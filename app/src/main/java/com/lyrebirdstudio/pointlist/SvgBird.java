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

public class SvgBird extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1378m = new Matrix();
    private static float od;
    private static final Paint f1379p = new Paint();
    private static final Path path = new Path();
    private static final Paint ps = new Paint();
    private static final Path f1380t = new Path();

    public SvgBird() {
        f1380t.reset();
        f1380t.moveTo(612.0f, 116.26f);
        f1380t.cubicTo(589.48f, 126.24f, 565.31f, 133.01f, 539.91f, 136.03f);
        f1380t.cubicTo(565.84f, 120.5f, 585.69f, 95.88f, 595.1f, 66.62f);
        f1380t.cubicTo(570.77f, 81.0f, 543.93f, 91.44f, 515.32f, 97.1f);
        f1380t.cubicTo(492.41f, 72.66f, 459.83f, 57.44f, 423.69f, 57.44f);
        f1380t.cubicTo(354.36f, 57.44f, 298.14f, 113.66f, 298.14f, 182.95f);
        f1380t.cubicTo(298.14f, 192.78f, 299.25f, 202.38f, 301.39f, 211.56f);
        f1380t.cubicTo(197.06f, 206.32f, 104.56f, 156.34f, 42.64f, 80.39f);
        f1380t.cubicTo(31.82f, 98.9f, 25.66f, 120.46f, 25.66f, 143.49f);
        f1380t.cubicTo(25.66f, 187.05f, 47.84f, 225.48f, 81.5f, 247.97f);
        f1380t.cubicTo(60.92f, 247.28f, 41.57f, 241.62f, 24.63f, 232.21f);
        f1380t.lineTo(24.63f, 233.78f);
        f1380t.cubicTo(24.63f, 294.58f, 67.92f, 345.33f, 125.32f, 356.88f);
        f1380t.cubicTo(114.81f, 359.71f, 103.72f, 361.28f, 92.24f, 361.28f);
        f1380t.cubicTo(84.14f, 361.28f, 76.3f, 360.48f, 68.61f, 358.95f);
        f1380t.cubicTo(84.59f, 408.85f, 130.94f, 445.15f, 185.86f, 446.14f);
        f1380t.cubicTo(142.91f, 479.8f, 88.76f, 499.8f, 29.94f, 499.8f);
        f1380t.cubicTo(19.81f, 499.8f, 9.83f, 499.18f, 0.0f, 498.08f);
        f1380t.cubicTo(55.57f, 533.76f, 121.54f, 554.56f, 192.44f, 554.56f);
        f1380t.cubicTo(423.39f, 554.56f, 549.63f, 363.27f, 549.63f, 197.37f);
        f1380t.lineTo(549.21f, 181.12f);
        f1380t.cubicTo(573.87f, 163.53f, 595.21f, 141.42f, 612.0f, 116.26f);
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
        m1497r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1378m.reset();
        f1378m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(0.84f, 0.84f);
        c.save();
        c.save();
        c.save();
        f1379p.setColor(Color.parseColor("#010002"));
        f1380t.transform(f1378m, path);
        if (clearMode) {
            f1379p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        c.drawPath(path, f1379p);
        c.drawPath(path, ps);
        c.restore();
        m1497r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1));
        f1379p.setColor(Color.parseColor("#010002"));
        c.restore();
        m1497r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1));
        f1379p.setColor(Color.parseColor("#010002"));
        c.restore();
        m1497r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1));
        f1379p.setColor(Color.parseColor("#010002"));
        c.save();
        c.restore();
        m1497r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1497r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1497r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1497r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1497r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1497r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1497r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1497r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1497r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1497r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1497r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1497r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1497r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1497r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.save();
        c.restore();
        m1497r(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4));
        c.restore();
        m1497r(new Integer[0]);
        c.restore();
    }

    private static void m1497r(Integer... o) {
        f1379p.reset();
        ps.reset();
        if (cf != null) {
            f1379p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1379p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1379p.setStyle(Style.FILL);
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
                    ps.setColor(Color.argb(0, 0, 0, 0));
                    break;
                case 3:
                    ps.setStrokeCap(Cap.BUTT);
                    break;
                case 4:
                    f1379p.setColor(Color.parseColor("#010002"));
                    break;
                default:
                    break;
            }
        }
    }
}
