package com.cloudwalk.validate.validateapp.mainscreen;

import com.cloudwalk.validate.validateapp.BasePresenter;
import com.cloudwalk.validate.validateapp.BaseView;

import java.util.List;

/**
 * Created by nkmcheng on 03/01/2017.
 */

public class MainScreenContract {

    interface View extends BaseView {

        void showPosts(List posts);

        void showError(String message);

        void showComplete();
    }

    interface Presenter extends BasePresenter {
        void loadPost();

        void loadPostFromRemoteDatatore();
    }
}
