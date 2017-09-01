package com.lyrebirdstudio.sticker;

public class NavigationDrawerItem {
    String icenListUrl;
    int id;
    boolean isDonwloadable = false;
    boolean isIconListDownloaded = false;
    boolean isNew = false;
    String name;
    int resId;

    NavigationDrawerItem(String name, int resId, int id) {
        this.name = name;
        this.resId = resId;
        this.id = id;
    }
}
