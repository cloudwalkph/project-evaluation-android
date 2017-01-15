package com.cloudwalk.validate.validateapp.mainscreen;

import com.cloudwalk.validate.validateapp.BasePresenter;
import com.cloudwalk.validate.validateapp.BaseView;
import com.cloudwalk.validate.validateapp.data.local.models.Assignment;
import com.cloudwalk.validate.validateapp.data.local.models.Event;

import java.util.List;

/**
 * Created by nkmcheng on 03/01/2017.
 */

public class MainScreenContract {

    interface View extends BaseView<Presenter> {
        void getAssignments(List<Assignment> assignments);
        void getEvents(Event event);
        void setProgressMessage(String message);
        void syncFinish();
    }

    interface Presenter extends BasePresenter {
        void getAssignments();
        void getEventById(int eventId);
        void loadEmployeeFromRemoteDataStore();
        void loadEventFromRemoteDataStore();
        void loadQuestionFromRemoteDataStore();
        void loadAssignmentFromRemoteDataStore();
        void loadAnswerFromRemoteDataStore();

        void getAssginedEvents();

    }
}
