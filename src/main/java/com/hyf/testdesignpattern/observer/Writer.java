package com.hyf.testdesignpattern.observer;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Observable;

@Data
@AllArgsConstructor
public class Writer extends Observable {

    // 作者名
    private String name;
    // 最新的小说名
    private String lastNovel;

    public Writer(String name){
        this.name = name;
    }

    // 新小说
    public void addNovel(String name){
        this.lastNovel = name;
        System.out.println("作者"+this.name+"发布了新小说<<"+name+">>");
        // setChanged是必须的，更新被观察者的changed为true，不然是不能通知观察者的
        setChanged();
        // 通知观察者
        notifyObservers();
    }

}
