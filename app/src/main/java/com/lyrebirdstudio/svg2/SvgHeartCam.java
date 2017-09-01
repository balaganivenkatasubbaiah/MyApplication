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

public class SvgHeartCam extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1702m = new Matrix();
    private static float od;
    private static final Paint f1703p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1704t = new Path();

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
        m1605r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1702m.reset();
        f1702m.setScale(od * 2.17f, od * 2.17f);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.save();
        c.save();
        f1703p.setColor(Color.parseColor("#000000"));
        f1704t.reset();
        f1704t.moveTo(229.0f, 51.5f);
        f1704t.lineTo(229.0f, 23.5f);
        f1704t.lineTo(189.0f, 23.5f);
        f1704t.lineTo(189.0f, 51.5f);
        f1704t.lineTo(185.15f, 51.5f);
        f1704t.lineTo(168.55f, 23.5f);
        f1704t.lineTo(68.11f, 23.5f);
        f1704t.lineTo(51.52f, 51.5f);
        f1704t.lineTo(0.0f, 51.5f);
        f1704t.lineTo(0.0f, 212.5f);
        f1704t.lineTo(236.0f, 212.5f);
        f1704t.lineTo(236.0f, 51.5f);
        f1704t.lineTo(229.0f, 51.5f);
        f1704t.moveTo(118.33f, 71.39f);
        f1704t.cubicTo(151.2f, 71.39f, 177.94f, 98.13f, 177.94f, 131.0f);
        f1704t.cubicTo(177.94f, 163.87f, 151.2f, 190.61f, 118.33f, 190.61f);
        f1704t.cubicTo(85.47f, 190.61f, 58.73f, 163.87f, 58.73f, 131.0f);
        f1704t.cubicTo(58.73f, 98.13f, 85.47f, 71.39f, 118.33f, 71.39f);
        f1704t.transform(f1702m);
        if (clearMode) {
            f1703p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1704t, ps);
        } else {
            c.drawPath(f1704t, f1703p);
            c.drawPath(f1704t, ps);
        }
        c.restore();
        m1605r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1703p.setColor(Color.parseColor("#000000"));
        c.save();
        f1704t.reset();
        f1704t.moveTo(118.37f, 167.25f);
        f1704t.cubicTo(118.37f, 167.25f, 147.71f, 148.19f, 153.31f, 138.68f);
        f1704t.cubicTo(156.1f, 133.94f, 158.07f, 128.74f, 157.75f, 121.89f);
        f1704t.cubicTo(157.17f, 109.77f, 148.29f, 99.75f, 137.42f, 99.75f);
        f1704t.cubicTo(126.73f, 99.75f, 118.33f, 108.65f, 118.33f, 108.65f);
        f1704t.cubicTo(118.33f, 108.65f, 110.42f, 99.75f, 99.25f, 99.75f);
        f1704t.cubicTo(88.38f, 99.75f, 79.5f, 109.77f, 78.92f, 121.89f);
        f1704t.cubicTo(78.59f, 128.74f, 80.57f, 133.96f, 83.36f, 138.68f);
        f1704t.cubicTo(88.92f, 148.11f, 118.37f, 167.25f, 118.37f, 167.25f);
        f1704t.transform(f1702m);
        if (clearMode) {
            f1703p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1704t, ps);
        } else {
            c.drawPath(f1704t, f1703p);
            c.drawPath(f1704t, ps);
        }
        c.restore();
        m1605r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1605r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1703p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1605r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1605r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1605r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1605r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1605r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1605r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1605r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1605r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1605r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1605r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1605r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1605r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1605r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1605r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1605r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1605r(new Integer[0]);
        c.restore();
    }

    private static void m1605r(Integer... o) {
        f1703p.reset();
        ps.reset();
        if (cf != null) {
            f1703p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1703p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1703p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1703p.setColor(Color.parseColor("#000000"));
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
