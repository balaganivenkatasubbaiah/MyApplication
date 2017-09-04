package com.lyrebirdstudio.promodialog;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;

public class PromoMirrorView extends View {
    private static final String TAG = "PromoMirror";
    static final String urlDefault = "market://details?id=com.lyrebirdstudio.mirror";
    final Matrix f872I = new Matrix();
    float animDelta = 2.0f;
    int animDirection = 1;
    int animHalfTime = ((this.animationLimit / 2) + 1);
    boolean animate = false;
    int animationCount = 0;
    int animationLimit = 291;
    private Runnable animator = new C06431();
    int currentModeIndex = 0;
    Bitmap d3Bitmap;
    boolean d3Mode = false;
    int defaultColor = -5592406;
    RectF destRect1;
    RectF destRect1X;
    RectF destRect1Y;
    RectF destRect2;
    RectF destRect2X;
    RectF destRect2Y;
    RectF destRect3;
    RectF destRect4;
    float distance;
    boolean drawSavedImage = false;
    RectF dstRectPaper1;
    RectF dstRectPaper2;
    RectF dstRectPaper3;
    RectF dstRectPaper4;
    int frameDuration = 15;
    Paint framePaint = new Paint();
    int height;
    float initialYPos = 0.0f;
    boolean isMarketCalled = false;
    boolean isTouchStartedLeft;
    boolean isTouchStartedTop;
    boolean isVerticle = false;
    Matrix m1 = new Matrix();
    Matrix m2 = new Matrix();
    Matrix m3 = new Matrix();
    String marketUrl = urlDefault;
    Matrix matrixMirror1 = new Matrix();
    Matrix matrixMirror2 = new Matrix();
    Matrix matrixMirror3 = new Matrix();
    Matrix matrixMirror4 = new Matrix();
    PromoMirrorMode[] mirrorModeList = new PromoMirrorMode[20];
    PromoMirrorMode modeX;
    PromoMirrorMode modeX10;
    PromoMirrorMode modeX11;
    PromoMirrorMode modeX12;
    PromoMirrorMode modeX13;
    PromoMirrorMode modeX14;
    PromoMirrorMode modeX15;
    PromoMirrorMode modeX16;
    PromoMirrorMode modeX17;
    PromoMirrorMode modeX18;
    PromoMirrorMode modeX19;
    PromoMirrorMode modeX2;
    PromoMirrorMode modeX20;
    PromoMirrorMode modeX3;
    PromoMirrorMode modeX4;
    PromoMirrorMode modeX5;
    PromoMirrorMode modeX6;
    PromoMirrorMode modeX7;
    PromoMirrorMode modeX8;
    PromoMirrorMode modeX9;
    float mulX = 1.0f;
    float mulY = 1.0f;
    float oldX;
    float oldY;
    int screenHeightPixels;
    int screenWidthPixels;
    Bitmap sourceBitmap;
    RectF srcRect1;
    RectF srcRect2;
    RectF srcRect3;
    RectF srcRectPaper;
    int tMode1;
    int tMode2;
    int tMode3;
    Matrix textMatrix = new Matrix();
    Paint textRectPaint = new Paint(1);
    RectF totalArea1;
    RectF totalArea2;
    RectF totalArea3;
    int touchCountForMarket = 0;
    int width;

    class C06431 implements Runnable {
        C06431() {
        }

