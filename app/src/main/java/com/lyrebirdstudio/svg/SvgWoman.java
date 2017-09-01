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

public class SvgWoman extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1669m = new Matrix();
    private static float od;
    private static final Paint f1670p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1671t = new Path();

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
        m1594r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1669m.reset();
        f1669m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(1.34f, 1.34f);
        c.save();
        c.save();
        f1670p.setColor(Color.parseColor("#000000"));
        f1671t.reset();
        f1671t.moveTo(347.17f, 286.09f);
        f1671t.cubicTo(347.17f, 286.09f, 363.4f, 281.58f, 362.32f, 274.24f);
        f1671t.cubicTo(355.22f, 278.58f, 338.6f, 264.42f, 338.6f, 264.42f);
        f1671t.cubicTo(338.6f, 264.42f, 346.77f, 250.23f, 346.23f, 232.78f);
        f1671t.cubicTo(345.68f, 215.34f, 343.91f, 198.57f, 343.91f, 198.57f);
        f1671t.cubicTo(343.91f, 198.57f, 353.88f, 210.15f, 366.51f, 198.91f);
        f1671t.cubicTo(341.6f, 186.7f, 343.1f, 170.19f, 345.84f, 159.54f);
        f1671t.cubicTo(348.56f, 148.91f, 359.36f, 99.78f, 318.15f, 61.96f);
        f1671t.cubicTo(291.06f, 38.43f, 276.02f, 59.5f, 276.02f, 59.5f);
        f1671t.cubicTo(276.02f, 59.5f, 272.04f, 52.65f, 267.03f, 52.94f);
        f1671t.cubicTo(262.02f, 53.26f, 258.45f, 58.68f, 258.45f, 58.68f);
        f1671t.cubicTo(258.45f, 58.68f, 255.59f, 49.98f, 251.08f, 51.22f);
        f1671t.cubicTo(246.59f, 52.44f, 245.36f, 56.63f, 245.36f, 56.63f);
        f1671t.cubicTo(245.36f, 56.63f, 240.44f, 30.45f, 185.65f, 7.43f);
        f1671t.cubicTo(130.82f, -15.59f, 58.84f, 21.05f, 43.71f, 34.13f);
        f1671t.cubicTo(28.57f, 47.22f, 22.85f, 51.32f, 27.75f, 66.86f);
        f1671t.cubicTo(29.48f, 72.31f, 32.3f, 74.29f, 35.33f, 74.64f);
        f1671t.cubicTo(23.95f, 99.92f, 30.0f, 130.91f, 34.41f, 142.26f);
        f1671t.cubicTo(34.63f, 143.12f, 34.76f, 144.05f, 34.95f, 144.97f);
        f1671t.cubicTo(31.72f, 145.46f, 27.11f, 145.06f, 23.38f, 139.79f);
        f1671t.cubicTo(21.77f, 147.59f, 30.23f, 149.05f, 35.53f, 149.25f);
        f1671t.cubicTo(35.95f, 154.5f, 35.25f, 160.11f, 31.7f, 165.44f);
        f1671t.cubicTo(23.9f, 177.15f, 15.17f, 182.52f, 12.36f, 190.37f);
        f1671t.cubicTo(8.36f, 201.34f, 29.41f, 203.25f, 29.41f, 203.25f);
        f1671t.lineTo(29.46f, 207.42f);
        f1671t.cubicTo(29.46f, 207.42f, 22.72f, 213.96f, 24.15f, 219.08f);
        f1671t.cubicTo(26.06f, 225.89f, 39.62f, 223.47f, 39.62f, 223.47f);
        f1671t.cubicTo(39.62f, 223.47f, 26.6f, 228.27f, 27.2f, 234.62f);
        f1671t.cubicTo(27.82f, 240.96f, 33.26f, 243.71f, 33.26f, 243.71f);
        f1671t.cubicTo(33.26f, 243.71f, 20.66f, 268.49f, 39.21f, 273.96f);
        f1671t.cubicTo(57.75f, 279.4f, 95.38f, 256.77f, 100.28f, 283.22f);
        f1671t.cubicTo(105.02f, 301.46f, 126.14f, 346.26f, 118.82f, 354.67f);
        f1671t.cubicTo(111.5f, 363.05f, 100.28f, 375.92f, 100.28f, 375.92f);
        f1671t.lineTo(292.78f, 381.92f);
        f1671t.cubicTo(292.78f, 381.92f, 233.33f, 305.02f, 227.34f, 296.31f);
        f1671t.cubicTo(224.14f, 291.66f, 231.17f, 287.78f, 241.72f, 281.56f);
        f1671t.cubicTo(245.44f, 300.41f, 256.15f, 340.27f, 282.14f, 356.85f);
        f1671t.cubicTo(316.77f, 378.94f, 334.76f, 359.29f, 333.68f, 351.54f);
        f1671t.cubicTo(315.13f, 363.13f, 311.19f, 340.89f, 311.19f, 340.89f);
        f1671t.cubicTo(311.19f, 340.89f, 342.12f, 350.58f, 343.09f, 331.49f);
        f1671t.cubicTo(317.86f, 339.68f, 312.0f, 292.64f, 312.0f, 292.64f);
        f1671t.cubicTo(312.0f, 292.64f, 360.94f, 343.5f, 370.07f, 290.19f);
        f1671t.cubicTo(354.13f, 308.06f, 347.17f, 286.09f, 347.17f, 286.09f);
        f1671t.transform(f1669m);
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1671t, ps);
        } else {
            c.drawPath(f1671t, f1670p);
            c.drawPath(f1671t, ps);
        }
        c.restore();
        m1594r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1670p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1594r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1670p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1594r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1594r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1594r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1594r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1594r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1594r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1594r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1594r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1594r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1594r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1594r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1594r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1594r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1594r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1594r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1594r(new Integer[0]);
        c.restore();
    }

    private static void m1594r(Integer... o) {
        f1670p.reset();
        ps.reset();
        if (cf != null) {
            f1670p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1670p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1670p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1670p.setColor(Color.parseColor("#000000"));
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
