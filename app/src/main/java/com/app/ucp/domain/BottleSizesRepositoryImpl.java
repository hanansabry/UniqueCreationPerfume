package com.app.ucp.domain;

import com.app.ucp.data.BottleSizeRepository;
import com.app.ucp.model.BottleSize;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;

public class BottleSizesRepositoryImpl implements BottleSizeRepository {
    @Override
    public void retrieveBottleSizes(MutableLiveData<List<BottleSize>> bottleSizeLiveData) {
        BottleSize size1 = new BottleSize("50ml", 1);
        BottleSize size2 = new BottleSize("100ml", 2);
        BottleSize size3 = new BottleSize("150ml", 3);

        List<BottleSize> bottleSizeList = new ArrayList<>();
        bottleSizeList.add(size1);
        bottleSizeList.add(size2);
        bottleSizeList.add(size3);

        bottleSizeLiveData.setValue(bottleSizeList);
    }
}
