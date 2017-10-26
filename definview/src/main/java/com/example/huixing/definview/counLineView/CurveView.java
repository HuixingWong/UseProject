package com.example.huixing.definview.counLineView;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

/**
 * Created by huixing on 2017/10/24.
 */

public class CurveView extends View{

    List<Point> points;
    Paint paint;


    public CurveView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setPoints(List<Point> points){

        this.points = points;
        invalidate();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int size = points.size();

        if (null == points){
            return;
        }
        paint = new Paint();
        paint.setStrokeWidth(5);
        paint.setColor(Color.BLACK);

        Path path = new Path();

        for (int i=0;i<points.size();i++){

            Point point = points.get(i);

//            canvas.drawPoint(point.x,point.y,paint);
            if (i==0){
                path.moveTo(point.x,point.y);
            }else {
                path.lineTo(point.x,point.y);
            }


        }

        canvas.drawPath(path,paint);

    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
}
