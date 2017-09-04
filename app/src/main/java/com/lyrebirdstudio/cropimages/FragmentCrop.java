package com.lyrebirdstudio.cropimages;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.lyrebirdstudio.R;

import java.io.File;

public class FragmentCrop extends Fragment {
    private static final String TAG = "FragmentCrop";
    Activity activity;
    Bitmap btm;
    Bundle bundle;
    Context context;
    CropListener cropListener;
    CropView cropView;
    String inputPath;
    Class intentClass;
    boolean isHDR = false;
    OnClickListener onClickListener = new C06121();
    String outputPath;
    Button[] ratioButtonList;

    class C06121 implements OnClickListener {
        C06121() {
        }

        public void onClick(View v) {
            FragmentCrop.this.myClickHandler(v);
        }
    }

    public interface CropListener {
        void cropApply(int i, int i2, int i3, int i4);

        void cropCancelled();
    }

    private class CropTask extends AsyncTask<Void, Void, Void> {
        String localOutputPath;
        ProgressDialog progressDialog;
        int res = 0;

        private CropTask() {
        }

        protected void onPreExecute() {
            if (FragmentCrop.this.outputPath.contains("jpg") || FragmentCrop.this.outputPath.contains("jpeg") || FragmentCrop.this.outputPath.contains("png")) {
                this.localOutputPath = FragmentCrop.this.outputPath;
            } else {
                this.localOutputPath = FragmentCrop.this.outputPath.substring(0, FragmentCrop.this.outputPath.lastIndexOf(File.separator) + 1);
                this.localOutputPath += "crop.jpg";
            }
            try {
                this.progressDialog = new ProgressDialog(FragmentCrop.this.context);
                this.progressDialog.setMessage(FragmentCrop.this.getString(R.string.crop_getting_crop_image));
                this.progressDialog.show();
            } catch (Exception e) {
            }
        }

        protected Void doInBackground(Void... arg0) {
            if (!FragmentCrop.this.isHDR) {
                this.res = CropActivity.crop(FragmentCrop.this.inputPath, this.localOutputPath, FragmentCrop.this.cropView.getLeftPos(), FragmentCrop.this.cropView.getTopPos(), FragmentCrop.this.cropView.getRightPos(), FragmentCrop.this.cropView.getBottomPos(), FragmentCrop.this.cropView.rotation);
            }
            return null;
        }

        protected void onPostExecute(Void unused) {
            if (this.localOutputPath != FragmentCrop.this.outputPath) {
                new File(this.localOutputPath).renameTo(new File(FragmentCrop.this.outputPath));
            }
            try {
                this.progressDialog.dismiss();
            } catch (Exception e) {
            }
            if (FragmentCrop.this.isHDR) {
                FragmentCrop.this.okCrop();
            } else if (this.res == 1) {
                new Intent().putExtra("result_path", FragmentCrop.this.outputPath);
                FragmentCrop.this.okCrop();
            } else {
                FragmentCrop.this.cancelCrop();
            }
        }
    }

    public void setCropListener(CropListener listener) {
        this.cropListener = listener;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setRetainInstance(true);
        if (savedInstanceState != null) {
        }
        return inflater.inflate(R.layout.fragment_crop, container, false);
    }

    public void onAttach(Activity act) {
        super.onAttach(act);
        this.context = getActivity();
        this.activity = getActivity();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void setBitmap(Bitmap btm) {
        this.btm = btm;
    }

    public void onStart() {
        super.onStart();
        this.inputPath = null;
        this.outputPath = null;
        this.isHDR = true;
        this.cropView = new CropView(this.context, this.inputPath, getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, this.btm, 1);
        RelativeLayout rl = (RelativeLayout) getView().findViewById(R.id.crop_view_container);
        LayoutParams rllp = new LayoutParams(-2, -2);
        rllp.addRule(14, -1);
        rllp.addRule(15, -1);
        rl.addView(this.cropView, rllp);
        this.ratioButtonList = new Button[11];
        this.ratioButtonList[0] = (Button) getView().findViewById(R.id.button1);
        this.ratioButtonList[1] = (Button) getView().findViewById(R.id.button2);
        this.ratioButtonList[2] = (Button) getView().findViewById(R.id.button3);
        this.ratioButtonList[3] = (Button) getView().findViewById(R.id.button4);
        this.ratioButtonList[4] = (Button) getView().findViewById(R.id.button5);
        this.ratioButtonList[5] = (Button) getView().findViewById(R.id.button6);
        this.ratioButtonList[6] = (Button) getView().findViewById(R.id.button7);
        this.ratioButtonList[7] = (Button) getView().findViewById(R.id.button8);
        this.ratioButtonList[8] = (Button) getView().findViewById(R.id.button9);
        this.ratioButtonList[9] = (Button) getView().findViewById(R.id.button10);
        this.ratioButtonList[10] = (Button) getView().findViewById(R.id.button11);
        for (Button onClickListener : this.ratioButtonList) {
            onClickListener.setOnClickListener(this.onClickListener);
        }
        ((Button) getView().findViewById(R.id.button_ok)).setOnClickListener(this.onClickListener);
        getView().findViewById(R.id.button_apply_action).setOnClickListener(this.onClickListener);
        getView().findViewById(R.id.button_cancel_action).setOnClickListener(this.onClickListener);
        setRatioButtonListBackgroundColor(0);
        this.cropView.setMode(0);
    }

    public void onBackPressed() {
        this.cropListener.cropCancelled();
    }

    void setRatioButtonListBackgroundColor(int index) {
        for (int i = 0; i < this.ratioButtonList.length; i++) {
            this.ratioButtonList[i].setBackgroundResource(R.drawable.crop_border);
            this.ratioButtonList[i].setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        this.ratioButtonList[index].setBackgroundResource(R.drawable.crop_border_selected);
        this.ratioButtonList[index].setTextColor(-1);
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
            okCrop();
        } else if (id == R.id.button_cancel_action) {
            cancelCrop();
        }
    }

    private void cancelCrop() {
        if (this.isHDR) {
            this.cropListener.cropCancelled();
        }
    }

    private void okCrop() {
        if (this.isHDR) {
            this.cropListener.cropApply(this.cropView.getLeftPos(), this.cropView.getTopPos(), this.cropView.getRightPos(), this.cropView.getBottomPos());
        }
    }
}
