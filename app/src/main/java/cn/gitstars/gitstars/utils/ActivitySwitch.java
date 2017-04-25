package cn.gitstars.gitstars.utils;

import android.content.Context;
import android.content.Intent;

import cn.gitstars.gitstars.activity.MainActivity;

/**
 * Created by Administrator on 2017/4/25.
 */

public class ActivitySwitch {

    public static void splashToMain(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}
