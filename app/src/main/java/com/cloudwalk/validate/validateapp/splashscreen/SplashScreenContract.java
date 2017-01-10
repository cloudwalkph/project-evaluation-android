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
        void showError(String error);
    }

    interface Presenter extends BasePresenter {
        void loadEmployeeFromRemoteDataStore();
        void loadEventFromRemoteDataStore();
        void loadEmployee();
        void loadEvent();
    }
}
