package com.lyrebirdstudio.sticker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;

import com.lyrebirdstudio.canvastext.BaseData;
import com.lyrebirdstudio.canvastext.CanvasTextView.TextAndStickerViewSelectedListener;
import com.lyrebirdstudio.canvastext.DecorateView;
import com.lyrebirdstudio.canvastext.MyMatrix;
import com.lyrebirdstudio.sticker.RotationGestureDetector.OnRotationGestureListener;

public class StickerView extends DecorateView {
    private static final int INVALID_POINTER_ID = -1;
    static float MIN_ZOOM = 0.2f;
    private static final String TAG = StickerView.class.getSimpleName();
    float actualRadius = this.paddingHeight;
    Paint bitmapPaint = new Paint(1);
    float btmH;
    float btmW;
    PointF center = new PointF();
    float circlePadding = 5.0f;
    Paint dashPaint = new Paint();
    Path dashPathHorizontal;
    Path dashPathHorizontalTemp = new Path();
    Path dashPathVertical;
    Path dashPathVerticalTemp = new Path();
    boolean doubleTouchCall = false;
    final float epsilon = 4.0f;
    GestureDetector gestureDetector;
    Matrix inverse = new Matrix();
    boolean isInCircle = false;
    boolean isOnRect = false;
    boolean isOnTouch = false;
    boolean locked = false;
    private int mActivePointerId = -1;
    private RotationGestureDetector mRotationDetector;
    private ScaleGestureDetector mScaleDetector;
    float mScaleFactor = 1.0f;
    float minDimen;
    boolean orthogonal = false;
    float paddingHeight = 30.0f;
    float paddingWidth = 10.0f;
    public Paint paint;
    PointF previosPos = new PointF();
    float[] pts = new float[2];
    Paint rectPaint;
    Paint rectPaintOnTouch;
    Paint redPaint = new Paint(1);
    Bitmap removeBitmap;
    Matrix removeBitmapMatrix = new Matrix();
    float removeBitmapWidth;
    OnRotationGestureListener rotateListener = new C10512();
    boolean savedViewSelected = false;
    float scale = 1.0f;
    Bitmap scaleBitmap;
    Matrix scaleBitmapMatrix = new Matrix();
    SingleTap singleTapListener;
    private float startAngle = 0.0f;
    float startAngleGesture = 0.0f;
    public Bitmap stickerBitmap;
    StickerData stickerData;
    TextAndStickerViewSelectedListener textAndStickerViewSelectedListener;
    Rect textBoundrect;
    RectF touchRect;
    float[] f1374v = new float[9];
    float[] values = new float[9];
    private boolean viewSelected = false;
    StickerViewSelectedListener viewSelectedListenerEx;
    Paint whitePaint = new Paint(1);
    PointF zoomStart = new PointF();

    class C06631 implements Runnable {
        C06631() {
        }

        public void run() {
            StickerView.this.doubleTouchCall = false;
        }
    }

    private class GestureListener extends SimpleOnGestureListener {
        private GestureListener() {
        }

        public boolean onDown(MotionEvent e) {
            Log.e(StickerView.TAG, "onDown");
            if (StickerView.this.isInCircle || StickerView.this.isOnRect) {
                return true;
            }
            StickerView.this.viewSelected = false;
            return false;
        }

        public boolean onSingleTapUp(MotionEvent event) {
            Log.e(StickerView.TAG, "onSingleTapUp");
            if (StickerView.this.locked) {
                return false;
            }
            StickerView.this.pts[0] = event.getX();
            StickerView.this.pts[1] = event.getY();
            StickerView.this.stickerData.canvasMatrix.invert(StickerView.this.inverse);
            StickerView.this.inverse.mapPoints(StickerView.this.pts, StickerView.this.pts);
            StickerView.this.isOnRect = StickerView.this.isOnRectCheck(StickerView.this.pts[0], StickerView.this.pts[1]);
            Log.e(StickerView.TAG, "onSingleTapUp viewSelected " + StickerView.this.viewSelected);
            if (StickerView.this.isOnRect) {
                Log.e(StickerView.TAG, "onSingleTapUp doubleSavedViewSelected " + StickerView.this.doubleTouchCall);
                if (StickerView.this.doubleTouchCall) {
                    StickerView.this.viewSelected = true;
                } else {
                    StickerView.this.viewSelected = !StickerView.this.savedViewSelected;
                }
                StickerView.this.doubleTouchCall = false;
            } else {
                StickerView.this.viewSelected = false;
            }
            if (StickerView.this.isInCircle || StickerView.this.isOnRect) {
                return true;
            }
            return false;
        }

