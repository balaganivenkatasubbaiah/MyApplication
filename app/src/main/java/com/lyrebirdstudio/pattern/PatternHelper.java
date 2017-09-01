package com.lyrebirdstudio.pattern;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.widget.LinearLayout;

import com.lyrebirdstudio.R;
import com.lyrebirdstudio.imagesavelib.ImageLoader;
import com.lyrebirdstudio.imagesavelib.ImageLoader.ImageLoaded;
import com.lyrebirdstudio.imagesavelib.ImageUtility;
import com.lyrebirdstudio.pattern.PatternAdapter.CurrentCollageIndexChangedListener;
import com.lyrebirdstudio.pattern.PatternOnlineFragment.PatternDownloadListener;
import com.lyrebirdstudio.sticker.Utility;

import java.util.ArrayList;

public class PatternHelper {
    public static final int MAX_SIZE_DEFAULT = 800;
    public static final int PATTERN_SENTINEL = -1;
    public static final int SELCT_IMAGE_BG = 244;
    public static final String TAG = "PatternHelper";
    public static ArrayList<String> sdIdList = new ArrayList();
    Activity activity;
    public Bitmap bitmapBlur;
    LinearLayout colorContainer;
    ImageLoaded imageLoadedListener = new C10377();
    ImageLoader imageLoader;
    public PatternAdapter patternAdapter;
    ArrayList<MyRecylceAdapterBase> patternAdapterList = new ArrayList();
    PatternBitmapColorListener patternBitmapColorListener;
    RecyclerView recyclerView;

    public interface PatternBitmapColorListener {
        void patternBitmapReady(int i, Bitmap bitmap, int i2);

        void patternColorReady(int i);

        void patternImageReady(Bitmap bitmap);

        void setBacgkroundMode();
    }

    class C10311 implements CurrentCollageIndexChangedListener {
        C10311() {
        }

        public void onIndexChanged(int position) {
            if (PatternHelper.this.patternBitmapColorListener != null) {
                PatternHelper.this.patternBitmapColorListener.setBacgkroundMode();
                if (position == 0) {
                    PatternHelper.this.patternBitmapColorListener.patternBitmapReady(-1, null, -1);
                } else if (position != 0 && PatternHelper.this.patternAdapterList != null && !PatternHelper.this.patternAdapterList.isEmpty()) {
                    int newPos = position - 1;
                    if (PatternHelper.this.patternAdapterList.get(newPos) != PatternHelper.this.recyclerView.getAdapter()) {
                        PatternHelper.this.recyclerView.setAdapter((Adapter) PatternHelper.this.patternAdapterList.get(newPos));
                        ((MyRecylceAdapterBase) PatternHelper.this.patternAdapterList.get(newPos)).setSelectedPositinVoid();
                    } else {
                        ((MyRecylceAdapterBase) PatternHelper.this.patternAdapterList.get(newPos)).setSelectedPositinVoid();
                        ((MyRecylceAdapterBase) PatternHelper.this.patternAdapterList.get(newPos)).notifyDataSetChanged();
                    }
                    if (PatternHelper.this.colorContainer != null) {
                        PatternHelper.this.colorContainer.setVisibility(0);
                    }
                }
            }
        }

        public void onPatternChanged(PatternItem item) {
        }
    }

    class C10322 implements CurrentCollageIndexChangedListener {
        C10322() {
        }

        public void onIndexChanged(int color) {
            if (PatternHelper.this.patternBitmapColorListener != null) {
                PatternHelper.this.patternBitmapColorListener.patternColorReady(color);
            }
        }

        public void onPatternChanged(PatternItem item) {
        }
    }

    class C10333 implements CurrentCollageIndexChangedListener {
        C10333() {
        }

        public void onIndexChanged(int color) {
            if (PatternHelper.this.patternBitmapColorListener != null) {
                PatternHelper.this.patternBitmapColorListener.patternColorReady(color);
            }
        }

        public void onPatternChanged(PatternItem item) {
        }
    }

    class C10377 implements ImageLoaded {
        C10377() {
        }

        public void callFileSizeAlertDialogBuilder() {
            int maxSize = PatternHelper.MAX_SIZE_DEFAULT;
           /* if (PatternHelper.this.activity != null) {
                maxSize = Utility.maxSizeForDimension(PatternHelper.this.activity, 1, 800.0f);
            }*/
            Bitmap btm = PatternHelper.this.readBitapBlur(PatternHelper.this.imageLoader.selectedImagePath, maxSize);
            if (btm != null) {
                PatternHelper.this.patternBitmapColorListener.patternImageReady(btm);
            }
        }
    }

