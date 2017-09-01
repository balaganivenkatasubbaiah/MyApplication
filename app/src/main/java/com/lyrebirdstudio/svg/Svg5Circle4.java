package com.lyrebirdstudio.svg;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;

public class Svg5Circle4 extends Svg {
    private static final Matrix f1462m = new Matrix();
    private static float od;
    private static final Paint f1463p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1464t = new Path();

    public void draw(Canvas c, int w, int h) {
        draw(c, (float) w, (float) h, 0.0f, 0.0f, false);
    }

    public void draw(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        od = w / 508.0f < h / 513.0f ? w / 508.0f : h / 513.0f;
        m1525r(new Integer[0]);
        c.save();
        c.translate((((w - (od * 508.0f)) / 2.0f) + dx) - 4.0f, (((h - (od * 513.0f)) / 2.0f) + dy) - 1.0f);
        f1462m.reset();
        f1462m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.translate(0.0f, 0.33f * od);
        c.scale(1.0f, 1.0f);
        c.save();
        f1464t.reset();
        f1464t.moveTo(0.0f, 0.0f);
        f1464t.lineTo(508.9f, 0.0f);
        f1464t.cubicTo(508.9f, 0.0f, 433.43f, 102.55f, 446.98f, 185.27f);
        f1464t.cubicTo(403.92f, 175.6f, 384.57f, 306.21f, 322.17f, 332.81f);
        f1464t.cubicTo(255.42f, 379.25f, 166.41f, 448.91f, 168.34f, 449.4f);
        f1464t.cubicTo(128.77f, 443.95f, 31.44f, 475.03f, 0.97f, 513.25f);
        f1464t.lineTo(0.0f, 0.0f);
        f1464t.transform(f1462m);
        c.drawPath(f1464t, f1463p);
        c.drawPath(f1464t, ps);
        c.restore();
        m1525r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.restore();
        m1525r(new Integer[0]);
        c.restore();
    }

    private static void m1525r(Integer... o) {
        f1463p.reset();
        ps.reset();
        if (cf != null) {
            f1463p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1463p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1463p.setStyle(Style.FILL);
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
