package com.lyrebirdstudio.pointlist;

import com.lyrebirdstudio.R;

import java.util.ArrayList;
import java.util.List;

public class Collage {
    public static int[][] collageIconArray;
    public static float scrapBookShapeScale = 1.0f;
    public List<CollageLayout> collageLayoutList;

    static {
        int[][] r0 = new int[15][];
        r0[0] = new int[]{R.drawable.collage_1_0, R.drawable.collage_1_1, R.drawable.collage_1_2, R.drawable.collage_1_3, R.drawable.collage_1_4, R.drawable.collage_1_5, R.drawable.collage_1_6, R.drawable.collage_1_7, R.drawable.collage_1_8, R.drawable.collage_1_9, R.drawable.collage_1_10, R.drawable.collage_1_11, R.drawable.collage_1_12, R.drawable.collage_1_13, R.drawable.collage_1_14, R.drawable.collage_1_15, R.drawable.collage_1_16, R.drawable.collage_1_17, R.drawable.collage_1_18, R.drawable.collage_1_19, R.drawable.collage_1_20, R.drawable.collage_1_21, R.drawable.collage_1_22, R.drawable.collage_1_23, R.drawable.collage_1_24, R.drawable.collage_1_25, R.drawable.collage_1_26, R.drawable.collage_1_27, R.drawable.collage_1_28, R.drawable.collage_1_29, R.drawable.collage_1_30, R.drawable.collage_1_31, R.drawable.collage_1_32, R.drawable.collage_1_33, R.drawable.collage_1_34, R.drawable.collage_1_35, R.drawable.collage_1_36, R.drawable.collage_1_37, R.drawable.collage_1_38, R.drawable.collage_1_39, R.drawable.collage_1_40, R.drawable.collage_1_41, R.drawable.collage_1_42, R.drawable.collage_1_43, R.drawable.collage_1_44, R.drawable.collage_1_45, R.drawable.collage_1_46, R.drawable.collage_1_47, R.drawable.collage_1_48, R.drawable.collage_1_49, R.drawable.collage_1_50, R.drawable.collage_1_51, R.drawable.collage_1_52, R.drawable.collage_1_53, R.drawable.collage_1_54, R.drawable.collage_1_55, R.drawable.collage_1_56, R.drawable.collage_1_57, R.drawable.collage_1_58, R.drawable.collage_1_59, R.drawable.collage_1_60, R.drawable.collage_1_61, R.drawable.collage_1_62, R.drawable.collage_1_63, R.drawable.collage_1_64, R.drawable.collage_1_65, R.drawable.collage_1_66, R.drawable.collage_1_67, R.drawable.collage_1_68, R.drawable.collage_1_69, R.drawable.collage_1_70};
        r0[1] = new int[]{R.drawable.collage_2_0, R.drawable.collage_2_1, R.drawable.collage_2_25, R.drawable.collage_2_24, R.drawable.collage_2_2, R.drawable.collage_2_3, R.drawable.collage_2_4, R.drawable.collage_2_5, R.drawable.collage_2_6, R.drawable.collage_2_7, R.drawable.collage_2_8, R.drawable.collage_2_9, R.drawable.collage_2_10, R.drawable.collage_2_11, R.drawable.collage_2_12, R.drawable.collage_2_13, R.drawable.collage_2_14, R.drawable.collage_2_15, R.drawable.collage_2_16, R.drawable.collage_2_17, R.drawable.collage_2_18, R.drawable.collage_2_19, R.drawable.collage_2_20, R.drawable.collage_2_21, R.drawable.collage_2_22, R.drawable.collage_2_23, R.drawable.collage_2_26, R.drawable.collage_2_27, R.drawable.collage_2_28, R.drawable.collage_2_29, R.drawable.collage_2_30};
        r0[2] = new int[]{R.drawable.collage_3_4, R.drawable.collage_3_53, R.drawable.collage_3_50, R.drawable.collage_3_3, R.drawable.collage_3_51, R.drawable.collage_3_52, R.drawable.collage_3_6, R.drawable.collage_3_1, R.drawable.collage_3_2, R.drawable.collage_3_49, R.drawable.collage_3_48, R.drawable.collage_3_8, R.drawable.collage_3_0, R.drawable.collage_3_9, R.drawable.collage_3_10, R.drawable.collage_3_11, R.drawable.collage_3_12, R.drawable.collage_3_13, R.drawable.collage_3_14, R.drawable.collage_3_15, R.drawable.collage_3_16, R.drawable.collage_3_17, R.drawable.collage_3_18, R.drawable.collage_3_19, R.drawable.collage_3_20, R.drawable.collage_3_21, R.drawable.collage_3_22, R.drawable.collage_3_23, R.drawable.collage_3_24, R.drawable.collage_3_25, R.drawable.collage_3_26, R.drawable.collage_3_27, R.drawable.collage_3_28, R.drawable.collage_3_29, R.drawable.collage_3_30, R.drawable.collage_3_31, R.drawable.collage_3_32, R.drawable.collage_3_33, R.drawable.collage_3_34, R.drawable.collage_3_35, R.drawable.collage_3_36, R.drawable.collage_3_37, R.drawable.collage_3_38, R.drawable.collage_3_39, R.drawable.collage_3_40, R.drawable.collage_3_41, R.drawable.collage_3_42, R.drawable.collage_3_43, R.drawable.collage_3_5, R.drawable.collage_3_44, R.drawable.collage_3_45, R.drawable.collage_3_46, R.drawable.collage_3_47, R.drawable.collage_3_7};
        r0[3] = new int[]{R.drawable.collage_4_0, R.drawable.collage_4_36, R.drawable.collage_4_34, R.drawable.collage_4_35, R.drawable.collage_4_29, R.drawable.collage_4_30, R.drawable.collage_4_31, R.drawable.collage_4_32, R.drawable.collage_4_33, R.drawable.collage_4_1, R.drawable.collage_4_2, R.drawable.collage_4_3, R.drawable.collage_4_4, R.drawable.collage_4_5, R.drawable.collage_4_6, R.drawable.collage_4_7, R.drawable.collage_4_8, R.drawable.collage_4_9, R.drawable.collage_4_10, R.drawable.collage_4_11, R.drawable.collage_4_12, R.drawable.collage_4_13, R.drawable.collage_4_14, R.drawable.collage_4_15, R.drawable.collage_4_16, R.drawable.collage_4_17, R.drawable.collage_4_18, R.drawable.collage_4_19, R.drawable.collage_4_20, R.drawable.collage_4_21, R.drawable.collage_4_22, R.drawable.collage_4_23, R.drawable.collage_4_24, R.drawable.collage_4_25, R.drawable.collage_4_26, R.drawable.collage_4_27, R.drawable.collage_4_28};
        r0[4] = new int[]{R.drawable.collage_5_0, R.drawable.collage_5_1, R.drawable.collage_5_5, R.drawable.collage_5_34, R.drawable.collage_5_6, R.drawable.collage_5_33, R.drawable.collage_5_7, R.drawable.collage_5_32, R.drawable.collage_5_3, R.drawable.collage_5_31, R.drawable.collage_5_35, R.drawable.collage_5_36, R.drawable.collage_5_21, R.drawable.collage_5_22, R.drawable.collage_5_23, R.drawable.collage_5_24, R.drawable.collage_5_25, R.drawable.collage_5_2, R.drawable.collage_5_4, R.drawable.collage_5_8, R.drawable.collage_5_9, R.drawable.collage_5_10, R.drawable.collage_5_11, R.drawable.collage_5_12, R.drawable.collage_5_13, R.drawable.collage_5_14, R.drawable.collage_5_15, R.drawable.collage_5_16, R.drawable.collage_5_17, R.drawable.collage_5_18, R.drawable.collage_5_19, R.drawable.collage_5_20, R.drawable.collage_5_26, R.drawable.collage_5_27, R.drawable.collage_5_28, R.drawable.collage_5_29, R.drawable.collage_5_30};
        r0[5] = new int[]{R.drawable.collage_6_13, R.drawable.collage_6_14, R.drawable.collage_6_15, R.drawable.collage_6_16, R.drawable.collage_6_0, R.drawable.collage_6_1, R.drawable.collage_6_2, R.drawable.collage_6_3, R.drawable.collage_6_4, R.drawable.collage_6_5, R.drawable.collage_6_6, R.drawable.collage_6_7, R.drawable.collage_6_8, R.drawable.collage_6_9, R.drawable.collage_6_10, R.drawable.collage_6_11, R.drawable.collage_6_12};
        r0[6] = new int[]{R.drawable.collage_7_12, R.drawable.collage_7_11, R.drawable.collage_7_0, R.drawable.collage_7_1, R.drawable.collage_7_2, R.drawable.collage_7_3, R.drawable.collage_7_4, R.drawable.collage_7_5, R.drawable.collage_7_6, R.drawable.collage_7_7, R.drawable.collage_7_8, R.drawable.collage_7_10};
        r0[7] = new int[]{R.drawable.collage_8_0, R.drawable.collage_8_1, R.drawable.collage_8_2, R.drawable.collage_8_3, R.drawable.collage_8_4, R.drawable.collage_8_5, R.drawable.collage_8_6, R.drawable.collage_8_7, R.drawable.collage_8_8, R.drawable.collage_8_9, R.drawable.collage_8_10, R.drawable.collage_8_11, R.drawable.collage_8_12, R.drawable.collage_8_13, R.drawable.collage_8_14, R.drawable.collage_8_15, R.drawable.collage_8_16};
        r0[8] = new int[]{R.drawable.collage_9_13, R.drawable.collage_9_0, R.drawable.collage_9_1, R.drawable.collage_9_12, R.drawable.collage_9_2, R.drawable.collage_9_3, R.drawable.collage_9_4, R.drawable.collage_9_5, R.drawable.collage_9_6, R.drawable.collage_9_7, R.drawable.collage_9_8, R.drawable.collage_9_9, R.drawable.collage_9_10, R.drawable.collage_9_11};
        r0[9] = new int[]{R.drawable.collage_10_5, R.drawable.collage_10_9, R.drawable.collage_10_6, R.drawable.collage_10_7, R.drawable.collage_10_8, R.drawable.collage_10_0, R.drawable.collage_10_1, R.drawable.collage_10_2, R.drawable.collage_10_3, R.drawable.collage_10_4};
        r0[10] = new int[]{R.drawable.collage_11_5, R.drawable.collage_11_7, R.drawable.collage_11_8, R.drawable.collage_11_9, R.drawable.collage_11_10, R.drawable.collage_11_11, R.drawable.collage_11_12, R.drawable.collage_11_0, R.drawable.collage_11_1, R.drawable.collage_11_2, R.drawable.collage_11_3, R.drawable.collage_11_4, R.drawable.collage_11_6};
        r0[11] = new int[]{R.drawable.collage_12_0, R.drawable.collage_12_5, R.drawable.collage_12_6, R.drawable.collage_12_7, R.drawable.collage_12_8, R.drawable.collage_12_1, R.drawable.collage_12_2, R.drawable.collage_12_3, R.drawable.collage_12_4};
        r0[12] = new int[]{R.drawable.collage_13_2, R.drawable.collage_13_9, R.drawable.collage_13_5, R.drawable.collage_13_6, R.drawable.collage_13_7, R.drawable.collage_13_8, R.drawable.collage_13_0, R.drawable.collage_13_1, R.drawable.collage_13_3, R.drawable.collage_13_4};
        r0[13] = new int[]{R.drawable.collage_14_7, R.drawable.collage_14_8, R.drawable.collage_14_9, R.drawable.collage_14_10, R.drawable.collage_14_11, R.drawable.collage_14_12, R.drawable.collage_14_0, R.drawable.collage_14_1, R.drawable.collage_14_2, R.drawable.collage_14_3, R.drawable.collage_14_4, R.drawable.collage_14_5, R.drawable.collage_14_6};
        r0[14] = new int[]{R.drawable.collage_15_7, R.drawable.collage_15_8, R.drawable.collage_15_0, R.drawable.collage_15_1, R.drawable.collage_15_2, R.drawable.collage_15_3, R.drawable.collage_15_4, R.drawable.collage_15_5, R.drawable.collage_15_6, R.drawable.collage_15_9};
        collageIconArray = r0;
    }

