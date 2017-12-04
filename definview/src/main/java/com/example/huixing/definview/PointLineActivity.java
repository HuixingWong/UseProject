package com.example.huixing.definview;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.example.huixing.definview.counLineView.CurveView;

import java.util.ArrayList;
import java.util.List;

public class PointLineActivity extends AppCompatActivity {


    private CurveView curveView;

    private List<Point> points;

    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_line);
        initDatas();
        curveView = (CurveView) findViewById(R.id.cur_view);
        curveView.setPoints(points);

    }

    private void initDatas(){

        points = new ArrayList<>();
        for (int i=0;i<10;i++){

            Point point = new Point();
            point.set(i*10,i*5);

            points.add(i,point);
        }

        button = (Button) findViewById(R.id.btn_setprogress);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curveView.setPoints(points);
            }
        });

    }
}
