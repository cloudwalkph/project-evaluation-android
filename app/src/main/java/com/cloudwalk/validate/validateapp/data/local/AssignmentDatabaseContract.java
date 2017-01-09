package com.cloudwalk.validate.validateapp.data.local;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;
import android.support.annotation.NonNull;

/**
 * Created by nkmcheng on 09/01/2017.
 */

public class AssignmentDatabaseContract {

    public static final String CONTENT_AUTHORITY = "com.cloudwalk.validate.validateapp";
    public static final String PATH_ASSIGNMENT = "assignment";

    public static abstract class Employee implements BaseColumns {
        @NonNull
        public static final String CONTENT_URI_STRING = "content://" + CONTENT_AUTHORITY + "/" + PATH_ASSIGNMENT;
        public static final Uri CONTENT_URI = Uri.parse(CONTENT_URI_STRING);

        public static final String CONTENT_USER_TYPE = "vnd.android.cursor.dir/" + CONTENT_AUTHORITY + "/" + PATH_ASSIGNMENT;
        public static final String CONTENT_USER_ITEM_TYPE = "vnd.android.cursor.item/" + CONTENT_AUTHORITY + "/" + PATH_ASSIGNMENT;

        public static final String TABLE_NAME = "assignments";

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_DEPARTMENT = "department";
        public static final String COLUMN_QNUM = "qnum";
        public static final String COLUMN_QCAT = "qcat";
        public static final String COLUMN_QRATEE = "qratee";
        public static final String COLUMN_QRATER = "qrater";
        public static final String COLUMN_QEVENT = "qevent";

        public static String getEmployeeCreateQuery() {
            return "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " LONG NOT NULL PRIMARY KEY, " +
                    COLUMN_DEPARTMENT + " TEXT NOT NULL , " +
                    COLUMN_QNUM + " TEXT NOT NULL, " +
                    COLUMN_QCAT + " TEXT NOT NULL, " +
                    COLUMN_QRATEE + " TEXT NOT NULL, " +
                    COLUMN_QRATER + " TEXT NOT NULL, " +
                    COLUMN_QEVENT + " TEXT NOT NULL" + ");";
        }

        public static String getEmployeeDeleteQuery() {
            return "DROP TABLE IF EXISTS " + TABLE_NAME;
        }


        public static Uri buildEmployeeUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
}
