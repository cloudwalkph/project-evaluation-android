package com.cloudwalk.validate.validateapp.data.local;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;
import android.support.annotation.NonNull;

/**
 * Created by nkmcheng on 10/01/2017.
 */

public class NegotiatorDatabaseContract {

    public static final String CONTENT_AUTHORITY = "com.cloudwalk.validate.validateapp";
    public static final String PATH_TEAM_LEADER = "negotiator";

    public static abstract class Negotiator implements BaseColumns {
        @NonNull
        public static final String CONTENT_URI_STRING = "content://" + CONTENT_AUTHORITY + "/" + PATH_TEAM_LEADER;
        public static final Uri CONTENT_URI = Uri.parse(CONTENT_URI_STRING);

        public static final String CONTENT_USER_TYPE = "vnd.android.cursor.dir/" + CONTENT_AUTHORITY + "/" + PATH_TEAM_LEADER;
        public static final String CONTENT_USER_ITEM_TYPE = "vnd.android.cursor.item/" + CONTENT_AUTHORITY + "/" + PATH_TEAM_LEADER;

        public static final String TABLE_NAME = "negotiators";

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_FNAME = "fname";
        public static final String COLUMN_LNAME = "lname";
        public static final String COLUMN_EMAIL = "email";

        public static String getNegotiatorCreateQuery() {
            return "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " LONG NOT NULL PRIMARY KEY, " +
                    COLUMN_FNAME + " TEXT NOT NULL , " +
                    COLUMN_LNAME + " TEXT NOT NULL, " +
                    COLUMN_EMAIL + " TEXT NOT NULL" + ");";
        }

        public static String getNegotiatorDeleteQuery() {
            return "DROP TABLE IF EXISTS " + TABLE_NAME;
        }


        public static Uri buildNegotiatorUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
}
