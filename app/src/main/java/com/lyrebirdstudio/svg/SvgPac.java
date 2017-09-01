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

public class SvgPac extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1582m = new Matrix();
    private static float od;
    private static final Paint f1583p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1584t = new Path();

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
        m1565r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1582m.reset();
        f1582m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(0.57f, 0.57f);
        c.save();
        c.save();
        f1583p.setColor(Color.parseColor("#000000"));
        f1584t.reset();
        f1584t.moveTo(850.32f, 663.51f);
        f1584t.cubicTo(774.05f, 802.06f, 626.63f, 896.0f, 457.17f, 896.0f);
        f1584t.cubicTo(209.48f, 896.0f, 8.69f, 695.43f, 8.69f, 448.0f);
        f1584t.cubicTo(8.69f, 200.58f, 209.48f, 0.0f, 457.17f, 0.0f);
        f1584t.cubicTo(660.97f, 0.0f, 832.75f, 135.92f, 887.31f, 321.88f);
        f1584t.lineTo(428.37f, 478.82f);
        f1584t.lineTo(850.32f, 663.51f);
        f1584t.moveTo(614.34f, 318.94f);
        f1584t.cubicTo(657.97f, 318.94f, 693.34f, 283.25f, 693.34f, 239.21f);
        f1584t.cubicTo(693.34f, 195.17f, 657.97f, 159.47f, 614.34f, 159.47f);
        f1584t.cubicTo(570.71f, 159.47f, 535.34f, 195.17f, 535.34f, 239.21f);
        f1584t.cubicTo(535.34f, 283.25f, 570.71f, 318.94f, 614.34f, 318.94f);
        f1584t.transform(f1582m);
        if (clearMode) {
            f1583p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1584t, ps);
        } else {
            c.drawPath(f1584t, f1583p);
            c.drawPath(f1584t, ps);
        }
        c.restore();
        m1565r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1583p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1565r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1583p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1565r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1565r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1565r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1565r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1565r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1565r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1565r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1565r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1565r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1565r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1565r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1565r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1565r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1565r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1565r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1565r(new Integer[0]);
        c.restore();
    }

    private static void m1565r(Integer... o) {
        f1583p.reset();
        ps.reset();
        if (cf != null) {
            f1583p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1583p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1583p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1583p.setColor(Color.parseColor("#000000"));
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
