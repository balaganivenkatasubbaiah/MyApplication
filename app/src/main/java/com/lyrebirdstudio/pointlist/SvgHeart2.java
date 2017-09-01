package com.lyrebirdstudio.pointlist;

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

public class SvgHeart2 extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1399m = new Matrix();
    private static float od;
    private static final Paint f1400p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1401t = new Path();

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
        od = w / 645.0f < h / 585.0f ? w / 645.0f : h / 585.0f;
        m1504r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 645.0f)) / 2.0f) + dx, ((h - (od * 585.0f)) / 2.0f) + dy);
        f1399m.reset();
        f1399m.setScale(od, od);
        c.save();
        if (clearMode) {
            f1400p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.save();
        c.save();
        f1400p.setColor(Color.parseColor("#ff0000"));
        f1401t.reset();
        f1401t.moveTo(297.3f, 550.87f);
        f1401t.cubicTo(283.52f, 535.43f, 249.13f, 505.34f, 220.86f, 483.99f);
        f1401t.cubicTo(137.12f, 420.75f, 125.72f, 411.6f, 91.72f, 380.29f);
        f1401t.cubicTo(29.03f, 322.57f, 2.41f, 264.58f, 2.5f, 185.95f);
        f1401t.cubicTo(2.55f, 147.57f, 5.17f, 132.78f, 15.91f, 110.15f);
        f1401t.cubicTo(34.15f, 71.77f, 61.01f, 43.24f, 95.36f, 25.8f);
        f1401t.cubicTo(119.69f, 13.44f, 131.68f, 7.95f, 172.3f, 7.73f);
        f1401t.cubicTo(214.8f, 7.49f, 223.74f, 12.45f, 248.74f, 26.18f);
        f1401t.cubicTo(279.16f, 42.9f, 310.48f, 78.62f, 316.95f, 103.99f);
        f1401t.lineTo(320.95f, 119.66f);
        f1401t.lineTo(330.81f, 98.08f);
        f1401t.cubicTo(386.53f, -23.89f, 564.41f, -22.07f, 626.31f, 101.11f);
        f1401t.cubicTo(645.95f, 140.19f, 648.11f, 223.62f, 630.69f, 270.62f);
        f1401t.cubicTo(607.98f, 331.93f, 565.31f, 378.67f, 466.69f, 450.3f);
        f1401t.cubicTo(402.01f, 497.27f, 328.8f, 568.35f, 323.71f, 578.33f);
        f1401t.cubicTo(317.79f, 589.92f, 323.42f, 580.14f, 297.3f, 550.87f);
        f1401t.transform(f1399m);
        c.drawPath(f1401t, f1400p);
        c.drawPath(f1401t, ps);
        c.restore();
        m1504r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1400p.setColor(Color.parseColor("#ff0000"));
        c.save();
        c.translate(129.29f * od, -64.29f * od);
        c.restore();
        m1504r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1504r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1400p.setColor(Color.parseColor("#ff0000"));
        c.restore();
        m1504r(new Integer[0]);
        c.restore();
    }

    private static void m1504r(Integer... o) {
        f1400p.reset();
        ps.reset();
        if (cf != null) {
            f1400p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1400p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1400p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1400p.setColor(Color.parseColor("#ff0000"));
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
