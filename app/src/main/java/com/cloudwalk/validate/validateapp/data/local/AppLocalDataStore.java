package com.cloudwalk.validate.validateapp.data.local;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.cloudwalk.validate.validateapp.data.AppDataStore;
import com.cloudwalk.validate.validateapp.data.local.models.Assignment;
import com.cloudwalk.validate.validateapp.data.local.models.AssignmentStorIOContentResolverDeleteResolver;
import com.cloudwalk.validate.validateapp.data.local.models.AssignmentStorIOContentResolverGetResolver;
import com.cloudwalk.validate.validateapp.data.local.models.AssignmentStorIOContentResolverPutResolver;
import com.cloudwalk.validate.validateapp.data.local.models.Employee;
import com.cloudwalk.validate.validateapp.data.local.models.EmployeeStorIOContentResolverDeleteResolver;
import com.cloudwalk.validate.validateapp.data.local.models.EmployeeStorIOContentResolverGetResolver;
import com.cloudwalk.validate.validateapp.data.local.models.EmployeeStorIOContentResolverPutResolver;
import com.cloudwalk.validate.validateapp.data.local.models.Event;
import com.cloudwalk.validate.validateapp.data.local.models.EventStorIOContentResolverDeleteResolver;
import com.cloudwalk.validate.validateapp.data.local.models.EventStorIOContentResolverGetResolver;
import com.cloudwalk.validate.validateapp.data.local.models.EventStorIOContentResolverPutResolver;
import com.cloudwalk.validate.validateapp.data.local.models.Negotiator;
import com.cloudwalk.validate.validateapp.data.local.models.NegotiatorStorIOContentResolverDeleteResolver;
import com.cloudwalk.validate.validateapp.data.local.models.NegotiatorStorIOContentResolverGetResolver;
import com.cloudwalk.validate.validateapp.data.local.models.NegotiatorStorIOContentResolverPutResolver;
import com.cloudwalk.validate.validateapp.data.local.models.Question;
import com.cloudwalk.validate.validateapp.data.local.models.QuestionStorIOContentResolverDeleteResolver;
import com.cloudwalk.validate.validateapp.data.local.models.QuestionStorIOContentResolverGetResolver;
import com.cloudwalk.validate.validateapp.data.local.models.QuestionStorIOContentResolverPutResolver;
import com.cloudwalk.validate.validateapp.data.local.models.TeamLeader;
import com.cloudwalk.validate.validateapp.data.local.models.TeamLeaderStorIOContentResolverDeleteResolver;
import com.cloudwalk.validate.validateapp.data.local.models.TeamLeaderStorIOContentResolverGetResolver;
import com.cloudwalk.validate.validateapp.data.local.models.TeamLeaderStorIOContentResolverPutResolver;
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
    private StorIOContentResolver mAssignmentStorIOContentResolver;
    private StorIOContentResolver mTeamLeaderStorIOContentResolver;
    private StorIOContentResolver mNegotiatorStorIOContentResolver;

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

        this.mAssignmentStorIOContentResolver = DefaultStorIOContentResolver.builder()
                .contentResolver(context.getContentResolver())
                .addTypeMapping(Assignment.class, ContentResolverTypeMapping.<Assignment>builder()
                        .putResolver(new AssignmentStorIOContentResolverPutResolver())
                        .getResolver(new AssignmentStorIOContentResolverGetResolver())
                        .deleteResolver(new AssignmentStorIOContentResolverDeleteResolver())
                        .build()
                ).build();

        this.mTeamLeaderStorIOContentResolver = DefaultStorIOContentResolver.builder()
                .contentResolver(context.getContentResolver())
                .addTypeMapping(TeamLeader.class, ContentResolverTypeMapping.<TeamLeader>builder()
                        .putResolver(new TeamLeaderStorIOContentResolverPutResolver())
                        .getResolver(new TeamLeaderStorIOContentResolverGetResolver())
                        .deleteResolver(new TeamLeaderStorIOContentResolverDeleteResolver())
                        .build()
                ).build();

        this.mNegotiatorStorIOContentResolver = DefaultStorIOContentResolver.builder()
                .contentResolver(context.getContentResolver())
                .addTypeMapping(Negotiator.class, ContentResolverTypeMapping.<Negotiator>builder()
                        .putResolver(new NegotiatorStorIOContentResolverPutResolver())
                        .getResolver(new NegotiatorStorIOContentResolverGetResolver())
                        .deleteResolver(new NegotiatorStorIOContentResolverDeleteResolver())
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

    public Observable<Event> getUserEvents(int eventId) {
        Log.d("UserEvents", "Getting events by id");

        return mEventStorIOContentResolver.get()
                .object(Event.class)
                .withQuery(Query.builder()
                        .uri(EventDatabaseContract.Event.CONTENT_URI)
                        .where("id = ?")
                        .whereArgs(eventId)
                        .build()
                ).prepare()
                .asRxObservable();
    }

    public Observable<Employee> attemptLogin(String email, String password) {
        Log.d("Login Employee", "Getting Employee by id");

        return mEventStorIOContentResolver.get()
                .object(Employee.class)
                .withQuery(Query.builder()
                        .uri(EmployeeDatabaseContract.Employee.CONTENT_URI)
                        .where("email = ?")
                        .whereArgs(email)
                        .where("password = ?")
                        .whereArgs(password)
                        .build()
                ).prepare()
                .asRxObservable();
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

    @Override
    public Observable<List<Assignment>> getAssignments() {
        Log.d("LOCAL ASSIGNMENTS","Loaded from local");

        return mAssignmentStorIOContentResolver.get()
                .listOfObjects(Assignment.class)
                .withQuery(Query.builder().uri(AssignmentDatabaseContract.Assignment.CONTENT_URI).build())
                .prepare()
                .asRxObservable();
    }

    public void saveAssignmentToDatabase(List<Assignment> assignments) {
        mAssignmentStorIOContentResolver.put().objects(assignments).prepare().executeAsBlocking();
    }

    public Observable<List<Assignment>> getUserAssignments(int employeeId) {
        Log.d("Assignments", "Getting assignments by authenticated user");

        return mAssignmentStorIOContentResolver.get()
                .listOfObjects(Assignment.class)
                .withQuery(Query.builder()
                        .uri(AssignmentDatabaseContract.Assignment.CONTENT_URI)
                        .where("rater = ?")
                        .whereArgs(employeeId)
                        .build()
                ).prepare()
                .asRxObservable();
    }

    @Override
    public Observable<List<TeamLeader>> getTeamLeaders() {
        Log.d("LOCAL TEAM LEADER","Loaded from local");

        return mTeamLeaderStorIOContentResolver.get()
                .listOfObjects(TeamLeader.class)
                .withQuery(Query.builder().uri(TeamLeaderDatabaseContract.TeamLeader.CONTENT_URI).build())
                .prepare()
                .asRxObservable();
    }

    public void saveTeamLeaderToDatabase(List<TeamLeader> teamLeaders) {
        mTeamLeaderStorIOContentResolver.put().objects(teamLeaders).prepare().executeAsBlocking();
    }

    @Override
    public Observable<List<Negotiator>> getNegotiators() {
        Log.d("LOCAL NEGOTIATOR","Loaded from local");

        return mNegotiatorStorIOContentResolver.get()
                .listOfObjects(Negotiator.class)
                .withQuery(Query.builder().uri(NegotiatorDatabaseContract.Negotiator.CONTENT_URI).build())
                .prepare()
                .asRxObservable();
    }

    public void saveNegotiatorToDatabase(List<Negotiator> negotiators) {
        mNegotiatorStorIOContentResolver.put().objects(negotiators).prepare().executeAsBlocking();
    }
}
