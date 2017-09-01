package com.lyrebirdstudio.svg;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;

public class SvgHex2 extends Svg {
    private static final Matrix f1564m = new Matrix();
    private static float od;
    private static final Paint f1565p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1566t = new Path();

    public void drawStroke(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        isStroke = true;
        draw(c, w, h, dx, dy, clearMode);
        isStroke = false;
    }

    public void draw(Canvas c, int w, int h) {
        draw(c, (float) w, (float) h, 0.0f, 0.0f, false);
    }

    public void draw(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        od = w / 723.0f < h / 625.77f ? w / 723.0f : h / 625.77f;
        m1559r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 723.0f)) / 2.0f) + dx, ((h - (od * 625.77f)) / 2.0f) + dy);
        f1564m.reset();
        f1564m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.save();
        f1565p.setColor(Color.parseColor("#FFFFFF"));
        ps.setColor(Color.parseColor("#000000"));
        ps.setStrokeWidth(4.0f * od);
        f1566t.reset();
        f1566t.moveTo(723.0f, 314.0f);
        f1566t.lineTo(543.0f, 625.77f);
        f1566t.lineTo(183.0f, 625.77f);
        f1566t.lineTo(0.0f, 314.0f);
        f1566t.lineTo(183.0f, 0.0f);
        f1566t.lineTo(543.0f, 0.0f);
        f1566t.lineTo(723.0f, 314.0f);
        f1566t.lineTo(723.0f, 314.0f);
        f1566t.transform(f1564m);
        if (clearMode) {
            f1565p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1566t, ps);
        } else {
            c.drawPath(f1566t, f1565p);
            c.drawPath(f1566t, ps);
        }
        c.restore();
        m1559r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        f1565p.setColor(Color.parseColor("#FFFFFF"));
        ps.setColor(Color.parseColor("#000000"));
        ps.setStrokeWidth(4.0f * od);
        c.restore();
        m1559r(new Integer[0]);
        c.restore();
    }

    private static void m1559r(Integer... o) {
        f1565p.reset();
        ps.reset();
        if (cf != null) {
            f1565p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1565p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1565p.setStyle(Style.FILL);
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
