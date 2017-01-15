package com.cloudwalk.validate.validateapp.QuestionScreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.cloudwalk.validate.validateapp.App;
import com.cloudwalk.validate.validateapp.R;
import com.cloudwalk.validate.validateapp.data.AppRepository;
import com.cloudwalk.validate.validateapp.data.local.models.Answer;
import com.cloudwalk.validate.validateapp.data.local.models.Employee;
import com.cloudwalk.validate.validateapp.data.local.models.Question;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by alleoindong on 1/12/17.
 */

public class QuestionFragment extends Fragment implements QuestionContract.View {
    private int mPosition;
    private static final String POSITION_MESSAGE = "position";
    public static List<Question> mQuestions;
    public static List<Answer> mAnswers;
    public static Employee mRatee;
    private QuestionContract.Presenter mPresenter;

    public LinearLayout ll;

    @Inject
    AppRepository repository;

    @Bind(R.id.question_details) TextView mQuestion;

    public static final QuestionFragment newInstance(int position)
    {
//        QuestionFragment.mQuestions = new ArrayList<Question>();

        QuestionFragment f = new QuestionFragment();
        Bundle bdl = new Bundle();
        bdl.putInt(POSITION_MESSAGE, position);
        f.setArguments(bdl);

        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        App.getAppComponent().inject(this);
        new QuestionPresenter(repository, this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.mPosition = getArguments().getInt(POSITION_MESSAGE);
        View v = inflater.inflate(R.layout.survey_fragment_layout, container, false);

        ButterKnife.bind(this, v);
        ll = (LinearLayout)v.findViewById(R.id.linear_layout_answer);

        if (QuestionFragment.mQuestions.size() > 0) {
            Question question = QuestionFragment.mQuestions.get(mPosition);
            mQuestion.setText(question.getQname());

            // get the list of answers
            mPresenter.getAnswerByQuestionId((int) question.getId());
        } else {
            mQuestion.setText("Question collection is empty");
        }

        return v;
    }

    @Override
    public void getAnswer(List<Answer> answers) {
        mAnswers = answers;

        RadioGroup mRadioGroup = new RadioGroup(this.getContext());
        mRadioGroup.setOrientation(RadioGroup.VERTICAL);

        mRadioGroup.setLayoutParams(ll.getLayoutParams());

        for (Answer answer : mAnswers) {
            RadioButton rb = new RadioButton(this.getContext());

            rb.setText(answer.getContent());
            rb.setTextSize(18);
            rb.setPadding(5, 10, 5, 10);
            mRadioGroup.addView(rb);
        }
        ll.addView(mRadioGroup);
    }

    @Override
    public void setPresenter(QuestionContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
