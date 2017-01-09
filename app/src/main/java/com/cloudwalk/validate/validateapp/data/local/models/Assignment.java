package com.cloudwalk.validate.validateapp.data.local.models;

import com.cloudwalk.validate.validateapp.data.local.AssignmentDatabaseContract;
import com.google.gson.annotations.SerializedName;
import com.pushtorefresh.storio.contentresolver.annotations.StorIOContentResolverColumn;
import com.pushtorefresh.storio.contentresolver.annotations.StorIOContentResolverType;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by nkmcheng on 09/01/2017.
 */

//@StorIOSQLiteType(table = AssignmentDatabaseContract.Assignment.TABLE_NAME)
//@StorIOContentResolverType(uri = AssignmentDatabaseContract.Assignment.CONTENT_URI_STRING)
public class Assignment {

//    @StorIOSQLiteColumn(name = AssignmentDatabaseContract.Assignment.COLUMN_ID, key = true)
//    @StorIOContentResolverColumn(name = AssignmentDatabaseContract.Assignment.COLUMN_ID, key = true)
//    @SerializedName("_id")
    protected long id;

//    @StorIOSQLiteColumn(name = AssignmentDatabaseContract.Assignment.COLUMN_DEPARTMENT)
//    @StorIOContentResolverColumn(name = AssignmentDatabaseContract.Assignment.COLUMN_DEPARTMENT)
//    @SerializedName("dept")
    protected String department;

//    @StorIOSQLiteColumn(name = AssignmentDatabaseContract.Assignment.COLUMN_QNUM)
//    @StorIOContentResolverColumn(name = AssignmentDatabaseContract.Assignment.COLUMN_QNUM)
//    @SerializedName("qnum")
    protected String qnum;

//    @StorIOSQLiteColumn(name = AssignmentDatabaseContract.Assignment.COLUMN_QCAT)
//    @StorIOContentResolverColumn(name = AssignmentDatabaseContract.Assignment.COLUMN_QCAT)
//    @SerializedName("qcat")
    protected String qcat;

//    @StorIOSQLiteColumn(name = AssignmentDatabaseContract.Assignment.COLUMN_QRATER)
//    @StorIOContentResolverColumn(name = AssignmentDatabaseContract.Assignment.COLUMN_QRATER)
//    @SerializedName("qrater")
    protected String qrater;

//    @StorIOSQLiteColumn(name = AssignmentDatabaseContract.Assignment.COLUMN_QRATEE)
//    @StorIOContentResolverColumn(name = AssignmentDatabaseContract.Assignment.COLUMN_QRATEE)
//    @SerializedName("qratee")
    protected String qratee;

//    @StorIOSQLiteColumn(name = AssignmentDatabaseContract.Assignment.COLUMN_QEVENT)
//    @StorIOContentResolverColumn(name = AssignmentDatabaseContract.Assignment.COLUMN_QEVENT)
//    @SerializedName("qevent")
    protected String qevent;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        department = department;
    }

    public String getQnum() {
        return qnum;
    }

    public void setQnum(String qnum) {
        qnum = qnum;
    }

    public String getQcat() {
        return qcat;
    }

    public void setQcat(String qcat) {
        qcat = qcat;
    }

    public String getQrater() {
        return qrater;
    }

    public void setRater(String rater) {
        qrater = rater;
    }

    public String getQratee() {
        return qratee;
    }

    public void setRatee(String ratee) {
        qratee = ratee;
    }

    public String getQevent() {
        return qevent;
    }

    public void setQevent(String event) {
        qevent = event;
    }

}
