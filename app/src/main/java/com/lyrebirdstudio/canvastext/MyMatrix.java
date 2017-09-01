package com.lyrebirdstudio.canvastext;

import android.graphics.Matrix;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MyMatrix extends Matrix implements Serializable, Parcelable {
    public static final Creator<MyMatrix> CREATOR = new C05861();
    private static final long serialVersionUID = 6346371585195628612L;

    static class C05861 implements Creator<MyMatrix> {
        C05861() {
        }

        public MyMatrix createFromParcel(Parcel in) {
            return new MyMatrix(in);
        }

        public MyMatrix[] newArray(int size) {
            return new MyMatrix[size];
        }
    }

    public MyMatrix(Matrix src) {
        super(src);
    }
    public MyMatrix() {
        super();
    }
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        float[] values = new float[9];
        super.getValues(values);
        oos.writeObject(values);
    }

    private void readObject(ObjectInputStream ois) throws Exception, ClassNotFoundException {
        ois.defaultReadObject();
        float[] values = new float[9];
        super.setValues((float[]) ois.readObject());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        float[] values = new float[9];
        super.getValues(values);
        dest.writeFloatArray(values);
    }

    public MyMatrix(Parcel in) {
        float[] values = new float[9];
        in.readFloatArray(values);
        super.setValues(values);
    }
}
