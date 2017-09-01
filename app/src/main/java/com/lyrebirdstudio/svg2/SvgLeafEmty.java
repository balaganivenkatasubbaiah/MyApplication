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
public class SvgLeafEmty extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1720m = new Matrix();
    private static float od;
    private static final Paint f1721p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1722t = new Path();

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
        m1611r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1720m.reset();
        f1720m.setScale(od * 6.13f, od * 6.13f);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.save();
        c.save();
        c.save();
        f1721p.setColor(Color.parseColor("#000000"));
        f1722t.reset();
        f1722t.moveTo(83.46f, 41.73f);
        f1722t.cubicTo(83.46f, 18.68f, 64.78f, 0.0f, 41.73f, 0.0f);
        f1722t.cubicTo(18.69f, 0.0f, 0.0f, 18.68f, 0.0f, 41.73f);
        f1722t.cubicTo(0.0f, 64.78f, 18.68f, 83.45f, 41.72f, 83.46f);
        f1722t.cubicTo(41.63f, 74.99f, 41.61f, 62.78f, 41.74f, 62.5f);
        f1722t.cubicTo(41.48f, 61.84f, 40.91f, 60.43f, 40.0f, 58.57f);
        f1722t.cubicTo(39.37f, 57.27f, 38.57f, 55.79f, 37.63f, 54.25f);
        f1722t.cubicTo(37.36f, 53.81f, 36.82f, 52.63f, 36.89f, 52.36f);
        f1722t.cubicTo(36.92f, 52.18f, 36.91f, 52.02f, 36.92f, 51.85f);
        f1722t.cubicTo(36.23f, 50.99f, 35.52f, 50.14f, 34.74f, 49.32f);
        f1722t.cubicTo(34.09f, 48.57f, 33.34f, 47.92f, 32.64f, 47.24f);
        f1722t.cubicTo(31.93f, 46.57f, 31.12f, 46.02f, 30.41f, 45.43f);
        f1722t.cubicTo(29.64f, 44.91f, 28.87f, 44.45f, 28.15f, 44.0f);
        f1722t.cubicTo(27.38f, 43.64f, 26.64f, 43.31f, 25.97f, 42.99f);
        f1722t.cubicTo(25.26f, 42.79f, 24.61f, 42.6f, 24.03f, 42.43f);
        f1722t.cubicTo(23.46f, 42.22f, 22.92f, 42.26f, 22.5f, 42.19f);
        f1722t.cubicTo(21.65f, 42.1f, 21.17f, 42.05f, 21.17f, 42.05f);
        f1722t.cubicTo(21.17f, 42.05f, 21.64f, 42.13f, 22.49f, 42.28f);
        f1722t.cubicTo(22.9f, 42.39f, 23.43f, 42.39f, 23.97f, 42.64f);
        f1722t.cubicTo(24.53f, 42.84f, 25.15f, 43.08f, 25.83f, 43.32f);
        f1722t.cubicTo(26.46f, 43.68f, 27.15f, 44.05f, 27.87f, 44.45f);
        f1722t.cubicTo(28.54f, 44.95f, 29.26f, 45.44f, 29.96f, 46.0f);
        f1722t.cubicTo(30.62f, 46.63f, 31.35f, 47.2f, 31.99f, 47.91f);
        f1722t.cubicTo(32.62f, 48.61f, 33.3f, 49.29f, 33.88f, 50.06f);
        f1722t.cubicTo(34.76f, 51.12f, 35.53f, 52.24f, 36.25f, 53.35f);
        f1722t.cubicTo(35.3f, 53.4f, 32.24f, 52.99f, 30.9f, 52.84f);
        f1722t.cubicTo(29.4f, 52.64f, 27.79f, 52.29f, 26.24f, 51.75f);
        f1722t.cubicTo(24.66f, 51.24f, 23.18f, 50.5f, 21.8f, 49.65f);
        f1722t.cubicTo(19.02f, 47.96f, 16.91f, 45.63f, 15.3f, 43.45f);
        f1722t.cubicTo(14.5f, 42.34f, 13.76f, 41.33f, 13.04f, 40.58f);
        f1722t.cubicTo(12.69f, 40.26f, 12.35f, 39.88f, 12.1f, 39.7f);
        f1722t.cubicTo(11.85f, 39.5f, 11.71f, 39.41f, 11.71f, 39.41f);
        f1722t.cubicTo(11.71f, 39.41f, 11.8f, 39.25f, 11.96f, 38.97f);
        f1722t.cubicTo(12.14f, 38.71f, 12.43f, 38.24f, 12.89f, 37.86f);
        f1722t.cubicTo(13.78f, 37.03f, 15.36f, 36.18f, 17.22f, 35.76f);
        f1722t.cubicTo(19.09f, 35.34f, 21.22f, 35.33f, 23.26f, 35.75f);
        f1722t.cubicTo(25.33f, 36.13f, 27.28f, 36.96f, 29.04f, 38.04f);
        f1722t.cubicTo(30.78f, 39.15f, 32.33f, 40.51f, 33.51f, 42.08f);
        f1722t.cubicTo(34.71f, 43.61f, 35.6f, 45.3f, 36.16f, 46.95f);
        f1722t.cubicTo(36.7f, 48.62f, 36.95f, 50.19f, 36.93f, 51.44f);
        f1722t.cubicTo(36.94f, 51.58f, 36.91f, 51.71f, 36.91f, 51.84f);
        f1722t.cubicTo(39.44f, 55.02f, 41.32f, 58.27f, 42.41f, 60.33f);
        f1722t.cubicTo(42.6f, 59.69f, 42.8f, 59.01f, 43.01f, 58.25f);
        f1722t.cubicTo(43.5f, 56.41f, 44.01f, 54.24f, 44.41f, 51.89f);
        f1722t.cubicTo(44.52f, 51.22f, 45.01f, 49.58f, 45.32f, 49.36f);
        f1722t.cubicTo(45.5f, 49.22f, 45.64f, 49.05f, 45.79f, 48.89f);
        f1722t.cubicTo(45.86f, 47.44f, 45.87f, 45.97f, 45.82f, 44.47f);
        f1722t.cubicTo(45.84f, 43.17f, 45.64f, 41.86f, 45.53f, 40.58f);
        f1722t.cubicTo(45.42f, 39.29f, 45.09f, 38.05f, 44.89f, 36.84f);
        f1722t.cubicTo(44.58f, 35.65f, 44.21f, 34.52f, 43.89f, 33.45f);
        f1722t.cubicTo(43.43f, 32.42f, 42.99f, 31.46f, 42.59f, 30.56f);
        f1722t.cubicTo(42.07f, 29.74f, 41.58f, 28.98f, 41.16f, 28.31f);
        f1722t.cubicTo(40.78f, 27.61f, 40.2f, 27.18f, 39.85f, 26.74f);
        f1722t.cubicTo(39.08f, 25.91f, 38.64f, 25.44f, 38.64f, 25.44f);
        f1722t.cubicTo(38.64f, 25.44f, 39.05f, 25.94f, 39.75f, 26.82f);
        f1722t.cubicTo(40.07f, 27.29f, 40.6f, 27.74f, 40.93f, 28.47f);
        f1722t.cubicTo(41.29f, 29.15f, 41.71f, 29.92f, 42.17f, 30.76f);
        f1722t.cubicTo(42.5f, 31.66f, 42.85f, 32.64f, 43.23f, 33.67f);
        f1722t.cubicTo(43.45f, 34.74f, 43.74f, 35.86f, 43.95f, 37.03f);
        f1722t.cubicTo(44.06f, 38.22f, 44.29f, 39.43f, 44.31f, 40.68f);
        f1722t.cubicTo(44.33f, 41.93f, 44.42f, 43.2f, 44.32f, 44.47f);
        f1722t.cubicTo(44.28f, 46.29f, 44.06f, 48.07f, 43.81f, 49.81f);
        f1722t.cubicTo(42.83f, 49.03f, 40.13f, 45.96f, 38.93f, 44.63f);
        f1722t.cubicTo(37.61f, 43.13f, 36.32f, 41.39f, 35.24f, 39.5f);
        f1722t.cubicTo(34.12f, 37.63f, 33.29f, 35.59f, 32.65f, 33.56f);
        f1722t.cubicTo(31.36f, 29.45f, 31.28f, 25.3f, 31.58f, 21.74f);
        f1722t.cubicTo(31.75f, 19.94f, 31.88f, 18.29f, 31.82f, 16.92f);
        f1722t.cubicTo(31.76f, 16.29f, 31.75f, 15.62f, 31.67f, 15.23f);
        f1722t.cubicTo(31.58f, 14.82f, 31.53f, 14.59f, 31.53f, 14.59f);
        f1722t.cubicTo(31.53f, 14.59f, 31.75f, 14.52f, 32.16f, 14.38f);
        f1722t.cubicTo(32.57f, 14.27f, 33.26f, 14.05f, 34.05f, 14.08f);
        f1722t.cubicTo(35.66f, 14.03f, 37.96f, 14.55f, 40.19f, 15.76f);
        f1722t.cubicTo(42.42f, 16.97f, 44.54f, 18.81f, 46.21f, 21.0f);
        f1722t.cubicTo(47.93f, 23.17f, 49.16f, 25.71f, 49.95f, 28.32f);
        f1722t.cubicTo(50.73f, 30.93f, 51.08f, 33.62f, 50.89f, 36.21f);
        f1722t.cubicTo(50.76f, 38.79f, 50.17f, 41.24f, 49.29f, 43.37f);
        f1722t.cubicTo(48.38f, 45.49f, 47.26f, 47.27f, 46.15f, 48.51f);
        f1722t.cubicTo(46.04f, 48.65f, 45.9f, 48.76f, 45.78f, 48.88f);
        f1722t.cubicTo(45.63f, 52.31f, 45.17f, 55.53f, 44.69f, 58.21f);
        f1722t.cubicTo(45.8f, 56.23f, 47.38f, 53.72f, 49.35f, 51.24f);
        f1722t.cubicTo(49.34f, 51.11f, 49.32f, 50.98f, 49.32f, 50.84f);
        f1722t.cubicTo(49.31f, 49.59f, 49.56f, 48.01f, 50.1f, 46.35f);
        f1722t.cubicTo(50.66f, 44.7f, 51.54f, 43.01f, 52.75f, 41.47f);
        f1722t.cubicTo(53.93f, 39.91f, 55.48f, 38.55f, 57.22f, 37.45f);
        f1722t.cubicTo(58.97f, 36.36f, 60.93f, 35.52f, 62.99f, 35.15f);
        f1722t.cubicTo(65.03f, 34.73f, 67.16f, 34.74f, 69.03f, 35.16f);
        f1722t.cubicTo(70.9f, 35.58f, 72.47f, 36.43f, 73.37f, 37.26f);
        f1722t.cubicTo(73.83f, 37.64f, 74.12f, 38.11f, 74.29f, 38.37f);
        f1722t.cubicTo(74.46f, 38.65f, 74.55f, 38.81f, 74.55f, 38.81f);
        f1722t.cubicTo(74.55f, 38.81f, 74.41f, 38.91f, 74.15f, 39.1f);
        f1722t.cubicTo(73.91f, 39.28f, 73.57f, 39.66f, 73.22f, 39.98f);
        f1722t.cubicTo(72.51f, 40.73f, 71.76f, 41.74f, 70.96f, 42.85f);
        f1722t.cubicTo(69.36f, 45.02f, 67.24f, 47.35f, 64.46f, 49.05f);
        f1722t.cubicTo(63.08f, 49.89f, 61.6f, 50.64f, 60.02f, 51.15f);
        f1722t.cubicTo(58.47f, 51.69f, 56.86f, 52.04f, 55.36f, 52.23f);
        f1722t.cubicTo(54.02f, 52.39f, 50.95f, 52.8f, 50.01f, 52.76f);
        f1722t.cubicTo(50.74f, 51.64f, 51.5f, 50.51f, 52.38f, 49.46f);
        f1722t.cubicTo(52.95f, 48.68f, 53.63f, 48.01f, 54.27f, 47.31f);
        f1722t.cubicTo(54.91f, 46.6f, 55.64f, 46.03f, 56.3f, 45.41f);
        f1722t.cubicTo(57.0f, 44.84f, 57.72f, 44.34f, 58.39f, 43.85f);
        f1722t.cubicTo(59.11f, 43.45f, 59.8f, 43.07f, 60.43f, 42.72f);
        f1722t.cubicTo(61.11f, 42.48f, 61.73f, 42.24f, 62.29f, 42.04f);
        f1722t.cubicTo(62.83f, 41.79f, 63.37f, 41.79f, 63.77f, 41.68f);
        f1722t.cubicTo(64.61f, 41.54f, 65.09f, 41.45f, 65.09f, 41.45f);
        f1722t.cubicTo(65.09f, 41.45f, 64.61f, 41.5f, 63.76f, 41.59f);
        f1722t.cubicTo(63.34f, 41.66f, 62.8f, 41.62f, 62.23f, 41.83f);
        f1722t.cubicTo(61.65f, 42.0f, 61.0f, 42.19f, 60.29f, 42.4f);
        f1722t.cubicTo(59.62f, 42.71f, 58.88f, 43.04f, 58.11f, 43.4f);
        f1722t.cubicTo(57.4f, 43.85f, 56.61f, 44.31f, 55.85f, 44.83f);
        f1722t.cubicTo(55.13f, 45.42f, 54.33f, 45.97f, 53.62f, 46.64f);
        f1722t.cubicTo(52.92f, 47.31f, 52.16f, 47.96f, 51.51f, 48.72f);
        f1722t.cubicTo(50.74f, 49.54f, 50.02f, 50.39f, 49.34f, 51.25f);
        f1722t.cubicTo(49.35f, 51.42f, 49.34f, 51.59f, 49.37f, 51.76f);
        f1722t.cubicTo(49.44f, 52.03f, 48.89f, 53.21f, 48.62f, 53.65f);
        f1722t.cubicTo(47.68f, 55.19f, 46.89f, 56.67f, 46.26f, 57.97f);
        f1722t.cubicTo(45.4f, 59.73f, 44.83f, 74.15f, 44.55f, 83.31f);
        f1722t.cubicTo(66.29f, 81.85f, 83.46f, 63.82f, 83.46f, 41.73f);
        f1722t.transform(f1720m);
        if (clearMode) {
            f1721p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1722t, ps);
        } else {
            c.drawPath(f1722t, f1721p);
            c.drawPath(f1722t, ps);
        }
        c.restore();
        m1611r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1721p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1611r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1721p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1611r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1721p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1611r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1611r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1611r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1611r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1611r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1611r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1611r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1611r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1611r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1611r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1611r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1611r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1611r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1611r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1611r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1611r(new Integer[0]);
        c.restore();
    }

    private static void m1611r(Integer... o) {
        f1721p.reset();
        ps.reset();
        if (cf != null) {
            f1721p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1721p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1721p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1721p.setColor(Color.parseColor("#000000"));
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
