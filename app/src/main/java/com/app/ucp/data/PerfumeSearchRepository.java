package com.app.ucp.data;

import com.app.ucp.model.PerfumeRequest;

import androidx.lifecycle.MutableLiveData;

public interface PerfumeSearchRepository {

    void getPerfumeByPhone(String phone, MutableLiveData<PerfumeRequest> perfumeRequestLiveData);
}
