package com.lyrebirdstudio.promodialog;

import android.content.Context;
import android.util.Log;

import com.loopj.android.http.FileAsyncHttpResponseHandler;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class ButtonPromo {
    static final int PREDEFINED_PROMO_LIMIT = 23;
    public static final int PROMO_BUTTON_INDEX_ARTISTA = 19;
    public static final int PROMO_BUTTON_INDEX_ART_FILTER = 18;
    public static final int PROMO_BUTTON_INDEX_BEAUTY = 10;
    public static final int PROMO_BUTTON_INDEX_COLLAGE_FLOWER = 17;
    public static final int PROMO_BUTTON_INDEX_COLLAGE_MAKER = 8;
    public static final int PROMO_BUTTON_INDEX_COLOR_EFFECT = 3;
    public static final int PROMO_BUTTON_INDEX_COLOR_SPLASH = 4;
    public static final int PROMO_BUTTON_INDEX_EMOJI_CAMERA = 22;
    public static final int PROMO_BUTTON_INDEX_FACE_CAMERA = 20;
    public static final int PROMO_BUTTON_INDEX_INSTASQUARE = 1;
    public static final int PROMO_BUTTON_INDEX_MAKEUP = 23;
    public static final int PROMO_BUTTON_INDEX_MIRROR_COLLAGE = 2;
    public static final int PROMO_BUTTON_INDEX_MIRROR_IMAGE = 5;
    public static final int PROMO_BUTTON_INDEX_MONTAGEN = 9;
    public static final int PROMO_BUTTON_INDEX_NOCROP = 0;
    public static final int PROMO_BUTTON_INDEX_PHOTO_COLLAGE = 11;
    public static final int PROMO_BUTTON_INDEX_PIP_CAMERA = 6;
    public static final int PROMO_BUTTON_INDEX_PIP_COLLAGE = 7;
    public static final int PROMO_BUTTON_INDEX_TINY_PLANET = 12;
    public static final int PROMO_BUTTON_INDEX_ULTIMATE = 16;
    public static final int PROMO_BUTTON_INDEX_VIDEO_EDITOR = 21;
    private static final String TAG = ButtonPromo.class.getSimpleName();
    public static int defaultIndex = 1;
    public static String defaultVersion = ButtonPromoEntity.BUTTON_PROMO_ENTITIES[defaultIndex].id;
    static final String folderName = "/promo_button/";
    static final String folderPrefix = "promo_button_";
    static final String iconPath = "promo_button.png";
    static final String jsonPath = "promo_button.json";
    static final String versionFileName = "promo_button_current_version.txt";
    String baseUrl2 = "http://159.203.164.37/lyrebirdstudio/";
    String currentVersion = null;
    boolean downloadingFolder = false;
    int durationLimit = 35999;
    boolean iconDownloadSuccess = false;
    PromoButtonDownloadedListener promoButtonDownloadedListener;
    ArrayList<String> urlList = new ArrayList();

    interface PromoButtonDownloadedListener {
        void onPromoDownload();

        void onPromoListDownload(int i);
    }

    public void setPromoButtonDownloadedListener(PromoButtonDownloadedListener promoButtonDownloadedListener) {
        this.promoButtonDownloadedListener = promoButtonDownloadedListener;
    }

    String getCurrentVersion(Context context) {
        if (context == null) {
            return defaultVersion;
        }
        File f = getFilePath(versionFileName, context, "");
        if (f == null || !f.exists()) {
            this.currentVersion = defaultVersion;
        } else {
            try {
                Scanner s = new Scanner(f);
                while (s.hasNext()) {
                    this.currentVersion = s.next();
                }
                s.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.currentVersion == null || this.currentVersion.length() != 4) {
            this.currentVersion = defaultVersion;
        }
        return this.currentVersion;
    }

    public ButtonPromoEntity getPromoButtonEntity(Context context) {
        ButtonPromoEntity entity = new ButtonPromoEntity();
        if (context == null) {
            return entity;
        }
        String version = getCurrentVersion(context);
        int ver = checkPromoRange(version);
        if (ver >= 0) {
            entity = ButtonPromoEntity.BUTTON_PROMO_ENTITIES[ver];
            Log.e(TAG, "ver int " + ver);
            return entity;
        } else if (version.compareTo(defaultVersion) == 0) {
            return entity;
        } else {
            File jsonFile = getFilePath(jsonPath, context, version);
            if (jsonFile != null && jsonFile.exists()) {
                entity = ButtonPromoEntity.loadFromJson(jsonFile.getAbsolutePath());
                if (entity != null) {
                    entity.iconPath = getFilePath(iconPath, context, getCurrentVersion(context)).getAbsolutePath();
                }
            }
            if (entity == null) {
                return entity;
            }
            int random = new Random().nextInt(100);
            Log.e(TAG, "random = " + random);
            Log.e(TAG, "percent = " + entity.percent);
            if (random < entity.percent) {
                return entity;
            }
            return new ButtonPromoEntity();
        }
    }

    public static int checkPromoRange(String version) {
        Long ver;
        try {
            ver = Long.valueOf(Long.parseLong(version.substring(2)));
        } catch (NumberFormatException e) {
            ver = null;
        }
        Log.e(TAG, "ver == null " + (ver == null));
        if (ver == null || ver.longValue() <= 0 || ver.longValue() >= 23) {
            return -1;
        }
        return (int) (ver.longValue() - 1);
    }

    public void checkVersion(Context context, String urlPart) {
        if (context != null) {
            String url = this.baseUrl2 + urlPart + versionFileName;
            File f = getFilePath(versionFileName, context, "");
            if (f == null) {
                return;
            }
            if (!f.exists()) {
                iconListDownloader(context, url);
            } else if (new Date().getTime() - f.lastModified() > ((long) this.durationLimit)) {
                iconListDownloader(context, url);
            }
        }
    }

    public void iconListDownloader(final Context context, String url) {
        if (context != null) {
            File f = getFilePath(url.substring(url.lastIndexOf(47) + 1, url.length()), context, "");
            if (f != null && f.getParentFile().isDirectory()) {
                LIRestClient.downloadFile(url, null, new FileAsyncHttpResponseHandler(f) {
                    @Override
                    public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, Throwable throwable, File file) {

                    }

                    @Override
                    public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, File file) {
                        try {
                            Scanner s = new Scanner(file);
                            String folderId = "";
                            while (s.hasNext()) {
                                String line = s.next();
                                folderId = line;
                                Log.e(ButtonPromo.TAG, "iconListDownloaderline " + line);
                            }
                            s.close();
                            ButtonPromo.this.iconDownloadSuccess = true;
                            ButtonPromo.this.urlList.clear();
                            int index = ButtonPromo.checkPromoRange(folderId);
                            if (index >= 0) {
                                if (ButtonPromo.this.promoButtonDownloadedListener != null) {
                                    ButtonPromo.this.promoButtonDownloadedListener.onPromoListDownload(index);
                                }
                            } else if (folderId.length() == 4) {
                                File dir = ButtonPromo.getDirectory(context, folderId);
                                if (dir == null) {
                                    return;
                                }
                                if ((!dir.exists() || dir.list() == null || dir.list().length <= 1) && folderId.compareToIgnoreCase(ButtonPromo.defaultVersion) != 0) {
                                    ButtonPromo.this.urlList.add(ButtonPromo.this.baseUrl2 + ButtonPromo.folderPrefix + folderId + "/" + ButtonPromo.iconPath);
                                    ButtonPromo.this.urlList.add(ButtonPromo.this.baseUrl2 + ButtonPromo.folderPrefix + folderId + "/" + ButtonPromo.jsonPath);
                                    ButtonPromo.this.fileListDownload(context, (String) ButtonPromo.this.urlList.remove(0), folderId);
                                }
                            }
                        } catch (Exception e) {
                            Log.e(ButtonPromo.TAG, e.toString());
                            ButtonPromo.this.iconDownloadSuccess = false;
                        }
                    }


                });
            }
        }
    }

    public void fileListDownload(Context context, String url, String folderId) {
        if (context != null) {
            Log.e(TAG, "url " + url);
            File f = getFilePath(url.substring(url.lastIndexOf(47) + 1, url.length()), context, folderId);
            if (f != null && f.getParentFile().isDirectory()) {
                final Context context2 = context;
                final String str = folderId;
                final File file = f;
                LIRestClient.downloadFile(url, null, new FileAsyncHttpResponseHandler(f) {
                    @Override
                    public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, Throwable throwable, File file) {
                        ButtonPromo.this.downloadingFolder = false;
                    }

                    @Override
                    public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, File file) {
                        Log.e(ButtonPromo.TAG, "fileListDownload onSuccess");
                        if (ButtonPromo.this.urlList.size() > 0) {
                            ButtonPromo.this.fileListDownload(context2, (String) ButtonPromo.this.urlList.remove(0), str);
                            return;
                        }
                        ButtonPromo.this.downloadingFolder = false;
                        if (file != null && file.getParentFile().isDirectory() && file.getParentFile().list().length == 2 && ButtonPromo.this.promoButtonDownloadedListener != null) {
                            ButtonPromo.this.promoButtonDownloadedListener.onPromoDownload();
                        }
                    }

                    public void onProgress(long bytesWritten, long totalSize) {
                    }


                });
            }
        }
    }

    public static File getFilePath(String filename, Context context, String folderId) {
        if (context == null) {
            return null;
        }
        File newfile = getDirectory(context, folderId);
        if (newfile != null) {
            return new File(newfile, filename);
        }
        return null;
    }

    public static File getDirectory(Context context, String folderId) {
        if (context == null) {
            return null;
        }
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            String dataDir = getDataDir(context);
            if (dataDir == null) {
                return null;
            }
            File newfile = new File(dataDir + folderName + folderId);
            newfile.mkdir();
            return newfile;
        }
        File newfile = new File(filesDir.getAbsolutePath() + folderName + folderId);
        newfile.mkdir();
        return newfile;
    }

    public static String getDataDir(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.dataDir + "/files";
        } catch (Exception e) {
            return null;
        }
    }

    public static void testDataDir(Context context) {
        try {
            Log.e(TAG, "getDataDir = " + getDataDir(context));
        } catch (Exception e) {
        }
        Log.e(TAG, "filesDir = " + context.getFilesDir().getAbsolutePath());
    }
}
