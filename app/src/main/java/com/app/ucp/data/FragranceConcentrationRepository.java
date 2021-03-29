package com.app.ucp.data;

import com.app.ucp.model.FragranceConcentration;

import java.util.List;

import androidx.lifecycle.MutableLiveData;

public interface FragranceConcentrationRepository {

    void retrieveFragranceConcentration(MutableLiveData<List<FragranceConcentration>> listFragranceConcentrationsLiveData);
}
