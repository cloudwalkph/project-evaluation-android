package com.cloudwalk.validate.validateapp.data.local;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by nkmcheng on 05/01/2017.
 */

public class Provider extends ContentProvider {

    private static final int POST_ITEM = 100;
    private static final int POST_DIR = 101;
    private static final int EMPLOYEE_ITEM = 102;
    private static final int EMPLOYEE_DIR = 103;
    private static final int EVENT_ITEM = 104;
    private static final int EVENT_DIR = 105;
    private static final int QUESTION_ITEM = 106;
    private static final int QUESTION_DIR = 107;
    private static final int ASSIGNMENT_ITEM = 108;
    private static final int ASSIGNMENT_DIR = 109;
    private static final int TEAMLEADER_ITEM = 110;
    private static final int TEAMLEADER_DIR = 111;

    private static final UriMatcher sUriMatcher = buildUriMatcher();
    private DatabaseHelper mDbHelper;

    private static UriMatcher buildUriMatcher() {
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = DatabaseContract.CONTENT_AUTHORITY;

        matcher.addURI(authority, DatabaseContract.PATH_POST + "/#", POST_ITEM);
        matcher.addURI(authority, DatabaseContract.PATH_POST, POST_DIR);

        matcher.addURI(authority, EmployeeDatabaseContract.PATH_EMPLOYEE + "/#", EMPLOYEE_ITEM);
        matcher.addURI(authority, EmployeeDatabaseContract.PATH_EMPLOYEE, EMPLOYEE_DIR);

        matcher.addURI(authority, EventDatabaseContract.PATH_EVENT + "/#", EVENT_ITEM);
        matcher.addURI(authority, EventDatabaseContract.PATH_EVENT, EVENT_DIR);

        matcher.addURI(authority, QuestionDatabaseContract.PATH_QUESTION + "/#", QUESTION_ITEM);
        matcher.addURI(authority, QuestionDatabaseContract.PATH_QUESTION, QUESTION_DIR);

        matcher.addURI(authority, AssignmentDatabaseContract.PATH_ASSIGNMENT + "/#", ASSIGNMENT_ITEM);
        matcher.addURI(authority, AssignmentDatabaseContract.PATH_ASSIGNMENT, ASSIGNMENT_DIR);

        matcher.addURI(authority, TeamLeaderDatabaseContract.PATH_TEAM_LEADER + "/#", TEAMLEADER_ITEM);
        matcher.addURI(authority, TeamLeaderDatabaseContract.PATH_TEAM_LEADER, TEAMLEADER_DIR);

        return matcher;
    }

