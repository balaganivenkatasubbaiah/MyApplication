package com.lyrebirdstudio.canvastext;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;

import com.lyrebirdstudio.R;
import com.lyrebirdstudio.sticker.RotationGestureDetector;
import com.lyrebirdstudio.sticker.RotationGestureDetector.OnRotationGestureListener;
import com.lyrebirdstudio.sticker.StickerView;

public class CanvasTextView extends DecorateView {
    private static final int INVALID_POINTER_ID = -1;
    static final float MIN_ZOOM = 0.8f;
    static int SNAP_CIRCLE_0 = 0;
    static int SNAP_CIRCLE_1 = 1;
    static int SNAP_CIRCLE_2 = 2;
    static int SNAP_CIRCLE_NONE = -1;
    private static final String TAG = "CanvasTextView";
    public static Paint paintSnap = new Paint(1);
    float actualRadius = this.paddingHeight;
    Paint bitmapPaint = new Paint(1);
    float bitmapWidth;
    Bitmap blackBarBitmap;
    float circlePadding = 5.0f;
    Paint dashPaint = new Paint();
    Path dashPathHorizontal;
    Path dashPathVertical;
    boolean doubleTouchCall = false;
    boolean downModeSnap = false;
    Bitmap editBitmap;
    Matrix editBtmScaleMatrix = new Matrix();
    final float epsilon = 4.0f;
    GestureDetector gestureDetector;
    Matrix inverse = new Matrix();
    boolean isInCircle = false;
    boolean isOnRect = false;
    boolean isOnTouch = false;
    Rect lineBound = new Rect();
    boolean locked = false;
    private int mActivePointerId = -1;
    private RotationGestureDetector mRotationDetector;
    private ScaleGestureDetector mScaleDetector;
    float mScaleFactor = 1.0f;
    boolean onRectSnap = false;
    boolean orthogonal = false;
    float paddingHeight = 30.0f;
    float paddingWidth = 10.0f;
    Paint paintBg = new Paint(1);
    Paint paintGreen = new Paint(1);
    PointF previosPos = new PointF();
    float previousY;
    float previousYSnap;
    float[] pts = new float[2];
    float radiusx = 40.0f;
    RectF rectBg = new RectF();
    Paint rectPaint;
    Paint rectPaintOnTouch;
    RectF rectSnap = new RectF();
    private RectF rectText;
    Paint redPaint = new Paint(1);
    Bitmap removeBitmap;
    Matrix removeBitmapMatrix = new Matrix();
    Matrix removeBtmSnapMatrix = new Matrix();
    PointF res = new PointF();
    OnRotationGestureListener rotateListener = new C10042();
    boolean savedViewSelected = false;
    float scale = 1.0f;
    Bitmap scaleBitmap;
    Matrix scaleBitmapMatrix = new Matrix();
    Matrix scaleBitmapSwitch = new Matrix();
    float screenHeight;
    float screenWidth;
    SingleTap singleTapListener;
    private float startAngle = 0.0f;
    float startAngleGesture = 0.0f;
    Bitmap switchBitmap;
    Matrix switchBtmScaleMatrix = new Matrix();
    TextAndStickerViewSelectedListener textAndStickerViewSelectedListener;
    Rect textBoundrect;
    TextData textData;
    float[] f1373v = new float[9];
    float[] values = new float[9];
    private boolean viewSelected = false;
    ViewSelectedListener viewSelectedListenerEx;
    Paint whitePaint = new Paint(1);
    PointF zoomStart = new PointF();

    class C05831 implements Runnable {
        C05831() {
        }

        public void run() {
            CanvasTextView.this.doubleTouchCall = false;
        }
    }

    private class GestureListener extends SimpleOnGestureListener {
        private GestureListener() {
        }

        public boolean onDown(MotionEvent e) {
            if (CanvasTextView.this.textData.getSnapMode() && CanvasTextView.this.onRectSnap) {
                return true;
            }
            if (CanvasTextView.this.textData.getSnapMode() && !CanvasTextView.this.onRectSnap) {
                CanvasTextView.this.viewSelected = false;
                return false;
            } else if (CanvasTextView.this.isInCircle || CanvasTextView.this.isOnRect) {
                return true;
            } else {
                CanvasTextView.this.viewSelected = false;
                return false;
            }
        }

        public boolean onSingleTapUp(MotionEvent event) {
            if (CanvasTextView.this.locked) {
                return false;
            }
            float x = event.getX();
            float y = event.getY();
            if (!CanvasTextView.this.textData.getSnapMode()) {
                Log.d("Single Tap", "Tapped at");
                CanvasTextView.this.pts[0] = event.getX();
                CanvasTextView.this.pts[1] = event.getY();
                CanvasTextView.this.textData.canvasMatrix.invert(CanvasTextView.this.inverse);
                CanvasTextView.this.inverse.mapPoints(CanvasTextView.this.pts, CanvasTextView.this.pts);
                CanvasTextView.this.isOnRect = CanvasTextView.this.isOnRectCheck(CanvasTextView.this.pts[0], CanvasTextView.this.pts[1]);
                if (CanvasTextView.this.isOnRect) {
                    Log.e(CanvasTextView.TAG, "onSingleTapUp doubleSavedViewSelected " + CanvasTextView.this.doubleTouchCall);
                    if (CanvasTextView.this.doubleTouchCall) {
                        CanvasTextView.this.viewSelected = true;
                    } else {
                        CanvasTextView.this.viewSelected = !CanvasTextView.this.savedViewSelected;
                    }
                    CanvasTextView.this.doubleTouchCall = false;
                } else {
                    CanvasTextView.this.viewSelected = false;
                }
                if (CanvasTextView.this.isInCircle || CanvasTextView.this.isOnRect) {
                    return true;
                }
                return false;
            } else if (x <= CanvasTextView.this.rectSnap.left || x >= CanvasTextView.this.rectSnap.right || y <= CanvasTextView.this.rectSnap.top || y >= CanvasTextView.this.rectSnap.bottom) {
                CanvasTextView.this.viewSelected = false;
                CanvasTextView.this.onRectSnap = false;
                return false;
            } else {
                CanvasTextView.this.onRectSnap = true;
                CanvasTextView.this.viewSelected = true;
                return true;
            }
        }

