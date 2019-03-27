package com.hyf.testdesignpattern.singleton;

public class SingleTon {

    // 私有化构造函数
    private SingleTon(){}

    public static SingleTon getInstance(){
        return SingleTonInstance.singleTon;
    }

    // 静态内部类
    static class SingleTonInstance{
        static SingleTon singleTon = new SingleTon();
    }
}
