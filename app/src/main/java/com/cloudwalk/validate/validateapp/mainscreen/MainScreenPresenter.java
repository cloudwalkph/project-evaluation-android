package com.cloudwalk.validate.validateapp.mainscreen;

import android.util.Log;

import com.cloudwalk.validate.validateapp.data.AppRepository;
import com.cloudwalk.validate.validateapp.data.local.models.Answer;
import com.cloudwalk.validate.validateapp.data.local.models.Assignment;
import com.cloudwalk.validate.validateapp.data.local.models.Employee;
import com.cloudwalk.validate.validateapp.data.local.models.Event;
import com.cloudwalk.validate.validateapp.data.local.models.Question;
import com.cloudwalk.validate.validateapp.data.remote.AppRemoteDataStore;
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
    public void loadEventFromRemoteDataStore() {
        mView.setProgressMessage("Syncing events");

        new AppRemoteDataStore().getEvents().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<List<Event>>() {
                    @Override
                    public void onCompleted() {
                        loadEvent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("SPLASH", e.toString());
                    }

                    @Override
                    public void onNext(List<Event> events) {

                    }
                });
    }

    @Override
    public void loadEvent() {
        mSubscription = mAppRepository.getEvents()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<List<Event>>() {
                    @Override
                    public void onCompleted() {
                        loadAssignmentFromRemoteDataStore();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("SPLASH", e.toString());
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(List posts) {

                    }
                });
    }

    @Override
    public void loadQuestionFromRemoteDataStore() {
        mView.setProgressMessage("Syncing questions");

        new AppRemoteDataStore().getQuestions().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<List<Question>>() {
                    @Override
                    public void onCompleted() {
                        loadQuestion();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("SPLASH", e.toString());
                    }

                    @Override
                    public void onNext(List<Question> questions) {

                    }
                });
    }

    @Override
    public void loadQuestion() {
        mSubscription = mAppRepository.getQuestions()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<List<Question>>() {
                    @Override
                    public void onCompleted() {
                        loadAnswerFromRemoteDataStore();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("QUESTIONS PUT", e.toString());
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(List posts) {

                    }
                });
    }

    @Override
    public void loadAssignmentFromRemoteDataStore() {
        mView.setProgressMessage("Syncing assignments");

        new AppRemoteDataStore().getAssignments().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<List<Assignment>>() {
                    @Override
                    public void onCompleted() {
                        loadAssignment();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("SPLASH", e.toString());
                    }

                    @Override
                    public void onNext(List<Assignment> assignments) {

                    }
                });
    }

    @Override
    public void loadAssignment() {
        mSubscription = mAppRepository.getAssignments()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<List<Assignment>>() {
                    @Override
                    public void onCompleted() {
                        loadQuestionFromRemoteDataStore();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("ASSIGNMENT PUT", e.toString());
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(List posts) {

                    }
                });
    }

    @Override
    public void loadAnswerFromRemoteDataStore() {
        mView.setProgressMessage("Syncing answers");

        new AppRemoteDataStore().getAnswers().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<List<Answer>>() {
                    @Override
                    public void onCompleted() {
                        Log.d("SPLASH", "Get Answer Complete");

                        loadAnswer();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("SPLASH", e.toString());
                    }

                    @Override
                    public void onNext(List<Answer> answers) {

                    }
                });
    }

    @Override
    public void loadAnswer() {
        mSubscription = mAppRepository.getAnswers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<List<Answer>>() {
                    @Override
                    public void onCompleted() {
                        mView.syncFinish();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(List posts) {

                    }
                });
    }

    @Override
    public void getAssginedEvents() {

    }
}
