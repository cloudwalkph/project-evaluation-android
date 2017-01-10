package com.cloudwalk.validate.validateapp.data;


import com.cloudwalk.validate.validateapp.data.local.models.Assignment;
import com.cloudwalk.validate.validateapp.data.local.models.Employee;
import com.cloudwalk.validate.validateapp.data.local.models.Event;
import com.cloudwalk.validate.validateapp.data.local.models.Question;

import java.util.List;

import rx.Observable;

/**
 * Created by nkmcheng on 03/01/2017.
 */

public interface AppDataStore {
    Observable<List<Employee>> getEmployees();
    Observable<List<Event>> getEvents();
    Observable<List<Question>> getQuestions();
    Observable<List<Assignment>> getAssignments();
}
