package com.lyrebirdstudio.tiltshift;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.view.MotionEvent;
import android.view.View;

import com.lyrebirdstudio.tiltshift.TiltContext.TiltMode;

public class TiltHelper {
    private static final int DRAG = 1;
    private static final int NONE = 0;
    private static final String TAG = TiltHelper.class.getSimpleName();
    private static final int ZOOM = 2;
    static float blurBitmapScale = 2.5f;
    int alpha = 230;
    int animAlphaMultiplier;
    int animEpsilon = 8;
    int animHalfTime = ((this.animationLimit / 2) + 1);
    boolean animate = false;
    int animationCount = 0;
    int animationDuration = 1500;
    int animationDurationLimit = 50;
    int animationLimit = 51;
    private Runnable animator = new C06681();
    Bitmap bitmapBlur;
    TiltContext currentTiltContext;
    float f877d;
    int frameDuration = 12;
    int f878h;
    float[] lastEvent = new float[4];
    Matrix matrixBlur = new Matrix();
    private PointF mid = new PointF();
    private int mode = 0;
    float newRot;
    float oldDist = 1.0f;
    boolean onTouch = false;
    Paint paintAnimate = new Paint(1);
    Paint paintGradient = new Paint(1);
    Paint paintGradientTouch = new Paint(1);
    Paint paintNormal = new Paint(1);
    Paint paintWHite = new Paint(1);
    Matrix savedMatrix = new Matrix();
    private PointF start = new PointF();
    long startTime = System.nanoTime();
    TiltContext tiltContextLinear;
    TiltContext tiltContextNone;
    TiltContext tiltContextRadial;
    Paint tiltPaint;
    View tiltView;
    int f879w;

    class C06681 implements Runnable {
        C06681() {
        }

        public void run() {
            boolean scheduleNewFrame = false;
            int iter = ((int) (((float) (System.nanoTime() - TiltHelper.this.startTime)) / 1000000.0f)) / TiltHelper.this.animationDurationLimit;
            if (iter <= 0) {
                iter = 1;
            }
            if (TiltHelper.this.animationCount == 0) {
                TiltHelper tiltHelper = TiltHelper.this;
                tiltHelper.animationCount++;
            } else {
                TiltHelper.this.animationCount += iter;
            }
            int animAlphaLocal = TiltHelper.this.animAlpha(TiltHelper.this.animationCount);
            TiltHelper.this.paintAnimate.setAlpha(animAlphaLocal);
            if (TiltHelper.this.animationCount < TiltHelper.this.animationLimit) {
                scheduleNewFrame = true;
            } else {
                TiltHelper.this.animate = false;
            }
            if (scheduleNewFrame) {
                TiltHelper.this.tiltView.postDelayed(this, (long) TiltHelper.this.frameDuration);
            }
            if (animAlphaLocal != TiltHelper.this.alpha) {
                TiltHelper.this.tiltView.invalidate();
            }
            TiltHelper.this.startTime = System.nanoTime();
        }
    }

    public TiltHelper(View view, Bitmap btmBlur, TiltContext tc, int w, int h) {
        this.tiltView = view;
        this.bitmapBlur = btmBlur;
        this.f879w = w;
        this.f878h = h;
        this.paintGradient.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        this.paintGradientTouch.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        this.paintNormal.setColor(-1);
        this.paintWHite.setColor(Color.WHITE);
        this.paintAnimate.setColor(-536870913);
        this.paintNormal.setFilterBitmap(true);
        this.tiltContextLinear = new TiltContext(TiltMode.LINEAR, w, h);
        this.tiltContextRadial = new TiltContext(TiltMode.RADIAL, w, h);
        this.tiltContextNone = new TiltContext(TiltMode.NONE, w, h);
        if (tc != null) {
            this.currentTiltContext = tc;
            if (tc.mode == TiltMode.LINEAR) {
                this.tiltContextLinear = tc;
            } else if (tc.mode == TiltMode.RADIAL) {
                this.tiltContextRadial = tc;
            }
        } else {
            this.currentTiltContext = this.tiltContextLinear;
        }
        this.paintGradient.setShader(this.currentTiltContext.gradient);
        this.paintGradientTouch.setShader(this.currentTiltContext.gradientTouch);
        this.matrixBlur.reset();
        this.matrixBlur.postScale(blurBitmapScale, blurBitmapScale);
    }

    public TiltContext getCurrentTiltContext() {
        return this.currentTiltContext;
    }

    public void setTiltMode(TiltMode mode) {
        if (mode == TiltMode.LINEAR) {
            this.currentTiltContext = this.tiltContextLinear;
            startAnimator();
        } else if (mode == TiltMode.RADIAL) {
            this.currentTiltContext = this.tiltContextRadial;
            startAnimator();
        } else if (mode == TiltMode.NONE) {
            this.currentTiltContext = this.tiltContextNone;
        }
        this.paintGradient.setShader(this.currentTiltContext.gradient);
        this.paintGradientTouch.setShader(this.currentTiltContext.gradientTouch);
        this.tiltView.postInvalidate();
    }

