package com.app.ucp.viewmodels;

import com.app.ucp.Injection;
import com.app.ucp.domain.usecases.AddBottleShapeUseCase;
import com.app.ucp.model.BottleShape;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AddBottleShapeViewModel extends ViewModel {

    private AddBottleShapeUseCase bottleShapeUseCase;
    private MutableLiveData<Boolean> success = new MutableLiveData<>();

    public AddBottleShapeViewModel() {
        bottleShapeUseCase = Injection.getAddBottleShapeUseCase();
    }

    public void addBottleShape(BottleShape bottleShape) {
        bottleShapeUseCase.execute(bottleShape, success);
    }

    public MutableLiveData<Boolean> getSuccess() {
        return success;
    }
}
