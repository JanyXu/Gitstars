package cn.gitstars.gitstars.utils;

import android.content.Context;
import android.content.Intent;

import cn.gitstars.gitstars.view.activity.HierarchyActivity;
import cn.gitstars.gitstars.view.activity.MainActivity;
import cn.gitstars.gitstars.view.activity.MeActivity;

/**
 * Created by Administrator on 2017/4/25.
 */

public class ActivitySwitch {

    public static void splashToMain(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public static void mainToMe(Context context) {
        Intent intent = new Intent(context, MeActivity.class);
        context.startActivity(intent);
    }

    public static void trendingToHierchy(Context context) {
        Intent intent = new Intent(context, HierarchyActivity.class);
        intent.putExtra("name","test/test");
        context.startActivity(intent);
    }
}
