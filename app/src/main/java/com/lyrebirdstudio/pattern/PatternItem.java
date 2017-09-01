package com.lyrebirdstudio.pattern;

public class PatternItem {
    public boolean isFromOnline = false;
    public String path;
    public int resId;

    public PatternItem(int resId) {
        this.resId = resId;
        this.isFromOnline = false;
    }

    public PatternItem(String path) {
        this.path = path;
        this.isFromOnline = true;
    }
}
