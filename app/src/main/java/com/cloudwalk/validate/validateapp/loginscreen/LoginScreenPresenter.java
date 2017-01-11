package com.cloudwalk.validate.validateapp.loginscreen;

import android.util.Log;

import com.cloudwalk.validate.validateapp.data.AppRepository;
import com.cloudwalk.validate.validateapp.data.local.models.Employee;
import com.cloudwalk.validate.validateapp.data.local.models.Event;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by alleoindong on 1/5/17.
 */

public class LoginScreenPresenter implements LoginScreenContract.Presenter {
    private static final String TAG = LoginScreenPresenter.class.getSimpleName();
    public static Employee mCurrentEmployee;
    private Subscription mSubscription;
    private AppRepository mAppRepository;
    private LoginScreenContract.View mView;

    public LoginScreenPresenter(LoginScreenContract.View mView) {
        this.mAppRepository = mAppRepository;
        this.mView = mView;
        this.mView.setPresenter(this);
    }

    @Override
    public void attemptLogin(String email, String password) {
        mSubscription = mAppRepository.attemptLogin(email, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<Employee>() {
                    @Override
                    public void onCompleted() {
                        Log.d("LOGIN", "Successfully logged in");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("LOGIN", e.toString());
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Employee employee) {
                        mCurrentEmployee = employee;
                    }
                });
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
