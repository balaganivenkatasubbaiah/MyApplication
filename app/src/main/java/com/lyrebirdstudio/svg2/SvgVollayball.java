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
public class SvgVollayball extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1744m = new Matrix();
    private static float od;
    private static final Paint f1745p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1746t = new Path();

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
        m1619r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1744m.reset();
        f1744m.setScale(od * 1.22f, od * 1.22f);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.save();
        c.save();
        c.save();
        f1745p.setColor(Color.parseColor("#000000"));
        f1746t.reset();
        f1746t.moveTo(54.73f, 134.58f);
        f1746t.lineTo(55.13f, 137.52f);
        f1746t.cubicTo(61.08f, 145.31f, 74.52f, 160.79f, 97.61f, 176.85f);
        f1746t.lineTo(102.11f, 175.5f);
        f1746t.cubicTo(109.81f, 156.23f, 123.58f, 128.08f, 135.0f, 111.55f);
        f1746t.lineTo(135.06f, 111.46f);
        f1746t.cubicTo(177.93f, 44.35f, 232.95f, 22.33f, 271.55f, 15.66f);
        f1746t.lineTo(271.98f, 9.86f);
        f1746t.cubicTo(258.12f, 5.31f, 244.09f, 2.42f, 229.09f, 1.02f);
        f1746t.cubicTo(223.12f, 0.46f, 217.71f, 0.0f, 212.03f, 0.0f);
        f1746t.cubicTo(204.49f, 0.0f, 197.19f, 0.85f, 189.04f, 2.66f);
        f1746t.cubicTo(163.79f, 8.29f, 139.98f, 22.49f, 114.13f, 47.34f);
        f1746t.cubicTo(86.81f, 73.61f, 67.44f, 102.01f, 54.88f, 134.2f);
        f1746t.lineTo(54.73f, 134.58f);
        f1746t.transform(f1744m);
        if (clearMode) {
            f1745p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1746t, ps);
        } else {
            c.drawPath(f1746t, f1745p);
            c.drawPath(f1746t, ps);
        }
        c.restore();
        m1619r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1745p.setColor(Color.parseColor("#000000"));
        c.save();
        f1746t.reset();
        f1746t.moveTo(100.93f, 291.18f);
        f1746t.cubicTo(125.69f, 299.73f, 152.19f, 304.06f, 179.69f, 304.06f);
        f1746t.lineTo(179.69f, 304.06f);
        f1746t.cubicTo(189.62f, 304.06f, 199.89f, 303.5f, 210.22f, 302.38f);
        f1746t.cubicTo(217.54f, 301.6f, 224.76f, 300.38f, 232.41f, 299.09f);
        f1746t.lineTo(234.12f, 298.8f);
        f1746t.lineTo(236.58f, 295.35f);
        f1746t.cubicTo(231.88f, 267.16f, 220.91f, 241.07f, 205.69f, 221.88f);
        f1746t.lineTo(202.76f, 220.8f);
        f1746t.cubicTo(201.88f, 220.97f, 200.99f, 221.15f, 200.22f, 221.29f);
        f1746t.cubicTo(184.15f, 224.34f, 168.05f, 224.59f, 152.65f, 222.03f);
        f1746t.cubicTo(103.84f, 213.89f, 64.09f, 188.15f, 34.51f, 145.52f);
        f1746t.cubicTo(30.46f, 139.67f, 26.96f, 133.53f, 24.07f, 128.28f);
        f1746t.lineTo(18.64f, 128.66f);
        f1746t.cubicTo(7.32f, 158.11f, 2.22f, 191.64f, 2.01f, 203.04f);
        f1746t.lineTo(2.48f, 204.7f);
        f1746t.cubicTo(6.33f, 210.77f, 16.01f, 225.83f, 22.68f, 234.67f);
        f1746t.cubicTo(42.67f, 261.15f, 69.0f, 280.17f, 100.93f, 291.18f);
        f1746t.transform(f1744m);
        if (clearMode) {
            f1745p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1746t, ps);
        } else {
            c.drawPath(f1746t, f1745p);
            c.drawPath(f1746t, ps);
        }
        c.restore();
        m1619r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1746t.reset();
        f1746t.moveTo(43.46f, 112.19f);
        f1746t.cubicTo(55.15f, 88.16f, 69.47f, 66.59f, 86.02f, 48.1f);
        f1746t.lineTo(81.95f, 43.73f);
        f1746t.cubicTo(64.95f, 56.81f, 49.9f, 72.79f, 37.22f, 91.21f);
        f1746t.cubicTo(36.0f, 92.97f, 33.89f, 96.44f, 32.33f, 99.05f);
        f1746t.lineTo(32.27f, 102.04f);
        f1746t.cubicTo(34.17f, 105.46f, 36.15f, 108.94f, 38.17f, 112.39f);
        f1746t.lineTo(43.46f, 112.19f);
        f1746t.transform(f1744m);
        if (clearMode) {
            f1745p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1746t, ps);
        } else {
            c.drawPath(f1746t, f1745p);
            c.drawPath(f1746t, ps);
        }
        c.restore();
        m1619r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1746t.reset();
        f1746t.moveTo(128.48f, 163.8f);
        f1746t.cubicTo(125.53f, 170.55f, 123.01f, 177.42f, 120.33f, 184.69f);
        f1746t.lineTo(119.73f, 186.33f);
        f1746t.lineTo(121.5f, 190.18f);
        f1746t.cubicTo(141.11f, 197.45f, 161.58f, 201.29f, 180.69f, 201.29f);
        f1746t.cubicTo(187.55f, 201.29f, 194.26f, 200.8f, 200.62f, 199.84f);
        f1746t.lineTo(203.01f, 197.83f);
        f1746t.cubicTo(203.3f, 196.97f, 203.59f, 196.12f, 203.84f, 195.37f);
        f1746t.cubicTo(209.19f, 179.87f, 216.92f, 165.85f, 226.82f, 153.72f);
        f1746t.cubicTo(258.12f, 115.39f, 300.19f, 93.66f, 351.88f, 89.15f);
        f1746t.cubicTo(356.24f, 88.77f, 360.87f, 88.59f, 366.46f, 88.59f);
        f1746t.cubicTo(368.31f, 88.59f, 370.17f, 88.61f, 372.03f, 88.64f);
        f1746t.lineTo(374.4f, 83.74f);
        f1746t.cubicTo(354.46f, 59.29f, 327.88f, 38.22f, 318.08f, 32.38f);
        f1746t.lineTo(316.41f, 31.96f);
        f1746t.cubicTo(309.22f, 32.29f, 291.33f, 33.22f, 280.37f, 34.62f);
        f1746t.cubicTo(247.46f, 38.82f, 217.88f, 52.23f, 192.47f, 74.48f);
        f1746t.cubicTo(165.68f, 97.94f, 144.15f, 127.99f, 128.48f, 163.8f);
        f1746t.transform(f1744m);
        if (clearMode) {
            f1745p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1746t, ps);
        } else {
            c.drawPath(f1746t, f1745p);
            c.drawPath(f1746t, ps);
        }
        c.restore();
        m1619r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1746t.reset();
        f1746t.moveTo(397.22f, 117.73f);
        f1746t.cubicTo(396.3f, 115.79f, 394.35f, 112.23f, 392.87f, 109.57f);
        f1746t.lineTo(390.3f, 108.03f);
        f1746t.cubicTo(386.41f, 107.96f, 382.35f, 107.94f, 378.39f, 107.97f);
        f1746t.lineTo(375.92f, 112.65f);
        f1746t.cubicTo(390.9f, 134.78f, 402.42f, 157.96f, 410.17f, 181.54f);
        f1746t.lineTo(413.03f, 180.88f);
        f1746t.lineTo(413.04f, 183.6f);
        f1746t.lineTo(413.04f, 180.88f);
        f1746t.lineTo(415.99f, 180.2f);
        f1746t.cubicTo(413.15f, 158.94f, 406.83f, 137.92f, 397.22f, 117.73f);
        f1746t.transform(f1744m);
        if (clearMode) {
            f1745p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1746t, ps);
        } else {
            c.drawPath(f1746t, f1745p);
            c.drawPath(f1746t, ps);
        }
        c.restore();
        m1619r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1746t.reset();
        f1746t.moveTo(187.3f, 402.49f);
        f1746t.cubicTo(167.95f, 402.49f, 148.95f, 400.53f, 130.84f, 396.67f);
        f1746t.lineTo(129.06f, 402.37f);
        f1746t.cubicTo(148.87f, 410.64f, 170.22f, 415.78f, 192.52f, 417.65f);
        f1746t.cubicTo(194.64f, 417.83f, 198.71f, 417.94f, 201.75f, 418.0f);
        f1746t.lineTo(204.38f, 416.56f);
        f1746t.cubicTo(205.76f, 414.28f, 207.94f, 410.64f, 210.44f, 406.29f);
        f1746t.lineTo(207.64f, 401.8f);
        f1746t.cubicTo(200.79f, 402.25f, 193.95f, 402.49f, 187.3f, 402.49f);
        f1746t.transform(f1744m);
        if (clearMode) {
            f1745p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1746t, ps);
        } else {
            c.drawPath(f1746t, f1745p);
            c.drawPath(f1746t, ps);
        }
        c.restore();
        m1619r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1746t.reset();
        f1746t.moveTo(351.18f, 111.58f);
        f1746t.lineTo(350.88f, 111.21f);
        f1746t.lineTo(348.15f, 110.1f);
        f1746t.cubicTo(338.42f, 111.36f, 318.3f, 115.27f, 292.86f, 127.25f);
        f1746t.lineTo(291.78f, 131.82f);
        f1746t.cubicTo(304.62f, 148.12f, 322.12f, 174.12f, 330.74f, 192.27f);
        f1746t.lineTo(330.78f, 192.37f);
        f1746t.cubicTo(354.3f, 237.64f, 362.15f, 283.04f, 354.12f, 327.31f);
        f1746t.cubicTo(352.18f, 337.97f, 349.34f, 348.42f, 345.66f, 358.37f);
        f1746t.lineTo(350.47f, 361.64f);
        f1746t.cubicTo(361.3f, 351.93f, 370.78f, 341.25f, 379.46f, 329.0f);
        f1746t.cubicTo(387.54f, 317.59f, 393.2f, 308.96f, 398.05f, 293.48f);
        f1746t.cubicTo(405.79f, 268.79f, 405.39f, 241.08f, 396.78f, 206.27f);
        f1746t.cubicTo(387.67f, 169.48f, 372.76f, 138.51f, 351.18f, 111.58f);
        f1746t.transform(f1744m);
        if (clearMode) {
            f1745p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1746t, ps);
        } else {
            c.drawPath(f1746t, f1745p);
            c.drawPath(f1746t, ps);
        }
        c.restore();
        m1619r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1746t.reset();
        f1746t.moveTo(288.73f, 160.51f);
        f1746t.cubicTo(284.37f, 154.59f, 279.68f, 148.97f, 274.7f, 143.01f);
        f1746t.lineTo(273.6f, 141.68f);
        f1746t.lineTo(269.37f, 141.29f);
        f1746t.cubicTo(247.39f, 159.56f, 230.39f, 182.18f, 221.48f, 204.99f);
        f1746t.lineTo(222.02f, 208.06f);
        f1746t.cubicTo(222.62f, 208.74f, 223.21f, 209.42f, 223.73f, 210.01f);
        f1746t.cubicTo(234.49f, 222.39f, 242.77f, 236.09f, 248.33f, 250.73f);
        f1746t.cubicTo(265.9f, 296.99f, 263.69f, 344.3f, 241.77f, 391.33f);
        f1746t.cubicTo(238.76f, 397.78f, 235.21f, 403.89f, 232.14f, 409.03f);
        f1746t.lineTo(235.2f, 413.53f);
        f1746t.cubicTo(266.35f, 408.47f, 297.88f, 395.98f, 307.83f, 390.42f);
        f1746t.lineTo(309.03f, 389.17f);
        f1746t.cubicTo(312.33f, 382.79f, 320.47f, 366.84f, 324.74f, 356.63f);
        f1746t.cubicTo(337.54f, 326.02f, 340.7f, 293.7f, 334.13f, 260.57f);
        f1746t.cubicTo(327.19f, 225.64f, 311.92f, 191.97f, 288.73f, 160.51f);
        f1746t.transform(f1744m);
        if (clearMode) {
            f1745p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1746t, ps);
        } else {
            c.drawPath(f1746t, f1745p);
            c.drawPath(f1746t, ps);
        }
        c.restore();
        m1619r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        f1746t.reset();
        f1746t.moveTo(233.47f, 319.48f);
        f1746t.cubicTo(216.78f, 321.83f, 195.85f, 323.3f, 178.84f, 323.3f);
        f1746t.cubicTo(172.34f, 323.3f, 166.55f, 323.08f, 161.63f, 322.66f);
        f1746t.lineTo(161.52f, 322.65f);
        f1746t.cubicTo(110.56f, 320.16f, 67.38f, 304.06f, 33.19f, 274.81f);
        f1746t.cubicTo(24.97f, 267.78f, 17.38f, 260.05f, 10.64f, 251.86f);
        f1746t.lineTo(5.38f, 254.37f);
        f1746t.cubicTo(8.31f, 268.61f, 12.76f, 282.18f, 18.97f, 295.86f);
        f1746t.cubicTo(24.76f, 308.59f, 29.36f, 317.82f, 40.28f, 329.81f);
        f1746t.cubicTo(57.71f, 348.94f, 81.85f, 362.55f, 116.26f, 372.65f);
        f1746t.cubicTo(140.61f, 379.8f, 164.71f, 383.42f, 187.88f, 383.42f);
        f1746t.cubicTo(198.95f, 383.42f, 210.1f, 382.6f, 221.02f, 380.98f);
        f1746t.lineTo(221.48f, 380.91f);
        f1746t.lineTo(223.83f, 379.11f);
        f1746t.cubicTo(227.64f, 370.07f, 234.4f, 350.73f, 236.87f, 322.71f);
        f1746t.lineTo(233.47f, 319.48f);
        f1746t.transform(f1744m);
        if (clearMode) {
            f1745p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1746t, ps);
        } else {
            c.drawPath(f1746t, f1745p);
            c.drawPath(f1746t, ps);
        }
        c.restore();
        m1619r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1619r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1745p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1619r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1745p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1619r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1619r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1619r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1619r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1619r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1619r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1619r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1619r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1619r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1619r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1619r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1619r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1619r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1619r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1619r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1619r(new Integer[0]);
        c.restore();
    }

    private static void m1619r(Integer... o) {
        f1745p.reset();
        ps.reset();
        if (cf != null) {
            f1745p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1745p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1745p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1745p.setColor(Color.parseColor("#000000"));
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
