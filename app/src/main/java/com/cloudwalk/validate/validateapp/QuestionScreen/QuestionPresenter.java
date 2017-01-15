package com.cloudwalk.validate.validateapp.QuestionScreen;

import android.util.Log;

import com.cloudwalk.validate.validateapp.data.AppRepository;
import com.cloudwalk.validate.validateapp.data.local.models.Answer;
import com.cloudwalk.validate.validateapp.data.local.models.Assignment;
import com.cloudwalk.validate.validateapp.loginscreen.LoginScreenPresenter;

import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by nkmcheng on 15/01/2017.
 */

public class QuestionPresenter implements QuestionContract.Presenter {

    private static final String TAG = QuestionPresenter.class.getSimpleName();
    private Subscription mSubscription;
    private AppRepository mAppRepository;
    private QuestionContract.View mView;

    public QuestionPresenter(AppRepository mAppRepository, QuestionContract.View mView) {
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

    @Override
    public void getAnswerByQuestionId(int questionId) {
        mSubscription = mAppRepository.getAnswerByQuestionId(questionId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<List<Answer>>() {
                    @Override
                    public void onCompleted() {
                        Log.d("QUESTIONS", "Successfully get the answers of question");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("QUESTIONS", e.toString());
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(List<Answer> answers) {
                        mView.getAnswer(answers);
                    }
                });
    }
}
