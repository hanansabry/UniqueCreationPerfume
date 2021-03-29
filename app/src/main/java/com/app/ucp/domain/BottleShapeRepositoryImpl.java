package com.app.ucp.domain;

import com.app.ucp.data.BottleShapeRepository;
import com.app.ucp.model.BottleShape;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;

public class BottleShapeRepositoryImpl implements BottleShapeRepository {
    @Override
    public void addBottleShape(BottleShape bottleShape, MutableLiveData<Boolean> success) {
        if (bottleShape.getImageUrl() != null) {
            success.setValue(true);
        } else {
            success.setValue(false);
        }
    }

    @Override
    public void retrieveBottleShapes(MutableLiveData<List<BottleShape>> listBottleShapesLiveData) {
        BottleShape shape1 = new BottleShape("https://p.kindpng.com/picc/s/100-1008927_perfume-bottle-muse-du-flacon-parfum-clube.png", 1);
        BottleShape shape2 = new BottleShape("https://st.depositphotos.com/1408467/3650/v/950/depositphotos_36507573-stock-illustration-perfume-bottle.jpg", 2);
        BottleShape shape3 = new BottleShape("https://smartymockups.com/wp-content/uploads/2018/01/Parfume_Bottle_Mockup_1.jpg", 3);
        BottleShape shape4 = new BottleShape("https://images-na.ssl-images-amazon.com/images/I/619dl3bGtRL._SL1001_.jpg", 2);
        BottleShape shape5 = new BottleShape("https://image.made-in-china.com/2f0j00TZBEYqJKgrRW/Rectangle-100ml-Cool-Design-Brand-Perfume-Bottle-for-Man.jpg", 6);
        BottleShape shape6 = new BottleShape("https://www.gearys.com/media/catalog/product/t/i/tizo_crystal_perfume_bottle_flat_round_2510-0013.jpg?quality=80&fit=bounds&height=1000&width=1000&canvas=1000:1000", 4);


        List<BottleShape> bottleShapeList = new ArrayList<>();
        bottleShapeList.add(shape1);
        bottleShapeList.add(shape2);
        bottleShapeList.add(shape3);
        bottleShapeList.add(shape4);
        bottleShapeList.add(shape5);
        bottleShapeList.add(shape6);

        listBottleShapesLiveData.setValue(bottleShapeList);
    }
}
