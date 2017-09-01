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
public class SvgPlus extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1729m = new Matrix();
    private static float od;
    private static final Paint f1730p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1731t = new Path();

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
        m1614r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1729m.reset();
        f1729m.setScale(od * 1.72f, od * 1.72f);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.save();
        c.save();
        c.save();
        f1730p.setColor(Color.parseColor("#000000"));
        f1731t.reset();
        f1731t.moveTo(242.16f, 110.92f);
        f1731t.lineTo(186.06f, 110.93f);
        f1731t.lineTo(186.07f, 54.81f);
        f1731t.cubicTo(186.07f, 52.03f, 184.97f, 49.37f, 183.01f, 47.41f);
        f1731t.cubicTo(181.05f, 45.45f, 178.38f, 44.35f, 175.61f, 44.35f);
        f1731t.lineTo(121.42f, 44.36f);
        f1731t.cubicTo(115.64f, 44.36f, 110.96f, 49.04f, 110.96f, 54.81f);
        f1731t.lineTo(110.95f, 110.94f);
        f1731t.lineTo(54.85f, 110.95f);
        f1731t.cubicTo(49.07f, 110.95f, 44.39f, 115.63f, 44.39f, 121.4f);
        f1731t.lineTo(44.38f, 175.62f);
        f1731t.cubicTo(44.38f, 178.39f, 45.48f, 181.05f, 47.45f, 183.01f);
        f1731t.cubicTo(49.41f, 184.98f, 52.07f, 186.08f, 54.84f, 186.08f);
        f1731t.lineTo(110.94f, 186.07f);
        f1731t.lineTo(110.93f, 242.19f);
        f1731t.cubicTo(110.93f, 244.96f, 112.04f, 247.63f, 114.0f, 249.59f);
        f1731t.cubicTo(115.96f, 251.55f, 118.62f, 252.65f, 121.39f, 252.65f);
        f1731t.cubicTo(121.39f, 252.65f, 121.39f, 252.65f, 121.39f, 252.65f);
        f1731t.lineTo(175.59f, 252.64f);
        f1731t.cubicTo(181.36f, 252.64f, 186.04f, 247.96f, 186.04f, 242.18f);
        f1731t.lineTo(186.05f, 186.06f);
        f1731t.lineTo(242.16f, 186.05f);
        f1731t.cubicTo(247.93f, 186.05f, 252.61f, 181.37f, 252.61f, 175.59f);
        f1731t.lineTo(252.62f, 121.38f);
        f1731t.cubicTo(252.62f, 118.61f, 251.52f, 115.95f, 249.55f, 113.98f);
        f1731t.cubicTo(247.59f, 112.02f, 244.93f, 110.92f, 242.16f, 110.92f);
        f1731t.transform(f1729m);
        if (clearMode) {
            f1730p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1731t, ps);
        } else {
            c.drawPath(f1731t, f1730p);
            c.drawPath(f1731t, ps);
        }
        c.restore();
        m1614r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1730p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1614r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1730p.setColor(Color.parseColor("#000000"));
        c.save();
        c.save();
        f1731t.reset();
        f1731t.moveTo(263.54f, 0.0f);
        f1731t.lineTo(33.47f, 0.0f);
        f1731t.cubicTo(15.01f, 0.0f, 0.0f, 15.01f, 0.0f, 33.47f);
        f1731t.lineTo(0.0f, 263.53f);
        f1731t.cubicTo(0.0f, 281.99f, 15.01f, 297.0f, 33.47f, 297.0f);
        f1731t.lineTo(263.53f, 297.0f);
        f1731t.cubicTo(281.99f, 297.0f, 297.0f, 281.99f, 297.0f, 263.54f);
        f1731t.lineTo(297.0f, 33.47f);
        f1731t.cubicTo(297.0f, 15.01f, 281.99f, 0.0f, 263.54f, 0.0f);
        f1731t.moveTo(267.25f, 175.6f);
        f1731t.cubicTo(267.25f, 189.43f, 255.99f, 200.69f, 242.16f, 200.69f);
        f1731t.lineTo(200.69f, 200.7f);
        f1731t.lineTo(200.68f, 242.19f);
        f1731t.cubicTo(200.68f, 256.02f, 189.42f, 267.28f, 175.59f, 267.28f);
        f1731t.lineTo(121.39f, 267.29f);
        f1731t.cubicTo(114.68f, 267.29f, 108.38f, 264.68f, 103.64f, 259.94f);
        f1731t.cubicTo(98.9f, 255.2f, 96.29f, 248.9f, 96.29f, 242.19f);
        f1731t.lineTo(96.3f, 200.72f);
        f1731t.lineTo(54.84f, 200.72f);
        f1731t.cubicTo(48.14f, 200.72f, 41.84f, 198.11f, 37.09f, 193.37f);
        f1731t.cubicTo(32.35f, 188.63f, 29.74f, 182.33f, 29.74f, 175.62f);
        f1731t.lineTo(29.75f, 121.4f);
        f1731t.cubicTo(29.75f, 107.57f, 41.01f, 96.31f, 54.85f, 96.31f);
        f1731t.lineTo(96.31f, 96.3f);
        f1731t.lineTo(96.32f, 54.81f);
        f1731t.cubicTo(96.32f, 40.98f, 107.58f, 29.72f, 121.42f, 29.72f);
        f1731t.lineTo(175.61f, 29.71f);
        f1731t.cubicTo(175.61f, 29.71f, 175.61f, 29.71f, 175.61f, 29.71f);
        f1731t.cubicTo(182.31f, 29.71f, 188.62f, 32.32f, 193.36f, 37.06f);
        f1731t.cubicTo(198.1f, 41.8f, 200.71f, 48.1f, 200.71f, 54.81f);
        f1731t.lineTo(200.7f, 96.29f);
        f1731t.lineTo(242.16f, 96.28f);
        f1731t.cubicTo(248.86f, 96.28f, 255.17f, 98.89f, 259.91f, 103.64f);
        f1731t.cubicTo(264.65f, 108.38f, 267.26f, 114.68f, 267.26f, 121.38f);
        f1731t.lineTo(267.25f, 175.6f);
        f1731t.transform(f1729m);
        if (clearMode) {
            f1730p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1731t, ps);
        } else {
            c.drawPath(f1731t, f1730p);
            c.drawPath(f1731t, ps);
        }
        c.restore();
        m1614r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1614r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1614r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1730p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1614r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1614r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1614r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1614r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1614r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1614r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1614r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1614r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1614r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1614r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1614r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1614r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1614r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1614r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1614r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1614r(new Integer[0]);
        c.restore();
    }

    private static void m1614r(Integer... o) {
        f1730p.reset();
        ps.reset();
        if (cf != null) {
            f1730p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1730p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1730p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1730p.setColor(Color.parseColor("#000000"));
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
