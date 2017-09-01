package com.lyrebirdstudio.pointlist;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;

public class SvgDiamond extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1396m = new Matrix();
    private static float od;
    private static final Paint f1397p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1398t = new Path();

    public static void setColorTint(int color) {
        cf = new PorterDuffColorFilter(color, Mode.SRC_IN);
    }

    public static void clearColorTint(int color) {
        cf = null;
    }

    public void draw(Canvas c, int w, int h) {
        draw(c, (float) w, (float) h, 0.0f, 0.0f, false);
    }

    public void draw(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        od = w / 417.0f < h / 417.0f ? w / 417.0f : h / 417.0f;
        m1503r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 417.0f)) / 2.0f) + dx, ((h - (od * 417.0f)) / 2.0f) + dy);
        f1396m.reset();
        f1396m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(1.0f, 1.0f);
        c.save();
        c.save();
        f1398t.reset();
        f1398t.moveTo(333.23f, 39.55f);
        f1398t.lineTo(278.31f, 122.56f);
        f1398t.lineTo(221.55f, 39.55f);
        f1398t.lineTo(333.23f, 39.55f);
        f1398t.moveTo(269.59f, 141.54f);
        f1398t.lineTo(147.76f, 141.54f);
        f1398t.lineTo(208.67f, 373.21f);
        f1398t.lineTo(269.59f, 141.54f);
        f1398t.moveTo(151.82f, 127.94f);
        f1398t.lineTo(265.51f, 127.94f);
        f1398t.lineTo(208.66f, 44.79f);
        f1398t.lineTo(151.82f, 127.94f);
        f1398t.moveTo(139.03f, 122.56f);
        f1398t.lineTo(195.79f, 39.55f);
        f1398t.lineTo(84.12f, 39.55f);
        f1398t.lineTo(139.03f, 122.56f);
        f1398t.moveTo(195.76f, 377.58f);
        f1398t.lineTo(133.7f, 141.54f);
        f1398t.lineTo(0.0f, 141.54f);
        f1398t.lineTo(195.76f, 377.58f);
        f1398t.moveTo(0.19f, 127.94f);
        f1398t.lineTo(126.29f, 127.94f);
        f1398t.lineTo(71.36f, 44.91f);
        f1398t.lineTo(0.19f, 127.94f);
        f1398t.moveTo(345.89f, 45.06f);
        f1398t.lineTo(291.05f, 127.95f);
        f1398t.lineTo(416.94f, 127.95f);
        f1398t.lineTo(345.89f, 45.06f);
        f1398t.moveTo(283.64f, 141.54f);
        f1398t.lineTo(221.58f, 377.56f);
        f1398t.lineTo(417.13f, 141.55f);
        f1398t.lineTo(283.64f, 141.55f);
        f1398t.transform(f1396m);
        if (clearMode) {
            f1397p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        c.drawPath(f1398t, f1397p);
        c.drawPath(f1398t, ps);
        c.restore();
        m1503r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.restore();
        m1503r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1503r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1503r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1503r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1503r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1503r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1503r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1503r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1503r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1503r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1503r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1503r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1503r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1503r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1503r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1503r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.restore();
        m1503r(new Integer[0]);
        c.restore();
    }

    private static void m1503r(Integer... o) {
        f1397p.reset();
        ps.reset();
        if (cf != null) {
            f1397p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1397p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1397p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    ps.setStrokeJoin(Join.MITER);
                    break;
                case 1:
                    ps.setStrokeMiter(4.0f * od);
                    break;
                case 2:
                    ps.setStrokeCap(Cap.BUTT);
                    break;
                case 3:
                    ps.setColor(Color.argb(0, 0, 0, 0));
                    break;
                default:
                    break;
            }
        }
    }
}
