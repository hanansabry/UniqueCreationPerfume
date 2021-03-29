package com.app.ucp.domain;

import com.app.ucp.data.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;

public class CategoryRepositoryImpl implements CategoryRepository {
    @Override
    public void retrieveAllCategories(MutableLiveData<List<String>> listCategoriesLiveData) {
        List<String> categoriesList = new ArrayList<>();
        categoriesList.add("Category1");
        categoriesList.add("Category2");
        categoriesList.add("Category3");
        categoriesList.add("Category4");
        categoriesList.add("Category5");

        listCategoriesLiveData.setValue(categoriesList);
    }
}
