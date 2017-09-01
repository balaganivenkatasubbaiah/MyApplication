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
public class SvgFishBowl extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1699m = new Matrix();
    private static float od;
    private static final Paint f1700p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1701t = new Path();

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
        m1604r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1699m.reset();
        f1699m.setScale(od * 9.85f, od * 9.85f);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.save();
        c.save();
        c.save();
        f1700p.setColor(Color.parseColor("#000000"));
        f1701t.reset();
        f1701t.moveTo(41.39f, 11.9f);
        f1701t.cubicTo(40.17f, 10.97f, 39.75f, 9.28f, 40.55f, 7.97f);
        f1701t.lineTo(43.99f, 2.37f);
        f1701t.cubicTo(44.79f, 1.06f, 44.2f, 0.0f, 42.66f, 0.0f);
        f1701t.lineTo(9.32f, 0.0f);
        f1701t.cubicTo(7.79f, 0.0f, 7.24f, 1.03f, 8.1f, 2.3f);
        f1701t.lineTo(11.8f, 7.77f);
        f1701t.cubicTo(12.66f, 9.04f, 12.26f, 10.67f, 11.02f, 11.58f);
        f1701t.cubicTo(4.66f, 16.21f, 0.53f, 23.71f, 0.53f, 32.18f);
        f1701t.cubicTo(0.53f, 38.25f, 3.69f, 45.17f, 7.52f, 49.91f);
        f1701t.cubicTo(8.49f, 51.11f, 10.62f, 51.98f, 12.16f, 51.98f);
        f1701t.lineTo(38.98f, 51.98f);
        f1701t.cubicTo(40.52f, 51.98f, 42.69f, 51.15f, 43.72f, 50.01f);
        f1701t.cubicTo(47.98f, 45.32f, 51.46f, 38.66f, 51.46f, 32.18f);
        f1701t.cubicTo(51.46f, 23.91f, 47.51f, 16.55f, 41.39f, 11.9f);
        f1701t.moveTo(8.01f, 24.77f);
        f1701t.cubicTo(8.01f, 24.01f, 8.62f, 23.4f, 9.38f, 23.4f);
        f1701t.cubicTo(10.14f, 23.4f, 10.76f, 24.01f, 10.76f, 24.77f);
        f1701t.cubicTo(10.76f, 25.53f, 10.14f, 26.15f, 9.38f, 26.15f);
        f1701t.cubicTo(8.62f, 26.15f, 8.01f, 25.53f, 8.01f, 24.77f);
        f1701t.moveTo(12.76f, 32.4f);
        f1701t.cubicTo(11.37f, 32.4f, 10.26f, 31.28f, 10.26f, 29.9f);
        f1701t.cubicTo(10.26f, 28.52f, 11.37f, 27.4f, 12.76f, 27.4f);
        f1701t.cubicTo(14.14f, 27.4f, 15.26f, 28.52f, 15.26f, 29.9f);
        f1701t.cubicTo(15.26f, 31.28f, 14.14f, 32.4f, 12.76f, 32.4f);
        f1701t.moveTo(15.0f, 9.56f);
        f1701t.cubicTo(15.0f, 9.56f, 17.55f, 7.69f, 23.84f, 8.81f);
        f1701t.cubicTo(30.13f, 9.94f, 35.18f, 7.69f, 35.18f, 7.69f);
        f1701t.cubicTo(34.06f, 9.98f, 29.79f, 13.64f, 24.54f, 10.98f);
        f1701t.cubicTo(19.29f, 8.31f, 15.0f, 9.56f, 15.0f, 9.56f);
        f1701t.moveTo(26.04f, 15.53f);
        f1701t.cubicTo(25.89f, 15.24f, 25.97f, 15.16f, 26.24f, 15.34f);
        f1701t.cubicTo(27.79f, 16.39f, 29.9f, 18.12f, 30.63f, 21.95f);
        f1701t.cubicTo(30.69f, 22.27f, 30.57f, 22.32f, 30.38f, 22.05f);
        f1701t.cubicTo(30.03f, 21.57f, 29.65f, 21.08f, 29.25f, 20.6f);
        f1701t.lineTo(28.92f, 20.2f);
        f1701t.cubicTo(28.74f, 19.98f, 28.44f, 19.97f, 28.25f, 20.19f);
        f1701t.cubicTo(28.06f, 20.41f, 27.91f, 20.59f, 27.91f, 20.59f);
        f1701t.cubicTo(27.87f, 20.64f, 27.51f, 21.05f, 27.01f, 21.77f);
        f1701t.cubicTo(26.82f, 22.03f, 26.74f, 22.0f, 26.79f, 21.68f);
        f1701t.cubicTo(27.04f, 20.2f, 27.18f, 17.76f, 26.04f, 15.53f);
        f1701t.moveTo(22.73f, 35.36f);
        f1701t.cubicTo(22.74f, 35.68f, 22.57f, 36.13f, 22.3f, 36.32f);
        f1701t.cubicTo(22.01f, 36.53f, 21.69f, 36.68f, 21.41f, 36.67f);
        f1701t.cubicTo(21.08f, 36.64f, 20.76f, 36.14f, 20.73f, 35.82f);
        f1701t.cubicTo(20.72f, 35.75f, 20.73f, 35.69f, 20.73f, 35.63f);
        f1701t.cubicTo(20.78f, 35.31f, 21.17f, 34.88f, 21.13f, 34.56f);
        f1701t.cubicTo(21.09f, 34.08f, 20.79f, 33.52f, 20.65f, 33.24f);
        f1701t.cubicTo(20.17f, 32.23f, 20.34f, 30.05f, 20.34f, 29.74f);
        f1701t.cubicTo(20.34f, 29.37f, 20.7f, 28.15f, 21.06f, 29.64f);
        f1701t.cubicTo(21.22f, 30.2f, 21.31f, 31.18f, 22.39f, 32.45f);
        f1701t.cubicTo(22.6f, 32.7f, 22.76f, 33.15f, 22.74f, 33.47f);
        f1701t.cubicTo(22.71f, 34.1f, 22.7f, 34.73f, 22.73f, 35.36f);
        f1701t.moveTo(29.03f, 46.69f);
        f1701t.cubicTo(28.79f, 46.91f, 28.4f, 46.86f, 28.19f, 46.61f);
        f1701t.cubicTo(18.8f, 35.3f, 26.39f, 24.01f, 28.21f, 21.63f);
        f1701t.cubicTo(28.41f, 21.37f, 28.74f, 21.37f, 28.95f, 21.62f);
        f1701t.cubicTo(38.84f, 34.08f, 31.47f, 44.4f, 29.03f, 46.69f);
        f1701t.moveTo(36.97f, 33.23f);
        f1701t.cubicTo(36.83f, 33.52f, 36.53f, 34.08f, 36.49f, 34.56f);
        f1701t.cubicTo(36.45f, 34.88f, 36.84f, 35.31f, 36.88f, 35.63f);
        f1701t.cubicTo(36.89f, 35.69f, 36.9f, 35.75f, 36.89f, 35.82f);
        f1701t.cubicTo(36.87f, 36.14f, 36.54f, 36.64f, 36.21f, 36.66f);
        f1701t.cubicTo(35.9f, 36.69f, 35.55f, 36.5f, 35.24f, 36.27f);
        f1701t.cubicTo(34.98f, 36.07f, 34.81f, 35.62f, 34.83f, 35.29f);
        f1701t.cubicTo(34.85f, 34.71f, 34.85f, 34.12f, 34.82f, 33.53f);
        f1701t.cubicTo(34.8f, 33.2f, 34.96f, 32.75f, 35.17f, 32.51f);
        f1701t.cubicTo(36.3f, 31.21f, 36.4f, 30.2f, 36.56f, 29.64f);
        f1701t.cubicTo(36.91f, 28.15f, 37.28f, 29.36f, 37.28f, 29.74f);
        f1701t.cubicTo(37.28f, 30.05f, 37.45f, 32.23f, 36.97f, 33.23f);
        f1701t.moveTo(36.52f, 17.67f);
        f1701t.cubicTo(35.85f, 17.67f, 35.31f, 17.12f, 35.31f, 16.46f);
        f1701t.cubicTo(35.31f, 15.79f, 35.85f, 15.24f, 36.52f, 15.24f);
        f1701t.cubicTo(37.19f, 15.24f, 37.73f, 15.79f, 37.73f, 16.46f);
        f1701t.cubicTo(37.73f, 17.12f, 37.19f, 17.67f, 36.52f, 17.67f);
        f1701t.transform(f1699m);
        if (clearMode) {
            f1700p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1701t, ps);
        } else {
            c.drawPath(f1701t, f1700p);
            c.drawPath(f1701t, ps);
        }
        c.restore();
        m1604r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1700p.setColor(Color.parseColor("#000000"));
        c.save();
        f1701t.reset();
        f1701t.transform(f1699m);
        if (clearMode) {
            f1700p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        c.drawPath(f1701t, f1700p);
        c.drawPath(f1701t, ps);
        c.restore();
        m1604r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1701t.reset();
        f1701t.transform(f1699m);
        if (clearMode) {
            f1700p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1701t, ps);
        } else {
            c.drawPath(f1701t, f1700p);
            c.drawPath(f1701t, ps);
        }
        c.restore();
        m1604r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1701t.reset();
        f1701t.moveTo(28.76f, 39.11f);
        f1701t.cubicTo(29.56f, 39.11f, 30.2f, 39.52f, 30.2f, 40.04f);
        f1701t.cubicTo(30.2f, 40.55f, 29.56f, 40.97f, 28.76f, 40.97f);
        f1701t.cubicTo(27.96f, 40.97f, 27.32f, 40.55f, 27.32f, 40.04f);
        f1701t.cubicTo(27.32f, 39.52f, 27.96f, 39.11f, 28.76f, 39.11f);
        f1701t.transform(f1699m);
        if (clearMode) {
            f1700p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1701t, ps);
        } else {
            c.drawPath(f1701t, f1700p);
            c.drawPath(f1701t, ps);
        }
        c.restore();
        m1604r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1604r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1700p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1604r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1700p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1604r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1604r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1604r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1604r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1604r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1604r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1604r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1604r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1604r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1604r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1604r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1604r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1604r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1604r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1604r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1604r(new Integer[0]);
        c.restore();
    }

    private static void m1604r(Integer... o) {
        f1700p.reset();
        ps.reset();
        if (cf != null) {
            f1700p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1700p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1700p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1700p.setColor(Color.parseColor("#000000"));
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
