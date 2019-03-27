package com.hyf.testdesignpattern.proxy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Data
@AllArgsConstructor
public class DynamicProxy implements InvocationHandler {
    // 被代理类
    private Object source;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("printName")){
            System.out.println("产品自我介绍前加点料");
            method.invoke(source,args);
            System.out.println("产品自我介绍后加点料");
        }else{
            return method.invoke(source,args);
        }
        return null;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(getClass().getClassLoader(), source.getClass().getInterfaces(), this);
    }
}
