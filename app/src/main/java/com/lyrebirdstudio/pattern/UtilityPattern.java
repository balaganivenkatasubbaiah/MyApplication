package com.lyrebirdstudio.pattern;

import android.content.Context;

import com.lyrebirdstudio.R;

import java.io.File;
import java.util.ArrayList;

public class UtilityPattern {
    public static final int[] patternResIdList = new int[]{R.drawable.no_pattern, R.drawable.color_picker, R.drawable.pattern_01, R.drawable.pattern_02, R.drawable.pattern_03, R.drawable.pattern_04, R.drawable.pattern_05, R.drawable.pattern_06, R.drawable.pattern_07, R.drawable.pattern_08, R.drawable.pattern_09, R.drawable.pattern_10, R.drawable.pattern_11, R.drawable.pattern_12, R.drawable.pattern_13, R.drawable.pattern_14, R.drawable.pattern_15, R.drawable.pattern_16, R.drawable.pattern_17, R.drawable.pattern_18, R.drawable.pattern_19, R.drawable.pattern_20, R.drawable.pattern_21, R.drawable.pattern_22, R.drawable.pattern_23, R.drawable.pattern_24, R.drawable.pattern_25, R.drawable.pattern_26, R.drawable.pattern_27, R.drawable.pattern_28, R.drawable.pattern_29, R.drawable.pattern_30, R.drawable.pattern_31, R.drawable.pattern_32, R.drawable.pattern_33, R.drawable.pattern_34, R.drawable.pattern_35, R.drawable.pattern_36, R.drawable.pattern_37, R.drawable.pattern_38, R.drawable.pattern_39, R.drawable.pattern_40, R.drawable.pattern_41, R.drawable.pattern_42, R.drawable.pattern_43, R.drawable.pattern_44, R.drawable.pattern_45, R.drawable.pattern_46, R.drawable.pattern_47, R.drawable.pattern_48, R.drawable.pattern_49, R.drawable.pattern_50, R.drawable.pattern_51, R.drawable.pattern_52, R.drawable.pattern_53, R.drawable.pattern_54, R.drawable.pattern_55, R.drawable.pattern_56, R.drawable.pattern_57};
    public static final int[][] patternResIdList2;
    public static final int[] patternResIdList3 = new int[]{R.drawable.no_pattern, R.drawable.color_picker, R.drawable.pattern_icon_08, R.drawable.pattern_icon_09, R.drawable.pattern_icon_06, R.drawable.pattern_icon_07, R.drawable.pattern_icon_10, R.drawable.pattern_icon_11, R.drawable.pattern_icon_12, R.drawable.pattern_icon_05, R.drawable.pattern_icon_01, R.drawable.pattern_icon_02, R.drawable.pattern_icon_03, R.drawable.pattern_icon_04};

    static {
        int[][] r0 = new int[12][];
        r0[0] = new int[]{R.drawable.pattern_085, R.drawable.pattern_086, R.drawable.pattern_087, R.drawable.pattern_088, R.drawable.pattern_089, R.drawable.pattern_090, R.drawable.pattern_091, R.drawable.pattern_092, R.drawable.pattern_093, R.drawable.pattern_094, R.drawable.pattern_095, R.drawable.pattern_096};
        r0[1] = new int[]{R.drawable.pattern_097, R.drawable.pattern_098, R.drawable.pattern_099, R.drawable.pattern_100, R.drawable.pattern_101, R.drawable.pattern_102, R.drawable.pattern_103, R.drawable.pattern_104, R.drawable.pattern_105, R.drawable.pattern_106, R.drawable.pattern_107, R.drawable.pattern_108};
        r0[2] = new int[]{R.drawable.pattern_061, R.drawable.pattern_062, R.drawable.pattern_063, R.drawable.pattern_064, R.drawable.pattern_065, R.drawable.pattern_066, R.drawable.pattern_067, R.drawable.pattern_068, R.drawable.pattern_069, R.drawable.pattern_070, R.drawable.pattern_071, R.drawable.pattern_072};
        r0[3] = new int[]{R.drawable.pattern_073, R.drawable.pattern_074, R.drawable.pattern_075, R.drawable.pattern_076, R.drawable.pattern_077, R.drawable.pattern_078, R.drawable.pattern_079, R.drawable.pattern_080, R.drawable.pattern_081, R.drawable.pattern_082, R.drawable.pattern_083, R.drawable.pattern_084};
        r0[4] = new int[]{R.drawable.pattern_109, R.drawable.pattern_110, R.drawable.pattern_111, R.drawable.pattern_112, R.drawable.pattern_113, R.drawable.pattern_114, R.drawable.pattern_115, R.drawable.pattern_116, R.drawable.pattern_117, R.drawable.pattern_118, R.drawable.pattern_119, R.drawable.pattern_120};
        r0[5] = new int[]{R.drawable.pattern_121, R.drawable.pattern_122, R.drawable.pattern_123, R.drawable.pattern_124, R.drawable.pattern_125, R.drawable.pattern_126, R.drawable.pattern_127, R.drawable.pattern_128, R.drawable.pattern_129, R.drawable.pattern_130, R.drawable.pattern_131};
        r0[6] = new int[]{R.drawable.pattern_132, R.drawable.pattern_133, R.drawable.pattern_134, R.drawable.pattern_135, R.drawable.pattern_136, R.drawable.pattern_137, R.drawable.pattern_138, R.drawable.pattern_139, R.drawable.pattern_140, R.drawable.pattern_141, R.drawable.pattern_142};
        r0[7] = new int[]{R.drawable.pattern_49, R.drawable.pattern_50, R.drawable.pattern_51, R.drawable.pattern_52, R.drawable.pattern_53, R.drawable.pattern_54, R.drawable.pattern_55, R.drawable.pattern_56, R.drawable.pattern_57, R.drawable.pattern_058, R.drawable.pattern_059, R.drawable.pattern_060};
        r0[8] = new int[]{R.drawable.pattern_01, R.drawable.pattern_02, R.drawable.pattern_03, R.drawable.pattern_04, R.drawable.pattern_05, R.drawable.pattern_06, R.drawable.pattern_07, R.drawable.pattern_08, R.drawable.pattern_09, R.drawable.pattern_10, R.drawable.pattern_11, R.drawable.pattern_12};
        r0[9] = new int[]{R.drawable.pattern_13, R.drawable.pattern_14, R.drawable.pattern_15, R.drawable.pattern_16, R.drawable.pattern_17, R.drawable.pattern_18, R.drawable.pattern_19, R.drawable.pattern_20, R.drawable.pattern_21, R.drawable.pattern_22, R.drawable.pattern_23, R.drawable.pattern_24};
        r0[10] = new int[]{R.drawable.pattern_25, R.drawable.pattern_26, R.drawable.pattern_27, R.drawable.pattern_28, R.drawable.pattern_29, R.drawable.pattern_30, R.drawable.pattern_31, R.drawable.pattern_32, R.drawable.pattern_33, R.drawable.pattern_34, R.drawable.pattern_35, R.drawable.pattern_36};
        r0[11] = new int[]{R.drawable.pattern_37, R.drawable.pattern_38, R.drawable.pattern_39, R.drawable.pattern_40, R.drawable.pattern_41, R.drawable.pattern_42, R.drawable.pattern_43, R.drawable.pattern_44, R.drawable.pattern_45, R.drawable.pattern_46, R.drawable.pattern_47, R.drawable.pattern_48};
        patternResIdList2 = r0;
    }

