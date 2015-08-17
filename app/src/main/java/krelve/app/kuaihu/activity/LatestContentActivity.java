package krelve.app.kuaihu.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.loopj.android.http.TextHttpResponseHandler;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.apache.http.Header;

import krelve.app.kuaihu.R;
import krelve.app.kuaihu.model.Content;
import krelve.app.kuaihu.model.StoriesEntity;
import krelve.app.kuaihu.util.Constant;
import krelve.app.kuaihu.util.HttpUtils;

/**
 * Created by wwjun.wang on 2015/8/17.
 */
public class LatestContentActivity extends AppCompatActivity {
    private WebView mWebView;
    private StoriesEntity entity;
    private Content content;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.latest_content_layout);
        entity = (StoriesEntity) getIntent().getSerializableExtra("entity");
        iv = (ImageView) findViewById(R.id.iv);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        CollapsingToolbarLayout mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        mCollapsingToolbarLayout.setTitle(entity.getTitle());
//        mCollapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.holo_purple));

        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.getSettings().setJavaScriptEnabled(true);
        HttpUtils.get(Constant.CONTENT + entity.getId(), new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Gson gson = new Gson();
                content = gson.fromJson(responseString, Content.class);
                final ImageLoader imageloader = ImageLoader.getInstance();
                imageloader.displayImage(content.getImage(), iv);
                String css = "<link rel=\"stylesheet\" href=\"file:///android_asset/css/news.css\" type=\"text/css\">";
                String html = "<html><head>" + css + "</head><body>" + content.getBody() + "</body></html>";
                html = html.replace("<div class=\"img-place-holder\">", "");
                mWebView.loadDataWithBaseURL("x-data://base", html, "text/html", "UTF-8", null);
            }
        });
    }
}
