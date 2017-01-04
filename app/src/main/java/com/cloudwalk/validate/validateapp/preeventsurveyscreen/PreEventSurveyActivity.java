package com.cloudwalk.validate.validateapp.preeventsurveyscreen;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cloudwalk.validate.validateapp.R;
import com.cloudwalk.validate.validateapp.eventproperscreen.EventProperActivity;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class PreEventSurveyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_event_survey);
        setTitle(EventProperActivity.mCurrentEvent.getName());

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}