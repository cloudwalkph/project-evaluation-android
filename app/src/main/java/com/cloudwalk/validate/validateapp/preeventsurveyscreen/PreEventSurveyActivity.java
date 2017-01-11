package com.cloudwalk.validate.validateapp.preeventsurveyscreen;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cloudwalk.validate.validateapp.R;
import com.cloudwalk.validate.validateapp.data.local.models.Event;
import com.cloudwalk.validate.validateapp.loginscreen.LoginScreenPresenter;


import butterknife.Bind;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class PreEventSurveyActivity extends AppCompatActivity {

    public QuestionAdapter mQuestionAdapter;
    public ViewPager mPager;
    @Bind(R.id.header_events_title) TextView mEventsTitle;
    @Bind(R.id.header_department) TextView mDepartmentTitle;
    @Bind(R.id.toolbar_container) AppBarLayout mEventToolbar;
    @Bind(R.id.progressBar) ProgressBar pBar;
    int currentPage;

    public static Event mCurrentEvent;

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
        mEventsTitle.setText(mCurrentEvent.getName());

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

        changeUi(LoginScreenPresenter.mCurrentEmployee.getDepartment());

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

    private List<Fragment> getFragments(){
        List<Fragment> fList = new ArrayList<Fragment>();

        fList.add(MyFragment.newInstance("Pre Event"));
        fList.add(MyFragment.newInstance("Fragment 2"));
        fList.add(MyFragment.newInstance("Fragment 3"));

        return fList;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    public void changeUi(String department){
        switch( department ){
            case "Account Executive":
                mDepartmentTitle.setText("Account Executive");
                mEventToolbar.setBackgroundResource(R.color.accountsColor);
                break;
            case "Operations":
                mDepartmentTitle.setText("Operations");
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
            case "Team Leader Rating":
                mDepartmentTitle.setText("Team Leader's Rating");
                mEventToolbar.setBackgroundResource(R.color.stpColor);
                break;
            case "Setup":
                mDepartmentTitle.setText("Setup");
                mEventToolbar.setBackgroundResource(R.color.stpColor);
                break;
            case "Setup Leader Assesment":
                mDepartmentTitle.setText("Setup Leader Assesment");
                mEventToolbar.setBackgroundResource(R.color.stpColor);
                break;
            case "Production":
                mDepartmentTitle.setText("Production");
                mEventToolbar.setBackgroundResource(R.color.prColor);
                break;
            case "Inventory":
                mDepartmentTitle.setText("Inventory");
                mEventToolbar.setBackgroundResource(R.color.invColor);
                break;
            case "Human Resource Department":
                mDepartmentTitle.setText("Human Resource Department");
                mEventToolbar.setBackgroundResource(R.color.hrColor);
                break;
        }
    }

}
