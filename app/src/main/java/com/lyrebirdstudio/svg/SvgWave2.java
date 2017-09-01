package com.lyrebirdstudio.svg;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;

public class SvgWave2 extends Svg {
    private static final Matrix f1660m = new Matrix();
    private static float od;
    private static final Paint f1661p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1662t = new Path();

    public void draw(Canvas c, int w, int h) {
        draw(c, (float) w, (float) h, 0.0f, 0.0f, false);
    }

    public void draw(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        od = w / 497.0f < h / 512.0f ? w / 497.0f : h / 512.0f;
        m1591r(new Integer[0]);
        c.save();
        c.translate((((w - (od * 497.0f)) / 2.0f) + dx) - 11.0f, (((h - (od * 512.0f)) / 2.0f) + dy) - 1.0f);
        f1660m.reset();
        f1660m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.translate(0.0f, 0.34f * od);
        c.scale(1.0f, 1.0f);
        c.save();
        f1662t.reset();
        f1662t.moveTo(0.0f, 48.71f);
        f1662t.cubicTo(0.0f, 48.71f, 232.1f, -40.45f, 307.11f, 22.85f);
        f1662t.cubicTo(317.91f, 34.45f, 327.48f, 47.09f, 327.26f, 71.73f);
        f1662t.cubicTo(327.59f, 78.92f, 331.34f, 88.42f, 336.14f, 93.5f);
        f1662t.cubicTo(356.91f, 114.84f, 391.78f, 106.16f, 407.99f, 99.67f);
        f1662t.cubicTo(426.04f, 92.01f, 442.01f, 80.63f, 453.09f, 63.06f);
        f1662t.cubicTo(470.62f, 64.23f, 515.77f, 134.32f, 489.84f, 164.53f);
        f1662t.cubicTo(473.77f, 181.48f, 462.58f, 167.48f, 434.13f, 190.32f);
        f1662t.cubicTo(415.16f, 208.31f, 404.66f, 232.17f, 399.92f, 269.47f);
        f1662t.cubicTo(399.8f, 299.08f, 398.47f, 323.1f, 399.65f, 366.42f);
        f1662t.cubicTo(401.46f, 414.77f, 403.78f, 512.16f, 403.78f, 512.16f);
        f1662t.lineTo(0.0f, 512.16f);
        f1662t.lineTo(0.0f, 48.71f);
        f1662t.transform(f1660m);
        c.drawPath(f1662t, f1661p);
        c.drawPath(f1662t, ps);
        c.restore();
        m1591r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.restore();
        m1591r(new Integer[0]);
        c.restore();
    }

    private static void m1591r(Integer... o) {
        f1661p.reset();
        ps.reset();
        if (cf != null) {
            f1661p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1661p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1661p.setStyle(Style.FILL);
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
