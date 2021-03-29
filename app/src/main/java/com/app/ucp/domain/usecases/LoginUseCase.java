package com.app.ucp.domain.usecases;

import com.app.ucp.data.AuthenticationRepository;

import androidx.lifecycle.MutableLiveData;

public class LoginUseCase {

    private final AuthenticationRepository authenticationRepository;

    public LoginUseCase(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    public void login(String email, String password, MutableLiveData<Boolean> success) {
        authenticationRepository.login(email, password, success);
    }
}
