package com.austry.espressotest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etLogin)
    EditText etLogin;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.tvErrorText)
    TextView tvErrorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.btnLogin)
    void checkAuth() {
        String login = etLogin.getText().toString();
        String password = etPassword.getText().toString();

        if (login.equals("login") && password.equals("password")) {
            Intent innerActivityIntent = new Intent(getApplicationContext(), InnerActivity.class);
            startActivity(innerActivityIntent);
        } else {
            tvErrorText.setText("Wrong login/password");
        }
    }

}
