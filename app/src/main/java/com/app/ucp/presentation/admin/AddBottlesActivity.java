package com.app.ucp.presentation.admin;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.os.Bundle;
import android.widget.Toast;

import com.app.ucp.R;

public class AddBottlesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bottles);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.backBtn)
    public void onBackClicked() {
        onBackPressed();
    }

    @OnClick(R.id.saveBtn)
    public void onSaveClicked() {
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
    }
}