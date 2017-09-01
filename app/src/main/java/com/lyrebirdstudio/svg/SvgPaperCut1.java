package com.lyrebirdstudio.svg;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;

public class SvgPaperCut1 extends Svg {
    private static final Matrix f1585m = new Matrix();
    private static float od;
    private static final Paint f1586p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1587t = new Path();

    public void draw(Canvas c, int w, int h) {
        draw(c, (float) w, (float) h, 0.0f, 0.0f, false);
    }

    public void draw(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        od = w / 512.0f < h / 512.0f ? w / 512.0f : h / 512.0f;
        m1566r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1585m.reset();
        f1585m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(1.0f, 1.0f);
        c.translate(1.8f * od, 0.5f * od);
        c.save();
        f1586p.setColor(Color.parseColor("#020202"));
        f1587t.reset();
        f1587t.moveTo(509.4f, 264.18f);
        f1587t.lineTo(260.89f, 511.5f);
        f1587t.cubicTo(260.89f, 511.5f, -35.89f, 356.04f, 1.79f, 232.38f);
        f1587t.cubicTo(39.48f, 108.71f, 231.75f, 1.54f, 251.47f, -0.82f);
        f1587t.cubicTo(262.06f, -2.08f, 509.4f, 264.18f, 509.4f, 264.18f);
        f1587t.transform(f1585m);
        c.drawPath(f1587t, f1586p);
        c.drawPath(f1587t, ps);
        c.restore();
        m1566r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        f1586p.setColor(Color.parseColor("#020202"));
        c.restore();
        m1566r(new Integer[0]);
        c.restore();
    }

    private static void m1566r(Integer... o) {
        f1586p.reset();
        ps.reset();
        if (cf != null) {
            f1586p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1586p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1586p.setStyle(Style.FILL);
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
