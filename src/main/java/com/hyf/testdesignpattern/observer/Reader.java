package com.hyf.testdesignpattern.observer;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Observable;
import java.util.Observer;

@Data
@AllArgsConstructor
public class Reader implements Observer {

    private String name;

    // 关注作者
    public void observerWriter(String name){
        WriterManager writerManager = WriterManager.getInstance();
        writerManager.getWriterByName(name).addObserver(this);
    }

    // 取消关注作者
    public void unObserverWriter(String name){
        WriterManager writerManager = WriterManager.getInstance();
        writerManager.getWriterByName(name).deleteObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Writer){
            System.out.println(this.name+"知道作者"+((Writer) o).getName()+"发布了新书<<"+((Writer) o).getLastNovel()+">>,立刻去看");
        }
    }
}