    public PatternHelper(FragmentActivity activity, PatternBitmapColorListener patternBitmapColorListener, LinearLayout colorContainer, RecyclerView recyclerView, int colorDefault, int colorSelected) {
        this.patternBitmapColorListener = patternBitmapColorListener;
        this.colorContainer = colorContainer;
        this.recyclerView = recyclerView;
        sdIdList = new ArrayList();
        PatternOnlineFragment fragment = (PatternOnlineFragment) activity.getSupportFragmentManager().findFragmentByTag(PatternOnlineFragment.FRAGMENT_TAG);
        if (fragment != null) {
            fragment.setPatternDownloadListener(getPatternListener(activity, colorDefault, colorSelected));
        }
        this.activity = activity;
    }

    public void createPatternAdapter(FragmentActivity activity, int colorDefault, int colorSelected) {
        this.patternAdapter = new PatternAdapter(UtilityPattern.getPatternIconList(activity), new C10311(), colorDefault, colorSelected, false, false);
        for (int i = 0; i < this.patternAdapter.patternItemArrayList.size(); i++) {
            PatternItem p = (PatternItem) this.patternAdapter.patternItemArrayList.get(i);
            if (p.isFromOnline) {
                PatternOnlineFragment.addToSdList(sdIdList, p.path);
            }
        }
        this.patternAdapter.setSelectedPositinVoid();
        this.recyclerView.setAdapter(new PatternColorPickerAdapter(new C10322(), colorDefault, colorSelected));
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        createAdapterList(activity, colorDefault, colorSelected);
    }

    public void patternDownloadClicker(FragmentActivity activity, int colorDefault, int colorSelected) {
        activity.findViewById(R.id.pattern_fragment_container).bringToFront();
        FragmentManager fm = activity.getSupportFragmentManager();
        PatternOnlineFragment fragment = (PatternOnlineFragment) fm.findFragmentByTag(PatternOnlineFragment.FRAGMENT_TAG);
        FragmentTransaction ft;
        if (fragment == null) {
            ft = fm.beginTransaction();
            fragment = new PatternOnlineFragment();
            if (fragment.isAdded()) {
                ft.show(fragment).commitAllowingStateLoss();
            } else {
                ft.add(R.id.pattern_fragment_container, fragment, PatternOnlineFragment.FRAGMENT_TAG);
                ft.addToBackStack(PatternOnlineFragment.FRAGMENT_TAG);
                ft.commitAllowingStateLoss();
            }
        } else {
            ft = fm.beginTransaction();
            if (fragment.isAdded()) {
                ft.show(fragment).commitAllowingStateLoss();
            } else {
                ft.addToBackStack(PatternOnlineFragment.FRAGMENT_TAG);
                ft.add(R.id.pattern_fragment_container, fragment, PatternOnlineFragment.FRAGMENT_TAG).commitAllowingStateLoss();
            }
        }
        fragment.setPatternDownloadListener(getPatternListener(activity, colorDefault, colorSelected));
    }

    private void createAdapterList(final Activity activity, int colorDefault, int colorSelected) {
        ArrayList<PatternItem> patternItems;
        int size = UtilityPattern.patternResIdList2.length;
        this.patternAdapterList.clear();
        this.patternAdapterList.add(new PatternColorPickerAdapter(new C10333(), colorDefault, colorSelected));
        int s = this.patternAdapter.patternItemArrayList.size();
        for (int x = 0; x < s; x++) {
            if (((PatternItem) this.patternAdapter.patternItemArrayList.get(x)).isFromOnline) {
                patternItems = UtilityPattern.getPatternIconsFromSdCard(((PatternItem) this.patternAdapter.patternItemArrayList.get(x)).path);
                if (!(patternItems == null || patternItems.isEmpty())) {
                    final Activity activity2 = activity;
                    this.patternAdapterList.add(new PatternAdapter(patternItems, new CurrentCollageIndexChangedListener() {
                        public void onIndexChanged(int positionOrColor) {
                        }

                        public void onPatternChanged(PatternItem item) {
                            if (PatternHelper.this.patternBitmapColorListener != null) {
                                Bitmap patternBitmap;
                                if (item.isFromOnline) {
                                    patternBitmap = BitmapFactory.decodeFile(item.path);
                                } else {
                                    patternBitmap = BitmapFactory.decodeResource(activity2.getResources(), item.resId);
                                }
                                PatternHelper.this.patternBitmapColorListener.patternBitmapReady(0, patternBitmap, item.resId);
                            }
                        }
                    }, colorDefault, colorSelected, true, true));
                }
            }
        }
        for (int i = 0; i < size; i++) {
            patternItems = new ArrayList();
            for (int patternItem : UtilityPattern.patternResIdList2[i]) {
                patternItems.add(new PatternItem(patternItem));
            }
            this.patternAdapterList.add(new PatternAdapter(patternItems, new CurrentCollageIndexChangedListener() {
                public void onIndexChanged(int positionOrColor) {
                }

                public void onPatternChanged(PatternItem item) {
                    Bitmap patternBitmap;
                    if (item.isFromOnline) {
                        patternBitmap = BitmapFactory.decodeFile(item.path);
                    } else {
                        patternBitmap = BitmapFactory.decodeResource(activity.getResources(), item.resId);
                    }
                    PatternHelper.this.patternBitmapColorListener.patternBitmapReady(0, patternBitmap, item.resId);
                }
            }, colorDefault, colorSelected, true, true));
        }
        if (this.patternAdapter.patternItemArrayList.size() != this.patternAdapterList.size() + 1) {
            this.patternAdapter.setData(UtilityPattern.getPatternIconList(activity));
            Log.e(TAG, "sizes do not match");
        }
    }

