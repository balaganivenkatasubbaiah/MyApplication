package com.lyrebirdstudio.svg;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;

public class Svg4Circle3 extends Svg {
    private static final Matrix f1447m = new Matrix();
    private static float od;
    private static final Paint f1448p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1449t = new Path();

    public void draw(Canvas c, int w, int h) {
        draw(c, (float) w, (float) h, 0.0f, 0.0f, false);
    }

    public void draw(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        od = w / 512.0f < h / 501.0f ? w / 512.0f : h / 501.0f;
        m1520r(new Integer[0]);
        c.save();
        c.translate((((w - (od * 512.0f)) / 2.0f) + dx) + 5.0f, (((h - (od * 501.0f)) / 2.0f) + dy) - 13.0f);
        f1447m.reset();
        f1447m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.translate(0.06f * od, 0.0f);
        c.scale(1.0f, 1.0f);
        c.save();
        f1449t.reset();
        f1449t.moveTo(86.33f, 209.26f);
        f1449t.cubicTo(77.27f, 135.35f, 56.38f, 48.53f, 1.93f, 0.13f);
        f1449t.lineTo(511.98f, 0.13f);
        f1449t.lineTo(511.98f, 428.96f);
        f1449t.cubicTo(524.52f, 419.53f, 420.03f, 499.26f, 298.57f, 500.78f);
        f1449t.cubicTo(197.56f, 501.28f, 123.99f, 479.05f, 50.34f, 431.56f);
        f1449t.cubicTo(74.07f, 384.91f, 94.13f, 300.95f, 86.33f, 209.26f);
        f1449t.transform(f1447m);
        c.drawPath(f1449t, f1448p);
        c.drawPath(f1449t, ps);
        c.restore();
        m1520r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.restore();
        m1520r(new Integer[0]);
        c.restore();
    }

    private static void m1520r(Integer... o) {
        f1448p.reset();
        ps.reset();
        if (cf != null) {
            f1448p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1448p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1448p.setStyle(Style.FILL);
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
