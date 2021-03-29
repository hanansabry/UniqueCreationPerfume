package com.app.ucp.viewmodels;

import com.app.ucp.Injection;
import com.app.ucp.domain.usecases.GetPerfumeRequestsUseCase;
import com.app.ucp.model.PerfumeRequest;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GetPerfumeRequestsViewModel extends ViewModel {

    private GetPerfumeRequestsUseCase getPerfumeRequestsUseCase;
    private MutableLiveData<List<PerfumeRequest>> perfumeRequestLiveData = new MutableLiveData<>();

    public GetPerfumeRequestsViewModel() {
        this.getPerfumeRequestsUseCase = Injection.getPerfumeRequestUseCase();
    }

    public void getPerfumeRequests() {
        getPerfumeRequestsUseCase.execute(perfumeRequestLiveData);
    }

    public MutableLiveData<List<PerfumeRequest>> getPerfumeRequestLiveData() {
        return perfumeRequestLiveData;
    }
}
