package com.hyf.testdesignpattern.template;

/**
 * @author Howinfun
 * @desc
 * @date 2019/3/28
 */
public class TestPageBuilder {
    public static void main(String[] args) {
        MyPageBuilder pageBuilder = new MyPageBuilder();
        System.out.println(pageBuilder.buildHtml());
    }
}
