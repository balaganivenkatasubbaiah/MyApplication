package com.lyrebirdstudio.svg;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;

public class SvgStoneHeart extends Svg {
    private static final Matrix f1633m = new Matrix();
    private static float od;
    private static final Paint f1634p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1635t = new Path();

    public void draw(Canvas c, int w, int h) {
        draw(c, (float) w, (float) h, 0.0f, 0.0f, false);
    }

    public void draw(Canvas c, float w, float h, float dx, float dy, boolean clearMode) {
        od = w / 512.0f < h / 424.0f ? w / 512.0f : h / 424.0f;
        m1582r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 424.0f)) / 2.0f) + dy);
        f1633m.reset();
        f1633m.setScale(od, od);
        c.save();
        if (clearMode) {
            f1634p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(1.0f, 1.0f);
        c.save();
        f1634p.setColor(Color.parseColor("#020202"));
        f1635t.reset();
        f1635t.moveTo(257.06f, 58.4f);
        f1635t.cubicTo(186.36f, -28.51f, -11.65f, -28.14f, 0.54f, 126.22f);
        f1635t.cubicTo(6.14f, 189.84f, 32.1f, 229.04f, 65.18f, 270.78f);
        f1635t.cubicTo(110.62f, 328.09f, 254.03f, 416.35f, 256.06f, 424.5f);
        f1635t.cubicTo(258.1f, 416.35f, 401.98f, 328.09f, 447.41f, 270.78f);
        f1635t.cubicTo(480.49f, 229.04f, 506.45f, 189.84f, 512.05f, 126.22f);
        f1635t.cubicTo(524.24f, -28.14f, 327.75f, -28.51f, 257.06f, 58.4f);
        f1635t.transform(f1633m);
        c.drawPath(f1635t, f1634p);
        c.drawPath(f1635t, ps);
        c.restore();
        m1582r(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1));
        f1634p.setColor(Color.parseColor("#020202"));
        c.restore();
        m1582r(new Integer[0]);
        c.restore();
    }

    private static void m1582r(Integer... o) {
        f1634p.reset();
        ps.reset();
        if (cf != null) {
            f1634p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1634p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1634p.setStyle(Style.FILL);
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
