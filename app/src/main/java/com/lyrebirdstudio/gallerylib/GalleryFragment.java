package com.lyrebirdstudio.gallerylib;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore.Images.Media;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.lyrebirdstudio.R;
import com.lyrebirdstudio.common_libs.CommonLibrary;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment implements OnItemClickListener {
    public static int MAX_COLLAGE = 15;
    public static int MAX_SCRAPBOOK = 9;
    private static final String TAG = GalleryFragment.class.getSimpleName();
    int COLLAGE_IMAGE_LIMIT_MAX = 15;
    int COLLAGE_IMAGE_LIMIT_MIN = 0;
    Activity activity;
    AdView adWhirlLayout;
    MyGridAdapter adapter;
    List<Album> albumList;
    Button buttonFooterCounter;
    View buttonHeaderBack;
    boolean collageSingleMode = false;
    Context context;
    TextView deleteAllTv;
    OnClickListener dialogClickListener = new C06163();
    LinearLayout footer;
    GalleryListener galleryListener;
    Parcelable gridState;
    GridView gridView;
    TextView headerText;
    boolean isOnBucket = true;
    boolean isScrapBook = false;
    boolean isShape = false;
    TextView maxTv;
    TextView nextTv;
    View.OnClickListener onClickListener = new C06152();
    TextView removeAllTv;
    int selectedBucketId;
    List<Long> selectedImageIdList = new ArrayList();
    List<Integer> selectedImageOrientationList = new ArrayList();
    Animation slideInLeft;

    class C06141 implements Runnable {
        C06141() {
        }

        public void run() {
            if (GalleryFragment.this.gridState != null) {
                Log.d(GalleryFragment.TAG, "trying to restore listview state..");
                GalleryFragment.this.gridView.onRestoreInstanceState(GalleryFragment.this.gridState);
            }
        }
    }

    class C06152 implements View.OnClickListener {
        C06152() {
        }

        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.gallery_header_back_button) {
                GalleryFragment.this.backtrace();
            }
            if (id == R.id.imageView_delete) {
                View parent = (View) view.getParent();
                if (parent != null && parent.getParent() != null) {
                    int location = ((ViewGroup) parent.getParent()).indexOfChild(parent);
                    GalleryFragment.this.footer.removeView(parent);
                    GalleryFragment.this.buttonFooterCounter.setText("" + GalleryFragment.this.footer.getChildCount());
                    GalleryFragment.this.deleteAllTv.setText("(" + GalleryFragment.this.footer.getChildCount() + ")");
                    long imageid = ((Long) GalleryFragment.this.selectedImageIdList.remove(location)).longValue();
                    GalleryFragment.this.selectedImageOrientationList.remove(location);
                    Point index = GalleryFragment.this.findItemById(imageid);
                    if (index != null) {
                        GridViewItem gridViewItem = (GridViewItem) ((Album) GalleryFragment.this.albumList.get(index.x)).gridItems.get(index.y);
                        gridViewItem.selectedItemCount--;
                        int value = ((GridViewItem) ((Album) GalleryFragment.this.albumList.get(index.x)).gridItems.get(index.y)).selectedItemCount;
                        if (((Album) GalleryFragment.this.albumList.get(index.x)).gridItems == GalleryFragment.this.adapter.items && GalleryFragment.this.gridView.getFirstVisiblePosition() <= index.y && index.y <= GalleryFragment.this.gridView.getLastVisiblePosition() && GalleryFragment.this.gridView.getChildAt(index.y) != null) {
                           TextView text = (TextView) GalleryFragment.this.gridView.getChildAt(index.y).findViewById(R.id.textViewSelectedItemCount);
                            text.setText("" + value);
                            if (value <= 0 && text.getVisibility() == 0) {
                                text.setVisibility(4);
                            }
                        }
                    }
                } else {
                    return;
                }
            }
            if (id == R.id.gallery_delete_all) {
                if (GalleryFragment.this.footer != null && GalleryFragment.this.footer.getChildCount() != 0) {
                    GalleryFragment.this.removeAllTv.setVisibility(0);
                    GalleryFragment.this.maxTv.setVisibility(4);
                    GalleryFragment.this.deleteAllTv.setVisibility(4);
                    GalleryFragment.this.removeAllTv.startAnimation(GalleryFragment.this.slideInLeft);
                } else {
                    return;
                }
            }
            if (id == R.id.gallery_remove_all) {
                GalleryFragment.this.remoAll();
            }
            if (id == R.id.button_footer_count || id == R.id.gallery_next) {
                GalleryFragment.this.photosSelectFinished();
            }
        }
    }

    class C06163 implements OnClickListener {
        C06163() {
        }

        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case -1:
                    if (GalleryFragment.this.footer != null) {
                        GalleryFragment.this.footer.removeAllViews();
                        if (GalleryFragment.this.selectedImageIdList != null && GalleryFragment.this.selectedImageIdList.size() > 0) {
                            for (int i = 0; i < GalleryFragment.this.selectedImageIdList.size(); i++) {
                                Point index = GalleryFragment.this.findItemById(((Long) GalleryFragment.this.selectedImageIdList.get(i)).longValue());
                                if (index != null) {
                                    GridViewItem gridViewItem = (GridViewItem) ((Album) GalleryFragment.this.albumList.get(index.x)).gridItems.get(index.y);
                                    gridViewItem.selectedItemCount--;
                                    int value = ((GridViewItem) ((Album) GalleryFragment.this.albumList.get(index.x)).gridItems.get(index.y)).selectedItemCount;
                                    if (((Album) GalleryFragment.this.albumList.get(index.x)).gridItems == GalleryFragment.this.adapter.items && GalleryFragment.this.gridView.getFirstVisiblePosition() <= index.y && index.y <= GalleryFragment.this.gridView.getLastVisiblePosition() && GalleryFragment.this.gridView.getChildAt(index.y) != null) {
                                        TextView text = (TextView) GalleryFragment.this.gridView.getChildAt(index.y).findViewById(R.id.textViewSelectedItemCount);
                                        text.setText("" + value);
                                        if (value <= 0 && text.getVisibility() == 0) {
                                            text.setVisibility(4);
                                        }
                                    }
                                }
                            }
                        }
                        GalleryFragment.this.selectedImageIdList.clear();
                        GalleryFragment.this.selectedImageOrientationList.clear();
                        GalleryFragment.this.buttonFooterCounter.setText("" + GalleryFragment.this.footer.getChildCount());
                        GalleryFragment.this.deleteAllTv.setText("(" + GalleryFragment.this.footer.getChildCount() + ")");
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public interface GalleryListener {
        void onGalleryCancel();

        void onGalleryOkImageArray(long[] jArr, int[] iArr, boolean z, boolean z2);

        void onGalleryOkImageArrayRemoveFragment(long[] jArr, int[] iArr, boolean z, boolean z2);

        void onGalleryOkSingleImage(long j, int i, boolean z, boolean z2);
    }

    public void setGalleryListener(GalleryListener l) {
        this.galleryListener = l;
    }

    public GalleryListener getGalleryListener() {
        return this.galleryListener;
    }

    public boolean getIsScrapbook() {
        return this.isScrapBook;
    }

    public void setIsShape(boolean isShape) {
        this.isShape = isShape;
    }

    public void setIsScrapbook(boolean isScrapbook) {
        this.isScrapBook = isScrapbook;
        setLimitMax(MAX_SCRAPBOOK);
        if (this.selectedImageIdList != null && this.selectedImageIdList.size() > this.COLLAGE_IMAGE_LIMIT_MAX) {
            remoAll();
        } else if (this.footer != null && this.footer.getChildCount() > this.COLLAGE_IMAGE_LIMIT_MAX) {
            remoAll();
        }
    }

    public void setCollageSingleMode(boolean mode) {
        this.collageSingleMode = mode;
        if (mode) {
            if (this.selectedImageIdList != null) {
                for (int i = this.selectedImageIdList.size() - 1; i >= 0; i--) {
                    Point index = findItemById(((Long) this.selectedImageIdList.remove(i)).longValue());
                    if (index != null) {
                        GridViewItem gridViewItem = (GridViewItem) ((Album) this.albumList.get(index.x)).gridItems.get(index.y);
                        gridViewItem.selectedItemCount--;
                        int value = ((GridViewItem) ((Album) this.albumList.get(index.x)).gridItems.get(index.y)).selectedItemCount;
                       /* if (((Album) this.albumList.get(index.x)).gridItems == this.adapter.items && this.gridView.getFirstVisiblePosition() <= index.y && index.y <= this.gridView.getLastVisiblePosition() && this.gridView.getChildAt(index.y) != null) {
                            TextView text = (TextView) this.gridView.getChildAt(index.y).findViewById(R.id.textViewSelectedItemCount);
                            text.setText("" + value);
                            if (value <= 0 && text.getVisibility() == 0) {
                                text.setVisibility(4);
                            }
                        }*/
                    }
                }
            }
            if (this.selectedImageOrientationList != null) {
                this.selectedImageOrientationList.clear();
            }
            if (this.footer != null) {
                this.footer.removeAllViews();
            }
            if (this.buttonFooterCounter != null) {
                this.buttonFooterCounter.setText("0");
            }
            if (this.deleteAllTv != null) {
                this.deleteAllTv.setText("(0)");
            }
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_gallery, container, false);
        this.buttonHeaderBack = fragmentView.findViewById(R.id.gallery_header_back_button);
        this.buttonHeaderBack.setOnClickListener(this.onClickListener);
        this.footer = (LinearLayout) fragmentView.findViewById(R.id.selected_image_linear);
        this.headerText = (TextView) fragmentView.findViewById(R.id.textView_header);
        this.buttonFooterCounter = (Button) fragmentView.findViewById(R.id.button_footer_count);
        this.deleteAllTv = (TextView) fragmentView.findViewById(R.id.gallery_delete_all);
        this.removeAllTv = (TextView) fragmentView.findViewById(R.id.gallery_remove_all);
        this.maxTv = (TextView) fragmentView.findViewById(R.id.gallery_max);
        this.nextTv = (TextView) fragmentView.findViewById(R.id.gallery_next);
        this.buttonFooterCounter.setOnClickListener(this.onClickListener);
        this.deleteAllTv.setOnClickListener(this.onClickListener);
        this.nextTv.setOnClickListener(this.onClickListener);
        this.removeAllTv.setOnClickListener(this.onClickListener);
        this.slideInLeft = AnimationUtils.loadAnimation(this.context, R.anim.slide_in_left);
        if (!CommonLibrary.isAppPro(getActivity())) {
            this.adWhirlLayout = new AdView(fragmentView.getContext());
            this.adWhirlLayout.setBackgroundColor(-2435373);
            this.adWhirlLayout.setAdUnitId(getString(R.string.admob_id));
            this.adWhirlLayout.setAdSize(AdSize.SMART_BANNER);
            this.adWhirlLayout.setMinimumHeight((int) (50.0f * getResources().getDisplayMetrics().density));
            this.adWhirlLayout.loadAd(new Builder().build());
            ((ViewGroup) fragmentView).addView(this.adWhirlLayout);
        }
        this.maxTv.setText(String.format(getString(R.string.gallery_lib_max), new Object[]{Integer.valueOf(getLimitMax())}));
        return fragmentView;
    }

    public void onDestroyView() {
        if (this.adWhirlLayout != null) {
            this.adWhirlLayout.removeAllViews();
            this.adWhirlLayout.destroy();
        }
        super.onDestroyView();
    }

    public void onAttach(Activity act) {
        super.onAttach(act);
        this.context = getActivity();
        this.activity = getActivity();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void onResume() {
        super.onResume();
        if (this.gridView != null) {
            try {
                this.gridState = this.gridView.onSaveInstanceState();
            } catch (Exception e) {
            }
        }
        logGalleryFolders();
        updateListForSelection();
        setGridAdapter();
        if (!this.isOnBucket && this.albumList != null && this.selectedBucketId >= 0 && this.selectedBucketId < this.albumList.size()) {
            this.adapter.items = ((Album) this.albumList.get(this.selectedBucketId)).gridItems;
            if (this.gridView != null) {
                this.gridView.post(new C06141());
            }
        }
        this.adapter.notifyDataSetChanged();
    }

    private void setGridAdapter() {
        this.gridView = (GridView) getView().findViewById(R.id.gridView);
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

    private boolean logGalleryFolders() {
        this.albumList = new ArrayList();
        List<Integer> bucketIdList = new ArrayList();
        ContentResolver contentResolver = this.context.getContentResolver();
        Cursor cur = contentResolver.query(Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "bucket_display_name", "bucket_id", "_id", "orientation"}, "1) GROUP BY 1,(2", null, "date_modified DESC");
        List<GridViewItem> items;
        int i;
        if (cur == null || !cur.moveToFirst()) {
            items = new ArrayList();
            for (i = 0; i < this.albumList.size(); i++) {
                items.add(new GridViewItem(this.activity, ((Album) this.albumList.get(i)).name, ((Album) this.albumList.get(i)).imageIdList.size(), true, ((Album) this.albumList.get(i)).imageIdForThumb, ((Integer) ((Album) this.albumList.get(i)).orientationList.get(0)).intValue()));
            }
            this.albumList.add(new Album());
            ((Album) this.albumList.get(this.albumList.size() - 1)).gridItems = items;
            for (i = 0; i < this.albumList.size() - 1; i++) {
                ((Album) this.albumList.get(i)).gridItems = createGridItemsOnClick(i);
            }
            return true;
        }
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
        items = new ArrayList();
        for (i = 0; i < this.albumList.size(); i++) {
            items.add(new GridViewItem(this.activity, ((Album) this.albumList.get(i)).name, ((Album) this.albumList.get(i)).imageIdList.size(), true, ((Album) this.albumList.get(i)).imageIdForThumb, ((Integer) ((Album) this.albumList.get(i)).orientationList.get(0)).intValue()));
        }
        this.albumList.add(new Album());
        ((Album) this.albumList.get(this.albumList.size() - 1)).gridItems = items;
        for (i = 0; i < this.albumList.size() - 1; i++) {
            ((Album) this.albumList.get(i)).gridItems = createGridItemsOnClick(i);
        }
        return true;
    }

    public boolean onBackPressed() {
        return backtrace();
    }

    boolean backtrace() {
        if (this.isOnBucket) {
            if (this.galleryListener != null) {
                this.galleryListener.onGalleryCancel();
            }
            return true;
        }
        this.gridView.setNumColumns(2);
        this.adapter.items = ((Album) this.albumList.get(this.albumList.size() - 1)).gridItems;
        this.adapter.notifyDataSetChanged();
        this.gridView.smoothScrollToPosition(0);
        this.isOnBucket = true;
        this.headerText.setText(getString(R.string.gallery_select_an_album));
        return false;
    }

    public void setLimitMax(int max) {
        this.COLLAGE_IMAGE_LIMIT_MAX = max;
        if (this.maxTv != null) {
            this.maxTv.setText(String.format(getString(R.string.gallery_lib_max), new Object[]{Integer.valueOf(this.COLLAGE_IMAGE_LIMIT_MAX)}));
        }
    }

    public void setLimitMin(int min) {
        this.COLLAGE_IMAGE_LIMIT_MIN = min;
    }

    public int getLimitMax() {
        return this.COLLAGE_IMAGE_LIMIT_MAX;
    }

    public int getLimitMin() {
        return this.COLLAGE_IMAGE_LIMIT_MIN;
    }

    public void onItemClick(AdapterView<?> adapterView, View arg1, int location, long arg3) {
        if (this.isOnBucket) {
            this.gridView.setNumColumns(3);
            this.adapter.items = ((Album) this.albumList.get(location)).gridItems;
            this.adapter.notifyDataSetChanged();
            this.gridView.smoothScrollToPosition(0);
            this.isOnBucket = false;
            this.selectedBucketId = location;
            this.headerText.setText(((Album) this.albumList.get(location)).name);
        } else if (this.footer.getChildCount() >= this.COLLAGE_IMAGE_LIMIT_MAX) {
            Toast msg = Toast.makeText(this.context, String.format(getString(R.string.gallery_no_more), new Object[]{Integer.valueOf(this.COLLAGE_IMAGE_LIMIT_MAX)}), 1);
            msg.setGravity(17, msg.getXOffset() / 2, msg.getYOffset() / 2);
            msg.show();
        } else {
            View retval = LayoutInflater.from(this.context).inflate(R.layout.footer_item, null);
            ((ImageView) retval.findViewById(R.id.imageView_delete)).setOnClickListener(this.onClickListener);
            ImageView im = (ImageView) retval.findViewById(R.id.imageView);
            if (this.selectedBucketId >= 0 && this.selectedBucketId < this.albumList.size() && location >= 0 && location < ((Album) this.albumList.get(this.selectedBucketId)).imageIdList.size()) {
                long id = ((Long) ((Album) this.albumList.get(this.selectedBucketId)).imageIdList.get(location)).longValue();
                this.selectedImageIdList.add(Long.valueOf(id));
                this.selectedImageOrientationList.add(((Album) this.albumList.get(this.selectedBucketId)).orientationList.get(location));
                Bitmap bm = GalleryUtility.getThumbnailBitmap(this.context, id, ((Integer) ((Album) this.albumList.get(this.selectedBucketId)).orientationList.get(location)).intValue());
                if (bm != null) {
                    im.setImageBitmap(bm);
                }
                this.footer.addView(retval);
                this.buttonFooterCounter.setText("" + this.footer.getChildCount());
                this.deleteAllTv.setText("(" + this.footer.getChildCount() + ")");
                GridViewItem gridViewItem = (GridViewItem) this.adapter.items.get(location);
                gridViewItem.selectedItemCount++;
                TextView text = (TextView) arg1.findViewById(R.id.textViewSelectedItemCount);
                text.setText("" + ((GridViewItem) this.adapter.items.get(location)).selectedItemCount);
                if (text.getVisibility() == 4) {
                    text.setVisibility(0);
                }
                if (this.collageSingleMode) {
                    photosSelectFinished();
                    this.collageSingleMode = false;
                }
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

    void updateListForSelection() {
        if (this.selectedImageIdList != null && !this.selectedImageIdList.isEmpty()) {
            for (int i = 0; i < this.selectedImageIdList.size(); i++) {
                Point index = findItemById(((Long) this.selectedImageIdList.get(i)).longValue());
                if (index != null) {
                    GridViewItem gridViewItem = (GridViewItem) ((Album) this.albumList.get(index.x)).gridItems.get(index.y);
                    gridViewItem.selectedItemCount++;
                }
            }
        }
    }

    void remoAll() {
        if (this.footer != null) {
            this.footer.removeAllViews();
            if (this.selectedImageIdList != null && this.selectedImageIdList.size() > 0) {
                for (int i = 0; i < this.selectedImageIdList.size(); i++) {
                    Point index = findItemById(((Long) this.selectedImageIdList.get(i)).longValue());
                    if (index != null) {
                        GridViewItem gridViewItem = (GridViewItem) ((Album) this.albumList.get(index.x)).gridItems.get(index.y);
                        gridViewItem.selectedItemCount--;
                        int value = ((GridViewItem) ((Album) this.albumList.get(index.x)).gridItems.get(index.y)).selectedItemCount;
                        if (((Album) this.albumList.get(index.x)).gridItems == this.adapter.items && this.gridView.getFirstVisiblePosition() <= index.y && index.y <= this.gridView.getLastVisiblePosition() && this.gridView.getChildAt(index.y) != null) {
                            TextView text = (TextView) this.gridView.getChildAt(index.y).findViewById(R.id.textViewSelectedItemCount);
                            text.setText("" + value);
                            if (value <= 0 && text.getVisibility() == 0) {
                                text.setVisibility(4);
                            }
                        }
                    }
                }
            }
            this.selectedImageIdList.clear();
            this.selectedImageOrientationList.clear();
            this.buttonFooterCounter.setText("" + this.footer.getChildCount());
            this.deleteAllTv.setText("(" + this.footer.getChildCount() + ")");
            getView().findViewById(R.id.gallery_remove_all).setVisibility(4);
            getView().findViewById(R.id.gallery_max).setVisibility(0);
            this.deleteAllTv.setVisibility(0);
        }
    }

    void photosSelectFinished() {
        int size = this.selectedImageIdList.size();
        if (size <= this.COLLAGE_IMAGE_LIMIT_MIN) {
            Toast msg = Toast.makeText(this.context, String.format(getString(R.string.gallery_message_select_one), new Object[]{Integer.valueOf(getLimitMin() + 1)}), 1);
            msg.setGravity(17, msg.getXOffset() / 2, msg.getYOffset() / 2);
            msg.show();
            return;
        }
        int i;
        long[] arrr = new long[size];
        for (i = 0; i < size; i++) {
            arrr[i] = ((Long) this.selectedImageIdList.get(i)).longValue();
        }
        int[] orientationArr = new int[size];
        for (i = 0; i < size; i++) {
            orientationArr[i] = ((Integer) this.selectedImageOrientationList.get(i)).intValue();
        }
        if (this.galleryListener != null) {
            this.galleryListener.onGalleryOkImageArray(arrr, orientationArr, this.isScrapBook, this.isShape);
            return;
        }
        try {
            getActivity().getSupportFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
        } catch (Exception e) {
        }
    }

    private boolean addRecentPhotos() {
        int i;
        List<Integer> bucketIdList = new ArrayList();
        if (!(this.albumList == null || this.albumList.isEmpty())) {
            Log.e(TAG, "addRecentPhotos " + this.albumList.size());
            this.albumList.remove(this.albumList.size() - 1);
            for (i = 0; i < this.albumList.size(); i++) {
                bucketIdList.add(Integer.valueOf(((Album) this.albumList.get(i)).ID));
            }
        }
        ContentResolver contentResolver = this.context.getContentResolver();
        Cursor cur = contentResolver.query(Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "bucket_display_name", "bucket_id", "_id", "orientation"}, "1) GROUP BY 1,(2", null, "date_modified DESC");
        if (cur != null && cur.moveToFirst()) {
            int bucketColumn = cur.getColumnIndex("bucket_display_name");
            int bucketId = cur.getColumnIndex("bucket_id");
            int imageId = cur.getColumnIndex("_id");
            int orientationColumnIndex = cur.getColumnIndex("orientation");
            int indexRecent = 0;
            int addedIndex = 0;
            do {
                Album album = new Album();
                int id = cur.getInt(bucketId);
                album.ID = id;
                if (bucketIdList.contains(Integer.valueOf(id))) {
                    int bucketIndex = bucketIdList.indexOf(Integer.valueOf(album.ID));
                    Album albumFromList = (Album) this.albumList.get(bucketIndex);
                    Log.e(TAG, "recent photo index = " + indexRecent);
                    if (albumFromList.imageIdList.indexOf(Long.valueOf(cur.getLong(imageId))) == -1) {
                        Log.e(TAG, "new photo index = " + indexRecent);
                        long idd = cur.getLong(imageId);
                        albumFromList.imageIdList.add(addedIndex, Long.valueOf(idd));
                        int orientation = cur.getInt(orientationColumnIndex);
                        albumFromList.orientationList.add(addedIndex, Integer.valueOf(orientation));
                        albumFromList.gridItems.add(addedIndex, new GridViewItem(this.activity, "", 0, false, idd, orientation));
                        if (addedIndex == 0) {
                            ((Album) this.albumList.get(bucketIndex)).imageIdForThumb = idd;
                        }
                        addedIndex++;
                    }
                } else {
                    String bucket = cur.getString(bucketColumn);
                    bucketIdList.add(0, Integer.valueOf(id));
                    album.name = bucket;
                    album.imageIdForThumb = cur.getLong(imageId);
                    album.imageIdList.add(Long.valueOf(album.imageIdForThumb));
                    this.albumList.add(0, album);
                    album.orientationList.add(Integer.valueOf(cur.getInt(orientationColumnIndex)));
                    Log.e(TAG, "recent photo indexxx = " + indexRecent);
                }
                indexRecent++;
                if (!cur.moveToNext()) {
                    break;
                }
            } while (indexRecent < 5);
        }
        List<GridViewItem> items = new ArrayList();
        for (i = 0; i < this.albumList.size(); i++) {
            items.add(new GridViewItem(this.activity, ((Album) this.albumList.get(i)).name, ((Album) this.albumList.get(i)).imageIdList.size(), true, ((Album) this.albumList.get(i)).imageIdForThumb, ((Integer) ((Album) this.albumList.get(i)).orientationList.get(0)).intValue()));
        }
        this.albumList.add(new Album());
        ((Album) this.albumList.get(this.albumList.size() - 1)).gridItems = items;
        return true;
    }
}
