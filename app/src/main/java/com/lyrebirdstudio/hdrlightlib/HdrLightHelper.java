package com.lyrebirdstudio.hdrlightlib;

import android.content.Context;
import android.graphics.Bitmap;

import com.lyrebirdstudio.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HdrLightHelper {
    ArrayList<HdrParameter> hdrParameterArrayList;

    /*static native void applyAdjustment(Bitmap bitmap, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int i, int i2, int i3, float f, float f2, float f3, float f4, float f5, int i4, float f6, float f7, float f8, int i5, int i6, int i7, int i8, float f9);

    static native void renderPlasma2(Bitmap bitmap, int i, int i2, float f, float f2, int i3, float f3, float f4, int i4);*/

    public HdrLightHelper(Context context) {
        this.hdrParameterArrayList = createHdrParameterList(context);
    }

    public void applyHdr(Bitmap bitmap, int index) {
        callHdrLight(bitmap, (HdrParameter) this.hdrParameterArrayList.get(index));
    }

    public static ArrayList<HdrParameter> createHdrParameterList(Context context) {
        ArrayList<HdrParameter> parameterList = new ArrayList();
        HdrParameter firstParameter = new HdrParameter();
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.autumn));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.basic));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.cp0));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.basicgreen));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.basicwarm));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.bluehdr));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.cporiginal));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.pink));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.retrox));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.cfr));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.darkhdr));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.deneysel));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.depblue));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.dx));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.bluehdr2));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.cmylmz));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.pink2));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.elegant));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.hdrsimple));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.retro1));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.greenx));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.weirdo));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.retrosepia));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.gangam));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.hhdrx));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.interest));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.nostalgic));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.retro4));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.vignette));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.old1));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.old2));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.old3));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.old4));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.old5));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.bw));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.bw2));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.bw3));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.bw4));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.bw5));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.bw6));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.bw8));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.bw9));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.bw10));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.us1));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.us2));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.painty));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.paint));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.cartt));
        parameterList.add(HdrParameter.loadParametersFromResources(context, R.raw.acaip));
        return parameterList;
    }

    public static void callHdrLight(Bitmap bitmap, HdrParameter parameterGlobal) {
      /*  renderPlasma2(bitmap, parameterGlobal.lowSaturation, parameterGlobal.highSaturation, parameterGlobal.power, parameterGlobal.blur, parameterGlobal.umEnabled, parameterGlobal.umPower, parameterGlobal.umBlur, parameterGlobal.umThreshold);
        Bitmap bitmap2 = bitmap;
        applyAdjustment(bitmap2, parameterGlobal.rgb, parameterGlobal.red, parameterGlobal.green, parameterGlobal.blue, parameterGlobal.contrast, parameterGlobal.brightness, parameterGlobal.temperature, parameterGlobal.minInput, parameterGlobal.gamma, parameterGlobal.maxInput, parameterGlobal.minOutput, parameterGlobal.maxOutput, parameterGlobal.applyVignette, parameterGlobal.range, parameterGlobal.slope, parameterGlobal.shade, parameterGlobal.offsetLeft, parameterGlobal.offsetTop, bitmap.getWidth() + parameterGlobal.offsetLeft, bitmap.getHeight() + parameterGlobal.offsetTop, parameterGlobal.getSaturation());*/
    }

    public static void calcululateCurve(MyPoint[] points, int[] result) {
        double[] sd = secondDerivative(points);
        for (int i = 0; i < points.length - 1; i++) {
            int j;
            MyPoint cur = points[i];
            MyPoint next = points[i + 1];
            if (i == 0 && cur.x > 0) {
                for (j = 0; j < cur.x; j++) {
                    if (j < 256) {
                        result[j] = Math.round((float) cur.y);
                        if (result[j] < 0) {
                            result[j] = 0;
                        }
                        if (result[j] > 255) {
                            result[j] = 255;
                        }
                    }
                }
            }
            for (int x = cur.x; x < next.x; x++) {
                double t = ((double) (x - cur.x)) / ((double) (next.x - cur.x));
                double a = 1.0d - t;
                double b = t;
                double h = (double) (next.x - cur.x);
                double y = ((((double) cur.y) * a) + (((double) next.y) * b)) + (((h * h) / 6.0d) * (((((a * a) * a) - a) * sd[i]) + ((((b * b) * b) - b) * sd[i + 1])));
                if (x < 256) {
                    result[x] = (int) Math.round(y);
                    if (result[x] < 0) {
                        result[x] = 0;
                    }
                    if (result[x] > 255) {
                        result[x] = 255;
                    }
                }
            }
            if (i == points.length - 2 && next.x < 255) {
                for (j = next.x; j < 256; j++) {
                    if (j < 256) {
                        result[j] = Math.round((float) next.y);
                        if (result[j] < 0) {
                            result[j] = 0;
                        }
                        if (result[j] > 255) {
                            result[j] = 255;
                        }
                    }
                }
            }
        }
    }

    public static double[] secondDerivative(MyPoint... P) {
        int i;
        int n = P.length;
        double[][] matrix = (double[][]) Array.newInstance(Double.TYPE, new int[]{n, 3});
        double[] result = new double[n];
        matrix[0][1] = 1.0d;
        for (i = 1; i < n - 1; i++) {
            matrix[i][0] = ((double) (P[i].x - P[i - 1].x)) / 6.0d;
            matrix[i][1] = ((double) (P[i + 1].x - P[i - 1].x)) / 3.0d;
            matrix[i][2] = ((double) (P[i + 1].x - P[i].x)) / 6.0d;
            result[i] = (((double) (P[i + 1].y - P[i].y)) / ((double) (P[i + 1].x - P[i].x))) - (((double) (P[i].y - P[i - 1].y)) / ((double) (P[i].x - P[i - 1].x)));
        }
        matrix[n - 1][1] = 1.0d;
        for (i = 1; i < n; i++) {
            double k = matrix[i][0] / matrix[i - 1][1];
            double[] dArr = matrix[i];
            dArr[1] = dArr[1] - (matrix[i - 1][2] * k);
            matrix[i][0] = 0.0d;
            result[i] = result[i] - (result[i - 1] * k);
        }
        for (i = n - 2; i >= 0; i--) {
            double k = matrix[i][2] / matrix[i + 1][1];
            double[] dArr = matrix[i];
            dArr[1] = dArr[1] - (matrix[i + 1][0] * k);
            matrix[i][2] = 0.0d;
            result[i] = result[i] - (result[i + 1] * k);
        }
        double[] y2 = new double[n];
        for (i = 0; i < n; i++) {
            y2[i] = result[i] / matrix[i][1];
        }
        return y2;
    }
}
