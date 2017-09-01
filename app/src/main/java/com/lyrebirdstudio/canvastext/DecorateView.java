package com.lyrebirdstudio.canvastext;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.lyrebirdstudio.R;

public class DecorateView extends View {
    public static final String TAG = "DecorateView";
    protected OnDecorateViewTouchUp onDecorateViewTouchUpListener;



    public interface OnDecorateViewTouchUp {
        void onTouchUp(BaseData baseData);
    }

    public DecorateView(Context context) {
        super(context);
    }

    public DecorateView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DecorateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BaseData getData() {
        return null;
    }

    public void setMatrix(MyMatrix matrix) {
    }

    public void setOnDecorateViewTouchUp(OnDecorateViewTouchUp l) {
        this.onDecorateViewTouchUpListener = l;
    }

    public boolean isDecorateViewSelected() {
        return false;
    }

    public void setDecorateViewSelected(boolean selection) {
    }

    public void onDestroy() {
    }

    public void createDeleteDialog(Context context, final View view) {
        Builder builder = new Builder(context);
        builder.setMessage(R.string.collage_lib_delete_message).setCancelable(true).setPositiveButton(context.getString(R.string.yes), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Log.e(DecorateView.TAG, "remove sticker ok");
                DecorateView.this.deleteView(view);
            }
        }).setNegativeButton(context.getString(R.string.no), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }

    public void deleteView(View view) {
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) {
            parent.removeView(view);
            onDestroy();
        }
    }

    public float containsScore(float x, float y) {
        return -2.0f;
    }

    public boolean isOnRectCheck(float x, float y) {
        return false;
    }
}
