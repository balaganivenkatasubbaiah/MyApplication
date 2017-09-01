package com.lyrebirdstudio.svg;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;

public class SvgPaperCut3 extends Svg {
    private static final Matrix f1591m = new Matrix();
    private static float od;
    private static final Paint f1592p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1593t = new Path();

    public void draw(Canvas c, int w, int h) {
        draw(c, (float) w, (float) h, 0.0f, 0.0f, false);
    }

    public void draw(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        od = w / 512.0f < h / 501.0f ? w / 512.0f : h / 501.0f;
        m1568r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 501.0f)) / 2.0f) + dy);
        f1591m.reset();
        f1591m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.translate(0.38f * od, 0.0f);
        c.scale(1.0f, 1.0f);
        c.translate(1.8f * od, -9.75f * od);
        c.save();
        f1593t.reset();
        f1593t.moveTo(-1.77f, 269.73f);
        f1593t.cubicTo(-1.77f, 269.73f, 211.7f, 38.57f, 244.72f, 12.62f);
        f1593t.cubicTo(277.74f, -13.32f, 499.47f, 144.71f, 510.08f, 252.04f);
        f1593t.cubicTo(517.88f, 330.89f, 348.51f, 481.43f, 240.4f, 511.5f);
        f1593t.cubicTo(196.76f, 467.86f, -1.77f, 269.73f, -1.77f, 269.73f);
        f1593t.transform(f1591m);
        c.drawPath(f1593t, f1592p);
        c.drawPath(f1593t, ps);
        c.restore();
        m1568r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.restore();
        m1568r(new Integer[0]);
        c.restore();
    }

    private static void m1568r(Integer... o) {
        f1592p.reset();
        ps.reset();
        if (cf != null) {
            f1592p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1592p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1592p.setStyle(Style.FILL);
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
