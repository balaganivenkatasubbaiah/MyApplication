package com.lyrebirdstudio.svg;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;

public class Svg3Block3 extends Svg {
    private static final Matrix f1420m = new Matrix();
    private static float od;
    private static final Paint f1421p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1422t = new Path();

    public void draw(Canvas c, int w, int h) {
        draw(c, (float) w, (float) h, 0.0f, 0.0f, false);
    }

    public void draw(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        od = w / 512.0f < h / 483.0f ? w / 512.0f : h / 483.0f;
        m1511r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 483.0f)) / 2.0f) + dy);
        f1420m.reset();
        f1420m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.translate(0.05f * od, 0.0f);
        c.scale(1.0f, 1.0f);
        c.save();
        f1421p.setColor(Color.parseColor("#010101"));
        f1422t.reset();
        f1422t.moveTo(0.68f, 483.06f);
        f1422t.cubicTo(0.68f, 483.06f, 346.1f, 483.06f, 360.41f, 483.06f);
        f1422t.cubicTo(391.75f, 484.08f, 499.4f, 456.83f, 512.0f, 347.82f);
        f1422t.cubicTo(512.0f, 326.5f, 512.0f, 0.01f, 512.0f, 0.01f);
        f1422t.cubicTo(512.0f, 0.01f, 189.06f, 0.01f, 144.1f, 0.01f);
        f1422t.cubicTo(93.34f, -1.01f, 2.73f, 53.5f, 0.0f, 142.58f);
        f1422t.cubicTo(0.0f, 182.6f, 0.68f, 483.06f, 0.68f, 483.06f);
        f1422t.transform(f1420m);
        c.drawPath(f1422t, f1421p);
        c.drawPath(f1422t, ps);
        c.restore();
        m1511r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        f1421p.setColor(Color.parseColor("#010101"));
        c.restore();
        m1511r(new Integer[0]);
        c.restore();
    }

    private static void m1511r(Integer... o) {
        f1421p.reset();
        ps.reset();
        if (cf != null) {
            f1421p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1421p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1421p.setStyle(Style.FILL);
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
