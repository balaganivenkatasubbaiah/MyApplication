package com.lyrebirdstudio.hdrlightlib;

import android.content.Context;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;

public class HdrParameter implements Parcelable {
    public static final Creator<HdrParameter> CREATOR = new C06171();
    static final String TAG = "HdrParameter";
    int applyVignette;
    int[] blue;
    float blur;
    int brightness;
    int contrast;
    float gamma;
    int[] green;
    int highSaturation;
    int lowSaturation;
    float maxInput;
    float maxOutput;
    float minInput;
    float minOutput;
    int offsetBottom;
    int offsetLeft;
    int offsetRight;
    int offsetTop;
    int opacity;
    MyPoint[] pointsBlue;
    MyPoint[] pointsGreen;
    MyPoint[] pointsRed;
    MyPoint[] pointsRgb;
    float power;
    float range;
    int[] red;
    int[] rgb;
    private int saturation;
    int selectedFilterIndex;
    int selectedOverlayIndex;
    int sepiaMode;
    float shade;
    float slope;
    int temperature;
    float umBlur;
    int umEnabled;
    float umPower;
    int umThreshold;

    static class C06171 implements Creator<HdrParameter> {
        C06171() {
        }

        public HdrParameter createFromParcel(Parcel in) {
            return new HdrParameter(in);
        }

        public HdrParameter[] newArray(int size) {
            return new HdrParameter[size];
        }
    }

    void setSaturation(int progress) {
        this.saturation = progress;
    }

    float getSaturation() {
        return ((float) this.saturation) / 50.0f;
    }

    int getSaturationProgressValue() {
        return this.saturation;
    }

    public HdrParameter() {
        this.offsetLeft = 0;
        this.offsetTop = 0;
        this.offsetRight = 0;
        this.offsetBottom = 0;
        this.red = new int[256];
        this.green = new int[256];
        this.blue = new int[256];
        this.rgb = new int[256];
        reset();
    }

    public void set(HdrParameter param) {
        if (param != null) {
            this.highSaturation = param.highSaturation;
            this.lowSaturation = param.lowSaturation;
            this.power = param.power;
            this.blur = param.blur;
            this.umEnabled = param.umEnabled;
            this.umPower = param.umPower;
            this.umBlur = param.umBlur;
            this.umThreshold = param.umThreshold;
            this.contrast = param.contrast;
            this.brightness = param.brightness;
            this.temperature = param.temperature;
            this.minInput = param.minInput;
            this.gamma = param.gamma;
            this.maxInput = param.maxInput;
            this.minOutput = param.minOutput;
            this.maxOutput = param.maxOutput;
            this.applyVignette = param.applyVignette;
            this.slope = param.slope;
            this.shade = param.shade;
            this.range = param.range;
            this.selectedFilterIndex = param.selectedFilterIndex;
            this.selectedOverlayIndex = param.selectedOverlayIndex;
            this.sepiaMode = param.sepiaMode;
            this.pointsRgb = param.pointsRgb;
            this.pointsRed = param.pointsRed;
            this.pointsGreen = param.pointsGreen;
            this.pointsBlue = param.pointsBlue;
            this.opacity = param.opacity;
            this.saturation = param.saturation;
            if (param.offsetLeft >= 0) {
                this.offsetLeft = param.offsetLeft;
            }
            if (param.offsetTop >= 0) {
                this.offsetTop = param.offsetTop;
            }
            if (param.offsetRight >= 0) {
                this.offsetRight = param.offsetRight;
            }
            if (param.offsetBottom >= 0) {
                this.offsetBottom = param.offsetBottom;
            }
        }
    }

    public void copy(HdrParameter param) {
        if (param != null) {
            this.highSaturation = param.highSaturation;
            this.lowSaturation = param.lowSaturation;
            this.power = param.power;
            this.blur = param.blur;
            this.umEnabled = param.umEnabled;
            this.umPower = param.umPower;
            this.umBlur = param.umBlur;
            this.umThreshold = param.umThreshold;
            this.contrast = param.contrast;
            this.brightness = param.brightness;
            this.temperature = param.temperature;
            this.minInput = param.minInput;
            this.gamma = param.gamma;
            this.maxInput = param.maxInput;
            this.minOutput = param.minOutput;
            this.maxOutput = param.maxOutput;
            this.applyVignette = param.applyVignette;
            this.slope = param.slope;
            this.shade = param.shade;
            this.range = param.range;
            this.selectedFilterIndex = param.selectedFilterIndex;
            this.selectedOverlayIndex = param.selectedOverlayIndex;
            this.sepiaMode = param.sepiaMode;
            this.pointsRgb = (MyPoint[]) param.pointsRgb.clone();
            this.pointsRed = (MyPoint[]) param.pointsRed.clone();
            this.pointsGreen = (MyPoint[]) param.pointsGreen.clone();
            this.pointsBlue = (MyPoint[]) param.pointsBlue.clone();
            this.opacity = param.opacity;
            this.saturation = param.saturation;
            if (param.offsetLeft >= 0) {
                this.offsetLeft = param.offsetLeft;
            }
            if (param.offsetTop >= 0) {
                this.offsetTop = param.offsetTop;
            }
            if (param.offsetRight >= 0) {
                this.offsetRight = param.offsetRight;
            }
            if (param.offsetBottom >= 0) {
                this.offsetBottom = param.offsetBottom;
            }
        }
    }

