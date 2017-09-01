package com.lyrebirdstudio.pattern;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.lyrebirdstudio.R;
import com.lyrebirdstudio.pattern.PatternOnlineListAdapter.ItemSelectedListener;

import java.util.ArrayList;
import java.util.Iterator;

public class PatternOnlineFragment extends Fragment {
    public static final String FRAGMENT_TAG = "PatternOnlineFragment";
    static final String TAG = "PatternOnlineFragment";
    static String[][] gridUrlList;
    static String[] nameList = new String[]{"Denim", "Doodle", "Fur", "Leaf", "Metal", "Wood"};
    static String[][] onlinePatternList;
    private ArrayList<PatternOnlineListItem> articleList;
    Context context;
    PatternDownloadListener deleteListener = new C10405();
    PatternDownloadListener detailListener = new C10394();
    int detail_layout_id;
    Fragment fragment = this;
    private LayoutManager layoutManager;
    private PatternOnlineListAdapter myAdapter;
    PatternDownloadListener patternDownloadListener;
    private RecyclerView recyclerView;

    class C06352 implements OnClickListener {
        C06352() {
        }

        public void onClick(View v) {
            PatternOnlineFragment.this.getActivity().onBackPressed();
        }
    }

    class C06363 implements OnClickListener {
        C06363() {
        }

        public void onClick(View v) {
            PatternOnlineFragment.this.createDeleteFragment();
        }
    }

    public interface PatternDownloadListener {
        void patternDeleted(String str);

        void patternDownloadError();

        void patternDownloaded(String str);
    }

    class C10381 implements ItemSelectedListener {
        C10381() {
        }

        public void onItemSelected(int index) {
            PatternOnlineFragment.this.showSelectedArticle((PatternOnlineListItem) PatternOnlineFragment.this.myAdapter.data.get(index));
        }
    }

    class C10394 implements PatternDownloadListener {
        C10394() {
        }

        public void patternDownloaded(String path) {
            PatternOnlineFragment.addToSdList(PatternHelper.sdIdList, path);
            PatternOnlineFragment.this.articleList = PatternOnlineFragment.this.getArticleData();
            PatternOnlineFragment.this.myAdapter.setData(PatternOnlineFragment.this.articleList);
            PatternOnlineFragment.this.patternDownloadListener.patternDownloaded(path);
        }

        public void patternDeleted(String path) {
        }

        public void patternDownloadError() {
        }
    }

    class C10405 implements PatternDownloadListener {
        C10405() {
        }

        public void patternDownloaded(String path) {
        }

        public void patternDeleted(String path) {
            PatternOnlineFragment.this.articleList = PatternOnlineFragment.this.getArticleData();
            PatternOnlineFragment.this.myAdapter.setData(PatternOnlineFragment.this.articleList);
            PatternOnlineFragment.this.patternDownloadListener.patternDeleted(path);
        }

        public void patternDownloadError() {
        }
    }

