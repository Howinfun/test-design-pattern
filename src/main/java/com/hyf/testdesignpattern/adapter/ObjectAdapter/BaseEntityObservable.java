package com.hyf.testdesignpattern.adapter.ObjectAdapter;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Howinfun
 * @desc 用户Entity需要拥有被观察者的功能，但是我们的每个Entity都必须继承BaseEntity，而且Java是单继承的，已经没位置继承Observable了
 *          所以这时候我们只能用适配器模式了，对象设配器。而且以后可能很多其他Entity都需要拥有观察者模式呢，我们不可能给每个Entity都弄一个
 *          对象适配器，那么我们就可以搞一下可观察的实体基类，以后那些Entity需要拥有被观察者功能的，直接继承可观察的实体基类即可。
 * @date 2019/3/28
 */
public class BaseEntityObservable extends BaseEntity{
    private Observable observable = new Observable();
    public synchronized void addObserver(Observer o) {
        observable.addObserver(o);
    }

    public synchronized void deleteObserver(Observer o) {
        observable.deleteObserver(o);
    }

    public void notifyObservers() {
        observable.notifyObservers();
    }

    public void notifyObservers(Object arg) {
        observable.notifyObservers(arg);
    }

    public synchronized void deleteObservers() {
        observable.deleteObservers();
    }

    /*protected synchronized void setChanged() {
        observable.setChanged();
    }

    protected synchronized void clearChanged() {
        observable.clearChanged();
    }*/

    public synchronized boolean hasChanged() {
        return observable.hasChanged();
    }

    public synchronized int countObservers() {
        return observable.countObservers();
    }
}
