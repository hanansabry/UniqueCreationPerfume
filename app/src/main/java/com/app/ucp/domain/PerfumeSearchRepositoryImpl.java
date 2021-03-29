package com.app.ucp.domain;

import com.app.ucp.data.PerfumeSearchRepository;
import com.app.ucp.model.BottleShape;
import com.app.ucp.model.FragranceConcentration;
import com.app.ucp.model.FragranceFamily;
import com.app.ucp.model.NoteConcentration;
import com.app.ucp.model.Perfume;
import com.app.ucp.model.PerfumeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

public class PerfumeSearchRepositoryImpl implements PerfumeSearchRepository {

    private final DatabaseReference mDatabase;

    public PerfumeSearchRepositoryImpl() {
        mDatabase = FirebaseDatabase.getInstance().getReference("perfumes");
    }

    @Override
    public void getPerfumeByPhone(String phone, MutableLiveData<PerfumeRequest> perfumeRequestLiveData) {
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot perfumeSnapshot : snapshot.getChildren()) {
                    PerfumeRequest perfumeRequest = perfumeSnapshot.getValue(PerfumeRequest.class);
                    if (perfumeRequest.getPhoneNumber().equals(phone)) {
                        perfumeRequestLiveData.setValue(perfumeRequest);
                        return;
                    }
                }
                perfumeRequestLiveData.setValue(null);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void getReadyMadePerfumes(MutableLiveData<List<Perfume>> perfumeListLiveData) {
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<Perfume> perfumeList = new ArrayList<>();
                for (DataSnapshot perfumeSnapshot : snapshot.getChildren()) {
                    PerfumeRequest perfumeRequest = perfumeSnapshot.getValue(PerfumeRequest.class);
                    if (perfumeRequest.getPhoneNumber().isEmpty()) {
                        perfumeList.add(perfumeRequest.getPerfume());
                    }
                }
                perfumeListLiveData.setValue(perfumeList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void getPerfumeRequests(MutableLiveData<List<PerfumeRequest>> perfumeRequestLiveData) {
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<PerfumeRequest> perfumeList = new ArrayList<>();
                for (DataSnapshot perfumeSnapshot : snapshot.getChildren()) {
                    PerfumeRequest perfumeRequest = perfumeSnapshot.getValue(PerfumeRequest.class);
                    if (!perfumeRequest.getPhoneNumber().isEmpty()) {
                        perfumeList.add(perfumeRequest);
                    }
                }
                perfumeRequestLiveData.setValue(perfumeList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
