package com.cloudwalk.validate.validateapp.data.local.models;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by nkmcheng on 03/01/2017.
 */

public class Event {

    public String name;
    public String job;
    public String date;

    public Event() {

    }

    public Event(String name, String job, String date) {
        this.name = name;
        this.job = job;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getDate() {
        return date;
    }

    public static ArrayList<Event> createEventList() {
        ArrayList<Event> events = new ArrayList<Event>();

        events.add(new Event("Ponds School Event", "201710001", "January 21, 2017"));
        events.add(new Event("Smart School Event", "201710002", "January 30, 2017"));
        events.add(new Event("Unilever School Event", "201710003", "February 02, 2017"));
        events.add(new Event("Globe School Event", "201710004", "March 16, 2017"));
        events.add(new Event("Sun School Event", "201710005", "June 03, 2017"));
        events.add(new Event("Test School Event", "201710006", "June 12, 2017"));

        return events;
    }
}
