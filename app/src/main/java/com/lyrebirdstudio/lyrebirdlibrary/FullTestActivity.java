package com.lyrebirdstudio.lyrebirdlibrary;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.lyrebirdstudio.R;

public class FullTestActivity extends FragmentActivity {
    private static final String TAG = FullTestActivity.class.getName();
    FullEffectFragment fullEffectFragment;

    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_test_layout);
        addFragment(true, BitmapFactory.decodeResource(getResources(), R.drawable.texture_09));
    }

    void addFragment(boolean isPro, Bitmap sourceBitmap) {
        if (this.fullEffectFragment == null) {
            this.fullEffectFragment = (FullEffectFragment) getSupportFragmentManager().findFragmentByTag("FULL_FRAGMENT");
            if (this.fullEffectFragment == null) {
                this.fullEffectFragment = new FullEffectFragment();
                this.fullEffectFragment.setArguments(getIntent().getExtras());
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, this.fullEffectFragment, "FULL_FRAGMENT").commit();
                this.fullEffectFragment.setBitmapWithParameter(sourceBitmap, null);
            } else {
                this.fullEffectFragment.setBitmapWithParameter(sourceBitmap, null);
            }
            getSupportFragmentManager().beginTransaction().show(this.fullEffectFragment).commit();
        }
    }

    public void myClickHandler(View view) {
        this.fullEffectFragment.myClickHandler(view);
    }
}
