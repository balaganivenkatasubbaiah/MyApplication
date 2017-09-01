package com.lyrebirdstudio.lyrebirdlibrary;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Build.VERSION;

public class BlurBuilderNormal {
    public static final float BITMAP_SCALE = 0.4f;
    public static final int BLUR_RADIUS_DEFAULT = 14;
    public static final int BLUR_RADIUS_DEFAULT_MULTI = 0;
    public static final int BLUR_RADIUS_MAX = 25;
    public static final int BLUR_RADIUS_SENTINEL = -1;
    private static final String TAG = BlurBuilderNormal.class.getSimpleName();
    Bitmap inputBitmap;
    int lastBlurRadius = -1;
    Matrix matrixBlur = new Matrix();
    Bitmap outputBitmap;
    Paint paintBlur = new Paint(2);

    public Bitmap createBlurBitmapNDK(Bitmap sourceBitmap, int radius) {
        boolean isPhotoNew;
        if (this.inputBitmap != sourceBitmap) {
            isPhotoNew = true;
        } else {
            isPhotoNew = false;
        }
        if (radius <= 2) {
            radius = 2;
        }
        if (this.lastBlurRadius == radius && this.outputBitmap != null && this.inputBitmap == sourceBitmap) {
            return this.outputBitmap;
        }
        if (this.inputBitmap == null || this.inputBitmap != sourceBitmap) {
            if (this.inputBitmap != null) {
                this.inputBitmap.recycle();
            }
            int width = Math.round(((float) sourceBitmap.getWidth()) * BITMAP_SCALE);
            int height = Math.round(((float) sourceBitmap.getHeight()) * BITMAP_SCALE);
            if (width % 2 == 1) {
                width++;
            }
            if (height % 2 == 1) {
                height++;
            }
            if (width <= 0) {
                width = 2;
            }
            if (height <= 0) {
                height = 2;
            }
            if (VERSION.SDK_INT < 12) {
                Options myOptions = new Options();
                myOptions.inDither = true;
                myOptions.inScaled = false;
                myOptions.inPreferredConfig = Config.ARGB_8888;
                myOptions.inPurgeable = true;
                if (!(sourceBitmap == null || sourceBitmap.isRecycled())) {
                    this.inputBitmap = createScaledBitmap(sourceBitmap, width, height, false);
                }
            } else if (!(sourceBitmap == null || sourceBitmap.isRecycled())) {
                this.inputBitmap = Bitmap.createScaledBitmap(sourceBitmap, width, height, false);
            }
        }
        if (this.inputBitmap == null) {
            return null;
        }
        if (this.outputBitmap == null || this.outputBitmap.isRecycled() || isPhotoNew) {
            this.outputBitmap = this.inputBitmap.copy(Config.ARGB_8888, true);
        } else {
            new Canvas(this.outputBitmap).drawBitmap(this.inputBitmap, 0.0f, 0.0f, this.paintBlur);
        }
        EffectFragment.functionToBlur(this.outputBitmap, radius);
        this.lastBlurRadius = radius;
        return this.outputBitmap;
    }

    public void destroy() {
        if (this.outputBitmap != null) {
            this.outputBitmap.recycle();
        }
        this.outputBitmap = null;
        if (this.inputBitmap != null) {
            this.inputBitmap.recycle();
        }
        this.inputBitmap = null;
    }

    public int getBlur() {
        return this.lastBlurRadius;
    }

    public static Bitmap createScaledBitmap(Bitmap src, int dstWidth, int dstHeight, boolean filter) {
        Matrix m = new Matrix();
        m.setScale(((float) dstWidth) / ((float) src.getWidth()), ((float) dstHeight) / ((float) src.getHeight()));
        Bitmap result = Bitmap.createBitmap(dstWidth, dstHeight, Config.ARGB_8888);
        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setFilterBitmap(filter);
        canvas.drawBitmap(src, m, paint);
        return result;
    }

    public static Bitmap createCroppedBitmap(Bitmap src, int left, int top, int width, int height, boolean filter) {
        Bitmap result = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setFilterBitmap(filter);
        canvas.drawBitmap(src, (float) (-left), (float) (-top), paint);
        return result;
    }
}
