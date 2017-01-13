package com.cloudwalk.validate.validateapp.data.local;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;
import android.support.annotation.NonNull;

/**
 * Created by nkmcheng on 09/01/2017.
 */

public class AnswerDatabaseContract {

    public static final String CONTENT_AUTHORITY = "com.cloudwalk.validate.validateapp";
    public static final String PATH_ANSWER = "answer";

    public static abstract class Answer implements BaseColumns {
        @NonNull
        public static final String CONTENT_URI_STRING = "content://" + CONTENT_AUTHORITY + "/" + PATH_ANSWER;
        public static final Uri CONTENT_URI = Uri.parse(CONTENT_URI_STRING);

        public static final String CONTENT_USER_TYPE = "vnd.android.cursor.dir/" + CONTENT_AUTHORITY + "/" + PATH_ANSWER;
        public static final String CONTENT_USER_ITEM_TYPE = "vnd.android.cursor.item/" + CONTENT_AUTHORITY + "/" + PATH_ANSWER;

        public static final String TABLE_NAME = "answers";

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_CONTENT = "content";
        public static final String COLUMN_QNUM = "question_id";

        public static String getAnswerCreateQuery() {
            return "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " LONG NOT NULL PRIMARY KEY, " +
                    COLUMN_CONTENT + " TEXT, " +
                    COLUMN_QNUM + " LONG" + ");";
        }

        public static String getAnswerDeleteQuery() {
            return "DROP TABLE IF EXISTS " + TABLE_NAME;
        }


        public static Uri buildAnswerUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

}
