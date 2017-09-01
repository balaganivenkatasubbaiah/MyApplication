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

public class SvgSun2 extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1642m = new Matrix();
    private static float od;
    private static final Paint f1643p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1644t = new Path();

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
        m1585r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1642m.reset();
        f1642m.setScale(od * 10.45f, od * 10.45f);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.save();
        c.save();
        f1643p.setColor(Color.parseColor("#000000"));
        f1644t.reset();
        f1644t.moveTo(39.53f, 18.11f);
        f1644t.cubicTo(36.0f, 9.81f, 26.41f, 5.94f, 18.11f, 9.46f);
        f1644t.cubicTo(9.81f, 12.99f, 5.94f, 22.58f, 9.47f, 30.89f);
        f1644t.cubicTo(12.99f, 39.19f, 22.58f, 43.06f, 30.88f, 39.53f);
        f1644t.cubicTo(39.19f, 36.0f, 43.06f, 26.41f, 39.53f, 18.11f);
        f1644t.moveTo(21.88f, 12.62f);
        f1644t.cubicTo(14.46f, 15.77f, 10.66f, 23.84f, 12.64f, 31.41f);
        f1644t.cubicTo(12.35f, 30.92f, 12.09f, 30.41f, 11.86f, 29.87f);
        f1644t.cubicTo(8.89f, 22.89f, 12.14f, 14.82f, 19.13f, 11.86f);
        f1644t.cubicTo(22.21f, 10.55f, 25.5f, 10.45f, 28.47f, 11.35f);
        f1644t.cubicTo(26.27f, 11.31f, 24.03f, 11.7f, 21.88f, 12.62f);
        f1644t.moveTo(49.0f, 24.88f);
        f1644t.cubicTo(49.0f, 24.79f, 49.0f, 24.69f, 48.99f, 24.59f);
        f1644t.cubicTo(47.85f, 24.02f, 46.54f, 22.61f, 45.34f, 20.67f);
        f1644t.cubicTo(45.77f, 18.43f, 46.49f, 16.65f, 47.36f, 15.7f);
        f1644t.cubicTo(47.33f, 15.61f, 47.3f, 15.52f, 47.26f, 15.43f);
        f1644t.cubicTo(45.94f, 15.32f, 44.13f, 14.45f, 42.23f, 13.02f);
        f1644t.cubicTo(41.71f, 10.71f, 41.65f, 8.7f, 42.09f, 7.45f);
        f1644t.cubicTo(42.02f, 7.38f, 41.96f, 7.31f, 41.89f, 7.24f);
        f1644t.cubicTo(40.67f, 7.65f, 38.75f, 7.57f, 36.53f, 7.05f);
        f1644t.cubicTo(35.26f, 5.16f, 34.5f, 3.39f, 34.45f, 2.11f);
        f1644t.cubicTo(34.36f, 2.07f, 34.27f, 2.03f, 34.18f, 2.0f);
        f1644t.cubicTo(33.17f, 2.85f, 31.28f, 3.51f, 28.92f, 3.85f);
        f1644t.cubicTo(26.91f, 2.58f, 25.45f, 1.2f, 24.88f, 0.0f);
        f1644t.cubicTo(24.78f, -0.0f, 24.69f, 0.0f, 24.59f, 0.0f);
        f1644t.cubicTo(24.02f, 1.15f, 22.6f, 2.45f, 20.67f, 3.65f);
        f1644t.cubicTo(18.43f, 3.22f, 16.65f, 2.5f, 15.7f, 1.63f);
        f1644t.cubicTo(15.61f, 1.67f, 15.52f, 1.7f, 15.43f, 1.73f);
        f1644t.cubicTo(15.33f, 3.06f, 14.45f, 4.87f, 13.02f, 6.77f);
        f1644t.cubicTo(10.71f, 7.29f, 8.7f, 7.35f, 7.45f, 6.91f);
        f1644t.cubicTo(7.38f, 6.97f, 7.31f, 7.04f, 7.25f, 7.11f);
        f1644t.cubicTo(7.65f, 8.33f, 7.58f, 10.25f, 7.05f, 12.47f);
        f1644t.cubicTo(5.16f, 13.75f, 3.39f, 14.5f, 2.11f, 14.55f);
        f1644t.cubicTo(2.07f, 14.64f, 2.04f, 14.73f, 2.0f, 14.82f);
        f1644t.cubicTo(2.85f, 15.83f, 3.51f, 17.73f, 3.85f, 20.08f);
        f1644t.cubicTo(2.58f, 22.09f, 1.2f, 23.55f, 0.0f, 24.12f);
        f1644t.cubicTo(-0.0f, 24.21f, 0.0f, 24.31f, 0.0f, 24.41f);
        f1644t.cubicTo(1.15f, 24.98f, 2.46f, 26.39f, 3.66f, 28.33f);
        f1644t.cubicTo(3.22f, 30.56f, 2.5f, 32.35f, 1.63f, 33.29f);
        f1644t.cubicTo(1.67f, 33.39f, 1.7f, 33.48f, 1.74f, 33.56f);
        f1644t.cubicTo(3.06f, 33.67f, 4.87f, 34.54f, 6.77f, 35.97f);
        f1644t.cubicTo(7.29f, 38.29f, 7.35f, 40.3f, 6.91f, 41.55f);
        f1644t.cubicTo(6.98f, 41.62f, 7.04f, 41.69f, 7.11f, 41.75f);
        f1644t.cubicTo(8.33f, 41.35f, 10.25f, 41.42f, 12.47f, 41.94f);
        f1644t.cubicTo(13.75f, 43.83f, 14.5f, 45.61f, 14.55f, 46.89f);
        f1644t.cubicTo(14.64f, 46.93f, 14.73f, 46.96f, 14.82f, 47.0f);
        f1644t.cubicTo(15.83f, 46.14f, 17.72f, 45.48f, 20.08f, 45.15f);
        f1644t.cubicTo(22.09f, 46.42f, 23.55f, 47.8f, 24.12f, 49.0f);
        f1644t.cubicTo(24.21f, 49.0f, 24.31f, 48.99f, 24.41f, 48.99f);
        f1644t.cubicTo(24.98f, 47.85f, 26.39f, 46.54f, 28.33f, 45.34f);
        f1644t.cubicTo(30.56f, 45.77f, 32.35f, 46.49f, 33.3f, 47.36f);
        f1644t.cubicTo(33.39f, 47.33f, 33.48f, 47.3f, 33.56f, 47.26f);
        f1644t.cubicTo(33.67f, 45.94f, 34.55f, 44.13f, 35.98f, 42.23f);
        f1644t.cubicTo(38.29f, 41.71f, 40.3f, 41.65f, 41.55f, 42.09f);
        f1644t.cubicTo(41.62f, 42.02f, 41.69f, 41.96f, 41.76f, 41.89f);
        f1644t.cubicTo(41.35f, 40.67f, 41.42f, 38.75f, 41.94f, 36.53f);
        f1644t.cubicTo(43.84f, 35.26f, 45.61f, 34.5f, 46.89f, 34.45f);
        f1644t.cubicTo(46.93f, 34.36f, 46.96f, 34.27f, 47.0f, 34.18f);
        f1644t.cubicTo(46.15f, 33.17f, 45.48f, 31.27f, 45.15f, 28.92f);
        f1644t.cubicTo(46.42f, 26.91f, 47.8f, 25.45f, 49.0f, 24.88f);
        f1644t.moveTo(42.1f, 27.12f);
        f1644t.cubicTo(42.04f, 27.52f, 41.98f, 27.92f, 41.9f, 28.31f);
        f1644t.cubicTo(41.83f, 28.62f, 41.74f, 28.92f, 41.65f, 29.23f);
        f1644t.cubicTo(41.59f, 29.48f, 41.53f, 29.72f, 41.45f, 29.96f);
        f1644t.cubicTo(41.34f, 30.3f, 41.21f, 30.64f, 41.08f, 30.97f);
        f1644t.cubicTo(41.0f, 31.17f, 40.93f, 31.37f, 40.85f, 31.57f);
        f1644t.cubicTo(40.71f, 31.89f, 40.55f, 32.19f, 40.4f, 32.5f);
        f1644t.cubicTo(40.29f, 32.71f, 40.19f, 32.93f, 40.08f, 33.13f);
        f1644t.cubicTo(39.94f, 33.4f, 39.77f, 33.65f, 39.61f, 33.9f);
        f1644t.cubicTo(39.46f, 34.14f, 39.32f, 34.39f, 39.16f, 34.62f);
        f1644t.cubicTo(39.02f, 34.82f, 38.87f, 35.01f, 38.73f, 35.2f);
        f1644t.cubicTo(38.52f, 35.47f, 38.32f, 35.75f, 38.09f, 36.01f);
        f1644t.cubicTo(37.97f, 36.16f, 37.84f, 36.29f, 37.72f, 36.43f);
        f1644t.cubicTo(37.45f, 36.72f, 37.19f, 37.01f, 36.9f, 37.28f);
        f1644t.cubicTo(36.79f, 37.39f, 36.67f, 37.5f, 36.55f, 37.6f);
        f1644t.cubicTo(36.24f, 37.88f, 35.94f, 38.16f, 35.62f, 38.42f);
        f1644t.cubicTo(35.47f, 38.53f, 35.31f, 38.64f, 35.17f, 38.75f);
        f1644t.cubicTo(34.86f, 38.98f, 34.56f, 39.2f, 34.23f, 39.42f);
        f1644t.cubicTo(33.97f, 39.59f, 33.7f, 39.73f, 33.43f, 39.89f);
        f1644t.cubicTo(33.21f, 40.02f, 32.99f, 40.16f, 32.76f, 40.29f);
        f1644t.cubicTo(32.24f, 40.56f, 31.71f, 40.81f, 31.16f, 41.03f);
        f1644t.cubicTo(30.03f, 41.48f, 28.88f, 41.81f, 27.72f, 42.02f);
        f1644t.cubicTo(26.56f, 42.24f, 25.37f, 42.34f, 24.15f, 42.31f);
        f1644t.cubicTo(23.55f, 42.3f, 22.96f, 42.25f, 22.38f, 42.19f);
        f1644t.cubicTo(22.17f, 42.16f, 21.97f, 42.12f, 21.77f, 42.09f);
        f1644t.cubicTo(21.41f, 42.03f, 21.04f, 41.98f, 20.69f, 41.9f);
        f1644t.cubicTo(20.36f, 41.83f, 20.03f, 41.73f, 19.7f, 41.63f);
        f1644t.cubicTo(19.48f, 41.57f, 19.26f, 41.52f, 19.04f, 41.45f);
        f1644t.cubicTo(18.68f, 41.34f, 18.33f, 41.2f, 17.98f, 41.06f);
        f1644t.cubicTo(17.8f, 40.98f, 17.61f, 40.92f, 17.43f, 40.84f);
        f1644t.cubicTo(17.1f, 40.7f, 16.78f, 40.53f, 16.46f, 40.37f);
        f1644t.cubicTo(16.26f, 40.27f, 16.06f, 40.18f, 15.87f, 40.08f);
        f1644t.cubicTo(15.6f, 39.92f, 15.34f, 39.75f, 15.07f, 39.59f);
        f1644t.cubicTo(14.84f, 39.44f, 14.61f, 39.31f, 14.38f, 39.15f);
        f1644t.cubicTo(14.17f, 39.01f, 13.97f, 38.85f, 13.77f, 38.7f);
        f1644t.cubicTo(13.51f, 38.49f, 13.24f, 38.3f, 12.99f, 38.09f);
        f1644t.cubicTo(12.84f, 37.96f, 12.69f, 37.81f, 12.54f, 37.68f);
        f1644t.cubicTo(12.26f, 37.42f, 11.98f, 37.17f, 11.72f, 36.9f);
        f1644t.cubicTo(11.6f, 36.77f, 11.48f, 36.64f, 11.36f, 36.5f);
        f1644t.cubicTo(11.09f, 36.21f, 10.83f, 35.92f, 10.58f, 35.61f);
        f1644t.cubicTo(10.45f, 35.45f, 10.33f, 35.27f, 10.2f, 35.1f);
        f1644t.cubicTo(9.99f, 34.81f, 9.78f, 34.53f, 9.58f, 34.23f);
        f1644t.cubicTo(9.39f, 33.93f, 9.21f, 33.61f, 9.03f, 33.3f);
        f1644t.cubicTo(8.93f, 33.11f, 8.81f, 32.94f, 8.72f, 32.76f);
        f1644t.cubicTo(8.45f, 32.24f, 8.19f, 31.7f, 7.97f, 31.15f);
        f1644t.cubicTo(7.51f, 30.02f, 7.18f, 28.86f, 6.97f, 27.71f);
        f1644t.cubicTo(6.76f, 26.56f, 6.66f, 25.36f, 6.68f, 24.15f);
        f1644t.cubicTo(6.7f, 23.55f, 6.74f, 22.96f, 6.81f, 22.38f);
        f1644t.cubicTo(6.83f, 22.16f, 6.88f, 21.94f, 6.92f, 21.72f);
        f1644t.cubicTo(6.97f, 21.37f, 7.02f, 21.03f, 7.09f, 20.69f);
        f1644t.cubicTo(7.17f, 20.34f, 7.27f, 20.0f, 7.36f, 19.66f);
        f1644t.cubicTo(7.42f, 19.45f, 7.47f, 19.24f, 7.53f, 19.04f);
        f1644t.cubicTo(7.65f, 18.67f, 7.8f, 18.31f, 7.94f, 17.94f);
        f1644t.cubicTo(8.01f, 17.77f, 8.07f, 17.6f, 8.14f, 17.43f);
        f1644t.cubicTo(8.29f, 17.09f, 8.46f, 16.76f, 8.63f, 16.43f);
        f1644t.cubicTo(8.72f, 16.24f, 8.81f, 16.05f, 8.91f, 15.87f);
        f1644t.cubicTo(9.07f, 15.59f, 9.24f, 15.31f, 9.42f, 15.03f);
        f1644t.cubicTo(9.55f, 14.82f, 9.68f, 14.6f, 9.83f, 14.38f);
        f1644t.cubicTo(9.98f, 14.16f, 10.15f, 13.95f, 10.31f, 13.73f);
        f1644t.cubicTo(10.5f, 13.48f, 10.69f, 13.23f, 10.89f, 12.99f);
        f1644t.cubicTo(11.03f, 12.82f, 11.19f, 12.66f, 11.34f, 12.5f);
        f1644t.cubicTo(11.58f, 12.24f, 11.82f, 11.97f, 12.08f, 11.72f);
        f1644t.cubicTo(12.22f, 11.58f, 12.38f, 11.45f, 12.53f, 11.32f);
        f1644t.cubicTo(12.8f, 11.07f, 13.07f, 10.82f, 13.36f, 10.59f);
        f1644t.cubicTo(13.55f, 10.44f, 13.75f, 10.3f, 13.95f, 10.16f);
        f1644t.cubicTo(14.21f, 9.96f, 14.47f, 9.76f, 14.74f, 9.58f);
        f1644t.cubicTo(15.07f, 9.37f, 15.41f, 9.18f, 15.76f, 8.98f);
        f1644t.cubicTo(15.91f, 8.9f, 16.06f, 8.8f, 16.22f, 8.71f);
        f1644t.cubicTo(16.74f, 8.44f, 17.28f, 8.19f, 17.84f, 7.97f);
        f1644t.cubicTo(18.97f, 7.51f, 20.12f, 7.18f, 21.27f, 6.97f);
        f1644t.cubicTo(22.43f, 6.75f, 23.62f, 6.65f, 24.84f, 6.68f);
        f1644t.cubicTo(25.44f, 6.69f, 26.03f, 6.73f, 26.61f, 6.8f);
        f1644t.cubicTo(26.8f, 6.83f, 26.99f, 6.87f, 27.18f, 6.9f);
        f1644t.cubicTo(27.56f, 6.95f, 27.93f, 7.01f, 28.3f, 7.09f);
        f1644t.cubicTo(28.62f, 7.16f, 28.94f, 7.26f, 29.26f, 7.35f);
        f1644t.cubicTo(29.5f, 7.41f, 29.73f, 7.46f, 29.95f, 7.54f);
        f1644t.cubicTo(30.31f, 7.65f, 30.65f, 7.79f, 31.0f, 7.92f);
        f1644t.cubicTo(31.18f, 8.0f, 31.38f, 8.06f, 31.56f, 8.14f);
        f1644t.cubicTo(31.89f, 8.28f, 32.21f, 8.45f, 32.52f, 8.61f);
        f1644t.cubicTo(32.72f, 8.71f, 32.92f, 8.8f, 33.12f, 8.91f);
        f1644t.cubicTo(33.39f, 9.06f, 33.66f, 9.23f, 33.92f, 9.39f);
        f1644t.cubicTo(34.15f, 9.54f, 34.39f, 9.68f, 34.61f, 9.83f);
        f1644t.cubicTo(34.83f, 9.98f, 35.03f, 10.14f, 35.23f, 10.3f);
        f1644t.cubicTo(35.49f, 10.49f, 35.75f, 10.68f, 36.0f, 10.89f);
        f1644t.cubicTo(36.17f, 11.03f, 36.32f, 11.18f, 36.48f, 11.33f);
        f1644t.cubicTo(36.75f, 11.57f, 37.01f, 11.81f, 37.26f, 12.07f);
        f1644t.cubicTo(37.41f, 12.22f, 37.54f, 12.37f, 37.67f, 12.53f);
        f1644t.cubicTo(37.92f, 12.8f, 38.17f, 13.07f, 38.4f, 13.35f);
        f1644t.cubicTo(38.56f, 13.55f, 38.7f, 13.77f, 38.85f, 13.97f);
        f1644t.cubicTo(39.04f, 14.22f, 39.23f, 14.47f, 39.4f, 14.73f);
        f1644t.cubicTo(39.64f, 15.09f, 39.86f, 15.48f, 40.07f, 15.86f);
        f1644t.cubicTo(40.13f, 15.98f, 40.21f, 16.09f, 40.27f, 16.2f);
        f1644t.cubicTo(40.54f, 16.73f, 40.79f, 17.27f, 41.02f, 17.83f);
        f1644t.cubicTo(41.47f, 18.97f, 41.81f, 20.12f, 42.02f, 21.28f);
        f1644t.cubicTo(42.23f, 22.43f, 42.33f, 23.62f, 42.3f, 24.83f);
        f1644t.cubicTo(42.29f, 25.44f, 42.25f, 26.03f, 42.18f, 26.61f);
        f1644t.cubicTo(42.16f, 26.79f, 42.13f, 26.95f, 42.1f, 27.12f);
        f1644t.transform(f1642m);
        if (clearMode) {
            f1643p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1644t, ps);
        } else {
            c.drawPath(f1644t, f1643p);
            c.drawPath(f1644t, ps);
        }
        c.restore();
        m1585r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1643p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1585r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1643p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1585r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1585r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1585r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1585r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1585r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1585r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1585r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1585r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1585r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1585r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1585r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1585r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1585r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1585r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1585r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1585r(new Integer[0]);
        c.restore();
    }

    private static void m1585r(Integer... o) {
        f1643p.reset();
        ps.reset();
        if (cf != null) {
            f1643p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1643p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1643p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1643p.setColor(Color.parseColor("#000000"));
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
