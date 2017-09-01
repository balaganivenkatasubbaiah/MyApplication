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
public class SvgFilm extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1696m = new Matrix();
    private static float od;
    private static final Paint f1697p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1698t = new Path();

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
        m1603r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1696m.reset();
        f1696m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(1.06f, 1.06f);
        c.save();
        c.save();
        f1697p.setColor(Color.parseColor("#000000"));
        f1698t.reset();
        f1698t.moveTo(454.89f, 60.65f);
        f1698t.lineTo(454.89f, 90.98f);
        f1698t.lineTo(394.24f, 90.98f);
        f1698t.lineTo(394.24f, 60.65f);
        f1698t.lineTo(90.98f, 60.65f);
        f1698t.lineTo(90.98f, 90.98f);
        f1698t.lineTo(30.33f, 90.98f);
        f1698t.lineTo(30.33f, 60.65f);
        f1698t.lineTo(0.0f, 60.65f);
        f1698t.lineTo(0.0f, 424.56f);
        f1698t.lineTo(30.33f, 424.56f);
        f1698t.lineTo(30.33f, 394.24f);
        f1698t.lineTo(90.98f, 394.24f);
        f1698t.lineTo(90.98f, 424.56f);
        f1698t.lineTo(394.24f, 424.56f);
        f1698t.lineTo(394.24f, 394.24f);
        f1698t.lineTo(454.89f, 394.24f);
        f1698t.lineTo(454.89f, 424.56f);
        f1698t.lineTo(485.21f, 424.56f);
        f1698t.lineTo(485.21f, 60.65f);
        f1698t.lineTo(454.89f, 60.65f);
        f1698t.moveTo(90.98f, 333.58f);
        f1698t.lineTo(30.33f, 333.58f);
        f1698t.lineTo(30.33f, 272.93f);
        f1698t.lineTo(90.98f, 272.93f);
        f1698t.lineTo(90.98f, 333.58f);
        f1698t.moveTo(90.98f, 212.28f);
        f1698t.lineTo(30.33f, 212.28f);
        f1698t.lineTo(30.33f, 151.63f);
        f1698t.lineTo(90.98f, 151.63f);
        f1698t.lineTo(90.98f, 212.28f);
        f1698t.moveTo(454.89f, 333.58f);
        f1698t.lineTo(394.24f, 333.58f);
        f1698t.lineTo(394.24f, 272.93f);
        f1698t.lineTo(454.89f, 272.93f);
        f1698t.lineTo(454.89f, 333.58f);
        f1698t.moveTo(454.89f, 212.28f);
        f1698t.lineTo(394.24f, 212.28f);
        f1698t.lineTo(394.24f, 151.63f);
        f1698t.lineTo(454.89f, 151.63f);
        f1698t.lineTo(454.89f, 212.28f);
        f1698t.transform(f1696m);
        if (clearMode) {
            f1697p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1698t, ps);
        } else {
            c.drawPath(f1698t, f1697p);
            c.drawPath(f1698t, ps);
        }
        c.restore();
        m1603r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1697p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1603r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1697p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1603r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1603r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1603r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1603r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1603r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1603r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1603r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1603r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1603r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1603r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1603r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1603r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1603r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1603r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1603r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1603r(new Integer[0]);
        c.restore();
    }

    private static void m1603r(Integer... o) {
        f1697p.reset();
        ps.reset();
        if (cf != null) {
            f1697p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1697p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1697p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1697p.setColor(Color.parseColor("#000000"));
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
