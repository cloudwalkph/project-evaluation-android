package com.cloudwalk.validate.validateapp.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nkmcheng on 05/01/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "validate.db";
    public static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        sqLiteDatabase.execSQL(DatabaseContract.Post.getPostCreateQuery());
        sqLiteDatabase.execSQL(EmployeeDatabaseContract.Employee.getEmployeeCreateQuery());
        sqLiteDatabase.execSQL(EventDatabaseContract.Event.getEventCreateQuery());
        sqLiteDatabase.execSQL(QuestionDatabaseContract.Question.getQuestionCreateQuery());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(EmployeeDatabaseContract.Employee.getEmployeeDeleteQuery());
        sqLiteDatabase.execSQL(EventDatabaseContract.Event.getEventDeleteQuery());
        sqLiteDatabase.execSQL(QuestionDatabaseContract.Question.getQuestionDeleteQuery());
        onCreate(sqLiteDatabase);
    }
}
