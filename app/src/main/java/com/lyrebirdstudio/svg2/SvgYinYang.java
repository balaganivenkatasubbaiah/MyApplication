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
public class SvgYinYang extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1747m = new Matrix();
    private static float od;
    private static final Paint f1748p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1749t = new Path();

    public static void setColorTint(int color) {
        cf = new PorterDuffColorFilter(color, Mode.SRC_IN);
    }

    public void drawStroke(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        isStroke = true;
        draw(c, w, h, dx, dy, clearMode);
        isStroke = false;
    }

    public static void clearColorTint(int color) {
        cf = null;
    }

    public void draw(Canvas c, int w, int h) {
        draw(c, (float) w, (float) h, 0.0f, 0.0f, false);
    }

    public void draw(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        od = w / 516.0f < h / 512.0f ? w / 516.0f : h / 512.0f;
        m1620r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 516.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1747m.reset();
        f1747m.setScale(od * 1.73f, od * 1.73f);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.save();
        c.save();
        f1748p.setColor(Color.parseColor("#000000"));
        f1749t.reset();
        f1749t.moveTo(296.05f, 147.96f);
        f1749t.cubicTo(296.05f, 147.86f, 296.05f, 147.77f, 296.05f, 147.68f);
        f1749t.cubicTo(295.82f, 66.26f, 229.54f, 0.0f, 148.1f, 0.0f);
        f1749t.cubicTo(109.55f, 0.0f, 73.06f, 14.63f, 45.34f, 41.4f);
        f1749t.cubicTo(17.7f, 68.09f, 1.68f, 104.04f, 0.24f, 142.04f);
        f1749t.lineTo(0.26f, 142.04f);
        f1749t.cubicTo(0.1f, 144.04f, 0.02f, 146.25f, 0.02f, 148.03f);
        f1749t.cubicTo(0.02f, 149.73f, 0.21f, 154.11f, 0.22f, 154.36f);
        f1749t.cubicTo(1.82f, 192.56f, 17.91f, 228.23f, 45.53f, 254.78f);
        f1749t.cubicTo(73.23f, 281.42f, 109.65f, 296.08f, 148.08f, 296.08f);
        f1749t.cubicTo(229.52f, 296.08f, 295.9f, 229.83f, 296.06f, 148.38f);
        f1749t.cubicTo(296.06f, 148.25f, 296.06f, 148.1f, 296.05f, 147.96f);
        f1749t.moveTo(148.08f, 280.09f);
        f1749t.cubicTo(113.8f, 280.09f, 81.32f, 267.01f, 56.62f, 243.26f);
        f1749t.cubicTo(46.81f, 233.83f, 38.63f, 223.11f, 32.25f, 211.47f);
        f1749t.cubicTo(39.73f, 216.9f, 48.08f, 220.93f, 56.92f, 223.4f);
        f1749t.cubicTo(56.9f, 223.39f, 56.88f, 223.38f, 56.86f, 223.36f);
        f1749t.cubicTo(63.7f, 225.29f, 70.83f, 226.3f, 78.08f, 226.3f);
        f1749t.cubicTo(98.46f, 226.3f, 117.74f, 218.49f, 132.37f, 204.31f);
        f1749t.cubicTo(146.96f, 190.18f, 155.38f, 171.22f, 156.08f, 150.94f);
        f1749t.cubicTo(156.12f, 145.84f, 156.09f, 145.84f, 156.09f, 145.93f);
        f1749t.lineTo(156.09f, 145.81f);
        f1749t.cubicTo(157.37f, 112.35f, 184.36f, 86.17f, 217.87f, 86.17f);
        f1749t.cubicTo(252.06f, 86.17f, 279.71f, 113.92f, 279.71f, 148.11f);
        f1749t.cubicTo(279.71f, 148.11f, 279.71f, 148.11f, 279.71f, 148.11f);
        f1749t.cubicTo(279.71f, 148.17f, 279.89f, 148.46f, 279.89f, 148.58f);
        f1749t.cubicTo(279.59f, 221.08f, 220.61f, 280.09f, 148.08f, 280.09f);
        f1749t.moveTo(98.0f, 148.09f);
        f1749t.cubicTo(98.0f, 159.12f, 89.03f, 168.09f, 78.0f, 168.09f);
        f1749t.cubicTo(66.97f, 168.09f, 58.0f, 159.12f, 58.0f, 148.09f);
        f1749t.cubicTo(58.0f, 137.06f, 66.97f, 128.09f, 78.0f, 128.09f);
        f1749t.cubicTo(89.03f, 128.09f, 98.0f, 137.06f, 98.0f, 148.09f);
        f1749t.transform(f1747m);
        if (clearMode) {
            f1748p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1749t, ps);
        } else {
            c.drawPath(f1749t, f1748p);
            c.drawPath(f1749t, ps);
        }
        c.restore();
        m1620r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1748p.setColor(Color.parseColor("#000000"));
        c.save();
        f1749t.reset();
        f1749t.moveTo(218.0f, 128.09f);
        f1749t.cubicTo(206.97f, 128.09f, 198.0f, 137.06f, 198.0f, 148.09f);
        f1749t.cubicTo(198.0f, 159.12f, 206.97f, 168.09f, 218.0f, 168.09f);
        f1749t.cubicTo(229.03f, 168.09f, 238.0f, 159.12f, 238.0f, 148.09f);
        f1749t.cubicTo(238.0f, 137.06f, 229.03f, 128.09f, 218.0f, 128.09f);
        f1749t.transform(f1747m);
        if (clearMode) {
            f1748p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1749t, ps);
        } else {
            c.drawPath(f1749t, f1748p);
            c.drawPath(f1749t, ps);
        }
        c.restore();
        m1620r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1620r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1748p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1620r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1620r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1620r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1620r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1620r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1620r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1620r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1620r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1620r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1620r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1620r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1620r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1620r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1620r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1620r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1620r(new Integer[0]);
        c.restore();
    }

    private static void m1620r(Integer... o) {
        f1748p.reset();
        ps.reset();
        if (cf != null) {
            f1748p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1748p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1748p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1748p.setColor(Color.parseColor("#000000"));
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
