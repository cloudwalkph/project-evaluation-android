package com.cloudwalk.validate.validateapp.mainscreen;

import rx.Subscription;

/**
 * Created by nkmcheng on 03/01/2017.
 */

public class MainScreenPresenter implements MainScreenContract.Presenter {

    private static final String TAG = MainScreenPresenter.class.getSimpleName();
    private Subscription mSubscription;
    private MainScreenContract.View mView;

    public MainScreenPresenter(MainScreenContract.View mView) {
        this.mView = mView;
        this.mView.setPresenter(this);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
