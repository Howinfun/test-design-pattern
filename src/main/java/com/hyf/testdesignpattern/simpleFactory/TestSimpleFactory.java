package com.hyf.testdesignpattern.simpleFactory;

public class TestSimpleFactory {
    public static void main(String[] args) {
        IProduct product = Factory.createProduct("A");
        product.printName();
        product = Factory.createProduct("B");
        product.printName();
    }
}
