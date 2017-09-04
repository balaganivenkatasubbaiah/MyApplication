package com.lyrebirdstudio.cropimages;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;

import com.lyrebirdstudio.R;

import java.io.File;

public class CropActivity extends Activity {
    static final String TAG = "CropActivity";
    Bundle bundle;
    Context context = this;
    CropView cropView;
    String inputPath;
    Class intentClass;
    boolean isHDR = false;
    String outputPath;
    Button[] ratioButtonList;

    private class CropTask extends AsyncTask<Void, Void, Void> {
        String localOutputPath;
        ProgressDialog progressDialog;
        int res;

        private CropTask() {
            this.res = 0;
        }

        protected void onPreExecute() {
            if (CropActivity.this.outputPath.contains("jpg") || CropActivity.this.outputPath.contains("jpeg") || CropActivity.this.outputPath.contains("png")) {
                this.localOutputPath = CropActivity.this.outputPath;
            } else {
                this.localOutputPath = CropActivity.this.outputPath.substring(0, CropActivity.this.outputPath.lastIndexOf(File.separator) + 1);
                this.localOutputPath += "crop.jpg";
                Log.e("localOutputPath", this.localOutputPath);
            }
            try {
                this.progressDialog = new ProgressDialog(CropActivity.this.context);
                this.progressDialog.setMessage(CropActivity.this.getString(R.string.crop_getting_crop_image));
                this.progressDialog.show();
            } catch (Exception e) {
            }
        }

        protected Void doInBackground(Void... arg0) {
            Log.e(CropActivity.TAG, "rotation " + CropActivity.this.cropView.rotation);
            if (!CropActivity.this.isHDR) {
                this.res = CropActivity.crop(CropActivity.this.inputPath, this.localOutputPath, cropView.getLeftPos(), cropView.getTopPos(), cropView.getRightPos(), cropView.getBottomPos(), 0);
            }
            return null;
        }

        protected void onPostExecute(Void unused) {
            if (this.localOutputPath != CropActivity.this.outputPath) {
                new File(this.localOutputPath).renameTo(new File(CropActivity.this.outputPath));
            }
            try {
                this.progressDialog.dismiss();
            } catch (Exception e) {
            }
            if (CropActivity.this.isHDR) {
                Intent plasmaIntent = new Intent();
                plasmaIntent.putExtra("result_path", CropActivity.this.outputPath);
                plasmaIntent.putExtra("bundle", CropActivity.this.bundle);
                plasmaIntent.putExtra("left", CropActivity.this.cropView.getLeftPos());
                plasmaIntent.putExtra("top", CropActivity.this.cropView.getTopPos());
                plasmaIntent.putExtra("right", CropActivity.this.cropView.getRightPos());
                plasmaIntent.putExtra("bottom", CropActivity.this.cropView.getBottomPos());
                CropActivity.this.setResult(-1, plasmaIntent);
                CropActivity.this.finish();
            } else if (this.res == 1) {
                Intent intent = new Intent();
                intent.putExtra("result_path", CropActivity.this.outputPath);
                CropActivity.this.setResult(-1, intent);
                CropActivity.this.finish();
            } else {
                CropActivity.this.setResult(0);
                CropActivity.this.finish();
            }
        }
    }

