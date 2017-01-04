package com.cloudwalk.validate.validateapp.eventproperscreen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.cloudwalk.validate.validateapp.R;
import com.cloudwalk.validate.validateapp.data.local.models.Event;
import com.cloudwalk.validate.validateapp.eventpropersurveyscreen.EventProperSurveyActivity;
import com.cloudwalk.validate.validateapp.posteventsurveyscreen.PostEventSurveyActivity;
import com.cloudwalk.validate.validateapp.preeventsurveyscreen.PreEventSurveyActivity;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by nkmcheng on 04/01/2017.
 */

public class EventProperActivity extends AppCompatActivity {

    public static Event mCurrentEvent;
    public LinearLayout mPreEventLayout;
    public LinearLayout mEventProperLayout;
    public LinearLayout mPostEventLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_proper);
        setTitle(mCurrentEvent.getName());

        mPreEventLayout = (LinearLayout) findViewById(R.id.ll_pre_event);
        mPreEventLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PreEventSurveyActivity.class);
                startActivity(intent);
            }
        });

        mEventProperLayout = (LinearLayout) findViewById(R.id.ll_event_proper);
        mEventProperLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EventProperSurveyActivity.class);
                startActivity(intent);
            }
        });

        mPostEventLayout = (LinearLayout) findViewById(R.id.ll_post_event);
        mPostEventLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PostEventSurveyActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
