package com.lyrebirdstudio.collagelib;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.preference.PreferenceManager;
import android.util.Log;
import android.webkit.WebView;

import com.lyrebirdstudio.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChangeLog {
    private static final String EOCL = "END_OF_CHANGE_LOG";
    private static final String TAG = "ChangeLog";
    private static final String VERSION_KEY = "PREFS_VERSION_KEY";
    private final Context context;
    private String lastVersion;
    private Listmode listMode;
    private StringBuffer sb;
    private String thisVersion;

    class C05981 implements OnClickListener {
        C05981() {
        }

        public void onClick(DialogInterface dialog, int id) {
            dialog.cancel();
        }
    }

    class C05992 implements OnClickListener {
        C05992() {
        }

        public void onClick(DialogInterface dialog, int id) {
            dialog.cancel();
            ChangeLog.this.getFullLogDialog().show();
        }
    }

    private enum Listmode {
        NONE,
        ORDERED,
        UNORDERED
    }

    public ChangeLog(Context context) {
        this(context, PreferenceManager.getDefaultSharedPreferences(context));
    }

    public ChangeLog(Context context, SharedPreferences sp) {
        this.listMode = Listmode.NONE;
        this.sb = null;
        this.context = context;
        this.lastVersion = sp.getString(VERSION_KEY, "");
        Log.d(TAG, "lastVersion: " + this.lastVersion);
        try {
            this.thisVersion = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            this.thisVersion = "?";
            Log.e(TAG, "could not get version name from manifest!");
            e.printStackTrace();
        }
        Log.d(TAG, "appVersion: " + this.thisVersion);
        Editor editor = sp.edit();
        editor.putString(VERSION_KEY, this.thisVersion);
        editor.commit();
    }

    public String getLastVersion() {
        return this.lastVersion;
    }

    public String getThisVersion() {
        return this.thisVersion;
    }

    public boolean firstRun() {
        return !this.lastVersion.equals(this.thisVersion);
    }

    public boolean firstRunEver() {
        return "".equals(this.lastVersion);
    }

    public AlertDialog getLogDialog() {
        return getDialog(false);
    }

    public AlertDialog getFullLogDialog() {
        return getDialog(true);
    }

    private AlertDialog getDialog(boolean full) {
        WebView wv = new WebView(this.context);
        wv.setBackgroundColor(0);
       // wv.loadDataWithBaseURL(null, getLog(full), AudienceNetworkActivity.WEBVIEW_MIME_TYPE, "UTF-8", null);
        Builder builder = new Builder(this.context);
        builder.setTitle(this.context.getResources().getString(full ? R.string.changelog_full_title : R.string.changelog_title)).setView(wv).setCancelable(false).setPositiveButton(this.context.getResources().getString(R.string.changelog_ok_button), new C05981());
        if (!full) {
            builder.setNegativeButton(R.string.changelog_show_full, new C05992());
        }
        return builder.create();
    }

    public String getLog() {
        return getLog(false);
    }

    public String getFullLog() {
        return getLog(true);
    }

    private String getLog(boolean full) {
        this.sb = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(this.context.getResources().openRawResource(R.raw.changelog)));
            boolean advanceToEOVS = false;
            while (true) {
                String line = br.readLine();
                if (line != null) {
                    char marker;
                    line = line.trim();
                    if (line.length() > 0) {
                        marker = line.charAt(0);
                    } else {
                        marker = '\u0000';
                    }
                    if (marker == '$') {
                        closeList();
                        String version = line.substring(1).trim();
                        if (!full) {
                            if (this.lastVersion.equals(version)) {
                                advanceToEOVS = true;
                            } else if (version.equals(EOCL)) {
                                advanceToEOVS = false;
                            }
                        }
                    } else if (!advanceToEOVS) {
                        switch (marker) {
                            case '!':
                                closeList();
                                this.sb.append("<div class='freetext'>" + line.substring(1).trim() + "</div>\n");
                                break;
                            case '#':
                                openList(Listmode.ORDERED);
                                this.sb.append("<li>" + line.substring(1).trim() + "</li>\n");
                                break;
                            case '%':
                                closeList();
                                this.sb.append("<div class='title'>" + line.substring(1).trim() + "</div>\n");
                                break;
                            case '*':
                                openList(Listmode.UNORDERED);
                                this.sb.append("<li>" + line.substring(1).trim() + "</li>\n");
                                break;
                            case '_':
                                closeList();
                                this.sb.append("<div class='subtitle'>" + line.substring(1).trim() + "</div>\n");
                                break;
                            default:
                                closeList();
                                this.sb.append(line + "\n");
                                break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    closeList();
                    br.close();
                    return this.sb.toString();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.sb.toString();
    }

    private void openList(Listmode listMode) {
        if (this.listMode != listMode) {
            closeList();
            if (listMode == Listmode.ORDERED) {
                this.sb.append("<div class='list'><ol>\n");
            } else if (listMode == Listmode.UNORDERED) {
                this.sb.append("<div class='list'><ul>\n");
            }
            this.listMode = listMode;
        }
    }

    private void closeList() {
        if (this.listMode == Listmode.ORDERED) {
            this.sb.append("</ol></div>\n");
        } else if (this.listMode == Listmode.UNORDERED) {
            this.sb.append("</ul></div>\n");
        }
        this.listMode = Listmode.NONE;
    }

    void setLastVersion(String lastVersion) {
        this.lastVersion = lastVersion;
    }
}