    public static Collage CreateCollage(int shapeCount, int width, int height, boolean isScrapBook) {
        if (isScrapBook) {
            return createScrapLaout(shapeCount, width, height);
        }
        if (shapeCount == 1) {
            return new Collage1(width, height);
        }
        if (shapeCount == 2) {
            return new Collage2(width, height);
        }
        if (shapeCount == 3) {
            return new Collage3(width, height);
        }
        if (shapeCount == 4) {
            return new Collage4(width, height);
        }
        if (shapeCount == 5) {
            return new Collage5(width, height);
        }
        if (shapeCount == 6) {
            return new Collage6(width, height);
        }
        if (shapeCount == 7) {
            return new Collage7(width, height);
        }
        if (shapeCount == 8) {
            return new Collage8(width, height);
        }
        if (shapeCount == 9) {
            return new Collage9(width, height);
        }
        if (shapeCount == 10) {
            return new Collage10(width, height);
        }
        if (shapeCount == 11) {
            return new Collage11(width, height);
        }
        if (shapeCount == 12) {
            return new Collage12(width, height);
        }
        if (shapeCount == 13) {
            return new Collage13(width, height);
        }
        if (shapeCount == 14) {
            return new Collage14(width, height);
        }
        if (shapeCount == 15) {
            return new Collage15(width, height);
        }
        return null;
    }

