package com.lyrebirdstudio.canvastext;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.lyrebirdstudio.R;
import com.lyrebirdstudio.canvastext.CanvasTextView.TextAndStickerViewSelectedListener;
import com.lyrebirdstudio.canvastext.TextLibFragment.TextStyledListener;
import com.lyrebirdstudio.sticker.StickerData;
import com.lyrebirdstudio.sticker.StickerLibHelper;
import com.lyrebirdstudio.sticker.StickerView;

import java.util.ArrayList;

public class TextLibHelper {
    private static final String TAG = TextLibHelper.class.getSimpleName();
    public static final String[] fontPathList = new String[]{"fonts/MfStillKindaRidiculous.otf", "fonts/ahundredmiles.otf", "fonts/Binz.otf", "fonts/Blunt.otf", "fonts/CaviarDreams.otf", "fonts/digiclock.otf", "fonts/FreeUniversal-Bold.otf", "fonts/GoodDog.otf", "fonts/gtw.otf", "fonts/HandTest.otf", "fonts/Jester.otf", "fonts/Junction 02.otf", "fonts/Laine.otf", "fonts/NotCourierSans.otf", "fonts/OldFolksShuffle.otf", "fonts/OSP-DIN.otf", "fonts/otfpoc.otf", "fonts/Pacifico.otf", "fonts/Polsku.otf", "fonts/PressStart2P.otf", "fonts/Primal _ream.otf", "fonts/Quicksand-Regular.otf", "fonts/Roboto-Thin.otf", "fonts/RomanAntique.otf", "fonts/Semplicita_Light.otf", "fonts/SerreriaSobria.otf", "fonts/She-Stole-the-Night.otf", "fonts/Sofia-Regular.otf", "fonts/Strato-linked.otf", "fonts/vinque.otf", "fonts/waltographUI.otf", "fonts/Windsong.otf"};
    public static final String textFragmentTag = "myTextLibFragmentTag";
    Bitmap textBlackBar;
    Bitmap textEditBitmap;
    TextLibFragment textLibFragment;
    Bitmap textRemoveBitmap;
    Bitmap textScaleBitmap;
    TextStyledListener textStyledListener;
    Bitmap textSwitchBitmap;

    public void addCanvasTextFragment(FragmentActivity fragmentActivity, ViewGroup textViewContainer, int parentId) {
        FragmentManager fm = fragmentActivity.getSupportFragmentManager();
        this.textLibFragment = (TextLibFragment) fm.findFragmentByTag(textFragmentTag);
        if (this.textLibFragment == null) {
            this.textLibFragment = new TextLibFragment();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(parentId, this.textLibFragment, textFragmentTag);
            ft.commitAllowingStateLoss();
            this.textLibFragment.setTextStyledListener(createFragmentListener(fragmentActivity, textViewContainer, parentId));
            return;
        }
        fragmentActivity.getSupportFragmentManager().beginTransaction().show(this.textLibFragment).commitAllowingStateLoss();
    }

    public void addCanvasText2(FragmentActivity fragmentActivity, ViewGroup textViewContainer, int parentId) {
        if (fragmentActivity != null && textViewContainer != null) {
            this.textLibFragment = new TextLibFragment();
            this.textLibFragment.setArguments(new Bundle());
            fragmentActivity.getSupportFragmentManager().beginTransaction().replace(parentId, this.textLibFragment, textFragmentTag).commitAllowingStateLoss();
            this.textLibFragment.setTextStyledListener(createFragmentListener(fragmentActivity, textViewContainer, parentId));
        }
    }

    SingleTap createSingleTapListener(final FragmentActivity activity, final ViewGroup textViewContainer, final int parentId) {
        return (activity == null || textViewContainer == null) ? null : new SingleTap() {
            public void onSingleTap(TextData textData) {
                TextLibHelper.this.textLibFragment = new TextLibFragment();
                Bundle arguments = new Bundle();
                arguments.putSerializable("text_data", textData);
                TextLibHelper.this.textLibFragment.setArguments(arguments);
                activity.getSupportFragmentManager().beginTransaction().replace(parentId, TextLibHelper.this.textLibFragment, TextLibHelper.textFragmentTag).commitAllowingStateLoss();
                TextLibHelper.this.textLibFragment.setTextStyledListener(TextLibHelper.this.createFragmentListener(activity, textViewContainer, parentId));
            }
        };
    }

