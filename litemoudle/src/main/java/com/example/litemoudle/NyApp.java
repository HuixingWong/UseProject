package com.example.litemoudle;

import android.app.Application;
import android.content.Context;

import org.litepal.LitePal;

/**
 * Created by dogoodsoft-app on 2017/11/3.
 */

public class NyApp extends Application{

    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(this);

        context = getApplicationContext();
    }


    public static   Context  getContext(){
        return context;
    }

}
