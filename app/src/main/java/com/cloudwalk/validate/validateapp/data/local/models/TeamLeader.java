package com.cloudwalk.validate.validateapp.data.local.models;

import com.cloudwalk.validate.validateapp.data.local.EmployeeDatabaseContract;
import com.cloudwalk.validate.validateapp.data.local.TeamLeaderDatabaseContract;
import com.google.gson.annotations.SerializedName;
import com.pushtorefresh.storio.contentresolver.annotations.StorIOContentResolverColumn;
import com.pushtorefresh.storio.contentresolver.annotations.StorIOContentResolverType;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by nkmcheng on 09/01/2017.
 */

@StorIOSQLiteType(table = TeamLeaderDatabaseContract.TeamLeader.TABLE_NAME)
@StorIOContentResolverType(uri = TeamLeaderDatabaseContract.TeamLeader.CONTENT_URI_STRING)
public class TeamLeader {

    @StorIOSQLiteColumn(name = TeamLeaderDatabaseContract.TeamLeader.COLUMN_ID, key = true)
    @StorIOContentResolverColumn(name = TeamLeaderDatabaseContract.TeamLeader.COLUMN_ID, key = true)
    @SerializedName("_id")
    protected long id;

    @StorIOSQLiteColumn(name = TeamLeaderDatabaseContract.TeamLeader.COLUMN_FNAME)
    @StorIOContentResolverColumn(name = TeamLeaderDatabaseContract.TeamLeader.COLUMN_FNAME)
    @SerializedName("tfname")
    protected String fname;

    @StorIOSQLiteColumn(name = TeamLeaderDatabaseContract.TeamLeader.COLUMN_LNAME)
    @StorIOContentResolverColumn(name = TeamLeaderDatabaseContract.TeamLeader.COLUMN_LNAME)
    @SerializedName("tlname")
    protected String lname;

    @StorIOSQLiteColumn(name = TeamLeaderDatabaseContract.TeamLeader.COLUMN_EMAIL)
    @StorIOContentResolverColumn(name = TeamLeaderDatabaseContract.TeamLeader.COLUMN_EMAIL)
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
