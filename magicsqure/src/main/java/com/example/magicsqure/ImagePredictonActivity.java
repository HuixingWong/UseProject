package com.example.magicsqure;

import android.Manifest;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.CountDownTimer;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.magicsqure.util.MyBitmapUtil;
import com.example.magicsqure.util.PictureSaveUtil;
import com.example.magicsqure.util.ScreenUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class ImagePredictonActivity extends AppCompatActivity {

    private ViewPager mPager;

    private View view1,view2,view3;

    private List<View> viewList;
    private List<Fragment> fragmentList;
    private   int mScreenwidth;
    private   int mScreenheight;
    private int mCount = 0;
    private final  int TUICHU = 1;

    private android.os.Handler mHandler = new android.os.Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){

                case TUICHU:
                    finish();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_predicton);
        initview();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){

            case 1:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(this, "获得权限", Toast.LENGTH_SHORT).show();

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(this, "无权限，即将推出", Toast.LENGTH_SHORT).show();
                }
                return;

        }
    }

    private void initview(){

        mScreenheight = ScreenUtils.getScreenHeight(this)/6;
        mScreenwidth = ScreenUtils.getScreenWidth(this)/4;

        mPager = (ViewPager) findViewById(R.id.main_pager);
        LayoutInflater inflater = getLayoutInflater();

        view1 = inflater.inflate(R.layout.pager1,null);
        view2 = inflater.inflate(R.layout.pager2,null);
        view3 = inflater.inflate(R.layout.pager3,null);

        viewList = new ArrayList<>();
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);

//        FragmentPagerAdapter pagerAdapter = new FragmentPagerAdapter() {
//            @Override
//            public Fragment getItem(int position) {
//                return null;
//            }
//
//            @Override
//            public int getCount() {
//                return 0;
//            }
//        };

        PagerAdapter adapter = new PagerAdapter() {
            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                // TODO Auto-generated method stub
                return arg0 == arg1;
            }

            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return viewList.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                // TODO Auto-generated method stub
                container.removeView(viewList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                // TODO Auto-generated method stub
                container.addView(viewList.get(position));


                return viewList.get(position);
            }
        };


        mPager.setAdapter(adapter);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {


                if (position == 2){

//                    Toast.makeText(ImagePredictonActivity.this, ""+position, Toast.LENGTH_SHORT).show();

//                    FileInputStream fis = null;
//                    try {
//                        fis = new FileInputStream("/sdcard/test.png");
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                    }
//                    Bitmap bitmap  = BitmapFactory.decodeStream(fis);

                    Bitmap bitmap = MyBitmapUtil.readBitMap(ImagePredictonActivity.this,R.mipmap.ic_launcher);

                    boolean b = PictureSaveUtil.saveImageToGallery(ImagePredictonActivity.this, bitmap);

                    Toast.makeText(ImagePredictonActivity.this, ""+b, Toast.LENGTH_SHORT).show();

                    mHandler.sendEmptyMessageDelayed(TUICHU, 4000);//启动handler，间隔4 second start

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    private int dealCount(float x,float y){

        int i = (int) (x / mScreenwidth);
        int j = (int) (y / mScreenheight);


        return 4*j+i+1;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {


        if (ContextCompat.checkSelfPermission(MyApp.fetchcontext(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(ImagePredictonActivity.this,
                    new String[]{Manifest.permission.READ_CONTACTS},1);

        }else{
            //
        }

        float x=0,y = 0;

        switch (ev.getAction()){

            case MotionEvent.ACTION_DOWN:

                 x = ev.getX();
                 y = ev.getY();
                int count = dealCount(x, y);
                Toast.makeText(this, ""+count, Toast.LENGTH_SHORT).show();
                break;

            case MotionEvent.ACTION_UP:

            default:
                break;

        }



        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
