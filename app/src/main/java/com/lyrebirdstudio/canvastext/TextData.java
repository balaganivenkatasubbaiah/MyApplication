package com.lyrebirdstudio.canvastext;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class TextData extends BaseData implements Serializable, Parcelable {
    public static final Creator<TextData> CREATOR = new C05881();
    private static final String TAG = TextData.class.getSimpleName();
    public static int bgColorSentinel = ViewCompat.MEASURED_SIZE_MASK;
    private static final AtomicInteger counter = new AtomicInteger();
    public static final int defBgAlpha = 255;
    public static final int defBgColor = bgColorSentinel;
    public static final String defaultMessage = "Preview Text";
    private static final long serialVersionUID = 3789254181897332363L;
    String ID;
    int backgroundAlpha;
    private int backgroundColor;
    public MyMatrix canvasMatrix;
    private String fontPath;
    private MyMatrix imageSaveMatrix;
    private boolean isSnapMode;
    public boolean isTypeFaceSet;
    public String message;
    public MyPaint textPaint;
    public float textSize;
    public float xPos;
    public float yPos;
    public float yPosSnap;

    static class C05881 implements Creator<TextData> {
        C05881() {
        }

        public TextData createFromParcel(Parcel in) {
            return new TextData(in);
        }

        public TextData[] newArray(int size) {
            return new TextData[size];
        }
    }

    public static String nextIdValue() {
        return UUID.randomUUID().toString();
    }

    public void setBackgroundColor(int color) {
        this.backgroundColor = color;
    }

    public int setTextColor(int color) {
        int finalColor = getColor(this.textPaint.getAlpha(), color);
        this.textPaint.setColor(finalColor);
        return finalColor;
    }

    public int getBackgroundColorValue() {
        return this.backgroundColor;
    }

    public int getBackgroundColorFinal() {
        if (this.backgroundColor == bgColorSentinel) {
            return 0;
        }
        return getColor(this.backgroundAlpha, this.backgroundColor);
    }

    int getColor(int alpha, int bgColor) {
        return Color.argb(alpha, Color.red(bgColor), Color.green(bgColor), Color.blue(bgColor));
    }

    public void setBackgroundAlpha(int alpha) {
        this.backgroundAlpha = alpha;
    }

    public int getBackgroundAlpha() {
        return this.backgroundAlpha;
    }

    public boolean getSnapMode() {
        return this.isSnapMode;
    }

    public void setSnapMode(boolean mode) {
        this.isSnapMode = mode;
        float textSize = this.textPaint.getTextSize();
        if (this.isSnapMode) {
            this.textPaint.setTextSize(0.8f * textSize);
        } else {
            this.textPaint.setTextSize(1.25f * textSize);
        }
    }

    public MyMatrix getCanvasMatrix() {
        return this.canvasMatrix;
    }

    public MyMatrix getImageSaveMatrix() {
        return this.imageSaveMatrix;
    }

    public String getId() {
        return this.ID;
    }

    public void setTextFont(String path, Context context) {
        this.fontPath = path;
        if (this.fontPath != null) {
            Typeface typeFace = FontCache.get(context, this.fontPath);
            if (typeFace != null) {
                this.textPaint.setTypeface(typeFace);
            }
            this.isTypeFaceSet = true;
        }
    }

    public String getFontPath() {
        return this.fontPath;
    }

    public TextData(float textSize) {
        this.message = defaultMessage;
        this.isTypeFaceSet = false;
        this.yPosSnap = 0.0f;
        this.isSnapMode = false;
        this.backgroundColor = defBgColor;
        this.backgroundAlpha = 255;
        this.canvasMatrix = new MyMatrix();
        this.textPaint = new MyPaint();
        this.textPaint.setAntiAlias(true);
        this.textPaint.setColor(-1);
        this.textSize = textSize;
        this.textPaint.setTextSize(textSize);
        this.fontPath = null;
        this.ID = nextIdValue();
        this.isSnapMode = false;
        this.yPosSnap = 0.0f;
        this.backgroundColor = defBgColor;
        this.backgroundAlpha = 255;
    }

    public TextData() {
        this.message = defaultMessage;
        this.isTypeFaceSet = false;
        this.yPosSnap = 0.0f;
        this.isSnapMode = false;
        this.backgroundColor = defBgColor;
        this.backgroundAlpha = 255;
        this.canvasMatrix = new MyMatrix();
        this.textPaint = new MyPaint();
        this.textPaint.setAntiAlias(true);
        this.textPaint.setColor(-1);
        this.textSize = 60.0f;
        this.textPaint.setTextSize(this.textSize);
        this.fontPath = null;
        this.ID = nextIdValue();
        this.yPosSnap = 0.0f;
        this.isSnapMode = false;
        this.backgroundColor = defBgColor;
        this.backgroundAlpha = 255;
    }

    public TextData(TextData src) {
        this.message = defaultMessage;
        this.isTypeFaceSet = false;
        this.yPosSnap = 0.0f;
        this.isSnapMode = false;
        this.backgroundColor = defBgColor;
        this.backgroundAlpha = 255;
        set(src);
    }

    public void set(TextData src) {
        this.canvasMatrix = new MyMatrix(src.canvasMatrix);
        this.textPaint = new MyPaint(src.textPaint);
        if (src.imageSaveMatrix != null) {
            this.imageSaveMatrix = new MyMatrix(src.imageSaveMatrix);
        }
        this.textPaint.setAntiAlias(true);
        this.message = new String(src.message);
        this.textSize = src.textSize;
        this.xPos = src.xPos;
        this.yPos = src.yPos;
        if (src.fontPath != null) {
            this.fontPath = src.fontPath;
        }
        this.ID = src.ID;
        if (this.ID == null) {
            this.ID = nextIdValue();
        }
        this.yPosSnap = src.yPosSnap;
        this.isSnapMode = src.isSnapMode;
        this.backgroundColor = src.backgroundColor;
        this.backgroundAlpha = src.backgroundAlpha;
    }

    public void setImageSaveMatrix(Matrix mtr) {
        if (mtr != null) {
            MyMatrix inverse = new MyMatrix(mtr);
            mtr.invert(inverse);
            MyMatrix canvas = new MyMatrix(mtr);
            canvas.set(this.canvasMatrix);
            inverse.preConcat(canvas);
            this.imageSaveMatrix = inverse;
        }
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeFloat(this.xPos);
        oos.writeFloat(this.yPos);
        oos.writeFloat(this.textSize);
        oos.writeObject(this.textPaint);
        oos.writeObject(this.message);
        oos.writeObject(this.canvasMatrix);
        oos.writeObject(this.imageSaveMatrix);
        oos.writeObject(this.fontPath);
        oos.writeObject(this.ID);
        oos.writeFloat(this.yPosSnap);
        oos.writeBoolean(this.isSnapMode);
        oos.writeInt(this.backgroundColor);
        oos.writeInt(this.backgroundAlpha);
    }

    private void readObject(ObjectInputStream ois) throws Exception, ClassNotFoundException {
        ois.defaultReadObject();
        this.xPos = ois.readFloat();
        this.yPos = ois.readFloat();
        this.textSize = ois.readFloat();
        this.textPaint = (MyPaint) ois.readObject();
        this.message = (String) ois.readObject();
        this.canvasMatrix = (MyMatrix) ois.readObject();
        this.imageSaveMatrix = (MyMatrix) ois.readObject();
        try {
            this.fontPath = (String) ois.readObject();
        } catch (Exception e) {
            this.fontPath = null;
        }
        try {
            this.ID = (String) ois.readObject();
        } catch (Exception e2) {
            this.ID = nextIdValue();
        }
        try {
            this.yPosSnap = ois.readFloat();
        } catch (Exception e3) {
            this.yPosSnap = 0.0f;
        }
        try {
            this.isSnapMode = ois.readBoolean();
        } catch (Exception e4) {
            this.isSnapMode = false;
        }
        try {
            this.backgroundColor = ois.readInt();
        } catch (Exception e5) {
            this.backgroundColor = defBgColor;
        }
        try {
            this.backgroundAlpha = ois.readInt();
        } catch (Exception e6) {
            this.backgroundAlpha = 255;
        }
        this.textPaint.setAntiAlias(true);
        this.isTypeFaceSet = false;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(this.xPos);
        dest.writeFloat(this.yPos);
        dest.writeFloat(this.textSize);
        dest.writeParcelable(this.textPaint, flags);
        dest.writeString(this.message);
        dest.writeParcelable(this.canvasMatrix, flags);
        dest.writeParcelable(this.imageSaveMatrix, flags);
        dest.writeString(this.fontPath);
        dest.writeString(this.ID);
        dest.writeFloat(this.yPosSnap);
        dest.writeByte((byte) (this.isSnapMode ? 1 : 0));
        dest.writeInt(this.backgroundColor);
        dest.writeInt(this.backgroundAlpha);
    }

    public TextData(Parcel in) {
        this.message = defaultMessage;
        this.isTypeFaceSet = false;
        this.yPosSnap = 0.0f;
        this.isSnapMode = false;
        this.backgroundColor = defBgColor;
        this.backgroundAlpha = 255;
        this.xPos = in.readFloat();
        this.yPos = in.readFloat();
        this.textSize = in.readFloat();
        this.textPaint = (MyPaint) in.readParcelable(MyPaint.class.getClassLoader());
        this.message = in.readString();
        this.canvasMatrix = (MyMatrix) in.readParcelable(MyMatrix.class.getClassLoader());
        this.imageSaveMatrix = (MyMatrix) in.readParcelable(MyMatrix.class.getClassLoader());
        try {
            this.fontPath = in.readString();
        } catch (Exception e) {
            this.fontPath = null;
        }
        try {
            this.ID = in.readString();
        } catch (Exception e2) {
            this.ID = nextIdValue();
        }
        try {
            this.yPosSnap = in.readFloat();
        } catch (Exception e3) {
            this.yPosSnap = 0.0f;
        }
        try {
            boolean z;
            if (in.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.isSnapMode = z;
        } catch (Exception e4) {
            this.isSnapMode = false;
        }
        try {
            this.backgroundColor = in.readInt();
        } catch (Exception e5) {
            this.backgroundColor = defBgColor;
        }
        try {
            this.backgroundAlpha = in.readInt();
        } catch (Exception e6) {
            this.backgroundAlpha = 255;
        }
        this.textPaint.setAntiAlias(true);
        this.isTypeFaceSet = false;
    }

    public static TextData[] toTextData(Parcelable[] parcelables) {
        if (parcelables == null) {
            return null;
        }
        TextData[] objects = new TextData[parcelables.length];
        System.arraycopy(parcelables, 0, objects, 0, parcelables.length);
        return objects;
    }
}
