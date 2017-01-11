package com.cloudwalk.validate.validateapp.mainscreen;

import android.util.Log;

import com.cloudwalk.validate.validateapp.data.AppRepository;
import com.cloudwalk.validate.validateapp.data.local.models.Assignment;
import com.cloudwalk.validate.validateapp.data.local.models.Employee;
import com.cloudwalk.validate.validateapp.data.local.models.Event;
import com.cloudwalk.validate.validateapp.loginscreen.LoginScreenPresenter;

import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by nkmcheng on 03/01/2017.
 */

public class MainScreenPresenter implements MainScreenContract.Presenter {

    private static final String TAG = MainScreenPresenter.class.getSimpleName();
    public static Employee mCurrentEmployee;
    private Subscription mSubscription;
    private AppRepository mAppRepository;
    private MainScreenContract.View mView;

    public MainScreenPresenter(AppRepository mAppRepository, MainScreenContract.View mView) {
        this.mAppRepository = mAppRepository;
        this.mView = mView;
        mView.setPresenter(this);
    }

    @Override
    public void subscribe() {
        getAssignments();
    }

    @Override
    public void unsubscribe() {
        if (mSubscription != null && mSubscription.isUnsubscribed())
            mSubscription.unsubscribe();
    }

    @Override
    public void getAssignments() {
        mSubscription = mAppRepository.getUserAssignments((int) LoginScreenPresenter.mCurrentEmployee.getId())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<List<Assignment>>() {
                    @Override
                    public void onCompleted() {
                        Log.d("MAINSCREEN", "Successfully get the assignments of user");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("MAINSCREEN", e.toString());
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(List<Assignment> assignments) {
                        mView.getAssignments(assignments);
                    }
                });
    }

    @Override
    public void getEventById(int eventId) {
        mSubscription = mAppRepository.getUserEvents(eventId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<Event>() {
                    @Override
                    public void onCompleted() {
                        Log.d("MAINSCREEN", "Successfully get the events of user");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("MAINSCREEN EVENT", e.toString());
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Event event) {
                        mView.getEvents(event);
                    }
                });
    }

    @Override
    public void getAssginedEvents() {

    }
}
