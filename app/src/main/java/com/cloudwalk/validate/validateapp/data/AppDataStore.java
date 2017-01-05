package com.cloudwalk.validate.validateapp.data;


import com.cloudwalk.validate.validateapp.data.local.models.Employee;

import java.util.List;

import rx.Observable;

/**
 * Created by nkmcheng on 03/01/2017.
 */

public interface AppDataStore {
    Observable<List<Employee>> getEmployees();
}
