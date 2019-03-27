package com.hyf.testdesignpattern.observer;

import java.util.HashMap;
import java.util.Map;

public class WriterManager {
    private Map<String,Writer> writers = new HashMap<>();

    // 添加作者
    public void addWriter(Writer writer){
        writers.put(writer.getName(),writer);
    }

    // 根据姓名获取作者
    public Writer getWriterByName(String name){
        return writers.get(name);
    }

    // 单例
    private WriterManager(){}
    private static class WriterManagerInstance{
        private static WriterManager instance = new WriterManager();
    }
    public static WriterManager getInstance(){
        return WriterManagerInstance.instance;
    }
}
