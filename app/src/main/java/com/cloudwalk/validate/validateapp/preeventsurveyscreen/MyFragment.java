package com.cloudwalk.validate.validateapp.preeventsurveyscreen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.cloudwalk.validate.validateapp.R;
import com.cloudwalk.validate.validateapp.data.local.models.Answer;

import java.util.List;

/**
 * Created by nkmcheng on 11/01/2017.
 */

public class MyFragment extends Fragment {
    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";

    public static final MyFragment newInstance(String message)
    {
        MyFragment f = new MyFragment();
        Bundle bdl = new Bundle(1);
        bdl.putString(EXTRA_MESSAGE, message);
        f.setArguments(bdl);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        String message = getArguments().getString(EXTRA_MESSAGE);
        View v = inflater.inflate(R.layout.survey_fragment_layout, container, false);

        TextView messageTextView = (TextView)v.findViewById(R.id.question_details);
        LinearLayout ll = (LinearLayout)v.findViewById(R.id.linear_layout_answer);

        List<Answer> answerList;

        messageTextView.setText(message);

        for (int i = 0; i < 5; i++) {

            RadioButton rb = new RadioButton(v.getContext());
            rb.setText("Details explained through Gantt Chart");
            rb.setTextSize(18);
            rb.setPadding(5, 10, 5, 10);
            ll.addView(rb);
        }

        return v;
    }
}
