package com.lyrebirdstudio.svg;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;

public class SvgHexagon extends Svg {
    private static final Matrix f1567m = new Matrix();
    private static float od;
    private static final Paint f1568p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1569t = new Path();

    public void drawStroke(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        isStroke = true;
        draw(c, w, h, dx, dy, clearMode);
        isStroke = false;
    }

    public void draw(Canvas c, int w, int h) {
        draw(c, (float) w, (float) h, 0.0f, 0.0f, false);
    }

    public void draw(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        od = w / 512.0f < h / 512.0f ? w / 512.0f : h / 512.0f;
        m1560r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1567m.reset();
        f1567m.setScale(od * 2.77f, od * 2.77f);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.save();
        f1569t.reset();
        f1569t.moveTo(0.0f, 92.38f);
        f1569t.lineTo(46.19f, 12.38f);
        f1569t.lineTo(138.57f, 12.38f);
        f1569t.lineTo(184.75f, 92.38f);
        f1569t.lineTo(138.57f, 172.38f);
        f1569t.lineTo(46.19f, 172.38f);
        f1569t.lineTo(0.0f, 92.38f);
        f1569t.transform(f1567m);
        if (clearMode) {
            f1568p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1569t, ps);
        } else {
            c.drawPath(f1569t, f1568p);
            c.drawPath(f1569t, ps);
        }
        c.restore();
        m1560r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1560r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1560r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1560r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1560r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1560r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1560r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1560r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1560r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1560r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1560r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1560r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1560r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1560r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1560r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1560r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.restore();
        m1560r(new Integer[0]);
        c.restore();
    }

    private static void m1560r(Integer... o) {
        f1568p.reset();
        ps.reset();
        if (cf != null) {
            f1568p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1568p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1568p.setStyle(Style.FILL);
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
