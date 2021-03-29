package com.app.ucp.viewmodels;

import com.app.ucp.Injection;
import com.app.ucp.domain.usecases.GetReadyMadePerfumesUseCase;
import com.app.ucp.model.Perfume;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GetReadyMadePerfumesViewModel extends ViewModel {

    private GetReadyMadePerfumesUseCase getReadyMadePerfumesUseCase;
    private MutableLiveData<List<Perfume>> perfumeListLiveData = new MutableLiveData<>();

    public GetReadyMadePerfumesViewModel() {
        getReadyMadePerfumesUseCase = Injection.getReadyMadePerfumesUseCase();
    }

    public void getReadyMadePerfumes() {
        getReadyMadePerfumesUseCase.execute(perfumeListLiveData);
    }

    public MutableLiveData<List<Perfume>> getPerfumeListLiveData() {
        return perfumeListLiveData;
    }
}
