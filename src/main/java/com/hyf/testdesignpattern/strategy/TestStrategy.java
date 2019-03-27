package com.hyf.testdesignpattern.strategy;

public class TestStrategy {
    public static void main(String[] args) {
        Consumer customer = new Consumer();
        customer.buy(500D);
        System.out.println("客户需要付钱：" + customer.callLastAmount());
        customer.buy(1200D);
        System.out.println("客户需要付钱：" + customer.callLastAmount());
        customer.buy(1200D);
        System.out.println("客户需要付钱：" + customer.callLastAmount());
        customer.buy(1200D);
        System.out.println("客户需要付钱：" + customer.callLastAmount());
    }
}
