package com.cloudwalk.validate.validateapp.mainscreen;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.cloudwalk.validate.validateapp.App;
import com.cloudwalk.validate.validateapp.R;
import com.cloudwalk.validate.validateapp.data.AppRepository;
import com.cloudwalk.validate.validateapp.data.local.models.Assignment;
import com.cloudwalk.validate.validateapp.data.local.models.Event;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity implements MainScreenContract.View {

    List<Event> eventList;
    private RecyclerView.LayoutManager mLayoutManager;
    private MainScreenContract.Presenter mPresenter;

    @Inject
    AppRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_event);
        setTitle("Choose an Event");

        //Inject dependency
        App.getAppComponent().inject(this);
        new MainScreenPresenter(repository, this);

        RecyclerView mRvEvents = (RecyclerView) findViewById(R.id.rv_events);

        // Initialize events
        eventList = new ArrayList<Event>();

        EventsAdapter adapter = new EventsAdapter(this, eventList);
        mRvEvents.setAdapter(adapter);
        mRvEvents.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.logout:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void setPresenter(MainScreenContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }

    @Override
    public void getAssignments(List<Assignment> assignments) {
        for (Assignment assignment : assignments) {
            Log.i("MAINSCREEN ASSIGNMENT", assignment.getQevent().toString());

            // Get the event
            mPresenter.getEventById(Integer.parseInt(assignment.getQevent()));
        }
    }

    @Override
    public void getEvents(Event event) {
        Log.i("MAINSCREEN EVENT", event.getName());
        eventList.add(event);
    }
}
