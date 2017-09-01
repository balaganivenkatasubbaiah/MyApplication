package com.lyrebirdstudio.canvastext;

import android.content.Context;
import android.graphics.Typeface;

import java.util.Hashtable;

public class FontCache {
    private static final Hashtable<String, Typeface> cache = new Hashtable();

    public static Typeface get(Context c, String name) {
        Typeface typeface = null;
        synchronized (cache) {
            if (name != null) {
                if (!(name.length() == 0 || name.compareTo("") == 0)) {
                    if (!cache.containsKey(name)) {
                        try {
                            cache.put(name, Typeface.createFromAsset(c.getAssets(), name));
                        } catch (Exception e) {
                        }
                    }
                    typeface = (Typeface) cache.get(name);
                }
            }
        }
        return typeface;
    }
}
