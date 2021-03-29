package com.app.ucp.domain;

import android.net.Uri;

import com.app.ucp.data.BottleShapeRepository;
import com.app.ucp.model.BottleShape;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

public class BottleShapeRepositoryImpl implements BottleShapeRepository {

    private final DatabaseReference mDatabase;

    public BottleShapeRepositoryImpl() {
        mDatabase = FirebaseDatabase.getInstance().getReference("bottle-shapes");
    }

    @Override
    public void addBottleShape(BottleShape bottleShape, MutableLiveData<Boolean> success) {
        StorageReference mStorageRef = FirebaseStorage.getInstance().getReference();
        Uri file = Uri.parse(bottleShape.getImageUrl());
        StorageReference storageReference = mStorageRef.child("bottles/" + UUID.randomUUID().toString());
        storageReference.putFile(file)
                .addOnSuccessListener(taskSnapshot -> {
                    storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            bottleShape.setImageUrl(uri.toString());
                            mDatabase.push().setValue(bottleShape).addOnCompleteListener(task -> success.setValue(task.isSuccessful()));
                        }
                    });
                })
                .addOnFailureListener(e -> {
                    success.setValue(false);
                });


    }

    @Override
    public void retrieveBottleShapes(MutableLiveData<List<BottleShape>> listBottleShapesLiveData) {
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<BottleShape> bottleShapes = new ArrayList<>();
                for (DataSnapshot bottleSnapshot : snapshot.getChildren()) {
                    BottleShape bottleShape = bottleSnapshot.getValue(BottleShape.class);
                    bottleShapes.add(bottleShape);
                }
                listBottleShapesLiveData.setValue(bottleShapes);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
