package com.cloudwalk.validate.validateapp.posteventsurveyscreen;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cloudwalk.validate.validateapp.QuestionScreen.QuestionAdapter;
import com.cloudwalk.validate.validateapp.QuestionScreen.QuestionFragment;
import com.cloudwalk.validate.validateapp.R;
import com.cloudwalk.validate.validateapp.eventproperscreen.EventProperActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class PostEventSurveyActivity extends AppCompatActivity {

    public QuestionAdapter mQuestionAdapter;
    public ViewPager mPager;
    @Bind(R.id.header_events_title) TextView mEventsTitle;
    @Bind(R.id.header_department) TextView mDepartmentTitle;
    @Bind(R.id.toolbar_container) AppBarLayout mEventToolbar;
    @Bind(R.id.progressBar) ProgressBar pBar;
    int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_event_survey);
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
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
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
}
