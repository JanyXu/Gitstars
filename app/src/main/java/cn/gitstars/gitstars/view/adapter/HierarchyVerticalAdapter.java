package cn.gitstars.gitstars.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import cn.gitstars.gitstars.R;
import cn.gitstars.gitstars.bean.MenuItem;
import cn.gitstars.gitstars.utils.MenuUtils;
import cn.gitstars.gitstars.utils.Utils;

/**
 * Created by jiangsiyu on 2016/6/30.
 */
public class HierarchyVerticalAdapter extends BaseQuickAdapter<MenuItem, BaseViewHolder> {
    public HierarchyVerticalAdapter() {
        super(R.layout.adapterview_hierarchy_horizontal, MenuUtils.getMenuData());
    }

    @Override
    protected void convert(BaseViewHolder helper, MenuItem item) {

    }


}