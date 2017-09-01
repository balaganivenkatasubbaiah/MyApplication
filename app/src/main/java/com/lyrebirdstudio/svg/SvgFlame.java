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

public class SvgFlame extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1531m = new Matrix();
    private static float od;
    private static final Paint f1532p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1533t = new Path();

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
        m1548r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1531m.reset();
        f1531m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(2.08f, 2.08f);
        c.save();
        c.save();
        f1532p.setColor(Color.parseColor("#000000"));
        f1533t.reset();
        f1533t.moveTo(208.25f, 121.2f);
        f1533t.cubicTo(213.82f, 154.21f, 199.87f, 160.86f, 199.87f, 160.86f);
        f1533t.cubicTo(199.87f, 160.86f, 212.51f, 134.05f, 195.64f, 107.89f);
        f1533t.cubicTo(188.95f, 97.55f, 184.87f, 82.28f, 186.72f, 76.36f);
        f1533t.cubicTo(178.56f, 82.76f, 175.27f, 100.38f, 175.27f, 100.38f);
        f1533t.cubicTo(175.27f, 100.38f, 166.32f, 82.28f, 167.8f, 58.13f);
        f1533t.lineTo(146.18f, 92.42f);
        f1533t.cubicTo(146.18f, 92.42f, 146.9f, 65.34f, 136.07f, 53.39f);
        f1533t.cubicTo(125.23f, 41.45f, 105.6f, 31.07f, 125.23f, 0.0f);
        f1533t.cubicTo(125.23f, 0.0f, 74.75f, 29.23f, 95.82f, 81.88f);
        f1533t.cubicTo(112.55f, 123.7f, 71.79f, 92.42f, 86.69f, 56.56f);
        f1533t.cubicTo(86.69f, 56.56f, 58.31f, 64.54f, 68.43f, 109.96f);
        f1533t.cubicTo(68.43f, 109.96f, 51.59f, 105.15f, 52.91f, 85.25f);
        f1533t.cubicTo(52.91f, 85.25f, 39.37f, 115.53f, 53.59f, 146.61f);
        f1533t.cubicTo(53.59f, 146.61f, 37.9f, 145.84f, 40.12f, 118.73f);
        f1533t.cubicTo(9.44f, 163.55f, 29.07f, 246.0f, 121.23f, 246.0f);
        f1533t.cubicTo(204.43f, 246.0f, 239.01f, 183.81f, 208.25f, 121.2f);
        f1533t.transform(f1531m);
        if (clearMode) {
            f1532p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1533t, ps);
        } else {
            c.drawPath(f1533t, f1532p);
            c.drawPath(f1533t, ps);
        }
        c.restore();
        m1548r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1532p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1548r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1532p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1548r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1548r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1548r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1548r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1548r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1548r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1548r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1548r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1548r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1548r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1548r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1548r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1548r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1548r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1548r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1548r(new Integer[0]);
        c.restore();
    }

    private static void m1548r(Integer... o) {
        f1532p.reset();
        ps.reset();
        if (cf != null) {
            f1532p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1532p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1532p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1532p.setColor(Color.parseColor("#000000"));
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
