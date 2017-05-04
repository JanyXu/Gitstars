package cn.gitstars.gitstars.http;

/**
 * Created by jiangsiyu on 2016/6/3.
 * 请求地址,常数
 */
public class ServerUri {

    public static String GIT_STARS_ROOT;//gitStars服务器地址
    private static final String SERVER_PATH_DEBUG = "http://test01.gitstars.cn";//测试地址
    private static final String SERVER_PATH_RELEASE = "https://gitstars.cn";//线上地址

    static {
        if (DebugSwitch.IS_DEBUG) {
            GIT_STARS_ROOT = SERVER_PATH_DEBUG;
        } else {
            GIT_STARS_ROOT = SERVER_PATH_RELEASE;
        }
    }

    public static final String GIT_HUB_ROOT = "https://github.com/";//gitHUb
    public static final String GIT_HUB_API_ROOT = "https://api.github.com";// gitHub openapi root
    public static final String GIT_HUB_USER_CONTENT = "https://raw.githubusercontent.com/";
    public static final String GIT_STARS_SHARE = GIT_STARS_ROOT + "/share/github/";//分享地址
    public static final String GIT_STARS_ABOUT = GIT_STARS_ROOT + "/about.html";//关于
    public static final String GIT_STARS_FEEDBACK = GIT_STARS_ROOT + "/feedback.html";//关于
    public static final String GIT_REPO_README = GIT_STARS_ROOT + "/fileContent.html?owner=%s&repo=%s";

}
