package com.cloudwalk.validate.validateapp.data.local;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.cloudwalk.validate.validateapp.data.AppDataStore;
import com.cloudwalk.validate.validateapp.data.local.models.Employee;
import com.cloudwalk.validate.validateapp.data.local.models.EmployeeStorIOContentResolverDeleteResolver;
import com.cloudwalk.validate.validateapp.data.local.models.EmployeeStorIOContentResolverGetResolver;
import com.cloudwalk.validate.validateapp.data.local.models.EmployeeStorIOContentResolverPutResolver;
import com.cloudwalk.validate.validateapp.data.local.models.Event;
import com.cloudwalk.validate.validateapp.data.local.models.EventStorIOContentResolverDeleteResolver;
import com.cloudwalk.validate.validateapp.data.local.models.EventStorIOContentResolverGetResolver;
import com.cloudwalk.validate.validateapp.data.local.models.EventStorIOContentResolverPutResolver;
import com.cloudwalk.validate.validateapp.data.local.models.Question;
import com.cloudwalk.validate.validateapp.data.local.models.QuestionStorIOContentResolverDeleteResolver;
import com.cloudwalk.validate.validateapp.data.local.models.QuestionStorIOContentResolverGetResolver;
import com.cloudwalk.validate.validateapp.data.local.models.QuestionStorIOContentResolverPutResolver;
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
    private StorIOContentResolver mEventStorIOContentResolver;
    private StorIOContentResolver mQuestionStorIOContentResolver;

    public AppLocalDataStore(@NonNull Context context) {
        this.mStorIOContentResolver = DefaultStorIOContentResolver.builder()
            .contentResolver(context.getContentResolver())
            .addTypeMapping(Employee.class, ContentResolverTypeMapping.<Employee>builder()
                .putResolver(new EmployeeStorIOContentResolverPutResolver())
                .getResolver(new EmployeeStorIOContentResolverGetResolver())
                .deleteResolver(new EmployeeStorIOContentResolverDeleteResolver())
                .build()
            ).build();

        this.mEventStorIOContentResolver = DefaultStorIOContentResolver.builder()
                .contentResolver(context.getContentResolver())
                .addTypeMapping(Event.class, ContentResolverTypeMapping.<Event>builder()
                        .putResolver(new EventStorIOContentResolverPutResolver())
                        .getResolver(new EventStorIOContentResolverGetResolver())
                        .deleteResolver(new EventStorIOContentResolverDeleteResolver())
                        .build()
                ).build();

        this.mQuestionStorIOContentResolver = DefaultStorIOContentResolver.builder()
                .contentResolver(context.getContentResolver())
                .addTypeMapping(Question.class, ContentResolverTypeMapping.<Question>builder()
                        .putResolver(new QuestionStorIOContentResolverPutResolver())
                        .getResolver(new QuestionStorIOContentResolverGetResolver())
                        .deleteResolver(new QuestionStorIOContentResolverDeleteResolver())
                        .build()
                ).build();
    }

    @Override
    public Observable<List<Employee>> getEmployees() {
        Log.d("LOCAL EMPLOYEES","Loaded from local");

        return mStorIOContentResolver.get()
                .listOfObjects(Employee.class)
                .withQuery(Query.builder().uri(EmployeeDatabaseContract.Employee.CONTENT_URI).build())
                .prepare()
                .asRxObservable();
    }

    public void saveEmployeeToDatabase(List<Employee> employees) {
        mStorIOContentResolver.put().objects(employees).prepare().executeAsBlocking();
    }

    @Override
    public Observable<List<Event>> getEvents() {
        Log.d("LOCAL EVENTS","Loaded from local");

        return mEventStorIOContentResolver.get()
                .listOfObjects(Event.class)
                .withQuery(Query.builder().uri(EventDatabaseContract.Event.CONTENT_URI).build())
                .prepare()
                .asRxObservable();
    }

    public void saveEventToDatabase(List<Event> events) {
        mEventStorIOContentResolver.put().objects(events).prepare().executeAsBlocking();
    }

    @Override
    public Observable<List<Question>> getQuestions() {
        Log.d("LOCAL QUESTIONS","Loaded from local");

        return mQuestionStorIOContentResolver.get()
                .listOfObjects(Question.class)
                .withQuery(Query.builder().uri(QuestionDatabaseContract.Question.CONTENT_URI).build())
                .prepare()
                .asRxObservable();
    }

    public void saveQuestionToDatabase(List<Question> questions) {
        mQuestionStorIOContentResolver.put().objects(questions).prepare().executeAsBlocking();
    }
}
