package com.cloudwalk.validate.validateapp.data.local;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;
import android.support.annotation.NonNull;

/**
 * Created by nkmcheng on 09/01/2017.
 */

public class RecordDatabaseContract {

    public static final String CONTENT_AUTHORITY = "com.cloudwalk.validate.validateapp";
    public static final String PATH_RECORD = "record";

    public static abstract class Record implements BaseColumns {
        @NonNull
        public static final String CONTENT_URI_STRING = "content://" + CONTENT_AUTHORITY + "/" + PATH_RECORD;
        public static final Uri CONTENT_URI = Uri.parse(CONTENT_URI_STRING);

        public static final String CONTENT_USER_TYPE = "vnd.android.cursor.dir/" + CONTENT_AUTHORITY + "/" + PATH_RECORD;
        public static final String CONTENT_USER_ITEM_TYPE = "vnd.android.cursor.item/" + CONTENT_AUTHORITY + "/" + PATH_RECORD;

        public static final String TABLE_NAME = "records";

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_EVENT = "event_id";
        public static final String COLUMN_QNUM = "question_id";
        public static final String COLUMN_QEVENT = "question_event";
        public static final String COLUMN_CATEGORY = "category";
        public static final String COLUMN_ANSWER = "answer_id";
        public static final String COLUMN_TLID = "team_leader_id";
        public static final String COLUMN_NEGOID = "negotiator_id";

        public static String getRecordCreateQuery() {
            return "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " LONG NOT NULL PRIMARY KEY, " +
                    COLUMN_EVENT + " TEXT, " +
                    COLUMN_QEVENT + " TEXT, " +
                    COLUMN_CATEGORY + " TEXT, " +
                    COLUMN_ANSWER + " TEXT, " +
                    COLUMN_TLID + " TEXT, " +
                    COLUMN_NEGOID + " TEXT, " +
                    COLUMN_QNUM + " TEXT" + ");";
        }

        public static String getRecordDeleteQuery() {
            return "DROP TABLE IF EXISTS " + TABLE_NAME;
        }


        public static Uri buildRecordUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

}
