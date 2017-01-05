package com.cloudwalk.validate.validateapp.data.remote;

import android.util.Log;

import com.cloudwalk.validate.validateapp.App;
import com.cloudwalk.validate.validateapp.dagger.module.AppModule;
import com.cloudwalk.validate.validateapp.dagger.module.DataModule;
import com.cloudwalk.validate.validateapp.data.AppDataStore;
import com.cloudwalk.validate.validateapp.data.local.AppLocalDataStore;
import com.cloudwalk.validate.validateapp.mainscreen.MainActivity;

import java.util.List;
import java.util.Observable;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import rx.functions.Action1;

/**
 * Created by nkmcheng on 03/01/2017.
 */

public class AppRemoteDataStore {
    @Singleton
    @Component(modules = {AppModule.class, DataModule.class})
    public interface AppComponent {
        void inject(MainActivity activity);
        void inject(AppRemoteDataStore appRemoteDataStore);
    }

}
