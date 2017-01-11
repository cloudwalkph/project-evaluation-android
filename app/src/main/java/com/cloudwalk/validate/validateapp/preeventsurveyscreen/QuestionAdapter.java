package com.cloudwalk.validate.validateapp.preeventsurveyscreen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by nkmcheng on 12/01/2017.
 */

public class QuestionAdapter extends FragmentPagerAdapter{

        private List<Fragment> fragments;

        public QuestionAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }
        @Override
        public Fragment getItem(int position) {
            return this.fragments.get(position);
        }

        @Override
        public int getCount() {
            return this.fragments.size();
        }
}
