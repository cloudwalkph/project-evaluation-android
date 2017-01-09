package com.cloudwalk.validate.validateapp.data.local.models;

import com.cloudwalk.validate.validateapp.data.local.EmployeeDatabaseContract;
import com.google.gson.annotations.SerializedName;
import com.pushtorefresh.storio.contentresolver.annotations.StorIOContentResolverColumn;
import com.pushtorefresh.storio.contentresolver.annotations.StorIOContentResolverType;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by nkmcheng on 05/01/2017.
 */

@StorIOSQLiteType(table = EmployeeDatabaseContract.Employee.TABLE_NAME)
@StorIOContentResolverType(uri = EmployeeDatabaseContract.Employee.CONTENT_URI_STRING)
public class Employee {

    @StorIOSQLiteColumn(name = EmployeeDatabaseContract.Employee.COLUMN_ID, key = true)
    @StorIOContentResolverColumn(name = EmployeeDatabaseContract.Employee.COLUMN_ID, key = true)
    @SerializedName("_id")
    protected long id;

    @StorIOSQLiteColumn(name = EmployeeDatabaseContract.Employee.COLUMN_FNAME)
    @StorIOContentResolverColumn(name = EmployeeDatabaseContract.Employee.COLUMN_FNAME)
    @SerializedName("emp_fname")
    protected String fname;

    @StorIOSQLiteColumn(name = EmployeeDatabaseContract.Employee.COLUMN_LNAME)
    @StorIOContentResolverColumn(name = EmployeeDatabaseContract.Employee.COLUMN_LNAME)
    @SerializedName("emp_lname")
    protected String lname;

    @StorIOSQLiteColumn(name = EmployeeDatabaseContract.Employee.COLUMN_EMAIL)
    @StorIOContentResolverColumn(name = EmployeeDatabaseContract.Employee.COLUMN_EMAIL)
    @SerializedName("emp_email")
    protected String email;

    @StorIOSQLiteColumn(name = EmployeeDatabaseContract.Employee.COLUMN_DEPARTMENT)
    @StorIOContentResolverColumn(name = EmployeeDatabaseContract.Employee.COLUMN_DEPARTMENT)
    @SerializedName("emp_dept")
    protected String department;

    @StorIOSQLiteColumn(name = EmployeeDatabaseContract.Employee.COLUMN_PASSWORD)
    @StorIOContentResolverColumn(name = EmployeeDatabaseContract.Employee.COLUMN_PASSWORD)
    @SerializedName("emp_pass")
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
