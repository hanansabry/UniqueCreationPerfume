package com.app.ucp.data;

import com.app.ucp.model.BottleSize;

import java.util.List;

import androidx.lifecycle.MutableLiveData;

public interface BottleSizeRepository {

    void retrieveBottleSizes(MutableLiveData<List<BottleSize>> bottleSizeLiveData);
}
