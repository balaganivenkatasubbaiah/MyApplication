package com.lyrebirdstudio.lyrebirdlibrary;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import android.widget.ViewSwitcher;

import com.lyrebirdstudio.R;
import com.lyrebirdstudio.hdrlightlib.HdrLightHelper;
import com.lyrebirdstudio.lyrebirdlibrary.FullEffectFragment.HideHeaderListener;
import com.lyrebirdstudio.lyrebirdlibrary.LibUtility.BuyProVersion;
import com.lyrebirdstudio.lyrebirdlibrary.LibUtility.ExcludeTabListener;
import com.lyrebirdstudio.lyrebirdlibrary.LibUtility.FooterVisibilityListener;
import com.lyrebirdstudio.lyrebirdlibrary.MyRecyclerViewAdapter.RecyclerAdapterIndexChangedListener;
import com.lyrebirdstudio.lyrebirdlibrary.MyRecyclerViewAdapter.SelectedIndexChangedListener;
import com.lyrebirdstudio.tiltshift.TiltContext;
import com.lyrebirdstudio.tiltshift.TiltContext.TiltMode;
import com.lyrebirdstudio.tiltshift.TiltFragment;
import com.lyrebirdstudio.tiltshift.TiltFragment.TiltListener;
import com.lyrebirdstudio.tiltshift.TiltHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class EffectFragment extends Fragment {
    public static final int INDEX_ADJUSTMENT = 4;
    public static final int INDEX_BLUR = 10;
    public static final int INDEX_BRIGHTNESS = 4;
    public static final int INDEX_CONTRAST = 6;
    public static final int INDEX_FRAME = 1;
    public static final int INDEX_FX = 0;
    public static final int INDEX_HIGHLIGHT = 11;
    public static final int INDEX_LIGHT = 2;
    public static final int INDEX_SATURATION = 7;
    public static final int INDEX_SHADOW = 12;
    public static final int INDEX_SHARPEN = 9;
    public static final int INDEX_TEXTURE = 3;
    public static final int INDEX_TILT = 13;
    public static final int INDEX_TINT = 8;
    public static final int INDEX_VOID = 5;
    public static final int INDEX_WARMTH = 5;
    public static final int TAB_SIZE = 14;
    static final String TAG = "EffectFragment";
    private static String[] filterBitmapTitle = new String[]{"None", "Gray", "Sepia", "Joey", "Sancia", "Blair", "Sura", "Tara", "Summer", "Penny", "Cuddy", "Cameron", "Lemon", "Tanya", "Lorelai", "Quinn", "Izabella", "Amber", "Cersei", "Debra", "Ellen", "Gabrielle", "Arya", "Lily", "Alexandra", "Nancy", "Daisy", "Brenda", "Sun", "Willow", "Ilina", "Faith", "Jess", "Cordelia"};
    public static Paint grayPaint;
    static boolean libLoadIsFailed;
    public static Paint sepiaPaint;
    Activity activity;
    Button adjustmentLabel;
    float[] autoParameters;
    int bitmapHeight;
    BitmapReady bitmapReadyListener;
    Bitmap bitmapTiltBlur;
    int bitmapWidth;
    BlurBuilderNormal blurBuilder;
    MyRecyclerViewAdapter borderAdapter;
    RecyclerAdapterIndexChangedListener borderIndexChangedListener = null;
    View buttonAuto;
    BuyProVersion buyProVersionListener;
    Context context;
    int count = 0;
    ExcludeTabListener excludeTabListener;
    MyRecyclerViewAdapter filterAdapter;
    Bitmap filterBitmap;
    FooterVisibilityListener footerListener;
    FilterAndAdjustmentTask ft;
    HdrLightHelper hdrLightHelper;
    HideHeaderListener hideHeaderListener;
    boolean inFilterAndAdjustment = false;
    OnSeekBarChangeListener mySeekBarListener = new C06259();
    MyRecyclerViewAdapter overlayAdapter;
    Parameter parameterBackUp = new Parameter();
    public Parameter parameterGlobal;
    int parameterSize = 4;
    SeekBar seekBarAdjustment;
    Rect seekbarHintTextBounds = new Rect();
    LayoutParams seekbarHintTextLayoutParams;
    int selectedTab = 0;
    private Animation slideLeftIn;
    private Animation slideLeftOut;
    private Animation slideRightIn;
    private Animation slideRightOut;
    private Bitmap sourceBitmap;
    Button[] tabButtonList;
    TextView textHint;
    MyRecyclerViewAdapter textureAdapter;
    int thumbSize;
    TiltFragment titlFragment;
    ViewFlipper viewFlipper;
    private ViewSwitcher viewSwitcher;

    class C06259 implements OnSeekBarChangeListener {
        C06259() {
        }

        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (EffectFragment.this.textHint == null) {
                EffectFragment.this.textHint = (TextView) EffectFragment.this.getView().findViewById(R.id.seekbar_hint);
            }
            if (EffectFragment.this.seekbarHintTextLayoutParams == null) {
                EffectFragment.this.seekbarHintTextLayoutParams = (LayoutParams) EffectFragment.this.textHint.getLayoutParams();
            }
            Rect thumbRect = ((SeekBarHint) seekBar).getSeekBarThumb().getBounds();
            EffectFragment.this.textHint.setText(String.valueOf(progress));
            EffectFragment.this.textHint.getPaint().getTextBounds(EffectFragment.this.textHint.getText().toString(), 0, EffectFragment.this.textHint.getText().length(), EffectFragment.this.seekbarHintTextBounds);
            EffectFragment.this.seekbarHintTextLayoutParams.setMargins(thumbRect.centerX() - (EffectFragment.this.seekbarHintTextBounds.width() / 2), 0, 0, 0);
            EffectFragment.this.textHint.setLayoutParams(EffectFragment.this.seekbarHintTextLayoutParams);
            if (EffectFragment.this.parameterGlobal.seekBarMode == 0) {
                EffectFragment.this.parameterGlobal.setBrightness(progress);
            } else if (EffectFragment.this.parameterGlobal.seekBarMode == 1) {
                EffectFragment.this.parameterGlobal.setContrast(progress);
            } else if (EffectFragment.this.parameterGlobal.seekBarMode == 2) {
                EffectFragment.this.parameterGlobal.setTemperature(progress);
            } else if (EffectFragment.this.parameterGlobal.seekBarMode == 3) {
                EffectFragment.this.parameterGlobal.setSaturation(progress);
            } else if (EffectFragment.this.parameterGlobal.seekBarMode == 4) {
                EffectFragment.this.parameterGlobal.setTint(progress);
            } else if (EffectFragment.this.parameterGlobal.seekBarMode == 5) {
                EffectFragment.this.parameterGlobal.setSharpen(progress);
            } else if (EffectFragment.this.parameterGlobal.seekBarMode == 6) {
                EffectFragment.this.parameterGlobal.setBlur(progress);
            } else if (EffectFragment.this.parameterGlobal.seekBarMode == 7) {
                EffectFragment.this.parameterGlobal.setHighlight(progress);
            } else if (EffectFragment.this.parameterGlobal.seekBarMode == 8) {
                EffectFragment.this.parameterGlobal.setShadow(progress);
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            if (EffectFragment.this.textHint == null) {
                EffectFragment.this.textHint = (TextView) EffectFragment.this.getView().findViewById(R.id.seekbar_hint);
            }
            EffectFragment.this.textHint.setVisibility(0);
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            if (EffectFragment.this.textHint == null) {
                EffectFragment.this.textHint = (TextView) EffectFragment.this.getView().findViewById(R.id.seekbar_hint);
            }
            EffectFragment.this.textHint.setVisibility(4);
            EffectFragment.this.callBack();
        }
    }

    public interface BitmapReady {
        void onBitmapReady(Bitmap bitmap);
    }

    class FilterAndAdjustmentTask extends AsyncTask<Void, Void, Void> {
        Bitmap bitmapBlur;
        int lastBlurRadius = -1;
        Matrix matrixBlur = new Matrix();
        Paint paintBlur = new Paint(2);
        ProgressDialog progressDialog;
        Bitmap smallBitmap;

        FilterAndAdjustmentTask() {
        }

        protected Void doInBackground(Void... arg0) {
            if (EffectFragment.this.isAdded()) {
                if (EffectFragment.this.filterBitmap == null) {
                    EffectFragment.this.filterBitmap = EffectFragment.this.sourceBitmap.copy(Config.ARGB_8888, true);
                } else {
                    new Canvas(EffectFragment.this.filterBitmap).drawBitmap(EffectFragment.this.sourceBitmap, 0.0f, 0.0f, new Paint());
                }
                Canvas cvs = new Canvas(EffectFragment.this.filterBitmap);
                cvs.drawBitmap(EffectFragment.this.sourceBitmap, 0.0f, 0.0f, new Paint());
                if (EffectFragment.this.parameterGlobal.blur > 0) {
                    Bitmap btmBlur = createBlurBitmapNDK(EffectFragment.this.parameterGlobal.blur);
                    Canvas canvas = new Canvas(EffectFragment.this.filterBitmap);
                    this.matrixBlur.reset();
                    this.matrixBlur.postScale(2.5f, 2.5f);
                    canvas.drawBitmap(btmBlur, this.matrixBlur, this.paintBlur);
                }
                if (!(EffectFragment.this.parameterGlobal.tiltContext == null || EffectFragment.this.parameterGlobal.tiltContext.mode == TiltMode.NONE || EffectFragment.this.bitmapTiltBlur != null)) {
                    EffectFragment.this.createTiltBlurBitmap();
                }
                if (!(EffectFragment.this.parameterGlobal.tiltContext == null || EffectFragment.this.bitmapTiltBlur == null || EffectFragment.this.parameterGlobal.tiltContext.mode == TiltMode.NONE)) {
                    TiltHelper.drawTiltShift2(cvs, EffectFragment.this.bitmapTiltBlur, EffectFragment.this.filterBitmap.getWidth(), EffectFragment.this.filterBitmap.getHeight(), EffectFragment.this.parameterGlobal.tiltContext);
                    EffectFragment.this.tiltSharpen(EffectFragment.this.filterBitmap);
                }
                if (EffectFragment.this.isAdded()) {
                    pipeline(EffectFragment.this.filterBitmap);
                } else {
                    cancel(true);
                    EffectFragment.this.inFilterAndAdjustment = false;
                }
            } else {
                EffectFragment.this.inFilterAndAdjustment = false;
            }
            return null;
        }

        void pipeline(Bitmap btmPipe) {
            if (EffectFragment.this.parameterGlobal.selectedFilterIndex <= 33) {
                EffectFragment.setFilter(EffectFragment.this.parameterGlobal.selectedFilterIndex, btmPipe);
            } else {
                if (EffectFragment.this.hdrLightHelper == null) {
                    EffectFragment.this.hdrLightHelper = new HdrLightHelper(EffectFragment.this.context);
                }
                EffectFragment.this.hdrLightHelper.applyHdr(btmPipe, EffectFragment.this.parameterGlobal.selectedFilterIndex - 34);
            }
            if (!(EffectFragment.this.parameterGlobal.contrast == 0 && EffectFragment.this.parameterGlobal.brightness == 0 && EffectFragment.this.parameterGlobal.getTemperature() == 0 && EffectFragment.this.parameterGlobal.getSaturation() == 1.0f && EffectFragment.this.parameterGlobal.getTint() == 0 && EffectFragment.this.parameterGlobal.highlight == 0.0f && EffectFragment.this.parameterGlobal.shadow == 0.0f)) {
                setAdjustment(btmPipe);
            }
            if (EffectFragment.this.parameterGlobal.sharpen > 0.0f) {
                long nanoTime = System.nanoTime();
                nanoTime = System.nanoTime();
                EffectFragment.sharpen6(btmPipe, 18, EffectFragment.this.parameterGlobal.sharpen);
                Log.e(EffectFragment.TAG, "sharpen6  " + (((float) (System.nanoTime() - nanoTime)) / 1000000.0f));
            }
            Bitmap overlayBitmap = EffectFragment.this.getOverlayBitmap(EffectFragment.this.parameterGlobal.selectedOverlayIndex);
            if (!(overlayBitmap == null || overlayBitmap.isRecycled())) {
                if (VERSION.SDK_INT > 10) {
                    EffectFragment.this.applyOverlay11(overlayBitmap, btmPipe, EffectFragment.isOverlayScreenMode(EffectFragment.this.parameterGlobal.selectedOverlayIndex));
                } else if (EffectFragment.isOverlayScreenMode(EffectFragment.this.overlayAdapter.getSelectedIndex()) == 0) {
                    EffectFragment.applyOverlay(overlayBitmap, btmPipe, EffectFragment.isOverlayScreenMode(EffectFragment.this.parameterGlobal.selectedOverlayIndex));
                } else {
                    EffectFragment.this.applyOverlay11(overlayBitmap, btmPipe, EffectFragment.isOverlayScreenMode(EffectFragment.this.parameterGlobal.selectedOverlayIndex));
                }
            }
            EffectFragment.this.filterMultiply(btmPipe, EffectFragment.this.parameterGlobal.selectedTextureIndex, false);
            if (EffectFragment.this.borderIndexChangedListener == null) {
                EffectFragment.this.setBorder(btmPipe, EffectFragment.this.parameterGlobal.selectedBorderIndex, false);
            }
            Canvas cvs = new Canvas(btmPipe);
            if (EffectFragment.this.parameterGlobal.selectedFilterIndex < 2) {
                cvs.drawBitmap(btmPipe, 0.0f, 0.0f, new Paint());
            }
        }

        public Bitmap createBlurBitmapRS(int radius) {
            if (this.lastBlurRadius == radius && this.bitmapBlur != null) {
                return this.bitmapBlur;
            }
            if (EffectFragment.this.blurBuilder == null) {
                EffectFragment.this.blurBuilder = new BlurBuilderNormal();
            }
            this.bitmapBlur = EffectFragment.this.blurBuilder.createBlurBitmapNDK(EffectFragment.this.sourceBitmap, radius);
            this.lastBlurRadius = radius;
            return this.bitmapBlur;
        }

        public Bitmap createBlurBitmapNDK(int radius) {
            if (this.lastBlurRadius == radius && this.smallBitmap != null) {
                return this.smallBitmap;
            }
            if (this.smallBitmap == null) {
                int width = Math.round(((float) EffectFragment.this.sourceBitmap.getWidth()) * BlurBuilderNormal.BITMAP_SCALE);
                int height = Math.round(((float) EffectFragment.this.sourceBitmap.getHeight()) * BlurBuilderNormal.BITMAP_SCALE);
                if (width % 2 == 1) {
                    width++;
                }
                if (height % 2 == 1) {
                    height++;
                }
                this.smallBitmap = Bitmap.createScaledBitmap(EffectFragment.this.sourceBitmap, width, height, false);
            } else {
                Canvas canvasSmall = new Canvas(this.smallBitmap);
                this.matrixBlur.reset();
                this.matrixBlur.postScale(BlurBuilderNormal.BITMAP_SCALE, BlurBuilderNormal.BITMAP_SCALE);
                canvasSmall.drawBitmap(EffectFragment.this.sourceBitmap, this.matrixBlur, this.paintBlur);
            }
            EffectFragment.functionToBlur(this.smallBitmap, radius);
            this.lastBlurRadius = radius;
            return this.smallBitmap;
        }

        public Bitmap getBlurBitmap(Bitmap bitmap, float radius) {
            BlurBuilderNormal bb = new BlurBuilderNormal();
            Bitmap btm = bb.createBlurBitmapNDK(bitmap, (int) radius);
            bb.destroy();
            return btm;
        }

        void setAdjustment(Bitmap btmAdj) {
            EffectFragment.applyAdjustment(btmAdj, EffectFragment.this.parameterGlobal.contrast, EffectFragment.this.parameterGlobal.brightness, EffectFragment.this.parameterGlobal.getTemperature(), EffectFragment.this.parameterGlobal.getSaturation(), EffectFragment.this.parameterGlobal.getTint(), EffectFragment.this.parameterGlobal.highlight, EffectFragment.this.parameterGlobal.shadow);
        }

        protected void onPreExecute() {
            EffectFragment.this.inFilterAndAdjustment = true;
            try {
                this.progressDialog = new ProgressDialog(EffectFragment.this.context);
                this.progressDialog.show();
            } catch (Exception e) {
            }
        }

        protected void onPostExecute(Void result) {
            EffectFragment.this.inFilterAndAdjustment = false;
            try {
                this.progressDialog.dismiss();
            } catch (Exception e) {
            }
            if (EffectFragment.this.isAdded()) {
                EffectFragment.this.bitmapReadyListener.onBitmapReady(EffectFragment.this.filterBitmap);
            }
        }
    }

    private class InitializeEffectThumbTask extends AsyncTask<Void, Void, Void> {
        private Bitmap[] filterBitmapArray;

        private InitializeEffectThumbTask() {
        }

        protected Void doInBackground(Void... arg0) {
            int width = EffectFragment.this.bitmapWidth;
            int height = EffectFragment.this.bitmapWidth;
            int side = Math.max(width, height);
            float scaler = ((float) side) / EffectFragment.this.getResources().getDimension(R.dimen.lib_filter_horizontal_view_image_size);
            width = (int) (((float) width) / scaler);
            height = (int) (((float) height) / scaler);
            Paint paint = new Paint();
            for (int i = 0; i < this.filterBitmapArray.length; i++) {
                int x0;
                int y0;
                int x1;
                int y1;
                Bitmap thumbBtm = Bitmap.createBitmap(EffectFragment.this.thumbSize, EffectFragment.this.thumbSize, Config.ARGB_8888);
                Canvas cvs = new Canvas(thumbBtm);
                int x = EffectFragment.this.bitmapWidth;
                int y = EffectFragment.this.bitmapHeight;
                if (x >= y) {
                    x0 = (x - y) / 2;
                    y0 = 0;
                    x1 = (x + y) / 2;
                    y1 = y;
                } else {
                    x0 = 0;
                    y0 = (y - x) / 2;
                    x1 = x;
                    y1 = (x + y) / 2;
                }
                Rect dst = new Rect(0, 0, EffectFragment.this.thumbSize, EffectFragment.this.thumbSize);
                cvs.drawBitmap(EffectFragment.this.sourceBitmap, new Rect(x0, y0, x1, y1), dst, paint);
                EffectFragment.setFilter(i, thumbBtm);
                this.filterBitmapArray[i] = thumbBtm;
            }
            return null;
        }

        protected void onPostExecute(Void result) {
        }

        protected void onPreExecute() {
            if (this.filterBitmapArray == null) {
                this.filterBitmapArray = new Bitmap[EffectFragment.filterBitmapTitle.length];
            }
        }
    }

    private class SaveThumbTask extends AsyncTask<Void, Void, Void> {
        String dir;

        private SaveThumbTask() {
        }

        protected Void doInBackground(Void... arg0) {
            int x0;
            int y0;
            int x1;
            int y1;
            int i;
            Bitmap thumbBtm;
            int width = EffectFragment.this.bitmapWidth;
            int height = EffectFragment.this.bitmapWidth;
            int side = Math.max(width, height);
            float scaler = ((float) side) / EffectFragment.this.getResources().getDimension(R.dimen.lib_thumb_save_size);
            width = (int) (((float) width) / scaler);
            height = (int) (((float) height) / scaler);
            Paint paint = new Paint();
            int x = EffectFragment.this.bitmapWidth;
            int y = EffectFragment.this.bitmapHeight;
            if (x >= y) {
                x0 = (x - y) / 2;
                y0 = 0;
                x1 = (x + y) / 2;
                y1 = y;
            } else {
                x0 = 0;
                y0 = (y - x) / 2;
                x1 = x;
                y1 = (x + y) / 2;
            }
            Rect dst = new Rect(0, 0, EffectFragment.this.thumbSize, EffectFragment.this.thumbSize);
            Rect src = new Rect(x0, y0, x1, y1);
            for (i = 1; i < LibUtility.borderRes.length; i++) {
                 thumbBtm = Bitmap.createBitmap(EffectFragment.this.thumbSize, EffectFragment.this.thumbSize, Config.ARGB_8888);
                new Canvas(thumbBtm).drawBitmap(EffectFragment.this.sourceBitmap, src, dst, paint);
                EffectFragment.this.setBorder(thumbBtm, i, false);
                saveBitmap(thumbBtm, "border_" + (i - 1));
                thumbBtm.recycle();
            }
            for (i = 1; i < LibUtility.textureResThumb.length; i++) {
                thumbBtm = Bitmap.createBitmap(EffectFragment.this.thumbSize, EffectFragment.this.thumbSize, Config.ARGB_8888);
                new Canvas(thumbBtm).drawBitmap(EffectFragment.this.sourceBitmap, src, dst, paint);
                EffectFragment.this.filterMultiply(thumbBtm, i, false);
                saveBitmap(thumbBtm, "texture_" + (i - 1));
                thumbBtm.recycle();
            }
            for (i = 1; i < LibUtility.overlayResThumb.length; i++) {
                thumbBtm = Bitmap.createBitmap(EffectFragment.this.thumbSize, EffectFragment.this.thumbSize, Config.ARGB_8888);
                new Canvas(thumbBtm).drawBitmap(EffectFragment.this.sourceBitmap, src, dst, paint);
                Bitmap overlayBitmap = EffectFragment.this.getOverlayBitmap(i);
                EffectFragment.this.applyOverlay11(overlayBitmap, thumbBtm, EffectFragment.isOverlayScreenMode(i));
                overlayBitmap.recycle();
                saveBitmap(thumbBtm, "overlay_" + (i - 1));
                thumbBtm.recycle();
            }
            for (i = 0; i < LibUtility.filterResThumb.length; i++) {
                dst.set(0, 0, EffectFragment.this.thumbSize, EffectFragment.this.thumbSize);
                thumbBtm = Bitmap.createBitmap(EffectFragment.this.thumbSize, EffectFragment.this.thumbSize, Config.ARGB_8888);
                new Canvas(thumbBtm).drawBitmap(EffectFragment.this.sourceBitmap, src, dst, paint);
                if (i <= 33) {
                    EffectFragment.setFilter(i, thumbBtm);
                } else {
                    if (EffectFragment.this.hdrLightHelper == null) {
                        EffectFragment.this.hdrLightHelper = new HdrLightHelper(EffectFragment.this.context);
                    }
                    EffectFragment.this.hdrLightHelper.applyHdr(thumbBtm, i - 34);
                }
                saveBitmap(thumbBtm, "effect_" + i);
                thumbBtm.recycle();
            }
            return null;
        }

        protected void onPreExecute() {
            this.dir = Environment.getExternalStorageDirectory() + "/coloreffect/";
            new File(this.dir).mkdir();
        }

        void saveBitmap(Bitmap bitmap, String name) {
            try {
                bitmap.compress(CompressFormat.JPEG, 75, new FileOutputStream(this.dir + name + "_thumb.jpg"));
            } catch (FileNotFoundException e) {
            }
        }

        protected void onPostExecute(Void result) {
            Log.e(EffectFragment.TAG, "Save Thumb Task finished!");
        }
    }

    class C10201 implements RecyclerAdapterIndexChangedListener {
        C10201() {
        }

        public void onIndexChanged(int position) {
            if (LibUtility.isAppPro || position <= EffectFragment.this.borderAdapter.proIndex) {
                EffectFragment.this.applyChangesOnBitmap();
            } else {
                EffectFragment.this.showAlertForPro();
            }
        }
    }

    class C10212 implements SelectedIndexChangedListener {
        C10212() {
        }

        public void selectedIndexChanged(int index) {
            EffectFragment.this.parameterGlobal.selectedBorderIndex = index;
        }
    }

    class C10223 implements RecyclerAdapterIndexChangedListener {
        C10223() {
        }

        public void onIndexChanged(int position) {
            if (LibUtility.isAppPro || position <= EffectFragment.this.textureAdapter.proIndex) {
                EffectFragment.this.applyChangesOnBitmap();
            } else {
                EffectFragment.this.showAlertForPro();
            }
        }
    }

    class C10234 implements SelectedIndexChangedListener {
        C10234() {
        }

        public void selectedIndexChanged(int index) {
            EffectFragment.this.parameterGlobal.selectedTextureIndex = index;
        }
    }

    class C10245 implements RecyclerAdapterIndexChangedListener {
        C10245() {
        }

        public void onIndexChanged(int position) {
            if (LibUtility.isAppPro || position <= EffectFragment.this.overlayAdapter.proIndex) {
                EffectFragment.this.applyChangesOnBitmap();
            } else {
                EffectFragment.this.showAlertForPro();
            }
        }
    }

    class C10256 implements SelectedIndexChangedListener {
        C10256() {
        }

        public void selectedIndexChanged(int index) {
            EffectFragment.this.parameterGlobal.selectedOverlayIndex = index;
        }
    }

    class C10267 implements RecyclerAdapterIndexChangedListener {
        C10267() {
        }

        public void onIndexChanged(int position) {
            if (LibUtility.isAppPro || position <= EffectFragment.this.filterAdapter.proIndex) {
                EffectFragment.this.applyChangesOnBitmap();
            } else {
                EffectFragment.this.showAlertForPro();
            }
        }
    }

    class C10278 implements SelectedIndexChangedListener {
        C10278() {
        }

        public void selectedIndexChanged(int index) {
            EffectFragment.this.parameterGlobal.selectedFilterIndex = index;
        }
    }

    private static native void applyAdjustment(Bitmap bitmap, int i, int i2, int i3, float f, int i4, float f2, float f3);

    private static native Bitmap applyOverlay(Bitmap bitmap, Bitmap bitmap2, int i);

    public static native void calculateAutoParameters(Bitmap bitmap, float[] fArr);

    private static native void filterAmber(Bitmap bitmap);

    private static native void filterAnne(Bitmap bitmap);

    private static native void filterAntonio(Bitmap bitmap);

    private static native void filterCameron(Bitmap bitmap);

    private static native void filterCross(Bitmap bitmap);

    private static native void filterCuddy(Bitmap bitmap);

    private static native void filterIns1(Bitmap bitmap);

    private static native void filterIns10(Bitmap bitmap);

    private static native void filterIns11(Bitmap bitmap);

    private static native void filterIns12(Bitmap bitmap);

    private static native void filterIns13(Bitmap bitmap);

    private static native void filterIns14(Bitmap bitmap);

    private static native void filterIns15(Bitmap bitmap);

    private static native void filterIns1Reverse(Bitmap bitmap);

    private static native void filterIns2(Bitmap bitmap);

    private static native void filterIns3(Bitmap bitmap);

    private static native void filterIns4(Bitmap bitmap);

    private static native void filterIns5(Bitmap bitmap);

    private static native void filterIns6(Bitmap bitmap);

    private static native void filterIns7(Bitmap bitmap);

    private static native void filterIns8(Bitmap bitmap);

    private static native void filterIns9(Bitmap bitmap);

    private static native void filterKaren(Bitmap bitmap);

    private static native void filterMain(Bitmap bitmap);

    private static native void filterNew1(Bitmap bitmap);

    private static native void filterNew2(Bitmap bitmap);

    private static native void filterNew3(Bitmap bitmap);

    private static native void filterNew4(Bitmap bitmap);

    private static native void filterNew5(Bitmap bitmap);

    private static native void filterPeter(Bitmap bitmap);

    private static native void filterSalomon(Bitmap bitmap);

    public static native void functionToBlur(Bitmap bitmap, int i);

    private static native void highlight(Bitmap bitmap, float f);

    public static native void saveFullImage(String str, String str2, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, int i, int i2, int i3, int i4, int i5, int i6, float f, int i7, int i8);

    private static native void shadows(Bitmap bitmap, float f);

    private static native void sharpen(Bitmap bitmap, float f);

    private static native void sharpen2(Bitmap bitmap, float f);

    private static native void sharpen3(Bitmap bitmap, int i, float f);

    private static native void sharpen4(Bitmap bitmap, int i, float f);

    private static native void sharpen5(Bitmap bitmap, int i, float f);

    private static native void sharpen6(Bitmap bitmap, int i, float f);

    private static native void sharpen7(Bitmap bitmap, Bitmap bitmap2, float f);

    public void excludeTabs(int[] tabList) {
        for (int i : tabList) {
            this.tabButtonList[i].setVisibility(8);
        }
    }

    public void setFooterVisibilityListener(FooterVisibilityListener listener) {
        this.footerListener = listener;
    }

    public void setExcludeTabListener(ExcludeTabListener listener) {
        this.excludeTabListener = listener;
    }

    public void setBitmapReadyListener(BitmapReady listener) {
        this.bitmapReadyListener = listener;
    }

    public void setBuyProVersionListener(BuyProVersion listener) {
        this.buyProVersionListener = listener;
    }

    public MyRecyclerViewAdapter getBorderAdapter() {
        return this.borderAdapter;
    }

    public void setHideHeaderListener(HideHeaderListener l) {
        this.hideHeaderListener = l;
    }

    public void setVisibilityOfEffectFooter(int visibility) {
        getView().findViewById(R.id.fx_footer).setVisibility(visibility);
    }

    public boolean backPressed() {
        if (this.titlFragment == null || !this.titlFragment.isVisible()) {
            return showToolBar();
        }
        this.titlFragment.backPressed();
        removeTiltFragment();
        return true;
    }

    public boolean showToolBar() {
        if (this.viewSwitcher.getDisplayedChild() != 0) {
            return false;
        }
        cancelViewSwitcher();
        this.viewSwitcher.setDisplayedChild(1);
        return true;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate");
        if (libLoadIsFailed) {
            LibUtility.initNativeLib(getActivity());
        }
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putParcelable(getString(R.string.effect_parameter_bundle_name), this.parameterGlobal);
        super.onSaveInstanceState(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.thumbSize = (int) getResources().getDimension(R.dimen.lib_thumb_save_size);
        return inflater.inflate(R.layout.horizontal_fragment_effect, container, false);
    }

    public void onAttach(Activity act) {
        super.onAttach(act);
        this.context = getActivity();
        this.activity = getActivity();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            this.parameterGlobal = (Parameter) savedInstanceState.getParcelable(getString(R.string.effect_parameter_bundle_name));
        } else if (getArguments() != null) {
            this.parameterGlobal = (Parameter) getArguments().getParcelable(getString(R.string.effect_parameter_bundle_name));
        }
        if (this.parameterGlobal == null) {
            this.parameterGlobal = new Parameter();
        }
        this.context = getActivity();
        this.activity = getActivity();
        initPaints();
        initAdapters();
        this.viewSwitcher = (ViewSwitcher) getView().findViewById(R.id.viewswitcher);
        this.viewFlipper = (ViewFlipper) getView().findViewById(R.id.control_container);
        this.slideLeftIn = AnimationUtils.loadAnimation(this.activity, R.anim.slide_in_left);
        this.slideLeftOut = AnimationUtils.loadAnimation(this.activity, R.anim.slide_out_left);
        this.slideRightIn = AnimationUtils.loadAnimation(this.activity, R.anim.slide_in_right);
        this.slideRightOut = AnimationUtils.loadAnimation(this.activity, R.anim.slide_out_right);
        this.adjustmentLabel = (Button) getView().findViewById(R.id.lib_current_adjustmen_label);
        setSelectedTab(this.selectedTab);
        this.viewSwitcher.setDisplayedChild(1);
        setTabBg(this.selectedTab);
        if (this.excludeTabListener != null) {
            this.excludeTabListener.exclude();
        }
        if (this.footerListener != null) {
            this.footerListener.setVisibility();
        }
        this.seekBarAdjustment = (SeekBar) getView().findViewById(R.id.seek_bar_adjustment);
        this.seekBarAdjustment.setOnSeekBarChangeListener(this.mySeekBarListener);
        this.hdrLightHelper = new HdrLightHelper(this.context);
    }

    public void setBorderIndexChangedListener(RecyclerAdapterIndexChangedListener l) {
        this.borderIndexChangedListener = l;
    }

    private void initAdapters() {
        RecyclerAdapterIndexChangedListener borderL;
        RecyclerAdapterIndexChangedListener c10201 = new C10201();
        if (this.borderIndexChangedListener != null) {
            borderL = this.borderIndexChangedListener;
        } else {
            borderL = c10201;
        }
        this.borderAdapter = new MyRecyclerViewAdapter(LibUtility.borderResThumb, borderL, R.color.lib_footer_second_bg, R.color.lib_footer_button_color_pressed, 100, LibUtility.shouldShowAds(this.activity));
        this.borderAdapter.setSelectedIndexChangedListener(new C10212());
        this.textureAdapter = new MyRecyclerViewAdapter(LibUtility.textureResThumb, new C10223(), R.color.lib_footer_second_bg, R.color.lib_footer_button_color_pressed, 100, LibUtility.shouldShowAds(this.activity));
        this.textureAdapter.setSelectedIndexChangedListener(new C10234());
        this.overlayAdapter = new MyRecyclerViewAdapter(LibUtility.overlayResThumb, new C10245(), R.color.lib_footer_second_bg, R.color.lib_footer_button_color_pressed, 100, LibUtility.shouldShowAds(this.activity));
        this.overlayAdapter.setSelectedIndexChangedListener(new C10256());
        this.filterAdapter = new MyRecyclerViewAdapter(LibUtility.filterResThumb, new C10267(), R.color.lib_footer_second_bg, R.color.lib_footer_button_color_pressed, 100, LibUtility.shouldShowAds(this.activity));
        this.filterAdapter.setSelectedIndexChangedListener(new C10278());
        RecyclerView borderRecyclerView = (RecyclerView) getView().findViewById(R.id.border_RecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        borderRecyclerView.setLayoutManager(linearLayoutManager);
        borderRecyclerView.setAdapter(this.borderAdapter);
        borderRecyclerView.setItemAnimator(new DefaultItemAnimator());
        RecyclerView textureRecyclerView = (RecyclerView) getView().findViewById(R.id.texture_RecyclerView);
        linearLayoutManager = new LinearLayoutManager(this.context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        textureRecyclerView.setLayoutManager(linearLayoutManager);
        textureRecyclerView.setAdapter(this.textureAdapter);
        textureRecyclerView.setItemAnimator(new DefaultItemAnimator());
        RecyclerView overlayRecyclerView = (RecyclerView) getView().findViewById(R.id.overlay_RecyclerView);
        linearLayoutManager = new LinearLayoutManager(this.context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        overlayRecyclerView.setLayoutManager(linearLayoutManager);
        overlayRecyclerView.setAdapter(this.overlayAdapter);
        overlayRecyclerView.setItemAnimator(new DefaultItemAnimator());
        RecyclerView filterRecyclerView = (RecyclerView) getView().findViewById(R.id.filter_RecyclerView);
        linearLayoutManager = new LinearLayoutManager(this.context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        filterRecyclerView.setLayoutManager(linearLayoutManager);
        filterRecyclerView.setAdapter(this.filterAdapter);
        filterRecyclerView.setItemAnimator(new DefaultItemAnimator());
        this.textureAdapter.setSelectedView(this.parameterGlobal.selectedTextureIndex);
        this.borderAdapter.setSelectedView(this.parameterGlobal.selectedBorderIndex);
        this.overlayAdapter.setSelectedView(this.parameterGlobal.selectedOverlayIndex);
        if (this.parameterGlobal.selectedFilterIndex >= this.filterAdapter.getItemCount()) {
            this.parameterGlobal.selectedFilterIndex = 0;
        }
        this.filterAdapter.setSelectedView(this.parameterGlobal.selectedFilterIndex);
    }

    public void setSelectedTabIndex(int index) {
        if (index >= 0 && index < 14) {
            this.selectedTab = index;
            if (getView() != null) {
                setSelectedTab(index);
            }
        }
    }

    public int getSelectedTabIndex() {
        if (this.viewFlipper != null) {
            return this.viewFlipper.getDisplayedChild();
        }
        return -1;
    }

    void setSeekBarProgress() {
        int progress = 50;
        if (this.parameterGlobal.seekBarMode == 0) {
            progress = this.parameterGlobal.getBrightProgress();
        } else if (this.parameterGlobal.seekBarMode == 1) {
            progress = this.parameterGlobal.getContrastProgress();
        } else if (this.parameterGlobal.seekBarMode == 2) {
            progress = this.parameterGlobal.getTemperatureProgress();
        } else if (this.parameterGlobal.seekBarMode == 3) {
            progress = this.parameterGlobal.saturation;
        } else if (this.parameterGlobal.seekBarMode == 4) {
            progress = this.parameterGlobal.getTintProgressValue();
        } else if (this.parameterGlobal.seekBarMode == 5) {
            progress = this.parameterGlobal.getSharpenValue();
        } else if (this.parameterGlobal.seekBarMode == 6) {
            progress = this.parameterGlobal.getBlurValue();
        } else if (this.parameterGlobal.seekBarMode == 7) {
            progress = this.parameterGlobal.getHighlightValue();
        } else if (this.parameterGlobal.seekBarMode == 8) {
            progress = this.parameterGlobal.getShadowValue();
        }
        this.seekBarAdjustment.setProgress(progress);
    }

    public void callBack() {
        execQueue();
    }

    public void setBitmap(Bitmap btm) {
        this.sourceBitmap = btm;
        this.bitmapWidth = this.sourceBitmap.getWidth();
        this.bitmapHeight = this.sourceBitmap.getHeight();
        this.filterBitmap = null;
    }

    public void setBitmapAndResetBlur(Bitmap btm) {
        setBitmap(btm);
        if (!(this.bitmapTiltBlur == null || this.bitmapTiltBlur.isRecycled())) {
            this.bitmapTiltBlur.recycle();
        }
        this.bitmapTiltBlur = null;
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    @SuppressLint({"NewApi"})
    public void applyOverlay11(Bitmap overlay, Bitmap btm, int screenMode) {
        Paint paint = new Paint(1);
        paint.setFilterBitmap(true);
        Mode mode = Mode.SCREEN;
        if (screenMode == 0) {
            mode = Mode.OVERLAY;
        }
        PorterDuffXfermode porterMode = new PorterDuffXfermode(mode);
        if (screenMode == 2) {
            porterMode = null;
        }
        paint.setXfermode(porterMode);
        Matrix borderMatrix = new Matrix();
        float wScale = ((float) btm.getWidth()) / ((float) overlay.getWidth());
        float hScale = ((float) btm.getHeight()) / ((float) overlay.getHeight());
        borderMatrix.reset();
        Canvas cvs = new Canvas(btm);
        borderMatrix.postScale(wScale, hScale);
        cvs.drawBitmap(overlay, borderMatrix, paint);
    }

    static int getBorderMode(int index) {
        return 0;
    }

    public synchronized void setBorder(Bitmap btm, int index, boolean isThumb) {
        if (isAdded() && index != 0) {
            if (LibUtility.borderRes.length > index) {
                Bitmap borderBitmap;
                Paint paint = new Paint(1);
                if (getBorderMode(index) == 1) {
                    paint.setXfermode(new PorterDuffXfermode(Mode.MULTIPLY));
                }
                Matrix borderMatrix = new Matrix();
                if (isThumb) {
                    borderBitmap = BitmapFactory.decodeResource(getResources(), LibUtility.borderResThumb[index]);
                } else {
                    borderBitmap = BitmapFactory.decodeResource(getResources(), LibUtility.borderRes[index]);
                }
                float wScale = ((float) btm.getWidth()) / ((float) borderBitmap.getWidth());
                float hScale = ((float) btm.getHeight()) / ((float) borderBitmap.getHeight());
                borderMatrix.reset();
                Canvas cvs = new Canvas(btm);
                borderMatrix.postScale(wScale, hScale);
                cvs.drawBitmap(borderBitmap, borderMatrix, paint);
                if (!(borderBitmap == null || btm == borderBitmap)) {
                    borderBitmap.recycle();
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void filterMultiply(Bitmap btm, int index, boolean isThumb) {
        if (index != 0 && isAdded()) {
            Bitmap textureBitmap;
            Paint paint = new Paint(1);
            Mode mode = Mode.SCREEN;
            if (LibUtility.textureModes[index] == LibUtility.MODE_MULTIPLY) {
                mode = Mode.MULTIPLY;
            } else if (LibUtility.textureModes[index] == LibUtility.MODE_OVERLAY && VERSION.SDK_INT > 10) {
                mode = Mode.OVERLAY;
            } else if (LibUtility.textureModes[index] == LibUtility.MODE_OVERLAY && VERSION.SDK_INT <= 10) {
                mode = Mode.MULTIPLY;
            }
            paint.setXfermode(new PorterDuffXfermode(mode));
            Matrix borderMatrix = new Matrix();
            if (isThumb) {
                textureBitmap = BitmapFactory.decodeResource(getResources(), LibUtility.textureResThumb[index]);
            } else {
                Options o2 = new Options();
                if (LibUtility.getLeftSizeOfMemory() > 1.024E7d) {
                    o2.inSampleSize = 1;
                } else {
                    o2.inSampleSize = 2;
                }
                textureBitmap = BitmapFactory.decodeResource(getResources(), LibUtility.textureRes[index], o2);
            }
            float wScale = ((float) btm.getWidth()) / ((float) textureBitmap.getWidth());
            float hScale = ((float) btm.getHeight()) / ((float) textureBitmap.getHeight());
            borderMatrix.reset();
            Canvas cvs = new Canvas(btm);
            borderMatrix.postScale(wScale, hScale);
            cvs.drawBitmap(textureBitmap, borderMatrix, paint);
            if (textureBitmap != null && btm != textureBitmap) {
                textureBitmap.recycle();
            }
        }
    }

    Bitmap getOverlayBitmap(int index) {
        Bitmap bitmap = null;
        if (isAdded()) {
            Options opts = new Options();
            opts.inPreferredConfig = Config.ARGB_8888;
            if (LibUtility.getLeftSizeOfMemory() > 1.024E7d) {
                opts.inSampleSize = 1;
            } else {
                opts.inSampleSize = 2;
            }
            if (index > 0 && index < LibUtility.overlayDrawableList.length) {
                Bitmap temp;
                bitmap = BitmapFactory.decodeResource(getResources(), LibUtility.overlayDrawableList[index], opts);
                if (bitmap.getConfig() != Config.ARGB_8888) {
                    temp = bitmap;
                    bitmap = bitmap.copy(Config.ARGB_8888, false);
                    if (bitmap != temp) {
                        temp.recycle();
                    }
                }
                int overlayWidth = bitmap.getWidth();
                int overlayHeight = bitmap.getHeight();
                if ((this.bitmapHeight > this.bitmapWidth && overlayHeight < overlayWidth) || (this.bitmapHeight < this.bitmapWidth && overlayHeight > overlayWidth)) {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    temp = bitmap;
                    bitmap = Bitmap.createBitmap(temp, 0, 0, temp.getWidth(), temp.getHeight(), matrix, true);
                    if (bitmap != temp) {
                        temp.recycle();
                    }
                }
            }
        }
        return bitmap;
    }

    static int isOverlayScreenMode(int index) {
        if (index == 2) {
            return 2;
        }
        return 1;
    }

    public void isAppPro(boolean isAppPro) {
        LibUtility.isAppPro = isAppPro;
    }

    private void setTabBg(int index) {
        if (this.tabButtonList == null) {
            this.tabButtonList = new Button[14];
            this.tabButtonList[0] = (Button) getView().findViewById(R.id.button_fx);
            this.tabButtonList[1] = (Button) getView().findViewById(R.id.button_frame);
            this.tabButtonList[2] = (Button) getView().findViewById(R.id.button_light);
            this.tabButtonList[3] = (Button) getView().findViewById(R.id.button_texture);
            this.tabButtonList[4] = (Button) getView().findViewById(R.id.button_brightness);
            this.tabButtonList[6] = (Button) getView().findViewById(R.id.button_contrast);
            this.tabButtonList[5] = (Button) getView().findViewById(R.id.button_temperature);
            this.tabButtonList[7] = (Button) getView().findViewById(R.id.button_saturation);
            this.tabButtonList[8] = (Button) getView().findViewById(R.id.button_tint);
            this.tabButtonList[9] = (Button) getView().findViewById(R.id.button_sharpen);
            this.tabButtonList[10] = (Button) getView().findViewById(R.id.button_blur);
            this.tabButtonList[11] = (Button) getView().findViewById(R.id.button_highlights);
            this.tabButtonList[12] = (Button) getView().findViewById(R.id.button_shadows);
            this.tabButtonList[13] = (Button) getView().findViewById(R.id.button_tilt_shift);
        }
        if (index >= 0) {
            this.adjustmentLabel.setText(this.tabButtonList[index].getText());
        }
    }

    private void setTabBgEx(int index) {
        if (this.tabButtonList == null) {
            this.tabButtonList = new Button[14];
            this.tabButtonList[0] = (Button) getView().findViewById(R.id.button_fx);
            this.tabButtonList[1] = (Button) getView().findViewById(R.id.button_frame);
            this.tabButtonList[2] = (Button) getView().findViewById(R.id.button_light);
            this.tabButtonList[3] = (Button) getView().findViewById(R.id.button_texture);
            this.tabButtonList[4] = (Button) getView().findViewById(R.id.button_brightness);
            this.tabButtonList[6] = (Button) getView().findViewById(R.id.button_contrast);
            this.tabButtonList[5] = (Button) getView().findViewById(R.id.button_temperature);
            this.tabButtonList[7] = (Button) getView().findViewById(R.id.button_saturation);
            this.tabButtonList[8] = (Button) getView().findViewById(R.id.button_tint);
            this.tabButtonList[9] = (Button) getView().findViewById(R.id.button_sharpen);
            this.tabButtonList[10] = (Button) getView().findViewById(R.id.button_blur);
            this.tabButtonList[11] = (Button) getView().findViewById(R.id.button_highlights);
            this.tabButtonList[12] = (Button) getView().findViewById(R.id.button_shadows);
            this.tabButtonList[13] = (Button) getView().findViewById(R.id.button_tilt_shift);
        }
        for (Button backgroundResource : this.tabButtonList) {
            backgroundResource.setBackgroundResource(R.drawable.selector_btn_footer);
        }
        if (index >= 0) {
            this.tabButtonList[index].setBackgroundResource(R.color.lib_footer_button_color_pressed);
        }
    }

    public void myClickHandler(int id) {
        if (id != R.id.button_lib_cancel) {
            this.parameterBackUp.set(this.parameterGlobal);
        }
        if (id == R.id.button_fx) {
            setSelectedTab(0);
        } else if (id == R.id.button_frame) {
            setSelectedTab(1);
        } else if (id == R.id.button_light) {
            setSelectedTab(2);
        } else if (id == R.id.button_texture) {
            setSelectedTab(3);
        } else if (id == R.id.button_filter_reset) {
            resetParameters();
        } else if (id == R.id.button_brightness) {
            setSelectedTab(4);
            this.parameterGlobal.seekBarMode = 0;
            setSeekBarProgress();
        } else if (id == R.id.button_contrast) {
            setSelectedTab(6);
            this.parameterGlobal.seekBarMode = 1;
            setSeekBarProgress();
        } else if (id == R.id.button_temperature) {
            setSelectedTab(5);
            this.parameterGlobal.seekBarMode = 2;
            setSeekBarProgress();
        } else if (id == R.id.button_saturation) {
            setSelectedTab(7);
            this.parameterGlobal.seekBarMode = 3;
            setSeekBarProgress();
        } else if (id == R.id.button_tint) {
            setSelectedTab(8);
            this.parameterGlobal.seekBarMode = 4;
            setSeekBarProgress();
        } else if (id == R.id.button_sharpen) {
            setSelectedTab(9);
            this.parameterGlobal.seekBarMode = 5;
            setSeekBarProgress();
        } else if (id == R.id.button_blur) {
            setSelectedTab(10);
            this.parameterGlobal.seekBarMode = 6;
            setSeekBarProgress();
        } else if (id == R.id.button_highlights) {
            setSelectedTab(11);
            this.parameterGlobal.seekBarMode = 7;
            setSeekBarProgress();
        } else if (id == R.id.button_shadows) {
            setSelectedTab(12);
            this.parameterGlobal.seekBarMode = 8;
            setSeekBarProgress();
        } else if (id == R.id.button_tilt_shift) {
            this.viewFlipper.setDisplayedChild(5);
            setTabBg(-1);
            final FragmentManager fm = getChildFragmentManager();
            this.titlFragment = (TiltFragment) fm.findFragmentByTag("my_tilt_fragment");
            if (this.titlFragment == null) {
                this.titlFragment = new TiltFragment();
                if (this.filterBitmap == null) {
                    this.filterBitmap = this.sourceBitmap.copy(Config.ARGB_8888, true);
                } else {
                    new Canvas(this.filterBitmap).drawBitmap(this.sourceBitmap, 0.0f, 0.0f, new Paint());
                }
                createTiltBlurBitmap();
                tiltSharpen(this.filterBitmap);
                this.titlFragment.setBitmaps(this.filterBitmap, this.bitmapTiltBlur);
                this.titlFragment.setTiltContext(this.parameterGlobal.tiltContext);
                this.titlFragment.setTiltListener(new TiltListener() {
                    public void onTiltOk(TiltContext tc) {
                        if (EffectFragment.this.hideHeaderListener != null) {
                            EffectFragment.this.hideHeaderListener.hide(true);
                        }
                        EffectFragment.this.parameterGlobal.tiltContext = tc;
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.remove(EffectFragment.this.titlFragment);
                        ft.commit();
                        EffectFragment.this.execQueue();
                    }

                    public void onTiltCancel() {
                        if (EffectFragment.this.hideHeaderListener != null) {
                            EffectFragment.this.hideHeaderListener.hide(true);
                        }
                        EffectFragment.this.removeTiltFragment();
                        EffectFragment.this.execQueue();
                    }
                });
                FragmentTransaction ft = fm.beginTransaction();
                ft.add(R.id.lyrebird_lib_tilt_fragment_container, this.titlFragment, "my_tilt_fragment");
                ft.commit();
                return;
            }
            if (this.bitmapTiltBlur == null) {
                createTiltBlurBitmap();
            }
            if (this.titlFragment.bitmap == null) {
                this.titlFragment.bitmap = this.filterBitmap;
            }
            if (this.titlFragment.bitmapBlur == null) {
                this.titlFragment.bitmapBlur = this.bitmapTiltBlur;
            }
            getChildFragmentManager().beginTransaction().show(this.titlFragment).commit();
        } else if (id == R.id.button_auto_set_parameters) {
            autoSetParameters();
        } else if (id == R.id.button_lib_cancel) {
            cancelViewSwitcher();
            this.viewSwitcher.setDisplayedChild(1);
        } else if (id == R.id.button_lib_ok) {
            this.viewSwitcher.setDisplayedChild(1);
        }
    }

    void tiltSharpen(Bitmap bitmap) {
        sharpen6(bitmap, 18, 0.1f);
    }

    private void cancelViewSwitcher() {
        if (this.parameterGlobal.isParameterReallyChanged(this.parameterBackUp)) {
            this.parameterGlobal.set(this.parameterBackUp);
            this.textureAdapter.setSelectedView(this.parameterGlobal.selectedTextureIndex);
            this.borderAdapter.setSelectedView(this.parameterGlobal.selectedBorderIndex);
            if (this.borderIndexChangedListener != null) {
                this.borderIndexChangedListener.onIndexChanged(this.parameterGlobal.selectedBorderIndex);
            }
            this.overlayAdapter.setSelectedView(this.parameterGlobal.selectedOverlayIndex);
            if (this.parameterGlobal.selectedFilterIndex >= this.filterAdapter.getItemCount()) {
                this.parameterGlobal.selectedFilterIndex = 0;
            }
            this.filterAdapter.setSelectedView(this.parameterGlobal.selectedFilterIndex);
            execQueue();
        }
    }

    private void removeTiltFragment() {
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.remove(this.titlFragment);
        ft.commit();
    }

    public void createTiltBlurBitmap() {
        if (this.bitmapTiltBlur == null || this.bitmapTiltBlur.isRecycled()) {
            if (this.blurBuilder == null) {
                this.blurBuilder = new BlurBuilderNormal();
            }
            float blurRadius = 15.0f * ((float) Math.sqrt((double) (((float) (this.sourceBitmap.getWidth() * this.sourceBitmap.getWidth())) / 4194304.0f)));
            if (((double) blurRadius) < 1.5d) {
                blurRadius = 1.5f;
            }
            this.bitmapTiltBlur = this.blurBuilder.createBlurBitmapNDK(this.sourceBitmap, (int) blurRadius);
        }
    }

    void setSelectedTab(int index) {
        this.viewSwitcher.setDisplayedChild(0);
        if (this.buttonAuto == null) {
            this.buttonAuto = getView().findViewById(R.id.button_auto_set_parameters);
        }
        this.buttonAuto.setVisibility(4);
        int displayedChild = this.viewFlipper.getDisplayedChild();
        if (index == 0) {
            setTabBg(0);
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
        if (index == 2) {
            setTabBg(2);
            if (displayedChild != 2) {
                if (displayedChild == 3 || displayedChild == 4) {
                    this.viewFlipper.setInAnimation(this.slideLeftIn);
                    this.viewFlipper.setOutAnimation(this.slideRightOut);
                } else {
                    this.viewFlipper.setInAnimation(this.slideRightIn);
                    this.viewFlipper.setOutAnimation(this.slideLeftOut);
                }
                this.viewFlipper.setDisplayedChild(2);
            } else {
                return;
            }
        }
        if (index == 3) {
            setTabBg(3);
            if (displayedChild != 3) {
                if (displayedChild == 4) {
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
        if (index == 4 || index == 6 || index == 7 || index == 5 || index == 8 || index == 9 || index == 10 || index == 11 || index == 12) {
            setTabBg(index);
            this.buttonAuto.setVisibility(0);
            if (displayedChild != 4) {
                this.viewFlipper.setInAnimation(this.slideRightIn);
                this.viewFlipper.setOutAnimation(this.slideLeftOut);
                this.viewFlipper.setDisplayedChild(4);
            }
        }
    }

    void showAlertForPro() {
        if (this.buyProVersionListener != null) {
            this.buyProVersionListener.proVersionCalled();
            return;
        }
        Toast msg = Toast.makeText(this.context, getString(R.string.lyrebirdlib_buy_pro), 1);
        msg.setGravity(17, msg.getXOffset() / 2, msg.getYOffset() / 2);
        msg.show();
    }

    void resetParameters() {
        this.parameterGlobal.reset();
        setAdjustmentSeekbarProgress();
    }

    public Parameter getParameter() {
        return this.parameterGlobal;
    }

    public void setParameters(Parameter parameter) {
        this.parameterGlobal.set(parameter);
        setAdjustmentSeekbarProgress();
    }

    void resetParametersWithoutChange() {
        this.parameterGlobal.reset();
        setSelectedIndexes();
        setSeekBarProgress();
    }

    public void setAutoParameters(int brightness, int saturation, int contrast, int warmth) {
        this.parameterGlobal.setBrightness(brightness);
        this.parameterGlobal.setContrast(contrast);
        this.parameterGlobal.setSaturation(saturation);
        this.parameterGlobal.setTemperature(warmth);
        this.parameterGlobal.setTint(50);
        setAdjustmentSeekbarProgress();
    }

    void setAdjustmentSeekbarProgress() {
        setSeekBarProgress();
        setSelectedIndexes();
        execQueue();
    }

    void setSelectedIndexes() {
        this.textureAdapter.setSelectedView(this.parameterGlobal.selectedTextureIndex);
        this.borderAdapter.setSelectedView(this.parameterGlobal.selectedBorderIndex);
        this.overlayAdapter.setSelectedView(this.parameterGlobal.selectedOverlayIndex);
        this.filterAdapter.setSelectedView(this.parameterGlobal.selectedFilterIndex);
    }

    void applyChangesOnBitmap() {
        this.parameterGlobal.selectedFilterIndex = this.filterAdapter.getSelectedIndex();
        this.parameterGlobal.selectedBorderIndex = this.borderAdapter.getSelectedIndex();
        this.parameterGlobal.selectedTextureIndex = this.textureAdapter.getSelectedIndex();
        this.parameterGlobal.selectedOverlayIndex = this.overlayAdapter.getSelectedIndex();
        execQueue();
    }

    public void execQueue() {
        if (this.ft == null || this.ft.getStatus() != Status.RUNNING) {
            this.ft = new FilterAndAdjustmentTask();
            try {
                this.ft.execute(new Void[0]);
            } catch (Exception e) {
            }
        }
    }

    static {
        libLoadIsFailed = false;
        Log.e(TAG, "static loadLibrary");
        try {
            System.loadLibrary("filter");
            libLoadIsFailed = false;
        } catch (Exception er) {
            Log.e(TAG, er.toString());
            libLoadIsFailed = true;
        }
    }

    public static void setFilter(int index, Bitmap btm) {
        if (index >= filterBitmapTitle.length) {
            index = 0;
        }
        index--;
        if (VERSION.SDK_INT != 7 && index != -1) {
            if (index == 0) {
                filterGray(btm);
            } else if (index == 1) {
                filterSepia(btm);
            } else if (index == 2) {
                filterMain(btm);
            } else if (index == 3) {
                filterAmber(btm);
            } else if (index == 4) {
                filterAnne(btm);
            } else if (index == 5) {
                filterPeter(btm);
            } else if (index == 6) {
                filterSalomon(btm);
            } else if (index == 7) {
                filterKaren(btm);
            } else if (index == 8) {
                filterCross(btm);
            } else if (index == 9) {
                filterCuddy(btm);
            } else if (index == 10) {
                filterCameron(btm);
            } else if (index == 11) {
                filterAntonio(btm);
            } else if (index == 12) {
                filterNew1(btm);
            } else if (index == 13) {
                filterNew2(btm);
            } else if (index == 14) {
                filterNew3(btm);
            } else if (index == 15) {
                filterNew4(btm);
            } else if (index == 16) {
                filterIns10(btm);
            } else if (index == 17) {
                filterIns1Reverse(btm);
            } else if (index == 18) {
                filterIns1(btm);
            } else if (index == 19) {
                filterIns2(btm);
            } else if (index == 20) {
                filterIns3(btm);
            } else if (index == 21) {
                filterIns4(btm);
            } else if (index == 22) {
                filterIns5(btm);
            } else if (index == 23) {
                filterIns6(btm);
            } else if (index == 24) {
                filterIns7(btm);
            } else if (index == 25) {
                filterIns8(btm);
            } else if (index == 26) {
                filterIns9(btm);
            } else if (index == 27) {
                filterNew5(btm);
            } else if (index == 28) {
                filterIns11(btm);
            } else if (index == 29) {
                filterIns12(btm);
            } else if (index == 30) {
                filterIns13(btm);
            } else if (index == 31) {
                filterIns14(btm);
            } else if (index == 32) {
                filterIns15(btm);
            }
        }
    }

    private static void filterSepia(Bitmap src) {
        new Canvas(src).drawBitmap(src, 0.0f, 0.0f, sepiaPaint);
    }

    private static void filterGray(Bitmap src) {
        new Canvas(src).drawBitmap(src, 0.0f, 0.0f, grayPaint);
    }

    public static void initPaints() {
        sepiaPaint = new Paint();
        ColorMatrix sepiaMatrix = new ColorMatrix();
        sepiaMatrix.set(new float[]{0.393f, 0.769f, 0.189f, 0.0f, 0.0f, 0.349f, 0.686f, 0.168f, 0.0f, 0.0f, 0.272f, 0.534f, 0.131f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f});
        sepiaPaint.setColorFilter(new ColorMatrixColorFilter(sepiaMatrix));
        grayPaint = new Paint();
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0.0f);
        grayPaint.setColorFilter(new ColorMatrixColorFilter(cm));
    }

    public void saveFullImageMember(String selectedImagePath, String resultPath) {
        Bitmap myOverlayBitmap = getOverlayBitmap(this.overlayAdapter.getSelectedIndex());
        Bitmap borderBitmap = BitmapFactory.decodeResource(getResources(), LibUtility.borderRes[this.borderAdapter.getSelectedIndex()]);
        Options o2 = new Options();
        o2.inSampleSize = 2;
        Bitmap textureBitmap = BitmapFactory.decodeResource(getResources(), LibUtility.textureRes[this.textureAdapter.getSelectedIndex()], o2);
        int index = this.borderAdapter.getSelectedIndex();
        saveFullImage(selectedImagePath, resultPath, myOverlayBitmap, borderBitmap, textureBitmap, 0, this.filterAdapter.getSelectedIndex() - 1, isOverlayScreenMode(this.overlayAdapter.getSelectedIndex()), this.parameterGlobal.contrast, this.parameterGlobal.brightness, this.parameterGlobal.getTemperature(), this.parameterGlobal.getSaturation(), this.parameterGlobal.getTint(), LibUtility.textureModes[this.textureAdapter.getSelectedIndex()]);
    }

    public static void saveFullImage2(String selectedImagePath, String resultPath, Parameter parameter, Resources res) {
        Bitmap borderBitmap = BitmapFactory.decodeResource(res, LibUtility.borderRes[parameter.selectedBorderIndex]);
        Options o2 = new Options();
        o2.inSampleSize = 2;
        Bitmap myOverlayBitmap = BitmapFactory.decodeResource(res, LibUtility.overlayDrawableList[parameter.selectedOverlayIndex], o2);
        Bitmap textureBitmap = BitmapFactory.decodeResource(res, LibUtility.textureRes[parameter.selectedTextureIndex], o2);
        int index = parameter.selectedBorderIndex;
        int i = parameter.selectedFilterIndex - 1;
        saveFullImage(selectedImagePath, resultPath, myOverlayBitmap, borderBitmap, textureBitmap, 0, i, isOverlayScreenMode(parameter.selectedOverlayIndex), parameter.contrast, parameter.brightness, parameter.getTemperature(), parameter.getSaturation(), parameter.getTint(), LibUtility.textureModes[parameter.selectedTextureIndex]);
    }

    boolean checkAutoParameters() {
        if (this.autoParameters == null) {
            return false;
        }
        for (int i = 0; i < this.parameterSize; i++) {
            if (this.autoParameters[i] <= 0.0f) {
                return false;
            }
        }
        return true;
    }

    void autoSetParameters() {
        if (!checkAutoParameters()) {
            int scale;
            Bitmap btm;
            this.autoParameters = new float[this.parameterSize];
            int width = this.sourceBitmap.getWidth();
            int height = this.sourceBitmap.getHeight();
            int pixelCount = this.sourceBitmap.getWidth() * this.sourceBitmap.getHeight();
            if (pixelCount < 810000) {
                scale = 1;
            } else if (pixelCount < 4000000) {
                scale = 2;
            } else {
                scale = 4;
            }
            if (scale > 1) {
                btm = Bitmap.createScaledBitmap(this.sourceBitmap, width / scale, height / scale, false);
                if (btm.getConfig().compareTo(Config.ARGB_8888) != 0) {
                    Bitmap tmp = btm.copy(Config.ARGB_8888, false);
                    btm.recycle();
                    btm = tmp;
                }
            } else {
                btm = this.sourceBitmap.copy(Config.ARGB_8888, false);
            }
            calculateAutoParameters(btm, this.autoParameters);
            btm.recycle();
        }
        if (this.autoParameters != null && this.autoParameters.length >= this.parameterSize) {
            float saturation = this.autoParameters[0];
            float contrast = this.autoParameters[1];
            float brightness = this.autoParameters[2];
            float warmth = this.autoParameters[3];
            int brightnessParam = 50;
            int saturationParam = 50;
            int contrastParam = 50;
            int warmthParam = 50;
            if (((double) brightness) < 0.46d || ((double) brightness) > 0.54d) {
                brightnessParam = (int) (50.0d + (45.0d * (0.5d - ((double) brightness))));
            }
            if (((double) saturation) > 0.1d) {
                saturationParam = (int) (50.0f + (20.0f * saturation));
            }
            float brcr = 1.0f;
            if (brightness < 4.0f) {
                brcr = brightness;
            }
            if (((double) contrast) > 0.17d) {
                contrastParam = (int) (50.0f + ((brcr * contrast) * 25.0f));
            }
            if (warmth > 2.0f) {
                warmth = 2.0f;
            }
            if (((double) warmth) < 0.9d || ((double) warmth) > 1.1d) {
                warmthParam = (int) (50.0f + ((1.0f - warmth) * 10.0f));
            }
            setAutoParameters(brightnessParam, saturationParam, contrastParam, warmthParam);
        }
    }
}
