package com.example.designpattern.delegate.buyphone;

/**
 * Created by wangxiabing on 2017/9/22.
 */

public class MyBuyPone {

    public static void main(String ... a){

        buyiphone buyiphone = new buyiphone();
        huangniu huangniu1 = new huangniu(buyiphone);


        huangniu1.buyAphone();

    }
}
