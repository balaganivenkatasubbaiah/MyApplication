package com.lyrebirdstudio.sticker;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import com.lyrebirdstudio.canvastext.DecorateView;

public class StickerFrameLayout extends FrameLayout {
    private static final String TAG = "StickerFrameLayout";
    DecorateView decorateView = null;
    int index = -1;

    public StickerFrameLayout(Context context) {
        super(context);
    }

    public StickerFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StickerFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(21)
    public StickerFrameLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction() & 255) {
            case 0:
                float x = event.getX();
                float y = event.getY();
                this.index = selectedChild(x, y);
                Log.e(TAG, "selectedChild " + this.index);
                if (this.index >= 0) {
                    if (getChildCount() > 0) {
                        for (int i = 0; i < getChildCount(); i++) {
                            if (i != this.index) {
                                ((DecorateView) getChildAt(i)).setDecorateViewSelected(false);
                            }
                        }
                    }
                    this.decorateView = (DecorateView) getChildAt(this.index);
                    this.decorateView.isOnRectCheck(x, y);
                    this.decorateView.dispatchTouchEvent(event);
                }
                Log.e(TAG, "pointer count = " + event.getPointerCount());
                break;
            case 1:
                if (this.decorateView != null) {
                    this.decorateView.dispatchTouchEvent(event);
                }
                this.decorateView = null;
                this.index = -1;
                break;
            case 2:
                if (this.decorateView != null) {
                    this.decorateView.dispatchTouchEvent(event);
                    break;
                }
                break;
            case 6:
                if (this.decorateView != null) {
                    this.decorateView.dispatchTouchEvent(event);
                    break;
                }
                break;
        }
        if (this.index >= 0) {
            return true;
        }
        return false;
    }

    private int selectedChild(float x, float y) {
        int selected = -1;
        float maxScore = -1.0f;
        if (getChildCount() > 0) {
            for (int i = 0; i < getChildCount(); i++) {
                float score = ((DecorateView) getChildAt(i)).containsScore(x, y);
                if (score > maxScore) {
                    selected = i;
                    maxScore = score;
                }
            }
        }
        return selected;
    }
}
