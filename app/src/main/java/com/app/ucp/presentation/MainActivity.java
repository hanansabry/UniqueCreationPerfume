package com.app.ucp.presentation;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.Intent;
import android.os.Bundle;

import com.app.ucp.R;
import com.app.ucp.presentation.admin.LoginActivity;
import com.app.ucp.presentation.createperfume.FragranceConcentration;
import com.app.ucp.presentation.newbie.NewBieActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.loginBtn)
    public void onLoginClicked() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    @OnClick(R.id.newbieCardView)
    public void onNewBieClicked() {
        startActivity(new Intent(this, NewBieActivity.class));
    }

    @OnClick(R.id.expertCardView)
    public void onExpertClicked() {
        startActivity(new Intent(this, FragranceConcentration.class));
    }
}