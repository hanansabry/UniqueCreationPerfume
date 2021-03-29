package com.app.ucp.domain;

import com.app.ucp.data.AddPerfumeRepository;
import com.app.ucp.model.PerfumeRequest;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

public class AddPerfumeRepositoryImpl implements AddPerfumeRepository {

    private final DatabaseReference mDatabase;

    public AddPerfumeRepositoryImpl() {
        mDatabase = FirebaseDatabase.getInstance().getReference("perfumes");
    }

    @Override
    public void addPerfume(PerfumeRequest perfumeRequest, MutableLiveData<Boolean> success) {
        mDatabase.push().setValue(perfumeRequest).addOnCompleteListener(task -> success.setValue(task.isSuccessful()));
    }
}
