package com.lyrebirdstudio.svg;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;

public class SvgPaperCut5 extends Svg {
    private static final Matrix f1597m = new Matrix();
    private static float od;
    private static final Paint f1598p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1599t = new Path();

    public void draw(Canvas c, int w, int h) {
        draw(c, (float) w, (float) h, 0.0f, 0.0f, false);
    }

    public void draw(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        od = w / 509.0f < h / 512.0f ? w / 509.0f : h / 512.0f;
        m1570r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 509.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1597m.reset();
        f1597m.setScale(od, od);
        c.save();
        if (clearMode) {
            f1598p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.translate(0.0f, 0.2f * od);
        c.scale(1.0f, 1.0f);
        c.save();
        f1599t.reset();
        f1599t.moveTo(72.73f, 74.72f);
        f1599t.lineTo(434.39f, 74.72f);
        f1599t.quadTo(434.39f, 74.72f, 434.39f, 74.72f);
        f1599t.lineTo(434.39f, 437.59f);
        f1599t.quadTo(434.39f, 437.59f, 434.39f, 437.59f);
        f1599t.lineTo(72.73f, 437.59f);
        f1599t.quadTo(72.73f, 437.59f, 72.73f, 437.59f);
        f1599t.lineTo(72.73f, 74.72f);
        f1599t.quadTo(72.73f, 74.72f, 72.73f, 74.72f);
        f1599t.transform(f1597m);
        c.drawPath(f1599t, f1598p);
        c.drawPath(f1599t, ps);
        c.restore();
        m1570r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.restore();
        m1570r(new Integer[0]);
        c.restore();
    }

    private static void m1570r(Integer... o) {
        f1598p.reset();
        ps.reset();
        if (cf != null) {
            f1598p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1598p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1598p.setStyle(Style.FILL);
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
