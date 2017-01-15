package com.cloudwalk.validate.validateapp.splashscreen;

import android.util.Log;

import com.cloudwalk.validate.validateapp.data.AppRepository;
import com.cloudwalk.validate.validateapp.data.local.models.Answer;
import com.cloudwalk.validate.validateapp.data.local.models.Assignment;
import com.cloudwalk.validate.validateapp.data.local.models.Employee;
import com.cloudwalk.validate.validateapp.data.local.models.Event;
import com.cloudwalk.validate.validateapp.data.local.models.Negotiator;
import com.cloudwalk.validate.validateapp.data.local.models.Question;
import com.cloudwalk.validate.validateapp.data.local.models.TeamLeader;
import com.cloudwalk.validate.validateapp.data.remote.AppRemoteDataStore;

import java.util.List;

import rx.Observable;
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
//                        loadEmployee();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("SPLASH REMOTE", e.toString());
                    }

                    @Override
                    public void onNext(List<Employee> employees) {

                    }
                });
    }

//    @Override
//    public void loadEmployee() {
//        mSubscription = mAppRepository.getEmployees()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.newThread())
//                .subscribe(new Observer<List<Employee>>() {
//                    @Override
//                    public void onCompleted() {
//                        Log.d("SPLASH", "Employees Complete");
//                        mView.showEmployeeCompleteSync();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d("SPLASH LOCAL", e.toString());
//                        e.printStackTrace();
//                        mView.showError(e.toString());
//                    }
//
//                    @Override
//                    public void onNext(List posts) {
//
//                    }
//                });
//    }

    @Override
    public void loadEventFromRemoteDataStore() {
        new AppRemoteDataStore().getEvents().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<List<Event>>() {
                    @Override
                    public void onCompleted() {
                        Log.d("SPLASH", "Get Events Complete");

//                        loadEvent();
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

//    @Override
//    public void loadEvent() {
//        mSubscription = mAppRepository.getEvents()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.newThread())
//                .subscribe(new Observer<List<Event>>() {
//                    @Override
//                    public void onCompleted() {
//                        Log.d("SPLASH", "Events Complete");
//                        mView.showEventCompleteSync();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d("SPLASH", e.toString());
//                        e.printStackTrace();
//                        mView.showError(e.toString());
//                    }
//
//                    @Override
//                    public void onNext(List posts) {
//
//                    }
//                });
//    }

    @Override
    public void loadQuestionFromRemoteDataStore() {
        new AppRemoteDataStore().getQuestions().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<List<Question>>() {
                    @Override
                    public void onCompleted() {
                        Log.d("SPLASH", "Get Questions Complete");

//                        loadQuestion();
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

//    @Override
//    public void loadQuestion() {
//        mSubscription = mAppRepository.getQuestions()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.newThread())
//                .subscribe(new Observer<List<Question>>() {
//                    @Override
//                    public void onCompleted() {
//                        Log.d("QUESTIONS PUT", "Question Complete");
//                        mView.showQuestionCompleteSync();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d("QUESTIONS PUT", e.toString());
//                        e.printStackTrace();
//                        mView.showError(e.toString());
//                    }
//
//                    @Override
//                    public void onNext(List posts) {
//
//                    }
//                });
//    }

    @Override
    public void loadAssignmentFromRemoteDataStore() {
        new AppRemoteDataStore().getAssignments().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<List<Assignment>>() {
                    @Override
                    public void onCompleted() {
                        Log.d("SPLASH", "Get Assignment Complete");

//                        loadAssignment();
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

//    @Override
//    public void loadAssignment() {
//        mSubscription = mAppRepository.getAssignments()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.newThread())
//                .subscribe(new Observer<List<Assignment>>() {
//                    @Override
//                    public void onCompleted() {
//                        Log.d("ASSIGNMENT PUT", "Assignment Complete");
//                        mView.showAssignmentCompleteSync();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d("ASSIGNMENT PUT", e.toString());
//                        e.printStackTrace();
//                        mView.showError(e.toString());
//                    }
//
//                    @Override
//                    public void onNext(List posts) {
//
//                    }
//                });
//    }

//    @Override
//    public void loadTeamLeaderFromRemoteDataStore() {
//        new AppRemoteDataStore().getTeamLeaders().observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.newThread())
//                .subscribe(new Observer<List<TeamLeader>>() {
//                    @Override
//                    public void onCompleted() {
//                        Log.d("SPLASH", "Get Team leader Complete");
//
//                        loadTeamLeader();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d("SPLASH", e.toString());
//                    }
//
//                    @Override
//                    public void onNext(List<TeamLeader> teamLeaders) {
//
//                    }
//                });
//    }

//    @Override
//    public void loadTeamLeader() {
//        mSubscription = mAppRepository.getTeamLeaders()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.newThread())
//                .subscribe(new Observer<List<TeamLeader>>() {
//                    @Override
//                    public void onCompleted() {
//                        Log.d("TEAM LEADER PUT", "Team leader Complete");
//                        mView.showTeamLeaderCompleteSync();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d("TEAM LEADER PUT", e.toString());
//                        e.printStackTrace();
//                        mView.showError(e.toString());
//                    }
//
//                    @Override
//                    public void onNext(List posts) {
//
//                    }
//                });
//    }

//    @Override
//    public void loadNegotiatorFromRemoteDataStore() {
//        new AppRemoteDataStore().getNegotiators().observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.newThread())
//                .subscribe(new Observer<List<Negotiator>>() {
//                    @Override
//                    public void onCompleted() {
//                        Log.d("SPLASH", "Get Negotiator Complete");
//
//                        loadNegotiator();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d("SPLASH", e.toString());
//                    }
//
//                    @Override
//                    public void onNext(List<Negotiator> negotiators) {
//
//                    }
//                });
//    }
//
//    @Override
//    public void loadNegotiator() {
//        mSubscription = mAppRepository.getNegotiators()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.newThread())
//                .subscribe(new Observer<List<Negotiator>>() {
//                    @Override
//                    public void onCompleted() {
//                        Log.d("NEGOTIATOR PUT", "Negotiator Complete");
//                        mView.showNegotiatorCompleteSync();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d("NEGOTIATOR PUT", e.toString());
//                        e.printStackTrace();
//                        mView.showError(e.toString());
//                    }
//
//                    @Override
//                    public void onNext(List posts) {
//
//                    }
//                });
//    }

    @Override
    public void loadAnswerFromRemoteDataStore() {
        new AppRemoteDataStore().getAnswers().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<List<Answer>>() {
                    @Override
                    public void onCompleted() {
                        Log.d("SPLASH", "Get Answer Complete");

//                        loadAnswer();
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

//    @Override
//    public void loadAnswer() {
//        mSubscription = mAppRepository.getAnswers()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.newThread())
//                .subscribe(new Observer<List<Answer>>() {
//                    @Override
//                    public void onCompleted() {
//                        Log.d("ANSWER PUT", "Answer Complete");
//                        mView.showAnswerCompleteSync();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d("ANSWER PUT", e.toString());
//                        e.printStackTrace();
//                        mView.showError(e.toString());
//                    }
//
//                    @Override
//                    public void onNext(List posts) {
//
//                    }
//                });
//    }

    @Override
    public void subscribe() {
//        loadEmployee();
//        loadEvent();
//        loadQuestion();
//        loadAnswer();
//        loadAssignment();
//        loadTeamLeader();
//        loadNegotiator();
    }

    @Override
    public void unsubscribe() {
        if (mSubscription != null && mSubscription.isUnsubscribed())
            mSubscription.unsubscribe();
    }
}
