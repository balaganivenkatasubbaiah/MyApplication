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

public class SvgDisc extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1519m = new Matrix();
    private static float od;
    private static final Paint f1520p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1521t = new Path();

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
        m1544r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1519m.reset();
        f1519m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(0.93f, 0.93f);
        c.save();
        c.save();
        c.save();
        f1520p.setColor(Color.parseColor("#000000"));
        f1521t.reset();
        f1521t.moveTo(376.01f, 275.4f);
        f1521t.cubicTo(376.01f, 330.93f, 330.84f, 376.11f, 275.31f, 376.11f);
        f1521t.cubicTo(249.36f, 376.11f, 225.76f, 366.15f, 207.88f, 349.98f);
        f1521t.lineTo(103.19f, 490.32f);
        f1521t.cubicTo(150.34f, 528.13f, 210.16f, 550.81f, 275.31f, 550.81f);
        f1521t.cubicTo(427.41f, 550.81f, 550.71f, 427.5f, 550.71f, 275.41f);
        f1521t.cubicTo(550.71f, 266.6f, 550.25f, 257.91f, 549.44f, 249.32f);
        f1521t.lineTo(374.69f, 259.92f);
        f1521t.cubicTo(375.48f, 264.98f, 376.01f, 270.13f, 376.01f, 275.4f);
        f1521t.transform(f1519m);
        if (clearMode) {
            f1520p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1521t, ps);
        } else {
            c.drawPath(f1521t, f1520p);
            c.drawPath(f1521t, ps);
        }
        c.restore();
        m1544r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1520p.setColor(Color.parseColor("#000000"));
        c.save();
        f1521t.reset();
        f1521t.moveTo(371.87f, 247.03f);
        f1521t.lineTo(541.48f, 204.6f);
        f1521t.cubicTo(537.99f, 191.47f, 533.57f, 178.73f, 528.27f, 166.46f);
        f1521t.lineTo(368.73f, 237.99f);
        f1521t.cubicTo(369.91f, 240.94f, 370.97f, 243.96f, 371.87f, 247.03f);
        f1521t.transform(f1519m);
        if (clearMode) {
            f1520p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1521t, ps);
        } else {
            c.drawPath(f1521t, f1520p);
            c.drawPath(f1521t, ps);
        }
        c.restore();
        m1544r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1521t.reset();
        f1521t.moveTo(275.31f, 363.87f);
        f1521t.cubicTo(324.09f, 363.87f, 363.77f, 324.18f, 363.77f, 275.4f);
        f1521t.cubicTo(363.77f, 226.62f, 324.09f, 186.94f, 275.31f, 186.94f);
        f1521t.cubicTo(226.53f, 186.94f, 186.85f, 226.62f, 186.85f, 275.4f);
        f1521t.cubicTo(186.85f, 324.18f, 226.53f, 363.87f, 275.31f, 363.87f);
        f1521t.moveTo(275.31f, 229.56f);
        f1521t.cubicTo(300.63f, 229.56f, 321.15f, 250.09f, 321.15f, 275.41f);
        f1521t.cubicTo(321.15f, 300.72f, 300.63f, 321.24f, 275.31f, 321.24f);
        f1521t.cubicTo(249.99f, 321.24f, 229.47f, 300.72f, 229.47f, 275.4f);
        f1521t.cubicTo(229.47f, 250.08f, 249.99f, 229.56f, 275.31f, 229.56f);
        f1521t.transform(f1519m);
        if (clearMode) {
            f1520p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1521t, ps);
        } else {
            c.drawPath(f1521t, f1520p);
            c.drawPath(f1521t, ps);
        }
        c.restore();
        m1544r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1521t.reset();
        f1521t.moveTo(2.58f, 313.43f);
        f1521t.cubicTo(10.27f, 369.01f, 34.49f, 419.29f, 70.19f, 459.12f);
        f1521t.lineTo(198.67f, 340.56f);
        f1521t.cubicTo(186.1f, 325.8f, 177.73f, 307.4f, 175.36f, 287.16f);
        f1521t.lineTo(2.58f, 313.43f);
        f1521t.transform(f1519m);
        if (clearMode) {
            f1520p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1521t, ps);
        } else {
            c.drawPath(f1521t, f1520p);
            c.drawPath(f1521t, ps);
        }
        c.restore();
        m1544r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1521t.reset();
        f1521t.moveTo(275.31f, 174.7f);
        f1521t.cubicTo(312.92f, 174.7f, 345.74f, 195.47f, 363.03f, 226.1f);
        f1521t.lineTo(506.87f, 126.4f);
        f1521t.cubicTo(457.85f, 50.39f, 372.49f, 0.0f, 275.31f, 0.0f);
        f1521t.cubicTo(125.65f, 0.0f, 3.95f, 119.41f, 0.1f, 268.15f);
        f1521t.lineTo(174.68f, 274.04f);
        f1521t.cubicTo(175.42f, 219.15f, 220.24f, 174.7f, 275.31f, 174.7f);
        f1521t.transform(f1519m);
        if (clearMode) {
            f1520p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1521t, ps);
        } else {
            c.drawPath(f1521t, f1520p);
            c.drawPath(f1521t, ps);
        }
        c.restore();
        m1544r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1544r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1520p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1544r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1520p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1544r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1544r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1544r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1544r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1544r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1544r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1544r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1544r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1544r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1544r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1544r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1544r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1544r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1544r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1544r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1544r(new Integer[0]);
        c.restore();
    }

    private static void m1544r(Integer... o) {
        f1520p.reset();
        ps.reset();
        if (cf != null) {
            f1520p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1520p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1520p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1520p.setColor(Color.parseColor("#000000"));
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
