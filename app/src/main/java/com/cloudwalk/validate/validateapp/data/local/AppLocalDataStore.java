package com.cloudwalk.validate.validateapp.data.local;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.cloudwalk.validate.validateapp.data.AppDataStore;
import com.cloudwalk.validate.validateapp.data.local.models.Employee;
import com.cloudwalk.validate.validateapp.data.local.models.EmployeeStorIOContentResolverDeleteResolver;
import com.cloudwalk.validate.validateapp.data.local.models.EmployeeStorIOContentResolverGetResolver;
import com.cloudwalk.validate.validateapp.data.local.models.EmployeeStorIOContentResolverPutResolver;
import com.pushtorefresh.storio.contentresolver.ContentResolverTypeMapping;
import com.pushtorefresh.storio.contentresolver.StorIOContentResolver;
import com.pushtorefresh.storio.contentresolver.impl.DefaultStorIOContentResolver;
import com.pushtorefresh.storio.contentresolver.queries.Query;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by nkmcheng on 03/01/2017.
 */

public class AppLocalDataStore implements AppDataStore {

    private StorIOContentResolver mStorIOContentResolver;

    public AppLocalDataStore(@NonNull Context context) {
        this.mStorIOContentResolver = DefaultStorIOContentResolver.builder()
            .contentResolver(context.getContentResolver())
            .addTypeMapping(Employee.class, ContentResolverTypeMapping.<Employee>builder()
                .putResolver(new EmployeeStorIOContentResolverPutResolver())
                .getResolver(new EmployeeStorIOContentResolverGetResolver())
                .deleteResolver(new EmployeeStorIOContentResolverDeleteResolver())
                .build()
            ).build();
    }

    @Override
    public Observable<List<Employee>> getEmployees() {
        Log.d("LOCAL","Loaded from local");

        return mStorIOContentResolver.get()
                .listOfObjects(Employee.class)
                .withQuery(Query.builder().uri(DatabaseContract.Employee.CONTENT_URI).build())
                .prepare()
                .asRxObservable();
    }

    public void saveEmployeeToDatabase(List<Employee> employees) {
        mStorIOContentResolver.put().objects(employees).prepare().executeAsBlocking();
    }
}
