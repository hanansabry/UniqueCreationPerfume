package com.app.ucp.viewmodels;

import com.app.ucp.Injection;
import com.app.ucp.domain.usecases.RetrieveFragranceUseCase;
import com.app.ucp.model.FragranceConcentration;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FragranceConcentrationViewModel extends ViewModel {

    private RetrieveFragranceUseCase retrieveFragranceUseCase;
    private MutableLiveData<List<FragranceConcentration>> listFragranceConcentrationsLiveData
            = new MutableLiveData<>();

    public FragranceConcentrationViewModel() {
        retrieveFragranceUseCase = Injection.getRetrieveFragranceUsceCase();
    }

    public void retrieveFragranceConcentration() {
        retrieveFragranceUseCase.execute(listFragranceConcentrationsLiveData);
    }

    public MutableLiveData<List<FragranceConcentration>> getListFragranceConcentrationsLiveData() {
        return listFragranceConcentrationsLiveData;
    }
}
