package com.lyrebirdstudio.svg;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;

public class SvgWave1 extends Svg {
    private static final Matrix f1657m = new Matrix();
    private static float od;
    private static final Paint f1658p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1659t = new Path();

    public void draw(Canvas c, int w, int h) {
        draw(c, (float) w, (float) h, 0.0f, 0.0f, false);
    }

    public void draw(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        od = w / 512.0f < h / 506.0f ? w / 512.0f : h / 506.0f;
        m1590r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, (((h - (od * 506.0f)) / 2.0f) + dy) + 4.0f);
        f1657m.reset();
        f1657m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(1.0f, 1.0f);
        c.save();
        f1658p.setColor(Color.parseColor("#020202"));
        f1659t.reset();
        f1659t.moveTo(55.04f, 51.18f);
        f1659t.cubicTo(55.04f, 51.18f, 98.47f, -8.21f, 140.1f, 1.48f);
        f1659t.cubicTo(172.63f, 12.08f, 180.98f, 60.28f, 183.07f, 63.71f);
        f1659t.cubicTo(195.46f, 87.59f, 232.91f, 99.97f, 272.16f, 105.79f);
        f1659t.cubicTo(311.11f, 110.27f, 510.31f, 101.76f, 513.0f, 101.76f);
        f1659t.cubicTo(513.0f, 104.0f, 513.0f, 506.0f, 513.0f, 506.0f);
        f1659t.lineTo(5.35f, 506.0f);
        f1659t.cubicTo(5.35f, 506.0f, -3.6f, 275.01f, 2.67f, 247.25f);
        f1659t.cubicTo(5.8f, 230.69f, 17.44f, 170.25f, 72.95f, 163.99f);
        f1659t.cubicTo(132.49f, 152.35f, 78.32f, 54.76f, 55.04f, 51.18f);
        f1659t.transform(f1657m);
        c.drawPath(f1659t, f1658p);
        c.drawPath(f1659t, ps);
        c.restore();
        m1590r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        f1658p.setColor(Color.parseColor("#020202"));
        c.restore();
        m1590r(new Integer[0]);
        c.restore();
    }

    private static void m1590r(Integer... o) {
        f1658p.reset();
        ps.reset();
        if (cf != null) {
            f1658p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1658p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1658p.setStyle(Style.FILL);
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
