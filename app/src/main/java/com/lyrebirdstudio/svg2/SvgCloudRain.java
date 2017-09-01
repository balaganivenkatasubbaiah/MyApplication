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
public class SvgCloudRain extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1681m = new Matrix();
    private static float od;
    private static final Paint f1682p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1683t = new Path();

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
        m1598r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1681m.reset();
        f1681m.setScale(od * 11.2f, od * 11.2f);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.save();
        c.save();
        c.save();
        c.save();
        f1682p.setColor(Color.parseColor("#000000"));
        f1683t.reset();
        f1683t.moveTo(36.26f, 7.16f);
        f1683t.cubicTo(35.83f, 7.16f, 35.4f, 7.19f, 34.98f, 7.25f);
        f1683t.cubicTo(33.46f, 5.41f, 31.17f, 4.25f, 28.6f, 4.25f);
        f1683t.cubicTo(28.11f, 4.25f, 27.63f, 4.29f, 27.16f, 4.37f);
        f1683t.cubicTo(25.05f, 1.71f, 21.79f, 0.0f, 18.14f, 0.0f);
        f1683t.cubicTo(13.23f, 0.0f, 9.04f, 3.07f, 7.39f, 7.39f);
        f1683t.cubicTo(3.3f, 8.32f, 0.25f, 11.98f, 0.25f, 16.36f);
        f1683t.cubicTo(0.25f, 21.44f, 4.37f, 25.56f, 9.45f, 25.56f);
        f1683t.cubicTo(9.5f, 25.56f, 9.55f, 25.56f, 9.59f, 25.56f);
        f1683t.cubicTo(11.61f, 28.89f, 16.26f, 31.21f, 21.68f, 31.21f);
        f1683t.cubicTo(27.25f, 31.21f, 32.02f, 28.75f, 33.93f, 25.26f);
        f1683t.cubicTo(34.67f, 25.46f, 35.46f, 25.56f, 36.26f, 25.56f);
        f1683t.cubicTo(41.35f, 25.56f, 45.46f, 21.44f, 45.46f, 16.36f);
        f1683t.cubicTo(45.46f, 11.28f, 41.34f, 7.16f, 36.26f, 7.16f);
        f1683t.transform(f1681m);
        if (clearMode) {
            f1682p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1683t, ps);
        } else {
            c.drawPath(f1683t, f1682p);
            c.drawPath(f1683t, ps);
        }
        c.restore();
        m1598r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1682p.setColor(Color.parseColor("#000000"));
        c.save();
        f1683t.reset();
        f1683t.moveTo(6.88f, 36.25f);
        f1683t.cubicTo(6.88f, 37.46f, 7.86f, 38.44f, 9.06f, 38.44f);
        f1683t.cubicTo(10.27f, 38.44f, 11.25f, 37.46f, 11.25f, 36.25f);
        f1683t.cubicTo(11.25f, 35.47f, 10.34f, 33.97f, 9.7f, 33.0f);
        f1683t.cubicTo(9.39f, 32.54f, 8.73f, 32.54f, 8.43f, 33.0f);
        f1683t.cubicTo(7.79f, 33.97f, 6.88f, 35.47f, 6.88f, 36.25f);
        f1683t.transform(f1681m);
        if (clearMode) {
            f1682p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1683t, ps);
        } else {
            c.drawPath(f1683t, f1682p);
            c.drawPath(f1683t, ps);
        }
        c.restore();
        m1598r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1683t.reset();
        f1683t.moveTo(30.07f, 37.41f);
        f1683t.cubicTo(30.07f, 38.62f, 31.05f, 39.6f, 32.26f, 39.6f);
        f1683t.cubicTo(33.47f, 39.6f, 34.45f, 38.62f, 34.45f, 37.41f);
        f1683t.cubicTo(34.45f, 36.63f, 33.54f, 35.13f, 32.89f, 34.15f);
        f1683t.cubicTo(32.58f, 33.7f, 31.92f, 33.7f, 31.62f, 34.15f);
        f1683t.cubicTo(30.98f, 35.13f, 30.07f, 36.63f, 30.07f, 37.41f);
        f1683t.transform(f1681m);
        if (clearMode) {
            f1682p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1683t, ps);
        } else {
            c.drawPath(f1683t, f1682p);
            c.drawPath(f1683t, ps);
        }
        c.restore();
        m1598r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1683t.reset();
        f1683t.moveTo(12.0f, 44.1f);
        f1683t.cubicTo(12.0f, 44.99f, 12.72f, 45.71f, 13.61f, 45.71f);
        f1683t.cubicTo(14.5f, 45.71f, 15.22f, 44.99f, 15.22f, 44.1f);
        f1683t.cubicTo(15.22f, 43.6f, 14.7f, 42.68f, 14.25f, 41.98f);
        f1683t.cubicTo(13.95f, 41.51f, 13.27f, 41.51f, 12.97f, 41.98f);
        f1683t.cubicTo(12.53f, 42.68f, 12.0f, 43.6f, 12.0f, 44.1f);
        f1683t.transform(f1681m);
        if (clearMode) {
            f1682p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1683t, ps);
        } else {
            c.drawPath(f1683t, f1682p);
            c.drawPath(f1683t, ps);
        }
        c.restore();
        m1598r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1683t.reset();
        f1683t.moveTo(25.7f, 44.1f);
        f1683t.cubicTo(25.7f, 44.99f, 26.42f, 45.71f, 27.31f, 45.71f);
        f1683t.cubicTo(28.19f, 45.71f, 28.92f, 44.99f, 28.92f, 44.1f);
        f1683t.cubicTo(28.92f, 43.6f, 28.39f, 42.68f, 27.95f, 41.98f);
        f1683t.cubicTo(27.65f, 41.52f, 26.97f, 41.52f, 26.67f, 41.98f);
        f1683t.cubicTo(26.22f, 42.68f, 25.7f, 43.6f, 25.7f, 44.1f);
        f1683t.transform(f1681m);
        if (clearMode) {
            f1682p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1683t, ps);
        } else {
            c.drawPath(f1683t, f1682p);
            c.drawPath(f1683t, ps);
        }
        c.restore();
        m1598r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1683t.reset();
        f1683t.moveTo(18.47f, 39.73f);
        f1683t.cubicTo(18.47f, 40.94f, 19.45f, 41.92f, 20.66f, 41.92f);
        f1683t.cubicTo(21.87f, 41.92f, 22.85f, 40.94f, 22.85f, 39.73f);
        f1683t.cubicTo(22.85f, 38.95f, 21.94f, 37.45f, 21.29f, 36.48f);
        f1683t.cubicTo(20.99f, 36.02f, 20.33f, 36.02f, 20.03f, 36.48f);
        f1683t.cubicTo(19.38f, 37.45f, 18.47f, 38.95f, 18.47f, 39.73f);
        f1683t.transform(f1681m);
        if (clearMode) {
            f1682p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1683t, ps);
        } else {
            c.drawPath(f1683t, f1682p);
            c.drawPath(f1683t, ps);
        }
        c.restore();
        m1598r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1598r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1682p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1598r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1682p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1598r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1682p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1598r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1598r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1598r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1598r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1598r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1598r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1598r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1598r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1598r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1598r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1598r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1598r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1598r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1598r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1598r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1598r(new Integer[0]);
        c.restore();
    }

    private static void m1598r(Integer... o) {
        f1682p.reset();
        ps.reset();
        if (cf != null) {
            f1682p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1682p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1682p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1682p.setColor(Color.parseColor("#000000"));
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
