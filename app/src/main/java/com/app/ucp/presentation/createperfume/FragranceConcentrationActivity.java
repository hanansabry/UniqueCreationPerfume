package com.app.ucp.presentation.createperfume;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.app.ucp.Constants;
import com.app.ucp.PerfumeHelper;
import com.app.ucp.R;
import com.app.ucp.model.FragranceConcentration;
import com.app.ucp.model.Perfume;
import com.app.ucp.viewmodels.FragranceConcentrationViewModel;

import java.util.List;
import java.util.UUID;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragranceConcentrationActivity extends AppCompatActivity {

    private List<FragranceConcentration> fragranceConcentrationList;

    @BindView(R.id.fragranceRadioGroup)
    RadioGroup fragranceRadioGroup;
    @BindView(R.id.purePerfumeEditText)
    EditText purePerfumeEditText;
    @BindView(R.id.remainUpEditText)
    EditText remainUpEditText;
    @BindView(R.id.priceRateEditText)
    EditText priceRateEditText;
    private String jsonPerfume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragrance_concentration);
        ButterKnife.bind(this);

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading..");
        progressDialog.show();

        FragranceConcentrationViewModel fragranceConcentrationViewModel
                = new ViewModelProvider(this).get(FragranceConcentrationViewModel.class);

        fragranceConcentrationViewModel.retrieveFragranceConcentration();
        fragranceConcentrationViewModel.getListFragranceConcentrationsLiveData()
                .observe(this, fragranceConcentrations -> {
                    progressDialog.hide();
                    fragranceConcentrationList = fragranceConcentrations;
                });

        fragranceRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            FragranceConcentration fragrance = null;
            switch (checkedId) {
                case R.id.perfumeRadioButton :
                    fragrance = fragranceConcentrationList.get(0);
                    purePerfumeEditText.setText(fragrance.getPurePerfume());
                    remainUpEditText.setText(String.valueOf(fragrance.getRemainUpTo()));
                    priceRateEditText.setText(String.valueOf(fragrance.getPriceRate()));
                    break;
                case R.id.eauDePerfumeRadioButton :
                    fragrance = fragranceConcentrationList.get(1);
                    purePerfumeEditText.setText(fragrance.getPurePerfume());
                    remainUpEditText.setText(String.valueOf(fragrance.getRemainUpTo()));
                    priceRateEditText.setText(String.valueOf(fragrance.getPriceRate()));
                    break;
                case R.id.eauDeToiletRadioButton :
                    fragrance = fragranceConcentrationList.get(2);
                    purePerfumeEditText.setText(fragrance.getPurePerfume());
                    remainUpEditText.setText(String.valueOf(fragrance.getRemainUpTo()));
                    priceRateEditText.setText(String.valueOf(fragrance.getPriceRate()));
                    break;
                case R.id.eauDeCologneRadioButton :
                    fragrance = fragranceConcentrationList.get(3);
                    purePerfumeEditText.setText(fragrance.getPurePerfume());
                    remainUpEditText.setText(String.valueOf(fragrance.getRemainUpTo()));
                    priceRateEditText.setText(String.valueOf(fragrance.getPriceRate()));
                    break;
                case R.id.eauDeFraicheRadioButton :
                    fragrance = fragranceConcentrationList.get(4);
                    purePerfumeEditText.setText(fragrance.getPurePerfume());
                    remainUpEditText.setText(String.valueOf(fragrance.getRemainUpTo()));
                    priceRateEditText.setText(String.valueOf(fragrance.getPriceRate()));
                    break;
            }
            jsonPerfume = updatePerfume(fragrance);
        });
    }

    private String updatePerfume(FragranceConcentration fragrance) {
        Perfume perfume = new Perfume();
        perfume.setId(UUID.randomUUID().toString());
        perfume.setFragranceConcentration(fragrance);
        perfume.updatePrice(fragrance.getPriceRate());
        PerfumeHelper perfumeHelper = new PerfumeHelper(this);
        return perfumeHelper.convertObjToJson(perfume);
    }

    @OnClick(R.id.nextBtn)
    public void onNextClicked() {
        if (fragranceRadioGroup.getCheckedRadioButtonId() != -1) {
            Intent intent = new Intent(this, NoteConcentrationActivity.class);
            intent.putExtra(Constants.PERFUME, jsonPerfume);
            startActivity(intent);
        } else {
            Toast.makeText(this, "You must make a selection", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.backBtn)
    public void onBackClicked() {
        onBackPressed();
    }
}