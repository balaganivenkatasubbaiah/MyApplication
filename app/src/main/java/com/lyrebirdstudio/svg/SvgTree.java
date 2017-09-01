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

public class SvgTree extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1651m = new Matrix();
    private static float od;
    private static final Paint f1652p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1653t = new Path();

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
        m1588r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1651m.reset();
        f1651m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(0.87f, 0.87f);
        c.save();
        c.save();
        f1652p.setColor(Color.parseColor("#000000"));
        f1653t.reset();
        f1653t.moveTo(537.8f, 174.69f);
        f1653t.cubicTo(537.8f, 129.92f, 503.83f, 93.09f, 460.25f, 88.57f);
        f1653t.cubicTo(448.02f, 55.59f, 416.37f, 32.03f, 379.12f, 32.03f);
        f1653t.cubicTo(362.82f, 32.03f, 347.62f, 36.62f, 334.61f, 44.46f);
        f1653t.cubicTo(319.81f, 17.95f, 291.51f, 0.0f, 258.99f, 0.0f);
        f1653t.cubicTo(215.87f, 0.0f, 180.21f, 31.56f, 173.6f, 72.81f);
        f1653t.cubicTo(170.08f, 72.38f, 166.52f, 72.08f, 162.89f, 72.08f);
        f1653t.cubicTo(115.07f, 72.08f, 76.29f, 110.85f, 76.29f, 158.68f);
        f1653t.cubicTo(76.29f, 161.02f, 76.46f, 163.32f, 76.64f, 165.61f);
        f1653t.cubicTo(52.39f, 180.96f, 36.25f, 207.95f, 36.25f, 238.77f);
        f1653t.cubicTo(36.25f, 266.01f, 48.86f, 290.28f, 68.52f, 306.15f);
        f1653t.cubicTo(68.44f, 307.71f, 68.29f, 309.26f, 68.29f, 310.84f);
        f1653t.cubicTo(68.29f, 358.66f, 107.05f, 397.44f, 154.88f, 397.44f);
        f1653t.cubicTo(169.22f, 397.44f, 182.7f, 393.9f, 194.61f, 387.74f);
        f1653t.cubicTo(211.1f, 399.59f, 234.72f, 414.41f, 246.16f, 411.46f);
        f1653t.cubicTo(246.16f, 411.46f, 250.41f, 477.36f, 249.49f, 494.1f);
        f1653t.cubicTo(247.74f, 525.94f, 238.19f, 561.39f, 231.47f, 590.07f);
        f1653t.lineTo(335.59f, 590.07f);
        f1653t.cubicTo(335.59f, 590.07f, 320.24f, 526.12f, 319.57f, 504.77f);
        f1653t.cubicTo(318.9f, 483.41f, 326.24f, 444.09f, 326.24f, 444.09f);
        f1653t.lineTo(362.36f, 406.73f);
        f1653t.cubicTo(376.26f, 416.24f, 393.06f, 421.64f, 411.17f, 421.64f);
        f1653t.cubicTo(455.94f, 421.64f, 492.77f, 387.58f, 497.29f, 344.0f);
        f1653t.cubicTo(530.27f, 331.77f, 553.82f, 300.03f, 553.82f, 262.79f);
        f1653t.cubicTo(553.82f, 240.79f, 545.56f, 220.79f, 532.06f, 205.51f);
        f1653t.cubicTo(535.71f, 195.93f, 537.8f, 185.56f, 537.8f, 174.69f);
        f1653t.moveTo(214.61f, 373.44f);
        f1653t.cubicTo(221.55f, 366.82f, 227.38f, 359.07f, 231.82f, 350.48f);
        f1653t.lineTo(248.82f, 386.1f);
        f1653t.cubicTo(248.82f, 386.1f, 239.57f, 390.18f, 214.61f, 373.44f);
        f1653t.moveTo(278.18f, 395.44f);
        f1653t.cubicTo(269.38f, 397.03f, 254.4f, 369.94f, 243.77f, 347.92f);
        f1653t.cubicTo(255.56f, 353.94f, 268.87f, 357.4f, 283.02f, 357.4f);
        f1653t.cubicTo(286.66f, 357.4f, 290.22f, 357.1f, 293.74f, 356.66f);
        f1653t.cubicTo(291.01f, 374.29f, 286.19f, 393.98f, 278.18f, 395.44f);
        f1653t.moveTo(315.56f, 412.77f);
        f1653t.cubicTo(295.21f, 418.43f, 307.4f, 376.27f, 313.23f, 351.87f);
        f1653t.cubicTo(317.45f, 350.3f, 321.53f, 348.46f, 325.41f, 346.27f);
        f1653t.cubicTo(327.75f, 364.05f, 335.48f, 380.1f, 346.93f, 392.79f);
        f1653t.cubicTo(337.01f, 401.6f, 325.59f, 409.99f, 315.56f, 412.77f);
        f1653t.transform(f1651m);
        if (clearMode) {
            f1652p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1653t, ps);
        } else {
            c.drawPath(f1653t, f1652p);
            c.drawPath(f1653t, ps);
        }
        c.restore();
        m1588r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1652p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1588r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1652p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1588r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1588r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1588r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1588r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1588r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1588r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1588r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1588r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1588r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1588r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1588r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1588r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1588r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1588r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1588r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1588r(new Integer[0]);
        c.restore();
    }

    private static void m1588r(Integer... o) {
        f1652p.reset();
        ps.reset();
        if (cf != null) {
            f1652p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1652p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1652p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1652p.setColor(Color.parseColor("#000000"));
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
