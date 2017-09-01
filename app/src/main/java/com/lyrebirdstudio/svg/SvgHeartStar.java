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

public class SvgHeartStar extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1561m = new Matrix();
    private static float od;
    private static final Paint f1562p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1563t = new Path();

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
        m1558r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1561m.reset();
        f1561m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(1.72f, 1.72f);
        c.save();
        c.save();
        c.save();
        f1562p.setColor(Color.parseColor("#000000"));
        f1563t.reset();
        f1563t.moveTo(171.77f, 242.26f);
        f1563t.cubicTo(171.45f, 244.31f, 172.28f, 245.52f, 173.73f, 245.52f);
        f1563t.cubicTo(174.26f, 245.52f, 174.88f, 245.36f, 175.55f, 245.01f);
        f1563t.lineTo(209.66f, 227.73f);
        f1563t.cubicTo(210.92f, 227.09f, 212.58f, 226.77f, 214.23f, 226.77f);
        f1563t.cubicTo(215.89f, 226.77f, 217.55f, 227.09f, 218.81f, 227.73f);
        f1563t.lineTo(252.91f, 245.01f);
        f1563t.cubicTo(253.59f, 245.36f, 254.2f, 245.52f, 254.74f, 245.52f);
        f1563t.cubicTo(256.19f, 245.52f, 257.02f, 244.31f, 256.7f, 242.26f);
        f1563t.lineTo(250.8f, 204.49f);
        f1563t.cubicTo(250.37f, 201.7f, 251.64f, 197.78f, 253.63f, 195.78f);
        f1563t.lineTo(280.61f, 168.69f);
        f1563t.cubicTo(282.6f, 166.69f, 281.95f, 164.69f, 279.16f, 164.24f);
        f1563t.lineTo(241.41f, 158.18f);
        f1563t.cubicTo(238.62f, 157.73f, 235.29f, 155.31f, 234.0f, 152.8f);
        f1563t.lineTo(216.57f, 118.77f);
        f1563t.cubicTo(215.93f, 117.51f, 215.08f, 116.88f, 214.23f, 116.88f);
        f1563t.cubicTo(213.39f, 116.88f, 212.54f, 117.51f, 211.9f, 118.77f);
        f1563t.lineTo(194.46f, 152.8f);
        f1563t.cubicTo(193.18f, 155.31f, 189.85f, 157.73f, 187.06f, 158.18f);
        f1563t.lineTo(149.31f, 164.24f);
        f1563t.cubicTo(146.52f, 164.69f, 145.87f, 166.69f, 147.86f, 168.69f);
        f1563t.lineTo(174.84f, 195.78f);
        f1563t.cubicTo(176.83f, 197.78f, 178.1f, 201.7f, 177.67f, 204.49f);
        f1563t.lineTo(171.77f, 242.26f);
        f1563t.transform(f1561m);
        if (clearMode) {
            f1562p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1563t, ps);
        } else {
            c.drawPath(f1563t, f1562p);
            c.drawPath(f1563t, ps);
        }
        c.restore();
        m1558r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1562p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1558r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1562p.setColor(Color.parseColor("#000000"));
        c.save();
        c.save();
        f1563t.reset();
        f1563t.moveTo(285.54f, 151.19f);
        f1563t.cubicTo(293.14f, 134.89f, 297.0f, 118.56f, 297.0f, 102.42f);
        f1563t.cubicTo(297.0f, 58.65f, 261.39f, 23.04f, 217.62f, 23.04f);
        f1563t.cubicTo(188.01f, 23.04f, 162.14f, 39.33f, 148.5f, 63.41f);
        f1563t.cubicTo(134.85f, 39.33f, 108.98f, 23.04f, 79.38f, 23.04f);
        f1563t.cubicTo(35.61f, 23.04f, 0.0f, 58.65f, 0.0f, 102.42f);
        f1563t.cubicTo(0.0f, 125.5f, 7.85f, 148.98f, 23.32f, 172.19f);
        f1563t.cubicTo(35.34f, 190.21f, 51.99f, 208.15f, 72.81f, 225.5f);
        f1563t.cubicTo(107.88f, 254.73f, 142.46f, 272.15f, 143.91f, 272.88f);
        f1563t.cubicTo(145.35f, 273.6f, 146.93f, 273.96f, 148.5f, 273.96f);
        f1563t.cubicTo(150.07f, 273.96f, 151.64f, 273.6f, 153.09f, 272.88f);
        f1563t.cubicTo(153.82f, 272.51f, 162.97f, 267.9f, 176.35f, 259.68f);
        f1563t.cubicTo(175.48f, 259.81f, 174.61f, 259.89f, 173.73f, 259.89f);
        f1563t.cubicTo(168.93f, 259.89f, 164.41f, 257.82f, 161.34f, 254.23f);
        f1563t.cubicTo(158.08f, 250.42f, 156.74f, 245.38f, 157.57f, 240.05f);
        f1563t.lineTo(163.14f, 204.4f);
        f1563t.lineTo(137.68f, 178.83f);
        f1563t.cubicTo(132.87f, 173.99f, 131.16f, 167.5f, 133.13f, 161.45f);
        f1563t.cubicTo(135.09f, 155.4f, 140.29f, 151.14f, 147.03f, 150.05f);
        f1563t.lineTo(182.66f, 144.33f);
        f1563t.lineTo(199.11f, 112.22f);
        f1563t.cubicTo(202.22f, 106.14f, 207.87f, 102.52f, 214.23f, 102.52f);
        f1563t.cubicTo(220.59f, 102.52f, 226.25f, 106.14f, 229.36f, 112.22f);
        f1563t.lineTo(245.81f, 144.33f);
        f1563t.lineTo(285.54f, 151.19f);
        f1563t.transform(f1561m);
        if (clearMode) {
            f1562p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1563t, ps);
        } else {
            c.drawPath(f1563t, f1562p);
            c.drawPath(f1563t, ps);
        }
        c.restore();
        m1558r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1558r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1558r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1562p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1558r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1558r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1558r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1558r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1558r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1558r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1558r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1558r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1558r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1558r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1558r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1558r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1558r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1558r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1558r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1558r(new Integer[0]);
        c.restore();
    }

    private static void m1558r(Integer... o) {
        f1562p.reset();
        ps.reset();
        if (cf != null) {
            f1562p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1562p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1562p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1562p.setColor(Color.parseColor("#000000"));
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
