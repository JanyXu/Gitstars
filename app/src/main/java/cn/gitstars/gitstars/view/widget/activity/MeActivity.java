package cn.gitstars.gitstars.view.widget.activity;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.gitstars.gitstars.R;
import cn.gitstars.gitstars.base.BaseActivity;
import cn.gitstars.gitstars.presenter.MePresenter;
import cn.gitstars.gitstars.view.widget.adapter.MenuAdapter;

public class MeActivity extends BaseActivity<MePresenter> implements View.OnClickListener {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private RecyclerView recyclerView;

    @Override
    protected MePresenter loadPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        setSupportActionBar(toolbar);
        //显示左上角的返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        设置一些recyclerView的内容
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            strings.add(i + "");
        }
//        RecyclerView必须要做的几步
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        MenuAdapter mAdapter = new MenuAdapter();
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_me;
    }

    @Override
    protected void otherViewClick(View view) {

    }
}
