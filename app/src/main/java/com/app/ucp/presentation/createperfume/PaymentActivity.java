package com.app.ucp.presentation.createperfume;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.ucp.Constants;
import com.app.ucp.PerfumeHelper;
import com.app.ucp.R;
import com.app.ucp.model.Perfume;
import com.app.ucp.model.PerfumeRequest;
import com.app.ucp.presentation.MainActivity;
import com.app.ucp.viewmodels.AddPerfumeViewModel;

import java.util.UUID;

public class PaymentActivity extends AppCompatActivity {

    @BindView(R.id.phoneNumberLabel)
    TextView phoneNumberLabel;
    @BindView(R.id.phoneNumberEditText)
    EditText phoneNumberEditText;
    private AddPerfumeViewModel addPerfumeViewModel;
    private PerfumeHelper perfumeHelper = new PerfumeHelper(this);
    private Perfume perfume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        ButterKnife.bind(this);

        String perfumeJson = getIntent().getExtras().getString(Constants.PERFUME);
        perfume = perfumeHelper.convertJsonToObj(perfumeJson);

        addPerfumeViewModel = new ViewModelProvider(this).get(AddPerfumeViewModel.class);
        if (addPerfumeViewModel.isAdmin()) {
            phoneNumberLabel.setVisibility(View.GONE);
            phoneNumberEditText.setVisibility(View.GONE);
        } else {
            phoneNumberLabel.setVisibility(View.VISIBLE);
            phoneNumberEditText.setVisibility(View.VISIBLE);
        }

        addPerfumeViewModel.getSuccess().observe(this, success -> {
            if (success) {
                Toast.makeText(this, "Perfume is added successfully", Toast.LENGTH_SHORT).show();
                finish();
                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Something wrong is happened.. Please try again", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.backBtn)
    public void onBackClicked() {
        onBackPressed();
    }

    @OnClick(R.id.finishBtn)
    public void onFinishClicked() {
        if (phoneNumberEditText.getText().toString().isEmpty() && !addPerfumeViewModel.isAdmin()) {
            Toast.makeText(this, "You must enter phone number..", Toast.LENGTH_SHORT).show();
        } else {
            PerfumeRequest perfumeRequest = new PerfumeRequest();
            perfumeRequest.setId(UUID.randomUUID().toString());
            perfumeRequest.setPerfume(perfume);
            perfumeRequest.setPhoneNumber(phoneNumberEditText.getText().toString());

            addPerfumeViewModel.addPerfume(perfumeRequest);
        }
    }
}