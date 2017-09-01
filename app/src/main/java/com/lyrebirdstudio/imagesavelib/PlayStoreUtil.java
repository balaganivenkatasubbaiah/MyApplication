package com.lyrebirdstudio.imagesavelib;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public final class PlayStoreUtil {
    private static final String ANDROID_MARKET_URI_PREFIX = "market://details?id=";
    private static final String GOOGLE_PLAY_STORE_URI_PREFIX = "https://play.google.com/store/apps/details?id=";

    private PlayStoreUtil() {
    }

    public static void openPlayStoreToRate(@NonNull Activity activity, @Nullable String packageName) {
        if (packageName == null) {
            packageName = activity.getPackageName();
        }
        try {
            activity.startActivity(new Intent("android.intent.action.VIEW", getAndroidMarketUriForPackageName(packageName)));
        } catch (ActivityNotFoundException e) {
            activity.startActivity(new Intent("android.intent.action.VIEW", getGooglePlayStoreUriForPackageName(packageName)));
        } finally {
            activity.overridePendingTransition(17432576, 17432577);
        }
    }

    @NonNull
    private static Uri getAndroidMarketUriForPackageName(@NonNull String packageName) {
        return Uri.parse(ANDROID_MARKET_URI_PREFIX + packageName);
    }

    @NonNull
    private static Uri getGooglePlayStoreUriForPackageName(@NonNull String packageName) {
        return Uri.parse(GOOGLE_PLAY_STORE_URI_PREFIX + packageName);
    }
}
