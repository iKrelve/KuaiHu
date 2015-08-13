package krelve.app.kuaihu.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.loopj.android.http.TextHttpResponseHandler;

import org.apache.http.Header;

import java.util.ArrayList;
import java.util.List;

import krelve.app.kuaihu.R;
import krelve.app.kuaihu.activity.MainActivity;
import krelve.app.kuaihu.adapter.NewsItemAdapter;
import krelve.app.kuaihu.model.Latest;
import krelve.app.kuaihu.util.Constant;
import krelve.app.kuaihu.util.HttpUtils;
import krelve.app.kuaihu.view.Kanner;

/**
 * Created by wwjun.wang on 2015/8/12.
 */
public class MainFragment extends BaseFragment {
    private ListView lv_news;
    private List<Latest> items;
    private Latest latest;
    private Kanner kanner;
    private Handler handler = new Handler();

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_news_layout, container, false);
        lv_news = (ListView) view.findViewById(R.id.lv_news);
        View header = inflater.inflate(R.layout.kanner, lv_news, false);
        kanner = (Kanner) header.findViewById(R.id.kanner);
        kanner.setOnItemClickListener(new Kanner.OnItemClickListener() {
            @Override
            public void click(Latest.TopStoriesEntity entity) {

            }
        });
        lv_news.addHeaderView(header);
        lv_news.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (lv_news != null && lv_news.getChildCount() > 0) {
                    boolean enable = (firstVisibleItem == 0) && (view.getChildAt(firstVisibleItem).getTop() == 0);
                    ((MainActivity) mActivity).setSwipeRefreshEnable(enable);
                }
            }
        });
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        HttpUtils.get(Constant.LATESTNEWS, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Gson gson = new Gson();
                latest = gson.fromJson(responseString, Latest.class);
                kanner.setTopEntities(latest.getTop_stories());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        List<Latest.StoriesEntity> storiesEntities = latest.getStories();
                        Latest.StoriesEntity topic = new Latest.StoriesEntity();
                        topic.setType(Constant.TOPIC);
                        topic.setTitle("今日热闻");
                        storiesEntities.add(0, topic);
                        lv_news.setAdapter(new NewsItemAdapter(mActivity, storiesEntities));
                    }
                });
            }

        });
    }

}
