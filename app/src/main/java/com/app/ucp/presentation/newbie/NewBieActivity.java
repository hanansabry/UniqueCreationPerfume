package com.app.ucp.presentation.newbie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.app.ucp.Constants;
import com.app.ucp.Injection;
import com.app.ucp.PerfumeHelper;
import com.app.ucp.R;
import com.app.ucp.model.Perfume;
import com.app.ucp.presentation.adapters.PerfumesAdapter;
import com.app.ucp.presentation.createperfume.PerfumeDetailsActivity;
import com.app.ucp.viewmodels.GetReadyMadePerfumesViewModel;

import java.util.List;

public class NewBieActivity extends AppCompatActivity implements PerfumesAdapter.PerfumeClickListener {

    PerfumeHelper perfumeHelper = new PerfumeHelper(this);
    @BindView(R.id.perfumesRecyclerView)
    RecyclerView perfumesRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_bie);
        ButterKnife.bind(this);

        GetReadyMadePerfumesViewModel getReadyMadePerfumesViewModel =
                new ViewModelProvider(this).get(GetReadyMadePerfumesViewModel.class);
        getReadyMadePerfumesViewModel.getReadyMadePerfumes();

        getReadyMadePerfumesViewModel.getPerfumeListLiveData().observe(this, this::setPerfumesRecyclerView);
    }

    private void setPerfumesRecyclerView(List<Perfume> perfumes) {
        PerfumesAdapter perfumesAdapter = new PerfumesAdapter(perfumes, this);
        perfumesRecyclerView.setAdapter(perfumesAdapter);
        perfumesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @OnClick(R.id.backBtn)
    public void onBackClicked() {
        onBackPressed();;
    }

    @Override
    public void onPerfumeClicked(Perfume perfume) {
        Intent intent = new Intent(this, PerfumeDetailsActivity.class);
        intent.putExtra(Constants.PERFUME, perfumeHelper.convertObjToJson(perfume));
        startActivity(intent);
    }
}