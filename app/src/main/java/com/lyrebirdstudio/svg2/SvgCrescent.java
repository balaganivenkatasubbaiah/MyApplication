package com.lyrebirdstudio.svg2;

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

import com.lyrebirdstudio.svg.Svg;
public class SvgCrescent extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1690m = new Matrix();
    private static float od;
    private static final Paint f1691p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1692t = new Path();

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
        m1601r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1690m.reset();
        f1690m.setScale(od * 4.29f, od * 4.29f);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.save();
        c.save();
        f1691p.setColor(Color.parseColor("#000000"));
        f1692t.reset();
        f1692t.moveTo(64.18f, 53.52f);
        f1692t.cubicTo(69.9f, 51.65f, 75.57f, 49.64f, 81.34f, 47.97f);
        f1692t.cubicTo(83.8f, 47.27f, 84.66f, 46.19f, 84.57f, 43.62f);
        f1692t.cubicTo(84.37f, 37.74f, 84.51f, 31.84f, 84.51f, 26.09f);
        f1692t.cubicTo(86.17f, 25.42f, 86.4f, 26.63f, 86.91f, 27.27f);
        f1692t.cubicTo(87.74f, 28.28f, 88.42f, 29.43f, 89.24f, 30.45f);
        f1692t.cubicTo(92.37f, 34.3f, 94.19f, 40.62f, 98.43f, 41.73f);
        f1692t.cubicTo(102.39f, 42.76f, 107.5f, 39.27f, 112.14f, 37.92f);
        f1692t.cubicTo(114.22f, 37.31f, 116.2f, 36.16f, 119.24f, 36.29f);
        f1692t.cubicTo(115.43f, 41.6f, 112.11f, 46.59f, 108.37f, 51.25f);
        f1692t.cubicTo(106.57f, 53.5f, 106.82f, 54.93f, 108.43f, 57.01f);
        f1692t.cubicTo(112.02f, 61.66f, 115.36f, 66.5f, 119.34f, 72.0f);
        f1692t.cubicTo(113.71f, 71.2f, 109.41f, 69.27f, 104.98f, 67.86f);
        f1692t.cubicTo(98.01f, 65.63f, 98.03f, 65.6f, 93.76f, 71.46f);
        f1692t.cubicTo(91.01f, 75.23f, 88.22f, 78.97f, 84.51f, 82.44f);
        f1692t.cubicTo(84.51f, 76.47f, 84.38f, 70.49f, 84.57f, 64.52f);
        f1692t.cubicTo(84.64f, 61.96f, 83.8f, 60.86f, 81.32f, 60.15f);
        f1692t.cubicTo(75.57f, 58.5f, 69.93f, 56.47f, 64.25f, 54.59f);
        f1692t.cubicTo(64.23f, 54.24f, 64.2f, 53.88f, 64.18f, 53.52f);
        f1692t.transform(f1690m);
        if (clearMode) {
            f1691p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1692t, ps);
        } else {
            c.drawPath(f1692t, f1691p);
            c.drawPath(f1692t, ps);
        }
        c.restore();
        m1601r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1691p.setColor(Color.parseColor("#000000"));
        c.save();
        f1692t.reset();
        f1692t.moveTo(67.28f, 102.62f);
        f1692t.cubicTo(42.41f, 102.62f, 22.25f, 82.46f, 22.25f, 57.58f);
        f1692t.cubicTo(22.25f, 32.71f, 42.41f, 12.54f, 67.28f, 12.54f);
        f1692t.cubicTo(67.99f, 12.54f, 68.69f, 12.56f, 69.39f, 12.6f);
        f1692t.cubicTo(63.59f, 10.29f, 57.28f, 9.01f, 50.66f, 9.01f);
        f1692t.cubicTo(22.68f, 9.01f, 0.0f, 31.69f, 0.0f, 59.67f);
        f1692t.cubicTo(0.0f, 87.65f, 22.68f, 110.33f, 50.66f, 110.33f);
        f1692t.cubicTo(61.78f, 110.33f, 72.05f, 106.74f, 80.41f, 100.67f);
        f1692t.cubicTo(76.25f, 101.94f, 71.85f, 102.62f, 67.28f, 102.62f);
        f1692t.transform(f1690m);
        if (clearMode) {
            f1691p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1692t, ps);
        } else {
            c.drawPath(f1692t, f1691p);
            c.drawPath(f1692t, ps);
        }
        c.restore();
        m1601r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1601r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1691p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1601r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1601r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1601r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1601r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1601r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1601r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1601r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1601r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1601r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1601r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1601r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1601r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1601r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1601r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1601r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1601r(new Integer[0]);
        c.restore();
    }

    private static void m1601r(Integer... o) {
        f1691p.reset();
        ps.reset();
        if (cf != null) {
            f1691p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1691p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1691p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1691p.setColor(Color.parseColor("#000000"));
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
