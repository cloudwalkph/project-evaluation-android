package com.cloudwalk.validate.validateapp.data;

import com.cloudwalk.validate.validateapp.data.local.AppLocalDataStore;
import com.cloudwalk.validate.validateapp.data.local.models.Answer;
import com.cloudwalk.validate.validateapp.data.local.models.Assignment;
import com.cloudwalk.validate.validateapp.data.local.models.Employee;
import com.cloudwalk.validate.validateapp.data.local.models.Event;
import com.cloudwalk.validate.validateapp.data.local.models.Negotiator;
import com.cloudwalk.validate.validateapp.data.local.models.Question;
import com.cloudwalk.validate.validateapp.data.local.models.Record;
import com.cloudwalk.validate.validateapp.data.local.models.TeamLeader;
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

    @Override
    public Observable<List<Event>> getEvents() {
        return Observable.concat(mAppLocalDataStore.getEvents(), mAppRemoteDataStore.getEvents())
                .first(new Func1<List<Event>, Boolean>() {
                    @Override
                    public Boolean call(List<Event> events) {
                        return events != null;
                    }
                });
    }

    @Override
    public Observable<List<Question>> getQuestions() {
        return Observable.concat(mAppLocalDataStore.getQuestions(), mAppRemoteDataStore.getQuestions())
                .first(new Func1<List<Question>, Boolean>() {
                    @Override
                    public Boolean call(List<Question> questions) {
                        return questions != null;
                    }
                });
    }

    @Override
    public Observable<List<Assignment>> getAssignments() {
        return Observable.concat(mAppLocalDataStore.getAssignments(), mAppRemoteDataStore.getAssignments())
                .first(new Func1<List<Assignment>, Boolean>() {
                    @Override
                    public Boolean call(List<Assignment> assignments) {
                        return assignments != null;
                    }
                });
    }

    public Observable<Employee> getEmployeeById(int employeeId) {
        return mAppLocalDataStore.getEmployeeById(employeeId)
                .first(new Func1<Employee, Boolean>() {
                    @Override
                    public Boolean call(Employee employee) {
                        return employee != null;
                    }
                });
    }

    public Observable<List<Assignment>> getUserAssignments(int employeeId) {
        return mAppLocalDataStore.getUserAssignments(employeeId)
                .first(new Func1<List<Assignment>, Boolean>() {
                    @Override
                    public Boolean call(List<Assignment> assignments) {
                        return assignments != null;
                    }
                });
    }

    public Observable<Event> getUserEvents(int eventId) {
        return mAppLocalDataStore.getUserEvents(eventId)
                .first(new Func1<Event, Boolean>() {
                    @Override
                    public Boolean call(Event event) {
                        return event != null;
                    }
                });
    }

    public Observable<Employee> attemptLogin(String email, String password) {
        return mAppLocalDataStore.attemptLogin(email, password)
                .first();
    }

    public Observable<Question> getQuestionById(int questionId, String category) {
        return mAppLocalDataStore.getQuestionById(questionId, category)
                .first(new Func1<Question, Boolean>() {
                    @Override
                    public Boolean call(Question question) {
                        return question != null;
                    }
                });
    }

    public Observable<List<Answer>> getAnswerByQuestionId(int questionId) {
        return mAppLocalDataStore.getAnswerByQuestionId(questionId)
                .first(new Func1<List<Answer>, Boolean>() {
                    @Override
                    public Boolean call(List<Answer> answer) {
                        return answer != null;
                    }
                });
    }

    public Observable<Record> saveAnswer(Record record) {
        return mAppRemoteDataStore.saveAnswer(record)
                .first();
    }

    @Override
    public Observable<List<TeamLeader>> getTeamLeaders() {
        return Observable.concat(mAppLocalDataStore.getTeamLeaders(), mAppRemoteDataStore.getTeamLeaders())
                .first(new Func1<List<TeamLeader>, Boolean>() {
                    @Override
                    public Boolean call(List<TeamLeader> teamLeaders) {
                        return teamLeaders != null;
                    }
                });
    }

    @Override
    public Observable<List<Negotiator>> getNegotiators() {
        return Observable.concat(mAppLocalDataStore.getNegotiators(), mAppRemoteDataStore.getNegotiators())
                .first(new Func1<List<Negotiator>, Boolean>() {
                    @Override
                    public Boolean call(List<Negotiator> negotiators) {
                        return negotiators != null;
                    }
                });
    }

    @Override
    public Observable<List<Answer>> getAnswers() {
        return Observable.concat(mAppLocalDataStore.getAnswers(), mAppRemoteDataStore.getAnswers())
                .first(new Func1<List<Answer>, Boolean>() {
                    @Override
                    public Boolean call(List<Answer> answers) {
                        return answers != null;
                    }
                });
    }
}
