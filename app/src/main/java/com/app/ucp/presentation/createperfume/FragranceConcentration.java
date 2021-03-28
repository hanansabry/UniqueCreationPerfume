package com.app.ucp.presentation.createperfume;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.Intent;
import android.os.Bundle;

import com.app.ucp.R;

public class FragranceConcentration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragrance_concentration);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.nextBtn)
    public void onNextClicked() {
        startActivity(new Intent(this, NoteConcentrationActivity.class));
    }

    @OnClick(R.id.backBtn)
    public void onBackClicked() {
        onBackPressed();
    }
}