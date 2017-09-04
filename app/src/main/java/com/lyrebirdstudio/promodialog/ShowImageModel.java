package com.lyrebirdstudio.promodialog;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class ShowImageModel {
    String packageName;
    int resId;

    public ShowImageModel(String packageName, int resId) {
        this.resId = resId;
        this.packageName = packageName;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public static void startPromoApp(Context context, String packageName) {
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
}
