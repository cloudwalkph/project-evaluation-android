package com.cloudwalk.validate.validateapp.eventproperscreen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

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
import com.cloudwalk.validate.validateapp.preeventsurveyscreen.QuestionAdapter;

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

    @Inject
    AppRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_proper);
        setTitle(mCurrentEvent.getName());

        new EventProperPresenter(repository, this);

        questions = new ArrayList<Question>();

        mPreEventLayout = (LinearLayout) findViewById(R.id.ll_pre_event);
        mPreEventLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getQuestions("pre");
                Intent intent = new Intent(getApplicationContext(), PreEventSurveyActivity.class);
                startActivity(intent);
            }
        });

        mEventProperLayout = (LinearLayout) findViewById(R.id.ll_event_proper);
        mEventProperLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getQuestions("eprop");
                Intent intent = new Intent(getApplicationContext(), EventProperSurveyActivity.class);
                startActivity(intent);
            }
        });

        mPostEventLayout = (LinearLayout) findViewById(R.id.ll_post_event);
        mPostEventLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getQuestions("post");
                Intent intent = new Intent(getApplicationContext(), PostEventSurveyActivity.class);
                startActivity(intent);
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
        for (Assignment assignment : MainActivity.mAssignments) {
            Log.i("MAINSCREEN ASSIGNMENT", assignment.getQevent().toString());

            // Get the event
            mPresenter.getQuestionById(Integer.parseInt(assignment.getQevent()), category);
        }
    }

    @Override
    public void addQuestion(Question question) {
        Log.i("Question", question.getQname().toString());
        questions.add(question);
    }

    @Override
    public void getQuestionsCompleted() {
        QuestionFragment.mQuestions = questions;
    }
}
