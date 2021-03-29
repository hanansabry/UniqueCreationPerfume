package com.app.ucp.domain;

import com.app.ucp.data.FragranceFamilyRepository;
import com.app.ucp.model.FragranceFamily;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

public class FragranceFamilyRepositoryImpl implements FragranceFamilyRepository {

    private final DatabaseReference mDatabase;

    public FragranceFamilyRepositoryImpl() {
        mDatabase = FirebaseDatabase.getInstance().getReference("fragrance-family");
    }

    @Override
    public void addNewFragranceFamily(FragranceFamily fragranceFamily, MutableLiveData<Boolean> success) {
        mDatabase.push().setValue(fragranceFamily).addOnCompleteListener(task -> {
            success.setValue(task.isSuccessful());
        });
    }

    @Override
    public void retrievePerfumesByCategory(String category, MutableLiveData<List<String>> listPerfumesLiveData) {
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<String> perfumeList = new ArrayList<>();
                for (DataSnapshot familySnapshot : snapshot.getChildren()) {
                    FragranceFamily fragranceFamily = familySnapshot.getValue(FragranceFamily.class);
                    if (fragranceFamily.getCategory().equals(category)) {
                        perfumeList.add(fragranceFamily.getPerfume());
                    }
                }
                listPerfumesLiveData.setValue(perfumeList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void retrieveFragranceFamily(String category, String perfume, MutableLiveData<FragranceFamily> fragranceFamilyLiveData) {
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot familySnapshot : snapshot.getChildren()) {
                    FragranceFamily fragranceFamily = familySnapshot.getValue(FragranceFamily.class);
                    if (fragranceFamily.getCategory().equals(category)
                            && fragranceFamily.getPerfume().equals(perfume)) {
                        fragranceFamilyLiveData.setValue(fragranceFamily);
                        break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
