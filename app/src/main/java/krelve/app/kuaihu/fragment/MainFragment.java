package krelve.app.kuaihu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.TextHttpResponseHandler;

import org.apache.http.Header;

import java.util.List;

import krelve.app.kuaihu.R;
import krelve.app.kuaihu.activity.LatestContentActivity;
import krelve.app.kuaihu.activity.MainActivity;
import krelve.app.kuaihu.adapter.MainNewsItemAdapter;
import krelve.app.kuaihu.model.Before;
import krelve.app.kuaihu.model.Latest;
import krelve.app.kuaihu.model.StoriesEntity;
import krelve.app.kuaihu.util.Constant;
import krelve.app.kuaihu.util.HttpUtils;
import krelve.app.kuaihu.view.Kanner;

/**
 * Created by wwjun.wang on 2015/8/12.
 */
public class MainFragment extends BaseFragment {
    private ListView lv_news;
    private MainNewsItemAdapter mAdapter;
    private Latest latest;
    private Before before;
    private Kanner kanner;
    private String date;
    private boolean isLoading = false;
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
        mAdapter = new MainNewsItemAdapter(mActivity);
        lv_news.setAdapter(mAdapter);
        lv_news.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (lv_news != null && lv_news.getChildCount() > 0) {
                    boolean enable = (firstVisibleItem == 0) && (view.getChildAt(firstVisibleItem).getTop() == 0);
                    ((MainActivity) mActivity).setSwipeRefreshEnable(enable);

                    if (firstVisibleItem + visibleItemCount == totalItemCount && !isLoading) {
                        loadMore(Constant.BEFORE + date);
                    }
                }

            }
        });
        lv_news.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StoriesEntity entity = (StoriesEntity) parent.getAdapter().getItem(position);
                Intent intent = new Intent(mActivity, LatestContentActivity.class);
                intent.putExtra("entity",entity);
                startActivity(intent);
            }
        });
        return view;
    }

    private void loadFirst() {
        isLoading = true;
        HttpUtils.get(Constant.LATESTNEWS, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Gson gson = new Gson();
                latest = gson.fromJson(responseString, Latest.class);
                date = latest.getDate();
                kanner.setTopEntities(latest.getTop_stories());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        List<StoriesEntity> storiesEntities = latest.getStories();
                        StoriesEntity topic = new StoriesEntity();
                        topic.setType(Constant.TOPIC);
                        topic.setTitle("今日热闻");
                        storiesEntities.add(0, topic);
                        mAdapter.addList(storiesEntities);
                        isLoading = false;
                    }
                });
            }

        });
    }

    private void loadMore(final String url) {
        isLoading = true;
        HttpUtils.get(url, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Gson gson = new Gson();
                before = gson.fromJson(responseString, Before.class);
                date = before.getDate();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        List<StoriesEntity> storiesEntities = before.getStories();
                        StoriesEntity topic = new StoriesEntity();
                        topic.setType(Constant.TOPIC);
                        topic.setTitle(convertDate(date));
                        storiesEntities.add(0, topic);
                        mAdapter.addList(storiesEntities);
                        isLoading = false;
                    }
                });
            }

        });
    }

    @Override
    protected void initData() {
        super.initData();
        loadFirst();
    }

    private String convertDate(String date) {
        String result = date.substring(0, 4);
        result += "年";
        result += date.substring(4, 6);
        result += "月";
        result += date.substring(6, 8);
        result += "日";
        return result;
    }

}
