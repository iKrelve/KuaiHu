package krelve.app.kuaihu.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.loopj.android.http.TextHttpResponseHandler;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.apache.http.Header;

import java.util.ArrayList;

import krelve.app.kuaihu.R;
import krelve.app.kuaihu.activity.MainActivity;
import krelve.app.kuaihu.adapter.NewsItemAdapter;
import krelve.app.kuaihu.model.News;
import krelve.app.kuaihu.util.Constant;
import krelve.app.kuaihu.util.HttpUtils;

/**
 * Created by wwjun.wang on 2015/8/14.
 */
@SuppressLint("ValidFragment")
public class NewsFragment extends BaseFragment {
    private ImageLoader mImageLoader;
    private ListView lv_news;
    private ImageView iv_title;
    private TextView tv_title;
    private String urlId;
    private News news;


    public NewsFragment(String id) {
        urlId = id;
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_layout, container, false);
        mImageLoader = ImageLoader.getInstance();
        lv_news = (ListView) view.findViewById(R.id.lv_news);
        View header = LayoutInflater.from(mActivity).inflate(
                R.layout.news_header, lv_news, false);
        iv_title = (ImageView) header.findViewById(R.id.iv_title);
        tv_title = (TextView) header.findViewById(R.id.tv_title);
        lv_news.addHeaderView(header);
//        lv_news.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//                NewsItem newsItem = (NewsItem) parent.getAdapter().getItem(
//                        position);
//                Intent intent = new Intent(getActivity(),
//                        ThemeNewsContentActivity.class);
//                intent.putExtra("id", newsItem.getId());
//                intent.putExtra("title", newsItem.getTitle());
//                startActivity(intent);
//            }
//        });
        lv_news.setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
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
        HttpUtils.get(Constant.THEMENEWS + urlId, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Gson gson = new Gson();
                news = gson.fromJson(responseString, News.class);
                tv_title.setText(news.getDescription());
                mImageLoader.displayImage(news.getImage(), iv_title);
                lv_news.setAdapter(new NewsItemAdapter(mActivity, news.getStories()));
            }
        });
    }
}
