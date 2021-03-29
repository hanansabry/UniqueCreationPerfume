package com.app.ucp.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.app.ucp.Constants;
import com.app.ucp.PerfumeHelper;
import com.app.ucp.R;
import com.app.ucp.presentation.admin.AdminControlActivity;
import com.app.ucp.presentation.admin.LoginActivity;
import com.app.ucp.presentation.createperfume.FragranceConcentrationActivity;
import com.app.ucp.presentation.createperfume.PerfumeDetailsActivity;
import com.app.ucp.presentation.newbie.NewBieActivity;
import com.app.ucp.viewmodels.PerfumeSearchViewModel;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private PerfumeHelper perfumeHelper = new PerfumeHelper(this);
    @BindView(R.id.phoneNumberEditText)
    EditText phoneNumberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.searchButton)
    public void onSearchClicked() {
        String phone = phoneNumberEditText.getText().toString();
        if (phone.isEmpty()) {
            Toast.makeText(this, "You must enter phone number..", Toast.LENGTH_SHORT).show();
        } else {
            PerfumeSearchViewModel perfumeSearchViewModel = new ViewModelProvider(this).get(PerfumeSearchViewModel.class);
            perfumeSearchViewModel.search(phone);
            perfumeSearchViewModel.getPerfumeRequestLiveData().observe(this, perfumeRequest -> {
                if (perfumeRequest != null) {
                    Intent intent = new Intent(MainActivity.this, PerfumeDetailsActivity.class);
                    intent.putExtra(Constants.PERFUME, perfumeHelper.convertObjToJson(perfumeRequest.getPerfume()));
                    intent.putExtra(Constants.SHOW_PAY, false);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Can't find results..", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @OnClick(R.id.loginBtn)
    public void onLoginClicked() {
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            startActivity(new Intent(this, AdminControlActivity.class));
        } else {
            startActivity(new Intent(this, LoginActivity.class));
        }
    }

    @OnClick(R.id.newbieCardView)
    public void onNewBieClicked() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(this, NewBieActivity.class));
    }

    @OnClick(R.id.expertCardView)
    public void onExpertClicked() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(this, FragranceConcentrationActivity.class));
    }
}