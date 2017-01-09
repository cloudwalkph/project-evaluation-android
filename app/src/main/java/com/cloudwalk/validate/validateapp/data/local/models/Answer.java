package com.cloudwalk.validate.validateapp.data.local.models;

import com.cloudwalk.validate.validateapp.data.local.AnswerDatabaseContract;
import com.google.gson.annotations.SerializedName;
import com.pushtorefresh.storio.contentresolver.annotations.StorIOContentResolverColumn;
import com.pushtorefresh.storio.contentresolver.annotations.StorIOContentResolverType;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by nkmcheng on 09/01/2017.
 */

@StorIOSQLiteType(table = AnswerDatabaseContract.Answer.TABLE_NAME)
@StorIOContentResolverType(uri = AnswerDatabaseContract.Answer.CONTENT_URI_STRING)
public class Answer {

//    @StorIOSQLiteColumn(name = AnswerDatabaseContract.Answer.COLUMN_ID, key = true)
//    @StorIOContentResolverColumn(name = AnswerDatabaseContract.Answer.COLUMN_ID, key = true)
//    @SerializedName("_id")
    protected long id;

//    @StorIOSQLiteColumn(name = AnswerDatabaseContract.Answer.COLUMN_CONTENT)
//    @StorIOContentResolverColumn(name = AnswerDatabaseContract.Answer.COLUMN_CONTENT)
//    @SerializedName("aneme")
    protected String content;

//    @StorIOSQLiteColumn(name = AnswerDatabaseContract.Answer.COLUMN_QNUM)
//    @StorIOContentResolverColumn(name = AnswerDatabaseContract.Answer.COLUMN_QNUM)
//    @SerializedName("qnum")
    protected long qnum;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getQnum() {
        return qnum;
    }

    public void setQnum(long qnum) {
        this.qnum = qnum;
    }

}
