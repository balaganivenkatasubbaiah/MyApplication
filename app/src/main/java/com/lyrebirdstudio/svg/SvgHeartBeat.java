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

public class SvgHeartBeat extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1546m = new Matrix();
    private static float od;
    private static final Paint f1547p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1548t = new Path();

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
        m1553r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1546m.reset();
        f1546m.setScale(od * 10.0f, od * 10.0f);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.save();
        c.save();
        c.save();
        f1547p.setColor(Color.parseColor("#000000"));
        f1548t.reset();
        f1548t.moveTo(29.28f, 33.33f);
        f1548t.lineTo(26.1f, 41.61f);
        f1548t.cubicTo(25.93f, 42.05f, 25.51f, 42.34f, 25.04f, 42.35f);
        f1548t.cubicTo(25.03f, 42.35f, 25.03f, 42.35f, 25.03f, 42.35f);
        f1548t.cubicTo(24.56f, 42.35f, 24.13f, 42.06f, 23.96f, 41.62f);
        f1548t.lineTo(15.31f, 20.18f);
        f1548t.lineTo(12.21f, 26.55f);
        f1548t.cubicTo(12.02f, 26.95f, 11.62f, 27.2f, 11.17f, 27.2f);
        f1548t.lineTo(3.73f, 27.2f);
        f1548t.cubicTo(3.82f, 27.34f, 3.89f, 27.48f, 3.97f, 27.63f);
        f1548t.lineTo(5.98f, 30.53f);
        f1548t.cubicTo(6.48f, 31.17f, 7.02f, 31.81f, 7.61f, 32.45f);
        f1548t.cubicTo(14.33f, 39.7f, 18.96f, 45.06f, 21.82f, 48.51f);
        f1548t.cubicTo(23.88f, 51.0f, 27.13f, 51.03f, 29.2f, 48.55f);
        f1548t.cubicTo(31.94f, 45.24f, 36.3f, 40.14f, 42.54f, 33.33f);
        f1548t.lineTo(29.28f, 33.33f);
        f1548t.lineTo(29.28f, 33.33f);
        f1548t.transform(f1546m);
        if (clearMode) {
            f1547p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1548t, ps);
        } else {
            c.drawPath(f1548t, f1547p);
            c.drawPath(f1548t, ps);
        }
        c.restore();
        m1553r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1547p.setColor(Color.parseColor("#000000"));
        c.save();
        f1548t.reset();
        f1548t.moveTo(37.81f, 0.83f);
        f1548t.cubicTo(34.34f, 0.84f, 31.17f, 2.18f, 28.79f, 4.35f);
        f1548t.cubicTo(26.41f, 6.55f, 24.51f, 6.55f, 22.12f, 4.37f);
        f1548t.cubicTo(19.73f, 2.19f, 16.57f, 0.87f, 13.09f, 0.88f);
        f1548t.cubicTo(7.72f, 0.89f, 3.1f, 4.05f, 0.98f, 8.61f);
        f1548t.cubicTo(-0.38f, 11.54f, -0.18f, 16.93f, 0.69f, 20.05f);
        f1548t.cubicTo(1.11f, 21.54f, 1.73f, 23.24f, 2.58f, 25.02f);
        f1548t.cubicTo(2.73f, 24.94f, 2.9f, 24.89f, 3.08f, 24.89f);
        f1548t.lineTo(10.46f, 24.89f);
        f1548t.lineTo(14.37f, 16.83f);
        f1548t.cubicTo(14.57f, 16.42f, 15.05f, 16.16f, 15.45f, 16.19f);
        f1548t.cubicTo(15.91f, 16.2f, 16.31f, 16.48f, 16.48f, 16.91f);
        f1548t.lineTo(25.0f, 38.04f);
        f1548t.lineTo(27.41f, 31.76f);
        f1548t.cubicTo(27.59f, 31.32f, 28.02f, 31.02f, 28.49f, 31.02f);
        f1548t.lineTo(43.4f, 31.02f);
        f1548t.cubicTo(43.71f, 31.02f, 43.99f, 31.15f, 44.2f, 31.35f);
        f1548t.cubicTo(44.55f, 30.87f, 44.97f, 30.28f, 45.39f, 29.7f);
        f1548t.cubicTo(46.47f, 28.2f, 48.71f, 24.71f, 49.76f, 21.65f);
        f1548t.cubicTo(51.22f, 17.36f, 51.22f, 14.19f, 51.22f, 14.19f);
        f1548t.cubicTo(51.21f, 6.79f, 45.2f, 0.81f, 37.81f, 0.83f);
        f1548t.transform(f1546m);
        if (clearMode) {
            f1547p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1548t, ps);
        } else {
            c.drawPath(f1548t, f1547p);
            c.drawPath(f1548t, ps);
        }
        c.restore();
        m1553r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1553r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1547p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1553r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1547p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1553r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1553r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1553r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1553r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1553r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1553r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1553r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1553r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1553r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1553r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1553r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1553r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1553r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1553r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1553r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1553r(new Integer[0]);
        c.restore();
    }

    private static void m1553r(Integer... o) {
        f1547p.reset();
        ps.reset();
        if (cf != null) {
            f1547p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1547p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1547p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1547p.setColor(Color.parseColor("#000000"));
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
