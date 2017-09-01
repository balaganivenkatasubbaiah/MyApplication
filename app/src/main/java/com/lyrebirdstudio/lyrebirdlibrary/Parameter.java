package com.lyrebirdstudio.lyrebirdlibrary;

import android.os.Parcel;
import android.os.Parcelable;

import com.lyrebirdstudio.tiltshift.TiltContext;
import com.lyrebirdstudio.tiltshift.TiltContext.TiltMode;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class Parameter implements Serializable, Parcelable {
    public static final Creator<Parameter> CREATOR = new C06261();
    private static final String TAG = Parameter.class.getSimpleName();
    public static final int seek_bar_blur = 6;
    public static final int seek_bar_brightness = 0;
    public static final int seek_bar_contrast = 1;
    public static final int seek_bar_highlight = 7;
    public static final int seek_bar_saturation = 3;
    public static final int seek_bar_shadows = 8;
    public static final int seek_bar_sharpen = 5;
    public static final int seek_bar_temperature = 2;
    public static final int seek_bar_tint = 4;
    private static final long serialVersionUID = -3588782317514910667L;
    public static AtomicInteger uniqueId = new AtomicInteger();
    int blur = 0;
    int brightness;
    int contrast;
    float highlight = 0.0f;
    int id;
    int saturation;
    int seekBarMode = 0;
    int selectedBorderIndex;
    int selectedFilterIndex;
    int selectedOverlayIndex;
    int selectedTextureIndex;
    float shadow = 0.0f;
    float sharpen = 0.0f;
    private int temperature;
    TiltContext tiltContext;
    private int tint;

    static class C06261 implements Creator<Parameter> {
        C06261() {
        }

        public Parameter createFromParcel(Parcel in) {
            return new Parameter(in);
        }

        public Parameter[] newArray(int size) {
            return new Parameter[size];
        }
    }

    public void setSelectedTextureIndex(int index) {
        this.selectedTextureIndex = index;
    }

    public void setSelectedBorderIndex(int index) {
        this.selectedBorderIndex = index;
    }

    public void setSelectedOverlayIndex(int index) {
        this.selectedOverlayIndex = index;
    }

    public void setSelectedFilterIndex(int index) {
        this.selectedFilterIndex = index;
    }

    public int getSelectedTextureIndex() {
        return this.selectedTextureIndex;
    }

    public int getSelectedBorderIndex() {
        return this.selectedBorderIndex;
    }

    public int getSelectedOverlayIndex() {
        return this.selectedOverlayIndex;
    }

    public int getSelectedFilterIndex() {
        return this.selectedFilterIndex;
    }

    public Parameter copy() {
        return new Parameter(this);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int d) {
        this.id = d;
    }

    public boolean isParameterChanged() {
        Parameter p = new Parameter();
        if (this.contrast == p.contrast && this.brightness == p.brightness && this.saturation == p.saturation && this.temperature == p.temperature && this.tint == p.tint && this.sharpen == p.sharpen && this.blur == p.blur && this.highlight == p.highlight && this.shadow == p.shadow && this.selectedBorderIndex == p.selectedBorderIndex && this.selectedFilterIndex == p.selectedFilterIndex && this.selectedOverlayIndex == p.selectedOverlayIndex && this.selectedTextureIndex == p.selectedTextureIndex) {
            return checkTiltShiftChanged(p);
        }
        return true;
    }

    public boolean isParameterChanged(Parameter p) {
        if (p == null) {
            return isParameterChanged();
        }
        boolean result = false;
        if (!(this.contrast == p.contrast && this.brightness == p.brightness && this.saturation == p.saturation && this.temperature == p.temperature && this.tint == p.tint && this.sharpen == p.sharpen && this.blur == p.blur && this.highlight == p.highlight && this.shadow == p.shadow && this.selectedBorderIndex == p.selectedBorderIndex && this.selectedFilterIndex == p.selectedFilterIndex && this.selectedOverlayIndex == p.selectedOverlayIndex && this.selectedTextureIndex == p.selectedTextureIndex)) {
            result = true;
        }
        result = result && isParameterChanged();
        return result;
    }

    public boolean isParameterReallyChanged(Parameter p) {
        if (this.contrast == p.contrast && this.brightness == p.brightness && this.saturation == p.saturation && this.temperature == p.temperature && this.tint == p.tint && this.sharpen == p.sharpen && this.blur == p.blur && this.highlight == p.highlight && this.shadow == p.shadow && this.selectedBorderIndex == p.selectedBorderIndex && this.selectedFilterIndex == p.selectedFilterIndex && this.selectedOverlayIndex == p.selectedOverlayIndex && this.selectedTextureIndex == p.selectedTextureIndex) {
            return checkTiltShiftChanged(p);
        }
        return true;
    }

    private boolean checkTiltShiftChanged(Parameter p) {
        if (this.tiltContext == null && p.tiltContext != null) {
            return true;
        }
        if (this.tiltContext != null && p.tiltContext == null) {
            return true;
        }
        if (this.tiltContext == null && p.tiltContext == null) {
            return false;
        }
        if (this.tiltContext == null || p.tiltContext == null) {
            return false;
        }
        if (this.tiltContext.mode == p.tiltContext.mode && (this.tiltContext.getMatrix() == null || p.tiltContext.getMatrix() == null || this.tiltContext.getMatrix().compare(p.tiltContext.getMatrix()))) {
            return false;
        }
        return true;
    }

    public Parameter(Parameter p) {
        set(p);
    }

    public Parameter() {
        reset();
        this.id = uniqueId.getAndIncrement();
        this.seekBarMode = 0;
    }

    public void set(Parameter p) {
        this.brightness = p.brightness;
        this.temperature = p.temperature;
        this.contrast = p.contrast;
        this.saturation = p.saturation;
        this.tint = p.tint;
        this.selectedTextureIndex = p.selectedTextureIndex;
        this.selectedBorderIndex = p.selectedBorderIndex;
        this.selectedOverlayIndex = p.selectedOverlayIndex;
        this.selectedFilterIndex = p.selectedFilterIndex;
        this.sharpen = p.sharpen;
        this.blur = p.blur;
        this.highlight = p.highlight;
        this.shadow = p.shadow;
        this.seekBarMode = p.seekBarMode;
        this.id = p.id;
        if (p.tiltContext != null) {
            this.tiltContext = new TiltContext(p.tiltContext);
        } else {
            this.tiltContext = null;
        }
    }

    public void reset() {
        this.brightness = 0;
        this.contrast = 0;
        this.temperature = 0;
        this.saturation = 50;
        this.tint = 0;
        this.selectedTextureIndex = 0;
        this.selectedBorderIndex = 0;
        this.selectedOverlayIndex = 0;
        this.selectedFilterIndex = 0;
        this.sharpen = 0.0f;
        this.blur = 0;
        this.highlight = 0.0f;
        this.shadow = 0.0f;
        if (this.tiltContext != null) {
            this.tiltContext.mode = TiltMode.NONE;
        }
    }

    public int getTemperature() {
        return -this.temperature;
    }

    public void setTemperature(int progress) {
        this.temperature = (progress - 50) * 2;
    }

    public void setTemperatureValue(int value) {
        this.temperature = value;
    }

    public void setContrast(int progress) {
        this.contrast = (progress - 50) * 2;
    }

    public void setContrastValue(int value) {
        this.contrast = value;
    }

    public void setBrightness(int progress) {
        int value = progress - 50;
        if (value < 0) {
            this.brightness = value * 3;
        } else {
            this.brightness = value * 5;
        }
    }

    public void setBrightnessValue(int value) {
        this.brightness = value;
    }

    public int getContrastProgress() {
        return (this.contrast / 2) + 50;
    }

    public int getBrightProgress() {
        if (this.brightness < 0) {
            return (this.brightness / 3) + 50;
        }
        return (this.brightness / 5) + 50;
    }

    public int getTemperatureProgress() {
        return (this.temperature / 2) + 50;
    }

    public void setSaturation(int progress) {
        this.saturation = progress;
    }

    public float getSaturation() {
        return ((float) this.saturation) / 50.0f;
    }

    public int getTint() {
        return this.tint;
    }

    public void setTint(int value) {
        this.tint = value - 50;
    }

    public void setTintValue(int value) {
        this.tint = value;
    }

    public int getTintProgressValue() {
        return this.tint + 50;
    }

    public int getSaturationProgressValue() {
        return this.saturation;
    }

    public void setSharpen(int value) {
        this.sharpen = ((float) value) / 100.0f;
    }

    public int getSharpenValue() {
        return (int) (this.sharpen * 100.0f);
    }

    public void setBlur(int value) {
        float radius = ((float) value) / 4.0f;
        if (radius > 25.0f) {
            radius = 25.0f;
        }
        this.blur = (int) radius;
    }

    public int getBlurValue() {
        return this.blur * 4;
    }

    public void setHighlight(int value) {
        this.highlight = ((float) (value - 50)) / 255.0f;
    }

    public int getHighlightValue() {
        return (int) ((this.highlight * 255.0f) + 50.0f);
    }

    public void setShadow(int value) {
        this.shadow = ((float) (value - 50)) / 255.0f;
    }

    public int getShadowValue() {
        return (int) ((this.shadow * 255.0f) + 50.0f);
    }

    public TiltContext getTiltContext() {
        return this.tiltContext;
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeInt(this.brightness);
        oos.writeInt(this.contrast);
        oos.writeInt(this.temperature);
        oos.writeInt(this.saturation);
        oos.writeInt(this.tint);
        oos.writeInt(this.selectedTextureIndex);
        oos.writeInt(this.selectedBorderIndex);
        oos.writeInt(this.selectedOverlayIndex);
        oos.writeInt(this.selectedFilterIndex);
        oos.writeInt(this.seekBarMode);
        oos.writeFloat(this.sharpen);
        oos.writeInt(this.blur);
        oos.writeFloat(this.highlight);
        oos.writeFloat(this.shadow);
        oos.writeInt(this.id);
        oos.writeObject(this.tiltContext);
    }

    private void readObject(ObjectInputStream ois) throws Exception, ClassNotFoundException {
        ois.defaultReadObject();
        this.brightness = ois.readInt();
        this.contrast = ois.readInt();
        this.temperature = ois.readInt();
        this.saturation = ois.readInt();
        this.tint = ois.readInt();
        this.selectedTextureIndex = ois.readInt();
        this.selectedBorderIndex = ois.readInt();
        this.selectedOverlayIndex = ois.readInt();
        this.selectedFilterIndex = ois.readInt();
        this.seekBarMode = ois.readInt();
        try {
            this.sharpen = ois.readFloat();
            this.blur = ois.readInt();
            this.highlight = ois.readFloat();
            this.shadow = ois.readFloat();
            this.id = ois.readInt();
            this.tiltContext = (TiltContext) ois.readObject();
        } catch (Exception e) {
        }
    }

    public Parameter(Parcel in) {
        this.brightness = in.readInt();
        this.contrast = in.readInt();
        this.temperature = in.readInt();
        this.saturation = in.readInt();
        this.tint = in.readInt();
        this.selectedTextureIndex = in.readInt();
        this.selectedBorderIndex = in.readInt();
        this.selectedOverlayIndex = in.readInt();
        this.selectedFilterIndex = in.readInt();
        this.seekBarMode = in.readInt();
        this.sharpen = in.readFloat();
        this.blur = in.readInt();
        this.highlight = in.readFloat();
        this.shadow = in.readFloat();
        this.id = in.readInt();
        this.tiltContext = (TiltContext) in.readParcelable(TiltContext.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int arg1) {
        out.writeInt(this.brightness);
        out.writeInt(this.contrast);
        out.writeInt(this.temperature);
        out.writeInt(this.saturation);
        out.writeInt(this.tint);
        out.writeInt(this.selectedTextureIndex);
        out.writeInt(this.selectedBorderIndex);
        out.writeInt(this.selectedOverlayIndex);
        out.writeInt(this.selectedFilterIndex);
        out.writeInt(this.seekBarMode);
        out.writeFloat(this.sharpen);
        out.writeInt(this.blur);
        out.writeFloat(this.highlight);
        out.writeFloat(this.shadow);
        out.writeInt(this.id);
        out.writeParcelable(this.tiltContext, arg1);
    }
}
