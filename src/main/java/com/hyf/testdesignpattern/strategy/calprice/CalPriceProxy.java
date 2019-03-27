package com.hyf.testdesignpattern.strategy.calprice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.SortedMap;

/**
 * 优惠策略的代理类，因为可能等级优惠策略和单次消费优惠策略都有满足的，那么就有两个策略要计算价格了，
 * 用代理类来搞定，不要写重复代码
 */
public class CalPriceProxy implements InvocationHandler {

    private  SortedMap<Integer,Class<? extends  CalPrice>> clazzMap;

    private CalPriceProxy(SortedMap<Integer,Class<? extends  CalPrice>> clazzMap){
        this.clazzMap = clazzMap;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Double result = 0d;
        if("calPrice".equals(method.getName())){
            for (Class<? extends CalPrice> value : clazzMap.values()) {
                if(result == 0d){
                    result = (Double) method.invoke(value.newInstance(),args);
                }else{
                    result = (Double) method.invoke(value.newInstance(),result);
                }
            }
            return result;
        }
        return null;
    }

    public static CalPrice getProxy(SortedMap<Integer,Class<? extends  CalPrice>> clazzMap){
        return (CalPrice) Proxy.newProxyInstance(CalPrice.class.getClassLoader(),new Class<?>[]{CalPrice.class}, new CalPriceProxy(clazzMap));
    }

}
