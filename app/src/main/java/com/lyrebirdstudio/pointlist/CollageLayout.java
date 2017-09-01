package com.lyrebirdstudio.pointlist;

import android.graphics.PointF;

import java.util.ArrayList;
import java.util.List;

public class CollageLayout {
    boolean checkForConcavite = false;
    public int[][] exceptionIndexForShapes = ((int[][]) null);
    boolean isScalable = false;
    public List<MaskPair> maskPairList = new ArrayList();
    public List<MaskPairSvg> maskPairListSvg = new ArrayList();
    int porterDuffClearBorderIntex = -1;
    public List<PointF[]> shapeList;
    public boolean useLine = true;

    public CollageLayout(List<PointF[]> shapeList) {
        this.shapeList = shapeList;
    }

    public int[] getexceptionIndex(int index) {
        if (this.exceptionIndexForShapes == null || index >= this.exceptionIndexForShapes.length || index < 0) {
            return null;
        }
        return this.exceptionIndexForShapes[index];
    }

    public void setClearIndex(int index) {
        if (index >= 0 && index < this.shapeList.size()) {
            this.porterDuffClearBorderIntex = index;
        }
    }

    public boolean getConcavite() {
        return this.checkForConcavite;
    }

    public void setScalibility(boolean scalebility) {
        this.isScalable = scalebility;
    }

    public int getClearIndex() {
        return this.porterDuffClearBorderIntex;
    }

    public boolean getScalibility() {
        return this.isScalable;
    }
}
