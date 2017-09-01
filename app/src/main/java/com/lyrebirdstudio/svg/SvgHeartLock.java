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

public class SvgHeartLock extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1555m = new Matrix();
    private static float od;
    private static final Paint f1556p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1557t = new Path();

    public void drawStroke(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        isStroke = true;
        draw(c, w, h, dx, dy, clearMode);
        isStroke = false;
    }

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
        m1556r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1555m.reset();
        f1555m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(2.3f, 2.3f);
        c.save();
        f1556p.setColor(Color.parseColor("#000000"));
        f1557t.reset();
        f1557t.moveTo(209.13f, 109.1f);
        f1557t.cubicTo(208.4f, 94.01f, 202.5f, 79.82f, 192.8f, 69.14f);
        f1557t.cubicTo(186.55f, 62.27f, 178.84f, 57.32f, 170.84f, 54.59f);
        f1557t.lineTo(170.84f, 0.0f);
        f1557t.lineTo(49.84f, 0.0f);
        f1557t.lineTo(49.84f, 54.96f);
        f1557t.cubicTo(42.84f, 57.75f, 35.21f, 62.55f, 29.22f, 69.14f);
        f1557t.cubicTo(19.52f, 79.82f, 13.87f, 94.01f, 13.14f, 109.1f);
        f1557t.cubicTo(12.42f, 124.12f, 15.9f, 137.18f, 24.33f, 151.47f);
        f1557t.cubicTo(37.9f, 174.46f, 105.64f, 218.63f, 108.52f, 220.5f);
        f1557t.lineTo(111.25f, 222.27f);
        f1557t.lineTo(113.98f, 220.5f);
        f1557t.cubicTo(116.84f, 218.64f, 184.33f, 174.65f, 197.98f, 151.46f);
        f1557t.cubicTo(206.41f, 137.15f, 209.84f, 124.08f, 209.13f, 109.1f);
        f1557t.moveTo(100.77f, 132.88f);
        f1557t.cubicTo(98.27f, 130.04f, 96.98f, 126.53f, 96.98f, 123.0f);
        f1557t.cubicTo(96.98f, 115.28f, 103.35f, 109.0f, 111.13f, 109.0f);
        f1557t.cubicTo(118.76f, 109.0f, 124.99f, 115.28f, 124.99f, 123.0f);
        f1557t.cubicTo(124.99f, 127.12f, 123.45f, 130.4f, 120.74f, 132.74f);
        f1557t.lineTo(118.84f, 134.24f);
        f1557t.lineTo(118.84f, 162.0f);
        f1557t.lineTo(101.84f, 162.0f);
        f1557t.lineTo(101.84f, 134.3f);
        f1557t.lineTo(100.77f, 132.88f);
        f1557t.moveTo(145.84f, 25.0f);
        f1557t.lineTo(145.84f, 53.09f);
        f1557t.cubicTo(129.84f, 56.17f, 116.94f, 65.85f, 110.92f, 71.16f);
        f1557t.cubicTo(104.92f, 65.66f, 91.84f, 55.65f, 74.84f, 52.86f);
        f1557t.lineTo(74.84f, 25.0f);
        f1557t.lineTo(145.84f, 25.0f);
        f1557t.transform(f1555m);
        if (clearMode) {
            f1556p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1557t, ps);
        } else {
            c.drawPath(f1557t, f1556p);
            c.drawPath(f1557t, ps);
        }
        c.restore();
        m1556r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1556p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1556r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1556r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1556r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1556r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1556r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1556r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1556r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1556r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1556r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1556r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1556r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1556r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1556r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1556r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1556r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1556r(new Integer[0]);
        c.restore();
    }

    private static void m1556r(Integer... o) {
        f1556p.reset();
        ps.reset();
        if (cf != null) {
            f1556p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1556p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1556p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1556p.setColor(Color.parseColor("#000000"));
                    break;
                case 1:
                    ps.setStrokeJoin(Join.MITER);
                    break;
                case 2:
                    ps.setStrokeMiter(4.0f * od);
                    break;
                case 3:
                    ps.setStrokeCap(Cap.BUTT);
                    break;
                case 4:
                    ps.setColor(Color.argb(0, 0, 0, 0));
                    break;
                default:
                    break;
            }
        }
    }
}
