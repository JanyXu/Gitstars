package cn.gitstars.gitstars.view.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.gitstars.gitstars.R;
import cn.gitstars.gitstars.base.BaseFragment;
import cn.gitstars.gitstars.presenter.TrendingPresenter;
import cn.gitstars.gitstars.utils.ToastUtil;
import cn.gitstars.gitstars.utils.Utils;
import cn.gitstars.gitstars.view.adapter.MenuAdapter;

public class TrendingFragment extends BaseFragment<TrendingPresenter> implements BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {
    @InjectView(R.id.rv_trending)
    RecyclerView rv_trending;
    @InjectView(R.id.sr_trending)
    SwipeRefreshLayout sr_trending;

    @Override
    protected TrendingPresenter loadPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        ToastUtil.setToast("haha");
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        ButterKnife.inject(this, getView());
        rv_trending.setLayoutManager(new LinearLayoutManager(Utils.getContext()));
        MenuAdapter menuAdapter = new MenuAdapter();
        menuAdapter.setOnLoadMoreListener(this, rv_trending);
        sr_trending.setOnRefreshListener(this);
        menuAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        rv_trending.setAdapter(menuAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_trending;
    }

    @Override
    protected void otherViewClick(View view) {

    }

    @Override
    public void onLoadMoreRequested() {

    }

    @Override
    public void onRefresh() {

    }
}
