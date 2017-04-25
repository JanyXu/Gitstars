package cn.gitstars.gitstars.activity;

import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.gitstars.gitstars.R;
import cn.gitstars.gitstars.base.BaseActivity;
import cn.gitstars.gitstars.presenter.MainPresenter;

/**
 * Created by JanyXu on 2017/04/25.
 * 首页
 */
public class MainActivity extends BaseActivity<MainPresenter> {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.drawer_layout)
    DrawerLayout drawer_layout;
    @InjectView(R.id.navigation_start)
    NavigationView navigation_start;
    @InjectView(R.id.navigation_end)
    NavigationView navigation_end;

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
        toolbar.setTitleTextColor(Color.WHITE);
        //设置toolbar标题文本
        toolbar.setTitle("首页");
        toolbar.setOnCreateContextMenuListener(this);
        //设置toolbar
        setSupportActionBar(toolbar);
        //设置左上角图标是否可点击
//        getSupportActionBar().setHomeButtonEnabled(true);
//        //左上角加上一个返回图标
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        //初始化ActionBarDrawerToggle(ActionBarDrawerToggle就是一个开关一样用来打开或者关闭drawer)
//        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawer_layout, toolbar, R.string.openString, R.string.closeString) {
//            /*
//            * 抽屉菜单打开监听
//            * */
//            @Override
//            public void onDrawerOpened(View drawerView) {
//                Toast.makeText(MainActivity.this, "菜单打开了", Toast.LENGTH_SHORT).show();
//                super.onDrawerOpened(drawerView);
//            }
//
//            /*
//            * 抽屉菜单关闭监听
//            * */
//            @Override
//            public void onDrawerClosed(View drawerView) {
//                Toast.makeText(MainActivity.this, "菜单关闭了", Toast.LENGTH_SHORT).show();
//                super.onDrawerClosed(drawerView);
//            }
//        };
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void otherViewClick(View view) {

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
