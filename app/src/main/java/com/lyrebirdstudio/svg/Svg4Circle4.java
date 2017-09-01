package com.lyrebirdstudio.svg;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;

public class Svg4Circle4 extends Svg {
    private static final Matrix f1450m = new Matrix();
    private static float od;
    private static final Paint f1451p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1452t = new Path();

    public void draw(Canvas c, int w, int h) {
        draw(c, (float) w, (float) h, 0.0f, 0.0f, false);
    }

    public void draw(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        od = w / 505.0f < h / 509.0f ? w / 505.0f : h / 509.0f;
        m1521r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 505.0f)) / 2.0f) + dx, (((h - (od * 509.0f)) / 2.0f) + dy) + 8.0f);
        f1450m.reset();
        f1450m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.translate(0.31f * od, 0.0f);
        c.scale(1.0f, 1.0f);
        c.save();
        f1452t.reset();
        f1452t.moveTo(505.13f, 510.13f);
        f1452t.lineTo(174.9f, 510.13f);
        f1452t.cubicTo(174.9f, 510.13f, 181.3f, 466.75f, 180.05f, 419.08f);
        f1452t.cubicTo(178.65f, 372.13f, 167.75f, 324.94f, 160.63f, 306.14f);
        f1452t.cubicTo(149.72f, 270.56f, 122.11f, 219.27f, 80.34f, 175.14f);
        f1452t.cubicTo(45.06f, 137.08f, 18.26f, 120.72f, 0.16f, 108.66f);
        f1452t.cubicTo(18.93f, 91.16f, 36.43f, 70.39f, 49.47f, 51.34f);
        f1452t.cubicTo(64.46f, 29.45f, 74.41f, 9.7f, 79.06f, 0.05f);
        f1452t.cubicTo(94.33f, 9.55f, 132.21f, 34.01f, 188.48f, 49.6f);
        f1452t.cubicTo(216.29f, 57.3f, 249.52f, 61.44f, 287.33f, 63.41f);
        f1452t.cubicTo(314.14f, 64.8f, 353.01f, 62.54f, 398.03f, 48.32f);
        f1452t.cubicTo(448.48f, 32.63f, 492.25f, 6.38f, 504.43f, -2.5f);
        f1452t.lineTo(505.13f, 510.13f);
        f1452t.transform(f1450m);
        c.drawPath(f1452t, f1451p);
        c.drawPath(f1452t, ps);
        c.restore();
        m1521r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.restore();
        m1521r(new Integer[0]);
        c.restore();
    }

    private static void m1521r(Integer... o) {
        f1451p.reset();
        ps.reset();
        if (cf != null) {
            f1451p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1451p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1451p.setStyle(Style.FILL);
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
