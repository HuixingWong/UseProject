package com.example.utilsmoudle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RadioButton;

/**
 * Created by dogoodsoft-app on 2017/11/24.
 */

@SuppressLint("AppCompatCustomView")

public class MyRadioBtn extends RadioButton {

    public String group_name;

    public MyRadioBtn(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MyRadioBtn);
        group_name = a.getString(R.styleable.MyRadioBtn_group_name);
    }

    public MyRadioBtn(Context context) {
        super(context);
    }
}
