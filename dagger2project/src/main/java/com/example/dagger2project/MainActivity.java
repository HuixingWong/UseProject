package com.example.dagger2project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    public Province province;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //in Android Studio, select Build > Rebuild Project
        DaggerMainActivityComponent.create().inject(this);
        Log.d("hcy", "onCreate: " + province.showAddress());
    }
}
