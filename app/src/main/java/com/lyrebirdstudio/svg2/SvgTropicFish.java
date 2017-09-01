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
public class SvgTropicFish extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1741m = new Matrix();
    private static float od;
    private static final Paint f1742p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1743t = new Path();

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
        m1618r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1741m.reset();
        f1741m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(1.04f, 1.04f);
        c.save();
        f1742p.setColor(Color.parseColor("#000000"));
        f1743t.reset();
        f1743t.moveTo(489.74f, 236.59f);
        f1743t.cubicTo(489.14f, 233.99f, 487.52f, 231.8f, 485.35f, 230.43f);
        f1743t.cubicTo(486.8f, 228.22f, 487.34f, 225.46f, 486.72f, 222.76f);
        f1743t.cubicTo(485.67f, 218.21f, 481.66f, 215.14f, 476.74f, 215.14f);
        f1743t.cubicTo(476.16f, 215.14f, 475.57f, 215.18f, 475.0f, 215.27f);
        f1743t.cubicTo(465.85f, 216.69f, 457.42f, 217.4f, 449.93f, 217.4f);
        f1743t.cubicTo(449.93f, 217.4f, 449.93f, 217.4f, 449.92f, 217.4f);
        f1743t.cubicTo(403.81f, 217.4f, 391.82f, 191.48f, 373.68f, 152.25f);
        f1743t.cubicTo(369.99f, 144.26f, 366.16f, 136.01f, 361.75f, 127.33f);
        f1743t.cubicTo(354.91f, 113.89f, 343.41f, 101.29f, 327.57f, 89.86f);
        f1743t.cubicTo(313.07f, 79.42f, 295.25f, 70.16f, 274.6f, 62.34f);
        f1743t.cubicTo(235.93f, 47.73f, 190.07f, 39.35f, 148.75f, 39.35f);
        f1743t.cubicTo(126.65f, 39.35f, 107.31f, 41.7f, 91.24f, 46.34f);
        f1743t.cubicTo(73.84f, 51.37f, 61.1f, 58.8f, 53.67f, 68.63f);
        f1743t.cubicTo(24.76f, 106.91f, 71.4f, 132.45f, 73.81f, 179.52f);
        f1743t.cubicTo(48.73f, 158.17f, 20.13f, 145.62f, 2.19f, 150.08f);
        f1743t.cubicTo(1.35f, 150.29f, 0.63f, 150.82f, 0.29f, 151.61f);
        f1743t.cubicTo(-0.04f, 152.41f, 0.04f, 153.32f, 0.51f, 154.05f);
        f1743t.cubicTo(29.9f, 199.02f, 29.89f, 257.35f, 0.49f, 302.63f);
        f1743t.cubicTo(0.02f, 303.36f, -0.23f, 304.38f, 0.29f, 305.08f);
        f1743t.cubicTo(1.69f, 306.96f, 5.97f, 307.07f, 7.93f, 307.07f);
        f1743t.cubicTo(26.73f, 307.07f, 61.5f, 293.25f, 73.92f, 275.52f);
        f1743t.cubicTo(78.69f, 349.54f, -54.85f, 431.11f, 205.35f, 390.81f);
        f1743t.cubicTo(189.04f, 415.81f, 155.71f, 433.74f, 161.04f, 445.38f);
        f1743t.cubicTo(167.71f, 459.98f, 279.33f, 446.86f, 306.4f, 372.85f);
        f1743t.cubicTo(391.74f, 346.49f, 396.72f, 250.74f, 479.24f, 250.74f);
        f1743t.cubicTo(490.88f, 250.51f, 490.35f, 239.23f, 489.74f, 236.59f);
        f1743t.moveTo(357.16f, 225.83f);
        f1743t.cubicTo(350.28f, 225.83f, 344.71f, 220.26f, 344.71f, 213.38f);
        f1743t.cubicTo(344.71f, 206.51f, 350.28f, 200.93f, 357.16f, 200.93f);
        f1743t.cubicTo(364.03f, 200.93f, 369.61f, 206.51f, 369.61f, 213.38f);
        f1743t.cubicTo(369.61f, 220.26f, 364.03f, 225.83f, 357.16f, 225.83f);
        f1743t.transform(f1741m);
        if (clearMode) {
            f1742p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1743t, ps);
        } else {
            c.drawPath(f1743t, f1742p);
            c.drawPath(f1743t, ps);
        }
        c.restore();
        m1618r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1742p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1618r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1618r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1618r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1618r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1618r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1618r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1618r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1618r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1618r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1618r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1618r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1618r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1618r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1618r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1618r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1618r(new Integer[0]);
        c.restore();
    }

    private static void m1618r(Integer... o) {
        f1742p.reset();
        ps.reset();
        if (cf != null) {
            f1742p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1742p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1742p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1742p.setColor(Color.parseColor("#000000"));
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
