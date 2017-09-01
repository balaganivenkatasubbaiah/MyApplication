package com.lyrebirdstudio.sticker;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;

public class MyDrawerLayout extends DrawerLayout {
    public MyDrawerLayout(Context context) {
        super(context);
    }

    public MyDrawerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyDrawerLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(widthMeasureSpec), 1073741824), MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(heightMeasureSpec), 1073741824));
    }
}
