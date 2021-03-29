package com.app.ucp.domain;

import com.app.ucp.data.CategoryRepository;
import com.app.ucp.model.FragranceConcentration;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

public class CategoryRepositoryImpl implements CategoryRepository {

    private final DatabaseReference mDatabase;

    public CategoryRepositoryImpl() {
        mDatabase = FirebaseDatabase.getInstance().getReference("category");
    }

    @Override
    public void retrieveAllCategories(MutableLiveData<List<String>> listCategoriesLiveData) {
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<String> retrievedFragrances = (ArrayList<String>) snapshot.getValue();
                listCategoriesLiveData.setValue(retrievedFragrances);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
