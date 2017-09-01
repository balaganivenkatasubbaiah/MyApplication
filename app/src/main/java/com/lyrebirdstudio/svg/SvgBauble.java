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

public class SvgBauble extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1480m = new Matrix();
    private static float od;
    private static final Paint f1481p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1482t = new Path();

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
        m1531r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1480m.reset();
        f1480m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(1.14f, 1.14f);
        c.save();
        c.save();
        c.save();
        f1481p.setColor(Color.parseColor("#000000"));
        f1482t.reset();
        f1482t.moveTo(267.86f, 164.11f);
        f1482t.lineTo(267.86f, 140.07f);
        f1482t.lineTo(261.39f, 140.07f);
        f1482t.cubicTo(261.44f, 139.25f, 261.48f, 138.43f, 261.48f, 137.59f);
        f1482t.cubicTo(261.48f, 118.75f, 247.59f, 103.09f, 229.51f, 100.32f);
        f1482t.lineTo(229.51f, 90.38f);
        f1482t.lineTo(234.64f, 90.38f);
        f1482t.cubicTo(238.72f, 94.47f, 243.41f, 98.3f, 248.59f, 101.68f);
        f1482t.cubicTo(259.59f, 108.88f, 282.14f, 114.78f, 291.92f, 99.46f);
        f1482t.cubicTo(290.59f, 96.91f, 288.09f, 92.97f, 285.86f, 90.42f);
        f1482t.cubicTo(284.84f, 93.6f, 266.82f, 107.57f, 236.56f, 75.4f);
        f1482t.cubicTo(236.56f, 75.4f, 282.9f, 65.26f, 293.86f, 95.38f);
        f1482t.cubicTo(294.93f, 90.95f, 296.69f, 86.04f, 298.42f, 81.22f);
        f1482t.cubicTo(301.03f, 73.94f, 303.73f, 66.4f, 304.37f, 59.61f);
        f1482t.cubicTo(305.48f, 47.86f, 299.86f, 42.07f, 294.95f, 39.27f);
        f1482t.cubicTo(291.42f, 37.27f, 287.29f, 36.25f, 282.66f, 36.25f);
        f1482t.cubicTo(272.4f, 36.25f, 259.33f, 41.29f, 243.81f, 51.23f);
        f1482t.cubicTo(238.04f, 54.93f, 233.04f, 58.6f, 229.51f, 61.32f);
        f1482t.lineTo(229.51f, 0.0f);
        f1482t.lineTo(218.02f, 0.0f);
        f1482t.lineTo(218.02f, 61.32f);
        f1482t.cubicTo(214.49f, 58.6f, 209.49f, 54.93f, 203.72f, 51.23f);
        f1482t.cubicTo(188.2f, 41.3f, 175.13f, 36.26f, 164.87f, 36.26f);
        f1482t.cubicTo(160.24f, 36.26f, 156.11f, 37.27f, 152.58f, 39.28f);
        f1482t.cubicTo(147.67f, 42.07f, 142.05f, 47.87f, 143.16f, 59.61f);
        f1482t.cubicTo(143.8f, 66.4f, 146.5f, 73.94f, 149.11f, 81.23f);
        f1482t.cubicTo(150.84f, 86.04f, 152.6f, 90.95f, 153.67f, 95.38f);
        f1482t.cubicTo(164.63f, 65.26f, 210.97f, 75.4f, 210.97f, 75.4f);
        f1482t.cubicTo(180.71f, 107.57f, 162.68f, 93.6f, 161.67f, 90.42f);
        f1482t.cubicTo(159.43f, 92.97f, 156.94f, 96.91f, 155.61f, 99.46f);
        f1482t.cubicTo(165.39f, 114.78f, 187.94f, 108.88f, 198.94f, 101.68f);
        f1482t.cubicTo(204.11f, 98.3f, 208.81f, 94.47f, 212.89f, 90.38f);
        f1482t.lineTo(218.02f, 90.38f);
        f1482t.lineTo(218.02f, 100.32f);
        f1482t.cubicTo(199.94f, 103.09f, 186.05f, 118.75f, 186.05f, 137.59f);
        f1482t.cubicTo(186.05f, 138.43f, 186.09f, 139.25f, 186.14f, 140.07f);
        f1482t.lineTo(179.67f, 140.07f);
        f1482t.lineTo(179.67f, 164.11f);
        f1482t.cubicTo(121.08f, 182.78f, 78.64f, 237.63f, 78.64f, 302.41f);
        f1482t.cubicTo(78.64f, 382.56f, 143.62f, 447.53f, 223.77f, 447.53f);
        f1482t.cubicTo(303.92f, 447.53f, 368.89f, 382.56f, 368.89f, 302.41f);
        f1482t.cubicTo(368.89f, 237.63f, 326.45f, 182.78f, 267.86f, 164.11f);
        f1482t.moveTo(130.92f, 314.31f);
        f1482t.lineTo(115.95f, 315.24f);
        f1482t.cubicTo(115.89f, 314.42f, 114.77f, 295.13f, 120.41f, 273.0f);
        f1482t.cubicTo(128.12f, 242.76f, 144.82f, 221.82f, 168.69f, 212.45f);
        f1482t.lineTo(174.17f, 226.42f);
        f1482t.cubicTo(127.28f, 244.81f, 130.88f, 313.61f, 130.92f, 314.31f);
        f1482t.moveTo(238.74f, 140.07f);
        f1482t.lineTo(208.78f, 140.07f);
        f1482t.cubicTo(208.65f, 139.26f, 208.56f, 138.44f, 208.56f, 137.59f);
        f1482t.cubicTo(208.56f, 129.22f, 215.38f, 122.4f, 223.76f, 122.4f);
        f1482t.cubicTo(232.14f, 122.4f, 238.96f, 129.22f, 238.96f, 137.59f);
        f1482t.cubicTo(238.96f, 138.44f, 238.88f, 139.26f, 238.74f, 140.07f);
        f1482t.transform(f1480m);
        if (clearMode) {
            f1481p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1482t, ps);
        } else {
            c.drawPath(f1482t, f1481p);
            c.drawPath(f1482t, ps);
        }
        c.restore();
        m1531r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1481p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1531r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1481p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1531r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1481p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1531r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1531r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1531r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1531r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1531r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1531r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1531r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1531r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1531r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1531r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1531r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1531r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1531r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1531r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1531r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1531r(new Integer[0]);
        c.restore();
    }

    private static void m1531r(Integer... o) {
        f1481p.reset();
        ps.reset();
        if (cf != null) {
            f1481p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1481p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1481p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1481p.setColor(Color.parseColor("#000000"));
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
