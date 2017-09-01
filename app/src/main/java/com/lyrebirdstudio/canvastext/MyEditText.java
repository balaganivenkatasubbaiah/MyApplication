package com.lyrebirdstudio.canvastext;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;

public class MyEditText extends AppCompatEditText {
    Context context;

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            ((InputMethodManager) this.context.getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
        }
        return false;
    }
}