        public boolean onDoubleTap(MotionEvent e) {
            if (CanvasTextView.this.locked) {
                return false;
            }
            float x = e.getX();
            float y = e.getY();
            if (!CanvasTextView.this.textData.getSnapMode()) {
                CanvasTextView.this.pts[0] = e.getX();
                CanvasTextView.this.pts[1] = e.getY();
                CanvasTextView.this.textData.canvasMatrix.invert(CanvasTextView.this.inverse);
                CanvasTextView.this.inverse.mapPoints(CanvasTextView.this.pts, CanvasTextView.this.pts);
                CanvasTextView.this.isOnRect = CanvasTextView.this.isOnRectCheck(CanvasTextView.this.pts[0], CanvasTextView.this.pts[1]);
                if (CanvasTextView.this.isOnRect) {
                    Log.d("viewSelected", "double Tapped at");
                    CanvasTextView.this.viewSelected = true;
                    CanvasTextView.this.singleTapped();
                } else {
                    CanvasTextView.this.viewSelected = false;
                }
                Log.d("Double Tap", "Tapped at");
                return true;
            } else if (x <= CanvasTextView.this.rectSnap.left || x >= CanvasTextView.this.rectSnap.right || y <= CanvasTextView.this.rectSnap.top || y >= CanvasTextView.this.rectSnap.bottom) {
                CanvasTextView.this.viewSelected = false;
                CanvasTextView.this.onRectSnap = false;
                return false;
            } else {
                CanvasTextView.this.singleTapped();
                CanvasTextView.this.onRectSnap = true;
                CanvasTextView.this.viewSelected = true;
                return true;
            }
        }
    }

    private class ScaleListener extends SimpleOnScaleGestureListener {
        private ScaleListener() {
        }

        public boolean onScale(ScaleGestureDetector detector) {
            CanvasTextView.this.mScaleFactor = detector.getScaleFactor();
            if (detector.isInProgress()) {
                CanvasTextView.this.pts[0] = CanvasTextView.this.rectText.centerX();
                CanvasTextView.this.pts[1] = CanvasTextView.this.rectText.centerY();
                CanvasTextView.this.textData.canvasMatrix.mapPoints(CanvasTextView.this.pts, CanvasTextView.this.pts);
                CanvasTextView.this.mScaleFactor = detector.getScaleFactor();
                CanvasTextView.this.mScaleFactor = Math.max(CanvasTextView.MIN_ZOOM, CanvasTextView.this.mScaleFactor);
                CanvasTextView.this.textData.canvasMatrix.postScale(CanvasTextView.this.mScaleFactor, CanvasTextView.this.mScaleFactor, CanvasTextView.this.pts[0], CanvasTextView.this.pts[1]);
                CanvasTextView.this.scale = CanvasTextView.this.getScale();
                CanvasTextView.this.invalidate();
            } else {
                CanvasTextView.this.pts[0] = CanvasTextView.this.rectText.centerX();
                CanvasTextView.this.pts[1] = CanvasTextView.this.rectText.centerY();
                CanvasTextView.this.textData.canvasMatrix.mapPoints(CanvasTextView.this.pts, CanvasTextView.this.pts);
                CanvasTextView.this.mScaleFactor = detector.getScaleFactor();
                CanvasTextView.this.mScaleFactor = Math.max(CanvasTextView.MIN_ZOOM, CanvasTextView.this.mScaleFactor);
                CanvasTextView.this.textData.canvasMatrix.postScale(CanvasTextView.this.mScaleFactor, CanvasTextView.this.mScaleFactor, CanvasTextView.this.pts[0], CanvasTextView.this.pts[1]);
                CanvasTextView.this.scale = CanvasTextView.this.getScale();
                CanvasTextView.this.invalidate();
            }
            return true;
        }
    }

    public interface TextAndStickerViewSelectedListener {
        void onTouchUp(BaseData baseData);

        void setSelectedView(DecorateView decorateView);
    }

    class C10042 implements OnRotationGestureListener {
        C10042() {
        }

