package com.lyrebirdstudio.pointlist;

import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;

public abstract class Svg {
    public static final int SVG_BARE_FOOT = 6;
    public static final int SVG_BIRD = 5;
    public static final int SVG_BUTTERFLY = 3;
    public static final int SVG_CIRCLE = 1;
    public static final int SVG_CLOUD = 7;
    public static final int SVG_CLOVER = 2;
    public static final int SVG_DIAMOND = 10;
    public static final int SVG_HEART = 0;
    public static final int SVG_HEX = 9;
    public static final int SVG_MAPLE_LEAF = 4;
    public static final int SVG_PAW = 8;
    public static Svg[] svgList = new Svg[]{new SvgHeart2(), new SvgCircle2(), new SvgClover(), new SvgButterfly(), new SvgMapleLeaf(), new SvgBird(), new SvgBareFoot(), new SvgCloud(), new SvgPaw(), new SvgHexagon(), new SvgDiamond()};
    Xfermode xferModeClear = new PorterDuffXfermode(Mode.CLEAR);

    public abstract void draw(Canvas canvas, float f, float f2, float f3, float f4, boolean z);
}
