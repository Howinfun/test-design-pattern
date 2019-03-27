package com.hyf.testdesignpattern.proxy;

import com.hyf.testdesignpattern.factory.IProduct;
import com.hyf.testdesignpattern.factory.ProductA;

public class TestDynamicProxy {
    public static void main(String[] args) {
        DynamicProxy dynamicProxy  = new DynamicProxy(new ProductA());
        IProduct productA = (IProduct) dynamicProxy.getProxy();
        productA.printName();
    }
}
