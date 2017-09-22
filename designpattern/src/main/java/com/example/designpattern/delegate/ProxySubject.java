package com.example.designpattern.delegate;

/**
 * Created by wangxiabing on 2017/9/22.
 */

public class ProxySubject extends Subject{

    private RealSubject realSubject;

    public ProxySubject(RealSubject realSubject){

        this.realSubject = realSubject;

    }

    @Override
    public void visit() {

        realSubject.visit();

    }
}
