package com.lyrebirdstudio.collagelib;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Xfermode;
import android.graphics.drawable.NinePatchDrawable;

import com.lyrebirdstudio.pointlist.Collage;
import com.lyrebirdstudio.svg.Svg;

public class Shape {
    public static final int MATRIX_MODE_CENTER = 1;
    public static final int MATRIX_MODE_FIT = 0;
    public static final int MATRIX_MODE_FLIP_HORIZONTAL = 4;
    public static final int MATRIX_MODE_FLIP_VERTICAL = 5;
    public static final int MATRIX_MODE_MOVE_DOWN = 13;
    public static final int MATRIX_MODE_MOVE_LEFT = 10;
    public static final int MATRIX_MODE_MOVE_RIGHT = 11;
    public static final int MATRIX_MODE_MOVE_UP = 12;
    public static final int MATRIX_MODE_ROTATE_LEFT = 3;
    public static final int MATRIX_MODE_ROTATE_NEGATIVE = 6;
    public static final int MATRIX_MODE_ROTATE_POSITIVE = 7;
    public static final int MATRIX_MODE_ROTATE_RIGHT = 2;
    public static final int MATRIX_MODE_ZOOM_IN = 8;
    public static final int MATRIX_MODE_ZOOM_OUT = 9;
    public static final int MESSAGE_DEFAULT = 0;
    public static final int MESSAGE_MAX_BOTTOM = 6;
    public static final int MESSAGE_MAX_LEFT = 3;
    public static final int MESSAGE_MAX_RIGHT = 4;
    public static final int MESSAGE_MAX_TOP = 5;
    public static final int MESSAGE_MAX_ZOOM = 1;
    public static final int MESSAGE_MIN_ZOOM = 2;
    public static final int SHAPE_MODE_INNER_POINT = 4;
    public static final int SHAPE_MODE_MASK = 3;
    public static final int SHAPE_MODE_POINT = 1;
    public static final int SHAPE_MODE_RECT = 2;
    public static final int SHAPE_MODE_SVG = 5;
    private static final String TAG = Shape.class.getSimpleName();
    private static final int[] scrapBookRotation = new int[]{13, -13, -7, -12, 11, 8, -9, 10, 9};
    private Bitmap bitmap;
    private int bitmapHeight;
    Matrix bitmapMatrix;
    private RectF bitmapRect;
    private int bitmapWidth;
    private Paint borderPaint;
    private int borderStrokeWidth;
    RectF bounds;
    Bitmap btmDelete;
    Bitmap btmScale;
    private PointF centerOriginal;
    boolean checkForConcavite;
    private Paint dashPaint;
    private Path dashPathHorizontal;
    private Path dashPathVertical;
    private int delW;
    private float deleteWidthHalf;
    float dx;
    float dy;
    int[] exceptionIndex;
    float[] f867f;
    private Paint iconMaskPaint;
    private Paint iconPaint;
    private Xfermode iconXferMode;
    private Matrix inverse;
    boolean isScrapBook;
    private Bitmap maskBitmap;
    private Matrix maskMatrix;
    Paint maskPaint;
    float maxScale;
    float minScale;
    NinePatchDrawable npd;
    int npdPadding;
    int offsetX;
    int offsetY;
    RectF originalBounds;
    Path originalPath;
    float[] f868p;
    private Paint paintLine;
    private Paint paintPath;
    private Paint paintScrap;
    Paint paintSoloBorder;
    private Paint paintTransparent;
    Paint paintXferMode;
    Path path;
    Matrix pathMatrix;
    PointF[] points;
    private float[] pts;
    RectF f869r;
    Region region;
    private Matrix removeBitmapMatrix;
    private Matrix scaleBitmapMatrix;
    private float scaleDown;
    private float scaleUp;
    private float scrapBookPadding;
    int screenWidth;
    int shapeMode;
    RectF sourceRect;
    private int svgClearFixPadding;
    int svgIndex;
    RectF tempRect;
    private final float tempScrapBookPadding;
    private float tempTouchStrokeWidth;
    private Paint touchPaint;
    private RectF touchRect;
    private float touchStrokeWidth;
    Matrix transparentMaskMatrix;
    float[] f870v;
    private float[] values;
    int viewH;
    int viewW;

    public Shape(PointF[] points, Bitmap b, int[] exceptionIndex, int offsetX, int offsetY, boolean isScrapBook, int index, boolean isDelete, Bitmap del, Bitmap scl, int screenWidth, int shapeModeParam, boolean checkForConcavite, int w, int h) {
        this.offsetY = 0;
        this.offsetX = 0;
        this.maskBitmap = null;
        this.maskMatrix = new Matrix();
        this.transparentMaskMatrix = new Matrix();
        this.checkForConcavite = false;
        this.svgIndex = -1;
        this.f870v = new float[9];
        this.tempRect = new RectF();
        this.svgClearFixPadding = 2;
        this.f869r = new RectF();
        this.minScale = 1.0f;
        this.maxScale = 1.0f;
        this.bitmapRect = new RectF();
        this.f868p = new float[2];
        this.dx = 0.0f;
        this.dy = 0.0f;
        this.scaleDown = 0.95f;
        this.scaleUp = 1.05f;
        this.f867f = new float[2];
        this.centerOriginal = new PointF();
        this.touchPaint = new Paint(1);
        this.borderPaint = new Paint(1);
        this.paintScrap = new Paint(2);
        this.pts = new float[2];
        this.inverse = new Matrix();
        this.tempScrapBookPadding = 25.0f;
        this.scrapBookPadding = 25.0f;
        this.tempTouchStrokeWidth = 8.0f;
        this.touchStrokeWidth = this.tempTouchStrokeWidth;
        this.values = new float[9];
        this.borderStrokeWidth = 6;
        this.dashPaint = new Paint();
        this.delW = 0;
        this.deleteWidthHalf = 0.0f;
        this.npdPadding = 16;
        this.points = points;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.btmDelete = del;
        this.btmScale = scl;
        this.screenWidth = screenWidth;
        this.isScrapBook = isScrapBook;
        this.checkForConcavite = checkForConcavite;
        createPathFromPoints(false);
        this.path.offset((float) offsetX, (float) offsetY);
        this.exceptionIndex = exceptionIndex;
        this.bitmap = b;
        this.bitmapWidth = this.bitmap.getWidth();
        this.bitmapHeight = this.bitmap.getHeight();
        this.shapeMode = shapeModeParam;
        this.viewW = w;
        this.viewH = h;
        init(isScrapBook, index, false, 0, 0);
    }

