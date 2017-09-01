package com.lyrebirdstudio.sticker;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.SimpleDrawerListener;
import android.support.v7.app.AlertDialog.Builder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lyrebirdstudio.R;
import com.lyrebirdstudio.photoactivity.PhotoActivity;
import com.lyrebirdstudio.sticker.StickerOnlineLib.StickerImageDownloadListener;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StickerGalleryFragment extends Fragment implements OnItemClickListener {
    private static final String TAG = "StickerGalleryFragment";
    public static int initialNavSelection = 2;
    final int STICKER_LIMIT = 12;
    Activity activity;
    Context context;
    int count = 0;
    int currentListIndex = initialNavSelection;
    DrawerLayout drawerLayout;
    StickerGalleryListener galleryListener;
    StickerGridAdapter gridAdapter;
    GridView gridView;
    TextView headerText;
    int initialTogglePos = 0;
    StickerGalleryFragment mFragment = this;
    float moveFactor = 0.0f;
    ListView navList;
    NavigationDrawerItem[] navigationDrawerItemList;
    OnClickListener onClickListener = new C06607();
    View progressBar;
    List<StickerGridItem> selectedImageIdList = new ArrayList();
    Animation slideIn;
    Animation slideOut;
    StickerGridItem[][] stickerItemList;
    ImageView toggleButton;
    int totalImage = 0;

    class C06541 implements OnTouchListener {
        C06541() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            StickerGalleryFragment.this.drawerLayout.openDrawer(StickerGalleryFragment.this.navList);
            return true;
        }
    }

    class C06552 implements Runnable {
        C06552() {
        }

        public void run() {
            StickerGalleryFragment.this.calculateTogglePos();
        }
    }

    class C06563 implements OnItemClickListener {
        C06563() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
            StickerGalleryFragment.this.drawerLayout.closeDrawer(StickerGalleryFragment.this.navList);
            if (StickerGalleryFragment.this.currentListIndex != pos) {
                if (StickerGalleryFragment.this.stickerItemList == null) {
                    StickerGalleryFragment.this.createItemList();
                }
                StickerGalleryFragment.this.gridAdapter.setItems(StickerGalleryFragment.this.stickerItemList[pos - 1]);
                StickerGalleryFragment.this.gridView.smoothScrollToPosition(0);
                StickerGalleryFragment.this.gridAdapter.notifyDataSetChanged();
            }
            StickerGalleryFragment.this.currentListIndex = pos;
        }
    }

    class C06575 implements Runnable {
        C06575() {
        }

        public void run() {
            StickerGalleryFragment.this.drawerLayout.openDrawer(StickerGalleryFragment.this.navList);
        }
    }

    class C06586 implements DialogInterface.OnClickListener {
        C06586() {
        }

        public void onClick(DialogInterface arg0, int arg1) {
        }
    }

    class C06607 implements OnClickListener {

        class C06591 implements Runnable {
            C06591() {
            }

            public void run() {
                if (StickerGalleryFragment.this.count > 0) {
                    if (StickerGalleryFragment.this.progressBar != null) {
                        StickerGalleryFragment.this.progressBar.setVisibility(4);
                    }
                    if (StickerGalleryFragment.this.getActivity() != null) {
                        StickerGalleryFragment.this.getActivity().getSupportFragmentManager().beginTransaction().hide(StickerGalleryFragment.this.mFragment).commitAllowingStateLoss();
                    }
                }
            }
        }

        C06607() {
        }

        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.textView_header) {
                StickerGalleryFragment.this.backtrace();
            }
            if (id == R.id.sticker_gallery_ok) {
                int i;
                new Handler().postDelayed(new C06591(), 30000);
                int outerSize = StickerGalleryFragment.this.stickerItemList.length;
                for (int j = 0; j < outerSize; j++) {
                    for (StickerGridItem stickerGridItem : StickerGalleryFragment.this.stickerItemList[j]) {
                        stickerGridItem.selectedItemCount = 0;
                    }
                }
                int size = StickerGalleryFragment.this.selectedImageIdList.size();
                final StickerGridItem[] arrr = new StickerGridItem[size];
                for (i = 0; i < size; i++) {
                    arrr[i] = (StickerGridItem) StickerGalleryFragment.this.selectedImageIdList.get(i);
                }
                StickerGalleryFragment.this.selectedImageIdList.clear();
                if (StickerGalleryFragment.this.galleryListener == null) {
                    StickerGalleryFragment.this.getActivity().getSupportFragmentManager().beginTransaction().hide(StickerGalleryFragment.this.mFragment).commitAllowingStateLoss();
                    return;
                }
                for (i = 0; i < arrr.length; i++) {
                    if (arrr[i].isOnline) {
                        if (StickerGalleryFragment.this.progressBar.getVisibility() != 0) {
                            StickerGalleryFragment.this.progressBar.setVisibility(0);
                        }
                        StickerGalleryFragment stickerGalleryFragment = StickerGalleryFragment.this;
                        stickerGalleryFragment.count++;
                        final StickerGridItem aa = arrr[i];
                        File f = StickerOnlineLib.getFilePath(StickerOnlineLib.getFileName(aa.url), StickerGalleryFragment.this.context, "", StickerOnlineLib.folderName);
                        if (f.exists()) {
                            Log.e(StickerGalleryFragment.TAG, "file already downloaded!");
                            aa.path = f.getAbsolutePath();
                            stickerGalleryFragment = StickerGalleryFragment.this;
                            stickerGalleryFragment.count--;
                        } else {
                            StickerOnlineLib.downloadSticker(StickerGalleryFragment.this.getActivity(), arrr[i].url, new StickerImageDownloadListener() {
                                public void onStickerImageDownloaded(String path) {
                                    if (aa != null) {
                                        aa.path = path;
                                    }
                                    StickerGalleryFragment stickerGalleryFragment = StickerGalleryFragment.this;
                                    stickerGalleryFragment.count--;
                                    if (StickerGalleryFragment.this.count <= 0) {
                                        if (StickerGalleryFragment.this.progressBar != null) {
                                            StickerGalleryFragment.this.progressBar.setVisibility(4);
                                        }
                                        if (StickerGalleryFragment.this.galleryListener != null) {
                                            StickerGalleryFragment.this.galleryListener.onGalleryOkImageArray(arrr);
                                        } else {
                                            StickerGalleryFragment.this.getActivity().getSupportFragmentManager().beginTransaction().hide(StickerGalleryFragment.this.mFragment).commitAllowingStateLoss();
                                        }
                                    }
                                }

                                public void onStickerImageDownloadFailure() {
                                    StickerGalleryFragment stickerGalleryFragment = StickerGalleryFragment.this;
                                    stickerGalleryFragment.count--;
                                    if (StickerGalleryFragment.this.count <= 0) {
                                        if (StickerGalleryFragment.this.progressBar != null) {
                                            StickerGalleryFragment.this.progressBar.setVisibility(4);
                                        }
                                        if (StickerGalleryFragment.this.galleryListener != null) {
                                            StickerGalleryFragment.this.galleryListener.onGalleryOkImageArray(arrr);
                                        } else if (StickerGalleryFragment.this.galleryListener == null) {
                                            StickerGalleryFragment.this.getActivity().getSupportFragmentManager().beginTransaction().hide(StickerGalleryFragment.this.mFragment).commitAllowingStateLoss();
                                        }
                                        if (StickerGalleryFragment.this.getActivity() != null) {
                                            MyAlertDialogFragment.newInstance(R.string.no_network_dialog_title, StickerGalleryFragment.this.getString(R.string.pip_lib_file_download_error)).show(StickerGalleryFragment.this.getActivity().getSupportFragmentManager(), "dialog");
                                        }
                                    }
                                }
                            });
                        }
                    }
                }
                if (StickerGalleryFragment.this.count <= 0) {
                    if (StickerGalleryFragment.this.progressBar != null) {
                        StickerGalleryFragment.this.progressBar.setVisibility(4);
                    }
                    if (StickerGalleryFragment.this.galleryListener != null) {
                        StickerGalleryFragment.this.galleryListener.onGalleryOkImageArray(arrr);
                    } else {
                        StickerGalleryFragment.this.getActivity().getSupportFragmentManager().beginTransaction().hide(StickerGalleryFragment.this.mFragment).commitAllowingStateLoss();
                    }
                }
            }
        }
    }

    public interface StickerGalleryListener {
        void onGalleryCancel();

        void onGalleryOkImageArray(StickerGridItem[] stickerGridItemArr);
    }

    class C11384 extends SimpleDrawerListener {
        C11384() {
        }

        @SuppressLint({"NewApi"})
        public void onDrawerClosed(View drawerView) {
            super.onDrawerClosed(drawerView);
        }

        @SuppressLint({"NewApi"})
        public void onDrawerOpened(View drawerView) {
        }

        @SuppressLint({"NewApi"})
        public void onDrawerSlide(View drawerView, float slideOffset) {
            if (StickerGalleryFragment.this.initialTogglePos <= 0) {
                StickerGalleryFragment.this.calculateTogglePos();
            }
            StickerGalleryFragment.this.moveFactor = (-slideOffset) * ((float) StickerGalleryFragment.this.initialTogglePos);
            if (VERSION.SDK_INT >= 11) {
                StickerGalleryFragment.this.toggleButton.setX(StickerGalleryFragment.this.moveFactor);
            }
        }

        public void onDrawerStateChanged(int newState) {
            if (newState == 2 && !StickerGalleryFragment.this.drawerLayout.isDrawerOpen(3)) {
            }
        }
    }

    public static class MyAlertDialogFragment extends DialogFragment {

        class C06611 implements DialogInterface.OnClickListener {
            C06611() {
            }

            public void onClick(DialogInterface dialog, int whichButton) {
            }
        }

        public static MyAlertDialogFragment newInstance(int title, String msg) {
            MyAlertDialogFragment frag = new MyAlertDialogFragment();
            Bundle args = new Bundle();
            args.putInt("title", title);
            args.putString("msg", msg);
            frag.setArguments(args);
            return frag;
        }

        public Dialog onCreateDialog(Bundle savedInstanceState) {
            int title = getArguments().getInt("title");
            CharSequence msg = getArguments().getString("msg");
            if (msg == null) {
                msg = getString(R.string.pip_lib_no_network);
            }
            return new Builder(getActivity()).setMessage(msg).setTitle(title).setPositiveButton("Ok", new C06611()).create();
        }

        public void show(FragmentManager manager, String tag) {
            try {
                FragmentTransaction ft = manager.beginTransaction();
                ft.add((Fragment) this, tag);
                ft.commitAllowingStateLoss();
            } catch (IllegalStateException e) {
            }
        }
    }

    public void setGalleryListener(StickerGalleryListener l) {
        this.galleryListener = l;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.sticker_fragment_gallery, container, false);
        this.progressBar = fragmentView.findViewById(R.id.progress_download);
        if (this.progressBar != null) {
            this.progressBar.setVisibility(4);
        }
        this.headerText = (TextView) fragmentView.findViewById(R.id.textView_header);
        this.headerText.setText(String.format(getString(R.string.sticker_items_selected_zero), new Object[]{Integer.valueOf(12)}));
        this.headerText.setOnClickListener(this.onClickListener);
        ((ImageButton) fragmentView.findViewById(R.id.sticker_gallery_ok)).setOnClickListener(this.onClickListener);
        this.toggleButton = (ImageView) fragmentView.findViewById(R.id.toggle_button);
        this.slideIn = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_left_galler_toggle);
        this.slideOut = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_out_left_gallery_toggle);
        this.slideIn.setFillAfter(true);
        this.slideOut.setFillAfter(true);
        this.toggleButton.setOnTouchListener(new C06541());
        this.toggleButton.post(new C06552());
        createNavItemList();
        NavigationDrawerListAdapter listAdapter = new NavigationDrawerListAdapter(getActivity(), this.navigationDrawerItemList);
        this.drawerLayout = (DrawerLayout) fragmentView.findViewById(R.id.layout_gallery_fragment_drawer);
        this.navList = (ListView) fragmentView.findViewById(R.id.sticker_nav_drawer);
        this.navList.addHeaderView(inflater.inflate(R.layout.sticker_header, null, false), null, false);
        this.navList.setAdapter(listAdapter);
        this.navList.setItemChecked(initialNavSelection + 1, true);
        this.navList.setOnItemClickListener(new C06563());
        this.drawerLayout.setDrawerListener(new C11384());
        return fragmentView;
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    void calculateTogglePos() {
        int[] loc = new int[2];
        this.toggleButton.getLocationOnScreen(loc);
        this.initialTogglePos = this.toggleButton.getWidth() + loc[0];
    }

    public void onAttach(Activity act) {
        super.onAttach(act);
        this.context = getActivity();
        this.activity = getActivity();
    }

    public void onStart() {
        super.onStart();
    }

    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (this.gridView != null && !hidden) {
            this.gridAdapter.notifyDataSetChanged();
            this.gridView.invalidateViews();
        }
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setGridAdapter();
        parseJSON();
        if (this.drawerLayout != null) {
            this.drawerLayout.postDelayed(new C06575(), 600);
        }
    }

    private void setGridAdapter() {
        this.gridView = (GridView) getView().findViewById(R.id.gridView);
        if (this.stickerItemList == null) {
            createItemList();
        }
        this.gridAdapter = new StickerGridAdapter(this.context, this.stickerItemList[initialNavSelection], this.gridView);
        this.gridView.setAdapter(this.gridAdapter);
        this.gridView.setOnItemClickListener(this);
    }

    private void createItemList() {
        int j;
        int outerSizeRes = Utility.stickerResIdList.length;
        int outerSizeUrl = Utility.stickerUrlList.length;
        this.stickerItemList = new StickerGridItem[(outerSizeRes + outerSizeUrl)][];
        for (j = 0; j < outerSizeRes; j++) {
            int i;
            int size = Utility.stickerResIdList[j].length;
            this.stickerItemList[j] = new StickerGridItem[size];
            for (i = 0; i < size; i++) {
                this.stickerItemList[j][i] = new StickerGridItem(Utility.stickerResIdList[j][i]);
            }
        }
        for (j = outerSizeRes; j < outerSizeRes + outerSizeUrl; j++) {
           int size = Utility.stickerUrlList[j - outerSizeRes].length;
            this.stickerItemList[j] = new StickerGridItem[size];
            for (int i = 0; i < size; i++) {
                this.stickerItemList[j][i] = new StickerGridItem(Utility.stickerUrlList[j - outerSizeRes][i]);
            }
        }
    }

    public void onBackPressed() {
        backtrace();
    }

    public void backtrace() {
        if (this.drawerLayout.isDrawerOpen(3)) {
            int outerSize = this.stickerItemList.length;
            for (int j = 0; j < outerSize; j++) {
                for (StickerGridItem stickerGridItem : this.stickerItemList[j]) {
                    stickerGridItem.selectedItemCount = 0;
                }
            }
            this.selectedImageIdList.clear();
            this.galleryListener.onGalleryCancel();
            return;
        }
        this.drawerLayout.openDrawer(this.navList);
    }

    public void setTotalImage(int size) {
        this.totalImage = size;
        if (this.headerText != null) {
            this.headerText.setText((this.totalImage + this.selectedImageIdList.size()) + String.format(getString(R.string.sticker_items_selected), new Object[]{Integer.valueOf(12)}));
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View arg1, int location, long arg3) {
        if (this.totalImage + this.selectedImageIdList.size() < 12 || this.gridAdapter.itemList[location].selectedItemCount != 0) {
            if (this.gridAdapter.itemList[location].selectedItemCount == 0) {
                StickerGridItem stickerGridItem = this.gridAdapter.itemList[location];
                stickerGridItem.selectedItemCount++;
            } else {
                this.gridAdapter.itemList[location].selectedItemCount = 0;
            }
            ImageView imageItemSelected = (ImageView) arg1.findViewById(R.id.image_view_item_selected);
            if (imageItemSelected.getVisibility() == 4 && this.gridAdapter.itemList[location].selectedItemCount == 1) {
                imageItemSelected.setVisibility(0);
            }
            if (imageItemSelected.getVisibility() == 0 && this.gridAdapter.itemList[location].selectedItemCount == 0) {
                imageItemSelected.setVisibility(4);
            }
            StickerGridItem item = this.gridAdapter.itemList[location];
            if (this.gridAdapter.itemList[location].selectedItemCount == 1) {
                this.selectedImageIdList.add(this.gridAdapter.itemList[location]);
            } else {
                for (int i = 0; i < this.selectedImageIdList.size(); i++) {
                    if (this.selectedImageIdList.get(i) == item) {
                        this.selectedImageIdList.remove(i);
                        break;
                    }
                }
            }
            this.headerText.setText((this.totalImage + this.selectedImageIdList.size()) + String.format(getString(R.string.sticker_items_selected), new Object[]{Integer.valueOf(12)}));
            return;
        }
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this.context);
        alertDialogBuilder.setMessage(String.format(getString(R.string.sticker_choose_limit), new Object[]{Integer.valueOf(12)}));
        alertDialogBuilder.setPositiveButton("ok", new C06586());
        alertDialogBuilder.create().show();
    }

    void createNavItemList() {
        if (this.navigationDrawerItemList == null) {
            this.navigationDrawerItemList = new NavigationDrawerItem[]{new NavigationDrawerItem(this.context.getString(R.string.sticker_navigation_name_list_emoji_1), R.drawable.list_icon_emoji, 101), new NavigationDrawerItem(this.context.getString(R.string.sticker_navigation_name_list_emoji_2), R.drawable.list_icon_emotion_1, 102), new NavigationDrawerItem("Snap", R.drawable.list_icon_snap, 103), new NavigationDrawerItem("Flower Crown", R.drawable.list_icon_flower_crown, 104), new NavigationDrawerItem("Snap 2", R.drawable.list_icon_snap_4, 105), new NavigationDrawerItem("Cat", R.drawable.list_icon_cat, 106), new NavigationDrawerItem("Rainbow", R.drawable.list_icon_rainbow, 107), new NavigationDrawerItem(this.context.getString(R.string.sticker_navigation_name_list_love), R.drawable.list_icon_love, 108), new NavigationDrawerItem("New", R.drawable.list_icon_new_arrival, 109), new NavigationDrawerItem(this.context.getString(R.string.sticker_navigation_name_list_candy), R.drawable.list_icon_candy, 110), new NavigationDrawerItem(this.context.getString(R.string.sticker_navigation_name_list_birds), R.drawable.list_icon_love_bird, 111), new NavigationDrawerItem(this.context.getString(R.string.sticker_navigation_name_list_monsters), R.drawable.list_icon_monster, 112), new NavigationDrawerItem(this.context.getString(R.string.sticker_navigation_name_list_comic), R.drawable.list_icon_comic, 113), new NavigationDrawerItem(this.context.getString(R.string.sticker_navigation_name_list_flag), R.drawable.list_icon_flag, 114), new NavigationDrawerItem(this.context.getString(R.string.sticker_navigation_name_list_glasses), R.drawable.list_icon_glasses, PhotoActivity.REQUEST_WRITE_STORAGE_SCRAPBOOK), new NavigationDrawerItem(this.context.getString(R.string.sticker_navigation_name_list_beard), R.drawable.list_icon_beard, PhotoActivity.REQUEST_WRITE_STORAGE_SCRAPBOOK_BLUR), new NavigationDrawerItem(this.context.getString(R.string.sticker_navigation_name_list_hat), R.drawable.list_icon_hat, 117), new NavigationDrawerItem(this.context.getString(R.string.sticker_navigation_name_list_wig), R.drawable.list_icon_wig, 118), new NavigationDrawerItem(this.context.getString(R.string.sticker_navigation_name_list_accesories), R.drawable.list_icon_accesory, 119), new NavigationDrawerItem(this.context.getString(R.string.sticker_navigation_name_list_emoji_4), R.drawable.list_icon_emoji_2, 120), new NavigationDrawerItem("Animals", R.drawable.list_icon_animal, 121)};
            this.navigationDrawerItemList[3].isNew = true;
            this.navigationDrawerItemList[4].isNew = true;
            this.navigationDrawerItemList[5].isNew = true;
            this.navigationDrawerItemList[6].isNew = true;
            this.navigationDrawerItemList[this.navigationDrawerItemList.length - 1].isDonwloadable = true;
            this.navigationDrawerItemList[this.navigationDrawerItemList.length - 1].icenListUrl = "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/sticker_list.txt";
        }
    }

    void parseJSON() {
        String url = StickerOnlineLib.jsonUrl;
        File f = StickerOnlineLib.getFilePath(url.substring(url.lastIndexOf(47) + 1, url.length()), this.context, "", StickerOnlineLib.folderName);
        if (f != null && f.getParentFile().isDirectory()) {
            try {
                String jsonString = "";
                DataInputStream in = new DataInputStream(new FileInputStream(f.getAbsolutePath()));
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                while (true) {
                    String strLine = br.readLine();
                    if (strLine == null) {
                        break;
                    }
                    jsonString = jsonString + strLine;
                }
                in.close();
                StickerOnlineItem[] stickerOnlineItemArr = (StickerOnlineItem[]) new Gson().fromJson(jsonString, StickerOnlineItem[].class);
                if (stickerOnlineItemArr != null && stickerOnlineItemArr.length > 0) {
                    for (StickerOnlineItem stickerOnlineItem : stickerOnlineItemArr) {
                        int selectedIndex = findIndexOfStickerItem(stickerOnlineItem.categoryId);
                        String baseUrl = stickerOnlineItem.baseUrl;
                        if (selectedIndex >= 0 && selectedIndex < this.stickerItemList.length && baseUrl != null && !baseUrl.isEmpty()) {
                            int i;
                            StickerGridItem[] g = this.stickerItemList[selectedIndex];
                            int size = ((g.length + stickerOnlineItem.lastIndex) - stickerOnlineItem.firstIndex) + 1;
                            StickerGridItem[] n = new StickerGridItem[size];
                            for (i = 0; i < g.length; i++) {
                                n[i] = g[i];
                            }
                            int index = 0;
                            for (i = g.length; i < size; i++) {
                                int iii = index + stickerOnlineItem.firstIndex;
                                index++;
                                n[i] = new StickerGridItem(baseUrl + stickerOnlineItem.name + String.format("%03d", new Object[]{Integer.valueOf(iii)}) + ".png");
                            }
                            this.stickerItemList[selectedIndex] = n;
                            if (stickerOnlineItem.putStar) {
                                this.navigationDrawerItemList[selectedIndex].isNew = stickerOnlineItem.putStar;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                Log.e(TAG, e.toString());
            }
        }
    }

    int findIndexOfStickerItem(int id) {
        for (int i = 0; i < this.navigationDrawerItemList.length; i++) {
            if (id == this.navigationDrawerItemList[i].id) {
                return i;
            }
        }
        return -1;
    }
}
