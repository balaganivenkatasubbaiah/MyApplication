package com.lyrebirdstudio.cropimages;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Point;
import android.media.ExifInterface;
import android.os.Debug;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BitmapResizer {
    public static Bitmap decodeFile(File f, int requiredSize, int[] scaler) {
        try {
            Options o = new Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(new FileInputStream(f), null, o);
            int REQUIRED_SIZE = requiredSize;
            int scale = 1;
            int max = Math.max(o.outWidth, o.outHeight);
            while (max / 2 >= REQUIRED_SIZE && max / 2 >= REQUIRED_SIZE) {
                max /= 2;
                scale *= 2;
            }
            Options o2 = new Options();
            o2.inSampleSize = scale;
            scaler[0] = scale;
            Log.e("scaler", "" + scale);
            return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public static Bitmap decodeX(String selectedImagePath, int requiredSize, int[] scaler, int[] rotation) {
        if (selectedImagePath == null) {
            return null;
        }
        String o1 = "";
        try {
            o1 = new ExifInterface(selectedImagePath).getAttribute("Orientation");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (o1 == null) {
            o1 = "";
        }
        File f = new File(selectedImagePath);
        Bitmap localBitmap;
        Matrix localMatrix;
        Bitmap result;
        if (o1.contentEquals("6")) {
            rotation[0] = 90;
            localBitmap = decodeFile(f, requiredSize, scaler);
            localMatrix = new Matrix();
            localMatrix.postRotate(90.0f);
            result = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), localMatrix, false);
            localBitmap.recycle();
            return result;
        } else if (o1.contentEquals("8")) {
            rotation[0] = 270;
            localBitmap = decodeFile(f, requiredSize, scaler);
            localMatrix = new Matrix();
            localMatrix.postRotate(270.0f);
            result = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), localMatrix, false);
            localBitmap.recycle();
            return result;
        } else if (!o1.contentEquals("3")) {
            return decodeFile(f, requiredSize, scaler);
        } else {
            rotation[0] = 180;
            localBitmap = decodeFile(f, requiredSize, scaler);
            localMatrix = new Matrix();
            localMatrix.postRotate(180.0f);
            result = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), localMatrix, false);
            localBitmap.recycle();
            return result;
        }
    }

    public static Point decodeFileSize(File f, int requiredSize) {
        try {
            Options o = new Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(new FileInputStream(f), null, o);
            int REQUIRED_SIZE = requiredSize;
            int width_tmp = o.outWidth;
            int height_tmp = o.outHeight;
            int scale = 1;
            while (Math.max(width_tmp, height_tmp) / 2 > REQUIRED_SIZE) {
                width_tmp /= 2;
                height_tmp /= 2;
                scale *= 2;
            }
            if (scale == 1) {
                return new Point(-1, -1);
            }
            return new Point(width_tmp, height_tmp);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public static int maxSizeForDimension(Context context) {
        return (int) Math.sqrt(((double) getFreeMemory(context)) / 80.0d);
    }

    public static long getFreeMemory(Context context) {
        return ((long) (((ActivityManager) context.getSystemService("activity")).getMemoryClass() * 1048576)) - Debug.getNativeHeapAllocatedSize();
    }

    public static Point getFileSize(File f, int requiredSize) {
        try {
            Options o = new Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(new FileInputStream(f), null, o);
            return new Point(o.outWidth, o.outHeight);
        } catch (FileNotFoundException e) {
            return null;
        }
    }
}
