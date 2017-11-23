package com.example.utilsmoudle;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class ChronometerTestActivity extends AppCompatActivity {

    private Chronometer chronometer;
    private Button start,pause,stop,other;
    private Long mRecordTime = 0l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chronometer_test);

        chronometer = (Chronometer) findViewById(R.id.cheronometor);
    }

    public void start(View view) {

        boolean activated = chronometer.isActivated();
//        boolean countDown = chronometer.isCountDown();

        if (mRecordTime == 0l){
            chronometer.setBase(SystemClock.elapsedRealtime());
        }else {
            chronometer.setBase(chronometer.getBase()+SystemClock.elapsedRealtime()-mRecordTime);
        }

        chronometer.start();
        boolean activated2 = chronometer.isActivated();
        boolean activated3 = chronometer.isActivated();
    }

    public void pause(View view) {


        chronometer.stop();
        boolean activated = chronometer.isActivated();
//        boolean countDown = chronometer.isCountDown();
        mRecordTime = SystemClock.elapsedRealtime();
    }

    public void stop(View view) {

        chronometer.stop();
        mRecordTime = 0l;
        chronometer.setBase(SystemClock.elapsedRealtime());
        boolean activated = chronometer.isActivated();
//        boolean countDown = chronometer.isCountDown();
    }

    public void other(View view) {


    }
}
