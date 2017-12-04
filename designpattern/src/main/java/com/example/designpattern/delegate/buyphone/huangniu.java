package com.example.designpattern.delegate.buyphone;

/**
 * Created by wangxiabing on 2017/9/22.
 */

public class huangniu extends buyphone{

    private  buyiphone buyiphone1;


    public huangniu(buyiphone buyiphone1){

        this.buyiphone1 = buyiphone1;

    }


    @Override
    public void buyAphone() {

        buyiphone1.buyAphone();

    }
}
