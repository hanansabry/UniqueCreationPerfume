package com.app.ucp.presentation.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.app.ucp.Injection;
import com.app.ucp.R;
import com.app.ucp.model.BottleShape;
import com.app.ucp.viewmodels.AddBottleShapeViewModel;
import com.vansuita.pickimage.bean.PickResult;
import com.vansuita.pickimage.bundle.PickSetup;
import com.vansuita.pickimage.dialog.PickImageDialog;
import com.vansuita.pickimage.listeners.IPickResult;

public class AddBottlesActivity extends AppCompatActivity implements IPickResult {

    @BindView(R.id.imageEditText)
    EditText imageEditText;
    @BindView(R.id.priceRateEditText)
    EditText priceRateEditText;
    private AddBottleShapeViewModel addBottleShapeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bottles);
        ButterKnife.bind(this);

        addBottleShapeViewModel = new ViewModelProvider(this).get(AddBottleShapeViewModel.class);
        addBottleShapeViewModel.getSuccess().observe(this, success -> {
            if (success) {
                Toast.makeText(this, "Bottle shape is added successfully..", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Something wrong is happened, Please try again..", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.imageEditText)
    public void onSelectImageClicked() {
        PickImageDialog.build(new PickSetup()).show(this);
    }

    @OnClick(R.id.backBtn)
    public void onBackClicked() {
        onBackPressed();
    }

    @OnClick(R.id.saveBtn)
    public void onSaveClicked() {
        String image = imageEditText.getText().toString();
        String price = priceRateEditText.getText().toString();
        if (image.isEmpty() || price.isEmpty()) {
            Toast.makeText(this, "You must enter all values..", Toast.LENGTH_SHORT).show();
        } else {
            BottleShape bottleShape = new BottleShape(image, Integer.parseInt(price));
            addBottleShapeViewModel.addBottleShape(bottleShape);
        }
    }

    @Override
    public void onPickResult(PickResult r) {
        if (r.getError() == null) {
            imageEditText.setText(r.getUri().toString());
        } else {
            //Handle possible errors
            Toast.makeText(this, r.getError().getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}