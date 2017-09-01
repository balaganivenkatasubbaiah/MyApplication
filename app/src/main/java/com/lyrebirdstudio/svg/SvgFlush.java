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

public class SvgFlush extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1534m = new Matrix();
    private static float od;
    private static final Paint f1535p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1536t = new Path();

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
        m1549r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1534m.reset();
        f1534m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(0.56f, 0.56f);
        c.save();
        c.save();
        c.save();
        f1535p.setColor(Color.parseColor("#000000"));
        f1536t.reset();
        f1536t.moveTo(39.45f, 803.1f);
        f1536t.cubicTo(39.45f, 803.0f, 39.45f, 803.0f, 39.45f, 803.1f);
        f1536t.cubicTo(39.45f, 803.0f, 39.45f, 803.0f, 39.45f, 803.1f);
        f1536t.lineTo(39.45f, 803.1f);
        f1536t.transform(f1534m);
        if (clearMode) {
            f1535p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1536t, ps);
        } else {
            c.drawPath(f1536t, f1535p);
            c.drawPath(f1536t, ps);
        }
        c.restore();
        m1549r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1535p.setColor(Color.parseColor("#000000"));
        c.save();
        f1536t.reset();
        f1536t.moveTo(795.95f, 690.6f);
        f1536t.cubicTo(795.95f, 690.5f, 795.95f, 690.5f, 795.95f, 690.6f);
        f1536t.cubicTo(795.95f, 690.5f, 795.95f, 690.5f, 795.95f, 690.6f);
        f1536t.cubicTo(805.85f, 673.3f, 811.45f, 653.4f, 811.45f, 632.1f);
        f1536t.cubicTo(811.45f, 567.8f, 759.75f, 515.7f, 695.65f, 515.1f);
        f1536t.lineTo(695.65f, 515.1f);
        f1536t.cubicTo(706.45f, 488.8f, 706.45f, 464.8f, 706.45f, 464.8f);
        f1536t.cubicTo(706.45f, 304.0f, 597.25f, 273.6f, 547.55f, 268.1f);
        f1536t.cubicTo(539.45f, 267.2f, 533.75f, 275.8f, 537.75f, 282.9f);
        f1536t.cubicTo(542.45f, 291.2f, 545.45f, 302.7f, 541.45f, 317.2f);
        f1536t.cubicTo(531.45f, 353.0f, 492.75f, 348.0f, 474.05f, 348.0f);
        f1536t.lineTo(335.05f, 348.0f);
        f1536t.cubicTo(270.65f, 348.0f, 218.45f, 400.2f, 218.45f, 464.6f);
        f1536t.lineTo(218.45f, 464.9f);
        f1536t.cubicTo(218.45f, 482.8f, 222.45f, 500.0f, 229.65f, 515.0f);
        f1536t.lineTo(225.85f, 515.0f);
        f1536t.cubicTo(161.25f, 515.0f, 108.45f, 567.4f, 108.45f, 632.0f);
        f1536t.lineTo(108.45f, 632.0f);
        f1536t.cubicTo(108.45f, 653.3f, 114.35f, 673.3f, 124.35f, 690.5f);
        f1536t.cubicTo(124.35f, 690.5f, 124.35f, 690.5f, 124.55f, 690.5f);
        f1536t.cubicTo(124.35f, 690.5f, 124.35f, 690.5f, 124.35f, 690.5f);
        f1536t.cubicTo(75.45f, 704.5f, 39.45f, 749.6f, 39.45f, 803.0f);
        f1536t.cubicTo(39.45f, 867.6f, 92.15f, 920.0f, 156.85f, 920.0f);
        f1536t.lineTo(763.75f, 920.0f);
        f1536t.cubicTo(828.35f, 920.0f, 880.55f, 867.7f, 880.55f, 803.0f);
        f1536t.cubicTo(880.45f, 749.6f, 844.85f, 704.6f, 795.95f, 690.6f);
        f1536t.transform(f1534m);
        if (clearMode) {
            f1535p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1536t, ps);
        } else {
            c.drawPath(f1536t, f1535p);
            c.drawPath(f1536t, ps);
        }
        c.restore();
        m1549r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1536t.reset();
        f1536t.moveTo(335.65f, 304.3f);
        f1536t.cubicTo(346.05f, 301.8f, 356.85f, 295.7f, 364.85f, 289.4f);
        f1536t.cubicTo(401.55f, 260.8f, 412.25f, 209.3f, 397.65f, 166.4f);
        f1536t.cubicTo(385.55f, 131.0f, 361.25f, 101.6f, 346.05f, 67.8f);
        f1536t.cubicTo(343.35f, 61.8f, 340.95f, 55.8f, 339.25f, 49.8f);
        f1536t.cubicTo(334.75f, 34.9f, 334.85f, 18.8f, 336.15f, 3.4f);
        f1536t.lineTo(336.15f, 3.3f);
        f1536t.cubicTo(336.35f, 1.1f, 334.15f, -0.6f, 332.05f, 0.2f);
        f1536t.lineTo(332.05f, 0.2f);
        f1536t.cubicTo(298.85f, 11.7f, 280.05f, 45.7f, 277.75f, 79.3f);
        f1536t.cubicTo(275.55f, 111.1f, 286.35f, 141.9f, 301.05f, 169.6f);
        f1536t.cubicTo(315.45f, 196.8f, 331.35f, 220.8f, 334.55f, 252.5f);
        f1536t.cubicTo(336.05f, 267.1f, 333.25f, 291.3f, 331.95f, 300.9f);
        f1536t.cubicTo(331.75f, 303.0f, 333.65f, 304.7f, 335.65f, 304.3f);
        f1536t.transform(f1534m);
        if (clearMode) {
            f1535p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1536t, ps);
        } else {
            c.drawPath(f1536t, f1535p);
            c.drawPath(f1536t, ps);
        }
        c.restore();
        m1549r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1536t.reset();
        f1536t.moveTo(137.75f, 420.9f);
        f1536t.cubicTo(148.15f, 418.4f, 158.95f, 412.3f, 166.95f, 406.0f);
        f1536t.cubicTo(203.65f, 377.4f, 214.35f, 325.9f, 199.75f, 283.0f);
        f1536t.cubicTo(187.65f, 247.6f, 163.35f, 218.2f, 148.15f, 184.4f);
        f1536t.cubicTo(145.45f, 178.4f, 143.05f, 172.4f, 141.35f, 166.4f);
        f1536t.cubicTo(136.85f, 151.5f, 136.95f, 135.4f, 138.25f, 120.0f);
        f1536t.lineTo(138.25f, 119.9f);
        f1536t.cubicTo(138.45f, 117.7f, 136.25f, 116.0f, 134.15f, 116.8f);
        f1536t.lineTo(134.15f, 116.8f);
        f1536t.cubicTo(100.95f, 128.3f, 82.15f, 162.3f, 79.85f, 195.9f);
        f1536t.cubicTo(77.65f, 227.7f, 88.45f, 258.5f, 103.15f, 286.2f);
        f1536t.cubicTo(117.55f, 313.4f, 133.45f, 337.4f, 136.65f, 369.1f);
        f1536t.cubicTo(138.15f, 383.7f, 135.35f, 407.9f, 134.05f, 417.5f);
        f1536t.cubicTo(133.85f, 419.7f, 135.75f, 421.4f, 137.75f, 420.9f);
        f1536t.transform(f1534m);
        if (clearMode) {
            f1535p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1536t, ps);
        } else {
            c.drawPath(f1536t, f1535p);
            c.drawPath(f1536t, ps);
        }
        c.restore();
        m1549r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1549r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1535p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1549r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1535p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1549r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1549r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1549r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1549r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1549r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1549r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1549r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1549r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1549r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1549r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1549r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1549r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1549r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1549r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1549r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1549r(new Integer[0]);
        c.restore();
    }

    private static void m1549r(Integer... o) {
        f1535p.reset();
        ps.reset();
        if (cf != null) {
            f1535p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1535p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1535p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1535p.setColor(Color.parseColor("#000000"));
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