    public void reset() {
        this.highSaturation = 100;
        this.lowSaturation = 100;
        this.power = 0.0f;
        this.blur = 0.0f;
        this.umEnabled = 0;
        this.umPower = 30.0f;
        this.umBlur = 4.0f;
        this.umThreshold = 0;
        this.contrast = 0;
        this.brightness = 0;
        this.temperature = 0;
        this.minInput = 0.0f;
        this.gamma = 1.0f;
        this.maxInput = 1.0f;
        this.minOutput = 0.0f;
        this.maxOutput = 1.0f;
        this.applyVignette = 0;
        this.slope = 20.0f;
        this.shade = 0.85f;
        this.range = 0.6f;
        this.selectedFilterIndex = 0;
        this.selectedOverlayIndex = 0;
        this.sepiaMode = 0;
        this.pointsRgb = new MyPoint[2];
        this.pointsRgb[0] = new MyPoint(0, 0);
        this.pointsRgb[1] = new MyPoint(256, 256);
        this.pointsRed = new MyPoint[2];
        this.pointsRed[0] = new MyPoint(0, 0);
        this.pointsRed[1] = new MyPoint(256, 256);
        this.pointsGreen = new MyPoint[2];
        this.pointsGreen[0] = new MyPoint(0, 0);
        this.pointsGreen[1] = new MyPoint(256, 256);
        this.pointsBlue = new MyPoint[2];
        this.pointsBlue[0] = new MyPoint(0, 0);
        this.pointsBlue[1] = new MyPoint(256, 256);
        this.opacity = 255;
        this.saturation = 50;
        this.offsetLeft = 0;
        this.offsetTop = 0;
        this.offsetRight = 0;
        this.offsetBottom = 0;
    }

    void setTemperature(int temp) {
        this.temperature = (temp - 50) * 2;
    }

    int getSeekBarvalueOfTemp() {
        return (this.temperature / 2) + 50;
    }

    void setContrast(int cont) {
        this.contrast = (cont - 50) / 3;
    }

    int getSeekBarvalueOfContrast() {
        return (this.contrast * 3) + 50;
    }

    void setBrightness(int bri) {
        int value = bri - 50;
        if (value < 0) {
            this.brightness = value * 3;
        } else {
            this.brightness = value * 5;
        }
    }

    int getSeekBarvalueOfBri() {
        if (this.brightness < 0) {
            return (this.brightness / 3) + 50;
        }
        return (this.brightness / 5) + 50;
    }

    void setBlurValue(int val) {
        this.blur = (float) (Math.pow((double) (((float) val) / 100.0f), 2.0d) * ((double) 500.0f));
    }

    int getSeekBarvalueBlur() {
        return Math.round(100.0f * ((float) Math.sqrt((double) (this.blur / 500.0f))));
    }

    float getBlurValue() {
        return this.blur;
    }

    void setPowerValue(float value) {
        if (value < 0.0f) {
            value = 0.0f;
        }
        if (((double) value) > 100.0d) {
            value = 100.0f;
        }
        this.power = value;
    }

    int getSeekBarvaluePower() {
        return (int) this.power;
    }

    float getPowerValue() {
        return this.power;
    }

    void setLowSaturation(int value) {
        if (value < 0) {
            value = 0;
        }
        if (value > 100) {
            value = 100;
        }
        this.lowSaturation = value;
    }

    int getLowSaturation() {
        return this.lowSaturation;
    }

    void setHighSaturation(int value) {
        if (value < 0) {
            value = 0;
        }
        if (value > 100) {
            value = 100;
        }
        this.highSaturation = value;
    }

    int getHighSaturation() {
        return this.highSaturation;
    }

    void setUnsharpMaskBlur(float value) {
        this.umBlur = (float) Math.round((Math.pow((double) (value / 100.0f), 2.0d) * ((double) 50)) + 1.0d);
    }

