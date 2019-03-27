package com.hyf.testdesignpattern.factory;

public class TestFactory {
    public static void main(String[] args) {
        IFactory factory = new FactoryA();
        IProduct product = factory.createProduct();
        product.printName();

        factory = new FactoryB();
        product = factory.createProduct();
        product.printName();
    }
}
