package com.cloudwalk.validate.validateapp.splashscreen;

import com.cloudwalk.validate.validateapp.BasePresenter;
import com.cloudwalk.validate.validateapp.BaseView;

/**
 * Created by alleoindong on 1/6/17.
 */

public class SplashScreenContract {
    interface View extends BaseView<Presenter> {
        void showEmployeeCompleteSync();
        void showEventCompleteSync();
        void showQuestionCompleteSync();
        void showAssignmentCompleteSync();
        void showTeamLeaderCompleteSync();
        void showNegotiatorCompleteSync();
        void showAnswerCompleteSync();
        void showError(String error);

        void moveToLoginScreen();
    }

    interface Presenter extends BasePresenter {
        void loadEmployeeFromRemoteDataStore();
        void loadEventFromRemoteDataStore();
        void loadQuestionFromRemoteDataStore();
        void loadAssignmentFromRemoteDataStore();
        void loadTeamLeaderFromRemoteDataStore();
        void loadNegotiatorFromRemoteDataStore();
        void loadAnswerFromRemoteDataStore();
        void loadEmployee();
        void loadEvent();
        void loadQuestion();
        void loadAssignment();
        void loadTeamLeader();
        void loadNegotiator();
        void loadAnswer();
    }
}
