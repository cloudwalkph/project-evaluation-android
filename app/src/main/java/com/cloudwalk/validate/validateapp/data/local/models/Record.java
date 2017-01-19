package com.cloudwalk.validate.validateapp.data.local.models;

import com.cloudwalk.validate.validateapp.data.local.EventDatabaseContract;
import com.cloudwalk.validate.validateapp.data.local.QuestionDatabaseContract;
import com.cloudwalk.validate.validateapp.data.local.RecordDatabaseContract;
import com.google.gson.annotations.SerializedName;
import com.pushtorefresh.storio.contentresolver.annotations.StorIOContentResolverColumn;
import com.pushtorefresh.storio.contentresolver.annotations.StorIOContentResolverType;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by nkmcheng on 03/01/2017.
 */

@StorIOSQLiteType(table = RecordDatabaseContract.Record.TABLE_NAME)
@StorIOContentResolverType(uri = RecordDatabaseContract.Record.CONTENT_URI_STRING)
public class Record {

    @StorIOSQLiteColumn(name = RecordDatabaseContract.Record.COLUMN_ID, key = true)
    @StorIOContentResolverColumn(name = RecordDatabaseContract.Record.COLUMN_ID, key = true)
    @SerializedName("_id")
    protected long id;

    @StorIOSQLiteColumn(name = RecordDatabaseContract.Record.COLUMN_EVENT)
    @StorIOContentResolverColumn(name = RecordDatabaseContract.Record.COLUMN_EVENT)
    @SerializedName("eid")
    protected String eventId;

    @StorIOSQLiteColumn(name = RecordDatabaseContract.Record.COLUMN_CATEGORY)
    @StorIOContentResolverColumn(name = RecordDatabaseContract.Record.COLUMN_CATEGORY)
    @SerializedName("qcat")
    protected String category;

    @StorIOSQLiteColumn(name = RecordDatabaseContract.Record.COLUMN_QEVENT)
    @StorIOContentResolverColumn(name = RecordDatabaseContract.Record.COLUMN_QEVENT)
    @SerializedName("qevent")
    protected String qEvent;

    @StorIOSQLiteColumn(name = RecordDatabaseContract.Record.COLUMN_QNUM)
    @StorIOContentResolverColumn(name = RecordDatabaseContract.Record.COLUMN_QNUM)
    @SerializedName("qid")
    protected String questionId;

    @StorIOSQLiteColumn(name = RecordDatabaseContract.Record.COLUMN_ANSWER)
    @StorIOContentResolverColumn(name = RecordDatabaseContract.Record.COLUMN_ANSWER)
    @SerializedName("qans")
    protected String answerId;

    @StorIOSQLiteColumn(name = RecordDatabaseContract.Record.COLUMN_TLID)
    @StorIOContentResolverColumn(name = RecordDatabaseContract.Record.COLUMN_TLID)
    protected String tlid;

    @StorIOSQLiteColumn(name = RecordDatabaseContract.Record.COLUMN_NEGOID)
    @StorIOContentResolverColumn(name = RecordDatabaseContract.Record.COLUMN_NEGOID)
    protected String negoid;

    public Record() {
    }

    public Record(long id, String eventId, String category,
                  String qEvent, String questionId, String answerId, String tlid, String negoid) {
        this.id = id;
        this.eventId = eventId;
        this.category = category;
        this.qEvent = qEvent;
        this.questionId = questionId;
        this.answerId = answerId;
        this.tlid = tlid;
        this.negoid = negoid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getqEvent() {
        return qEvent;
    }

    public void setqEvent(String qEvent) {
        this.qEvent = qEvent;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public String getTlid() {
        return tlid;
    }

    public void setTlid(String tlid) {
        this.tlid = tlid;
    }

    public String getNegoid() {
        return negoid;
    }

    public void setNegoid(String negoid) {
        this.negoid = negoid;
    }
}
