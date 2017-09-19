package com.chenjishi.slidedemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.chenjishi.slidedemo.base.Slide;
import com.chenjishi.slidedemo.base.SlideActivity;

/**
 * Created by chenjishi on 14-3-17.
 */
public class DetailActivity extends SlideActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }

    public void onButtonClicked(View v) {
        Intent intent = new Intent(this, ImageActivity.class);
        Slide.getInstance().startActivity(this, intent);
    }
}