    int getSeekBarvalueMaskBlur() {
        return (int) Math.round(Math.sqrt((((double) this.umBlur) - 1.0d) / ((double) 50.0f)) * 100.0d);
    }

    float getUnsharpMaskBlur() {
        return this.umBlur;
    }

    void setUnsharpMaskEnabled(boolean value) {
        if (value) {
            this.umEnabled = 1;
        } else {
            this.umEnabled = 0;
        }
    }

    void setVignetteEnabled(boolean value) {
        if (value) {
            this.applyVignette = 1;
        } else {
            this.applyVignette = 0;
        }
    }

    int getUnsharpMaskEnabled() {
        return this.umEnabled;
    }

    void setUnsharpMaskPower(float value) {
        this.umPower = value;
    }

    float getUnsharpMaskPower() {
        return this.umPower;
    }

    void setUnsharpMaskThreshold(int value) {
        this.umThreshold = value;
    }

    int getUnsharpMaskThreshold() {
        return this.umThreshold;
    }

    void setOffsetLeft(int leftPos) {
        this.offsetLeft += leftPos;
        if (this.offsetLeft < 0) {
            this.offsetLeft = 0;
        }
        Log.e("offsetLeft", "" + this.offsetLeft);
    }

    void setOffsetTop(int topPos) {
        this.offsetTop += topPos;
        if (this.offsetTop < 0) {
            this.offsetTop = 0;
        }
        Log.e("offsetTop", "" + this.offsetTop);
    }

    void setOffsetRight(int rightPos, int leftPos, int croppedWidth) {
        this.offsetRight += (croppedWidth - rightPos) + leftPos;
        if (this.offsetRight < 0) {
            this.offsetRight = 0;
        }
        Log.e("offsetRight", "" + this.offsetRight);
    }

    void setOffsetBottom(int bottomPos, int topPos, int croppedHeight) {
        this.offsetBottom += (croppedHeight - bottomPos) + topPos;
        if (this.offsetBottom < 0) {
            this.offsetBottom = 0;
        }
        Log.e("offsetBottom", "" + this.offsetBottom);
    }

    public void serializeToJSON() {
        Gson gson = new Gson();
        HdrParameter obj2 = (HdrParameter) gson.fromJson(gson.toJson((Object) this), HdrParameter.class);
    }

    public void saveParametersToFile(String name) throws IOException {
        String json = new Gson().toJson((Object) this);
        Writer output = new BufferedWriter(new FileWriter(new File(Environment.getExternalStorageDirectory().toString() + "/HDR/fx/" + name + ".txt")));
        output.write(json);
        output.close();
    }

