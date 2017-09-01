package com.lyrebirdstudio.gallerylib;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class GallerySquareImageView extends ImageView {
    public GallerySquareImageView(Context context) {
        super(context);
    }

    public GallerySquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GallerySquareImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(21)
    public GallerySquareImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        setMeasuredDimension(width, width);
    }
}
