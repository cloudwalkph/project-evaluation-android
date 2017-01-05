package com.cloudwalk.validate.validateapp.loginscreen;

import rx.Subscription;

/**
 * Created by alleoindong on 1/5/17.
 */

public class LoginScreenPresenter implements LoginScreenContract.Presenter {
    private static final String TAG = LoginScreenPresenter.class.getSimpleName();
    private Subscription mSubscription;
    private LoginScreenContract.View mView;

    public LoginScreenPresenter(LoginScreenContract.View mView) {
        this.mView = mView;
        this.mView.setPresenter(this);
    }

    @Override
    public void attemptLogin() {

    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