        public void OnRotation(RotationGestureDetector rotationDetector) {
            float angle = rotationDetector.getAngle();
            float rotation = CanvasTextView.this.getMatrixRotation(CanvasTextView.this.textData.canvasMatrix);
            if ((rotation == 0.0f || rotation == 90.0f || rotation == 180.0f || rotation == -180.0f || rotation == -90.0f) && Math.abs(CanvasTextView.this.startAngleGesture - angle) < 4.0f) {
                CanvasTextView.this.orthogonal = true;
                return;
            }
            if (Math.abs((rotation - CanvasTextView.this.startAngleGesture) + angle) < 4.0f) {
                angle = CanvasTextView.this.startAngleGesture - rotation;
                CanvasTextView.this.orthogonal = true;
            } else if (Math.abs(90.0f - ((rotation - CanvasTextView.this.startAngleGesture) + angle)) < 4.0f) {
                angle = (CanvasTextView.this.startAngleGesture + 90.0f) - rotation;
                CanvasTextView.this.orthogonal = true;
            } else if (Math.abs(180.0f - ((rotation - CanvasTextView.this.startAngleGesture) + angle)) < 4.0f) {
                angle = (180.0f + CanvasTextView.this.startAngleGesture) - rotation;
                CanvasTextView.this.orthogonal = true;
            } else if (Math.abs(-180.0f - ((rotation - CanvasTextView.this.startAngleGesture) + angle)) < 4.0f) {
                angle = (CanvasTextView.this.startAngleGesture - 0.024902344f) - rotation;
                CanvasTextView.this.orthogonal = true;
            } else if (Math.abs(-90.0f - ((rotation - CanvasTextView.this.startAngleGesture) + angle)) < 4.0f) {
                angle = (CanvasTextView.this.startAngleGesture - 0.049804688f) - rotation;
                CanvasTextView.this.orthogonal = true;
            } else {
                CanvasTextView.this.orthogonal = false;
            }
            CanvasTextView.this.pts[0] = CanvasTextView.this.rectText.centerX();
            CanvasTextView.this.pts[1] = CanvasTextView.this.rectText.centerY();
            CanvasTextView.this.textData.canvasMatrix.mapPoints(CanvasTextView.this.pts, CanvasTextView.this.pts);
            CanvasTextView.this.textData.canvasMatrix.postRotate(CanvasTextView.this.startAngleGesture - angle, CanvasTextView.this.pts[0], CanvasTextView.this.pts[1]);
            CanvasTextView.this.startAngleGesture = angle;
            CanvasTextView.this.invalidate();
        }
    }

    public void setSingleTapListener(SingleTap l) {
        this.singleTapListener = l;
    }

    public void setViewSelectedListener(ViewSelectedListener l) {
        this.viewSelectedListenerEx = l;
    }

    public void setTextAndStickerViewSelectedListener(TextAndStickerViewSelectedListener l) {
        this.textAndStickerViewSelectedListener = l;
    }

    public void setTextSelected(boolean selection) {
        this.viewSelected = selection;
        postInvalidate();
    }

    public BaseData getData() {
        return this.textData;
    }

    public CanvasTextView(Context context, TextData td, Bitmap removeBtm, Bitmap scaleBtm, Bitmap editBtm, Bitmap switchBtm, Bitmap blackBar) {
        super(context);
        this.mScaleDetector = new ScaleGestureDetector(context, new ScaleListener());
        this.mRotationDetector = new RotationGestureDetector(this.rotateListener);
        float textSize = context.getResources().getDimension(R.dimen.myFontSize);
        this.screenWidth = (float) getResources().getDisplayMetrics().widthPixels;
        this.screenHeight = (float) getResources().getDisplayMetrics().heightPixels;
        this.rectPaint = new Paint(1);
        this.rectPaint.setColor(2006555033);
        this.redPaint.setColor(-2140327);
        this.paintGreen.setColor(-1722294439);
        this.whitePaint.setColor(-1460137);
        this.bitmapPaint.setFilterBitmap(true);
        this.rectPaintOnTouch = new Paint(1);
        this.rectPaintOnTouch.setColor(2011028957);
        this.textBoundrect = new Rect();
        if (td == null) {
            this.textData = new TextData(textSize);
            this.textData.textPaint.getTextBounds(TextData.defaultMessage, 0, TextData.defaultMessage.length(), this.textBoundrect);
            this.textData.xPos = (this.screenWidth / 2.0f) - ((float) (this.textBoundrect.width() / 2));
            this.textData.yPos = this.screenHeight / 3.0f;
        } else {
            this.textData = td;
            if (this.textData.getFontPath() != null) {
                Typeface typeFace = FontCache.get(context, this.textData.getFontPath());
                if (typeFace != null) {
                    this.textData.textPaint.setTypeface(typeFace);
                }
            }
            this.textData.textPaint.getTextBounds(this.textData.message, 0, this.textData.message.length(), this.textBoundrect);
        }
        this.paddingWidth = this.screenWidth / 15.0f;
        this.paddingHeight = this.screenWidth / 14.0f;
        this.rectText = new RectF(this.textData.xPos - this.paddingWidth, (this.textData.yPos - ((float) this.textBoundrect.height())) - this.paddingHeight, (this.textData.xPos + ((float) this.textBoundrect.width())) + (2.0f * this.paddingWidth), this.textData.yPos + this.paddingHeight);
        this.gestureDetector = new GestureDetector(context, new GestureListener());
        float minDimen = Math.min(this.screenWidth, this.screenHeight);
        this.actualRadius = minDimen / 20.0f;
        this.circlePadding = this.actualRadius / 2.0f;
        if (this.actualRadius <= 5.0f) {
            this.actualRadius = this.paddingHeight;
        }
        this.removeBitmap = removeBtm;
        this.scaleBitmap = scaleBtm;
        this.editBitmap = editBtm;
        this.switchBitmap = switchBtm;
        this.blackBarBitmap = blackBar;
        this.bitmapWidth = (float) this.removeBitmap.getWidth();
        this.removeBitmapMatrix.reset();
        this.scaleBitmapMatrix.reset();
        this.scaleBitmapSwitch.reset();
        float bitmapScale = (2.0f * this.actualRadius) / this.bitmapWidth;
        this.removeBitmapMatrix.postScale(bitmapScale, bitmapScale);
        this.removeBitmapMatrix.postTranslate(this.rectText.left - ((this.bitmapWidth * bitmapScale) / 2.0f), this.rectText.top - ((this.bitmapWidth * bitmapScale) / 2.0f));
        this.scaleBitmapMatrix.postScale(bitmapScale, bitmapScale);
        this.scaleBitmapMatrix.postTranslate(this.rectText.right - ((this.bitmapWidth * bitmapScale) / 2.0f), this.rectText.bottom - ((this.bitmapWidth * bitmapScale) / 2.0f));
        this.scaleBitmapSwitch.postScale(bitmapScale, bitmapScale);
        this.scaleBitmapSwitch.postTranslate(this.rectText.right - ((this.bitmapWidth * bitmapScale) / 2.0f), this.rectText.top - ((this.bitmapWidth * bitmapScale) / 2.0f));
        this.scale = getScale();
        this.scaleBitmapMatrix.postScale(1.0f / this.scale, 1.0f / this.scale, this.rectText.right, this.rectText.bottom);
        this.removeBitmapMatrix.postScale(1.0f / this.scale, 1.0f / this.scale, this.rectText.left, this.rectText.top);
        this.scaleBitmapSwitch.postScale(1.0f / this.scale, 1.0f / this.scale, this.rectText.right, this.rectText.top);
        float rW = this.rectText.width();
        float rH = this.rectText.height();
        this.dashPaint.setColor(-7829368);
        this.dashPaint.setStyle(Style.STROKE);
        float strokeW = minDimen / 120.0f;
        if (strokeW <= 0.0f) {
            strokeW = 5.0f;
        }
        this.dashPaint.setStrokeWidth(strokeW);
        this.dashPaint.setPathEffect(new DashPathEffect(new float[]{strokeW, strokeW}, 0.0f));
        this.dashPathVertical = new Path();
        dashPathReset(rW, rH);
        initSnapText();
    }

