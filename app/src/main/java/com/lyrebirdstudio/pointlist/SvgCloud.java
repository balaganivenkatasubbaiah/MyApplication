package com.lyrebirdstudio.pointlist;

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

public class SvgCloud extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1390m = new Matrix();
    private static float od;
    private static final Paint f1391p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1392t = new Path();

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
        od = w / 512.0f < h / 512.0f ? w / 512.0f : h / 512.0f;
        m1501r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1390m.reset();
        f1390m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(1.64f, 1.64f);
        c.save();
        c.save();
        f1391p.setColor(Color.parseColor("#010002"));
        f1392t.reset();
        f1392t.moveTo(169.13f, 285.97f);
        f1392t.cubicTo(143.05f, 285.97f, 117.84f, 275.52f, 99.27f, 257.16f);
        f1392t.cubicTo(93.07f, 259.82f, 86.35f, 261.23f, 79.57f, 261.23f);
        f1392t.cubicTo(52.15f, 261.23f, 29.85f, 238.92f, 29.85f, 211.5f);
        f1392t.cubicTo(29.85f, 208.57f, 30.13f, 205.6f, 30.67f, 202.63f);
        f1392t.cubicTo(11.39f, 188.36f, 0.0f, 165.94f, 0.0f, 141.83f);
        f1392t.cubicTo(0.0f, 103.92f, 28.62f, 71.73f, 65.85f, 66.89f);
        f1392t.cubicTo(75.18f, 42.49f, 98.41f, 26.36f, 124.84f, 26.36f);
        f1392t.cubicTo(147.92f, 26.36f, 169.02f, 38.97f, 180.08f, 58.93f);
        f1392t.cubicTo(188.06f, 56.17f, 196.37f, 54.78f, 204.88f, 54.78f);
        f1392t.cubicTo(246.83f, 54.78f, 280.95f, 88.9f, 280.95f, 130.84f);
        f1392t.cubicTo(280.95f, 132.6f, 280.88f, 134.39f, 280.72f, 136.29f);
        f1392t.cubicTo(299.56f, 143.66f, 312.33f, 162.02f, 312.33f, 182.55f);
        f1392t.cubicTo(312.33f, 211.67f, 286.99f, 235.0f, 257.48f, 232.01f);
        f1392t.cubicTo(240.5f, 264.93f, 206.3f, 285.97f, 169.13f, 285.97f);
        f1392t.transform(f1390m);
        if (clearMode) {
            f1391p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        c.drawPath(f1392t, f1391p);
        c.drawPath(f1392t, ps);
        c.restore();
        m1501r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1));
        f1391p.setColor(Color.parseColor("#010002"));
        c.restore();
        m1501r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1));
        f1391p.setColor(Color.parseColor("#010002"));
        c.save();
        c.restore();
        m1501r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1501r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1501r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1501r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1501r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1501r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1501r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1501r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1501r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1501r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1501r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1501r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1501r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1501r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1501r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.restore();
        m1501r(new Integer[0]);
        c.restore();
    }

    private static void m1501r(Integer... o) {
        f1391p.reset();
        ps.reset();
        if (cf != null) {
            f1391p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1391p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1391p.setStyle(Style.FILL);
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
                    ps.setColor(Color.argb(0, 0, 0, 0));
                    break;
                case 3:
                    ps.setStrokeCap(Cap.BUTT);
                    break;
                case 4:
                    f1391p.setColor(Color.parseColor("#010002"));
                    break;
                default:
                    break;
            }
        }
    }
}
