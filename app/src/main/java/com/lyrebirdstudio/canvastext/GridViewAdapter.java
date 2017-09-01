package com.lyrebirdstudio.canvastext;

import android.content.ClipData.Item;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.lyrebirdstudio.R;

import java.util.ArrayList;

public class GridViewAdapter extends ArrayAdapter<Item> {
    Context context;
    int layoutResourceId;
    ArrayList<Typeface> typeFaceArray = new ArrayList();

    public GridViewAdapter(Context context, int layoutResourceId, String[] data) {
        super(context, layoutResourceId);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        for (String str : data) {
            Typeface tf = FontCache.get(context, str);
            if (tf != null) {
                this.typeFaceArray.add(tf);
            }
        }
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.row_grid, parent, false);
        }
        ((TextView) row.findViewById(R.id.item_text)).setTypeface((Typeface) this.typeFaceArray.get(position));
        return row;
    }

    public int getCount() {
        return this.typeFaceArray.size();
    }
}
