package com.chenjishi.slidedemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.chenjishi.slidedemo.base.SlideActivity;

/**
 * Created by chenjishi on 15/10/13.
 */
public class ImageActivity extends SlideActivity {

    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        iv = (ImageView) findViewById(R.id.iv);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ImageActivity.this,MySlideAc.class);
                startActivity(intent);
            }
        });
    }
}
