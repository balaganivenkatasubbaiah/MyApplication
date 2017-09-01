package com.lyrebirdstudio.collagelib;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.NinePatchDrawable;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.gms.ads.InterstitialAd;
import com.lyrebirdstudio.R;
import com.lyrebirdstudio.canvastext.BaseData;
import com.lyrebirdstudio.canvastext.CanvasTextView;
import com.lyrebirdstudio.canvastext.DecorateView;
import com.lyrebirdstudio.canvastext.DecorateView.OnDecorateViewTouchUp;
import com.lyrebirdstudio.canvastext.MyMatrix;
import com.lyrebirdstudio.canvastext.TextData;
import com.lyrebirdstudio.canvastext.TextLibHelper;
import com.lyrebirdstudio.collagelib.MyAdapter.CurrentCollageIndexChangedListener;
import com.lyrebirdstudio.collagelib.RotationGestureDetector.OnRotationGestureListener;
import com.lyrebirdstudio.common_libs.CommonLibrary;
import com.lyrebirdstudio.gallerylib.GalleryUtility;
import com.lyrebirdstudio.imagesavelib.SaveImageActivity;
import com.lyrebirdstudio.linecolorpicker.LineColorPicker;
import com.lyrebirdstudio.linecolorpicker.OnColorChangedListener;
import com.lyrebirdstudio.linecolorpicker.Palette;
import com.lyrebirdstudio.lyrebirdlibrary.BlurBuilderNormal;
import com.lyrebirdstudio.lyrebirdlibrary.FullEffectFragment;
import com.lyrebirdstudio.lyrebirdlibrary.FullEffectFragment.FullBitmapReady;
import com.lyrebirdstudio.lyrebirdlibrary.LibUtility;
import com.lyrebirdstudio.lyrebirdlibrary.Parameter;
import com.lyrebirdstudio.pattern.PatternHelper;
import com.lyrebirdstudio.pattern.PatternHelper.PatternBitmapColorListener;
import com.lyrebirdstudio.sticker.StickerData;
import com.lyrebirdstudio.sticker.StickerLibHelper;
import com.lyrebirdstudio.sticker.StickerView;
import com.lyrebirdstudio.pointlist.Collage;
import com.lyrebirdstudio.pointlist.CollageLayout;
import com.lyrebirdstudio.pointlist.MaskPairSvg;
import com.lyrebirdstudio.svg.Svg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class CollageActivity extends FragmentActivity {
    public static final int INDEX_COLLAGE = 0;
    public static final int INDEX_COLLAGE_BACKGROUND = 1;
    public static final int INDEX_COLLAGE_BLUR = 4;
    public static final int INDEX_COLLAGE_BORDER = 6;
    public static final int INDEX_COLLAGE_CASCADE = 5;
    public static final int INDEX_COLLAGE_INVISIBLE_VIEW = 7;
    public static final int INDEX_COLLAGE_RATIO = 3;
    public static final int INDEX_COLLAGE_SPACE = 2;
    static final int SAVE_IMAGE_ID = 1543;
    public static final int TAB_SIZE = 8;
    private static final String TAG = CollageActivity.class.getSimpleName();
    private static final float UPPER_SIZE_FOR_LOAD = 1500.0f;
    public static boolean isGridLayoutLocked = false;
    final String CROP_TAG = "crop_fragment";
    int RATIO_BUTTON_SIZE = 11;
    Activity activity = this;
    FragmentActivity activityFragment = this;
    boolean bgImageIsWaiting = false;
    Bitmap[] bitmapList;
    private int blurRadius = 14;
    Bitmap btmDelete = null;
    Bitmap btmScale = null;
    MyAdapter collageAdapter;
    RecyclerView collageRecyclerView;
    CollageView collageView;
    final Handler collageVisibilityHandler = new Handler();
    LinearLayout colorContainer;
    int colorDefault;
    int colorSelected;
    Context context = this;
    ViewGroup contextFooter;
   // FragmentCrop cropFragment;
   /* CropListener cropListener = new CropListener() {
        public void cropCancelled() {
            CollageActivity.this.getSupportFragmentManager().beginTransaction().remove(CollageActivity.this.cropFragment).commitAllowingStateLoss();
            CollageActivity.this.setVisibilityOfCollage(0);
        }

        public void cropApply(int leftPos, int topPos, int rightPos, int bottomPos) {
            CollageActivity.this.collageView.setCropBitmap(leftPos, topPos, rightPos, bottomPos);
            CollageActivity.this.cropFragment.setBitmap(null);
            CollageActivity.this.getSupportFragmentManager().beginTransaction().remove(CollageActivity.this.cropFragment).commitAllowingStateLoss();
            CollageActivity.this.setVisibilityOfCollage(0);
        }
    };*/
    public final int defaultSizeProgressForBlur = 45;
    OnClickListener dialogClickListener = new C06047();
    FullEffectFragment fullEffectFragment;
    int height;
    InterstitialAd interstitial;
    final String isGridLockedKey = "is_grid_locked2";
    boolean isScrapBook = false;
    boolean isShape = false;
    LineColorPicker lineColorPicker;
    Matrix f2024m = new Matrix();
    private RotationGestureDetector mRotationDetector;
    OnSeekBarChangeListener mSeekBarListener = new C06025();
    RelativeLayout mainLayout;
    float mulX = 1.0f;
    float mulY = 1.0f;
    NinePatchDrawable npd;
    Button originalInstagram;
    Parameter[] parameterList;
    PatternHelper patternHelper;
    Button[] ratioButtonArray;
    RecyclerView recyclerViewInnerPattern;
    AlertDialog saveImageAlert;
    float screenDensity = 1.0f;
    SeekBar seekBarBorder;
    SeekBar seekBarPadding;
    SeekBar seekBarRound;
    SeekBar seekbarBlur;
    SeekBar seekbarCascadeBlur;
    SeekBar seekbarCascadeNumber;
    SeekBar seekbarSize;
    View selectFilterTextView;
    boolean selectImageForAdj = false;
    View selectSwapTextView;
    private Animation slideLeftIn;
    private Animation slideLeftOut;
    private Animation slideRightIn;
    private Animation slideRightOut;
    int stickerFragemntContinerId = R.id.sticker_grid_fragment_container;
    StickerLibHelper stickerLibHelper;
    boolean swapMode = false;
    View[] tabButtonList;
    FrameLayout textAndStickerViewContainer;
    int textFragemntContinerId = R.id.collage_text_view_fragment_container;
    TextLibHelper textLibHelper;
    float topOffset;
    float totalOffset;
    ViewFlipper viewFlipper;
    int width;

    class C06025 implements OnSeekBarChangeListener {
        C06025() {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            int id = seekBar.getId();
            if (id == R.id.seekbar_collage_blur || id == R.id.seekbar_collage_blur_cascade) {
                int progress = seekBar.getProgress();
                float radius = ((float) progress) / 4.0f;
                if (radius > 25.0f) {
                    radius = 25.0f;
                }
                if (radius < 0.0f) {
                    radius = 0.0f;
                }
                boolean isCascade = id == R.id.seekbar_collage_blur_cascade;
                if (isCascade) {
                    if (CollageActivity.this.seekbarBlur != null) {
                        CollageActivity.this.seekbarBlur.setProgress(progress);
                    }
                } else if (CollageActivity.this.seekbarCascadeBlur != null) {
                    CollageActivity.this.seekbarCascadeBlur.setProgress(progress);
                }
                if (CollageActivity.this.collageView != null) {
                    CollageActivity.this.collageView.setBlurBitmap((int) radius, isCascade);
                }
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            int id = seekBar.getId();
            if (id == R.id.seekbar_round) {
                if (CollageActivity.this.collageView != null) {
                    CollageActivity.this.collageView.setCornerRadius((float) progress);
                }
            } else if (id == R.id.seekbar_padding) {
                if (CollageActivity.this.collageView != null) {
                    CollageActivity.this.collageView.setPathPadding(CollageActivity.this.collageView.currentCollageIndex, (float) progress, false);
                }
            } else if (id == R.id.seekbar_size) {
                if (CollageActivity.this.collageView != null) {
                    CollageActivity.this.collageView.setCollageSize(CollageActivity.this.collageView.currentCollageIndex, CollageActivity.this.collageView.sizeMatrix, progress, false);
                }
            } else if (id == R.id.seekbar_collage_blur) {
            } else {
                if (id == R.id.seekbar_cascade_number) {
                    if (CollageActivity.this.collageView != null) {
                        CollageActivity.this.collageView.cascadeNumber = progress + 1;
                        CollageActivity.this.collageView.invalidate();
                    }
                } else if (id == R.id.seekbar_collage_border) {
                    if (CollageActivity.this.screenDensity <= 0.0f) {
                        CollageActivity.this.screenDensity = 1.0f;
                    }
                    Svg.strokeSize = (((float) (progress - 1)) * CollageActivity.this.screenDensity) * BlurBuilderNormal.BITMAP_SCALE;
                    if (CollageActivity.this.collageView != null) {
                        CollageActivity.this.collageView.invalidate();
                    }
                }
            }
        }
    }

    class C06036 implements OnHierarchyChangeListener {

        class C10111 implements OnDecorateViewTouchUp {
            C10111() {
            }

            public void onTouchUp(BaseData mData) {
                Matrix m = CollageActivity.this.getCurrentMatrixForSticker();
                if (m != null) {
                    mData.setImageSaveMatrix(m);
                }
            }
        }

        C06036() {
        }

        public void onChildViewAdded(View parent, View child) {
            Log.e(CollageActivity.TAG, "onChildViewAdded");
            if (child instanceof StickerView) {
                CollageActivity.this.setVisibilityOfCollage(0);
            }
            ((DecorateView) child).setOnDecorateViewTouchUp(new C10111());
        }

        public void onChildViewRemoved(View parent, View child) {
        }
    }

    class C06047 implements OnClickListener {
        C06047() {
        }

        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case -1:
                    CollageActivity.this.handleLock();
                    return;
                default:
                    return;
            }
        }
    }

    class C06058 implements OnClickListener {
        C06058() {
        }

        public void onClick(DialogInterface dialog, int id) {
        }
    }

    class C06069 implements OnClickListener {
        C06069() {
        }

        public void onClick(DialogInterface dialog, int id) {
            CollageActivity.this.collageView.deleteBitmap(CollageActivity.this.collageView.shapeIndex, CollageActivity.this.width, CollageActivity.this.width);
        }
    }

    private class BitmapWorkerTask extends AsyncTask<Bundle, Void, Void> {
        int arraySize;
        Bundle data;
        ProgressDialog progressDialog;
        Bundle savedInstanceState;

        class C06071 implements OnHierarchyChangeListener {

            class C10121 implements OnDecorateViewTouchUp {
                C10121() {
                }

                public void onTouchUp(BaseData mData) {
                    Matrix m = CollageActivity.this.getCurrentMatrixForSticker();
                    Log.e(CollageActivity.TAG, "m==null " + (m == null));
                    if (m != null) {
                        mData.setImageSaveMatrix(m);
                    }
                }
            }

            C06071() {
            }

            public void onChildViewAdded(View parent, View child) {
                DecorateView decorateView = (DecorateView) child;
                Log.e(CollageActivity.TAG, "onChildViewAdded");
                if (child instanceof StickerView) {
                    CollageActivity.this.setVisibilityOfCollage(0);
                }
                decorateView.setOnDecorateViewTouchUp(new C10121());
            }

            public void onChildViewRemoved(View parent, View child) {
            }
        }

        class C10132 implements OnColorChangedListener {
            C10132() {
            }

            public void onColorChanged(int c) {
                Log.d(CollageActivity.TAG, "Selected color " + Integer.toHexString(c));
                Svg.colorStroke = c;
                if (CollageActivity.this.collageView != null) {
                    CollageActivity.this.collageView.invalidate();
                }
            }
        }

        private BitmapWorkerTask() {
        }

        protected void onPreExecute() {
            this.progressDialog = new ProgressDialog(CollageActivity.this.context);
            this.progressDialog.setCancelable(false);
            this.progressDialog.setMessage(CollageActivity.this.getString(R.string.collage_lib_loading_message));
            this.progressDialog.show();
        }

        protected Void doInBackground(Bundle... params) {
            int i;
            this.data = params[0];
            this.savedInstanceState = params[1];
            CollageActivity.this.isScrapBook = this.data.getBoolean("is_scrap_book", false);
            CollageActivity.this.isShape = this.data.getBoolean("is_shape", false);
            long[] selectedImageList = this.data.getLongArray("photo_id_list");
            int[] selectedImageOrientationList = this.data.getIntArray("photo_orientation_list");
            this.arraySize = 0;
            if (selectedImageList == null) {
                String selectedImagePath = this.data.getString("selected_image_path");
                if (selectedImagePath != null) {
                    this.arraySize = 1;
                    CollageActivity.this.bitmapList = new Bitmap[this.arraySize];
                  //  String str = selectedImagePath;
                   // int i4 = Utility.maxSizeForDimension(CollageActivity.this.context, 3, 1500.0F);
                    CollageActivity.this.bitmapList[0] = Utility.decodeFile(selectedImagePath, Utility.maxSizeForDimension(CollageActivity.this.context, 3, CollageActivity.UPPER_SIZE_FOR_LOAD), CollageActivity.this.isScrapBook);
                }
            } else {
                this.arraySize = selectedImageList.length;
                CollageActivity.this.bitmapList = new Bitmap[this.arraySize];
                int maxDivider = this.arraySize;
                if (maxDivider < 3) {
                    maxDivider = 3;
                }
                int requiredSize = Utility.maxSizeForDimension(CollageActivity.this.context, maxDivider, CollageActivity.UPPER_SIZE_FOR_LOAD);
                int loadingImageError = 0;
                for (i = 0; i < this.arraySize; i++) {
                    Bitmap bitmap = Utility.getScaledBitmapFromId(CollageActivity.this.context, selectedImageList[i], selectedImageOrientationList[i], requiredSize, CollageActivity.this.isScrapBook);
                    if (bitmap != null) {
                        CollageActivity.this.bitmapList[i] = bitmap;
                    } else {
                        loadingImageError++;
                    }
                }
                if (loadingImageError > 0) {
                    int newSize = this.arraySize - loadingImageError;
                    Bitmap[] arr = new Bitmap[newSize];
                    int j = 0;
                    for (i = 0; i < this.arraySize; i++) {
                        if (CollageActivity.this.bitmapList[i] != null) {
                            arr[j] = CollageActivity.this.bitmapList[i];
                            j++;
                        }
                    }
                    this.arraySize = newSize;
                    CollageActivity.this.bitmapList = arr;
                }
            }
            CollageActivity.this.parameterList = new Parameter[this.arraySize];
            for (i = 0; i < CollageActivity.this.parameterList.length; i++) {
                CollageActivity.this.parameterList[i] = new Parameter();
            }
            return null;
        }

        protected void onPostExecute(Void bitmap) {
            try {
                this.progressDialog.dismiss();
            } catch (Exception e) {
            }
            if (this.arraySize <= 0) {
                Toast msg = Toast.makeText(CollageActivity.this.context, R.string.collage_lib_loading_error_message, 1);
                msg.setGravity(17, msg.getXOffset() / 2, msg.getYOffset() / 2);
                msg.show();
                CollageActivity.this.finish();
                return;
            }
            if (!CollageActivity.this.isScrapBook) {
                CollageActivity.isGridLayoutLocked = PreferenceManager.getDefaultSharedPreferences(CollageActivity.this.context).getBoolean("is_grid_locked2", CollageActivity.isGridLayoutLocked);
                CollageActivity.this.setLockViewStates();
            }
            if (Collage.collageIconArray[CollageActivity.this.bitmapList.length - 1] != CollageActivity.this.collageAdapter.iconList) {
                CollageActivity.this.collageAdapter.setData(Collage.collageIconArray[CollageActivity.this.bitmapList.length - 1]);
                CollageActivity.this.collageAdapter.notifyDataSetChanged();
            }
            if (CollageActivity.this.isScrapBook) {
                CollageActivity.this.btmDelete = BitmapFactory.decodeResource(CollageActivity.this.getResources(), R.drawable.scrapbook_remove);
                CollageActivity.this.btmScale = BitmapFactory.decodeResource(CollageActivity.this.getResources(), R.drawable.scrapbook_scale);
            }
            if (CollageActivity.this.isScrapBook) {
                CollageActivity.this.npd = (NinePatchDrawable) ContextCompat.getDrawable(CollageActivity.this.context, R.drawable.shadow_7);
            }
            CollageActivity.this.collageView = new CollageView(CollageActivity.this.context, CollageActivity.this.width, CollageActivity.this.height);
            CollageActivity.this.mainLayout = (RelativeLayout) CollageActivity.this.findViewById(R.id.collage_main_layout);
            CollageActivity.this.mainLayout.addView(CollageActivity.this.collageView);
            CollageActivity.this.slideLeftIn = AnimationUtils.loadAnimation(CollageActivity.this.activity, R.anim.slide_in_left);
            CollageActivity.this.slideLeftOut = AnimationUtils.loadAnimation(CollageActivity.this.activity, R.anim.slide_out_left);
            CollageActivity.this.slideRightIn = AnimationUtils.loadAnimation(CollageActivity.this.activity, R.anim.slide_in_right);
            CollageActivity.this.slideRightOut = AnimationUtils.loadAnimation(CollageActivity.this.activity, R.anim.slide_out_right);
            CollageActivity.this.addEffectFragment();
            if (this.arraySize == 1) {
                CollageActivity.this.setVisibilityForSingleImage();
            } else {
                CollageActivity.this.blurRadius = 0;
            }
            if (CollageActivity.this.isScrapBook) {
                CollageActivity.this.setVisibilityForScrapbook();
            }
          /*  if (CommonLibrary.isAppPro(CollageActivity.this.context)) {
                CollageActivity.this.adWhirlLayout = (AdView) CollageActivity.this.findViewById(R.id.collage_edit_ad_id);
                CollageActivity.this.adWhirlLayout.setVisibility(8);
            } else {
                CollageActivity.this.adWhirlLayout = (AdView) CollageActivity.this.findViewById(R.id.collage_edit_ad_id);
                CollageActivity.this.adWhirlLayout.bringToFront();
                CollageActivity.this.adWhirlLayout.loadAd(new Builder().build());
                if (CollageActivity.this.context.getResources().getBoolean(R.bool.showInterstitialAds)) {
                    CollageActivity.this.interstitial = new InterstitialAd(CollageActivity.this.context);
                    CollageActivity.this.interstitial.setAdUnitId(CollageActivity.this.getString(R.string.interstital_ad_id));
                    CollageActivity.this.interstitial.loadAd(new Builder().build());
                }
            }*/
            CollageActivity.this.textAndStickerViewContainer = (FrameLayout) CollageActivity.this.findViewById(R.id.sticker_view_container);
            CollageActivity.this.textAndStickerViewContainer.bringToFront();
            CollageActivity.this.findViewById(R.id.collage_footer_container).bringToFront();
            if (CollageActivity.this.viewFlipper == null) {
                CollageActivity.this.viewFlipper = (ViewFlipper) CollageActivity.this.findViewById(R.id.collage_view_flipper);
            }
            CollageActivity.this.viewFlipper.bringToFront();
            CollageActivity.this.findViewById(R.id.collage_header).bringToFront();
            CollageActivity.this.findViewById(R.id.collage_header_shadow).bringToFront();
            CollageActivity.this.contextFooter = (ViewGroup) CollageActivity.this.findViewById(R.id.collage_context_menu);
            CollageActivity.this.contextFooter.bringToFront();
            CollageActivity.this.selectSwapTextView = CollageActivity.this.findViewById(R.id.select_image_swap);
            CollageActivity.this.selectSwapTextView.bringToFront();
            CollageActivity.this.selectSwapTextView.setVisibility(4);
            CollageActivity.this.selectFilterTextView = CollageActivity.this.findViewById(R.id.select_image_filter);
            CollageActivity.this.selectFilterTextView.bringToFront();
            CollageActivity.this.selectFilterTextView.setVisibility(4);
            CollageActivity.this.textAndStickerViewContainer.setOnHierarchyChangeListener(new C06071());
            CollageActivity.this.lineColorPicker = (LineColorPicker) CollageActivity.this.findViewById(R.id.line_color_picker);
            CollageActivity.this.lineColorPicker.setColors(Palette.DEFAULT);
            CollageActivity.this.lineColorPicker.setSelectedColor(-1);
            CollageActivity.this.lineColorPicker.setOnColorChangedListener(new C10132());
            CollageActivity.this.findViewById(CollageActivity.this.textFragemntContinerId).bringToFront();
            CollageActivity.this.textLibHelper = new TextLibHelper();
            CollageActivity.this.findViewById(CollageActivity.this.stickerFragemntContinerId).bringToFront();
            CollageActivity.this.stickerLibHelper = new StickerLibHelper();
            if (this.savedInstanceState != null) {
                CollageActivity.this.textLibHelper.hideForOncreate(CollageActivity.this.activityFragment, CollageActivity.this.textAndStickerViewContainer, CollageActivity.this.textFragemntContinerId);
                CollageActivity.this.stickerLibHelper.hideForOncreate(CollageActivity.this.activityFragment, CollageActivity.this.textAndStickerViewContainer);
            }
        }
    }

    class CollageView extends View {
        public static final int BACKGROUND_BLUR = 1;
        public static final int BACKGROUND_CASCADE = 2;
        public static final int BACKGROUND_PATTERN = 0;
        private static final int INVALID_POINTER_ID = -1;
        public static final int PATTERN_SENTINEL = -1;
        static final float RATIO_CONSTANT = 1.25f;
        private static final int UPPER_SIZE_LIMIT = 1500;
        public static final int VIEW_ORIGINAL = 1;
        public static final int VIEW_SQUARE = 0;
        static final float smallestDistanceDivider = 500.0f;
        float MIN_ZOOM = 0.1f;
        int animHalfTime = ((this.animationLimit / 2) + 1);
        int animSizeSeekbarProgress = 0;
        boolean animate = false;
        int animationCount = 0;
        int animationDurationLimit = 50;
        int animationLimit = 31;
        private Runnable animator = new C06081();
        int backgroundMode = 0;
        Bitmap blurBitmap;
        BlurBuilderNormal blurBuilderNormal;
        RectF blurRectDst = new RectF();
        Rect blurRectSrc = new Rect();
        Paint borderPaint = new Paint(1);
        RectF bottomLeft;
        RectF bottomRight;
        Bitmap btmDoubleArrow;
        int cascadeNumber = 4;
        float cascadeOffsetX = 120.0f;
        float cascadeOffsetY = 120.0f;
        RectF[] cascadeRectArray = new RectF[]{new RectF(), new RectF(), new RectF(), new RectF()};
        Paint circlePaint;
        float cornerRadius = 0.0f;
        int currentCollageIndex = 0;
        RectF drawingAreaRect = new RectF();
        final float epsilon = 4.0f;
        float finalAngle = 0.0f;
        Bitmap frameBitmap;
        int frameDuration = 10;
        RectF frameRect;
        Matrix identityMatrix = new Matrix();
        boolean isInCircle = false;
        boolean isOnCross = false;
        int lastSize;
        Paint lineCircleStroke = new Paint(1);
        ArrayList<LineHelper> lineHelpers = new ArrayList();
        private int mActivePointerId = -1;
        float mLastTouchX;
        float mLastTouchXLine;
        float mLastTouchY;
        float mLastTouchYLine;
        private ScaleGestureDetector mScaleDetector;
        float mScaleFactor = 1.0f;
        private GestureDetectorCompat mTouchDetector;
        Bitmap[] maskBitmapArray;
        Matrix matrixDoubleArrow = new Matrix();
        float[] matrixValues = new float[9];
        int offsetX;
        int offsetY;
        int oldSizeProgress = 0;
        boolean orthogonal = false;
        float paddingDistance = 0.0f;
        Paint paint = new Paint();
        Paint paintGray = new Paint(1);
        Paint paintLine = new Paint(1);
        Bitmap patternBitmap;
        Paint patternPaint = new Paint(1);
        int previousIndex;
        float[] pts;
        RectF rTemp;
        float radiusLineHandle = 45.0f;
        Rect rectAnim = new Rect();
        OnRotationGestureListener rotateListener = new C10142();
        Shape scaleShape;
        int screenHeight;
        int screenWidth;
        int shapeIndex = -1;
        List<ShapeLayout> shapeLayoutList = new ArrayList();
        Matrix sizeMatrix = new Matrix();
        Matrix sizeMatrixSaved;
        float sizeScale = 1.0f;
        ArrayList<Float> smallestDistanceList = new ArrayList();
        private float startAngle = 0.0f;
        long startTime = System.nanoTime();
        RectF topLeft;
        RectF topRight;
        float[] vSize = new float[9];
        float[] values = new float[9];
        int viewSizeMode = 0;
        float xscale = 1.0f;
        float yscale = 1.0f;
        PointF zoomStart = new PointF();

        class C06081 implements Runnable {
            C06081() {
            }

            public void run() {
                boolean scheduleNewFrame = false;
                int iter = ((int) (((float) (System.nanoTime() - CollageView.this.startTime)) / 1000000.0f)) / CollageView.this.animationDurationLimit;
                if (iter <= 0) {
                    iter = 1;
                }
                if (CollageView.this.animationCount == 0) {
                    CollageView collageView = CollageView.this;
                    collageView.animationCount++;
                } else {
                    CollageView.this.animationCount += iter;
                }
                CollageView.this.setCollageSize(0, CollageView.this.sizeMatrix, CollageView.this.animSize(CollageView.this.animationCount), false);
                if (CollageView.this.animationCount < CollageView.this.animationLimit) {
                    scheduleNewFrame = true;
                } else {
                    CollageView.this.animate = false;
                }
                if (scheduleNewFrame) {
                    CollageView.this.postDelayed(this, (long) CollageView.this.frameDuration);
                } else {
                    CollageView.this.sizeMatrix.set(CollageView.this.sizeMatrixSaved);
                }
                ((ShapeLayout) CollageView.this.shapeLayoutList.get(CollageView.this.currentCollageIndex)).shapeArr[0].f869r.roundOut(CollageView.this.rectAnim);
                CollageView.this.invalidate(CollageView.this.rectAnim);
                CollageView.this.startTime = System.nanoTime();
            }
        }

        class MyGestureListener extends SimpleOnGestureListener {
            private static final String DEBUG_TAG = "Gestures";

            MyGestureListener() {
            }

            public boolean onSingleTapConfirmed(MotionEvent event) {
                Log.d(DEBUG_TAG, "onSingleTapConfirmed: ");
                return true;
            }

            public boolean onSingleTapUp(MotionEvent event) {
                Log.d(DEBUG_TAG, "onSingleTapUp: ");
                if (!CollageView.this.isOnCross) {
                    CollageActivity.this.collageView.selectCurrentShape(event.getX(), event.getY(), true);
                }
                return true;
            }

            public boolean onDoubleTap(MotionEvent event) {
                if (!CollageView.this.isOnCross) {
                    CollageActivity.this.collageView.selectCurrentShape(event.getX(), event.getY(), false);
                }
                if (CollageActivity.this.collageView.currentCollageIndex < 0) {
                    return false;
                }
                CollageActivity.this.collageView.setShapeScaleMatrix(1);
                return true;
            }
        }

        private class ScaleListener extends SimpleOnScaleGestureListener {
            private ScaleListener() {
            }

            public boolean onScale(ScaleGestureDetector detector) {
                if (CollageView.this.shapeIndex >= 0) {
                    CollageView.this.mScaleFactor = detector.getScaleFactor();
                    if (detector.isInProgress()) {
                        CollageView.this.mScaleFactor = Math.max(0.1f, Math.min(CollageView.this.mScaleFactor, 5.0f));
                        CollageView.this.scaleShape = ((ShapeLayout) CollageView.this.shapeLayoutList.get(CollageView.this.currentCollageIndex)).shapeArr[CollageView.this.shapeIndex];
                    } else {
                        CollageView.this.mScaleFactor = Math.max(0.1f, Math.min(CollageView.this.mScaleFactor, 5.0f));
                        CollageView.this.scaleShape = ((ShapeLayout) CollageView.this.shapeLayoutList.get(CollageView.this.currentCollageIndex)).shapeArr[CollageView.this.shapeIndex];
                    }
                    if (CollageActivity.this.isScrapBook) {
                        CollageView.this.scaleShape.bitmapMatrixScaleScrapBook(CollageView.this.mScaleFactor, CollageView.this.mScaleFactor);
                    } else {
                        CollageView.this.scaleShape.bitmapMatrixScale(CollageView.this.mScaleFactor, CollageView.this.mScaleFactor, CollageView.this.scaleShape.bounds.centerX(), CollageView.this.scaleShape.bounds.centerY());
                    }
                    CollageView.this.invalidate();
                    CollageView.this.requestLayout();
                }
                return true;
            }
        }

        class C10142 implements OnRotationGestureListener {
            C10142() {
            }

            public void OnRotation(RotationGestureDetector rotationDetector) {
                if (CollageView.this.shapeIndex >= 0) {
                    float angle = rotationDetector.getAngle();
                    CollageView.this.scaleShape = ((ShapeLayout) CollageView.this.shapeLayoutList.get(CollageView.this.currentCollageIndex)).shapeArr[CollageView.this.shapeIndex];
                    float rotation = CollageView.this.getMatrixRotation(CollageView.this.scaleShape.bitmapMatrix);
                    if ((rotation == 0.0f || rotation == 90.0f || rotation == 180.0f || rotation == -180.0f || rotation == -90.0f) && Math.abs(CollageView.this.finalAngle - angle) < 4.0f) {
                        CollageView.this.orthogonal = true;
                        return;
                    }
                    if (Math.abs((rotation - CollageView.this.finalAngle) + angle) < 4.0f) {
                        angle = CollageView.this.finalAngle - rotation;
                        CollageView.this.orthogonal = true;
                    }
                    if (Math.abs(90.0f - ((rotation - CollageView.this.finalAngle) + angle)) < 4.0f) {
                        angle = (CollageView.this.finalAngle + 90.0f) - rotation;
                        CollageView.this.orthogonal = true;
                    }
                    if (Math.abs(180.0f - ((rotation - CollageView.this.finalAngle) + angle)) < 4.0f) {
                        angle = (180.0f + CollageView.this.finalAngle) - rotation;
                        CollageView.this.orthogonal = true;
                    }
                    if (Math.abs(-180.0f - ((rotation - CollageView.this.finalAngle) + angle)) < 4.0f) {
                        angle = (CollageView.this.finalAngle - 0.024902344f) - rotation;
                        CollageView.this.orthogonal = true;
                    }
                    if (Math.abs(-90.0f - ((rotation - CollageView.this.finalAngle) + angle)) < 4.0f) {
                        angle = (CollageView.this.finalAngle - 0.049804688f) - rotation;
                        CollageView.this.orthogonal = true;
                    } else {
                        CollageView.this.orthogonal = false;
                    }
                    CollageView.this.scaleShape.bitmapMatrixRotate(CollageView.this.finalAngle - angle);
                    CollageView.this.finalAngle = angle;
                    CollageView.this.invalidate();
                    CollageView.this.requestLayout();
                }
            }
        }

        public CollageView(Context context, int width, int height) {
            super(context);
            this.borderPaint.setColor(-16776961);
            this.borderPaint.setStyle(Style.STROKE);
            this.screenWidth = width;
            this.screenHeight = height;
            this.borderPaint.setStrokeWidth(((float) this.screenWidth) / 144.0f);
            this.radiusLineHandle = ((float) this.screenWidth) / 29.0f;
            this.circlePaint = new Paint();
            this.circlePaint.setColor(SupportMenu.CATEGORY_MASK);
            this.identityMatrix.reset();
            this.lineCircleStroke.setStyle(Style.STROKE);
            this.lineCircleStroke.setColor(-15591619);
            this.lineCircleStroke.setStrokeWidth(((float) this.screenWidth) / 240.0f);
            this.topLeft = new RectF((float) (width * 0), (float) (height * 0), 0.5f * ((float) width), 0.5f * ((float) height));
            this.topRight = new RectF(0.5f * ((float) width), 0.0f * ((float) height), 1.0f * ((float) width), 0.5f * ((float) height));
            this.bottomLeft = new RectF((float) (width * 0), 0.5f * ((float) height), 0.5f * ((float) width), 1.0f * ((float) height));
            this.bottomRight = new RectF(0.5f * ((float) width), 0.5f * ((float) height), 1.0f * ((float) width), 1.0f * ((float) height));
            Path pathTopLeft = new Path();
            Path pathTopRight = new Path();
            Path pathBottomLeft = new Path();
            Path pathBottomRight = new Path();
            pathTopLeft.addRect(this.topLeft, Direction.CCW);
            pathTopRight.addRect(this.topRight, Direction.CCW);
            pathBottomLeft.addRect(this.bottomLeft, Direction.CCW);
            pathBottomRight.addRect(this.bottomRight, Direction.CCW);
            this.mTouchDetector = new GestureDetectorCompat(context, new MyGestureListener());
            this.mScaleDetector = new ScaleGestureDetector(context, new ScaleListener());
            CollageActivity.this.mRotationDetector = new RotationGestureDetector(this.rotateListener);
            calculateOffset();
            this.patternPaint = new Paint(1);
            this.patternPaint.setColor(-1);
            createShapeList(CollageActivity.this.bitmapList.length, width, height);
            this.paintGray.setColor(-12303292);
            if (!(!CollageActivity.this.bgImageIsWaiting || CollageActivity.this.patternHelper == null || CollageActivity.this.patternHelper.bitmapBlur == null || CollageActivity.this.patternHelper.bitmapBlur.isRecycled())) {
                setBlurBitmap(CollageActivity.this.blurRadius, false);
                this.backgroundMode = 1;
                invalidate();
                CollageActivity.this.bgImageIsWaiting = false;
            }
            this.btmDoubleArrow = BitmapFactory.decodeResource(getResources(), R.drawable.double_arrow);
        }

        public void changeViewSizeMode() {
            int sizeMode = 0;
            if (this.viewSizeMode == 0) {
                sizeMode = 1;
            }
            this.viewSizeMode = sizeMode;
            setViewSize();
            CollageActivity.this.checkDecoareteViewPositions(CollageActivity.this.getCurrentMatrixForSticker());
        }

        public void setViewSize() {
            if (this.viewSizeMode == 0) {
                CollageActivity.this.mulX = 1.0f;
                CollageActivity.this.mulY = 1.0f;
                updateShapeListForRatio(CollageActivity.this.width, CollageActivity.this.height);
                if (CollageActivity.this.seekbarSize.getProgress() == 0) {
                    setCollageSize(0, this.sizeMatrix, this.oldSizeProgress, true);
                    Log.e(CollageActivity.TAG, "oldSizeProgress " + this.oldSizeProgress);
                    CollageActivity.this.seekbarSize.setProgress(this.oldSizeProgress);
                }
            } else if (this.viewSizeMode == 1) {
                CollageActivity.this.mulX = ((float) CollageActivity.this.bitmapList[0].getWidth()) / ((float) CollageActivity.this.bitmapList[0].getHeight());
                CollageActivity.this.mulY = 1.0f;
                updateShapeListForRatio(CollageActivity.this.width, CollageActivity.this.height);
                this.oldSizeProgress = this.lastSize;
                setCollageSize(0, this.sizeMatrix, getResources().getInteger(R.integer.default_ssize_value), true);
                CollageActivity.this.seekbarSize.setProgress(0);
            }
            invalidate();
        }

        private void calculateOffset() {
            PointF scale = getRatio();
            this.offsetX = (int) ((((float) CollageActivity.this.width) - (scale.x * ((float) CollageActivity.this.width))) / 2.0f);
            this.offsetY = (int) (CollageActivity.this.topOffset + (((((float) CollageActivity.this.height) - CollageActivity.this.totalOffset) - (scale.y * ((float) CollageActivity.this.width))) / 2.0f));
        }

        private String saveBitmap(int width, int height) {
            int i;
            int btmWidth = (int) (((float) width) * CollageActivity.this.collageView.xscale);
            int btmHeight = (int) (((float) width) * CollageActivity.this.collageView.yscale);
            float btmScale = ((float) Utility.maxSizeForSave(CollageActivity.this.context, CollageActivity.UPPER_SIZE_FOR_LOAD)) / ((float) Math.max(btmWidth, btmHeight));
            int newBtmWidth = (int) (((float) btmWidth) * btmScale);
            int newBtmHeight = (int) (((float) btmHeight) * btmScale);
            if (newBtmWidth <= 0) {
                newBtmWidth = btmWidth;
            }
            if (newBtmHeight <= 0) {
                newBtmHeight = btmHeight;
            }
            Bitmap savedBitmap = Bitmap.createBitmap(newBtmWidth, newBtmHeight, Config.ARGB_8888);
            Canvas bitmapCanvas = new Canvas(savedBitmap);
            ShapeLayout arr = (ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex);
            Matrix sizeMat = new Matrix();
            sizeMat.reset();
            sizeMat.preScale(btmScale, btmScale);
            bitmapCanvas.setMatrix(sizeMat);
            if (this.backgroundMode == 0) {
                bitmapCanvas.drawRect(0.0f, 0.0f, (float) btmWidth, (float) btmHeight, this.patternPaint);
            }
            if (!(this.blurBitmap == null || this.blurBitmap.isRecycled() || (this.backgroundMode != 1 && this.backgroundMode != 2))) {
                if (this.backgroundMode == 2) {
                    float localCascadeOffsetX = (((float) btmWidth) / 4.0f) / ((float) (this.cascadeNumber + 1));
                    float localCascadeOffsetY = (((float) btmHeight) / 4.0f) / ((float) (this.cascadeNumber + 1));
                    for (int j = 0; j < this.cascadeNumber; j++) {
                        int offsetIndex = j + 1;
                        this.cascadeRectArray[j].set(((float) offsetIndex) * localCascadeOffsetX, ((float) offsetIndex) * localCascadeOffsetY, ((float) btmWidth) - (((float) offsetIndex) * localCascadeOffsetX), ((float) btmHeight) - (((float) offsetIndex) * localCascadeOffsetY));
                    }
                }
                RectF rectF = new RectF(0.0f, 0.0f, (float) btmWidth, (float) btmHeight);
                if (!(this.blurBitmap == null || this.blurBitmap.isRecycled())) {
                    bitmapCanvas.drawBitmap(this.blurBitmap, this.blurRectSrc, rectF, this.paint);
                }
                if (this.backgroundMode == 2) {
                    for (i = 0; i < this.cascadeNumber; i++) {
                        if (!(this.blurBitmap == null || this.blurBitmap.isRecycled())) {
                            bitmapCanvas.drawBitmap(this.blurBitmap, this.blurRectSrc, this.cascadeRectArray[i], this.paint);
                        }
                    }
                }
            }
            sizeMat.postScale(this.sizeScale, this.sizeScale, ((float) newBtmWidth) / 2.0f, ((float) newBtmHeight) / 2.0f);
            sizeMat.preTranslate((float) (-this.offsetX), (float) (-this.offsetY));
            bitmapCanvas.setMatrix(sizeMat);
            int q = bitmapCanvas.saveLayer(((float) (-width)) / this.sizeScale, ((float) (-height)) / this.sizeScale, ((float) this.offsetX) + (((float) width) / this.sizeScale), ((float) this.offsetY) + (((float) height) / this.sizeScale), null, 31);
            for (i = 0; i < arr.shapeArr.length; i++) {
                boolean drawPorterClear = false;
                if (i == arr.getClearIndex()) {
                    drawPorterClear = true;
                }
                if (CollageActivity.this.isScrapBook) {
                    arr.shapeArr[i].drawShapeForScrapBook(bitmapCanvas, newBtmWidth, newBtmHeight, false, false);
                } else {
                    arr.shapeArr[i].drawShape(bitmapCanvas, newBtmWidth, newBtmHeight, q, drawPorterClear, true, arr.shapeArr.length == 1);
                }
            }
            if (CollageActivity.this.textAndStickerViewContainer != null) {
                for (i = 0; i < CollageActivity.this.textAndStickerViewContainer.getChildCount(); i++) {
                    Matrix mat = new Matrix();
                    View v = CollageActivity.this.textAndStickerViewContainer.getChildAt(i);
                    if (v instanceof StickerView) {
                        StickerView view = (StickerView) v;
                        StickerData data = view.getStickerData();
                        mat.set(data.getCanvasMatrix());
                        mat.postTranslate((float) (-this.offsetX), (float) (-this.offsetY));
                        mat.postScale(btmScale, btmScale);
                        bitmapCanvas.setMatrix(mat);
                        if (!(view.stickerBitmap == null || view.stickerBitmap.isRecycled())) {
                            bitmapCanvas.drawBitmap(view.stickerBitmap, data.xPos, data.yPos, view.paint);
                        }
                    } else if (v instanceof CanvasTextView) {
                        TextData textData = ((CanvasTextView) v).getTextData();
                        if (!textData.getSnapMode()) {
                            mat.set(textData.getCanvasMatrix());
                        }
                        mat.postTranslate((float) (-this.offsetX), (float) (-this.offsetY));
                        mat.postScale(btmScale, btmScale);
                        bitmapCanvas.setMatrix(mat);
                        TextLibHelper.saveTextOnBitmap(bitmapCanvas, textData, this.screenWidth);
                    }
                }
            }
            bitmapCanvas.restoreToCount(q);
            String resultPath = Environment.getExternalStorageDirectory().toString() + CollageActivity.this.getString(R.string.directory) + String.valueOf(System.currentTimeMillis()) + ".jpg";
            new File(resultPath).getParentFile().mkdirs();
            try {
                OutputStream fileOutputStream = new FileOutputStream(resultPath);
                savedBitmap.compress(CompressFormat.JPEG, 90, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            savedBitmap.recycle();
            return resultPath;
        }

        private void createShapeList(int shapeCount, int width, int height) {
            this.shapeLayoutList.clear();
            this.smallestDistanceList.clear();
            Collage collage = Collage.CreateCollage(shapeCount, width, width, CollageActivity.this.isScrapBook);
            int size = ((CollageLayout) collage.collageLayoutList.get(0)).shapeList.size();
            int i = 0;
            while (i < collage.collageLayoutList.size()) {
                Shape[] shapeArray = new Shape[size];
                for (int j = 0; j < shapeCount; j++) {
                    boolean maskedSvg = false;
                    int svgIndex = -1;
                    if (!(((CollageLayout) collage.collageLayoutList.get(i)).maskPairListSvg == null || ((CollageLayout) collage.collageLayoutList.get(i)).maskPairListSvg.isEmpty())) {
                        for (MaskPairSvg maskPairSvg : ((CollageLayout) collage.collageLayoutList.get(i)).maskPairListSvg) {
                            if (j == maskPairSvg.index) {
                                maskedSvg = true;
                                svgIndex = maskPairSvg.svgIndex;
                            }
                        }
                    }
                    if (maskedSvg) {
                        shapeArray[j] = new Shape((PointF[]) ((CollageLayout) collage.collageLayoutList.get(i)).shapeList.get(j), CollageActivity.this.bitmapList[j], null, this.offsetX, this.offsetY, CollageActivity.this.isScrapBook, j, false, CollageActivity.this.btmDelete, CollageActivity.this.btmScale, this.screenWidth, ((CollageLayout) collage.collageLayoutList.get(i)).getConcavite(), svgIndex, width, width);
                        if (CollageActivity.this.isScrapBook) {
                            shapeArray[j].initScrapBook(CollageActivity.this.npd);
                        }
                    } else {
                        int shapeMode = 1;
                        if (j == ((CollageLayout) collage.collageLayoutList.get(i)).getClearIndex()) {
                            shapeMode = 4;
                        }
                        shapeArray[j] = new Shape((PointF[]) ((CollageLayout) collage.collageLayoutList.get(i)).shapeList.get(j), CollageActivity.this.bitmapList[j], ((CollageLayout) collage.collageLayoutList.get(i)).getexceptionIndex(j), this.offsetX, this.offsetY, CollageActivity.this.isScrapBook, j, false, CollageActivity.this.btmDelete, CollageActivity.this.btmScale, this.screenWidth, shapeMode, ((CollageLayout) collage.collageLayoutList.get(i)).getConcavite(), width, width);
                        if (CollageActivity.this.isScrapBook) {
                            shapeArray[j].initScrapBook(CollageActivity.this.npd);
                        }
                    }
                }
                this.smallestDistanceList.add(Float.valueOf(smallestDistance(shapeArray)));
                ShapeLayout shapeLayout = new ShapeLayout(shapeArray);
                shapeLayout.useLine = ((CollageLayout) collage.collageLayoutList.get(i)).useLine;
                shapeLayout.setClearIndex(((CollageLayout) collage.collageLayoutList.get(i)).getClearIndex());
                this.shapeLayoutList.add(shapeLayout);
                i++;
            }
            if (!CollageActivity.this.isScrapBook) {
                if (shapeCount != 1) {
                    for (int index = 0; index < this.shapeLayoutList.size(); index++) {
                        setPathPadding(index, (float) getResources().getInteger(R.integer.default_space_value), false);
                    }
                    setCollageSize(0, this.sizeMatrix, getResources().getInteger(R.integer.default_ssize_value), true);
                } else if (CollageActivity.this.bitmapList.length == 1) {
                    setCollageSize(0, this.sizeMatrix, getResources().getInteger(R.integer.default_ssize_value), false);
                }
            }
            if (!CollageActivity.this.isScrapBook) {
                createLineList((int) (((float) width) * this.xscale), (int) (((float) width) * this.yscale));
            }
        }

        void createLineList(int w, int h) {
            if (this.lineHelpers == null) {
                this.lineHelpers = new ArrayList();
            }
            this.lineHelpers.clear();
            for (int position = 0; position < this.shapeLayoutList.size(); position++) {
                ShapeLayout sl = (ShapeLayout) this.shapeLayoutList.get(position);
                ArrayList<ArrayList<PointF>> shapeList = new ArrayList();
                for (int i = 0; i < sl.shapeArr.length; i++) {
                    shapeList.add(new ArrayList());
                    for (Object add : sl.shapeArr[i].points) {
                        ((ArrayList) shapeList.get(i)).add(add);
                    }
                }
                LineHelper lineHelper = new LineHelper(shapeList, (float) w, (float) h, ((ShapeLayout) this.shapeLayoutList.get(position)).useLine);
                lineHelper.findGridLines();
                lineHelper.minDistance = ((Float) this.smallestDistanceList.get(position)).floatValue() / 2.0f;
                this.lineHelpers.add(lineHelper);
            }
        }

        private int setShapeScaleMatrix(int mode) {
            if (this.shapeIndex < 0) {
                return -1;
            }
            int message = ((ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex)).shapeArr[this.shapeIndex].setScaleMatrix(mode);
            invalidate();
            CollageActivity.this.checkDecoareteViewPositions(CollageActivity.this.getCurrentMatrixForSticker());
            return message;
        }

        private void setLockScales() {
            for (int i = 0; i < this.shapeLayoutList.size(); i++) {
                for (Shape maxMinScalesForLock : ((ShapeLayout) this.shapeLayoutList.get(i)).shapeArr) {
                    maxMinScalesForLock.setMaxMinScalesForLock();
                }
            }
        }

        private void deleteBitmap(int index, int width, int height) {
            Shape[] scrapBookTemp = ((ShapeLayout) this.shapeLayoutList.get(0)).shapeArr;
            if (index >= 0 && index < ((ShapeLayout) this.shapeLayoutList.get(0)).shapeArr.length) {
                int i;
                int newSize = ((ShapeLayout) this.shapeLayoutList.get(0)).shapeArr.length - 1;
                Bitmap[] currentBitmapListTemp = new Bitmap[newSize];
                Bitmap[] bitmapListTemp = new Bitmap[newSize];
                int j = 0;
                for (i = 0; i < currentBitmapListTemp.length + 1; i++) {
                    if (i != index) {
                        currentBitmapListTemp[j] = ((ShapeLayout) this.shapeLayoutList.get(0)).shapeArr[i].getBitmap();
                        bitmapListTemp[j] = CollageActivity.this.bitmapList[i];
                        j++;
                    }
                }
                CollageActivity.this.bitmapList[index].recycle();
                ((ShapeLayout) this.shapeLayoutList.get(0)).shapeArr[index].getBitmap().recycle();
                this.shapeLayoutList.clear();
                this.smallestDistanceList.clear();
                Collage collage = Collage.CreateCollage(newSize, width, width, CollageActivity.this.isScrapBook);
                int size = ((CollageLayout) collage.collageLayoutList.get(0)).shapeList.size();
                CollageActivity.this.bitmapList = bitmapListTemp;
                i = 0;
                while (i < collage.collageLayoutList.size()) {
                    Shape[] shapeArray = new Shape[size];
                    for (j = 0; j < currentBitmapListTemp.length; j++) {
                        boolean maskedSvg = false;
                        int svgIndex = -1;
                        if (!(((CollageLayout) collage.collageLayoutList.get(i)).maskPairListSvg == null || ((CollageLayout) collage.collageLayoutList.get(i)).maskPairListSvg.isEmpty())) {
                            for (MaskPairSvg maskPairSvg : ((CollageLayout) collage.collageLayoutList.get(i)).maskPairListSvg) {
                                if (j == maskPairSvg.index) {
                                    maskedSvg = true;
                                    svgIndex = maskPairSvg.svgIndex;
                                }
                            }
                        }
                        if (maskedSvg) {
                            shapeArray[j] = new Shape((PointF[]) ((CollageLayout) collage.collageLayoutList.get(i)).shapeList.get(j), CollageActivity.this.bitmapList[j], null, this.offsetX, this.offsetY, CollageActivity.this.isScrapBook, j, false, CollageActivity.this.btmDelete, CollageActivity.this.btmScale, this.screenWidth, ((CollageLayout) collage.collageLayoutList.get(i)).getConcavite(), svgIndex, width, width);
                            if (CollageActivity.this.isScrapBook) {
                                shapeArray[j].initScrapBook(CollageActivity.this.npd);
                            }
                        } else {
                            int shapeMode = 1;
                            if (j == ((CollageLayout) collage.collageLayoutList.get(i)).getClearIndex()) {
                                shapeMode = 4;
                            }
                            shapeArray[j] = new Shape((PointF[]) ((CollageLayout) collage.collageLayoutList.get(i)).shapeList.get(j), currentBitmapListTemp[j], ((CollageLayout) collage.collageLayoutList.get(i)).getexceptionIndex(j), this.offsetX, this.offsetY, CollageActivity.this.isScrapBook, j, true, CollageActivity.this.btmDelete, CollageActivity.this.btmScale, this.screenWidth, shapeMode, ((CollageLayout) collage.collageLayoutList.get(i)).getConcavite(), width, width);
                            if (CollageActivity.this.isScrapBook) {
                                shapeArray[j].initScrapBook(CollageActivity.this.npd);
                            }
                        }
                    }
                    if (CollageActivity.this.isScrapBook) {
                        for (int k = 0; k < scrapBookTemp.length; k++) {
                            if (k < index) {
                                shapeArray[k].bitmapMatrix.set(scrapBookTemp[k].bitmapMatrix);
                            }
                            if (k > index) {
                                shapeArray[k - 1].bitmapMatrix.set(scrapBookTemp[k].bitmapMatrix);
                            }
                        }
                    }
                    ShapeLayout shapeLayout = new ShapeLayout(shapeArray);
                    shapeLayout.useLine = ((CollageLayout) collage.collageLayoutList.get(i)).useLine;
                    shapeLayout.setClearIndex(((CollageLayout) collage.collageLayoutList.get(i)).getClearIndex());
                    this.shapeLayoutList.add(shapeLayout);
                    this.smallestDistanceList.add(Float.valueOf(smallestDistance(shapeArray)));
                    i++;
                }
                this.currentCollageIndex = 0;
                CollageActivity.this.collageAdapter.selectedPosition = 0;
                CollageActivity.this.collageAdapter.setData(Collage.collageIconArray[newSize - 1]);
                CollageActivity.this.collageAdapter.notifyDataSetChanged();
                if (!CollageActivity.this.isScrapBook) {
                    updateShapeListForRatio(width, height);
                }
                unselectShapes();
                invalidate();
                if (currentBitmapListTemp.length == 1) {
                    CollageActivity.this.setVisibilityForSingleImage();
                }
                if (newSize == 1) {
                    setPathPadding(0, 0.0f, false);
                    if (this.sizeScale == 1.0f && !CollageActivity.this.isScrapBook) {
                        setCollageSize(0, this.sizeMatrix, getResources().getInteger(R.integer.default_ssize_value), true);
                    }
                }
                if (!CollageActivity.this.isScrapBook) {
                    createLineList((int) (((float) width) * this.xscale), (int) (((float) width) * this.yscale));
                }
            }
        }

        public float smallestDistance(Shape[] shapeArray) {
            float smallestDistance = shapeArray[0].smallestDistance();
            for (Shape smallestDistance2 : shapeArray) {
                float distance = smallestDistance2.smallestDistance();
                if (distance < smallestDistance) {
                    smallestDistance = distance;
                }
            }
            return smallestDistance;
        }

        private void updateShapeListForRatio(int width, int height) {
            int shapeCount = ((ShapeLayout) this.shapeLayoutList.get(0)).shapeArr.length;
            PointF scale = getRatio();
            calculateOffset();
            Collage collage = Collage.CreateCollage(shapeCount, (int) (scale.x * ((float) width)), (int) (((float) width) * scale.y), CollageActivity.this.isScrapBook);
            this.smallestDistanceList.clear();
            for (int index = 0; index < this.shapeLayoutList.size(); index++) {
                if (shapeCount == 1) {
                    ((ShapeLayout) this.shapeLayoutList.get(index)).shapeArr[0].changeRatio((PointF[]) ((CollageLayout) collage.collageLayoutList.get(index)).shapeList.get(0), null, this.offsetX, this.offsetY, CollageActivity.this.isScrapBook, 0, (int) (scale.x * ((float) width)), (int) (((float) width) * scale.y));
                } else {
                    for (int j = 0; j < shapeCount; j++) {
                        ((ShapeLayout) this.shapeLayoutList.get(index)).shapeArr[j].changeRatio((PointF[]) ((CollageLayout) collage.collageLayoutList.get(index)).shapeList.get(j), null, this.offsetX, this.offsetY, CollageActivity.this.isScrapBook, j, (int) (scale.x * ((float) width)), (int) (((float) width) * scale.y));
                    }
                }
                this.smallestDistanceList.add(Float.valueOf(smallestDistance(((ShapeLayout) this.shapeLayoutList.get(index)).shapeArr)));
                setPathPadding(index, this.paddingDistance, false);
                if (!CollageActivity.this.isScrapBook) {
                    for (Shape scaleMatrix : ((ShapeLayout) this.shapeLayoutList.get(index)).shapeArr) {
                        scaleMatrix.setScaleMatrix(1);
                    }
                }
            }
            setCornerRadius(this.cornerRadius);
            if (this.blurBitmap != null) {
                setBlurRect2((float) this.blurBitmap.getWidth(), (float) this.blurBitmap.getHeight());
            }
            if (!CollageActivity.this.isScrapBook) {
                createLineList((int) (scale.x * ((float) width)), (int) (((float) width) * scale.y));
            }
            postInvalidate();
            CollageActivity.this.checkDecoareteViewPositions(CollageActivity.this.getCurrentMatrixForSticker());
        }

        PointF getRatio() {
            this.yscale = 1.0f;
            this.xscale = 1.0f;
            this.yscale = CollageActivity.this.mulY / CollageActivity.this.mulX;
            if (!CollageActivity.this.isScrapBook && this.yscale > RATIO_CONSTANT) {
                this.xscale = RATIO_CONSTANT / this.yscale;
                this.yscale = RATIO_CONSTANT;
            }
            return new PointF(this.xscale, this.yscale);
        }

        private void updateShapeListForFilterBitmap(Bitmap bitmap) {
            if (this.shapeIndex >= 0) {
                for (int i = 0; i < this.shapeLayoutList.size(); i++) {
                    ((ShapeLayout) this.shapeLayoutList.get(i)).shapeArr[this.shapeIndex].setBitmap(bitmap, true);
                }
            }
        }

        void updateParamList(Parameter p) {
            if (this.shapeIndex >= 0) {
                CollageActivity.this.parameterList[this.shapeIndex] = new Parameter(p);
            }
        }

        private void swapBitmaps(int index1, int index2) {
            Bitmap bitmap1 = ((ShapeLayout) this.shapeLayoutList.get(0)).shapeArr[index1].getBitmap();
            Bitmap bitmap2 = ((ShapeLayout) this.shapeLayoutList.get(0)).shapeArr[index2].getBitmap();
            for (int i = 0; i < this.shapeLayoutList.size(); i++) {
                ((ShapeLayout) this.shapeLayoutList.get(i)).shapeArr[index1].setBitmap(bitmap2, false);
                ((ShapeLayout) this.shapeLayoutList.get(i)).shapeArr[index1].setScaleMatrix(1);
                ((ShapeLayout) this.shapeLayoutList.get(i)).shapeArr[index2].setBitmap(bitmap1, false);
                ((ShapeLayout) this.shapeLayoutList.get(i)).shapeArr[index2].setScaleMatrix(1);
            }
            Bitmap temp = CollageActivity.this.bitmapList[index1];
            CollageActivity.this.bitmapList[index1] = CollageActivity.this.bitmapList[index2];
            CollageActivity.this.bitmapList[index2] = temp;
            Parameter tempParam = CollageActivity.this.parameterList[index1];
            CollageActivity.this.parameterList[index1] = CollageActivity.this.parameterList[index2];
            CollageActivity.this.parameterList[index2] = tempParam;
            CollageActivity.this.selectSwapTextView.setVisibility(4);
            unselectShapes();
        }

        void setCurrentCollageIndex(int index) {
            boolean z = false;
            this.currentCollageIndex = index;
            if (this.currentCollageIndex >= this.shapeLayoutList.size()) {
                this.currentCollageIndex = 0;
            }
            if (this.currentCollageIndex < 0) {
                this.currentCollageIndex = this.shapeLayoutList.size() - 1;
            }
            setCornerRadius(this.cornerRadius);
            setPathPadding(this.currentCollageIndex, this.paddingDistance, false);
            int i = this.currentCollageIndex;
            Matrix matrix = this.sizeMatrix;
            int i2 = this.lastSize;
            if (this.lastSize == getResources().getInteger(R.integer.default_ssize_value)) {
                z = true;
            }
            setCollageSize(i, matrix, i2, z);
            CollageActivity.this.checkDecoareteViewPositions(CollageActivity.this.getCurrentMatrixForSticker());
        }

        private void setCornerRadius(float radius) {
            this.cornerRadius = radius;
            CornerPathEffect corEffect = new CornerPathEffect(radius);
            for (Shape radius2 : ((ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex)).shapeArr) {
                radius2.setRadius(corEffect);
            }
            postInvalidate();
        }

        private void setPathPadding(int index, float distance, boolean override) {
            this.paddingDistance = distance;
            for (int i = 0; i < ((ShapeLayout) this.shapeLayoutList.get(index)).shapeArr.length; i++) {
                ((ShapeLayout) this.shapeLayoutList.get(index)).shapeArr[i].scalePath((((Float) this.smallestDistanceList.get(index)).floatValue() / smallestDistanceDivider) * distance, (float) this.screenWidth, (float) this.screenWidth);
                if (!CollageActivity.this.isScrapBook) {
                    ((ShapeLayout) this.shapeLayoutList.get(index)).shapeArr[i].checkScaleBounds(override);
                    ((ShapeLayout) this.shapeLayoutList.get(index)).shapeArr[i].checkBoundries(override);
                    if (override) {
                        boolean z;
                        Shape shape = ((ShapeLayout) this.shapeLayoutList.get(index)).shapeArr[i];
                        if (override) {
                            z = false;
                        } else {
                            z = true;
                        }
                        shape.checkScaleBounds(z);
                    }
                }
            }
            postInvalidate();
        }

        private void setCollageSize(int index, Matrix matrix, int progress, boolean equalSize) {
            this.lastSize = progress;
            matrix.reset();
            this.sizeScale = calculateSize(index, (float) progress, equalSize);
            matrix.postScale(this.sizeScale, this.sizeScale, (((float) (this.offsetX + this.offsetX)) + (((float) CollageActivity.this.width) * this.xscale)) / 2.0f, (((float) (this.offsetY + this.offsetY)) + (((float) CollageActivity.this.width) * this.yscale)) / 2.0f);
            invalidate();
            CollageActivity.this.checkDecoareteViewPositions(CollageActivity.this.getCurrentMatrixForSticker());
        }

        float calculateSize(int index, float progress, boolean equalSize) {
            if (!equalSize) {
                return 1.0f - (progress / 200.0f);
            }
            float xx = (2.0f * progress) * (((Float) this.smallestDistanceList.get(index)).floatValue() / smallestDistanceDivider);
            return (((float) CollageActivity.this.width) - ((((float) CollageActivity.this.width) * xx) / (((float) CollageActivity.this.width) + xx))) / ((float) CollageActivity.this.width);
        }

        void setPatternPaint(int resId, Bitmap bitmap) {
            if (this.patternPaint == null) {
                this.patternPaint = new Paint(1);
                this.patternPaint.setColor(-1);
            }
            if (resId == -1) {
                this.patternPaint.setShader(null);
                this.patternPaint.setColor(-1);
                postInvalidate();
            } else if (bitmap != null && !bitmap.isRecycled()) {
                this.patternBitmap = bitmap;
                this.patternPaint.setShader(new BitmapShader(this.patternBitmap, TileMode.REPEAT, TileMode.REPEAT));
                postInvalidate();
            }
        }

        void setPatternPaintColor(int color) {
            if (this.patternPaint == null) {
                this.patternPaint = new Paint(1);
            }
            this.patternPaint.setShader(null);
            this.patternPaint.setColor(color);
            postInvalidate();
        }

        public void setFrame(int index) {
            if (this.frameRect == null) {
                this.frameRect = new RectF(0.0f, 0.0f, (float) this.screenWidth, (float) this.screenWidth);
            }
            if (!(this.frameBitmap == null || this.frameBitmap.isRecycled())) {
                this.frameBitmap.recycle();
                this.frameBitmap = null;
            }
            if (index != 0) {
                this.frameBitmap = BitmapFactory.decodeResource(getResources(), LibUtility.borderRes[index]);
                postInvalidate();
            }
        }

        public void startAnimator() {
            if (CollageActivity.this.seekbarSize != null) {
                this.animSizeSeekbarProgress = CollageActivity.this.seekbarSize.getProgress();
            } else {
                this.animSizeSeekbarProgress = 0;
            }
            this.sizeMatrixSaved = new Matrix(this.sizeMatrix);
            this.animationCount = 0;
            this.animate = true;
            removeCallbacks(this.animator);
            postDelayed(this.animator, 150);
        }

        int animSize(int value) {
            int res;
            if (value < this.animHalfTime) {
                res = value;
            } else {
                res = this.animationLimit - value;
            }
            return this.animSizeSeekbarProgress + Math.round((float) (res * 2));
        }

        public void onDraw(Canvas canvas) {
            int j;
            int i;
            int width = getWidth();
            int height = getHeight();
            this.cascadeOffsetX = (((float) width) * this.xscale) / 4.0f;
            this.cascadeOffsetY = (((float) width) * this.yscale) / 4.0f;
            canvas.save();
            if (this.backgroundMode == 2) {
                float localCascadeOffsetX = this.cascadeOffsetX / ((float) (this.cascadeNumber + 1));
                float loxalCascadeOffsetY = this.cascadeOffsetY / ((float) (this.cascadeNumber + 1));
                for (j = 0; j < this.cascadeNumber; j++) {
                    int offsetIndex = j + 1;
                    this.cascadeRectArray[j].set(((float) this.offsetX) + (((float) offsetIndex) * localCascadeOffsetX), ((float) this.offsetY) + (((float) offsetIndex) * loxalCascadeOffsetY), (((float) this.offsetX) + (((float) width) * this.xscale)) - (((float) offsetIndex) * localCascadeOffsetX), (((float) this.offsetY) + (((float) width) * this.yscale)) - (((float) offsetIndex) * loxalCascadeOffsetY));
                }
            }
            this.drawingAreaRect.set((float) this.offsetX, (float) this.offsetY, ((float) this.offsetX) + (((float) width) * this.xscale), ((float) this.offsetY) + (((float) width) * this.yscale));
            canvas.clipRect(this.drawingAreaRect);
            if (this.backgroundMode == 0) {
                canvas.drawRect(this.drawingAreaRect, this.patternPaint);
            }
            if (!(this.blurBitmap == null || this.blurBitmap.isRecycled() || (this.backgroundMode != 1 && this.backgroundMode != 2))) {
                this.blurRectDst.set(this.drawingAreaRect);
                canvas.drawBitmap(this.blurBitmap, this.blurRectSrc, this.blurRectDst, this.paint);
                if (this.backgroundMode == 2) {
                    for (i = 0; i < this.cascadeNumber; i++) {
                        canvas.drawBitmap(this.blurBitmap, this.blurRectSrc, this.cascadeRectArray[i], this.paint);
                    }
                }
            }
            if (!CollageActivity.this.isScrapBook) {
                canvas.setMatrix(this.sizeMatrix);
            }
            j = 0;
            if (!CollageActivity.this.isScrapBook) {
                j = canvas.saveLayer(-Svg.strokeSize, 0.0f, Svg.strokeSize + ((float) width), (float) height, null, 31);
            }
            i = 0;
            while (i < ((ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex)).shapeArr.length) {
                boolean drawPorterClear = false;
                if (i == ((ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex)).getClearIndex()) {
                    drawPorterClear = true;
                }
                if (CollageActivity.this.isScrapBook) {
                    ((ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex)).shapeArr[i].drawShapeForScrapBook(canvas, width, height, i == this.shapeIndex, this.orthogonal);
                } else {
                    ((ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex)).shapeArr[i].drawShape(canvas, width, height, j, drawPorterClear, false, ((ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex)).shapeArr.length == 1);
                }
                i++;
            }
            if (!CollageActivity.this.isScrapBook && this.shapeIndex >= 0 && ((ShapeLayout) this.shapeLayoutList.get(0)).shapeArr.length > 1) {
                this.rTemp = ((ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex)).shapeArr[this.shapeIndex].bounds;
                canvas.drawLine(this.rTemp.left, this.rTemp.top, this.rTemp.right, this.rTemp.top, this.borderPaint);
                canvas.drawLine(this.rTemp.left, this.rTemp.top, this.rTemp.left, this.rTemp.bottom, this.borderPaint);
                canvas.drawLine(this.rTemp.right, this.rTemp.top, this.rTemp.right, this.rTemp.bottom, this.borderPaint);
                canvas.drawLine(this.rTemp.left, this.rTemp.bottom, this.rTemp.right, this.rTemp.bottom, this.borderPaint);
            }
            if (!(this.frameBitmap == null || this.frameBitmap.isRecycled())) {
                canvas.drawBitmap(this.frameBitmap, null, this.frameRect, this.paint);
            }
            canvas.restore();
            if (!CollageActivity.this.isScrapBook && this.lineHelpers != null && ((LineHelper) this.lineHelpers.get(this.currentCollageIndex)).useLine) {
                canvas.setMatrix(this.sizeMatrix);
                canvas.translate((float) this.offsetX, (float) this.offsetY);
                ArrayList<GridLine> gridLines = ((LineHelper) this.lineHelpers.get(this.currentCollageIndex)).gridLines;
                if (gridLines != null && !gridLines.isEmpty()) {
                    int q = 0;
                    while (q < gridLines.size()) {
                        if (!((GridLine) gridLines.get(q)).isSide) {
                            this.paintLine.setColor(-1);
                            if (((LineHelper) this.lineHelpers.get(this.currentCollageIndex)).selectedLine == q) {
                                this.paintLine.setColor(-567676);
                            }
                            canvas.drawCircle(((GridLine) gridLines.get(q)).pointHandle.x, ((GridLine) gridLines.get(q)).pointHandle.y, this.radiusLineHandle, this.paintLine);
                            canvas.drawCircle(((GridLine) gridLines.get(q)).pointHandle.x, ((GridLine) gridLines.get(q)).pointHandle.y, this.radiusLineHandle, this.lineCircleStroke);
                            this.matrixDoubleArrow.reset();
                            this.matrixDoubleArrow.postTranslate(((GridLine) gridLines.get(q)).pointHandle.x - ((float) (this.btmDoubleArrow.getWidth() / 2)), ((GridLine) gridLines.get(q)).pointHandle.y - ((float) (this.btmDoubleArrow.getHeight() / 2)));
                            this.matrixDoubleArrow.postRotate(-((float) (Math.atan((double) (1.0f / ((GridLine) gridLines.get(q)).slope)) * 57.29577951308232d)), ((GridLine) gridLines.get(q)).pointHandle.x, ((GridLine) gridLines.get(q)).pointHandle.y);
                            canvas.drawBitmap(this.btmDoubleArrow, this.matrixDoubleArrow, this.paintLine);
                        }
                        q++;
                    }
                }
            }
        }

        public boolean onTouchEvent(MotionEvent ev) {
            this.mScaleDetector.onTouchEvent(ev);
            this.mTouchDetector.onTouchEvent(ev);
            if (CollageActivity.this.isScrapBook) {
                CollageActivity.this.mRotationDetector.onTouchEvent(ev);
            }
            int action = ev.getAction();
            float x;
            float y;
            int j;
            int pointerIndex;
            switch (action & 255) {
                case 0:
                    this.previousIndex = this.shapeIndex;
                    x = ev.getX();
                    y = ev.getY();
                    this.mLastTouchX = x;
                    this.mLastTouchY = y;
                    this.orthogonal = false;
                    this.mActivePointerId = ev.getPointerId(0);
                    if (!CollageActivity.this.isScrapBook || this.shapeIndex < 0) {
                        selectCurrentShape(x, y, false);
                    } else {
                        this.zoomStart.set(x, y);
                        this.pts = ((ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex)).shapeArr[this.shapeIndex].getMappedCenter();
                        if (this.pts != null) {
                            this.startAngle = -Utility.pointToAngle(x, y, this.pts[0], this.pts[1]);
                        }
                        this.isInCircle = ((ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex)).shapeArr[this.shapeIndex].isInCircle(x, y);
                        this.isOnCross = ((ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex)).shapeArr[this.shapeIndex].isOnCross(x, y);
                    }
                    if (!(CollageActivity.this.isScrapBook || this.lineHelpers == null || this.lineHelpers.isEmpty() || !((LineHelper) this.lineHelpers.get(this.currentCollageIndex)).useLine)) {
                        this.sizeMatrix.getValues(this.vSize);
                        float scaleLine = this.vSize[0];
                        float xPos = this.vSize[2];
                        float yPos = this.vSize[5];
                        this.mLastTouchXLine = x - ((float) this.offsetX);
                        this.mLastTouchYLine = y - ((float) this.offsetY);
                        float checposx = ((x - xPos) / scaleLine) - ((float) this.offsetX);
                        float checkposy = ((y - yPos) / scaleLine) - ((float) this.offsetY);
                        ((LineHelper) this.lineHelpers.get(this.currentCollageIndex)).selectedLine = -1;
                        for (int i = 0; i < ((LineHelper) this.lineHelpers.get(this.currentCollageIndex)).gridLines.size(); i++) {
                            GridLine gridLine = (GridLine) ((LineHelper) this.lineHelpers.get(this.currentCollageIndex)).gridLines.get(i);
                            if (gridLine.isTouchOnHandle(checposx, checkposy, (2.0f * this.radiusLineHandle) / scaleLine) && !gridLine.isSide) {
                                ((LineHelper) this.lineHelpers.get(this.currentCollageIndex)).selectedLine = i;
                            }
                        }
                        if (((LineHelper) this.lineHelpers.get(this.currentCollageIndex)).selectedLine >= 0) {
                            unselectShapes();
                        }
                        return true;
                    }
                    break;
                case 1:
                    if (!(CollageActivity.this.isScrapBook || this.lineHelpers == null || this.lineHelpers.isEmpty() || !((LineHelper) this.lineHelpers.get(this.currentCollageIndex)).useLine || ((LineHelper) this.lineHelpers.get(this.currentCollageIndex)).selectedLine < 0)) {
                        ((LineHelper) this.lineHelpers.get(this.currentCollageIndex)).updateGridLines();
                        for (j = 0; j < ((ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex)).shapeArr.length; j++) {
                            ((ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex)).shapeArr[j].updateFromLine(((ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex)).shapeArr[j].points);
                            setPathPadding(this.currentCollageIndex, this.paddingDistance, true);
                        }
                        ((LineHelper) this.lineHelpers.get(this.currentCollageIndex)).selectedLine = -1;
                    }
                    this.orthogonal = false;
                    this.mActivePointerId = -1;
                    if (this.isOnCross) {
                        CollageActivity.this.createDeleteDialog();
                    }
                    this.isInCircle = false;
                    this.isOnCross = false;
                    invalidate();
                    break;
                case 2:
                    if (!this.isOnCross) {
                        pointerIndex = ev.findPointerIndex(this.mActivePointerId);
                        x = ev.getX(pointerIndex);
                        y = ev.getY(pointerIndex);
                        if (!(CollageActivity.this.isScrapBook || this.lineHelpers == null || this.lineHelpers.isEmpty())) {
                            boolean showLines = ((LineHelper) this.lineHelpers.get(this.currentCollageIndex)).useLine && ((LineHelper) this.lineHelpers.get(this.currentCollageIndex)).selectedLine >= 0;
                            if (!(!showLines || this.lineHelpers == null || this.lineHelpers.isEmpty())) {
                                if (((LineHelper) this.lineHelpers.get(this.currentCollageIndex)).selectedLine >= 0) {
                                    this.sizeMatrix.getValues(this.vSize);
                                    ((LineHelper) this.lineHelpers.get(this.currentCollageIndex)).moveGridLines((x - this.mLastTouchXLine) - ((float) this.offsetX), (y - this.mLastTouchYLine) - ((float) this.offsetY));
                                    this.mLastTouchXLine = x - ((float) this.offsetX);
                                    this.mLastTouchYLine = y - ((float) this.offsetY);
                                    ((LineHelper) this.lineHelpers.get(this.currentCollageIndex)).updateGridLines();
                                    for (j = 0; j < ((ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex)).shapeArr.length; j++) {
                                        ((ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex)).shapeArr[j].updateFromLine(((ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex)).shapeArr[j].points);
                                        setPathPadding(this.currentCollageIndex, this.paddingDistance, true);
                                    }
                                    invalidate();
                                }
                                return true;
                            }
                        }
                        if (this.shapeIndex < 0) {
                            selectCurrentShape(x, y, false);
                        }
                        if (this.shapeIndex >= 0) {
                            if (!CollageActivity.this.isScrapBook || !this.isInCircle) {
                                ((ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex)).shapeArr[this.shapeIndex].bitmapMatrixTranslate(x - this.mLastTouchX, y - this.mLastTouchY);
                                this.mLastTouchX = x;
                                this.mLastTouchY = y;
                                invalidate();
                                break;
                            }
                            this.pts = ((ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex)).shapeArr[this.shapeIndex].getMappedCenter();
                            float currentAngle = -Utility.pointToAngle(x, y, this.pts[0], this.pts[1]);
                            float rotation = getMatrixRotation(((ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex)).shapeArr[this.shapeIndex].bitmapMatrix);
                            if ((rotation == 0.0f || rotation == 90.0f || rotation == 180.0f || rotation == -180.0f || rotation == -90.0f) && Math.abs(this.startAngle - currentAngle) < 4.0f) {
                                this.orthogonal = true;
                            } else {
                                if (Math.abs((rotation - this.startAngle) + currentAngle) < 4.0f) {
                                    currentAngle = this.startAngle - rotation;
                                    this.orthogonal = true;
                                } else if (Math.abs(90.0f - ((rotation - this.startAngle) + currentAngle)) < 4.0f) {
                                    currentAngle = (90.0f + this.startAngle) - rotation;
                                    this.orthogonal = true;
                                } else if (Math.abs(180.0f - ((rotation - this.startAngle) + currentAngle)) < 4.0f) {
                                    currentAngle = (180.0f + this.startAngle) - rotation;
                                    this.orthogonal = true;
                                } else if (Math.abs(-180.0f - ((rotation - this.startAngle) + currentAngle)) < 4.0f) {
                                    currentAngle = (-180.0f + this.startAngle) - rotation;
                                    this.orthogonal = true;
                                } else if (Math.abs(-90.0f - ((rotation - this.startAngle) + currentAngle)) < 4.0f) {
                                    currentAngle = (-90.0f + this.startAngle) - rotation;
                                    this.orthogonal = true;
                                } else {
                                    this.orthogonal = false;
                                }
                                ((ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex)).shapeArr[this.shapeIndex].bitmapMatrixRotate(this.startAngle - currentAngle);
                                this.startAngle = currentAngle;
                            }
                            float scaley = ((float) Math.sqrt((double) (((x - this.pts[0]) * (x - this.pts[0])) + ((y - this.pts[1]) * (y - this.pts[1]))))) / ((float) Math.sqrt((double) (((this.zoomStart.x - this.pts[0]) * (this.zoomStart.x - this.pts[0])) + ((this.zoomStart.y - this.pts[1]) * (this.zoomStart.y - this.pts[1])))));
                            float scale = ((ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex)).shapeArr[this.shapeIndex].getScale();
                            if (scale >= this.MIN_ZOOM || (scale < this.MIN_ZOOM && scaley > 1.0f)) {
                                ((ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex)).shapeArr[this.shapeIndex].bitmapMatrixScaleScrapBook(scaley, scaley);
                                this.zoomStart.set(x, y);
                            }
                            invalidate();
                            CollageActivity.this.checkDecoareteViewPositions(CollageActivity.this.getCurrentMatrixForSticker());
                            return true;
                        }
                    }
                    break;
                case 3:
                    this.mActivePointerId = -1;
                    this.isInCircle = false;
                    this.isOnCross = false;
                    break;
                case 6:
                    this.finalAngle = 0.0f;
                    pointerIndex = (MotionEventCompat.ACTION_POINTER_INDEX_MASK & action) >> 8;
                    if (ev.getPointerId(pointerIndex) == this.mActivePointerId) {
                        int newPointerIndex = pointerIndex == 0 ? 1 : 0;
                        this.mLastTouchX = ev.getX(newPointerIndex);
                        this.mLastTouchY = ev.getY(newPointerIndex);
                        this.mActivePointerId = ev.getPointerId(newPointerIndex);
                        break;
                    }
                    break;
            }
            CollageActivity.this.checkDecoareteViewPositions(CollageActivity.this.getCurrentMatrixForSticker());
            return true;
        }

        private void selectCurrentShapeScrapBook(float x, float y, boolean isSingleTap) {
            int i;
            int length = ((ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex)).shapeArr.length;
            boolean isSelected = false;
            for (i = length - 1; i >= 0; i--) {
                if (((ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex)).shapeArr[i].isScrapBookSelected(x, y)) {
                    this.shapeIndex = i;
                    isSelected = true;
                    break;
                }
            }
            if (this.previousIndex == this.shapeIndex && isSingleTap) {
                unselectShapes();
            } else if (!isSelected) {
                unselectShapes();
            } else if (CollageActivity.this.selectImageForAdj) {
                openFilterFragment();
            } else if (this.shapeIndex >= 0 && this.shapeIndex < length) {
                Shape shapeTemp = ((ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex)).shapeArr[this.shapeIndex];
                Bitmap btmTemp = CollageActivity.this.bitmapList[this.shapeIndex];
                Parameter prmTemp = CollageActivity.this.parameterList[this.shapeIndex];
                for (i = 0; i < length; i++) {
                    if (i >= this.shapeIndex) {
                        if (i < length - 1) {
                            ((ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex)).shapeArr[i] = ((ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex)).shapeArr[i + 1];
                            CollageActivity.this.bitmapList[i] = CollageActivity.this.bitmapList[i + 1];
                            CollageActivity.this.parameterList[i] = CollageActivity.this.parameterList[i + 1];
                        } else {
                            ((ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex)).shapeArr[i] = shapeTemp;
                            CollageActivity.this.bitmapList[i] = btmTemp;
                            CollageActivity.this.parameterList[i] = prmTemp;
                        }
                    }
                }
                if (this.previousIndex == this.shapeIndex) {
                    this.previousIndex = length - 1;
                } else if (this.previousIndex > this.shapeIndex) {
                    this.previousIndex--;
                }
                this.shapeIndex = length - 1;
                if (this.shapeIndex >= 0 && ((ShapeLayout) this.shapeLayoutList.get(0)).shapeArr.length > 0) {
                    CollageActivity.this.contextFooter.setVisibility(0);
                    CollageActivity.this.setSelectedTab(7);
                }
            }
            if (this.shapeIndex >= 0) {
                ((ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex)).shapeArr[this.shapeIndex].bitmapMatrixgGetValues(this.matrixValues);
                this.mScaleFactor = this.matrixValues[0];
            }
            postInvalidate();
        }

        private void selectCurrentShape(float x, float y, boolean isSingleTap) {
            if (CollageActivity.this.isScrapBook) {
                selectCurrentShapeScrapBook(x, y, isSingleTap);
            } else {
                selectCurrentShapeCollage(x, y, isSingleTap);
            }
        }

        private void selectCurrentShapeCollage(float x, float y, boolean isSingleTap) {
            int swapIndex = this.shapeIndex;
            for (int i = 0; i < ((ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex)).shapeArr.length; i++) {
                if (((ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex)).shapeArr[i].region.contains((int) x, (int) y)) {
                    this.shapeIndex = i;
                }
            }
            if (CollageActivity.this.selectImageForAdj) {
                openFilterFragment();
            } else if (CollageActivity.this.swapMode) {
                if (swapIndex != this.shapeIndex && swapIndex > -1 && this.shapeIndex > -1) {
                    swapBitmaps(this.shapeIndex, swapIndex);
                    CollageActivity.this.swapMode = false;
                }
            } else if (this.previousIndex == this.shapeIndex && isSingleTap) {
                unselectShapes();
            } else if (this.shapeIndex >= 0 && ((ShapeLayout) this.shapeLayoutList.get(0)).shapeArr.length > 0) {
                CollageActivity.this.contextFooter.setVisibility(0);
                CollageActivity.this.setSelectedTab(7);
            }
            if (this.shapeIndex >= 0) {
                ((ShapeLayout) this.shapeLayoutList.get(this.currentCollageIndex)).shapeArr[this.shapeIndex].bitmapMatrixgGetValues(this.matrixValues);
                this.mScaleFactor = this.matrixValues[0];
            }
            postInvalidate();
        }

        void unselectShapes() {
            CollageActivity.this.contextFooter.setVisibility(4);
            this.shapeIndex = -1;
            postInvalidate();
        }

        public void openFilterFragment() {
            CollageActivity.this.selectFilterTextView.setVisibility(4);
            CollageActivity.this.selectImageForAdj = false;
            if (this.shapeIndex >= 0) {
                CollageActivity.this.fullEffectFragment.setBitmapWithParameter(CollageActivity.this.bitmapList[this.shapeIndex], CollageActivity.this.parameterList[this.shapeIndex]);
                CollageActivity.this.setVisibilityOfFilterHorizontalListview(true);
                CollageActivity.this.setVisibilityOfCollage(4);
            }
        }

        float getMatrixRotation(Matrix matrix) {
            matrix.getValues(this.values);
            return (float) Math.round(Math.atan2((double) this.values[1], (double) this.values[0]) * 57.29577951308232d);
        }

        public void setBlurBitmap(int radius, boolean cascade) {
            if (this.blurBuilderNormal == null) {
                this.blurBuilderNormal = new BlurBuilderNormal();
            }
            if (cascade) {
                this.backgroundMode = 2;
                if (!CollageActivity.this.isScrapBook) {
                    CollageActivity.this.seekbarSize.setProgress(CollageActivity.this.seekbarSize.getMax());
                }
            } else {
                this.backgroundMode = 1;
            }
            if (CollageActivity.this.patternHelper == null || CollageActivity.this.patternHelper.bitmapBlur == null || CollageActivity.this.patternHelper.bitmapBlur.isRecycled() || radius != 0) {
                if (CollageActivity.this.patternHelper == null || CollageActivity.this.patternHelper.bitmapBlur == null || CollageActivity.this.patternHelper.bitmapBlur.isRecycled()) {
                    this.blurBitmap = this.blurBuilderNormal.createBlurBitmapNDK(CollageActivity.this.bitmapList[0], radius);
                } else {
                    this.blurBitmap = this.blurBuilderNormal.createBlurBitmapNDK(CollageActivity.this.patternHelper.bitmapBlur, radius);
                }
                CollageActivity.this.blurRadius = this.blurBuilderNormal.getBlur();
            } else {
                this.blurBitmap = CollageActivity.this.patternHelper.bitmapBlur;
                CollageActivity.this.blurRadius = 0;
            }
            if (this.blurBitmap != null) {
                setBlurRect2((float) this.blurBitmap.getWidth(), (float) this.blurBitmap.getHeight());
            }
            postInvalidate();
        }

        void setBlurRect2(float btmwidth, float btmheight) {
            float w;
            float h;
            if ((CollageActivity.this.mulY * btmwidth) / CollageActivity.this.mulX < btmheight) {
                w = btmwidth;
                h = (CollageActivity.this.mulY * btmwidth) / CollageActivity.this.mulX;
            } else {
                w = (CollageActivity.this.mulX * btmheight) / CollageActivity.this.mulY;
                h = btmheight;
            }
            int l = (int) ((btmwidth - w) / 2.0f);
            int t = (int) ((btmheight - h) / 2.0f);
            this.blurRectSrc.set(l, t, (int) (((float) l) + w), (int) (((float) t) + h));
        }

        public void setCropBitmap(int left, int top, int right, int bottom) {
            if (this.shapeIndex >= 0) {
                Bitmap sourceBitmap = CollageActivity.this.bitmapList[this.shapeIndex];
                boolean isFilter = sourceBitmap != ((ShapeLayout) this.shapeLayoutList.get(0)).shapeArr[this.shapeIndex].getBitmap();
                if (isFilter) {
                    doCrop(left, top, right, bottom, sourceBitmap, false, false);
                    doCrop(left, top, right, bottom, ((ShapeLayout) this.shapeLayoutList.get(0)).shapeArr[this.shapeIndex].getBitmap(), true, true);
                } else {
                    doCrop(left, top, right, bottom, sourceBitmap, false, true);
                }
                if (!(!isFilter || CollageActivity.this.parameterList == null || CollageActivity.this.parameterList[this.shapeIndex] == null)) {
                    CollageActivity.this.parameterList[this.shapeIndex].setId(Parameter.uniqueId.getAndIncrement());
                }
                invalidate();
            }
        }

        public void doCrop(int left, int top, int right, int bottom, Bitmap sourceBitmap, boolean isFilter, boolean last) {
            Bitmap localCropBtm = sourceBitmap;
            int bitmapWidth = sourceBitmap.getWidth();
            int bitmapHeight = sourceBitmap.getHeight();
            if (right > bitmapWidth) {
                right = bitmapWidth;
            }
            if (bottom > bitmapHeight) {
                bottom = bitmapHeight;
            }
            if (right - left > 0 && bottom - top > 0) {
                if (VERSION.SDK_INT < 12) {
                    sourceBitmap = BlurBuilderNormal.createCroppedBitmap(localCropBtm, left, top, right - left, bottom - top, false);
                } else {
                    sourceBitmap = Bitmap.createBitmap(localCropBtm, left, top, right - left, bottom - top);
                }
                if (localCropBtm != sourceBitmap) {
                    localCropBtm.recycle();
                }
                if (!isFilter) {
                    CollageActivity.this.bitmapList[this.shapeIndex] = sourceBitmap;
                }
                if (last) {
                    for (int i = 0; i < this.shapeLayoutList.size(); i++) {
                        ((ShapeLayout) this.shapeLayoutList.get(i)).shapeArr[this.shapeIndex].setBitmap(sourceBitmap, false);
                        if (CollageActivity.this.isScrapBook) {
                            ((ShapeLayout) this.shapeLayoutList.get(i)).shapeArr[this.shapeIndex].resetDashPaths();
                        }
                    }
                }
            }
        }
    }

    final class MyMediaScannerConnectionClient implements MediaScannerConnectionClient {
        private MediaScannerConnection mConn;
        private String mFilename;
        private String mMimetype;

        public MyMediaScannerConnectionClient(Context ctx, File file, String mimetype) {
            this.mFilename = file.getAbsolutePath();
            this.mConn = new MediaScannerConnection(ctx, this);
            this.mConn.connect();
        }

        public void onMediaScannerConnected() {
            this.mConn.scanFile(this.mFilename, this.mMimetype);
        }

        public void onScanCompleted(String path, Uri uri) {
            this.mConn.disconnect();
        }
    }

    private class SaveImageTask extends AsyncTask<Object, Object, Object> {
        ProgressDialog progressDialog;
        String resultPath;
        int saveMode;

        private SaveImageTask() {
            this.saveMode = 0;
            this.resultPath = null;
        }

        protected Object doInBackground(Object... arg0) {
            if (arg0 != null) {
                this.saveMode = ((Integer) arg0[0]).intValue();
            }
            this.resultPath = collageView.saveBitmap(CollageActivity.this.width, CollageActivity.this.height);
            return null;
        }

        protected void onPreExecute() {
            this.progressDialog = new ProgressDialog(CollageActivity.this.context);
            this.progressDialog.setMessage(CollageActivity.this.getString(R.string.collage_lib_saving_message));
            this.progressDialog.show();
        }

        protected void onPostExecute(Object result) {
            Toast msg;
            try {
                if (this.progressDialog != null && this.progressDialog.isShowing()) {
                    this.progressDialog.cancel();
                }
            } catch (Exception e) {
            }
            if (this.saveMode == 0 || this.saveMode == 4) {
                super.onPostExecute(result);
                msg = Toast.makeText(CollageActivity.this.context, String.format(CollageActivity.this.getString(R.string.save_image_lib_image_saved_message), new Object[]{CollageActivity.this.getString(R.string.directory)}), 1);
                msg.setGravity(17, msg.getXOffset() / 2, msg.getYOffset() / 2);
                msg.show();
                MediaScannerConnectionClient client = new MyMediaScannerConnectionClient(CollageActivity.this.getApplicationContext(), new File(this.resultPath), null);
                if (this.saveMode == 4) {
                    CollageActivity.this.finish();
                }
            } else if (this.saveMode == 1) {
                super.onPostExecute(result);
                try {
                    Intent picMessageIntent = new Intent("android.intent.action.SEND");
                    picMessageIntent.setFlags(268435456);
                    picMessageIntent.setType("image/jpeg");
                    if (this.resultPath != null) {
                        picMessageIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(this.resultPath)));
                        CollageActivity.this.startActivity(picMessageIntent);
                    }
                } catch (Exception e2) {
                    msg = Toast.makeText(CollageActivity.this.context, R.string.collage_lib_no_email_message, 1);
                    msg.setGravity(17, msg.getXOffset() / 2, msg.getYOffset() / 2);
                    msg.show();
                }
            } else if (this.saveMode == 3) {
                Intent fbIntent = new Intent(CollageActivity.this.context, SaveImageActivity.class);
                if (this.resultPath != null) {
                    fbIntent.putExtra("imagePath", this.resultPath);
                    fbIntent.putExtra("urlFacebookLike", CollageActivity.this.getString(R.string.facebook_like_url));
                    fbIntent.putExtra("proVersionUrl", CollageActivity.this.getString(R.string.pro_package));
                    fbIntent.putExtra("folder", CollageActivity.this.getString(R.string.directory));
                    fbIntent.putExtra("twitter_message", CollageActivity.this.getString(R.string.hashtag_twitter) + " ");
                    fbIntent.putExtra("should_show_ads", !CommonLibrary.isAppPro(CollageActivity.this.context));
                    String str = "show_inter_ad";
                    boolean z = !CommonLibrary.isAppPro(CollageActivity.this.context) && CollageActivity.this.context.getResources().getBoolean(R.bool.showInterstitialAds);
                    fbIntent.putExtra(str, z);
                    CollageActivity.this.startActivityForResult(fbIntent, CollageActivity.SAVE_IMAGE_ID);
                }
            }
            MyMediaScannerConnectionClient myMediaScannerConnectionClient = new MyMediaScannerConnectionClient(CollageActivity.this.getApplicationContext(), new File(this.resultPath), null);
        }
    }

    class C10091 implements CurrentCollageIndexChangedListener {
        C10091() {
        }

        public void onIndexChanged(int position) {
            CollageActivity.this.collageView.setCurrentCollageIndex(position);
        }
    }

    class C10104 implements PatternBitmapColorListener {
        C10104() {
        }

        public void patternBitmapReady(int index, Bitmap bitmap, int resId) {
            CollageActivity.this.collageView.setPatternPaint(index, bitmap);
        }

        public void patternColorReady(int color) {
            CollageActivity.this.collageView.setPatternPaintColor(color);
        }

        public void setBacgkroundMode() {
            CollageActivity.this.collageView.backgroundMode = 0;
        }

        public void patternImageReady(Bitmap bitmap) {
            if (bitmap != null) {
                if (CollageActivity.this.collageView == null) {
                    CollageActivity.this.bgImageIsWaiting = true;
                } else {
                    CollageActivity.this.bgImageIsWaiting = false;
                }
                if (!(CollageActivity.this.collageView == null || CollageActivity.this.collageView.blurBitmap == null)) {
                    CollageActivity.this.collageView.blurBitmap.recycle();
                }
                if (CollageActivity.this.collageView != null) {
                    CollageActivity.this.collageView.setBlurBitmap(CollageActivity.this.blurRadius, false);
                    CollageActivity.this.collageView.backgroundMode = 1;
                    CollageActivity.this.collageView.invalidate();
                }
            }
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        Display display = getWindowManager().getDefaultDisplay();
        this.width = display.getWidth();
        this.height = display.getHeight();
        Utility.logFreeMemory(this.context);
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        this.topOffset = metrics.density * 92.0f;
        this.totalOffset = metrics.density * 140.0f;
        this.screenDensity = metrics.density;
        Bundle extras = getIntent().getExtras();
        setContentView(R.layout.activity_collage);
        int arraySize = getCollageSize(extras);
        this.seekBarRound = (SeekBar) findViewById(R.id.seekbar_round);
        this.seekBarRound.setOnSeekBarChangeListener(this.mSeekBarListener);
        this.seekBarPadding = (SeekBar) findViewById(R.id.seekbar_padding);
        this.seekBarPadding.setOnSeekBarChangeListener(this.mSeekBarListener);
        this.seekbarSize = (SeekBar) findViewById(R.id.seekbar_size);
        this.seekbarSize.setOnSeekBarChangeListener(this.mSeekBarListener);
        this.seekbarBlur = (SeekBar) findViewById(R.id.seekbar_collage_blur);
        this.seekbarBlur.setOnSeekBarChangeListener(this.mSeekBarListener);
        this.seekbarCascadeBlur = (SeekBar) findViewById(R.id.seekbar_collage_blur_cascade);
        this.seekbarCascadeBlur.setOnSeekBarChangeListener(this.mSeekBarListener);
        this.seekbarCascadeNumber = (SeekBar) findViewById(R.id.seekbar_cascade_number);
        this.seekbarCascadeNumber.setOnSeekBarChangeListener(this.mSeekBarListener);
        this.seekBarBorder = (SeekBar) findViewById(R.id.seekbar_collage_border);
        this.seekBarBorder.setOnSeekBarChangeListener(this.mSeekBarListener);
        this.collageRecyclerView = (RecyclerView) findViewById(R.id.recyclerView_grid);
        this.colorDefault = getResources().getColor(R.color.view_flipper_bg_color);
        this.colorSelected = getResources().getColor(R.color.footer_button_color_pressed);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.context);
        layoutManager.setOrientation(0);
        this.collageRecyclerView.setLayoutManager(layoutManager);
        this.collageAdapter = new MyAdapter(Collage.collageIconArray[arraySize - 1], new C10091(), this.colorDefault, this.colorSelected, false, true);
        this.collageRecyclerView.setAdapter(this.collageAdapter);
        this.collageRecyclerView.setItemAnimator(new DefaultItemAnimator());
        this.viewFlipper = (ViewFlipper) findViewById(R.id.collage_view_flipper);
        this.viewFlipper.setDisplayedChild(7);
        RecyclerView recyclerViewPattern = (RecyclerView) findViewById(R.id.recyclerView_pattern);
        LinearLayoutManager layoutManagerPattern = new LinearLayoutManager(this.context);
        layoutManagerPattern.setOrientation(0);
        this.colorContainer = (LinearLayout) findViewById(R.id.color_container);
        recyclerViewPattern.setLayoutManager(layoutManagerPattern);
        patternHelperInit();
        recyclerViewPattern.setAdapter(this.patternHelper.patternAdapter);
        recyclerViewPattern.setItemAnimator(new DefaultItemAnimator());
        this.recyclerViewInnerPattern = (RecyclerView) findViewById(R.id.recyclerView_color);
        LinearLayoutManager layoutManagerColor = new LinearLayoutManager(this.context);
        layoutManagerColor.setOrientation(0);
        this.recyclerViewInnerPattern.setLayoutManager(layoutManagerColor);
        final HorizontalScrollView horizontalScrollView = (HorizontalScrollView) findViewById(R.id.collage_footer_scrollview);
        horizontalScrollView.bringToFront();
        horizontalScrollView.postDelayed(new Runnable() {
            public void run() {
                horizontalScrollView.scrollTo(horizontalScrollView.getChildAt(0).getMeasuredWidth(), 0);
            }
        }, 350);
        horizontalScrollView.postDelayed(new Runnable() {
            public void run() {
                horizontalScrollView.fullScroll(17);
            }
        }, 1500);
        CollageActivity collageActivity = this;
        new BitmapWorkerTask().execute(new Bundle[]{extras, savedInstanceState});
    }

    void patternHelperInit() {
        if (this.recyclerViewInnerPattern == null) {
            this.recyclerViewInnerPattern = (RecyclerView) findViewById(R.id.recyclerView_color);
            LinearLayoutManager layoutManagerColor = new LinearLayoutManager(this.context);
            layoutManagerColor.setOrientation(0);
            this.recyclerViewInnerPattern.setLayoutManager(layoutManagerColor);
        }
        this.patternHelper = new PatternHelper(this, new C10104(), this.colorContainer, this.recyclerViewInnerPattern, this.colorDefault, this.colorSelected);
        this.patternHelper.createPatternAdapter(this, this.colorDefault, this.colorSelected);
    }

    private void setVisibilityForSingleImage() {
        findViewById(R.id.seekbar_corner_container).setVisibility(8);
        findViewById(R.id.seekbar_space_container).setVisibility(8);
        findViewById(R.id.button_collage_blur).setVisibility(0);
        findViewById(R.id.button_collage_context_delete).setVisibility(8);
        findViewById(R.id.button_collage_context_swap).setVisibility(8);
        findViewById(R.id.button_collage_cascade).setVisibility(0);
        findViewById(R.id.button_collage_screen_mode).setVisibility(0);
        if (!this.isScrapBook) {
            findViewById(R.id.button_collage_border).setVisibility(0);
        }
        if (!this.isScrapBook) {
            this.collageView.setCollageSize(0, this.collageView.sizeMatrix, 45, false);
            if (this.seekbarSize != null) {
                this.seekbarSize.setProgress(45);
            }
        }
        this.collageView.setBlurBitmap(this.blurRadius, false);
        if (this.isShape) {
            setSelectedTab(0);
        } else if (!this.isScrapBook) {
            setSelectedTab(2);
        }
        if (this.screenDensity <= 0.0f) {
            this.screenDensity = 1.0f;
        }
        Svg.strokeSize = 9.0f / this.screenDensity;
    }

    private void setVisibilityForScrapbook() {
        findViewById(R.id.button_collage_layout).setVisibility(8);
        findViewById(R.id.button_collage_space).setVisibility(8);
        findViewById(R.id.button_collage_context_swap).setVisibility(8);
        findViewById(R.id.button_collage_context_fit).setVisibility(8);
        findViewById(R.id.button_collage_context_center).setVisibility(8);
        findViewById(R.id.button_collage_context_delete).setVisibility(8);
        findViewById(R.id.button_collage_grid_lock).setVisibility(8);
    }

    int getCollageSize(Bundle extras) {
        long[] selectedImageList = extras.getLongArray("photo_id_list");
        if (selectedImageList == null) {
            return 1;
        }
        return selectedImageList.length;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SAVE_IMAGE_ID) {
         /*   if (!CommonLibrary.isAppPro(this.context) && this.context.getResources().getBoolean(R.bool.showInterstitialAds)) {
                AdUtility.displayInterStitialWithSplashScreen(this.interstitial, this, AdUtility.SPLASH_TIME_OUT_DEFAULT, "COLLAGE_ACTIVITY_ONACTIVITYRESULT");
            }*/
        } else if (requestCode == PatternHelper.SELCT_IMAGE_BG && resultCode == -1) {
            if (this.patternHelper == null) {
                patternHelperInit();
            }
            if (this.patternHelper != null) {
                this.patternHelper.activityResult(resultCode, data);
                View buttonBlur = findViewById(R.id.button_collage_blur);
                if (!(buttonBlur == null || buttonBlur.getVisibility() == 0)) {
                    this.seekbarBlur.setProgress(this.blurRadius * 4);
                    buttonBlur.setVisibility(0);
                }
                setSelectedTab(4);
            }
        }
    }

    public void onPause() {
        super.onPause();
        Editor editor = PreferenceManager.getDefaultSharedPreferences(this).edit();
        editor.putBoolean("is_grid_locked2", isGridLayoutLocked);
        editor.commit();
    }

    public void onDestroy() {
        int i;
        super.onDestroy();
        if (this.bitmapList != null) {
            for (i = 0; i < this.bitmapList.length; i++) {
                if (this.bitmapList[i] != null) {
                    this.bitmapList[i].recycle();
                }
            }
        }
        if (this.collageView != null) {
            if (this.collageView.shapeLayoutList != null) {
                for (i = 0; i < this.collageView.shapeLayoutList.size(); i++) {
                    for (int j = 0; j < ((ShapeLayout) this.collageView.shapeLayoutList.get(i)).shapeArr.length; j++) {
                        if (((ShapeLayout) this.collageView.shapeLayoutList.get(i)).shapeArr[j] != null) {
                            ((ShapeLayout) this.collageView.shapeLayoutList.get(i)).shapeArr[j].freeBitmaps();
                        }
                    }
                }
            }
            if (this.collageView.maskBitmapArray != null) {
                i = 0;
                while (i < this.collageView.maskBitmapArray.length) {
                    if (this.collageView.maskBitmapArray[i] != null) {
                        if (!(this.collageView.maskBitmapArray[i] == null || this.collageView.maskBitmapArray[i].isRecycled())) {
                            this.collageView.maskBitmapArray[i].recycle();
                        }
                        this.collageView.maskBitmapArray[i] = null;
                    }
                    i++;
                }
            }
        }
        if (!(this.patternHelper == null || this.patternHelper.bitmapBlur == null)) {
            this.patternHelper.bitmapBlur.recycle();
        }
        if (!(this.collageView == null || this.collageView.blurBuilderNormal == null)) {
            this.collageView.blurBuilderNormal.destroy();
        }
      /*  if (this.adWhirlLayout != null) {
            this.adWhirlLayout.removeAllViews();
            this.adWhirlLayout.destroy();
        }*/
    }

    void setSelectedTab(int index) {
        if (this.viewFlipper != null) {
            setTabBg(0);
            int displayedChild = this.viewFlipper.getDisplayedChild();
            if (displayedChild != 1) {
                hideColorContainer();
            }
            if (index == 0) {
                if (displayedChild != 0) {
                    this.viewFlipper.setInAnimation(this.slideLeftIn);
                    this.viewFlipper.setOutAnimation(this.slideRightOut);
                    this.viewFlipper.setDisplayedChild(0);
                } else {
                    return;
                }
            }
            if (index == 1) {
                setTabBg(1);
                if (displayedChild != 1) {
                    if (displayedChild == 0) {
                        this.viewFlipper.setInAnimation(this.slideRightIn);
                        this.viewFlipper.setOutAnimation(this.slideLeftOut);
                    } else {
                        this.viewFlipper.setInAnimation(this.slideLeftIn);
                        this.viewFlipper.setOutAnimation(this.slideRightOut);
                    }
                    this.viewFlipper.setDisplayedChild(1);
                } else {
                    return;
                }
            }
            if (index == 4) {
                setTabBg(4);
                if (displayedChild != 4) {
                    if (displayedChild == 0) {
                        this.viewFlipper.setInAnimation(this.slideRightIn);
                        this.viewFlipper.setOutAnimation(this.slideLeftOut);
                    } else {
                        this.viewFlipper.setInAnimation(this.slideLeftIn);
                        this.viewFlipper.setOutAnimation(this.slideRightOut);
                    }
                    this.viewFlipper.setDisplayedChild(4);
                } else {
                    return;
                }
            }
            if (index == 5) {
                setTabBg(5);
                if (displayedChild != 5) {
                    if (displayedChild < 5) {
                        this.viewFlipper.setInAnimation(this.slideRightIn);
                        this.viewFlipper.setOutAnimation(this.slideLeftOut);
                    } else {
                        this.viewFlipper.setInAnimation(this.slideLeftIn);
                        this.viewFlipper.setOutAnimation(this.slideRightOut);
                    }
                    this.viewFlipper.setDisplayedChild(5);
                } else {
                    return;
                }
            }
            if (index == 6) {
                setTabBg(6);
                if (displayedChild != 6) {
                    if (displayedChild < 6) {
                        this.viewFlipper.setInAnimation(this.slideRightIn);
                        this.viewFlipper.setOutAnimation(this.slideLeftOut);
                    } else {
                        this.viewFlipper.setInAnimation(this.slideLeftIn);
                        this.viewFlipper.setOutAnimation(this.slideRightOut);
                    }
                    this.viewFlipper.setDisplayedChild(6);
                } else {
                    return;
                }
            }
            if (index == 2) {
                setTabBg(2);
                if (displayedChild != 2) {
                    if (displayedChild == 0 || displayedChild == 1) {
                        this.viewFlipper.setInAnimation(this.slideRightIn);
                        this.viewFlipper.setOutAnimation(this.slideLeftOut);
                    } else {
                        this.viewFlipper.setInAnimation(this.slideLeftIn);
                        this.viewFlipper.setOutAnimation(this.slideRightOut);
                    }
                    this.viewFlipper.setDisplayedChild(2);
                } else {
                    return;
                }
            }
            if (index == 3) {
                setTabBg(3);
                if (displayedChild != 3) {
                    if (displayedChild == 7) {
                        this.viewFlipper.setInAnimation(this.slideLeftIn);
                        this.viewFlipper.setOutAnimation(this.slideRightOut);
                    } else {
                        this.viewFlipper.setInAnimation(this.slideRightIn);
                        this.viewFlipper.setOutAnimation(this.slideLeftOut);
                    }
                    this.viewFlipper.setDisplayedChild(3);
                } else {
                    return;
                }
            }
            if (index == 7) {
                setTabBg(-1);
                if (displayedChild != 7) {
                    this.viewFlipper.setInAnimation(this.slideRightIn);
                    this.viewFlipper.setOutAnimation(this.slideLeftOut);
                    this.viewFlipper.setDisplayedChild(7);
                }
            }
        }
    }

    private void setTabBg(int index) {
        if (this.tabButtonList == null) {
            this.tabButtonList = new View[8];
            this.tabButtonList[0] = findViewById(R.id.button_collage_layout);
            this.tabButtonList[2] = findViewById(R.id.button_collage_space);
            this.tabButtonList[4] = findViewById(R.id.button_collage_blur);
            this.tabButtonList[1] = findViewById(R.id.button_collage_background);
            this.tabButtonList[3] = findViewById(R.id.button_collage_ratio);
            this.tabButtonList[5] = findViewById(R.id.button_collage_cascade);
            this.tabButtonList[6] = findViewById(R.id.button_collage_border);
            this.tabButtonList[7] = findViewById(R.id.button_collage_adj);
        }
        for (View backgroundResource : this.tabButtonList) {
            backgroundResource.setBackgroundResource(R.drawable.collage_footer_button);
        }
        if (index >= 0) {
            this.tabButtonList[index].setBackgroundResource(R.color.footer_button_color_pressed);
        }
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        if (this.textLibHelper != null) {
            this.textLibHelper.saveTextAndStickerDataInstance(savedInstanceState, this.textAndStickerViewContainer, null);
        }
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (this.textLibHelper == null) {
            this.textLibHelper = new TextLibHelper();
        }
        if (this.stickerLibHelper == null) {
            this.stickerLibHelper = new StickerLibHelper();
        }
        if (this.textAndStickerViewContainer == null) {
            this.textAndStickerViewContainer = (FrameLayout) findViewById(R.id.sticker_view_container);
            this.textAndStickerViewContainer.bringToFront();
            this.textAndStickerViewContainer.setOnHierarchyChangeListener(new C06036());
            findViewById(R.id.collage_footer_container).bringToFront();
            if (this.viewFlipper == null) {
                this.viewFlipper = (ViewFlipper) findViewById(R.id.collage_view_flipper);
            }
            if (this.viewFlipper != null) {
                this.viewFlipper.bringToFront();
            }
            View header = findViewById(R.id.collage_header);
            if (header != null) {
                header.bringToFront();
            }
            findViewById(R.id.collage_header_shadow).bringToFront();
            if (this.contextFooter == null) {
                this.contextFooter = (ViewGroup) findViewById(R.id.collage_context_menu);
            }
            if (this.contextFooter != null) {
                this.contextFooter.bringToFront();
            }
            this.selectSwapTextView = findViewById(R.id.select_image_swap);
            if (this.selectSwapTextView != null) {
                this.selectSwapTextView.bringToFront();
                this.selectSwapTextView.setVisibility(4);
            }
            this.selectFilterTextView = findViewById(R.id.select_image_filter);
            if (this.selectFilterTextView != null) {
                this.selectFilterTextView.bringToFront();
                this.selectFilterTextView.setVisibility(4);
            }
        }
        if (this.textLibHelper != null) {
            this.textLibHelper.loadTextAndStickerDataFromSavedInstance(this.activityFragment, savedInstanceState, this.textAndStickerViewContainer, this.textFragemntContinerId, null);
        }
    }

    public void myClickHandler(View view) {
        int id = view.getId();
        if (id == R.id.button_collage_layout) {
            setSelectedTab(0);
        } else if (id == R.id.button_collage_ratio) {
            setSelectedTab(3);
        } else if (id == R.id.button_collage_blur) {
            this.collageView.setBlurBitmap(this.blurRadius, false);
            setSelectedTab(4);
            this.collageView.startAnimator();
        } else if (id == R.id.button_collage_cascade) {
            this.collageView.setBlurBitmap(this.blurRadius, true);
            setSelectedTab(5);
        } else if (id == R.id.button_collage_background) {
            setSelectedTab(1);
        } else if (id == R.id.button_collage_space) {
            setSelectedTab(2);
        } else if (id == R.id.button_collage_border) {
            setSelectedTab(6);
        } else if (id == R.id.button_collage_adj) {
            if (((ShapeLayout) this.collageView.shapeLayoutList.get(0)).shapeArr.length == 1) {
                this.collageView.shapeIndex = 0;
                this.collageView.openFilterFragment();
            } else if (this.collageView.shapeIndex >= 0) {
                this.collageView.openFilterFragment();
            } else {
                setSelectedTab(7);
                this.selectFilterTextView.setVisibility(0);
                this.selectImageForAdj = true;
            }
        } else if (id == R.id.button_collage_context_swap) {
            if (((ShapeLayout) this.collageView.shapeLayoutList.get(this.collageView.currentCollageIndex)).shapeArr.length == 2) {
                this.collageView.swapBitmaps(0, 1);
            } else {
                this.selectSwapTextView.setVisibility(0);
                this.swapMode = true;
            }
        } else if (id == R.id.button_collage_context_delete) {
            createDeleteDialog();
        }/* else if (id == R.id.button_collage_context_crop) {
            if (this.collageView != null && this.collageView.shapeIndex >= 0) {
                addCropFragment(((ShapeLayout) this.collageView.shapeLayoutList.get(0)).shapeArr[this.collageView.shapeIndex].getBitmap());
            }
        } */else if (id == R.id.button_collage_context_filter) {
            this.collageView.openFilterFragment();
        } else if (id == R.id.button_save_collage_image) {
            setSelectedTab(7);
            new SaveImageTask().execute(new Object[]{Integer.valueOf(3)});
        } else if (id == R.id.button_cancel_collage_image) {
            backButtonAlertBuilder();
        } else if (id == R.id.button11) {
            this.mulX = 1.0f;
            this.mulY = 1.0f;
            this.collageView.updateShapeListForRatio(this.width, this.height);
            setRatioButtonBg(0);
        } else if (id == R.id.button21) {
            this.mulX = 2.0f;
            this.mulY = 1.0f;
            this.collageView.updateShapeListForRatio(this.width, this.height);
            setRatioButtonBg(1);
        } else if (id == R.id.button12) {
            this.mulX = 1.0f;
            this.mulY = 2.0f;
            this.collageView.updateShapeListForRatio(this.width, this.height);
            setRatioButtonBg(2);
        } else if (id == R.id.button32) {
            this.mulX = 3.0f;
            this.mulY = 2.0f;
            this.collageView.updateShapeListForRatio(this.width, this.height);
            setRatioButtonBg(3);
        } else if (id == R.id.button23) {
            this.mulX = 2.0f;
            this.mulY = 3.0f;
            this.collageView.updateShapeListForRatio(this.width, this.height);
            setRatioButtonBg(4);
        } else if (id == R.id.button43) {
            this.mulX = 4.0f;
            this.mulY = 3.0f;
            this.collageView.updateShapeListForRatio(this.width, this.height);
            setRatioButtonBg(5);
        } else if (id == R.id.button34) {
            this.mulX = 3.0f;
            this.mulY = 4.0f;
            this.collageView.updateShapeListForRatio(this.width, this.height);
            setRatioButtonBg(6);
        } else if (id == R.id.button45) {
            this.mulX = 4.0f;
            this.mulY = 5.0f;
            this.collageView.updateShapeListForRatio(this.width, this.height);
            setRatioButtonBg(7);
        } else if (id == R.id.button57) {
            this.mulX = 5.0f;
            this.mulY = 7.0f;
            this.collageView.updateShapeListForRatio(this.width, this.height);
            setRatioButtonBg(8);
        } else if (id == R.id.button169) {
            this.mulX = 16.0f;
            this.mulY = 9.0f;
            this.collageView.updateShapeListForRatio(this.width, this.height);
            setRatioButtonBg(9);
        } else if (id == R.id.button916) {
            this.mulX = 9.0f;
            this.mulY = 16.0f;
            this.collageView.updateShapeListForRatio(this.width, this.height);
            setRatioButtonBg(10);
        } else if (id == R.id.hide_select_image_warning) {
            this.selectSwapTextView.setVisibility(4);
            this.swapMode = false;
        } else if (id == R.id.hide_select_image_warning_filter) {
            this.selectFilterTextView.setVisibility(4);
            this.selectImageForAdj = false;
        } else if (id == R.id.hide_color_container) {
            hideColorContainer();
        } else if (id == R.id.button_mirror_text) {
            if (this.textLibHelper == null) {
                this.textLibHelper = new TextLibHelper();
            }
            this.textLibHelper.addCanvasText2(this.activityFragment, this.textAndStickerViewContainer, this.textFragemntContinerId);
            clearViewFlipper();
        } else if (id == R.id.button_mirror_sticker) {
            if (this.stickerLibHelper == null) {
                this.stickerLibHelper = new StickerLibHelper();
            }
            this.stickerLibHelper.addStickerGalleryFragment(this.activityFragment, this.textAndStickerViewContainer, this.stickerFragemntContinerId);
            setVisibilityOfCollage(4);
        }
        if (id == R.id.button_collage_context_fit) {
            this.collageView.setShapeScaleMatrix(0);
        } else if (id == R.id.button_collage_context_center) {
            this.collageView.setShapeScaleMatrix(1);
        } else if (id == R.id.button_collage_context_rotate_left) {
            this.collageView.setShapeScaleMatrix(3);
        } else if (id == R.id.button_collage_context_rotate_right) {
            this.collageView.setShapeScaleMatrix(2);
        } else if (id == R.id.button_collage_context_flip_horizontal) {
            this.collageView.setShapeScaleMatrix(4);
        } else if (id == R.id.button_collage_context_flip_vertical) {
            this.collageView.setShapeScaleMatrix(5);
        } else if (id == R.id.button_collage_context_rotate_negative) {
            this.collageView.setShapeScaleMatrix(6);
        } else if (id == R.id.button_collage_context_rotate_positive) {
            this.collageView.setShapeScaleMatrix(7);
        } else if (id == R.id.button_collage_context_zoom_in) {
            toastMatrixMessage(this.collageView.setShapeScaleMatrix(8));
        } else if (id == R.id.button_collage_context_zoom_out) {
            toastMatrixMessage(this.collageView.setShapeScaleMatrix(9));
        } else if (id == R.id.button_collage_context_move_left) {
            toastMatrixMessage(this.collageView.setShapeScaleMatrix(10));
        } else if (id == R.id.button_collage_context_move_right) {
            toastMatrixMessage(this.collageView.setShapeScaleMatrix(11));
        } else if (id == R.id.button_collage_context_move_up) {
            toastMatrixMessage(this.collageView.setShapeScaleMatrix(12));
        } else if (id == R.id.button_collage_context_move_down) {
            toastMatrixMessage(this.collageView.setShapeScaleMatrix(13));
        } else if (id == R.id.button_collage_grid_lock) {
            if (isGridLayoutLocked) {
                new AlertDialog.Builder(this.context).setMessage(R.string.collage_lib_unlock_message).setPositiveButton(getString(17039379), this.dialogClickListener).setNegativeButton(getString(17039369), this.dialogClickListener).show();
            } else {
                handleLock();
            }
        } else if (id == R.id.button_collage_pattern_download) {
            if (this.patternHelper == null) {
                patternHelperInit();
            }
            this.patternHelper.patternDownloadClicker(this, this.colorDefault, this.colorSelected);
        } else if (id == R.id.button_collage_pattern_image) {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction("android.intent.action.GET_CONTENT");
            this.patternHelper.selectImage();
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PatternHelper.SELCT_IMAGE_BG);
        } else if (id == R.id.button_collage_screen_mode) {
            String msg;
            this.collageView.changeViewSizeMode();
            if (this.originalInstagram == null) {
                this.originalInstagram = (Button) findViewById(R.id.button_collage_screen_mode);
            }
            int i = this.collageView.viewSizeMode;
            CollageView collageView = this.collageView;
            if (i == 0) {
                this.originalInstagram.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.collage_mode_original, 0, 0);
                msg = getString(R.string.instagram);
                this.originalInstagram.setText(R.string.hdr_fx_original);
                setRatioButtonBg(0);
                msg = msg + " 1:1";
            } else {
                this.originalInstagram.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.collage_mode_instagram, 0, 0);
                msg = getString(R.string.hdr_fx_original);
                this.originalInstagram.setText(R.string.instagram);
            }
            Toast toast = Toast.makeText(this.context, msg, 1);
            toast.setGravity(17, toast.getXOffset() / 2, toast.getYOffset() / 2);
            toast.show();
        } else if (this.fullEffectFragment != null && this.fullEffectFragment.isVisible()) {
            this.fullEffectFragment.myClickHandler(view);
        }
        GalleryUtility.logHeap();
        Utility.logFreeMemory(this.context);
    }

    void handleLock() {
        isGridLayoutLocked = !isGridLayoutLocked;
        setLockViewStates();
        this.collageView.setLockScales();
        checkDecoareteViewPositions(getCurrentMatrixForSticker());
        this.collageView.invalidate();
    }

    void setLockViewStates() {
        if (isGridLayoutLocked) {
            ((Button) findViewById(R.id.button_collage_grid_lock)).setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.grid_locked, 0, 0);
            findViewById(R.id.button_collage_context_fit).setVisibility(8);
            return;
        }
        ((Button) findViewById(R.id.button_collage_grid_lock)).setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.grid_unlocked, 0, 0);
        findViewById(R.id.button_collage_context_fit).setVisibility(0);
    }

    void toastMatrixMessage(int message) {
        String str = null;
        if (message == 1) {
            str = getString(R.string.collage_lib_maximum_zoom);
        } else if (message == 2) {
            str = getString(R.string.collage_lib_minimum_zoom);
        } else if (message == 6) {
            str = getString(R.string.collage_lib_max_bottom);
        } else if (message == 5) {
            str = getString(R.string.collage_lib_max_top);
        } else if (message == 4) {
            str = getString(R.string.collage_lib_max_right);
        } else if (message == 3) {
            str = getString(R.string.collage_lib_max_left);
        }
        if (str != null) {
            Toast msg = Toast.makeText(this.context, str, 0);
            msg.setGravity(17, msg.getXOffset() / 2, msg.getYOffset() / 2);
            msg.show();
        }
    }

    void createDeleteDialog() {
        if (((ShapeLayout) this.collageView.shapeLayoutList.get(0)).shapeArr.length == 1) {
            Toast msg = Toast.makeText(this.context, R.string.collage_lib_delete_last_image_error_message, 1);
            msg.setGravity(17, msg.getXOffset() / 2, msg.getYOffset() / 2);
            msg.show();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.activity);
        builder.setMessage(R.string.collage_lib_delete_message).setCancelable(true).setPositiveButton(getString(17039379), new C06069()).setNegativeButton(getString(17039369), new C06058());
        this.saveImageAlert = builder.create();
        this.saveImageAlert.show();
    }

    void clearViewFlipper() {
        this.viewFlipper.setDisplayedChild(7);
        setTabBg(-1);
    }

    private void hideColorContainer() {
        if (this.colorContainer == null) {
            this.colorContainer = (LinearLayout) findViewById(R.id.color_container);
        }
        this.colorContainer.setVisibility(4);
    }

    private void setRatioButtonBg(int index) {
        if (this.ratioButtonArray == null) {
            this.ratioButtonArray = new Button[this.RATIO_BUTTON_SIZE];
            this.ratioButtonArray[0] = (Button) findViewById(R.id.button11);
            this.ratioButtonArray[1] = (Button) findViewById(R.id.button21);
            this.ratioButtonArray[2] = (Button) findViewById(R.id.button12);
            this.ratioButtonArray[3] = (Button) findViewById(R.id.button32);
            this.ratioButtonArray[4] = (Button) findViewById(R.id.button23);
            this.ratioButtonArray[5] = (Button) findViewById(R.id.button43);
            this.ratioButtonArray[6] = (Button) findViewById(R.id.button34);
            this.ratioButtonArray[7] = (Button) findViewById(R.id.button45);
            this.ratioButtonArray[8] = (Button) findViewById(R.id.button57);
            this.ratioButtonArray[9] = (Button) findViewById(R.id.button169);
            this.ratioButtonArray[10] = (Button) findViewById(R.id.button916);
        }
        for (int i = 0; i < this.RATIO_BUTTON_SIZE; i++) {
            this.ratioButtonArray[i].setBackgroundResource(R.drawable.selector_collage_ratio_button);
        }
        this.ratioButtonArray[index].setBackgroundResource(R.drawable.collage_ratio_bg_pressed);
    }

    void addEffectFragment() {
        if (this.fullEffectFragment == null) {
            this.fullEffectFragment = (FullEffectFragment) getSupportFragmentManager().findFragmentByTag("FULL_FRAGMENT");
            if (this.fullEffectFragment == null) {
                this.fullEffectFragment = new FullEffectFragment();
                this.fullEffectFragment.setArguments(getIntent().getExtras());
                try {
                    getSupportFragmentManager().beginTransaction().add(R.id.collage_effect_fragment_container, this.fullEffectFragment, "FULL_FRAGMENT").commitAllowingStateLoss();
                } catch (Exception e) {
                }
            } else if (this.collageView.shapeIndex >= 0) {
                this.fullEffectFragment.setBitmapWithParameter(this.bitmapList[this.collageView.shapeIndex], this.parameterList[this.collageView.shapeIndex]);
            }
            try {
                getSupportFragmentManager().beginTransaction().hide(this.fullEffectFragment).commitAllowingStateLoss();
            } catch (Exception e2) {
            }
            this.fullEffectFragment.setFullBitmapReadyListener(new FullBitmapReady() {
                public void onBitmapReady(Bitmap bitmap, Parameter parameter) {
                    CollageActivity.this.collageView.updateShapeListForFilterBitmap(bitmap);
                    CollageActivity.this.collageView.updateParamList(parameter);
                    CollageActivity.this.collageView.postInvalidate();
                    CollageActivity.this.getSupportFragmentManager().beginTransaction().hide(CollageActivity.this.fullEffectFragment).commitAllowingStateLoss();
                    CollageActivity.this.setVisibilityOfCollage(0);
                    CollageActivity.this.collageView.postInvalidate();
                }

                public void onCancel() {
                    CollageActivity.this.setVisibilityOfFilterHorizontalListview(false);
                    CollageActivity.this.collageView.postInvalidate();
                }
            });
            findViewById(R.id.collage_effect_fragment_container).bringToFront();
        }
    }

    void setVisibilityOfFilterHorizontalListview(boolean show) {
        if (show && this.fullEffectFragment.isHidden()) {
            getSupportFragmentManager().beginTransaction().show(this.fullEffectFragment).commitAllowingStateLoss();
        }
        if (!show && this.fullEffectFragment.isVisible()) {
            getSupportFragmentManager().beginTransaction().hide(this.fullEffectFragment).commitAllowingStateLoss();
        }
        findViewById(R.id.collage_effect_fragment_container).bringToFront();
        if (show) {
            setVisibilityOfCollage(4);
        } else {
            setVisibilityOfCollage(0);
        }
    }

    public void onBackPressed() {
        if (this.stickerLibHelper == null) {
            this.stickerLibHelper = new StickerLibHelper();
        }
        if (this.textLibHelper == null) {
            this.textLibHelper = new TextLibHelper();
        }
/*        if (!this.textLibHelper.removeOnBackPressed(this.activityFragment) && !PatternHelper.onBackPressed(this)) {
            if (this.cropFragment != null && this.cropFragment.isVisible()) {
                this.cropFragment.onBackPressed();
                setVisibilityOfCollage(0);
            } else if (this.textLibHelper != null && this.textLibHelper.hideOnBackPressed(this.activityFragment)) {
            } else {
                if (this.stickerLibHelper != null && this.stickerLibHelper.hideOnBackPressed()) {
                    setVisibilityOfCollage(0);
                } else if (this.textAndStickerViewContainer != null && TextLibHelper.onBackPressedForDecorateViewSelection(this.textAndStickerViewContainer)) {
                } else {
                    if (this.fullEffectFragment == null || !this.fullEffectFragment.isVisible()) {
                        if (this.colorContainer.getVisibility() == 0) {
                            hideColorContainer();
                        } else if (this.swapMode) {
                            this.selectSwapTextView.setVisibility(4);
                            this.swapMode = false;
                        } else if (this.collageView != null && this.collageView.shapeIndex >= 0) {
                            this.collageView.unselectShapes();
                        } else if (this.selectImageForAdj) {
                            this.selectFilterTextView.setVisibility(4);
                            this.selectImageForAdj = false;
                        } else if (this.viewFlipper != null && this.viewFlipper.getDisplayedChild() != 7) {
                            setSelectedTab(7);
                        } else if (this.contextFooter == null || this.contextFooter.getVisibility() != 0) {
                            backButtonAlertBuilder();
                        } else {
                            this.contextFooter.setVisibility(4);
                        }
                    } else if (!this.fullEffectFragment.onBackPressed()) {
                        setVisibilityOfFilterHorizontalListview(false);
                        setVisibilityOfCollage(0);
                    }
                }
            }
        }*/
    }

    private void backButtonAlertBuilder() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.activity);
        builder.setMessage("Would you like to save image ?").setCancelable(true).setPositiveButton(getString(17039379), new OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                new SaveImageTask().execute(new Object[]{Integer.valueOf(4)});
            }
        }).setNegativeButton(getString(17039360), new OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        }).setNeutralButton(getString(R.string.collage_lib_save_no), new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                CollageActivity.this.activity.finish();
            }
        });
        this.saveImageAlert = builder.create();
        this.saveImageAlert.show();
    }

    void checkDecoareteViewPositions(Matrix cvsMtrx) {
        if (cvsMtrx != null && this.textAndStickerViewContainer != null && this.textAndStickerViewContainer.getChildCount() > 0) {
            int size = this.textAndStickerViewContainer.getChildCount();
            for (int i = 0; i < size; i++) {
                DecorateView decorateView = (DecorateView) this.textAndStickerViewContainer.getChildAt(i);
                BaseData data = decorateView.getData();
                MyMatrix imageSaveMatrix = data.getImageSaveMatrix();
                if (imageSaveMatrix != null) {
                    decorateView.setMatrix(imageSaveMatrix);
                    MyMatrix mat = new MyMatrix(data.getCanvasMatrix());
                    mat.postConcat(cvsMtrx);
                    decorateView.setMatrix(mat);
                    decorateView.postInvalidate();
                }
            }
        }
    }

    Matrix getCurrentMatrixForSticker() {
        if (this.collageView == null || this.collageView.shapeLayoutList == null || ((ShapeLayout) this.collageView.shapeLayoutList.get(this.collageView.currentCollageIndex)).shapeArr == null || ((ShapeLayout) this.collageView.shapeLayoutList.get(this.collageView.currentCollageIndex)).shapeArr[0] == null) {
            return null;
        }
        if (((ShapeLayout) this.collageView.shapeLayoutList.get(this.collageView.currentCollageIndex)).shapeArr.length > 1) {
            return null;
        }
        this.f2024m.set(((ShapeLayout) this.collageView.shapeLayoutList.get(this.collageView.currentCollageIndex)).shapeArr[0].bitmapMatrix);
        this.f2024m.postConcat(this.collageView.sizeMatrix);
        return this.f2024m;
    }

   /* void addCropFragment(Bitmap sourceBitmap) {
        ((FrameLayout) findViewById(R.id.crop_fragment_container)).bringToFront();
        this.cropFragment = (FragmentCrop) getSupportFragmentManager().findFragmentByTag("crop_fragment");
        if (this.cropFragment == null) {
            this.cropFragment = new FragmentCrop();
            this.cropFragment.setCropListener(this.cropListener);
            this.cropFragment.setBitmap(sourceBitmap);
            this.cropFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.crop_fragment_container, this.cropFragment, "crop_fragment").commitAllowingStateLoss();
        } else {
            this.cropFragment.setCropListener(this.cropListener);
            this.cropFragment.setBitmap(sourceBitmap);
        }
        setVisibilityOfCollage(4);
    }*/

    void setVisibilityOfCollage(final int visibility) {
        if (this.mainLayout == null) {
            this.mainLayout = (RelativeLayout) findViewById(R.id.collage_main_layout);
        }
        if (this.mainLayout.getVisibility() == visibility) {
            return;
        }
        if (visibility == 4) {
            this.collageVisibilityHandler.postDelayed(new Runnable() {
                public void run() {
                    CollageActivity.this.mainLayout.setVisibility(visibility);
                }
            }, 100);
        } else {
            this.mainLayout.setVisibility(visibility);
        }
    }
}
