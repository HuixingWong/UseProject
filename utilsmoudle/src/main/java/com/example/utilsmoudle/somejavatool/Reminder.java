package com.example.utilsmoudle.somejavatool;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by   huixing   on 2017/10/9.
 */

public class Reminder {

    Timer timer;
    public  Reminder(int second){

        timer = new Timer();

        timer.schedule(new MyTimertask(),0,second*1000);


    }

    class MyTimertask extends TimerTask{

        @Override
        public void run() {
            System.out.println("this is my timertask");
//            timer.cancel();
        }
    }

    public static void main(String args []){


        System.out.println("start...................");
        new Reminder(5);
        System.out.println("end...................");

    }

}
