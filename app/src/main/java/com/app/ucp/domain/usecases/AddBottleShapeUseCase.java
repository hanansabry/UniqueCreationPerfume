package com.app.ucp.domain.usecases;

import com.app.ucp.data.BottleShapeRepository;
import com.app.ucp.model.BottleShape;

import androidx.lifecycle.MutableLiveData;

public class AddBottleShapeUseCase {

    private final BottleShapeRepository bottleShapeRepository;


    public AddBottleShapeUseCase(BottleShapeRepository bottleShapeRepository) {
        this.bottleShapeRepository = bottleShapeRepository;
    }

    public void execute(BottleShape bottleShape, MutableLiveData<Boolean> success) {
        bottleShapeRepository.addBottleShape(bottleShape, success);
    }
}
