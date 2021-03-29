package com.app.ucp.domain;

import com.app.ucp.data.FragranceConcentrationRepository;
import com.app.ucp.model.FragranceConcentration;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;

public class FragranceConcentrationRepositoryImpl implements FragranceConcentrationRepository {
    @Override
    public void retrieveFragranceConcentration(MutableLiveData<List<FragranceConcentration>> listFragranceConcentrationsLiveData) {
        FragranceConcentration f1 = new FragranceConcentration("Perfume", "20-30%", 24, 5);
        FragranceConcentration f2 = new FragranceConcentration("Eau de perfume", "15-20%", 8, 4);
        FragranceConcentration f3 = new FragranceConcentration("Eau de toilet", "5-15%", 3, 3);
        FragranceConcentration f4 = new FragranceConcentration("Eau de cologne", "2-4%", 2, 2);
        FragranceConcentration f5 = new FragranceConcentration("Eau de fraiche", "1-3%", 1, 1);

        List<FragranceConcentration> list = new ArrayList<>();
        list.add(f1);
        list.add(f2);
        list.add(f3);
        list.add(f4);
        list.add(f5);

        listFragranceConcentrationsLiveData.setValue(list);
    }
}
