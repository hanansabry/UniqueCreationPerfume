package com.app.ucp.data;

import java.util.List;

import androidx.lifecycle.MutableLiveData;

public interface CategoryRepository {

    void retrieveAllCategories(MutableLiveData<List<String>> listCategoriesLiveData);
}
