package com.example.kuo.choosepickertest;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by Kuo on 2015/10/20.
 */
public class ChooseGridView extends GridView {

    public ChooseGridView(Context context) {
        super(context);
    }

    public ChooseGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int heightSpec;

        if (getLayoutParams().height == LayoutParams.WRAP_CONTENT) {
            heightSpec = MeasureSpec.makeMeasureSpec(MEASURED_SIZE_MASK, MeasureSpec.AT_MOST);
        } else {
            heightSpec = heightMeasureSpec;
        }

        super.onMeasure(widthMeasureSpec, heightSpec);
    }
}
