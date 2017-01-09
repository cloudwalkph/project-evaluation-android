package com.cloudwalk.validate.validateapp.data.local;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;
import android.support.annotation.NonNull;

/**
 * Created by nkmcheng on 09/01/2017.
 */

public class EventDatabaseContract {

    public static final String CONTENT_AUTHORITY = "com.cloudwalk.validate.validateapp";
    public static final String PATH_EVENT = "event";

    public static abstract class Event implements BaseColumns {
        @NonNull
        public static final String CONTENT_URI_STRING = "content://" + CONTENT_AUTHORITY + "/" + PATH_EVENT;
        public static final Uri CONTENT_URI = Uri.parse(CONTENT_URI_STRING);

        public static final String CONTENT_USER_TYPE = "vnd.android.cursor.dir/" + CONTENT_AUTHORITY + "/" + PATH_EVENT;
        public static final String CONTENT_USER_ITEM_TYPE = "vnd.android.cursor.item/" + CONTENT_AUTHORITY + "/" + PATH_EVENT;

        public static final String TABLE_NAME = "events";

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_JONUM = "jonum";
        public static final String COLUMN_EVENT_DATE = "eventdate";
        public static final String COLUMN_EVENT_AREA = "eventarea";
        public static final String COLUMN_POST_DATE = "postdate";
        public static final String COLUMN_PRE_DATE = "predate";
        public static final String COLUMN_EVENT_TIME = "eventtime";
        public static final String COLUMN_EVALUATOR = "evaluator";
        public static final String COLUMN_TLS = "tls";
        public static final String COLUMN_NEGO = "nego";
        public static final String COLUMN_DATE_CREATED = "dateCreated";

        public static String getEventCreateQuery() {
            return "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " LONG NOT NULL PRIMARY KEY, " +
                    COLUMN_NAME + " TEXT NOT NULL , " +
                    COLUMN_JONUM + " TEXT NOT NULL, " +
                    COLUMN_EVENT_DATE + " TEXT NOT NULL, " +
                    COLUMN_EVENT_AREA + " TEXT NOT NULL, " +
                    COLUMN_POST_DATE + " TEXT NOT NULL, " +
                    COLUMN_PRE_DATE + " TEXT NOT NULL, " +
                    COLUMN_EVENT_TIME + " TEXT NOT NULL, " +
                    COLUMN_EVALUATOR + " TEXT NOT NULL, " +
                    COLUMN_TLS + " TEXT NOT NULL, " +
                    COLUMN_NEGO + " TEXT NOT NULL, " +
                    COLUMN_DATE_CREATED + " TEXT NOT NULL "+ ");";
        }

        public static String getEventDeleteQuery() {
            return "DROP TABLE IF EXISTS " + TABLE_NAME;
        }


        public static Uri buildEventUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
}
