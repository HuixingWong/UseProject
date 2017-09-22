package com.example.designpattern.susong;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by wangxiabing on 2017/9/22.
 */

public class Dynamicproxy  implements InvocationHandler{


    private Object object;


    public Dynamicproxy(Object obj){

        this.object = obj;

    }


    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {

        Object result = method.invoke(object,objects);
        return result;
    }
}
