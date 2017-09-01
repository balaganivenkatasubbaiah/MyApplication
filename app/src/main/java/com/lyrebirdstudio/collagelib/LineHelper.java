package com.lyrebirdstudio.collagelib;

import android.graphics.Point;
import android.graphics.PointF;

import java.util.ArrayList;

public class LineHelper {
    private static final String TAG = "LineHelper";
    float epsilon = 0.001f;
    ArrayList<GridLine> gridLines = new ArrayList();
    float maxHeight;
    float maxWidth;
    float minDistance = 175.0f;
    int selectedLine = -1;
    int sentinel = 0;
    ArrayList<ArrayList<PointF>> shapeList = new ArrayList();
    public boolean useLine;

    public LineHelper(ArrayList<ArrayList<PointF>> s, float width, float height, boolean use) {
        this.shapeList = s;
        this.maxWidth = width;
        this.maxHeight = height;
        this.useLine = use;
    }

    void findGridLines() {
        int i;
        if (this.gridLines == null) {
            this.gridLines = new ArrayList();
        } else {
            this.gridLines.clear();
        }
        for (i = 0; i < this.shapeList.size(); i++) {
            for (int j = 0; j < ((ArrayList) this.shapeList.get(i)).size(); j++) {
                int beforeIndex = j - 1;
                int afterIndex = j + 2;
                if (beforeIndex < 0) {
                    beforeIndex = ((ArrayList) this.shapeList.get(i)).size() - 1;
                }
                if (afterIndex == ((ArrayList) this.shapeList.get(i)).size()) {
                    afterIndex = 0;
                }
                if (afterIndex == ((ArrayList) this.shapeList.get(i)).size() + 1) {
                    afterIndex = 1;
                }
                PointF before = (PointF) ((ArrayList) this.shapeList.get(i)).get(beforeIndex);
                PointF after = (PointF) ((ArrayList) this.shapeList.get(i)).get(afterIndex);
                int h = j + 1;
                if (h > ((ArrayList) this.shapeList.get(i)).size() - 1) {
                    h = 0;
                }
                PointF p1 = (PointF) ((ArrayList) this.shapeList.get(i)).get(j);
                PointF p2 = (PointF) ((ArrayList) this.shapeList.get(i)).get(h);
                Point index1 = new Point(i, j);
                Point index2 = new Point(i, h);
                Point indexBefore = new Point(i, beforeIndex);
                Point indexAfter = new Point(i, afterIndex);
                GridLine gridLine;
                if (i == 0) {
                    gridLine = new GridLine(p1, p2, index1, index2);
                    gridLine.distanceList.add(new PointF((-p1.x) + before.x, (-p1.y) + before.y));
                    gridLine.distanceList.add(new PointF((-p2.x) + after.x, (-p2.y) + after.y));
                    gridLine.distanceIndexList.add(indexBefore);
                    gridLine.distanceIndexList.add(indexAfter);
                    this.gridLines.add(gridLine);
                } else {
                    boolean added = false;
                    for (int q = 0; q < this.gridLines.size(); q++) {
                        if (((GridLine) this.gridLines.get(q)).shouldAddLineSegment(p1, p2)) {
                            ((GridLine) this.gridLines.get(q)).addPoints(p1, p2, index1, index2);
                            ((GridLine) this.gridLines.get(q)).distanceList.add(new PointF((-p1.x) + before.x, (-p1.y) + before.y));
                            ((GridLine) this.gridLines.get(q)).distanceList.add(new PointF((-p2.x) + after.x, (-p2.y) + after.y));
                            ((GridLine) this.gridLines.get(q)).distanceIndexList.add(indexBefore);
                            ((GridLine) this.gridLines.get(q)).distanceIndexList.add(indexAfter);
                            added = true;
                            break;
                        }
                    }
                    if (!added) {
                        gridLine = new GridLine(p1, p2, index1, index2);
                        gridLine.distanceList.add(new PointF((-p1.x) + before.x, (-p1.y) + before.y));
                        gridLine.distanceList.add(new PointF((-p2.x) + after.x, (-p2.y) + after.y));
                        gridLine.distanceIndexList.add(indexBefore);
                        gridLine.distanceIndexList.add(indexAfter);
                        this.gridLines.add(gridLine);
                    }
                }
            }
        }
        calulateSlopesForPoints();
        mergeLines();
        for (i = 0; i < this.gridLines.size(); i++) {
            ((GridLine) this.gridLines.get(i)).isSide(this.maxWidth, this.maxHeight);
            ((GridLine) this.gridLines.get(i)).findMinMaxDistance();
            ((GridLine) this.gridLines.get(i)).setPointHandle(i % 2 == 1);
        }
    }

