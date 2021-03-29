package com.app.ucp.presentation.createperfume;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import com.app.ucp.Constants;
import com.app.ucp.PerfumeHelper;
import com.app.ucp.R;
import com.app.ucp.model.FragranceFamily;
import com.app.ucp.model.Perfume;
import com.app.ucp.viewmodels.FragranceConcentrationViewModel;
import com.app.ucp.viewmodels.RetrieveCategoriesViewModel;
import com.app.ucp.viewmodels.RetrieveFragranceFamilyViewModel;
import com.app.ucp.viewmodels.RetrievePerfumesByCategoryViewModel;

import java.util.List;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragranceFamilyActivity extends AppCompatActivity {

    private PerfumeHelper perfumeHelper = new PerfumeHelper(this);
    private Perfume perfume;

    @BindView(R.id.priceRateEditText)
    EditText priceRateEditText;
    @BindView(R.id.categorySpinner)
    AppCompatSpinner categorySpinner;
    @BindView(R.id.perfumeSpinner)
    AppCompatSpinner perfumeSpinner;
    @BindView(R.id.descEditText)
    EditText descEditText;

    private RetrievePerfumesByCategoryViewModel retrievePerfumesByCategoryViewModel;
    private RetrieveCategoriesViewModel retrieveCategoriesViewModel;
    private RetrieveFragranceFamilyViewModel fragranceFamilyViewModel;
    private String selectedCategory;
    private String selectedPerfume;
    private FragranceFamily fragranceFamily;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragrance_family);
        ButterKnife.bind(this);

        String perfumeJson = getIntent().getExtras().getString(Constants.PERFUME);
        perfume = perfumeHelper.convertJsonToObj(perfumeJson);
        Toast.makeText(this, "Current Price rate: " + perfume.getPrice(), Toast.LENGTH_SHORT).show();
        priceRateEditText.setText(String.format(Locale.US, "%.2f", perfume.getPrice()));

        retrieveCategoriesViewModel = new ViewModelProvider(this).get(RetrieveCategoriesViewModel.class);
        retrievePerfumesByCategoryViewModel = new ViewModelProvider(FragranceFamilyActivity.this).get(RetrievePerfumesByCategoryViewModel.class);
        fragranceFamilyViewModel = new ViewModelProvider(this).get(RetrieveFragranceFamilyViewModel.class);

        retrieveCategoriesViewModel.retrieveCategories();
        retrieveCategoriesViewModel.getListCategoriesLiveData()
                .observe(this, this::setCategoriesSpinner);

        retrievePerfumesByCategoryViewModel.getListPerfumesLiveData()
                .observe(FragranceFamilyActivity.this, this::setPerfumesSpinner);

        fragranceFamilyViewModel.getFragranceFamilyLiveData()
                .observe(this, fragranceFamily -> {
                    this.fragranceFamily = fragranceFamily;
                    if (fragranceFamily != null) {
                        descEditText.setText(fragranceFamily.getDescription());
                        double priceRate = perfume.getPrice() + fragranceFamily.getPriceRate();
                        priceRateEditText.setText(String.format(Locale.US, "%.2f", priceRate));
                    } else {
                        descEditText.setText("");
                        priceRateEditText.setText(String.format(Locale.US, "%.2f", perfume.getPrice()));
                    }
                });
    }

    private void setCategoriesSpinner(List<String> categories) {
        ArrayAdapter<String> categoriesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item);
        categoriesAdapter.addAll(categories);
        categorySpinner.setAdapter(categoriesAdapter);
        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCategory = categories.get(position);
                retrievePerfumesByCategoryViewModel.retrievePerfumesByCategory(selectedCategory);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setPerfumesSpinner(List<String> perfumes) {
        ArrayAdapter<String> perfumesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item);
        perfumesAdapter.addAll(perfumes);
        perfumeSpinner.setAdapter(perfumesAdapter);
        perfumeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedPerfume = perfumes.get(position);
                fragranceFamilyViewModel.retrieveFragranceFamily(selectedCategory, selectedPerfume);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @OnClick(R.id.backBtn)
    public void onBackClicked() {
        onBackPressed();
    }

    @OnClick(R.id.nextBtn)
    public void onNextClicked() {
        perfume.setFragranceFamily(fragranceFamily);
        perfume.updatePrice(Double.parseDouble(priceRateEditText.getText().toString()));
        Intent intent = new Intent(this, BottleShapeActivity.class);
        intent.putExtra(Constants.PERFUME, perfumeHelper.convertObjToJson(perfume));
        startActivity(intent);
    }
}