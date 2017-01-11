package com.cloudwalk.validate.validateapp.loginscreen;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cloudwalk.validate.validateapp.R;
import com.cloudwalk.validate.validateapp.eventproperscreen.EventProperActivity;
import com.cloudwalk.validate.validateapp.mainscreen.MainActivity;

import butterknife.Bind;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class LoginActivity extends AppCompatActivity
    implements LoginScreenContract.View {

    public Button mBtnSignIn;

    @Bind(R.id.email_text) EditText mEmail;
    @Bind(R.id.password_text) EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initSigninButton();

    }

    private void initSigninButton() {
        mBtnSignIn = (Button) findViewById(R.id.btn_log_in);
        mBtnSignIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                ProgressDialog pd = new ProgressDialog(LoginActivity.this);
                pd.setMessage("loading");
                pd.show();
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void loginComplete() {

    }

    @Override
    public void loginFailed() {

    }

    @Override
    public void setPresenter(LoginScreenContract.Presenter presenter) {

    }
}