    public HdrParameter loadParametersFromFile(String fileName) {
        String result = "";
        try {
            DataInputStream in = new DataInputStream(new FileInputStream(Environment.getExternalStorageDirectory().toString() + "/HDR/fx/" + fileName));
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            while (true) {
                String strLine = br.readLine();
                if (strLine != null) {
                    result = result + strLine;
                } else {
                    in.close();
                    return (HdrParameter) new Gson().fromJson(result, HdrParameter.class);
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    public static HdrParameter loadParametersFromResources(Context context, int resId) {
        String result = "";
        HdrParameter resultParameter = null;
        try {
            DataInputStream in = new DataInputStream(context.getResources().openRawResource(resId));
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            while (true) {
                String strLine = br.readLine();
                if (strLine == null) {
                    break;
                }
                result = result + strLine;
            }
            in.close();
            resultParameter = (HdrParameter) new Gson().fromJson(result, HdrParameter.class);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        resultParameter.offsetLeft = -1;
        resultParameter.offsetTop = -1;
        resultParameter.offsetRight = -1;
        resultParameter.offsetBottom = -1;
        HdrLightHelper.calcululateCurve(resultParameter.pointsRed, resultParameter.red);
        HdrLightHelper.calcululateCurve(resultParameter.pointsGreen, resultParameter.green);
        HdrLightHelper.calcululateCurve(resultParameter.pointsBlue, resultParameter.blue);
        HdrLightHelper.calcululateCurve(resultParameter.pointsRgb, resultParameter.rgb);
        return resultParameter;
    }

    MyPoint[] selectPoints(int MODE) {
        MyPoint[] res = null;
        if (MODE == 0) {
            res = this.pointsRgb;
        }
        if (MODE == 1) {
            res = this.pointsRed;
        }
        if (MODE == 2) {
            res = this.pointsGreen;
        }
        if (MODE == 3) {
            return this.pointsBlue;
        }
        return res;
    }

    void initPoints(int MODE, int size) {
        if (MODE == 0) {
            this.pointsRgb = new MyPoint[size];
        }
        if (MODE == 1) {
            this.pointsRed = new MyPoint[size];
        }
        if (MODE == 2) {
            this.pointsGreen = new MyPoint[size];
        }
        if (MODE == 3) {
            this.pointsBlue = new MyPoint[size];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int arg1) {
        out.writeInt(this.lowSaturation);
        out.writeInt(this.highSaturation);
        out.writeFloat(this.power);
        out.writeFloat(this.blur);
        out.writeInt(this.umEnabled);
        out.writeFloat(this.umPower);
        out.writeFloat(this.umBlur);
        out.writeInt(this.umThreshold);
        out.writeInt(this.contrast);
        out.writeInt(this.brightness);
        out.writeInt(this.temperature);
        out.writeFloat(this.slope);
        out.writeFloat(this.shade);
        out.writeFloat(this.range);
        out.writeInt(this.applyVignette);
        out.writeInt(this.opacity);
        out.writeFloat(this.minInput);
        out.writeFloat(this.gamma);
        out.writeFloat(this.maxInput);
        out.writeFloat(this.minOutput);
        out.writeFloat(this.maxOutput);
        out.writeInt(this.selectedFilterIndex);
        out.writeInt(this.sepiaMode);
        writeParcellableArray(out, this.pointsRgb);
        writeParcellableArray(out, this.pointsRed);
        writeParcellableArray(out, this.pointsGreen);
        writeParcellableArray(out, this.pointsBlue);
        out.writeInt(this.selectedOverlayIndex);
        out.writeInt(this.saturation);
        out.writeInt(this.offsetLeft);
        out.writeInt(this.offsetTop);
        out.writeInt(this.offsetRight);
        out.writeInt(this.offsetBottom);
    }

    HdrParameter(Parcel in) {
        this.offsetLeft = 0;
        this.offsetTop = 0;
        this.offsetRight = 0;
        this.offsetBottom = 0;
        this.red = new int[256];
        this.green = new int[256];
        this.blue = new int[256];
        this.rgb = new int[256];
        this.lowSaturation = in.readInt();
        this.highSaturation = in.readInt();
        this.power = in.readFloat();
        this.blur = in.readFloat();
        this.umEnabled = in.readInt();
        this.umPower = in.readFloat();
        this.umBlur = in.readFloat();
        this.umThreshold = in.readInt();
        this.contrast = in.readInt();
        this.brightness = in.readInt();
        this.temperature = in.readInt();
        this.slope = in.readFloat();
        this.shade = in.readFloat();
        this.range = in.readFloat();
        this.applyVignette = in.readInt();
        this.opacity = in.readInt();
        this.minInput = in.readFloat();
        this.gamma = in.readFloat();
        this.maxInput = in.readFloat();
        this.minOutput = in.readFloat();
        this.maxOutput = in.readFloat();
        this.selectedFilterIndex = in.readInt();
        this.sepiaMode = in.readInt();
        this.pointsRgb = readParcellableArray(in);
        this.pointsRed = readParcellableArray(in);
        this.pointsGreen = readParcellableArray(in);
        this.pointsBlue = readParcellableArray(in);
        try {
            this.selectedOverlayIndex = in.readInt();
        } catch (Exception e) {
        }
        try {
            this.saturation = in.readInt();
        } catch (Exception e2) {
        }
        Log.e("parcel", "bir numara");
        try {
            this.offsetLeft = in.readInt();
            this.offsetTop = in.readInt();
            this.offsetRight = in.readInt();
            this.offsetBottom = in.readInt();
        } catch (Exception e3) {
        }
    }

    MyPoint[] readParcellableArray(Parcel parcel) {
        Parcelable[] parcelableArray = parcel.readParcelableArray(MyPoint.class.getClassLoader());
        MyPoint[] resultArray = null;
        if (parcelableArray != null) {
            resultArray = new MyPoint[parcelableArray.length];
            for (int i = 0; i < parcelableArray.length; i++) {
                resultArray[i] = (MyPoint) parcelableArray[i];
            }
        }
        return resultArray;
    }

    void writeParcellableArray(Parcel parcel, MyPoint[] arr) {
        if (arr != null) {
            Parcelable[] parcelableArray = new Parcelable[arr.length];
            for (int i = 0; i < parcelableArray.length; i++) {
                parcelableArray[i] = arr[i];
            }
            parcel.writeParcelableArray(parcelableArray, 0);
        }
    }

    private static void setInitialValues(int[] arr) {
        for (int i = 0; i < 256; i++) {
            arr[i] = i;
        }
    }
}
