package com.app.ucp.domain.usecases;

import com.app.ucp.data.CategoryRepository;

import java.util.List;

import androidx.lifecycle.MutableLiveData;

public class RetrieveCategoriesUseCase {

    private final CategoryRepository categoryRepository;

    public RetrieveCategoriesUseCase(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void execute(MutableLiveData<List<String>> listCategoriesLiveData) {
        categoryRepository.retrieveAllCategories(listCategoriesLiveData);
    }
}
