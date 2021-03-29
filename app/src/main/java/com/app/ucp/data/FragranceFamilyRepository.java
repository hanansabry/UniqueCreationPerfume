package com.app.ucp.data;

import com.app.ucp.model.FragranceFamily;

import java.util.List;

import androidx.lifecycle.MutableLiveData;

public interface FragranceFamilyRepository {

    void addNewFragranceFamily(FragranceFamily fragranceFamily, MutableLiveData<Boolean> success);
    void retrievePerfumesByCategory(String category, MutableLiveData<List<String>> listPerfumesLiveData);
    void retrieveFragranceFamily(String category, String perfume, MutableLiveData<FragranceFamily> fragranceFamilyLiveData);
}
