package com.example.litemoudle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.litemoudle.modols.Tag;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tag tag = new Tag();
        tag.setId(0);
        tag.setName("london");
        tag.save();

    }
}
