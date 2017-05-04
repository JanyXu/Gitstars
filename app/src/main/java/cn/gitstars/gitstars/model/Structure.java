package cn.gitstars.gitstars.model;


/**
 * Created by jiangsiyu on 2016/7/4.
 */
public class Structure implements BaseRecyclerItem {

    String name;
    int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getDataType() {
        return 0;
    }
}