    void mergeLines() {
        mergeLoop();
    }

    void mergeLoop() {
        int i = 0;
        while (i < this.gridLines.size()) {
            int j = 0;
            while (j < this.gridLines.size()) {
                if (i != j && ((GridLine) this.gridLines.get(i)).compareSloples(((GridLine) this.gridLines.get(j)).slope)) {
                    for (int q = 0; q < ((GridLine) this.gridLines.get(i)).pointArrayList.size(); q++) {
                        int r = 0;
                        while (r < ((GridLine) this.gridLines.get(j)).pointArrayList.size()) {
                            PointF p1 = (PointF) ((GridLine) this.gridLines.get(i)).pointArrayList.get(q);
                            PointF p2 = (PointF) ((GridLine) this.gridLines.get(j)).pointArrayList.get(r);
                            if (Math.abs(p1.x - p2.x) >= this.epsilon || Math.abs(p1.y - p2.y) >= this.epsilon) {
                                r++;
                            } else {
                                actualMerge(i, j);
                                mergeLines();
                                return;
                            }
                        }
                    }
                    continue;
                }
                j++;
            }
            i++;
        }
    }

    void actualMerge(int i, int j) {
        ((GridLine) this.gridLines.get(i)).merge((GridLine) this.gridLines.get(j));
        this.gridLines.remove(j);
    }

    void updateGridLines() {
        for (int i = 0; i < this.gridLines.size(); i++) {
            GridLine gridLine = (GridLine) this.gridLines.get(i);
            for (int j = 0; j < gridLine.indexArrayList.size(); j++) {
                Point index = (Point) gridLine.indexArrayList.get(j);
                PointF q = (PointF) ((ArrayList) this.shapeList.get(index.x)).get(index.y);
                ((PointF) gridLine.pointArrayList.get(j)).set(q.x, q.y);
            }
            gridLine.setAbc((PointF) gridLine.pointArrayList.get(0), (PointF) gridLine.pointArrayList.get(1));
        }
    }

    void calulateSlopesForPoints() {
        for (int i = 0; i < this.gridLines.size(); i++) {
            GridLine gridLine = (GridLine) this.gridLines.get(i);
            for (int j = 0; j < gridLine.indexArrayList.size(); j++) {
                gridLine.slopeArrayList.add(Float.valueOf(findPointInLine(i, (Point) gridLine.indexArrayList.get(j))));
            }
        }
    }

    float findPointInLine(int except, Point index) {
        for (int i = 0; i < this.gridLines.size(); i++) {
            if (i != except) {
                GridLine gridLine = (GridLine) this.gridLines.get(i);
                int j = 0;
                while (j < gridLine.indexArrayList.size()) {
                    if (((Point) gridLine.indexArrayList.get(j)).x == index.x && ((Point) gridLine.indexArrayList.get(j)).y == index.y) {
                        return gridLine.slope;
                    }
                    j++;
                }
                continue;
            }
        }
        return (float) this.sentinel;
    }

    float checkMoveX(float dx) {
        GridLine gridLine = (GridLine) this.gridLines.get(this.selectedLine);
        Point indPos = (Point) gridLine.distanceIndexList.get(gridLine.minXIndex);
        Point indNeg = (Point) gridLine.distanceIndexList.get(gridLine.minXIndexNegative);
        float positiveMinDistance = gridLine.distance((PointF) ((ArrayList) this.shapeList.get(indPos.x)).get(indPos.y));
        float negativeMinDistance = gridLine.distance((PointF) ((ArrayList) this.shapeList.get(indNeg.x)).get(indNeg.y));
        if (dx >= 0.0f && dx < positiveMinDistance - this.minDistance) {
            return dx;
        }
        if (dx < 0.0f && (-dx) < negativeMinDistance - this.minDistance) {
            return dx;
        }
        if (dx >= 0.0f) {
            return positiveMinDistance - this.minDistance;
        }
        return dx < 0.0f ? (-negativeMinDistance) + this.minDistance : 0.0f;
    }

