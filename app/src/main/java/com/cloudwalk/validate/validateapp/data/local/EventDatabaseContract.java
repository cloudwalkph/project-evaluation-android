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
        public static final String COLUMN_EVENT_DATE = "event_date";
        public static final String COLUMN_EVENT_AREA = "event_area";
        public static final String COLUMN_POST_DATE = "post_date";
        public static final String COLUMN_PRE_DATE = "pre_date";
        public static final String COLUMN_EVENT_TIME = "event_time";
        public static final String COLUMN_EVALUATOR = "evaluator";
        public static final String COLUMN_TLS = "tls";
        public static final String COLUMN_NEGO = "negotiator";
        public static final String COLUMN_DATE_CREATED = "date_created";

        public static String getEventCreateQuery() {
            return "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " LONG NOT NULL PRIMARY KEY, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_JONUM + " TEXT, " +
                    COLUMN_EVENT_DATE + " TEXT, " +
                    COLUMN_EVENT_AREA + " TEXT, " +
                    COLUMN_POST_DATE + " TEXT, " +
                    COLUMN_PRE_DATE + " TEXT, " +
                    COLUMN_EVENT_TIME + " TEXT, " +
                    COLUMN_EVALUATOR + " TEXT, " +
                    COLUMN_TLS + " TEXT, " +
                    COLUMN_NEGO + " TEXT, " +
                    COLUMN_DATE_CREATED + " TEXT "+ ");";
        }

        public static String getEventDeleteQuery() {
            return "DROP TABLE IF EXISTS " + TABLE_NAME;
        }


        public static Uri buildEventUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
}
