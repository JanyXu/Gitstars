package cn.gitstars.gitstars.utils;

import android.content.res.TypedArray;

import java.util.ArrayList;
import java.util.List;

import cn.gitstars.gitstars.ProApplication;
import cn.gitstars.gitstars.R;
import cn.gitstars.gitstars.bean.MenuItem;

/**
 * Created by Administrator on 2017/4/27.
 */

public class MenuUtils {
    public static List<MenuItem> getMenuData() {
        TypedArray menuImgResArray;
        String[] listMenuName;
        List<Integer> listMenuImgRes;
        List<cn.gitstars.gitstars.bean.MenuItem> listMenuItem = new ArrayList<>();

        menuImgResArray = ProApplication.getmContext().getResources().obtainTypedArray(R.array.menuImgRes);
        listMenuName = ProApplication.getmContext().getResources().getStringArray(R.array.menuName);
        for (int i = 0; i < listMenuName.length; i++) {
            listMenuItem.add(new cn.gitstars.gitstars.bean.MenuItem(listMenuName[i], menuImgResArray.getResourceId(i, 0)));
        }
        return  listMenuItem;
    }
}
