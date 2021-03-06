package com.lyrebirdstudio.svg;

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

public class SvgCircle extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1507m = new Matrix();
    private static float od;
    private static final Paint f1508p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1509t = new Path();

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
        od = w / 512.0f < h / 512.0f ? w / 512.0f : h / 512.0f;
        m1540r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1507m.reset();
        f1507m.setScale(od, od);
        c.save();
        if (clearMode) {
            f1508p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(1.0f, 1.0f);
        c.save();
        f1508p.setColor(Color.parseColor("#FFFFFF"));
        c.scale(1.0f, -1.0f);
        c.translate(0.0f, -448.0f * od);
        f1509t.reset();
        f1509t.moveTo(256.0f, 405.33f);
        f1509t.cubicTo(138.24f, 405.33f, 42.67f, 309.76f, 42.67f, 192.0f);
        f1509t.cubicTo(42.67f, 74.24f, 138.24f, -21.33f, 256.0f, -21.33f);
        f1509t.cubicTo(373.76f, -21.33f, 469.33f, 74.24f, 469.33f, 192.0f);
        f1509t.cubicTo(469.33f, 309.76f, 373.76f, 405.33f, 256.0f, 405.33f);
        f1509t.transform(f1507m);
        c.drawPath(f1509t, f1508p);
        c.drawPath(f1509t, ps);
        c.restore();
        m1540r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        f1508p.setColor(Color.parseColor("#FFFFFF"));
        c.restore();
        m1540r(new Integer[0]);
        c.restore();
    }

    private static void m1540r(Integer... o) {
        f1508p.reset();
        ps.reset();
        if (cf != null) {
            f1508p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1508p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1508p.setStyle(Style.FILL);
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
