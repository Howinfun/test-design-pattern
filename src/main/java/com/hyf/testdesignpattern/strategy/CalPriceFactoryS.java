package com.hyf.testdesignpattern.strategy;

import com.hyf.testdesignpattern.strategy.annotation.OnceValidRegion;
import com.hyf.testdesignpattern.strategy.annotation.TotalValidRegion;
import com.hyf.testdesignpattern.strategy.calprice.CalPrice;
import com.hyf.testdesignpattern.strategy.calprice.CalPriceProxy;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 策略工厂升级版，利用注解来导致if/else
 * 首先扫描出com.hyf.strategy.calprice中的类
 * 然后过滤出CalPrice的实现类，并放入列表中存放起来
 * 获取优惠策略的时候，遍历上面的列表，拿到这些类的@TotalValidRegion和@OnceValidRegion注解，然后判断总价的区间来返回优惠策略
 */
public class CalPriceFactoryS {

    private final static String CAL_PRICE_PACKAGE = "com.hyf.testdesignpattern.strategy.calprice";

    private ClassLoader classLoader = getClass().getClassLoader();//我们加载策略时的类加载器，我们任何类运行时信息必须来自该类加载器

    private List<Class <? extends CalPrice>> calPrices = new ArrayList<>(); // 存放遍历出来的所有策略

    public CalPrice handleCalPrice(Consumer consumer){
        // 符合标准的所有优惠策略（包括等级策略和单次消费策略）
        SortedMap<Integer,Class<? extends CalPrice>> clazzMap = new TreeMap<>();
        for (Class<? extends CalPrice> calPrice : calPrices) {
            Annotation anno = handleAnnotation(calPrice);
            Double totalAmount = consumer.getTotalAmount();
            if (anno instanceof TotalValidRegion){
                TotalValidRegion totalValidRegion = (TotalValidRegion) anno;
                if(totalAmount > totalValidRegion.value().min() && totalAmount < totalValidRegion.value().max()){
                    clazzMap.put(totalValidRegion.value().order(),calPrice);
                }
            }
            if (anno instanceof OnceValidRegion){
                OnceValidRegion onceValidRegion = (OnceValidRegion) anno;
                if(totalAmount > onceValidRegion.value().min() && totalAmount < onceValidRegion.value().max()){
                    clazzMap.put(onceValidRegion.value().order(),calPrice);
                }
            }

        }
        return CalPriceProxy.getProxy(clazzMap);
    }

    //
    private Annotation handleAnnotation(Class<? extends CalPrice> clazz){
        Annotation[] annotations = clazz.getAnnotations();
        if(annotations == null || annotations.length == 0){
            return  null;
        }
        for (Annotation annotation : annotations) {
            if(annotation instanceof TotalValidRegion || annotation instanceof OnceValidRegion){
                return annotation;
            }
        }
        return null;
    }

    // 扫描
    private void init(){
        File[] files = getResources();
        try {
            Class<CalPrice> calPriceClass = (Class<CalPrice>) classLoader.loadClass(CalPrice.class.getName());
            for (File file : files) {
                Class<?> clazz = classLoader.loadClass(CAL_PRICE_PACKAGE+"."+file.getName().replace(".class",""));
                // 判断clazz是否是CalPrice的实现类，而且不是CalPrice本人
                if(CalPrice.class.isAssignableFrom(clazz) && clazz != calPriceClass){
                    calPrices.add((Class<? extends CalPrice>) clazz);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    //获取扫描的包下面所有的class文件
    private File[] getResources(){
        try {
            // 获取包下的所有文件
            File file = new File(classLoader.getResource(CAL_PRICE_PACKAGE.replace(".","/")).toURI());
            // 对文件进行过滤，只留下后缀名为class的文件
            return file.listFiles(pathName -> { return pathName.getName().endsWith(".class");});
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    private CalPriceFactoryS(){
        init();
    }

    private static class CalPriceFactorySInstance{
        static CalPriceFactoryS instance = new CalPriceFactoryS();
    }

    public static CalPriceFactoryS getInstance(){
        return CalPriceFactorySInstance.instance;
    }
}