    public TextData getTextData() {
        return this.textData;
    }

    public void lockView(boolean isLocked) {
        this.locked = isLocked;
    }

    void dashPathReset(float w, float h) {
        this.dashPathVertical.reset();
        this.dashPathVertical.moveTo(this.rectText.left + (w / 2.0f), this.rectText.top - (h / 5.0f));
        this.dashPathVertical.lineTo(this.rectText.left + (w / 2.0f), this.rectText.top + ((6.0f * h) / 5.0f));
        this.dashPathHorizontal = new Path();
        this.dashPathHorizontal.moveTo(this.rectText.left + ((-w) / 5.0f), this.rectText.top + (h / 2.0f));
        this.dashPathHorizontal.lineTo(this.rectText.left + ((6.0f * w) / 5.0f), this.rectText.top + (h / 2.0f));
    }

    public void setAlignment(int mode) {
        Align align = Align.LEFT;
        if (mode == 1) {
            align = Align.CENTER;
        }
        if (mode == 2) {
            align = Align.RIGHT;
        }
        this.textData.textPaint.setTextAlign(align);
        invalidate();
    }

    public boolean isDecorateViewSelected() {
        return this.viewSelected;
    }

    public void setDecorateViewSelected(boolean selection) {
        this.viewSelected = selection;
        invalidate();
    }

    public void setMatrix(MyMatrix matrix) {
        this.textData.canvasMatrix = matrix;
        this.scale = getScale();
    }

    public void onDraw(Canvas canvas) {
        resetRectPosition();
        if (this.textData.getSnapMode()) {
            drawSnap(canvas);
            return;
        }
        float bitmapScale = (this.actualRadius * 2.0f) / this.bitmapWidth;
        this.removeBitmapMatrix.reset();
        this.scaleBitmapMatrix.reset();
        this.scaleBitmapSwitch.reset();
        this.removeBitmapMatrix.postScale(bitmapScale, bitmapScale);
        this.removeBitmapMatrix.postTranslate(this.rectText.left - ((this.bitmapWidth * bitmapScale) / 2.0f), this.rectText.top - ((this.bitmapWidth * bitmapScale) / 2.0f));
        this.scaleBitmapMatrix.postScale(bitmapScale, bitmapScale);
        this.scaleBitmapMatrix.postTranslate(this.rectText.right - ((this.bitmapWidth * bitmapScale) / 2.0f), this.rectText.bottom - ((this.bitmapWidth * bitmapScale) / 2.0f));
        this.scaleBitmapSwitch.postScale(bitmapScale, bitmapScale);
        this.scaleBitmapSwitch.postTranslate(this.rectText.right - ((this.bitmapWidth * bitmapScale) / 2.0f), this.rectText.top - ((this.bitmapWidth * bitmapScale) / 2.0f));
        this.scale = getScale();
        this.scaleBitmapMatrix.postScale(1.0f / this.scale, 1.0f / this.scale, this.rectText.right, this.rectText.bottom);
        this.removeBitmapMatrix.postScale(1.0f / this.scale, 1.0f / this.scale, this.rectText.left, this.rectText.top);
        this.scaleBitmapSwitch.postScale(1.0f / this.scale, 1.0f / this.scale, this.rectText.right, this.rectText.top);
        canvas.setMatrix(this.textData.canvasMatrix);
        if (this.viewSelected) {
            if (this.isOnTouch) {
                canvas.drawRect(this.rectText, this.rectPaintOnTouch);
            } else {
                canvas.drawRect(this.rectText, this.rectPaint);
            }
            float rad = this.actualRadius / this.scale;
            canvas.drawCircle(this.rectText.right, this.rectText.bottom, rad, this.whitePaint);
            canvas.drawCircle(this.rectText.left, this.rectText.top, rad, this.redPaint);
            canvas.drawCircle(this.rectText.right, this.rectText.top, rad, this.paintGreen);
            canvas.drawBitmap(this.scaleBitmap, this.scaleBitmapMatrix, this.bitmapPaint);
            canvas.drawBitmap(this.removeBitmap, this.removeBitmapMatrix, this.bitmapPaint);
            canvas.drawBitmap(this.blackBarBitmap, this.scaleBitmapSwitch, this.bitmapPaint);
        }
        drawMultiline(canvas, this.textData.message, this.textData.xPos, this.textData.yPos, this.textData.textPaint, this.textData, this.lineBound, this.rectBg, this.paintBg);
        if (this.orthogonal) {
            canvas.drawPath(this.dashPathVertical, this.dashPaint);
            canvas.drawPath(this.dashPathHorizontal, this.dashPaint);
        }
    }

