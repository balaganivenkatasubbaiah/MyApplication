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

public class SvgFaceRight extends Svg {
    private static final Matrix f1528m = new Matrix();
    private static float od;
    private static final Paint f1529p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1530t = new Path();

    public void draw(Canvas c, int w, int h) {
        draw(c, (float) w, (float) h, 0.0f, 0.0f, false);
    }

    public void draw(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        od = w / 229.0f < h / 512.0f ? w / 229.0f : h / 512.0f;
        m1547r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 229.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1528m.reset();
        f1528m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.translate(0.02f * od, 0.0f);
        c.scale(1.0f, 1.0f);
        c.save();
        c.restore();
        m1547r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.save();
        f1529p.setColor(Color.parseColor("#010101"));
        f1530t.reset();
        f1530t.moveTo(15.96f, 512.3f);
        f1530t.cubicTo(15.96f, 512.3f, 39.5f, 489.79f, 20.06f, 455.69f);
        f1530t.cubicTo(3.69f, 429.09f, 27.56f, 414.76f, 34.04f, 410.67f);
        f1530t.cubicTo(40.52f, 405.9f, 23.47f, 393.28f, 20.06f, 386.46f);
        f1530t.cubicTo(15.28f, 376.91f, 49.05f, 354.06f, 36.77f, 334.62f);
        f1530t.cubicTo(15.96f, 316.54f, 4.31f, 309.11f, 0.96f, 293.69f);
        f1530t.cubicTo(-0.75f, 285.85f, -7.23f, 266.07f, 28.58f, 240.15f);
        f1530t.cubicTo(58.59f, 218.33f, 108.04f, 184.9f, 112.82f, 158.3f);
        f1530t.cubicTo(115.55f, 141.25f, 118.11f, 138.0f, 111.11f, 114.65f);
        f1530t.cubicTo(107.02f, 101.01f, 130.89f, 3.81f, 146.92f, BlurBuilderNormal.BITMAP_SCALE);
        f1530t.cubicTo(148.63f, -0.28f, 229.79f, BlurBuilderNormal.BITMAP_SCALE, 229.79f, BlurBuilderNormal.BITMAP_SCALE);
        f1530t.lineTo(229.79f, 512.38f);
        f1530t.lineTo(15.96f, 512.3f);
        f1530t.transform(f1528m);
        c.drawPath(f1530t, f1529p);
        c.drawPath(f1530t, ps);
        c.restore();
        m1547r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        f1529p.setColor(Color.parseColor("#010101"));
        c.restore();
        m1547r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        f1529p.setColor(Color.parseColor("#010101"));
        c.restore();
        m1547r(new Integer[0]);
        c.restore();
    }

    private static void m1547r(Integer... o) {
        f1529p.reset();
        ps.reset();
        if (cf != null) {
            f1529p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1529p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1529p.setStyle(Style.FILL);
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
