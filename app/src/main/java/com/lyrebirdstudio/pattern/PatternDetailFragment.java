package com.lyrebirdstudio.pattern;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.loopj.android.http.FileAsyncHttpResponseHandler;
import com.lyrebirdstudio.R;
import com.lyrebirdstudio.pattern.PatternOnlineFragment.PatternDownloadListener;
import com.squareup.picasso.Picasso;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class PatternDetailFragment extends Fragment {
    public static final String FRAGMENT_TAG = "PatternDetailFragment";
    static final String TAG = "PatternDetailAdapter";
    static final String folderName = "/pattern/";
    Context context;
    View downloadButton;
    boolean downloadMode = true;
    String imageUrl;
    private LayoutManager layoutManager;
    PatternDetailGridAdapter myAdapter;
    OnClickListener myOnClickListener = new C06331();
    String name = "";
    PatternDownloadListener patternDownloadListener;
    ProgressBar progressBar;
    View progressBarContainer;
    private RecyclerView recyclerView;
    TextView textView;
    String[] urlList;
    String zipUrl;

    class C06331 implements OnClickListener {
        C06331() {
        }

        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.button_pattern_download) {
                if (PatternDetailFragment.this.downloadMode) {
                   // PatternDetailFragment.this.zipDownload(PatternDetailFragment.this.context, PatternDetailFragment.this.zipUrl, "");
                } else {
                    PatternDetailFragment.this.removeSelf();
                }
            } else if (id == R.id.button_pattern_detail_back) {
                PatternDetailFragment.this.getActivity().onBackPressed();
            }
        }
    }

    static class C06343 implements Comparator<File> {
        C06343() {
        }

        public int compare(File o1, File o2) {
            if (o1.lastModified() < o2.lastModified()) {
                return 1;
            }
            if (o1.lastModified() > o2.lastModified()) {
                return -1;
            }
            return 0;
        }
    }

    public void setPatternDownloadListener(PatternDownloadListener l) {
        this.patternDownloadListener = l;
    }

    public void setParameters(PatternOnlineListItem item, PatternDownloadListener patternDownloadListener) {
        this.zipUrl = item.zipUrl;
        this.urlList = item.gridUrlArr;
        this.name = item.name;
        if (this.myAdapter != null) {
            this.myAdapter.setData(this.urlList);
        }
        this.imageUrl = item.imageUrl;
        this.patternDownloadListener = patternDownloadListener;
        this.downloadMode = true;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pattern_detail, container, false);
        this.context = view.getContext();
        this.recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_pattern_detail);
        this.recyclerView.setHasFixedSize(true);
        this.layoutManager = new GridLayoutManager(this.context, 4);
        this.recyclerView.setLayoutManager(this.layoutManager);
        this.myAdapter = new PatternDetailGridAdapter(this.context, this.urlList);
        this.recyclerView.setAdapter(this.myAdapter);
        if (this.imageUrl != null) {
            Picasso.with(this.context).load(Uri.parse(this.imageUrl)).into((ImageView) view.findViewById(R.id.image_view_pattern_detail));
            ((TextView) view.findViewById(R.id.text_view_name_pattern_detail)).setText(this.name);
        }
        this.textView = (TextView) view.findViewById(R.id.text_view_pattern_download);
        this.progressBar = (ProgressBar) view.findViewById(R.id.progress_bar_pattern_download);
        this.downloadButton = view.findViewById(R.id.button_pattern_download);
        this.downloadButton.setOnClickListener(this.myOnClickListener);
        this.progressBarContainer = view.findViewById(R.id.pattern_detail_progress_container);
        view.findViewById(R.id.button_pattern_detail_back).setOnClickListener(this.myOnClickListener);
        return view;
    }

    void removeSelf() {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        fm.executePendingTransactions();
        int size = fm.getBackStackEntryCount();
        if (size > 2) {
            size = 2;
        }
        for (int i = 0; i < size; i++) {
            fm.popBackStack();
        }
    }

    /*public void zipDownload(Context context, String url, String folderId) {
        this.downloadButton.setVisibility(4);
        this.progressBarContainer.setVisibility(0);
        if (context != null) {
            final String fileName = url.substring(url.lastIndexOf(47) + 1, url.length());
            File f = getFilePath(fileName, context, folderId);
            if (f != null && f.getParentFile().isDirectory()) {
                LIRestClient.downloadFile(url, null, new FileAsyncHttpResponseHandler(f) {
                    @Override
                    public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, Throwable throwable, File file) {
                        PatternDetailFragment.this.downloadButton.setVisibility(0);
                        PatternDetailFragment.this.progressBarContainer.setVisibility(4);
                        PatternDetailFragment.this.downloadMode = true;
                    }

                    @Override
                    public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, File file) {
                        String absolutePath = file.getAbsolutePath();
                        String unzipped = PatternDetailFragment.this.unpackZip(absolutePath.substring(0, absolutePath.lastIndexOf(File.separator) + 1), fileName);
                        if (!(unzipped == null || PatternDetailFragment.this.patternDownloadListener == null)) {
                            PatternDetailFragment.this.patternDownloadListener.patternDownloaded(unzipped);
                        }
                        PatternDetailFragment.this.downloadButton.setBackgroundResource(R.drawable.selector_pattern_downloaded);
                        PatternDetailFragment.this.downloadButton.setVisibility(0);
                        PatternDetailFragment.this.progressBarContainer.setVisibility(4);
                        PatternDetailFragment.this.downloadMode = false;
                    }

                    public void onProgress(long bytesWritten, long totalSize) {
                        float bw = (float) bytesWritten;
                        float ts = (float) totalSize;
                        if (totalSize > 0) {
                            int progress = (int) ((100.0f * bw) / ts);
                            PatternDetailFragment.this.progressBar.setProgress(progress);
                            PatternDetailFragment.this.textView.setText(progress + "%");
                        }
                    }

                });
            }
        }
    }*/

    private String unpackZip(String path, String zipName) {
        String iconPath = null;
        try {
            ZipInputStream zis = new ZipInputStream(new BufferedInputStream(new FileInputStream(path + zipName)));
            byte[] buffer = new byte[1024];
            while (true) {
                ZipEntry ze = zis.getNextEntry();
                if (ze != null) {
                    String filename = ze.getName();
                    if (filename.contains("icon")) {
                        iconPath = path + filename;
                    }
                    if (ze.isDirectory()) {
                        new File(path + filename).mkdirs();
                    } else {
                        FileOutputStream fout = new FileOutputStream(path + filename);
                        while (true) {
                            int count = zis.read(buffer);
                            if (count == -1) {
                                break;
                            }
                            fout.write(buffer, 0, count);
                        }
                        fout.close();
                        zis.closeEntry();
                    }
                } else {
                    zis.close();
                    return iconPath;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
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

    public static void sortFiles(File[] files) {
        Arrays.sort(files, new C06343());
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            this.zipUrl = savedInstanceState.getString("zipUrl");
            this.name = savedInstanceState.getString("name");
            this.urlList = savedInstanceState.getStringArray("urlList");
            this.imageUrl = savedInstanceState.getString("imageUrl");
            if (this.myAdapter != null && this.urlList != null) {
                this.myAdapter.setData(this.urlList);
            }
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("zipUrl", this.zipUrl);
        outState.putString("name", this.name);
        outState.putStringArray("urlList", this.urlList);
        outState.putString("imageUrl", this.imageUrl);
    }
}
