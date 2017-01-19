package com.cloudwalk.validate.validateapp.data.local.models;

import com.cloudwalk.validate.validateapp.data.local.EventDatabaseContract;
import com.google.gson.annotations.SerializedName;
import com.pushtorefresh.storio.contentresolver.annotations.StorIOContentResolverColumn;
import com.pushtorefresh.storio.contentresolver.annotations.StorIOContentResolverType;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by nkmcheng on 03/01/2017.
 */
public class Record {
    @SerializedName("_id")
    protected long id;

    @SerializedName("eid")
    protected String eventId;

    @SerializedName("qcat")
    protected String category;

    @SerializedName("qevent")
    protected String qEvent;

    @SerializedName("qid")
    protected String questionId;

    @SerializedName("qans")
    protected String answerId;

    protected String tlid;

    protected String negoid;

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
