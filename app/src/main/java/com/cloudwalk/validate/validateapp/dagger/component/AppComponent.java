package com.cloudwalk.validate.validateapp.dagger.component;

import com.cloudwalk.validate.validateapp.dagger.module.AppModule;
import com.cloudwalk.validate.validateapp.dagger.module.DataModule;
import com.cloudwalk.validate.validateapp.data.remote.AppRemoteDataStore;
import com.cloudwalk.validate.validateapp.loginscreen.LoginActivity;
import com.cloudwalk.validate.validateapp.mainscreen.MainActivity;
import com.cloudwalk.validate.validateapp.splashscreen.SplashActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by nkmcheng on 03/01/2017.
 */

@Singleton
@Component(modules = {AppModule.class, DataModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
    void inject(SplashActivity activity);
    void inject(LoginActivity activity);
    void inject(AppRemoteDataStore appRemoteDataStore);
}
