package krelve.app.kuaihu.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import krelve.app.kuaihu.R;
import krelve.app.kuaihu.activity.MainActivity;
import krelve.app.kuaihu.model.NewsListItem;
import krelve.app.kuaihu.util.Constant;
import krelve.app.kuaihu.util.HttpUtils;

public class MenuFragment extends BaseFragment implements OnClickListener {
    private ListView lv_item;
    private TextView tv_download, tv_main;
    // private static String[] ITEMS = { "日常心理学", "用户推荐日报", "电影日报", "不许无聊",
    // "设计日报", "大公司日报", "财经日报", "互联网安全", "开始游戏", "音乐日报", "动漫日报", "体育日报" };
    private List<NewsListItem> items;
    private Handler handler = new Handler();


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu, container, false);
        tv_download = (TextView) view.findViewById(R.id.tv_download);
        tv_download.setOnClickListener(this);
        tv_main = (TextView) view.findViewById(R.id.tv_main);
        tv_main.setOnClickListener(this);
        lv_item = (ListView) view.findViewById(R.id.lv_item);
        lv_item.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                getFragmentManager()
                        .beginTransaction().setCustomAnimations(R.anim.slide_in_from_right, R.anim.slide_out_to_left)
                        .replace(
                                R.id.fl_content,
                                new NewsFragment(items.get(position)
                                        .getId()), "news").commit();
                ((MainActivity) mActivity).setCurId(items.get(position).getId());
                ((MainActivity) mActivity).closeMenu();
            }
        });
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        items = new ArrayList<NewsListItem>();
        HttpUtils.get(Constant.THEMES, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    JSONArray itemsArray = response.getJSONArray("others");
                    for (int i = 0; i < itemsArray.length(); i++) {
                        NewsListItem newsListItem = new NewsListItem();
                        JSONObject itemObject = itemsArray.getJSONObject(i);
                        newsListItem.setTitle(itemObject.getString("name"));
                        newsListItem.setId(itemObject.getString("id"));
                        items.add(newsListItem);
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            lv_item.setAdapter(new NewsTypeAdapter());
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public class NewsTypeAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getActivity()).inflate(
                        R.layout.menu_item, parent, false);
            }
            TextView tv_item = (TextView) convertView
                    .findViewById(R.id.tv_item);
            tv_item.setText(items.get(position).getTitle());
            return convertView;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_main:
                ((MainActivity) mActivity).loadLatest();
                ((MainActivity) mActivity).closeMenu();
                break;
        }
//        switch (v.getId()) {
//            case R.id.tv_download:
//                String CurID = ((MainActivity) getActivity()).getCurID();
//                List<NewsItem> newsItems = null;
//                if (CurID.equals("news")) {
//                    newsItems = ((NewsFragment) getFragmentManager()
//                            .findFragmentByTag("news")).getNewsItems();
//                } else {
//                    newsItems = ((ThemeNewsFragment) getFragmentManager()
//                            .findFragmentByTag("news")).getNewsItems();
//                }
//                Intent downLoadService = new Intent(getActivity(),
//                        DownloadService.class);
//                downLoadService.putExtra("news", (Serializable) newsItems);
//                getActivity().startService(downLoadService);
//                break;
//            case R.id.tv_main:
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.fl_content, new NewsFragment(), "news")
//                        .commit();
//                ((MainActivity) getActivity()).setCurID("news");
//                ((MainActivity) getActivity()).toggle();
//        }
    }
}
