package com.app.ucp.domain.usecases;

import com.app.ucp.data.BottleSizeRepository;
import com.app.ucp.model.BottleSize;

import java.util.List;

import androidx.lifecycle.MutableLiveData;

public class RetriveBottleSizesUseCase {

    final private BottleSizeRepository bottleSizeRepository;

    public RetriveBottleSizesUseCase(BottleSizeRepository bottleSizeRepository) {
        this.bottleSizeRepository = bottleSizeRepository;
    }

    public void execute(MutableLiveData<List<BottleSize>> bottleSizeLiveData) {
        bottleSizeRepository.retrieveBottleSizes(bottleSizeLiveData);
    }
}
