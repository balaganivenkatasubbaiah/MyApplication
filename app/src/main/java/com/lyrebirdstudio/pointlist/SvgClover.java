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

public class SvgClover extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1393m = new Matrix();
    private static float od;
    private static final Paint f1394p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1395t = new Path();

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
        od = w / 477.0f < h / 477.0f ? w / 477.0f : h / 477.0f;
        m1502r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 477.0f)) / 2.0f) + dx, ((h - (od * 477.0f)) / 2.0f) + dy);
        f1393m.reset();
        f1393m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(1.0f, 1.0f);
        c.save();
        c.save();
        c.save();
        f1395t.reset();
        f1395t.moveTo(238.42f, 165.79f);
        f1395t.cubicTo(238.42f, 165.79f, 292.54f, 81.19f, 256.83f, 22.75f);
        f1395t.cubicTo(243.15f, 0.36f, 213.9f, -6.71f, 191.5f, 6.98f);
        f1395t.cubicTo(175.46f, 16.78f, 167.28f, 34.58f, 168.97f, 52.12f);
        f1395t.cubicTo(154.14f, 42.61f, 134.57f, 41.76f, 118.52f, 51.56f);
        f1395t.cubicTo(96.13f, 65.25f, 89.06f, 94.49f, 102.75f, 116.89f);
        f1395t.cubicTo(138.45f, 175.33f, 238.42f, 165.79f, 238.42f, 165.79f);
        f1395t.transform(f1393m);
        c.drawPath(f1395t, f1394p);
        c.drawPath(f1395t, ps);
        c.restore();
        m1502r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        f1395t.reset();
        f1395t.moveTo(260.8f, 202.42f);
        f1395t.cubicTo(260.8f, 202.42f, 206.69f, 287.02f, 242.39f, 345.46f);
        f1395t.cubicTo(256.07f, 367.86f, 285.32f, 374.92f, 307.72f, 361.24f);
        f1395t.cubicTo(323.77f, 351.43f, 331.94f, 333.64f, 330.25f, 316.1f);
        f1395t.cubicTo(345.09f, 325.61f, 364.65f, 326.45f, 380.7f, 316.65f);
        f1395t.cubicTo(403.09f, 302.97f, 410.16f, 273.72f, 396.48f, 251.33f);
        f1395t.cubicTo(360.77f, 192.88f, 260.8f, 202.42f, 260.8f, 202.42f);
        f1395t.transform(f1393m);
        c.drawPath(f1395t, f1394p);
        c.drawPath(f1395t, ps);
        c.restore();
        m1502r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        f1395t.reset();
        f1395t.moveTo(426.74f, 126.0f);
        f1395t.cubicTo(416.94f, 109.95f, 399.14f, 101.78f, 381.6f, 103.47f);
        f1395t.cubicTo(391.11f, 88.63f, 391.96f, 69.07f, 382.16f, 53.02f);
        f1395t.cubicTo(368.47f, 30.62f, 339.23f, 23.56f, 316.83f, 37.24f);
        f1395t.cubicTo(258.39f, 72.95f, 267.93f, 172.92f, 267.93f, 172.92f);
        f1395t.cubicTo(267.93f, 172.92f, 352.53f, 227.03f, 410.97f, 191.33f);
        f1395t.cubicTo(433.36f, 177.65f, 440.43f, 148.4f, 426.74f, 126.0f);
        f1395t.transform(f1393m);
        c.drawPath(f1395t, f1394p);
        c.drawPath(f1395t, ps);
        c.restore();
        m1502r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        f1395t.reset();
        f1395t.moveTo(117.62f, 264.75f);
        f1395t.cubicTo(108.11f, 279.58f, 107.26f, 299.15f, 117.07f, 315.19f);
        f1395t.cubicTo(130.75f, 337.59f, 160.0f, 344.65f, 182.39f, 330.97f);
        f1395t.cubicTo(240.84f, 295.27f, 231.3f, 195.3f, 231.3f, 195.3f);
        f1395t.cubicTo(231.3f, 195.3f, 146.7f, 141.18f, 88.26f, 176.89f);
        f1395t.cubicTo(65.86f, 190.57f, 58.8f, 219.82f, 72.48f, 242.21f);
        f1395t.cubicTo(82.29f, 258.26f, 100.08f, 266.44f, 117.62f, 264.75f);
        f1395t.transform(f1393m);
        c.drawPath(f1395t, f1394p);
        c.drawPath(f1395t, ps);
        c.restore();
        m1502r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        f1395t.reset();
        f1395t.moveTo(216.7f, 316.86f);
        f1395t.cubicTo(216.05f, 318.31f, 215.38f, 319.94f, 214.56f, 321.67f);
        f1395t.cubicTo(213.71f, 323.38f, 212.86f, 325.25f, 211.79f, 327.18f);
        f1395t.cubicTo(209.76f, 331.07f, 207.22f, 335.32f, 204.19f, 339.74f);
        f1395t.cubicTo(201.17f, 344.17f, 197.65f, 348.76f, 193.65f, 353.34f);
        f1395t.cubicTo(189.65f, 357.92f, 185.17f, 362.49f, 180.29f, 366.93f);
        f1395t.cubicTo(175.41f, 371.37f, 170.13f, 375.67f, 164.57f, 379.77f);
        f1395t.cubicTo(159.01f, 383.85f, 153.16f, 387.72f, 147.17f, 391.35f);
        f1395t.cubicTo(135.2f, 398.6f, 122.62f, 404.82f, 110.57f, 409.97f);
        f1395t.cubicTo(98.52f, 415.12f, 86.98f, 419.21f, 77.03f, 422.33f);
        f1395t.cubicTo(67.07f, 425.46f, 58.7f, 427.63f, 52.91f, 428.98f);
        f1395t.cubicTo(50.02f, 429.66f, 47.78f, 430.13f, 46.3f, 430.42f);
        f1395t.cubicTo(45.59f, 430.55f, 45.05f, 430.66f, 44.68f, 430.72f);
        f1395t.cubicTo(44.49f, 430.76f, 44.43f, 430.76f, 44.38f, 430.76f);
        f1395t.cubicTo(44.33f, 430.77f, 44.23f, 430.79f, 44.24f, 430.78f);
        f1395t.lineTo(58.44f, 477.96f);
        f1395t.cubicTo(58.44f, 477.96f, 58.73f, 477.85f, 59.28f, 477.63f);
        f1395t.cubicTo(59.76f, 477.43f, 60.46f, 477.13f, 61.39f, 476.74f);
        f1395t.cubicTo(63.16f, 475.97f, 65.67f, 474.85f, 68.79f, 473.38f);
        f1395t.cubicTo(75.03f, 470.43f, 83.71f, 466.08f, 93.79f, 460.37f);
        f1395t.cubicTo(103.87f, 454.67f, 115.36f, 447.61f, 127.13f, 439.29f);
        f1395t.cubicTo(138.91f, 430.99f, 150.98f, 421.42f, 162.16f, 410.89f);
        f1395t.cubicTo(167.75f, 405.63f, 173.13f, 400.15f, 178.14f, 394.51f);
        f1395t.cubicTo(183.15f, 388.86f, 187.79f, 383.07f, 191.97f, 377.25f);
        f1395t.cubicTo(196.15f, 371.43f, 199.85f, 365.58f, 203.02f, 359.87f);
        f1395t.cubicTo(206.2f, 354.17f, 208.84f, 348.6f, 210.98f, 343.37f);
        f1395t.cubicTo(213.13f, 338.14f, 214.79f, 333.25f, 216.01f, 328.87f);
        f1395t.cubicTo(216.67f, 326.7f, 217.13f, 324.61f, 217.61f, 322.72f);
        f1395t.cubicTo(218.06f, 320.81f, 218.39f, 319.04f, 218.72f, 317.47f);
        f1395t.cubicTo(219.29f, 314.27f, 219.69f, 311.78f, 219.88f, 310.06f);
        f1395t.cubicTo(220.09f, 308.35f, 220.21f, 307.44f, 220.21f, 307.44f);
        f1395t.cubicTo(220.21f, 307.44f, 219.9f, 308.31f, 219.34f, 309.94f);
        f1395t.cubicTo(218.81f, 311.56f, 217.89f, 313.91f, 216.7f, 316.86f);
        f1395t.transform(f1393m);
        c.drawPath(f1395t, f1394p);
        c.drawPath(f1395t, ps);
        c.restore();
        m1502r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.restore();
        m1502r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.restore();
        m1502r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1502r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1502r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1502r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1502r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1502r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1502r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1502r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1502r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1502r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1502r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1502r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1502r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1502r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1502r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.save();
        c.restore();
        m1502r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        c.restore();
        m1502r(new Integer[0]);
        c.restore();
    }

    private static void m1502r(Integer... o) {
        f1394p.reset();
        ps.reset();
        if (cf != null) {
            f1394p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1394p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1394p.setStyle(Style.FILL);
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
