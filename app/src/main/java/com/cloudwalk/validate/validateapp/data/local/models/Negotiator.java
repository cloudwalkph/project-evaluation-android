package com.cloudwalk.validate.validateapp.data.local.models;

import com.cloudwalk.validate.validateapp.data.local.NegotiatorDatabaseContract;
import com.google.gson.annotations.SerializedName;
import com.pushtorefresh.storio.contentresolver.annotations.StorIOContentResolverColumn;
import com.pushtorefresh.storio.contentresolver.annotations.StorIOContentResolverType;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by nkmcheng on 10/01/2017.
 */

@StorIOSQLiteType(table = NegotiatorDatabaseContract.Negotiator.TABLE_NAME)
@StorIOContentResolverType(uri = NegotiatorDatabaseContract.Negotiator.CONTENT_URI_STRING)
public class Negotiator {

    @StorIOSQLiteColumn(name = NegotiatorDatabaseContract.Negotiator.COLUMN_ID, key = true)
    @StorIOContentResolverColumn(name = NegotiatorDatabaseContract.Negotiator.COLUMN_ID, key = true)
    @SerializedName("_id")
    protected long id;

    @StorIOSQLiteColumn(name = NegotiatorDatabaseContract.Negotiator.COLUMN_FNAME)
    @StorIOContentResolverColumn(name = NegotiatorDatabaseContract.Negotiator.COLUMN_FNAME)
    @SerializedName("tfname")
    protected String fname;

    @StorIOSQLiteColumn(name = NegotiatorDatabaseContract.Negotiator.COLUMN_LNAME)
    @StorIOContentResolverColumn(name = NegotiatorDatabaseContract.Negotiator.COLUMN_LNAME)
    @SerializedName("tlname")
    protected String lname;

    @StorIOSQLiteColumn(name = NegotiatorDatabaseContract.Negotiator.COLUMN_EMAIL)
    @StorIOContentResolverColumn(name = NegotiatorDatabaseContract.Negotiator.COLUMN_EMAIL)
    @SerializedName("temail")
    protected String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
