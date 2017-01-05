package com.cloudwalk.validate.validateapp.data.local.models;

import com.cloudwalk.validate.validateapp.data.local.DatabaseContract;
import com.google.gson.annotations.SerializedName;
import com.pushtorefresh.storio.contentresolver.annotations.StorIOContentResolverColumn;
import com.pushtorefresh.storio.contentresolver.annotations.StorIOContentResolverType;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by nkmcheng on 03/01/2017.
 */

//@StorIOSQLiteType(table = DatabaseContract.Event.TABLE_NAME)
//@StorIOContentResolverType(uri = DatabaseContract.Event.CONTENT_URI_STRING)
public class Event {

//    @StorIOSQLiteColumn(name = DatabaseContract.Event.COLUMN_ID, key = true)
//    @StorIOContentResolverColumn(name = DatabaseContract.Event.COLUMN_ID, key = true)
//    @SerializedName("_id")
    protected long id;

//    @StorIOSQLiteColumn(name = DatabaseContract.Event.COLUMN_NAME)
//    @StorIOContentResolverColumn(name = DatabaseContract.Event.COLUMN_NAME)
//    @SerializedName("e_name")
    protected String name;

//    @StorIOSQLiteColumn(name = DatabaseContract.Event.COLUMN_JONUM)
//    @StorIOContentResolverColumn(name = DatabaseContract.Event.COLUMN_JONUM)
//    @SerializedName("e_jo")
    protected String jonum;

//    @StorIOSQLiteColumn(name = DatabaseContract.Event.COLUMN_EVENT_DATE)
//    @StorIOContentResolverColumn(name = DatabaseContract.Event.COLUMN_EVENT_DATE)
//    @SerializedName("e_date")
    protected String eventdate;

//    @StorIOSQLiteColumn(name = DatabaseContract.Event.COLUMN_EVENT_AREA)
//    @StorIOContentResolverColumn(name = DatabaseContract.Event.COLUMN_EVENT_AREA)
//    @SerializedName("e_area")
    protected String eventarea;

//    @StorIOSQLiteColumn(name = DatabaseContract.Event.COLUMN_POST_DATE)
//    @StorIOContentResolverColumn(name = DatabaseContract.Event.COLUMN_POST_DATE)
//    @SerializedName("p_date")
    protected String postdate;

//    @StorIOSQLiteColumn(name = DatabaseContract.Event.COLUMN_PRE_DATE)
//    @StorIOContentResolverColumn(name = DatabaseContract.Event.COLUMN_PRE_DATE)
//    @SerializedName("pe_date")
    protected String predate;

//    @StorIOSQLiteColumn(name = DatabaseContract.Event.COLUMN_EVENT_TIME)
//    @StorIOContentResolverColumn(name = DatabaseContract.Event.COLUMN_EVENT_TIME)
//    @SerializedName("e_time")
    protected String eventtime;
//
//    @StorIOSQLiteColumn(name = DatabaseContract.Event.COLUMN_EVALUATOR)
//    @StorIOContentResolverColumn(name = DatabaseContract.Event.COLUMN_EVALUATOR)
    protected String evaluator;
//
//    @StorIOSQLiteColumn(name = DatabaseContract.Event.COLUMN_TLS)
//    @StorIOContentResolverColumn(name = DatabaseContract.Event.COLUMN_TLS)
    protected String tls;
//
//    @StorIOSQLiteColumn(name = DatabaseContract.Event.COLUMN_NEGO)
//    @StorIOContentResolverColumn(name = DatabaseContract.Event.COLUMN_NEGO)
    protected String nego;

//    @StorIOSQLiteColumn(name = DatabaseContract.Event.COLUMN_DATE_CREATED)
//    @StorIOContentResolverColumn(name = DatabaseContract.Event.COLUMN_DATE_CREATED)
//    @SerializedName("datecreated")
    protected String dateCreated;

    public String getPostdate() {
        return postdate;
    }

    public void setPostdate(String postdate) { this.postdate = postdate; }

    public String getPredate() {
        return predate;
    }

    public void setPredate(String predate) {
        this.predate = predate;
    }

    public String getEvaluator() {
        return evaluator;
    }

    public void setEvaluator(String evaluator) {
        this.evaluator = evaluator;
    }

    public String getTls() {
        return tls;
    }

    public void setTls(String tls) {
        this.tls = tls;
    }

    public String getNego() {
        return nego;
    }

    public void setNego(String nego) {
        this.nego = nego;
    }

    public String getEventtime() {
        return eventtime;
    }

    public void setEventtime(String eventtime) {
        this.eventtime = eventtime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJonum() {
        return jonum;
    }

    public void setJonum(String jonum) {
        this.jonum = jonum;
    }

    public String getEventdate() {
        return eventdate;
    }

    public void setEventdate(String eventdate) {
        this.eventdate = eventdate;
    }

    public String getEventArea() {
        return eventarea;
    }

    public void setEventArea(String eventarea) {
        this.eventarea = eventarea;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String datecreated) {
        this.dateCreated = datecreated;
    }

    public Event(long id, String name, String jonum, String eventdate,
                 String eventarea, String postdate, String predate,
                 String eventtime, String evaluator, String tls,
                 String nego, String dateCreated) {
        this.id = id;
        this.name = name;
        this.jonum = jonum;
        this.eventdate = eventdate;
        this.eventarea = eventarea;
        this.postdate = postdate;
        this.predate = predate;
        this.eventtime = eventtime;
        this.evaluator = evaluator;
        this.tls = tls;
        this.nego = nego;
        this.dateCreated = dateCreated;
    }

    public static ArrayList<Event> createEventList() {
        ArrayList<Event> events = new ArrayList<Event>();

        events.add(new Event(1, "Ponds School Event", "201710001", "January 21, 2017", "Manila", "January 21, 2017", "January 21, 2017", "8:00PM", "CEO", "test", "test", "January 21, 2017"));
        events.add(new Event(2, "Smart School Event", "201710002", "January 30, 2017", "Manila", "January 21, 2017", "January 21, 2017", "8:00PM", "CEO", "test", "test", "January 21, 2017"));
        events.add(new Event(3, "Unilever School Event", "201710003", "February 02, 2017", "Manila", "January 21, 2017", "January 21, 2017", "8:00PM", "CEO", "test", "test", "January 21, 2017"));
        events.add(new Event(4, "Globe School Event", "201710004", "March 16, 2017", "Manila", "January 21, 2017", "January 21, 2017", "8:00PM", "CEO", "test", "test", "January 21, 2017"));
        events.add(new Event(5, "Sun School Event", "201710005", "June 03, 2017", "Manila", "January 21, 2017", "January 21, 2017", "8:00PM", "CEO", "test", "test", "January 21, 2017"));
        events.add(new Event(6, "Test School Event", "201710006", "June 12, 2017", "Manila", "January 21, 2017", "January 21, 2017", "8:00PM", "CEO", "test", "test", "January 21, 2017"));

        return events;
    }
}
