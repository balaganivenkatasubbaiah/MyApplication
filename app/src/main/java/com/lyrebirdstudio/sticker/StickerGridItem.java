package com.lyrebirdstudio.sticker;

public class StickerGridItem {
    String id;
    boolean isOnline = false;
    public String path;
    public int resId;
    int selectedItemCount = 0;
    public String url;

    public StickerGridItem(int resId, int count) {
        this.resId = resId;
        this.selectedItemCount = count;
    }

    public StickerGridItem(int resId) {
        this.resId = resId;
        this.selectedItemCount = 0;
        this.isOnline = false;
    }

    public StickerGridItem(String url) {
        this.url = url;
        this.selectedItemCount = 0;
        this.isOnline = true;
    }

    public StickerGridItem(String url, String id) {
        this.url = url;
        this.id = id;
        this.selectedItemCount = 0;
        this.isOnline = true;
    }

    public boolean getIsOnline() {
        return this.isOnline;
    }
}
