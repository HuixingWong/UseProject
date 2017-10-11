package com.example.huixing.definview.practice06;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.huixing.definview.R;

import java.util.List;


public class Practice06KeyframeLayout extends RelativeLayout {
    Practice06KeyframeView view;
    Button animateBt;
    private List<Integer> mProgressList;

    private int progress;

    public Practice06KeyframeLayout(Context context) {
        super(context);
    }

    public Practice06KeyframeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CircleView);
        progress = array.getInteger(0, 0);
    }

    public Practice06KeyframeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        view = (Practice06KeyframeView) findViewById(R.id.objectAnimatorView);
        animateBt = (Button) findViewById(R.id.animateBt);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // 使用 Keyframe.ofFloat() 来为 view 的 progress 属性创建关键帧
                // 初始帧：progress 为 0
                // 时间进行到一般：progress 为 100
                // 结束帧：progress 回落到 80
                // 使用 PropertyValuesHolder.ofKeyframe() 来把关键帧拼接成一个完整的属性动画方案
                // 使用 ObjectAnimator.ofPropertyValuesHolder() 来创建动画
//                Toast.makeText(getContext(), "就不动啦啦啦啦", Toast.LENGTH_SHORT).show();

                Keyframe key1 = Keyframe.ofFloat(0,0);
                Keyframe key2 = Keyframe.ofFloat(0.3f,60);
                Keyframe key3 = Keyframe.ofFloat(0.5f,30);
                Keyframe key4 = Keyframe.ofFloat(0.6f,80);
                Keyframe key5 = Keyframe.ofFloat(0.7f,50);
                Keyframe key6 = Keyframe.ofFloat(0.8f,90);
                Keyframe key7 = Keyframe.ofFloat(0.9f,60);
                Keyframe key8 = Keyframe.ofFloat(1,100);

                PropertyValuesHolder holdr = PropertyValuesHolder.ofKeyframe
                        ("progress",key1,key2,key3,key4,key5,key6,key7,key8);

                ObjectAnimator animator = ObjectAnimator.
                        ofPropertyValuesHolder(view,holdr);

                animator.setDuration(3000);
                animator.setInterpolator(new FastOutSlowInInterpolator());
                animator.start();

            }
        });
    }
}
