package com.app.ucp.viewmodels;

import com.app.ucp.Injection;
import com.app.ucp.domain.usecases.RetrieveFragranceFamilyUseCase;
import com.app.ucp.model.FragranceFamily;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RetrieveFragranceFamilyViewModel extends ViewModel {

    private RetrieveFragranceFamilyUseCase fragranceFamilyUseCase;
    MutableLiveData<FragranceFamily> fragranceFamilyLiveData = new MutableLiveData<>();

    public RetrieveFragranceFamilyViewModel() {
        fragranceFamilyUseCase = Injection.getFragranceFamilyUseCase();
    }

    public void retrieveFragranceFamily(String category, String perfume) {
        fragranceFamilyUseCase.execute(category, perfume, fragranceFamilyLiveData);
    }

    public MutableLiveData<FragranceFamily> getFragranceFamilyLiveData() {
        return fragranceFamilyLiveData;
    }
}
