package com.app.ucp.viewmodels;

import com.app.ucp.Injection;
import com.app.ucp.domain.usecases.RetrievePerfumesByCategoryUseCase;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RetrievePerfumesByCategoryViewModel extends ViewModel {

    private RetrievePerfumesByCategoryUseCase useCase;
    MutableLiveData<List<String>> listPerfumesLiveData = new MutableLiveData<>();

    public RetrievePerfumesByCategoryViewModel() {
        useCase = Injection.getRetrievePerfumesByCategoryUseCase();
    }

    public void retrievePerfumesByCategory(String category) {
        useCase.execute(category, listPerfumesLiveData);
    }

    public MutableLiveData<List<String>> getListPerfumesLiveData() {
        return listPerfumesLiveData;
    }
}
