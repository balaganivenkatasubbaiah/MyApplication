package com.lyrebirdstudio.canvastext;

import android.graphics.Matrix;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class BaseData implements Serializable, Parcelable {
    public static final Creator<BaseData> CREATOR = new C05821();

    static class C05821 implements Creator<BaseData> {
        C05821() {
        }

        public BaseData createFromParcel(Parcel in) {
            return new BaseData(in);
        }

        public BaseData[] newArray(int size) {
            return new BaseData[size];
        }
    }

    protected BaseData(Parcel in) {
    }
    protected BaseData() {
    }
    public void setMatrix(Matrix matrix) {
    }

    public void setImageSaveMatrix(Matrix matrix) {
    }

    public MyMatrix getCanvasMatrix() {
        return null;
    }

    public MyMatrix getImageSaveMatrix() {
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
    }

    public static BaseData[] toBaseData(Parcelable[] parcelables) {
        if (parcelables == null) {
            return null;
        }
        BaseData[] objects = new BaseData[parcelables.length];
        System.arraycopy(parcelables, 0, objects, 0, parcelables.length);
        return objects;
    }
}
