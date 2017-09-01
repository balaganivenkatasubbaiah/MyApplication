package com.lyrebirdstudio.svg;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;

public class Svg5Circle2 extends Svg {
    private static final Matrix f1456m = new Matrix();
    private static float od;
    private static final Paint f1457p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1458t = new Path();

    public void draw(Canvas c, int w, int h) {
        draw(c, (float) w, (float) h, 0.0f, 0.0f, false);
    }

    public void draw(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        od = w / 511.0f < h / 509.0f ? w / 511.0f : h / 509.0f;
        m1523r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 511.0f)) / 2.0f) + dx, ((h - (od * 509.0f)) / 2.0f) + dy);
        f1456m.reset();
        f1456m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.translate(0.28f * od, 0.0f);
        c.scale(1.0f, 1.0f);
        c.save();
        f1457p.setColor(Color.parseColor("#020202"));
        f1458t.reset();
        f1458t.moveTo(511.45f, 509.03f);
        f1458t.lineTo(511.45f, 0.0f);
        f1458t.cubicTo(511.45f, 0.0f, 410.81f, 75.48f, 328.06f, 61.94f);
        f1458t.cubicTo(337.74f, 105.0f, 207.1f, 124.36f, 180.48f, 186.77f);
        f1458t.cubicTo(134.03f, 253.55f, 64.36f, 342.58f, 63.87f, 340.64f);
        f1458t.cubicTo(70.16f, 379.35f, 39.28f, 473.3f, 0.0f, 510.0f);
        f1458t.lineTo(511.45f, 509.03f);
        f1458t.transform(f1456m);
        c.drawPath(f1458t, f1457p);
        c.drawPath(f1458t, ps);
        c.restore();
        m1523r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        f1457p.setColor(Color.parseColor("#020202"));
        c.restore();
        m1523r(new Integer[0]);
        c.restore();
    }

    private static void m1523r(Integer... o) {
        f1457p.reset();
        ps.reset();
        if (cf != null) {
            f1457p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1457p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1457p.setStyle(Style.FILL);
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
