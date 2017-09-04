package com.lyrebirdstudio.canvastext;

import android.app.Activity;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView.BufferType;
import android.widget.Toast;

import com.lyrebirdstudio.R;

public class TextLibFragment extends Fragment {
    String TAG = "TextLibFragment";
    int TOOL_MODE_BG_COLOR = 3;
    int TOOL_MODE_COLOR = 2;
    int TOOL_MODE_FONT = 1;
    int TOOL_MODE_KEYBOARD = 0;
    Activity activity;
    int alignCount = 0;
    ImageView buttonAlign;
    ImageView buttonBgColor;
    ImageView buttonColor;
    ImageView buttonFont;
    ImageView buttonKeyboard;
    ImageView buttonOk;
    View containerBgColor;
    GridViewAdapter customGridAdapter;
    MyEditText editText;
    GridView gridViewBgColors;
    View gridViewColorContainer;
    GridView gridViewColors;
    GridView gridViewFont;
    OnClickListener myOnClickListener = new C05957();
    OnSeekBarChangeListener onSeekBarChangeListener = new C05968();
    TextData textDataLocal;
    TextStyledListener textStyledListener;
    View[] toolButtonList = new View[4];

    class C05891 implements OnItemClickListener {
        C05891() {
        }

        public void onItemClick(AdapterView<?> adapterView, View v, int position, long arg3) {
            Typeface typeFace = FontCache.get(TextLibFragment.this.activity, TextLibHelper.fontPathList[position]);
            if (typeFace != null) {
                TextLibFragment.this.editText.setTypeface(typeFace);
            }
            TextLibFragment.this.textDataLocal.setTextFont(TextLibHelper.fontPathList[position], TextLibFragment.this.activity);
        }
    }

    class C05913 implements TextWatcher {
        C05913() {
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence message, int start, int before, int count) {
            String str;
            if (message.toString().compareToIgnoreCase("") != 0) {
                str = message.toString();
            } else {
                str = TextData.defaultMessage;
            }
            TextLibFragment.this.textDataLocal.message = str;
        }

        public void afterTextChanged(Editable s) {
        }
    }

