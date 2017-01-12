package com.cloudwalk.validate.validateapp.eventproperscreen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.cloudwalk.validate.validateapp.App;
import com.cloudwalk.validate.validateapp.QuestionScreen.QuestionFragment;
import com.cloudwalk.validate.validateapp.R;
import com.cloudwalk.validate.validateapp.data.AppRepository;
import com.cloudwalk.validate.validateapp.data.local.models.Assignment;
import com.cloudwalk.validate.validateapp.data.local.models.Event;
import com.cloudwalk.validate.validateapp.data.local.models.Question;
import com.cloudwalk.validate.validateapp.eventpropersurveyscreen.EventProperSurveyActivity;
import com.cloudwalk.validate.validateapp.mainscreen.MainActivity;
import com.cloudwalk.validate.validateapp.posteventsurveyscreen.PostEventSurveyActivity;
import com.cloudwalk.validate.validateapp.preeventsurveyscreen.PreEventSurveyActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by nkmcheng on 04/01/2017.
 */

public class EventProperActivity extends AppCompatActivity implements EventProperContract.View {

    public static Event mCurrentEvent;
    public List<Question> questions;
    public LinearLayout mPreEventLayout;
    public LinearLayout mEventProperLayout;
    public LinearLayout mPostEventLayout;

    private EventProperContract.Presenter mPresenter;
    public Intent mEventIntent;

    @Inject
    AppRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_proper);
        setTitle(mCurrentEvent.getName());

        App.getAppComponent().inject(this);
        new EventProperPresenter(repository, this);

        questions = new ArrayList<Question>();

        mPreEventLayout = (LinearLayout) findViewById(R.id.ll_pre_event);
        mPreEventLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getQuestions("pre");
                mEventIntent = new Intent(getApplicationContext(), PreEventSurveyActivity.class);
            }
        });

        mEventProperLayout = (LinearLayout) findViewById(R.id.ll_event_proper);
        mEventProperLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getQuestions("eprop");
                mEventIntent = new Intent(getApplicationContext(), EventProperSurveyActivity.class);
            }
        });

        mPostEventLayout = (LinearLayout) findViewById(R.id.ll_post_event);
        mPostEventLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getQuestions("post");
                Intent intent = new Intent(getApplicationContext(), PostEventSurveyActivity.class);
            }
        });

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    public void setPresenter(EventProperPresenter presenter) {
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
    public void setPresenter(EventProperContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void getQuestions(String category) {
        int requested = 0;
        for (Assignment assignment : MainActivity.mAssignments) {

            if (EventProperActivity.mCurrentEvent.getId() != Integer.parseInt(assignment.getQevent())) {
                continue;
            }

            // Get the event
            try {
                if (requested == 0) {
                    mPresenter.getEmployeeById(Integer.parseInt(assignment.getQratee()));
                    requested = 1;
                }

                mPresenter.getQuestionById(Integer.parseInt(assignment.getQnum()), category);
            } catch (NumberFormatException e) {

            }
        }
    }

    @Override
    public void addQuestion(Question question) {
        questions.add(question);
    }

    @Override
    public void getQuestionsCompleted() {
        QuestionFragment.mQuestions = questions;
        startActivity(mEventIntent);
    }
}
