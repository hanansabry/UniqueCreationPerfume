package com.app.ucp.presentation.createperfume;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.Intent;
import android.os.Bundle;

import com.app.ucp.R;

public class FragranceFamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragrance_family);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.backBtn)
    public void onBackClicked() {
        onBackPressed();
    }

    @OnClick(R.id.nextBtn)
    public void onNextClicked() {
        startActivity(new Intent(this, BottleShapeActivity.class));
    }
}