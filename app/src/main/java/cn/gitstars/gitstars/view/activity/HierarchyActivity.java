package cn.gitstars.gitstars.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import cn.gitstars.gitstars.R;
import cn.gitstars.gitstars.base.BaseActivity;
import cn.gitstars.gitstars.presenter.HierarchyPresenter;
import cn.gitstars.gitstars.view.adapter.HierarchyHorizontalAdapter;
import cn.gitstars.gitstars.view.adapter.HierarchyVerticalAdapter;

public class HierarchyActivity extends BaseActivity<HierarchyPresenter> implements SwipeRefreshLayout.OnRefreshListener {
    private String name;
    private static final String KEY_NAME = "name";
    private String[] requestArr;

    private RecyclerView mRecyclerViewHorizontal;
    private RecyclerView mRecyclerViewVertical;
    private Toolbar mToolbar;
    private SwipeRefreshLayout mRefreshLayout;
    private HierarchyVerticalAdapter mVerticalAdapter;
    private HierarchyHorizontalAdapter mHorizontalAdapter;


    public static void launcher(Context context, String name) {
        if (TextUtils.isEmpty(name)) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(KEY_NAME, name);
        intent.setClass(context, HierarchyActivity.class);
        context.startActivity(intent);
    }

    public static void launcher(Fragment fragment, String name) {
        if (TextUtils.isEmpty(name)) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(KEY_NAME, name);
        intent.setClass(fragment.getActivity(), HierarchyActivity.class);
        fragment.startActivity(intent);
    }

    @Override
    protected HierarchyPresenter loadPresenter() {
        return new HierarchyPresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        if (getIntent().hasExtra(KEY_NAME) && !TextUtils.isEmpty(name = getIntent().getStringExtra(KEY_NAME))) {
            requestArr = name.split("/");
            if (requestArr.length != 2) {
                Toast.makeText(this, "参数错误", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                initUi();
                //HierarchyPresenter.requestDirector(name).subscribe(this);
            }
        } else {
            finish();
        }
    }

    private void showRefresh() {
        mRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setRefreshing(true);
            }
        }, 10);
    }


    private void initUi() {
        mRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        mRecyclerViewHorizontal = (RecyclerView) findViewById(R.id.recyclerView_horizontal);
        mRecyclerViewVertical = (RecyclerView) findViewById(R.id.recyclerView_vertical);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mRecyclerViewVertical.setLayoutManager(new LinearLayoutManager(this));
        mVerticalAdapter = new HierarchyVerticalAdapter();
        mRecyclerViewVertical.setAdapter(mVerticalAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerViewHorizontal.setLayoutManager(linearLayoutManager);
        mHorizontalAdapter = new HierarchyHorizontalAdapter();
        mRecyclerViewHorizontal.setAdapter(mHorizontalAdapter);


        mRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_light,
                android.R.color.holo_red_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_green_light);
        mRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_hierarchy;
    }

    @Override
    protected void otherViewClick(View view) {

    }

    @Override
    public void onRefresh() {

    }


}
