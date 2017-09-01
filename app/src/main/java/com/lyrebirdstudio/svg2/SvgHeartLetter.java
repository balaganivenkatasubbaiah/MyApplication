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
public class SvgHeartLetter extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1708m = new Matrix();
    private static float od;
    private static final Paint f1709p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1710t = new Path();

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
        m1607r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1708m.reset();
        f1708m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(1.56f, 1.56f);
        c.save();
        c.save();
        c.save();
        c.save();
        c.save();
        f1709p.setColor(Color.parseColor("#000000"));
        f1710t.reset();
        f1710t.moveTo(311.69f, 121.34f);
        f1710t.cubicTo(309.46f, 119.8f, 195.85f, 23.02f, 169.59f, 2.83f);
        f1710t.cubicTo(166.15f, 0.19f, 165.9f, -0.0f, 164.21f, 0.0f);
        f1710t.cubicTo(162.36f, 0.01f, 162.1f, 0.34f, 158.39f, 3.23f);
        f1710t.cubicTo(131.36f, 24.3f, 19.4f, 121.05f, 18.08f, 122.36f);
        f1710t.cubicTo(13.29f, 127.15f, 16.33f, 130.25f, 19.43f, 132.42f);
        f1710t.cubicTo(28.39f, 138.71f, 41.72f, 147.39f, 60.22f, 159.58f);
        f1710t.cubicTo(60.96f, 160.07f, 61.69f, 160.56f, 62.43f, 161.04f);
        f1710t.cubicTo(63.38f, 161.66f, 65.27f, 161.73f, 65.27f, 158.57f);
        f1710t.lineTo(65.27f, 100.13f);
        f1710t.cubicTo(65.27f, 94.48f, 69.89f, 89.86f, 75.54f, 89.86f);
        f1710t.lineTo(252.92f, 89.86f);
        f1710t.cubicTo(258.57f, 89.86f, 263.19f, 94.48f, 263.19f, 100.13f);
        f1710t.cubicTo(263.19f, 100.13f, 263.19f, 142.99f, 263.19f, 157.27f);
        f1710t.cubicTo(263.19f, 160.71f, 264.78f, 160.67f, 265.55f, 160.15f);
        f1710t.cubicTo(277.41f, 152.06f, 311.6f, 129.23f, 311.6f, 129.23f);
        f1710t.cubicTo(312.97f, 128.32f, 315.79f, 124.16f, 311.69f, 121.34f);
        f1710t.transform(f1708m);
        if (clearMode) {
            f1709p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1710t, ps);
        } else {
            c.drawPath(f1710t, f1709p);
            c.drawPath(f1710t, ps);
        }
        c.restore();
        m1607r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1709p.setColor(Color.parseColor("#000000"));
        c.save();
        f1710t.reset();
        f1710t.moveTo(320.95f, 147.11f);
        f1710t.cubicTo(320.95f, 142.37f, 317.94f, 144.36f, 317.94f, 144.36f);
        f1710t.lineTo(203.49f, 221.2f);
        f1710t.cubicTo(203.49f, 221.2f, 201.15f, 222.98f, 197.95f, 222.98f);
        f1710t.cubicTo(196.81f, 222.98f, 129.35f, 223.3f, 129.36f, 223.16f);
        f1710t.cubicTo(125.93f, 223.16f, 124.36f, 221.98f, 123.5f, 221.38f);
        f1710t.cubicTo(88.51f, 196.92f, 30.9f, 160.05f, 10.24f, 145.57f);
        f1710t.cubicTo(7.82f, 143.87f, 7.4f, 146.52f, 7.4f, 146.52f);
        f1710t.lineTo(7.4f, 306.67f);
        f1710t.cubicTo(7.4f, 318.66f, 17.2f, 328.46f, 29.19f, 328.46f);
        f1710t.lineTo(299.27f, 328.46f);
        f1710t.cubicTo(311.26f, 328.46f, 321.07f, 318.66f, 321.07f, 306.67f);
        f1710t.cubicTo(321.07f, 306.67f, 320.95f, 191.74f, 320.95f, 147.11f);
        f1710t.transform(f1708m);
        if (clearMode) {
            f1709p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1710t, ps);
        } else {
            c.drawPath(f1710t, f1709p);
            c.drawPath(f1710t, ps);
        }
        c.restore();
        m1607r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1710t.reset();
        f1710t.moveTo(189.06f, 128.78f);
        f1710t.cubicTo(175.14f, 128.78f, 166.31f, 144.3f, 164.22f, 144.3f);
        f1710t.cubicTo(162.4f, 144.3f, 153.92f, 128.78f, 139.38f, 128.78f);
        f1710t.cubicTo(125.24f, 128.78f, 113.69f, 140.45f, 112.93f, 154.57f);
        f1710t.cubicTo(112.5f, 162.55f, 115.08f, 168.63f, 118.7f, 174.13f);
        f1710t.cubicTo(125.94f, 185.12f, 157.61f, 211.57f, 164.27f, 211.57f);
        f1710t.cubicTo(171.07f, 211.57f, 202.45f, 185.21f, 209.74f, 174.13f);
        f1710t.cubicTo(213.38f, 168.6f, 215.94f, 162.55f, 215.51f, 154.57f);
        f1710t.cubicTo(214.75f, 140.45f, 203.21f, 128.78f, 189.06f, 128.78f);
        f1710t.transform(f1708m);
        if (clearMode) {
            f1709p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1710t, ps);
        } else {
            c.drawPath(f1710t, f1709p);
            c.drawPath(f1710t, ps);
        }
        c.restore();
        m1607r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1607r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1709p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1607r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1709p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1607r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1709p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1607r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1709p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1607r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1607r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1607r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1607r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1607r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1607r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1607r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1607r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1607r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1607r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1607r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1607r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1607r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1607r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1607r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1607r(new Integer[0]);
        c.restore();
    }

    private static void m1607r(Integer... o) {
        f1709p.reset();
        ps.reset();
        if (cf != null) {
            f1709p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1709p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1709p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1709p.setColor(Color.parseColor("#000000"));
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