    public void setPatternDownloadListener(PatternDownloadListener patternDownloadListener) {
        this.patternDownloadListener = patternDownloadListener;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pattern_online, container, false);
        this.context = view.getContext();
        this.recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        this.recyclerView.setHasFixedSize(true);
        this.layoutManager = new LinearLayoutManager(this.context);
        this.recyclerView.setLayoutManager(this.layoutManager);
        this.articleList = getArticleData();
        this.myAdapter = new PatternOnlineListAdapter(this.context, this.articleList);
        this.myAdapter.setItemSelectedListener(new C10381());
        this.recyclerView.setAdapter(this.myAdapter);
        view.findViewById(R.id.button_pattern_online_back).setOnClickListener(new C06352());
        view.findViewById(R.id.button_pattern_delete).setOnClickListener(new C06363());
        PatternDeleteFragment deleteFragment = (PatternDeleteFragment) getFragmentManager().findFragmentByTag(PatternDeleteFragment.FRAGMENT_TAG);
        if (deleteFragment != null) {
            deleteFragment.setPatternDownloadListener(this.deleteListener);
        }
        PatternDetailFragment detailFragment = (PatternDetailFragment) getFragmentManager().findFragmentByTag(PatternDetailFragment.FRAGMENT_TAG);
        if (detailFragment != null) {
            detailFragment.setPatternDownloadListener(this.detailListener);
        }
        return view;
    }

    private void showSelectedArticle(PatternOnlineListItem item) {
        PatternDetailFragment nextFrag = new PatternDetailFragment();
        nextFrag.setParameters(item, this.detailListener);
        getFragmentManager().beginTransaction().add(R.id.pattern_fragment_container, nextFrag, PatternDetailFragment.FRAGMENT_TAG).addToBackStack(PatternDetailFragment.FRAGMENT_TAG).commitAllowingStateLoss();
    }

    boolean checkSdList(String path) {
        if (PatternHelper.sdIdList == null || PatternHelper.sdIdList.isEmpty()) {
            return false;
        }
        Iterator it = PatternHelper.sdIdList.iterator();
        while (it.hasNext()) {
            if (path.contains((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<PatternOnlineListItem> getArticleData() {
        this.articleList = new ArrayList();
        for (int i = 0; i < onlinePatternList.length; i++) {
            if (!checkSdList(onlinePatternList[i][1])) {
                this.articleList.add(new PatternOnlineListItem(onlinePatternList[i][0], onlinePatternList[i][1], nameList[i], gridUrlList[i]));
            }
        }
        return this.articleList;
    }

    static {
         String[][] r0 = new String[6][];
        r0[0] = new String[]{"https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/preview_denim.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/pattern_denim.zip"};
        r0[1] = new String[]{"https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/preview_doodle.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/pattern_doodle.zip"};
        r0[2] = new String[]{"https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/preview_fur.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/pattern_fur.zip"};
        r0[3] = new String[]{"https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/preview_leaf.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/pattern_leaf.zip"};
        r0[4] = new String[]{"https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/preview_metal.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/pattern_metal.zip"};
        r0[5] = new String[]{"https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/preview_wood.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/pattern_wood.zip"};
        onlinePatternList = r0;
        r0 = new String[6][];
        r0[0] = new String[]{"https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_143.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_144.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_145.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_146.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_147.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_148.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_149.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_150.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_151.jpg"};
        r0[1] = new String[]{"https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_152.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_153.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_154.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_155.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_156.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_157.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_158.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_159.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_160.jpg"};
        r0[2] = new String[]{"https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_161.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_162.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_163.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_164.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_165.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_166.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_167.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_168.jpg"};
        r0[3] = new String[]{"https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_169.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_170.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_171.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_172.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_173.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_174.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_175.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_176.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_177.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_178.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_179.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_180.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_181.jpg"};
        r0[4] = new String[]{"https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_182.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_183.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_184.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_185.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_186.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_187.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_188.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_189.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_190.jpg"};
        r0[5] = new String[]{"https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_191.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_192.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_193.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_194.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_195.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_196.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_197.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_198.jpg", "https://s3-us-west-2.amazonaws.com/lyrebirdstudio/patterns/icons/pattern_199.jpg"};
        gridUrlList = r0;
    }

    public static void addToSdList(ArrayList<String> list, String path) {
        String folder = path.substring(path.substring(0, path.lastIndexOf("/")).lastIndexOf("/") + 1, path.lastIndexOf("/"));
        int i = 0;
        while (i < list.size()) {
            if (((String) list.get(i)).compareTo(folder) != 0) {
                i++;
            } else {
                return;
            }
        }
        list.add(folder);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            PatternHelper.sdIdList = savedInstanceState.getStringArrayList("sdList");
            if (PatternHelper.sdIdList == null) {
                PatternHelper.sdIdList = new ArrayList();
            }
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("sdList", PatternHelper.sdIdList);
    }

    void createDeleteFragment() {
        PatternDeleteFragment nextFrag = new PatternDeleteFragment();
        nextFrag.setPatternDownloadListener(this.deleteListener);
        this.fragment.getFragmentManager().beginTransaction().add(R.id.pattern_fragment_container, nextFrag, PatternDeleteFragment.FRAGMENT_TAG).addToBackStack(PatternDeleteFragment.FRAGMENT_TAG).commitAllowingStateLoss();
    }
}
