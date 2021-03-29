package com.app.ucp.domain;

import com.app.ucp.data.FragranceFamilyRepository;
import com.app.ucp.model.FragranceFamily;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;

public class FragranceFamilyRepositoryImpl implements FragranceFamilyRepository {
    @Override
    public void addNewFragranceFamily(FragranceFamily fragranceFamily, MutableLiveData<Boolean> success) {
        if (fragranceFamily.getCategory().equals("Category1")
                || fragranceFamily.getCategory().equals("Category2")
                || fragranceFamily.getCategory().equals("Category3")
                || fragranceFamily.getCategory().equals("Category4")
                || fragranceFamily.getCategory().equals("Category5")) {
            success.setValue(true);
        } else {
            success.setValue(false);
        }
    }

    @Override
    public void retrievePerfumesByCategory(String category, MutableLiveData<List<String>> listPerfumesLiveData) {
        List<String> perfumeList = new ArrayList<>();
        if (category.equals("Category1")) {
            perfumeList.add("Perfume1");
            perfumeList.add("Perfume2");
            perfumeList.add("Perfume3");
        } else if (category.equals("Category2")) {
            perfumeList.add("Perfume4");
            perfumeList.add("Perfume5");
        } else if (category.equals("Category3")) {
            perfumeList.add("Perfume6");
            perfumeList.add("Perfume7");
            perfumeList.add("Perfume8");
            perfumeList.add("Perfume9");
        } else if (category.equals("Category4")) {
            perfumeList.add("Perfume10");
            perfumeList.add("Perfume11");
            perfumeList.add("Perfume12");
        } else if (category.equals("Category5")) {
            perfumeList.add("Perfume13");
            perfumeList.add("Perfume14");
        }
        listPerfumesLiveData.setValue(perfumeList);
    }

    @Override
    public void retrieveFragranceFamily(String category, String perfume, MutableLiveData<FragranceFamily> fragranceFamilyLiveData) {
        FragranceFamily ff1 = null;
        if (category.equals("Category1") && perfume.equals("Perfume1")) {
            ff1 = new FragranceFamily("Category1", "Perfume1", "my desc", 3);
        } else if (category.equals("Category2") && perfume.equals("Perfume4")) {
            ff1 = new FragranceFamily("Category2", "Perfume4", "my desc", 5);
        } else if (category.equals("Category3") && perfume.equals("Perfume8")) {
            ff1 = new FragranceFamily("Category3", "Perfume8", "my desc", 2);
        } else if (category.equals("Category4") && perfume.equals("Perfume11")) {
            ff1 = new FragranceFamily("Category4", "Perfume11", "my desc", 1);
        }
        fragranceFamilyLiveData.setValue(ff1);
    }
}
