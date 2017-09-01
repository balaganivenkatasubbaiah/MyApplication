package com.lyrebirdstudio.svg;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;

import com.lyrebirdstudio.lyrebirdlibrary.BlurBuilderNormal;

public class SvgFaceLeft extends Svg {
    private static final Matrix f1522m = new Matrix();
    private static float od;
    private static final Paint f1523p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1524t = new Path();

    public void draw(Canvas c, int w, int h) {
        draw(c, (float) w, (float) h, 0.0f, 0.0f, false);
    }

    public void draw(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        od = w / 225.0f < h / 512.0f ? w / 225.0f : h / 512.0f;
        m1545r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 225.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1522m.reset();
        f1522m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.translate(0.02f * od, 0.0f);
        c.scale(1.0f, 1.0f);
        c.save();
        c.restore();
        m1545r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.save();
        f1524t.reset();
        f1524t.moveTo(177.0f, BlurBuilderNormal.BITMAP_SCALE);
        f1524t.cubicTo(177.0f, BlurBuilderNormal.BITMAP_SCALE, 159.88f, 29.33f, 180.21f, 67.84f);
        f1524t.cubicTo(197.32f, 112.06f, 266.15f, 237.6f, 190.9f, 246.51f);
        f1524t.cubicTo(125.64f, 248.65f, 139.01f, 264.97f, 140.26f, 286.1f);
        f1524t.cubicTo(141.16f, 333.44f, 104.24f, 326.75f, 94.62f, 324.61f);
        f1524t.cubicTo(139.55f, 371.69f, 97.83f, 385.59f, 79.64f, 386.67f);
        f1524t.cubicTo(64.3f, 416.62f, 72.15f, 430.17f, 70.01f, 457.19f);
        f1524t.cubicTo(66.8f, 483.4f, 36.49f, 524.32f, -0.6f, 509.7f);
        f1524t.cubicTo(-0.6f, 510.77f, -0.6f, 0.44f, -0.6f, 0.44f);
        f1524t.lineTo(177.0f, BlurBuilderNormal.BITMAP_SCALE);
        f1524t.transform(f1522m);
        c.drawPath(f1524t, f1523p);
        c.drawPath(f1524t, ps);
        c.restore();
        m1545r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.restore();
        m1545r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.restore();
        m1545r(new Integer[0]);
        c.restore();
    }

    private static void m1545r(Integer... o) {
        f1523p.reset();
        ps.reset();
        if (cf != null) {
            f1523p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1523p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1523p.setStyle(Style.FILL);
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
