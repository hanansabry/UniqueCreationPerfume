package com.app.ucp.viewmodels;

import com.app.ucp.Injection;
import com.app.ucp.domain.usecases.PerfumeSearchUseCase;
import com.app.ucp.model.PerfumeRequest;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PerfumeSearchViewModel extends ViewModel {

    private PerfumeSearchUseCase perfumeSearchUseCase;
    private MutableLiveData<PerfumeRequest> perfumeRequestLiveData = new MutableLiveData<>();

    public PerfumeSearchViewModel() {
        this.perfumeSearchUseCase = Injection.getPerfumeSearchUseCase();
    }

    public void search(String phone) {
        perfumeSearchUseCase.search(phone, perfumeRequestLiveData);
    }

    public MutableLiveData<PerfumeRequest> getPerfumeRequestLiveData() {
        return perfumeRequestLiveData;
    }
}