        public void run() {
            boolean scheduleNewFrame = false;
            PromoMirrorView promoMirrorView = PromoMirrorView.this;
            promoMirrorView.animationCount++;
            float animD = PromoMirrorView.this.animDelta * ((float) PromoMirrorView.this.animDirection);
            RectF srcRect = PromoMirrorView.this.mirrorModeList[PromoMirrorView.this.currentModeIndex].getSrcRect();
            if (srcRect.width() < ((float) PromoMirrorView.this.width)) {
                if (srcRect.right + animD >= ((float) PromoMirrorView.this.width)) {
                    PromoMirrorView.this.animDirection = -1;
                }
                if (srcRect.left + animD <= 0.0f) {
                    PromoMirrorView.this.animDirection = 1;
                }
            } else {
                if (srcRect.bottom + animD > ((float) PromoMirrorView.this.height)) {
                    PromoMirrorView.this.animDirection = -1;
                }
                if (srcRect.top + animD <= 0.0f) {
                    PromoMirrorView.this.animDirection = 1;
                }
            }
            PromoMirrorView.this.moveGrid(srcRect, animD, animD);
            PromoMirrorView.this.mirrorModeList[PromoMirrorView.this.currentModeIndex].updateBitmapSrc();
            if (PromoMirrorView.this.animationCount < PromoMirrorView.this.animationLimit) {
                scheduleNewFrame = true;
            } else {
                PromoMirrorView.this.animate = false;
            }
            if (scheduleNewFrame) {
                PromoMirrorView.this.postDelayed(this, (long) PromoMirrorView.this.frameDuration);
            }
            PromoMirrorView.this.postInvalidate();
        }
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        if (width > height) {
            size = height;
        } else {
            size = width;
        }
        if (size <= 0) {
            size = Math.min(this.screenWidthPixels, this.screenHeightPixels);
        }
        if (width <= 0) {
            width = this.screenWidthPixels;
        }
        if (height <= 0) {
            height = this.screenHeightPixels;
        }
        if (height > width) {
            height = width;
        }
        setMeasuredDimension(width, height);
        Log.e(TAG, "onMeasure " + size);
    }

