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

public class SvgHeartBrain extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1549m = new Matrix();
    private static float od;
    private static final Paint f1550p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1551t = new Path();

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
        m1554r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1549m.reset();
        f1549m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(1.08f, 1.08f);
        c.save();
        c.save();
        c.save();
        c.save();
        f1550p.setColor(Color.parseColor("#000000"));
        f1551t.reset();
        f1551t.moveTo(441.53f, 147.98f);
        f1551t.cubicTo(433.48f, 108.49f, 438.61f, 25.75f, 301.82f, 3.94f);
        f1551t.cubicTo(165.06f, -17.91f, 41.84f, 51.5f, 72.8f, 203.16f);
        f1551t.cubicTo(72.8f, 230.82f, 18.09f, 273.71f, 31.26f, 288.22f);
        f1551t.cubicTo(44.44f, 302.75f, 66.83f, 303.31f, 66.83f, 303.31f);
        f1551t.cubicTo(66.83f, 303.31f, 52.28f, 330.92f, 58.8f, 338.56f);
        f1551t.cubicTo(65.39f, 346.21f, 83.54f, 342.94f, 83.54f, 342.94f);
        f1551t.cubicTo(83.54f, 342.94f, 66.67f, 355.13f, 66.67f, 364.57f);
        f1551t.cubicTo(66.67f, 374.0f, 95.2f, 386.59f, 95.2f, 386.59f);
        f1551t.cubicTo(95.2f, 386.59f, 89.97f, 438.92f, 132.82f, 435.3f);
        f1551t.cubicTo(175.71f, 431.65f, 182.88f, 419.57f, 182.88f, 419.57f);
        f1551t.lineTo(195.6f, 472.45f);
        f1551t.lineTo(361.47f, 472.45f);
        f1551t.lineTo(355.66f, 357.48f);
        f1551t.cubicTo(355.66f, 357.48f, 457.52f, 246.9f, 441.53f, 147.98f);
        f1551t.moveTo(322.93f, 241.73f);
        f1551t.cubicTo(319.65f, 247.29f, 318.1f, 293.04f, 317.1f, 299.16f);
        f1551t.cubicTo(316.1f, 305.27f, 300.7f, 306.6f, 296.29f, 295.83f);
        f1551t.cubicTo(292.97f, 287.72f, 282.86f, 242.31f, 278.06f, 220.34f);
        f1551t.cubicTo(260.19f, 217.11f, 246.57f, 200.54f, 246.57f, 180.56f);
        f1551t.cubicTo(246.57f, 177.49f, 246.9f, 174.5f, 247.51f, 171.62f);
        f1551t.cubicTo(246.24f, 171.75f, 244.96f, 171.82f, 243.65f, 171.82f);
        f1551t.cubicTo(232.63f, 171.82f, 222.71f, 166.8f, 215.79f, 158.79f);
        f1551t.cubicTo(209.9f, 162.82f, 202.9f, 165.17f, 195.38f, 165.17f);
        f1551t.cubicTo(178.98f, 165.17f, 165.01f, 154.05f, 159.75f, 138.49f);
        f1551t.cubicTo(159.55f, 138.49f, 159.36f, 138.49f, 159.15f, 138.48f);
        f1551t.cubicTo(138.27f, 137.39f, 122.28f, 118.45f, 123.44f, 96.19f);
        f1551t.cubicTo(123.59f, 93.5f, 123.98f, 90.88f, 124.58f, 88.36f);
        f1551t.cubicTo(126.28f, 68.58f, 152.86f, 46.71f, 189.26f, 36.76f);
        f1551t.cubicTo(219.82f, 28.41f, 248.68f, 30.81f, 263.99f, 41.36f);
        f1551t.cubicTo(269.13f, 38.57f, 274.94f, 37.0f, 281.1f, 37.0f);
        f1551t.cubicTo(298.53f, 37.0f, 313.2f, 49.54f, 317.61f, 66.62f);
        f1551t.cubicTo(319.54f, 66.3f, 321.53f, 66.13f, 323.55f, 66.13f);
        f1551t.cubicTo(341.06f, 66.13f, 355.78f, 78.79f, 360.11f, 95.99f);
        f1551t.cubicTo(380.17f, 101.28f, 395.45f, 119.49f, 397.73f, 141.85f);
        f1551t.cubicTo(406.67f, 151.48f, 412.19f, 164.71f, 412.19f, 179.31f);
        f1551t.cubicTo(412.19f, 205.18f, 394.89f, 226.73f, 371.96f, 231.56f);
        f1551t.lineTo(371.85f, 232.18f);
        f1551t.cubicTo(371.86f, 232.18f, 326.2f, 236.17f, 322.93f, 241.73f);
        f1551t.transform(f1549m);
        if (clearMode) {
            f1550p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1551t, ps);
        } else {
            c.drawPath(f1551t, f1550p);
            c.drawPath(f1551t, ps);
        }
        c.restore();
        m1554r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1550p.setColor(Color.parseColor("#000000"));
        c.save();
        f1551t.reset();
        f1551t.moveTo(315.54f, 95.69f);
        f1551t.cubicTo(314.83f, 95.61f, 314.08f, 95.57f, 313.31f, 95.57f);
        f1551t.cubicTo(305.55f, 95.57f, 297.82f, 99.21f, 293.0f, 105.0f);
        f1551t.cubicTo(288.19f, 99.21f, 280.46f, 95.57f, 272.7f, 95.57f);
        f1551t.cubicTo(271.93f, 95.57f, 271.19f, 95.61f, 270.47f, 95.69f);
        f1551t.cubicTo(261.73f, 96.63f, 255.58f, 99.58f, 251.67f, 104.71f);
        f1551t.cubicTo(247.79f, 109.8f, 246.53f, 116.7f, 247.91f, 125.22f);
        f1551t.cubicTo(249.94f, 137.57f, 265.94f, 152.62f, 278.79f, 164.71f);
        f1551t.lineTo(279.09f, 164.98f);
        f1551t.cubicTo(282.67f, 168.36f, 285.76f, 171.27f, 287.78f, 173.44f);
        f1551t.cubicTo(288.05f, 173.74f, 290.5f, 176.43f, 293.19f, 176.43f);
        f1551t.cubicTo(295.89f, 176.43f, 298.29f, 173.7f, 298.51f, 173.44f);
        f1551t.cubicTo(300.65f, 171.12f, 304.13f, 167.83f, 307.56f, 164.58f);
        f1551t.cubicTo(320.27f, 152.53f, 336.09f, 137.52f, 338.09f, 125.21f);
        f1551t.cubicTo(339.49f, 116.7f, 338.23f, 109.81f, 334.35f, 104.71f);
        f1551t.cubicTo(330.44f, 99.58f, 324.29f, 96.62f, 315.54f, 95.69f);
        f1551t.transform(f1549m);
        if (clearMode) {
            f1550p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1551t, ps);
        } else {
            c.drawPath(f1551t, f1550p);
            c.drawPath(f1551t, ps);
        }
        c.restore();
        m1554r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1554r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1550p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1554r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1550p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1554r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1550p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1554r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1554r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1554r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1554r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1554r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1554r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1554r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1554r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1554r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1554r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1554r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1554r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1554r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1554r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1554r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1554r(new Integer[0]);
        c.restore();
    }

    private static void m1554r(Integer... o) {
        f1550p.reset();
        ps.reset();
        if (cf != null) {
            f1550p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1550p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1550p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1550p.setColor(Color.parseColor("#000000"));
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
