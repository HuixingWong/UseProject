package com.example.designpattern.delegate;

/**
 * Created by wangxiabing on 2017/9/22.
 */

public class Client {

    public static  void main(String ... a){
        RealSubject realSubject = new RealSubject();


        ProxySubject proxySubject = new ProxySubject(realSubject);

        proxySubject.visit();
    }
}
