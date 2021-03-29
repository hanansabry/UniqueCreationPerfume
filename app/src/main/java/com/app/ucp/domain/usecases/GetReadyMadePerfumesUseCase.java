package com.app.ucp.domain.usecases;

import com.app.ucp.data.PerfumeSearchRepository;
import com.app.ucp.model.Perfume;

import java.util.List;

import androidx.lifecycle.MutableLiveData;

public class GetReadyMadePerfumesUseCase {

    private final PerfumeSearchRepository perfumeSearchRepository;

    public GetReadyMadePerfumesUseCase(PerfumeSearchRepository perfumeSearchRepository) {
        this.perfumeSearchRepository = perfumeSearchRepository;
    }

    public void execute(MutableLiveData<List<Perfume>> perfumeListLiveData) {
        perfumeSearchRepository.getReadyMadePerfumes(perfumeListLiveData);
    }
}
