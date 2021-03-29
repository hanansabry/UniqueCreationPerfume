package com.app.ucp.domain;

import com.app.ucp.data.AuthenticationRepository;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

public class AuthenticationRepositoryImpl implements AuthenticationRepository {

    private final FirebaseAuth firebaseAuth;

    public AuthenticationRepositoryImpl() {
        firebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void login(String email, String password, MutableLiveData<Boolean> success) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            success.setValue(task.isSuccessful());
        });
    }
}