        public boolean onDoubleTap(MotionEvent e) {
            if (StickerView.this.locked) {
                return false;
            }
            StickerView.this.pts[0] = e.getX();
            StickerView.this.pts[1] = e.getY();
            StickerView.this.stickerData.canvasMatrix.invert(StickerView.this.inverse);
            StickerView.this.inverse.mapPoints(StickerView.this.pts, StickerView.this.pts);
            StickerView.this.isOnRect = StickerView.this.isOnRectCheck(StickerView.this.pts[0], StickerView.this.pts[1]);
            if (StickerView.this.isOnRect) {
                StickerView.this.viewSelected = true;
            } else {
                StickerView.this.viewSelected = false;
            }
            return true;
        }
    }

    private class ScaleListener extends SimpleOnScaleGestureListener {
        private ScaleListener() {
        }

        public boolean onScale(ScaleGestureDetector detector) {
            StickerView.this.mScaleFactor = detector.getScaleFactor();
            if (detector.isInProgress()) {
                StickerView.this.pts[0] = StickerView.this.touchRect.centerX();
                StickerView.this.pts[1] = StickerView.this.touchRect.centerY();
                StickerView.this.stickerData.canvasMatrix.mapPoints(StickerView.this.pts, StickerView.this.pts);
                StickerView.this.mScaleFactor = detector.getScaleFactor();
                StickerView.this.mScaleFactor = Math.max(StickerView.MIN_ZOOM, StickerView.this.mScaleFactor);
                StickerView.this.stickerData.canvasMatrix.postScale(StickerView.this.mScaleFactor, StickerView.this.mScaleFactor, StickerView.this.pts[0], StickerView.this.pts[1]);
                StickerView.this.scale = StickerView.this.getScale();
                StickerView.this.invalidate();
            } else {
                StickerView.this.pts[0] = StickerView.this.touchRect.centerX();
                StickerView.this.pts[1] = StickerView.this.touchRect.centerY();
                StickerView.this.stickerData.canvasMatrix.mapPoints(StickerView.this.pts, StickerView.this.pts);
                StickerView.this.mScaleFactor = detector.getScaleFactor();
                StickerView.this.mScaleFactor = Math.max(StickerView.MIN_ZOOM, StickerView.this.mScaleFactor);
                StickerView.this.stickerData.canvasMatrix.postScale(StickerView.this.mScaleFactor, StickerView.this.mScaleFactor, StickerView.this.pts[0], StickerView.this.pts[1]);
                StickerView.this.scale = StickerView.this.getScale();
                StickerView.this.invalidate();
            }
            return true;
        }
    }

    public interface SingleTap {
        void onSingleTap(StickerData stickerData);
    }

    public interface StickerViewSelectedListener {
        void onTouchUp(StickerData stickerData);

        void setSelectedView(StickerView stickerView);
    }

    public interface StickerViewTouchUpListener {
        void onTouchUp();
    }

    class C10512 implements OnRotationGestureListener {
        C10512() {
        }

