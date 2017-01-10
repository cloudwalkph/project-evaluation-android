package com.cloudwalk.validate.validateapp.mainscreen;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cloudwalk.validate.validateapp.R;
import com.cloudwalk.validate.validateapp.data.local.models.Event;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    ArrayList<Event> events;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_event);
        setTitle("Choose an Event");

        RecyclerView mRvEvents = (RecyclerView) findViewById(R.id.rv_events);

        // Initialize events
//        events = Event.createEventList();
//        EventsAdapter adapter = new EventsAdapter(this, events);
//        mRvEvents.setAdapter(adapter);
//        mRvEvents.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
