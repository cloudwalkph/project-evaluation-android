package com.cloudwalk.validate.validateapp.splashscreen;

import android.util.Log;

import com.cloudwalk.validate.validateapp.data.AppRepository;
import com.cloudwalk.validate.validateapp.data.local.models.Employee;
import com.cloudwalk.validate.validateapp.data.remote.AppRemoteDataStore;

import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by alleoindong on 1/6/17.
 */

public class SplashScreenPresenter implements SplashScreenContract.Presenter {
    private static final String TAG = SplashScreenPresenter.class.getSimpleName();
    private Subscription mSubscription;
    private AppRepository mAppRepository;
    private SplashScreenContract.View mView;

    public SplashScreenPresenter(AppRepository mAppRepository, SplashScreenContract.View mView) {
        this.mAppRepository = mAppRepository;
        this.mView = mView;
        mView.setPresenter(this);
    }

    @Override
    public void loadEmployeeFromRemoteDataStore() {
        new AppRemoteDataStore().getEmployees().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<List<Employee>>() {
                    @Override
                    public void onCompleted() {
                        Log.d("SPLASH", "Get Employees Complete");

                        loadEmployee();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("SPLASH", e.toString());
                    }

                    @Override
                    public void onNext(List<Employee> employees) {

                    }
                });
    }

    @Override
    public void loadEmployee() {
        mSubscription = mAppRepository.getEmployees()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<List<Employee>>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "Complete");
                        mView.showEmployeeCompleteSync();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, e.toString());
                        mView.showError(e.toString());
                    }

                    @Override
                    public void onNext(List posts) {

                    }
                });
    }

    @Override
    public void subscribe() {
        loadEmployee();
    }

    @Override
    public void unsubscribe() {
        if (mSubscription != null && mSubscription.isUnsubscribed())
            mSubscription.unsubscribe();
    }
}
