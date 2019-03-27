package com.hyf.testdesignpattern.simpleFactory;

public class ProductB implements IProduct {
    @Override
    public void printName() {
        System.out.println("我是产品B");
    }
}
