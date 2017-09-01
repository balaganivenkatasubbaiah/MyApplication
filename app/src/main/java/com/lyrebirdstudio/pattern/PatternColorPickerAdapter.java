package com.lyrebirdstudio.pattern;

import android.annotation.SuppressLint;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.lyrebirdstudio.R;
import com.lyrebirdstudio.pattern.PatternAdapter.CurrentCollageIndexChangedListener;

import java.util.ArrayList;
import java.util.List;

@SuppressLint({"InflateParams"})
public class PatternColorPickerAdapter extends MyRecylceAdapterBase<PatternColorPickerAdapter.ViewHolder> implements OnClickListener {
    private static final String TAG = PatternColorPickerAdapter.class.getSimpleName();
    public static int[] colors = new int[]{-1, -1057075, -3323318, -3381658, -4432552, -44215, -172461, -164754, -148300, -37302, -24439, -1409443, -4954291, -5936817, -35528, -32951, -2255755, -32189, -23436, -6323856, -3304075, -1061448, -2717095, -2184568, -350356, -12373, -17016, -140875, -23741, -1057851, -18861, -1587561, -7702179, -333899, -12472, -206475, -140435, -202621, -989039, -1250626, -4540308, -131980, -131980, -103, -3808380, -5051299, -7886485, -5708640, -14812908, -8978566, -9323400, -9589119, -6298945, -14898056, -13583729, -12202334, -12865393, -14888030, -15237011, -15368072, -14692661, -8856606, -8921625, -8332565, -12498356, -15098179, -14898743, -14832426, -6631701, -15054730, -15108910, -13931324, -14715394, -3813146, -5195834, -10651957, -6115888, -6841686, -5394986, -9214275, -9157944, -8891991, -6454854, -7180626, -3300130, -7384931, -3971899, -295171, -232195, -7453307, -57906, -57906, -46896, -1660713, -4176753, -9547424, -2276206, -48220, -629585, -215851, -17191, -568428, -21812, -1890965, -141340, -3524761, -2204285, -226900, -556895, -3655590, -1171379, -46740, -1075030, -234363, -251833, -25686, -3456684, -1184275, -2369582, -3291710, -6975092, -11184811, -14474461, -15658735, -16119286, ViewCompat.MEASURED_STATE_MASK};
    int colorCount = 60;
    int colorDefault;
    private List<Integer> colorList = new ArrayList();
    int colorSelected;
    CurrentCollageIndexChangedListener listener;
    RecyclerView recylceView;
    View selectedListItem;
    int selectedPosition;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private static final String TAG = ViewHolder.class.getSimpleName();
        public View colorPickerView;
        private int item;
        CurrentCollageIndexChangedListener viewHolderListener;

        public void setCurrentCollageIndexChangedListener(CurrentCollageIndexChangedListener l) {
            this.viewHolderListener = l;
        }

        public void setItem(int items) {
            this.item = items;
            this.colorPickerView.setBackgroundColor(this.item);
        }

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            this.colorPickerView = itemLayoutView.findViewById(R.id.color_picker_view);
        }
    }

    public PatternColorPickerAdapter(CurrentCollageIndexChangedListener l, int cDefault, int cSelected) {
        this.listener = l;
        this.colorDefault = cDefault;
        this.colorSelected = cSelected;
        createColorList();
    }

    private void createColorList() {
        for (int valueOf : colors) {
            this.colorList.add(Integer.valueOf(valueOf));
        }
    }

    public void setSelectedPositinVoid() {
        this.selectedListItem = null;
        this.selectedPosition = -1;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.color_recycler_view_item, null);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        viewHolder.setCurrentCollageIndexChangedListener(this.listener);
        itemLayoutView.setOnClickListener(this);
        return viewHolder;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.setItem(((Integer) this.colorList.get(position)).intValue());
        if (this.selectedPosition == position) {
            viewHolder.itemView.setBackgroundColor(this.colorSelected);
        } else {
            viewHolder.itemView.setBackgroundColor(this.colorDefault);
        }
    }

    public void onAttachedToRecyclerView(RecyclerView recylceView) {
        this.recylceView = recylceView;
    }

    public void onClick(View view) {
        int position = this.recylceView.getChildPosition(view);
        RecyclerView.ViewHolder oldViewHolder = this.recylceView.findViewHolderForPosition(this.selectedPosition);
        if (oldViewHolder != null) {
            View oldView = oldViewHolder.itemView;
            if (oldView != null) {
                oldView.setBackgroundColor(this.colorDefault);
            }
        }
        if (this.selectedListItem != null) {
            this.listener.onIndexChanged(((Integer) this.colorList.get(position)).intValue());
            this.selectedPosition = position;
            view.setBackgroundColor(this.colorSelected);
            this.selectedListItem = view;
        } else {
            this.listener.onIndexChanged(((Integer) this.colorList.get(position)).intValue());
            this.selectedPosition = position;
            view.setBackgroundColor(this.colorSelected);
            this.selectedListItem = view;
        }
    }

    public int getItemCount() {
        return this.colorList.size();
    }
}
