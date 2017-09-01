package com.lyrebirdstudio.imagesavelib;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore.Images.Media;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.widget.Toast;

import com.lyrebirdstudio.R;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ImageUtility {
    private static final String TAG = ImageUtility.class.getSimpleName();
    private static final int TWITTER_ACTIVITY = 5455;
    public static final int sizeDivider = 100000;

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

    public static String getPrefferredDirectoryPathEx(Context mContext) {
        String directory = Environment.getExternalStorageDirectory().getAbsolutePath() + mContext.getResources().getString(R.string.directory);
        String prefDir = PreferenceManager.getDefaultSharedPreferences(mContext).getString("save_image_directory_custom", null);
        if (prefDir != null) {
            return prefDir + File.separator;
        }
        return directory;
    }

    public static String getPrefferredDirectoryPath(final Context mContext, boolean showErrorMessage, boolean getPrefDirectoryNoMatterWhat, boolean isAppCamera) {
        String directory;
        if (isAppCamera) {
            directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath() + File.separator + mContext.getResources().getString(R.string.directory);
        } else {
            directory = Environment.getExternalStorageDirectory().getAbsolutePath() + mContext.getResources().getString(R.string.directory);
        }
        String prefDir = PreferenceManager.getDefaultSharedPreferences(mContext).getString("save_image_directory_custom", null);
        if (prefDir != null) {
            prefDir = prefDir + File.separator;
            if (getPrefDirectoryNoMatterWhat) {
                return prefDir;
            }
            File dirFile = new File(prefDir);
            final String finalDirectory = directory;
          /*  if (dirFile.canRead() && dirFile.canWrite() && checkIfEACCES(prefDir)) {
                directory = prefDir;
            } else*/ if (showErrorMessage) {
                ((Activity) mContext).runOnUiThread(new Runnable() {
                    public void run() {
                        Toast msg = Toast.makeText(mContext, String.format(mContext.getString(R.string.save_image_directory_error_message), new Object[]{finalDirectory}), 1);
                        msg.setGravity(17, msg.getXOffset() / 2, msg.getYOffset() / 2);
                        msg.show();
                    }
                });
            }
            Log.e(TAG, "prefDir " + prefDir);
        }
        Log.e(TAG, "getPrefferredDirectoryPathEx " + getPrefferredDirectoryPathEx(mContext));
        Log.e(TAG, "getPrefferredDirectoryPath " + directory);
        return directory;
    }

   /* public static boolean checkIfEACCES(String dir) {
        IOException ex;
        Throwable th;
        boolean result = false;
        Writer writer = null;
        try {
            File f = new File(dir);
            String localPath = dir + "mpp";
            f.mkdirs();
            Writer writer2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(localPath), AudienceNetworkActivity.WEBVIEW_ENCODING));
            try {
                writer2.write("Something");
                result = true;
                writer2.close();
                Log.e(TAG, "f.delete() = " + new File(localPath).delete());
                try {
                    writer2.close();
                    writer = writer2;
                } catch (Exception e) {
                    writer = writer2;
                }
            } catch (IOException e2) {
                ex = e2;
                writer = writer2;
                try {
                    Log.e(TAG, ex.toString());
                    try {
                        writer.close();
                    } catch (Exception e3) {
                    }
                    return result;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        writer.close();
                    } catch (Exception e4) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                writer = writer2;
                writer.close();
                throw th;
            }
        } catch (IOException e5) {
            ex = e5;
            Log.e(TAG, ex.toString());
            writer.close();
            return result;
        }
        return result;
    }
*/
    private static long getFreeMemory() {
        return Runtime.getRuntime().maxMemory() - Debug.getNativeHeapAllocatedSize();
    }

    public static int maxSizeForDimension() {
        int maxSize = (int) Math.sqrt(((double) getFreeMemory()) / 30.0d);
        Log.e(TAG, "maxSize " + maxSize);
        return Math.min(maxSize, 1624);
    }

    public static int calculateInSampleSize(Options options, int reqWidth, int reqHeight) {
        int height = options.outHeight;
        int width = options.outWidth;
        if (height <= reqHeight && width <= reqWidth) {
            return 1;
        }
        if (width < height) {
            return (int) Math.ceil((double) (((float) height) / ((float) reqHeight)));
        }
        return (int) Math.ceil((double) (((float) width) / ((float) reqWidth)));
    }

    public static final void launchFacebook(Context mContext, Class FacebookLike, String urlFacebookLike) {
        String urlFb = urlFacebookLike;
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(urlFb));
        List<ResolveInfo> list = mContext.getPackageManager().queryIntentActivities(intent, 65536);
        if (list == null || list.size() != 0) {
            mContext.startActivity(intent);
        } else {
            mContext.startActivity(new Intent(mContext, FacebookLike));
        }
        Toast.makeText(mContext, mContext.getString(R.string.facebook_like_us), 1).show();
    }

    public static boolean shouldShowAds(Context mContext) {
        return !mContext.getPackageName().toLowerCase().contains("pro");
    }

    public static final void launchInstagram(Context mContext) {
        Intent insta = new Intent("android.intent.action.VIEW", Uri.parse("http://instagram.com/_u/lyrebird_studio"));
        insta.setPackage("com.instagram.android");
        if (isIntentAvailable(mContext, insta)) {
            try {
                mContext.startActivity(insta);
                return;
            } catch (Exception e) {
                return;
            }
        }
        try {
            mContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://instagram.com/lyrebird_studio")));
        } catch (Exception e2) {
        }
    }

    private static boolean isIntentAvailable(Context ctx, Intent intent) {
        List<ResolveInfo> list = ctx.getPackageManager().queryIntentActivities(intent, 65536);
        if (list == null || list.size() <= 0) {
            return false;
        }
        return true;
    }

    public static void followTwitter(Activity activity) {
        boolean isTwitterCalled = false;
        if (isAppInstalled(activity.getString(R.string.twitter_package), activity)) {
            isTwitterCalled = openTwitterAppv2(activity);
        }
       /* if (!isTwitterCalled) {
            Intent intentTwit = new Intent(activity, FacebookLike.class);
            intentTwit.putExtra("isTwitter", true);
            activity.startActivity(intentTwit);
        }*/
    }

    public static double getLeftSizeOfMemory() {
        double totalSize = Double.valueOf((double) Runtime.getRuntime().maxMemory()).doubleValue();
        double heapAllocated = Double.valueOf((double) Runtime.getRuntime().totalMemory()).doubleValue();
        double nativeAllocated = Double.valueOf((double) Debug.getNativeHeapAllocatedSize()).doubleValue();
        double usedMemory = heapAllocated - Double.valueOf((double) Runtime.getRuntime().freeMemory()).doubleValue();
        Log.e("heapAllocated", " " + Runtime.getRuntime().totalMemory());
        Log.e("nativeAllocated", " " + Debug.getNativeHeapAllocatedSize());
        Log.e("getNativeHeapFreeSize", " " + Debug.getNativeHeapFreeSize());
        Log.e("usedMemory", " " + usedMemory);
        Log.e("old free memory ", " " + ((totalSize - heapAllocated) - nativeAllocated));
        return (totalSize - usedMemory) - nativeAllocated;
    }

    public static Bitmap decodeBitmapFromFile(String selectedImagePath, int MAX_SIZE) {
        int orientation = 0;
        try {
            orientation = new ExifInterface(selectedImagePath).getAttributeInt("Orientation", 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap localBitmap = decodeFile(selectedImagePath, MAX_SIZE);
        if (localBitmap == null) {
            return null;
        }
        Bitmap graySourceBtm = rotateBitmap(localBitmap, orientation);
        if (graySourceBtm == null || VERSION.SDK_INT >= 13) {
            return graySourceBtm;
        }
        Bitmap temp = graySourceBtm.copy(Config.ARGB_8888, false);
        if (graySourceBtm != temp) {
            graySourceBtm.recycle();
        }
        return temp;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Bitmap rotateBitmap(Bitmap r9, int r10) {
        /*
        r5 = new android.graphics.Matrix;	 Catch:{ Exception -> 0x002d }
        r5.<init>();	 Catch:{ Exception -> 0x002d }
        switch(r10) {
            case 1: goto L_0x0008;
            case 2: goto L_0x0009;
            case 3: goto L_0x0027;
            case 4: goto L_0x0033;
            case 5: goto L_0x0040;
            case 6: goto L_0x004d;
            case 7: goto L_0x0053;
            case 8: goto L_0x0060;
            default: goto L_0x0008;
        };	 Catch:{ Exception -> 0x002d }
    L_0x0008:
        return r9;
    L_0x0009:
        r0 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
        r1 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r5.setScale(r0, r1);	 Catch:{ Exception -> 0x002d }
    L_0x0010:
        r1 = 0;
        r2 = 0;
        r3 = r9.getWidth();	 Catch:{ OutOfMemoryError -> 0x0066 }
        r4 = r9.getHeight();	 Catch:{ OutOfMemoryError -> 0x0066 }
        r6 = 1;
        r0 = r9;
        r7 = android.graphics.Bitmap.createBitmap(r0, r1, r2, r3, r4, r5, r6);	 Catch:{ OutOfMemoryError -> 0x0066 }
        if (r7 == r9) goto L_0x0025;
    L_0x0022:
        r9.recycle();	 Catch:{ OutOfMemoryError -> 0x0066 }
    L_0x0025:
        r9 = r7;
        goto L_0x0008;
    L_0x0027:
        r0 = 1127481344; // 0x43340000 float:180.0 double:5.570497984E-315;
        r5.setRotate(r0);	 Catch:{ Exception -> 0x002d }
        goto L_0x0010;
    L_0x002d:
        r8 = move-exception;
        r8.printStackTrace();
        r9 = 0;
        goto L_0x0008;
    L_0x0033:
        r0 = 1127481344; // 0x43340000 float:180.0 double:5.570497984E-315;
        r5.setRotate(r0);	 Catch:{ Exception -> 0x002d }
        r0 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
        r1 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r5.postScale(r0, r1);	 Catch:{ Exception -> 0x002d }
        goto L_0x0010;
    L_0x0040:
        r0 = 1119092736; // 0x42b40000 float:90.0 double:5.529052754E-315;
        r5.setRotate(r0);	 Catch:{ Exception -> 0x002d }
        r0 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
        r1 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r5.postScale(r0, r1);	 Catch:{ Exception -> 0x002d }
        goto L_0x0010;
    L_0x004d:
        r0 = 1119092736; // 0x42b40000 float:90.0 double:5.529052754E-315;
        r5.setRotate(r0);	 Catch:{ Exception -> 0x002d }
        goto L_0x0010;
    L_0x0053:
        r0 = -1028390912; // 0xffffffffc2b40000 float:-90.0 double:NaN;
        r5.setRotate(r0);	 Catch:{ Exception -> 0x002d }
        r0 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
        r1 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r5.postScale(r0, r1);	 Catch:{ Exception -> 0x002d }
        goto L_0x0010;
    L_0x0060:
        r0 = -1028390912; // 0xffffffffc2b40000 float:-90.0 double:NaN;
        r5.setRotate(r0);	 Catch:{ Exception -> 0x002d }
        goto L_0x0010;
    L_0x0066:
        r8 = move-exception;
        r8.printStackTrace();	 Catch:{ Exception -> 0x002d }
        r9 = 0;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lyrebirdstudio.imagesavelib.ImageUtility.rotateBitmap(android.graphics.Bitmap, int):android.graphics.Bitmap");
    }

    private static Bitmap decodeFile(String selectedImagePath, int MAX_SIZE) {
        Options o = new Options();
        o.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(selectedImagePath, o);
        int scale = 1;
        int width_tmp = o.outWidth;
        int height_tmp = o.outHeight;
        while (Math.max(width_tmp, height_tmp) / 2 > MAX_SIZE) {
            width_tmp /= 2;
            height_tmp /= 2;
            scale *= 2;
        }
        Options o2 = new Options();
        o2.inSampleSize = scale;
        Bitmap b = BitmapFactory.decodeFile(selectedImagePath, o2);
        if (b != null) {
            Log.e("decoded file height", String.valueOf(b.getHeight()));
            Log.e("decoded file width", String.valueOf(b.getWidth()));
        }
        return b;
    }

    public static final void launchFacebook(Context mContext) {
        String urlFb = mContext.getString(R.string.facebook_like_url);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(urlFb));
      /*  if (mContext.getPackageManager().queryIntentActivities(intent, 65536).size() == 0) {
            mContext.startActivity(new Intent(mContext, FacebookLike.class));
        } else {*/
            mContext.startActivity(intent);
      /*  }*/
        Toast.makeText(mContext, mContext.getString(R.string.facebook_like_us), 1).show();
    }

    public static boolean isPackageInstalled(String packagename, Context context) {
        try {
            context.getPackageManager().getPackageInfo(packagename, 1);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static boolean isPackageEnabled(String packagename, Context context) {
        boolean z = false;
        if (!isPackageInstalled(packagename, context)) {
            return z;
        }
        try {
            return context.getPackageManager().getApplicationInfo(packagename, 0).enabled;
        } catch (NameNotFoundException e) {
            return z;
        }
    }

    public static void sendShareTwit(Context context, String message, String imagePath) {
        if (context != null && imagePath != null) {
            try {
                Intent tweetIntent = new Intent("android.intent.action.SEND");
                tweetIntent.setFlags(268435456);
                File imageFile = new File(imagePath);
                tweetIntent.setType("image/jpeg");
                tweetIntent.putExtra("android.intent.extra.TEXT", message);
                if (VERSION.SDK_INT >= 24) {
                    tweetIntent.setFlags(1);
                    tweetIntent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".provider", imageFile));
                } else {
                    tweetIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(imageFile));
                }
                boolean resolved = false;
                for (ResolveInfo ri : context.getPackageManager().queryIntentActivities(tweetIntent, 65536)) {
                    if (ri.activityInfo.name.contains("twitter")) {
                        tweetIntent.setClassName(ri.activityInfo.packageName, ri.activityInfo.name);
                        resolved = true;
                        break;
                    }
                }
                if (!resolved) {
                    tweetIntent = Intent.createChooser(tweetIntent, "Choose one");
                }
                context.startActivity(tweetIntent);
            } catch (Exception e) {
                Toast msg = Toast.makeText(context, context.getString(R.string.save_image_no_twitter_app), 1);
                msg.setGravity(17, msg.getXOffset() / 2, msg.getYOffset() / 2);
                msg.show();
            }
        }
    }

    public static boolean shareTwit(Context context, String message, String imagePath) {
        try {
            String path = Media.insertImage(context.getContentResolver(), new File(imagePath).getAbsolutePath(), "Title", null);
            if (path == null) {
                Log.e(TAG, "twit path null");
                return false;
            }
            Uri imageUri = Uri.parse(path);
            Intent shareIntent = new Intent("android.intent.action.SEND");
            shareIntent.setAction("android.intent.action.SEND");
            shareIntent.putExtra("android.intent.extra.TEXT", message);
            shareIntent.putExtra("android.intent.extra.STREAM", imageUri);
            shareIntent.setType("image/jpeg");
            for (ResolveInfo app : context.getPackageManager().queryIntentActivities(shareIntent, 0)) {
                if (app.activityInfo.name.contains("twitter")) {
                    ActivityInfo activity = app.activityInfo;
                    ComponentName name = new ComponentName(activity.applicationInfo.packageName, activity.name);
                    shareIntent.addCategory("android.intent.category.LAUNCHER");
                    shareIntent.setFlags(270532608);
                    shareIntent.setComponent(name);
                    context.startActivity(shareIntent);
                    break;
                }
            }
            return true;
        } catch (Exception e) {
            Log.e(TAG, "Exception " + e.toString());
            e.printStackTrace();
            return false;
        }
    }

    public static void openPromoApp(String packageName, Context context) {
        try {
            Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
            if (intent == null) {
                intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("market://details?id=" + packageName));
            }
            context.startActivity(intent);
        } catch (Exception e) {
        }
    }

    public static boolean isAppInstalled(String packageName, Activity activity) {
        try {
            activity.getPackageManager().getPackageInfo(packageName, 1);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static boolean checkIfTwitterAppIsInstalled(Activity activity) {
        try {
            if (activity.getPackageManager().getPackageInfo("com.twitter.android", 0).toString().equalsIgnoreCase("com.twitter.android")) {
                return true;
            }
            return false;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean openTwitterAppv2(Activity activity) {
        try {
            Log.e(TAG, "openTwitterAppv2 static");
            activity.getPackageManager().getPackageInfo("com.twitter.android", 0);
            activity.startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse("twitter://user?user_id=363903149")), TWITTER_ACTIVITY);
            return true;
        } catch (Exception e) {
            Log.e(TAG, "openTwitterApp catch");
            return false;
        }
    }

    private static boolean isCallable(Intent intent, Activity activity) {
        return activity.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
