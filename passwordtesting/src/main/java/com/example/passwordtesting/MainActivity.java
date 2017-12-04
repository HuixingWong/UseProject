package com.example.passwordtesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.pass);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass = editText.getText().toString();
                String s = checkPassword(pass);
                Toast.makeText(MainActivity.this, ""+s, Toast.LENGTH_SHORT).show();
            }
        });
    }


    /**
     * 密码强度
     *
     * @return Z = 数字  S = 字母 T = 特殊字符
     */
    public String checkPassword(String passwordStr) {
        String regexZ = "\\d*";
        String regexS = "[a-zA-Z]+";
        String regexZS = "\\w*";

        if (passwordStr.matches(regexZ)) {
            return "弱";
        }

        if (passwordStr.matches(regexS)) {
            return "中";

        }

        if (passwordStr.matches(regexZS)) {
            return "强";
        }
        return null;

    }

}
