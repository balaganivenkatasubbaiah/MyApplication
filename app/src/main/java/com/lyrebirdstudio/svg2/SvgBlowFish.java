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
public class SvgBlowFish extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1675m = new Matrix();
    private static float od;
    private static final Paint f1676p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1677t = new Path();

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
        m1596r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1675m.reset();
        f1675m.setScale(od * 11.62f, od * 11.62f);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.save();
        c.save();
        c.save();
        f1676p.setColor(Color.parseColor("#000000"));
        f1677t.reset();
        f1677t.moveTo(44.04f, 16.04f);
        f1677t.cubicTo(43.97f, 15.64f, 43.9f, 15.24f, 43.79f, 14.84f);
        f1677t.cubicTo(43.64f, 14.41f, 43.46f, 13.98f, 43.26f, 13.57f);
        f1677t.cubicTo(43.01f, 13.15f, 42.72f, 12.74f, 42.42f, 12.35f);
        f1677t.cubicTo(42.08f, 12.0f, 41.73f, 11.65f, 41.35f, 11.34f);
        f1677t.cubicTo(40.97f, 11.07f, 40.57f, 10.84f, 40.18f, 10.62f);
        f1677t.cubicTo(39.79f, 10.45f, 39.41f, 10.31f, 39.03f, 10.19f);
        f1677t.cubicTo(38.65f, 10.07f, 38.31f, 10.04f, 37.96f, 9.99f);
        f1677t.cubicTo(37.26f, 9.88f, 36.66f, 9.97f, 36.07f, 10.02f);
        f1677t.cubicTo(35.51f, 10.13f, 34.99f, 10.26f, 34.53f, 10.45f);
        f1677t.cubicTo(34.07f, 10.64f, 33.65f, 10.85f, 33.29f, 11.06f);
        f1677t.cubicTo(32.93f, 11.27f, 32.61f, 11.53f, 32.36f, 11.73f);
        f1677t.cubicTo(32.29f, 11.78f, 32.23f, 11.84f, 32.16f, 11.9f);
        f1677t.cubicTo(29.22f, 9.25f, 25.21f, 7.45f, 20.67f, 7.09f);
        f1677t.cubicTo(19.28f, 6.97f, 17.92f, 7.02f, 16.6f, 7.17f);
        f1677t.lineTo(15.42f, 4.73f);
        f1677t.lineTo(15.32f, 7.35f);
        f1677t.cubicTo(12.06f, 7.95f, 9.15f, 9.34f, 6.85f, 11.28f);
        f1677t.cubicTo(6.81f, 10.21f, 5.94f, 9.36f, 4.86f, 9.36f);
        f1677t.cubicTo(3.76f, 9.36f, 2.86f, 10.26f, 2.86f, 11.36f);
        f1677t.cubicTo(2.86f, 13.02f, 2.74f, 13.66f, 2.66f, 13.9f);
        f1677t.cubicTo(2.55f, 13.92f, 2.35f, 13.94f, 2.0f, 13.94f);
        f1677t.cubicTo(0.9f, 13.94f, 0.0f, 14.84f, 0.0f, 15.94f);
        f1677t.cubicTo(0.0f, 17.05f, 0.9f, 17.94f, 2.0f, 17.94f);
        f1677t.cubicTo(2.12f, 17.94f, 2.22f, 17.93f, 2.34f, 17.93f);
        f1677t.cubicTo(2.05f, 18.84f, 1.86f, 19.79f, 1.78f, 20.78f);
        f1677t.cubicTo(1.65f, 22.43f, 1.84f, 24.05f, 2.3f, 25.59f);
        f1677t.lineTo(0.92f, 26.71f);
        f1677t.lineTo(2.57f, 26.39f);
        f1677t.cubicTo(3.18f, 28.05f, 4.1f, 29.59f, 5.3f, 30.97f);
        f1677t.lineTo(4.02f, 33.09f);
        f1677t.lineTo(6.09f, 31.85f);
        f1677t.cubicTo(6.71f, 32.47f, 7.4f, 33.05f, 8.13f, 33.58f);
        f1677t.lineTo(7.53f, 36.61f);
        f1677t.lineTo(9.34f, 34.4f);
        f1677t.cubicTo(10.85f, 35.33f, 12.54f, 36.08f, 14.36f, 36.58f);
        f1677t.lineTo(14.8f, 39.35f);
        f1677t.lineTo(15.64f, 36.89f);
        f1677t.cubicTo(16.5f, 37.07f, 17.36f, 37.21f, 18.26f, 37.29f);
        f1677t.cubicTo(20.01f, 37.43f, 21.71f, 37.34f, 23.34f, 37.06f);
        f1677t.lineTo(24.63f, 39.18f);
        f1677t.lineTo(24.49f, 36.82f);
        f1677t.cubicTo(27.51f, 36.12f, 30.22f, 34.76f, 32.35f, 32.88f);
        f1677t.lineTo(34.89f, 34.59f);
        f1677t.lineTo(33.42f, 31.84f);
        f1677t.cubicTo(34.81f, 30.35f, 35.87f, 28.62f, 36.51f, 26.72f);
        f1677t.lineTo(38.08f, 26.89f);
        f1677t.lineTo(36.72f, 25.97f);
        f1677t.cubicTo(36.93f, 25.2f, 37.09f, 24.41f, 37.16f, 23.6f);
        f1677t.cubicTo(37.22f, 22.81f, 37.19f, 22.04f, 37.11f, 21.27f);
        f1677t.cubicTo(37.63f, 21.1f, 38.13f, 20.88f, 38.63f, 20.63f);
        f1677t.cubicTo(39.07f, 21.25f, 39.55f, 21.85f, 39.93f, 22.3f);
        f1677t.cubicTo(40.12f, 22.54f, 40.34f, 22.74f, 40.46f, 22.86f);
        f1677t.cubicTo(40.6f, 23.0f, 40.68f, 23.07f, 40.68f, 23.07f);
        f1677t.cubicTo(40.68f, 23.07f, 40.76f, 23.01f, 40.92f, 22.89f);
        f1677t.cubicTo(41.05f, 22.78f, 41.3f, 22.61f, 41.51f, 22.39f);
        f1677t.cubicTo(41.74f, 22.17f, 42.04f, 21.92f, 42.3f, 21.6f);
        f1677t.cubicTo(42.57f, 21.27f, 42.84f, 20.89f, 43.1f, 20.45f);
        f1677t.cubicTo(43.35f, 20.01f, 43.56f, 19.52f, 43.76f, 18.99f);
        f1677t.cubicTo(43.85f, 18.71f, 43.89f, 18.41f, 43.96f, 18.1f);
        f1677t.cubicTo(44.04f, 17.8f, 44.08f, 17.48f, 44.08f, 17.12f);
        f1677t.cubicTo(44.08f, 16.77f, 44.09f, 16.43f, 44.04f, 16.04f);
        f1677t.moveTo(14.97f, 26.12f);
        f1677t.cubicTo(14.18f, 26.12f, 13.53f, 25.47f, 13.53f, 24.68f);
        f1677t.cubicTo(13.53f, 23.88f, 14.17f, 23.24f, 14.97f, 23.24f);
        f1677t.cubicTo(15.77f, 23.24f, 16.41f, 23.88f, 16.41f, 24.68f);
        f1677t.cubicTo(16.41f, 25.47f, 15.77f, 26.12f, 14.97f, 26.12f);
        f1677t.moveTo(13.83f, 15.94f);
        f1677t.cubicTo(12.3f, 15.94f, 11.07f, 14.71f, 11.07f, 13.19f);
        f1677t.cubicTo(11.07f, 11.66f, 12.3f, 10.43f, 13.83f, 10.43f);
        f1677t.cubicTo(15.35f, 10.43f, 16.58f, 11.66f, 16.58f, 13.19f);
        f1677t.cubicTo(16.58f, 14.71f, 15.35f, 15.94f, 13.83f, 15.94f);
        f1677t.moveTo(18.26f, 19.75f);
        f1677t.cubicTo(17.79f, 19.75f, 17.4f, 19.37f, 17.4f, 18.9f);
        f1677t.cubicTo(17.4f, 18.42f, 17.79f, 18.04f, 18.26f, 18.04f);
        f1677t.cubicTo(18.73f, 18.04f, 19.12f, 18.42f, 19.12f, 18.9f);
        f1677t.cubicTo(19.12f, 19.37f, 18.73f, 19.75f, 18.26f, 19.75f);
        f1677t.moveTo(23.09f, 31.13f);
        f1677t.cubicTo(22.62f, 31.13f, 22.23f, 30.75f, 22.23f, 30.28f);
        f1677t.cubicTo(22.23f, 29.8f, 22.62f, 29.42f, 23.09f, 29.42f);
        f1677t.cubicTo(23.56f, 29.42f, 23.95f, 29.81f, 23.95f, 30.28f);
        f1677t.cubicTo(23.95f, 30.75f, 23.56f, 31.13f, 23.09f, 31.13f);
        f1677t.moveTo(23.09f, 23.93f);
        f1677t.cubicTo(22.49f, 23.93f, 22.01f, 23.45f, 22.01f, 22.85f);
        f1677t.cubicTo(22.01f, 22.26f, 22.49f, 21.77f, 23.09f, 21.77f);
        f1677t.cubicTo(23.69f, 21.77f, 24.17f, 22.26f, 24.17f, 22.85f);
        f1677t.cubicTo(24.17f, 23.45f, 23.69f, 23.93f, 23.09f, 23.93f);
        f1677t.transform(f1675m);
        if (clearMode) {
            f1676p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1677t, ps);
        } else {
            c.drawPath(f1677t, f1676p);
            c.drawPath(f1677t, ps);
        }
        c.restore();
        m1596r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1676p.setColor(Color.parseColor("#000000"));
        c.save();
        f1677t.reset();
        f1677t.transform(f1675m);
        if (clearMode) {
            f1676p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        c.drawPath(f1677t, f1676p);
        c.drawPath(f1677t, ps);
        c.restore();
        m1596r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1596r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1676p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1596r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1676p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1596r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1596r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1596r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1596r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1596r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1596r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1596r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1596r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1596r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1596r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1596r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1596r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1596r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1596r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1596r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1596r(new Integer[0]);
        c.restore();
    }

    private static void m1596r(Integer... o) {
        f1676p.reset();
        ps.reset();
        if (cf != null) {
            f1676p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1676p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1676p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1676p.setColor(Color.parseColor("#000000"));
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