    public Shape(PointF[] points, Bitmap b, int[] exceptionIndex, int offsetX, int offsetY, boolean isScrapBook, int index, boolean isDelete, Bitmap del, Bitmap scl, int screenWidth, boolean checkForConcavite, int svgIndex, int w, int h) {
        this.offsetY = 0;
        this.offsetX = 0;
        this.maskBitmap = null;
        this.maskMatrix = new Matrix();
        this.transparentMaskMatrix = new Matrix();
        this.checkForConcavite = false;
        this.svgIndex = -1;
        this.f870v = new float[9];
        this.tempRect = new RectF();
        this.svgClearFixPadding = 2;
        this.f869r = new RectF();
        this.minScale = 1.0f;
        this.maxScale = 1.0f;
        this.bitmapRect = new RectF();
        this.f868p = new float[2];
        this.dx = 0.0f;
        this.dy = 0.0f;
        this.scaleDown = 0.95f;
        this.scaleUp = 1.05f;
        this.f867f = new float[2];
        this.centerOriginal = new PointF();
        this.touchPaint = new Paint(1);
        this.borderPaint = new Paint(1);
        this.paintScrap = new Paint(2);
        this.pts = new float[2];
        this.inverse = new Matrix();
        this.tempScrapBookPadding = 25.0f;
        this.scrapBookPadding = 25.0f;
        this.tempTouchStrokeWidth = 8.0f;
        this.touchStrokeWidth = this.tempTouchStrokeWidth;
        this.values = new float[9];
        this.borderStrokeWidth = 6;
        this.dashPaint = new Paint();
        this.delW = 0;
        this.deleteWidthHalf = 0.0f;
        this.npdPadding = 16;
        this.points = points;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.btmDelete = del;
        this.btmScale = scl;
        this.screenWidth = screenWidth;
        this.isScrapBook = isScrapBook;
        this.checkForConcavite = checkForConcavite;
        createPathFromPoints(false);
        this.path.offset((float) offsetX, (float) offsetY);
        this.exceptionIndex = exceptionIndex;
        this.bitmap = b;
        this.bitmapWidth = this.bitmap.getWidth();
        this.bitmapHeight = this.bitmap.getHeight();
        this.shapeMode = 5;
        this.svgIndex = svgIndex;
        this.viewW = w;
        this.viewH = h;
        init(isScrapBook, index, false, 0, 0);
    }

    public void changeRatio(PointF[] points, int[] exceptionIndex, int offsetX, int offsetY, boolean isScrapBook, int index, int w, int h) {
        this.points = points;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        createPathFromPoints(false);
        this.path.offset((float) offsetX, (float) offsetY);
        this.exceptionIndex = exceptionIndex;
        this.viewW = w;
        this.viewH = h;
        init(isScrapBook, index, true, w, h);
    }

    public void updateFromLine(PointF[] points) {
        this.points = points;
        createPathFromPoints(true);
        this.path.offset((float) this.offsetX, (float) this.offsetY);
        this.path.computeBounds(this.bounds, true);
        this.region = new Region();
        this.region.setPath(this.path, new Region((int) this.bounds.left, (int) this.bounds.top, (int) this.bounds.right, (int) this.bounds.bottom));
    }

    public void freeBitmaps() {
        if (!(this.bitmap == null || this.bitmap.isRecycled())) {
            this.bitmap.recycle();
        }
        if (this.maskBitmap != null && !this.maskBitmap.isRecycled()) {
            this.maskBitmap = null;
        }
    }

    public void setRadius(CornerPathEffect corEffect) {
        this.paintPath.setPathEffect(corEffect);
        this.paintTransparent.setPathEffect(corEffect);
    }

    public float smallestDistance() {
        float smallestDistance = 1500.0f;
        for (int i = 0; i < this.points.length; i++) {
            for (int j = 0; j < this.points.length; j++) {
                if (i != j) {
                    float distance = Math.abs(this.points[i].x - this.points[j].x) + Math.abs(this.points[i].y - this.points[j].y);
                    if (distance < smallestDistance) {
                        smallestDistance = distance;
                    }
                }
            }
        }
        if (this.shapeMode == 3 || this.shapeMode == 4 || this.shapeMode == 5) {
            return smallestDistance / 2.0f;
        }
        return smallestDistance;
    }

    public void init(boolean isScrapBook, int index, boolean isChangeRatio, int w, int h) {
        this.bounds = new RectF();
        this.originalPath = new Path(this.path);
        this.path.computeBounds(this.bounds, true);
        this.originalBounds = new RectF(this.bounds);
        this.paintSoloBorder = new Paint(1);
        this.paintSoloBorder.setStyle(Style.STROKE);
        this.paintSoloBorder.setStrokeWidth(Svg.strokeSize);
        this.paintSoloBorder.setColor(Svg.colorStroke);
        this.paintXferMode = new Paint(1);
        this.paintXferMode.setFilterBitmap(true);
        this.paintXferMode.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        this.paintPath = new Paint(1);
        this.paintPath.setFilterBitmap(true);
        this.maskPaint = new Paint(1);
        this.maskPaint.setFilterBitmap(true);
        this.paintLine = new Paint(1);
        this.paintLine.setColor(-16711936);
        this.paintLine.setStyle(Style.STROKE);
        this.paintLine.setStrokeWidth(10.0f);
        this.paintTransparent = new Paint(1);
        this.paintTransparent.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        this.paintTransparent.setFilterBitmap(true);
        if (isScrapBook) {
            setScrapBookBitmapPosition(index, isChangeRatio, w, h);
        } else {
            setBitmapPosition(!CollageActivity.isGridLayoutLocked);
        }
        this.paintPath.setPathEffect(new CornerPathEffect(3.0f));
        this.pathMatrix = new Matrix();
        this.region = new Region();
        this.region.setPath(this.path, new Region((int) this.bounds.left, (int) this.bounds.top, (int) this.bounds.right, (int) this.bounds.bottom));
        if (isScrapBook) {
            this.dashPaint.setColor(-7829368);
            this.dashPaint.setStyle(Style.STROKE);
            float strokeW = ((float) this.screenWidth) / 120.0f;
            if (strokeW <= 0.0f) {
                strokeW = 5.0f;
            }
            this.dashPaint.setStrokeWidth(strokeW);
            this.dashPaint.setPathEffect(new DashPathEffect(new float[]{strokeW, strokeW}, 0.0f));
            this.dashPathVertical = new Path();
            this.dashPathHorizontal = new Path();
            resetDashPaths();
        }
    }

    public void resetDashPaths() {
        if (this.dashPathVertical == null) {
            this.dashPathVertical = new Path();
        }
        this.dashPathVertical.reset();
        this.dashPathVertical.moveTo((float) (this.bitmapWidth / 2), (float) ((-this.bitmapHeight) / 5));
        this.dashPathVertical.lineTo((float) (this.bitmapWidth / 2), (float) ((this.bitmapHeight * 6) / 5));
        if (this.dashPathHorizontal == null) {
            this.dashPathHorizontal = new Path();
        }
        this.dashPathHorizontal.reset();
        this.dashPathHorizontal.moveTo((float) ((-this.bitmapWidth) / 5), (float) (this.bitmapHeight / 2));
        this.dashPathHorizontal.lineTo((float) ((this.bitmapWidth * 6) / 5), (float) (this.bitmapHeight / 2));
    }

