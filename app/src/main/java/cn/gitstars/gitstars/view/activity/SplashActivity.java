package cn.gitstars.gitstars.view.activity;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import cn.gitstars.gitstars.R;
import cn.gitstars.gitstars.base.BaseActivity;
import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.gitstars.gitstars.presenter.SplashPresenter;
import cn.gitstars.gitstars.utils.ActivitySwitch;

/**
 * Created by JanyXu on 2017/04/25.
 * 启动页
 */
public class SplashActivity extends BaseActivity<SplashPresenter> {

    @InjectView(R.id.tv_slogan)
    TextView tv_slogan;
    private String slogan;
    private char[] charArrays;
    private String len = "";
    boolean currentChar = true;
    protected static final int INTERRUPT_MESSAGE = 1000;
    protected static final int INTERRUPT_UNDERLINE_MESSAGE = 1001;
    protected static final int ACTIVITY_SWITCH_MESSAGE = 1002;
    protected static final int CHAR_CHANGE_TIME = 100;
    protected static final int ACTIVITY_SWITCH_TIME = 500;


    @Override
    protected SplashPresenter loadPresenter() {
        return new SplashPresenter();
    }

    @Override
    protected void initData() {
        new Thread() {
            public void run() {
                try {
                    charArrays = slogan.toCharArray();
                    for (int i = 0; i < charArrays.length * 2; i++) {
                        if (currentChar) {
                            handler.sendEmptyMessage(INTERRUPT_UNDERLINE_MESSAGE);
                        } else {
                            len = charArrays[i / 2] + "";
                            handler.sendEmptyMessage(INTERRUPT_MESSAGE);
                        }
                        currentChar = !currentChar;
                        sleep(CHAR_CHANGE_TIME);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case INTERRUPT_MESSAGE:
                    String strTemp = tv_slogan.getText().toString();
                    tv_slogan.setText(strTemp.substring(0, strTemp.length() - 1));
                    tv_slogan.append(len);
                    if (currentChar && (strTemp.length() + 1) == slogan.length()) {
                        handler.sendEmptyMessageDelayed(ACTIVITY_SWITCH_MESSAGE, ACTIVITY_SWITCH_TIME);
                    }
                    break;
                case INTERRUPT_UNDERLINE_MESSAGE:
                    tv_slogan.setText(tv_slogan.getText().toString() + "_");
                    break;
                case ACTIVITY_SWITCH_MESSAGE:
                    switchToMain(null);
                    break;
                default:
                    break;
            }
        }

    };

    public void switchToMain(View view) {
        ActivitySwitch.splashToMain(SplashActivity.this);
        finish();
    }

    @Override
    protected void initListener() {
    }

    @Override
    protected void initView() {
        ButterKnife.inject(this);
        slogan = getResources().getString(R.string.slogan);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void otherViewClick(View view) {
    }

}
