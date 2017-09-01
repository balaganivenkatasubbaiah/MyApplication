package com.lyrebirdstudio.collagelib;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Debug;
import android.provider.MediaStore.Images.Media;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Utility {
    public static final int ICON_SIZE = 160;
    private static final String TAG = Utility.class.getSimpleName();
    private static final float limitDivider = 30.0f;
    private static final float limitDividerGinger = 160.0f;

   /* public static void createIconBitmap(List<ShapeLayout> shapeList) {
        for (int i = 0; i < shapeList.size(); i++) {
            Bitmap drawBitmap = Bitmap.createBitmap(ICON_SIZE, ICON_SIZE, Config.ARGB_8888);
            Canvas canvas = new Canvas(drawBitmap);
            canvas.drawColor(-1);
            int sc = canvas.saveLayer(-160.0f, -160.0f, limitDividerGinger, limitDividerGinger, 0, 31);
            for (int j = 0; j < ((ShapeLayout) shapeList.get(i)).shapeArr.length; j++) {
                ((ShapeLayout) shapeList.get(i)).shapeArr[j].initIcon(ICON_SIZE, ICON_SIZE);
                boolean drawPorterClear = false;
                if (j == ((ShapeLayout) shapeList.get(i)).getClearIndex()) {
                    drawPorterClear = true;
                }
                ((ShapeLayout) shapeList.get(i)).shapeArr[j].drawShapeIcon(canvas, ICON_SIZE, ICON_SIZE, sc, drawPorterClear);
            }
            canvas.restoreToCount(sc);
            File myDir = new File(Environment.getExternalStorageDirectory().toString() + "/collage_icons2");
            myDir.mkdirs();
            try {
                FileOutputStream out = new FileOutputStream(new File(myDir, "collage_" + ((ShapeLayout) shapeList.get(i)).shapeArr.length + "_" + i + ".png"));
                drawBitmap.compress(CompressFormat.PNG, 90, out);
                out.flush();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
*/
    public static boolean isPackageProEx(Context context) {
        return context.getPackageName().toLowerCase().contains("pro");
    }

    public static Bitmap getBitmapFromId(Context context, long imageID) {
        Bitmap bitmap = null;
        try {
            bitmap = Media.getBitmap(context.getContentResolver(), Uri.withAppendedPath(Media.EXTERNAL_CONTENT_URI, Long.toString(imageID)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return bitmap;
    }

    public static Bitmap getScaledBitmapFromId(Context context, long imageID) {
        Uri uri = Uri.withAppendedPath(Media.EXTERNAL_CONTENT_URI, Long.toString(imageID));
        Options options = new Options();
        options.inSampleSize = 4;
        AssetFileDescriptor fileDescriptor = null;
        try {
            fileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, "r");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return BitmapFactory.decodeFileDescriptor(fileDescriptor.getFileDescriptor(), null, options);
    }

    public static Bitmap getScaledBitmapFromId(Context context, long imageID, int orientation, int requiredSize, boolean isScrapBook) {
        Uri uri = Uri.withAppendedPath(Media.EXTERNAL_CONTENT_URI, Long.toString(imageID));
        Options boundsOption = new Options();
        boundsOption.inJustDecodeBounds = true;
        AssetFileDescriptor fileDescriptor = null;
        try {
            fileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, "r");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (fileDescriptor == null) {
            return null;
        }
        BitmapFactory.decodeFileDescriptor(fileDescriptor.getFileDescriptor(), null, boundsOption);
        Options options = new Options();
        options.inSampleSize = calculateInSampleSize(boundsOption, requiredSize, requiredSize);
        if (VERSION.SDK_INT >= 11 && isScrapBook) {
            options.inMutable = true;
        }
        Bitmap actuallyUsableBitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor.getFileDescriptor(), null, options);
        if (actuallyUsableBitmap == null) {
            return null;
        }
        Bitmap bitmap = rotateImage(actuallyUsableBitmap, orientation);
        if (!(bitmap == null || actuallyUsableBitmap == bitmap)) {
            actuallyUsableBitmap.recycle();
        }
        if (bitmap.isMutable() || !isScrapBook) {
            return bitmap;
        }
        Bitmap mutableBitmap = bitmap.copy(Config.ARGB_8888, true);
        if (mutableBitmap != bitmap) {
            bitmap.recycle();
        }
        return mutableBitmap;
    }

    public static Bitmap decodeFile(String path, int requiredSize, boolean isScrapBook) {
        IOException e;
        try {
            File f = new File(path);
            Options boundsOption = new Options();
            boundsOption.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(new FileInputStream(f), null, boundsOption);
            Options o2 = new Options();
            if (VERSION.SDK_INT >= 11 && isScrapBook) {
                o2.inMutable = true;
            }
            o2.inSampleSize = calculateInSampleSize(boundsOption, requiredSize, requiredSize);
            Bitmap bitmap = BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
            int orientation = 1;
            try {
                ExifInterface exif = new ExifInterface(path);
                ExifInterface exifInterface;
                orientation = exif.getAttributeInt("Orientation", 0);
                exifInterface = exif;
            } catch (IOException e3) {
                e = e3;
                e.printStackTrace();
                bitmap = rotateBitmap(bitmap, orientation);
                if (bitmap != null) {
                }
            }
            bitmap = rotateBitmap(bitmap, orientation);
            if (bitmap != null && !bitmap.isMutable()) {
                Bitmap mutableBitmap = bitmap.copy(Config.ARGB_8888, true);
                if (mutableBitmap != bitmap) {
                    bitmap.recycle();
                }
                return mutableBitmap;
            }
        } catch (FileNotFoundException e4) {
            return null;
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Bitmap rotateBitmap(Bitmap paramBitmap, int paramInt)
    {
        for (;;)
        {
            Matrix localMatrix;
            Bitmap localBitmap;
            try
            {
                localMatrix = new Matrix();
                switch (paramInt)
                {
                    case 0: localMatrix.setRotate(180.0F);
                        break;
                    case 1:  localMatrix.setRotate(180.0F);
                        localMatrix.postScale(-1.0F, 1.0F);
                        break;
                    case 2:
                        localMatrix.setRotate(90.0F);
                        localMatrix.postScale(-1.0F, 1.0F);
                        break;
                    case 3:localMatrix.setRotate(90.0F);
                        break;

                    case 4: localMatrix.setRotate(-90.0F);
                        localMatrix.postScale(-1.0F, 1.0F);
                        break;

                    case 5:localMatrix.setRotate(-90.0F);
                        break;

                }
            }
            catch (Exception localException)
            {

                localException.printStackTrace();
                return paramBitmap;
            }
            try
            {
                localBitmap = createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
                if (localBitmap != paramBitmap) {
                    paramBitmap.recycle();
                }
                return localBitmap;
            }
            catch (OutOfMemoryError localOutOfMemoryError)
            {
                localOutOfMemoryError.printStackTrace();
            }

        }
       // return paramBitmap;
    }

    private static Bitmap rotateImage(Bitmap bitmap, int orientation) {
        Bitmap resultBitmap = bitmap;
        Matrix matrix = new Matrix();
        if (orientation == 90) {
            matrix.postRotate(90.0f);
        } else if (orientation == 180) {
            matrix.postRotate(180.0f);
        } else if (orientation == 270) {
            matrix.postRotate(270.0f);
        }
        if (orientation == 0) {
            return resultBitmap;
        }
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static int calculateInSampleSize(Options options, int reqWidth, int reqHeight) {
        int height = options.outHeight;
        int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            int halfHeight = height / 2;
            int halfWidth = width / 2;
            while (true) {
                if (halfHeight / inSampleSize <= reqHeight && halfWidth / inSampleSize <= reqWidth) {
                    break;
                }
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }

    public static boolean getAmazonMarket(Context context) {
        int AMAZON_MARKET = 0;
        try {
            AMAZON_MARKET = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getInt("amazon_market");
            if (AMAZON_MARKET < 0) {
                AMAZON_MARKET = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (AMAZON_MARKET == 1) {
            return true;
        }
        return false;
    }

    public static double getLeftSizeOfMemoryMb() {
        return (Double.valueOf((double) (Runtime.getRuntime().maxMemory() / 1048576)).doubleValue() - Double.valueOf((double) (Runtime.getRuntime().totalMemory() / 1048576)).doubleValue()) - (Double.valueOf((double) Debug.getNativeHeapAllocatedSize()).doubleValue() / Double.valueOf(1048576.0d).doubleValue());
    }

    public static double getLeftSizeOfMemoryEx(Context context) {
        double totalSize = Double.valueOf((double) Runtime.getRuntime().maxMemory()).doubleValue();
        double heapAllocated = Double.valueOf((double) Runtime.getRuntime().totalMemory()).doubleValue();
        return (totalSize - heapAllocated) - Double.valueOf((double) Debug.getNativeHeapAllocatedSize()).doubleValue();
    }

    public static double getLeftSizeOfMemory() {
        double totalSize = Double.valueOf((double) Runtime.getRuntime().maxMemory()).doubleValue();
        double heapAllocated = Double.valueOf((double) Runtime.getRuntime().totalMemory()).doubleValue();
        return (totalSize - (heapAllocated - Double.valueOf((double) Runtime.getRuntime().freeMemory()).doubleValue())) - Double.valueOf((double) Debug.getNativeHeapAllocatedSize()).doubleValue();
    }

    public static void logFreeMemory(Context context) {
        Log.e(TAG, "free memory own method = " + (getLeftSizeOfMemory() / 1048576.0d));
    }

    public static int maxSizeForDimension(Context context, int count, float upperLimit) {
        float divider = limitDivider;
        if (VERSION.SDK_INT <= 11) {
            divider = limitDividerGinger;
        }
        int maxSize = (int) Math.sqrt(getLeftSizeOfMemory() / ((double) (((float) count) * divider)));
        if (maxSize <= 0) {
            maxSize = getDefaultLimit(count, upperLimit);
        }
        return Math.min(maxSize, getDefaultLimit(count, upperLimit));
    }

    public static int maxSizeForSave(Context context, float upperLimit) {
        float divider = limitDivider;
        if (VERSION.SDK_INT <= 11) {
            divider = limitDividerGinger;
        }
        int maxSize = (int) Math.sqrt(getLeftSizeOfMemory() / ((double) divider));
        if (maxSize > 0) {
            return (int) Math.min((float) maxSize, upperLimit);
        }
        return (int) upperLimit;
    }

    private static int getDefaultLimit(int count, float upperLimit) {
        int limit = (int) (((double) upperLimit) / Math.sqrt((double) count));
        Log.e(TAG, "limit = " + limit);
        return limit;
    }

    public static float pointToAngle(float x, float y, float centerX, float centerY) {
        float degree = 0.0f;
        if (x >= centerX && y < centerY) {
            degree = (float) (270.0d + Math.toDegrees(Math.atan(((double) (x - centerX)) / ((double) (centerY - y)))));
        } else if (x > centerX && y >= centerY) {
            degree = (float) Math.toDegrees(Math.atan(((double) (y - centerY)) / ((double) (x - centerX))));
        } else if (x <= centerX && y > centerY) {
            degree = (float) (90.0d + Math.toDegrees(Math.atan(((double) (centerX - x)) / ((double) (y - centerY)))));
        } else if (x < centerX && y <= centerY) {
            degree = (float) (((int) Math.toDegrees(Math.atan(((double) (centerY - y)) / ((double) (centerX - x))))) + 180);
        }
        if (degree < -180.0f) {
            degree += 360.0f;
        }
        if (degree > 180.0f) {
            return degree - 360.0f;
        }
        return degree;
    }

    public static Bitmap createBitmap(Bitmap source, int x, int y, int width, int height, Matrix m, boolean filter) {
        if (x + width > source.getWidth()) {
            throw new IllegalArgumentException("x + width must be <= bitmap.width()");
        } else if (y + height > source.getHeight()) {
            throw new IllegalArgumentException("y + height must be <= bitmap.height()");
        } else if (!source.isMutable() && x == 0 && y == 0 && width == source.getWidth() && height == source.getHeight() && (m == null || m.isIdentity())) {
            return source;
        } else {
            Bitmap bitmap;
            Paint paint;
            int neww = width;
            int newh = height;
            Canvas canvas = new Canvas();
            Rect srcR = new Rect(x, y, x + width, y + height);
            RectF dstR = new RectF(0.0f, 0.0f, (float) width, (float) height);
            Config newConfig = Config.ARGB_8888;
            if (m == null || m.isIdentity()) {
                bitmap = Bitmap.createBitmap(neww, newh, newConfig);
                paint = null;
            } else {
                boolean transformed = !m.rectStaysRect();
                RectF deviceR = new RectF();
                m.mapRect(deviceR, dstR);
                bitmap = Bitmap.createBitmap(Math.round(deviceR.width()), Math.round(deviceR.height()), newConfig);
                canvas.translate(-deviceR.left, -deviceR.top);
                canvas.concat(m);
                paint = new Paint();
                paint.setFilterBitmap(filter);
                if (transformed) {
                    paint.setAntiAlias(true);
                }
            }
            canvas.setBitmap(bitmap);
            canvas.drawBitmap(source, srcR, dstR, paint);
            canvas.setBitmap(null);
            return bitmap;
        }
    }
}
