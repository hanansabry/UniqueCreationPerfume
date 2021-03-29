package com.app.ucp.viewmodels;

import com.app.ucp.Injection;
import com.app.ucp.domain.usecases.AddNewFamilyUseCase;
import com.app.ucp.model.FragranceFamily;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AddFragranceFamilyViewModel extends ViewModel {

    private AddNewFamilyUseCase addNewFamilyUseCase;
    private MutableLiveData<Boolean> success = new MutableLiveData<>();

    public AddFragranceFamilyViewModel() {
        addNewFamilyUseCase = Injection.getAddNewFamilyUseCase();
    }

    public void addNewFamily(FragranceFamily fragranceFamily) {
        addNewFamilyUseCase.execute(fragranceFamily, success);
    }

    public MutableLiveData<Boolean> getSuccess() {
        return success;
    }
}
