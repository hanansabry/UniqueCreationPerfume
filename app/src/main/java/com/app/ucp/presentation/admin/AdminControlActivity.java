package com.app.ucp.presentation.admin;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.Intent;
import android.os.Bundle;

import com.app.ucp.R;
import com.app.ucp.presentation.createperfume.FragranceConcentration;

public class AdminControlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_control);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.backBtn)
    public void onBackClicked() {
        onBackPressed();
    }

    @OnClick(R.id.createPerfumeCardView)
    public void onCreatePerfumeClicked() {
        startActivity(new Intent(this, FragranceConcentration.class));
    }

    @OnClick(R.id.displayRequestCardView)
    public void onDisplayRequestsClicked() {
        startActivity(new Intent(this, DisplayRequestsActivity.class));
    }

    @OnClick(R.id.addFragranceCardView)
    public void onAddFragranceClicked() {
        startActivity(new Intent(this, AddFragranceActivity.class));
    }

    @OnClick(R.id.addBottlesCardView)
    public void onAddBottlesClicked() {
        startActivity(new Intent(this, AddBottlesActivity.class));
    }
}