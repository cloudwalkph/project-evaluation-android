package com.cloudwalk.validate.validateapp.data;

import com.cloudwalk.validate.validateapp.data.local.AppLocalDataStore;
import com.cloudwalk.validate.validateapp.data.local.models.Employee;
import com.cloudwalk.validate.validateapp.data.remote.AppRemoteDataStore;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by nkmcheng on 03/01/2017.
 */

public class AppRepository implements AppDataStore {

    private AppLocalDataStore mAppLocalDataStore;
    private AppRemoteDataStore mAppRemoteDataStore;


    @Inject
    public AppRepository(AppLocalDataStore mAppLocalDataStore,
                         AppRemoteDataStore mAppRemoteDataStore) {
        this.mAppLocalDataStore = mAppLocalDataStore;
        this.mAppRemoteDataStore = mAppRemoteDataStore;
    }

    @Override
    public Observable<List<Employee>> getEmployees() {
        return Observable.concat(mAppLocalDataStore.getEmployees(), mAppRemoteDataStore.getEmployees())
                .first(new Func1<List<Employee>, Boolean>() {
                    @Override
                    public Boolean call(List<Employee> employees) {
                        return employees != null;
                    }
                });
    }
}
