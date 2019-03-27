package com.hyf.testdesignpattern.simpleFactory;

/**
 * 简单工厂模式不符合开闭原则，所以有了工厂模式
 */
public class Factory {
    public static IProduct createProduct(String name){
        if("a".equals(name.toLowerCase())){
            return new ProductA();
        }

        if("b".equals(name.toLowerCase())){
            return new ProductB();
        }
        return null;
    }
}
