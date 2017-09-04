package com.lyrebirdstudio.photoactivity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdView;
import com.lyrebirdstudio.R;
import com.lyrebirdstudio.collagelib.CollageActivity;
import com.lyrebirdstudio.collagelib.CollageHelper;
import com.lyrebirdstudio.collagelib.Utility;
import com.lyrebirdstudio.common_libs.CommonLibrary;
import com.lyrebirdstudio.gallerylib.GalleryFragment;
import com.lyrebirdstudio.imagesavelib.ImageLoader;
import com.lyrebirdstudio.imagesavelib.ImageLoader.ImageLoaded;
import com.lyrebirdstudio.imagesavelib.ImageUtility;
import com.lyrebirdstudio.sticker.StickerOnlineLib;
import com.lyrebirdstudio.sticker.StickerOnlineLib.StickerJSONDownloadListener;

import java.io.File;
import java.util.Date;
import java.util.Locale;

public abstract class PhotoActivity extends AppCompatActivity {
    public static final int REQUEST_WRITE_STORAGE_BLUR = 114;
    public static final int REQUEST_WRITE_STORAGE_COLLAGE = 112;
    public static final int REQUEST_WRITE_STORAGE_FACE = 113;
    public static final int REQUEST_WRITE_STORAGE_SCRAPBOOK = 115;
    public static final int REQUEST_WRITE_STORAGE_SCRAPBOOK_BLUR = 116;
    private static final String TAG = PhotoActivity.class.getSimpleName();
    static final int delayTime = 2500;
    public final int CROP_PICTURE_COLOR_SPLASH = 109;
    public final int CROP_RESULT_COLOR_SPLASH = 110;
    public final int SELECT_IMAGE = 101;
    public final int SELECT_IMAGE_BEAUTY = 117;
    public final int SELECT_IMAGE_COLOR_EFFECT = 105;
    public final int SELECT_IMAGE_COLOR_SPLASH = 106;
    public final int SELECT_IMAGE_EYE_COLOR = 107;
    public final int SELECT_IMAGE_HDR_FX = 108;
    public final int SELECT_IMAGE_MIRROR = 103;
    public final int SELECT_IMAGE_NEURAL = 111;
    public final int SELECT_IMAGE_PIP = 104;
    public final int SELECT_IMAGE_SQUARE = 102;
    public final int SHOW_ADS_AFTER = 45;
    public final int TAKE_PICTURE = 51;
    public final int TAKE_PICTURE_BEAUTY = 60;
    public final int TAKE_PICTURE_COLLAGE = 55;
    public final int TAKE_PICTURE_COLOR_EFFECT = 53;
    public final int TAKE_PICTURE_COLOR_SPLASH = 52;
    public final int TAKE_PICTURE_EYE_COLOR = 59;
    public final int TAKE_PICTURE_HDR_FX = 58;
    public final int TAKE_PICTURE_MIRROR = 56;
    public final int TAKE_PICTURE_PIP = 57;
    public final int TAKE_PICTURE_SQUARE = 54;
    public Activity activity = this;
    public AdView adWhirlLayout;
    public Context context = this;
    boolean doubleBackToExitPressedOnce = false;
    int durationLimit = 3600000;
    public View exitScreen = null;
    public GalleryFragment galleryFragment;
    Handler galleryVisibilityHandler = new Handler();
    public ImageLoader imageLoader;
    boolean isOnActivityResult = false;
    private Handler mHandler;
    private final Runnable mRunnable = new C06383();
    ImageSwitcher myImageSwitcher;
    public int promoIndex = 0;
   /* Runnable runnablePromo = new Runnable() {
        int f871i = 1;

        public void run() {
            Log.e(PhotoActivity.TAG, "run i = " + this.f871i);
            if (PhotoActivity.this.myImageSwitcher != null) {
                PhotoActivity photoActivity = PhotoActivity.this;
                int i = this.f871i;
                this.f871i = i + 1;
                photoActivity.promoIndex = i % PhotoActivity.this.promoEntities.length;
                if (!PhotoActivity.this.promoEntities[PhotoActivity.this.promoIndex].isOnline || PhotoActivity.this.promoEntities[PhotoActivity.this.promoIndex].iconPath == null) {
                    PhotoActivity.this.myImageSwitcher.setImageResource(PhotoActivity.this.promoEntities[PhotoActivity.this.promoIndex].resId);
                } else if (PhotoActivity.this.promoEntities[PhotoActivity.this.promoIndex].resId > 0) {
                    PhotoActivity.this.myImageSwitcher.setImageResource(PhotoActivity.this.promoEntities[PhotoActivity.this.promoIndex].resId);
                } else {
                    Uri imgUri = Uri.parse(PhotoActivity.this.promoEntities[PhotoActivity.this.promoIndex].iconPath);
                    if (imgUri != null) {
                        PhotoActivity.this.myImageSwitcher.setImageURI(imgUri);
                    }
                }
                PhotoActivity.this.textViewPromo.setText(PhotoActivity.this.promoEntities[PhotoActivity.this.promoIndex].name);
                if (!PhotoActivity.this.stopPromoAnimation && PhotoActivity.this.myImageSwitcher != null) {
                    PhotoActivity.this.myImageSwitcher.postDelayed(this, 2500);
                }
            }
        }
    };*/
    public int selectImageMode = 102;
    public int showCaseIndex = 0;
    boolean showInterstitial = false;
    boolean stopPromoAnimation = false;
    TextView textViewPromo;
    Activity thisActivity = this;