        public void OnRotation(RotationGestureDetector rotationDetector) {
            float angle = rotationDetector.getAngle();
            float rotation = StickerView.this.getMatrixRotation(StickerView.this.stickerData.canvasMatrix);
            if ((rotation == 0.0f || rotation == 90.0f || rotation == 180.0f || rotation == -180.0f || rotation == -90.0f) && Math.abs(StickerView.this.startAngleGesture - angle) < 4.0f) {
                StickerView.this.orthogonal = true;
                return;
            }
            if (Math.abs((rotation - StickerView.this.startAngleGesture) + angle) < 4.0f) {
                angle = StickerView.this.startAngleGesture - rotation;
                StickerView.this.orthogonal = true;
            } else if (Math.abs(90.0f - ((rotation - StickerView.this.startAngleGesture) + angle)) < 4.0f) {
                angle = (StickerView.this.startAngleGesture + 90.0f) - rotation;
                StickerView.this.orthogonal = true;
            } else if (Math.abs(180.0f - ((rotation - StickerView.this.startAngleGesture) + angle)) < 4.0f) {
                angle = (180.0f + StickerView.this.startAngleGesture) - rotation;
                StickerView.this.orthogonal = true;
            } else if (Math.abs(-180.0f - ((rotation - StickerView.this.startAngleGesture) + angle)) < 4.0f) {
                angle = (StickerView.this.startAngleGesture - 0.024902344f) - rotation;
                StickerView.this.orthogonal = true;
            } else if (Math.abs(-90.0f - ((rotation - StickerView.this.startAngleGesture) + angle)) < 4.0f) {
                angle = (StickerView.this.startAngleGesture - 0.049804688f) - rotation;
                StickerView.this.orthogonal = true;
            } else {
                StickerView.this.orthogonal = false;
            }
            StickerView.this.pts[0] = StickerView.this.touchRect.centerX();
            StickerView.this.pts[1] = StickerView.this.touchRect.centerY();
            StickerView.this.stickerData.canvasMatrix.mapPoints(StickerView.this.pts, StickerView.this.pts);
            StickerView.this.stickerData.canvasMatrix.postRotate(StickerView.this.startAngleGesture - angle, StickerView.this.pts[0], StickerView.this.pts[1]);
            StickerView.this.startAngleGesture = angle;
            StickerView.this.invalidate();
        }
    }

    public void setStickerViewSelectedListener(StickerViewSelectedListener l) {
    }

    public BaseData getData() {
        return this.stickerData;
    }

    public void setSingleTapListener(SingleTap l) {
        this.singleTapListener = l;
    }

    public void setTextAndStickerSelectedListner(TextAndStickerViewSelectedListener l) {
        this.textAndStickerViewSelectedListener = l;
    }

    public void setViewSelected(boolean selection) {
        Log.e(TAG, "setViewSelected " + selection);
        this.viewSelected = selection;
        postInvalidate();
    }

    public StickerData getStickerData() {
        return this.stickerData;
    }

    public void setStickerData(StickerData data) {
        this.stickerData.set(data);
    }

    public boolean getViewSelected() {
        return this.viewSelected;
    }

    public void lockView(boolean isLocked) {
        this.locked = isLocked;
    }

