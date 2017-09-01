package com.lyrebirdstudio.sticker;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;

import com.lyrebirdstudio.R;

import java.util.concurrent.atomic.AtomicInteger;

public class Utility {
    private static final float limitDivider = 30.0f;
    private static final float limitDividerGinger = 160.0f;
    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);
    public static final int[][] stickerResIdList;
    public static final String[][] stickerUrlList = new String[][]{createEmojiUrlList(), createAnimalUrlList()};

    static {
        int[][] r0 = new int[19][];
        r0[0] = new int[]{R.drawable.emoji_001, R.drawable.emoji_002, R.drawable.emoji_003, R.drawable.emoji_004, R.drawable.emoji_005, R.drawable.emoji_006, R.drawable.emoji_007, R.drawable.emoji_008, R.drawable.emoji_009, R.drawable.emoji_010, R.drawable.emoji_011, R.drawable.emoji_012, R.drawable.emoji_013, R.drawable.emoji_014, R.drawable.emoji_015, R.drawable.emoji_016, R.drawable.emoji_017, R.drawable.emoji_018, R.drawable.emoji_019, R.drawable.emoji_020, R.drawable.emoji_021, R.drawable.emoji_022, R.drawable.emoji_023, R.drawable.emoji_024, R.drawable.emoji_025, R.drawable.emoji_026, R.drawable.emoji_027, R.drawable.emoji_028, R.drawable.emoji_029, R.drawable.emoji_030, R.drawable.emoji_031, R.drawable.emoji_032, R.drawable.emoji_033, R.drawable.emoji_034, R.drawable.emoji_035, R.drawable.emoji_036, R.drawable.emoji_037, R.drawable.emoji_038, R.drawable.emoji_039, R.drawable.emoji_040, R.drawable.emoji_041, R.drawable.emoji_042, R.drawable.emoji_043, R.drawable.emoji_044, R.drawable.emoji_045, R.drawable.emoji_046, R.drawable.emoji_047, R.drawable.emoji_048, R.drawable.emoji_049, R.drawable.emoji_050, R.drawable.emoji_051, R.drawable.emoji_052, R.drawable.emoji_053, R.drawable.emoji_054, R.drawable.emoji_055, R.drawable.emoji_056, R.drawable.emoji_057, R.drawable.emoji_058, R.drawable.emoji_059, R.drawable.emoji_060, R.drawable.emoji_061, R.drawable.emoji_062, R.drawable.emoji_063, R.drawable.emoji_064, R.drawable.emoji_065, R.drawable.emoji_066, R.drawable.emoji_067, R.drawable.emoji_068, R.drawable.emoji_069, R.drawable.emoji_070, R.drawable.emoji_071, R.drawable.emoji_072, R.drawable.emoji_073, R.drawable.emoji_074, R.drawable.emoji_075, R.drawable.emoji_076, R.drawable.emoji_077, R.drawable.emoji_078, R.drawable.emoji_079, R.drawable.emoji_080, R.drawable.emoji_081, R.drawable.emoji_082, R.drawable.emoji_083, R.drawable.emoji_084, R.drawable.emoji_085, R.drawable.emoji_086, R.drawable.emoji_087, R.drawable.emoji_088, R.drawable.emoji_089, R.drawable.emoji_090, R.drawable.emoji_091, R.drawable.emoji_092, R.drawable.emoji_093, R.drawable.emoji_094, R.drawable.emoji_095, R.drawable.emoji_096, R.drawable.emoji_097, R.drawable.emoji_098, R.drawable.emoji_099, R.drawable.emoji_100, R.drawable.emoji_101, R.drawable.emoji_102, R.drawable.emoji_103, R.drawable.emoji_104, R.drawable.emoji_105, R.drawable.emoji_106, R.drawable.emoji_107, R.drawable.emoji_108, R.drawable.emoji_109, R.drawable.emoji_110, R.drawable.emoji_111, R.drawable.emoji_112, R.drawable.emoji_113, R.drawable.emoji_114, R.drawable.emoji_115, R.drawable.emoji_116, R.drawable.emoji_117, R.drawable.emoji_118, R.drawable.emoji_119, R.drawable.emoji_120, R.drawable.emoji_121, R.drawable.emoji_122, R.drawable.emoji_123, R.drawable.emoji_124, R.drawable.emoji_125, R.drawable.emoji_126, R.drawable.emoji_127, R.drawable.emoji_128, R.drawable.emoji_129, R.drawable.emoji_130, R.drawable.emoji_131, R.drawable.emoji_132, R.drawable.emoji_133, R.drawable.emoji_134, R.drawable.emoji_135, R.drawable.emoji_136, R.drawable.emoji_137, R.drawable.emoji_138, R.drawable.emoji_139, R.drawable.emoji_140, R.drawable.emoji_141, R.drawable.emoji_142, R.drawable.emoji_143, R.drawable.emoji_144, R.drawable.emoji_145, R.drawable.emoji_146, R.drawable.emoji_147, R.drawable.emoji_148, R.drawable.emoji_149, R.drawable.emoji_150, R.drawable.emoji_151, R.drawable.emoji_152, R.drawable.emoji_153, R.drawable.emoji_154, R.drawable.emoji_155, R.drawable.emoji_156, R.drawable.emoji_157, R.drawable.emoji_158, R.drawable.emoji_159, R.drawable.emoji_160, R.drawable.emoji_161, R.drawable.emoji_162, R.drawable.emoji_163, R.drawable.emoji_164, R.drawable.emoji_165, R.drawable.emoji_166, R.drawable.emoji_167};
        r0[1] = new int[0];
        r0[2] = new int[]{R.drawable.snap_dog_ear_left, R.drawable.snap_dog_ear_right, R.drawable.snap_dog_muzzle, R.drawable.snap_dog_tongue, R.drawable.snap_057, R.drawable.snap_058, R.drawable.snap_059, R.drawable.snap_060, R.drawable.snap_061, R.drawable.snap_062, R.drawable.snap_063, R.drawable.snap_064, R.drawable.snap_065, R.drawable.snap_066, R.drawable.snap_067, R.drawable.snap_068, R.drawable.snap_069, R.drawable.snap_rainbow_0, R.drawable.snap_rainbow_1, R.drawable.snap_rainbow_2, R.drawable.snap_rainbow_3, R.drawable.snap_yorkie_tongue, R.drawable.snap_dog_ear_left6, R.drawable.snap_dog_ear_right6, R.drawable.snap_dog_muzzle6, R.drawable.snap_fox_tongue, R.drawable.snap_tears_1_right, R.drawable.snap_tears_1_left, R.drawable.snap_tears_2_right, R.drawable.snap_tears_2_left, R.drawable.snap_eye_left, R.drawable.snap_eye_right, R.drawable.snap_bunny_ear_right, R.drawable.snap_bunny_ear_left, R.drawable.snap_bunny_nose, R.drawable.snap_cat_ear_left, R.drawable.snap_cat_ear_right, R.drawable.snap_cat_muzzle};
        r0[3] = new int[]{R.drawable.snap_flower_crown_0, R.drawable.snap_flower_crown_1, R.drawable.snap_flower_crown_2, R.drawable.snap_flower_crown_3, R.drawable.snap_flower_crown_4, R.drawable.snap_flower_crown_5, R.drawable.snap_flower_crown_6, R.drawable.snap_flower_crown_7, R.drawable.snap_flower_crown_8, R.drawable.snap_flower_crown_9, R.drawable.snap_flower_crown_10, R.drawable.snap_flower_crown_11, R.drawable.snap_flower_crown_18, R.drawable.snap_flower_crown_19, R.drawable.snap_flower_crown_20, R.drawable.snap_flower_crown_21, R.drawable.snap_flower_crown_22, R.drawable.snap_tiara_0, R.drawable.snap_tiara_2, R.drawable.snap_emerald_tiara, R.drawable.snap_flower_tiara};
        r0[4] = new int[]{R.drawable.snap_dalmatian_ear_left, R.drawable.snap_dalmatian_ear_right, R.drawable.snap_dalmatian_nose, R.drawable.snap_dash_ear_left, R.drawable.snap_dash_ear_right, R.drawable.snap_dash_ose, R.drawable.snap_hera_ear_left, R.drawable.snap_hera_ear_right, R.drawable.snap_hera_nose};
        r0[5] = new int[]{R.drawable.snap_cat_ear_left_01, R.drawable.snap_cat_ear_right_01, R.drawable.snap_cat_nose_01};
        r0[6] = new int[]{R.drawable.snap_rainbow_4, R.drawable.snap_rainbow_5, R.drawable.snap_rainbow_7, R.drawable.snap_rainbow_6, R.drawable.snap_rainbow_11, R.drawable.snap_rainbow_8, R.drawable.snap_rainbow_10, R.drawable.snap_rainbow_9};
        r0[7] = new int[]{R.drawable.love_01, R.drawable.love_02, R.drawable.love_03, R.drawable.love_04, R.drawable.love_05, R.drawable.love_06, R.drawable.love_07, R.drawable.love_08, R.drawable.love_09, R.drawable.love_10, R.drawable.love_11, R.drawable.love_12, R.drawable.love_13, R.drawable.love_14, R.drawable.love_15, R.drawable.love_16, R.drawable.love_17, R.drawable.love_18, R.drawable.love_19, R.drawable.love_20, R.drawable.love_21, R.drawable.love_22, R.drawable.love_23, R.drawable.love_24, R.drawable.love_25, R.drawable.love_26, R.drawable.love_27, R.drawable.love_28, R.drawable.love_29, R.drawable.love_30, R.drawable.love_31, R.drawable.love_32, R.drawable.love_33, R.drawable.love_34, R.drawable.love_35, R.drawable.love_36, R.drawable.love_37, R.drawable.love_38, R.drawable.love_39, R.drawable.love_40, R.drawable.love_41, R.drawable.love_42, R.drawable.love_43, R.drawable.love_44, R.drawable.love_45, R.drawable.love_46, R.drawable.love_47, R.drawable.love_48, R.drawable.love_49, R.drawable.love_40, R.drawable.love_41, R.drawable.love_42, R.drawable.love_53, R.drawable.love_54, R.drawable.love_55};
        r0[8] = new int[]{R.drawable.snap_dash_ear_left, R.drawable.snap_dash_ear_right, R.drawable.snap_dash_ose, R.drawable.snap_flower_crown_0, R.drawable.snap_flower_crown_1, R.drawable.snap_flower_crown_2, R.drawable.snap_hera_ear_left, R.drawable.snap_hera_ear_right, R.drawable.snap_hera_nose};
        r0[9] = new int[]{R.drawable.candy_01, R.drawable.candy_02, R.drawable.candy_03, R.drawable.candy_04, R.drawable.candy_05, R.drawable.candy_06, R.drawable.candy_07, R.drawable.candy_08, R.drawable.candy_09, R.drawable.candy_10, R.drawable.candy_11, R.drawable.candy_12, R.drawable.candy_13, R.drawable.candy_14, R.drawable.candy_15, R.drawable.candy_16, R.drawable.candy_17, R.drawable.candy_18, R.drawable.candy_19, R.drawable.candy_20};
        r0[10] = new int[]{R.drawable.love_bird_01, R.drawable.love_bird_02, R.drawable.love_bird_03, R.drawable.love_bird_04, R.drawable.love_bird_05, R.drawable.love_bird_06, R.drawable.love_bird_07, R.drawable.love_bird_08, R.drawable.love_bird_09};
        r0[11] = new int[]{R.drawable.monster_01, R.drawable.monster_02, R.drawable.monster_03, R.drawable.monster_04, R.drawable.monster_05, R.drawable.monster_06, R.drawable.monster_07, R.drawable.monster_08, R.drawable.monster_09, R.drawable.monster_10, R.drawable.monster_11, R.drawable.monster_12, R.drawable.monster_13, R.drawable.monster_14, R.drawable.monster_15};
        r0[12] = new int[]{R.drawable.comic_01, R.drawable.comic_02, R.drawable.comic_03, R.drawable.comic_04, R.drawable.comic_05, R.drawable.comic_06, R.drawable.comic_07, R.drawable.comic_08, R.drawable.comic_09, R.drawable.comic_10, R.drawable.comic_11, R.drawable.comic_12, R.drawable.comic_13, R.drawable.comic_14, R.drawable.comic_15, R.drawable.comic_16, R.drawable.comic_17, R.drawable.comic_18, R.drawable.comic_19, R.drawable.comic_20, R.drawable.comic_21, R.drawable.comic_22, R.drawable.comic_23, R.drawable.comic_24, R.drawable.comic_25, R.drawable.comic_26, R.drawable.comic_27, R.drawable.comic_28};
       /* r0[13] = new int[]{R.drawable.flag_01, R.drawable.flag_02, R.drawable.flag_03, R.drawable.flag_04, R.drawable.flag_05, R.drawable.flag_06, R.drawable.flag_07, R.drawable.flag_08, R.drawable.flag_09, R.drawable.flag_10, R.drawable.flag_11, R.drawable.flag_12, R.drawable.flag_13, R.drawable.flag_14, R.drawable.flag_15, R.drawable.flag_16, R.drawable.flag_17, R.drawable.flag_18, R.drawable.flag_19, R.drawable.flag_20, R.drawable.flag_21, R.drawable.flag_22, R.drawable.flag_23, R.drawable.flag_24, R.drawable.flag_25, R.drawable.flag_26, R.drawable.flag_27, R.drawable.flag_28, R.drawable.flag_29, R.drawable.flag_30, R.drawable.flag_31, R.drawable.flag_32, R.drawable.flag_33, R.drawable.flag_34, R.drawable.flag_35, R.drawable.flag_36, R.drawable.flag_37, R.drawable.flag_38, R.drawable.flag_39, R.drawable.flag_40, R.drawable.flag_41, R.drawable.flag_42, R.drawable.flag_43, R.drawable.flag_44, R.drawable.flag_45, R.drawable.flag_46, R.drawable.flag_47, R.drawable.flag_48, R.drawable.flag_49, R.drawable.flag_50, R.drawable.flag_51, R.drawable.flag_52, R.drawable.flag_53, R.drawable.flag_54, R.drawable.flag_55, R.drawable.flag_56, R.drawable.flag_57, R.drawable.flag_58, R.drawable.flag_59, R.drawable.flag_60, R.drawable.flag_61, R.drawable.flag_62, R.drawable.flag_63, R.drawable.flag_64, R.drawable.flag_65, R.drawable.flag_66, R.drawable.flag_67, R.drawable.flag_68, R.drawable.flag_69, R.drawable.flag_70, R.drawable.flag_71, R.drawable.flag_72, R.drawable.flag_73, R.drawable.flag_74, R.drawable.flag_75, R.drawable.flag_76, R.drawable.flag_77, R.drawable.flag_78, R.drawable.flag_79, R.drawable.flag_80};
        r0[14] = new int[]{R.drawable.glasses_01, R.drawable.glasses_02, R.drawable.glasses_03, R.drawable.glasses_04, R.drawable.glasses_05, R.drawable.glasses_06, R.drawable.glasses_07, R.drawable.glasses_08, R.drawable.glasses_09, R.drawable.glasses_10, R.drawable.glasses_11, R.drawable.glasses_12, R.drawable.glasses_13, R.drawable.glasses_14, R.drawable.glasses_15, R.drawable.glasses_16, R.drawable.glasses_17, R.drawable.glasses_18, R.drawable.glasses_19, R.drawable.glasses_20, R.drawable.glasses_21, R.drawable.glasses_22, R.drawable.glasses_23, R.drawable.glasses_24, R.drawable.glasses_25};
        r0[15] = new int[]{R.drawable.beard_01, R.drawable.beard_02, R.drawable.beard_03, R.drawable.beard_04, R.drawable.beard_05, R.drawable.beard_06, R.drawable.beard_07, R.drawable.beard_08, R.drawable.beard_09, R.drawable.beard_10, R.drawable.beard_11, R.drawable.beard_12, R.drawable.beard_13, R.drawable.beard_14, R.drawable.beard_15, R.drawable.beard_16, R.drawable.beard_17, R.drawable.beard_18, R.drawable.beard_19};
        r0[16] = new int[]{R.drawable.hat_01, R.drawable.hat_02, R.drawable.hat_03, R.drawable.hat_04, R.drawable.hat_05, R.drawable.hat_06, R.drawable.hat_07, R.drawable.hat_02, R.drawable.hat_08, R.drawable.hat_09, R.drawable.hat_10, R.drawable.hat_11};
        r0[17] = new int[]{R.drawable.wig_01, R.drawable.wig_02, R.drawable.wig_03, R.drawable.wig_04, R.drawable.wig_05, R.drawable.wig_06, R.drawable.wig_07, R.drawable.wig_08, R.drawable.wig_09, R.drawable.wig_10, R.drawable.wig_11};
        r0[18] = new int[]{R.drawable.accessory_01, R.drawable.accessory_02, R.drawable.accessory_03, R.drawable.accessory_04, R.drawable.accessory_05, R.drawable.accessory_06, R.drawable.accessory_07, R.drawable.accessory_08, R.drawable.accessory_09, R.drawable.accessory_10, R.drawable.accessory_11};*/
        stickerResIdList = r0;
    }

    public static int generateViewId() {
        int result;
        int newValue;
        do {
            result = sNextGeneratedId.get();
            newValue = result + 1;
            if (newValue > ViewCompat.MEASURED_SIZE_MASK) {
                newValue = 1;
            }
        } while (!sNextGeneratedId.compareAndSet(result, newValue));
        return result;
    }

    public static String[] createEmojiUrlList() {
        String[] emojiUrl = new String[659];
        for (int i = 0; i < emojiUrl.length; i++) {
            emojiUrl[i] = "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/stickers/emoji/emoji_" + (i + 168) + ".png";
        }
        return emojiUrl;
    }

    public static String[] createAnimalUrlList() {
        String[] animalUrl = new String[40];
        for (int i = 0; i < animalUrl.length; i++) {
            animalUrl[i] = "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/stickers/animal/sticker_animal_" + String.format("%03d", new Object[]{Integer.valueOf(i)}) + ".png";
        }
        return animalUrl;
    }

   /* public static int maxSizeForDimension(Context context, int count, float upperLimit) {
        float divider = limitDivider;
        if (VERSION.SDK_INT <= 11) {
            divider = limitDividerGinger;
        }
        int maxSize = (int) Math.sqrt(ImageUtility.getLeftSizeOfMemory() / ((double) (((float) count) * divider)));
        if (maxSize <= 0) {
            maxSize = getDefaultLimit(count, upperLimit);
        }
        return Math.min(maxSize, getDefaultLimit(count, upperLimit));
    }
*/
    private static int getDefaultLimit(int count, float upperLimit) {
        return (int) (((double) upperLimit) / Math.sqrt((double) count));
    }
}
