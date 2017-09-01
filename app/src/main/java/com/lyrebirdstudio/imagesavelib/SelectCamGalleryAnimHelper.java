package com.lyrebirdstudio.imagesavelib;

import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.lyrebirdstudio.R;

public class SelectCamGalleryAnimHelper {
    public static int MODE_CLICK = 0;
    public static int MODE_OPEN = 1;
    View buttonSelectCamera;
    View buttonSelectGallery;
    private Animation slideLeftIn;
    private Animation slideRightIn;

   /* public SelectCamGalleryAnimHelper(Activity activity) {
        this.slideLeftIn = AnimationUtils.loadAnimation(activity, R.anim.slide_in_left);
        this.slideRightIn = AnimationUtils.loadAnimation(activity, R.anim.slide_in_right);
        this.buttonSelectCamera = activity.findViewById(R.id.select_dialog_button_camera);
        this.buttonSelectGallery = activity.findViewById(R.id.select_dialog_button_gallery);
    }

    public void onClickListener(View selectContainer, View view, int id) {
        if (id == R.id.select_image_container) {
            view.setVisibility(4);
        } else if (id == R.id.select_dialog_button_gallery) {
            selectContainer.setVisibility(4);
        } else if (id == R.id.select_dialog_button_camera) {
            selectContainer.setVisibility(4);
        }
    }*/

    public void openCamGal(View selectContainer) {
        selectContainer.setVisibility(0);
        selectContainer.bringToFront();
        this.buttonSelectGallery.startAnimation(this.slideLeftIn);
        this.buttonSelectCamera.startAnimation(this.slideRightIn);
    }

    public boolean onBackButton(View selectContainer) {
        if (selectContainer.getVisibility() != 0) {
            return false;
        }
        selectContainer.setVisibility(4);
        return true;
    }
}
