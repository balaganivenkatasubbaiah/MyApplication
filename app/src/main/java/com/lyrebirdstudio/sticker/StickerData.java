package com.lyrebirdstudio.sticker;

import android.graphics.Matrix;
import android.os.Parcel;
import android.os.Parcelable;

import com.lyrebirdstudio.canvastext.BaseData;
import com.lyrebirdstudio.canvastext.MyMatrix;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class StickerData extends BaseData implements Serializable, Parcelable {
    public static final Creator<StickerData> CREATOR = new C06531();
    private static final String TAG = StickerData.class.getSimpleName();
    private static final long serialVersionUID = 3789254141896332763L;
    MyMatrix canvasMatrix;
    MyMatrix imageSaveMatrix;
    String path;
    int resId;
    public float xPos;
    public float yPos;

    static class C06531 implements Creator<StickerData> {
        C06531() {
        }

        public StickerData createFromParcel(Parcel in) {
            return new StickerData(in);
        }

        public StickerData[] newArray(int size) {
            return new StickerData[size];
        }
    }

    public int getResId() {
        return this.resId;
    }

    public String getPath() {
        return this.path;
    }

    public MyMatrix getCanvasMatrix() {
        return this.canvasMatrix;
    }

    public MyMatrix getImageSaveMatrix() {
        return this.imageSaveMatrix;
    }

    public StickerData(int resId) {
        this.canvasMatrix = new MyMatrix();
        this.canvasMatrix.reset();
        this.resId = resId;
    }

    public StickerData(String path) {
        this.canvasMatrix = new MyMatrix();
        this.canvasMatrix.reset();
        this.path = path;
    }

    public StickerData(StickerData src) {
        set(src);
    }

    public void set(StickerData src) {
        if (src.canvasMatrix != null) {
            this.canvasMatrix = new MyMatrix(src.canvasMatrix);
        }
        if (src.imageSaveMatrix != null) {
            this.imageSaveMatrix = new MyMatrix(src.imageSaveMatrix);
        }
        this.xPos = src.xPos;
        this.yPos = src.yPos;
        this.resId = src.resId;
    }

    public void setImageSaveMatrix(Matrix mtr) {
        if (mtr != null) {
            MyMatrix inverse = new MyMatrix();
            mtr.invert(inverse);
            MyMatrix canvas = new MyMatrix();
            canvas.set(this.canvasMatrix);
            inverse.preConcat(canvas);
            this.imageSaveMatrix = inverse;
        }
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeFloat(this.xPos);
        oos.writeFloat(this.yPos);
        oos.writeObject(this.canvasMatrix);
        oos.writeObject(this.imageSaveMatrix);
        oos.writeInt(this.resId);
        oos.writeObject(this.path);
    }

    private void readObject(ObjectInputStream ois) throws Exception, ClassNotFoundException {
        ois.defaultReadObject();
        this.xPos = ois.readFloat();
        this.yPos = ois.readFloat();
        this.canvasMatrix = (MyMatrix) ois.readObject();
        this.imageSaveMatrix = (MyMatrix) ois.readObject();
        this.resId = ois.readInt();
        this.path = (String) ois.readObject();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(this.xPos);
        dest.writeFloat(this.yPos);
        dest.writeParcelable(this.canvasMatrix, flags);
        dest.writeParcelable(this.imageSaveMatrix, flags);
        dest.writeInt(this.resId);
        dest.writeString(this.path);
    }

    public StickerData(Parcel in) {
        this.xPos = in.readFloat();
        this.yPos = in.readFloat();
        this.canvasMatrix = (MyMatrix) in.readParcelable(MyMatrix.class.getClassLoader());
        this.imageSaveMatrix = (MyMatrix) in.readParcelable(MyMatrix.class.getClassLoader());
        this.resId = in.readInt();
        this.path = in.readString();
    }

    public static StickerData[] toStickerData(Parcelable[] parcelables) {
        if (parcelables == null) {
            return null;
        }
        StickerData[] objects = new StickerData[parcelables.length];
        System.arraycopy(parcelables, 0, objects, 0, parcelables.length);
        return objects;
    }
}
