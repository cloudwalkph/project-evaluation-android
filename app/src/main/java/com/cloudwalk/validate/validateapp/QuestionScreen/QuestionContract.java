package com.cloudwalk.validate.validateapp.QuestionScreen;

import com.cloudwalk.validate.validateapp.BasePresenter;
import com.cloudwalk.validate.validateapp.BaseView;
import com.cloudwalk.validate.validateapp.data.local.models.Answer;

import java.util.List;

/**
 * Created by nkmcheng on 15/01/2017.
 */

public class QuestionContract {
    interface View extends BaseView<Presenter> {
        void getAnswer(List<Answer> answers);
    }

    interface Presenter extends BasePresenter {
        void getAnswerByQuestionId(int questionId);
    }
}