    @SuppressLint({"NewApi"})
    public StickerView(Context context, Bitmap bitmap, StickerData stData, Bitmap removeBtm, Bitmap scaleBtm, int resourceId, String path) {
        super(context);
        this.stickerBitmap = bitmap;
        this.removeBitmap = removeBtm;
        this.scaleBitmap = scaleBtm;
        this.mScaleDetector = new ScaleGestureDetector(context, new ScaleListener());
        this.mRotationDetector = new RotationGestureDetector(this.rotateListener);
        float screenWidth = (float) getResources().getDisplayMetrics().widthPixels;
        float screenHeight = (float) getResources().getDisplayMetrics().heightPixels;
        this.minDimen = Math.min(screenWidth, screenHeight);
        this.rectPaint = new Paint(1);
        this.rectPaint.setColor(2006555033);
        this.rectPaintOnTouch = new Paint(1);
        this.rectPaintOnTouch.setColor(2011028957);
        this.textBoundrect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        if (stData == null) {
            if (path != null) {
                this.stickerData = new StickerData(path);
            } else {
                this.stickerData = new StickerData(resourceId);
            }
            float scale = this.minDimen / 1080.0f;
            this.stickerData.canvasMatrix.postScale(scale, scale);
            this.stickerData.canvasMatrix.postTranslate(0.1f, 0.1f);
            this.stickerData.xPos = ((screenWidth / scale) - ((float) this.textBoundrect.width())) / 2.0f;
            this.stickerData.yPos = screenHeight / (3.0f * scale);
        } else {
            this.stickerData = stData;
        }
        this.paddingWidth = screenWidth / 15.0f;
        this.paddingHeight = screenWidth / 14.0f;
        this.touchRect = new RectF(this.stickerData.xPos - this.paddingWidth, this.stickerData.yPos - this.paddingHeight, (this.stickerData.xPos + ((float) this.textBoundrect.width())) + this.paddingWidth, (this.stickerData.yPos + ((float) this.textBoundrect.height())) + this.paddingHeight);
        this.gestureDetector = new GestureDetector(context, new GestureListener());
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setFilterBitmap(true);
        this.redPaint.setColor(-16485377);
        this.whitePaint.setColor(-1460137);
        this.bitmapPaint.setFilterBitmap(true);
        this.actualRadius = this.minDimen / 20.0f;
        float maxDimForBitmap = (float) Math.max(bitmap.getWidth(), bitmap.getHeight());
        if (maxDimForBitmap > this.actualRadius * 3.0f) {
            MIN_ZOOM = (this.actualRadius * 1.0f) / maxDimForBitmap;
        }
        this.circlePadding = this.actualRadius / 2.0f;
        if (this.actualRadius <= 5.0f) {
            this.actualRadius = this.paddingHeight;
        }
        this.removeBitmapWidth = (float) this.removeBitmap.getWidth();
        this.removeBitmapMatrix.reset();
        this.scaleBitmapMatrix.reset();
        float bitmapScale = (2.0f * this.actualRadius) / this.removeBitmapWidth;
        this.removeBitmapMatrix.postScale(bitmapScale, bitmapScale);
        this.removeBitmapMatrix.postTranslate(this.touchRect.left - ((this.removeBitmapWidth * bitmapScale) / 2.0f), this.touchRect.top - ((this.removeBitmapWidth * bitmapScale) / 2.0f));
        this.scaleBitmapMatrix.postScale(bitmapScale, bitmapScale);
        this.scaleBitmapMatrix.postTranslate(this.touchRect.right - ((this.removeBitmapWidth * bitmapScale) / 2.0f), this.touchRect.bottom - ((this.removeBitmapWidth * bitmapScale) / 2.0f));
        this.scale = getScale();
        this.scaleBitmapMatrix.postScale(1.0f / this.scale, 1.0f / this.scale, this.touchRect.right, this.touchRect.bottom);
        this.removeBitmapMatrix.postScale(1.0f / this.scale, 1.0f / this.scale, this.touchRect.left, this.touchRect.top);
        this.btmW = (float) bitmap.getWidth();
        this.btmH = (float) bitmap.getHeight();
        this.dashPaint.setColor(-7829368);
        this.dashPaint.setStyle(Style.STROKE);
        float strokeW = screenWidth / 120.0f;
        if (strokeW <= 0.0f) {
            strokeW = 5.0f;
        }
        this.dashPaint.setStrokeWidth(strokeW);
        this.dashPaint.setPathEffect(new DashPathEffect(new float[]{strokeW, strokeW}, 0.0f));
        this.dashPathVertical = new Path();
        this.dashPathVertical.moveTo(this.btmW / 2.0f, (-this.btmH) / 5.0f);
        this.dashPathVertical.lineTo(this.btmW / 2.0f, (6.0f * this.btmH) / 5.0f);
        this.dashPathHorizontal = new Path();
        this.dashPathHorizontal.moveTo((-this.btmW) / 5.0f, this.btmH / 2.0f);
        this.dashPathHorizontal.lineTo((6.0f * this.btmW) / 5.0f, this.btmH / 2.0f);
    }

    public boolean isDecorateViewSelected() {
        return this.viewSelected;
    }

    public void setDecorateViewSelected(boolean selection) {
        this.viewSelected = selection;
        invalidate();
    }

    public void setMatrix(MyMatrix matrix) {
        this.stickerData.canvasMatrix.set(matrix);
        this.scale = getScale();
    }

    public void onDestroy() {
        Log.e(TAG, "ondestroy");
        this.stickerBitmap.recycle();
        this.stickerBitmap = null;
    }

