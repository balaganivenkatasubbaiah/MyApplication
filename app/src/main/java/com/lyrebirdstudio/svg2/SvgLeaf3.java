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
public class SvgLeaf3 extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1711m = new Matrix();
    private static float od;
    private static final Paint f1712p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1713t = new Path();

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
        m1608r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1711m.reset();
        f1711m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(1.16f, 1.16f);
        c.save();
        f1712p.setColor(Color.parseColor("#000000"));
        f1713t.reset();
        f1713t.moveTo(434.57f, 164.07f);
        f1713t.cubicTo(431.74f, 163.4f, 428.11f, 162.8f, 423.94f, 162.11f);
        f1713t.cubicTo(415.5f, 160.72f, 405.0f, 158.99f, 396.89f, 155.98f);
        f1713t.cubicTo(390.4f, 153.57f, 387.49f, 151.05f, 387.49f, 149.62f);
        f1713t.cubicTo(387.49f, 146.26f, 385.78f, 143.13f, 382.96f, 141.3f);
        f1713t.cubicTo(380.14f, 139.48f, 376.58f, 139.2f, 373.51f, 140.57f);
        f1713t.cubicTo(369.08f, 142.56f, 364.63f, 143.6f, 360.64f, 143.61f);
        f1713t.cubicTo(351.95f, 143.61f, 348.91f, 138.7f, 347.38f, 135.01f);
        f1713t.cubicTo(345.43f, 130.32f, 340.26f, 127.85f, 335.39f, 129.3f);
        f1713t.cubicTo(327.97f, 131.49f, 320.0f, 136.02f, 312.29f, 140.4f);
        f1713t.cubicTo(304.32f, 144.93f, 294.4f, 150.57f, 289.29f, 150.57f);
        f1713t.cubicTo(288.77f, 150.57f, 288.5f, 150.5f, 288.46f, 150.48f);
        f1713t.cubicTo(288.46f, 150.47f, 288.33f, 150.39f, 288.12f, 150.09f);
        f1713t.cubicTo(285.04f, 145.68f, 286.54f, 137.83f, 289.25f, 125.39f);
        f1713t.cubicTo(290.19f, 121.08f, 291.26f, 116.18f, 292.13f, 111.01f);
        f1713t.cubicTo(292.57f, 108.37f, 291.93f, 105.67f, 290.36f, 103.51f);
        f1713t.cubicTo(288.78f, 101.35f, 286.4f, 99.92f, 283.76f, 99.54f);
        f1713t.cubicTo(275.14f, 98.29f, 269.23f, 95.24f, 266.21f, 90.47f);
        f1713t.cubicTo(261.14f, 82.46f, 264.53f, 71.11f, 264.55f, 71.06f);
        f1713t.cubicTo(265.65f, 67.62f, 264.8f, 63.84f, 262.32f, 61.21f);
        f1713t.cubicTo(259.84f, 58.58f, 256.12f, 57.51f, 252.62f, 58.41f);
        f1713t.cubicTo(252.05f, 58.56f, 251.51f, 58.63f, 251.03f, 58.63f);
        f1713t.cubicTo(242.73f, 58.63f, 233.67f, 33.9f, 231.12f, 11.78f);
        f1713t.cubicTo(230.55f, 6.77f, 226.31f, 2.99f, 221.26f, 2.98f);
        f1713t.cubicTo(221.26f, 2.98f, 221.26f, 2.98f, 221.26f, 2.98f);
        f1713t.cubicTo(216.21f, 2.98f, 211.97f, 6.77f, 211.39f, 11.78f);
        f1713t.cubicTo(208.84f, 33.89f, 199.78f, 58.63f, 191.48f, 58.63f);
        f1713t.cubicTo(191.0f, 58.63f, 190.46f, 58.56f, 189.89f, 58.41f);
        f1713t.cubicTo(186.39f, 57.51f, 182.68f, 58.58f, 180.2f, 61.21f);
        f1713t.cubicTo(177.72f, 63.84f, 176.86f, 67.62f, 177.97f, 71.06f);
        f1713t.cubicTo(178.0f, 71.17f, 181.3f, 82.48f, 176.35f, 90.39f);
        f1713t.cubicTo(173.35f, 95.21f, 167.42f, 98.29f, 158.76f, 99.54f);
        f1713t.cubicTo(156.11f, 99.92f, 153.73f, 101.35f, 152.16f, 103.51f);
        f1713t.cubicTo(150.58f, 105.67f, 149.95f, 108.37f, 150.39f, 111.01f);
        f1713t.cubicTo(151.26f, 116.18f, 152.32f, 121.08f, 153.26f, 125.39f);
        f1713t.cubicTo(155.97f, 137.83f, 157.47f, 145.68f, 154.39f, 150.09f);
        f1713t.cubicTo(154.21f, 150.34f, 154.09f, 150.46f, 154.06f, 150.47f);
        f1713t.cubicTo(154.01f, 150.5f, 153.74f, 150.57f, 153.22f, 150.57f);
        f1713t.cubicTo(148.11f, 150.57f, 138.19f, 144.93f, 130.22f, 140.4f);
        f1713t.cubicTo(122.51f, 136.02f, 114.55f, 131.49f, 107.12f, 129.29f);
        f1713t.cubicTo(102.25f, 127.85f, 97.08f, 130.32f, 95.14f, 135.01f);
        f1713t.cubicTo(93.6f, 138.7f, 90.56f, 143.6f, 81.88f, 143.6f);
        f1713t.cubicTo(77.89f, 143.6f, 73.44f, 142.55f, 69.0f, 140.57f);
        f1713t.cubicTo(65.93f, 139.2f, 62.38f, 139.47f, 59.55f, 141.3f);
        f1713t.cubicTo(56.73f, 143.13f, 55.03f, 146.26f, 55.02f, 149.62f);
        f1713t.cubicTo(55.02f, 151.05f, 52.11f, 153.57f, 45.63f, 155.98f);
        f1713t.cubicTo(37.51f, 158.99f, 27.01f, 160.72f, 18.57f, 162.11f);
        f1713t.cubicTo(14.21f, 162.83f, 10.45f, 163.45f, 7.56f, 164.15f);
        f1713t.cubicTo(2.59f, 165.37f, -0.64f, 170.17f, 0.11f, 175.24f);
        f1713t.cubicTo(0.85f, 180.3f, 5.32f, 183.97f, 10.43f, 183.71f);
        f1713t.cubicTo(10.75f, 183.7f, 11.11f, 183.69f, 11.5f, 183.69f);
        f1713t.cubicTo(25.03f, 183.69f, 42.22f, 189.26f, 43.89f, 193.08f);
        f1713t.cubicTo(43.86f, 193.27f, 43.72f, 193.78f, 43.29f, 194.55f);
        f1713t.cubicTo(41.57f, 197.61f, 41.6f, 201.35f, 43.36f, 204.39f);
        f1713t.cubicTo(45.12f, 207.42f, 48.35f, 209.3f, 51.86f, 209.33f);
        f1713t.cubicTo(62.17f, 209.43f, 65.36f, 211.75f, 65.65f, 212.36f);
        f1713t.cubicTo(66.63f, 214.44f, 63.32f, 221.98f, 59.23f, 227.01f);
        f1713t.cubicTo(56.98f, 229.74f, 56.36f, 233.47f, 57.59f, 236.78f);
        f1713t.cubicTo(58.83f, 240.1f, 61.74f, 242.51f, 65.23f, 243.11f);
        f1713t.cubicTo(77.76f, 245.25f, 91.55f, 250.65f, 93.84f, 254.24f);
        f1713t.cubicTo(93.24f, 255.49f, 89.91f, 260.59f, 73.16f, 268.71f);
        f1713t.cubicTo(70.55f, 269.97f, 68.63f, 272.31f, 67.89f, 275.1f);
        f1713t.cubicTo(67.15f, 277.9f, 67.67f, 280.88f, 69.31f, 283.27f);
        f1713t.cubicTo(74.73f, 291.15f, 56.11f, 307.55f, 47.17f, 315.43f);
        f1713t.cubicTo(43.8f, 318.39f, 40.9f, 320.95f, 38.8f, 323.19f);
        f1713t.cubicTo(35.35f, 326.87f, 35.21f, 332.54f, 38.45f, 336.38f);
        f1713t.cubicTo(41.7f, 340.23f, 47.31f, 341.04f, 51.51f, 338.27f);
        f1713t.cubicTo(55.91f, 335.36f, 69.74f, 329.94f, 80.49f, 329.94f);
        f1713t.cubicTo(90.06f, 329.94f, 90.68f, 333.78f, 91.08f, 336.31f);
        f1713t.cubicTo(91.59f, 339.52f, 93.64f, 342.27f, 96.56f, 343.69f);
        f1713t.cubicTo(99.48f, 345.1f, 102.91f, 345.0f, 105.74f, 343.41f);
        f1713t.cubicTo(113.28f, 339.18f, 118.06f, 338.3f, 120.75f, 338.3f);
        f1713t.cubicTo(129.59f, 338.3f, 130.72f, 350.89f, 130.82f, 352.27f);
        f1713t.cubicTo(130.97f, 355.04f, 132.29f, 357.62f, 134.43f, 359.38f);
        f1713t.cubicTo(136.58f, 361.14f, 139.37f, 361.93f, 142.12f, 361.54f);
        f1713t.cubicTo(167.43f, 357.96f, 182.16f, 343.76f, 194.0f, 332.36f);
        f1713t.cubicTo(203.44f, 323.27f, 209.66f, 317.63f, 217.63f, 316.33f);
        f1713t.cubicTo(217.38f, 317.99f, 217.13f, 319.65f, 216.85f, 321.3f);
        f1713t.cubicTo(214.06f, 338.24f, 209.52f, 354.77f, 203.31f, 370.77f);
        f1713t.cubicTo(197.75f, 384.08f, 191.12f, 396.93f, 182.01f, 408.18f);
        f1713t.cubicTo(175.63f, 416.08f, 167.96f, 425.92f, 177.99f, 435.08f);
        f1713t.cubicTo(199.97f, 455.16f, 216.43f, 401.71f, 220.14f, 388.87f);
        f1713t.cubicTo(226.75f, 366.02f, 229.73f, 341.49f, 229.11f, 317.49f);
        f1713t.cubicTo(235.23f, 319.82f, 240.8f, 324.93f, 248.51f, 332.36f);
        f1713t.cubicTo(260.35f, 343.76f, 275.09f, 357.96f, 300.4f, 361.54f);
        f1713t.cubicTo(300.86f, 361.6f, 301.32f, 361.64f, 301.79f, 361.64f);
        f1713t.cubicTo(304.07f, 361.64f, 306.29f, 360.85f, 308.08f, 359.39f);
        f1713t.cubicTo(310.23f, 357.62f, 311.54f, 355.04f, 311.7f, 352.27f);
        f1713t.cubicTo(311.7f, 352.13f, 312.6f, 338.3f, 321.77f, 338.3f);
        f1713t.cubicTo(324.45f, 338.3f, 329.24f, 339.19f, 336.78f, 343.41f);
        f1713t.cubicTo(339.61f, 345.0f, 343.03f, 345.1f, 345.96f, 343.69f);
        f1713t.cubicTo(348.88f, 342.27f, 350.92f, 339.52f, 351.44f, 336.32f);
        f1713t.cubicTo(351.84f, 333.78f, 352.45f, 329.94f, 362.02f, 329.94f);
        f1713t.cubicTo(372.77f, 329.94f, 386.6f, 335.36f, 391.01f, 338.27f);
        f1713t.cubicTo(395.21f, 341.05f, 400.82f, 340.24f, 404.06f, 336.39f);
        f1713t.cubicTo(407.31f, 332.54f, 407.16f, 326.87f, 403.72f, 323.2f);
        f1713t.cubicTo(401.62f, 320.96f, 398.71f, 318.4f, 395.35f, 315.44f);
        f1713t.cubicTo(386.41f, 307.56f, 367.79f, 291.15f, 373.21f, 283.27f);
        f1713t.cubicTo(374.85f, 280.88f, 375.36f, 277.9f, 374.62f, 275.11f);
        f1713t.cubicTo(373.88f, 272.31f, 371.96f, 269.97f, 369.36f, 268.71f);
        f1713t.cubicTo(352.61f, 260.59f, 349.28f, 255.49f, 348.68f, 254.24f);
        f1713t.cubicTo(350.96f, 250.66f, 364.75f, 245.26f, 377.28f, 243.12f);
        f1713t.cubicTo(380.77f, 242.52f, 383.69f, 240.12f, 384.92f, 236.8f);
        f1713t.cubicTo(386.16f, 233.48f, 385.54f, 229.75f, 383.29f, 227.01f);
        f1713t.cubicTo(379.25f, 222.12f, 375.89f, 214.45f, 376.86f, 212.37f);
        f1713t.cubicTo(377.15f, 211.75f, 380.34f, 209.43f, 390.66f, 209.34f);
        f1713t.cubicTo(394.17f, 209.31f, 397.4f, 207.42f, 399.16f, 204.39f);
        f1713t.cubicTo(400.92f, 201.36f, 400.95f, 197.62f, 399.23f, 194.56f);
        f1713t.cubicTo(398.8f, 193.78f, 398.65f, 193.28f, 398.63f, 193.08f);
        f1713t.cubicTo(400.29f, 189.26f, 417.49f, 183.69f, 431.01f, 183.69f);
        f1713t.cubicTo(431.4f, 183.69f, 431.76f, 183.7f, 432.08f, 183.72f);
        f1713t.cubicTo(432.3f, 183.73f, 432.51f, 183.73f, 432.72f, 183.73f);
        f1713t.cubicTo(438.15f, 183.67f, 442.53f, 179.25f, 442.53f, 173.8f);
        f1713t.cubicTo(442.53f, 168.99f, 439.11f, 164.98f, 434.57f, 164.07f);
        f1713t.moveTo(149.64f, 282.85f);
        f1713t.cubicTo(129.59f, 289.42f, 110.06f, 298.09f, 89.83f, 304.04f);
        f1713t.cubicTo(117.85f, 271.31f, 173.49f, 251.84f, 215.91f, 260.86f);
        f1713t.cubicTo(194.18f, 269.11f, 171.73f, 275.6f, 149.64f, 282.85f);
        f1713t.moveTo(149.74f, 212.99f);
        f1713t.cubicTo(124.51f, 197.4f, 98.14f, 186.32f, 69.98f, 177.34f);
        f1713t.cubicTo(126.58f, 169.61f, 191.5f, 211.93f, 217.75f, 260.86f);
        f1713t.cubicTo(195.47f, 244.35f, 173.35f, 227.57f, 149.74f, 212.99f);
        f1713t.moveTo(212.94f, 166.62f);
        f1713t.cubicTo(212.22f, 130.79f, 212.82f, 94.08f, 218.86f, 58.67f);
        f1713t.cubicTo(225.73f, 92.91f, 227.14f, 128.31f, 227.87f, 163.13f);
        f1713t.cubicTo(228.15f, 197.97f, 227.8f, 233.39f, 221.88f, 267.81f);
        f1713t.cubicTo(215.19f, 234.66f, 213.62f, 200.34f, 212.94f, 166.62f);
        f1713t.moveTo(353.29f, 304.04f);
        f1713t.cubicTo(333.07f, 298.09f, 313.53f, 289.42f, 293.48f, 282.85f);
        f1713t.cubicTo(271.4f, 275.6f, 248.95f, 269.11f, 227.21f, 260.86f);
        f1713t.cubicTo(269.64f, 251.84f, 325.27f, 271.31f, 353.29f, 304.04f);
        f1713t.moveTo(295.03f, 211.62f);
        f1713t.cubicTo(270.39f, 226.09f, 247.69f, 243.87f, 224.77f, 260.86f);
        f1713t.cubicTo(251.02f, 211.92f, 315.93f, 169.61f, 372.54f, 177.34f);
        f1713t.cubicTo(345.14f, 186.07f, 319.79f, 196.87f, 295.03f, 211.62f);
        f1713t.transform(f1711m);
        if (clearMode) {
            f1712p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1713t, ps);
        } else {
            c.drawPath(f1713t, f1712p);
            c.drawPath(f1713t, ps);
        }
        c.restore();
        m1608r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1712p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1608r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1608r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1608r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1608r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1608r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1608r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1608r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1608r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1608r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1608r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1608r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1608r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1608r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1608r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1608r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1608r(new Integer[0]);
        c.restore();
    }

    private static void m1608r(Integer... o) {
        f1712p.reset();
        ps.reset();
        if (cf != null) {
            f1712p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1712p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1712p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1712p.setColor(Color.parseColor("#000000"));
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
