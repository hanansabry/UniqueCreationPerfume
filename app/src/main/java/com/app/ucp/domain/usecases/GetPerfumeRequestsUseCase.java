package com.app.ucp.domain.usecases;

import com.app.ucp.data.PerfumeSearchRepository;
import com.app.ucp.model.PerfumeRequest;

import java.util.List;

import androidx.lifecycle.MutableLiveData;

public class GetPerfumeRequestsUseCase {

    private final PerfumeSearchRepository perfumeSearchRepository;

    public GetPerfumeRequestsUseCase(PerfumeSearchRepository perfumeSearchRepository) {
        this.perfumeSearchRepository = perfumeSearchRepository;
    }

    public void execute(MutableLiveData<List<PerfumeRequest>> perfumeRequestLiveData) {
        perfumeSearchRepository.getPerfumeRequests(perfumeRequestLiveData);
    }
}
