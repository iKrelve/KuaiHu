package krelve.app.kuaihu.activity;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import krelve.app.kuaihu.R;
import krelve.app.kuaihu.fragment.MainFragment;
import krelve.app.kuaihu.fragment.MenuFragment;
import krelve.app.kuaihu.fragment.NewsFragment;

public class MainActivity extends AppCompatActivity {
    private FrameLayout fl_content;
    private MenuFragment menu_fragment;
    private DrawerLayout mDrawerLayout;
    private SwipeRefreshLayout sr;
    private long firstTime;
    private String curId;
    private Toolbar toolbar;
    private boolean isLight;
    private SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = PreferenceManager.getDefaultSharedPreferences(this);
        isLight = sp.getBoolean("isLight", true);
        initView();
        loadLatest();
    }

    public void loadLatest() {
        getSupportFragmentManager().beginTransaction().
                setCustomAnimations(R.anim.slide_in_from_right, R.anim.slide_out_to_left).
                replace(R.id.fl_content, new MainFragment(), "latest").
                commit();
        curId = "latest";
    }

    public void setCurId(String id) {
        curId = id;
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(isLight ? R.color.light_toolbar : R.color.dark_toolbar));
        setSupportActionBar(toolbar);
        sr = (SwipeRefreshLayout) findViewById(R.id.sr);
        sr.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        sr.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                replaceFragment();
                sr.setRefreshing(false);
            }
        });
        fl_content = (FrameLayout) findViewById(R.id.fl_content);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        final ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                toolbar, R.string.app_name, R.string.app_name);
        mDrawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    public void replaceFragment() {
        if (curId.equals("latest")) {
            getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in_from_right, R.anim.slide_out_to_left)
                    .replace(R.id.fl_content,
                            new MainFragment(), "latest").commit();
        } else {

        }

    }

    public void closeMenu() {
        mDrawerLayout.closeDrawers();
    }

    public void setSwipeRefreshEnable(boolean enable) {
        sr.setEnabled(enable);
    }

    public void setToolbarTitle(String text) {
        toolbar.setTitle(text);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_mode) {
            isLight = !isLight;
            toolbar.setBackgroundColor(getResources().getColor(isLight ? R.color.light_toolbar : R.color.dark_toolbar));
            if (curId.equals("latest")) {
                ((MainFragment) getSupportFragmentManager().findFragmentByTag("latest")).updateTheme();
            } else {
                ((NewsFragment) getSupportFragmentManager().findFragmentByTag("news")).updateTheme();
            }
            ((MenuFragment) getSupportFragmentManager().findFragmentById(R.id.menu_fragment)).updateTheme();
            sp.edit().putBoolean("isLight", isLight).commit();
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean isLight() {
        return isLight;
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
            closeMenu();
        } else {
            long secondTime = System.currentTimeMillis();
            if (secondTime - firstTime > 2000) {
                Snackbar sb = Snackbar.make(fl_content, "再按一次退出", Snackbar.LENGTH_SHORT);
                sb.getView().setBackgroundColor(getResources().getColor(isLight ? android.R.color.holo_blue_dark : android.R.color.black));
                sb.show();
                firstTime = secondTime;
            } else {
                finish();
            }
        }

    }
}
