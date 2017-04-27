package cn.gitstars.gitstars.view.widget.adapter;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import cn.gitstars.gitstars.R;
import cn.gitstars.gitstars.bean.MenuItem;
import cn.gitstars.gitstars.utils.MenuUtils;
import cn.gitstars.gitstars.utils.Utils;

/**
 * Created by Administrator on 2017/4/27.
 */

public class MenuAdapter extends BaseQuickAdapter<MenuItem, BaseViewHolder> {
    public MenuAdapter() {
        super(R.layout.layout_animation, MenuUtils.getMenuData());
    }

    @Override
    protected void convert(BaseViewHolder helper, MenuItem item) {
        try {
            Drawable img_off;
            Resources res = Utils.getContext().getResources();
            img_off = res.getDrawable(item.getMenuImgRes());
            img_off.setBounds(0, 0, img_off.getMinimumWidth(), img_off.getMinimumHeight());
            ((TextView) helper.getView(R.id.tweetName)).setCompoundDrawables(img_off, null, null, null);

        } catch (Exception e) {

        }
        ((TextView) helper.getView(R.id.tweetName)).setText(item.getMenuName());
    }


}