package com.lyrebirdstudio.svg;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;

public class SvgStoneTest extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1636m = new Matrix();
    private static float od;
    private static final Paint f1637p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1638t = new Path();

    public static void setColorTint(int color) {
        cf = new PorterDuffColorFilter(color, Mode.SRC_IN);
    }

    public static void clearColorTint(int color) {
        cf = null;
    }

    public void draw(Canvas c, int w, int h) {
        draw(c, (float) w, (float) h, 0.0f, 0.0f, false);
    }

    public void draw(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        od = w / 511.0f < h / 511.0f ? w / 511.0f : h / 511.0f;
        m1583r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 511.0f)) / 2.0f) + dx, ((h - (od * 511.0f)) / 2.0f) + dy);
        f1636m.reset();
        f1636m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(1.0f, 1.0f);
        c.save();
        f1638t.reset();
        f1638t.moveTo(212.62f, 45.88f);
        f1638t.cubicTo(256.63f, 28.27f, 334.75f, -10.24f, 429.36f, 43.67f);
        f1638t.cubicTo(523.98f, 97.58f, 529.91f, 235.63f, 449.17f, 355.04f);
        f1638t.cubicTo(371.05f, 470.56f, 286.34f, 602.59f, 75.09f, 411.15f);
        f1638t.cubicTo(1.38f, 325.33f, 1.38f, 237.31f, 12.38f, 205.41f);
        f1638t.cubicTo(27.78f, 141.59f, 212.62f, 45.88f, 212.62f, 45.88f);
        f1638t.transform(f1636m);
        c.drawPath(f1638t, f1637p);
        c.drawPath(f1638t, ps);
        c.restore();
        m1583r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.restore();
        m1583r(new Integer[0]);
        c.restore();
    }

    private static void m1583r(Integer... o) {
        f1637p.reset();
        ps.reset();
        if (cf != null) {
            f1637p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1637p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1637p.setStyle(Style.FILL);
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
