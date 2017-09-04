package com.lyrebirdstudio.promodialog;

import com.google.gson.Gson;
import com.lyrebirdstudio.BuildConfig;
import com.lyrebirdstudio.R;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ButtonPromoEntity {
    public static final ButtonPromoEntity[] BUTTON_PROMO_ENTITIES = new ButtonPromoEntity[]{new ButtonPromoEntity("No Crop", "0001", "com.lyrebirdstudio.nocrop", R.drawable.promo_button_no_crop, 100), new ButtonPromoEntity("Insta Square", "0002", "com.lyrebirdstudio.instasquare",
            R.drawable.promo_button_insta_square, 100),
            new ButtonPromoEntity("Mirror Collage", "0003", "com.lyrebirdstudio.mirror_collage",
                    R.drawable.promo_button_mirror_collage, 100), new ButtonPromoEntity("Color Effect", "0004",
            "com.lyrebirdstudio.colorizer.lite", R.drawable.promo_button_color_effect, 100),
            new ButtonPromoEntity("Color Splash", "0005", "com.lyrebirdstudio.colorme",
                    R.drawable.promo_button_color_splash, 100),
            new ButtonPromoEntity("Mirror", "0006", "com.lyrebirdstudio.mirror",
                    R.drawable.promo_button_mirror, 100),
            new ButtonPromoEntity("PiP Photo", "0007", "com.lyrebirdstudio.pipcamera",
                    R.drawable.promo_button_pip_camera, 100),
            new ButtonPromoEntity("Pip Collage", "0008", "com.lyrebirdstudio.pip_collage",
                    R.drawable.promo_button_pip_collage, 100), new ButtonPromoEntity("Collage Pro", "0009",
            BuildConfig.APPLICATION_ID, R.drawable.promo_button_collage, 100),
            new ButtonPromoEntity("Photo Editor", "0010", "com.lyrebirdstudio.montagenscolagem",
                    R.drawable.promo_button_montagens, 100),
            new ButtonPromoEntity("Beauty Cam", "0011", "com.lyrebirdstudio.beauty",
                    R.drawable.promo_button_beauty, 100),
            new ButtonPromoEntity("Collage Pro", "0012", "com.lyrebirdstudio.photocollageeditor",
                    R.drawable.promo_button_photo_collage, 100), new ButtonPromoEntity("Tiny Planet", "0013", "com.lyrebirdstudio.tinyplanet", R.drawable.promo_button_tiny_planet, 100), new ButtonPromoEntity("Insta Square", "0014", "com.lyrebirdstudio.instasquare", R.drawable.promo_button_insta_square, 40), new ButtonPromoEntity("Collage Frame", "0015", "com.lyrebirdstudio.collage_frame", R.drawable.promo_button_collage_frame, 100), new ButtonPromoEntity("Collage Layout", "0016", "com.lyrebirdstudio.collage_layout", R.drawable.promo_button_collage_layout, 100),
            new ButtonPromoEntity("Editor Pro", "0017", "com.lyrebirdstudio.photo_editor_pro",
                    R.drawable.promo_button_photo_ultimate, 100), new ButtonPromoEntity("Collage Flower", "0018",
            "com.lyrebirdstudio.tbt", R.drawable.promo_button_collage_flower, 100),
            new ButtonPromoEntity("Art Filter", "0019", "com.lyrebirdstudio.art_filter",
                    R.drawable.promo_button_art, 100), new ButtonPromoEntity("ArtistA", "0020",
            "com.lyrebirdstudio.art", R.drawable.promo_button_artista, 100),
            new ButtonPromoEntity("Face Cam", "0021", "com.lyrebirdstudio.face_camera",
                    R.drawable.promo_button_face_camera, 100), new ButtonPromoEntity("Video Editor", "0022", "com.lyrebirdstudio.videoeditor",
            R.drawable.promo_button_video_editor, 100), new ButtonPromoEntity("Emoji Camera", "0023", "com.lyrebirdstudio.emoji_camera",
            R.drawable.promo_button_face_camera, 100), new ButtonPromoEntity("Makeup", "0024", "com.lyrebirdstudio.makeup",
            R.drawable.promo_button_beauty, 100)};
    private static final String TAG = ButtonPromoEntity.class.getSimpleName();
    public String iconPath;
    public String id;
    public boolean isOnline = true;
    public String name;
    public String packageName;
    public int percent = 100;
    public int resId = 0;

    public ButtonPromoEntity()

    {

    }
    public ButtonPromoEntity(String name, String id, String packageName, int resId, int percent) {
        this.name = name;
        this.packageName = packageName;
        this.id = id;
        this.resId = resId;
        this.percent = percent;
        this.isOnline = false;
    }

    void set(ButtonPromoEntity bp) {
        if (bp != null) {
            this.iconPath = bp.iconPath;
            this.name = bp.name;
            this.id = bp.id;
            this.packageName = bp.packageName;
            this.percent = bp.percent;
            this.isOnline = bp.isOnline;
            this.resId = bp.resId;
        }
    }

    public static ButtonPromoEntity loadFromJson(String path) {
        String jsonString = "";
        try {
            DataInputStream in = new DataInputStream(new FileInputStream(path));
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            while (true) {
                String strLine = br.readLine();
                if (strLine != null) {
                    jsonString = jsonString + strLine;
                } else {
                    in.close();
                    return (ButtonPromoEntity) new Gson().fromJson(jsonString, ButtonPromoEntity.class);
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }
}
