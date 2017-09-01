package com.lyrebirdstudio.svg;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;

public class SvgStone3 extends Svg {
    private static final Matrix f1621m = new Matrix();
    private static float od;
    private static final Paint f1622p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1623t = new Path();

    public void draw(Canvas c, int w, int h) {
        draw(c, (float) w, (float) h, 0.0f, 0.0f, false);
    }

    public void draw(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        od = w / 483.0f < h / 512.0f ? w / 483.0f : h / 512.0f;
        m1578r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 483.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1621m.reset();
        f1621m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.translate(0.0f, 0.18f * od);
        c.scale(1.0f, 1.0f);
        c.save();
        f1622p.setColor(Color.parseColor("#010101"));
        f1623t.reset();
        f1623t.moveTo(147.94f, 1.5f);
        f1623t.cubicTo(273.85f, -13.19f, 423.01f, 82.98f, 465.86f, 176.72f);
        f1623t.cubicTo(516.22f, 286.89f, 444.88f, 390.76f, 407.1f, 427.49f);
        f1623t.cubicTo(369.33f, 464.21f, 288.54f, 549.2f, 163.68f, 493.59f);
        f1623t.cubicTo(71.35f, 442.17f, 3.67f, 272.2f, 0.0f, 201.9f);
        f1623t.cubicTo(4.2f, 157.83f, -7.34f, 37.17f, 147.94f, 1.5f);
        f1623t.transform(f1621m);
        c.drawPath(f1623t, f1622p);
        c.drawPath(f1623t, ps);
        c.restore();
        m1578r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        f1622p.setColor(Color.parseColor("#010101"));
        c.restore();
        m1578r(new Integer[0]);
        c.restore();
    }

    private static void m1578r(Integer... o) {
        f1622p.reset();
        ps.reset();
        if (cf != null) {
            f1622p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1622p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1622p.setStyle(Style.FILL);
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
