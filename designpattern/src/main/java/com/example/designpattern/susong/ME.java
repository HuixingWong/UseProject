package com.example.designpattern.susong;

/**
 * Created by wangxiabing on 2017/9/22.
 */

public class ME implements ILawsuit
{
    @Override
    public void submit() {
        System.out.println("申请仲裁");
    }

    @Override
    public void burden() {
        System.out.println("提供证据");

    }

    @Override
    public void defend() {
        System.out.println("证据确凿");

    }

    @Override
    public void finish() {
        System.out.println("赢啦赢啦");

    }
}
