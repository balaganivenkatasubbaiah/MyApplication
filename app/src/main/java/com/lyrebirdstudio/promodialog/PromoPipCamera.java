package com.lyrebirdstudio.promodialog;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.net.Uri;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View;

import com.lyrebirdstudio.R;
import com.lyrebirdstudio.lyrebirdlibrary.BlurBuilderNormal;

public class PromoPipCamera extends View {
    private static final int INVALID_POINTER_ID = 1;
    private static int PROMO_INDEX = 0;
    private static final String TAG = "PromoPipCamera";
    static final String urlDefault = "market://details?id=com.lyrebirdstudio.pipcamera";
    Bitmap bitmapBlur;
    Bitmap bitmapMask;
    RectF bitmapRect = new RectF();
    Bitmap bitmapShade;
    Bitmap bitmapSource;
    int currentIndex = 0;
    boolean isMarketCalled = false;
    private int mActivePointerId = 1;
    float mLastTouchX;
    float mLastTouchY;
    String marketUrl = urlDefault;
    RectF maskRect = new RectF();
    Matrix matrixBitmap;
    Matrix matrixBlur;
    Matrix matrixBubble;
    Matrix matrixMask;
    float minScale = 1.0f;
    PromoPipEntity[] myDataset;
    Paint paint = new Paint(3);
    Paint paintXfermode = new Paint(3);
    float[] pts = new float[2];
    RectF f873r = new RectF();
    float screenWidth;
    Matrix textMatrix = new Matrix();
    int touchCountForMarket = 0;
    boolean touchOutSide = true;
    float[] values = new float[9];

    private class ScaleListener extends SimpleOnScaleGestureListener {
        private ScaleListener() {
        }

