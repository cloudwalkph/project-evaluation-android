package com.cloudwalk.validate.validateapp.eventproperscreen;

import com.cloudwalk.validate.validateapp.data.AppRepository;

import rx.Subscription;

/**
 * Created by nkmcheng on 03/01/2017.
 */

public class EventProperPresenter implements EventProperContract.Presenter {

    private static final String TAG = EventProperPresenter.class.getSimpleName();
    private Subscription mSubscription;
    private AppRepository mAppRepository;
    private EventProperActivity.View mView;

    public EventProperPresenter(AppRepository mAppRepository, EventProperActivity.View mView) {
        this.mAppRepository = mAppRepository;
        this.mView = mView;
        mView.setPresenter(this);
    }

    public EventProperPresenter(AppRepository repository, EventProperActivity eventProperActivity) {

    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        if (mSubscription != null && mSubscription.isUnsubscribed())
            mSubscription.unsubscribe();
    }

}
