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

public class SvgMan extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1570m = new Matrix();
    private static float od;
    private static final Paint f1571p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1572t = new Path();

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
        m1561r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1570m.reset();
        f1570m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(1.33f, 1.33f);
        c.save();
        c.save();
        f1571p.setColor(Color.parseColor("#000000"));
        f1572t.reset();
        f1572t.moveTo(304.73f, 335.24f);
        f1572t.cubicTo(304.73f, 335.24f, 287.41f, 302.0f, 281.21f, 274.95f);
        f1572t.cubicTo(273.48f, 236.48f, 338.18f, 183.55f, 301.79f, 141.51f);
        f1572t.cubicTo(295.79f, 136.25f, 313.93f, 107.23f, 309.52f, 99.62f);
        f1572t.cubicTo(306.58f, 108.07f, 296.66f, 121.66f, 296.66f, 121.66f);
        f1572t.cubicTo(296.66f, 121.66f, 296.2f, 80.77f, 288.12f, 71.77f);
        f1572t.cubicTo(290.14f, 87.85f, 288.94f, 104.39f, 288.94f, 104.39f);
        f1572t.cubicTo(288.94f, 104.39f, 276.63f, 69.2f, 264.31f, 63.96f);
        f1572t.cubicTo(277.06f, 76.4f, 276.44f, 95.58f, 276.44f, 95.58f);
        f1572t.cubicTo(276.44f, 95.58f, 255.86f, 56.25f, 227.18f, 56.98f);
        f1572t.cubicTo(248.11f, 68.37f, 253.26f, 84.55f, 253.26f, 84.55f);
        f1572t.cubicTo(253.26f, 84.55f, 117.64f, 66.17f, 142.26f, 13.97f);
        f1572t.cubicTo(123.15f, 18.75f, 123.15f, 71.31f, 123.15f, 71.31f);
        f1572t.cubicTo(123.15f, 71.31f, 104.39f, 39.7f, 135.64f, 0.0f);
        f1572t.cubicTo(70.58f, 40.8f, 95.57f, 113.96f, 95.57f, 113.96f);
        f1572t.cubicTo(95.57f, 113.96f, 81.6f, 112.85f, 74.24f, 61.39f);
        f1572t.cubicTo(59.92f, 124.62f, 99.98f, 157.69f, 99.98f, 157.69f);
        f1572t.cubicTo(99.98f, 157.69f, 84.17f, 185.63f, 93.0f, 198.86f);
        f1572t.cubicTo(101.83f, 212.08f, 81.23f, 241.88f, 81.6f, 251.43f);
        f1572t.cubicTo(81.97f, 260.98f, 97.05f, 259.89f, 97.05f, 259.89f);
        f1572t.cubicTo(97.05f, 259.89f, 91.15f, 275.7f, 104.03f, 277.53f);
        f1572t.cubicTo(101.09f, 278.63f, 95.95f, 288.93f, 110.65f, 294.81f);
        f1572t.cubicTo(106.24f, 295.91f, 97.42f, 347.37f, 160.64f, 315.03f);
        f1572t.cubicTo(184.16f, 327.15f, 197.03f, 384.13f, 197.03f, 384.13f);
        f1572t.lineTo(304.73f, 335.24f);
        f1572t.transform(f1570m);
        if (clearMode) {
            f1571p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1572t, ps);
        } else {
            c.drawPath(f1572t, f1571p);
            c.drawPath(f1572t, ps);
        }
        c.restore();
        m1561r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1571p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1561r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1571p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1561r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1561r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1561r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1561r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1561r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1561r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1561r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1561r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1561r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1561r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1561r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1561r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1561r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1561r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1561r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1561r(new Integer[0]);
        c.restore();
    }

    private static void m1561r(Integer... o) {
        f1571p.reset();
        ps.reset();
        if (cf != null) {
            f1571p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1571p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1571p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1571p.setColor(Color.parseColor("#000000"));
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
