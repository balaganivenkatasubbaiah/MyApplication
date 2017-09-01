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

public class SvgBrokenHeart extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1492m = new Matrix();
    private static float od;
    private static final Paint f1493p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1494t = new Path();

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
        m1535r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1492m.reset();
        f1492m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(1.73f, 1.73f);
        c.save();
        c.save();
        f1493p.setColor(Color.parseColor("#000000"));
        f1494t.reset();
        f1494t.moveTo(244.5f, 16.72f);
        f1494t.cubicTo(234.71f, 13.59f, 225.51f, 12.15f, 216.94f, 12.15f);
        f1494t.cubicTo(190.94f, 12.15f, 170.73f, 25.43f, 157.17f, 45.2f);
        f1494t.cubicTo(174.62f, 71.74f, 183.09f, 90.06f, 183.48f, 90.91f);
        f1494t.cubicTo(185.06f, 94.36f, 184.01f, 98.44f, 180.96f, 100.69f);
        f1494t.lineTo(139.84f, 130.99f);
        f1494t.lineTo(176.36f, 161.97f);
        f1494t.cubicTo(178.02f, 163.38f, 179.04f, 165.41f, 179.17f, 167.58f);
        f1494t.cubicTo(179.31f, 169.75f, 178.55f, 171.88f, 177.08f, 173.49f);
        f1494t.lineTo(146.28f, 206.98f);
        f1494t.lineTo(155.75f, 231.6f);
        f1494t.cubicTo(157.34f, 235.73f, 155.28f, 240.36f, 151.16f, 241.94f);
        f1494t.cubicTo(150.22f, 242.31f, 149.24f, 242.48f, 148.29f, 242.48f);
        f1494t.cubicTo(145.07f, 242.48f, 142.04f, 240.53f, 140.82f, 237.35f);
        f1494t.lineTo(129.57f, 208.09f);
        f1494t.cubicTo(128.48f, 205.26f, 129.09f, 202.05f, 131.15f, 199.81f);
        f1494t.lineTo(159.66f, 168.79f);
        f1494t.lineTo(121.78f, 136.65f);
        f1494t.cubicTo(119.92f, 135.06f, 118.88f, 132.72f, 118.96f, 130.27f);
        f1494t.cubicTo(119.05f, 127.83f, 120.24f, 125.56f, 122.21f, 124.11f);
        f1494t.lineTo(166.07f, 91.78f);
        f1494t.cubicTo(162.86f, 85.55f, 145.35f, 56.37f, 145.18f, 56.11f);
        f1494t.cubicTo(129.74f, 32.46f, 108.06f, 12.51f, 77.45f, 12.51f);
        f1494t.cubicTo(69.6f, 12.51f, 61.17f, 13.82f, 52.09f, 16.72f);
        f1494t.cubicTo(-2.34f, 34.13f, -59.27f, 148.75f, 134.78f, 279.2f);
        f1494t.cubicTo(139.15f, 282.14f, 143.12f, 284.43f, 148.29f, 284.43f);
        f1494t.cubicTo(153.46f, 284.43f, 158.46f, 281.43f, 162.06f, 279.02f);
        f1494t.cubicTo(355.79f, 148.66f, 298.89f, 34.13f, 244.5f, 16.72f);
        f1494t.transform(f1492m);
        if (clearMode) {
            f1493p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1494t, ps);
        } else {
            c.drawPath(f1494t, f1493p);
            c.drawPath(f1494t, ps);
        }
        c.restore();
        m1535r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1493p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1535r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1493p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1535r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1535r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1535r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1535r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1535r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1535r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1535r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1535r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1535r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1535r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1535r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1535r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1535r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1535r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1535r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1535r(new Integer[0]);
        c.restore();
    }

    private static void m1535r(Integer... o) {
        f1493p.reset();
        ps.reset();
        if (cf != null) {
            f1493p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1493p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1493p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1493p.setColor(Color.parseColor("#000000"));
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
