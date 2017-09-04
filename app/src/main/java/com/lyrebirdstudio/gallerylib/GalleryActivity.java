package com.lyrebirdstudio.gallerylib;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lyrebirdstudio.R;

import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends Activity implements OnItemClickListener {
    public static final int COLLAGE_IMAGE_LIMIT = 9;
    private static final String TAG = GalleryActivity.class.getSimpleName();
    Activity activity = this;
    MyGridAdapter adapter;
    List<Album> albumList;
    Button buttonFooterCounter;
    Context context = this;
    LinearLayout footer;
    GridView gridView;
    TextView headerText;
    boolean isOnBucket = true;
    int selectedBucketId;
    List<Long> selectedImageIdList = new ArrayList();
    List<Integer> selectedImageOrientationList = new ArrayList();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        setContentView(R.layout.fragment_gallery);
        this.footer = (LinearLayout) findViewById(R.id.selected_image_linear);
        this.headerText = (TextView) findViewById(R.id.textView_header);
        this.buttonFooterCounter = (Button) findViewById(R.id.button_footer_count);
        logGalleryFolders();
        setGridAdapter();
    }

    private void setGridAdapter() {
        this.gridView = (GridView) findViewById(R.id.gridView);
        this.adapter = new MyGridAdapter(this.context, ((Album) this.albumList.get(this.albumList.size() - 1)).gridItems, this.gridView);
        this.gridView.setAdapter(this.adapter);
        this.gridView.setOnItemClickListener(this);
    }

    private List<GridViewItem> createGridItemsOnClick(int position) {
        List<GridViewItem> items = new ArrayList();
        Album album = (Album) this.albumList.get(position);
        List<Long> imageIdList = album.imageIdList;
        List<Integer> orientList = album.orientationList;
        for (int i = 0; i < imageIdList.size(); i++) {
            items.add(new GridViewItem(this.activity, "", 0, false, ((Long) imageIdList.get(i)).longValue(), ((Integer) orientList.get(i)).intValue()));
        }
        return items;
    }

    private void logGalleryFolders() {
        int i;
        this.albumList = new ArrayList();
        List<Integer> bucketIdList = new ArrayList();
        ContentResolver contentResolver = getContentResolver();
        Cursor cur = contentResolver.query(Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "bucket_display_name", "bucket_id", "_id", "orientation"}, "1) GROUP BY 1,(2", null, "date_modified DESC");
        if (cur.moveToFirst()) {
            int bucketColumn = cur.getColumnIndex("bucket_display_name");
            int bucketId = cur.getColumnIndex("bucket_id");
            int imageId = cur.getColumnIndex("_id");
            int orientationColumnIndex = cur.getColumnIndex("orientation");
            do {
                Album album = new Album();
                int id = cur.getInt(bucketId);
                album.ID = id;
                if (bucketIdList.contains(Integer.valueOf(id))) {
                    Album albumFromList = (Album) this.albumList.get(bucketIdList.indexOf(Integer.valueOf(album.ID)));
                    albumFromList.imageIdList.add(Long.valueOf(cur.getLong(imageId)));
                    albumFromList.orientationList.add(Integer.valueOf(cur.getInt(orientationColumnIndex)));
                } else {
                    String bucket = cur.getString(bucketColumn);
                    bucketIdList.add(Integer.valueOf(id));
                    album.name = bucket;
                    album.imageIdForThumb = cur.getLong(imageId);
                    album.imageIdList.add(Long.valueOf(album.imageIdForThumb));
                    this.albumList.add(album);
                    album.orientationList.add(Integer.valueOf(cur.getInt(orientationColumnIndex)));
                }
            } while (cur.moveToNext());
        }
        List<GridViewItem> items = new ArrayList();
        for (i = 0; i < this.albumList.size(); i++) {
            items.add(new GridViewItem(this.activity, ((Album) this.albumList.get(i)).name, ((Album) this.albumList.get(i)).imageIdList.size(), true, ((Album) this.albumList.get(i)).imageIdForThumb, ((Integer) ((Album) this.albumList.get(i)).orientationList.get(0)).intValue()));
        }
        this.albumList.add(new Album());
        ((Album) this.albumList.get(this.albumList.size() - 1)).gridItems = items;
        for (i = 0; i < this.albumList.size() - 1; i++) {
            ((Album) this.albumList.get(i)).gridItems = createGridItemsOnClick(i);
        }
    }

    public void onBackPressed() {
        backtrace();
    }

    void backtrace() {
        if (this.isOnBucket) {
            finish();
            return;
        }
        this.adapter.items = ((Album) this.albumList.get(this.albumList.size() - 1)).gridItems;
        this.adapter.notifyDataSetChanged();
        this.gridView.smoothScrollToPosition(0);
        this.isOnBucket = true;
        this.headerText.setText(getString(R.string.gallery_select_an_album));
    }

    public void onItemClick(AdapterView<?> adapterView, View arg1, int location, long arg3) {
        if (this.isOnBucket) {
            this.adapter.items = ((Album) this.albumList.get(location)).gridItems;
            this.adapter.notifyDataSetChanged();
            this.gridView.smoothScrollToPosition(0);
            this.isOnBucket = false;
            this.selectedBucketId = location;
            this.headerText.setText(((Album) this.albumList.get(location)).name);
            return;
        }
        if (this.footer.getChildCount() >= 9) {
            Toast msg = Toast.makeText(this.context, String.format(getString(R.string.gallery_no_more), new Object[]{Integer.valueOf(9)}), 1);
            msg.setGravity(17, msg.getXOffset() / 2, msg.getYOffset() / 2);
            msg.show();
        } else {
            View retval = LayoutInflater.from(this.context).inflate(R.layout.footer_item, null);
            ImageView im = (ImageView) retval.findViewById(R.id.imageView);
            long id = ((Long) ((Album) this.albumList.get(this.selectedBucketId)).imageIdList.get(location)).longValue();
            this.selectedImageIdList.add(Long.valueOf(id));
            this.selectedImageOrientationList.add(((Album) this.albumList.get(this.selectedBucketId)).orientationList.get(location));
            Bitmap bm = GalleryUtility.getThumbnailBitmap(this.context, id, ((Integer) ((Album) this.albumList.get(this.selectedBucketId)).orientationList.get(location)).intValue());
            if (bm != null) {
                im.setImageBitmap(bm);
            }
            this.footer.addView(retval);
            this.buttonFooterCounter.setText("" + this.footer.getChildCount());
        }
        if (!this.isOnBucket) {
            GridViewItem gridViewItem = (GridViewItem) this.adapter.items.get(location);
            gridViewItem.selectedItemCount++;
            TextView text = (TextView) arg1.findViewById(R.id.textViewSelectedItemCount);
            text.setText("" + ((GridViewItem) this.adapter.items.get(location)).selectedItemCount);
            if (text.getVisibility() == 4) {
                text.setVisibility(0);
            }
        }
    }

    Point findItemById(long id) {
        for (int i = 0; i < this.albumList.size() - 1; i++) {
            List<GridViewItem> list = ((Album) this.albumList.get(i)).gridItems;
            for (int j = 0; j < list.size(); j++) {
                if (((GridViewItem) list.get(j)).imageIdForThumb == id) {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

    public void myClickHandler(View view) {
        int id = view.getId();
        if (id == R.id.textView_header) {
            backtrace();
        }
        if (id == R.id.button_footer_count && this.buttonFooterCounter == null) {
            this.buttonFooterCounter = (Button) findViewById(R.id.button_footer_count);
        }
        if (id == R.id.imageView_delete) {
            View parent = (View) view.getParent();
            int location = ((ViewGroup) parent.getParent()).indexOfChild(parent);
            this.footer.removeView(parent);
            this.buttonFooterCounter.setText("" + this.footer.getChildCount());
            long imageid = ((Long) this.selectedImageIdList.remove(location)).longValue();
            this.selectedImageOrientationList.remove(location);
            Point index = findItemById(imageid);
            if (index != null) {
                GridViewItem gridViewItem = (GridViewItem) ((Album) this.albumList.get(index.x)).gridItems.get(index.y);
                gridViewItem.selectedItemCount--;
            }
            int value = ((GridViewItem) ((Album) this.albumList.get(index.x)).gridItems.get(index.y)).selectedItemCount;
            if (((Album) this.albumList.get(index.x)).gridItems == this.adapter.items && this.gridView.getFirstVisiblePosition() <= index.y && index.y <= this.gridView.getLastVisiblePosition() && this.gridView.getChildAt(index.y) != null) {
                TextView text = (TextView) this.gridView.getChildAt(index.y).findViewById(R.id.textViewSelectedItemCount);
                text.setText("" + value);
                if (value <= 0 && text.getVisibility() == 0) {
                    text.setVisibility(4);
                }
            }
        }
        if (id == R.id.button_footer_count) {
            int i;
            Intent in = new Intent();
            int size = this.selectedImageIdList.size();
            long[] arrr = new long[size];
            for (i = 0; i < size; i++) {
                arrr[i] = ((Long) this.selectedImageIdList.get(i)).longValue();
            }
            int[] orientationArr = new int[size];
            for (i = 0; i < size; i++) {
                orientationArr[i] = ((Integer) this.selectedImageOrientationList.get(i)).intValue();
            }
            in.putExtra("photo_id_list", arrr);
            in.putExtra("photo_orientation_list", orientationArr);
            setResult(RESULT_OK, in);
            finish();
        }
    }
}
