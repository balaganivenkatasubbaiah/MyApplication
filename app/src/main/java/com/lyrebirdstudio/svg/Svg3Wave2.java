package com.lyrebirdstudio.svg;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;

public class Svg3Wave2 extends Svg {
    private static final Matrix f1435m = new Matrix();
    private static float od;
    private static final Paint f1436p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1437t = new Path();

    public void draw(Canvas c, int w, int h) {
        draw(c, (float) w, (float) h, 0.0f, 0.0f, false);
    }

    public void draw(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        od = w / 513.0f < h / 266.0f ? w / 513.0f : h / 266.0f;
        m1516r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 513.0f)) / 2.0f) + dx, ((h - (od * 266.0f)) / 2.0f) + dy);
        f1435m.reset();
        f1435m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.translate(0.7f * od, 0.0f);
        c.scale(1.0f, 1.0f);
        c.save();
        f1436p.setColor(Color.parseColor("#020202"));
        f1437t.reset();
        f1437t.moveTo(0.0f, 80.87f);
        f1437t.cubicTo(0.0f, 80.87f, 48.14f, 94.08f, 123.9f, 74.96f);
        f1437t.cubicTo(183.86f, 60.36f, 239.47f, 28.22f, 264.32f, 18.22f);
        f1437t.cubicTo(307.24f, -0.8f, 334.35f, -1.15f, 358.16f, 0.76f);
        f1437t.cubicTo(391.7f, 2.32f, 431.08f, 13.48f, 452.17f, 21.27f);
        f1437t.cubicTo(464.31f, 25.18f, 476.33f, 30.01f, 486.35f, 34.31f);
        f1437t.cubicTo(502.16f, 41.11f, 513.12f, 46.75f, 513.12f, 46.75f);
        f1437t.lineTo(513.01f, 228.99f);
        f1437t.cubicTo(513.01f, 228.99f, 432.85f, 186.63f, 371.73f, 180.83f);
        f1437t.cubicTo(319.46f, 178.02f, 293.83f, 181.59f, 247.78f, 207.83f);
        f1437t.cubicTo(210.9f, 226.35f, 180.13f, 241.11f, 125.95f, 257.07f);
        f1437t.cubicTo(107.34f, 261.83f, 52.45f, 272.65f, 0.17f, 262.74f);
        f1437t.cubicTo(0.52f, 263.09f, 0.0f, 80.87f, 0.0f, 80.87f);
        f1437t.transform(f1435m);
        c.drawPath(f1437t, f1436p);
        c.drawPath(f1437t, ps);
        c.restore();
        m1516r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        f1436p.setColor(Color.parseColor("#020202"));
        c.restore();
        m1516r(new Integer[0]);
        c.restore();
    }

    private static void m1516r(Integer... o) {
        f1436p.reset();
        ps.reset();
        if (cf != null) {
            f1436p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1436p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1436p.setStyle(Style.FILL);
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
