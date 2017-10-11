package com.example.huixing.definview.practice06;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.View;

import com.example.huixing.definview.R;

import java.util.Calendar;

import static com.example.huixing.definview.Utils.dpToPixel;


public class MyCircleView extends View {
    float radius = dpToPixel(30);

    float progress = 0;
    RectF arcRectF = new RectF();
    private int mAscent;

    private int mCircleSize,mTextSize,mCircleColor,mStrokeWidth;


    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public MyCircleView(Context context) {
        super(context);
    }

    public MyCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CircleView);

        mCircleSize = array.getInteger(R.styleable.CircleView_circlesize,80);
        mTextSize = array.getInteger(R.styleable.CircleView_textsize,20);
        mCircleColor = array.getColor(R.styleable.CircleView_strokecolor,Color.RED);
        mStrokeWidth = array.getColor(R.styleable.CircleView_strokewidth,10);

        radius = mCircleSize;
        array.recycle();

    }

    {
        paint.setTextSize(dpToPixel(30));
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


        paint.setColor(Color.GRAY);
        /**
         * 这一句是线头末尾的形状
         */
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dpToPixel(10));
        arcRectF.set(centerX - radius, centerY - radius, centerX + radius, centerY + radius);
        canvas.drawArc(arcRectF, 135, 100 * 3.6f, false, paint);


        paint.setColor(mCircleColor);

        /**
         * 设置线条的宽度
         */
        paint.setStrokeWidth(dpToPixel(mStrokeWidth));
        arcRectF.set(centerX - radius, centerY - radius, centerX + radius, centerY + radius);
//        canvas.drawArc(arcRectF, 135, progress * 2.7f, false, paint);
        canvas.drawArc(arcRectF, 135, progress * 3.6f, false, paint);
//        canvas.drawCircle(centerX,centerY,progress * 3.6f,paint);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(dpToPixel(mTextSize));
        canvas.drawText((int) progress + "%", centerX, centerY - (paint.ascent() + paint.descent()) / 2, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        setMeasuredDimension(measureWidth(widthMeasureSpec),
                measureHeight(heightMeasureSpec));
    }

    private int measureHeight(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        mAscent = (int) paint.ascent();
        if (specMode == MeasureSpec.EXACTLY) {
            // We were told how big to be
            result = specSize;
        } else {
            // Measure the text (beware: ascent is a negative number)
            result = (int) (-mAscent + paint.descent()) + getPaddingTop()
                    + getPaddingBottom();
            if (specMode == MeasureSpec.AT_MOST) {
                // Respect AT_MOST value if that was what is called for by measureSpec
                result = Math.min(result, specSize);
            }
        }
        return result;
    }


    private int measureWidth(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            // We were told how big to be
            result = specSize;
        } else {
            // Measure the text
            result = getPaddingLeft() + getPaddingRight();
            if (specMode == MeasureSpec.AT_MOST) {
                // Respect AT_MOST value if that was what is called for by measureSpec
                result = Math.min(result, specSize);
            }
        }

        return result;
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