    void initSnapText() {
        setRectSnap(this.textData, this.rectSnap, this.screenWidth);
        paintSnap.setColor(-2030043136);
        if (this.textData.yPosSnap == 0.0f) {
            this.textData.yPosSnap = this.screenHeight / 2.0f;
        }
    }

    public static void setRectSnap(TextData textData, RectF rectSnap, float screenWidth) {
        float width = screenWidth;
        int height = getTextHeight(textData);
        float padding = getSnapRectPadding(textData);
        float yPos = textData.yPosSnap + ((float) (height / 2));
        rectSnap.set(0.0f, (yPos - ((float) height)) - padding, width, yPos + padding);
    }

    void drawSnap(Canvas canvas) {
        setRectSnap(this.textData, this.rectSnap, this.screenWidth);
        Canvas canvas2 = canvas;
        drawSnap(canvas2, this.textData, (this.screenWidth - ((float) getMaxLength(this.textData, this.lineBound, this.textData.message))) / 2.0f, ((getSnapRectPadding(this.textData) + this.rectSnap.top) + ((float) getTextHeight(this.textData))) - this.textData.textPaint.descent(), this.rectSnap, paintSnap, this.lineBound);
        if (this.viewSelected) {
            this.scale = getScale();
            float rad = this.actualRadius;
            float midX = this.rectSnap.left + (this.rectSnap.width() / 2.0f);
            float circleY = this.rectSnap.bottom + rad;
            float d0 = 3.0f * rad;
            float d2 = -3.0f * rad;
            float bitmapScale = (2.0f * this.actualRadius) / this.bitmapWidth;
            this.removeBtmSnapMatrix.reset();
            this.removeBtmSnapMatrix.postScale(bitmapScale, bitmapScale);
            this.removeBtmSnapMatrix.postTranslate((midX - d0) - ((this.bitmapWidth * bitmapScale) / 2.0f), circleY - ((this.bitmapWidth * bitmapScale) / 2.0f));
            this.editBtmScaleMatrix.reset();
            this.editBtmScaleMatrix.postScale(bitmapScale, bitmapScale);
            this.editBtmScaleMatrix.postTranslate((midX - 0.0f) - ((this.bitmapWidth * bitmapScale) / 2.0f), circleY - ((this.bitmapWidth * bitmapScale) / 2.0f));
            this.switchBtmScaleMatrix.reset();
            this.switchBtmScaleMatrix.postScale(bitmapScale, bitmapScale);
            this.switchBtmScaleMatrix.postTranslate((midX - d2) - ((this.bitmapWidth * bitmapScale) / 2.0f), circleY - ((this.bitmapWidth * bitmapScale) / 2.0f));
            canvas.drawCircle(midX - d0, circleY, rad, this.whitePaint);
            canvas.drawCircle(midX - 0.0f, circleY, rad, this.redPaint);
            canvas.drawCircle(midX - d2, circleY, rad, this.paintGreen);
            canvas.drawBitmap(this.removeBitmap, this.removeBtmSnapMatrix, this.bitmapPaint);
            canvas.drawBitmap(this.editBitmap, this.editBtmScaleMatrix, this.bitmapPaint);
            canvas.drawBitmap(this.switchBitmap, this.switchBtmScaleMatrix, this.bitmapPaint);
        }
    }

    int isInCircleSnap(float x, float y) {
        float rad = this.actualRadius;
        float touchrad = rad + this.circlePadding;
        float midX = this.rectSnap.left + (this.rectSnap.width() / 2.0f);
        float circleY = this.rectSnap.bottom + rad;
        float d0 = 3.0f * rad;
        float d2 = -3.0f * rad;
        if (((x - (midX - d0)) * (x - (midX - d0))) + ((y - circleY) * (y - circleY)) < touchrad * touchrad) {
            this.viewSelected = true;
            return SNAP_CIRCLE_0;
        } else if (((x - (midX - 0.0f)) * (x - (midX - 0.0f))) + ((y - circleY) * (y - circleY)) < touchrad * touchrad) {
            this.viewSelected = true;
            return SNAP_CIRCLE_1;
        } else if (((x - (midX - d2)) * (x - (midX - d2))) + ((y - circleY) * (y - circleY)) >= touchrad * touchrad) {
            return SNAP_CIRCLE_NONE;
        } else {
            this.viewSelected = true;
            return SNAP_CIRCLE_2;
        }
    }

    public static float getSnapRectPadding(TextData textData) {
        return ((-textData.textPaint.ascent()) + textData.textPaint.descent()) / 4.7f;
    }

    public static void drawSnap(Canvas canvas, TextData textData, float xPos, float yPos, RectF rectSnap, Paint paintSnap, Rect lineBound) {
        canvas.drawRect(rectSnap, paintSnap);
        drawMultiline(canvas, textData.message, xPos, yPos, textData.textPaint, textData, lineBound, null, null);
    }

    public static int getTextHeight(TextData textData) {
        int height = 0;
        for (String line : textData.message.split("\n")) {
            height = (int) (((float) height) + ((-textData.textPaint.ascent()) + textData.textPaint.descent()));
        }
        return height;
    }

