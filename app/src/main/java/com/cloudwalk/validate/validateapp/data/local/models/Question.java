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

//    @StorIOSQLiteColumn(name = QuestionDatabaseContract.Question.COLUMN_ID, key = true)
//    @StorIOContentResolverColumn(name = QuestionDatabaseContract.Question.COLUMN_ID, key = true)
//    @SerializedName("_id")
    protected long id;

//    @StorIOSQLiteColumn(name = QuestionDatabaseContract.Question.COLUMN_NAME)
//    @StorIOContentResolverColumn(name = QuestionDatabaseContract.Question.COLUMN_NAME)
//    @SerializedName("qname")
    protected String qname;

//    @StorIOSQLiteColumn(name = QuestionDatabaseContract.Question.COLUMN_JONUM)
//    @StorIOContentResolverColumn(name = QuestionDatabaseContract.Question.COLUMN_JONUM)
//    @SerializedName("qdept")
    protected String qdept;

//    @StorIOSQLiteColumn(name = QuestionDatabaseContract.Question.COLUMN_EVENT_DATE)
//    @StorIOContentResolverColumn(name = QuestionDatabaseContract.Question.COLUMN_EVENT_DATE)
//    @SerializedName("qcat")
    protected String qcat;

//    @StorIOSQLiteColumn(name = QuestionDatabaseContract.Question.COLUMN_EVENT_AREA)
//    @StorIOContentResolverColumn(name = QuestionDatabaseContract.Question.COLUMN_EVENT_AREA)
//    @SerializedName("qtype")
    protected String qtype;

//    @StorIOSQLiteColumn(name = QuestionDatabaseContract.Question.COLUMN_POST_DATE)
//    @StorIOContentResolverColumn(name = QuestionDatabaseContract.Question.COLUMN_POST_DATE)
//    @SerializedName("qsub")
    protected String qsub;

    List<Answer> answers = new ArrayList<Answer>();

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

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

    public String getQsub() {
        return qsub;
    }

    public void setQsub(String qsub) {
        this.qsub = qsub;
    }

}
