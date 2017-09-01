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

public class SvgHeartCare extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1552m = new Matrix();
    private static float od;
    private static final Paint f1553p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1554t = new Path();

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
        m1555r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1552m.reset();
        f1552m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(2.62f, 2.62f);
        c.save();
        c.save();
        f1553p.setColor(Color.parseColor("#000000"));
        f1554t.reset();
        f1554t.moveTo(6.17f, 98.51f);
        f1554t.lineTo(68.88f, 98.51f);
        f1554t.lineTo(78.74f, 52.06f);
        f1554t.cubicTo(79.24f, 49.7f, 81.34f, 48.02f, 83.77f, 48.1f);
        f1554t.cubicTo(86.18f, 48.16f, 88.2f, 49.94f, 88.57f, 52.32f);
        f1554t.lineTo(96.79f, 104.66f);
        f1554t.lineTo(101.91f, 88.33f);
        f1554t.cubicTo(102.51f, 86.42f, 104.18f, 85.06f, 106.16f, 84.85f);
        f1554t.cubicTo(108.14f, 84.64f, 110.06f, 85.63f, 111.04f, 87.37f);
        f1554t.lineTo(118.23f, 100.13f);
        f1554t.lineTo(188.58f, 99.59f);
        f1554t.cubicTo(191.39f, 94.11f, 193.46f, 88.12f, 194.48f, 81.49f);
        f1554t.cubicTo(197.34f, 63.05f, 192.57f, 44.49f, 181.74f, 31.85f);
        f1554t.cubicTo(172.14f, 20.66f, 158.49f, 14.74f, 142.28f, 14.74f);
        f1554t.cubicTo(117.11f, 14.74f, 102.82f, 31.64f, 97.65f, 39.26f);
        f1554t.cubicTo(92.48f, 31.64f, 78.18f, 14.74f, 53.02f, 14.74f);
        f1554t.cubicTo(36.8f, 14.74f, 23.16f, 20.66f, 13.56f, 31.85f);
        f1554t.cubicTo(2.73f, 44.49f, -2.04f, 63.05f, 0.81f, 81.49f);
        f1554t.cubicTo(1.77f, 87.68f, 3.63f, 93.33f, 6.17f, 98.51f);
        f1554t.transform(f1552m);
        if (clearMode) {
            f1553p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1554t, ps);
        } else {
            c.drawPath(f1554t, f1553p);
            c.drawPath(f1554t, ps);
        }
        c.restore();
        m1555r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1553p.setColor(Color.parseColor("#000000"));
        c.save();
        f1554t.reset();
        f1554t.moveTo(115.36f, 110.16f);
        f1554t.cubicTo(113.57f, 110.13f, 111.86f, 109.2f, 110.97f, 107.61f);
        f1554t.lineTo(108.0f, 102.34f);
        f1554t.lineTo(99.93f, 128.05f);
        f1554t.cubicTo(99.27f, 130.15f, 97.33f, 131.55f, 95.16f, 131.55f);
        f1554t.cubicTo(95.04f, 131.55f, 94.91f, 131.55f, 94.79f, 131.54f);
        f1554t.cubicTo(92.47f, 131.37f, 90.58f, 129.62f, 90.22f, 127.33f);
        f1554t.lineTo(82.89f, 80.65f);
        f1554t.lineTo(77.82f, 104.55f);
        f1554t.cubicTo(77.33f, 106.86f, 75.29f, 108.51f, 72.93f, 108.51f);
        f1554t.lineTo(12.25f, 108.51f);
        f1554t.cubicTo(24.14f, 124.72f, 42.53f, 135.64f, 57.25f, 144.37f);
        f1554t.cubicTo(64.46f, 148.64f, 71.28f, 152.68f, 76.01f, 156.55f);
        f1554t.cubicTo(93.51f, 170.82f, 95.11f, 178.02f, 95.17f, 178.32f);
        f1554t.cubicTo(95.32f, 179.57f, 96.38f, 180.56f, 97.64f, 180.56f);
        f1554t.cubicTo(98.94f, 180.56f, 100.01f, 179.62f, 100.13f, 178.33f);
        f1554t.cubicTo(100.14f, 178.26f, 101.5f, 171.06f, 119.28f, 156.55f);
        f1554t.cubicTo(124.02f, 152.68f, 130.84f, 148.64f, 138.05f, 144.37f);
        f1554t.cubicTo(152.42f, 135.84f, 170.3f, 125.23f, 182.2f, 109.64f);
        f1554t.lineTo(115.36f, 110.16f);
        f1554t.transform(f1552m);
        if (clearMode) {
            f1553p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1554t, ps);
        } else {
            c.drawPath(f1554t, f1553p);
            c.drawPath(f1554t, ps);
        }
        c.restore();
        m1555r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1555r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1553p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1555r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1555r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1555r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1555r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1555r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1555r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1555r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1555r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1555r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1555r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1555r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1555r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1555r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1555r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1555r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1555r(new Integer[0]);
        c.restore();
    }

    private static void m1555r(Integer... o) {
        f1553p.reset();
        ps.reset();
        if (cf != null) {
            f1553p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1553p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1553p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1553p.setColor(Color.parseColor("#000000"));
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
