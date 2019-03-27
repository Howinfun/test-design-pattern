package com.hyf.testdesignpattern.singleton;

public class DoubleCheck {
    // 静态属性
    private static DoubleCheck doubleCheck;
    // 私有化构造函数
    private DoubleCheck(){}
    // 静态方法获实例
    public static DoubleCheck getDoubleCheck(){
        if(doubleCheck == null){
            synchronized (DoubleCheck.class){
                if(doubleCheck == null){
                    doubleCheck = new DoubleCheck();
                }
            }
        }
        return doubleCheck;
    }
}
