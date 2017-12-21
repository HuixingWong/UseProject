package com.example.huixing.definview.slideRecycle;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Created by dogoodsoft-app on 2017/12/4.
 */

public class SwipItemLayout extends FrameLayout{


    private ViewDragHelper mDragHelper;
    private int mTouchSlop;
    private int mVelocity;

    private float mDownX;
    private float mDownY;
    private boolean mISDragged;
    private boolean mSwipeEnable = true;

    private int mCurrentmenu;
    private boolean mIsOpen;

    private LinkedHashMap<Integer,View> mMenus = new LinkedHashMap<>();

    public SwipItemLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SwipItemLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        mVelocity  = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
        mDragHelper = ViewDragHelper.create(this,new DragCallBack());

    }

    public SwipItemLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public SwipItemLayout(@NonNull Context context) {
        super(context);
    }



    public class DragCallBack extends ViewDragHelper.Callback{

        @Override
        public boolean tryCaptureView(View child, int pointerId) {
//            return child == getContentView() || mMenus.containsValue(child);

            return false;
        }
    }






}
