package com.example.huixing.definview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TomatoView clockView;
    TextView textView;
    Button button;
    Button buttonToLinePoint;
    Button mTosurfacebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clockView = (TomatoView) findViewById(R.id.clockView);
        textView = (TextView) findViewById(R.id.tv_start);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clockView.start();
                startActivity(new Intent(MainActivity.this,TestCircleBarActivity.class));
            }
        });

        button = (Button) findViewById(R.id.to_circle_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ToCircleActivity.class));
            }
        });

        buttonToLinePoint = (Button) findViewById(R.id.to_point_line);

        buttonToLinePoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,PointLineActivity.class));
            }
        });

        mTosurfacebtn = (Button) findViewById(R.id.tosurface);
        mTosurfacebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SurfaceViewActivity.class));
            }
        });
    }
}