    public static Collage createScrapLaout(int shapeCount, int width, int height) {
        Collage collage = new Collage();
        collage.collageLayoutList = new ArrayList();
        CollageScrapBook scrapBook = new CollageScrapBook(width, height);
        if (shapeCount == 1) {
            collage.collageLayoutList.add(scrapBook.collageLayoutList.get(0));
            scrapBookShapeScale = 0.7f;
        }
        if (shapeCount == 2) {
            if (height > width) {
                collage.collageLayoutList.add(scrapBook.collageLayoutList.get(2));
            } else {
                collage.collageLayoutList.add(scrapBook.collageLayoutList.get(1));
            }
            scrapBookShapeScale = 1.0f;
        } else if (shapeCount == 3) {
            collage.collageLayoutList.add(scrapBook.collageLayoutList.get(3));
            scrapBookShapeScale = 0.95f;
        } else if (shapeCount == 4) {
            collage.collageLayoutList.add(scrapBook.collageLayoutList.get(4));
            scrapBookShapeScale = 1.0f;
        } else if (shapeCount == 5) {
            collage.collageLayoutList.add(scrapBook.collageLayoutList.get(5));
            scrapBookShapeScale = 0.95f;
        } else if (shapeCount == 6) {
            if (height > width) {
                collage.collageLayoutList.add(scrapBook.collageLayoutList.get(6));
            } else {
                collage.collageLayoutList.add(scrapBook.collageLayoutList.get(7));
            }
            scrapBookShapeScale = 1.0f;
        } else if (shapeCount == 7) {
            if (height > width) {
                collage.collageLayoutList.add(scrapBook.collageLayoutList.get(8));
            } else {
                collage.collageLayoutList.add(scrapBook.collageLayoutList.get(9));
            }
            scrapBookShapeScale = 1.0f;
        } else if (shapeCount == 8) {
            collage.collageLayoutList.add(scrapBook.collageLayoutList.get(10));
            scrapBookShapeScale = 1.0f;
        } else if (shapeCount == 9) {
            collage.collageLayoutList.add(scrapBook.collageLayoutList.get(11));
            scrapBookShapeScale = 1.0f;
        }
        return collage;
    }
}
