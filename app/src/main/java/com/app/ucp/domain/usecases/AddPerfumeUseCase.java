package com.app.ucp.domain.usecases;

import com.app.ucp.data.AddPerfumeRepository;
import com.app.ucp.model.PerfumeRequest;

import androidx.lifecycle.MutableLiveData;

public class AddPerfumeUseCase {

    private final AddPerfumeRepository addPerfumeRepository;

    public AddPerfumeUseCase(AddPerfumeRepository addPerfumeRepository) {
        this.addPerfumeRepository = addPerfumeRepository;
    }

    public void execute(PerfumeRequest perfumeRequest, MutableLiveData<Boolean> success) {
        addPerfumeRepository.addPerfume(perfumeRequest, success);
    }
}
