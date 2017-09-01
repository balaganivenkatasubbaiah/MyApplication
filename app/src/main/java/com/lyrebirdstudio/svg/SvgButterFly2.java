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

public class SvgButterFly2 extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1495m = new Matrix();
    private static float od;
    private static final Paint f1496p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1497t = new Path();

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
        m1536r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1495m.reset();
        f1495m.setScale(od, od);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(0.89f, 0.89f);
        c.save();
        c.save();
        c.save();
        f1496p.setColor(Color.parseColor("#000000"));
        f1497t.reset();
        f1497t.moveTo(577.23f, 65.05f);
        f1497t.cubicTo(573.65f, 68.84f, 570.38f, 72.17f, 567.27f, 75.64f);
        f1497t.cubicTo(547.08f, 98.23f, 522.88f, 114.5f, 492.82f, 120.11f);
        f1497t.cubicTo(476.46f, 123.16f, 459.58f, 123.35f, 443.08f, 125.81f);
        f1497t.cubicTo(387.88f, 134.06f, 350.29f, 163.41f, 333.82f, 217.91f);
        f1497t.cubicTo(329.53f, 232.1f, 324.96f, 246.3f, 319.12f, 259.89f);
        f1497t.cubicTo(314.19f, 271.36f, 307.22f, 281.96f, 300.79f, 293.62f);
        f1497t.cubicTo(297.46f, 289.33f, 295.37f, 286.64f, 293.2f, 283.86f);
        f1497t.cubicTo(295.82f, 278.28f, 297.06f, 272.95f, 292.85f, 268.26f);
        f1497t.cubicTo(292.56f, 253.77f, 294.72f, 239.48f, 299.08f, 225.94f);
        f1497t.cubicTo(302.72f, 216.45f, 307.43f, 207.39f, 313.52f, 198.93f);
        f1497t.cubicTo(319.22f, 191.0f, 327.37f, 184.82f, 334.43f, 177.86f);
        f1497t.cubicTo(338.98f, 173.38f, 344.31f, 169.39f, 345.41f, 161.29f);
        f1497t.cubicTo(338.73f, 161.43f, 334.96f, 164.56f, 331.87f, 168.51f);
        f1497t.cubicTo(306.5f, 192.16f, 291.43f, 224.99f, 289.79f, 259.39f);
        f1497t.cubicTo(289.76f, 259.34f, 289.74f, 259.29f, 289.72f, 259.23f);
        f1497t.cubicTo(286.46f, 228.11f, 272.43f, 198.87f, 250.19f, 176.9f);
        f1497t.cubicTo(249.22f, 175.34f, 248.26f, 173.77f, 247.29f, 172.22f);
        f1497t.cubicTo(243.75f, 166.6f, 239.81f, 161.7f, 231.66f, 162.44f);
        f1497t.cubicTo(232.82f, 166.32f, 234.3f, 169.98f, 236.9f, 172.48f);
        f1497t.cubicTo(241.6f, 177.0f, 247.41f, 180.39f, 251.98f, 185.02f);
        f1497t.cubicTo(271.56f, 204.86f, 280.12f, 230.11f, 286.13f, 256.51f);
        f1497t.cubicTo(286.18f, 256.72f, 286.22f, 256.93f, 286.27f, 257.14f);
        f1497t.cubicTo(286.58f, 259.61f, 286.81f, 262.11f, 286.98f, 264.61f);
        f1497t.cubicTo(286.53f, 266.13f, 285.5f, 267.58f, 283.44f, 268.94f);
        f1497t.cubicTo(281.59f, 270.16f, 280.55f, 275.37f, 281.58f, 277.66f);
        f1497t.cubicTo(284.56f, 284.3f, 280.61f, 287.52f, 276.67f, 292.1f);
        f1497t.cubicTo(274.27f, 288.63f, 272.24f, 285.89f, 270.4f, 283.03f);
        f1497t.cubicTo(257.2f, 262.48f, 249.84f, 239.54f, 242.97f, 216.35f);
        f1497t.cubicTo(235.98f, 192.71f, 223.97f, 172.07f, 204.95f, 155.94f);
        f1497t.cubicTo(180.01f, 134.78f, 150.41f, 125.22f, 118.42f, 124.27f);
        f1497t.cubicTo(72.73f, 122.9f, 34.99f, 106.28f, 5.81f, 70.82f);
        f1497t.cubicTo(4.15f, 68.8f, 1.95f, 67.21f, 0.0f, 65.42f);
        f1497t.cubicTo(4.77f, 100.18f, 17.41f, 130.62f, 42.07f, 155.32f);
        f1497t.cubicTo(27.39f, 163.84f, 25.8f, 171.27f, 35.35f, 184.51f);
        f1497t.cubicTo(37.98f, 188.15f, 40.84f, 191.77f, 44.2f, 194.7f);
        f1497t.cubicTo(50.89f, 200.54f, 58.01f, 205.91f, 64.94f, 211.46f);
        f1497t.cubicTo(56.39f, 218.4f, 55.32f, 223.65f, 63.2f, 231.74f);
        f1497t.cubicTo(72.16f, 240.95f, 82.4f, 248.91f, 92.31f, 257.61f);
        f1497t.cubicTo(87.57f, 267.24f, 88.96f, 273.46f, 99.44f, 279.78f);
        f1497t.cubicTo(105.49f, 283.42f, 112.28f, 287.31f, 119.04f, 287.96f);
        f1497t.cubicTo(137.69f, 289.77f, 156.5f, 290.66f, 175.24f, 290.55f);
        f1497t.cubicTo(195.7f, 290.42f, 215.86f, 291.59f, 235.66f, 297.11f);
        f1497t.cubicTo(232.03f, 297.51f, 228.44f, 297.26f, 224.85f, 297.11f);
        f1497t.cubicTo(202.93f, 296.22f, 181.4f, 298.28f, 160.57f, 305.6f);
        f1497t.cubicTo(123.09f, 318.75f, 102.46f, 348.33f, 104.5f, 386.0f);
        f1497t.cubicTo(105.27f, 400.34f, 113.13f, 405.84f, 126.94f, 401.72f);
        f1497t.cubicTo(128.84f, 401.15f, 130.77f, 400.71f, 131.53f, 400.51f);
        f1497t.cubicTo(133.29f, 409.42f, 133.78f, 418.36f, 136.92f, 426.23f);
        f1497t.cubicTo(141.28f, 437.16f, 150.56f, 434.3f, 157.46f, 431.41f);
        f1497t.cubicTo(161.0f, 438.22f, 162.74f, 446.63f, 167.78f, 449.85f);
        f1497t.cubicTo(173.14f, 453.27f, 181.64f, 451.77f, 189.65f, 452.5f);
        f1497t.cubicTo(186.35f, 470.03f, 180.6f, 486.5f, 165.52f, 497.95f);
        f1497t.cubicTo(159.25f, 502.72f, 151.95f, 504.56f, 143.06f, 500.75f);
        f1497t.cubicTo(145.22f, 499.45f, 146.63f, 498.82f, 147.78f, 497.87f);
        f1497t.cubicTo(152.32f, 494.13f, 153.49f, 489.43f, 150.25f, 484.48f);
        f1497t.cubicTo(146.99f, 479.49f, 142.0f, 479.01f, 136.87f, 481.32f);
        f1497t.cubicTo(131.49f, 483.73f, 128.78f, 491.33f, 130.66f, 497.85f);
        f1497t.cubicTo(133.6f, 508.11f, 143.56f, 514.83f, 154.05f, 512.03f);
        f1497t.cubicTo(161.84f, 509.94f, 169.68f, 506.63f, 176.39f, 502.19f);
        f1497t.cubicTo(209.89f, 480.02f, 228.0f, 447.66f, 236.84f, 409.23f);
        f1497t.cubicTo(243.02f, 382.33f, 249.64f, 355.48f, 263.42f, 331.22f);
        f1497t.cubicTo(267.04f, 324.86f, 272.55f, 319.57f, 277.7f, 313.15f);
        f1497t.cubicTo(282.38f, 321.18f, 284.85f, 327.01f, 280.05f, 333.58f);
        f1497t.cubicTo(278.75f, 335.38f, 278.16f, 338.14f, 278.23f, 340.42f);
        f1497t.cubicTo(278.79f, 356.79f, 279.13f, 373.19f, 280.58f, 389.48f);
        f1497t.cubicTo(281.05f, 394.75f, 284.62f, 399.75f, 287.49f, 406.58f);
        f1497t.cubicTo(290.23f, 402.82f, 291.87f, 401.34f, 292.56f, 399.5f);
        f1497t.cubicTo(300.78f, 377.8f, 302.36f, 355.34f, 295.92f, 333.26f);
        f1497t.cubicTo(293.67f, 325.56f, 295.13f, 320.5f, 298.79f, 312.34f);
        f1497t.cubicTo(304.29f, 318.95f, 310.11f, 323.92f, 313.32f, 330.22f);
        f1497t.cubicTo(319.43f, 342.22f, 324.99f, 354.67f, 329.07f, 367.48f);
        f1497t.cubicTo(335.18f, 386.65f, 339.32f, 406.43f, 345.17f, 425.69f);
        f1497t.cubicTo(355.25f, 458.85f, 374.33f, 485.67f, 403.98f, 504.17f);
        f1497t.cubicTo(410.14f, 508.01f, 417.39f, 510.86f, 424.51f, 512.24f);
        f1497t.cubicTo(438.41f, 514.96f, 451.64f, 500.09f, 445.98f, 488.22f);
        f1497t.cubicTo(444.23f, 484.54f, 438.82f, 481.47f, 434.56f, 480.56f);
        f1497t.cubicTo(432.26f, 480.07f, 427.66f, 484.19f, 426.24f, 487.23f);
        f1497t.cubicTo(423.96f, 492.14f, 426.45f, 496.41f, 431.54f, 498.83f);
        f1497t.cubicTo(432.28f, 499.18f, 432.73f, 500.12f, 433.48f, 500.96f);
        f1497t.cubicTo(412.61f, 507.65f, 385.49f, 477.08f, 388.95f, 451.58f);
        f1497t.cubicTo(411.43f, 452.96f, 411.56f, 455.9f, 418.82f, 431.09f);
        f1497t.cubicTo(434.76f, 436.45f, 442.15f, 431.87f, 443.96f, 415.13f);
        f1497t.cubicTo(444.49f, 410.26f, 444.04f, 405.29f, 444.04f, 399.76f);
        f1497t.cubicTo(446.74f, 400.6f, 448.48f, 401.16f, 450.22f, 401.68f);
        f1497t.cubicTo(464.44f, 405.95f, 473.14f, 400.3f, 472.54f, 385.4f);
        f1497t.cubicTo(472.06f, 373.66f, 470.88f, 361.29f, 466.71f, 350.47f);
        f1497t.cubicTo(455.29f, 320.81f, 430.28f, 306.95f, 400.91f, 301.35f);
        f1497t.cubicTo(381.56f, 297.65f, 361.55f, 297.39f, 342.75f, 295.67f);
        f1497t.cubicTo(352.02f, 294.36f, 362.59f, 291.9f, 373.22f, 291.56f);
        f1497t.cubicTo(393.88f, 290.9f, 414.58f, 291.64f, 435.25f, 291.38f);
        f1497t.cubicTo(450.29f, 291.2f, 464.83f, 288.42f, 477.73f, 280.05f);
        f1497t.cubicTo(488.17f, 273.28f, 489.83f, 267.28f, 484.55f, 256.26f);
        f1497t.cubicTo(489.11f, 253.15f, 493.85f, 250.24f, 498.23f, 246.85f);
        f1497t.cubicTo(502.83f, 243.28f, 507.67f, 239.74f, 511.32f, 235.3f);
        f1497t.cubicTo(514.71f, 231.17f, 518.01f, 226.07f, 518.79f, 221.01f);
        f1497t.cubicTo(519.27f, 217.88f, 514.96f, 214.02f, 512.75f, 210.41f);
        f1497t.cubicTo(525.56f, 202.6f, 537.41f, 193.28f, 545.09f, 179.74f);
        f1497t.cubicTo(550.92f, 169.47f, 548.52f, 162.52f, 537.97f, 157.15f);
        f1497t.cubicTo(537.28f, 156.8f, 536.71f, 156.23f, 536.11f, 155.69f);
        f1497t.cubicTo(537.77f, 153.9f, 539.14f, 151.88f, 540.18f, 149.72f);
        f1497t.cubicTo(563.29f, 119.58f, 580.89f, 80.48f, 577.23f, 65.05f);
        f1497t.moveTo(174.95f, 445.03f);
        f1497t.cubicTo(175.26f, 444.95f, 175.57f, 444.85f, 175.88f, 444.73f);
        f1497t.cubicTo(176.53f, 445.1f, 177.2f, 445.46f, 177.88f, 445.79f);
        f1497t.cubicTo(176.9f, 445.68f, 175.92f, 445.43f, 174.95f, 445.03f);
        f1497t.transform(f1495m);
        if (clearMode) {
            f1496p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1497t, ps);
        } else {
            c.drawPath(f1497t, f1496p);
            c.drawPath(f1497t, ps);
        }
        c.restore();
        m1536r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1496p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1536r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1496p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1536r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1496p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1536r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1536r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1536r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1536r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1536r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1536r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1536r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1536r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1536r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1536r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1536r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1536r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1536r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1536r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1536r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1536r(new Integer[0]);
        c.restore();
    }

    private static void m1536r(Integer... o) {
        f1496p.reset();
        ps.reset();
        if (cf != null) {
            f1496p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1496p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1496p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1496p.setColor(Color.parseColor("#000000"));
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
