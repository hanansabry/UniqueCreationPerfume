package com.app.ucp.domain;

import com.app.ucp.data.AddPerfumeRepository;
import com.app.ucp.model.PerfumeRequest;

import androidx.lifecycle.MutableLiveData;

public class AddPerfumeRepositoryImpl implements AddPerfumeRepository {
    @Override
    public void addPerfume(PerfumeRequest perfumeRequest, MutableLiveData<Boolean> success) {
        success.setValue(true);
    }
}
