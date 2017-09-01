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

public class SvgStarSquare extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1612m = new Matrix();
    private static float od;
    private static final Paint f1613p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1614t = new Path();

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
        m1575r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1612m.reset();
        f1612m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(1.61f, 1.61f);
        c.save();
        c.save();
        f1613p.setColor(Color.parseColor("#000000"));
        f1614t.reset();
        f1614t.moveTo(190.86f, 114.49f);
        f1614t.lineTo(170.32f, 72.87f);
        f1614t.cubicTo(168.17f, 68.52f, 163.73f, 65.76f, 158.88f, 65.76f);
        f1614t.cubicTo(154.02f, 65.76f, 149.58f, 68.52f, 147.43f, 72.87f);
        f1614t.lineTo(126.89f, 114.49f);
        f1614t.lineTo(80.96f, 121.17f);
        f1614t.cubicTo(76.16f, 121.86f, 72.16f, 125.23f, 70.66f, 129.85f);
        f1614t.cubicTo(69.16f, 134.47f, 70.41f, 139.54f, 73.89f, 142.93f);
        f1614t.lineTo(107.13f, 175.33f);
        f1614t.lineTo(99.28f, 221.07f);
        f1614t.cubicTo(98.46f, 225.86f, 100.43f, 230.7f, 104.36f, 233.55f);
        f1614t.cubicTo(108.29f, 236.41f, 113.5f, 236.79f, 117.8f, 234.53f);
        f1614t.lineTo(158.88f, 212.93f);
        f1614t.lineTo(199.96f, 234.53f);
        f1614t.cubicTo(201.82f, 235.51f, 203.86f, 235.99f, 205.89f, 235.99f);
        f1614t.cubicTo(208.54f, 235.99f, 211.17f, 235.17f, 213.4f, 233.55f);
        f1614t.cubicTo(217.33f, 230.7f, 219.29f, 225.86f, 218.47f, 221.07f);
        f1614t.lineTo(210.63f, 175.33f);
        f1614t.lineTo(243.86f, 142.93f);
        f1614t.cubicTo(247.34f, 139.54f, 248.59f, 134.47f, 247.09f, 129.85f);
        f1614t.cubicTo(245.59f, 125.23f, 241.6f, 121.86f, 236.79f, 121.17f);
        f1614t.lineTo(190.86f, 114.49f);
        f1614t.transform(f1612m);
        if (clearMode) {
            f1613p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1614t, ps);
        } else {
            c.drawPath(f1614t, f1613p);
            c.drawPath(f1614t, ps);
        }
        c.restore();
        m1575r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1613p.setColor(Color.parseColor("#000000"));
        c.save();
        f1614t.reset();
        f1614t.moveTo(286.53f, 0.0f);
        f1614t.lineTo(31.23f, 0.0f);
        f1614t.cubicTo(18.68f, 0.0f, 8.52f, 10.17f, 8.52f, 22.71f);
        f1614t.lineTo(8.52f, 295.05f);
        f1614t.cubicTo(8.52f, 307.59f, 18.69f, 317.75f, 31.23f, 317.75f);
        f1614t.lineTo(286.53f, 317.75f);
        f1614t.cubicTo(299.07f, 317.75f, 309.23f, 307.59f, 309.23f, 295.05f);
        f1614t.lineTo(309.23f, 22.71f);
        f1614t.cubicTo(309.23f, 10.17f, 299.07f, 0.0f, 286.53f, 0.0f);
        f1614t.moveTo(158.88f, 274.65f);
        f1614t.cubicTo(94.89f, 274.65f, 43.11f, 222.87f, 43.11f, 158.88f);
        f1614t.cubicTo(43.11f, 94.89f, 94.88f, 43.11f, 158.88f, 43.11f);
        f1614t.cubicTo(222.86f, 43.11f, 274.65f, 94.89f, 274.65f, 158.88f);
        f1614t.cubicTo(274.65f, 222.86f, 222.87f, 274.65f, 158.88f, 274.65f);
        f1614t.transform(f1612m);
        if (clearMode) {
            f1613p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1614t, ps);
        } else {
            c.drawPath(f1614t, f1613p);
            c.drawPath(f1614t, ps);
        }
        c.restore();
        m1575r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1575r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1613p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1575r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1575r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1575r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1575r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1575r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1575r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1575r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1575r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1575r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1575r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1575r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1575r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1575r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1575r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1575r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1575r(new Integer[0]);
        c.restore();
    }

    private static void m1575r(Integer... o) {
        f1613p.reset();
        ps.reset();
        if (cf != null) {
            f1613p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1613p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1613p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1613p.setColor(Color.parseColor("#000000"));
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
