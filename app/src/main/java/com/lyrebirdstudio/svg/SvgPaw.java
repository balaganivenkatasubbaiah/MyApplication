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

public class SvgPaw extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1600m = new Matrix();
    private static float od;
    private static final Paint f1601p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1602t = new Path();

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
        od = w / 390.0f < h / 390.0f ? w / 390.0f : h / 390.0f;
        m1571r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 390.0f)) / 2.0f) + dx, ((h - (od * 390.0f)) / 2.0f) + dy);
        f1600m.reset();
        f1600m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(1.0f, 1.0f);
        c.save();
        c.save();
        c.save();
        f1602t.reset();
        f1602t.moveTo(132.64f, 177.86f);
        f1602t.cubicTo(163.8f, 177.86f, 189.15f, 143.84f, 189.15f, 102.03f);
        f1602t.cubicTo(189.15f, 60.21f, 163.8f, 26.18f, 132.64f, 26.18f);
        f1602t.cubicTo(101.49f, 26.18f, 76.14f, 60.21f, 76.14f, 102.03f);
        f1602t.cubicTo(76.14f, 143.84f, 101.49f, 177.86f, 132.64f, 177.86f);
        f1602t.transform(f1600m);
        if (clearMode) {
            f1601p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1602t, ps);
        } else {
            c.drawPath(f1602t, f1601p);
            c.drawPath(f1602t, ps);
        }
        c.restore();
        m1571r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        f1602t.reset();
        f1602t.moveTo(300.25f, 251.63f);
        f1602t.cubicTo(299.09f, 250.05f, 297.98f, 248.56f, 297.38f, 247.28f);
        f1602t.cubicTo(284.75f, 220.23f, 250.11f, 188.35f, 194.0f, 187.56f);
        f1602t.lineTo(191.84f, 187.54f);
        f1602t.cubicTo(136.59f, 187.54f, 102.21f, 217.74f, 88.46f, 246.01f);
        f1602t.cubicTo(87.99f, 246.98f, 86.94f, 248.23f, 85.83f, 249.56f);
        f1602t.cubicTo(84.52f, 251.12f, 83.23f, 252.71f, 82.12f, 254.44f);
        f1602t.cubicTo(70.5f, 272.51f, 64.58f, 292.86f, 65.45f, 311.74f);
        f1602t.cubicTo(66.37f, 331.77f, 74.76f, 347.87f, 89.03f, 357.05f);
        f1602t.cubicTo(94.8f, 360.75f, 101.02f, 362.62f, 107.55f, 362.62f);
        f1602t.cubicTo(121.02f, 362.62f, 133.35f, 355.04f, 147.63f, 346.25f);
        f1602t.cubicTo(156.72f, 340.65f, 166.1f, 334.88f, 176.52f, 330.56f);
        f1602t.cubicTo(177.69f, 330.17f, 182.47f, 329.58f, 190.3f, 329.58f);
        f1602t.cubicTo(199.61f, 329.58f, 206.29f, 330.41f, 207.72f, 330.9f);
        f1602t.cubicTo(217.89f, 335.39f, 226.83f, 341.29f, 235.47f, 346.97f);
        f1602t.cubicTo(248.71f, 355.7f, 261.22f, 363.94f, 274.79f, 363.94f);
        f1602t.cubicTo(280.62f, 363.94f, 286.26f, 362.4f, 291.59f, 359.38f);
        f1602t.cubicTo(320.97f, 342.69f, 326.57f, 296.89f, 304.07f, 257.29f);
        f1602t.cubicTo(302.94f, 255.3f, 301.6f, 253.45f, 300.25f, 251.63f);
        f1602t.transform(f1600m);
        if (clearMode) {
            f1601p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1602t, ps);
        } else {
            c.drawPath(f1602t, f1601p);
            c.drawPath(f1602t, ps);
        }
        c.restore();
        m1571r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        f1602t.reset();
        f1602t.moveTo(252.8f, 177.86f);
        f1602t.cubicTo(283.94f, 177.86f, 309.3f, 143.84f, 309.3f, 102.03f);
        f1602t.cubicTo(309.3f, 60.21f, 283.94f, 26.18f, 252.8f, 26.18f);
        f1602t.cubicTo(221.63f, 26.18f, 196.29f, 60.21f, 196.29f, 102.03f);
        f1602t.cubicTo(196.28f, 143.84f, 221.63f, 177.86f, 252.8f, 177.86f);
        f1602t.transform(f1600m);
        if (clearMode) {
            f1601p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1602t, ps);
        } else {
            c.drawPath(f1602t, f1601p);
            c.drawPath(f1602t, ps);
        }
        c.restore();
        m1571r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        f1602t.reset();
        f1602t.moveTo(345.6f, 138.92f);
        f1602t.cubicTo(320.62f, 138.92f, 301.07f, 164.82f, 301.07f, 197.88f);
        f1602t.cubicTo(301.07f, 230.94f, 320.63f, 256.84f, 345.6f, 256.84f);
        f1602t.cubicTo(370.56f, 256.84f, 390.13f, 230.94f, 390.13f, 197.88f);
        f1602t.cubicTo(390.13f, 164.82f, 370.57f, 138.92f, 345.6f, 138.92f);
        f1602t.transform(f1600m);
        if (clearMode) {
            f1601p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1602t, ps);
        } else {
            c.drawPath(f1602t, f1601p);
            c.drawPath(f1602t, ps);
        }
        c.restore();
        m1571r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        f1602t.reset();
        f1602t.moveTo(89.05f, 197.88f);
        f1602t.cubicTo(89.05f, 164.82f, 69.49f, 138.92f, 44.53f, 138.92f);
        f1602t.cubicTo(19.56f, 138.92f, 0.0f, 164.82f, 0.0f, 197.88f);
        f1602t.cubicTo(0.0f, 230.94f, 19.56f, 256.84f, 44.53f, 256.84f);
        f1602t.cubicTo(69.49f, 256.84f, 89.05f, 230.94f, 89.05f, 197.88f);
        f1602t.transform(f1600m);
        if (clearMode) {
            f1601p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1602t, ps);
        } else {
            c.drawPath(f1602t, f1601p);
            c.drawPath(f1602t, ps);
        }
        c.restore();
        m1571r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.restore();
        m1571r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.restore();
        m1571r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1571r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1571r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1571r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1571r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1571r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1571r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1571r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1571r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1571r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1571r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1571r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1571r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1571r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1571r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1571r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.restore();
        m1571r(new Integer[0]);
        c.restore();
    }

    private static void m1571r(Integer... o) {
        f1601p.reset();
        ps.reset();
        if (cf != null) {
            f1601p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1601p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1601p.setStyle(Style.FILL);
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
                    ps.setStrokeCap(Cap.BUTT);
                    break;
                case 3:
                    ps.setColor(Color.argb(0, 0, 0, 0));
                    break;
                default:
                    break;
            }
        }
    }
}
