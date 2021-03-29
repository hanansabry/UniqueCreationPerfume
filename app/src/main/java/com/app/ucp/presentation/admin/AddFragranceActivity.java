package com.app.ucp.presentation.admin;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import com.app.ucp.R;
import com.app.ucp.model.FragranceFamily;
import com.app.ucp.viewmodels.AddFragranceFamilyViewModel;
import com.app.ucp.viewmodels.RetrieveCategoriesViewModel;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddFragranceActivity extends AppCompatActivity {

    @BindView(R.id.categorySpinner)
    AppCompatSpinner categorySpinner;
    @BindView(R.id.perfumeEditText)
    EditText perfumeEditText;
    @BindView(R.id.priceRateEditText)
    EditText priceRateEditText;
    @BindView(R.id.descEditText)
    EditText descEditText;

    private String selectedCategory;
    private AddFragranceFamilyViewModel addFragranceFamilyViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fragrance);
        ButterKnife.bind(this);

        RetrieveCategoriesViewModel retrieveCategoriesViewModel = new ViewModelProvider(this).get(RetrieveCategoriesViewModel.class);
        retrieveCategoriesViewModel.retrieveCategories();
        retrieveCategoriesViewModel.getListCategoriesLiveData()
                .observe(this, this::setCategoriesSpinner);

        addFragranceFamilyViewModel = new ViewModelProvider(this).get(AddFragranceFamilyViewModel.class);
        addFragranceFamilyViewModel.getSuccess().observe(this, success -> {
            if (success) {
                Toast.makeText(this, "Fragrance family is added successfully..", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Something wrong is happened, Please try again..", Toast.LENGTH_SHORT).show();
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

    @OnClick(R.id.saveBtn)
    public void onSaveClicked() {
        if (selectedCategory == null
                || perfumeEditText.getText().toString().isEmpty()
                || priceRateEditText.getText().toString().isEmpty()
                || descEditText.getText().toString().isEmpty()) {
            Toast.makeText(this, "You must enter all values..", Toast.LENGTH_SHORT).show();
        } else {
            String perfume = perfumeEditText.getText().toString();
            String desc = descEditText.getText().toString();
            int price = Integer.parseInt(priceRateEditText.getText().toString());
            FragranceFamily fragranceFamily = new FragranceFamily(selectedCategory, perfume, desc, price);
            addFragranceFamilyViewModel.addNewFamily(fragranceFamily);
        }
    }
}