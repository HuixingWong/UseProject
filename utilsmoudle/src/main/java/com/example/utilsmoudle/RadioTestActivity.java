package com.example.utilsmoudle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class RadioTestActivity extends AppCompatActivity {

    private MyRadioBtn myRadioBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_test);

        myRadioBtn = (MyRadioBtn) findViewById(R.id.radio1);

        Toast.makeText(this, ""+myRadioBtn.group_name, Toast.LENGTH_SHORT).show();

    }
}
