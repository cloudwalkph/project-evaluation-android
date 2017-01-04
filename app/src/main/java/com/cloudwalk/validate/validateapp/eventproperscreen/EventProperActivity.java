package com.cloudwalk.validate.validateapp.eventproperscreen;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cloudwalk.validate.validateapp.R;
import com.cloudwalk.validate.validateapp.data.local.models.Event;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by nkmcheng on 04/01/2017.
 */

public class EventProperActivity extends AppCompatActivity {

    public static Event mCurrentEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_proper);
        setTitle(mCurrentEvent.getName());
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
