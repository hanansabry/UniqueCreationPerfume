package com.app.ucp.viewmodels;

import com.app.ucp.Injection;
import com.app.ucp.domain.usecases.RetrieveCategoriesUseCase;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RetrieveCategoriesViewModel extends ViewModel {

    private RetrieveCategoriesUseCase retrieveCategoriesUseCase;
    private MutableLiveData<List<String>> listCategoriesLiveData = new MutableLiveData<>();

    public RetrieveCategoriesViewModel() {
        retrieveCategoriesUseCase = Injection.getRetrieveCategoriesUseCase();
    }

    public void retrieveCategories() {
        retrieveCategoriesUseCase.execute(listCategoriesLiveData);
    }

    public MutableLiveData<List<String>> getListCategoriesLiveData() {
        return listCategoriesLiveData;
    }
}
