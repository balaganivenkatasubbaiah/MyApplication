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
public class SvgCross extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1693m = new Matrix();
    private static float od;
    private static final Paint f1694p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1695t = new Path();

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
        m1602r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1693m.reset();
        f1693m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(1.09f, 1.09f);
        c.save();
        c.save();
        f1694p.setColor(Color.parseColor("#000000"));
        f1695t.reset();
        f1695t.moveTo(290.52f, 0.0f);
        f1695t.lineTo(260.52f, 0.0f);
        f1695t.lineTo(207.94f, 0.0f);
        f1695t.lineTo(177.94f, 0.0f);
        f1695t.lineTo(177.94f, 30.0f);
        f1695t.lineTo(177.94f, 99.02f);
        f1695t.lineTo(77.14f, 99.02f);
        f1695t.lineTo(47.14f, 99.02f);
        f1695t.lineTo(47.14f, 129.02f);
        f1695t.lineTo(47.14f, 181.6f);
        f1695t.lineTo(47.14f, 211.6f);
        f1695t.lineTo(77.14f, 211.6f);
        f1695t.lineTo(177.94f, 211.6f);
        f1695t.lineTo(177.94f, 438.45f);
        f1695t.lineTo(177.94f, 468.45f);
        f1695t.lineTo(207.94f, 468.45f);
        f1695t.lineTo(260.52f, 468.45f);
        f1695t.lineTo(290.52f, 468.45f);
        f1695t.lineTo(290.52f, 438.45f);
        f1695t.lineTo(290.52f, 211.6f);
        f1695t.lineTo(391.31f, 211.6f);
        f1695t.lineTo(421.31f, 211.6f);
        f1695t.lineTo(421.31f, 181.6f);
        f1695t.lineTo(421.31f, 129.02f);
        f1695t.lineTo(421.31f, 99.02f);
        f1695t.lineTo(391.31f, 99.02f);
        f1695t.lineTo(290.52f, 99.02f);
        f1695t.lineTo(290.52f, 30.0f);
        f1695t.lineTo(290.52f, 0.0f);
        f1695t.lineTo(290.52f, 0.0f);
        f1695t.transform(f1693m);
        if (clearMode) {
            f1694p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1695t, ps);
        } else {
            c.drawPath(f1695t, f1694p);
            c.drawPath(f1695t, ps);
        }
        c.restore();
        m1602r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1694p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1602r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1694p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1602r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1602r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1602r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1602r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1602r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1602r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1602r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1602r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1602r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1602r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1602r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1602r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1602r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1602r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1602r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1602r(new Integer[0]);
        c.restore();
    }

    private static void m1602r(Integer... o) {
        f1694p.reset();
        ps.reset();
        if (cf != null) {
            f1694p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1694p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1694p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1694p.setColor(Color.parseColor("#000000"));
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
