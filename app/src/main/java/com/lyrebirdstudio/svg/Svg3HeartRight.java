package com.lyrebirdstudio.svg;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;

public class Svg3HeartRight extends Svg {
    private static final Matrix f1429m = new Matrix();
    private static float od;
    private static final Paint f1430p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1431t = new Path();

    public void draw(Canvas c, int w, int h) {
        draw(c, (float) w, (float) h, 0.0f, 0.0f, false);
    }

    public void draw(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        od = w / 351.0f < h / 512.0f ? w / 351.0f : h / 512.0f;
        m1514r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 351.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1429m.reset();
        f1429m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.translate(0.0f, 0.67f * od);
        c.scale(1.0f, 1.0f);
        c.translate(-153.84f * od, 5.84f * od);
        c.save();
        f1431t.reset();
        f1431t.moveTo(251.51f, 144.89f);
        f1431t.cubicTo(251.51f, 144.89f, 231.11f, 24.6f, 350.86f, -6.84f);
        f1431t.cubicTo(381.5f, -6.84f, 505.75f, -6.84f, 505.75f, -6.84f);
        f1431t.lineTo(505.75f, 505.16f);
        f1431t.lineTo(153.84f, 505.16f);
        f1431t.cubicTo(230.1f, 482.07f, 244.15f, 438.58f, 246.16f, 403.8f);
        f1431t.cubicTo(248.03f, 371.49f, 369.25f, 281.91f, 381.97f, 262.97f);
        f1431t.cubicTo(425.5f, 221.91f, 430.81f, 106.09f, 331.12f, 93.37f);
        f1431t.cubicTo(281.62f, 89.36f, 251.51f, 144.89f, 251.51f, 144.89f);
        f1431t.transform(f1429m);
        c.drawPath(f1431t, f1430p);
        c.drawPath(f1431t, ps);
        c.restore();
        m1514r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.restore();
        m1514r(new Integer[0]);
        c.restore();
    }

    private static void m1514r(Integer... o) {
        f1430p.reset();
        ps.reset();
        if (cf != null) {
            f1430p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1430p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1430p.setStyle(Style.FILL);
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
