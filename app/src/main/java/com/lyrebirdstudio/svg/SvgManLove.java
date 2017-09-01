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

public class SvgManLove extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1573m = new Matrix();
    private static float od;
    private static final Paint f1574p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1575t = new Path();

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
        m1562r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1573m.reset();
        f1573m.setScale(od * 5.83f, od * 5.83f);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.save();
        c.save();
        c.save();
        f1574p.setColor(Color.parseColor("#000000"));
        f1575t.reset();
        f1575t.moveTo(82.28f, 50.22f);
        f1575t.cubicTo(82.26f, 49.42f, 81.9f, 48.61f, 81.66f, 47.85f);
        f1575t.cubicTo(81.39f, 46.98f, 81.12f, 46.12f, 80.77f, 45.27f);
        f1575t.cubicTo(80.09f, 43.65f, 79.46f, 42.0f, 78.84f, 40.36f);
        f1575t.cubicTo(78.33f, 38.99f, 77.32f, 36.81f, 78.0f, 35.4f);
        f1575t.cubicTo(78.37f, 34.63f, 78.71f, 34.03f, 78.53f, 33.17f);
        f1575t.cubicTo(78.36f, 32.34f, 78.17f, 31.52f, 77.95f, 30.7f);
        f1575t.cubicTo(77.36f, 28.45f, 76.6f, 26.25f, 75.78f, 24.08f);
        f1575t.cubicTo(75.56f, 23.48f, 73.2f, 18.28f, 73.2f, 18.28f);
        f1575t.lineTo(75.17f, 17.09f);
        f1575t.cubicTo(75.17f, 17.09f, 74.57f, 16.08f, 74.45f, 15.89f);
        f1575t.cubicTo(73.91f, 14.95f, 73.21f, 14.05f, 72.57f, 13.18f);
        f1575t.cubicTo(71.25f, 11.38f, 69.72f, 9.81f, 68.06f, 8.32f);
        f1575t.cubicTo(68.68f, 8.09f, 69.3f, 7.85f, 69.91f, 7.62f);
        f1575t.cubicTo(68.3f, 6.54f, 66.73f, 5.42f, 64.97f, 4.57f);
        f1575t.cubicTo(56.72f, 0.6f, 47.58f, -0.75f, 38.51f, 0.39f);
        f1575t.cubicTo(30.1f, 1.46f, 21.07f, 4.3f, 14.89f, 10.7f);
        f1575t.cubicTo(8.71f, 17.22f, 4.86f, 26.16f, 5.74f, 35.28f);
        f1575t.cubicTo(5.97f, 37.64f, 6.08f, 39.99f, 6.88f, 42.23f);
        f1575t.cubicTo(11.39f, 54.94f, 19.78f, 62.72f, 21.68f, 66.08f);
        f1575t.cubicTo(23.59f, 69.43f, 24.75f, 73.24f, 25.22f, 77.08f);
        f1575t.cubicTo(25.41f, 78.64f, 25.38f, 80.22f, 25.4f, 81.8f);
        f1575t.cubicTo(25.41f, 82.3f, 25.38f, 86.11f, 25.4f, 87.89f);
        f1575t.lineTo(63.91f, 87.89f);
        f1575t.lineTo(63.94f, 85.2f);
        f1575t.cubicTo(64.02f, 82.94f, 63.96f, 80.65f, 64.19f, 78.41f);
        f1575t.cubicTo(64.3f, 77.28f, 64.23f, 75.95f, 64.8f, 74.93f);
        f1575t.cubicTo(65.36f, 73.91f, 66.39f, 73.59f, 67.49f, 73.43f);
        f1575t.cubicTo(69.57f, 73.14f, 74.58f, 74.45f, 76.66f, 73.3f);
        f1575t.cubicTo(78.37f, 72.35f, 78.67f, 70.94f, 78.32f, 69.13f);
        f1575t.cubicTo(78.15f, 68.25f, 78.17f, 67.55f, 78.59f, 66.76f);
        f1575t.cubicTo(78.93f, 66.11f, 79.4f, 65.58f, 79.7f, 64.9f);
        f1575t.cubicTo(80.36f, 63.44f, 78.77f, 61.92f, 77.75f, 61.2f);
        f1575t.cubicTo(78.66f, 60.73f, 79.88f, 60.1f, 80.11f, 58.99f);
        f1575t.cubicTo(80.24f, 58.36f, 79.91f, 57.71f, 79.72f, 57.11f);
        f1575t.cubicTo(79.54f, 56.53f, 79.42f, 55.94f, 79.3f, 55.34f);
        f1575t.cubicTo(79.18f, 54.82f, 78.98f, 52.87f, 79.1f, 52.71f);
        f1575t.cubicTo(79.21f, 52.54f, 82.02f, 51.97f, 82.28f, 50.22f);
        f1575t.moveTo(42.83f, 46.22f);
        f1575t.cubicTo(42.65f, 46.44f, 42.42f, 46.58f, 42.16f, 46.63f);
        f1575t.cubicTo(41.91f, 46.67f, 41.64f, 46.64f, 41.4f, 46.5f);
        f1575t.cubicTo(40.88f, 46.2f, 28.56f, 39.09f, 26.52f, 33.56f);
        f1575t.cubicTo(25.68f, 31.3f, 25.66f, 29.34f, 26.44f, 27.76f);
        f1575t.cubicTo(27.24f, 26.16f, 28.77f, 25.03f, 31.13f, 24.3f);
        f1575t.cubicTo(31.32f, 24.24f, 31.52f, 24.2f, 31.73f, 24.16f);
        f1575t.cubicTo(33.81f, 23.75f, 36.37f, 24.3f, 38.12f, 25.95f);
        f1575t.cubicTo(39.13f, 23.78f, 41.3f, 22.31f, 43.38f, 21.9f);
        f1575t.cubicTo(43.58f, 21.86f, 43.79f, 21.83f, 43.99f, 21.82f);
        f1575t.cubicTo(46.45f, 21.61f, 48.29f, 22.08f, 49.63f, 23.28f);
        f1575t.cubicTo(50.95f, 24.45f, 51.65f, 26.28f, 51.72f, 28.7f);
        f1575t.cubicTo(51.89f, 34.57f, 43.19f, 45.75f, 42.83f, 46.22f);
        f1575t.moveTo(55.39f, 12.94f);
        f1575t.cubicTo(55.03f, 15.14f, 50.99f, 18.66f, 50.82f, 18.81f);
        f1575t.cubicTo(50.74f, 18.88f, 50.65f, 18.91f, 50.55f, 18.91f);
        f1575t.cubicTo(50.45f, 18.91f, 50.35f, 18.88f, 50.27f, 18.81f);
        f1575t.cubicTo(50.1f, 18.66f, 46.03f, 15.14f, 45.67f, 12.94f);
        f1575t.cubicTo(45.53f, 12.03f, 45.66f, 11.31f, 46.06f, 10.77f);
        f1575t.cubicTo(46.48f, 10.23f, 47.13f, 9.92f, 48.05f, 9.83f);
        f1575t.cubicTo(48.13f, 9.82f, 48.21f, 9.81f, 48.29f, 9.81f);
        f1575t.cubicTo(49.09f, 9.81f, 50.0f, 10.21f, 50.53f, 10.94f);
        f1575t.cubicTo(51.07f, 10.21f, 51.97f, 9.81f, 52.78f, 9.81f);
        f1575t.cubicTo(52.86f, 9.81f, 52.94f, 9.82f, 53.01f, 9.83f);
        f1575t.cubicTo(53.94f, 9.92f, 54.59f, 10.23f, 55.0f, 10.77f);
        f1575t.cubicTo(55.41f, 11.31f, 55.53f, 12.03f, 55.39f, 12.94f);
        f1575t.moveTo(61.69f, 21.02f);
        f1575t.cubicTo(60.9f, 22.21f, 57.63f, 23.18f, 57.49f, 23.22f);
        f1575t.cubicTo(57.43f, 23.24f, 57.36f, 23.23f, 57.31f, 23.21f);
        f1575t.cubicTo(57.25f, 23.18f, 57.2f, 23.14f, 57.17f, 23.07f);
        f1575t.cubicTo(57.11f, 22.94f, 55.69f, 19.82f, 56.06f, 18.46f);
        f1575t.cubicTo(56.21f, 17.9f, 56.48f, 17.51f, 56.86f, 17.3f);
        f1575t.cubicTo(57.24f, 17.1f, 57.69f, 17.1f, 58.26f, 17.29f);
        f1575t.cubicTo(58.3f, 17.3f, 58.35f, 17.32f, 58.4f, 17.34f);
        f1575t.cubicTo(58.87f, 17.56f, 59.29f, 18.02f, 59.4f, 18.59f);
        f1575t.cubicTo(59.91f, 18.3f, 60.54f, 18.31f, 61.0f, 18.52f);
        f1575t.cubicTo(61.05f, 18.55f, 61.09f, 18.57f, 61.13f, 18.6f);
        f1575t.cubicTo(61.65f, 18.9f, 61.94f, 19.25f, 62.04f, 19.67f);
        f1575t.cubicTo(62.14f, 20.08f, 62.01f, 20.54f, 61.69f, 21.02f);
        f1575t.transform(f1573m);
        if (clearMode) {
            f1574p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1575t, ps);
        } else {
            c.drawPath(f1575t, f1574p);
            c.drawPath(f1575t, ps);
        }
        c.restore();
        m1562r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1574p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1562r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1574p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1562r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1574p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1562r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1562r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1562r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1562r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1562r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1562r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1562r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1562r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1562r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1562r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1562r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1562r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1562r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1562r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1562r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1562r(new Integer[0]);
        c.restore();
    }

    private static void m1562r(Integer... o) {
        f1574p.reset();
        ps.reset();
        if (cf != null) {
            f1574p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1574p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1574p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1574p.setColor(Color.parseColor("#000000"));
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
