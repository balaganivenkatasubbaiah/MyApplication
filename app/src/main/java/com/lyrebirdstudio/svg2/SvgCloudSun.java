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
public class SvgCloudSun extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1684m = new Matrix();
    private static float od;
    private static final Paint f1685p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1686t = new Path();

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
        m1599r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1684m.reset();
        f1684m.setScale(od * 11.19f, od * 11.19f);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.save();
        c.save();
        c.save();
        f1685p.setColor(Color.parseColor("#000000"));
        f1686t.reset();
        f1686t.moveTo(31.41f, 5.37f);
        f1686t.lineTo(31.41f, 4.34f);
        f1686t.cubicTo(31.41f, 3.95f, 31.3f, 3.58f, 31.11f, 3.25f);
        f1686t.lineTo(29.91f, 1.25f);
        f1686t.cubicTo(29.77f, 1.02f, 29.52f, 0.89f, 29.26f, 0.89f);
        f1686t.cubicTo(28.99f, 0.89f, 28.74f, 1.03f, 28.61f, 1.25f);
        f1686t.lineTo(27.42f, 3.25f);
        f1686t.cubicTo(27.22f, 3.58f, 27.12f, 3.96f, 27.12f, 4.34f);
        f1686t.lineTo(27.12f, 5.37f);
        f1686t.cubicTo(27.79f, 5.25f, 28.53f, 5.18f, 29.27f, 5.18f);
        f1686t.cubicTo(30.0f, 5.18f, 30.7f, 5.25f, 31.41f, 5.37f);
        f1686t.transform(f1684m);
        if (clearMode) {
            f1685p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1686t, ps);
        } else {
            c.drawPath(f1686t, f1685p);
            c.drawPath(f1686t, ps);
        }
        c.restore();
        m1599r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1685p.setColor(Color.parseColor("#000000"));
        c.save();
        f1686t.reset();
        f1686t.moveTo(39.26f, 10.41f);
        f1686t.lineTo(40.0f, 9.68f);
        f1686t.cubicTo(40.27f, 9.41f, 40.46f, 9.07f, 40.55f, 8.69f);
        f1686t.lineTo(41.12f, 6.44f);
        f1686t.cubicTo(41.18f, 6.18f, 41.11f, 5.9f, 40.92f, 5.71f);
        f1686t.cubicTo(40.73f, 5.53f, 40.45f, 5.45f, 40.19f, 5.51f);
        f1686t.lineTo(37.94f, 6.08f);
        f1686t.cubicTo(37.56f, 6.17f, 37.23f, 6.37f, 36.95f, 6.64f);
        f1686t.lineTo(36.22f, 7.37f);
        f1686t.cubicTo(37.4f, 8.2f, 38.43f, 9.23f, 39.26f, 10.41f);
        f1686t.transform(f1684m);
        if (clearMode) {
            f1685p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1686t, ps);
        } else {
            c.drawPath(f1686t, f1685p);
            c.drawPath(f1686t, ps);
        }
        c.restore();
        m1599r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1686t.reset();
        f1686t.moveTo(45.38f, 16.72f);
        f1686t.lineTo(43.38f, 15.52f);
        f1686t.cubicTo(43.05f, 15.32f, 42.67f, 15.22f, 42.29f, 15.22f);
        f1686t.lineTo(41.26f, 15.22f);
        f1686t.cubicTo(41.38f, 15.92f, 41.45f, 16.65f, 41.45f, 17.38f);
        f1686t.cubicTo(41.45f, 18.12f, 41.38f, 18.84f, 41.26f, 19.55f);
        f1686t.lineTo(42.29f, 19.55f);
        f1686t.cubicTo(42.67f, 19.55f, 43.05f, 19.43f, 43.38f, 19.23f);
        f1686t.lineTo(45.38f, 18.03f);
        f1686t.cubicTo(45.6f, 17.89f, 45.74f, 17.64f, 45.74f, 17.38f);
        f1686t.cubicTo(45.74f, 17.11f, 45.6f, 16.86f, 45.38f, 16.72f);
        f1686t.transform(f1684m);
        if (clearMode) {
            f1685p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1686t, ps);
        } else {
            c.drawPath(f1686t, f1685p);
            c.drawPath(f1686t, ps);
        }
        c.restore();
        m1599r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1686t.reset();
        f1686t.moveTo(17.96f, 8.7f);
        f1686t.cubicTo(18.05f, 9.07f, 18.25f, 9.41f, 18.52f, 9.68f);
        f1686t.lineTo(19.25f, 10.41f);
        f1686t.cubicTo(20.08f, 9.23f, 21.11f, 8.2f, 22.29f, 7.37f);
        f1686t.lineTo(21.56f, 6.64f);
        f1686t.cubicTo(21.29f, 6.37f, 20.95f, 6.17f, 20.58f, 6.08f);
        f1686t.lineTo(18.32f, 5.52f);
        f1686t.cubicTo(18.06f, 5.45f, 17.78f, 5.53f, 17.6f, 5.72f);
        f1686t.cubicTo(17.41f, 5.9f, 17.33f, 6.18f, 17.4f, 6.44f);
        f1686t.lineTo(17.96f, 8.7f);
        f1686t.transform(f1684m);
        if (clearMode) {
            f1685p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1686t, ps);
        } else {
            c.drawPath(f1686t, f1685p);
            c.drawPath(f1686t, ps);
        }
        c.restore();
        m1599r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1686t.reset();
        f1686t.moveTo(40.72f, 26.73f);
        f1686t.lineTo(40.55f, 26.05f);
        f1686t.cubicTo(40.46f, 25.68f, 40.27f, 25.34f, 39.99f, 25.07f);
        f1686t.lineTo(39.26f, 24.34f);
        f1686t.cubicTo(38.99f, 24.72f, 38.71f, 25.08f, 38.4f, 25.43f);
        f1686t.cubicTo(39.23f, 25.77f, 40.01f, 26.21f, 40.72f, 26.73f);
        f1686t.transform(f1684m);
        if (clearMode) {
            f1685p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1686t, ps);
        } else {
            c.drawPath(f1686t, f1685p);
            c.drawPath(f1686t, ps);
        }
        c.restore();
        m1599r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1686t.reset();
        f1686t.moveTo(36.26f, 6.17f);
        f1686t.cubicTo(36.41f, 5.81f, 36.46f, 5.43f, 36.4f, 5.05f);
        f1686t.lineTo(36.06f, 2.75f);
        f1686t.cubicTo(36.03f, 2.48f, 35.85f, 2.26f, 35.6f, 2.15f);
        f1686t.cubicTo(35.36f, 2.05f, 35.08f, 2.08f, 34.86f, 2.24f);
        f1686t.lineTo(32.99f, 3.62f);
        f1686t.cubicTo(32.68f, 3.85f, 32.44f, 4.16f, 32.29f, 4.51f);
        f1686t.lineTo(31.89f, 5.47f);
        f1686t.cubicTo(33.33f, 5.79f, 34.67f, 6.36f, 35.86f, 7.13f);
        f1686t.lineTo(36.26f, 6.17f);
        f1686t.transform(f1684m);
        if (clearMode) {
            f1685p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1686t, ps);
        } else {
            c.drawPath(f1686t, f1685p);
            c.drawPath(f1686t, ps);
        }
        c.restore();
        m1599r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1686t.reset();
        f1686t.moveTo(39.53f, 10.82f);
        f1686t.cubicTo(40.3f, 12.02f, 40.86f, 13.36f, 41.17f, 14.8f);
        f1686t.lineTo(42.13f, 14.4f);
        f1686t.cubicTo(42.48f, 14.26f, 42.79f, 14.02f, 43.02f, 13.71f);
        f1686t.lineTo(44.41f, 11.84f);
        f1686t.cubicTo(44.57f, 11.63f, 44.61f, 11.35f, 44.51f, 11.1f);
        f1686t.cubicTo(44.4f, 10.85f, 44.18f, 10.68f, 43.91f, 10.64f);
        f1686t.lineTo(41.62f, 10.29f);
        f1686t.cubicTo(41.24f, 10.23f, 40.85f, 10.28f, 40.49f, 10.43f);
        f1686t.lineTo(39.53f, 10.82f);
        f1686t.transform(f1684m);
        if (clearMode) {
            f1685p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1686t, ps);
        } else {
            c.drawPath(f1686t, f1685p);
            c.drawPath(f1686t, ps);
        }
        c.restore();
        m1599r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1686t.reset();
        f1686t.moveTo(14.43f, 12.18f);
        f1686t.cubicTo(14.58f, 12.18f, 14.73f, 12.17f, 14.88f, 12.17f);
        f1686t.cubicTo(15.97f, 12.17f, 17.03f, 12.31f, 18.06f, 12.56f);
        f1686t.cubicTo(18.33f, 11.93f, 18.65f, 11.34f, 19.01f, 10.77f);
        f1686t.lineTo(18.05f, 10.37f);
        f1686t.cubicTo(17.7f, 10.23f, 17.31f, 10.18f, 16.93f, 10.23f);
        f1686t.lineTo(14.63f, 10.57f);
        f1686t.cubicTo(14.36f, 10.61f, 14.14f, 10.78f, 14.04f, 11.03f);
        f1686t.cubicTo(13.93f, 11.28f, 13.97f, 11.56f, 14.13f, 11.77f);
        f1686t.lineTo(14.43f, 12.18f);
        f1686t.transform(f1684m);
        if (clearMode) {
            f1685p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1686t, ps);
        } else {
            c.drawPath(f1686t, f1685p);
            c.drawPath(f1686t, ps);
        }
        c.restore();
        m1599r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1686t.reset();
        f1686t.moveTo(43.01f, 21.1f);
        f1686t.cubicTo(42.78f, 20.79f, 42.47f, 20.55f, 42.12f, 20.41f);
        f1686t.lineTo(41.16f, 20.01f);
        f1686t.cubicTo(40.84f, 21.44f, 40.27f, 22.78f, 39.5f, 23.98f);
        f1686t.lineTo(40.46f, 24.38f);
        f1686t.cubicTo(40.81f, 24.52f, 41.2f, 24.57f, 41.58f, 24.52f);
        f1686t.lineTo(43.88f, 24.18f);
        f1686t.cubicTo(44.15f, 24.14f, 44.38f, 23.97f, 44.48f, 23.72f);
        f1686t.cubicTo(44.58f, 23.47f, 44.55f, 23.19f, 44.39f, 22.98f);
        f1686t.lineTo(43.01f, 21.1f);
        f1686t.transform(f1684m);
        if (clearMode) {
            f1685p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1686t, ps);
        } else {
            c.drawPath(f1686t, f1685p);
            c.drawPath(f1686t, ps);
        }
        c.restore();
        m1599r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1686t.reset();
        f1686t.moveTo(22.7f, 7.1f);
        f1686t.cubicTo(23.9f, 6.33f, 25.24f, 5.77f, 26.68f, 5.46f);
        f1686t.lineTo(26.28f, 4.5f);
        f1686t.cubicTo(26.14f, 4.15f, 25.9f, 3.84f, 25.59f, 3.61f);
        f1686t.lineTo(23.73f, 2.22f);
        f1686t.cubicTo(23.51f, 2.06f, 23.23f, 2.03f, 22.98f, 2.13f);
        f1686t.cubicTo(22.73f, 2.23f, 22.56f, 2.45f, 22.52f, 2.72f);
        f1686t.lineTo(22.17f, 5.02f);
        f1686t.cubicTo(22.11f, 5.39f, 22.16f, 5.78f, 22.31f, 6.14f);
        f1686t.lineTo(22.7f, 7.1f);
        f1686t.transform(f1684m);
        if (clearMode) {
            f1685p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1686t, ps);
        } else {
            c.drawPath(f1686t, f1685p);
            c.drawPath(f1686t, ps);
        }
        c.restore();
        m1599r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1686t.reset();
        f1686t.moveTo(29.25f, 7.17f);
        f1686t.cubicTo(25.12f, 7.17f, 21.56f, 9.63f, 19.96f, 13.17f);
        f1686t.cubicTo(22.62f, 14.26f, 24.88f, 16.19f, 26.37f, 18.7f);
        f1686t.cubicTo(26.82f, 18.64f, 27.28f, 18.61f, 27.73f, 18.61f);
        f1686t.cubicTo(31.67f, 18.61f, 35.14f, 20.85f, 36.82f, 24.22f);
        f1686t.cubicTo(38.46f, 22.41f, 39.46f, 20.01f, 39.46f, 17.37f);
        f1686t.cubicTo(39.46f, 11.74f, 34.89f, 7.17f, 29.25f, 7.17f);
        f1686t.transform(f1684m);
        if (clearMode) {
            f1685p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1686t, ps);
        } else {
            c.drawPath(f1686t, f1685p);
            c.drawPath(f1686t, ps);
        }
        c.restore();
        m1599r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1686t.reset();
        f1686t.moveTo(34.81f, 27.59f);
        f1686t.cubicTo(34.24f, 24.19f, 31.3f, 21.59f, 27.74f, 21.59f);
        f1686t.cubicTo(26.66f, 21.59f, 25.66f, 21.83f, 24.74f, 22.25f);
        f1686t.cubicTo(23.35f, 18.13f, 19.47f, 15.16f, 14.88f, 15.16f);
        f1686t.cubicTo(9.12f, 15.16f, 4.46f, 19.82f, 4.46f, 25.58f);
        f1686t.cubicTo(4.46f, 26.55f, 4.52f, 27.49f, 4.77f, 28.38f);
        f1686t.cubicTo(2.0f, 29.71f, 0.0f, 32.54f, 0.0f, 35.82f);
        f1686t.lineTo(0.0f, 36.17f);
        f1686t.cubicTo(0.0f, 40.73f, 3.88f, 44.86f, 8.44f, 44.86f);
        f1686t.lineTo(34.12f, 44.86f);
        f1686t.cubicTo(38.68f, 44.86f, 42.32f, 40.74f, 42.32f, 36.17f);
        f1686t.lineTo(42.32f, 35.82f);
        f1686t.cubicTo(42.32f, 31.5f, 39.04f, 27.96f, 34.81f, 27.59f);
        f1686t.transform(f1684m);
        if (clearMode) {
            f1685p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1686t, ps);
        } else {
            c.drawPath(f1686t, f1685p);
            c.drawPath(f1686t, ps);
        }
        c.restore();
        m1599r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1599r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1685p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1599r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1685p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1599r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1599r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1599r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1599r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1599r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1599r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1599r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1599r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1599r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1599r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1599r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1599r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1599r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1599r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1599r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1599r(new Integer[0]);
        c.restore();
    }

    private static void m1599r(Integer... o) {
        f1685p.reset();
        ps.reset();
        if (cf != null) {
            f1685p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1685p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1685p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1685p.setColor(Color.parseColor("#000000"));
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
