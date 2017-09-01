package com.lyrebirdstudio.canvastext;

import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MyPaint extends Paint implements Serializable, Parcelable {
    public static final Creator<MyPaint> CREATOR = new C05871();
    private static final long serialVersionUID = -2455397208601380474L;
    int alignment;
    int alpha;
    int color;
    float textSize;

    static class C05871 implements Creator<MyPaint> {
        C05871() {
        }

        public MyPaint createFromParcel(Parcel in) {
            return new MyPaint(in);
        }

        public MyPaint[] newArray(int size) {
            return new MyPaint[size];
        }
    }

    public MyPaint() {
        super.setAntiAlias(true);
    }

    public static int alignValue(Paint paint) {
        Align align = paint.getTextAlign();
        if (align == Align.RIGHT) {
            return 2;
        }
        if (align == Align.CENTER) {
            return 1;
        }
        if (align == Align.LEFT) {
            return 0;
        }
        return 0;
    }

    public static Align alignEnumValue(int al) {
        Align align = Align.LEFT;
        if (al == 2) {
            return Align.RIGHT;
        }
        if (al == 1) {
            return Align.CENTER;
        }
        if (al == 0) {
            return Align.LEFT;
        }
        return align;
    }

    public MyPaint(MyPaint src) {
        super(src);
        this.color = src.color;
        this.textSize = src.textSize;
        this.alignment = alignValue(src);
        setTextAlign(alignEnumValue(this.alignment));
        super.setAntiAlias(true);
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        this.color = super.getColor();
        this.textSize = super.getTextSize();
        this.alignment = alignValue(this);
        oos.writeInt(this.color);
        oos.writeFloat(this.textSize);
        oos.writeInt(this.alignment);
        oos.writeInt(super.getAlpha());
    }

    private void readObject(ObjectInputStream ois) throws Exception, ClassNotFoundException {
        ois.defaultReadObject();
        this.color = ois.readInt();
        this.textSize = ois.readFloat();
        super.setColor(this.color);
        super.setTextSize(this.textSize);
        super.setAntiAlias(true);
        try {
            this.alignment = ois.readInt();
            super.setTextAlign(alignEnumValue(this.alignment));
        } catch (Exception e) {
        }
        try {
            this.alignment = ois.readInt();
            super.setTextAlign(alignEnumValue(this.alignment));
        } catch (Exception e2) {
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        this.color = super.getColor();
        this.textSize = super.getTextSize();
        this.alignment = alignValue(this);
        this.alpha = getAlpha();
        dest.writeInt(this.color);
        dest.writeFloat(this.textSize);
        dest.writeInt(this.alignment);
        dest.writeInt(this.alpha);
    }

    public MyPaint(Parcel in) {
        this.color = in.readInt();
        this.textSize = in.readFloat();
        super.setColor(this.color);
        super.setTextSize(this.textSize);
        super.setAntiAlias(true);
        try {
            this.alignment = in.readInt();
            super.setTextAlign(alignEnumValue(this.alignment));
        } catch (Exception e) {
        }
        try {
            this.alpha = in.readInt();
            super.setAlpha(this.alpha);
        } catch (Exception e2) {
        }
    }
}
