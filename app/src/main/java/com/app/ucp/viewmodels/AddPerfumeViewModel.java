package com.app.ucp.viewmodels;

import com.app.ucp.Injection;
import com.app.ucp.domain.usecases.AddPerfumeUseCase;
import com.app.ucp.model.PerfumeRequest;
import com.google.firebase.auth.FirebaseAuth;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AddPerfumeViewModel extends ViewModel {

    private AddPerfumeUseCase addPerfumeUseCase;
    private MutableLiveData<Boolean> success = new MutableLiveData<>();

    public AddPerfumeViewModel() {
        this.addPerfumeUseCase = Injection.getAddPerfumeUseCase();
    }

    public void addPerfume(PerfumeRequest perfumeRequest) {
        addPerfumeUseCase.execute(perfumeRequest, success);
    }

    public boolean isAdmin() {
        return FirebaseAuth.getInstance().getCurrentUser() != null;
    }

    public MutableLiveData<Boolean> getSuccess() {
        return success;
    }
}