    public void setBitmap(Bitmap bitmap, boolean isFilter) {
        this.bitmap = bitmap;
        this.bitmapWidth = bitmap.getWidth();
        this.bitmapHeight = bitmap.getHeight();
        if (!isFilter) {
            setBitmapPosition(!CollageActivity.isGridLayoutLocked);
        }
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    private void setBitmapPosition(boolean init) {
        RectF rrr;
        if (init) {
            rrr = this.originalBounds;
        } else {
            rrr = this.bounds;
        }
        float scaleBitmap = getBitmapScale(rrr);
        float bitmapY = rrr.top - (((((float) this.bitmapHeight) * scaleBitmap) - rrr.height()) / 2.0f);
        float bitmapX = rrr.left - (((((float) this.bitmapWidth) * scaleBitmap) - rrr.width()) / 2.0f);
        this.bitmapMatrix = new Matrix();
        this.bitmapMatrix.reset();
        this.bitmapMatrix.postScale(scaleBitmap, scaleBitmap);
        this.bitmapMatrix.postTranslate(bitmapX, bitmapY);
        if (this.shapeMode == 3) {
            setMaskBitmapPositions();
        }
        setMaxMinScales(scaleBitmap);
    }

    private float getBitmapScale(RectF rrr) {
        float scaleBitmapX = rrr.width() / ((float) this.bitmapWidth);
        float scaleBitmapY = rrr.height() / ((float) this.bitmapHeight);
        if (scaleBitmapX < scaleBitmapY) {
            return scaleBitmapY;
        }
        return scaleBitmapX;
    }

    private float getBitmapScaleRotated() {
        float scaleBitmapX;
        float scaleBitmapY;
        float rotation = getMatrixRotation(this.bitmapMatrix);
        if (rotation == 90.0f || rotation == 270.0f || rotation == -90.0f || rotation == -270.0f) {
            scaleBitmapX = this.bounds.width() / ((float) this.bitmapHeight);
            scaleBitmapY = this.bounds.height() / ((float) this.bitmapWidth);
        } else {
            scaleBitmapX = this.bounds.width() / ((float) this.bitmapWidth);
            scaleBitmapY = this.bounds.height() / ((float) this.bitmapHeight);
        }
        if (scaleBitmapX < scaleBitmapY) {
            return scaleBitmapY;
        }
        return scaleBitmapX;
    }

    float getMatrixRotation(Matrix matrix) {
        matrix.getValues(this.f870v);
        return (float) Math.round(Math.atan2((double) this.f870v[1], (double) this.f870v[0]) * 57.29577951308232d);
    }

    void setMaxMinScalesForLock() {
        if (CollageActivity.isGridLayoutLocked) {
            setMaxMinScalesRotated();
            checkScaleBoundries();
            checkBoundries(false);
            return;
        }
        setMaxMinScales(getBitmapScale(this.bounds));
    }

    void setMaxMinScales(float scaleBitmap) {
        if (this.isScrapBook || !CollageActivity.isGridLayoutLocked) {
            this.minScale = scaleBitmap / 2.0f;
        } else {
            this.minScale = scaleBitmap;
        }
        if (this.isScrapBook) {
            this.maxScale = scaleBitmap * 2.0f;
        } else {
            this.maxScale = 4.0f * scaleBitmap;
        }
    }

    void setMaxMinScalesRotated() {
        float scaleBitmap = getBitmapScaleRotated();
        this.minScale = scaleBitmap;
        this.maxScale = 4.0f * scaleBitmap;
    }

    void setMinScales(float scaleBitmap, boolean override) {
        if (this.isScrapBook || !(CollageActivity.isGridLayoutLocked || override)) {
            this.minScale = scaleBitmap / 2.0f;
        } else {
            this.minScale = scaleBitmap;
        }
    }

    private void setMaskBitmapPositions() {
        if (this.maskBitmap != null) {
            float scaleMaskBitmap;
            float scaleMaskBitmapTr;
            int maskBitmapWidth = this.maskBitmap.getWidth();
            int maskBitmapHeight = this.maskBitmap.getHeight();
            float scaleMaskBitmapX = this.bounds.width() / ((float) maskBitmapWidth);
            float scaleMaskBitmapY = this.bounds.height() / ((float) maskBitmapHeight);
            if (scaleMaskBitmapX > scaleMaskBitmapY) {
                scaleMaskBitmap = scaleMaskBitmapY;
            } else {
                scaleMaskBitmap = scaleMaskBitmapX;
            }
            float maskBitmapY = this.bounds.top - (((((float) maskBitmapHeight) * scaleMaskBitmap) - this.bounds.height()) / 2.0f);
            float maskBitmapX = this.bounds.left - (((((float) maskBitmapWidth) * scaleMaskBitmap) - this.bounds.width()) / 2.0f);
            this.maskMatrix = new Matrix();
            this.maskMatrix.reset();
            this.maskMatrix.postScale(scaleMaskBitmap, scaleMaskBitmap);
            this.maskMatrix.postTranslate(maskBitmapX, maskBitmapY);
            float scaleMaskBitmapXTr = this.originalBounds.width() / ((float) maskBitmapWidth);
            float scaleMaskBitmapYTr = this.originalBounds.height() / ((float) maskBitmapHeight);
            if (scaleMaskBitmapXTr > scaleMaskBitmapYTr) {
                scaleMaskBitmapTr = scaleMaskBitmapYTr;
            } else {
                scaleMaskBitmapTr = scaleMaskBitmapXTr;
            }
            float maskBitmapYTr = this.originalBounds.top - (((((float) maskBitmapHeight) * scaleMaskBitmapTr) - this.originalBounds.height()) / 2.0f);
            float maskBitmapXTr = this.originalBounds.left - (((((float) maskBitmapWidth) * scaleMaskBitmapTr) - this.originalBounds.width()) / 2.0f);
            this.transparentMaskMatrix = new Matrix();
            this.transparentMaskMatrix.reset();
            this.transparentMaskMatrix.postScale(scaleMaskBitmapTr, scaleMaskBitmapTr);
            this.transparentMaskMatrix.postTranslate(maskBitmapXTr, maskBitmapYTr);
        }
    }

    public void scalePath(float distance, float width, float height) {
        if (this.shapeMode == 1 || this.shapeMode == 4) {
            if (this.shapeMode == 4) {
                distance *= 2.0f;
            }
            pathTransform(this.points, this.path, distance);
        } else if (this.shapeMode == 2) {
            pathTransformFromRect(distance);
        } else {
            float scaleX = (this.originalBounds.width() - (4.0f * distance)) / this.originalBounds.width();
            float scaleY = (this.originalBounds.height() - (4.0f * distance)) / this.originalBounds.height();
            this.pathMatrix.reset();
            this.pathMatrix.setScale(scaleX, scaleY, this.originalBounds.centerX(), this.originalBounds.centerY());
            this.originalPath.transform(this.pathMatrix, this.path);
        }
        this.path.computeBounds(this.bounds, true);
        if (this.shapeMode == 3) {
            setMaskBitmapPositions();
        }
    }

    void createPathFromPoints(boolean update) {
        if (!update || this.path == null) {
            this.path = new Path();
        } else {
            this.path.reset();
        }
        this.path.setFillType(FillType.EVEN_ODD);
        this.path.moveTo(this.points[0].x, this.points[0].y);
        for (int i = 1; i < this.points.length; i++) {
            this.path.lineTo(this.points[i].x, this.points[i].y);
        }
        this.path.lineTo(this.points[0].x, this.points[0].y);
        this.path.close();
    }

    void pathTransform(PointF[] points, Path path, float distance) {
        path.rewind();
        path.setFillType(FillType.EVEN_ODD);
        int size = points.length;
        PointF newPosition = findAngle2(points[size - 1], points[0], points[1], distance);
        path.moveTo(newPosition.x, newPosition.y);
        for (int i = 1; i < size; i++) {
            int nextIndex = i + 1;
            if (nextIndex == size) {
                nextIndex = 0;
            }
            newPosition = findAngle2(points[i - 1], points[i], points[nextIndex], distance);
            path.lineTo(newPosition.x, newPosition.y);
        }
        newPosition = findAngle2(points[size - 1], points[0], points[1], distance);
        path.lineTo(newPosition.x, newPosition.y);
        path.close();
        path.offset((float) this.offsetX, (float) this.offsetY);
    }

    PointF findAngle2(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, float paramFloat) {
        /*PointF p21;
        PointF p23;
        float concavite = ((p2.x - p1.x) * (p3.y - p2.y)) - ((p3.x - p2.x) * (p2.y - p1.y));
        int concMultiplier = 1;
        if (this.checkForConcavite) {
            concMultiplier = (int) Math.signum(concavite);
        }
        float distanceX = dit;
        float distanceY = dit;
        if (p3.x == 0.0f && p2.x == 0.0f) {
            distanceX = dit * 2.0f;
        }
        if (p3.y == 0.0f && p2.y == 0.0f) {
            distanceY = dit * 2.0f;
        }
        float pMaxX = (float) this.viewW;
        float pMaxY = (float) this.viewH;
        if (p3.x == pMaxX && p2.x == pMaxX) {
            distanceX = dit * 2.0f;
        }
        if (p3.y == pMaxY && p2.y == pMaxY) {
            distanceY = dit * 2.0f;
        }
        PointF normal1 = new PointF(-(p3.y - p2.y), p3.x - p2.x);
        PointF normal2 = new PointF(p3.y - p2.y, -(p3.x - p2.x));
        PointF normalSelected = normal1;
        float lenght = normalSelected.length();
        normalSelected.set(normalSelected.x / lenght, normalSelected.y / lenght);
        PointF p111 = new PointF(p3.x + (normalSelected.x * distanceX), p3.y + (normalSelected.y * distanceY));
        PointF pointF = new PointF(p2.x + (normalSelected.x * distanceX), p2.y + (normalSelected.y * distanceY));
        normalSelected = normal2;
        lenght = normalSelected.length();
        normalSelected.set(normalSelected.x / lenght, normalSelected.y / lenght);
        PointF p11 = new PointF(p3.x + (normalSelected.x * distanceX), p3.y + (normalSelected.y * distanceY));
        pointF = new PointF(p2.x + (normalSelected.x * distanceX), p2.y + (normalSelected.y * distanceY));
        if (((p1.x - p111.x) * (p1.x - p111.x)) + ((p1.y - p111.y) * (p1.y - p111.y)) < ((p1.x - p11.x) * (p1.x - p11.x)) + ((p1.y - p11.y) * (p1.y - p11.y))) {
            p11 = p111;
            p21 = pointF;
        }
        distanceX = dit;
        distanceY = dit;
        if (p1.x == 0.0f && p2.x == 0.0f) {
            distanceX = dit * 2.0f;
        }
        if (p1.y == 0.0f && p2.y == 0.0f) {
            distanceY = dit * 2.0f;
        }
        if (p1.x == pMaxX && p2.x == pMaxX) {
            distanceX = dit * 2.0f;
        }
        if (p1.y == pMaxY && p2.y == pMaxY) {
            distanceY = dit * 2.0f;
        }
        normal1 = new PointF(-(p2.y - p1.y), p2.x - p1.x);
        normal2 = new PointF(p2.y - p1.y, -(p2.x - p1.x));
        normalSelected = normal1;
        lenght = normalSelected.length();
        normalSelected.set(normalSelected.x / lenght, normalSelected.y / lenght);
        pointF = new PointF(p2.x + (normalSelected.x * distanceX), p2.y + (normalSelected.y * distanceY));
        pointF = new PointF(p1.x + (normalSelected.x * distanceX), p1.y + (normalSelected.y * distanceY));
        normalSelected = normal2;
        lenght = normalSelected.length();
        normalSelected.set(normalSelected.x / lenght, normalSelected.y / lenght);
        PointF p13 = new PointF(p2.x + (normalSelected.x * distanceX), p2.y + (normalSelected.y * distanceY));
        pointF = new PointF(p1.x + (normalSelected.x * distanceX), p1.y + (normalSelected.y * distanceY));
        if (((p3.x - pointF.x) * (p3.x - pointF.x)) + ((p3.y - pointF.y) * (p3.y - pointF.y)) < ((p3.x - p13.x) * (p3.x - p13.x)) + ((p3.y - p13.y) * (p3.y - p13.y))) {
            p13 = pointF;
            p23 = pointF;
        }
        PointF r2 = findLineIntersection(p11, p21, p13, p23);
        PointF result = new PointF();
        result.set(r2);
        if (concMultiplier < 0 && result != null) {
            result.set((2.0f * p2.x) - result.x, (2.0f * p2.y) - result.y);
        }
        return result;*/

        float f1 = (paramPointF2.x - paramPointF1.x) * (paramPointF3.y - paramPointF2.y) - (paramPointF3.x - paramPointF2.x) * (paramPointF2.y - paramPointF1.y);
        int i = 1;
        if (this.checkForConcavite) {
            i = (int)Math.signum(f1);
        }
        float f2 = paramFloat;
        float f3 = paramFloat;
        if ((paramPointF3.x == 0.0F) && (paramPointF2.x == 0.0F)) {
            f2 = paramFloat * 2.0F;
        }
        if ((paramPointF3.y == 0.0F) && (paramPointF2.y == 0.0F)) {
            f3 = paramFloat * 2.0F;
        }
        float f4 = this.viewW;
        float f5 = this.viewH;
        if ((paramPointF3.x == f4) && (paramPointF2.x == f4)) {
            f2 = paramFloat * 2.0F;
        }
        if ((paramPointF3.y == f5) && (paramPointF2.y == f5)) {
            f3 = paramFloat * 2.0F;
        }
        PointF localPointF1 = new PointF(-(paramPointF3.y - paramPointF2.y), paramPointF3.x - paramPointF2.x);
        PointF localPointF2 = new PointF(paramPointF3.y - paramPointF2.y, -(paramPointF3.x - paramPointF2.x));
        float f6 = localPointF1.length();
        localPointF1.set(localPointF1.x / f6, localPointF1.y / f6);
        PointF localPointF3 = new PointF(paramPointF3.x + f2 * localPointF1.x, paramPointF3.y + f3 * localPointF1.y);
        PointF localPointF4 = new PointF(paramPointF2.x + f2 * localPointF1.x, paramPointF2.y + f3 * localPointF1.y);
        float f7 = localPointF2.length();
        localPointF2.set(localPointF2.x / f7, localPointF2.y / f7);
        PointF localPointF5 = new PointF(paramPointF3.x + f2 * localPointF2.x, paramPointF3.y + f3 * localPointF2.y);
        float f8 = paramPointF2.x + f2 * localPointF2.x;
        float f9 = paramPointF2.y + f3 * localPointF2.y;
        PointF localPointF6 = new PointF(f8, f9);
        if ((paramPointF1.x - localPointF3.x) * (paramPointF1.x - localPointF3.x) + (paramPointF1.y - localPointF3.y) * (paramPointF1.y - localPointF3.y) < (paramPointF1.x - localPointF5.x) * (paramPointF1.x - localPointF5.x) + (paramPointF1.y - localPointF5.y) * (paramPointF1.y - localPointF5.y))
        {
            localPointF5 = localPointF3;
            localPointF6 = localPointF4;
        }
        float f10 = paramFloat;
        float f11 = paramFloat;
        if ((paramPointF1.x == 0.0F) && (paramPointF2.x == 0.0F)) {
            f10 = paramFloat * 2.0F;
        }
        if ((paramPointF1.y == 0.0F) && (paramPointF2.y == 0.0F)) {
            f11 = paramFloat * 2.0F;
        }
        if ((paramPointF1.x == f4) && (paramPointF2.x == f4)) {
            f10 = paramFloat * 2.0F;
        }
        if ((paramPointF1.y == f5) && (paramPointF2.y == f5)) {
            f11 = paramFloat * 2.0F;
        }
        PointF localPointF7 = new PointF(-(paramPointF2.y - paramPointF1.y), paramPointF2.x - paramPointF1.x);
        PointF localPointF8 = new PointF(paramPointF2.y - paramPointF1.y, -(paramPointF2.x - paramPointF1.x));
        float f12 = localPointF7.length();
        localPointF7.set(localPointF7.x / f12, localPointF7.y / f12);
        PointF localPointF9 = new PointF(paramPointF2.x + f10 * localPointF7.x, paramPointF2.y + f11 * localPointF7.y);
        PointF localPointF10 = new PointF(paramPointF1.x + f10 * localPointF7.x, paramPointF1.y + f11 * localPointF7.y);
        float f13 = localPointF8.length();
        localPointF8.set(localPointF8.x / f13, localPointF8.y / f13);
        PointF localPointF11 = new PointF(paramPointF2.x + f10 * localPointF8.x, paramPointF2.y + f11 * localPointF8.y);
        float f14 = paramPointF1.x + f10 * localPointF8.x;
        float f15 = paramPointF1.y + f11 * localPointF8.y;
        PointF localPointF12 = new PointF(f14, f15);
        if ((paramPointF3.x - localPointF9.x) * (paramPointF3.x - localPointF9.x) + (paramPointF3.y - localPointF9.y) * (paramPointF3.y - localPointF9.y) < (paramPointF3.x - localPointF11.x) * (paramPointF3.x - localPointF11.x) + (paramPointF3.y - localPointF11.y) * (paramPointF3.y - localPointF11.y))
        {
            localPointF11 = localPointF9;
            localPointF12 = localPointF10;
        }
        PointF localPointF13 = findLineIntersection(localPointF5, localPointF6, localPointF11, localPointF12);
        PointF localPointF14 = new PointF();
        localPointF14.set(localPointF13);
        if ((i < 0) && (localPointF14 != null)) {
            localPointF14.set(2.0F * paramPointF2.x - localPointF14.x, 2.0F * paramPointF2.y - localPointF14.y);
        }
        return localPointF14;
    }

    PointF findLineIntersection(PointF p1, PointF p2, PointF p3, PointF p4) {
        float y;
        float x1 = p1.x;
        float y1 = p1.y;
        float x2 = p2.x;
        float y2 = p2.y;
        float x3 = p3.x;
        float y3 = p3.y;
        float x4 = p4.x;
        float y4 = p4.y;
        float a1 = y1 - y2;
        float b1 = x2 - x1;
        float c1 = ((x1 - x2) * y1) + ((y2 - y1) * x1);
        float a2 = y3 - y4;
        float b2 = x4 - x3;
        float c2 = ((x3 - x4) * y3) + ((y4 - y3) * x3);
        float x = ((c2 * b1) - (c1 * b2)) / ((b2 * a1) - (b1 * a2));
        if (b1 != 0.0f) {
            y = (((-a1) * x) - c1) / b1;
        } else {
            y = (((-a2) * x) - c2) / b2;
        }
        return new PointF(x, y);
    }

    void pathTransformFromRect(float distance) {
        float top = this.sourceRect.top;
        float left = this.sourceRect.left;
        float bottom = this.sourceRect.bottom;
        this.tempRect.set(left + distance, top + distance, this.sourceRect.right - distance, bottom - distance);
        this.path.rewind();
        this.path.addRect(this.tempRect, Direction.CCW);
    }

    float checkRange(float pointA, float distance, float centerA) {
        if (pointA > centerA) {
            return pointA - distance;
        }
        if (pointA < centerA) {
            return pointA + distance;
        }
        return pointA;
    }

    public void drawShape(Canvas canvas, int width, int height, int j, boolean drawPorterClear, boolean saving, boolean isSolo) {
        if (drawPorterClear) {
            if (this.shapeMode == 5) {
                Svg.svgList[this.svgIndex].draw(canvas, this.originalBounds.width() - ((float) (this.svgClearFixPadding * 2)), this.originalBounds.height() - ((float) (this.svgClearFixPadding * 2)), ((float) this.svgClearFixPadding) + this.originalBounds.left, ((float) this.svgClearFixPadding) + this.originalBounds.top, true);
            } else if (this.shapeMode != 3) {
                canvas.drawPath(this.originalPath, this.paintTransparent);
            } else if (!(this.maskBitmap == null || this.maskBitmap.isRecycled())) {
                canvas.drawBitmap(this.maskBitmap, this.transparentMaskMatrix, this.paintTransparent);
            }
            canvas.restoreToCount(j);
        }
        this.f869r.set(0.0f, 0.0f, (float) this.bitmapWidth, (float) this.bitmapHeight);
        this.bitmapMatrix.mapRect(this.f869r);
        if (!saving) {
            this.f869r.intersect(0.0f, 0.0f, (float) width, (float) height);
        }
        int k = canvas.saveLayer(this.f869r, null, 31);
        if (this.shapeMode == 5) {
            Svg.svgList[this.svgIndex].draw(canvas, this.bounds.width(), this.bounds.height(), this.bounds.left, this.bounds.top, false);
        } else if (this.shapeMode != 3) {
            canvas.drawPath(this.path, this.paintPath);
        } else if (!(this.maskBitmap == null || this.maskBitmap.isRecycled())) {
            canvas.drawBitmap(this.maskBitmap, this.maskMatrix, this.maskPaint);
        }
        canvas.drawBitmap(this.bitmap, this.bitmapMatrix, this.paintXferMode);
        canvas.restoreToCount(k);
        if (isSolo && Svg.strokeSize > 0.0f) {
            if (this.shapeMode == 5) {
                Svg.svgList[this.svgIndex].drawStroke(canvas, this.bounds.width(), this.bounds.height(), this.bounds.left, this.bounds.top, false);
                return;
            }
            this.paintSoloBorder.setStrokeWidth(Svg.strokeSize);
            this.paintSoloBorder.setColor(Svg.colorStroke);
            canvas.drawPath(this.path, this.paintSoloBorder);
        }
    }

    public void initIcon(int width, int height) {
        this.iconPaint = new Paint(1);
        this.iconPaint.setFilterBitmap(true);
        this.iconPaint.setColor(-7829368);
        this.paintXferMode.setColor(-7829368);
        scalePath(5.0f, (float) width, (float) height);
        this.iconMaskPaint = new Paint(1);
        this.iconMaskPaint.setFilterBitmap(true);
        this.iconMaskPaint.setColor(-7829368);
        this.iconXferMode = new PorterDuffXfermode(Mode.SRC_IN);
        this.iconMaskPaint.setXfermode(this.iconXferMode);
        Svg.setColorTint(-7829368);
    }

    void drawShapeIcon(Canvas canvas, int width, int height, int j, boolean drawPorterClear) {
        setMaskBitmapPositions();
        this.path.offset((float) (-this.offsetX), (float) (-this.offsetY));
        this.originalPath.offset((float) (-this.offsetX), (float) (-this.offsetY));
        this.maskMatrix.postTranslate((float) (-this.offsetX), (float) (-this.offsetY));
        this.transparentMaskMatrix.postTranslate((float) (-this.offsetX), (float) (-this.offsetY));
        if (drawPorterClear) {
            if (this.shapeMode == 5) {
                Svg.svgList[this.svgIndex].draw(canvas, this.originalBounds.width() - ((float) (this.svgClearFixPadding * 2)), this.originalBounds.height() - ((float) (this.svgClearFixPadding * 2)), (this.originalBounds.left + ((float) this.svgClearFixPadding)) - ((float) this.offsetX), (this.originalBounds.top + ((float) this.svgClearFixPadding)) - ((float) this.offsetY), true);
            } else if (this.shapeMode == 3) {
                canvas.drawBitmap(this.maskBitmap, this.transparentMaskMatrix, this.paintTransparent);
            } else {
                canvas.drawPath(this.originalPath, this.paintTransparent);
            }
            canvas.restoreToCount(j);
        }
        int i;
        if (this.shapeMode == 5) {
            i = canvas.saveLayer(0.0f, 0.0f, (float) width, (float) height, null, 31);
            Svg.svgList[this.svgIndex].draw(canvas, this.bounds.width(), this.bounds.height(), this.bounds.left - ((float) this.offsetX), this.bounds.top - ((float) this.offsetY), false);
            canvas.drawRect(this.bounds, this.iconMaskPaint);
            canvas.restoreToCount(i);
        } else if (this.shapeMode == 3) {
            i = canvas.saveLayer(0.0f, 0.0f, (float) width, (float) height, null, 31);
            canvas.drawBitmap(this.maskBitmap, this.maskMatrix, this.iconPaint);
            canvas.drawBitmap(this.maskBitmap, this.maskMatrix, this.iconMaskPaint);
            canvas.restoreToCount(i);
        } else {
            canvas.drawPath(this.path, this.iconPaint);
        }
    }

    void drawShapeIcon2(Canvas canvas, int width, int height) {
        this.path.offset((float) (-this.offsetX), (float) (-this.offsetY));
        this.originalPath.offset((float) (-this.offsetX), (float) (-this.offsetY));
        this.maskMatrix.postTranslate((float) (-this.offsetX), (float) (-this.offsetY));
        this.transparentMaskMatrix.postTranslate((float) (-this.offsetX), (float) (-this.offsetY));
        Paint p2 = new Paint();
        if (this.shapeMode == 3) {
            int i = canvas.saveLayer(0.0f, 0.0f, (float) width, (float) height, null, 31);
            canvas.drawBitmap(this.maskBitmap, this.transparentMaskMatrix, p2);
            p2.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
            canvas.drawRect(0.0f, 0.0f, (float) width, (float) height, p2);
            p2.setXfermode(null);
            canvas.restoreToCount(i);
            return;
        }
        canvas.drawPath(this.path, this.iconPaint);
    }

    void bitmapMatrixScale(float scaleX, float scaleY, float centerX, float centerY) {
        this.bitmapMatrix.postScale(scaleX, scaleY, centerX, centerY);
        checkScaleBoundries();
    }

    void bitmapMatrixScaleScrapBook(float scaleX, float scaleY) {
        this.f868p[0] = (float) (this.bitmapWidth / 2);
        this.f868p[1] = (float) (this.bitmapHeight / 2);
        this.bitmapMatrix.mapPoints(this.f868p);
        this.bitmapMatrix.postScale(scaleX, scaleY, this.f868p[0], this.f868p[1]);
        checkScaleBoundries();
    }

    void checkScaleBoundries() {
        float scale = getScale();
        PointF centerOfImage = getCenterOfImage();
        if (scale < this.minScale) {
            this.bitmapMatrix.postScale(this.minScale / scale, this.minScale / scale, centerOfImage.x, centerOfImage.y);
        }
        if (scale > this.maxScale) {
            this.bitmapMatrix.postScale(this.maxScale / scale, this.maxScale / scale, centerOfImage.x, centerOfImage.y);
        }
    }

    void bitmapMatrixTranslate(float dx, float dy) {
        this.bitmapMatrix.postTranslate(dx, dy);
        if (!this.isScrapBook) {
            checkBoundries(false);
        }
    }

    public void checkBoundries(boolean override) {
        if (CollageActivity.isGridLayoutLocked || override) {
            this.bitmapRect.set(0.0f, 0.0f, (float) this.bitmapWidth, (float) this.bitmapHeight);
            this.bitmapMatrix.mapRect(this.bitmapRect);
            float dx = 0.0f;
            float dy = 0.0f;
            if (this.bitmapRect.left > this.bounds.left) {
                dx = this.bounds.left - this.bitmapRect.left;
            }
            if (this.bitmapRect.top > this.bounds.top) {
                dy = this.bounds.top - this.bitmapRect.top;
            }
            if (this.bitmapRect.right < this.bounds.right) {
                dx = this.bounds.right - this.bitmapRect.right;
            }
            if (this.bitmapRect.bottom < this.bounds.bottom) {
                dy = this.bounds.bottom - this.bitmapRect.bottom;
            }
            this.bitmapMatrix.postTranslate(dx, dy);
        }
    }

    public void checkScaleBounds(boolean override) {
        setMinScales(getBitmapScale(this.bounds), override);
        checkScaleBoundries();
    }

    void bitmapMatrixgGetValues(float[] values) {
        this.bitmapMatrix.getValues(values);
    }

    void bitmapMatrixRotate(float angle) {
        this.f868p[0] = (float) (this.bitmapWidth / 2);
        this.f868p[1] = (float) (this.bitmapHeight / 2);
        this.bitmapMatrix.mapPoints(this.f868p);
        this.bitmapMatrix.postRotate(angle, this.f868p[0], this.f868p[1]);
    }

    public int setScaleMatrix(int mode) {
        if (this.dx <= 0.5f) {
            this.dx = ((float) this.bitmapWidth) / 100.0f;
        }
        if (this.dy <= 0.5f) {
            this.dy = ((float) this.bitmapHeight) / 100.0f;
        }
        PointF centerOfImage = getCenterOfImage();
        if (mode == 0) {
            setMatrixFit();
        } else if (mode == 1) {
            setBitmapPosition(false);
        } else if (mode == 3) {
            this.bitmapMatrix.postRotate(-90.0f, centerOfImage.x, centerOfImage.y);
            if (!this.isScrapBook && CollageActivity.isGridLayoutLocked) {
                setMaxMinScalesRotated();
                float scale = getScale();
                this.bitmapMatrix.postScale(this.minScale / scale, this.minScale / scale, centerOfImage.x, centerOfImage.y);
            }
        } else if (mode == 2) {
            this.bitmapMatrix.postRotate(90.0f, centerOfImage.x, centerOfImage.y);
            if (!this.isScrapBook && CollageActivity.isGridLayoutLocked) {
                setMaxMinScalesRotated();
                float scale = getScale();
                this.bitmapMatrix.postScale(this.minScale / scale, this.minScale / scale, centerOfImage.x, centerOfImage.y);
            }
        } else if (mode == 4) {
            this.bitmapMatrix.postScale(-1.0f, 1.0f, centerOfImage.x, centerOfImage.y);
        } else if (mode == 5) {
            this.bitmapMatrix.postScale(1.0f, -1.0f, centerOfImage.x, centerOfImage.y);
        } else if (mode == 6) {
            this.bitmapMatrix.postRotate(-10.0f, centerOfImage.x, centerOfImage.y);
        } else if (mode == 7) {
            this.bitmapMatrix.postRotate(10.0f, centerOfImage.x, centerOfImage.y);
        } else if (mode == 8) {
            if (getScale() >= this.maxScale) {
                return 1;
            }
            this.bitmapMatrix.postScale(this.scaleUp, this.scaleUp, centerOfImage.x, centerOfImage.y);
        } else if (mode == 9) {
            if (getScale() <= this.minScale) {
                return 2;
            }
            this.bitmapMatrix.postScale(this.scaleDown, this.scaleDown, centerOfImage.x, centerOfImage.y);
        } else if (mode == 10) {
            this.bitmapRect.set(0.0f, 0.0f, (float) this.bitmapWidth, (float) this.bitmapHeight);
            this.bitmapMatrix.mapRect(this.bitmapRect);
            if (this.bitmapRect.right <= this.bounds.right && !this.isScrapBook && CollageActivity.isGridLayoutLocked) {
                return 3;
            }
            this.bitmapMatrix.postTranslate(-this.dx, 0.0f);
        } else if (mode == 11) {
            this.bitmapRect.set(0.0f, 0.0f, (float) this.bitmapWidth, (float) this.bitmapHeight);
            this.bitmapMatrix.mapRect(this.bitmapRect);
            if (this.bitmapRect.left >= this.bounds.left && !this.isScrapBook && CollageActivity.isGridLayoutLocked) {
                return 4;
            }
            this.bitmapMatrix.postTranslate(this.dx, 0.0f);
        } else if (mode == 12) {
            this.bitmapRect.set(0.0f, 0.0f, (float) this.bitmapWidth, (float) this.bitmapHeight);
            this.bitmapMatrix.mapRect(this.bitmapRect);
            if (this.bitmapRect.bottom <= this.bounds.bottom && !this.isScrapBook && CollageActivity.isGridLayoutLocked) {
                return 5;
            }
            this.bitmapMatrix.postTranslate(0.0f, -this.dy);
        } else if (mode == 13) {
            this.bitmapRect.set(0.0f, 0.0f, (float) this.bitmapWidth, (float) this.bitmapHeight);
            this.bitmapMatrix.mapRect(this.bitmapRect);
            if (this.bitmapRect.top >= this.bounds.top && !this.isScrapBook && CollageActivity.isGridLayoutLocked) {
                return 6;
            }
            this.bitmapMatrix.postTranslate(0.0f, this.dy);
        }
        checkScaleBoundries();
        if (this.isScrapBook) {
            return 0;
        }
        checkBoundries(false);
        return 0;
    }

    private PointF getCenterOfImage() {
        if (this.centerOriginal == null) {
            this.centerOriginal = new PointF();
        }
        if (this.f867f == null) {
            this.f867f = new float[2];
        }
        float y = ((float) this.bitmapHeight) / 2.0f;
        this.f867f[0] = ((float) this.bitmapWidth) / 2.0f;
        this.f867f[1] = y;
        this.bitmapMatrix.mapPoints(this.f867f);
        this.centerOriginal.set(this.f867f[0], this.f867f[1]);
        return this.centerOriginal;
    }

    void setMatrixFit() {
        float scaleBitmap = Math.min(this.bounds.width() / ((float) this.bitmapWidth), this.bounds.height() / ((float) this.bitmapHeight));
        if (this.isScrapBook) {
            scaleBitmap *= Collage.scrapBookShapeScale;
        }
        float bitmapY = this.bounds.top + ((this.bounds.height() - (((float) this.bitmapHeight) * scaleBitmap)) / 2.0f);
        float bitmapX = this.bounds.left + ((this.bounds.width() - (((float) this.bitmapWidth) * scaleBitmap)) / 2.0f);
        this.bitmapMatrix.reset();
        this.bitmapMatrix.postScale(scaleBitmap, scaleBitmap);
        this.bitmapMatrix.postTranslate(bitmapX, bitmapY);
    }

    private void setScrapBookBitmapPosition(int index, boolean isChangeRatio, int width, int height) {
        if (isChangeRatio) {
            int w = this.bitmapWidth;
            int h = this.bitmapHeight;
            float[] points = new float[]{0.0f, 0.0f, (float) w, 0.0f, (float) w, (float) h, 0.0f, (float) h};
            this.bitmapMatrix.mapPoints(points);
            RectF drawArea = new RectF((float) this.offsetX, (float) this.offsetY, (float) (this.offsetX + width), (float) (this.offsetY + height));
            if (!drawArea.contains(points[0], points[1])) {
                if (!drawArea.contains(points[2], points[3])) {
                    if (!drawArea.contains(points[4], points[5])) {
                        if (!drawArea.contains(points[6], points[7])) {
                            PointF A = new PointF((float) this.offsetX, (float) this.offsetY);
                            PointF B = new PointF((float) (this.offsetX + width), (float) this.offsetY);
                            PointF P = new PointF();
                            float[] f;
                            float min;
                            int minIndex;
                            int i;
                            if (points[1] < ((float) this.offsetY)) {
                                P.set(points[0], points[1]);
                                f = new float[4];
                                P.set(points[2], points[3]);
                                f[1] = pointToLineDistance(A, B, P);
                                P.set(points[4], points[5]);
                                f[2] = pointToLineDistance(A, B, P);
                                P.set(points[6], points[7]);
                                f[3] = pointToLineDistance(A, B, P);
                                min = f[0];
                                minIndex = 0;
                                for (i = 1; i < 4; i++) {
                                    if (f[i] < min) {
                                        min = f[i];
                                        minIndex = i;
                                    }
                                }
                                this.bitmapMatrix.postTranslate(0.0f, ((float) (this.offsetY + 120)) - points[(minIndex * 2) + 1]);
                                return;
                            }
                            A = new PointF((float) this.offsetX, (float) (this.offsetY + height));
                            B = new PointF((float) (this.offsetX + width), (float) (this.offsetY + height));
                            P.set(points[0], points[1]);
                            f = new float[4];
                            P.set(points[2], points[3]);
                            f[1] = pointToLineDistance(A, B, P);
                            P.set(points[4], points[5]);
                            f[2] = pointToLineDistance(A, B, P);
                            P.set(points[6], points[7]);
                            f[3] = pointToLineDistance(A, B, P);
                            min = f[0];
                            minIndex = 0;
                            for (i = 1; i < 4; i++) {
                                if (f[i] < min) {
                                    min = f[i];
                                    minIndex = i;
                                }
                            }
                            this.bitmapMatrix.postTranslate(0.0f, ((float) ((this.offsetY + height) - 120)) - points[(minIndex * 2) + 1]);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.bitmapMatrix = new Matrix();
        setMatrixFit();
        float actualScale = getScale();
        setMaxMinScales(actualScale);
        float scale = 1.0f / actualScale;
        this.touchStrokeWidth = this.tempTouchStrokeWidth * scale;
        this.scrapBookPadding = 25.0f * scale;
        this.bitmapMatrix.postRotate((float) scrapBookRotation[index], this.bounds.left + (this.bounds.width() / 2.0f), this.bounds.top + (this.bounds.height() / 2.0f));
        this.touchRect = new RectF(-this.scrapBookPadding, -this.scrapBookPadding, ((float) this.bitmapWidth) + this.scrapBookPadding, ((float) this.bitmapHeight) + this.scrapBookPadding);
        this.touchPaint.setColor(-1290417);
        this.touchPaint.setFilterBitmap(true);
        this.touchPaint.setStyle(Style.STROKE);
        this.touchPaint.setStrokeWidth(this.touchStrokeWidth);
        this.borderPaint.setColor(-1);
        this.borderPaint.setStyle(Style.STROKE);
        this.borderPaint.setStrokeWidth((float) this.borderStrokeWidth);
        this.borderPaint.setAntiAlias(true);
    }

    public float pointToLineDistance(PointF A, PointF B, PointF P) {
        return Math.abs(((P.x - A.x) * (B.y - A.y)) - ((P.y - A.y) * (B.x - A.x))) / ((float) Math.sqrt((double) (((B.x - A.x) * (B.x - A.x)) + ((B.y - A.y) * (B.y - A.y)))));
    }

    float sqr(float x) {
        return x * x;
    }

    float dist2(PointF v, PointF w) {
        return sqr(v.x - w.x) + sqr(v.y - w.y);
    }

    float distToSegmentSquared(PointF p, PointF v, PointF w) {
        float l2 = dist2(v, w);
        if (l2 == 0.0f) {
            return dist2(p, v);
        }
        float t = (((p.x - v.x) * (w.x - v.x)) + ((p.y - v.y) * (w.y - v.y))) / l2;
        if (t < 0.0f) {
            return dist2(p, v);
        }
        if (t > 1.0f) {
            return dist2(p, w);
        }
        return dist2(p, new PointF(v.x + ((w.x - v.x) * t), v.y + ((w.y - v.y) * t)));
    }

    float[] getMappedCenter() {
        this.pts[0] = (float) (this.bitmapWidth / 2);
        this.pts[1] = (float) (this.bitmapHeight / 2);
        this.bitmapMatrix.mapPoints(this.pts, this.pts);
        return this.pts;
    }

    public boolean isScrapBookSelected(float x1, float y1) {
        this.pts[0] = x1;
        this.pts[1] = y1;
        this.inverse.reset();
        this.bitmapMatrix.invert(this.inverse);
        this.inverse.mapPoints(this.pts, this.pts);
        float x = this.pts[0];
        float y = this.pts[1];
        if (x < 0.0f || x > ((float) this.bitmapWidth) || y < 0.0f || y > ((float) this.bitmapHeight)) {
            return false;
        }
        return true;
    }

    public void drawShapeForScrapBook(Canvas canvas, int width, int height, boolean isSelected, boolean isOrthogonal) {
        this.touchRect.set(-this.scrapBookPadding, -this.scrapBookPadding, ((float) this.bitmapWidth) + this.scrapBookPadding, ((float) this.bitmapHeight) + this.scrapBookPadding);
        canvas.save();
        canvas.concat(this.bitmapMatrix);
        this.npd.setBounds((-this.npdPadding) - this.borderStrokeWidth, (-this.npdPadding) - this.borderStrokeWidth, (this.bitmapWidth + this.npdPadding) + this.borderStrokeWidth, (this.bitmapHeight + this.npdPadding) + this.borderStrokeWidth);
        this.npd.draw(canvas);
        if (!(this.bitmap == null || this.bitmap.isRecycled())) {
            canvas.drawBitmap(this.bitmap, 0.0f, 0.0f, this.paintScrap);
        }
        if (isSelected) {
            this.touchStrokeWidth = this.tempTouchStrokeWidth * (1.0f / getScale());
            this.touchPaint.setStrokeWidth(this.touchStrokeWidth);
            canvas.drawRect(this.touchRect, this.touchPaint);
            setDelAndScaleBitmapMatrix();
            if (!(this.btmDelete == null || this.btmDelete.isRecycled())) {
                canvas.drawBitmap(this.btmDelete, this.removeBitmapMatrix, this.touchPaint);
            }
            if (!(this.btmScale == null || this.btmScale.isRecycled())) {
                canvas.drawBitmap(this.btmScale, this.scaleBitmapMatrix, this.touchPaint);
            }
            if (isOrthogonal) {
                canvas.drawPath(this.dashPathVertical, this.dashPaint);
                canvas.drawPath(this.dashPathHorizontal, this.dashPaint);
            }
        }
        canvas.drawRect((float) ((-this.borderStrokeWidth) / 2), (float) ((-this.borderStrokeWidth) / 2), (float) (this.bitmapWidth + (this.borderStrokeWidth / 2)), (float) (this.bitmapHeight + (this.borderStrokeWidth / 2)), this.borderPaint);
        canvas.restore();
    }

    private void setDelAndScaleBitmapMatrix() {
        if (this.removeBitmapMatrix == null) {
            this.removeBitmapMatrix = new Matrix();
        }
        if (this.scaleBitmapMatrix == null) {
            this.scaleBitmapMatrix = new Matrix();
        }
        this.removeBitmapMatrix.reset();
        this.scaleBitmapMatrix.reset();
        if (this.delW == 0) {
            this.delW = this.btmDelete.getWidth();
        }
        if (this.screenWidth <= 0) {
            this.screenWidth = 720;
        }
        float bitmapScale = (2.0f * (((float) this.screenWidth) / 20.0f)) / ((float) this.delW);
        this.deleteWidthHalf = (((float) this.delW) * bitmapScale) / 1.4f;
        this.removeBitmapMatrix.postScale(bitmapScale, bitmapScale);
        this.removeBitmapMatrix.postTranslate((-this.scrapBookPadding) - ((((float) this.delW) * bitmapScale) / 2.0f), (-this.scrapBookPadding) - ((((float) this.delW) * bitmapScale) / 2.0f));
        this.scaleBitmapMatrix.postScale(bitmapScale, bitmapScale);
        this.scaleBitmapMatrix.postTranslate((((float) this.bitmapWidth) + this.scrapBookPadding) - ((((float) this.delW) * bitmapScale) / 2.0f), (((float) this.bitmapHeight) + this.scrapBookPadding) - ((((float) this.delW) * bitmapScale) / 2.0f));
        float scale = getScale();
        this.scaleBitmapMatrix.postScale(1.0f / scale, 1.0f / scale, this.touchRect.right, this.touchRect.bottom);
        this.removeBitmapMatrix.postScale(1.0f / scale, 1.0f / scale, this.touchRect.left, this.touchRect.top);
        if (this.screenWidth > 0) {
            this.tempTouchStrokeWidth = ((float) this.screenWidth) / 120.0f;
        }
    }

    public void initScrapBook(NinePatchDrawable npd) {
        setNinePatch(npd);
    }

    public void setNinePatch(NinePatchDrawable npd) {
        this.npd = npd;
        this.touchRect.round(new Rect());
    }

    float getScale() {
        this.bitmapMatrix.getValues(this.values);
        float scalex = this.values[0];
        float skewy = this.values[3];
        float scale = (float) Math.sqrt((double) ((scalex * scalex) + (skewy * skewy)));
        if (scale <= 0.0f) {
            return 1.0f;
        }
        return scale;
    }

    boolean isInCircle(float x1, float y1) {
        this.pts[0] = x1;
        this.pts[1] = y1;
        this.bitmapMatrix.invert(this.inverse);
        this.inverse.mapPoints(this.pts, this.pts);
        float x = this.pts[0];
        float y = this.pts[1];
        float scale = getScale();
        if (((x - this.touchRect.right) * (x - this.touchRect.right)) + ((y - this.touchRect.bottom) * (y - this.touchRect.bottom)) < (this.deleteWidthHalf * this.deleteWidthHalf) / (scale * scale)) {
            return true;
        }
        return false;
    }

    boolean isOnCross(float x1, float y1) {
        this.pts[0] = x1;
        this.pts[1] = y1;
        this.bitmapMatrix.invert(this.inverse);
        this.inverse.mapPoints(this.pts, this.pts);
        float x = this.pts[0];
        float y = this.pts[1];
        float scale = getScale();
        if (((x - this.touchRect.left) * (x - this.touchRect.left)) + ((y - this.touchRect.top) * (y - this.touchRect.top)) < (this.deleteWidthHalf * this.deleteWidthHalf) / (scale * scale)) {
            return true;
        }
        return false;
    }
}
