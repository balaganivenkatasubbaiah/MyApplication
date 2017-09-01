package com.lyrebirdstudio.imagesavelib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.content.FileProvider;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.InterstitialAd;
import com.lyrebirdstudio.R;

import java.io.File;
import java.util.Locale;

public class SaveImageActivity extends AppCompatActivity {
    public static boolean IMAGE_SAVED = false;
    public static long IMAGE_SAVED_TIME = 0;
    private static final String TAG = "ImageSaveActivity";
    private static final String mirrorCollagePackageName = "com.lyrebirdstudio.mirror_collage";
    private static final String mirrorImagePackageName = "com.lyrebirdstudio.mirror";
    private static final String pipCameraPackageName = "com.lyrebirdstudio.pipcamera";
    private static final String pipCollagePackageName = "com.lyrebirdstudio.pip_collage";
    int INSTAGRAM_ID = 335;
    Activity activity = this;
    SharedPreferences appPreferences;
    Context context = this;
    String folder;
    String imagePath;
    int insampleSize = 2;
    private InterstitialAd interstitial;
    Context mContext = this;
    String mirrorPromoCountName = "mirror_promo_count";
    String pipPromoCountName = "pip_promo_count";
    String selectedMirror = mirrorImagePackageName;
    String selectedPip = pipCameraPackageName;
    boolean shouldShowAds = false;
    boolean showInterstitial = false;
    boolean showPipCollage = false;
    String twitterMessage;

