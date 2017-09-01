package com.lyrebirdstudio.svg;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;

public class Svg5Circle5 extends Svg {
    private static final Matrix f1465m = new Matrix();
    private static float od;
    private static final Paint f1466p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1467t = new Path();

    public void draw(Canvas c, int w, int h) {
        draw(c, (float) w, (float) h, 0.0f, 0.0f, false);
    }

    public void draw(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        od = w / 511.0f < h / 511.0f ? w / 511.0f : h / 511.0f;
        m1526r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 511.0f)) / 2.0f) + dx, ((h - (od * 511.0f)) / 2.0f) + dy);
        f1465m.reset();
        f1465m.setScale(od, od);
        c.save();
        if (clearMode) {
            f1466p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(1.0f, 1.0f);
        c.save();
        f1467t.reset();
        f1467t.moveTo(511.99f, 256.0f);
        f1467t.cubicTo(511.99f, 133.64f, 426.15f, 31.36f, 311.41f, 6.03f);
        f1467t.cubicTo(293.56f, 2.09f, 275.03f, 0.0f, 256.0f, 0.0f);
        f1467t.cubicTo(116.25f, 0.0f, 2.67f, 111.98f, 0.06f, 251.11f);
        f1467t.cubicTo(0.03f, 252.74f, 0.0f, 254.36f, 0.0f, 256.0f);
        f1467t.cubicTo(0.0f, 397.38f, 114.61f, 511.99f, 256.0f, 511.99f);
        f1467t.cubicTo(292.7f, 511.99f, 327.6f, 504.25f, 359.16f, 490.33f);
        f1467t.cubicTo(447.54f, 451.37f, 509.71f, 363.88f, 511.92f, 261.62f);
        f1467t.cubicTo(511.96f, 259.75f, 511.99f, 257.88f, 511.99f, 256.0f);
        f1467t.transform(f1465m);
        c.drawPath(f1467t, f1466p);
        c.drawPath(f1467t, ps);
        c.restore();
        m1526r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.restore();
        m1526r(new Integer[0]);
        c.restore();
    }

    private static void m1526r(Integer... o) {
        f1466p.reset();
        ps.reset();
        if (cf != null) {
            f1466p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1466p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1466p.setStyle(Style.FILL);
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
