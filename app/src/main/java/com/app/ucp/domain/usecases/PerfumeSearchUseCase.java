package com.app.ucp.domain.usecases;

import com.app.ucp.data.PerfumeSearchRepository;
import com.app.ucp.model.PerfumeRequest;

import androidx.lifecycle.MutableLiveData;

public class PerfumeSearchUseCase {

    private final PerfumeSearchRepository perfumeSearchRepository;

    public PerfumeSearchUseCase(PerfumeSearchRepository perfumeSearchRepository) {
        this.perfumeSearchRepository = perfumeSearchRepository;
    }

    public void search(String phone, MutableLiveData<PerfumeRequest> perfumeRequestLiveData) {
        perfumeSearchRepository.getPerfumeByPhone(phone, perfumeRequestLiveData);
    }
}
