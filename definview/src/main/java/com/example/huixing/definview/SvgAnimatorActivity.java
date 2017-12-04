package com.example.huixing.definview;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.media.Image;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.ImageView;

public class SvgAnimatorActivity extends AppCompatActivity {

    private ImageView imageView;
    static{
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svg_animator);

        imageView= (ImageView) findViewById(R.id.imageview);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((AnimatedVectorDrawable) imageView.getDrawable()).start();

            }
        });
    }
}
