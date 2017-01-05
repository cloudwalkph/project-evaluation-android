package com.cloudwalk.validate.validateapp.data.local;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;
import android.support.annotation.NonNull;

/**
 * Created by nkmcheng on 05/01/2017.
 */

public class DatabaseContract {

    public static final String CONTENT_AUTHORITY = "com.cloudwalk.validate.validateapp";
    private static final String CONTENT_SCHEME = "content://";
    public static final Uri BASE_CONTENT_URI = Uri.parse(CONTENT_SCHEME + CONTENT_AUTHORITY);

    public static final String PATH_POST = "post";
    public static final String PATH_EMPLOYEE = "employee";

    public DatabaseContract() {
    }

    public static abstract class Post implements BaseColumns {

        @NonNull
        public static final String CONTENT_URI_STRING = "content://" + CONTENT_AUTHORITY + "/" + PATH_POST;
        public static final Uri CONTENT_URI = Uri.parse(CONTENT_URI_STRING);

        public static final String CONTENT_USER_TYPE = "vnd.android.cursor.dir/" + CONTENT_AUTHORITY + "/" + PATH_POST;
        public static final String CONTENT_USER_ITEM_TYPE = "vnd.android.cursor.item/" + CONTENT_AUTHORITY + "/" + PATH_POST;

        public static final String TABLE_NAME = "post";

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_USER_ID = "user_id";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_BODY = "body";

        public static String getPostCreateQuery() {
            return "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " LONG NOT NULL PRIMARY KEY, " +
                    COLUMN_USER_ID + " LONG , " +
                    COLUMN_TITLE + " TEXT NOT NULL, " +
                    COLUMN_BODY + " TEXT NOT NULL" + ");";
        }

        public static String getUserDeleteQuery() {
            return "DROP TABLE IF EXISTS " + TABLE_NAME;
        }


        public static Uri buildUserUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

    public static abstract class Employee implements BaseColumns {
        @NonNull
        public static final String CONTENT_URI_STRING = "content://" + CONTENT_AUTHORITY + "/" + PATH_EMPLOYEE;
        public static final Uri CONTENT_URI = Uri.parse(CONTENT_URI_STRING);

        public static final String CONTENT_USER_TYPE = "vnd.android.cursor.dir/" + CONTENT_AUTHORITY + "/" + PATH_EMPLOYEE;
        public static final String CONTENT_USER_ITEM_TYPE = "vnd.android.cursor.item/" + CONTENT_AUTHORITY + "/" + PATH_EMPLOYEE;

        public static final String TABLE_NAME = "employees";

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_FNAME = "fname";
        public static final String COLUMN_LNAME = "lname";
        public static final String COLUMN_DEPARTMENT = "department";
        public static final String COLUMN_PASSWORD = "password";
    }
}
