package com.hyf.testdesignpattern.factory;

public class FactoryB implements IFactory{
    @Override
    public IProduct createProduct() {
        return new ProductB();
    }
}
