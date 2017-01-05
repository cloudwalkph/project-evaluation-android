package com.cloudwalk.validate.validateapp;

import android.app.Application;
import com.cloudwalk.validate.validateapp.dagger.component.AppComponent;
import com.cloudwalk.validate.validateapp.dagger.component.DaggerAppComponent;
import com.cloudwalk.validate.validateapp.dagger.module.AppModule;
import com.cloudwalk.validate.validateapp.dagger.module.DataModule;

/**
 * Created by nkmcheng on 05/01/2017.
 */
public class App extends Application {

    private static AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .dataModule(new DataModule("http://evaluation.activationsadvertising.com/"))
                .build();
    }


    public static AppComponent getAppComponent() {
        return mAppComponent;
    }

}