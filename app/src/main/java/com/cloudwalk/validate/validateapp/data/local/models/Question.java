package com.cloudwalk.validate.validateapp.data.local.models;

import com.cloudwalk.validate.validateapp.data.local.QuestionDatabaseContract;
import com.google.gson.annotations.SerializedName;
import com.pushtorefresh.storio.contentresolver.annotations.StorIOContentResolverColumn;
import com.pushtorefresh.storio.contentresolver.annotations.StorIOContentResolverType;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nkmcheng on 09/01/2017.
 */

@StorIOSQLiteType(table = QuestionDatabaseContract.Question.TABLE_NAME)
@StorIOContentResolverType(uri = QuestionDatabaseContract.Question.CONTENT_URI_STRING)
public class Question {

    @StorIOSQLiteColumn(name = QuestionDatabaseContract.Question.COLUMN_ID, key = true)
    @StorIOContentResolverColumn(name = QuestionDatabaseContract.Question.COLUMN_ID, key = true)
    @SerializedName("_id")
    protected long id;

    @StorIOSQLiteColumn(name = QuestionDatabaseContract.Question.COLUMN_QNAME)
    @StorIOContentResolverColumn(name = QuestionDatabaseContract.Question.COLUMN_QNAME)
    protected String qname;

    @StorIOSQLiteColumn(name = QuestionDatabaseContract.Question.COLUMN_QDEPT)
    @StorIOContentResolverColumn(name = QuestionDatabaseContract.Question.COLUMN_QDEPT)
    protected String qdept;

    @StorIOSQLiteColumn(name = QuestionDatabaseContract.Question.COLUMN_QCAT)
    @StorIOContentResolverColumn(name = QuestionDatabaseContract.Question.COLUMN_QCAT)
    protected String qcat;

    @StorIOSQLiteColumn(name = QuestionDatabaseContract.Question.COLUMN_QTYPE)
    @StorIOContentResolverColumn(name = QuestionDatabaseContract.Question.COLUMN_QTYPE)
    protected String qtype;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQname() {
        return qname;
    }

    public void setQname(String qname) {
        this.qname = qname;
    }

    public String getQtype() {
        return qtype;
    }

    public void setQtype(String qtype) {
        this.qtype = qtype;
    }

    public String getQdept() {
        return qdept;
    }

    public void setQdept(String qdept) {
        this.qdept = qdept;
    }

    public String getQcat() {
        return qcat;
    }

    public void setQcat(String qcat) {
        this.qcat = qcat;
    }

}
