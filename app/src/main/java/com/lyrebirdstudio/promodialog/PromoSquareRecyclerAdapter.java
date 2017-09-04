package com.lyrebirdstudio.promodialog;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lyrebirdstudio.R;

import java.util.Collections;
import java.util.List;

public class PromoSquareRecyclerAdapter extends RecyclerView.Adapter<PromoSquareRecyclerAdapter.PromoSquareViewHolder> {
    Context context;
    List<PromoSquareModel> list = Collections.emptyList();

    public PromoSquareRecyclerAdapter(List<PromoSquareModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public PromoSquareViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.promo_recycler_item, parent, false);
        final PromoSquareViewHolder holder = new PromoSquareViewHolder(v);
        v.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String packageName = ((PromoSquareModel) PromoSquareRecyclerAdapter.this.list.get(holder.getAdapterPosition())).packageName;
                try {
                    Intent intent = PromoSquareRecyclerAdapter.this.context.getPackageManager().getLaunchIntentForPackage(packageName);
                    if (intent == null) {
                        intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse("market://details?id=" + packageName));
                    }
                    PromoSquareRecyclerAdapter.this.context.startActivity(intent);
                } catch (Exception e) {
                }
            }
        });
        return holder;
    }

    public void onBindViewHolder(PromoSquareViewHolder holder, int position) {
        holder.promoSquareImageView.setImageResource(((PromoSquareModel) this.list.get(position)).imageId);
        holder.promoSquareText.setText(((PromoSquareModel) this.list.get(position)).message);
    }

    public int getItemCount() {
        return this.list.size();
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void insert(int position, PromoSquareModel data) {
        this.list.add(position, data);
        notifyItemInserted(position);
    }

    public void remove(PromoSquareModel data) {
        int position = this.list.indexOf(data);
        this.list.remove(position);
        notifyItemRemoved(position);
    }

     class PromoSquareViewHolder extends RecyclerView.ViewHolder {
        ImageView promoSquareButton;
        ImageView promoSquareImageView;
        TextView promoSquareText;

        public PromoSquareViewHolder(View itemView) {
            super(itemView);
            this.promoSquareImageView = (ImageView) itemView.findViewById(R.id.promo_square_image);
            this.promoSquareText = (TextView) itemView.findViewById(R.id.promo_square_text);
        }
    }
}