    public void drawTiltShift(Canvas canvas, Bitmap blurBtm, int btmW, int btmH) {
        if (this.currentTiltContext.mode != TiltMode.NONE) {
            int i = canvas.saveLayer(0.0f, 0.0f, (float) btmW, (float) btmH, this.paintNormal, 31);
            if (!(this.onTouch || blurBtm == null || blurBtm.isRecycled())) {
                canvas.drawBitmap(blurBtm, this.matrixBlur, this.paintNormal);
            }
            if (this.onTouch) {
                canvas.drawRect(0.0f, 0.0f, (float) btmW, (float) btmH, this.paintWHite);
            } else if (this.animate) {
                canvas.drawRect(0.0f, 0.0f, (float) btmW, (float) btmH, this.paintAnimate);
            }
            if (this.onTouch || this.animate) {
                canvas.drawRect(0.0f, 0.0f, (float) btmW, (float) btmH, this.paintGradientTouch);
            } else {
                canvas.drawRect(0.0f, 0.0f, (float) btmW, (float) btmH, this.paintGradient);
            }
            canvas.restoreToCount(i);
        }
    }

    public static void drawTiltShift2(Canvas canvas, Bitmap blurBtm, int btmW, int btmH, TiltContext tiltContext) {
        if (tiltContext.mode != TiltMode.NONE) {
            Paint p = new Paint(1);
            p.setFilterBitmap(true);
            int i = canvas.saveLayer(0.0f, 0.0f, (float) btmW, (float) btmH, p, 31);
            Matrix m = new Matrix();
            m.postScale(blurBitmapScale, blurBitmapScale);
            canvas.drawBitmap(blurBtm, m, p);
            Paint pG = new Paint(1);
            pG.setShader(pG.setShader(tiltContext.gradient));
            pG.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
            canvas.drawRect(0.0f, 0.0f, (float) btmW, (float) btmH, pG);
            canvas.restoreToCount(i);
        }
    }

    public void startAnimator() {
        this.animationCount = 0;
        this.animAlphaMultiplier = this.alpha / (this.animHalfTime - this.animEpsilon);
        this.animate = true;
        this.tiltView.removeCallbacks(this.animator);
        this.tiltView.post(this.animator);
    }

    int animAlpha(int value) {
        if (value == (this.animHalfTime - this.animEpsilon) - 1) {
            return this.alpha;
        }
        if (value < this.animHalfTime - this.animEpsilon) {
            return value * this.animAlphaMultiplier;
        }
        if (value > this.animHalfTime + this.animEpsilon) {
            return (this.animationLimit - value) * this.animAlphaMultiplier;
        }
        return this.alpha;
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (this.currentTiltContext.mode == TiltMode.NONE) {
            return false;
        }
        switch (event.getAction() & 255) {
            case 0:
                this.onTouch = true;
                this.savedMatrix.set(this.currentTiltContext.matrix);
                this.start.set(event.getX(), event.getY());
                this.mode = 1;
                this.lastEvent = null;
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.onTouch = false;
                this.lastEvent = null;
                break;
            case 2:
                if (this.mode != 1) {
                    if (this.mode == 2 && event.getPointerCount() == 2) {
                        float newDist = spacing(event);
                        this.currentTiltContext.matrix.set(this.savedMatrix);
                        if (newDist > 10.0f) {
                            float scale = newDist / this.oldDist;
                            this.currentTiltContext.matrix.postScale(scale, scale, this.mid.x, this.mid.y);
                        }
                        if (this.lastEvent != null) {
                            this.newRot = rotation(event);
                            this.currentTiltContext.matrix.postRotate(this.newRot - this.f877d, (float) (this.f879w / 2), (float) (this.f878h / 2));
                            break;
                        }
                    }
                }
                this.currentTiltContext.matrix.set(this.savedMatrix);
                this.currentTiltContext.matrix.postTranslate(event.getX() - this.start.x, event.getY() - this.start.y);
                break;

            case 5:
                this.oldDist = spacing(event);
                if (this.oldDist > 10.0f) {
                    this.savedMatrix.set(this.currentTiltContext.matrix);
                    midPoint(this.mid, event);
                    this.mode = 2;
                }
                this.lastEvent = new float[4];
                this.lastEvent[0] = event.getX(0);
                this.lastEvent[1] = event.getX(1);
                this.lastEvent[2] = event.getY(0);
                this.lastEvent[3] = event.getY(1);
                this.f877d = rotation(event);
                break;
        }
        this.currentTiltContext.setLocalMatrix();
        this.paintGradient.setShader(this.currentTiltContext.gradient);
        this.paintGradientTouch.setShader(this.currentTiltContext.gradientTouch);
        this.tiltView.postInvalidate();
        return true;
    }

    private float rotation(MotionEvent event) {
        return (float) Math.toDegrees(Math.atan2((double) (event.getY(0) - event.getY(1)), (double) (event.getX(0) - event.getX(1))));
    }

    private float spacing(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float) Math.sqrt((double) ((x * x) + (y * y)));
    }

    private void midPoint(PointF point, MotionEvent event) {
        point.set((event.getX(0) + event.getX(1)) / 2.0f, (event.getY(0) + event.getY(1)) / 2.0f);
    }
}
