package com.lyrebirdstudio.common_libs;

import android.content.Context;

import com.lyrebirdstudio.BuildConfig;

import java.util.Locale;

public class CommonLibrary {
    public static boolean purchased;

    public static boolean isAppPro(Context context) {
        String packageName = context.getPackageName().toLowerCase(Locale.ENGLISH);
        if (!packageName.contains("lyrebirdstudio")) {
            return false;
        }
        if (purchased) {
            return true;
        }
        if (packageName.equals("com.lyrebirdstudio.clone.free")) {
            return false;
        }
        if (packageName.equals("com.lyrebirdstudio.clone")) {
            return true;
        }
        if (packageName.equals(BuildConfig.APPLICATION_ID) || packageName.equals("com.lyrebirdstudio.colorizer.lite")) {
            return false;
        }
        if (packageName.equals("com.lyrebirdstudio.colorizer.pro")) {
            return true;
        }
        if (packageName.equals("com.lyrebirdstudio.colorme")) {
            return false;
        }
        if (packageName.equals("com.lyrebirdstudio.colorsplasheffect.pro")) {
            return true;
        }
        if (packageName.equals("com.lyrebirdstudio.copter") || packageName.equals("com.lyrebirdstudio.eyecolorchanger")) {
            return false;
        }
        if (packageName.equals("com.lyrebirdstudio.eyecolorchanger.pro")) {
            return true;
        }
        if (packageName.equals("com.lyrebirdstudio.hdr.lite")) {
            return false;
        }
        if (packageName.equals("com.lyrebirdstudio.hdr")) {
            return true;
        }
        if (packageName.equals("com.lyrebirdstudio.mirror")) {
            return false;
        }
        if (packageName.equals("com.lyrebirdstudio.mirror.pro")) {
            return true;
        }
        if (packageName.equals("com.lyrebirdstudio.camera")) {
            return true;
        }
        if (packageName.equals("com.lyrebirdstudio.hdrcamera")) {
            return true;
        }
        if (packageName.equals("com.lyrebirdstudio.rush")) {
            return false;
        }
        if (packageName.equals("com.lyrebirdstudio.tinyplanet")) {
            return true;
        }
        if (packageName.equals("com.lyrebirdstudio.mirror_collage") || packageName.equals("com.lyrebirdstudio.instasquare") || packageName.equals("com.lyrebirdstudio.nocrop") || packageName.equals("com.lyrebirdstudio.montagenscolagem") || packageName.equals("com.lyrebirdstudio.photocollageeditor") || packageName.equals("com.lyrebirdstudio.pipcamera") || packageName.equals("com.lyrebirdstudio.pip_collage") || packageName.equals("com.lyrebirdstudio.beauty_makeover") || packageName.equals("com.lyrebirdstudio.beauty") || packageName.equals("com.lyrebirdstudio.tbt") || packageName.equals("com.lyrebirdstudio.faceswap") || packageName.equals("com.lyrebirdstudio.collage_layout") || packageName.equals("com.lyrebirdstudio.collage_frame") || packageName.equals("com.lyrebirdstudio.photo_editor_pro") || packageName.equals("com.lyrebirdstudio.makeup") || packageName.equals("com.lyrebirdstudio.magazine") || packageName.equals("com.lyrebirdstudio.art_filter") || packageName.equals("com.lyrebirdstudio.art") || packageName.equals("com.lyrebirdstudio.videoeditor") || packageName.equals("com.lyrebirdstudio.face_camera") || packageName.equals("com.lyrebirdstudio.emoji_camera")) {
            return false;
        }
        if (packageName.contains("pro")) {
            return true;
        }
        if (packageName.contains("free") || packageName.contains("lite")) {
            return false;
        }
        return true;
    }
}
