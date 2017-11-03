package com.example.litemoudle;

import android.app.Application;

import org.litepal.LitePal;

/**
 * Created by dogoodsoft-app on 2017/11/3.
 */

public class NyApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(this);
    }

}
