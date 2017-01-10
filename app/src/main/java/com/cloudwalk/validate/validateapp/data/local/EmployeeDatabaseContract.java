package com.cloudwalk.validate.validateapp.data.local;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;
import android.support.annotation.NonNull;

/**
 * Created by nkmcheng on 09/01/2017.
 */

public class EmployeeDatabaseContract {

    public static final String CONTENT_AUTHORITY = "com.cloudwalk.validate.validateapp";
    public static final String PATH_EMPLOYEE = "employee";

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
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_DEPARTMENT = "department";
        public static final String COLUMN_PASSWORD = "password";

        public static String getEmployeeCreateQuery() {
            return "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " LONG NOT NULL PRIMARY KEY, " +
                    COLUMN_FNAME + " TEXT NOT NULL, " +
                    COLUMN_LNAME + " TEXT NOT NULL, " +
                    COLUMN_EMAIL + " TEXT NOT NULL, " +
                    COLUMN_DEPARTMENT + " TEXT NOT NULL, " +
                    COLUMN_PASSWORD + " TEXT NOT NULL" + ");";
        }

        public static String getEmployeeDeleteQuery() {
            return "DROP TABLE IF EXISTS " + TABLE_NAME;
        }


        public static Uri buildEmployeeUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }


}
