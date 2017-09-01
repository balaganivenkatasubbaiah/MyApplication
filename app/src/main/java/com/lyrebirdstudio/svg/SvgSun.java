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

public class SvgSun extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1645m = new Matrix();
    private static float od;
    private static final Paint f1646p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1647t = new Path();

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
        m1586r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1645m.reset();
        f1645m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(0.88f, 0.88f);
        c.save();
        c.save();
        c.save();
        f1646p.setColor(Color.parseColor("#000000"));
        f1647t.reset();
        f1647t.moveTo(565.41f, 199.96f);
        f1647t.cubicTo(564.54f, 196.72f, 562.39f, 194.57f, 558.93f, 193.49f);
        f1647t.lineTo(464.45f, 162.44f);
        f1647t.lineTo(464.45f, 63.42f);
        f1647t.cubicTo(464.45f, 59.97f, 463.05f, 57.18f, 460.24f, 55.01f);
        f1647t.cubicTo(457.01f, 52.86f, 453.88f, 52.43f, 450.86f, 53.71f);
        f1647t.lineTo(356.38f, 84.13f);
        f1647t.lineTo(298.14f, 3.89f);
        f1647t.cubicTo(296.22f, 1.3f, 293.41f, 0.0f, 289.74f, 0.0f);
        f1647t.cubicTo(286.07f, 0.0f, 283.27f, 1.3f, 281.33f, 3.89f);
        f1647t.lineTo(223.09f, 84.13f);
        f1647t.lineTo(128.61f, 53.71f);
        f1647t.cubicTo(125.58f, 52.42f, 122.46f, 52.86f, 119.23f, 55.01f);
        f1647t.cubicTo(116.42f, 57.18f, 115.02f, 59.98f, 115.02f, 63.42f);
        f1647t.lineTo(115.02f, 162.44f);
        f1647t.lineTo(20.55f, 193.49f);
        f1647t.cubicTo(17.09f, 194.58f, 14.93f, 196.73f, 14.07f, 199.96f);
        f1647t.cubicTo(12.99f, 203.42f, 13.43f, 206.54f, 15.36f, 209.35f);
        f1647t.lineTo(73.61f, 289.58f);
        f1647t.lineTo(15.36f, 369.83f);
        f1647t.cubicTo(13.42f, 372.41f, 12.99f, 375.55f, 14.07f, 379.21f);
        f1647t.cubicTo(14.93f, 382.45f, 17.09f, 384.61f, 20.55f, 385.68f);
        f1647t.lineTo(115.03f, 416.74f);
        f1647t.lineTo(115.03f, 515.76f);
        f1647t.cubicTo(115.03f, 519.21f, 116.43f, 522.0f, 119.23f, 524.16f);
        f1647t.cubicTo(122.47f, 526.32f, 125.6f, 526.75f, 128.61f, 525.46f);
        f1647t.lineTo(223.09f, 495.04f);
        f1647t.lineTo(281.33f, 575.29f);
        f1647t.cubicTo(283.49f, 578.09f, 286.29f, 579.5f, 289.75f, 579.5f);
        f1647t.cubicTo(293.19f, 579.5f, 296.0f, 578.1f, 298.16f, 575.29f);
        f1647t.lineTo(356.4f, 495.04f);
        f1647t.lineTo(450.88f, 525.46f);
        f1647t.cubicTo(453.9f, 526.75f, 457.02f, 526.32f, 460.26f, 524.16f);
        f1647t.cubicTo(463.06f, 522.0f, 464.47f, 519.2f, 464.47f, 515.76f);
        f1647t.lineTo(464.47f, 416.74f);
        f1647t.lineTo(558.95f, 385.69f);
        f1647t.cubicTo(562.4f, 384.61f, 564.56f, 382.45f, 565.43f, 379.22f);
        f1647t.cubicTo(566.5f, 375.55f, 566.07f, 372.42f, 564.14f, 369.83f);
        f1647t.lineTo(505.89f, 289.58f);
        f1647t.lineTo(564.14f, 209.35f);
        f1647t.cubicTo(566.06f, 206.54f, 566.49f, 203.42f, 565.41f, 199.96f);
        f1647t.moveTo(461.39f, 361.9f);
        f1647t.cubicTo(451.57f, 384.88f, 438.31f, 404.72f, 421.59f, 421.43f);
        f1647t.cubicTo(404.88f, 438.16f, 385.03f, 451.42f, 362.06f, 461.23f);
        f1647t.cubicTo(339.08f, 471.05f, 314.98f, 475.95f, 289.74f, 475.95f);
        f1647t.cubicTo(264.5f, 475.95f, 240.4f, 471.05f, 217.43f, 461.23f);
        f1647t.cubicTo(194.45f, 451.42f, 174.6f, 438.16f, 157.89f, 421.43f);
        f1647t.cubicTo(141.18f, 404.72f, 127.91f, 384.87f, 118.09f, 361.9f);
        f1647t.cubicTo(108.28f, 338.93f, 103.38f, 314.82f, 103.38f, 289.58f);
        f1647t.cubicTo(103.38f, 264.35f, 108.28f, 240.24f, 118.09f, 217.27f);
        f1647t.cubicTo(127.91f, 194.29f, 141.17f, 174.46f, 157.89f, 157.73f);
        f1647t.cubicTo(174.6f, 141.02f, 194.45f, 127.75f, 217.43f, 117.94f);
        f1647t.cubicTo(240.39f, 108.13f, 264.5f, 103.22f, 289.74f, 103.22f);
        f1647t.cubicTo(314.98f, 103.22f, 339.08f, 108.13f, 362.05f, 117.94f);
        f1647t.cubicTo(385.02f, 127.75f, 404.87f, 141.02f, 421.59f, 157.73f);
        f1647t.cubicTo(438.3f, 174.46f, 451.57f, 194.3f, 461.39f, 217.27f);
        f1647t.cubicTo(471.2f, 240.23f, 476.11f, 264.35f, 476.11f, 289.58f);
        f1647t.cubicTo(476.11f, 314.82f, 471.2f, 338.93f, 461.39f, 361.9f);
        f1647t.transform(f1645m);
        if (clearMode) {
            f1646p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1647t, ps);
        } else {
            c.drawPath(f1647t, f1646p);
            c.drawPath(f1647t, ps);
        }
        c.restore();
        m1586r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1646p.setColor(Color.parseColor("#000000"));
        c.save();
        f1647t.reset();
        f1647t.transform(f1645m);
        if (clearMode) {
            f1646p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        c.drawPath(f1647t, f1646p);
        c.drawPath(f1647t, ps);
        c.restore();
        m1586r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1586r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1646p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1586r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1646p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1586r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1586r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1586r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1586r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1586r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1586r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1586r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1586r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1586r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1586r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1586r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1586r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1586r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1586r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1586r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1586r(new Integer[0]);
        c.restore();
    }

    private static void m1586r(Integer... o) {
        f1646p.reset();
        ps.reset();
        if (cf != null) {
            f1646p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1646p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1646p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1646p.setColor(Color.parseColor("#000000"));
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
