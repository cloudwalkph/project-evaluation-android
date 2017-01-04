package com.cloudwalk.validate.validateapp.evaluationcompletescreen;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cloudwalk.validate.validateapp.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class EvaluationCompleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluation_complete);

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
