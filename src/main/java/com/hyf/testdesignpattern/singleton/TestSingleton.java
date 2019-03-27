package com.hyf.testdesignpattern.singleton;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestSingleton {
    public static void main(String[] args) throws InterruptedException {
        // 并发安全的set，保存实例的toString，会去重
        Set<String> set = Collections.synchronizedSet(new HashSet<String>());
        CyclicBarrier cyclicBarrier = new CyclicBarrier(100);
        for (int i = 0;i<100;i++){
            new Thread(()->{
                try {
                    cyclicBarrier.await();
                    /*DoubleCheck doubleCheck = DoubleCheck.getDoubleCheck();
                    set.add(doubleCheck.toString());*/
                    SingleTon singleTon  = SingleTon.getInstance();
                    set.add(singleTon.toString());
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }).start();
        }
        Thread.sleep(4000);
        set.forEach(str->{
            System.out.println(str);
        });
    }
}