    int getTextHeight23() {
        int height = 0;
        Rect bounds = new Rect();
        for (String line : this.textData.message.split("\n")) {
            this.textData.textPaint.getTextBounds(line, 0, line.length(), bounds);
            height += bounds.height();
        }
        return height;
    }

    float resetRectPosition() {
        this.paintBg.setColor(this.textData.getBackgroundColorFinal());
        getHeightAndMaxLength(this.textData, this.lineBound, this.res);
        float maxLength = this.res.x;
        float height = this.res.y;
        this.paddingWidth = this.screenWidth / 15.0f;
        this.paddingHeight = this.screenWidth / 14.0f;
        this.rectText.set(this.textData.xPos - this.paddingWidth, ((this.textData.yPos - ((float) this.textBoundrect.height())) - this.paddingHeight) + height, (this.textData.xPos + maxLength) + this.paddingWidth, this.textData.yPos + this.paddingHeight);
        this.paddingWidth = this.screenWidth / 30.0f;
        this.paddingHeight = this.screenWidth / 30.0f;
        this.rectBg.set(this.textData.xPos - this.paddingWidth, ((this.textData.yPos - ((float) this.textBoundrect.height())) - this.paddingHeight) + height, (this.textData.xPos + maxLength) + this.paddingWidth, (this.textData.yPos + this.paddingHeight) + this.textData.textPaint.descent());
        dashPathReset(this.rectText.width(), this.rectText.height());
        return -height;
    }

    static void getHeightAndMaxLength(TextData textData, Rect lineBound, PointF res) {
        float maxLength = 0.0f;
        float height = 0.0f;
        for (String line : textData.message.split("\n")) {
            height -= (-textData.textPaint.ascent()) + textData.textPaint.descent();
            textData.textPaint.getTextBounds(line, 0, line.length(), lineBound);
            if (((float) lineBound.width()) > maxLength) {
                maxLength = (float) (lineBound.width() + (lineBound.left * 2));
            }
        }
        res.set(maxLength, height + ((-textData.textPaint.ascent()) + textData.textPaint.descent()));
    }

    public static void setBgRect(TextData textData, RectF rrr, Rect lineBound, Rect textBoundrect, float screenWidth) {
        PointF res = new PointF();
        getHeightAndMaxLength(textData, lineBound, res);
        float maxLength = res.x;
        float height = res.y;
        float paddingWidth = screenWidth / 30.0f;
        float paddingHeight = screenWidth / 30.0f;
        float bottomPaddingExtra = textData.textPaint.descent();
        textData.textPaint.getTextBounds(textData.message, 0, textData.message.length(), textBoundrect);
        rrr.set(textData.xPos - paddingWidth, ((textData.yPos - ((float) textBoundrect.height())) - paddingHeight) + height, (textData.xPos + maxLength) + paddingWidth, (textData.yPos + paddingHeight) + bottomPaddingExtra);
    }

    public static void drawMultiline(Canvas canvas, String str, float x, float y, Paint paint, TextData textData, Rect lineBound, RectF rectBg, Paint paintBg) {
        float myX = x;
        float myY = y;
        int maxLength = 0;
        for (String line : str.split("\n")) {
            myY -= (-paint.ascent()) + paint.descent();
            textData.textPaint.getTextBounds(line, 0, line.length(), lineBound);
            if (lineBound.width() > maxLength) {
                maxLength = lineBound.width();
            }
        }
        myY += (-paint.ascent()) + paint.descent();
        Align align = textData.textPaint.getTextAlign();
        if (align == Align.RIGHT) {
            myX += (float) maxLength;
        }
        if (align == Align.CENTER) {
            myX += (float) (maxLength / 2);
        }
        if (!(rectBg == null || paintBg == null)) {
            canvas.drawRect(rectBg, paintBg);
        }
        for (String line2 : str.split("\n")) {
            canvas.drawText(line2, myX, myY, paint);
            myY += (-paint.ascent()) + paint.descent();
        }
    }

    public static int getMaxLength(TextData textData, Rect lineBound, String str) {
        int maxLength = 0;
        for (String line : str.split("\n")) {
            textData.textPaint.getTextBounds(line, 0, line.length(), lineBound);
            if (lineBound.width() > maxLength) {
                maxLength = lineBound.width();
            }
        }
        return maxLength;
    }

    void checkMatrix() {
        this.textData.canvasMatrix.getValues(this.values);
        if (getScale() < 0.5f) {
            this.textData.canvasMatrix.postScale(0.5f, 0.5f, this.pts[0], this.pts[1]);
        }
    }

    void singleTapped() {
        if (this.singleTapListener != null) {
            this.singleTapListener.onSingleTap(this.textData);
        }
    }

    void setTextColor(int color) {
        this.textData.textPaint.setColor(color);
        postInvalidate();
    }

    public void setMessage(CharSequence newMessage) {
        if (newMessage.length() == 0) {
            this.textData.message = TextData.defaultMessage;
        } else {
            this.textData.message = newMessage.toString();
        }
        float exRight = this.rectText.right;
        this.rectText.right = (this.rectText.left + this.textData.textPaint.measureText(this.textData.message)) + (2.0f * this.paddingWidth);
        this.scaleBitmapMatrix.postTranslate(this.rectText.right - exRight, 0.0f);
        this.scaleBitmapSwitch.postTranslate(this.rectText.right - exRight, 0.0f);
        postInvalidate();
    }

