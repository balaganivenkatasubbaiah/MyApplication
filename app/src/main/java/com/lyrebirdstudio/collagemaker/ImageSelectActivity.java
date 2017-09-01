package com.lyrebirdstudio.collagemaker;

import android.os.Bundle;
import android.view.View;

import com.lyrebirdstudio.BuildConfig;
import com.lyrebirdstudio.R;
import com.lyrebirdstudio.photoactivity.PhotoActivity;

;

public class ImageSelectActivity extends PhotoActivity {
    protected static final String TAG = ImageSelectActivity.class.getSimpleName();
    static final String promoFolder = "/collage_maker/";
    int buttonPromoDefaultIndex = 3;
   // ButtonPromoEntity buttonPromoEntity;
   // ButtonPromoEntity[] localPromoEntities = new ButtonPromoEntity[]{ButtonPromoEntity.BUTTON_PROMO_ENTITIES[19], ButtonPromoEntity.BUTTON_PROMO_ENTITIES[20], ButtonPromoEntity.BUTTON_PROMO_ENTITIES[this.buttonPromoDefaultIndex]};
   // int[] resArr = new int[]{R.id.insta_show_case_container, R.id.nativeAdContainer};
    int[] showImageResArray = new int[]{R.drawable.show_0, R.drawable.show_1, R.drawable.show_2};

   /* class C10161 implements AdmobNativeAdvancedAdLoadListener {
        C10161() {
        }

        public void onAdLoaded() {
            if (ImageSelectActivity.this.viewPagerTop != null) {
                ImageSelectActivity.this.viewPagerTop.setCurrentItem(1);
            }
        }

        public void onAdFailed() {
        }
    }*/

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      /*  this.viewPagerTop = (MyViewPager) findViewById(R.id.native_ad_view_pager);
        this.viewPagerTop.setAdapter(new CustomPagerAdapter(this, this.resArr));
        new AdmobNativeAdvancedHelper(this, R.string.admob_native_front, R.id.nativeAdContainer, R.layout.admob_native_ad_app_install_front, R.layout.admob_native_ad_content_front, false, AdmobNativeAdvancedHelper.TEXT_COLOR_SENTINEL).setAdmobNativeAdvancedAdLoadListener(new C10161());
        this.promoEntities = this.localPromoEntities;
        this.buttonPromoEntity = PromoButtonHelper.initPromoButton(getApplicationContext(), promoFolder, this.promoEntities, this.buttonPromoDefaultIndex);
        initPromoSwitcher(R.style.collage_maker_promo, R.id.promo_button_text, R.id.promo_button_image, 0, null);*/
    }

    public boolean interceptIntent() {
        return false;
    }

    protected int getToolbarId() {
        return R.id.my_awesome_toolbar;
    }

    protected int getLayoutResourceId() {
        return R.layout.select_image_layout;
    }

    /*protected int getAdViewId() {
        return R.id.collage_main_ad_id;
    }*/

    public boolean addActionBar() {
        return true;
    }

    protected void startShaderActivity() {
    }

    protected int galleryFragmentContainerId() {
        return R.id.gallery_fragment_container;
    }

    protected boolean isShowCaseActive() {
        return true;
    }

   /* protected int getShowCaseImageViewId() {
        return R.id.collage_image_show_case;
    }*/

    protected int[] getShowCaseImageArray() {
        return this.showImageResArray;
    }

    protected boolean hideMainLayoutOnGalleryOpened() {
        return true;
    }

    protected View getMainViewToHide() {
        return findViewById(R.id.collage_main_layout);
    }

    public void onResume() {
        super.onResume();
        putHouseAdBadge(R.id.promo_button_image, R.id.im_ad_badge_house);
    }

    public void myClickHandler(View view) {
        int id = view.getId();
        if (id == R.id.collage_gallery) {
            openCollage(false, false, false);
        } else if (id == R.id.collage_more_apps) {
            openCollage(true, false, false);
        } else if (id == R.id.collage_scrapbook) {
            openCollage(false, true, false);
        } else if (id == R.id.collage_camera) {
            if (BuildConfig.FLAVOR.equals("chocolate")) {
                FlavorHelper.selectFlavor(this.context);
            } else {
                takePhoto(55);
            }
        } else if (id == R.id.collage_rate) {
            rate();
        } /*else if (id == R.id.collage_promo_button) {
            PromoButtonHelper.clickHandlerForPromoButton(this.promoEntities[this.promoIndex], this);
        }*/
    }

    public boolean checkExitAd() {
        return true;
    }
}
