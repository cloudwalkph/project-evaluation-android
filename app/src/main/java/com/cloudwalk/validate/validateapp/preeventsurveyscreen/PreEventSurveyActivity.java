package com.cloudwalk.validate.validateapp.preeventsurveyscreen;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cloudwalk.validate.validateapp.QuestionScreen.QuestionAdapter;
import com.cloudwalk.validate.validateapp.QuestionScreen.QuestionFragment;
import com.cloudwalk.validate.validateapp.R;
import com.cloudwalk.validate.validateapp.evaluationcompletescreen.EvaluationCompleteActivity;
import com.cloudwalk.validate.validateapp.eventproperscreen.EventProperActivity;


import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class PreEventSurveyActivity extends AppCompatActivity {

    public QuestionAdapter mQuestionAdapter;
    public ViewPager mPager;
    @Bind(R.id.header_events_title) TextView mEventsTitle;
    @Bind(R.id.header_department) TextView mDepartmentTitle;
    @Bind(R.id.toolbar_container) AppBarLayout mEventToolbar;
    @Bind(R.id.progressBar) ProgressBar pBar;
    @Bind(R.id.viewpager) ViewPager vp_container;
    @Bind(R.id.question_max) TextView mMaximumQuestion;
    @Bind(R.id.question_min) TextView mMinimumQuestion;
    int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_event_survey);
        setTitle("");

        ButterKnife.bind(this);

        // toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        pBar.setProgress(0);
        mEventsTitle.setText(EventProperActivity.mCurrentEvent.getName());

        mQuestionAdapter = new QuestionAdapter(getSupportFragmentManager());

        mPager = (ViewPager)findViewById(R.id.viewpager);
        mPager.setAdapter(mQuestionAdapter);
        mMaximumQuestion.setText(String.valueOf(mPager.getAdapter().getCount()));

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
                int curPosition = mPager.getCurrentItem() + 1;
                int totalItems = mPager.getAdapter().getCount();
                float progress = (float) curPosition / totalItems;
                float pTotal = progress * 100;
                pBar.setProgress((int) pTotal);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        changeUi(QuestionFragment.mRatee.getDepartment());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    public void changeUi(String department){
        switch( department ){
            case "Accounting":
                mDepartmentTitle.setText("Accounting");
                mEventToolbar.setBackgroundResource(R.color.accountsColor);
                break;
            case "Accounts":
                mDepartmentTitle.setText("Accounts");
                mEventToolbar.setBackgroundResource(R.color.accountsColor);
                break;
            case "CMTUVA":
                mDepartmentTitle.setText("CMTUVA");
                mEventToolbar.setBackgroundResource(R.color.cmtuvaColor);
                break;
            case "Negotiator Assesment":
                mDepartmentTitle.setText("Negotiator's Assesment");
                mEventToolbar.setBackgroundResource(R.color.stpColor);
                break;
            case "Project Manager":
                mDepartmentTitle.setText("Project Manager's");
                mEventToolbar.setBackgroundResource(R.color.pmColor);
                break;
            case "Activations":
                mDepartmentTitle.setText("Activations");
                mEventToolbar.setBackgroundResource(R.color.actgColor);
                break;
            case "Setup":
                mDepartmentTitle.setText("Setup");
                mEventToolbar.setBackgroundResource(R.color.stpColor);
                break;
            case "CEO":
                mDepartmentTitle.setText("CEO");
                mEventToolbar.setBackgroundResource(R.color.ceoColor);
                break;
            case "Production":
                mDepartmentTitle.setText("Production");
                mEventToolbar.setBackgroundResource(R.color.prColor);
                break;
            case "Inventory":
                mDepartmentTitle.setText("Inventory");
                mEventToolbar.setBackgroundResource(R.color.invColor);
                break;
            case "Human Resources ":
                mDepartmentTitle.setText("Human Resources ");
                mEventToolbar.setBackgroundResource(R.color.hrColor);
                break;
        }
    }

    @OnClick(R.id.nxtBtn)
    public void nextPage(){
        int totalPage = vp_container.getAdapter().getCount();
        int page = getItem() + 1;
        if(page <= totalPage){
            mMinimumQuestion.setText(String.valueOf(page+1));
            vp_container.setCurrentItem(page, true);
            if(page == vp_container.getAdapter().getCount()){
                EvaluationCompleteActivity.completeLabel = "Pre Event Evaluation Completed";
                startActivity(new Intent(getApplicationContext(), EvaluationCompleteActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                finish();
            }
        }
    }

    @OnClick(R.id.prevBtn)
    public void prevPage(){
        int page = getItem() - 1;
        if(page >= 0){
            mMinimumQuestion.setText(String.valueOf(page+1));
            vp_container.setCurrentItem(page, true);
        }
    }

    private int getItem() {
        return vp_container.getCurrentItem();
    }

}