    public void onDraw(Canvas canvas) {
        canvas.setMatrix(this.stickerData.canvasMatrix);
        this.removeBitmapMatrix.reset();
        this.scaleBitmapMatrix.reset();
        this.scale = getScale();
        float localPaddingWidth = this.paddingWidth;
        float localPaddingHeight = this.paddingHeight;
        localPaddingWidth = this.minDimen / (this.scale * 18.0f);
        localPaddingHeight = this.minDimen / (this.scale * 18.0f);
        this.touchRect.set(this.stickerData.xPos - localPaddingWidth, this.stickerData.yPos - localPaddingHeight, (this.stickerData.xPos + ((float) this.textBoundrect.width())) + localPaddingWidth, (this.stickerData.yPos + ((float) this.textBoundrect.height())) + localPaddingHeight);
        float bitmapScale = (this.actualRadius * 2.0f) / this.removeBitmapWidth;
        this.removeBitmapMatrix.postScale(bitmapScale, bitmapScale);
        this.removeBitmapMatrix.postTranslate(this.touchRect.left - ((this.removeBitmapWidth * bitmapScale) / 2.0f), this.touchRect.top - ((this.removeBitmapWidth * bitmapScale) / 2.0f));
        this.scaleBitmapMatrix.postScale(bitmapScale, bitmapScale);
        this.scaleBitmapMatrix.postTranslate(this.touchRect.right - ((this.removeBitmapWidth * bitmapScale) / 2.0f), this.touchRect.bottom - ((this.removeBitmapWidth * bitmapScale) / 2.0f));
        this.scaleBitmapMatrix.postScale(1.0f / this.scale, 1.0f / this.scale, this.touchRect.right, this.touchRect.bottom);
        this.removeBitmapMatrix.postScale(1.0f / this.scale, 1.0f / this.scale, this.touchRect.left, this.touchRect.top);
        float rad = this.actualRadius / this.scale;
        if (this.viewSelected) {
            if (this.isOnTouch) {
                canvas.drawRect(this.touchRect, this.rectPaintOnTouch);
            } else {
                canvas.drawRect(this.touchRect, this.rectPaint);
            }
            canvas.drawCircle(this.touchRect.right, this.touchRect.bottom, rad, this.whitePaint);
            canvas.drawCircle(this.touchRect.left, this.touchRect.top, rad, this.redPaint);
            canvas.drawBitmap(this.scaleBitmap, this.scaleBitmapMatrix, this.bitmapPaint);
            canvas.drawBitmap(this.removeBitmap, this.removeBitmapMatrix, this.bitmapPaint);
        }
        if (!(this.stickerBitmap == null || this.stickerBitmap.isRecycled())) {
            canvas.drawBitmap(this.stickerBitmap, this.stickerData.xPos, this.stickerData.yPos, this.paint);
        }
        if (this.orthogonal) {
            this.dashPathVertical.offset(this.stickerData.xPos, this.stickerData.yPos, this.dashPathVerticalTemp);
            this.dashPathHorizontal.offset(this.stickerData.xPos, this.stickerData.yPos, this.dashPathHorizontalTemp);
            canvas.drawPath(this.dashPathVerticalTemp, this.dashPaint);
            canvas.drawPath(this.dashPathHorizontalTemp, this.dashPaint);
        }
    }

    void singleTapped() {
    }

    public boolean isOnRectCheck(float x, float y) {
        float paddingX = this.touchRect.width() / 10.0f;
        float paddingY = this.touchRect.height() / 10.0f;
        if (getScale() < MIN_ZOOM * 2.0f) {
            paddingX = -paddingX;
            paddingY = -paddingY;
        }
        if (x <= this.touchRect.left + paddingX || x >= this.touchRect.right - paddingX || y <= this.touchRect.top + paddingY || y >= this.touchRect.bottom - paddingY) {
            return false;
        }
        this.viewSelected = true;
        return true;
    }

    public float containsScore(float xx, float yy) {
        this.pts[0] = xx;
        this.pts[1] = yy;
        this.stickerData.canvasMatrix.invert(this.inverse);
        this.inverse.mapPoints(this.pts, this.pts);
        float x = this.pts[0];
        float y = this.pts[1];
        RectF maskRect = this.touchRect;
        if (x >= maskRect.left && x <= maskRect.right && y >= maskRect.top && y <= maskRect.bottom) {
            float contain = ((x - maskRect.centerX()) * (x - maskRect.centerX())) + ((y - maskRect.centerY()) * (y - maskRect.centerY()));
            float hypotenus = (maskRect.width() * maskRect.width()) + (maskRect.height() * maskRect.height());
            if (contain > 0.0f) {
                return hypotenus / contain;
            }
        }
        return -2.0f;
    }

