package com.app.ucp.presentation.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.Intent;
import android.os.Bundle;

import com.app.ucp.Constants;
import com.app.ucp.PerfumeHelper;
import com.app.ucp.R;
import com.app.ucp.model.PerfumeRequest;
import com.app.ucp.presentation.adapters.PerfumeRequestsAdapter;
import com.app.ucp.presentation.createperfume.PerfumeDetailsActivity;
import com.app.ucp.viewmodels.GetPerfumeRequestsViewModel;

import java.util.List;

public class DisplayRequestsActivity extends AppCompatActivity implements PerfumeRequestsAdapter.PerfumeRequestClickListener {

    PerfumeHelper perfumeHelper = new PerfumeHelper(this);
    @BindView(R.id.requestsRecyclerView)
    RecyclerView requestsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_requests);
        ButterKnife.bind(this);

        GetPerfumeRequestsViewModel getPerfumeRequestsViewModel = new ViewModelProvider(this).get(GetPerfumeRequestsViewModel.class);
        getPerfumeRequestsViewModel.getPerfumeRequests();

        getPerfumeRequestsViewModel.getPerfumeRequestLiveData()
                .observe(this, this::setRequestsRecyclerView);
    }

    private void setRequestsRecyclerView(List<PerfumeRequest> perfumeRequests) {
        PerfumeRequestsAdapter adapter = new PerfumeRequestsAdapter(perfumeRequests, this);
        requestsRecyclerView.setAdapter(adapter);
        requestsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @OnClick(R.id.backBtn)
    public void onBackClicked() {
        onBackPressed();
    }

    @Override
    public void onPerfumeRequestClicked(PerfumeRequest perfumeRequest) {
        Intent intent = new Intent(this, PerfumeDetailsActivity.class);
        intent.putExtra(Constants.PERFUME, perfumeHelper.convertObjToJson(perfumeRequest.getPerfume()));
        intent.putExtra(Constants.SHOW_PAY, false);
        startActivity(intent);
    }
}