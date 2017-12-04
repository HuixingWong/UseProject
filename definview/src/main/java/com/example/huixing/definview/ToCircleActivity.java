package com.example.huixing.definview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.huixing.definview.practice06.MyCircleView;

import static com.example.huixing.definview.R.id.outer;

public class ToCircleActivity extends AppCompatActivity {


    private MyCircleView myCircleView;
    private MyCircleView myCircleView2;
    private MyCircleView mMoreInner;
    private MyCircleView minner;
    private MyCircleView mOtter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_circle);


        myCircleView = (MyCircleView) findViewById(R.id.mycircle);
        myCircleView2 = (MyCircleView) findViewById(R.id.mycircle2);
        mMoreInner = (MyCircleView) findViewById(R.id.more_inner);
        minner = (MyCircleView) findViewById(R.id.inner);
        mOtter = (MyCircleView) findViewById(outer);
        myCircleView.setProgress(60);
        myCircleView2.setProgress(90);
        mMoreInner.setProgress(50);
        minner.setProgress(70);
        mOtter.setProgress(90);


    }
}
