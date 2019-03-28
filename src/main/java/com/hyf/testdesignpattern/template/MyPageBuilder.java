package com.hyf.testdesignpattern.template;

/**
 * @author Howinfun
 * @descm 子类中实现两个模板方法
 * @date 2019/3/28
 */
public class MyPageBuilder extends AbstractPageBuilder{
    @Override
    public void appendHead(StringBuffer sb) {
        sb.append("<head><title>你好</title></head>");
    }

    @Override
    public void appendBody(StringBuffer sb) {
        sb.append("<body><h1>你好,世界！</h1></body>");
    }
}
