package com.lyrebirdstudio.pattern;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.lyrebirdstudio.R;
import com.lyrebirdstudio.pattern.PatternDeleteListAdapter.ItemSelectedListener;
import com.lyrebirdstudio.pattern.PatternOnlineFragment.PatternDownloadListener;

import java.io.File;
import java.util.ArrayList;

public class PatternDeleteFragment extends Fragment {
    public static final String FRAGMENT_TAG = "PatternDeleteFragment";
    static final String TAG = "PatternDeleteFragment";
    Context context;
    private ArrayList<String> data = new ArrayList();
    private LayoutManager layoutManager;
    private PatternDeleteListAdapter myAdapter;
    PatternDownloadListener patternDownloadListener;
    private RecyclerView recyclerView;

    class C06302 implements OnClickListener {
        C06302() {
        }

        public void onClick(View v) {
            PatternDeleteFragment.this.getActivity().onBackPressed();
        }
    }

    class C06313 implements DialogInterface.OnClickListener {
        C06313() {
        }

        public void onClick(DialogInterface dialog, int id) {
        }
    }

    class C10301 implements ItemSelectedListener {
        C10301() {
        }

        public void onItemSelected(int index) {
            int position = index;
            PatternDeleteFragment.this.showSelectedArticle((String) PatternDeleteFragment.this.myAdapter.data.get(position), position);
        }
    }

    public void setPatternDownloadListener(PatternDownloadListener patternDownloadListener) {
        this.patternDownloadListener = patternDownloadListener;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pattern_delete, container, false);
        this.context = view.getContext();
        this.recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        this.recyclerView.setHasFixedSize(true);
        this.layoutManager = new LinearLayoutManager(this.context);
        this.recyclerView.setLayoutManager(this.layoutManager);
        createData();
        this.myAdapter = new PatternDeleteListAdapter(this.context, this.data);
        this.myAdapter.setItemSelectedListener(new C10301());
        this.recyclerView.setAdapter(this.myAdapter);
        view.findViewById(R.id.button_pattern_online_back).setOnClickListener(new C06302());
        return view;
    }

    void createData() {
        this.data.clear();
        if (PatternHelper.sdIdList != null && PatternHelper.sdIdList.size() > 0) {
            for (int i = 0; i < PatternHelper.sdIdList.size(); i++) {
                this.data.add(PatternDetailFragment.getDirectory(getActivity(), "") + "/" + ((String) PatternHelper.sdIdList.get(i)));
            }
        }
    }

    private void showSelectedArticle(final String item, final int position) {
        new Builder(this.context).setMessage(getString(R.string.save_image_lib_save_image_message)).setCancelable(true).setPositiveButton(getString(17039379), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                File f = new File(item);
                if (f.exists() && PatternDeleteFragment.deleteRecursive(f)) {
                    PatternHelper.sdIdList.remove(position);
                    PatternDeleteFragment.this.createData();
                    PatternDeleteFragment.this.myAdapter.setData(PatternDeleteFragment.this.data);
                    PatternDeleteFragment.this.myAdapter.notifyDataSetChanged();
                    PatternDeleteFragment.this.patternDownloadListener.patternDeleted(item);
                }
            }
        }).setNegativeButton(getString(17039360), new C06313()).create().show();
    }

    public static boolean deleteRecursive(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory()) {
            for (File child : fileOrDirectory.listFiles()) {
                deleteRecursive(child);
            }
        }
        return fileOrDirectory.delete();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            PatternHelper.sdIdList = savedInstanceState.getStringArrayList("sdList");
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("sdList", PatternHelper.sdIdList);
    }
}
