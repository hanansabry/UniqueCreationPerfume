package com.app.ucp.domain.usecases;

import com.app.ucp.data.FragranceConcentrationRepository;
import com.app.ucp.model.FragranceConcentration;

import java.util.List;

import androidx.lifecycle.MutableLiveData;

public class RetrieveFragranceUseCase {

    private final FragranceConcentrationRepository fragranceConcentrationRepository;

    public RetrieveFragranceUseCase(FragranceConcentrationRepository fragranceConcentrationRepository) {
        this.fragranceConcentrationRepository = fragranceConcentrationRepository;
    }

    public void execute(MutableLiveData<List<FragranceConcentration>> listFragranceConcentrationsLiveData) {
        fragranceConcentrationRepository.retrieveFragranceConcentration(listFragranceConcentrationsLiveData);
    }
}
