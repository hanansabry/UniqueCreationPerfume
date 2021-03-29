package com.app.ucp.presentation.createperfume;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.app.ucp.Constants;
import com.app.ucp.PerfumeHelper;
import com.app.ucp.R;
import com.app.ucp.model.BottleShape;
import com.app.ucp.model.BottleSize;
import com.app.ucp.model.Perfume;
import com.app.ucp.presentation.adapters.BottleShapesAdapter;
import com.app.ucp.viewmodels.BottleShapeViewModel;
import com.app.ucp.viewmodels.BottleSizesViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BottleShapeActivity extends AppCompatActivity implements BottleShapesAdapter.BottleShapesClickListener {

    private Perfume perfume;
    private PerfumeHelper perfumeHelper = new PerfumeHelper(this);

    @BindView(R.id.sizeSpinner)
    AppCompatSpinner sizeSpinner;
    @BindView(R.id.bottleShapeRecyclerView)
    RecyclerView bottleShapeRecyclerView;
    private BottleShape selectedBottleShape;
    private BottleSize selectedSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottle_shape);
        ButterKnife.bind(this);

        String perfumeJson = getIntent().getExtras().getString(Constants.PERFUME);
        perfume = perfumeHelper.convertJsonToObj(perfumeJson);
        Toast.makeText(this, "Current Price rate: " + perfume.getPrice(), Toast.LENGTH_SHORT).show();

        BottleSizesViewModel bottleSizesViewModel = new ViewModelProvider(this).get(BottleSizesViewModel.class);
        bottleSizesViewModel.retrieveBottleSizes();
        bottleSizesViewModel.getBottleSizeLiveData().observe(this, this::setSizesSpinner);

        BottleShapeViewModel bottleShapeViewModel = new ViewModelProvider(this).get(BottleShapeViewModel.class);
        bottleShapeViewModel.retrieveBottleShapes();
        bottleShapeViewModel.getListBottleShapesLiveData().observe(this, this::setBottleShapesRecyclerView);
    }

    private void setSizesSpinner(List<BottleSize> bottleSizes) {
        ArrayList<String> sizes = new ArrayList<>();
        for (BottleSize bottleSize : bottleSizes) {
            sizes.add(bottleSize.getSize());
        }
        ArrayAdapter<String> sizesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item);
        sizesAdapter.addAll(sizes);
        sizeSpinner.setAdapter(sizesAdapter);
        sizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedSize = bottleSizes.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setBottleShapesRecyclerView(List<BottleShape> bottleShapes) {
        BottleShapesAdapter bottleShapesAdapter = new BottleShapesAdapter(bottleShapes, this);
        bottleShapeRecyclerView.setAdapter(bottleShapesAdapter);
        bottleShapeRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }

    @OnClick(R.id.backBtn)
    public void onBackButton() {
        onBackPressed();
    }

    @OnClick(R.id.nextBtn)
    public void onNextClicked() {
        if (selectedBottleShape != null && selectedSize != null) {
            double bottlePrice = selectedBottleShape.getPrice() * selectedSize.getPriceRate();
            perfume.setBottleShape(selectedBottleShape);
            perfume.updatePrice(perfume.getPrice() + bottlePrice);
            Intent intent = new Intent(this, PerfumeDetailsActivity.class);
            intent.putExtra(Constants.PERFUME, perfumeHelper.convertObjToJson(perfume));
            startActivity(intent);
        } else {
            Toast.makeText(this, "You must select bottle shape..", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBottleClicked(BottleShape bottleShape) {
        selectedBottleShape = bottleShape;
    }
}