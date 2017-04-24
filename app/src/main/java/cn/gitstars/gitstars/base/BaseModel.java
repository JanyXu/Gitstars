package cn.gitstars.gitstars.base;

import cn.gitstars.gitstars.http.Http;
import cn.gitstars.gitstars.http.HttpService;
import cn.gitstars.gitstars.mvp.IModel;

/**
 * Created by gaosheng on 2016/12/1.
 * 23:13
 * com.example.gs.mvpdemo.base
 */

public class BaseModel implements IModel {
    protected static HttpService httpService;

    //初始化httpService
    static {
        httpService = Http.getHttpService();
    }

}
