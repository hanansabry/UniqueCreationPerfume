package com.app.ucp.domain;

import com.app.ucp.data.FragranceConcentrationRepository;
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

public class FragranceConcentrationRepositoryImpl implements FragranceConcentrationRepository {

    private final DatabaseReference mDatabase;

    public FragranceConcentrationRepositoryImpl() {
        mDatabase = FirebaseDatabase.getInstance().getReference("fragrance-concentration");
    }

    @Override
    public void retrieveFragranceConcentration(MutableLiveData<List<FragranceConcentration>> listFragranceConcentrationsLiveData) {
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<FragranceConcentration> retrievedFragrances = new ArrayList<>();
                for (DataSnapshot fragranceSnapshot : snapshot.getChildren()) {
                    FragranceConcentration fragranceConcentration = fragranceSnapshot.getValue(FragranceConcentration.class);
                    retrievedFragrances.add(fragranceConcentration);
                }
                listFragranceConcentrationsLiveData.setValue(retrievedFragrances);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