    class C05924 implements OnTouchListener {
        C05924() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            if (1 == event.getAction()) {
                TextLibFragment.this.setVisibiltyMode(TextLibFragment.this.TOOL_MODE_KEYBOARD);
            }
            return false;
        }
    }

    class C05935 implements OnItemClickListener {
        C05935() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            TextLibFragment.this.textDataLocal.setBackgroundColor(((Integer) TextLibFragment.this.gridViewBgColors.getItemAtPosition(position)).intValue());
            TextLibFragment.this.editText.setBackgroundColor(TextLibFragment.this.textDataLocal.getBackgroundColorFinal());
        }
    }

    class C05946 implements OnItemClickListener {
        C05946() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            TextLibFragment.this.editText.setTextColor(TextLibFragment.this.textDataLocal.setTextColor(((Integer) TextLibFragment.this.gridViewColors.getItemAtPosition(position)).intValue()));
        }
    }

    class C05957 implements OnClickListener {
        C05957() {
        }

        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.text_lib_font) {
                ((InputMethodManager) TextLibFragment.this.activity.getSystemService("input_method")).hideSoftInputFromWindow(TextLibFragment.this.editText.getWindowToken(), 0);
                TextLibFragment.this.setVisibiltyMode(TextLibFragment.this.TOOL_MODE_FONT);
            } else if (id == R.id.text_lib_keyboard) {
                TextLibFragment.this.setVisibiltyMode(TextLibFragment.this.TOOL_MODE_KEYBOARD);
                ((InputMethodManager) TextLibFragment.this.activity.getSystemService("input_method")).toggleSoftInput(2, 1);
            } else if (id == R.id.text_lib_color) {
                ((InputMethodManager) TextLibFragment.this.activity.getSystemService("input_method")).hideSoftInputFromWindow(TextLibFragment.this.editText.getWindowToken(), 0);
                TextLibFragment.this.setVisibiltyMode(TextLibFragment.this.TOOL_MODE_COLOR);
            } else if (id == R.id.text_lib_bg_color) {
                ((InputMethodManager) TextLibFragment.this.activity.getSystemService("input_method")).hideSoftInputFromWindow(TextLibFragment.this.editText.getWindowToken(), 0);
                TextLibFragment.this.setVisibiltyMode(TextLibFragment.this.TOOL_MODE_BG_COLOR);
            } else if (id == R.id.text_lib_align) {
                TextLibFragment textLibFragment = TextLibFragment.this;
                textLibFragment.alignCount++;
                TextLibFragment.this.setAlignState(TextLibFragment.this.alignCount % 3);
            } else if (id == R.id.text_lib_ok) {
                String newMessage = TextLibFragment.this.textDataLocal.message;
                if (newMessage.compareToIgnoreCase(TextData.defaultMessage) == 0 || newMessage.length() == 0) {
                    if (TextLibFragment.this.activity == null) {
                        TextLibFragment.this.activity = TextLibFragment.this.getActivity();
                    }
                    Toast msg = Toast.makeText(TextLibFragment.this.activity, TextLibFragment.this.getString(R.string.canvas_text_enter_text), 1);
                    msg.setGravity(17, msg.getXOffset() / 2, msg.getYOffset() / 2);
                    msg.show();
                    return;
                }
                if (newMessage.length() == 0) {
                    TextLibFragment.this.textDataLocal.message = TextData.defaultMessage;
                } else {
                    TextLibFragment.this.textDataLocal.message = newMessage;
                }
                if (TextLibFragment.this.textStyledListener != null) {
                    TextLibFragment.this.textStyledListener.onOk(TextLibFragment.this.textDataLocal);
                }
                ((InputMethodManager) TextLibFragment.this.activity.getSystemService("input_method")).hideSoftInputFromWindow(TextLibFragment.this.editText.getWindowToken(), 0);
            } else if (id != R.id.text_lib_edittext) {
            }
        }
    }

    class C05968 implements OnSeekBarChangeListener {
        C05968() {
        }

        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            int id = seekBar.getId();
            if (id == R.id.seekbar_text_color_opacity) {
                if (progress >= 0 && progress <= 255) {
                    TextLibFragment.this.textDataLocal.textPaint.setAlpha(progress);
                    TextLibFragment.this.editText.setTextColor(TextLibFragment.this.textDataLocal.textPaint.getColor());
                }
            } else if (id == R.id.seekbar_text_background_color_opacity && progress >= 0 && progress <= 255) {
                TextLibFragment.this.textDataLocal.setBackgroundAlpha(progress);
                TextLibFragment.this.editText.setBackgroundColor(TextLibFragment.this.textDataLocal.getBackgroundColorFinal());
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    public interface TextStyledListener {
        void onCancel();

        void onOk(TextData textData);
    }

    public void setTextStyledListener(TextStyledListener l) {
        this.textStyledListener = l;
    }

    public static TextLibFragment newInstance(String param1, String param2) {
        TextLibFragment fragment = new TextLibFragment();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(this.TAG, "is visible " + isVisible());
        Log.e(this.TAG, "text fragment onActivityCreated");
        if (isVisible()) {
            ((InputMethodManager) this.activity.getSystemService("input_method")).toggleSoftInput(2, 1);
            ((InputMethodManager) getActivity().getSystemService("input_method")).showSoftInput(this.editText, 1);
        }
    }

    public void onResume() {
        super.onResume();
        this.editText.requestFocus();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_canvas_text, container, false);
        this.activity = getActivity();
        SeekBar seekBarColorOpacity = (SeekBar) fragmentView.findViewById(R.id.seekbar_text_color_opacity);
        seekBarColorOpacity.setOnSeekBarChangeListener(this.onSeekBarChangeListener);
        SeekBar seekBarBgColorOpacity = (SeekBar) fragmentView.findViewById(R.id.seekbar_text_background_color_opacity);
        seekBarBgColorOpacity.setOnSeekBarChangeListener(this.onSeekBarChangeListener);
        this.buttonKeyboard = (ImageView) fragmentView.findViewById(R.id.text_lib_keyboard);
        this.buttonFont = (ImageView) fragmentView.findViewById(R.id.text_lib_font);
        this.buttonColor = (ImageView) fragmentView.findViewById(R.id.text_lib_color);
        this.buttonBgColor = (ImageView) fragmentView.findViewById(R.id.text_lib_bg_color);
        this.buttonAlign = (ImageView) fragmentView.findViewById(R.id.text_lib_align);
        this.buttonOk = (ImageView) fragmentView.findViewById(R.id.text_lib_ok);
        this.toolButtonList[0] = this.buttonKeyboard;
        this.toolButtonList[1] = this.buttonFont;
        this.toolButtonList[2] = this.buttonColor;
        this.toolButtonList[3] = this.buttonBgColor;
        this.buttonKeyboard.setOnClickListener(this.myOnClickListener);
        this.buttonFont.setOnClickListener(this.myOnClickListener);
        this.buttonColor.setOnClickListener(this.myOnClickListener);
        this.buttonBgColor.setOnClickListener(this.myOnClickListener);
        this.buttonAlign.setOnClickListener(this.myOnClickListener);
        this.buttonOk.setOnClickListener(this.myOnClickListener);
        this.editText = (MyEditText) fragmentView.findViewById(R.id.text_lib_edittext);
        this.editText.setInputType((this.editText.getInputType() | 524288) | 176);
        Bundle extras = getArguments();
        if (extras != null) {
            TextData mTextData = (TextData) extras.getSerializable("text_data");
            if (mTextData == null) {
                mTextData = new TextData(this.activity.getResources().getDimension(R.dimen.myFontSize));
                float screenWidth = (float) getResources().getDisplayMetrics().widthPixels;
                float screenHeight = (float) getResources().getDisplayMetrics().heightPixels;
                Rect r = new Rect();
                mTextData.textPaint.getTextBounds(TextData.defaultMessage, 0, TextData.defaultMessage.length(), r);
                mTextData.xPos = (screenWidth / 2.0f) - ((float) (r.width() / 2));
                mTextData.yPos = screenHeight / 3.0f;
                this.editText.setText("");
                this.textDataLocal = new TextData();
                this.textDataLocal.set(mTextData);
            } else {
                this.textDataLocal = new TextData();
                this.textDataLocal.set(mTextData);
                if (!this.textDataLocal.message.equals(TextData.defaultMessage)) {
                    this.editText.setText(this.textDataLocal.message, BufferType.EDITABLE);
                }
                setAlignState(MyPaint.alignValue(this.textDataLocal.textPaint));
                Log.e(this.TAG, this.textDataLocal.message);
                this.editText.setTextColor(this.textDataLocal.textPaint.getColor());
                this.editText.setText(this.textDataLocal.message);
                if (this.textDataLocal.getFontPath() != null) {
                    this.textDataLocal.setTextFont(this.textDataLocal.getFontPath(), this.activity);
                    Typeface typeFace = FontCache.get(this.activity, this.textDataLocal.getFontPath());
                    if (typeFace != null) {
                        this.editText.setTypeface(typeFace);
                    }
                }
                seekBarBgColorOpacity.setProgress(this.textDataLocal.getBackgroundAlpha());
                seekBarColorOpacity.setProgress(this.textDataLocal.textPaint.getAlpha());
                this.editText.setBackgroundColor(this.textDataLocal.getBackgroundColorFinal());
            }
        }
        this.gridViewColorContainer = fragmentView.findViewById(R.id.gridViewColorContainer);
        this.containerBgColor = fragmentView.findViewById(R.id.gridViewBackgroundColorContainer);
        this.gridViewFont = (GridView) fragmentView.findViewById(R.id.gridview_font);
        this.customGridAdapter = new GridViewAdapter(this.activity, R.layout.row_grid, TextLibHelper.fontPathList);
        this.gridViewFont.setAdapter(this.customGridAdapter);
        this.gridViewFont.setOnItemClickListener(new C05891());
        final RelativeLayout libContainer = (RelativeLayout) fragmentView.findViewById(R.id.text_lib_container);
        final RelativeLayout mainLayout = (RelativeLayout) fragmentView.findViewById(R.id.text_lib_main_layout);
        mainLayout.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                int height = mainLayout.getHeight();
                Rect r = new Rect();
                mainLayout.getWindowVisibleDisplayFrame(r);
                int heightDiff = height - (r.bottom - r.top);
                if (heightDiff > 150 && libContainer.getLayoutParams().height != heightDiff) {
                    libContainer.getLayoutParams().height = heightDiff;
                    libContainer.requestLayout();
                }
            }
        });
        this.editText.requestFocus();
        this.editText.addTextChangedListener(new C05913());
        this.editText.setFocusableInTouchMode(true);
        this.editText.setOnTouchListener(new C05924());
        ((InputMethodManager) this.activity.getSystemService("input_method")).showSoftInput(this.editText, 0);
        this.gridViewBgColors = (GridView) fragmentView.findViewById(R.id.gridViewBackgroundColor);
        this.gridViewBgColors.setAdapter(new RainbowPickerAdapter(this.activity, TextData.bgColorSentinel));
        this.gridViewBgColors.setOnItemClickListener(new C05935());
        this.gridViewColors = (GridView) fragmentView.findViewById(R.id.gridViewColor);
        this.gridViewColors.setAdapter(new RainbowPickerAdapter(this.activity, -1));
        this.gridViewColors.setOnItemClickListener(new C05946());
        return fragmentView;
    }

    void setToolbarButtonBg(int index) {
        if (this.toolButtonList != null) {
            for (View backgroundResource : this.toolButtonList) {
                backgroundResource.setBackgroundResource(R.drawable.text_lib_toolbar_button_selector);
            }
            this.toolButtonList[index].setBackgroundResource(R.color.text_lib_toolbar_button_bg_pressed);
        }
    }

    public void onDestroy() {
        if (this.customGridAdapter != null) {
            if (this.customGridAdapter.typeFaceArray != null) {
                int length = this.customGridAdapter.typeFaceArray.size();
                for (int i = 0; i < length; i++) {
                    this.customGridAdapter.typeFaceArray.set(i, null);
                }
            }
            this.customGridAdapter.typeFaceArray = null;
        }
        super.onDestroy();
    }

    public void onAttach(Activity context) {
        super.onAttach(context);
    }

    public void onDetach() {
        super.onDetach();
    }

    void setVisibiltyMode(int mode) {
        if (mode == this.TOOL_MODE_KEYBOARD) {
            this.gridViewFont.setVisibility(View.GONE);
            this.gridViewColorContainer.setVisibility(View.GONE);
            this.containerBgColor.setVisibility(View.GONE);
            setToolbarButtonBg(this.TOOL_MODE_KEYBOARD);
        } else if (mode == this.TOOL_MODE_FONT) {
            this.gridViewFont.setVisibility(View.VISIBLE);
            this.gridViewColorContainer.setVisibility(View.GONE);
            this.containerBgColor.setVisibility(View.GONE);
            setToolbarButtonBg(this.TOOL_MODE_FONT);
        } else if (mode == this.TOOL_MODE_COLOR) {
            this.gridViewFont.setVisibility(View.GONE);
            this.gridViewColorContainer.setVisibility(View.VISIBLE);
            this.containerBgColor.setVisibility(View.GONE);
            setToolbarButtonBg(this.TOOL_MODE_COLOR);
        } else if (mode == this.TOOL_MODE_BG_COLOR) {
            this.gridViewFont.setVisibility(View.GONE);
            this.gridViewColorContainer.setVisibility(View.GONE);
            this.containerBgColor.setVisibility(View.VISIBLE);
            setToolbarButtonBg(this.TOOL_MODE_BG_COLOR);
        }
    }

    void setAlignState(int alignMode) {
        this.alignCount = alignMode;
        int gravity = 3;
        Align align = Align.LEFT;
        int alignResId = R.drawable.ic_text_lib_align_left;
        if (alignMode == 1) {
            align = Align.CENTER;
            gravity = 17;
            alignResId = R.drawable.ic_text_lib_align_center;
        }
        if (alignMode == 2) {
            align = Align.RIGHT;
            gravity = 5;
            alignResId = R.drawable.ic_text_lib_align_right;
        }
        this.editText.setGravity(gravity);
        this.textDataLocal.textPaint.setTextAlign(align);
        this.buttonAlign.setImageResource(alignResId);
    }
}
