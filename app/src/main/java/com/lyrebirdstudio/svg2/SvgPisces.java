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
public class SvgPisces extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1726m = new Matrix();
    private static float od;
    private static final Paint f1727p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1728t = new Path();

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
        m1613r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1726m.reset();
        f1726m.setScale(od * 16.0f, od * 16.0f);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.save();
        c.save();
        c.save();
        f1727p.setColor(Color.parseColor("#000000"));
        f1728t.reset();
        f1728t.moveTo(15.15f, 14.71f);
        f1728t.cubicTo(15.15f, 14.71f, 15.31f, 15.03f, 15.45f, 15.06f);
        f1728t.cubicTo(16.5f, 15.31f, 21.19f, 16.38f, 22.54f, 15.53f);
        f1728t.cubicTo(23.26f, 15.06f, 20.62f, 12.8f, 20.62f, 12.8f);
        f1728t.cubicTo(20.62f, 12.8f, 23.74f, 14.24f, 24.27f, 13.71f);
        f1728t.cubicTo(26.19f, 10.61f, 21.23f, 5.5f, 19.96f, 4.3f);
        f1728t.cubicTo(19.65f, 3.94f, 19.41f, 4.21f, 19.41f, 4.21f);
        f1728t.lineTo(13.52f, 8.29f);
        f1728t.lineTo(15.15f, 14.71f);
        f1728t.moveTo(20.6f, 8.92f);
        f1728t.cubicTo(21.11f, 8.92f, 21.53f, 9.34f, 21.53f, 9.85f);
        f1728t.cubicTo(21.53f, 10.37f, 21.11f, 10.79f, 20.6f, 10.79f);
        f1728t.cubicTo(20.08f, 10.79f, 19.66f, 10.37f, 19.66f, 9.85f);
        f1728t.cubicTo(19.66f, 9.34f, 20.08f, 8.92f, 20.6f, 8.92f);
        f1728t.transform(f1726m);
        if (clearMode) {
            f1727p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1728t, ps);
        } else {
            c.drawPath(f1728t, f1727p);
            c.drawPath(f1728t, ps);
        }
        c.restore();
        m1613r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1727p.setColor(Color.parseColor("#000000"));
        c.save();
        f1728t.reset();
        f1728t.moveTo(13.64f, 14.44f);
        f1728t.cubicTo(14.29f, 14.48f, 14.1f, 13.76f, 14.1f, 13.76f);
        f1728t.lineTo(12.61f, 7.86f);
        f1728t.lineTo(18.92f, 3.74f);
        f1728t.cubicTo(18.92f, 3.74f, 19.34f, 3.46f, 18.94f, 3.21f);
        f1728t.cubicTo(17.94f, 2.35f, 15.0f, -0.08f, 14.01f, 0.0f);
        f1728t.cubicTo(12.81f, 0.1f, 13.1f, 3.26f, 12.23f, 3.07f);
        f1728t.cubicTo(3.22f, 3.5f, 0.02f, 19.05f, 0.44f, 19.56f);
        f1728t.cubicTo(0.86f, 20.07f, 1.2f, 20.43f, 1.97f, 19.85f);
        f1728t.cubicTo(2.76f, 21.56f, 0.94f, 25.43f, 0.33f, 27.02f);
        f1728t.cubicTo(0.17f, 27.49f, 0.57f, 27.37f, 0.85f, 27.13f);
        f1728t.cubicTo(2.24f, 25.74f, 3.23f, 25.25f, 3.79f, 25.3f);
        f1728t.cubicTo(4.34f, 25.36f, 5.63f, 25.84f, 6.38f, 26.26f);
        f1728t.cubicTo(6.74f, 26.52f, 7.15f, 26.45f, 6.77f, 25.91f);
        f1728t.cubicTo(0.95f, 13.65f, 10.9f, 14.16f, 13.64f, 14.44f);
        f1728t.transform(f1726m);
        if (clearMode) {
            f1727p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1728t, ps);
        } else {
            c.drawPath(f1728t, f1727p);
            c.drawPath(f1728t, ps);
        }
        c.restore();
        m1613r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1728t.reset();
        f1728t.moveTo(16.85f, 17.28f);
        f1728t.cubicTo(16.85f, 17.28f, 16.69f, 16.97f, 16.55f, 16.93f);
        f1728t.cubicTo(15.5f, 16.68f, 10.81f, 15.62f, 9.46f, 16.46f);
        f1728t.cubicTo(8.74f, 16.94f, 11.38f, 19.19f, 11.38f, 19.19f);
        f1728t.cubicTo(11.38f, 19.19f, 8.26f, 17.76f, 7.74f, 18.28f);
        f1728t.cubicTo(5.81f, 21.39f, 10.78f, 26.49f, 12.04f, 27.7f);
        f1728t.cubicTo(12.36f, 28.05f, 12.59f, 27.79f, 12.59f, 27.79f);
        f1728t.lineTo(18.48f, 23.7f);
        f1728t.lineTo(16.85f, 17.28f);
        f1728t.moveTo(11.4f, 23.08f);
        f1728t.cubicTo(10.89f, 23.08f, 10.47f, 22.66f, 10.47f, 22.14f);
        f1728t.cubicTo(10.47f, 21.63f, 10.89f, 21.21f, 11.4f, 21.21f);
        f1728t.cubicTo(11.92f, 21.21f, 12.34f, 21.63f, 12.34f, 22.14f);
        f1728t.cubicTo(12.34f, 22.66f, 11.92f, 23.08f, 11.4f, 23.08f);
        f1728t.transform(f1726m);
        if (clearMode) {
            f1727p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1728t, ps);
        } else {
            c.drawPath(f1728t, f1727p);
            c.drawPath(f1728t, ps);
        }
        c.restore();
        m1613r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1728t.reset();
        f1728t.moveTo(31.15f, 4.87f);
        f1728t.cubicTo(29.76f, 6.26f, 28.77f, 6.75f, 28.21f, 6.7f);
        f1728t.cubicTo(27.65f, 6.64f, 26.37f, 6.15f, 25.62f, 5.74f);
        f1728t.cubicTo(25.26f, 5.47f, 24.85f, 5.55f, 25.23f, 6.09f);
        f1728t.cubicTo(31.05f, 18.35f, 21.1f, 17.84f, 18.36f, 17.56f);
        f1728t.cubicTo(17.71f, 17.52f, 17.9f, 18.24f, 17.9f, 18.24f);
        f1728t.lineTo(19.38f, 24.14f);
        f1728t.lineTo(13.08f, 28.26f);
        f1728t.cubicTo(13.08f, 28.26f, 12.66f, 28.54f, 13.06f, 28.79f);
        f1728t.cubicTo(14.06f, 29.64f, 17.0f, 32.08f, 17.99f, 32.0f);
        f1728t.cubicTo(19.19f, 31.9f, 18.9f, 28.73f, 19.77f, 28.93f);
        f1728t.cubicTo(28.78f, 28.5f, 31.98f, 12.95f, 31.56f, 12.44f);
        f1728t.cubicTo(31.14f, 11.93f, 30.8f, 11.57f, 30.02f, 12.15f);
        f1728t.cubicTo(29.24f, 10.44f, 31.06f, 6.57f, 31.67f, 4.98f);
        f1728t.cubicTo(31.83f, 4.5f, 31.43f, 4.63f, 31.15f, 4.87f);
        f1728t.transform(f1726m);
        if (clearMode) {
            f1727p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1728t, ps);
        } else {
            c.drawPath(f1728t, f1727p);
            c.drawPath(f1728t, ps);
        }
        c.restore();
        m1613r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1613r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1727p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1613r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1727p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1613r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1613r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1613r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1613r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1613r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1613r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1613r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1613r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1613r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1613r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1613r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1613r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1613r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1613r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1613r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1613r(new Integer[0]);
        c.restore();
    }

    private static void m1613r(Integer... o) {
        f1727p.reset();
        ps.reset();
        if (cf != null) {
            f1727p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1727p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1727p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1727p.setColor(Color.parseColor("#000000"));
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
