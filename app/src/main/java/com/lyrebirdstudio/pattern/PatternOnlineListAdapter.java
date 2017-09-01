package com.lyrebirdstudio.pattern;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lyrebirdstudio.R;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

public class PatternOnlineListAdapter extends Adapter<PatternOnlineListAdapter.MyViewHolder> {
    List<PatternOnlineListItem> data = Collections.emptyList();
    private LayoutInflater inflater;
    ItemSelectedListener itemSelectedListener;

    public interface ItemSelectedListener {
        void onItemSelected(int i);
    }

    class MyViewHolder extends ViewHolder implements OnClickListener {
        ImageView articleImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.articleImage = (ImageView) itemView.findViewById(R.id.pattern_online_image_view);
            itemView.setOnClickListener(this);
        }

        public void onClick(View v) {
            PatternOnlineListAdapter.this.itemSelectedListener.onItemSelected(getAdapterPosition());
        }
    }

    public void setItemSelectedListener(ItemSelectedListener itemSelectedListener) {
        this.itemSelectedListener = itemSelectedListener;
    }

    public PatternOnlineListAdapter(Context context, List<PatternOnlineListItem> data) {
        this.inflater = LayoutInflater.from(context);
        this.data = data;
    }

    public void setData(List<PatternOnlineListItem> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(this.inflater.inflate(R.layout.pattern_online_row_layout, viewGroup, false));
    }

    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        Picasso.with(myViewHolder.articleImage.getContext()).load(Uri.parse(((PatternOnlineListItem) this.data.get(i)).imageUrl)).placeholder(R.drawable.pattern_place_holder).into(myViewHolder.articleImage);
    }

    public int getItemCount() {
        return this.data.size();
    }
}
