package com.lyrebirdstudio.promodialog;

public class PromoButtonHelper {
    private static final String TAG = "PromoButtonHelper";

   /* public static ButtonPromoEntity initPromoButton(Context context, String amazonFolder, TextView textView, ImageView imageView, int prefDefIndex) {
        ButtonPromo.defaultIndex = prefDefIndex;
        ButtonPromo.defaultVersion = ButtonPromoEntity.BUTTON_PROMO_ENTITIES[ButtonPromo.defaultIndex].id;
        final ButtonPromo buttonPromo = new ButtonPromo();
        buttonPromo.checkVersion(context, amazonFolder);
        final ButtonPromoEntity buttonPromoEntity = buttonPromo.getPromoButtonEntity(context);
        if (buttonPromoEntity != null) {
            if (!(textView == null || buttonPromoEntity.name == null)) {
                textView.setText(buttonPromoEntity.name);
            }
            if (buttonPromoEntity.isOnline && buttonPromoEntity.iconPath != null) {
                Bitmap btm = BitmapFactory.decodeFile(buttonPromoEntity.iconPath);
                if (!(btm == null || imageView == null)) {
                    imageView.setImageBitmap(btm);
                }
            }
            if (!(buttonPromoEntity.isOnline || buttonPromoEntity.resId == 0 || imageView == null)) {
                imageView.setImageResource(buttonPromoEntity.resId);
            }
        }
        final Context context2 = context;
        final TextView textView2 = textView;
        final ImageView imageView2 = imageView;
        buttonPromo.setPromoButtonDownloadedListener(new PromoButtonDownloadedListener() {
            public void onPromoDownload() {
                if (!(buttonPromo == null || buttonPromoEntity == null)) {
                    buttonPromoEntity.set(buttonPromo.getPromoButtonEntity(context2));
                }
                if (buttonPromoEntity != null && buttonPromoEntity.iconPath != null) {
                    if (textView2 != null) {
                        textView2.setText(buttonPromoEntity.name);
                    }
                    if (imageView2 != null) {
                        imageView2.setImageBitmap(BitmapFactory.decodeFile(buttonPromoEntity.iconPath));
                    }
                }
            }

            public void onPromoListDownload(int index) {
                Log.e(PromoButtonHelper.TAG, "onPromoListDownload + index " + index);
                if (!(buttonPromo == null || buttonPromoEntity == null)) {
                    buttonPromoEntity.set(buttonPromo.getPromoButtonEntity(context2));
                }
                if (buttonPromoEntity != null) {
                    if (textView2 != null) {
                        textView2.setText(buttonPromoEntity.name);
                    }
                    if (!buttonPromoEntity.isOnline && buttonPromoEntity.resId != 0 && imageView2 != null) {
                        imageView2.setImageResource(buttonPromoEntity.resId);
                    }
                }
            }
        });
        return buttonPromoEntity;
    }

    public static ButtonPromoEntity initPromoButton(final Context context, String amazonFolder, final ButtonPromoEntity[] entities, int prefDefIndex) {
        ButtonPromo.defaultIndex = prefDefIndex;
        ButtonPromo.defaultVersion = ButtonPromoEntity.BUTTON_PROMO_ENTITIES[ButtonPromo.defaultIndex].id;
        final ButtonPromo buttonPromo = new ButtonPromo();
        buttonPromo.checkVersion(context, amazonFolder);
        final ButtonPromoEntity buttonPromoEntity = buttonPromo.getPromoButtonEntity(context);
        if (!(buttonPromoEntity == null || !buttonPromoEntity.isOnline || buttonPromoEntity.iconPath == null || entities == null || entities.length <= 0)) {
            entities[entities.length - 1] = buttonPromoEntity;
        }
        buttonPromo.setPromoButtonDownloadedListener(new PromoButtonDownloadedListener() {
            public void onPromoDownload() {
                if (!(buttonPromo == null || buttonPromoEntity == null)) {
                    buttonPromoEntity.set(buttonPromo.getPromoButtonEntity(context));
                }
                if (buttonPromoEntity != null && buttonPromoEntity.iconPath != null && entities != null && entities.length > 0) {
                    entities[entities.length - 1] = buttonPromoEntity;
                }
            }

            public void onPromoListDownload(int index) {
                Log.e(PromoButtonHelper.TAG, "onPromoListDownload + index " + index);
                if (!(buttonPromo == null || buttonPromoEntity == null)) {
                    buttonPromoEntity.set(buttonPromo.getPromoButtonEntity(context));
                }
                if (buttonPromoEntity != null && entities != null && entities.length > 0) {
                    entities[entities.length - 1] = buttonPromoEntity;
                }
            }
        });
        return buttonPromoEntity;
    }

    public static void clickHandlerForPromoButton(ButtonPromoEntity buttonPromoEntity, Context context) {
        try {
            String packageName = ButtonPromoEntity.BUTTON_PROMO_ENTITIES[ButtonPromo.defaultIndex].packageName;
            if (!(buttonPromoEntity == null || buttonPromoEntity.packageName == null)) {
                packageName = buttonPromoEntity.packageName;
            }
            Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
            if (intent == null) {
                intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("market://details?id=" + packageName));
            }
            context.startActivity(intent);
        } catch (Exception e) {
        }
    }

    public static void openPromoApp(Activity activity, String packageName) {
        try {
            Intent intent = activity.getPackageManager().getLaunchIntentForPackage(packageName);
            if (intent == null) {
                intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("market://details?id=" + packageName));
            }
            activity.startActivity(intent);
        } catch (Exception e) {
        }
    }*/
}
