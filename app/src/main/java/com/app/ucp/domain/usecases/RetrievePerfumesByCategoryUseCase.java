package com.app.ucp.domain.usecases;

import com.app.ucp.data.FragranceFamilyRepository;

import java.util.List;

import androidx.lifecycle.MutableLiveData;

public class RetrievePerfumesByCategoryUseCase {

    private final FragranceFamilyRepository fragranceFamilyRepository;

    public RetrievePerfumesByCategoryUseCase(FragranceFamilyRepository fragranceFamilyRepository) {
        this.fragranceFamilyRepository = fragranceFamilyRepository;
    }

    public void execute(String category, MutableLiveData<List<String>> listPerfumesLiveData) {
        fragranceFamilyRepository.retrievePerfumesByCategory(category, listPerfumesLiveData);
    }
}
