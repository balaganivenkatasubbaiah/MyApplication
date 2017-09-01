package com.lyrebirdstudio.pattern;

import android.annotation.SuppressLint;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.lyrebirdstudio.R;

import java.util.ArrayList;

@SuppressLint({"InflateParams"})
public class PatternAdapter extends MyRecylceAdapterBase<PatternAdapter.ViewHolder> implements OnClickListener {
    private static final String TAG = PatternAdapter.class.getSimpleName();
    int colorDefault;
    int colorSelected;
    CurrentCollageIndexChangedListener currentIndexlistener;
    boolean isPattern = false;
    public ArrayList<PatternItem> patternItemArrayList;
    PatternResIdChangedListener patternResIdListener;
    RecyclerView recylceView;
    View selectedListItem;
    int selectedPosition;
    boolean setSelectedView = true;

    public interface CurrentCollageIndexChangedListener {
        void onIndexChanged(int i);

        void onPatternChanged(PatternItem patternItem);
    }

    public interface PatternResIdChangedListener {
        void onPatternResIdChanged(int i);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private static final String TAG = ViewHolder.class.getSimpleName();
        public ImageView imageView;
        private PatternItem item;

        public void setItem(PatternItem item) {
            this.item = item;
            if (item.isFromOnline) {
                this.imageView.setImageBitmap(BitmapFactory.decodeFile(item.path));
                return;
            }
            this.imageView.setImageResource(item.resId);
        }

        public ViewHolder(View itemLayoutView, boolean isPattern) {
            super(itemLayoutView);
            this.imageView = (ImageView) itemLayoutView.findViewById(R.id.image_view_collage_icon);
            if (isPattern) {
                this.imageView.setScaleType(ScaleType.CENTER_CROP);
            }
        }
    }

    public PatternAdapter(ArrayList<PatternItem> patternItemArrayList, CurrentCollageIndexChangedListener l, int cDefault, int cSelected, boolean isPattern, boolean setSelectedView) {
        this.patternItemArrayList = patternItemArrayList;
        this.currentIndexlistener = l;
        this.colorDefault = cDefault;
        this.colorSelected = cSelected;
        this.isPattern = isPattern;
        this.setSelectedView = setSelectedView;
    }

    public PatternAdapter(ArrayList<PatternItem> patternItemArrayList, int cDefault, int cSelected, boolean isPattern, boolean setSelectedView) {
        this.patternItemArrayList = patternItemArrayList;
        this.colorDefault = cDefault;
        this.colorSelected = cSelected;
        this.isPattern = isPattern;
        this.setSelectedView = setSelectedView;
    }

    public void setData(ArrayList<PatternItem> patternItemArrayList) {
        this.patternItemArrayList = patternItemArrayList;
        notifyDataSetChanged();
    }

    public void addItem(PatternItem item) {
        if (item.isFromOnline) {
            int i = 0;
            while (i < this.patternItemArrayList.size()) {
                if (!((PatternItem) this.patternItemArrayList.get(i)).isFromOnline || item.path.compareTo(((PatternItem) this.patternItemArrayList.get(i)).path) != 0) {
                    i++;
                } else {
                    return;
                }
            }
        }
        this.patternItemArrayList.add(2, item);
        notifyItemInserted(2);
    }

    public void removeItem(PatternItem item) {
        if (item.isFromOnline) {
            Log.e(TAG, "item path= " + item.path);
            for (int i = 0; i < this.patternItemArrayList.size(); i++) {
                if (((PatternItem) this.patternItemArrayList.get(i)).isFromOnline) {
                    Log.e(TAG, "patternItemArrayList path= " + ((PatternItem) this.patternItemArrayList.get(i)).path);
                    if (((PatternItem) this.patternItemArrayList.get(i)).path.contains(item.path)) {
                        Log.e(TAG, "item removeItem");
                        this.patternItemArrayList.remove(i);
                        notifyItemRemoved(i);
                        return;
                    }
                }
            }
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, null);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView, this.isPattern);
        itemLayoutView.setOnClickListener(this);
        return viewHolder;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.setItem((PatternItem) this.patternItemArrayList.get(position));
        if (this.selectedPosition == position) {
            viewHolder.itemView.setBackgroundColor(this.colorSelected);
        } else {
            viewHolder.itemView.setBackgroundColor(this.colorDefault);
        }
    }

    public void onAttachedToRecyclerView(RecyclerView recylceView) {
        this.recylceView = recylceView;
    }

    public void setSelectedPositinVoid() {
        this.selectedListItem = null;
        this.selectedPosition = -1;
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
        }
        if (this.isPattern) {
            this.currentIndexlistener.onPatternChanged((PatternItem) this.patternItemArrayList.get(position));
        } else {
            this.currentIndexlistener.onIndexChanged(position);
        }
        if (this.setSelectedView) {
            this.selectedPosition = position;
            view.setBackgroundColor(this.colorSelected);
            this.selectedListItem = view;
        }
    }

    public int getItemCount() {
        return this.patternItemArrayList.size();
    }
}