    /*class C06371 implements OnClickListener {
        C06371() {
        }

        public void onClick(View v) {
            int viewId = v.getId();
            if (viewId == R.id.exit_screen_cancel) {
                PhotoActivity.this.exitScreen.setVisibility(4);
            } else if (viewId == R.id.exit_screen_ok) {
                PhotoActivity.this.finish();
            }
        }
    }*/

    class C06383 implements Runnable {
        C06383() {
        }

        public void run() {
            PhotoActivity.this.doubleBackToExitPressedOnce = false;
        }
    }

    class C10412 implements ImageLoaded {
        C10412() {
        }

        public void callFileSizeAlertDialogBuilder() {
            PhotoActivity.this.fileSizeAlertDialogBuilder();
        }
    }

   /* class C10425 implements StickerJSONDownloadListener {
        C10425() {
        }

        public void onStickerJSONDownloaded(String path) {
            VersionModel versionModel = VersionModel.loadFromJson(path);
            if (versionModel != null && PhotoActivity.this.activity != null) {
                int appVersion = -1;
                try {
                    appVersion = PhotoActivity.this.getPackageManager().getPackageInfo(PhotoActivity.this.getPackageName(), 0).versionCode;
                } catch (Exception e) {
                }
                if (versionModel.getVersionCode() > appVersion) {
                    PlayStoreVersionMessage playStoreMessage = versionModel.getPlayStoreMessage(Locale.getDefault().getISO3Language());
                    if (playStoreMessage == null) {
                        playStoreMessage = new PlayStoreVersionMessage("eng", "New version available!", "Please update the application to the new version.");
                    }
                    DialogFragment newFragment = PlayStoreVersionDialog.newInstance(playStoreMessage.title, playStoreMessage.message, versionModel.getErrorCode());
                    if (newFragment != null) {
                        if (versionModel.getErrorCode() == 2) {
                            newFragment.setCancelable(true);
                        } else {
                            newFragment.setCancelable(false);
                        }
                        newFragment.show(PhotoActivity.this.getSupportFragmentManager(), "dialog");
                    }
                }
            }
        }

        public void onStickerJSONDownloadFailed() {
            Log.e(PhotoActivity.TAG, "onStickerJSONDownloadFailed");
        }
    }*/

    class C10436 implements StickerJSONDownloadListener {
        C10436() {
        }

        public void onStickerJSONDownloaded(String path) {
            Log.e(PhotoActivity.TAG, "JSON DOWNLOADED");
        }

        public void onStickerJSONDownloadFailed() {
        }
    }

    protected abstract int galleryFragmentContainerId();

    //protected abstract int getAdViewId();

    protected abstract int getLayoutResourceId();

    protected abstract int[] getShowCaseImageArray();

   // protected abstract int getShowCaseImageViewId();

    protected abstract int getToolbarId();

    protected abstract boolean isShowCaseActive();

    public abstract void myClickHandler(View view);

