package com.example.androidkotlin

import android.content.Context
import android.widget.Toast

/**
 * Created by wangxiabing on 2017/7/11.
 */
fun Context.toast123(){
    Toast.makeText(this,"123",1).show();
}