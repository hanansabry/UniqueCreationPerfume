package com.app.ucp.domain;

import com.app.ucp.data.BottleSizeRepository;
import com.app.ucp.model.BottleSize;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

public class BottleSizesRepositoryImpl implements BottleSizeRepository {
    
    private final DatabaseReference mDatabase;

    public BottleSizesRepositoryImpl() {
        mDatabase = FirebaseDatabase.getInstance().getReference("bottle-size");
    }

    @Override
    public void retrieveBottleSizes(MutableLiveData<List<BottleSize>> bottleSizeLiveData) {
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<BottleSize> bottleSizes = new ArrayList<>();
                for (DataSnapshot sizeSnapshot : snapshot.getChildren()) {
                    BottleSize bottleSize = sizeSnapshot.getValue(BottleSize.class);
                    bottleSizes.add(bottleSize);
                }
                bottleSizeLiveData.setValue(bottleSizes);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