    float checkMoveY(float dy) {
        GridLine gridLine = (GridLine) this.gridLines.get(this.selectedLine);
        Point indPos = (Point) gridLine.distanceIndexList.get(gridLine.minYIndex);
        Point indNeg = (Point) gridLine.distanceIndexList.get(gridLine.minYIndexNegative);
        float positiveMinDistance = gridLine.distance((PointF) ((ArrayList) this.shapeList.get(indPos.x)).get(indPos.y));
        float negativeMinDistance = gridLine.distance((PointF) ((ArrayList) this.shapeList.get(indNeg.x)).get(indNeg.y));
        if (dy >= 0.0f && dy < positiveMinDistance - this.minDistance) {
            return dy;
        }
        if (dy < 0.0f && (-dy) < negativeMinDistance - this.minDistance) {
            return dy;
        }
        if (dy >= 0.0f) {
            return positiveMinDistance - this.minDistance;
        }
        return dy < 0.0f ? (-negativeMinDistance) + this.minDistance : 0.0f;
    }

    void moveGridLines(float dxx, float dyy) {
        if (this.gridLines != null && this.gridLines.get(this.selectedLine) != null && ((GridLine) this.gridLines.get(this.selectedLine)).indexArrayList != null) {
            int i;
            for (i = 0; i < ((GridLine) this.gridLines.get(this.selectedLine)).indexArrayList.size(); i++) {
                Point index = (Point) ((GridLine) this.gridLines.get(this.selectedLine)).indexArrayList.get(i);
                boolean moveX = false;
                if (((GridLine) this.gridLines.get(this.selectedLine)).slope > 1.0f || ((GridLine) this.gridLines.get(this.selectedLine)).slope < -1.0f) {
                    moveX = true;
                }
                float dx = checkMoveX(dxx);
                float dy = checkMoveY(dyy);
                float orthoSlope;
                PointF pointF;
                if (moveX && Math.abs(dx) > this.epsilon) {
                    orthoSlope = ((Float) ((GridLine) this.gridLines.get(this.selectedLine)).slopeArrayList.get(i)).floatValue();
                    pointF = (PointF) ((ArrayList) this.shapeList.get(index.x)).get(index.y);
                    pointF.x += dx;
                    if (!Float.isInfinite(orthoSlope)) {
                        pointF = (PointF) ((ArrayList) this.shapeList.get(index.x)).get(index.y);
                        pointF.y += dx * orthoSlope;
                    }
                    if (i == 0) {
                        ((GridLine) this.gridLines.get(this.selectedLine)).addToDx(dx);
                        if (!Float.isInfinite(orthoSlope)) {
                            ((GridLine) this.gridLines.get(this.selectedLine)).addToDy(dx * orthoSlope);
                        }
                    }
                } else if (!moveX && Math.abs(dy) > this.epsilon) {
                    orthoSlope = ((Float) ((GridLine) this.gridLines.get(this.selectedLine)).slopeArrayList.get(i)).floatValue();
                    pointF = (PointF) ((ArrayList) this.shapeList.get(index.x)).get(index.y);
                    pointF.y += dy;
                    if (Math.abs(orthoSlope - this.epsilon) > 0.0f) {
                        pointF = (PointF) ((ArrayList) this.shapeList.get(index.x)).get(index.y);
                        pointF.x += dy / orthoSlope;
                    }
                    if (i == 0) {
                        ((GridLine) this.gridLines.get(this.selectedLine)).addToDy(dy);
                        if (Math.abs(orthoSlope - this.epsilon) > 0.0f) {
                            ((GridLine) this.gridLines.get(this.selectedLine)).addToDx(dy / orthoSlope);
                        }
                    }
                }
            }
            for (i = 0; i < this.gridLines.size(); i++) {
                boolean z;
                GridLine gridLine = (GridLine) this.gridLines.get(i);
                gridLine.distanceList.clear();
                for (int g = 0; g < gridLine.distanceIndexList.size(); g += 2) {
                    PointF before = (PointF) ((ArrayList) this.shapeList.get(((Point) gridLine.distanceIndexList.get(g)).x)).get(((Point) gridLine.distanceIndexList.get(g)).y);
                    PointF after = (PointF) ((ArrayList) this.shapeList.get(((Point) gridLine.distanceIndexList.get(g + 1)).x)).get(((Point) gridLine.distanceIndexList.get(g + 1)).y);
                    PointF p1 = (PointF) gridLine.pointArrayList.get(g);
                    PointF p2 = (PointF) gridLine.pointArrayList.get(g + 1);
                    gridLine.distanceList.add(new PointF((-p1.x) + before.x, (-p1.y) + before.y));
                    gridLine.distanceList.add(new PointF((-p2.x) + after.x, (-p2.y) + after.y));
                }
                ((GridLine) this.gridLines.get(i)).findMinMaxDistance();
                GridLine gridLine2 = (GridLine) this.gridLines.get(i);
                if (i % 2 == 1) {
                    z = true;
                } else {
                    z = false;
                }
                gridLine2.setPointHandle(z);
            }
        }
    }
}