    public void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.e(TAG, "initialYPos " + this.initialYPos);
        int w = r - l;
        int h = b - t;
        this.mulX = 1.0f;
        this.mulY = ((float) h) / ((float) w);
        reset(w, h, true);
        float scaleBtm = ((float) this.width) / ((float) this.height);
        float scaleView = ((float) w) / (1.33f * ((float) h));
        if (scaleBtm < scaleView) {
            setCurrentMode(2);
        }
        Log.e(TAG, "scaleView " + scaleView);
        Log.e(TAG, "scaleBtm " + scaleBtm);
        super.onLayout(changed, l, t, r, b);
    }

    public PromoMirrorView(Context context, int screenWidth, int screenHeight, Bitmap btm, String packageName) {
        super(context);
        this.sourceBitmap = btm;
        this.screenHeightPixels = screenWidth;
        this.screenWidthPixels = screenWidth;
        this.width = this.sourceBitmap.getWidth();
        this.height = this.sourceBitmap.getHeight();
        int widthPixels = screenWidth;
        int heightPixels = screenWidth;
        createMatrix(widthPixels, heightPixels);
        createRectX(widthPixels, heightPixels);
        createRectY(widthPixels, heightPixels);
        createRectXY(widthPixels, heightPixels);
        createModes();
        this.framePaint.setAntiAlias(true);
        this.framePaint.setFilterBitmap(true);
        this.framePaint.setDither(true);
        this.textRectPaint.setColor(this.defaultColor);
        if (packageName != null) {
            this.marketUrl = "market://details?id=" + packageName;
        }
    }

    private void reset(int widthPixels, int heightPixels, boolean invalidate) {
        createMatrix(widthPixels, heightPixels);
        createRectX(widthPixels, heightPixels);
        createRectY(widthPixels, heightPixels);
        createRectXY(widthPixels, heightPixels);
        createModes();
        if (invalidate) {
            postInvalidate();
        }
    }

    private void setCurrentMode(int index) {
        this.currentModeIndex = index;
    }

    public PromoMirrorMode getCurrentMirrorMode() {
        return this.mirrorModeList[this.currentModeIndex];
    }

    private void createModes() {
        this.modeX = new PromoMirrorMode(4, this.srcRect3, this.destRect1, this.destRect1, this.destRect3, this.destRect3, this.matrixMirror1, this.f872I, this.matrixMirror1, this.tMode3, this.totalArea3);
        this.modeX2 = new PromoMirrorMode(4, this.srcRect3, this.destRect1, this.destRect4, this.destRect1, this.destRect4, this.matrixMirror1, this.matrixMirror1, this.f872I, this.tMode3, this.totalArea3);
        this.modeX3 = new PromoMirrorMode(4, this.srcRect3, this.destRect3, this.destRect2, this.destRect3, this.destRect2, this.matrixMirror1, this.matrixMirror1, this.f872I, this.tMode3, this.totalArea3);
        this.modeX8 = new PromoMirrorMode(4, this.srcRect3, this.destRect1, this.destRect1, this.destRect1, this.destRect1, this.matrixMirror1, this.matrixMirror2, this.matrixMirror3, this.tMode3, this.totalArea3);
        int m9TouchMode = 4;
        if (this.tMode3 == 0) {
            m9TouchMode = 0;
        }
        this.modeX9 = new PromoMirrorMode(4, this.srcRect3, this.destRect2, this.destRect2, this.destRect2, this.destRect2, this.matrixMirror1, this.matrixMirror2, this.matrixMirror3, m9TouchMode, this.totalArea3);
        int m10TouchMode = 3;
        if (this.tMode3 == 1) {
            m10TouchMode = 1;
        }
        this.modeX10 = new PromoMirrorMode(4, this.srcRect3, this.destRect3, this.destRect3, this.destRect3, this.destRect3, this.matrixMirror1, this.matrixMirror2, this.matrixMirror3, m10TouchMode, this.totalArea3);
        int m11TouchMode = 4;
        if (this.tMode3 == 0) {
            m11TouchMode = 3;
        }
        this.modeX11 = new PromoMirrorMode(4, this.srcRect3, this.destRect4, this.destRect4, this.destRect4, this.destRect4, this.matrixMirror1, this.matrixMirror2, this.matrixMirror3, m11TouchMode, this.totalArea3);
        this.modeX4 = new PromoMirrorMode(2, this.srcRect1, this.destRect1X, this.destRect1X, this.matrixMirror1, this.tMode1, this.totalArea1);
        PromoMirrorMode modeX4Promo = new PromoMirrorMode(2, this.srcRect1, this.destRect1X, this.destRect2X, this.f872I, this.tMode1, this.totalArea1);
        int m5TouchMode = 4;
        if (this.tMode1 == 0) {
            m5TouchMode = 0;
        } else if (this.tMode1 == 5) {
            m5TouchMode = 5;
        }
        this.modeX5 = new PromoMirrorMode(2, this.srcRect1, this.destRect2X, this.destRect2X, this.matrixMirror1, m5TouchMode, this.totalArea1);
        this.modeX6 = new PromoMirrorMode(2, this.srcRect2, this.destRect1Y, this.destRect1Y, this.matrixMirror2, this.tMode2, this.totalArea2);
        int m7TouchMode = 3;
        if (this.tMode2 == 1) {
            m7TouchMode = 1;
        } else if (this.tMode2 == 6) {
            m7TouchMode = 6;
        }
        this.modeX7 = new PromoMirrorMode(2, this.srcRect2, this.destRect2Y, this.destRect2Y, this.matrixMirror2, m7TouchMode, this.totalArea2);
        this.modeX12 = new PromoMirrorMode(2, this.srcRect1, this.destRect1X, this.destRect2X, this.matrixMirror4, this.tMode1, this.totalArea1);
        this.modeX13 = new PromoMirrorMode(2, this.srcRect2, this.destRect1Y, this.destRect2Y, this.matrixMirror4, this.tMode2, this.totalArea2);
        this.modeX14 = new PromoMirrorMode(2, this.srcRect1, this.destRect1X, this.destRect1X, this.matrixMirror3, this.tMode1, this.totalArea1);
        this.modeX15 = new PromoMirrorMode(2, this.srcRect2, this.destRect1Y, this.destRect1Y, this.matrixMirror3, this.tMode2, this.totalArea2);
        this.modeX16 = new PromoMirrorMode(4, this.srcRectPaper, this.dstRectPaper1, this.dstRectPaper2, this.dstRectPaper3, this.dstRectPaper4, this.matrixMirror1, this.matrixMirror1, this.f872I, this.tMode1, this.totalArea1);
        this.modeX17 = new PromoMirrorMode(4, this.srcRectPaper, this.dstRectPaper1, this.dstRectPaper3, this.dstRectPaper3, this.dstRectPaper1, this.f872I, this.matrixMirror1, this.matrixMirror1, this.tMode1, this.totalArea1);
        this.modeX18 = new PromoMirrorMode(4, this.srcRectPaper, this.dstRectPaper2, this.dstRectPaper4, this.dstRectPaper2, this.dstRectPaper4, this.f872I, this.matrixMirror1, this.matrixMirror1, this.tMode1, this.totalArea1);
        this.modeX19 = new PromoMirrorMode(4, this.srcRectPaper, this.dstRectPaper1, this.dstRectPaper2, this.dstRectPaper2, this.dstRectPaper1, this.f872I, this.matrixMirror1, this.matrixMirror1, this.tMode1, this.totalArea1);
        this.modeX20 = new PromoMirrorMode(4, this.srcRectPaper, this.dstRectPaper4, this.dstRectPaper3, this.dstRectPaper3, this.dstRectPaper4, this.f872I, this.matrixMirror1, this.matrixMirror1, this.tMode1, this.totalArea1);
        this.mirrorModeList[0] = this.modeX4;
        this.mirrorModeList[1] = this.modeX5;
        this.mirrorModeList[2] = this.modeX6;
        this.mirrorModeList[3] = this.modeX7;
        this.mirrorModeList[4] = this.modeX8;
        this.mirrorModeList[5] = this.modeX9;
        this.mirrorModeList[6] = this.modeX10;
        this.mirrorModeList[7] = this.modeX11;
        this.mirrorModeList[8] = this.modeX12;
        this.mirrorModeList[9] = this.modeX13;
        this.mirrorModeList[10] = this.modeX14;
        this.mirrorModeList[11] = this.modeX15;
        this.mirrorModeList[12] = this.modeX;
        this.mirrorModeList[13] = this.modeX2;
        this.mirrorModeList[14] = this.modeX3;
        this.mirrorModeList[15] = this.modeX7;
        this.mirrorModeList[16] = this.modeX17;
        this.mirrorModeList[17] = this.modeX18;
        this.mirrorModeList[18] = this.modeX19;
        this.mirrorModeList[19] = this.modeX20;
    }

    public Bitmap getBitmap() {
        setDrawingCacheEnabled(true);
        buildDrawingCache();
        Bitmap bmp = Bitmap.createBitmap(getDrawingCache());
        setDrawingCacheEnabled(false);
        return bmp;
    }

    private void createMatrix(int widthPixels, int heightPixels) {
        this.f872I.reset();
        this.matrixMirror1.reset();
        this.matrixMirror1.postScale(-1.0f, 1.0f);
        this.matrixMirror1.postTranslate((float) widthPixels, 0.0f);
        this.matrixMirror2.reset();
        this.matrixMirror2.postScale(1.0f, -1.0f);
        this.matrixMirror2.postTranslate(0.0f, (float) heightPixels);
        this.matrixMirror3.reset();
        this.matrixMirror3.postScale(-1.0f, -1.0f);
        this.matrixMirror3.postTranslate((float) widthPixels, (float) heightPixels);
    }

    private void createRectX(int widthPixels, int heightPixels) {
        float destH = ((float) widthPixels) * (this.mulY / this.mulX);
        float destW = ((float) widthPixels) / 2.0f;
        float destX = 0.0f;
        float destY = this.initialYPos;
        if (destH > ((float) heightPixels)) {
            destH = (float) heightPixels;
            destW = ((this.mulX / this.mulY) * destH) / 2.0f;
            destX = (((float) widthPixels) / 2.0f) - destW;
        }
        destY = this.initialYPos + ((((float) heightPixels) - destH) / 2.0f);
        float srcX = 0.0f;
        float srcY = 0.0f;
        float srcX2 = (float) this.width;
        float srcY2 = (float) this.height;
        this.destRect1X = new RectF(destX, destY, destW + destX, destH + destY);
        float destXX = destX + destW;
        this.destRect2X = new RectF(destXX, destY, destW + destXX, destH + destY);
        this.totalArea1 = new RectF(destX, destY, destW + destXX, destH + destY);
        this.tMode1 = 1;
        if (this.mulX * ((float) this.height) <= (this.mulY * 2.0f) * ((float) this.width)) {
            srcX = (((float) this.width) - (((this.mulX / this.mulY) * ((float) this.height)) / 2.0f)) / 2.0f;
            srcX2 = srcX + (((this.mulX / this.mulY) * ((float) this.height)) / 2.0f);
        } else {
            srcY = (((float) this.height) - (((float) (this.width * 2)) * (this.mulY / this.mulX))) / 2.0f;
            srcY2 = srcY + (((float) (this.width * 2)) * (this.mulY / this.mulX));
            this.tMode1 = 5;
        }
        this.srcRect1 = new RectF(srcX, srcY, srcX2, srcY2);
        this.srcRectPaper = new RectF(srcX, srcY, ((srcX2 - srcX) / 2.0f) + srcX, srcY2);
        float destWPapar = destW / 2.0f;
        this.dstRectPaper1 = new RectF(destX, destY, destWPapar + destX, destH + destY);
        float dextXP = destX + destWPapar;
        this.dstRectPaper2 = new RectF(dextXP, destY, destWPapar + dextXP, destH + destY);
        dextXP += destWPapar;
        this.dstRectPaper3 = new RectF(dextXP, destY, destWPapar + dextXP, destH + destY);
        dextXP += destWPapar;
        this.dstRectPaper4 = new RectF(dextXP, destY, destWPapar + dextXP, destH + destY);
    }

    private void createRectY(int widthPixels, int heightPixels) {
        float destH = (((float) widthPixels) * (this.mulY / this.mulX)) / 2.0f;
        float destW = (float) widthPixels;
        float destX = 0.0f;
        float destY = this.initialYPos;
        if (destH > ((float) heightPixels)) {
            destH = (float) heightPixels;
            destW = ((this.mulX / this.mulY) * destH) / 2.0f;
            destX = (((float) widthPixels) / 2.0f) - destW;
        }
        destY = this.initialYPos + ((((float) heightPixels) - (2.0f * destH)) / 2.0f);
        this.destRect1Y = new RectF(destX, destY, destW + destX, destH + destY);
        float destYY = destY + destH;
        this.destRect2Y = new RectF(destX, destYY, destW + destX, destH + destYY);
        this.totalArea2 = new RectF(destX, destY, destW + destX, destH + destYY);
        float srcX = 0.0f;
        float srcY = 0.0f;
        float srcX2 = (float) this.width;
        float srcY2 = (float) this.height;
        this.tMode2 = 0;
        if ((this.mulX * 2.0f) * ((float) this.height) > this.mulY * ((float) this.width)) {
            srcY = (((float) this.height) - (((this.mulY / this.mulX) * ((float) this.width)) / 2.0f)) / 2.0f;
            srcY2 = srcY + (((this.mulY / this.mulX) * ((float) this.width)) / 2.0f);
        } else {
            srcX = (((float) this.width) - (((float) (this.height * 2)) * (this.mulX / this.mulY))) / 2.0f;
            srcX2 = srcX + (((float) (this.height * 2)) * (this.mulX / this.mulY));
            this.tMode2 = 6;
        }
        this.srcRect2 = new RectF(srcX, srcY, srcX2, srcY2);
    }

    private void createRectXY(int widthPixels, int heightPixels) {
        float destH = (((float) widthPixels) * (this.mulY / this.mulX)) / 2.0f;
        float destW = ((float) widthPixels) / 2.0f;
        float destX = 0.0f;
        float destY = this.initialYPos;
        if (destH > ((float) heightPixels)) {
            destH = (float) heightPixels;
            destW = ((this.mulX / this.mulY) * destH) / 2.0f;
            destX = (((float) widthPixels) / 2.0f) - destW;
        }
        destY = this.initialYPos + ((((float) heightPixels) - (2.0f * destH)) / 2.0f);
        float srcX = 0.0f;
        float srcY = 0.0f;
        float srcX2 = (float) this.width;
        float srcY2 = (float) this.height;
        this.destRect1 = new RectF(destX, destY, destW + destX, destH + destY);
        float destX2 = destX + destW;
        this.destRect2 = new RectF(destX2, destY, destW + destX2, destH + destY);
        float destY2 = destY + destH;
        this.destRect3 = new RectF(destX, destY2, destW + destX, destH + destY2);
        this.destRect4 = new RectF(destX2, destY2, destW + destX2, destH + destY2);
        this.totalArea3 = new RectF(destX, destY, destW + destX2, destH + destY2);
        if (this.mulX * ((float) this.height) <= this.mulY * ((float) this.width)) {
            srcX = (((float) this.width) - ((this.mulX / this.mulY) * ((float) this.height))) / 2.0f;
            srcX2 = srcX + ((this.mulX / this.mulY) * ((float) this.height));
            this.tMode3 = 1;
        } else {
            srcY = (((float) this.height) - (((float) this.width) * (this.mulY / this.mulX))) / 2.0f;
            srcY2 = srcY + (((float) this.width) * (this.mulY / this.mulX));
            this.tMode3 = 0;
        }
        this.srcRect3 = new RectF(srcX, srcY, srcX2, srcY2);
    }

    public void onDraw(Canvas canvas) {
        canvas.drawColor(this.defaultColor);
        drawMode(canvas, this.sourceBitmap, this.mirrorModeList[this.currentModeIndex], this.f872I);
        if (!(!this.d3Mode || this.d3Bitmap == null || this.d3Bitmap.isRecycled())) {
            canvas.setMatrix(this.f872I);
            canvas.drawBitmap(this.d3Bitmap, null, this.mirrorModeList[this.currentModeIndex].rectTotalArea, this.framePaint);
        }
        super.onDraw(canvas);
    }

    private void drawMode(Canvas canvas, Bitmap bitmap, PromoMirrorMode mirrorMode, Matrix matrix) {
        canvas.drawBitmap(bitmap, mirrorMode.getDrawBitmapSrc(), mirrorMode.rect1, this.framePaint);
        this.m1.set(mirrorMode.matrix1);
        this.m1.postConcat(matrix);
        canvas.concat(this.m1);
        canvas.drawBitmap(bitmap, mirrorMode.getDrawBitmapSrc(), mirrorMode.rect2, this.framePaint);
        if (mirrorMode.count == 4) {
            this.m2.set(mirrorMode.matrix2);
            this.m2.postConcat(matrix);
            canvas.setMatrix(this.m2);
            canvas.drawBitmap(bitmap, mirrorMode.getDrawBitmapSrc(), mirrorMode.rect3, this.framePaint);
            this.m3.set(mirrorMode.matrix3);
            this.m3.postConcat(matrix);
            canvas.setMatrix(this.m3);
            canvas.drawBitmap(bitmap, mirrorMode.getDrawBitmapSrc(), mirrorMode.rect4, this.framePaint);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
        r7 = this;
        r4 = 0;
        r6 = 1;
        r1 = r8.getX();
        r2 = r8.getY();
        r3 = r8.getAction();
        switch(r3) {
            case 0: goto L_0x0015;
            case 1: goto L_0x0011;
            case 2: goto L_0x0079;
            default: goto L_0x0011;
        };
    L_0x0011:
        r7.postInvalidate();
    L_0x0014:
        return r6;
    L_0x0015:
        r3 = r7.touchCountForMarket;
        r3 = r3 + 1;
        r7.touchCountForMarket = r3;
        r3 = r7.getHeight();
        r3 = r3 / 2;
        r3 = (float) r3;
        r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r3 > 0) goto L_0x0031;
    L_0x0026:
        r3 = r7.getWidth();
        r3 = r3 / 2;
        r3 = (float) r3;
        r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r3 <= 0) goto L_0x0054;
    L_0x0031:
        r3 = r7.isMarketCalled;
        if (r3 != 0) goto L_0x0054;
    L_0x0035:
        r3 = r7.touchCountForMarket;
        if (r3 <= r6) goto L_0x0054;
    L_0x0039:
        r0 = new android.content.Intent;
        r3 = "android.intent.action.VIEW";
        r0.<init>(r3);
        r3 = r7.marketUrl;
        r3 = android.net.Uri.parse(r3);
        r0.setData(r3);
        r3 = r7.getContext();
        r3.startActivity(r0);
        r7.isMarketCalled = r6;
        goto L_0x0014;
    L_0x0054:
        r3 = r7.getWidth();
        r3 = r3 / 2;
        r3 = (float) r3;
        r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r3 >= 0) goto L_0x0073;
    L_0x005f:
        r7.isTouchStartedLeft = r6;
    L_0x0061:
        r3 = r7.getHeight();
        r3 = r3 / 2;
        r3 = (float) r3;
        r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r3 >= 0) goto L_0x0076;
    L_0x006c:
        r7.isTouchStartedTop = r6;
    L_0x006e:
        r7.oldX = r1;
        r7.oldY = r2;
        goto L_0x0011;
    L_0x0073:
        r7.isTouchStartedLeft = r4;
        goto L_0x0061;
    L_0x0076:
        r7.isTouchStartedTop = r4;
        goto L_0x006e;
    L_0x0079:
        r3 = r7.mirrorModeList;
        r4 = r7.currentModeIndex;
        r3 = r3[r4];
        r3 = r3.getSrcRect();
        r4 = r7.oldX;
        r4 = r1 - r4;
        r5 = r7.oldY;
        r5 = r2 - r5;
        r7.moveGrid(r3, r4, r5);
        r3 = r7.mirrorModeList;
        r4 = r7.currentModeIndex;
        r3 = r3[r4];
        r3.updateBitmapSrc();
        r7.oldX = r1;
        r7.oldY = r2;
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lyrebirdstudio.promodialog.PromoMirrorView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    void moveGrid(RectF srcRect, float x, float y) {
        if (this.mirrorModeList[this.currentModeIndex].touchMode == 1 || this.mirrorModeList[this.currentModeIndex].touchMode == 4 || this.mirrorModeList[this.currentModeIndex].touchMode == 6) {
            if (this.mirrorModeList[this.currentModeIndex].touchMode == 4) {
                x *= -1.0f;
            }
            if (this.isTouchStartedLeft && this.mirrorModeList[this.currentModeIndex].touchMode != 6) {
                x *= -1.0f;
            }
            if (srcRect.left + x < 0.0f) {
                x = -srcRect.left;
            }
            if (srcRect.right + x >= ((float) this.width)) {
                x = ((float) this.width) - srcRect.right;
            }
            srcRect.left += x;
            srcRect.right += x;
        } else if (this.mirrorModeList[this.currentModeIndex].touchMode == 0 || this.mirrorModeList[this.currentModeIndex].touchMode == 3 || this.mirrorModeList[this.currentModeIndex].touchMode == 5) {
            if (this.mirrorModeList[this.currentModeIndex].touchMode == 3) {
                y *= -1.0f;
            }
            if (this.isTouchStartedTop && this.mirrorModeList[this.currentModeIndex].touchMode != 5) {
                y *= -1.0f;
            }
            if (srcRect.top + y < 0.0f) {
                y = -srcRect.top;
            }
            if (srcRect.bottom + y >= ((float) this.height)) {
                y = ((float) this.height) - srcRect.bottom;
            }
            srcRect.top += y;
            srcRect.bottom += y;
        }
    }

    public void startAnimator() {
        int srcWidth = (int) this.mirrorModeList[this.currentModeIndex].getSrcRect().width();
        int srcHeight = (int) this.mirrorModeList[this.currentModeIndex].getSrcRect().height();
        Log.e(TAG, "anim width " + this.mirrorModeList[this.currentModeIndex].getSrcRect().width());
        if (srcWidth < this.width) {
            this.animDelta = ((float) (this.width - srcWidth)) / 135.0f;
        } else {
            this.animDelta = ((float) (this.height - srcHeight)) / 135.0f;
        }
        if (this.animDelta <= 0.0f) {
            this.animDelta = 0.5f;
        }
        this.animationCount = 0;
        this.animate = true;
        removeCallbacks(this.animator);
        post(this.animator);
    }
}
