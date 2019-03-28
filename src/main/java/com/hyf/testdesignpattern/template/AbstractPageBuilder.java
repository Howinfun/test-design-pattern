package com.hyf.testdesignpattern.template;

/**
 * @author Howinfun
 * @desc 抽象类,规定子类实现网页输入的步骤，防止出现各种各样的网页模板
 * @date 2019/3/28
 */
public abstract class AbstractPageBuilder implements PageBuilder{

    private StringBuffer sb = new StringBuffer();

    @Override
    public String buildHtml() {
        //首先加入doctype,因为都是html页面,所以我们父类不需要推迟给子类实现,直接在父类实现
        sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
        //页面下面就是成对的一个HTML标签，我们也在父类加入,不需要给子类实现
        sb.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
        //下面就应该是head标签里的内容了,这个我们父类做不了主了,推迟到子类实现,所以我们定义一个抽象方法,让子类必须实现
        appendHead(sb);
        //下面是body的内容了，我们父类依然无法做主，仍然推迟到子类实现
        appendBody(sb);
        //html标签的关闭
        sb.append("</html>");
        return sb.toString();
    }

    /**
     * 第一个模板方法：添加头部
     * @param sb
     */
    public abstract void appendHead(StringBuffer sb);

    /**
     * 第二个模板方法：添加身体
     * @param sb
     */
    public abstract void appendBody(StringBuffer sb);
}
