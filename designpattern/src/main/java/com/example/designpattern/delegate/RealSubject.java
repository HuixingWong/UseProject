package com.example.designpattern.delegate;

/**
 * Created by wangxiabing on 2017/9/22.
 */

public class RealSubject extends Subject{
    @Override
    public void visit() {

        System.out.println("this is a Real Subject");

    }
}
