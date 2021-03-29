package com.app.ucp.domain.usecases;

import com.app.ucp.data.FragranceFamilyRepository;
import com.app.ucp.model.FragranceFamily;

import androidx.lifecycle.MutableLiveData;

public class AddNewFamilyUseCase {

    private final FragranceFamilyRepository fragranceFamilyRepository;

    public AddNewFamilyUseCase(FragranceFamilyRepository fragranceFamilyRepository) {
        this.fragranceFamilyRepository = fragranceFamilyRepository;
    }

    public void execute(FragranceFamily fragranceFamily, MutableLiveData<Boolean> success) {
        fragranceFamilyRepository.addNewFragranceFamily(fragranceFamily, success);
    }
}
