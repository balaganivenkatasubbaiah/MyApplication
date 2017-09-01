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

public class SvgGift extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1537m = new Matrix();
    private static float od;
    private static final Paint f1538p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1539t = new Path();

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
        m1550r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1537m.reset();
        f1537m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(1.2f, 1.2f);
        c.save();
        c.save();
        c.save();
        c.save();
        f1538p.setColor(Color.parseColor("#000000"));
        f1539t.reset();
        f1539t.moveTo(63.58f, 200.27f);
        f1539t.lineTo(363.18f, 200.27f);
        f1539t.quadTo(363.18f, 200.27f, 363.18f, 200.27f);
        f1539t.lineTo(363.18f, 426.76f);
        f1539t.quadTo(363.18f, 426.76f, 363.18f, 426.76f);
        f1539t.lineTo(63.58f, 426.76f);
        f1539t.quadTo(63.58f, 426.76f, 63.58f, 426.76f);
        f1539t.lineTo(63.58f, 200.27f);
        f1539t.quadTo(63.58f, 200.27f, 63.58f, 200.27f);
        f1539t.transform(f1537m);
        if (clearMode) {
            f1538p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1539t, ps);
        } else {
            c.drawPath(f1539t, f1538p);
            c.drawPath(f1539t, ps);
        }
        c.restore();
        m1550r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1538p.setColor(Color.parseColor("#000000"));
        c.save();
        f1539t.reset();
        f1539t.moveTo(332.66f, 93.28f);
        f1539t.cubicTo(332.92f, 93.07f, 333.19f, 92.88f, 333.44f, 92.67f);
        f1539t.cubicTo(342.98f, 84.79f, 353.14f, 69.35f, 347.37f, 40.52f);
        f1539t.cubicTo(341.97f, 13.51f, 327.94f, 4.33f, 317.13f, 1.38f);
        f1539t.cubicTo(298.21f, -3.78f, 274.52f, 5.51f, 244.72f, 29.76f);
        f1539t.cubicTo(231.06f, 40.89f, 219.52f, 52.44f, 213.38f, 58.88f);
        f1539t.cubicTo(207.24f, 52.44f, 195.7f, 40.89f, 182.04f, 29.76f);
        f1539t.cubicTo(152.24f, 5.51f, 128.56f, -3.78f, 109.63f, 1.38f);
        f1539t.cubicTo(98.82f, 4.33f, 84.79f, 13.51f, 79.39f, 40.52f);
        f1539t.cubicTo(73.62f, 69.35f, 83.65f, 84.68f, 93.08f, 92.47f);
        f1539t.cubicTo(93.41f, 92.75f, 93.77f, 93.01f, 94.11f, 93.28f);
        f1539t.lineTo(39.09f, 93.28f);
        f1539t.lineTo(39.09f, 177.27f);
        f1539t.lineTo(195.38f, 177.27f);
        f1539t.lineTo(195.38f, 94.21f);
        f1539t.lineTo(231.38f, 95.78f);
        f1539t.lineTo(231.38f, 177.27f);
        f1539t.lineTo(387.66f, 177.27f);
        f1539t.lineTo(387.66f, 93.28f);
        f1539t.lineTo(332.66f, 93.28f);
        f1539t.moveTo(110.82f, 70.99f);
        f1539t.cubicTo(105.63f, 66.7f, 104.25f, 58.29f, 106.71f, 45.99f);
        f1539t.cubicTo(108.15f, 38.78f, 111.09f, 29.86f, 116.95f, 28.26f);
        f1539t.cubicTo(117.59f, 28.08f, 118.6f, 27.9f, 120.03f, 27.9f);
        f1539t.cubicTo(126.04f, 27.9f, 139.47f, 31.09f, 164.2f, 51.17f);
        f1539t.cubicTo(171.56f, 57.14f, 178.34f, 63.36f, 183.81f, 68.66f);
        f1539t.cubicTo(154.95f, 76.83f, 122.95f, 81.01f, 110.82f, 70.99f);
        f1539t.moveTo(315.7f, 71.19f);
        f1539t.cubicTo(302.94f, 81.73f, 269.58f, 77.26f, 241.75f, 69.82f);
        f1539t.cubicTo(247.43f, 64.27f, 254.65f, 57.59f, 262.56f, 51.17f);
        f1539t.cubicTo(293.18f, 26.31f, 306.47f, 27.35f, 309.81f, 28.26f);
        f1539t.cubicTo(315.67f, 29.86f, 318.62f, 38.78f, 320.06f, 45.99f);
        f1539t.cubicTo(323.76f, 64.53f, 317.7f, 69.54f, 315.7f, 71.19f);
        f1539t.transform(f1537m);
        if (clearMode) {
            f1538p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1539t, ps);
        } else {
            c.drawPath(f1539t, f1538p);
            c.drawPath(f1539t, ps);
        }
        c.restore();
        m1550r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1550r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1538p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1550r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1538p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1550r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1538p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1550r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1550r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1550r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1550r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1550r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1550r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1550r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1550r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1550r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1550r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1550r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1550r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1550r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1550r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1550r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1550r(new Integer[0]);
        c.restore();
    }

    private static void m1550r(Integer... o) {
        f1538p.reset();
        ps.reset();
        if (cf != null) {
            f1538p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1538p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1538p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1538p.setColor(Color.parseColor("#000000"));
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
