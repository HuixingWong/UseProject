package com.example.huixing.definview.practice06;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.View;

import static com.example.huixing.definview.Utils.dpToPixel;


public class MyCircleView extends View {
    final float radius = dpToPixel(80);

    float progress = 0;
    RectF arcRectF = new RectF();

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public MyCircleView(Context context) {
        super(context);
    }

    public MyCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setTextSize(dpToPixel(40));
        paint.setTextAlign(Paint.Align.CENTER);
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
        invalidate();
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float centerX = getWidth() / 2;
        float centerY = getHeight() / 2;

        paint.setColor(Color.parseColor("#E91E63"));
        paint.setStyle(Paint.Style.STROKE);
        /**
         * 这一句是线头末尾的形状
         */
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(dpToPixel(15));
        arcRectF.set(centerX - radius, centerY - radius, centerX + radius, centerY + radius);
//        canvas.drawArc(arcRectF, 135, progress * 2.7f, false, paint);
        canvas.drawArc(arcRectF, 135, progress * 3.6f, false, paint);
//        canvas.drawCircle(centerX,centerY,progress * 3.6f,paint);

        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText((int) progress + "%", centerX, centerY - (paint.ascent() + paint.descent()) / 2, paint);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        Keyframe key1 = Keyframe.ofFloat(0,0);
        Keyframe key2 = Keyframe.ofFloat(0.3f,60);
        Keyframe key3 = Keyframe.ofFloat(0.5f,30);
        Keyframe key4 = Keyframe.ofFloat(0.6f,80);
        Keyframe key5 = Keyframe.ofFloat(0.7f,50);
        Keyframe key6 = Keyframe.ofFloat(0.8f,90);
        Keyframe key7 = Keyframe.ofFloat(0.9f,60);
        Keyframe key8 = Keyframe.ofFloat(1,100);
        if (progress != 0){
            key8 = Keyframe.ofFloat(1,progress);
        }




        PropertyValuesHolder holdr = PropertyValuesHolder.ofKeyframe
                ("progress",key1,key2,key3,key4,key5,key6,key7,key8);

        ObjectAnimator animator = ObjectAnimator.
                ofPropertyValuesHolder(this,holdr);

        animator.setDuration(3000);
        animator.setInterpolator(new FastOutSlowInInterpolator());
        animator.start();
    }


    private void startAnimation(){

    }
}
