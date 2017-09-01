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

public class SvgHeart extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1402m = new Matrix();
    private static float od;
    private static final Paint f1403p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1404t = new Path();

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
        m1505r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1402m.reset();
        f1402m.setScale(od, od);
        c.save();
        if (clearMode) {
            f1403p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(1.0f, 1.0f);
        c.save();
        f1403p.setColor(Color.parseColor("#FFFFFF"));
        c.scale(1.0f, -1.0f);
        c.translate(0.0f, -448.0f * od);
        f1404t.reset();
        f1404t.moveTo(256.0f, -7.47f);
        f1404t.lineTo(225.07f, 20.69f);
        f1404t.cubicTo(115.2f, 120.32f, 42.67f, 186.24f, 42.67f, 266.67f);
        f1404t.cubicTo(42.67f, 332.59f, 94.29f, 384.0f, 160.0f, 384.0f);
        f1404t.cubicTo(197.12f, 384.0f, 232.75f, 366.72f, 256.0f, 339.63f);
        f1404t.cubicTo(279.25f, 366.72f, 314.88f, 384.0f, 352.0f, 384.0f);
        f1404t.cubicTo(417.71f, 384.0f, 469.33f, 332.59f, 469.33f, 266.67f);
        f1404t.cubicTo(469.33f, 186.24f, 396.8f, 120.32f, 286.93f, 20.69f);
        f1404t.lineTo(256.0f, -7.47f);
        f1404t.transform(f1402m);
        c.drawPath(f1404t, f1403p);
        c.drawPath(f1404t, ps);
        c.restore();
        m1505r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        f1403p.setColor(Color.parseColor("#FFFFFF"));
        c.restore();
        m1505r(new Integer[0]);
        c.restore();
    }

    private static void m1505r(Integer... o) {
        f1403p.reset();
        ps.reset();
        if (cf != null) {
            f1403p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1403p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1403p.setStyle(Style.FILL);
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
