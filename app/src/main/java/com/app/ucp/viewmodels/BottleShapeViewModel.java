package com.app.ucp.viewmodels;

import com.app.ucp.Injection;
import com.app.ucp.domain.usecases.RetrieveBottleShapesUseCase;
import com.app.ucp.model.BottleShape;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BottleShapeViewModel extends ViewModel {

    RetrieveBottleShapesUseCase retrieveBottleShapesUseCase;
    MutableLiveData<List<BottleShape>> listBottleShapesLiveData = new MutableLiveData<>();

    public BottleShapeViewModel() {
        retrieveBottleShapesUseCase = Injection.getRetrieveBottleShapesUseCase();
    }

    public void retrieveBottleShapes() {
        retrieveBottleShapesUseCase.execute(listBottleShapesLiveData);
    }

    public MutableLiveData<List<BottleShape>> getListBottleShapesLiveData() {
        return listBottleShapesLiveData;
    }
}
