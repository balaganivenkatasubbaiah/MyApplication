package com.lyrebirdstudio.lyrebirdlibrary;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.lyrebirdstudio.R;
import com.lyrebirdstudio.lyrebirdlibrary.EffectFragment.BitmapReady;

import java.io.File;

@TargetApi(11)
public class EffectActivity extends FragmentActivity {
    public static final String TAG = "EffectActivity";
    private static final boolean debug = true;
    Context context = this;
    EffectFragment effectFragment;
    ImageView imageView;
    String outputPath;
    String path;
    Bitmap sourceBitmap;

    private class EffectTask extends AsyncTask<Void, Void, Void> {
        String localOutputPath;
        ProgressDialog progressDialog;

        private EffectTask() {
        }

        protected void onPreExecute() {
            if (EffectActivity.this.outputPath.contains("jpg") || EffectActivity.this.outputPath.contains("jpeg") || EffectActivity.this.outputPath.contains("png")) {
                this.localOutputPath = EffectActivity.this.outputPath;
            } else {
                this.localOutputPath = EffectActivity.this.outputPath.substring(0, EffectActivity.this.outputPath.lastIndexOf(File.separator) + 1);
                this.localOutputPath += "crop.jpg";
                Log.e("localOutputPath", this.localOutputPath);
            }
            try {
                this.progressDialog = new ProgressDialog(EffectActivity.this.context);
                this.progressDialog.setMessage("Saving result image!");
                this.progressDialog.show();
            } catch (Exception e) {
            }
        }

        protected Void doInBackground(Void... arg0) {
            Log.e("outputPath", EffectActivity.this.outputPath);
            EffectActivity.this.effectFragment.saveFullImageMember(EffectActivity.this.path, EffectActivity.this.outputPath);
            return null;
        }

        protected void onPostExecute(Void unused) {
            if (this.localOutputPath != EffectActivity.this.outputPath) {
                new File(this.localOutputPath).renameTo(new File(EffectActivity.this.outputPath));
            }
            try {
                this.progressDialog.dismiss();
            } catch (Exception e) {
            }
            Intent intent = new Intent();
            intent.putExtra("result_path", EffectActivity.this.outputPath);
            EffectActivity.this.setResult(-1, intent);
            EffectActivity.this.finish();
        }
    }

    class C10191 implements BitmapReady {
        C10191() {
        }

        public void onBitmapReady(Bitmap bitmap) {
            EffectActivity.this.imageView.setImageBitmap(bitmap);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_effect);
        this.imageView = (ImageView) findViewById(R.id.imageView1);
        Options op = new Options();
        op.inPreferredConfig = Config.ARGB_8888;
        this.sourceBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.texture_26, op);
        if (VERSION.SDK_INT < 12) {
            Bitmap result = Bitmap.createBitmap(this.sourceBitmap.getWidth(), this.sourceBitmap.getHeight(), Config.ARGB_8888);
            new Canvas(result).drawBitmap(this.sourceBitmap, 0.0f, 0.0f, new Paint());
            Bitmap temp = this.sourceBitmap;
            this.sourceBitmap = result;
            temp.recycle();
        }
        Log.e(TAG, "getWidth" + this.sourceBitmap.getWidth());
        this.imageView.setImageBitmap(this.sourceBitmap);
        addFragment(true);
        getGoogleAnalyticsTracker();
    }

    private void getGoogleAnalyticsTracker() {
    }

    private void hitGoogleAnalyticsTracker() {
    }

    private void stopHitGoogleAnalyticsTracker() {
    }

    protected void onStart() {
        hitGoogleAnalyticsTracker();
        super.onStart();
    }

    protected void onStop() {
        super.onStop();
        stopHitGoogleAnalyticsTracker();
    }

    void addFragment(boolean isPro) {
        if (this.effectFragment == null) {
            this.effectFragment = (EffectFragment) getSupportFragmentManager().findFragmentByTag("MY_FRAGMENT");
            if (this.effectFragment == null) {
                this.effectFragment = new EffectFragment();
                Log.e(TAG, "EffectFragment == null");
                this.effectFragment.isAppPro(isPro);
                this.effectFragment.setBitmap(this.sourceBitmap);
                this.effectFragment.setArguments(getIntent().getExtras());
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, this.effectFragment, "MY_FRAGMENT").commit();
            } else {
                this.effectFragment.setBitmap(this.sourceBitmap);
                this.effectFragment.isAppPro(isPro);
            }
            getSupportFragmentManager().beginTransaction().show(this.effectFragment).commit();
            this.effectFragment.setBitmapReadyListener(new C10191());
        }
    }

    public void myClickHandler(View view) {
        if (view.getId() == R.id.button_apply_filter) {
            new EffectTask().execute(new Void[0]);
        } else if (view.getId() == R.id.button_cancel_filter) {
            setResult(0);
            finish();
        } else {
            this.effectFragment.myClickHandler(view.getId());
        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onBackPressed() {
        boolean handled = false;
        if (this.effectFragment != null && this.effectFragment.isVisible()) {
            handled = this.effectFragment.backPressed();
        }
        if (!handled) {
            super.onBackPressed();
        }
    }
}
