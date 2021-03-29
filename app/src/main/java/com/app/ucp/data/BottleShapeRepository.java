package com.app.ucp.data;

import com.app.ucp.model.BottleShape;

import java.util.List;

import androidx.lifecycle.MutableLiveData;

public interface BottleShapeRepository {

    void addBottleShape(BottleShape bottleShape, MutableLiveData<Boolean> success);
    void retrieveBottleShapes(MutableLiveData<List<BottleShape>> listBottleShapesLiveData);
}