    public void setNewTextData(TextData textData) {
        this.textData = textData;
        float exRight = this.rectText.right;
        this.rectText.right = (this.rectText.left + textData.textPaint.measureText(textData.message)) + (2.0f * this.paddingWidth);
        this.scaleBitmapMatrix.postTranslate(this.rectText.right - exRight, 0.0f);
        this.scaleBitmapSwitch.postTranslate(this.rectText.right - exRight, 0.0f);
        postInvalidate();
    }

    public boolean isOnRectCheck(float x, float y) {
        if (x <= this.rectText.left || x >= this.rectText.right || y <= this.rectText.top || y >= this.rectText.bottom) {
            return false;
        }
        this.viewSelected = true;
        return true;
    }

    boolean isInCircle(float x, float y) {
        if (((x - this.rectText.right) * (x - this.rectText.right)) + ((y - this.rectText.bottom) * (y - this.rectText.bottom)) >= ((this.actualRadius + this.circlePadding) * (this.actualRadius + this.circlePadding)) / (this.scale * this.scale)) {
            return false;
        }
        this.viewSelected = true;
        return true;
    }

    boolean isInSecondCircle(float x, float y) {
        if (((x - this.rectText.right) * (x - this.rectText.right)) + ((y - this.rectText.top) * (y - this.rectText.top)) >= ((this.actualRadius + this.circlePadding) * (this.actualRadius + this.circlePadding)) / (this.scale * this.scale)) {
            return false;
        }
        this.viewSelected = true;
        return true;
    }

