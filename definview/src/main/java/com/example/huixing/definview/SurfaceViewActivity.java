package com.example.huixing.definview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SurfaceViewActivity extends AppCompatActivity {

    private SurfaceViewL surfaceViewL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_view);
        surfaceViewL = (SurfaceViewL) findViewById(R.id.ssl);
    }

    @Override
    protected void onDestroy() {
        surfaceViewL.setDrawing(false);
        super.onDestroy();
    }
}
