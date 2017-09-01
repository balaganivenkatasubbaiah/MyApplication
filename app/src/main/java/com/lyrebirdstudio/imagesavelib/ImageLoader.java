package com.lyrebirdstudio.imagesavelib;

import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Audio;
import android.provider.MediaStore.Files;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.google.android.exoplayer2.util.MimeTypes;
import com.lyrebirdstudio.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageLoader {
    static boolean DEBUG = true;
    String TAG = "ImageLoader";
    Context context;
    int count = 0;
    Cursor cursorBackup;
    public String filemanagerstring;
    ImageLoaded imageLoadedListener;
    String loadImageMessage = "Loading image!";
    public String selectedCropPath;
    public String selectedImagePath;

    class C06191 implements OnClickListener {
        C06191() {
        }

        public void onClick(DialogInterface dialog, int id) {
            dialog.cancel();
        }
    }

    public interface ImageLoaded {
        void callFileSizeAlertDialogBuilder();
    }

    private class LoadImage19Task extends AsyncTask<Uri, Void, Void> {
        String path;
        ProgressDialog saveImageDialog;
        Uri uri;

        private LoadImage19Task() {
        }

        protected void onPreExecute() {
            super.onPreExecute();
            ImageLoader.this.loadImageMessage = ImageLoader.this.context.getString(R.string.loading_image);
            try {
                this.saveImageDialog = new ProgressDialog(ImageLoader.this.context);
                this.saveImageDialog.setMessage(ImageLoader.this.loadImageMessage);
                this.saveImageDialog.show();
            } catch (Exception e) {
            }
        }

        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            ImageLoader.this.selectedImagePath = this.path;
            ImageLoader.this.startActivityFromUri(this.uri);
            try {
                this.saveImageDialog.dismiss();
            } catch (Exception e) {
            }
        }

        protected Void doInBackground(Uri... arg0) {
            if (arg0 != null) {

                    this.uri = arg0[0];

            }
            if (this.uri != null) {
                try {
                    this.path = ImageLoader.this.getRealPathFromURI19(this.uri);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }

    public void setListener(ImageLoaded l) {
        this.imageLoadedListener = l;
    }

    public ImageLoader(Context context) {
        this.context = context;
    }

    public void getImageFromIntent(Intent intent) {
        Uri selectedImageUri = intent.getData();
        if (selectedImageUri == null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                selectedImageUri = (Uri) bundle.get("android.intent.extra.STREAM");
            } else {
                return;
            }
        }
        if (VERSION.SDK_INT >= 19) {
            try {
                this.selectedImagePath = getPathForKitKat(selectedImageUri);
            } catch (Exception e) {
                Log.e(this.TAG, e.toString());
            }
            if (this.selectedImagePath == null) {
                new LoadImage19Task().execute(new Uri[]{selectedImageUri});
                return;
            }
            startActivityFromUri(selectedImageUri);
            return;
        }
        this.selectedImagePath = getRealPathFromURI(selectedImageUri);
        startActivityFromUri(selectedImageUri);
    }

    void startActivityFromUri(Uri selectedImageUri) {
        if (selectedImageUri != null) {
            this.filemanagerstring = selectedImageUri.getPath();
            if (this.selectedImagePath == null) {
                this.selectedImagePath = this.filemanagerstring;
            }
            if (this.selectedImagePath == null || this.selectedImagePath.length() == 0 || this.selectedImagePath.toLowerCase().contains("http")) {
                new LoadImage19Task().execute(new Uri[]{selectedImageUri});
                this.count++;
            } else if (checkFileExtension(this.selectedImagePath)) {
                this.imageLoadedListener.callFileSizeAlertDialogBuilder();
            } else {
                Builder builder = new Builder(this.context);
                builder.setMessage(this.context.getString(R.string.image_format_error_message)).setCancelable(false).setNegativeButton("Ok", new C06191());
                builder.create().show();
            }
        }
    }

    public String getRealPathFromURI(Uri contentUri) {
        if (this.context == null) {
            return null;
        }
        String res = null;
        String[] proj = new String[]{"_data"};
        Cursor cursor = null;
        if (!(this.context == null || this.context.getContentResolver() == null)) {
            try {
                cursor = this.context.getContentResolver().query(contentUri, proj, null, null, null);
                if (cursor.moveToFirst()) {
                    res = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                }
                cursor.close();
            } catch (Exception e) {
            }
        }
        if (cursor != null && res != null) {
            return res;
        }
        this.cursorBackup = this.context.getContentResolver().query(contentUri, proj, null, null, null);
        try {
            if (this.cursorBackup == null) {
                return res;
            }
            int column_index = this.cursorBackup.getColumnIndexOrThrow("_data");
            this.cursorBackup.moveToFirst();
            return this.cursorBackup.getString(column_index);
        } catch (Exception e2) {
            return res;
        }
    }

    public String getRealPathFromURI19(Uri contentUri) throws IOException {
        Bitmap bitmap = getBitmapFromUri(contentUri);
        if (bitmap == null) {
            return null;
        }
        return saveImageToTemp(bitmap);
    }

    private Bitmap getBitmapFromUri(Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptor = this.context.getContentResolver().openFileDescriptor(uri, "r");
        if (parcelFileDescriptor == null) {
            return null;
        }
        Bitmap image = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
        parcelFileDescriptor.close();
        return image;
    }

    private String saveImageToTemp(Bitmap bitmap) throws FileNotFoundException {
        if (bitmap == null) {
            return null;
        }
        String resultPath = ImageUtility.getPrefferredDirectoryPath(this.context, false, true, false) + "temp/dump.dump";
        new File(resultPath).getParentFile().mkdirs();
        Log.i(this.TAG, "resultPath " + resultPath);
        bitmap.compress(CompressFormat.JPEG, 90, new FileOutputStream(resultPath));
        bitmap.recycle();
        return resultPath;
    }

    private String getFileExtension(String str) {
        if (str == null) {
            str = "";
        }
        int dotPos = str.lastIndexOf(".");
        String extension = "";
        if (dotPos > 0) {
            return str.substring(dotPos);
        }
        return extension;
    }

    private boolean checkFileExtension(String str) {
        String extension = getFileExtension(str).toLowerCase();
        if (extension.contains("jpg") || extension.contains("png") || extension.contains("jpeg") || extension.contains("gif") || extension.contains("bmp") || extension.contains("webp") || extension.contains("dump")) {
            return true;
        }
        return false;
    }

    public void closeCursor() {
        if (this.cursorBackup != null) {
            this.cursorBackup.close();
        }
    }

    @SuppressLint({"NewApi"})
    public String getPathForKitKat(Uri uri) {
        boolean isKitKat;
        if (DEBUG) {
            Log.d(this.TAG + " File -", "Authority: " + uri.getAuthority() + ", Fragment: " + uri.getFragment() + ", Port: " + uri.getPort() + ", Query: " + uri.getQuery() + ", Scheme: " + uri.getScheme() + ", Host: " + uri.getHost() + ", Segments: " + uri.getPathSegments().toString());
        }
        if (VERSION.SDK_INT >= 19) {
            isKitKat = true;
        } else {
            isKitKat = false;
        }
        if (isKitKat && DocumentsContract.isDocumentUri(this.context, uri)) {
            if (isLocalStorageDocument(uri)) {
                return DocumentsContract.getDocumentId(uri);
            }
            String[] split =null;
            if (isExternalStorageDocument(uri)) {
                split = DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(split[0])) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
                return null;
            } else if (isDownloadsDocument(uri)) {
                return getDataColumn(this.context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
            } else if (!isMediaDocument(uri)) {
                return null;
            } else {
                String type = DocumentsContract.getDocumentId(uri).split(":")[0];
                Uri contentUri = null;
                if ("image".equals(type)) {
                    contentUri = Media.EXTERNAL_CONTENT_URI;
                } else if (MimeTypes.BASE_TYPE_VIDEO.equals(type)) {
                    contentUri = Video.Media.EXTERNAL_CONTENT_URI;
                } else if (MimeTypes.BASE_TYPE_AUDIO.equals(type)) {
                    contentUri = Audio.Media.EXTERNAL_CONTENT_URI;
                }
                String selection = "_id=?";
                return getDataColumn(this.context, contentUri, "_id=?", new String[]{split[1]});
            }
        } /*else if (Param.CONTENT.equalsIgnoreCase(uri.getScheme())) {
            if (isGooglePhotosUri(uri)) {
                return uri.getLastPathSegment();
            }
            return getDataColumn(this.context, uri, null, null);
        } */else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        } else {
            return null;
        }
    }

    public static boolean isLocalStorageDocument(Uri uri) {
        return LocalStorageProvider.AUTHORITY.equals(uri.getAuthority());
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs) {
        Cursor cursor = null;
        String column = "_data";
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, selection, selectionArgs, null);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
            if (DEBUG) {
                DatabaseUtils.dumpCursor(cursor);
            }
            String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
            return string;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public String getPathFromUri(Context context, Uri uri) {
        boolean isAfterKitKat = VERSION.SDK_INT >= 19;
        Log.e(this.TAG, "uri:" + uri.getAuthority());
        if (isAfterKitKat && DocumentsContract.isDocumentUri(context, uri)) {
            String type;
            if ("com.android.externalstorage.documents".equals(uri.getAuthority())) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                type = split[0];
                if ("primary".equalsIgnoreCase(type)) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
                return "/stroage/" + type + "/" + split[1];
            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
            } else if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                type = DocumentsContract.getDocumentId(uri).split(":")[0];
                String selection = "_id=?";
                return getDataColumn(context, Files.getContentUri("external"), "_id=?", new String[]{DocumentsContract.getDocumentId(uri).split(":")[1]});
            }
        } /*else if (Param.CONTENT.equalsIgnoreCase(uri.getScheme())) {
            return getDataColumn(context, uri, null, null);
        } */else {
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }
}
