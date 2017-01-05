package com.cloudwalk.validate.validateapp.data;

import com.cloudwalk.validate.validateapp.data.local.AppLocalDataStore;
import com.cloudwalk.validate.validateapp.data.remote.AppRemoteDataStore;

import java.util.List;
import java.util.Observable;

import javax.inject.Inject;

/**
 * Created by nkmcheng on 03/01/2017.
 */

public class AppRepository {

    private AppLocalDataStore mAppLocalDataStore;
    private AppRemoteDataStore mAppRemoteDataStore;


    @Inject
    public AppRepository(AppLocalDataStore mAppLocalDataStore, AppRemoteDataStore mAppRemoteDataStore) {
        this.mAppLocalDataStore = mAppLocalDataStore;
        this.mAppRemoteDataStore = mAppRemoteDataStore;
    }

}
