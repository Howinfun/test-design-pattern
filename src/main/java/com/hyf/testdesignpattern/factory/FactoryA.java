package com.hyf.testdesignpattern.factory;

public class FactoryA implements IFactory{
    @Override
    public IProduct createProduct() {
        return new ProductA();
    }
}
