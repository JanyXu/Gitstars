package cn.gitstars.gitstars.bean;

/**
 * Created by JanyXu on 2017/4/27.
 *
 */

public class MenuItem {
    private String menuName;
    private int menuImgRes;

    public String getMenuName() {
        return menuName;
    }
    public MenuItem(String menuName,int menuImgRes) {
        this.menuName = menuName;
        this.menuImgRes = menuImgRes;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuImgRes() {
        return menuImgRes;
    }

    public void setMenuImgRes(int menuImgRes) {
        this.menuImgRes = menuImgRes;
    }
}
