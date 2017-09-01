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

public class SvgApple extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1468m = new Matrix();
    private static float od;
    private static final Paint f1469p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1470t = new Path();

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
        m1527r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1468m.reset();
        f1468m.setScale(od * 10.24f, od * 10.24f);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.translate(0.01f * od, 0.0f);
        c.save();
        c.save();
        c.save();
        f1469p.setColor(Color.parseColor("#000000"));
        f1470t.reset();
        f1470t.moveTo(26.12f, 14.49f);
        f1470t.cubicTo(27.0f, 13.02f, 28.39f, 10.92f, 30.15f, 8.9f);
        f1470t.lineTo(30.15f, 8.9f);
        f1470t.cubicTo(31.64f, 7.19f, 34.55f, 5.0f, 34.55f, 5.0f);
        f1470t.cubicTo(34.99f, 4.66f, 34.94f, 4.2f, 34.44f, 3.97f);
        f1470t.lineTo(30.92f, 2.33f);
        f1470t.cubicTo(30.42f, 2.09f, 29.75f, 2.26f, 29.42f, 2.7f);
        f1470t.cubicTo(29.42f, 2.7f, 26.81f, 6.44f, 23.75f, 14.39f);
        f1470t.cubicTo(14.27f, 10.11f, 5.26f, 16.11f, 5.26f, 26.56f);
        f1470t.cubicTo(5.26f, 37.46f, 13.65f, 54.04f, 25.0f, 49.03f);
        f1470t.cubicTo(36.95f, 54.21f, 44.75f, 37.47f, 44.75f, 26.56f);
        f1470t.cubicTo(44.75f, 16.02f, 36.65f, 9.85f, 26.12f, 14.49f);
        f1470t.transform(f1468m);
        if (clearMode) {
            f1469p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1470t, ps);
        } else {
            c.drawPath(f1470t, f1469p);
            c.drawPath(f1470t, ps);
        }
        c.restore();
        m1527r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1469p.setColor(Color.parseColor("#000000"));
        c.save();
        f1470t.reset();
        f1470t.moveTo(24.0f, 10.96f);
        f1470t.cubicTo(24.55f, 10.91f, 25.03f, 10.42f, 25.07f, 9.88f);
        f1470t.cubicTo(25.07f, 9.88f, 25.43f, 5.61f, 22.45f, 2.64f);
        f1470t.cubicTo(19.47f, -0.34f, 15.21f, 0.01f, 15.21f, 0.01f);
        f1470t.cubicTo(14.66f, 0.06f, 14.18f, 0.54f, 14.14f, 1.09f);
        f1470t.cubicTo(14.14f, 1.09f, 13.78f, 5.36f, 16.75f, 8.34f);
        f1470t.cubicTo(19.73f, 11.31f, 24.0f, 10.96f, 24.0f, 10.96f);
        f1470t.transform(f1468m);
        if (clearMode) {
            f1469p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1470t, ps);
        } else {
            c.drawPath(f1470t, f1469p);
            c.drawPath(f1470t, ps);
        }
        c.restore();
        m1527r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1527r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1469p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1527r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1469p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1527r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1527r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1527r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1527r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1527r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1527r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1527r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1527r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1527r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1527r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1527r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1527r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1527r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1527r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1527r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1527r(new Integer[0]);
        c.restore();
    }

    private static void m1527r(Integer... o) {
        f1469p.reset();
        ps.reset();
        if (cf != null) {
            f1469p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1469p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1469p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1469p.setColor(Color.parseColor("#000000"));
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