   public static native int crop(String str, String str2, int i, int i2, int i3, int i4, int i5);

    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crop_activity_main);
        this.inputPath = null;
        this.outputPath = null;
        Bundle extras = getIntent().getExtras();
        int mode = 0;
        if (extras != null) {
            this.inputPath = extras.getString("image-path");
            this.outputPath = extras.getString("result-path");
            mode = extras.getInt("mode");
            this.bundle = extras.getBundle("bundle");
            this.isHDR = this.bundle != null;
            if (this.isHDR) {
                this.intentClass = (Class) this.bundle.getSerializable("class");
            }
        }
        new File(this.outputPath).getParentFile().mkdirs();
        int screenHeight = getResources().getDisplayMetrics().heightPixels;
        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        if (this.inputPath == null) {
            this.inputPath = "/sdcard/background.jpg";
        }
        if (this.outputPath == null) {
            this.outputPath = "/sdcard/cropped.jpg";
        }
        this.cropView = new CropView(this, this.inputPath, screenWidth, screenHeight, null, 1);
        if (this.cropView.bitmap == null) {
            Toast.makeText(getApplicationContext(), R.string.crop_image_load_error_message, Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.crop_view_container);
        LayoutParams rllp = new LayoutParams(-2, -2);
        rllp.addRule(14, -1);
        rllp.addRule(15, -1);
        rl.addView(this.cropView, rllp);
        this.ratioButtonList = new Button[11];
        this.ratioButtonList[0] = (Button) findViewById(R.id.button1);
        this.ratioButtonList[1] = (Button) findViewById(R.id.button2);
        this.ratioButtonList[2] = (Button) findViewById(R.id.button3);
        this.ratioButtonList[3] = (Button) findViewById(R.id.button4);
        this.ratioButtonList[4] = (Button) findViewById(R.id.button5);
        this.ratioButtonList[5] = (Button) findViewById(R.id.button6);
        this.ratioButtonList[6] = (Button) findViewById(R.id.button7);
        this.ratioButtonList[7] = (Button) findViewById(R.id.button8);
        this.ratioButtonList[8] = (Button) findViewById(R.id.button9);
        this.ratioButtonList[9] = (Button) findViewById(R.id.button10);
        this.ratioButtonList[10] = (Button) findViewById(R.id.button11);
        setRatioButtonListBackgroundColor(mode);
        this.cropView.setMode(mode);
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
        stopHitGoogleAnalyticsTracker();
        super.onStop();
    }

    void setRatioButtonListBackgroundColor(int index) {
        for (int i = 0; i < this.ratioButtonList.length; i++) {
            this.ratioButtonList[i].setBackgroundResource(R.drawable.crop_border);
            this.ratioButtonList[i].setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        this.ratioButtonList[index].setBackgroundResource(R.drawable.crop_border_selected);
        this.ratioButtonList[index].setTextColor(-1);
    }

    static {
        System.loadLibrary("filter");
    }

    protected void onDestroy() {
        if (!(this.cropView == null || this.cropView.bitmap == null)) {
            this.cropView.bitmap.recycle();
        }
        super.onDestroy();
    }

    public void myClickHandler(View view) {
        int id = view.getId();
        if (id == R.id.button1) {
            this.cropView.setMode(0);
            setRatioButtonListBackgroundColor(0);
        } else if (id == R.id.button2) {
            this.cropView.setMode(1);
            setRatioButtonListBackgroundColor(1);
        } else if (id == R.id.button3) {
            this.cropView.setMode(2);
            setRatioButtonListBackgroundColor(2);
        } else if (id == R.id.button4) {
            this.cropView.setMode(3);
            setRatioButtonListBackgroundColor(3);
        } else if (id == R.id.button5) {
            this.cropView.setMode(4);
            setRatioButtonListBackgroundColor(4);
        } else if (id == R.id.button6) {
            this.cropView.setMode(5);
            setRatioButtonListBackgroundColor(5);
        } else if (id == R.id.button7) {
            this.cropView.setMode(6);
            setRatioButtonListBackgroundColor(6);
        } else if (id == R.id.button8) {
            this.cropView.setMode(7);
            setRatioButtonListBackgroundColor(7);
        } else if (id == R.id.button9) {
            this.cropView.setMode(8);
            setRatioButtonListBackgroundColor(8);
        } else if (id == R.id.button10) {
            this.cropView.setMode(9);
            setRatioButtonListBackgroundColor(9);
        } else if (id == R.id.button11) {
            this.cropView.setMode(10);
            setRatioButtonListBackgroundColor(10);
        } else if (id == R.id.button_ok || id == R.id.button_apply_action) {
            new CropTask().execute(new Void[0]);
        } else if (id == R.id.button_cancel_action) {
            cancelCrop();
        }
    }

    public void onBackPressed() {
        cancelCrop();
    }

    private void cancelCrop() {
        if (this.isHDR) {
            setResult(0);
            finish();
            return;
        }
        setResult(0);
        finish();
    }
}
