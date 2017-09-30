package com.example.magicsqure;

import android.app.Application;
import android.content.Context;

/**
 * Created by   huixing   on 2017/9/30.
 */

public class MyApp extends Application{

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
    }
    public static Context fetchcontext(){
        return context;
    }
}
