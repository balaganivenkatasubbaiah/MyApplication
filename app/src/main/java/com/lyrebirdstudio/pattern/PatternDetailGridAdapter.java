package com.lyrebirdstudio.pattern;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lyrebirdstudio.R;
import com.squareup.picasso.Picasso;

public class PatternDetailGridAdapter extends Adapter<PatternDetailGridAdapter.MyViewHolder> {
    String[] data;
    private LayoutInflater inflater;

    class MyViewHolder extends ViewHolder {
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.pattern_detail_grid_image_view);
        }
    }

    public PatternDetailGridAdapter(Context context, String[] data) {
        this.inflater = LayoutInflater.from(context);
        this.data = data;
    }

    public void setData(String[] data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(this.inflater.inflate(R.layout.pattern_detail_grid_cell, viewGroup, false));
    }

    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        Picasso.with(myViewHolder.imageView.getContext()).load(Uri.parse(this.data[i])).into(myViewHolder.imageView);
    }

    public int getItemCount() {
        return this.data.length;
    }
}
