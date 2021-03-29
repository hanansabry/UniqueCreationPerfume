package com.app.ucp.data;

import com.app.ucp.model.PerfumeRequest;

import androidx.lifecycle.MutableLiveData;

public interface AddPerfumeRepository {

    void addPerfume(PerfumeRequest perfumeRequest, MutableLiveData<Boolean> success);

}
