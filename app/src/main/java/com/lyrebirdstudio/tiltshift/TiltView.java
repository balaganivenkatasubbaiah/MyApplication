package com.lyrebirdstudio.tiltshift;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class TiltView extends View {
    private static final String TAG = TiltView.class.getSimpleName();
    Bitmap bitmap;
    Bitmap bitmapBlur;
    int f880h;
    Paint paint = new Paint(1);
    float scale = 1.0f;
    float screenHeight;
    float screenWidth;
    TiltHelper tiltHelper;
    int viewHeight;
    int viewWidth;
    int f881w;

    class C06691 implements Runnable {
        C06691() {
        }

        public void run() {
            TiltView.this.tiltHelper.startAnimator();
        }
    }

    public TiltView(Context context, Bitmap btm, Bitmap blur, int scrW, int scrH, TiltContext tc) {
        super(context);
        if (context != null && btm != null) {
            this.bitmap = btm;
            this.bitmapBlur = blur;
            this.f881w = this.bitmap.getWidth();
            this.f880h = this.bitmap.getHeight();
            this.tiltHelper = new TiltHelper(this, this.bitmapBlur, tc, this.f881w, this.f880h);
            this.screenWidth = (float) scrW;
            this.screenHeight = (float) scrH;
            this.scale = Math.min(this.screenWidth / ((float) this.f881w), this.screenHeight / ((float) this.f880h));
            this.viewWidth = (int) (this.scale * ((float) this.f881w));
            this.viewHeight = (int) (this.scale * ((float) this.f880h));
            this.paint.setFilterBitmap(true);
            post(new C06691());
        }
    }

    public void onDraw(Canvas canvas) {
        canvas.scale(this.scale, this.scale);
        canvas.drawBitmap(this.bitmap, 0.0f, 0.0f, this.paint);
        this.tiltHelper.drawTiltShift(canvas, this.bitmapBlur, this.f881w, this.f880h);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int myWidth = (int) (((double) MeasureSpec.getSize(heightMeasureSpec)) * 0.5d);
        super.onMeasure(MeasureSpec.makeMeasureSpec(this.viewWidth, 1073741824), MeasureSpec.makeMeasureSpec(this.viewHeight, 1073741824));
    }

    public boolean onTouchEvent(MotionEvent event) {
        return this.tiltHelper.onTouchEvent(event);
    }
}