   /* class PromoMirrorTask extends AsyncTask<Void, Void, PromoMirrorView> {
        PromoMirrorTask() {
        }

        protected void onPreExecute() {
        }

        protected PromoMirrorView doInBackground(Void... params) {
            return SaveImageActivity.this.addMirrorView();
        }

        protected void onPostExecute(final PromoMirrorView mirrorView) {
            if (mirrorView != null) {
                RelativeLayout mainLayout = (RelativeLayout) SaveImageActivity.this.findViewById(R.id.save_image_main_layout);
                LayoutParams lp = new LayoutParams(-2, -2);
                lp.setMargins(0, 0, 0, 0);
                lp.addRule(3, R.id.save_image_divider);
                mirrorView.setId(R.id.promo_mirror_id);
                mainLayout.addView(mirrorView, lp);
                mainLayout.bringToFront();
                TextView promoText = (TextView) SaveImageActivity.this.findViewById(R.id.mirror_promo_text);
                lp = (LayoutParams) promoText.getLayoutParams();
                lp.addRule(8, R.id.promo_mirror_id);
                promoText.setLayoutParams(lp);
                promoText.setVisibility(0);
                promoText.bringToFront();
                mirrorView.postDelayed(new Runnable() {
                    public void run() {
                        mirrorView.startAnimator();
                    }
                }, 2000);
                mainLayout.requestLayout();
                if (SaveImageActivity.this.appPreferences == null) {
                    SaveImageActivity.this.appPreferences = PreferenceManager.getDefaultSharedPreferences(SaveImageActivity.this.context);
                }
                Editor editor = SaveImageActivity.this.appPreferences.edit();
                editor.putInt(SaveImageActivity.this.mirrorPromoCountName, SaveImageActivity.this.appPreferences.getInt(SaveImageActivity.this.mirrorPromoCountName, 0) + 1);
                editor.commit();
            }
        }
    }

    class PromoPipCameraTask extends AsyncTask<Void, Void, PromoPipCamera> {
        PromoPipCameraTask() {
        }

        protected void onPreExecute() {
        }

        protected PromoPipCamera doInBackground(Void... params) {
            return SaveImageActivity.this.addPipCameraView();
        }

        protected void onPostExecute(PromoPipCamera mirrorView) {
            if (mirrorView != null) {
                int padding = (int) SaveImageActivity.this.getResources().getDimension(R.dimen.promoList_item_padding);
                RelativeLayout mainLayout = (RelativeLayout) SaveImageActivity.this.findViewById(R.id.save_image_main_layout);
                LayoutParams lp = new LayoutParams(-2, -2);
                lp.setMargins(padding, 0, padding, 0);
                lp.addRule(3, R.id.save_image_divider);
                mirrorView.setId(R.id.promo_mirror_id);
                mainLayout.addView(mirrorView, lp);
                mainLayout.bringToFront();
                TextView promoText = (TextView) SaveImageActivity.this.findViewById(R.id.mirror_promo_text);
                lp = (LayoutParams) promoText.getLayoutParams();
                lp.addRule(6, R.id.promo_mirror_id);
                if (SaveImageActivity.this.showPipCollage) {
                    promoText.setText(R.string.promo_pip_collage_message);
                    promoText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.promo_pip_collage, 0, 0, 0);
                } else {
                    promoText.setText(R.string.promo_pip_cam_message);
                    promoText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.promo_pip_camera_icon, 0, 0, 0);
                }
                promoText.setLayoutParams(lp);
                promoText.setVisibility(0);
                promoText.bringToFront();
                mainLayout.requestLayout();
                if (SaveImageActivity.this.appPreferences == null) {
                    SaveImageActivity.this.appPreferences = PreferenceManager.getDefaultSharedPreferences(SaveImageActivity.this.context);
                }
                Editor editor = SaveImageActivity.this.appPreferences.edit();
                editor.putInt(SaveImageActivity.this.pipPromoCountName, SaveImageActivity.this.appPreferences.getInt(SaveImageActivity.this.pipPromoCountName, 0) + 1);
                editor.commit();
            }
        }
    }

    class C10182 implements AdmobNativeAdvancedAdLoadListener {
        C10182() {
        }

        public void onAdLoaded() {
            Log.e(SaveImageActivity.TAG, "ad loaded");
            SaveImageActivity.this.admobBannerAd = (AdView) SaveImageActivity.this.findViewById(R.id.save_image_ad_id);
            SaveImageActivity.this.admobBannerAd.setVisibility(8);
        }

        public void onAdFailed() {
            Log.e(SaveImageActivity.TAG, "admob native onAdFailed");
            SaveImageActivity.this.findViewById(R.id.save_image_native_advanced_ad_admob).setVisibility(8);
        }
    }
*/
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_save_screen);
        IMAGE_SAVED = true;
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
        boolean addSupportActionBar = VERSION.SDK_INT >= 13;
        IMAGE_SAVED_TIME = System.currentTimeMillis();
        if (addSupportActionBar) {
            try {
                Class.forName("android.support.v7.view.menu.MenuBuilder");
            } catch (ClassNotFoundException e) {
                addSupportActionBar = false;
            }
        }
        if (addSupportActionBar) {
            setSupportActionBar(toolbar);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
        } else {
            toolbar.setVisibility(8);
        }
        this.showInterstitial = getResources().getBoolean(R.bool.showInterstitialAds);
        if (getResources().getBoolean(R.bool.showMirrorCollage)) {
            this.selectedMirror = mirrorCollagePackageName;
        }
        this.showPipCollage = getResources().getBoolean(R.bool.shouldAddPromoPipCollage);
        if (this.showPipCollage) {
            this.selectedPip = pipCollagePackageName;
        }
        this.appPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
        /*boolean isAppPro = CommonLibrary.isAppPro(this);
        int pipPromoCount = this.appPreferences.getInt(this.pipPromoCountName, 0);
        boolean shouldAddMirrorPromo = !isAppPro && getResources().getBoolean(R.bool.shouldAddPromoMirror) && !ImageUtility.isPackageInstalled(this.selectedMirror, this.context) && this.appPreferences.getInt(this.mirrorPromoCountName, 0) < 3;
        boolean shouldAddPipCameraPromo = !isAppPro && getResources().getBoolean(R.bool.shouldAddPromoPipCamera) && !ImageUtility.isPackageInstalled(this.selectedPip, this.context) && pipPromoCount < 2;*/
        Bundle extras = getIntent().getExtras();
        File fileImage = null;
        if (extras != null) {
            this.imagePath = extras.getString("imagePath");
            if (this.imagePath == null) {
                finish();
                return;
            }
            this.folder = extras.getString("folder");
            this.twitterMessage = extras.getString("twitter_message");
            this.shouldShowAds = extras.getBoolean("should_show_ads");
            fileImage = new File(this.imagePath);
        } else {
            this.shouldShowAds = true;
        }
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setDisplayShowTitleEnabled(true);
            actionbar.setTitle(R.string.save_image_menu_item_share);
            Log.e(TAG, "getSupportActionBar not null");
        } else {
            Log.e(TAG, "getSupportActionBar null");
        }
      /*  if ((!shouldAddPipCameraPromo && !shouldAddMirrorPromo) || fileImage == null || !fileImage.exists()) {
            String facebookNativeAdId = getString(R.string.facebook_native_ad_id);
            if (!isAppPro && this.shouldShowAds && facebookNativeAdId != null && facebookNativeAdId.length() > 10 && !facebookNativeAdId.contains("x")) {
                final boolean z = isAppPro;
                new FacebookNativeAdHelperSaveLib((LinearLayout) findViewById(R.id.save_image_native_advanced_ad_admob), this.context, (ViewGroup) findViewById(R.id.save_image_main_layout), R.id.save_image_ad_id, facebookNativeAdId, R.layout.fan_native_ad_unit).setFacebookNativeAdListener(new FacebookNativeAdListener() {
                    public void onFANAdLoaded() {
                    }

                    public void onFANError() {
                        SaveImageActivity.this.loadAdmobAds(z);
                        Log.e(SaveImageActivity.TAG, "onFANError");
                    }
                });
            } else if (!isAppPro && this.shouldShowAds && (facebookNativeAdId == null || facebookNativeAdId.length() < 10 || facebookNativeAdId.contains("x"))) {
                loadAdmobAds(isAppPro);
            }
            if (isAppPro) {
                findViewById(R.id.save_image_native_advanced_ad_admob).setVisibility(8);
            }
        } *//*else if (shouldAddMirrorPromo) {
            new PromoMirrorTask().execute(new Void[0]);
        } else if (shouldAddPipCameraPromo) {
            this.selectedMirror = this.selectedPip;
            new PromoPipCameraTask().execute(new Void[0]);
        }*/
      /*  if (this.shouldShowAds) {
            this.admobBannerAd = (AdView) findViewById(R.id.save_image_ad_id);
            this.admobBannerAd.loadAd(new Builder().build());
        } else {
            this.admobBannerAd = (AdView) findViewById(R.id.save_image_ad_id);
            this.admobBannerAd.setVisibility(8);
        }
        if (!isAppPro && this.showInterstitial) {
            this.interstitial = new InterstitialAd(this);
            this.interstitial.setAdUnitId(getString(R.string.interstital_ad_id));
            this.interstitial.loadAd(new Builder().build());
        }
        getGoogleAnalyticsTracker();
        AppRate.with(this).initialLaunchCount(5).minInterval(ExoPlayerFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS).retryPolicy(RetryPolicy.INCREMENTAL).theme(AppRateTheme.YELLOW).installedSince(Utils.dayToMilliSeconds(0.5d)).checkAndShow();
        ArrayList<PromoSquareModel> promoSquareData = new ArrayList();
        promoSquareData.add(new PromoSquareModel(R.drawable.square_promo_art, "79023", "com.lyrebirdstudio.art_filter"));
        promoSquareData.add(new PromoSquareModel(R.drawable.square_promo_face_cam, "65491", "com.lyrebirdstudio.face_camera"));
        promoSquareData.add(new PromoSquareModel(R.drawable.square_promo_video_editor, "55964", "com.lyrebirdstudio.videoeditor"));
        promoSquareData.add(new PromoSquareModel(R.drawable.square_promo_art_filter, "15837", "com.lyrebirdstudio.art"));
        Collections.shuffle(promoSquareData, new Random(System.nanoTime()));
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview_promo_square);
        recyclerView.setAdapter(new PromoSquareRecyclerAdapter(promoSquareData, this.activity));
        LayoutManager linearLayoutManager = new LinearLayoutManager(this.context);
        linearLayoutManager.setOrientation(0);
        recyclerView.setLayoutManager(linearLayoutManager);*/
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save_image_toolbar_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_rate) {
            rate();
            return true;
        } /*else if (id == R.id.action_face) {
            ImageUtility.launchFacebook(this);
            return true;
        } else if (id == R.id.action_twitter) {
            ImageUtility.followTwitter(this.activity);
            return true;
        } else if (id == R.id.action_inst) {
            ImageUtility.launchInstagram(this);
            return true;
        } */else if (id == R.id.action_share) {
            try {
                Intent i = new Intent("android.intent.action.SEND");
                i.setType("text/plain");
                i.putExtra("android.intent.extra.SUBJECT", getApplicationInfo().loadLabel(getPackageManager()).toString());
                i.putExtra("android.intent.extra.TEXT", getString(R.string.recommand_message) + "https://play.google.com/store/apps/details?id=" + getPackageName().toLowerCase() + " \n\n");
                startActivity(Intent.createChooser(i, "choose one"));
                return true;
            } catch (Exception e) {
                return true;
            }
        } else {
            if (id == R.id.action_save_home) {
                try {
                    Class homeClass = Class.forName(this.context.getPackageManager().getLaunchIntentForPackage(this.context.getPackageName()).getComponent().getClassName());
                    if (homeClass != null) {
                        Log.d(TAG, "home class " + homeClass.getSimpleName());
                        Intent intent = new Intent(getApplicationContext(), homeClass);
                        intent.addFlags(67108864);
                        startActivity(intent);
                        /*if (!CommonLibrary.isAppPro(this) && this.showInterstitial) {
                            AdUtility.displayInterStitialWithSplashScreen(this.interstitial, this, AdUtility.SPLASH_TIME_OUT_DEFAULT, "SAVED_IMAGE_HOME_BUTTON");
                        }*/
                    }
                } catch (ClassNotFoundException e2) {
                    e2.printStackTrace();
                }
            }
            if (id == 16908332) {
                finish();
            }
            return super.onOptionsItemSelected(item);
        }
    }

    void rate() {
        Intent intentRateMe = new Intent("android.intent.action.VIEW");
      /*  if (ImageUtility.getAmazonMarket(this.context)) {
            intentRateMe.setData(Uri.parse("amzn://apps/android?p=" + getPackageName().toLowerCase()));
        } else*/ {
            intentRateMe.setData(Uri.parse("market://details?id=" + getPackageName().toLowerCase()));
        }
        startActivity(intentRateMe);
    }

    public void myClickHandler(View view) {
        Toast msg;
        String message = "\n\n" + getString(R.string.save_image_created) + " " + getApplicationName(this.mContext) + "." + "\n\n https://play.google.com/store/apps/details?id=" + getPackageName().toLowerCase(Locale.ENGLISH);
        int itemId = view.getId();
        if (itemId == R.id.saved_message) {
            msg = Toast.makeText(this.context, String.format(getString(R.string.save_image_lib_image_saved_message), new Object[]{getString(R.string.directory)}), 1);
            msg.setGravity(17, msg.getXOffset() / 2, msg.getYOffset() / 2);
            msg.show();
        } else if (itemId == R.id.share_image_whatsapp) {
            try {
                Intent shareIntent = new Intent();
               File downloadedPic = new File(this.imagePath);
                shareIntent.setType("image/*");
                shareIntent.setAction("android.intent.action.SEND");
                if (VERSION.SDK_INT >= 24) {
                    shareIntent.setFlags(1);
                    shareIntent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(this.context, this.context.getApplicationContext().getPackageName() + ".provider", downloadedPic));
                } else {
                    shareIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(downloadedPic));
                }
                shareIntent.putExtra("android.intent.extra.TEXT", message);
                shareIntent.setPackage("com.whatsapp");
                startActivity(shareIntent);
              /*  if (!CommonLibrary.isAppPro(this) && this.showInterstitial) {
                    AdUtility.displayInterStitialWithSplashScreen(this.interstitial, this, AdUtility.SPLASH_TIME_OUT_DEFAULT, "SAVED_IMAGE_WHATSAPP");
                }*/
            } catch (Exception e) {
                Log.e(TAG, e.toString());
                msg = Toast.makeText(this.mContext, getString(R.string.no_whatsapp_app), 1);
                msg.setGravity(17, msg.getXOffset() / 2, msg.getYOffset() / 2);
                msg.show();
            }
        } else if (itemId == R.id.share_image_instagram) {
            try {
                Intent instagram = new Intent("android.intent.action.SEND");
                instagram.setType("image/*");
               File downloadedPic = new File(this.imagePath);
                if (VERSION.SDK_INT >= 24) {
                    instagram.setFlags(1);
                    instagram.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(this.context, this.context.getApplicationContext().getPackageName() + ".provider", downloadedPic));
                } else {
                    instagram.putExtra("android.intent.extra.STREAM", Uri.fromFile(downloadedPic));
                }
                instagram.putExtra("android.intent.extra.TEXT", this.twitterMessage);
                instagram.setPackage("com.instagram.android");
                startActivityForResult(instagram, this.INSTAGRAM_ID);
            } catch (Exception e2) {
                msg = Toast.makeText(this.mContext, getString(R.string.no_instagram_app), 1);
                msg.setGravity(17, msg.getXOffset() / 2, msg.getYOffset() / 2);
                msg.show();
            }
        } else if (itemId == R.id.share_image_facebook) {
            try {
                Intent intentFace = new Intent("android.intent.action.SEND");
                intentFace.setType("image/*");
                intentFace.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(this.imagePath)));
                intentFace.setPackage("com.facebook.katana");
                startActivity(intentFace);
               /* if (!CommonLibrary.isAppPro(this) && this.showInterstitial) {
                    AdUtility.displayInterStitialWithSplashScreen(this.interstitial, this, AdUtility.SPLASH_TIME_OUT_DEFAULT, "SAVED_IMAGE_FACEBOOK");
                }*/
            } catch (Exception e3) {
                msg = Toast.makeText(this.context, getString(R.string.no_face_app), 1);
                msg.setGravity(17, msg.getXOffset() / 2, msg.getYOffset() / 2);
                msg.show();
            }
        } else if (itemId == R.id.share_image_more) {
            try {
                Intent picMessageIntent = new Intent("android.intent.action.SEND");
                picMessageIntent.setFlags(268435456);
                picMessageIntent.setType("image/jpeg");
                if (this.imagePath != null) {
                    File downloadedPic = new File(this.imagePath);
                    if (VERSION.SDK_INT >= 24) {
                        picMessageIntent.setFlags(1);
                        picMessageIntent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(this.context, this.context.getApplicationContext().getPackageName() + ".provider", downloadedPic));
                    } else {
                        picMessageIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(downloadedPic));
                    }
                    startActivity(picMessageIntent);
                }
            } catch (Exception e4) {
                msg = Toast.makeText(this.mContext, getString(R.string.no_email_intent), 1);
                msg.setGravity(17, msg.getXOffset() / 2, msg.getYOffset() / 2);
                msg.show();
            }
        } /*else if (itemId == R.id.share_image_twitter) {
            if (ImageUtility.isAppInstalled(getString(R.string.twitter_package), this.activity)) {
                ImageUtility.sendShareTwit(this.context, this.twitterMessage, this.imagePath);
                if (!CommonLibrary.isAppPro(this) && this.showInterstitial) {
                    AdUtility.displayInterStitialWithSplashScreen(this.interstitial, this, AdUtility.SPLASH_TIME_OUT_DEFAULT, "SAVED_IMAGE_FACEBOOK");
                    return;
                }
                return;
            }
            msg = Toast.makeText(this.context, this.context.getString(R.string.save_image_no_twitter_app), 1);
            msg.setGravity(17, msg.getXOffset() / 2, msg.getYOffset() / 2);
            msg.show();
        }*/ else if (itemId == R.id.mirror_promo_text) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("market://details?id=" + this.selectedMirror));
            startActivity(intent);
        }
    }

    /*public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == this.INSTAGRAM_ID && !CommonLibrary.isAppPro(this) && this.showInterstitial) {
            AdUtility.displayInterStitialWithSplashScreen(this.interstitial, this, AdUtility.SPLASH_TIME_OUT_DEFAULT, "SAVED_IMAGE_INSTAGRAM");
        }
    }*/

    public static String getApplicationName(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int stringId = applicationInfo.labelRes;
        return stringId == 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(stringId);
    }

    private void getGoogleAnalyticsTracker() {
    }

    private void hitGoogleAnalyticsTracker() {
    }

    private void stopHitGoogleAnalyticsTracker() {
    }

    public void onStart() {
        hitGoogleAnalyticsTracker();
        super.onStart();
    }

    public void onStop() {
        stopHitGoogleAnalyticsTracker();
        super.onStop();
    }

    protected void onResume() {
        super.onResume();
    }

    public void onDestroy() {
      /*  if (this.admobBannerAd != null) {
            this.admobBannerAd.removeAllViews();
            this.admobBannerAd.destroy();
        }*/
        super.onDestroy();
    }

  /*  private PromoMirrorView addMirrorView() {
        int width;
        int height;
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int screenHeightPixels = metrics.heightPixels;
        int screenWidthPixels = metrics.widthPixels;
        Display display = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        if (VERSION.SDK_INT >= 13) {
            Point size = new Point();
            display.getSize(size);
            width = size.x;
            height = size.y;
        } else {
            width = display.getWidth();
            height = display.getHeight();
        }
        if (screenWidthPixels <= 0) {
            screenWidthPixels = width;
        }
        if (screenHeightPixels <= 0) {
            screenHeightPixels = height;
        }
        Bitmap bitmapMirror = ImageUtility.decodeBitmapFromFile(this.imagePath, 540);
        if (bitmapMirror == null) {
            return null;
        }
        return new PromoMirrorView(this, screenWidthPixels, screenHeightPixels, bitmapMirror, this.selectedMirror);
    }

    private PromoPipCamera addPipCameraView() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int screenHeightPixels = metrics.heightPixels;
        int screenWidthPixels = metrics.widthPixels;
        Display display = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        if (screenWidthPixels <= 0) {
            screenWidthPixels = width;
        }
        if (screenHeightPixels <= 0) {
            screenHeightPixels = height;
        }
        Bitmap bitmapMirror = ImageUtility.decodeBitmapFromFile(this.imagePath, 540);
        if (bitmapMirror == null) {
            return null;
        }
        return new PromoPipCamera(this, screenWidthPixels, bitmapMirror, this.selectedPip);
    }

    void loadAdmobAds(boolean isAppPro) {
        new AdmobNativeAdvancedHelper(this.activity, R.string.admob_native_advanced_ad_id, R.id.save_image_native_advanced_ad_admob, R.layout.admob_native_ad_app_install_back, R.layout.admob_native_ad_content_back, true, AdmobNativeAdvancedHelper.TEXT_COLOR_SENTINEL).setAdmobNativeAdvancedAdLoadListener(new C10182());
    }*/
}
