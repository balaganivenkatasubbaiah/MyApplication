package com.lyrebirdstudio.sticker;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lyrebirdstudio.R;

public class NavigationDrawerListAdapter extends BaseAdapter {
    Context context;
    NavigationDrawerItem[] navigationDrawerItemList;

    static class ViewHolderItem {
        ImageView imageViewItem;
        ImageView imageViewNewBadge;
        TextView textViewItem;

        ViewHolderItem() {
        }
    }

    public NavigationDrawerListAdapter(Context context, NavigationDrawerItem[] data) {
        this.context = context;
        this.navigationDrawerItemList = data;
    }

    public int getCount() {
        return this.navigationDrawerItemList.length;
    }

    public Object getItem(int position) {
        return this.navigationDrawerItemList;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderItem viewHolder;
        if (convertView == null) {
            convertView = ((Activity) this.context).getLayoutInflater().inflate(R.layout.sticker_nav_list_item, parent, false);
            viewHolder = new ViewHolderItem();
            viewHolder.textViewItem = (TextView) convertView.findViewById(R.id.nav_list_text);
            viewHolder.imageViewItem = (ImageView) convertView.findViewById(R.id.nav_list_image);
            viewHolder.imageViewNewBadge = (ImageView) convertView.findViewById(R.id.nav_list_new_badge);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolderItem) convertView.getTag();
        }
        viewHolder.textViewItem.setText(this.navigationDrawerItemList[position].name);
        viewHolder.imageViewItem.setImageResource(this.navigationDrawerItemList[position].resId);
        if (this.navigationDrawerItemList[position].isNew) {
            viewHolder.imageViewNewBadge.setVisibility(0);
        } else {
            viewHolder.imageViewNewBadge.setVisibility(4);
        }
        return convertView;
    }
}
