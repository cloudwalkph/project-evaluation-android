package com.cloudwalk.validate.validateapp.evaluationcompletescreen;

import com.cloudwalk.validate.validateapp.BasePresenter;
import com.cloudwalk.validate.validateapp.BaseView;
import com.cloudwalk.validate.validateapp.data.local.models.Question;
import com.cloudwalk.validate.validateapp.data.local.models.Record;

/**
 * Created by nkmcheng on 03/01/2017.
 */

public class EvaluationCompleteContract {

    interface View extends BaseView<Presenter> {
        void saveRecordComplete();
    }

    interface Presenter extends BasePresenter {
        void saveRecord(Record record);
    }
}
