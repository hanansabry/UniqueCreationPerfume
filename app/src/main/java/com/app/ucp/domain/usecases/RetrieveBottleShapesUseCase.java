package com.app.ucp.domain.usecases;

import com.app.ucp.data.BottleShapeRepository;
import com.app.ucp.model.BottleShape;

import java.util.List;

import androidx.lifecycle.MutableLiveData;

public class RetrieveBottleShapesUseCase {

    private final BottleShapeRepository bottleShapeRepository;

    public RetrieveBottleShapesUseCase(BottleShapeRepository bottleShapeRepository) {
        this.bottleShapeRepository = bottleShapeRepository;
    }

    public void execute(MutableLiveData<List<BottleShape>> listBottleShapesLiveData) {
        bottleShapeRepository.retrieveBottleShapes(listBottleShapesLiveData);
    }

}
