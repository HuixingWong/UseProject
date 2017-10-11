package com.example.huixing.definview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.huixing.definview.practice06.MyCircleView;

public class ToCircleActivity extends AppCompatActivity {


    private MyCircleView myCircleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_circle);


        myCircleView = (MyCircleView) findViewById(R.id.mycircle);
        myCircleView.setProgress(60);


    }
}
