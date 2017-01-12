package com.cloudwalk.validate.validateapp.eventproperscreen;

import android.util.Log;

import com.cloudwalk.validate.validateapp.QuestionScreen.QuestionFragment;
import com.cloudwalk.validate.validateapp.data.AppRepository;
import com.cloudwalk.validate.validateapp.data.local.models.Employee;
import com.cloudwalk.validate.validateapp.data.local.models.Event;
import com.cloudwalk.validate.validateapp.data.local.models.Question;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by nkmcheng on 03/01/2017.
 */

public class EventProperPresenter implements EventProperContract.Presenter {

    private static final String TAG = EventProperPresenter.class.getSimpleName();
    private Subscription mSubscription;
    private AppRepository mAppRepository;
    private EventProperContract.View mView;

    public EventProperPresenter(AppRepository mAppRepository, EventProperContract.View mView) {
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
    public void getQuestionById(int questionId, String category) {
        mSubscription = mAppRepository.getQuestionById(questionId, category)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<Question>() {
                    @Override
                    public void onCompleted() {
                        mView.getQuestionsCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Question question) {
                        Log.i("Question", "New Question Added");
                        mView.addQuestion(question);
                    }
                });
    }

    @Override
    public void getEmployeeById(int employeeId) {
        mSubscription = mAppRepository.getEmployeeById(employeeId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<Employee>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Employee employee) {
                        Log.i("Employee", employee.getDepartment());
                        QuestionFragment.mRatee = employee;
                    }
                });
    }


}
