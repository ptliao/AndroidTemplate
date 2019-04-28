package com.php.demo.ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.php.demo.R;
import com.php.demo.common.MyActivity;
import com.php.demo.helper.InputTextHelper;
import com.php.widget.CountdownView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *    author : xxx
 *    xxx
 *    time   : 2019/02/27
 *    desc   : 忘记密码
 */
public class PasswordForgetActivity extends MyActivity {

    @BindView(R.id.et_password_forget_phone)
    EditText mPhoneView;
    @BindView(R.id.et_password_forget_code)
    EditText mCodeView;
    @BindView(R.id.cv_password_forget_countdown)
    CountdownView mCountdownView;
    @BindView(R.id.btn_password_forget_commit)
    Button mCommitView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_password_forget;
    }

    @Override
    protected int getTitleId() {
        return R.id.tb_password_forget_title;
    }

    @Override
    protected void initView() {
        new InputTextHelper.Builder(this)
                .setMain(mCommitView)
                .addView(mPhoneView)
                .addView(mCodeView)
                .build();
    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.cv_password_forget_countdown, R.id.btn_password_forget_commit})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cv_password_forget_countdown:
                if (mPhoneView.getText().toString().length() != 11) {
                    // 重置验证码倒计时控件
                    mCountdownView.resetState();
                    toast(getString(R.string.phone_input_error));
                } else {
                    // 获取验证码
                    toast(getString(R.string.countdown_code_send_succeed));
                }
                break;
            case R.id.btn_password_forget_commit:
                if (mPhoneView.getText().toString().length() != 11) {
                    toast(getString(R.string.phone_input_error));
                } else {
                    // 重置密码
                    startActivityFinish(PasswordResetActivity.class);
                }
                break;
            default:
                break;
        }
    }
}