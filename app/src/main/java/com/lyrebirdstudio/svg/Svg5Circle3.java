package com.lyrebirdstudio.svg;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;

public class Svg5Circle3 extends Svg {
    private static final Matrix f1459m = new Matrix();
    private static float od;
    private static final Paint f1460p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1461t = new Path();

    public void draw(Canvas c, int w, int h) {
        draw(c, (float) w, (float) h, 0.0f, 0.0f, false);
    }

    public void draw(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        od = w / 512.0f < h / 512.0f ? w / 512.0f : h / 512.0f;
        m1524r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1459m.reset();
        f1459m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.translate(0.13f * od, 0.0f);
        c.scale(1.0f, 1.0f);
        c.save();
        f1461t.reset();
        f1461t.moveTo(512.33f, 448.7f);
        f1461t.cubicTo(512.33f, 448.7f, 499.13f, 456.93f, 479.36f, 469.7f);
        f1461t.cubicTo(448.92f, 486.73f, 387.33f, 516.39f, 338.16f, 512.17f);
        f1461t.cubicTo(310.11f, 483.15f, 241.38f, 395.1f, 241.38f, 395.1f);
        f1461t.lineTo(179.39f, 303.59f);
        f1461t.lineTo(104.6f, 238.64f);
        f1461t.lineTo(0.3f, 176.65f);
        f1461t.cubicTo(0.3f, 176.65f, -2.33f, 149.75f, 8.0f, 112.36f);
        f1461t.cubicTo(18.54f, 71.88f, 39.38f, 29.88f, 64.44f, 1.15f);
        f1461t.lineTo(511.51f, 0.0f);
        f1461t.lineTo(512.33f, 448.7f);
        f1461t.transform(f1459m);
        c.drawPath(f1461t, f1460p);
        c.drawPath(f1461t, ps);
        c.restore();
        m1524r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.restore();
        m1524r(new Integer[0]);
        c.restore();
    }

    private static void m1524r(Integer... o) {
        f1460p.reset();
        ps.reset();
        if (cf != null) {
            f1460p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1460p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1460p.setStyle(Style.FILL);
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
