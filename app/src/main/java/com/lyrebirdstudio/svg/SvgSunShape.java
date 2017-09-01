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

public class SvgSunShape extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1648m = new Matrix();
    private static float od;
    private static final Paint f1649p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1650t = new Path();

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
        m1587r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1648m.reset();
        f1648m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(0.88f, 0.88f);
        c.save();
        c.save();
        c.save();
        f1649p.setColor(Color.parseColor("#000000"));
        f1650t.reset();
        f1650t.moveTo(289.65f, 109.2f);
        f1650t.cubicTo(311.33f, 109.2f, 332.12f, 113.05f, 351.38f, 120.08f);
        f1650t.cubicTo(352.34f, 102.35f, 349.91f, 70.25f, 323.49f, 50.66f);
        f1650t.cubicTo(285.53f, 22.52f, 312.76f, 0.0f, 312.76f, 0.0f);
        f1650t.cubicTo(312.76f, 0.0f, 242.74f, 14.96f, 252.21f, 113.13f);
        f1650t.cubicTo(264.29f, 110.57f, 276.81f, 109.2f, 289.65f, 109.2f);
        f1650t.transform(f1648m);
        if (clearMode) {
            f1649p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1650t, ps);
        } else {
            c.drawPath(f1650t, f1649p);
            c.drawPath(f1650t, ps);
        }
        c.restore();
        m1587r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1649p.setColor(Color.parseColor("#000000"));
        c.save();
        f1650t.reset();
        f1650t.moveTo(528.65f, 255.82f);
        f1650t.cubicTo(509.06f, 229.4f, 476.95f, 226.96f, 459.22f, 227.92f);
        f1650t.cubicTo(466.26f, 247.19f, 470.11f, 267.98f, 470.11f, 289.65f);
        f1650t.cubicTo(470.11f, 302.49f, 468.74f, 315.01f, 466.17f, 327.1f);
        f1650t.cubicTo(564.35f, 336.57f, 579.3f, 266.54f, 579.3f, 266.54f);
        f1650t.cubicTo(579.3f, 266.54f, 556.79f, 293.78f, 528.65f, 255.82f);
        f1650t.transform(f1648m);
        if (clearMode) {
            f1649p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1650t, ps);
        } else {
            c.drawPath(f1650t, f1649p);
            c.drawPath(f1650t, ps);
        }
        c.restore();
        m1587r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1650t.reset();
        f1650t.moveTo(266.55f, 579.31f);
        f1650t.cubicTo(266.55f, 579.31f, 336.57f, 564.35f, 327.1f, 466.18f);
        f1650t.cubicTo(315.02f, 468.74f, 302.5f, 470.11f, 289.66f, 470.11f);
        f1650t.cubicTo(267.98f, 470.11f, 247.19f, 466.26f, 227.93f, 459.23f);
        f1650t.cubicTo(226.97f, 476.96f, 229.4f, 509.06f, 255.82f, 528.65f);
        f1650t.cubicTo(293.78f, 556.79f, 266.55f, 579.31f, 266.55f, 579.31f);
        f1650t.transform(f1648m);
        if (clearMode) {
            f1649p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1650t, ps);
        } else {
            c.drawPath(f1650t, f1649p);
            c.drawPath(f1650t, ps);
        }
        c.restore();
        m1587r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1650t.reset();
        f1650t.moveTo(50.66f, 323.5f);
        f1650t.cubicTo(70.25f, 349.91f, 102.36f, 352.35f, 120.09f, 351.39f);
        f1650t.cubicTo(113.05f, 332.12f, 109.21f, 311.33f, 109.21f, 289.66f);
        f1650t.cubicTo(109.21f, 276.82f, 110.58f, 264.3f, 113.14f, 252.21f);
        f1650t.cubicTo(14.96f, 242.74f, 0.0f, 312.76f, 0.0f, 312.76f);
        f1650t.cubicTo(0.0f, 312.76f, 22.52f, 285.53f, 50.66f, 323.5f);
        f1650t.transform(f1648m);
        if (clearMode) {
            f1649p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1650t, ps);
        } else {
            c.drawPath(f1650t, f1649p);
            c.drawPath(f1650t, ps);
        }
        c.restore();
        m1587r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1650t.reset();
        f1650t.moveTo(440.88f, 191.37f);
        f1650t.cubicTo(517.1f, 128.63f, 478.13f, 68.5f, 478.13f, 68.5f);
        f1650t.cubicTo(478.13f, 68.5f, 481.47f, 103.68f, 434.72f, 96.73f);
        f1650t.cubicTo(402.16f, 91.89f, 377.72f, 112.93f, 365.87f, 126.14f);
        f1650t.cubicTo(396.54f, 140.5f, 422.52f, 163.22f, 440.88f, 191.37f);
        f1650t.transform(f1648m);
        if (clearMode) {
            f1649p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1650t, ps);
        } else {
            c.drawPath(f1650t, f1649p);
            c.drawPath(f1650t, ps);
        }
        c.restore();
        m1587r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1650t.reset();
        f1650t.moveTo(138.43f, 191.37f);
        f1650t.cubicTo(156.79f, 163.22f, 182.77f, 140.5f, 213.44f, 126.14f);
        f1650t.cubicTo(201.6f, 112.93f, 177.15f, 91.89f, 144.59f, 96.73f);
        f1650t.cubicTo(97.84f, 103.68f, 101.18f, 68.5f, 101.18f, 68.5f);
        f1650t.cubicTo(101.18f, 68.5f, 62.22f, 128.63f, 138.43f, 191.37f);
        f1650t.transform(f1648m);
        if (clearMode) {
            f1649p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1650t, ps);
        } else {
            c.drawPath(f1650t, f1649p);
            c.drawPath(f1650t, ps);
        }
        c.restore();
        m1587r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1650t.reset();
        f1650t.moveTo(144.59f, 482.57f);
        f1650t.cubicTo(177.15f, 487.41f, 201.6f, 466.38f, 213.44f, 453.17f);
        f1650t.cubicTo(182.77f, 438.82f, 156.79f, 416.09f, 138.43f, 387.94f);
        f1650t.cubicTo(62.22f, 450.68f, 101.18f, 510.81f, 101.18f, 510.81f);
        f1650t.cubicTo(101.18f, 510.81f, 97.84f, 475.63f, 144.59f, 482.57f);
        f1650t.transform(f1648m);
        if (clearMode) {
            f1649p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1650t, ps);
        } else {
            c.drawPath(f1650t, f1649p);
            c.drawPath(f1650t, ps);
        }
        c.restore();
        m1587r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1650t.reset();
        f1650t.moveTo(440.88f, 387.94f);
        f1650t.cubicTo(422.52f, 416.09f, 396.54f, 438.82f, 365.87f, 453.17f);
        f1650t.cubicTo(377.71f, 466.38f, 402.16f, 487.41f, 434.72f, 482.57f);
        f1650t.cubicTo(481.47f, 475.63f, 478.13f, 510.81f, 478.13f, 510.81f);
        f1650t.cubicTo(478.13f, 510.81f, 517.1f, 450.69f, 440.88f, 387.94f);
        f1650t.transform(f1648m);
        if (clearMode) {
            f1649p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1650t, ps);
        } else {
            c.drawPath(f1650t, f1649p);
            c.drawPath(f1650t, ps);
        }
        c.restore();
        m1587r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1650t.reset();
        f1650t.moveTo(427.9f, 378.08f);
        f1650t.cubicTo(438.19f, 362.04f, 445.76f, 344.1f, 449.96f, 324.89f);
        f1650t.cubicTo(452.44f, 313.53f, 453.79f, 301.75f, 453.79f, 289.66f);
        f1650t.cubicTo(453.79f, 272.73f, 451.22f, 256.4f, 446.47f, 241.04f);
        f1650t.cubicTo(442.07f, 226.84f, 435.76f, 213.49f, 427.9f, 201.23f);
        f1650t.cubicTo(412.63f, 177.4f, 391.39f, 157.78f, 366.26f, 144.49f);
        f1650t.cubicTo(357.37f, 139.8f, 348.02f, 135.87f, 338.27f, 132.85f);
        f1650t.cubicTo(322.91f, 128.09f, 306.58f, 125.52f, 289.66f, 125.52f);
        f1650t.cubicTo(277.56f, 125.52f, 265.78f, 126.87f, 254.42f, 129.35f);
        f1650t.cubicTo(239.81f, 132.55f, 225.93f, 137.69f, 213.05f, 144.49f);
        f1650t.cubicTo(187.92f, 157.78f, 166.68f, 177.4f, 151.41f, 201.23f);
        f1650t.cubicTo(141.12f, 217.27f, 133.55f, 235.21f, 129.35f, 254.43f);
        f1650t.cubicTo(126.87f, 265.78f, 125.52f, 277.56f, 125.52f, 289.66f);
        f1650t.cubicTo(125.52f, 306.58f, 128.09f, 322.91f, 132.84f, 338.27f);
        f1650t.cubicTo(137.24f, 352.47f, 143.55f, 365.82f, 151.41f, 378.08f);
        f1650t.cubicTo(166.68f, 401.91f, 187.92f, 421.53f, 213.05f, 434.82f);
        f1650t.cubicTo(221.94f, 439.51f, 231.29f, 443.45f, 241.04f, 446.47f);
        f1650t.cubicTo(256.4f, 451.22f, 272.73f, 453.79f, 289.66f, 453.79f);
        f1650t.cubicTo(301.75f, 453.79f, 313.54f, 452.44f, 324.89f, 449.96f);
        f1650t.cubicTo(339.5f, 446.76f, 353.38f, 441.62f, 366.26f, 434.82f);
        f1650t.cubicTo(391.39f, 421.53f, 412.63f, 401.91f, 427.9f, 378.08f);
        f1650t.transform(f1648m);
        if (clearMode) {
            f1649p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1650t, ps);
        } else {
            c.drawPath(f1650t, f1649p);
            c.drawPath(f1650t, ps);
        }
        c.restore();
        m1587r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1587r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1649p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1587r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1649p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1587r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1587r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1587r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1587r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1587r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1587r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1587r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1587r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1587r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1587r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1587r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1587r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1587r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1587r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1587r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1587r(new Integer[0]);
        c.restore();
    }

    private static void m1587r(Integer... o) {
        f1649p.reset();
        ps.reset();
        if (cf != null) {
            f1649p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1649p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1649p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1649p.setColor(Color.parseColor("#000000"));
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