    public static boolean onBackPressed(FragmentActivity activity) {
        FragmentManager fm = activity.getSupportFragmentManager();
        PatternOnlineFragment patternOnlineFragment = (PatternOnlineFragment) fm.findFragmentByTag(PatternOnlineFragment.FRAGMENT_TAG);
        PatternDetailFragment patternDetailFragment = (PatternDetailFragment) fm.findFragmentByTag(PatternDetailFragment.FRAGMENT_TAG);
        PatternDeleteFragment patternDeleteFragment = (PatternDeleteFragment) fm.findFragmentByTag(PatternDeleteFragment.FRAGMENT_TAG);
        FragmentTransaction ft;
        if (patternDeleteFragment != null && patternDeleteFragment.isVisible()) {
            ft = fm.beginTransaction();
            ft.remove(patternDeleteFragment);
            ft.commitAllowingStateLoss();
            return true;
        } else if (patternDetailFragment != null && patternDetailFragment.isVisible()) {
            ft = fm.beginTransaction();
            ft.remove(patternDetailFragment);
            ft.commitAllowingStateLoss();
            return true;
        } else if (patternOnlineFragment == null || !patternOnlineFragment.isVisible()) {
            return false;
        } else {
            ft = fm.beginTransaction();
            ft.remove(patternOnlineFragment);
            ft.commitAllowingStateLoss();
            return true;
        }
    }

    PatternDownloadListener getPatternListener(final FragmentActivity activity, final int colorDefault, final int colorSelected) {
        return new PatternDownloadListener() {
            public void patternDownloaded(String path) {
                if (PatternHelper.this.patternAdapter != null) {
                    PatternItem p = new PatternItem(path);
                    PatternHelper.this.patternAdapter.addItem(p);
                    if (p.isFromOnline) {
                        PatternOnlineFragment.addToSdList(PatternHelper.sdIdList, p.path);
                    }
                    PatternHelper.this.createAdapterList(activity, colorDefault, colorSelected);
                }
            }

            public void patternDeleted(String path) {
                PatternHelper.this.patternAdapter.removeItem(new PatternItem(path));
                PatternHelper.this.createAdapterList(activity, colorDefault, colorSelected);
            }

            public void patternDownloadError() {
            }
        };
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void selectImage() {
        if (this.activity != null) {
            this.imageLoader = new ImageLoader(this.activity);
            this.imageLoader.setListener(this.imageLoadedListener);
        }
    }

    private Bitmap readBitapBlur(String selectedImagePath, int maxSize) {
        if (this.bitmapBlur != null) {
            this.bitmapBlur.recycle();
        }
        Bitmap readTemp = ImageUtility.decodeBitmapFromFile(selectedImagePath, maxSize / 2);
        if (readTemp == null) {
            return null;
        }
        this.bitmapBlur = readTemp;
        return this.bitmapBlur;
    }

    public static Bitmap createCroppedBitmap(Bitmap src, int left, int top, int width, int height, boolean filter) {
        Bitmap result = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setFilterBitmap(filter);
        canvas.drawBitmap(src, (float) (-left), (float) (-top), paint);
        return result;
    }

    public void activityResult(int resultCode, Intent data) {
        if (resultCode == -1) {
            if (this.imageLoader == null) {
                selectImage();
            }
            this.imageLoader.getImageFromIntent(data);
        }
    }
}
