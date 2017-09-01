package com.lyrebirdstudio.svg;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;

public class SvgStone4 extends Svg {
    private static final Matrix f1624m = new Matrix();
    private static float od;
    private static final Paint f1625p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1626t = new Path();

    public void draw(Canvas c, int w, int h) {
        draw(c, (float) w, (float) h, 0.0f, 0.0f, false);
    }

    public void draw(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        od = w / 489.0f < h / 512.0f ? w / 489.0f : h / 512.0f;
        m1579r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 489.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1624m.reset();
        f1624m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(1.0f, 1.0f);
        c.save();
        f1625p.setColor(Color.parseColor("#010101"));
        f1626t.reset();
        f1626t.moveTo(146.96f, 50.38f);
        f1626t.cubicTo(334.19f, -22.7f, 382.91f, -6.0f, 439.99f, 35.76f);
        f1626t.cubicTo(497.06f, 77.52f, 510.8f, 204.27f, 448.34f, 321.13f);
        f1626t.cubicTo(383.61f, 442.23f, 314.7f, 551.5f, 172.71f, 498.61f);
        f1626t.cubicTo(30.73f, 445.71f, -6.16f, 307.21f, 0.8f, 246.65f);
        f1626t.cubicTo(5.74f, 203.72f, 27.25f, 113.72f, 146.96f, 50.38f);
        f1626t.transform(f1624m);
        c.drawPath(f1626t, f1625p);
        c.drawPath(f1626t, ps);
        c.restore();
        m1579r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        f1625p.setColor(Color.parseColor("#010101"));
        c.restore();
        m1579r(new Integer[0]);
        c.restore();
    }

    private static void m1579r(Integer... o) {
        f1625p.reset();
        ps.reset();
        if (cf != null) {
            f1625p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1625p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1625p.setStyle(Style.FILL);
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
