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

public class SvgStrawberry extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1639m = new Matrix();
    private static float od;
    private static final Paint f1640p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1641t = new Path();

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
        m1584r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1639m.reset();
        f1639m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(1.03f, 1.03f);
        c.save();
        c.save();
        c.save();
        f1640p.setColor(Color.parseColor("#000000"));
        f1641t.reset();
        f1641t.moveTo(303.96f, 129.45f);
        f1641t.cubicTo(318.19f, 110.7f, 334.86f, 93.62f, 351.19f, 78.84f);
        f1641t.cubicTo(361.92f, 69.13f, 353.66f, 55.17f, 342.61f, 52.79f);
        f1641t.cubicTo(341.04f, 52.32f, 339.36f, 51.99f, 337.43f, 52.03f);
        f1641t.cubicTo(312.5f, 52.55f, 292.66f, 60.35f, 276.11f, 73.31f);
        f1641t.cubicTo(279.75f, 56.24f, 284.81f, 39.5f, 291.97f, 23.31f);
        f1641t.cubicTo(297.82f, 10.07f, 288.43f, -1.88f, 274.18f, 0.25f);
        f1641t.cubicTo(260.57f, 2.29f, 247.05f, 1.21f, 233.49f, 4.18f);
        f1641t.cubicTo(225.96f, 5.82f, 222.52f, 11.22f, 222.21f, 17.03f);
        f1641t.cubicTo(221.9f, 18.52f, 221.74f, 20.12f, 221.93f, 21.94f);
        f1641t.cubicTo(223.95f, 40.8f, 224.76f, 59.69f, 224.33f, 78.56f);
        f1641t.cubicTo(207.24f, 64.31f, 184.69f, 56.37f, 161.55f, 54.66f);
        f1641t.cubicTo(145.13f, 53.45f, 141.16f, 76.12f, 153.61f, 83.92f);
        f1641t.cubicTo(174.25f, 96.87f, 191.71f, 113.31f, 201.21f, 133.82f);
        f1641t.cubicTo(168.14f, 115.26f, 122.37f, 104.93f, 79.91f, 148.29f);
        f1641t.cubicTo(1.54f, 228.34f, 70.12f, 416.14f, 248.09f, 496.2f);
        f1641t.lineTo(250.95f, 497.25f);
        f1641t.cubicTo(428.92f, 417.19f, 495.3f, 228.33f, 416.92f, 148.29f);
        f1641t.cubicTo(377.94f, 108.47f, 336.14f, 113.92f, 303.96f, 129.45f);
        f1641t.moveTo(110.63f, 287.8f);
        f1641t.cubicTo(110.63f, 293.09f, 106.35f, 297.36f, 101.06f, 297.36f);
        f1641t.cubicTo(95.78f, 297.36f, 91.5f, 293.09f, 91.5f, 287.8f);
        f1641t.lineTo(91.5f, 249.55f);
        f1641t.cubicTo(91.5f, 244.26f, 95.78f, 239.99f, 101.06f, 239.99f);
        f1641t.cubicTo(106.35f, 239.99f, 110.63f, 244.26f, 110.63f, 249.55f);
        f1641t.lineTo(110.63f, 287.8f);
        f1641t.moveTo(177.56f, 364.3f);
        f1641t.cubicTo(177.56f, 369.59f, 173.29f, 373.86f, 168.0f, 373.86f);
        f1641t.cubicTo(162.71f, 373.86f, 158.44f, 369.59f, 158.44f, 364.3f);
        f1641t.lineTo(158.44f, 326.05f);
        f1641t.cubicTo(158.44f, 320.76f, 162.71f, 316.49f, 168.0f, 316.49f);
        f1641t.cubicTo(173.29f, 316.49f, 177.56f, 320.76f, 177.56f, 326.05f);
        f1641t.lineTo(177.56f, 364.3f);
        f1641t.moveTo(177.56f, 201.74f);
        f1641t.cubicTo(177.56f, 207.03f, 173.29f, 211.3f, 168.0f, 211.3f);
        f1641t.cubicTo(162.71f, 211.3f, 158.44f, 207.03f, 158.44f, 201.74f);
        f1641t.lineTo(158.44f, 163.49f);
        f1641t.cubicTo(158.44f, 158.2f, 162.71f, 153.93f, 168.0f, 153.93f);
        f1641t.cubicTo(173.29f, 153.93f, 177.56f, 158.2f, 177.56f, 163.49f);
        f1641t.lineTo(177.56f, 201.74f);
        f1641t.moveTo(254.06f, 459.93f);
        f1641t.cubicTo(254.06f, 465.22f, 249.79f, 469.49f, 244.5f, 469.49f);
        f1641t.cubicTo(239.21f, 469.49f, 234.94f, 465.22f, 234.94f, 459.93f);
        f1641t.lineTo(234.94f, 421.68f);
        f1641t.cubicTo(234.94f, 416.39f, 239.21f, 412.12f, 244.5f, 412.12f);
        f1641t.cubicTo(249.79f, 412.12f, 254.06f, 416.39f, 254.06f, 421.68f);
        f1641t.lineTo(254.06f, 459.93f);
        f1641t.moveTo(254.06f, 287.8f);
        f1641t.cubicTo(254.06f, 293.09f, 249.79f, 297.36f, 244.5f, 297.36f);
        f1641t.cubicTo(239.21f, 297.36f, 234.94f, 293.09f, 234.94f, 287.8f);
        f1641t.lineTo(234.94f, 249.55f);
        f1641t.cubicTo(234.94f, 244.26f, 239.21f, 239.99f, 244.5f, 239.99f);
        f1641t.cubicTo(249.79f, 239.99f, 254.06f, 244.26f, 254.06f, 249.55f);
        f1641t.lineTo(254.06f, 287.8f);
        f1641t.moveTo(340.13f, 364.3f);
        f1641t.cubicTo(340.13f, 369.59f, 335.85f, 373.86f, 330.56f, 373.86f);
        f1641t.cubicTo(325.27f, 373.86f, 321.0f, 369.59f, 321.0f, 364.3f);
        f1641t.lineTo(321.0f, 326.05f);
        f1641t.cubicTo(321.0f, 320.76f, 325.27f, 316.49f, 330.56f, 316.49f);
        f1641t.cubicTo(335.85f, 316.49f, 340.12f, 320.76f, 340.12f, 326.05f);
        f1641t.lineTo(340.12f, 364.3f);
        f1641t.moveTo(340.13f, 201.74f);
        f1641t.cubicTo(340.13f, 207.03f, 335.85f, 211.3f, 330.56f, 211.3f);
        f1641t.cubicTo(325.27f, 211.3f, 321.0f, 207.03f, 321.0f, 201.74f);
        f1641t.lineTo(321.0f, 163.49f);
        f1641t.cubicTo(321.0f, 158.2f, 325.27f, 153.93f, 330.56f, 153.93f);
        f1641t.cubicTo(335.85f, 153.93f, 340.12f, 158.2f, 340.12f, 163.49f);
        f1641t.lineTo(340.12f, 201.74f);
        f1641t.moveTo(407.06f, 287.8f);
        f1641t.cubicTo(407.06f, 293.09f, 402.79f, 297.36f, 397.5f, 297.36f);
        f1641t.cubicTo(392.21f, 297.36f, 387.94f, 293.09f, 387.94f, 287.8f);
        f1641t.lineTo(387.94f, 249.55f);
        f1641t.cubicTo(387.94f, 244.26f, 392.21f, 239.99f, 397.5f, 239.99f);
        f1641t.cubicTo(402.79f, 239.99f, 407.06f, 244.26f, 407.06f, 249.55f);
        f1641t.lineTo(407.06f, 287.8f);
        f1641t.transform(f1639m);
        if (clearMode) {
            f1640p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1641t, ps);
        } else {
            c.drawPath(f1641t, f1640p);
            c.drawPath(f1641t, ps);
        }
        c.restore();
        m1584r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1640p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1584r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1640p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1584r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1640p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1584r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1584r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1584r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1584r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1584r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1584r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1584r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1584r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1584r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1584r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1584r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1584r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1584r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1584r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1584r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1584r(new Integer[0]);
        c.restore();
    }

    private static void m1584r(Integer... o) {
        f1640p.reset();
        ps.reset();
        if (cf != null) {
            f1640p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1640p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1640p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1640p.setColor(Color.parseColor("#000000"));
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
