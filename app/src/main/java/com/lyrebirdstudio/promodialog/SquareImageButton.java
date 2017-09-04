package com.lyrebirdstudio.promodialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageButton;

public class SquareImageButton extends ImageButton {
    int screenHeight;
    int screenWidth;

    public SquareImageButton(Context context) {
        super(context);
        getDimens(context);
    }

    public SquareImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        getDimens(context);
    }

    @SuppressLint({"NewApi"})
    void getDimens(Context context) {
        Display display = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (VERSION.SDK_INT < 13) {
            this.screenWidth = display.getWidth();
            this.screenHeight = display.getHeight();
            return;
        }
        Point size = new Point();
        display.getSize(size);
        this.screenWidth = size.x;
        this.screenHeight = size.y;
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int size;
        if (width > height) {
            size = height;
        } else {
            size = width;
        }
        if (this.screenHeight > 0 && this.screenWidth > 0) {
            float scale = ((float) Math.min(this.screenWidth, this.screenHeight)) / ((float) Math.max(this.screenHeight, this.screenWidth));
            if (scale >= 0.5625f + 0.001f) {
                if (scale < 0.6f + 0.001f) {
                }
            }
        }
        int finalSize = Math.round(((float) this.screenWidth) / 7.0f);
        setMeasuredDimension(finalSize, finalSize);
    }
}
