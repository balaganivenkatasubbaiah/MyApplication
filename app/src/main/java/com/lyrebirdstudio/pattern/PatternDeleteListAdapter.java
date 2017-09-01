package com.lyrebirdstudio.pattern;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lyrebirdstudio.R;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class PatternDeleteListAdapter extends Adapter<PatternDeleteListAdapter.MyViewHolder> {
    List<String> data = Collections.emptyList();
    private LayoutInflater inflater;
    ItemSelectedListener itemSelectedListener;

    public interface ItemSelectedListener {
        void onItemSelected(int i);
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements OnClickListener {
        ImageView articleImage;
        ImageView deleteButton;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.articleImage = (ImageView) itemView.findViewById(R.id.pattern_delete_image_view);
            this.deleteButton = (ImageView) itemView.findViewById(R.id.pattern_delete_row_button);
            this.deleteButton.setOnClickListener(this);
        }

        public void onClick(View v) {
            PatternDeleteListAdapter.this.itemSelectedListener.onItemSelected(getAdapterPosition());
        }
    }

    public void setItemSelectedListener(ItemSelectedListener itemSelectedListener) {
        this.itemSelectedListener = itemSelectedListener;
    }

    public PatternDeleteListAdapter(Context context, List<String> data) {
        this.inflater = LayoutInflater.from(context);
        this.data = data;
    }

    public void setData(List<String> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(this.inflater.inflate(R.layout.pattern_delete_row_layout, viewGroup, false));
    }

    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        File f = new File((String) this.data.get(i));
        if (f != null) {
            File[] files = f.listFiles();
            if (files != null && files.length > 0) {
                for (File s : files) {
                    String filePath = s.getAbsolutePath();
                    if (filePath.contains("preview")) {
                        myViewHolder.articleImage.setImageBitmap(BitmapFactory.decodeFile(filePath));
                    } else if (filePath.contains("icon")) {
                        myViewHolder.articleImage.setImageBitmap(BitmapFactory.decodeFile(filePath));
                    }
                }
            }
        }
    }

    public int getItemCount() {
        return this.data.size();
    }
}
