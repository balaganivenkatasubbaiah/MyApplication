package com.lyrebirdstudio.svg;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;

public class SvgCircle2 extends Svg {
    private static final Matrix f1504m = new Matrix();
    private static float od;
    private static final Paint f1505p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1506t = new Path();

    public void drawStroke(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        isStroke = true;
        draw(c, w, h, dx, dy, clearMode);
        isStroke = false;
    }

    public void draw(Canvas c, int w, int h) {
        draw(c, (float) w, (float) h, 0.0f, 0.0f, false);
    }

    public void draw(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        od = w / 386.0f < h / 377.0f ? w / 386.0f : h / 377.0f;
        m1539r(new Integer[0]);
        c.save();
        c.translate((((w - (od * 386.0f)) / 2.0f) + dx) + 16.0f, ((h - (od * 377.0f)) / 2.0f) + dy);
        f1504m.reset();
        f1504m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.save();
        f1505p.setColor(Color.parseColor("#FFFFFF"));
        c.restore();
        m1539r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1539r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.translate(-197.14f * od, -338.08f * od);
        c.save();
        f1505p.setColor(Color.argb(255, 0, 0, 0));
        c.translate(31.43f * od, 2.86f * od);
        f1506t.reset();
        f1506t.moveTo(542.86f, 523.79f);
        f1506t.cubicTo(542.86f, 627.94f, 458.43f, 712.36f, 354.29f, 712.36f);
        f1506t.cubicTo(250.14f, 712.36f, 165.71f, 627.94f, 165.71f, 523.79f);
        f1506t.cubicTo(165.71f, 419.65f, 250.14f, 335.22f, 354.29f, 335.22f);
        f1506t.cubicTo(458.43f, 335.22f, 542.86f, 419.65f, 542.86f, 523.79f);
        f1506t.transform(f1504m);
        if (clearMode) {
            f1505p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1506t, ps);
        } else {
            c.drawPath(f1506t, f1505p);
            c.drawPath(f1506t, ps);
        }
        c.restore();
        m1539r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        f1505p.setColor(Color.argb(255, 0, 0, 0));
        c.restore();
        m1539r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        f1505p.setColor(Color.argb(255, 0, 0, 0));
        c.restore();
        m1539r(new Integer[0]);
        c.restore();
    }

    private static void m1539r(Integer... o) {
        f1505p.reset();
        ps.reset();
        if (cf != null) {
            f1505p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1505p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1505p.setStyle(Style.FILL);
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
