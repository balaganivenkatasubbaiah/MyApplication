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

public class SvgBareFoot extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1474m = new Matrix();
    private static float od;
    private static final Paint f1475p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1476t = new Path();

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
        m1529r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1474m.reset();
        f1474m.setScale(od * 4.56f, od * 4.56f);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.save();
        c.save();
        f1475p.setColor(Color.parseColor("#010002"));
        f1476t.reset();
        f1476t.moveTo(107.44f, 31.47f);
        f1476t.cubicTo(108.39f, 30.16f, 109.03f, 28.5f, 109.17f, 26.64f);
        f1476t.cubicTo(109.29f, 24.84f, 108.95f, 23.1f, 108.18f, 21.62f);
        f1476t.cubicTo(107.43f, 20.2f, 106.29f, 19.15f, 104.97f, 18.5f);
        f1476t.cubicTo(104.16f, 15.06f, 101.69f, 12.52f, 98.5f, 12.16f);
        f1476t.cubicTo(96.98f, 9.03f, 94.25f, 6.96f, 91.06f, 6.96f);
        f1476t.lineTo(90.66f, 6.97f);
        f1476t.cubicTo(89.89f, 7.02f, 89.18f, 7.21f, 88.49f, 7.47f);
        f1476t.cubicTo(86.76f, 4.94f, 84.22f, 3.33f, 81.33f, 3.33f);
        f1476t.lineTo(80.9f, 3.34f);
        f1476t.cubicTo(79.33f, 3.42f, 77.92f, 4.0f, 76.7f, 4.87f);
        f1476t.cubicTo(74.17f, 1.43f, 70.53f, -0.49f, 66.73f, 0.11f);
        f1476t.cubicTo(60.56f, 1.1f, 56.89f, 7.97f, 58.19f, 16.08f);
        f1476t.cubicTo(58.86f, 20.21f, 60.74f, 23.65f, 63.24f, 25.9f);
        f1476t.cubicTo(62.34f, 27.22f, 61.68f, 28.66f, 61.4f, 30.26f);
        f1476t.cubicTo(59.84f, 39.25f, 66.4f, 44.79f, 70.74f, 48.46f);
        f1476t.cubicTo(71.71f, 49.29f, 72.64f, 50.06f, 73.39f, 50.83f);
        f1476t.cubicTo(76.05f, 53.57f, 76.51f, 58.14f, 74.43f, 61.01f);
        f1476t.cubicTo(74.28f, 61.21f, 74.04f, 61.5f, 73.74f, 61.86f);
        f1476t.cubicTo(70.67f, 65.57f, 62.51f, 75.42f, 65.7f, 86.14f);
        f1476t.cubicTo(67.51f, 92.25f, 71.75f, 96.05f, 78.29f, 97.41f);
        f1476t.cubicTo(80.12f, 97.79f, 81.87f, 97.98f, 83.51f, 97.98f);
        f1476t.cubicTo(93.39f, 97.98f, 99.48f, 91.13f, 99.81f, 79.65f);
        f1476t.cubicTo(99.93f, 75.26f, 100.62f, 71.82f, 101.98f, 68.78f);
        f1476t.cubicTo(106.45f, 58.65f, 113.68f, 42.17f, 107.44f, 31.47f);
        f1476t.moveTo(70.45f, 23.28f);
        f1476t.cubicTo(67.4f, 23.77f, 64.28f, 20.17f, 63.49f, 15.24f);
        f1476t.cubicTo(62.7f, 10.3f, 64.53f, 5.91f, 67.58f, 5.42f);
        f1476t.cubicTo(70.63f, 4.93f, 73.74f, 8.53f, 74.53f, 13.46f);
        f1476t.cubicTo(75.32f, 18.39f, 73.5f, 22.79f, 70.45f, 23.28f);
        f1476t.moveTo(81.88f, 21.2f);
        f1476t.cubicTo(79.74f, 21.32f, 77.86f, 18.62f, 77.67f, 15.16f);
        f1476t.cubicTo(77.48f, 11.71f, 79.06f, 8.82f, 81.19f, 8.7f);
        f1476t.cubicTo(83.33f, 8.58f, 85.21f, 11.29f, 85.4f, 14.74f);
        f1476t.cubicTo(85.59f, 18.19f, 84.01f, 21.09f, 81.88f, 21.2f);
        f1476t.moveTo(91.5f, 22.48f);
        f1476t.cubicTo(89.78f, 22.57f, 88.25f, 20.38f, 88.09f, 17.57f);
        f1476t.cubicTo(87.94f, 14.77f, 89.22f, 12.42f, 90.95f, 12.33f);
        f1476t.cubicTo(92.69f, 12.23f, 94.22f, 14.43f, 94.37f, 17.23f);
        f1476t.cubicTo(94.52f, 20.04f, 93.24f, 22.39f, 91.5f, 22.48f);
        f1476t.moveTo(97.3f, 24.96f);
        f1476t.cubicTo(96.02f, 24.87f, 95.1f, 23.11f, 95.25f, 21.05f);
        f1476t.cubicTo(95.4f, 18.97f, 96.55f, 17.37f, 97.83f, 17.46f);
        f1476t.cubicTo(99.11f, 17.55f, 100.03f, 19.3f, 99.89f, 21.37f);
        f1476t.cubicTo(99.74f, 23.45f, 98.58f, 25.05f, 97.3f, 24.96f);
        f1476t.moveTo(101.75f, 29.13f);
        f1476t.cubicTo(100.73f, 29.06f, 99.99f, 27.66f, 100.11f, 26.0f);
        f1476t.cubicTo(100.23f, 24.35f, 101.15f, 23.07f, 102.17f, 23.14f);
        f1476t.cubicTo(103.2f, 23.21f, 103.93f, 24.61f, 103.81f, 26.27f);
        f1476t.cubicTo(103.69f, 27.92f, 102.77f, 29.2f, 101.75f, 29.13f);
        f1476t.transform(f1474m);
        if (clearMode) {
            f1475p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1476t, ps);
        } else {
            c.drawPath(f1476t, f1475p);
            c.drawPath(f1476t, ps);
        }
        c.restore();
        m1529r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1));
        f1475p.setColor(Color.parseColor("#010002"));
        c.save();
        f1476t.reset();
        f1476t.moveTo(53.16f, 20.91f);
        f1476t.cubicTo(51.67f, 17.33f, 48.91f, 14.97f, 45.57f, 14.43f);
        f1476t.cubicTo(41.78f, 13.82f, 38.14f, 15.75f, 35.61f, 19.19f);
        f1476t.cubicTo(34.38f, 18.31f, 32.97f, 17.74f, 31.39f, 17.65f);
        f1476t.lineTo(30.97f, 17.64f);
        f1476t.cubicTo(28.08f, 17.64f, 25.54f, 19.25f, 23.81f, 21.79f);
        f1476t.cubicTo(23.12f, 21.53f, 22.4f, 21.33f, 21.63f, 21.28f);
        f1476t.lineTo(21.24f, 21.27f);
        f1476t.cubicTo(18.05f, 21.27f, 15.32f, 23.34f, 13.81f, 26.47f);
        f1476t.cubicTo(10.63f, 26.83f, 8.18f, 29.34f, 7.35f, 32.75f);
        f1476t.cubicTo(6.52f, 33.15f, 5.76f, 33.72f, 5.13f, 34.45f);
        f1476t.cubicTo(3.68f, 36.12f, 2.96f, 38.49f, 3.13f, 40.97f);
        f1476t.cubicTo(3.26f, 42.82f, 3.9f, 44.47f, 4.86f, 45.79f);
        f1476t.cubicTo(-1.38f, 56.48f, 5.85f, 72.97f, 10.33f, 83.15f);
        f1476t.cubicTo(11.68f, 86.14f, 12.37f, 89.58f, 12.5f, 93.97f);
        f1476t.cubicTo(12.83f, 105.45f, 18.93f, 112.3f, 28.8f, 112.3f);
        f1476t.cubicTo(30.43f, 112.3f, 32.19f, 112.11f, 34.02f, 111.72f);
        f1476t.cubicTo(40.55f, 110.36f, 44.78f, 106.58f, 46.61f, 100.46f);
        f1476t.cubicTo(49.79f, 89.75f, 41.64f, 79.9f, 38.57f, 76.19f);
        f1476t.cubicTo(38.27f, 75.82f, 38.02f, 75.54f, 37.87f, 75.33f);
        f1476t.cubicTo(35.79f, 72.46f, 36.26f, 67.89f, 38.92f, 65.15f);
        f1476t.cubicTo(39.66f, 64.38f, 40.6f, 63.6f, 41.57f, 62.78f);
        f1476t.cubicTo(45.91f, 59.11f, 52.46f, 53.56f, 50.9f, 44.58f);
        f1476t.cubicTo(50.62f, 42.99f, 49.97f, 41.54f, 49.06f, 40.23f);
        f1476t.cubicTo(51.56f, 37.97f, 53.45f, 34.53f, 54.1f, 30.41f);
        f1476t.cubicTo(54.65f, 27.05f, 54.31f, 23.68f, 53.16f, 20.91f);
        f1476t.moveTo(10.55f, 43.45f);
        f1476t.cubicTo(9.53f, 43.52f, 8.61f, 42.24f, 8.49f, 40.58f);
        f1476t.cubicTo(8.37f, 38.93f, 9.1f, 37.52f, 10.13f, 37.45f);
        f1476t.cubicTo(11.15f, 37.38f, 12.07f, 38.66f, 12.19f, 40.32f);
        f1476t.cubicTo(12.3f, 41.98f, 11.57f, 43.38f, 10.55f, 43.45f);
        f1476t.moveTo(15.0f, 39.28f);
        f1476t.cubicTo(13.72f, 39.37f, 12.56f, 37.76f, 12.41f, 35.69f);
        f1476t.cubicTo(12.27f, 33.61f, 13.19f, 31.86f, 14.46f, 31.77f);
        f1476t.cubicTo(15.74f, 31.68f, 16.9f, 33.29f, 17.05f, 35.36f);
        f1476t.cubicTo(17.19f, 37.43f, 16.27f, 39.19f, 15.0f, 39.28f);
        f1476t.moveTo(20.79f, 36.8f);
        f1476t.cubicTo(19.05f, 36.71f, 17.77f, 34.36f, 17.93f, 31.55f);
        f1476t.cubicTo(18.08f, 28.75f, 19.61f, 26.55f, 21.34f, 26.65f);
        f1476t.cubicTo(23.07f, 26.74f, 24.36f, 29.09f, 24.2f, 31.89f);
        f1476t.cubicTo(24.05f, 34.7f, 22.52f, 36.89f, 20.79f, 36.8f);
        f1476t.moveTo(30.42f, 35.52f);
        f1476t.cubicTo(28.28f, 35.4f, 26.71f, 32.51f, 26.9f, 29.05f);
        f1476t.cubicTo(27.09f, 25.6f, 28.97f, 22.89f, 31.1f, 23.01f);
        f1476t.cubicTo(33.24f, 23.13f, 34.82f, 26.02f, 34.63f, 29.48f);
        f1476t.cubicTo(34.44f, 32.94f, 32.55f, 35.64f, 30.42f, 35.52f);
        f1476t.moveTo(48.8f, 29.55f);
        f1476t.cubicTo(48.01f, 34.48f, 44.89f, 38.09f, 41.85f, 37.59f);
        f1476t.cubicTo(38.8f, 37.1f, 36.97f, 32.71f, 37.77f, 27.77f);
        f1476t.cubicTo(38.56f, 22.84f, 41.67f, 19.24f, 44.72f, 19.73f);
        f1476t.cubicTo(47.77f, 20.22f, 49.6f, 24.62f, 48.8f, 29.55f);
        f1476t.transform(f1474m);
        if (clearMode) {
            f1475p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1476t, ps);
        } else {
            c.drawPath(f1476t, f1475p);
            c.drawPath(f1476t, ps);
        }
        c.restore();
        m1529r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.restore();
        m1529r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1));
        f1475p.setColor(Color.parseColor("#010002"));
        c.save();
        c.restore();
        m1529r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1529r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1529r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1529r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1529r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1529r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1529r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1529r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1529r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1529r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1529r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1529r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1529r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1529r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1529r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.restore();
        m1529r(new Integer[0]);
        c.restore();
    }

    private static void m1529r(Integer... o) {
        f1475p.reset();
        ps.reset();
        if (cf != null) {
            f1475p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1475p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1475p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    ps.setStrokeJoin(Join.MITER);
                    break;
                case 1:
                    ps.setStrokeMiter(4.0f * od);
                    break;
                case 2:
                    ps.setColor(Color.argb(0, 0, 0, 0));
                    break;
                case 3:
                    ps.setStrokeCap(Cap.BUTT);
                    break;
                case 4:
                    f1475p.setColor(Color.parseColor("#010002"));
                    break;
                default:
                    break;
            }
        }
    }
}
