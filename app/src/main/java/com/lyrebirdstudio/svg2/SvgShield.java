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
public class SvgShield extends Svg {
    protected static ColorFilter cf = null;
    private static final Matrix f1732m = new Matrix();
    private static float od;
    private static final Paint f1733p = new Paint();
    private static final Paint ps = new Paint();
    private static final Path f1734t = new Path();

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
        m1615r(new Integer[0]);
        c.save();
        c.translate(((w - (od * 512.0f)) / 2.0f) + dx, ((h - (od * 512.0f)) / 2.0f) + dy);
        f1732m.reset();
        f1732m.setScale(od * 1.08f, od * 1.08f);
        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Cap.BUTT);
        ps.setStrokeJoin(Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.save();
        c.save();
        c.save();
        f1733p.setColor(Color.parseColor("#000000"));
        f1734t.reset();
        f1734t.moveTo(421.52f, 160.0f);
        f1734t.cubicTo(424.19f, 126.0f, 434.52f, 95.0f, 452.52f, 67.0f);
        f1734t.lineTo(383.52f, 0.0f);
        f1734t.cubicTo(361.52f, 18.67f, 336.52f, 28.67f, 308.52f, 30.0f);
        f1734t.cubicTo(282.52f, 32.67f, 258.19f, 28.0f, 235.52f, 16.0f);
        f1734t.cubicTo(212.19f, 27.33f, 187.85f, 32.0f, 162.52f, 30.0f);
        f1734t.cubicTo(135.85f, 28.0f, 112.19f, 19.0f, 91.52f, 3.0f);
        f1734t.lineTo(22.52f, 69.0f);
        f1734t.cubicTo(39.19f, 98.33f, 48.52f, 128.67f, 50.52f, 160.0f);
        f1734t.cubicTo(51.19f, 174.67f, 46.85f, 195.0f, 37.52f, 221.0f);
        f1734t.cubicTo(32.19f, 235.0f, 28.19f, 247.33f, 25.52f, 258.0f);
        f1734t.cubicTo(23.52f, 268.67f, 22.19f, 277.0f, 21.52f, 283.0f);
        f1734t.cubicTo(20.85f, 310.33f, 28.85f, 335.0f, 45.52f, 357.0f);
        f1734t.cubicTo(58.19f, 373.67f, 79.52f, 391.67f, 109.52f, 411.0f);
        f1734t.cubicTo(141.52f, 427.0f, 166.19f, 437.0f, 183.52f, 441.0f);
        f1734t.cubicTo(185.52f, 441.67f, 188.02f, 442.83f, 191.02f, 444.5f);
        f1734t.cubicTo(194.02f, 446.17f, 196.52f, 447.33f, 198.52f, 448.0f);
        f1734t.lineTo(212.52f, 454.0f);
        f1734t.cubicTo(223.85f, 460.67f, 231.52f, 467.33f, 235.52f, 474.0f);
        f1734t.cubicTo(240.19f, 466.67f, 247.85f, 460.0f, 258.52f, 454.0f);
        f1734t.cubicTo(267.19f, 450.67f, 273.52f, 448.0f, 277.52f, 446.0f);
        f1734t.cubicTo(284.19f, 443.33f, 287.85f, 441.67f, 288.52f, 441.0f);
        f1734t.cubicTo(292.52f, 439.67f, 297.52f, 437.67f, 303.52f, 435.0f);
        f1734t.lineTo(325.52f, 427.0f);
        f1734t.cubicTo(342.19f, 421.67f, 354.52f, 416.33f, 362.52f, 411.0f);
        f1734t.cubicTo(391.19f, 391.67f, 412.19f, 374.0f, 425.52f, 358.0f);
        f1734t.cubicTo(442.19f, 336.0f, 450.52f, 311.0f, 450.52f, 283.0f);
        f1734t.cubicTo(449.19f, 270.33f, 443.52f, 250.33f, 433.52f, 223.0f);
        f1734t.cubicTo(424.19f, 195.67f, 420.19f, 174.67f, 421.52f, 160.0f);
        f1734t.transform(f1732m);
        if (clearMode) {
            f1733p.setXfermode(this.xferModeClear);
            ps.setXfermode(this.xferModeClear);
        }
        if (isStroke) {
            ps.setColor(colorStroke);
            ps.setStrokeWidth(strokeSize);
            c.drawPath(f1734t, ps);
        } else {
            c.drawPath(f1734t, f1733p);
            c.drawPath(f1734t, ps);
        }
        c.restore();
        m1615r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1733p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1615r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1733p.setColor(Color.parseColor("#000000"));
        c.restore();
        m1615r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2));
        f1733p.setColor(Color.parseColor("#000000"));
        c.save();
        c.restore();
        m1615r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1615r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1615r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1615r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1615r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1615r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1615r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1615r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1615r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1615r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1615r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1615r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1615r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1615r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.save();
        c.restore();
        m1615r(Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
        c.restore();
        m1615r(new Integer[0]);
        c.restore();
    }

    private static void m1615r(Integer... o) {
        f1733p.reset();
        ps.reset();
        if (cf != null) {
            f1733p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        f1733p.setAntiAlias(true);
        ps.setAntiAlias(true);
        f1733p.setStyle(Style.FILL);
        ps.setStyle(Style.STROKE);
        for (Integer i : o) {
            switch (i.intValue()) {
                case 0:
                    f1733p.setColor(Color.parseColor("#000000"));
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
