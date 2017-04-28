package cn.gitstars.gitstars.presenter;

import java.util.HashMap;

import cn.gitstars.gitstars.base.BasePresenter;
import cn.gitstars.gitstars.mvp.IModel;
import cn.gitstars.gitstars.view.activity.MainActivity;

/**
 * Created by Administrator on 2017/4/27.
 */

public class MePresenter extends BasePresenter<MainActivity> {

    @Override
    public HashMap<String, IModel> getiModelMap() {
        return null;
    }

    @Override
    public HashMap<String, IModel> loadModelMap(IModel... models) {
        return null;
    }
}