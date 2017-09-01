package com.lyrebirdstudio.svg;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;

public class SvgStoneHeart1 extends Svg {
    private static final Matrix f1627m = new Matrix();
    private static float od;
    private static final Paint f1628p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1629t = new Path();

    public void draw(Canvas c, int w, int h) {
        draw(c, (float) w, (float) h, 0.0f, 0.0f, false);
    }

    public void draw(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        od = w / 513.0f < h / 441.0f ? w / 513.0f : h / 441.0f;
        m1580r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 513.0f)) / 2.0f) + dx, ((h - (od * 441.0f)) / 2.0f) + dy);
        f1627m.reset();
        f1627m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.translate(0.15f * od, 0.0f);
        c.scale(1.0f, 1.0f);
        c.save();
        f1628p.setColor(Color.parseColor("#010101"));
        f1629t.reset();
        f1629t.moveTo(117.8f, 4.41f);
        f1629t.cubicTo(14.56f, 22.84f, -51.8f, 289.53f, 52.66f, 384.16f);
        f1629t.cubicTo(157.12f, 478.79f, 514.75f, 454.21f, 513.52f, 328.85f);
        f1629t.cubicTo(512.29f, 203.5f, 375.39f, 102.91f, 334.09f, 74.46f);
        f1629t.cubicTo(187.85f, -26.32f, 117.8f, 4.41f, 117.8f, 4.41f);
        f1629t.transform(f1627m);
        c.drawPath(f1629t, f1628p);
        c.drawPath(f1629t, ps);
        c.restore();
        m1580r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        f1628p.setColor(Color.parseColor("#010101"));
        c.restore();
        m1580r(new Integer[0]);
        c.restore();
    }

    private static void m1580r(Integer... o) {
        f1628p.reset();
        ps.reset();
        if (cf != null) {
            f1628p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1628p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1628p.setStyle(Style.FILL);
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
