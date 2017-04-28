package cn.gitstars.gitstars.presenter;

import java.util.HashMap;

import cn.gitstars.gitstars.view.activity.MainActivity;
import cn.gitstars.gitstars.base.BasePresenter;
import cn.gitstars.gitstars.mvp.IModel;

/**
 * Created by JanyXu on 2017/04/25.
 */

public class MainPresenter extends BasePresenter<MainActivity> {

    @Override
    public HashMap<String, IModel> getiModelMap() {
        return null;
    }

    @Override
    public HashMap<String, IModel> loadModelMap(IModel... models) {
        return null;
    }
}