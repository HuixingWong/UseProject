package com.example.designpattern.susong;

import java.lang.reflect.Proxy;

/**
 * Created by wangxiabing on 2017/9/22.
 */

public class Client {

    public static void main(String ... a){

        ILawsuit me = new ME();

        Dynamicproxy dynamicproxy = new Dynamicproxy(me);

        ClassLoader loader = me.getClass().getClassLoader();


        ILawsuit lawyer = (ILawsuit) Proxy.newProxyInstance(loader,new Class[]{ILawsuit.class},dynamicproxy);




        lawyer.submit();
        lawyer.burden();
        lawyer.defend();
        lawyer.finish();

    }
}
