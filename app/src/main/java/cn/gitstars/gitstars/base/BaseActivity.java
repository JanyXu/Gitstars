package cn.gitstars.gitstars.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import cn.gitstars.gitstars.mvp.IPresenter;
import cn.gitstars.gitstars.mvp.IView;
import cn.gitstars.gitstars.utils.LogUtils;

/**
 * Created by GaoSheng on 2016/9/13.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements
        IView, View.OnClickListener {
    protected View view;
    /**
     * fragment管理器
     */
    protected FragmentManager mFragmentManager;

    protected P mPresenter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getView());
        mFragmentManager = getSupportFragmentManager();
        mPresenter = loadPresenter();
        initCommonData();
        initView();
        initListener();
        initData();
    }

    protected abstract P loadPresenter();

    private void initCommonData() {

        if (mPresenter != null)
            mPresenter.attachView(this);
    }

    protected abstract void initData();

    protected abstract void initListener();

    protected abstract void initView();

    protected abstract int getLayoutId();

    protected abstract void otherViewClick(View view);

    /**
     * @return 显示的内容
     */
    public View getView() {
        view = View.inflate(this, getLayoutId(), null);
        return view;
    }

    /**
     * 点击的事件的统一的处理
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            default:
                otherViewClick(view);
                break;
        }

    }


    /**
     * @param str 显示一个内容为str的toast
     */
    public void toast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    /**
     * @param contentId 显示一个内容为contentId指定的toast
     */
    public void toast(int contentId) {
        Toast.makeText(this, contentId, Toast.LENGTH_SHORT).show();
    }


    /**
     * @param str 日志的处理
     */
    public void LogE(String str) {
        LogUtils.e(getClass(), str);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.detachView();
    }

    Fragment mCurrentFragment;

    /**
     * 添加并显示fragment
     *
     * @param showFragment 需要添加的fragment
     */
    protected <T extends Fragment> void addFragment(Fragment showFragment, int res) {
        if (mCurrentFragment != null && showFragment == mCurrentFragment) {
            return;
        }
        Log.i("response","test===============1");
        //验证是否已经显示过当前类
        Fragment fragment = findFragmentByTag(showFragment.getClass());
        if (fragment != null) {
            replaceFragment(fragment, res);
            mCurrentFragment = fragment;
            return;
        }
        Log.i("response","test===============2");
        //首次依附fragment判断
        if (mCurrentFragment == null) {
            //该页面第一次依附fragment，直接添加
            mFragmentManager.beginTransaction()
                    .add(res, showFragment,
                            showFragment.getClass().getName())
                    .commitAllowingStateLoss();
            Log.i("response","test===============3");
        } else {
            //当前有其他页面显示，调用显示隐藏组合拳
            mFragmentManager.beginTransaction()
                    .add(res, showFragment,
                            showFragment.getClass().getName())
                    .hide(mCurrentFragment)
                    .commitAllowingStateLoss();
            Log.i("response","test===============4");
        }
        mCurrentFragment = showFragment;
        Log.i("response","test===============5");
    }

    /**
     * 显示指定fragment
     *
     * @param fragmentClass 需要显示的fragment的类
     */
    protected <T extends Fragment> void replaceFragment(Class<T> fragmentClass, int res) {
        if (mCurrentFragment == null) {
            return;
        }
        Fragment showFragment =
                mFragmentManager.findFragmentByTag(fragmentClass.getName());
        if (showFragment == null) {
            //首次显示，先创建实例
            showFragment = newInstanceFragment(fragmentClass);
            if (showFragment == null) {
                return;
            }
            addFragment(showFragment, res);
        } else {
            replaceFragment(showFragment, res);
        }

        mCurrentFragment = showFragment;
    }

    private void replaceFragment(Fragment showFragment, int res) {
        if (showFragment == null || showFragment == mCurrentFragment) {
            return;
        }
        if (mCurrentFragment == null) {
            addFragment(showFragment, res);
            return;
        }
        mFragmentManager.beginTransaction()
                .show(showFragment)
                .hide(mCurrentFragment)
                .commitAllowingStateLoss();
    }

    /**
     * 创建fragment实例
     *
     * @param fragmentClass
     * @return
     */
    @SuppressWarnings("unchecked")
    private <T extends Fragment> T newInstanceFragment(Class<T> fragmentClass) {
        Fragment showFragment = null;
        try {
            showFragment = fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) showFragment;
    }

    @SuppressWarnings("unchecked")
    protected <T extends Fragment> T findFragmentByTag(Class<T> fragmentClass) {
        return (T) mFragmentManager.findFragmentByTag(fragmentClass.getName());
    }
}

