package com.lyrebirdstudio.svg;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;

public class Svg3Block1 extends Svg {
    private static final Matrix f1414m = new Matrix();
    private static float od;
    private static final Paint f1415p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1416t = new Path();

    public void draw(Canvas c, int w, int h) {
        draw(c, (float) w, (float) h, 0.0f, 0.0f, false);
    }

    public void draw(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        od = w / 375.0f < h / 511.0f ? w / 375.0f : h / 511.0f;
        m1509r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 375.0f)) / 2.0f) + dx, ((h - (od * 511.0f)) / 2.0f) + dy);
        f1414m.reset();
        f1414m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.translate(0.0f, 0.54f * od);
        c.scale(1.0f, 1.0f);
        c.save();
        f1416t.reset();
        f1416t.moveTo(375.79f, 511.0f);
        f1416t.cubicTo(375.79f, 511.0f, 375.79f, 147.7f, 375.79f, 107.8f);
        f1416t.cubicTo(374.83f, 84.34f, 360.7f, 3.84f, 269.09f, 0.0f);
        f1416t.lineTo(0.01f, 0.0f);
        f1416t.cubicTo(0.01f, 0.0f, 0.43f, 375.23f, 0.01f, 387.16f);
        f1416t.cubicTo(-0.4f, 404.85f, 7.42f, 502.36f, 110.69f, 510.18f);
        f1416t.cubicTo(111.51f, 510.59f, 375.79f, 511.0f, 375.79f, 511.0f);
        f1416t.transform(f1414m);
        c.drawPath(f1416t, f1415p);
        c.drawPath(f1416t, ps);
        c.restore();
        m1509r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.restore();
        m1509r(new Integer[0]);
        c.restore();
    }

    private static void m1509r(Integer... o) {
        f1415p.reset();
        ps.reset();
        if (cf != null) {
            f1415p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1415p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1415p.setStyle(Style.FILL);
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
