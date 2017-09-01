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

public class SvgBaseball extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1477m = new Matrix();
    private static float od;
    private static final Paint f1478p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1479t = new Path();

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
        m1530r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1477m.reset();
        f1477m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(0.58f, 0.58f);
        c.save();
        c.save();
        c.save();
        f1478p.setColor(Color.parseColor("#000000"));
        f1479t.reset();
        f1479t.moveTo(447.02f, 0.0f);
        f1479t.cubicTo(447.52f, 6.5f, 447.72f, 13.0f, 447.72f, 19.5f);
        f1479t.cubicTo(447.72f, 88.9f, 420.72f, 154.1f, 371.63f, 203.2f);
        f1479t.lineTo(293.52f, 281.3f);
        f1479t.cubicTo(252.92f, 321.9f, 230.62f, 375.8f, 230.62f, 433.2f);
        f1479t.cubicTo(230.62f, 490.6f, 252.92f, 544.5f, 293.52f, 585.1f);
        f1479t.cubicTo(334.13f, 625.7f, 388.02f, 648.0f, 445.43f, 648.0f);
        f1479t.cubicTo(502.82f, 648.0f, 556.73f, 625.7f, 597.32f, 585.1f);
        f1479t.lineTo(675.43f, 507.0f);
        f1479t.cubicTo(724.53f, 457.9f, 789.73f, 430.9f, 859.13f, 430.9f);
        f1479t.cubicTo(865.63f, 430.9f, 872.02f, 431.1f, 878.43f, 431.6f);
        f1479t.cubicTo(876.53f, 321.7f, 833.73f, 212.5f, 749.82f, 128.6f);
        f1479t.cubicTo(666.02f, 44.8f, 556.83f, 2.0f, 447.02f, 0.0f);
        f1479t.transform(f1477m);
        if (clearMode) {
            f1478p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1479t, ps);
        } else {
            c.drawPath(f1479t, f1478p);
            c.drawPath(f1479t, ps);
        }
        c.restore();
        m1530r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1478p.setColor(Color.parseColor("#000000"));
        c.save();
        f1479t.reset();
        f1479t.moveTo(707.23f, 538.8f);
        f1479t.lineTo(629.13f, 616.9f);
        f1479t.cubicTo(580.02f, 666.0f, 514.83f, 693.0f, 445.43f, 693.0f);
        f1479t.cubicTo(376.02f, 693.0f, 310.82f, 666.0f, 261.73f, 616.9f);
        f1479t.cubicTo(212.63f, 567.8f, 185.63f, 502.6f, 185.63f, 433.2f);
        f1479t.cubicTo(185.63f, 363.8f, 212.63f, 298.6f, 261.73f, 249.5f);
        f1479t.lineTo(339.83f, 171.4f);
        f1479t.cubicTo(380.43f, 130.8f, 402.73f, 76.9f, 402.73f, 19.5f);
        f1479t.cubicTo(402.73f, 13.5f, 402.43f, 7.5f, 401.93f, 1.5f);
        f1479t.cubicTo(302.23f, 9.9f, 204.83f, 52.3f, 128.63f, 128.6f);
        f1479t.cubicTo(-42.88f, 300.1f, -42.88f, 578.2f, 128.63f, 749.8f);
        f1479t.cubicTo(300.13f, 921.3f, 578.23f, 921.3f, 749.83f, 749.8f);
        f1479t.cubicTo(826.03f, 673.6f, 868.43f, 576.3f, 876.93f, 476.6f);
        f1479t.cubicTo(871.03f, 476.1f, 865.13f, 475.9f, 859.13f, 475.9f);
        f1479t.cubicTo(801.73f, 475.9f, 747.73f, 498.2f, 707.23f, 538.8f);
        f1479t.transform(f1477m);
        if (clearMode) {
            f1478p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1479t, ps);
        } else {
            c.drawPath(f1479t, f1478p);
            c.drawPath(f1479t, ps);
        }
        c.restore();
        m1530r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1530r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1478p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1530r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1478p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1530r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1530r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1530r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1530r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1530r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1530r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1530r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1530r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1530r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1530r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1530r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1530r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1530r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1530r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1530r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1530r(new Integer[0]);
        c.restore();
    }

    private static void m1530r(Integer... o) {
        f1478p.reset();
        ps.reset();
        if (cf != null) {
            f1478p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1478p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1478p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1478p.setColor(Color.parseColor("#000000"));
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
