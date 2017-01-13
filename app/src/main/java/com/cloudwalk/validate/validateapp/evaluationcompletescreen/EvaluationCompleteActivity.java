package com.cloudwalk.validate.validateapp.evaluationcompletescreen;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.cloudwalk.validate.validateapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class EvaluationCompleteActivity extends AppCompatActivity {

    public static String completeLabel;
    @Bind(R.id.label_finish) TextView mEvaluationCompleteLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluation_complete);

        ButterKnife.bind(this);

        mEvaluationCompleteLabel.setText(completeLabel);

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
