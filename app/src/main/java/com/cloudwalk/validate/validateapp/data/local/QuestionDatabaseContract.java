package com.cloudwalk.validate.validateapp.data.local;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;
import android.support.annotation.NonNull;

/**
 * Created by nkmcheng on 09/01/2017.
 */

public class QuestionDatabaseContract {

    public static final String CONTENT_AUTHORITY = "com.cloudwalk.validate.validateapp";
    public static final String PATH_QUESTION = "question";

    public static abstract class Question implements BaseColumns {
        @NonNull
        public static final String CONTENT_URI_STRING = "content://" + CONTENT_AUTHORITY + "/" + PATH_QUESTION;
        public static final Uri CONTENT_URI = Uri.parse(CONTENT_URI_STRING);

        public static final String CONTENT_USER_TYPE = "vnd.android.cursor.dir/" + CONTENT_AUTHORITY + "/" + PATH_QUESTION;
        public static final String CONTENT_USER_ITEM_TYPE = "vnd.android.cursor.item/" + CONTENT_AUTHORITY + "/" + PATH_QUESTION;

        public static final String TABLE_NAME = "questions";

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_QNAME = "qname";
        public static final String COLUMN_QDEPT = "qdept";
        public static final String COLUMN_QCAT = "qcat";
        public static final String COLUMN_QTYPE = "qtype";
        public static final String COLUMN_QSUB = "qsub";

        public static String getQuestionCreateQuery() {
            return "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " LONG NOT NULL PRIMARY KEY, " +
                    COLUMN_QNAME + " TEXT NOT NULL , " +
                    COLUMN_QDEPT + " TEXT NOT NULL, " +
                    COLUMN_QCAT + " TEXT NOT NULL, " +
                    COLUMN_QTYPE + " TEXT NOT NULL, " +
                    COLUMN_QSUB + " TEXT NOT NULL" + ");";
        }

        public static String getQuestionDeleteQuery() {
            return "DROP TABLE IF EXISTS " + TABLE_NAME;
        }


        public static Uri buildQuestionUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

}
