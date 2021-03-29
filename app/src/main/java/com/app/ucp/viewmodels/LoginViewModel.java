package com.app.ucp.viewmodels;

import com.app.ucp.Injection;
import com.app.ucp.domain.usecases.LoginUseCase;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    private LoginUseCase loginUseCase;
    private MutableLiveData<Boolean> success = new MutableLiveData<>();

    public LoginViewModel() {
        loginUseCase = Injection.getLoginUseCase();
    }

    public void login(String email, String password) {
        loginUseCase.login(email, password, success);
    }

    public MutableLiveData<Boolean> getSuccess() {
        return success;
    }
}
