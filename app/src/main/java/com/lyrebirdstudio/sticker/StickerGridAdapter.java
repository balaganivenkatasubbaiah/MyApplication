package com.lyrebirdstudio.sticker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.lyrebirdstudio.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.Target;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;

public class StickerGridAdapter extends BaseAdapter {
    private static final String TAG = "StickerGridAdapter";
    Context context;
    GridView gridView;
    LayoutInflater inflater;
    StickerGridItem[] itemList;
    Options option = new Options();
    Bitmap placeHolder;
    ViewHolder viewHolder;

    static class AsyncDrawable extends BitmapDrawable {
        private final WeakReference<BitmapWorkerTask> bitmapWorkerTaskReference;

        public AsyncDrawable(Resources res, Bitmap bitmap, BitmapWorkerTask bitmapWorkerTask) {
            super(res, bitmap);
            this.bitmapWorkerTaskReference = new WeakReference(bitmapWorkerTask);
        }

        public BitmapWorkerTask getBitmapWorkerTask() {
            return (BitmapWorkerTask) this.bitmapWorkerTaskReference.get();
        }
    }

    class BitmapWorkerTask extends AsyncTask<Long, Void, Bitmap> {
        private long data = 0;
        private final WeakReference<ImageView> imageViewReference;
        private int item;
        private Resources res;

        public BitmapWorkerTask(ImageView imageView, Resources res, Integer item) {
            this.imageViewReference = new WeakReference(imageView);
            this.item = item.intValue();
            this.res = res;
        }

        protected Bitmap doInBackground(Long... params) {
            this.data = params[0].longValue();
            return BitmapFactory.decodeResource(this.res, this.item, StickerGridAdapter.this.option);
        }

        protected void onPostExecute(Bitmap bitmap) {
            if (isCancelled()) {
                bitmap = null;
            }
            if (this.imageViewReference != null && bitmap != null) {
                ImageView imageView = (ImageView) this.imageViewReference.get();
                if (this == StickerGridAdapter.getBitmapWorkerTask(imageView) && imageView != null) {
                    imageView.setImageBitmap(bitmap);
                }
            }
        }
    }

    static class ViewHolder {
        ImageView imageView;
        ImageView itemSelected;

        ViewHolder() {
        }
    }

    public StickerGridAdapter(Context context, StickerGridItem[] resList, GridView gridView) {
        this.inflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.gridView = gridView;
        this.placeHolder = BitmapFactory.decodeResource(context.getResources(), R.drawable.empty_photo);
        this.context = context;
        this.option.inSampleSize = 2;
        this.itemList = resList;
    }

    public int getCount() {
        return this.itemList.length;
    }

    public StickerGridItem getItem(int position) {
        return this.itemList[position];
    }

    public void setItems(StickerGridItem[] itemList) {
        this.itemList = itemList;
    }

    public long getItemId(int position) {
        return (long) position;
    }

    @SuppressLint({"NewApi"})
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = this.inflater.inflate(R.layout.sticker_grid_item, null);
            this.viewHolder = new ViewHolder();
            this.viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            this.viewHolder.itemSelected = (ImageView) convertView.findViewById(R.id.image_view_item_selected);
            convertView.setTag(this.viewHolder);
        } else {
            this.viewHolder = (ViewHolder) convertView.getTag();
        }
        if (this.itemList[position].isOnline) {
            final String url = this.itemList[position].url;
            Log.e(TAG, url);
            File file = StickerOnlineLib.getFilePath(url.substring(url.lastIndexOf(47) + 1, url.length()), this.context, "", StickerOnlineLib.folderName);
            if (file.exists()) {
                Picasso.with(this.context).load(Uri.fromFile(file)).placeholder(R.drawable.placeholder).error(R.drawable.error).fit().tag(this.context).into(this.viewHolder.imageView);
                Log.e(TAG, "disk load from with picasso");
            } else {
                Log.e(TAG, "url  load with picasso");
                Picasso.with(this.context).load(url).placeholder(R.drawable.placeholder).error(R.drawable.error).fit().tag(this.context).into(this.viewHolder.imageView);
                Picasso.with(this.context).load(url).placeholder(R.drawable.placeholder).error(R.drawable.error).into(new Target() {
                    public void onBitmapLoaded(final Bitmap bitmap, LoadedFrom from) {
                        new Thread(new Runnable() {
                            public void run() {
                                File file = StickerOnlineLib.getFilePath(url.substring(url.lastIndexOf(47) + 1, url.length()), StickerGridAdapter.this.context, "", StickerOnlineLib.folderName);
                                if (file != null && file.getParentFile().isDirectory()) {
                                    try {
                                        file.createNewFile();
                                        FileOutputStream ostream = new FileOutputStream(file);
                                        bitmap.compress(CompressFormat.PNG, 90, ostream);
                                        ostream.close();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }).start();
                    }

                    public void onBitmapFailed(Drawable drawable) {
                    }

                    public void onPrepareLoad(Drawable drawable) {
                    }
                });
            }
        } else {
            Picasso.with(this.context).cancelRequest(this.viewHolder.imageView);
            loadBitmap((long) position, this.viewHolder.imageView, this.itemList[position].resId);
        }
        if (this.itemList[position].selectedItemCount > 0) {
            if (this.viewHolder.itemSelected.getVisibility() == 4) {
                this.viewHolder.itemSelected.setVisibility(0);
            }
        } else if (this.viewHolder.itemSelected.getVisibility() == 0) {
            this.viewHolder.itemSelected.setVisibility(4);
        }
        return convertView;
    }

    public void loadBitmap(long resId, ImageView imageView, int item) {
        if (cancelPotentialWork(resId, imageView)) {
            BitmapWorkerTask task = new BitmapWorkerTask(imageView, this.context.getResources(), Integer.valueOf(item));
            imageView.setImageDrawable(new AsyncDrawable(this.context.getResources(), this.placeHolder, task));
            task.execute(new Long[]{Long.valueOf(resId)});
        }
    }

    public static boolean cancelPotentialWork(long data, ImageView imageView) {
        BitmapWorkerTask bitmapWorkerTask = getBitmapWorkerTask(imageView);
        if (bitmapWorkerTask == null) {
            return true;
        }
        long bitmapData = bitmapWorkerTask.data;
        if (bitmapData != 0 && bitmapData == data) {
            return false;
        }
        bitmapWorkerTask.cancel(true);
        return true;
    }

    private static BitmapWorkerTask getBitmapWorkerTask(ImageView imageView) {
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof AsyncDrawable) {
                return ((AsyncDrawable) drawable).getBitmapWorkerTask();
            }
        }
        return null;
    }
}
