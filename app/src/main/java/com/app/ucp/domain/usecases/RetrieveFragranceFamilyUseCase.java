package com.app.ucp.domain.usecases;

import com.app.ucp.data.FragranceFamilyRepository;
import com.app.ucp.model.FragranceFamily;

import androidx.lifecycle.MutableLiveData;

public class RetrieveFragranceFamilyUseCase {

    private final FragranceFamilyRepository fragranceFamilyRepository;

    public RetrieveFragranceFamilyUseCase(FragranceFamilyRepository fragranceFamilyRepository) {
        this.fragranceFamilyRepository = fragranceFamilyRepository;
    }

    public void execute(String category, String perfume, MutableLiveData<FragranceFamily> fragranceFamilyLiveData) {
        fragranceFamilyRepository.retrieveFragranceFamily(category, perfume, fragranceFamilyLiveData);
    }
}