    protected abstract void startShaderActivity();

    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        super.onCreate(savedInstanceState);
       // Bugsnag.init(this);
        if (checkPremium()) {
            CommonLibrary.purchased = PreferenceManager.getDefaultSharedPreferences(this.context).getBoolean("is_premium", CommonLibrary.purchased);
            Log.e(TAG, "is purchased ? " + CommonLibrary.purchased);
        }
        initImageLoader();
        if (interceptIntent()) {
            Intent intent = getIntent();
            String action = intent.getAction();
            if (savedInstanceState == null && (("android.intent.action.EDIT".equals(action) || "android.intent.action.SEND".equals(action)) && this.imageLoader != null)) {
                this.imageLoader.getImageFromIntent(intent);
            }
        }
        setContentView(getLayoutResourceId());
        boolean addSupportActionBar = addActionBar();
        if (addSupportActionBar) {
            Toolbar toolbar = (Toolbar) findViewById(getToolbarId());
            if (toolbar != null) {
                try {
                    Class.forName("android.support.v7.view.menu.MenuBuilder");
                } catch (ClassNotFoundException e) {
                    addSupportActionBar = false;
                    Log.e(TAG, "addSupportActionBar " + e.toString());
                }
                if (addSupportActionBar) {
                    setSupportActionBar(toolbar);
                    getSupportActionBar().setDisplayShowTitleEnabled(false);
                } else {
                    toolbar.setVisibility(8);
                }
            }
        }
        if (isShowCaseActive()) {
            String showCaseKey = "colmir_show_case_index";
            SharedPreferences appPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
            int storedShowCaseIndex = appPreferences.getInt(showCaseKey, 0);
            this.showCaseIndex = storedShowCaseIndex % getShowCaseImageArray().length;
            storedShowCaseIndex++;
            Editor editor = appPreferences.edit();
            editor.putInt(showCaseKey, storedShowCaseIndex);
            editor.commit();
           // ((ImageView) findViewById(getShowCaseImageViewId())).setImageResource(getShowCaseImageArray()[this.showCaseIndex]);
        }
      /*  if (!CommonLibrary.isAppPro(this.context)) {
            this.adWhirlLayout = (AdView) findViewById(getAdViewId());
            AdRequest adRequest = new Builder().build();
            try {
                if (this.adWhirlLayout != null) {
                    this.adWhirlLayout.loadAd(adRequest);
                }
            } catch (Exception e2) {
            }
            if (this.context.getResources().getBoolean(R.bool.showInterstitialAds)) {
                this.interstitial = new InterstitialAd(this);
                this.interstitial.setAdUnitId(getString(R.string.interstital_ad_id));
                this.interstitial.loadAd(new Builder().build());
                this.showInterstitial = true;
            }
        }*/
        if (savedInstanceState != null) {
            FragmentManager fm = getSupportFragmentManager();
            this.galleryFragment = (GalleryFragment) fm.findFragmentByTag("myFragmentTag");
            if (this.galleryFragment != null) {
                fm.beginTransaction().hide(this.galleryFragment).commitAllowingStateLoss();
                this.galleryFragment.setGalleryListener(CollageHelper.createGalleryListener(this, this.galleryFragment, this.showInterstitial, getMainViewToHide()));
            }
        }
        /*if (checkExitAd()) {
            this.exitScreen = findViewById(R.id.layout_admob_native_exit);
            findViewById(R.id.exit_screen_ok).setOnClickListener(this.exitAdListener);
            findViewById(R.id.exit_screen_cancel).setOnClickListener(this.exitAdListener);
            if (!(CommonLibrary.purchased || CommonLibrary.isAppPro(this))) {
                AdmobNativeAdvancedHelper admobNativeAdvancedHelper = new AdmobNativeAdvancedHelper(this, R.string.admob_native_advanced_exit_ad, R.id.exit_nativeAdContainer, R.layout.admob_native_ad_app_install_front, R.layout.admob_native_ad_content_front, false, ViewCompat.MEASURED_STATE_MASK);
            }
        }*/
       // downloadPlayVersionJSON();
        downloadStickerJSON();
    }

    public void initImageLoader() {
        this.imageLoader = new ImageLoader(this);
        this.imageLoader.setListener(new C10412());
    }

    public boolean checkPremium() {
        return false;
    }

    public String getAdMessage() {
        return "PHOTO_ACTIVITY";
    }

    public boolean addActionBar() {
        return true;
    }

    public boolean checkDoubleClickWhenExit() {
        return false;
    }

    public boolean checkExitAd() {
        return false;
    }

    public boolean interceptIntent() {
        return true;
    }

    protected boolean hideMainLayoutOnGalleryOpened() {
        return false;
    }

    protected View getMainViewToHide() {
        return null;
    }

    private void getGoogleAnalyticsTracker() {
    }

    private void hitGoogleAnalyticsTracker() {
    }

    private void stopHitGoogleAnalyticsTracker() {
    }

    public void onStart() {
        super.onStart();
        hitGoogleAnalyticsTracker();
       /* if (!this.isOnActivityResult) {
            showSomething();
        }*/
        this.isOnActivityResult = false;
    }

    public void onStop() {
        stopHitGoogleAnalyticsTracker();
        super.onStop();
    }

    public void onDestroy() {
        if (this.adWhirlLayout != null) {
            this.adWhirlLayout.removeAllViews();
            this.adWhirlLayout.destroy();
        }
        if (this.imageLoader != null) {
            this.imageLoader.closeCursor();
        }
        super.onDestroy();
    }

  /*  public void showSomething() {
        ChangeLog cl = new ChangeLog(this);
        if (cl.firstRun()) {
            cl.getLogDialog().show();
        }
        AppiraterBase.checkAppiraterZ(this);
    }*/

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.photo, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_rate) {
            rate();
            return true;
        } else if (id == R.id.action_face) {
            ImageUtility.launchFacebook(this);
            return true;
        } else if (id == R.id.action_twitter) {
            ImageUtility.followTwitter(this.activity);
            return true;
        } else if (id == R.id.action_inst) {
            ImageUtility.launchInstagram(this);
            return true;
        } else if (id == R.id.action_share) {
            try {
                Intent i = new Intent("android.intent.action.SEND");
                i.setType("text/plain");
                i.putExtra("android.intent.extra.SUBJECT", getApplicationInfo().loadLabel(getPackageManager()).toString());
                i.putExtra("android.intent.extra.TEXT", getString(R.string.photo_actvity_app_recommand) + "https://play.google.com/store/apps/details?id=" + getPackageName().toLowerCase(Locale.ENGLISH) + " \n\n");
                startActivity(Intent.createChooser(i, getString(R.string.photo_activity_share_title)));
                return true;
            } catch (Exception e) {
                return true;
            }
        } else {
            if (id == R.id.action_about) {
                startActivity(new Intent(this, AboutActivity.class));
            }
            return super.onOptionsItemSelected(item);
        }
    }

    public void more() {
        if (ImageUtility.getAmazonMarket(this.context)) {
            String url = "amzn://apps/android?p=" + getPackageName().toLowerCase(Locale.ENGLISH) + "&showAll=1";
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(url));
            startActivity(intent);
            return;
        }
        Intent otherrApps = new Intent("android.intent.action.VIEW");
        otherrApps.setData(Uri.parse("market://search?q=pub:Lyrebird Studio"));
        startActivity(otherrApps);
    }

    public void rate() {
        Intent intentRateMe = new Intent("android.intent.action.VIEW");
        if (Utility.getAmazonMarket(this.context)) {
            intentRateMe.setData(Uri.parse("amzn://apps/android?p=" + getPackageName().toLowerCase(Locale.ENGLISH)));
        } else {
            intentRateMe.setData(Uri.parse("market://details?id=" + getPackageName().toLowerCase(Locale.ENGLISH)));
        }
        try {
            startActivity(intentRateMe);
        } catch (Exception e) {
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.isOnActivityResult = true;
        if (this.imageLoader == null) {
            initImageLoader();
        }
        if (requestCode == 101 || requestCode == 102 || requestCode == 103 || requestCode == 104 || requestCode == 105 || requestCode == 106 || requestCode == 107 || requestCode == 108 || requestCode == 109 || requestCode == 111) {
            if (resultCode == RESULT_OK) {
                this.selectImageMode = requestCode;
                this.imageLoader.getImageFromIntent(data);
            }
        } else if (requestCode == 110) {
            this.selectImageMode = 106;
            if (resultCode == RESULT_OK) {

                this.selectImageMode = 110;
                String resultPath = null;
                if (data != null) {
                    resultPath = data.getExtras().getString("result_path");
                }
              String  path = getCropPath();
                if (resultPath != null) {
                    path = resultPath;
                }
                if (!new File(path).exists()) {
                    path = getCropPath();
                    if (!new File(path).exists()) {
                        return;
                    }
                }
                this.imageLoader.selectedCropPath = path;
            }
            startShaderActivity();
        } else if (requestCode == 51 || requestCode == 56 || requestCode == 57 || requestCode == 54 || requestCode == 53 || requestCode == 52 || requestCode == 59 || requestCode == 58 || requestCode == 60) {
            if (resultCode == RESULT_OK) {
                Uri selectedImage = getImageUri(true);
                this.imageLoader.selectedImagePath = selectedImage.getPath();
                if (this.imageLoader.selectedImagePath != null && BitmapResizer.decodeFileSize(new File(this.imageLoader.selectedImagePath), Utility.maxSizeForDimension(this.context, 1, 1500.0f)) != null) {
                    startShaderActivity();
                }
            }
        } else if (requestCode == 55) {
            if (resultCode == RESULT_OK) {
                String  path = getImageUri(true).getPath();
                if (path != null) {
                    Intent intent = new Intent(this, CollageActivity.class);
                    intent.putExtra("selected_image_path", path);
                    startActivity(intent);
                }
            }
        } /*else if (!CommonLibrary.isAppPro(this) && requestCode == 45) {
            AdUtility.displayInterStitialWithSplashScreen(this.interstitial, this.activity, AdUtility.SPLASH_TIME_OUT_DEFAULT, getAdMessage());
        }*/ else if (requestCode == 117 && resultCode == RESULT_OK) {
            this.selectImageMode = 117;
            this.imageLoader.getImageFromIntent(data);
        }
    }

    private void fileSizeAlertDialogBuilder() {
        Point p = BitmapResizer.decodeFileSize(new File(this.imageLoader.selectedImagePath), Utility.maxSizeForDimension(this.context, 1, 1500.0f));
        if (p == null || p.x != -1) {
            startShaderActivity();
        } else {
            startShaderActivity();
        }
    }

    private Uri getImageUri(boolean toRead) {
        File photo = new File(Environment.getExternalStorageDirectory(), "pic.jpg");
        if (VERSION.SDK_INT < 24 || toRead) {
            return Uri.fromFile(photo);
        }
        return FileProvider.getUriForFile(this.context, this.context.getApplicationContext().getPackageName() + ".provider", photo);
    }

    public void onBackPressed() {
        GalleryFragment galleryFragment = CollageHelper.getGalleryFragment(this);
        if (galleryFragment != null && galleryFragment.isVisible()) {
            galleryFragment.onBackPressed();
        } else if (checkDoubleClickWhenExit()) {
            if (this.doubleBackToExitPressedOnce) {
                finish();
                return;
            }
            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, R.string.save_image_lib_press_back, 0).show();
            this.mHandler = new Handler();
            this.mHandler.postDelayed(this.mRunnable, 2000);
        } /*else if (checkExitAd()) {
            if (this.exitScreen == null) {
                this.exitScreen = findViewById(R.id.layout_admob_native_exit);
            }
            this.exitScreen.setVisibility(0);
            this.exitScreen.bringToFront();
        } */else {
            finish();
        }
    }

    public void takePhoto(int requestId) {
        if (VERSION.SDK_INT >= 23) {
            boolean permission = checkPermission(requestId);
            Log.e(TAG, "permission = " + permission);
            if (!permission) {
                return;
            }
        }
        try {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            if (VERSION.SDK_INT >= 24) {
                intent.setFlags(1);
            }
            intent.putExtra("output", getImageUri(false));
            startActivityForResult(intent, requestId);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), getString(R.string.photo_activity_no_camera), 1).show();
        }
    }

    private String getCropPath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + this.context.getResources().getString(R.string.directory) + getString(R.string.crop_file_name);
    }

    public void openGallery(int requestId) {
        if (VERSION.SDK_INT >= 23) {
            boolean permission = checkPermission(requestId);
            Log.e(TAG, "permission = " + permission);
            if (!permission) {
                return;
            }
        }
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        try {
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), requestId);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this.context, getString(R.string.save_image_lib_no_gallery), 0).show();
        }
    }

    void hideMainLayout() {
        final View v = getMainViewToHide();
        if (v != null) {
            if (this.galleryVisibilityHandler == null) {
                this.galleryVisibilityHandler = new Handler();
            }
            this.galleryVisibilityHandler.postDelayed(new Runnable() {
                public void run() {
                    v.setVisibility(4);
                }
            }, 100);
        }
    }

    void showMainLayout() {
        View v = getMainViewToHide();
        if (v != null) {
            v.setVisibility(0);
        }
    }

    public void openCollage(boolean isblur, boolean isScrapBook, boolean isShape) {
        hideMainLayout();
        int reqId = REQUEST_WRITE_STORAGE_COLLAGE;
        if (isblur && isScrapBook) {
            reqId = REQUEST_WRITE_STORAGE_SCRAPBOOK_BLUR;
        }
        if (!isblur && isScrapBook) {
            reqId = REQUEST_WRITE_STORAGE_SCRAPBOOK;
        }
        if (isblur && !isScrapBook) {
            reqId = REQUEST_WRITE_STORAGE_BLUR;
        }
        if (VERSION.SDK_INT >= 23) {
            boolean permission = checkPermission(reqId);
            Log.e(TAG, "permission = " + permission);
            if (!permission) {
                return;
            }
        }
        this.galleryFragment = CollageHelper.addGalleryFragment(this, galleryFragmentContainerId(),  !CommonLibrary.isAppPro(this.context), getMainViewToHide());
        this.galleryFragment.setCollageSingleMode(isblur);
        this.galleryFragment.setIsScrapbook(isScrapBook);
        this.galleryFragment.setIsShape(isShape);
        if (!isScrapBook) {
            this.galleryFragment.setLimitMax(GalleryFragment.MAX_COLLAGE);
        }
    }

    public boolean checkPermission(int requestId) {
        if (ContextCompat.checkSelfPermission(this.thisActivity, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return true;
        }
        if (ActivityCompat.shouldShowRequestPermissionRationale(this.thisActivity, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            Log.e(TAG, "shouldShowRequestPermissionRationale");
            educateUser(requestId);
            return false;
        }
        ActivityCompat.requestPermissions(this.thisActivity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, requestId);
        return false;
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        boolean isScrapBook = true;
        if (requestCode == REQUEST_WRITE_STORAGE_COLLAGE || requestCode == REQUEST_WRITE_STORAGE_BLUR || requestCode == REQUEST_WRITE_STORAGE_SCRAPBOOK || requestCode == REQUEST_WRITE_STORAGE_SCRAPBOOK_BLUR) {
            boolean isBlur = requestCode == REQUEST_WRITE_STORAGE_BLUR || requestCode == REQUEST_WRITE_STORAGE_SCRAPBOOK_BLUR;
            if (!(requestCode == REQUEST_WRITE_STORAGE_SCRAPBOOK || requestCode == REQUEST_WRITE_STORAGE_SCRAPBOOK_BLUR)) {
                isScrapBook = false;
            }
            if (grantResults.length <= 0 || grantResults[0] != 0) {
                showMainLayout();
            } else {
                openCollage(isBlur, isScrapBook, false);
            }
        } else if (isRequestSelectPicture(requestCode)) {
            if (grantResults.length > 0 && grantResults[0] == 0) {
                openGallery(requestCode);
            }
        } else if (isRequestTakePicture(requestCode) && grantResults.length > 0 && grantResults[0] == 0) {
            takePhoto(requestCode);
        }
    }

    boolean isRequestSelectPicture(int requestCode) {
        if (requestCode >= Callback.DEFAULT_DRAG_ANIMATION_DURATION || requestCode < 100) {
            return false;
        }
        return true;
    }

    boolean isRequestTakePicture(int requestCode) {
        if (requestCode >= 100 || requestCode < 50) {
            return false;
        }
        return true;
    }

    public void downloadStickerJSON() {
        if (this.context != null) {
            File f = StickerOnlineLib.getJsonFile(this.context, StickerOnlineLib.jsonUrl, StickerOnlineLib.folderName);
            if (f != null && f.getParentFile().isDirectory()) {
                if (!f.exists()) {
                    downloadJSON();
                } else if (new Date().getTime() - f.lastModified() > ((long) this.durationLimit)) {
                    downloadJSON();
                } else {
                    Log.e(TAG, "json wont downloaded");
                }
            }
        }
    }

  /*  public void downloadPlayVersionJSON() {
        StickerOnlineLib.downloadJSON(this.activity, getString(R.string.play_version_url), StickerOnlineLib.folderName, new C10425());
    }*/

    void downloadJSON() {
        StickerOnlineLib.downloadJSON(this.activity, StickerOnlineLib.jsonUrl, StickerOnlineLib.folderName, new C10436());
    }

    public void educateUser(final int requestId) {
        new AlertDialog.Builder(this.context).setCancelable(false).setTitle(R.string.permission_education_title).setMessage(R.string.permission_education_message).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                ActivityCompat.requestPermissions(PhotoActivity.this.activity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, requestId);
            }
        }).show();
    }

    protected void putHouseAdBadge(int adViewId, final int badgeId) {
        final View pipGrid = findViewById(adViewId);
        pipGrid.post(new Runnable() {
            public void run() {
                int[] location = new int[2];
                pipGrid.getLocationOnScreen(location);
                View imageView = PhotoActivity.this.findViewById(badgeId);
                int y = (location[1] + pipGrid.getHeight()) - imageView.getHeight();
                imageView.setX((float) ((location[0] + pipGrid.getWidth()) - ((imageView.getWidth() * 2) / 3)));
                imageView.setY((float) y);
                if (y > 0) {
                    imageView.setVisibility(0);
                }
            }
        });
    }

   /* protected void putHouseAdBadgeInParent(int adViewId, final int badgeId) {
        final View pipGrid = findViewById(adViewId);
        pipGrid.post(new Runnable() {
            public void run() {
                int[] location = new int[2];
                int[] locationParent = new int[2];
                pipGrid.getLocationOnScreen(location);
                ((View) pipGrid.getParent()).getLocationOnScreen(locationParent);
                View imageView = PhotoActivity.this.findViewById(badgeId);
                int x = ((location[0] - locationParent[0]) + pipGrid.getWidth()) - imageView.getWidth();
                int y = ((location[1] - locationParent[1]) + pipGrid.getHeight()) - imageView.getHeight();
                imageView.setVisibility(0);
                imageView.setX((float) x);
                imageView.setY((float) y);
                if (y > 0) {
                    imageView.setVisibility(0);
                }
            }
        });
    }*/

   /* public void initPromoSwitcher(final int style, int promoTextViewId, int promoImageSwitcherId, final int padding, final LayoutParams params) {
        this.myImageSwitcher = (ImageSwitcher) findViewById(promoImageSwitcherId);
        this.myImageSwitcher.setFactory(new ViewFactory() {
            public View makeView() {
                ImageView imageView = new ImageView(new ContextThemeWrapper(PhotoActivity.this.activity, style), null, 0);
                imageView.setClickable(false);
                imageView.setPadding(padding, padding, padding, padding);
                LayoutParams lp = new LayoutParams(-2, -2);
                if (params != null) {
                    lp = params;
                }
                imageView.setLayoutParams(lp);
                return imageView;
            }
        });
        this.textViewPromo = (TextView) findViewById(promoTextViewId);
        this.myImageSwitcher.setImageDrawable(getResources().getDrawable(this.promoEntities[this.promoIndex].resId));
        this.textViewPromo.setText(this.promoEntities[this.promoIndex].name);
        Animation animationOut = AnimationUtils.loadAnimation(this, R.anim.promo_scale_down);
        Animation animationIn = AnimationUtils.loadAnimation(this, R.anim.promo_scale_up);
        this.myImageSwitcher.setOutAnimation(animationOut);
        this.myImageSwitcher.setInAnimation(animationIn);
    }

    public void onResume() {
        super.onResume();
        if (this.handlerPromo != null) {
            this.stopPromoAnimation = false;
            this.handlerPromo.removeCallbacks(this.runnablePromo);
            this.handlerPromo.removeCallbacksAndMessages(null);
            this.handlerPromo.postDelayed(this.runnablePromo, 2500);
        }
    }

    public void onPause() {
        super.onPause();
        if (this.handlerPromo != null) {
            this.stopPromoAnimation = true;
            this.handlerPromo.removeCallbacks(this.runnablePromo);
            this.handlerPromo.removeCallbacksAndMessages(null);
        }
    }*/
}