    public static ArrayList<PatternItem> getPatternList(Context context) {
        ArrayList<PatternItem> patternItems = new ArrayList();
        addPatternIconsFromSdCard(context, patternItems, false);
        return patternItems;
    }

    public static ArrayList<PatternItem> getPatternIconList(Context context) {
        ArrayList<PatternItem> patternItems = new ArrayList();
        patternItems.add(new PatternItem(patternResIdList3[0]));
        patternItems.add(new PatternItem(patternResIdList3[1]));
        addPatternIconsFromSdCard(context, patternItems, true);
        for (int i = 2; i < patternResIdList3.length; i++) {
            patternItems.add(new PatternItem(patternResIdList3[i]));
        }
        return patternItems;
    }

    static void addPatternIconsFromSdCard(Context context, ArrayList<PatternItem> patternItems, boolean getIcons) {
        File[] fileList = PatternDetailFragment.getDirectory(context, "").listFiles();
        if (fileList != null && fileList.length > 0) {
            PatternDetailFragment.sortFiles(fileList);
            for (int i = 0; i < fileList.length; i++) {
                String[] f2 = fileList[i].list();
                if (f2 != null && f2.length > 1) {
                    for (String path : f2) {
                        if (getIcons) {
                            if (path.contains("pattern_icon")) {
                                patternItems.add(new PatternItem(fileList[i].getAbsolutePath() + "/" + path));
                            }
                        } else if (!path.contains("pattern_icon")) {
                            patternItems.add(new PatternItem(fileList[i].getAbsolutePath() + "/" + path));
                        }
                    }
                }
            }
        }
    }

    static ArrayList<ArrayList<PatternItem>> addPatternIconsFromSdCard(Context context) {
        ArrayList<ArrayList<PatternItem>> list = new ArrayList();
        File[] fileList = PatternDetailFragment.getDirectory(context, "").listFiles();
        if (fileList != null && fileList.length > 0) {
            PatternDetailFragment.sortFiles(fileList);
            for (int i = 0; i < fileList.length; i++) {
                ArrayList<PatternItem> patternItems = new ArrayList();
                String[] f2 = fileList[i].list();
                if (f2 != null && f2.length > 1) {
                    for (String path : f2) {
                        if (!path.contains("pattern_icon")) {
                            patternItems.add(new PatternItem(fileList[i].getAbsolutePath() + "/" + path));
                        }
                    }
                }
                if (patternItems.size() > 1) {
                    list.add(patternItems);
                }
            }
        }
        return list;
    }

    static ArrayList<PatternItem> getPatternIconsFromSdCard(String p) {
        int i = 0;
        String folderPath = p.substring(0, p.lastIndexOf(File.separator) + 1);
        ArrayList<PatternItem> patternItems = new ArrayList();
        File f = new File(folderPath);
        if (f != null && f.exists()) {
            String[] f2 = f.list();
            if (f2 != null && f2.length > 1) {
                int length = f2.length;
                while (i < length) {
                    String path = f2[i];
                    if (!path.contains("icon") && (path.contains("jpg") || path.contains("png"))) {
                        patternItems.add(new PatternItem(folderPath + "/" + path));
                    }
                    i++;
                }
            }
        }
        return patternItems;
    }

    public static int countOccurrences(String haystack, char needle) {
        int count = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle) {
                count++;
            }
        }
        return count;
    }
}
