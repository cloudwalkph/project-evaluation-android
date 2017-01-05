package com.cloudwalk.validate.validateapp.data.local.models;

import com.cloudwalk.validate.validateapp.data.local.DatabaseContract;
import com.pushtorefresh.storio.contentresolver.annotations.StorIOContentResolverColumn;
import com.pushtorefresh.storio.contentresolver.annotations.StorIOContentResolverType;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by nkmcheng on 05/01/2017.
 */

@StorIOSQLiteType(table = DatabaseContract.Employee.TABLE_NAME)
@StorIOContentResolverType(uri = DatabaseContract.Employee.CONTENT_URI_STRING)
public class Employee {
    @StorIOSQLiteColumn(name = DatabaseContract.Employee.COLUMN_ID, key = true)
    @StorIOContentResolverColumn(name = DatabaseContract.Employee.COLUMN_ID, key = true)
    protected long id;

    @StorIOSQLiteColumn(name = DatabaseContract.Employee.COLUMN_FNAME)
    @StorIOContentResolverColumn(name = DatabaseContract.Employee.COLUMN_FNAME)
    protected String fname;

    @StorIOSQLiteColumn(name = DatabaseContract.Employee.COLUMN_LNAME)
    @StorIOContentResolverColumn(name = DatabaseContract.Employee.COLUMN_LNAME)
    protected String lname;

    @StorIOSQLiteColumn(name = DatabaseContract.Employee.COLUMN_EMAIL)
    @StorIOContentResolverColumn(name = DatabaseContract.Employee.COLUMN_EMAIL)
    protected String email;

    @StorIOSQLiteColumn(name = DatabaseContract.Employee.COLUMN_DEPARTMENT)
    @StorIOContentResolverColumn(name = DatabaseContract.Employee.COLUMN_DEPARTMENT)
    protected String department;

    @StorIOSQLiteColumn(name = DatabaseContract.Employee.COLUMN_PASSWORD)
    @StorIOContentResolverColumn(name = DatabaseContract.Employee.COLUMN_PASSWORD)
    protected String password = "12345";

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
