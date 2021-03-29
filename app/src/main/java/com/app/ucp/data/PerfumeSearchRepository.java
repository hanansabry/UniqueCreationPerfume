package com.app.ucp.data;

import com.app.ucp.model.Perfume;
import com.app.ucp.model.PerfumeRequest;

import java.util.List;

import androidx.lifecycle.MutableLiveData;

public interface PerfumeSearchRepository {

    void getPerfumeByPhone(String phone, MutableLiveData<PerfumeRequest> perfumeRequestLiveData);

    void getReadyMadePerfumes(MutableLiveData<List<Perfume>> perfumeListLiveData);

    void getPerfumeRequests(MutableLiveData<List<PerfumeRequest>> perfumeRequestLiveData);
}
