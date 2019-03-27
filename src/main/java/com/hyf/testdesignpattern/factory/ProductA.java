package com.hyf.testdesignpattern.factory;

public class ProductA implements IProduct {
    @Override
    public void printName() {
        System.out.println("我是产品A");
    }
}
