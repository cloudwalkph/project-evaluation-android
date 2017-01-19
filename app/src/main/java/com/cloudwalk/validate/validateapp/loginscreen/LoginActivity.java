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
import android.widget.Toast;

import com.cloudwalk.validate.validateapp.App;
import com.cloudwalk.validate.validateapp.R;
import com.cloudwalk.validate.validateapp.data.AppRepository;
import com.cloudwalk.validate.validateapp.eventproperscreen.EventProperActivity;
import com.cloudwalk.validate.validateapp.mainscreen.MainActivity;

import javax.inject.Inject;

import butterknife.Bind;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class LoginActivity extends AppCompatActivity
    implements LoginScreenContract.View {

    public Button mBtnSignIn;
    public EditText mEmail;
    public EditText mPassword;

    public ProgressDialog pd;

    @Inject
    AppRepository repository;

    public LoginScreenContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        App.getAppComponent().inject(this);
        new LoginScreenPresenter(repository, this);

        pd = new ProgressDialog(LoginActivity.this);
        pd.setCancelable(false);
        initSigninButton();
    }

    private void initSigninButton() {
        mEmail = (EditText) findViewById(R.id.email_text);
        mPassword = (EditText) findViewById(R.id.password_text);

        mBtnSignIn = (Button) findViewById(R.id.btn_log_in);
        mBtnSignIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();

                pd.setMessage("loading");
                pd.show();

                Log.i("Login", email);
                Log.i("Login", password);

                mPresenter.attemptLogin(email, password);
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void loginComplete() {
        pd.dismiss();

        Log.i("Login", String.valueOf(LoginScreenPresenter.mCurrentEmployee.getId()));

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        ProgressDialog pd = new ProgressDialog(LoginActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void loginFailed() {
        pd.hide();
        pd.dismiss();
        Toast.makeText(this, "Invalid username/password", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(LoginScreenContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
