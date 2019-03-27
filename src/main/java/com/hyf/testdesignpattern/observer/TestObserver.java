package com.hyf.testdesignpattern.observer;

public class TestObserver {
    public static void main(String[] args) {
        Reader reader1 = new Reader("王全蛋");
        Reader reader2 = new Reader("彭于晏");
        Reader reader3 = new Reader("张靓颖");

        Writer writer1 = new Writer("辰东");
        Writer writer2 = new Writer("天产土豆");

        WriterManager writerManager = WriterManager.getInstance();
        writerManager.addWriter(writer1);
        writerManager.addWriter(writer2);

        reader1.observerWriter("辰东");
        reader1.observerWriter("天产土豆");
        reader2.observerWriter("天产土豆");
        reader3.observerWriter("天产土豆");

        writer1.addNovel("元尊");
        writer2.addNovel("斗罗大陆");

        reader1.unObserverWriter("辰东");

        writer1.addNovel("长生界");
        writer2.addNovel("终极斗罗");


    }
}
