package com.cloudwalk.validate.validateapp.loginscreen;

import com.cloudwalk.validate.validateapp.BasePresenter;
import com.cloudwalk.validate.validateapp.BaseView;

/**
 * Created by alleoindong on 1/5/17.
 */

public class LoginScreenContract {
    interface View extends BaseView<Presenter> {
        void loginComplete();
        void loginFailed();
    }

    interface Presenter extends BasePresenter {
        void attemptLogin(String email, String password);
    }
}
