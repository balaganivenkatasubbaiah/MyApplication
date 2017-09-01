package com.lyrebirdstudio.tiltshift;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.lyrebirdstudio.R;

public class TiltActivity extends FragmentActivity {
    TiltFragment titlFragment;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
        Bitmap bitmapBlur = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
        setContentView(R.layout.activity_tilt);
        FragmentManager fm = getSupportFragmentManager();
        this.titlFragment = (TiltFragment) fm.findFragmentByTag("my_tilt_fragment");
        if (this.titlFragment == null) {
            this.titlFragment = new TiltFragment();
            this.titlFragment.setBitmaps(bitmap, bitmapBlur);
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.tilt_fragment_container, this.titlFragment, "my_tilt_fragment");
            ft.commit();
            return;
        }
        getSupportFragmentManager().beginTransaction().show(this.titlFragment).commit();
    }
}
