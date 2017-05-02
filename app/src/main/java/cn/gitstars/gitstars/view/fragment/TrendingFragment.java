package cn.gitstars.gitstars.view.fragment;

import android.animation.Animator;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.gitstars.gitstars.R;
import cn.gitstars.gitstars.base.BaseFragment;
import cn.gitstars.gitstars.presenter.TrendingPresenter;
import cn.gitstars.gitstars.utils.ToastUtil;
import cn.gitstars.gitstars.utils.Utils;
import cn.gitstars.gitstars.view.adapter.MenuAdapter;

public class TrendingFragment extends BaseFragment<TrendingPresenter> implements BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener, View.OnTouchListener {
    @InjectView(R.id.rv_trending)
    RecyclerView rv_trending;
    @InjectView(R.id.sr_trending)
    SwipeRefreshLayout sr_trending;
    @InjectView(R.id.ib_search)
    ImageButton ib_search;
    @InjectView(R.id.rl_search)
    RelativeLayout rl_search;
    @InjectView(R.id.ll_search)
    LinearLayout ll_search;
    @InjectView(R.id.ll_search_cancel)
    LinearLayout ll_search_cancel;
    @InjectView(R.id.btn_search_cancel)
    Button btn_search_cancel;

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
        ib_search.setOnTouchListener(this);
        btn_search_cancel.setOnTouchListener(this);
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

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            ToastUtil.setToast("test");
            if (view.getId() == R.id.ib_search) {
                ToastUtil.setToast("test");
                ll_search.setVisibility(View.GONE);
                ll_search_cancel.setVisibility(View.VISIBLE);
                revealYellow(motionEvent.getRawX(), motionEvent.getRawY());
            } else if (view.getId() == R.id.btn_search_cancel) {
                ToastUtil.setToast("test");
                ll_search_cancel.setVisibility(View.GONE);
                ll_search.setVisibility(View.VISIBLE);
                revealYellow(motionEvent.getRawX(), motionEvent.getRawY());
            }
        }
        return false;
    }

    private void revealYellow(float x, float y) {
        animateRevealColorFromCoordinates(rl_search, R.color.white, (int) x, (int) y);
    }

    private Animator animateRevealColorFromCoordinates(ViewGroup viewRoot, @ColorRes int color, int x, int y) {
        float finalRadius = (float) Math.hypot(viewRoot.getWidth(), viewRoot.getHeight());
        Animator anim = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            anim = ViewAnimationUtils.createCircularReveal(viewRoot, x, y, 0, finalRadius);
        }
        viewRoot.setBackgroundColor(ContextCompat.getColor(Utils.getContext(), color));
        anim.setDuration(getResources().getInteger(R.integer.anim_duration_long));
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.start();
        return anim;
    }
}

