package com.hyf.testdesignpattern.adapter.ClassAdapter;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Howinfun
 * @desc 类适配器：假如现在需要HashMap也有观察者的功能，但是HashMap是在成熟的继承体系中的，我们不可能对HashMap进行修改
 *              这时候我们需要考虑的就是适配器了，给HashMap适配一下。我们新建一个类作为适配器，继承HashMap，然后实现Observer接口，重写update方法
 *              这时候，我们既拥有HashMap的功能，也拥有了观察者Observer的监听功能。
 * @date 2019/3/28
 */
public class HashMapObserver extends HashMap implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("重新update方法");
    }
}
