package com.example.utilsmoudle;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.utilsmoudle.TouchUtils.TestCallback;

public class MainActivity extends AppCompatActivity implements TestCallback.OnFragmentInteractionListener{

    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);


        // 步骤1：获取FragmentManager
        FragmentManager fragmentManager = getFragmentManager();

        // 步骤2：获取FragmentTransaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        // 步骤3：创建需要添加的Fragment
        TestCallback testCallback = TestCallback.newInstance("123", "456");
        // 步骤4：动态添加fragment
        // 即将创建的fragment添加到Activity布局文件中定义的占位符中（FrameLayout）
        fragmentTransaction.add(R.id.container_a_c,testCallback);
        fragmentTransaction.commit();


    }

    @Override
    public void onFragmentInteraction(String uri) {

        tv.setText(uri);
    }
}
