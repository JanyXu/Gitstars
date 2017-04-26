package cn.gitstars.gitstars.activity;

import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.gitstars.gitstars.R;
import cn.gitstars.gitstars.base.BaseActivity;
import cn.gitstars.gitstars.presenter.MainPresenter;
import cn.gitstars.gitstars.utils.ToastUtil;

/**
 * Created by JanyXu on 2017/04/25.
 * 首页
 */
public class MainActivity extends BaseActivity<MainPresenter> implements View.OnClickListener {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.drawer_layout)
    DrawerLayout drawer_layout;
    @InjectView(R.id.navigation_start)
    NavigationView navigation_start;
    @InjectView(R.id.navigation_end)
    NavigationView navigation_end;
    Button btn_close;

    @Override
    protected MainPresenter loadPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        ButterKnife.inject(this);
        //ButterKnife.inject(this,navigation_end.getHeaderView(0));
//        btn_close = ButterKnife.findById(navigation_end.getHeaderView(0), R.id.btn_close);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitle("首页");
        toolbar.setOnCreateContextMenuListener(this);
        setSupportActionBar(toolbar);
        //设置左上角图标是否可点击
//        getSupportActionBar().setHomeButtonEnabled(true);
//        //左上角加上一个返回图标
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigation_end.setNavigationItemSelectedListener(

                new NavigationView.OnNavigationItemSelectedListener() {

                    private MenuItem mPreMenuItem;

                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        if (mPreMenuItem != null) mPreMenuItem.setChecked(false);

                        return true;
                    }
                });
        //btn_close.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void otherViewClick(View view) {
        switch (view.getId()) {
            case R.id.btn_close:
                ToastUtil.setToast("ggg");
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            //显示右侧栏
            if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
                drawer_layout.closeDrawer(GravityCompat.START);
            }
            drawer_layout.openDrawer(GravityCompat.END);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
