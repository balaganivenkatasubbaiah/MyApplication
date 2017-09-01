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
public class SvgBasketball extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1672m = new Matrix();
    private static float od;
    private static final Paint f1673p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1674t = new Path();

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
        m1595r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1672m.reset();
        f1672m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(1.05f, 1.05f);
        c.save();
        c.save();
        c.save();
        c.save();
        f1673p.setColor(Color.parseColor("#000000"));
        f1674t.reset();
        f1674t.moveTo(264.32f, 39.49f);
        f1674t.cubicTo(269.85f, 32.16f, 268.96f, 16.62f, 268.17f, 2.91f);
        f1674t.cubicTo(268.14f, 2.31f, 268.11f, 1.74f, 268.08f, 1.15f);
        f1674t.cubicTo(260.33f, 0.41f, 252.48f, 0.0f, 244.54f, 0.0f);
        f1674t.cubicTo(214.12f, 0.0f, 185.0f, 5.61f, 158.14f, 15.77f);
        f1674t.cubicTo(177.3f, 24.98f, 206.97f, 40.83f, 239.95f, 64.26f);
        f1674t.cubicTo(251.2f, 54.57f, 259.69f, 45.63f, 264.32f, 39.49f);
        f1674t.transform(f1672m);
        if (clearMode) {
            f1673p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1674t, ps);
        } else {
            c.drawPath(f1674t, f1673p);
            c.drawPath(f1674t, ps);
        }
        c.restore();
        m1595r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1673p.setColor(Color.parseColor("#000000"));
        c.save();
        f1674t.reset();
        f1674t.moveTo(388.16f, 178.96f);
        f1674t.cubicTo(376.12f, 180.32f, 365.96f, 182.29f, 357.27f, 185.07f);
        f1674t.cubicTo(398.8f, 257.59f, 415.0f, 349.21f, 418.96f, 415.59f);
        f1674t.cubicTo(460.11f, 373.66f, 486.25f, 316.98f, 488.72f, 254.19f);
        f1674t.cubicTo(460.36f, 219.34f, 422.8f, 175.03f, 388.16f, 178.96f);
        f1674t.transform(f1672m);
        if (clearMode) {
            f1673p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1674t, ps);
        } else {
            c.drawPath(f1674t, f1673p);
            c.drawPath(f1674t, ps);
        }
        c.restore();
        m1595r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1674t.reset();
        f1674t.moveTo(141.23f, 116.36f);
        f1674t.cubicTo(170.42f, 110.28f, 197.84f, 95.59f, 219.7f, 80.09f);
        f1674t.cubicTo(174.09f, 48.68f, 136.05f, 32.38f, 128.48f, 29.27f);
        f1674t.cubicTo(81.17f, 54.85f, 43.3f, 95.61f, 21.27f, 144.99f);
        f1674t.cubicTo(49.91f, 133.58f, 80.91f, 127.77f, 111.37f, 122.12f);
        f1674t.cubicTo(121.22f, 120.29f, 131.41f, 118.4f, 141.23f, 116.36f);
        f1674t.transform(f1672m);
        if (clearMode) {
            f1673p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1674t, ps);
        } else {
            c.drawPath(f1674t, f1673p);
            c.drawPath(f1674t, ps);
        }
        c.restore();
        m1595r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1674t.reset();
        f1674t.moveTo(310.17f, 123.46f);
        f1674t.cubicTo(312.78f, 126.08f, 315.37f, 128.74f, 317.95f, 131.46f);
        f1674t.cubicTo(327.48f, 141.45f, 336.11f, 152.38f, 344.04f, 163.95f);
        f1674t.cubicTo(355.57f, 159.59f, 369.15f, 156.5f, 385.41f, 154.67f);
        f1674t.cubicTo(423.72f, 150.33f, 457.78f, 180.68f, 487.02f, 214.09f);
        f1674t.cubicTo(480.75f, 163.44f, 459.03f, 117.6f, 426.66f, 81.46f);
        f1674t.cubicTo(409.0f, 83.58f, 389.3f, 87.19f, 369.23f, 93.18f);
        f1674t.cubicTo(356.06f, 97.11f, 335.09f, 107.8f, 310.17f, 123.46f);
        f1674t.transform(f1672m);
        if (clearMode) {
            f1673p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1674t, ps);
        } else {
            c.drawPath(f1674t, f1673p);
            c.drawPath(f1674t, ps);
        }
        c.restore();
        m1595r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1674t.reset();
        f1674t.moveTo(278.01f, 249.69f);
        f1674t.cubicTo(288.04f, 215.73f, 299.65f, 191.26f, 322.15f, 175.37f);
        f1674t.cubicTo(315.39f, 165.67f, 308.13f, 156.58f, 300.26f, 148.31f);
        f1674t.cubicTo(296.62f, 144.49f, 292.93f, 140.8f, 289.24f, 137.17f);
        f1674t.cubicTo(198.97f, 198.61f, 75.33f, 311.47f, 64.09f, 409.25f);
        f1674t.cubicTo(101.62f, 450.32f, 152.98f, 478.48f, 210.8f, 486.47f);
        f1674t.cubicTo(231.85f, 444.55f, 251.67f, 359.34f, 263.44f, 308.67f);
        f1674t.cubicTo(269.1f, 284.32f, 273.99f, 263.31f, 278.01f, 249.69f);
        f1674t.transform(f1672m);
        if (clearMode) {
            f1673p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1674t, ps);
        } else {
            c.drawPath(f1674t, f1673p);
            c.drawPath(f1674t, ps);
        }
        c.restore();
        m1595r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1674t.reset();
        f1674t.moveTo(175.67f, 195.84f);
        f1674t.cubicTo(207.14f, 166.84f, 240.38f, 140.84f, 270.77f, 119.93f);
        f1674t.cubicTo(260.64f, 110.97f, 250.48f, 102.71f, 240.5f, 95.13f);
        f1674t.cubicTo(215.25f, 114.11f, 182.19f, 132.8f, 146.21f, 140.28f);
        f1674t.cubicTo(136.13f, 142.38f, 125.81f, 144.3f, 115.84f, 146.15f);
        f1674t.cubicTo(77.4f, 153.29f, 40.5f, 160.2f, 9.47f, 177.51f);
        f1674t.cubicTo(3.43f, 198.79f, 0.12f, 221.21f, 0.12f, 244.42f);
        f1674t.cubicTo(0.12f, 296.34f, 16.36f, 344.44f, 43.96f, 384.02f);
        f1674t.cubicTo(61.84f, 313.23f, 123.17f, 244.21f, 175.67f, 195.84f);
        f1674t.transform(f1672m);
        if (clearMode) {
            f1673p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1674t, ps);
        } else {
            c.drawPath(f1674t, f1673p);
            c.drawPath(f1674t, ps);
        }
        c.restore();
        m1595r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1674t.reset();
        f1674t.moveTo(291.83f, 105.97f);
        f1674t.cubicTo(320.91f, 87.44f, 345.98f, 74.62f, 362.24f, 69.76f);
        f1674t.cubicTo(376.85f, 65.4f, 391.18f, 62.22f, 404.74f, 59.91f);
        f1674t.cubicTo(373.39f, 32.66f, 335.06f, 13.24f, 292.76f, 4.78f);
        f1674t.cubicTo(293.69f, 21.85f, 294.1f, 40.59f, 283.83f, 54.21f);
        f1674t.cubicTo(278.96f, 60.67f, 270.7f, 69.54f, 259.96f, 79.16f);
        f1674t.cubicTo(270.48f, 87.35f, 281.17f, 96.28f, 291.83f, 105.97f);
        f1674t.transform(f1672m);
        if (clearMode) {
            f1673p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1674t, ps);
        } else {
            c.drawPath(f1674t, f1673p);
            c.drawPath(f1674t, ps);
        }
        c.restore();
        m1595r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1674t.reset();
        f1674t.moveTo(301.45f, 256.61f);
        f1674t.cubicTo(297.63f, 269.54f, 292.82f, 290.23f, 287.25f, 314.2f);
        f1674t.cubicTo(270.81f, 384.95f, 255.07f, 448.26f, 236.7f, 488.64f);
        f1674t.cubicTo(239.3f, 488.72f, 241.91f, 488.84f, 244.54f, 488.84f);
        f1674t.cubicTo(301.5f, 488.84f, 353.87f, 469.3f, 395.43f, 436.63f);
        f1674t.cubicTo(393.79f, 367.17f, 377.13f, 268.92f, 335.19f, 195.99f);
        f1674t.cubicTo(318.92f, 208.08f, 310.17f, 227.1f, 301.45f, 256.61f);
        f1674t.transform(f1672m);
        if (clearMode) {
            f1673p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1674t, ps);
        } else {
            c.drawPath(f1674t, f1673p);
            c.drawPath(f1674t, ps);
        }
        c.restore();
        m1595r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1595r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1673p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1595r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1673p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1595r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1673p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1595r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1595r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1595r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1595r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1595r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1595r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1595r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1595r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1595r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1595r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1595r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1595r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1595r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1595r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1595r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1595r(new Integer[0]);
        c.restore();
    }

    private static void m1595r(Integer... o) {
        f1673p.reset();
        ps.reset();
        if (cf != null) {
            f1673p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1673p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1673p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1673p.setColor(Color.parseColor("#000000"));
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