    boolean isOnCross(float x, float y) {
        if (((x - this.rectText.left) * (x - this.rectText.left)) + ((y - this.rectText.top) * (y - this.rectText.top)) >= ((this.actualRadius + this.circlePadding) * (this.actualRadius + this.circlePadding)) / (this.scale * this.scale)) {
            return false;
        }
        this.viewSelected = true;
        return true;
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (this.locked) {
            return false;
        }
        float x = event.getX();
        float y = event.getY();
        if (this.textData.getSnapMode()) {
            switch (event.getAction() & 255) {
                case 0:
                    this.downModeSnap = true;
                    int circleMode = SNAP_CIRCLE_NONE;
                    if (this.viewSelected) {
                        circleMode = isInCircleSnap(x, y);
                        if (circleMode == SNAP_CIRCLE_0) {
                            createDeleteDialog(getContext(), this);
                            return true;
                        } else if (circleMode == SNAP_CIRCLE_1) {
                            singleTapped();
                            return true;
                        } else if (circleMode == SNAP_CIRCLE_2) {
                            this.textData.setSnapMode(false);
                            invalidate();
                            return true;
                        }
                    }
                    boolean isOnSnapRect = x > this.rectSnap.left && x < this.rectSnap.right && y > this.rectSnap.top && y < this.rectSnap.bottom;
                    if (isOnSnapRect) {
                        this.onRectSnap = true;
                        this.viewSelected = true;
                    }
                    this.previousY = y;
                    this.previousYSnap = this.textData.yPosSnap;
                    if ((isOnSnapRect || circleMode != SNAP_CIRCLE_NONE) && this.textAndStickerViewSelectedListener != null) {
                        this.textAndStickerViewSelectedListener.setSelectedView(this);
                        break;
                    }
                    break;
                case 1:
                    this.onRectSnap = false;
                    if (this.onDecorateViewTouchUpListener != null) {
                        this.onDecorateViewTouchUpListener.onTouchUp(this.textData);
                        break;
                    }
                    break;
                case 2:
                    if (this.downModeSnap && this.onRectSnap) {
                        this.textData.yPosSnap = (this.previousYSnap + y) - this.previousY;
                        break;
                    }
            }
            invalidate();
            return this.gestureDetector.onTouchEvent(event);
        }
        this.mScaleDetector.onTouchEvent(event);
        this.mRotationDetector.onTouchEvent(event);
        int pointerIndex;
        switch (event.getAction() & 255) {
            case 0:
                this.isOnRect = false;
                this.isInCircle = false;
                this.downModeSnap = false;
                this.isOnTouch = true;
                this.savedViewSelected = this.viewSelected;
                this.pts[0] = x;
                this.pts[1] = y;
                this.textData.canvasMatrix.invert(this.inverse);
                this.inverse.mapPoints(this.pts, this.pts);
                if (this.viewSelected) {
                    if (isOnCross(this.pts[0], this.pts[1])) {
                        createDeleteDialog(getContext(), this);
                        return true;
                    }
                    if (isInSecondCircle(this.pts[0], this.pts[1])) {
                        this.textData.setSnapMode(true);
                        invalidate();
                        return true;
                    }
                }
                this.isOnRect = isOnRectCheck(this.pts[0], this.pts[1]);
                this.isInCircle = isInCircle(this.pts[0], this.pts[1]);
                this.previosPos.set(x, y);
                this.zoomStart.set(x, y);
                this.pts[0] = this.rectText.centerX();
                this.pts[1] = this.rectText.centerY();
                this.textData.canvasMatrix.mapPoints(this.pts, this.pts);
                this.startAngle = (float) (-StickerView.pointToAngle(x, y, this.pts[0], this.pts[1]));
                if ((this.isInCircle || this.isOnRect) && this.textAndStickerViewSelectedListener != null) {
                    this.textAndStickerViewSelectedListener.setSelectedView(this);
                }
                this.mActivePointerId = event.getPointerId(0);
                if (!this.savedViewSelected) {
                    this.doubleTouchCall = true;
                    return this.savedViewSelected;
                }
                break;
            case 1:
                new Handler().postDelayed(new C05831(), 100);
                this.startAngleGesture = 0.0f;
                this.orthogonal = false;
                this.isOnTouch = false;
                this.isOnRect = false;
                if (this.onDecorateViewTouchUpListener != null) {
                    this.onDecorateViewTouchUpListener.onTouchUp(this.textData);
                }
                this.mActivePointerId = -1;
                break;
            case 2:
                if (!this.downModeSnap) {
                    if (!this.isInCircle) {
                        if (this.isOnRect) {
                            pointerIndex = event.findPointerIndex(this.mActivePointerId);
                            if (pointerIndex >= 0 && pointerIndex < event.getPointerCount()) {
                                float mx = event.getX(pointerIndex);
                                float my = event.getY(pointerIndex);
                                this.textData.canvasMatrix.postTranslate(mx - this.previosPos.x, my - this.previosPos.y);
                                this.previosPos.set(mx, my);
                                break;
                            }
                        }
                    }
                    float currentAngle = (float) (-StickerView.pointToAngle(x, y, this.pts[0], this.pts[1]));
                    float rotation = getMatrixRotation(this.textData.canvasMatrix);
                    if ((rotation == 0.0f || rotation == 90.0f || rotation == 180.0f || rotation == -180.0f || rotation == -90.0f) && Math.abs(this.startAngle - currentAngle) < 4.0f) {
                        this.orthogonal = true;
                    } else {
                        if (Math.abs((rotation - this.startAngle) + currentAngle) < 4.0f) {
                            currentAngle = this.startAngle - rotation;
                            this.orthogonal = true;
                            Log.d(TAG, "aaaaa " + Float.toString(rotation));
                        } else if (Math.abs(90.0f - ((rotation - this.startAngle) + currentAngle)) < 4.0f) {
                            currentAngle = (90.0f + this.startAngle) - rotation;
                            this.orthogonal = true;
                            Log.d(TAG, "bbbbb " + Float.toString(rotation));
                        } else if (Math.abs(180.0f - ((rotation - this.startAngle) + currentAngle)) < 4.0f) {
                            currentAngle = (180.0f + this.startAngle) - rotation;
                            this.orthogonal = true;
                            Log.d(TAG, "cccc " + Float.toString(rotation));
                        } else if (Math.abs(-180.0f - ((rotation - this.startAngle) + currentAngle)) < 4.0f) {
                            currentAngle = (-180.0f + this.startAngle) - rotation;
                            this.orthogonal = true;
                        } else if (Math.abs(-90.0f - ((rotation - this.startAngle) + currentAngle)) < 4.0f) {
                            currentAngle = (-90.0f + this.startAngle) - rotation;
                            this.orthogonal = true;
                            Log.d(TAG, "dddd " + Float.toString(rotation));
                        } else {
                            this.orthogonal = false;
                        }
                        this.textData.canvasMatrix.postRotate(this.startAngle - currentAngle, this.pts[0], this.pts[1]);
                        this.startAngle = currentAngle;
                    }
                    float scaley = ((float) Math.sqrt((double) (((x - this.pts[0]) * (x - this.pts[0])) + ((y - this.pts[1]) * (y - this.pts[1]))))) / ((float) Math.sqrt((double) (((this.zoomStart.x - this.pts[0]) * (this.zoomStart.x - this.pts[0])) + ((this.zoomStart.y - this.pts[1]) * (this.zoomStart.y - this.pts[1])))));
                    this.scale = getScale();
                    if (this.scale >= MIN_ZOOM || (this.scale < MIN_ZOOM && scaley > 1.0f)) {
                        this.textData.canvasMatrix.postScale(scaley, scaley, this.pts[0], this.pts[1]);
                        this.zoomStart.set(x, y);
                        this.scale = getScale();
                        this.scaleBitmapMatrix.postScale(1.0f / scaley, 1.0f / scaley, this.rectText.right, this.rectText.bottom);
                        this.removeBitmapMatrix.postScale(1.0f / scaley, 1.0f / scaley, this.rectText.left, this.rectText.top);
                        this.scaleBitmapSwitch.postScale(1.0f / scaley, 1.0f / scaley, this.rectText.right, this.rectText.top);
                        break;
                    }
                }
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
        postInvalidate();
        boolean returnValue = this.gestureDetector.onTouchEvent(event);
        postInvalidate();
        return returnValue;
    }

    float getScale() {
        this.textData.canvasMatrix.getValues(this.values);
        float scalex = this.values[0];
        float skewy = this.values[3];
        return (float) Math.sqrt((double) ((scalex * scalex) + (skewy * skewy)));
    }

    float getMatrixRotation(Matrix matrix) {
        matrix.getValues(this.f1373v);
        return (float) Math.round(Math.atan2((double) this.f1373v[1], (double) this.f1373v[0]) * 57.29577951308232d);
    }

    public float containsScore(float xx, float yy) {
        if (this.textData.getSnapMode()) {
            return (float) -2;
        }
        this.pts[0] = xx;
        this.pts[1] = yy;
        this.textData.canvasMatrix.invert(this.inverse);
        this.inverse.mapPoints(this.pts, this.pts);
        float x = this.pts[0];
        float y = this.pts[1];
        RectF maskRect = this.rectText;
        if (x >= maskRect.left && x <= maskRect.right && y >= maskRect.top && y <= maskRect.bottom) {
            float contain = ((x - maskRect.centerX()) * (x - maskRect.centerX())) + ((y - maskRect.centerY()) * (y - maskRect.centerY()));
            float hypotenus = (maskRect.width() * maskRect.width()) + (maskRect.height() * maskRect.height());
            if (contain > 0.0f) {
                return hypotenus / contain;
            }
        }
        return (float) -2;
    }
}
