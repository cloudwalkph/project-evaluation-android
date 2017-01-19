package com.cloudwalk.validate.validateapp.evaluationcompletescreen;

import android.util.Log;

import com.cloudwalk.validate.validateapp.QuestionScreen.QuestionFragment;
import com.cloudwalk.validate.validateapp.data.AppRepository;
import com.cloudwalk.validate.validateapp.data.local.models.Employee;
import com.cloudwalk.validate.validateapp.data.local.models.Question;
import com.cloudwalk.validate.validateapp.eventproperscreen.EventProperContract;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by nkmcheng on 03/01/2017.
 */

public class EvaluationCompletePresenter implements EvaluationCompleteContract.Presenter {

    private static final String TAG = EvaluationCompletePresenter.class.getSimpleName();
    private Subscription mSubscription;
    private AppRepository mAppRepository;
    private EvaluationCompleteContract.View mView;

    public EvaluationCompletePresenter(AppRepository mAppRepository, EvaluationCompleteContract.View mView) {
        this.mAppRepository = mAppRepository;
        this.mView = mView;
        mView.setPresenter(this);
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
