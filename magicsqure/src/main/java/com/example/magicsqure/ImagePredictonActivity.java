package com.example.magicsqure;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.magicsqure.util.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

public class ImagePredictonActivity extends AppCompatActivity {

    private ViewPager mPager;

    private View view1,view2,view3;

    private List<View> viewList;
    private List<Fragment> fragmentList;
    private   int mScreenwidth;
    private   int mScreenheight;
    private int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_predicton);

        initview();
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


    }


    private int dealCount(float x,float y){

        int i = (int) (x / mScreenwidth);
        int j = (int) (y / mScreenheight);




        return 4*j+i+1;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        switch (ev.getAction()){

            case MotionEvent.ACTION_DOWN:

                float x = ev.getX();
                float y = ev.getY();

                int count = dealCount(x, y);
                Toast.makeText(this, ""+count, Toast.LENGTH_SHORT).show();
                break;

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
