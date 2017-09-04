package com.lyrebirdstudio.sticker;

import android.content.Context;

import com.loopj.android.http.FileAsyncHttpResponseHandler;
import com.lyrebirdstudio.promodialog.LIRestClient;


import org.apache.http.Header;

import java.io.File;
import java.util.ArrayList;

public class StickerOnlineLib {
    private static final String TAG = StickerOnlineLib.class.getSimpleName();
    public static final String folderName = "/stickers/";
    public static final String jsonUrl = "http://159.203.164.37/lyrebirdstudio/stickerV2.json";

    public interface StickerIconDownloadListener {
        void onStickerListDownloaded(ArrayList<StickerGridItem> arrayList);
    }

    public interface StickerImageDownloadListener {
        void onStickerImageDownloadFailure();

        void onStickerImageDownloaded(String str);
    }

    public interface StickerJSONDownloadListener {
        void onStickerJSONDownloadFailed();

        void onStickerJSONDownloaded(String str);
    }

    public static void downloadSticker(Context context, String url, final StickerImageDownloadListener stickerImageDownloadListener) {
        File f = getFilePath(url.substring(url.lastIndexOf(47) + 1, url.length()), context, "", folderName);
        if (f == null || !f.getParentFile().isDirectory()) {
            stickerImageDownloadListener.onStickerImageDownloadFailure();
        } else {
            LIRestClient.downloadFile(url, null, new FileAsyncHttpResponseHandler(f) {
                @Override
                public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, Throwable throwable, File file) {
                    stickerImageDownloadListener.onStickerImageDownloadFailure();
                }

                @Override
                public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, File file) {
                    stickerImageDownloadListener.onStickerImageDownloaded(file.getAbsolutePath());
                }


            });
        }
    }

    public static String getFileName(String url) {
        return url.substring(url.lastIndexOf(47) + 1, url.length());
    }

    public static File getFilePath(String filename, Context context, String folderId, String folderName) {
        if (context == null) {
            return null;
        }
        File newfile = getDirectory(context, folderId, folderName);
        if (newfile != null) {
            return new File(newfile, filename);
        }
        return null;
    }

    public static File getDirectory(Context context, String folderId, String folderName) {
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

    public static void downloadJSON(Context context, String url, String folderName, final StickerJSONDownloadListener stickerJSONDownloadListener) {
        File f = getJsonFile(context, url, folderName);
        if (f == null || !f.getParentFile().isDirectory()) {
            stickerJSONDownloadListener.onStickerJSONDownloadFailed();
        } else {
            LIRestClient.downloadFile(url, null, new FileAsyncHttpResponseHandler(f) {
                @Override
                public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, Throwable throwable, File file) {
                    stickerJSONDownloadListener.onStickerJSONDownloadFailed();
                }

                @Override
                public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, File file) {
                    stickerJSONDownloadListener.onStickerJSONDownloaded(file.getAbsolutePath());
                }


            });
        }
    }

    public static File getJsonFile(Context context, String url, String folderName) {
        return getFilePath(url.substring(url.lastIndexOf(47) + 1, url.length()), context, "", folderName);
    }
}
