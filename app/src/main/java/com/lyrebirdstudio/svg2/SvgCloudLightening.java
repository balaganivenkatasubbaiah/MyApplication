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
public class SvgCloudLightening extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1678m = new Matrix();
    private static float od;
    private static final Paint f1679p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1680t = new Path();

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
        m1597r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1678m.reset();
        f1678m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(1.15f, 1.15f);
        c.save();
        c.save();
        c.save();
        f1679p.setColor(Color.parseColor("#000000"));
        f1680t.reset();
        f1680t.moveTo(375.77f, 103.23f);
        f1680t.cubicTo(376.91f, 98.03f, 377.51f, 92.67f, 377.51f, 87.19f);
        f1680t.cubicTo(377.51f, 39.27f, 332.12f, 0.43f, 276.13f, 0.43f);
        f1680t.cubicTo(236.21f, 0.43f, 201.68f, 20.18f, 185.15f, 48.88f);
        f1680t.cubicTo(181.73f, 48.59f, 178.26f, 48.43f, 174.75f, 48.43f);
        f1680t.cubicTo(133.36f, 48.43f, 97.76f, 69.67f, 82.02f, 100.1f);
        f1680t.cubicTo(35.29f, 107.84f, 0.0f, 143.02f, 0.0f, 185.27f);
        f1680t.cubicTo(0.0f, 233.18f, 45.39f, 272.02f, 101.38f, 272.02f);
        f1680t.lineTo(342.75f, 272.02f);
        f1680t.cubicTo(398.74f, 272.02f, 444.13f, 233.18f, 444.13f, 185.27f);
        f1680t.cubicTo(444.13f, 147.25f, 415.55f, 114.94f, 375.77f, 103.23f);
        f1680t.transform(f1678m);
        if (clearMode) {
            f1679p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1680t, ps);
        } else {
            c.drawPath(f1680t, f1679p);
            c.drawPath(f1680t, ps);
        }
        c.restore();
        m1597r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1679p.setColor(Color.parseColor("#000000"));
        c.save();
        f1680t.reset();
        f1680t.moveTo(289.23f, 280.02f);
        f1680t.lineTo(203.68f, 371.37f);
        f1680t.lineTo(279.62f, 371.37f);
        f1680t.lineTo(239.52f, 443.7f);
        f1680t.lineTo(327.89f, 347.63f);
        f1680t.lineTo(251.94f, 347.63f);
        f1680t.lineTo(289.23f, 280.02f);
        f1680t.transform(f1678m);
        if (clearMode) {
            f1679p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1680t, ps);
        } else {
            c.drawPath(f1680t, f1679p);
            c.drawPath(f1680t, ps);
        }
        c.restore();
        m1597r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1680t.reset();
        f1680t.moveTo(168.74f, 294.85f);
        f1680t.lineTo(116.25f, 350.89f);
        f1680t.lineTo(162.84f, 350.89f);
        f1680t.lineTo(138.24f, 395.27f);
        f1680t.lineTo(192.45f, 336.33f);
        f1680t.lineTo(145.86f, 336.33f);
        f1680t.lineTo(168.74f, 294.85f);
        f1680t.transform(f1678m);
        if (clearMode) {
            f1679p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1680t, ps);
        } else {
            c.drawPath(f1680t, f1679p);
            c.drawPath(f1680t, ps);
        }
        c.restore();
        m1597r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1597r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1679p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1597r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1679p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1597r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1597r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1597r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1597r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1597r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1597r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1597r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1597r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1597r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1597r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1597r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1597r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1597r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1597r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1597r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1597r(new Integer[0]);
        c.restore();
    }

    private static void m1597r(Integer... o) {
        f1679p.reset();
        ps.reset();
        if (cf != null) {
            f1679p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1679p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1679p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1679p.setColor(Color.parseColor("#000000"));
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
