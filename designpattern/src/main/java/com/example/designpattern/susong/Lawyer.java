package com.example.designpattern.susong;

/**
 * Created by wangxiabing on 2017/9/22.
 */

public class Lawyer implements ILawsuit{

    private  ILawsuit mIlsuit;

    public Lawyer(ILawsuit llsuit){

        mIlsuit = llsuit;
    }

    @Override
    public void submit() {
        mIlsuit.submit();
    }

    @Override
    public void burden() {

        mIlsuit.burden();
    }

    @Override
    public void defend() {

        mIlsuit.defend();
    }

    @Override
    public void finish() {

        mIlsuit.finish();
    }
}
