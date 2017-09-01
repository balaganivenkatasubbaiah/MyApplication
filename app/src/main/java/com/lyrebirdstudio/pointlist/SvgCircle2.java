package com.lyrebirdstudio.pointlist;

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

public class SvgCircle2 extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1384m = new Matrix();
    private static float od;
    private static final Paint f1385p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1386t = new Path();

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
        od = w / 377.0f < h / 377.0f ? w / 377.0f : h / 377.0f;
        m1499r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 377.0f)) / 2.0f) + dx, ((h - (od * 377.0f)) / 2.0f) + dy);
        f1384m.reset();
        f1384m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.save();
        f1385p.setColor(Color.parseColor("#FFFFFF"));
        c.restore();
        m1499r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1499r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.translate(-197.14f * od, -338.08f * od);
        c.save();
        f1385p.setColor(Color.argb(255, 0, 0, 0));
        c.translate(31.43f * od, 2.86f * od);
        f1386t.reset();
        f1386t.moveTo(542.86f, 523.79f);
        f1386t.cubicTo(542.86f, 627.94f, 458.43f, 712.36f, 354.29f, 712.36f);
        f1386t.cubicTo(250.14f, 712.36f, 165.71f, 627.94f, 165.71f, 523.79f);
        f1386t.cubicTo(165.71f, 419.65f, 250.14f, 335.22f, 354.29f, 335.22f);
        f1386t.cubicTo(458.43f, 335.22f, 542.86f, 419.65f, 542.86f, 523.79f);
        f1386t.transform(f1384m);
        if (clearMode) {
            f1385p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        c.drawPath(f1386t, f1385p);
        c.drawPath(f1386t, ps);
        c.restore();
        m1499r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        f1385p.setColor(Color.argb(255, 0, 0, 0));
        c.restore();
        m1499r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        f1385p.setColor(Color.argb(255, 0, 0, 0));
        c.restore();
        m1499r(new Integer[0]);
        c.restore();
    }

    private static void m1499r(Integer... o) {
        f1385p.reset();
        ps.reset();
        if (cf != null) {
            f1385p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1385p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1385p.setStyle(Style.FILL);
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
