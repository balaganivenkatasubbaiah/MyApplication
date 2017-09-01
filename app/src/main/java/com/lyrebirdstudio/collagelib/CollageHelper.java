package com.lyrebirdstudio.collagelib;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.lyrebirdstudio.gallerylib.GalleryFragment;
import com.lyrebirdstudio.gallerylib.GalleryFragment.GalleryListener;

public class CollageHelper {
    protected static final String TAG = CollageHelper.class.getSimpleName();

    public static GalleryFragment getGalleryFragment(FragmentActivity activity) {
        return (GalleryFragment) activity.getSupportFragmentManager().findFragmentByTag("myFragmentTag");
    }

    public static GalleryFragment addGalleryFragment(FragmentActivity activity, int gallery_fragment_container, boolean showInter, View mainLayoutToHide) {
        FragmentManager fm = activity.getSupportFragmentManager();
        GalleryFragment galleryFragment = (GalleryFragment) fm.findFragmentByTag("myFragmentTag");
        if (galleryFragment == null) {
            galleryFragment = new GalleryFragment();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(gallery_fragment_container, galleryFragment, "myFragmentTag");
            ft.commitAllowingStateLoss();
            galleryFragment.setGalleryListener(createGalleryListener(activity, galleryFragment, showInter, mainLayoutToHide));
            activity.findViewById(gallery_fragment_container).bringToFront();
            return galleryFragment;
        }
        activity.getSupportFragmentManager().beginTransaction().show(galleryFragment).commitAllowingStateLoss();
        return galleryFragment;
    }

    public static GalleryListener createGalleryListener(FragmentActivity activity, GalleryFragment galleryFragment, boolean showInter, View mainLayoutToHide) {
        final FragmentActivity fragmentActivity = activity;
        final View view = mainLayoutToHide;
        final GalleryFragment galleryFragment2 = galleryFragment;
        final boolean z = showInter;
        return new GalleryListener() {
            public void onGalleryOkSingleImage(long ImageIdList, int orientationList, boolean isScrapBook, boolean isShape) {
            }

            public void onGalleryOkImageArrayRemoveFragment(long[] ImageIdList, int[] orientationList, boolean isScrapBook, boolean isShape) {
            }

            public void onGalleryOkImageArray(long[] ImageIdList, int[] orientationList, boolean isScrapBook, boolean isShape) {
                Intent intent = new Intent(fragmentActivity, CollageActivity.class);
                intent.putExtra("photo_id_list", ImageIdList);
                intent.putExtra("photo_orientation_list", orientationList);
                intent.putExtra("is_scrap_book", isScrapBook);
                intent.putExtra("is_shape", isShape);
                fragmentActivity.startActivity(intent);
            }

            public void onGalleryCancel() {
                if (!(view == null || view.getVisibility() == 0)) {
                    view.setVisibility(0);
                }
                fragmentActivity.getSupportFragmentManager().beginTransaction().hide(galleryFragment2).commitAllowingStateLoss();
               /* if (z && interstitialAd != null) {
                    AdUtility.displayInterStitialWithSplashScreen(interstitialAd, fragmentActivity, AdUtility.SPLASH_TIME_OUT_DEFAULT, "COLLAGE_GALLERY_CLOSED");
                }*/
            }
        };
    }
}
