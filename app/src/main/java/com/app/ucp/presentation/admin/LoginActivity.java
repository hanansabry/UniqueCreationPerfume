package com.app.ucp.presentation.admin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.app.ucp.R;
import com.app.ucp.viewmodels.LoginViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.editTextEmail)
    EditText editTextEmail;
    @BindView(R.id.editTextPassword)
    EditText editTextPassword;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        loginViewModel.getSuccess().observe(this, success -> {
            if (success) {
                startActivity(new Intent(this, AdminControlActivity.class));
            } else {
                Toast.makeText(LoginActivity.this, "Invalid credentials..", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.backBtn)
    public void onBackClicked() {
        onBackPressed();
    }

    @OnClick(R.id.loginBtn)
    public void onLoginClicked() {
        if (editTextEmail.getText().toString().isEmpty() || editTextPassword.getText().toString().isEmpty()) {
            Toast.makeText(this, "You must enter email and password..", Toast.LENGTH_SHORT).show();
        } else {
            String email = editTextEmail.getText().toString();
            String password = editTextPassword.getText().toString();
            loginViewModel.login(email, password);
        }
    }

}