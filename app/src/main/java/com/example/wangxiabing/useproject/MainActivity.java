package com.example.wangxiabing.useproject;

import android.app.ActivityManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.chenjishi.slidedemo.base.Slide;


public class MainActivity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn= (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
//                Slide.getInstance().startActivity(MainActivity.this, intent);
                PasswordUtil util = new PasswordUtil();
                String s = util.generatePass(10, true, true, true, true);
                Toast.makeText(MainActivity.this, ""+s, Toast.LENGTH_SHORT).show();

            }
        });

    }
}
