package com.php.demo.mvp;

import com.php.demo.common.MyActivity;

/**
 *    author : xxx
 *    xxx
 *    time   : 2018/11/17
 *    desc   : MVP Activity 基类
 */
public abstract class MvpActivity<P extends MvpPresenter> extends MyActivity implements IMvpView {

    private P mPresenter;

    @Override
    public void initActivity() {
        mPresenter = createPresenter();
        mPresenter.attach(this);
        super.initActivity();
        mPresenter.start();
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detach();
            mPresenter = null;
        }
        super.onDestroy();
    }

    public P getPresenter() {
        return mPresenter;
    }

    protected abstract P createPresenter();

    @Override
    public void onLoading() {
        showLoading();
    }

    @Override
    public void onComplete() {
        showComplete();
    }

    @Override
    public void onEmpty() {
        showEmpty();
    }

    @Override
    public void onError() {
        showError();
    }
}