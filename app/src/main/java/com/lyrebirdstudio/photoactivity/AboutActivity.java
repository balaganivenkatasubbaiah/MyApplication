package com.lyrebirdstudio.photoactivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.lyrebirdstudio.R;

public class AboutActivity extends AppCompatActivity {
    private static final String TAG = "AboutActivity";

    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.about_toolbar);
        boolean addSupportActionBar = VERSION.SDK_INT >= 13;
        if (addSupportActionBar && toolbar != null) {
            try {
                Class.forName("android.support.v7.view.menu.MenuBuilder");
            } catch (ClassNotFoundException e) {
                addSupportActionBar = false;
                Log.e(TAG, "addSupportActionBar " + e.toString());
            }
            Log.e(TAG, "addSupportActionBar " + addSupportActionBar);
            if (addSupportActionBar) {
                setSupportActionBar(toolbar);
                getSupportActionBar().setDisplayShowTitleEnabled(true);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setTitle(R.string.about_title);
            } else {
                toolbar.setVisibility(8);
            }
        }
        try {
            ((TextView) findViewById(R.id.about_app_version)).setText(getString(R.string.about_version) + " " + getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
        } catch (Exception e2) {
        }
        try {
            int test = getResources().getIdentifier("ic_launcher", "mipmap", getPackageName());
            boolean isThereMipMap = test != 0;
            Log.e(TAG, "isThereMipMap " + isThereMipMap);
            if (isThereMipMap) {
                ((ImageView) findViewById(R.id.about_icon_image)).setImageResource(test);
            }
        } catch (Exception e3) {
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 16908332:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public static void startAboutApp(Context context) {
        context.startActivity(new Intent(context, AboutActivity.class));
    }
}
