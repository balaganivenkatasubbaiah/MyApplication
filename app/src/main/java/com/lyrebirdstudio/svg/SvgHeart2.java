package com.lyrebirdstudio.svg;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;

public class SvgHeart2 extends Svg {
    private static final Matrix f1540m = new Matrix();
    private static float od;
    private static final Paint f1541p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1542t = new Path();

    public void drawStroke(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        isStroke = true;
        draw(c, w, h, dx, dy, clearMode);
        isStroke = false;
    }

    public void draw(Canvas c, int w, int h) {
        draw(c, (float) w, (float) h, 0.0f, 0.0f, false);
    }

    public void draw(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        od = w / 645.0f < h / 585.0f ? w / 645.0f : h / 585.0f;
        m1551r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 645.0f)) / 2.0f) + dx, ((h - (od * 585.0f)) / 2.0f) + dy);
        f1540m.reset();
        f1540m.setScale(od, od);
        c.save();
        if (clearMode) {
            f1541p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.save();
        c.save();
        f1541p.setColor(Color.parseColor("#888888"));
        f1542t.reset();
        f1542t.moveTo(297.3f, 550.87f);
        f1542t.cubicTo(283.52f, 535.43f, 249.13f, 505.34f, 220.86f, 483.99f);
        f1542t.cubicTo(137.12f, 420.75f, 125.72f, 411.6f, 91.72f, 380.29f);
        f1542t.cubicTo(29.03f, 322.57f, 2.41f, 264.58f, 2.5f, 185.95f);
        f1542t.cubicTo(2.55f, 147.57f, 5.17f, 132.78f, 15.91f, 110.15f);
        f1542t.cubicTo(34.15f, 71.77f, 61.01f, 43.24f, 95.36f, 25.8f);
        f1542t.cubicTo(119.69f, 13.44f, 131.68f, 7.95f, 172.3f, 7.73f);
        f1542t.cubicTo(214.8f, 7.49f, 223.74f, 12.45f, 248.74f, 26.18f);
        f1542t.cubicTo(279.16f, 42.9f, 310.48f, 78.62f, 316.95f, 103.99f);
        f1542t.lineTo(320.95f, 119.66f);
        f1542t.lineTo(330.81f, 98.08f);
        f1542t.cubicTo(386.53f, -23.89f, 564.41f, -22.07f, 626.31f, 101.11f);
        f1542t.cubicTo(645.95f, 140.19f, 648.11f, 223.62f, 630.69f, 270.62f);
        f1542t.cubicTo(607.98f, 331.93f, 565.31f, 378.67f, 466.69f, 450.3f);
        f1542t.cubicTo(402.01f, 497.27f, 328.8f, 568.35f, 323.71f, 578.33f);
        f1542t.cubicTo(317.79f, 589.92f, 323.42f, 580.14f, 297.3f, 550.87f);
        f1542t.transform(f1540m);
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1542t, ps);
        } else {
            c.drawPath(f1542t, f1541p);
            c.drawPath(f1542t, ps);
        }
        c.restore();
        m1551r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1541p.setColor(Color.parseColor("#888888"));
        c.save();
        c.translate(129.29f * od, -64.29f * od);
        c.restore();
        m1551r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1551r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1541p.setColor(Color.parseColor("#888888"));
        c.restore();
        m1551r(new Integer[0]);
        c.restore();
    }

    private static void m1551r(Integer... o) {
        f1541p.reset();
        ps.reset();
        if (cf != null) {
            f1541p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1541p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1541p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1541p.setColor(Color.parseColor("#888888"));
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
