package com.example.huixing.definview;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.widget.LinearLayout;

import com.example.huixing.definview.practice06.Practice06KeyframeLayout;

public class TestCircleBarActivity extends AppCompatActivity {

    private Practice06KeyframeLayout practice06KeyframeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_keyframe);

        practice06KeyframeLayout = (Practice06KeyframeLayout) findViewById(R.id.circle_layout);

    }
}