        public boolean onScale(ScaleGestureDetector detector) {
            float[] p;
            float scale;
            float mScaleFactor = detector.getScaleFactor();
            if (detector.isInProgress()) {
                p = PromoPipCamera.this.getCenterOfMask();
                mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 5.0f));
                PromoPipCamera.this.matrixBitmap.postScale(mScaleFactor, mScaleFactor, p[0], p[1]);
                PromoPipCamera.this.matrixBitmap.getValues(PromoPipCamera.this.values);
                scale = PromoPipCamera.this.values[0];
            } else {
                p = PromoPipCamera.this.getCenterOfMask();
                mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 5.0f));
                PromoPipCamera.this.matrixBitmap.postScale(mScaleFactor, mScaleFactor, p[0], p[1]);
                PromoPipCamera.this.matrixBitmap.getValues(PromoPipCamera.this.values);
                scale = PromoPipCamera.this.values[0];
            }
            if (scale < PromoPipCamera.this.minScale) {
                PromoPipCamera.this.matrixBitmap.postScale(PromoPipCamera.this.minScale / scale, PromoPipCamera.this.minScale / scale, p[0], p[1]);
            }
            PromoPipCamera.this.checkBoundries();
            PromoPipCamera.this.invalidate();
            return true;
        }
    }

    public PromoPipCamera(Context context, int measuredWidth, Bitmap sourceBtm, String packageName) {
        super(context);
        this.bitmapSource = sourceBtm;
        this.bitmapBlur = createBlurBitmap(sourceBtm);
        this.myDataset = new PromoPipEntity[3];
        this.currentIndex = PROMO_INDEX % this.myDataset.length;
        PROMO_INDEX++;
        Log.e(TAG, "currentIndex " + this.currentIndex);
        this.myDataset[0] = new PromoPipEntity(70.0f, 80.0f, R.drawable.promo_mask_tablet, R.drawable.promo_shade_tablet, -1);
        this.myDataset[1] = new PromoPipEntity(58.0f, 120.0f, R.drawable.promo_mask_water_drop, R.drawable.promo_shade_water_drop, -1);
        this.myDataset[2] = new PromoPipEntity(30.0f, 0.0f, R.drawable.promo_mask_turn_page, R.drawable.promo_shade_turn_page, -1);
        this.bitmapShade = BitmapFactory.decodeResource(getResources(), this.myDataset[this.currentIndex].shadeId);
        this.bitmapMask = loadMaskBitmap2(this.myDataset[this.currentIndex].maskId);
        this.paintXfermode.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        this.screenWidth = (float) measuredWidth;
        setMatrixes();
        if (packageName != null) {
            this.marketUrl = "market://details?id=" + packageName;
        }
    }

    public void setMatrixes() {
        float w1 = (float) this.bitmapMask.getWidth();
        float h1 = (float) this.bitmapMask.getHeight();
        float w2 = (float) this.bitmapSource.getWidth();
        float h2 = (float) this.bitmapSource.getHeight();
        float scale = Math.max(w1 / w2, h1 / h2);
        this.minScale = scale;
        this.matrixBitmap = new Matrix();
        this.matrixBitmap.reset();
        this.matrixBitmap.postScale(scale, scale);
        float ddx = (-((scale * w2) - w1)) / 2.0f;
        float ddy = (-((scale * h2) - h1)) / 2.0f;
        float bubbleScale = this.screenWidth / ((float) this.bitmapShade.getWidth());
        this.matrixBubble = new Matrix();
        this.matrixBubble.reset();
        this.matrixBubble.postScale(bubbleScale, bubbleScale);
        scale = this.screenWidth / ((float) this.bitmapBlur.getWidth());
        this.matrixBlur = new Matrix();
        this.matrixBlur.reset();
        this.matrixBlur.postScale(scale, scale);
        this.matrixMask = new Matrix();
        this.matrixMask.reset();
        this.minScale *= bubbleScale;
        this.matrixMask.postScale(bubbleScale, bubbleScale);
        this.matrixBitmap.postScale(bubbleScale, bubbleScale);
        float sss = this.screenWidth / ((float) this.bitmapShade.getWidth());
        float dx = this.myDataset[this.currentIndex].dx * sss;
        float dy = this.myDataset[this.currentIndex].dy * sss;
        this.matrixMask.postTranslate(dx, dy);
        this.matrixBitmap.postTranslate(dx + ddx, dy + ddy);
        this.maskRect.set(0.0f, 0.0f, (float) this.bitmapMask.getWidth(), (float) this.bitmapMask.getHeight());
        this.matrixMask.mapRect(this.maskRect);
    }

    public void onDraw(Canvas canvas) {
        canvas.drawColor(-16711936);
        drawPipBitmap(canvas);
    }

    private void drawPipBitmap(Canvas canvas) {
        if (!this.bitmapBlur.isRecycled()) {
            canvas.drawBitmap(this.bitmapBlur, this.matrixBlur, this.paint);
        }
        this.f873r.set(0.0f, 0.0f, this.screenWidth + 0.0f, this.screenWidth + 0.0f);
        if (!this.bitmapMask.isRecycled()) {
            int k = canvas.saveLayer(this.f873r, null, 31);
            canvas.drawBitmap(this.bitmapMask, this.matrixMask, this.paint);
            if (!this.bitmapSource.isRecycled()) {
                canvas.drawBitmap(this.bitmapSource, this.matrixBitmap, this.paintXfermode);
            }
            canvas.restoreToCount(k);
        }
        if (!this.bitmapShade.isRecycled()) {
            canvas.drawBitmap(this.bitmapShade, this.matrixBubble, this.paint);
        }
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size;
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        if (width > height) {
            size = height;
        } else {
            size = width;
        }
        setMeasuredDimension(size, size);
    }

    public boolean onTouchEvent(MotionEvent ev) {
        int newPointerIndex = 0;
        int action = ev.getAction();
        float x;
        float y;
        int pointerIndex;
        switch (action & 255) {
            case 0:
                x = ev.getX();
                y = ev.getY();
                this.mActivePointerId = ev.getPointerId(0);
                this.touchCountForMarket++;
                if ((y > ((float) (getHeight() / 2)) || x > ((float) (getWidth() / 2))) && !this.isMarketCalled && this.touchCountForMarket > 1) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(this.marketUrl));
                    getContext().startActivity(intent);
                    this.isMarketCalled = true;
                    return true;
                }
                this.mLastTouchX = x;
                this.mLastTouchY = y;
                if (x < this.maskRect.left || x > this.maskRect.right || y < this.maskRect.top || y > this.maskRect.bottom) {
                    this.touchOutSide = true;
                    return true;
                }
                this.touchOutSide = false;
                return true;
            case 1:
                this.mActivePointerId = 1;
                return true;
            case 2:
                if (this.touchOutSide) {
                    return false;
                }
                pointerIndex = ev.findPointerIndex(this.mActivePointerId);
                x = ev.getX(pointerIndex);
                y = ev.getY(pointerIndex);
                this.matrixBitmap.postTranslate(x - this.mLastTouchX, y - this.mLastTouchY);
                checkBoundries();
                this.mLastTouchX = x;
                this.mLastTouchY = y;
                invalidate();
                return true;
            case 3:
                this.mActivePointerId = 1;
                return true;
            case 6:
                pointerIndex = (MotionEventCompat.ACTION_POINTER_INDEX_MASK & action) >> 8;
                if (ev.getPointerId(pointerIndex) != this.mActivePointerId) {
                    return true;
                }
                if (pointerIndex == 0) {
                    newPointerIndex = 1;
                }
                this.mLastTouchX = ev.getX(newPointerIndex);
                this.mLastTouchY = ev.getY(newPointerIndex);
                this.mActivePointerId = ev.getPointerId(newPointerIndex);
                return true;
            default:
                return true;
        }
    }

    float[] getCenterOfMask() {
        this.pts[0] = ((float) this.bitmapMask.getWidth()) / 2.0f;
        this.pts[1] = ((float) this.bitmapMask.getHeight()) / 2.0f;
        this.matrixMask.mapPoints(this.pts);
        return this.pts;
    }

    private void checkBoundries() {
        this.bitmapRect.set(0.0f, 0.0f, (float) this.bitmapSource.getWidth(), (float) this.bitmapSource.getHeight());
        this.matrixBitmap.mapRect(this.bitmapRect);
        float dx = 0.0f;
        float dy = 0.0f;
        if (this.bitmapRect.left > this.maskRect.left) {
            dx = this.maskRect.left - this.bitmapRect.left;
        }
        if (this.bitmapRect.top > this.maskRect.top) {
            dy = this.maskRect.top - this.bitmapRect.top;
        }
        if (this.bitmapRect.right < this.maskRect.right) {
            dx = this.maskRect.right - this.bitmapRect.right;
        }
        if (this.bitmapRect.bottom < this.maskRect.bottom) {
            dy = this.maskRect.bottom - this.bitmapRect.bottom;
        }
        this.matrixBitmap.postTranslate(dx, dy);
    }

    public Bitmap createBlurBitmap(Bitmap sourceBitmap) {
        if (Math.round(9.0f * ((float) Math.sqrt((double) (((float) (sourceBitmap.getWidth() * sourceBitmap.getWidth())) / 2560000.0f)))) < 2) {
        }
        if (sourceBitmap.getWidth() > sourceBitmap.getHeight()) {
            return createCroppedBitmap(sourceBitmap, (sourceBitmap.getWidth() / 2) - (sourceBitmap.getHeight() / 2), 0, sourceBitmap.getHeight(), sourceBitmap.getHeight(), false);
        }
        return createCroppedBitmap(sourceBitmap, 0, (sourceBitmap.getHeight() / 2) - (sourceBitmap.getWidth() / 2), sourceBitmap.getWidth(), sourceBitmap.getWidth(), false);
    }

    public static Bitmap createCroppedBitmap(Bitmap src, int left, int top, int w, int h, boolean filter) {
        Matrix m = new Matrix();
        m.setScale(BlurBuilderNormal.BITMAP_SCALE, BlurBuilderNormal.BITMAP_SCALE);
        m.postTranslate(((float) (-left)) * BlurBuilderNormal.BITMAP_SCALE, ((float) (-top)) * BlurBuilderNormal.BITMAP_SCALE);
        Bitmap result = Bitmap.createBitmap((int) (((float) w) * BlurBuilderNormal.BITMAP_SCALE), (int) (((float) h) * BlurBuilderNormal.BITMAP_SCALE), Config.ARGB_8888);
        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setFilterBitmap(filter);
        canvas.drawBitmap(src, m, paint);
        return result;
    }

    Bitmap loadMaskBitmap2(int resId) {
        return convertToAlphaMask(BitmapFactory.decodeResource(getResources(), resId));
    }

    private Bitmap convertToAlphaMask(Bitmap b) {
        Bitmap a = Bitmap.createBitmap(b.getWidth(), b.getHeight(), Config.ALPHA_8);
        new Canvas(a).drawBitmap(b, 0.0f, 0.0f, null);
        b.recycle();
        return a;
    }
}
