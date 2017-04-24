package cn.gitstars.gitstars.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.EditText;
import android.widget.TextView;

import cn.gitstars.gitstars.MainActivity;
import cn.gitstars.gitstars.R;
import cn.gitstars.gitstars.base.BaseActivity;
import cn.gitstars.gitstars.contract.LoginContract;
import cn.gitstars.gitstars.presenter.LoginPresenter;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.gitstars.gitstars.view.XTextView;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.LoginView {

    AppCompatButton btnLogin;
    @InjectView(R.id.link_signup)
    TextView link_signup;
    private String TextDemo = "我是一段测试文字\n我是一段测试文字我是一段测试文\n字我是一段测试文字我是一段测试文字我是一段测试文字我是一段测试文字";
    private char[] charArrays;
    private String len = "";
    protected static final int UI = 1000;
    @Override
    protected LoginPresenter loadPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void initData() {
        new Thread(){
            public void run() {
                try {
                    charArrays = TextDemo.toCharArray();
                    for (int i = 0; i < charArrays.length; i++) {
                        sleep(1000);
                        len = charArrays[i]+"";
                        handler.sendEmptyMessage(UI);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case UI:
                    link_signup.append(len);
                    break;

                default:
                    break;
            }
        }

    };
    @Override
    protected void initListener() {
       // btnLogin.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        ButterKnife.inject(this);

    }

    private void testOne() {
//        link_signup.setOnDrawFinishListener(new XTextView.OnDrawFinishListener() {
//            @Override
//            public void OnDrawFinish() {
//                Log.i("response", "test=================");
//                startActivity(new Intent(LoginActivity.this, MainActivity.class));
//            }
//        });
//        link_signup.setTextContent(TextDemo);
//        link_signup.setDelayPlayTime(200);
//        link_signup.setTextAlignment("normal");
        link_signup.setText(TextDemo);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void otherViewClick(View view) {
        mPresenter.login(getUserName(), getPwd());
    }

    @Override
    public String getUserName() {
        return "";
    }

    @Override
    public String getPwd() {
        return "";
    }

    @Override
    public void loginSuccess(String str) {
        toast(str);
    }

    @Override
    public void loginFail(String failMsg) {
        toast(failMsg);
    }


    public boolean checkNull() {
        boolean isNull = false;
//        if (TextUtils.isEmpty(getUserName())) {
//            inputEmail.setError("账号不能为空");
//            isNull = true;
//        } else if (TextUtils.isEmpty(getPwd())) {
//            inputPassword.setError("密码不能为空");
//            isNull = true;
//        }
        return isNull;
    }

}
