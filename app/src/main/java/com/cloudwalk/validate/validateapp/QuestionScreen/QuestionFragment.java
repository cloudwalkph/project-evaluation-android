package com.cloudwalk.validate.validateapp.QuestionScreen;

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
import com.cloudwalk.validate.validateapp.data.local.models.Question;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by alleoindong on 1/12/17.
 */

public class QuestionFragment extends Fragment {
    private int mPosition;
    private static final String POSITION_MESSAGE = "position";
    public static List<Question> mQuestions;

    @Bind(R.id.question_details) TextView mQuestion;

    public static final QuestionFragment newInstance(int postion)
    {
        QuestionFragment f = new QuestionFragment();
        Bundle bdl = new Bundle();
        bdl.putInt(POSITION_MESSAGE, postion);
        f.setArguments(bdl);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.mPosition = getArguments().getInt(POSITION_MESSAGE);
        View v = inflater.inflate(R.layout.survey_fragment_layout, container, false);

        ButterKnife.bind(v);
        LinearLayout ll = (LinearLayout)v.findViewById(R.id.linear_layout_answer);

        Question question = mQuestions.get(mPosition);
        mQuestion.setText(question.getQname());

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