    @Override
    public boolean onCreate() {
        mDbHelper = new DatabaseHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor retCursor;
        switch (sUriMatcher.match(uri)) {
            case POST_ITEM:
                retCursor = mDbHelper.getReadableDatabase().query(
                        DatabaseContract.Post.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            case POST_DIR:
                retCursor = mDbHelper.getReadableDatabase().query(
                        DatabaseContract.Post.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            case EMPLOYEE_DIR:
                retCursor = mDbHelper.getReadableDatabase().query(
                        EmployeeDatabaseContract.Employee.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            case EMPLOYEE_ITEM:
                retCursor = mDbHelper.getReadableDatabase().query(
                        EmployeeDatabaseContract.Employee.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            case EVENT_DIR:
                retCursor = mDbHelper.getReadableDatabase().query(
                        EventDatabaseContract.Event.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            case EVENT_ITEM:
                retCursor = mDbHelper.getReadableDatabase().query(
                        EventDatabaseContract.Event.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            case QUESTION_DIR:
                retCursor = mDbHelper.getReadableDatabase().query(
                        QuestionDatabaseContract.Question.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            case QUESTION_ITEM:
                retCursor = mDbHelper.getReadableDatabase().query(
                        QuestionDatabaseContract.Question.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            case ASSIGNMENT_DIR:
                retCursor = mDbHelper.getReadableDatabase().query(
                        AssignmentDatabaseContract.Assignment.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            case ASSIGNMENT_ITEM:
                retCursor = mDbHelper.getReadableDatabase().query(
                        AssignmentDatabaseContract.Assignment.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            case TEAMLEADER_DIR:
                retCursor = mDbHelper.getReadableDatabase().query(
                        TeamLeaderDatabaseContract.TeamLeader.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            case TEAMLEADER_ITEM:
                retCursor = mDbHelper.getReadableDatabase().query(
                        TeamLeaderDatabaseContract.TeamLeader.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            default:
                throw new UnsupportedOperationException("Unknown Uri " + uri);
        }
        retCursor.setNotificationUri(getContext().getContentResolver(), uri);
        return retCursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        final int match = sUriMatcher.match(uri);
        switch (match) {
            //Case for user
            case POST_ITEM:
                return DatabaseContract.Post.CONTENT_USER_ITEM_TYPE;
            case POST_DIR:
                return DatabaseContract.Post.CONTENT_USER_TYPE;
            case EMPLOYEE_ITEM:
                return EmployeeDatabaseContract.Employee.CONTENT_USER_ITEM_TYPE;
            case EMPLOYEE_DIR:
                return EmployeeDatabaseContract.Employee.CONTENT_USER_TYPE;
            case EVENT_ITEM:
                return EventDatabaseContract.Event.CONTENT_USER_ITEM_TYPE;
            case EVENT_DIR:
                return EventDatabaseContract.Event.CONTENT_USER_TYPE;
            case QUESTION_ITEM:
                return QuestionDatabaseContract.Question.CONTENT_USER_ITEM_TYPE;
            case QUESTION_DIR:
                return QuestionDatabaseContract.Question.CONTENT_USER_TYPE;
            case ASSIGNMENT_ITEM:
                return AssignmentDatabaseContract.Assignment.CONTENT_USER_ITEM_TYPE;
            case ASSIGNMENT_DIR:
                return AssignmentDatabaseContract.Assignment.CONTENT_USER_TYPE;
            case TEAMLEADER_ITEM:
                return TeamLeaderDatabaseContract.TeamLeader.CONTENT_USER_ITEM_TYPE;
            case TEAMLEADER_DIR:
                return TeamLeaderDatabaseContract.TeamLeader.CONTENT_USER_TYPE;
            default:
                throw new UnsupportedOperationException("Unknown URI " + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        final SQLiteDatabase db = mDbHelper.getWritableDatabase();
        Uri returnUri;
        switch (sUriMatcher.match(uri)) {
            //Case for Post
            case POST_DIR:
                long _id = db.insert(DatabaseContract.Post.TABLE_NAME, null, contentValues);
                if (_id > 0)
                    returnUri = DatabaseContract.Post.buildUserUri(_id);
                else
                    throw new SQLException("Failed to insert row " + uri);
                break;
            case EMPLOYEE_DIR:
                long employee_id = db.insert(EmployeeDatabaseContract.Employee.TABLE_NAME, null, contentValues);
                if (employee_id > 0) {
                    returnUri = EmployeeDatabaseContract.Employee.buildEmployeeUri(employee_id);
                } else {
                    throw new SQLException("Employee Failed to insert row " + uri);
                }
                break;
            case EVENT_DIR:
                long event_id = db.insert(EventDatabaseContract.Event.TABLE_NAME, null, contentValues);
                if (event_id > 0) {
                    returnUri = EventDatabaseContract.Event.buildEventUri(event_id);
                } else {
                    throw new SQLException("Event Failed to insert row " + uri);
                }
                break;
            case QUESTION_DIR:
                long question_id = db.insert(QuestionDatabaseContract.Question.TABLE_NAME, null, contentValues);
                if (question_id > 0) {
                    returnUri = QuestionDatabaseContract.Question.buildQuestionUri(question_id);
                } else {
                    throw new SQLException("Question Failed to insert row " + uri);
                }
                break;
            case ASSIGNMENT_DIR:
                long assignment_id = db.insert(AssignmentDatabaseContract.Assignment.TABLE_NAME, null, contentValues);
                if (assignment_id > 0) {
                    returnUri = AssignmentDatabaseContract.Assignment.buildAssignmentUri(assignment_id);
                } else {
                    throw new SQLException("Assignment Failed to insert row " + uri);
                }
                break;
            case TEAMLEADER_DIR:
                long team_leader_id = db.insert(TeamLeaderDatabaseContract.TeamLeader.TABLE_NAME, null, contentValues);
                if (team_leader_id > 0) {
                    returnUri = TeamLeaderDatabaseContract.TeamLeader.buildTeamLeaderUri(team_leader_id);
                } else {
                    throw new SQLException("Team leader Failed to insert row " + uri);
                }
                break;
            default:
                throw new UnsupportedOperationException("Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return returnUri;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        final SQLiteDatabase db = mDbHelper.getWritableDatabase();
        int rowsDeleted;
        switch (sUriMatcher.match(uri)) {
            case POST_DIR:
                rowsDeleted = db.delete(DatabaseContract.Post.TABLE_NAME, selection, selectionArgs);
                break;
            case EMPLOYEE_DIR:
                rowsDeleted = db.delete(EmployeeDatabaseContract.Employee.TABLE_NAME, selection, selectionArgs);
                break;
            case EVENT_DIR:
                rowsDeleted = db.delete(EventDatabaseContract.Event.TABLE_NAME, selection, selectionArgs);
                break;
            case QUESTION_DIR:
                rowsDeleted = db.delete(QuestionDatabaseContract.Question.TABLE_NAME, selection, selectionArgs);
                break;
            case ASSIGNMENT_DIR:
                rowsDeleted = db.delete(AssignmentDatabaseContract.Assignment.TABLE_NAME, selection, selectionArgs);
                break;
            case TEAMLEADER_DIR:
                rowsDeleted = db.delete(TeamLeaderDatabaseContract.TeamLeader.TABLE_NAME, selection, selectionArgs);
                break;
            default:
                throw new UnsupportedOperationException("Unknown URI " + uri);
        }
        if (selection == null || 0 != rowsDeleted)
            getContext().getContentResolver().notifyChange(uri, null);
        return rowsDeleted;
    }

    @Override
    public int update(Uri uri,  ContentValues values, String selection, String[] selectionArgs) {
        final SQLiteDatabase db = mDbHelper.getWritableDatabase();
        int update;
        switch (sUriMatcher.match(uri)) {
            //Case for User
            case POST_DIR:
                update = db.update(DatabaseContract.Post.TABLE_NAME, values, selection, selectionArgs);
                break;
            case EMPLOYEE_DIR:
                update = db.update(EmployeeDatabaseContract.Employee.TABLE_NAME, values, selection, selectionArgs);
                break;
            case EVENT_DIR:
                update = db.update(EventDatabaseContract.Event.TABLE_NAME, values, selection, selectionArgs);
                break;
            case QUESTION_DIR:
                update = db.update(QuestionDatabaseContract.Question.TABLE_NAME, values, selection, selectionArgs);
                break;
            case ASSIGNMENT_DIR:
                update = db.update(AssignmentDatabaseContract.Assignment.TABLE_NAME, values, selection, selectionArgs);
                break;
            case TEAMLEADER_DIR:
                update = db.update(TeamLeaderDatabaseContract.TeamLeader.TABLE_NAME, values, selection, selectionArgs);
                break;
            default:
                throw new UnsupportedOperationException("Unknown URI " + uri);
        }
        if (update > 0)
            getContext().getContentResolver().notifyChange(uri, null);
        return update;
    }
}