    boolean isInCircle(float x, float y) {
        if (((x - this.touchRect.right) * (x - this.touchRect.right)) + ((y - this.touchRect.bottom) * (y - this.touchRect.bottom)) >= ((this.actualRadius + this.circlePadding) * (this.actualRadius + this.circlePadding)) / (this.scale * this.scale)) {
            return false;
        }
        this.viewSelected = true;
        return true;
    }

    boolean isOnCross(float x, float y) {
        if (((x - this.touchRect.left) * (x - this.touchRect.left)) + ((y - this.touchRect.top) * (y - this.touchRect.top)) >= ((this.actualRadius + this.circlePadding) * (this.actualRadius + this.circlePadding)) / (this.scale * this.scale)) {
            return false;
        }
        this.viewSelected = true;
        return true;
    }

    boolean isOnCross2(float x, float y, float left, float top) {
        if (((x - left) * (x - left)) + ((y - top) * (y - top)) >= ((this.actualRadius + this.circlePadding) * (this.actualRadius + this.circlePadding)) / (this.scale * this.scale)) {
            return false;
        }
        this.viewSelected = true;
        return true;
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (this.locked) {
            return false;
        }
        this.mScaleDetector.onTouchEvent(event);
        this.mRotationDetector.onTouchEvent(event);
        float x = event.getX();
        float y = event.getY();
        int pointerIndex;
        switch (event.getAction() & 255) {
            case 0:
                this.isOnRect = false;
                this.isInCircle = false;
                this.savedViewSelected = this.viewSelected;
                this.isOnTouch = true;
                this.pts[0] = x;
                this.pts[1] = y;
                this.stickerData.canvasMatrix.invert(this.inverse);
                this.inverse.mapPoints(this.pts, this.pts);
                Log.e(TAG, "ACTION_DOWN savedViewSelected " + this.savedViewSelected);
                Log.e(TAG, "pointer count = " + event.getPointerCount());
                if (this.viewSelected) {
                    if (isOnCross(this.pts[0], this.pts[1])) {
                        createDeleteDialog(getContext(), this);
                        return true;
                    }
                }
                this.isOnRect = isOnRectCheck(this.pts[0], this.pts[1]);
                Log.e(TAG, "ACTION_DOWN viewSelected " + this.viewSelected);
                this.isInCircle = isInCircle(this.pts[0], this.pts[1]);
                this.previosPos.set(x, y);
                this.zoomStart.set(x, y);
                this.pts[0] = this.touchRect.centerX();
                this.pts[1] = this.touchRect.centerY();
                this.stickerData.canvasMatrix.mapPoints(this.pts, this.pts);
                this.startAngle = (float) (-pointToAngle(x, y, this.pts[0], this.pts[1]));
                if (this.isInCircle || this.isOnRect) {
                    this.textAndStickerViewSelectedListener.setSelectedView(this);
                }
                this.mActivePointerId = event.getPointerId(0);
                if (!this.savedViewSelected) {
                    this.doubleTouchCall = true;
                    return this.savedViewSelected;
                }
                break;
            case 1:
                new Handler().postDelayed(new C06631(), 100);
                Log.e(TAG, "ACTION_UP");
                this.orthogonal = false;
                this.textAndStickerViewSelectedListener.onTouchUp(this.stickerData);
                if (this.onDecorateViewTouchUpListener != null) {
                    this.onDecorateViewTouchUpListener.onTouchUp(this.stickerData);
                }
                this.isOnTouch = false;
                this.isOnRect = false;
                this.mActivePointerId = -1;
                break;
            case 2:
                if (!this.isInCircle) {
                    if (this.isOnRect) {
                        pointerIndex = event.findPointerIndex(this.mActivePointerId);
                        if (pointerIndex >= 0 && pointerIndex < event.getPointerCount()) {
                            float mx = event.getX(pointerIndex);
                            float my = event.getY(pointerIndex);
                            this.stickerData.canvasMatrix.postTranslate(mx - this.previosPos.x, my - this.previosPos.y);
                            this.previosPos.set(mx, my);
                            break;
                        }
                    }
                }
                float currentAngle = (float) (-pointToAngle(x, y, this.pts[0], this.pts[1]));
                float rotation = getMatrixRotation(this.stickerData.canvasMatrix);
                if ((rotation == 0.0f || rotation == 90.0f || rotation == 180.0f || rotation == -180.0f || rotation == -90.0f) && Math.abs(this.startAngle - currentAngle) < 4.0f) {
                    this.orthogonal = true;
                } else {
                    if (Math.abs((rotation - this.startAngle) + currentAngle) < 4.0f) {
                        currentAngle = this.startAngle - rotation;
                        this.orthogonal = true;
                    } else if (Math.abs(90.0f - ((rotation - this.startAngle) + currentAngle)) < 4.0f) {
                        currentAngle = (90.0f + this.startAngle) - rotation;
                        this.orthogonal = true;
                    } else if (Math.abs(180.0f - ((rotation - this.startAngle) + currentAngle)) < 4.0f) {
                        currentAngle = (180.0f + this.startAngle) - rotation;
                        this.orthogonal = true;
                    } else if (Math.abs(-180.0f - ((rotation - this.startAngle) + currentAngle)) < 4.0f) {
                        currentAngle = (-180.0f + this.startAngle) - rotation;
                        this.orthogonal = true;
                    } else if (Math.abs(-90.0f - ((rotation - this.startAngle) + currentAngle)) < 4.0f) {
                        currentAngle = (-90.0f + this.startAngle) - rotation;
                        this.orthogonal = true;
                    } else {
                        this.orthogonal = false;
                    }
                    this.stickerData.canvasMatrix.postRotate(this.startAngle - currentAngle, this.pts[0], this.pts[1]);
                    this.startAngle = currentAngle;
                }
                float scaley = ((float) Math.sqrt((double) (((x - this.pts[0]) * (x - this.pts[0])) + ((y - this.pts[1]) * (y - this.pts[1]))))) / ((float) Math.sqrt((double) (((this.zoomStart.x - this.pts[0]) * (this.zoomStart.x - this.pts[0])) + ((this.zoomStart.y - this.pts[1]) * (this.zoomStart.y - this.pts[1])))));
                this.scale = getScale();
                if (this.scale >= MIN_ZOOM || (this.scale < MIN_ZOOM && scaley > 1.0f)) {
                    this.stickerData.canvasMatrix.postScale(scaley, scaley, this.pts[0], this.pts[1]);
                    this.zoomStart.set(x, y);
                    this.scale = getScale();
                    break;
                }
                break;
            case 5:
                Log.e(TAG, "ACTION_POINTER_DOWN pointer count = " + event.getPointerCount());
                break;
            case 6:
                this.startAngleGesture = 0.0f;
                pointerIndex = (event.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                if (event.getPointerId(pointerIndex) == this.mActivePointerId) {
                    int newPointerIndex = pointerIndex == 0 ? 1 : 0;
                    if (newPointerIndex >= 0 && newPointerIndex < event.getPointerCount()) {
                        this.previosPos.set(event.getX(newPointerIndex), event.getY(newPointerIndex));
                        this.mActivePointerId = event.getPointerId(newPointerIndex);
                        break;
                    }
                }
                break;
        }
        boolean returnValue = this.gestureDetector.onTouchEvent(event);
        postInvalidate();
        return returnValue;
    }

    float getScale() {
        this.stickerData.canvasMatrix.getValues(this.values);
        float scalex = this.values[0];
        float skewy = this.values[3];
        return (float) Math.sqrt((double) ((scalex * scalex) + (skewy * skewy)));
    }

    public static int pointToAngle(float x, float y, float centerX, float centerY) {
        if (x >= centerX && y < centerY) {
            return ((int) Math.toDegrees(Math.atan(((double) (x - centerX)) / ((double) (centerY - y))))) + 270;
        }
        if (x > centerX && y >= centerY) {
            return (int) Math.toDegrees(Math.atan(((double) (y - centerY)) / ((double) (x - centerX))));
        }
        if (x <= centerX && y > centerY) {
            return ((int) Math.toDegrees(Math.atan(((double) (centerX - x)) / ((double) (y - centerY))))) + 90;
        }
        if (x >= centerX || y > centerY) {
            return 0;
        }
        return ((int) Math.toDegrees(Math.atan(((double) (centerY - y)) / ((double) (centerX - x))))) + 180;
    }

    float getMatrixRotation(Matrix matrix) {
        matrix.getValues(this.f1374v);
        return (float) Math.round(Math.atan2((double) this.f1374v[1], (double) this.f1374v[0]) * 57.29577951308232d);
    }
}
