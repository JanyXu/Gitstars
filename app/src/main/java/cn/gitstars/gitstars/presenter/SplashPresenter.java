package cn.gitstars.gitstars.presenter;

import cn.gitstars.gitstars.activity.SplashActivity;
import cn.gitstars.gitstars.base.BasePresenter;
import cn.gitstars.gitstars.contract.LoginContract;
import cn.gitstars.gitstars.model.LoginModel;
import cn.gitstars.gitstars.mvp.IModel;
import cn.gitstars.gitstars.utils.LogUtils;

import java.util.HashMap;

/**
 * Created by JanyXu on 2017/04/25.
 */

public class SplashPresenter extends BasePresenter<SplashActivity> {

    @Override
    public HashMap<String, IModel> getiModelMap() {
        return null;
    }

    @Override
    public HashMap<String, IModel> loadModelMap(IModel... models) {
        return null;
    }
}
