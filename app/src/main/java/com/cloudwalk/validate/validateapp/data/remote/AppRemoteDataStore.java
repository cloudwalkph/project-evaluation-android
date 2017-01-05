package com.cloudwalk.validate.validateapp.data.remote;

import android.util.Log;

import com.cloudwalk.validate.validateapp.App;
import com.cloudwalk.validate.validateapp.data.AppDataStore;
import com.cloudwalk.validate.validateapp.data.local.AppLocalDataStore;
import com.cloudwalk.validate.validateapp.data.local.models.Employee;

import java.util.List;

import javax.inject.Inject;

import dagger.Component;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import rx.Observable;
import rx.functions.Action1;

/**
 * Created by nkmcheng on 03/01/2017.
 */

public class AppRemoteDataStore implements AppDataStore {
    @Inject
    Retrofit retrofit;

    @Inject
    AppLocalDataStore appLocalDataStore;

    public AppRemoteDataStore() {
        App.getAppComponent().inject(this);
    }

    @Override
    public Observable<List<Employee>> getEmployees() {
        Log.d("REMOTE","Loaded from remote");

        return retrofit.create(EmployeeService.class).getEmployeeList().doOnNext(new Action1<List<Employee>>() {
            @Override
            public void call(List<Employee> employees) {
                appLocalDataStore.saveEmployeeToDatabase(employees);
            }
        });
    }

    private interface EmployeeService {
        @GET("/employees")
        Observable<List<Employee>> getEmployeeList();
    }

}