    TextStyledListener createFragmentListener(FragmentActivity activity, ViewGroup textViewContainer, int parentId) {
        if (activity == null || textViewContainer == null) {
            return null;
        }
        final FragmentManager fm = activity.getSupportFragmentManager();
        if (this.textLibFragment == null) {
            this.textLibFragment = (TextLibFragment) fm.findFragmentByTag(textFragmentTag);
        }
        if (this.textStyledListener == null) {
            final FragmentActivity fragmentActivity = activity;
            final ViewGroup viewGroup = textViewContainer;
            final int i = parentId;
            this.textStyledListener = new TextStyledListener() {
                public void onOk(TextData textData) {
                    if (TextLibHelper.this.textRemoveBitmap == null) {
                        TextLibHelper.this.textRemoveBitmap = BitmapFactory.decodeResource(fragmentActivity.getResources(), R.drawable.remove_text);
                    }
                    if (TextLibHelper.this.textScaleBitmap == null) {
                        TextLibHelper.this.textScaleBitmap = BitmapFactory.decodeResource(fragmentActivity.getResources(), R.drawable.scale_text);
                    }
                    if (TextLibHelper.this.textEditBitmap == null) {
                        TextLibHelper.this.textEditBitmap = BitmapFactory.decodeResource(fragmentActivity.getResources(), R.drawable.ic_text_snap_edit2);
                    }
                    if (TextLibHelper.this.textSwitchBitmap == null) {
                        TextLibHelper.this.textSwitchBitmap = BitmapFactory.decodeResource(fragmentActivity.getResources(), R.drawable.ic_text_snap_switch);
                    }
                    if (TextLibHelper.this.textBlackBar == null) {
                        TextLibHelper.this.textBlackBar = BitmapFactory.decodeResource(fragmentActivity.getResources(), R.drawable.ic_text_black_bar);
                    }
                    CanvasTextView canvasTextView = null;
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        View view = viewGroup.getChildAt(i);
                        if (view instanceof CanvasTextView) {
                            CanvasTextView ctv = (CanvasTextView) view;
                            if (ctv.textData.ID.compareTo(textData.ID) == 0) {
                                canvasTextView = ctv;
                            }
                        }
                    }
                    if (canvasTextView == null) {
                        Rect lineBound = new Rect();
                        int maxLength = 0;
                        int height = 0;
                        for (String line : textData.message.split("\n")) {
                            height = (int) (((float) height) - ((-textData.textPaint.ascent()) + textData.textPaint.descent()));
                            textData.textPaint.getTextBounds(line, 0, line.length(), lineBound);
                            if (lineBound.width() > maxLength) {
                                maxLength = lineBound.width();
                            }
                        }
                        height = (int) (((float) height) + ((-textData.textPaint.ascent()) + textData.textPaint.descent()));
                        Log.e(TextLibHelper.TAG, "height " + height);
                        float screenHeight = (float) fragmentActivity.getResources().getDisplayMetrics().heightPixels;
                        textData.xPos = (((float) fragmentActivity.getResources().getDisplayMetrics().widthPixels) / 2.0f) - ((float) (maxLength / 2));
                        textData.yPos = (screenHeight / 3.5f) - ((float) height);
                        canvasTextView = new CanvasTextView(fragmentActivity, textData, TextLibHelper.this.textRemoveBitmap, TextLibHelper.this.textScaleBitmap, TextLibHelper.this.textEditBitmap, TextLibHelper.this.textSwitchBitmap, TextLibHelper.this.textBlackBar);
                        canvasTextView.setTextAndStickerViewSelectedListener(TextLibHelper.this.createTextAndStickerViewSelectedListener(viewGroup));
                        canvasTextView.setSingleTapListener(TextLibHelper.this.createSingleTapListener(fragmentActivity, viewGroup, i));
                        viewGroup.addView(canvasTextView);
                    } else {
                        canvasTextView.textData.set(textData);
                        if (textData.getFontPath() != null) {
                            canvasTextView.textData.setTextFont(textData.getFontPath(), fragmentActivity);
                        }
                    }
                    canvasTextView.invalidate();
                    fm.beginTransaction().hide(TextLibHelper.this.textLibFragment).commitAllowingStateLoss();
                }

                public void onCancel() {
                    fragmentActivity.getSupportFragmentManager().beginTransaction().hide(TextLibHelper.this.textLibFragment).commitAllowingStateLoss();
                }
            };
        }
        return this.textStyledListener;
    }

    ViewSelectedListener excreateCanvasTextViewSelectedListner(final ViewGroup textViewContainer) {
        return new ViewSelectedListener() {
            public void setSelectedView(CanvasTextView canvasTextView) {
                canvasTextView.bringToFront();
                canvasTextView.bringToFront();
                if (VERSION.SDK_INT < 19) {
                    textViewContainer.requestLayout();
                }
            }
        };
    }

    TextAndStickerViewSelectedListener createTextAndStickerViewSelectedListener(final ViewGroup textViewContainer) {
        return textViewContainer == null ? null : new TextAndStickerViewSelectedListener() {
            public void setSelectedView(DecorateView decorateView) {
                decorateView.bringToFront();
                if (VERSION.SDK_INT < 19) {
                    textViewContainer.requestLayout();
                }
            }

            public void onTouchUp(BaseData data) {
            }
        };
    }

    public void loadTextDataFromSavedInstance(FragmentActivity activity, Bundle savedInstanceState, ViewGroup textViewContainer, int parentId) {
        if (activity != null && textViewContainer != null && savedInstanceState != null) {
            TextData[] textDataArray = TextData.toTextData(savedInstanceState.getParcelableArray("text_data_array"));
            if (textDataArray != null) {
                Bitmap textRemoveBitmap = BitmapFactory.decodeResource(activity.getResources(), R.drawable.remove_text);
                Bitmap textScaleBitmap = BitmapFactory.decodeResource(activity.getResources(), R.drawable.scale_text);
                Bitmap textEditBitmap = BitmapFactory.decodeResource(activity.getResources(), R.drawable.ic_text_snap_edit2);
                Bitmap textSwitchBitmap = BitmapFactory.decodeResource(activity.getResources(), R.drawable.ic_text_snap_switch);
                Bitmap textBlackBar = BitmapFactory.decodeResource(activity.getResources(), R.drawable.ic_text_black_bar);
                for (TextData canvasTextView : textDataArray) {
                    CanvasTextView canvasTextView2 = new CanvasTextView(activity, canvasTextView, textRemoveBitmap, textScaleBitmap, textEditBitmap, textSwitchBitmap, textBlackBar);
                    canvasTextView2.setTextAndStickerViewSelectedListener(createTextAndStickerViewSelectedListener(textViewContainer));
                    canvasTextView2.setSingleTapListener(createSingleTapListener(activity, textViewContainer, parentId));
                    textViewContainer.addView(canvasTextView2);
                }
            }
        }
    }

    public void saveTextDataInstance(Bundle savedInstanceState, ViewGroup textViewContainer) {
        if (textViewContainer != null && savedInstanceState != null) {
            int size = getCanvasTextChildCount(textViewContainer);
            if (textViewContainer != null && size > 0) {
                TextData[] textDataArray = new TextData[size];
                int index = 0;
                for (int i = 0; i < textViewContainer.getChildCount(); i++) {
                    View view = textViewContainer.getChildAt(i);
                    if (view instanceof CanvasTextView) {
                        textDataArray[index] = ((CanvasTextView) view).textData;
                        index++;
                    }
                }
                savedInstanceState.putParcelableArray("text_data_array", textDataArray);
            }
        }
    }

    public void saveTextAndStickerDataInstance(Bundle savedInstanceState, ViewGroup textViewContainer, Matrix matrix) {
        if (textViewContainer != null && savedInstanceState != null && textViewContainer != null && savedInstanceState != null) {
            int size = textViewContainer.getChildCount();
            if (textViewContainer != null && size > 0) {
                BaseData[] baseDataArray = new BaseData[size];
                for (int i = 0; i < size; i++) {
                    View view = textViewContainer.getChildAt(i);
                    if (view instanceof CanvasTextView) {
                        TextData data = ((CanvasTextView) view).textData;
                        if (matrix != null) {
                            data.setImageSaveMatrix(matrix);
                        }
                        baseDataArray[i] = data;
                    }
                    if (view instanceof StickerView) {
                        StickerData data2 = ((StickerView) view).getStickerData();
                        if (matrix != null) {
                            data2.setImageSaveMatrix(matrix);
                        }
                        baseDataArray[i] = data2;
                    }
                }
                savedInstanceState.putParcelableArray("base_data_array", baseDataArray);
            }
        }
    }

    public void loadTextAndStickerDataFromSavedInstance(FragmentActivity activity, Bundle savedInstanceState, ViewGroup textViewContainer, int parentId, Matrix matrixx) {
        if (textViewContainer != null && savedInstanceState != null) {
            BaseData[] baseDataArray = BaseData.toBaseData(savedInstanceState.getParcelableArray("base_data_array"));
            if (baseDataArray != null) {
                Bitmap textRemoveBitmap = BitmapFactory.decodeResource(activity.getResources(), R.drawable.remove_text);
                Bitmap textScaleBitmap = BitmapFactory.decodeResource(activity.getResources(), R.drawable.scale_text);
                Bitmap textEditBitmap = BitmapFactory.decodeResource(activity.getResources(), R.drawable.ic_text_snap_edit2);
                Bitmap textSwitchBitmap = BitmapFactory.decodeResource(activity.getResources(), R.drawable.ic_text_snap_switch);
                Bitmap textBlackBar = BitmapFactory.decodeResource(activity.getResources(), R.drawable.ic_text_black_bar);
                Bitmap stickerremoveBitmap = BitmapFactory.decodeResource(activity.getResources(), R.drawable.sticker_remove_text);
                Bitmap stickerscaleBitmap = BitmapFactory.decodeResource(activity.getResources(), R.drawable.sticker_scale_text);
                for (BaseData baseData : baseDataArray) {
                    if (baseData instanceof TextData) {
                        CanvasTextView canvasTextView = new CanvasTextView(activity, (TextData) baseData, textRemoveBitmap, textScaleBitmap, textEditBitmap, textSwitchBitmap, textBlackBar);
                        canvasTextView.setTextAndStickerViewSelectedListener(createTextAndStickerViewSelectedListener(textViewContainer));
                        canvasTextView.setSingleTapListener(createSingleTapListener(activity, textViewContainer, parentId));
                        textViewContainer.addView(canvasTextView);
                    } else if (baseData instanceof StickerData) {
                        Bitmap bitmap;
                        StickerData stickerData = (StickerData) baseData;
                        if (stickerData.getPath() != null) {
                            bitmap = BitmapFactory.decodeFile(stickerData.getPath());
                        } else {
                            bitmap = BitmapFactory.decodeResource(activity.getResources(), stickerData.getResId());
                        }
                        StickerView stickerView = new StickerView(activity, bitmap, stickerData, stickerremoveBitmap, stickerscaleBitmap, stickerData.getResId(), stickerData.getPath());
                        stickerView.setTextAndStickerSelectedListner(StickerLibHelper.createTextAndStickerViewSelectedListener(textViewContainer));
                        textViewContainer.addView(stickerView);
                    }
                }
            }
        }
    }

    public void loadTextAndStickerDataFromArray(FragmentActivity activity, BaseData[] baseDataArray, ViewGroup textViewContainer, int parentId, Matrix matrixx) {
        if (textViewContainer != null && baseDataArray != null && baseDataArray != null) {
            Bitmap textRemoveBitmap = BitmapFactory.decodeResource(activity.getResources(), R.drawable.remove_text);
            Bitmap textScaleBitmap = BitmapFactory.decodeResource(activity.getResources(), R.drawable.scale_text);
            Bitmap textEditBitmap = BitmapFactory.decodeResource(activity.getResources(), R.drawable.ic_text_snap_edit2);
            Bitmap textSwitchBitmap = BitmapFactory.decodeResource(activity.getResources(), R.drawable.ic_text_snap_switch);
            Bitmap textBlackBar = BitmapFactory.decodeResource(activity.getResources(), R.drawable.ic_text_black_bar);
            Bitmap stickerremoveBitmap = BitmapFactory.decodeResource(activity.getResources(), R.drawable.sticker_remove_text);
            Bitmap stickerscaleBitmap = BitmapFactory.decodeResource(activity.getResources(), R.drawable.sticker_scale_text);
            for (BaseData baseData : baseDataArray) {
                if (baseData instanceof TextData) {
                    CanvasTextView canvasTextView = new CanvasTextView(activity, (TextData) baseData, textRemoveBitmap, textScaleBitmap, textEditBitmap, textSwitchBitmap, textBlackBar);
                    canvasTextView.setTextAndStickerViewSelectedListener(createTextAndStickerViewSelectedListener(textViewContainer));
                    canvasTextView.setSingleTapListener(createSingleTapListener(activity, textViewContainer, parentId));
                    textViewContainer.addView(canvasTextView);
                } else if (baseData instanceof StickerData) {
                    Bitmap bitmap;
                    StickerData stickerData = (StickerData) baseData;
                    if (stickerData.getPath() != null) {
                        bitmap = BitmapFactory.decodeFile(stickerData.getPath());
                    } else {
                        bitmap = BitmapFactory.decodeResource(activity.getResources(), stickerData.getResId());
                    }
                    StickerView stickerView = new StickerView(activity, bitmap, stickerData, stickerremoveBitmap, stickerscaleBitmap, stickerData.getResId(), stickerData.getPath());
                    stickerView.setTextAndStickerSelectedListner(StickerLibHelper.createTextAndStickerViewSelectedListener(textViewContainer));
                    textViewContainer.addView(stickerView);
                }
            }
        }
    }

    int getCanvasTextChildCount(ViewGroup parent) {
        int count = 0;
        int totalCount = parent.getChildCount();
        if (totalCount <= 0) {
            return 0;
        }
        for (int i = 0; i < totalCount; i++) {
            if (parent.getChildAt(i) instanceof CanvasTextView) {
                count++;
            }
        }
        return count;
    }

    public static ArrayList<TextData> getTextDataList(ViewGroup parent) {
        ArrayList<TextData> textDataList = new ArrayList();
        int totalCount = parent.getChildCount();
        for (int i = 0; i < totalCount; i++) {
            View child = parent.getChildAt(i);
            if (child instanceof CanvasTextView) {
                textDataList.add(((CanvasTextView) child).textData);
            }
        }
        return textDataList;
    }

    public void hideForOncreate(FragmentActivity activity, ViewGroup textViewContainer, int parentId) {
        if (activity != null && textViewContainer != null) {
            FragmentManager fm = activity.getSupportFragmentManager();
            this.textLibFragment = (TextLibFragment) fm.findFragmentByTag(textFragmentTag);
            if (this.textLibFragment != null) {
                fm.beginTransaction().hide(this.textLibFragment).commitAllowingStateLoss();
                this.textLibFragment.setTextStyledListener(createFragmentListener(activity, textViewContainer, parentId));
            }
        }
    }

    public boolean removeOnBackPressed(FragmentActivity activity) {
        if (activity == null) {
            return false;
        }
        if (this.textLibFragment == null) {
            this.textLibFragment = (TextLibFragment) activity.getSupportFragmentManager().findFragmentByTag(textFragmentTag);
        }
        if (this.textLibFragment == null || !this.textLibFragment.isVisible()) {
            return false;
        }
        activity.getSupportFragmentManager().beginTransaction().remove(this.textLibFragment).commitAllowingStateLoss();
        return true;
    }

    public boolean hideOnBackPressed(FragmentActivity activity) {
        if (activity == null) {
            return false;
        }
        if (this.textLibFragment == null) {
            this.textLibFragment = (TextLibFragment) activity.getSupportFragmentManager().findFragmentByTag(textFragmentTag);
        }
        if (this.textLibFragment == null || !this.textLibFragment.isVisible()) {
            return false;
        }
        activity.getSupportFragmentManager().beginTransaction().hide(this.textLibFragment).commitAllowingStateLoss();
        return true;
    }

    public static boolean onBackPressedForDecorateViewSelection(ViewGroup textAndStickerViewContainer) {
        if (textAndStickerViewContainer == null) {
            return false;
        }
        boolean result = false;
        for (int i = 0; i < textAndStickerViewContainer.getChildCount(); i++) {
            DecorateView view = (DecorateView) textAndStickerViewContainer.getChildAt(i);
            if (view.isDecorateViewSelected()) {
                view.setDecorateViewSelected(false);
                view.invalidate();
                result = true;
            }
        }
        return result;
    }

    public static void saveTextOnBitmap(Canvas bitmapCanvas, TextData textData, int screenWidth) {
        if (textData.getSnapMode()) {
            RectF rectSnap = new RectF();
            Rect lineBound = new Rect();
            CanvasTextView.setRectSnap(textData, rectSnap, (float) (screenWidth + 1));
            Canvas canvas = bitmapCanvas;
            TextData textData2 = textData;
            CanvasTextView.drawSnap(canvas, textData2, (float) ((screenWidth - CanvasTextView.getMaxLength(textData, lineBound, textData.message)) / 2), ((CanvasTextView.getSnapRectPadding(textData) + rectSnap.top) + ((float) CanvasTextView.getTextHeight(textData))) - textData.textPaint.descent(), rectSnap, CanvasTextView.paintSnap, lineBound);
            return;
        }
        Rect lineBound = new Rect();
        RectF rectBg = new RectF();
        Rect textBound = new Rect();
        Paint paint = new Paint(1);
        paint.setColor(textData.getBackgroundColorFinal());
        CanvasTextView.setBgRect(textData, rectBg, lineBound, textBound, (float) screenWidth);
        CanvasTextView.drawMultiline(bitmapCanvas, textData.message, textData.xPos, textData.yPos, textData.textPaint, textData, lineBound, rectBg, paint);
    }
}
