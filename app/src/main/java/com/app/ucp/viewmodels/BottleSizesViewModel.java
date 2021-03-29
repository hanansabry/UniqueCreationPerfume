package com.app.ucp.viewmodels;

import com.app.ucp.Injection;
import com.app.ucp.domain.usecases.RetriveBottleSizesUseCase;
import com.app.ucp.model.BottleSize;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BottleSizesViewModel extends ViewModel {

    private RetriveBottleSizesUseCase retriveBottleSizesUseCase;
    MutableLiveData<List<BottleSize>> bottleSizeLiveData = new MutableLiveData<>();

    public BottleSizesViewModel() {
        retriveBottleSizesUseCase = Injection.getRetrieveBottleSizesUseCase();
    }

    public void retrieveBottleSizes() {
        retriveBottleSizesUseCase.execute(bottleSizeLiveData);
    }

    public MutableLiveData<List<BottleSize>> getBottleSizeLiveData() {
        return bottleSizeLiveData;
    }
}
