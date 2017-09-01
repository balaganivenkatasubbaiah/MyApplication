package com.lyrebirdstudio.svg2;

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

import com.lyrebirdstudio.svg.Svg;
public class SvgLoveYou extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1723m = new Matrix();
    private static float od;
    private static final Paint f1724p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1725t = new Path();

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
        m1612r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1723m.reset();
        f1723m.setScale(od * 1.13f, od * 1.13f);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.save();
        c.save();
        c.save();
        f1724p.setColor(Color.parseColor("#000000"));
        f1725t.reset();
        f1725t.moveTo(44.15f, 227.68f);
        f1725t.cubicTo(46.46f, 232.32f, 49.44f, 233.64f, 52.75f, 234.97f);
        f1725t.cubicTo(56.06f, 236.29f, 61.02f, 236.96f, 67.31f, 236.96f);
        f1725t.cubicTo(90.14f, 236.96f, 108.67f, 225.04f, 108.67f, 217.77f);
        f1725t.cubicTo(108.67f, 217.11f, 108.67f, 216.77f, 108.34f, 216.11f);
        f1725t.cubicTo(99.41f, 200.89f, 98.08f, 148.6f, 98.08f, 111.54f);
        f1725t.cubicTo(98.08f, 78.12f, 102.06f, 18.22f, 103.38f, 11.92f);
        f1725t.cubicTo(103.38f, 11.92f, 103.71f, 10.6f, 103.71f, 9.94f);
        f1725t.cubicTo(103.71f, 0.0f, 82.19f, 0.0f, 82.19f, 0.0f);
        f1725t.cubicTo(61.35f, 0.0f, 48.77f, 7.29f, 45.79f, 10.26f);
        f1725t.cubicTo(44.14f, 11.91f, 43.8f, 13.23f, 43.8f, 14.56f);
        f1725t.cubicTo(43.8f, 16.22f, 44.14f, 17.55f, 44.14f, 17.55f);
        f1725t.cubicTo(46.13f, 29.46f, 47.12f, 47.0f, 47.12f, 67.19f);
        f1725t.cubicTo(47.12f, 106.23f, 42.48f, 182.02f, 42.48f, 215.44f);
        f1725t.cubicTo(42.49f, 220.07f, 42.82f, 224.38f, 44.15f, 227.68f);
        f1725t.transform(f1723m);
        if (clearMode) {
            f1724p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1725t, ps);
        } else {
            c.drawPath(f1725t, f1724p);
            c.drawPath(f1725t, ps);
        }
        c.restore();
        m1612r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1724p.setColor(Color.parseColor("#000000"));
        c.save();
        f1725t.reset();
        f1725t.moveTo(82.19f, 383.93f);
        f1725t.cubicTo(83.36f, 391.18f, 83.82f, 398.9f, 83.82f, 406.16f);
        f1725t.cubicTo(83.82f, 419.72f, 81.72f, 433.29f, 81.72f, 447.33f);
        f1725t.cubicTo(81.72f, 448.73f, 82.65f, 452.7f, 94.11f, 452.7f);
        f1725t.cubicTo(106.04f, 452.7f, 125.92f, 444.98f, 125.92f, 435.63f);
        f1725t.cubicTo(125.92f, 427.68f, 125.45f, 419.72f, 125.45f, 408.96f);
        f1725t.cubicTo(125.45f, 399.14f, 125.68f, 389.31f, 126.62f, 385.1f);
        f1725t.cubicTo(134.34f, 352.59f, 165.22f, 300.2f, 176.67f, 284.76f);
        f1725t.cubicTo(177.61f, 283.6f, 178.08f, 282.42f, 178.08f, 281.49f);
        f1725t.cubicTo(178.08f, 277.05f, 168.26f, 276.58f, 164.52f, 276.58f);
        f1725t.cubicTo(149.31f, 276.58f, 135.98f, 281.02f, 134.34f, 287.57f);
        f1725t.cubicTo(130.6f, 301.6f, 115.4f, 341.83f, 109.31f, 341.83f);
        f1725t.cubicTo(103.47f, 341.83f, 85.69f, 285.46f, 85.69f, 285.46f);
        f1725t.cubicTo(84.06f, 280.32f, 81.25f, 278.91f, 73.06f, 278.91f);
        f1725t.cubicTo(59.26f, 278.91f, 38.45f, 289.2f, 38.45f, 299.03f);
        f1725t.cubicTo(38.45f, 300.67f, 38.91f, 302.3f, 40.08f, 303.71f);
        f1725t.cubicTo(53.88f, 321.95f, 77.98f, 366.16f, 82.19f, 383.93f);
        f1725t.transform(f1723m);
        if (clearMode) {
            f1724p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1725t, ps);
        } else {
            c.drawPath(f1725t, f1724p);
            c.drawPath(f1725t, ps);
        }
        c.restore();
        m1612r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1725t.reset();
        f1725t.moveTo(194.19f, 310.73f);
        f1725t.cubicTo(181.56f, 322.18f, 167.76f, 341.36f, 167.76f, 377.38f);
        f1725t.cubicTo(167.76f, 419.72f, 187.17f, 454.1f, 225.07f, 454.1f);
        f1725t.cubicTo(268.81f, 454.1f, 293.13f, 418.32f, 293.13f, 360.78f);
        f1725t.cubicTo(293.13f, 300.9f, 261.32f, 277.98f, 229.75f, 277.98f);
        f1725t.cubicTo(199.81f, 277.98f, 182.04f, 294.35f, 182.04f, 299.04f);
        f1725t.cubicTo(182.04f, 303.49f, 193.49f, 308.63f, 193.49f, 308.63f);
        f1725t.cubicTo(195.83f, 309.56f, 194.19f, 310.73f, 194.19f, 310.73f);
        f1725t.moveTo(230.68f, 314.23f);
        f1725t.cubicTo(237.7f, 314.23f, 260.38f, 324.76f, 260.38f, 369.9f);
        f1725t.cubicTo(260.38f, 390.95f, 253.6f, 421.59f, 230.91f, 421.59f);
        f1725t.cubicTo(220.85f, 421.59f, 204.72f, 410.13f, 204.72f, 365.93f);
        f1725t.cubicTo(204.72f, 337.85f, 217.58f, 314.23f, 230.68f, 314.23f);
        f1725t.transform(f1723m);
        if (clearMode) {
            f1724p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1725t, ps);
        } else {
            c.drawPath(f1725t, f1724p);
            c.drawPath(f1725t, ps);
        }
        c.restore();
        m1612r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1725t.reset();
        f1725t.moveTo(377.06f, 290.38f);
        f1725t.cubicTo(376.13f, 291.31f, 375.89f, 293.18f, 375.89f, 295.99f);
        f1725t.cubicTo(375.89f, 306.05f, 379.87f, 328.73f, 379.87f, 370.13f);
        f1725t.cubicTo(379.87f, 377.38f, 379.64f, 384.86f, 379.4f, 393.52f);
        f1725t.cubicTo(379.4f, 393.52f, 379.63f, 420.18f, 361.62f, 420.18f);
        f1725t.cubicTo(348.75f, 420.18f, 344.08f, 411.29f, 344.08f, 372.46f);
        f1725t.cubicTo(344.08f, 339.48f, 348.06f, 288.02f, 348.06f, 288.02f);
        f1725t.cubicTo(348.06f, 283.81f, 340.11f, 281.94f, 335.43f, 281.94f);
        f1725t.cubicTo(318.59f, 281.94f, 306.89f, 288.02f, 304.55f, 290.36f);
        f1725t.cubicTo(303.61f, 291.29f, 302.92f, 292.23f, 302.92f, 293.87f);
        f1725t.cubicTo(302.92f, 299.95f, 303.85f, 305.8f, 303.85f, 334.32f);
        f1725t.cubicTo(303.85f, 360.76f, 302.69f, 389.52f, 302.69f, 404.02f);
        f1725t.cubicTo(302.69f, 416.89f, 306.2f, 452.91f, 356.49f, 452.91f);
        f1725t.cubicTo(393.44f, 452.91f, 412.62f, 426.71f, 412.62f, 407.52f);
        f1725t.cubicTo(412.62f, 402.38f, 411.21f, 397.7f, 411.21f, 372.67f);
        f1725t.cubicTo(411.21f, 331.5f, 415.66f, 285.42f, 415.66f, 284.26f);
        f1725t.cubicTo(415.66f, 280.05f, 408.17f, 279.58f, 408.17f, 279.58f);
        f1725t.cubicTo(397.65f, 279.62f, 384.08f, 283.36f, 377.06f, 290.38f);
        f1725t.transform(f1723m);
        if (clearMode) {
            f1724p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1725t, ps);
        } else {
            c.drawPath(f1725t, f1724p);
            c.drawPath(f1725t, ps);
        }
        c.restore();
        m1612r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1725t.reset();
        f1725t.moveTo(272.89f, 34.65f);
        f1725t.lineTo(272.43f, 34.65f);
        f1725t.cubicTo(272.43f, 34.65f, 209.47f, -30.35f, 154.53f, 20.01f);
        f1725t.cubicTo(99.58f, 70.38f, 147.66f, 188.41f, 272.43f, 238.78f);
        f1725t.lineTo(274.43f, 239.31f);
        f1725t.cubicTo(399.21f, 188.94f, 445.74f, 70.38f, 390.8f, 20.01f);
        f1725t.cubicTo(335.85f, -30.35f, 272.89f, 34.65f, 272.89f, 34.65f);
        f1725t.transform(f1723m);
        if (clearMode) {
            f1724p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1725t, ps);
        } else {
            c.drawPath(f1725t, f1724p);
            c.drawPath(f1725t, ps);
        }
        c.restore();
        m1612r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1612r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1724p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1612r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1724p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1612r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1612r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1612r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1612r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1612r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1612r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1612r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1612r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1612r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1612r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1612r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1612r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1612r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1612r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1612r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1612r(new Integer[0]);
        c.restore();
    }

    private static void m1612r(Integer... o) {
        f1724p.reset();
        ps.reset();
        if (cf != null) {
            f1724p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1724p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1724p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1724p.setColor(Color.parseColor("#000000"));
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
