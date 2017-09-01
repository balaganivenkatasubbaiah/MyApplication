package com.lyrebirdstudio.canvastext;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.lyrebirdstudio.R;
import com.lyrebirdstudio.sticker.StickerLibHelper;

public class TextLibTestActivity extends FragmentActivity {
    private final String TAG = TextLibTestActivity.class.getSimpleName();
    FragmentActivity activity = this;
    Context context = this;
    StickerLibHelper stickerLibHelper;
    FrameLayout textAndStickerViewContainer;
    int textFragemntContinerId = R.id.text_fragment_container;
    TextLibHelper textLibHelper;

    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_lib_test);
        this.textAndStickerViewContainer = (FrameLayout) findViewById(R.id.text_view_container);
        this.textAndStickerViewContainer.bringToFront();
        findViewById(this.textFragemntContinerId).bringToFront();
        this.textLibHelper = new TextLibHelper();
        findViewById(R.id.sticker_fragment_container).bringToFront();
        this.stickerLibHelper = new StickerLibHelper();
        if (savedInstanceState != null) {
            this.textLibHelper.hideForOncreate(this, this.textAndStickerViewContainer, this.textFragemntContinerId);
            this.textLibHelper.loadTextDataFromSavedInstance(this, savedInstanceState, this.textAndStickerViewContainer, this.textFragemntContinerId);
            this.stickerLibHelper.hideForOncreate(this, this.textAndStickerViewContainer);
            this.stickerLibHelper.loadStixckerDataFromSavedInstance(this, savedInstanceState, this.textAndStickerViewContainer);
        }
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        this.textLibHelper.saveTextDataInstance(savedInstanceState, this.textAndStickerViewContainer);
        this.stickerLibHelper.saveStickerDataInstance(savedInstanceState, this.textAndStickerViewContainer);
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    public void myClickHandler(View view) {
        int id = view.getId();
        if (id == R.id.text_lib_test_add_text) {
            this.textLibHelper.addCanvasText2(this.activity, this.textAndStickerViewContainer, this.textFragemntContinerId);
        } else if (id == R.id.text_lib_add_sticker) {
            this.stickerLibHelper.addStickerGalleryFragment(this.activity, this.textAndStickerViewContainer, R.id.sticker_fragment_container);
        }
    }

    public void onBackPressed() {
        if (!this.textLibHelper.hideOnBackPressed(this.activity) && !this.stickerLibHelper.hideOnBackPressed()) {
            finish();
        }
    }
}
