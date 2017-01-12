package com.cloudwalk.validate.validateapp.eventproperscreen;

import com.cloudwalk.validate.validateapp.BasePresenter;
import com.cloudwalk.validate.validateapp.BaseView;
import com.cloudwalk.validate.validateapp.data.local.models.Question;

import java.util.List;

/**
 * Created by nkmcheng on 03/01/2017.
 */

public class EventProperContract {

    interface View extends BaseView<Presenter> {
        void getQuestions(String category);
        void addQuestion(Question question);
        void getQuestionsCompleted();
    }

    interface Presenter extends BasePresenter {
        void getQuestionById(int questionId, String category);
        void getEmployeeById(int employeeId);
    }
}
