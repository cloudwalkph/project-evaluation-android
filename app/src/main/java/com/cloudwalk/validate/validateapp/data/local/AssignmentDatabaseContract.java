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

    public static abstract class Assignment implements BaseColumns {
        @NonNull
        public static final String CONTENT_URI_STRING = "content://" + CONTENT_AUTHORITY + "/" + PATH_ASSIGNMENT;
        public static final Uri CONTENT_URI = Uri.parse(CONTENT_URI_STRING);

        public static final String CONTENT_USER_TYPE = "vnd.android.cursor.dir/" + CONTENT_AUTHORITY + "/" + PATH_ASSIGNMENT;
        public static final String CONTENT_USER_ITEM_TYPE = "vnd.android.cursor.item/" + CONTENT_AUTHORITY + "/" + PATH_ASSIGNMENT;

        public static final String TABLE_NAME = "assignments";

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_QNUM = "question";
        public static final String COLUMN_QCAT = "category";
        public static final String COLUMN_QRATEE = "ratee";
        public static final String COLUMN_QRATER = "rater";
        public static final String COLUMN_QEVENT = "event_id";

        public static String getAssignmentCreateQuery() {
            return "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " LONG NOT NULL PRIMARY KEY, " +
                    COLUMN_QNUM + " TEXT, " +
                    COLUMN_QCAT + " TEXT, " +
                    COLUMN_QRATEE + " TEXT, " +
                    COLUMN_QRATER + " TEXT, " +
                    COLUMN_QEVENT + " TEXT" + ");";
        }

        public static String getAssignmentDeleteQuery() {
            return "DROP TABLE IF EXISTS " + TABLE_NAME;
        }


        public static Uri buildAssignmentUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
}
