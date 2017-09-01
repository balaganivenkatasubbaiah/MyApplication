package com.lyrebirdstudio.svg;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;

public class SvgWave4 extends Svg {
    private static final Matrix f1666m = new Matrix();
    private static float od;
    private static final Paint f1667p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1668t = new Path();

    public void draw(Canvas c, int w, int h) {
        draw(c, (float) w, (float) h, 0.0f, 0.0f, false);
    }

    public void draw(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        od = w / 506.0f < h / 512.0f ? w / 506.0f : h / 512.0f;
        m1593r(new Integer[0]);
        c.save();
        c.translate((((w - (od * 506.0f)) / 2.0f) + dx) - 9.0f, (((h - (od * 512.0f)) / 2.0f) + dy) - 7.0f);
        f1666m.reset();
        f1666m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.translate(0.0f, 0.34f * od);
        c.scale(1.0f, 1.0f);
        c.save();
        f1667p.setColor(Color.parseColor("#010101"));
        f1668t.reset();
        f1668t.moveTo(0.0f, 452.62f);
        f1668t.cubicTo(0.0f, 452.62f, 334.03f, 325.88f, 334.94f, 477.06f);
        f1668t.cubicTo(341.27f, 531.37f, 432.25f, 518.7f, 463.93f, 467.1f);
        f1668t.cubicTo(453.07f, 458.87f, 381.22f, 398.41f, 427.27f, 358.47f);
        f1668t.cubicTo(439.96f, 349.21f, 458.28f, 343.2f, 470.74f, 339.26f);
        f1668t.cubicTo(494.26f, 329.28f, 508.86f, 306.76f, 506.48f, 261.73f);
        f1668t.cubicTo(505.79f, 249.26f, 504.56f, 238.53f, 503.31f, 225.06f);
        f1668t.cubicTo(501.39f, 185.46f, 496.32f, 148.75f, 491.26f, 120.42f);
        f1668t.cubicTo(486.21f, 88.53f, 481.03f, 63.97f, 476.95f, 45.63f);
        f1668t.cubicTo(471.49f, 21.61f, 467.02f, 8.29f, 465.09f, 4.21f);
        f1668t.cubicTo(463.74f, 1.35f, 462.88f, 0.0f, 462.88f, 0.0f);
        f1668t.lineTo(0.0f, 0.0f);
        f1668t.lineTo(0.0f, 452.62f);
        f1668t.transform(f1666m);
        c.drawPath(f1668t, f1667p);
        c.drawPath(f1668t, ps);
        c.restore();
        m1593r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        f1667p.setColor(Color.parseColor("#010101"));
        c.restore();
        m1593r(new Integer[0]);
        c.restore();
    }

    private static void m1593r(Integer... o) {
        f1667p.reset();
        ps.reset();
        if (cf != null) {
            f1667p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1667p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1667p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    ps.setStrokeJoin(Join.MITER);
                    break;
                case 1:
                    ps.setStrokeMiter(4.0f * od);
                    break;
                case 2:
                    ps.setStrokeCap(Cap.BUTT);
                    break;
                case 3:
                    ps.setColor(Color.argb(0, 0, 0, 0));
                    break;
                default:
                    break;
            }
        }
    }
}
