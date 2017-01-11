package com.cloudwalk.validate.validateapp.preeventsurveyscreen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cloudwalk.validate.validateapp.QuestionScreen.QuestionFragment;

import java.util.List;

/**
 * Created by nkmcheng on 12/01/2017.
 */

public class QuestionAdapter extends FragmentPagerAdapter {

        public QuestionAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return QuestionFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return QuestionFragment.mQuestions.size();
        }
}
