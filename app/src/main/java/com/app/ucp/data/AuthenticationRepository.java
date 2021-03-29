package com.app.ucp.data;

import androidx.lifecycle.MutableLiveData;

public interface AuthenticationRepository {

    void login(String email, String password, MutableLiveData<Boolean> success);
}
