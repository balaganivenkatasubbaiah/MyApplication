package com.lyrebirdstudio.lyrebirdlibrary;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.lyrebirdstudio.R;

public class HorizontalViewAdapter {
    static int uniqueId = 233;
    public Activity activity;
    HorizontalScrollView myHorScrollView;
    int nextBg;
    int previousBg;
    int proIndex = 9;
    int[] resIdList;
    int selectedFilterColor = -72959;
    int selectedIndex = 0;
    View selectedView;
    int unselectedFilterColor = 1436129689;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void setSelectedIndex(int index) {
        this.selectedIndex = index;
    }

    public HorizontalViewAdapter(Activity _activity, int[] imageResIdList, int previousBg, int nextBg, ViewGroup parent, int proIndex) {
        this.activity = _activity;
        this.previousBg = previousBg;
        this.nextBg = nextBg;
        this.proIndex = proIndex;
        this.resIdList = new int[imageResIdList.length];
        int i = 0;
        while (i < this.resIdList.length) {
            View retval = LayoutInflater.from(parent.getContext()).inflate(R.layout.lyrebird_library_viewitem, null);
            if (LibUtility.shouldShowAds(_activity) && i > proIndex) {
                ((ImageView) retval.findViewById(R.id.pro_imageview)).setImageResource(R.drawable.pro);
            }
            ImageView filterImageView = (ImageView) retval.findViewById(R.id.filter_image);
            filterImageView.setScaleType(ScaleType.FIT_XY);
            filterImageView.setImageResource(imageResIdList[i]);
            uniqueId++;
            retval.setId(uniqueId);
            this.resIdList[i] = uniqueId;
            parent.addView(retval);
            i++;
        }
        setSelectedView(0);
    }

    public HorizontalViewAdapter(Activity _activity, Bitmap[] btmList, String[] strList, ViewGroup parent, int previousBg, int nextBg, int proIndex) {
        this.activity = _activity;
        this.proIndex = proIndex;
        this.resIdList = new int[btmList.length];
        int i = 0;
        while (i < btmList.length) {
            View retval = LayoutInflater.from(parent.getContext()).inflate(R.layout.lyrebird_library_viewitem, null);
            if (LibUtility.shouldShowAds(_activity) && i > proIndex) {
                ((ImageView) retval.findViewById(R.id.pro_imageview)).setImageResource(R.drawable.pro);
            }
            ((ImageView) retval.findViewById(R.id.filter_image)).setImageBitmap(btmList[i]);
            uniqueId++;
            retval.setId(uniqueId);
            this.resIdList[i] = uniqueId;
            parent.addView(retval);
            i++;
        }
        this.previousBg = previousBg;
        this.nextBg = nextBg;
        setSelectedView(0);
    }

    public void setSelectedView(int index) {
        if (this.selectedView != null) {
            this.selectedView.setBackgroundResource(this.previousBg);
        }
        this.selectedView = this.activity.findViewById(this.resIdList[index]);
        if (this.selectedView != null) {
            this.selectedView.setBackgroundResource(this.nextBg);
        }
    }

    void scrollToPosition() {
        this.myHorScrollView.smoothScrollTo(this.selectedView.getLeft(), this.selectedView.getTop());
    }

    public int getSize() {
        return this.resIdList.length;
    }

    public int getIndex(int id) {
        int result = -1;
        for (int i = 0; i < this.resIdList.length; i++) {
            if (id == this.resIdList[i]) {
                result = i;
            }
        }
        return result;
    }
}
