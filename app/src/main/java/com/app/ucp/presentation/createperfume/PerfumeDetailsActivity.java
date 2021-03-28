package com.app.ucp.presentation.createperfume;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.Intent;
import android.os.Bundle;

import com.app.ucp.R;

public class PerfumeDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfume_details);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.backBtn)
    public void onBackClicked() {
        onBackPressed();
    }

    @OnClick(R.id.payBtn)
    public void onPayClicked() {
        startActivity(new Intent(this, PaymentActivity.class));
    }
}