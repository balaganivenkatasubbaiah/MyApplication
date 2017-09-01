package com.lyrebirdstudio.tiltshift;

import android.graphics.Matrix;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MyMatrix extends Matrix implements Serializable, Parcelable {
    public static final Creator<MyMatrix> CREATOR = new C06641();
    private static final long serialVersionUID = 834616781988144445L;

    static class C06641 implements Creator<MyMatrix> {
        C06641() {
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
    public MyMatrix( ) {
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

    public boolean compare(MyMatrix matrix) {
        float[] v = new float[9];
        float[] p = new float[9];
        getValues(v);
        matrix.getValues(p);
        for (int i = 0; i < 9; i++) {
            if (v[i] != p[i]) {
                return false;
            }
        }
        return true;
    }

    public MyMatrix(Parcel in) {
        float[] values = new float[9];
        in.readFloatArray(values);
        super.setValues(values);
    }
}
