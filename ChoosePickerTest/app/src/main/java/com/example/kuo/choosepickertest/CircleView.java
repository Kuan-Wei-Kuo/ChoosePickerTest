package com.example.kuo.choosepickertest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Kuo on 2015/11/5.
 */
public class CircleView extends View {

    private Paint paint;
    private boolean isFocus = false;
    private int focusColor = Color.parseColor("#424242");
    private int unfocusColor = Color.parseColor("#FAFAFA");

    public CircleView(Context context) {
        super(context);
        initPaint();
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        setPaintColor();
        canvas.drawCircle(getWidth()/2, getHeight()/2, getWidth()/4, paint);

    }

    private void initPaint() {

        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

    }

    private void setPaintColor() {
        if(isFocus) {
            paint.setColor(focusColor);
        } else {
            paint.setColor(unfocusColor);
        }
    }

    public void setFocusColor(int focusColor) {
        this.focusColor = focusColor;
    }

    public void setUnfocusColor(int unfocusColor) {
        this.unfocusColor = unfocusColor;
    }

    public void isFocus(boolean i) {
        isFocus = i;
        invalidate();
    }
}
