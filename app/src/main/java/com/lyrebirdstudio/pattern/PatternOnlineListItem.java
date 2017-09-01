package com.lyrebirdstudio.pattern;

public class PatternOnlineListItem {
    String[] gridUrlArr;
    String imageUrl;
    String name;
    String zipUrl;

    public PatternOnlineListItem(String str, String zipUrl, String name, String[] gridUrlArr) {
        this.imageUrl = str;
        this.zipUrl = zipUrl;
        this.gridUrlArr = gridUrlArr;
        this.name = name;
    }
}
