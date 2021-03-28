package com.app.ucp.presentation.createperfume;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.app.ucp.R;
import com.google.android.material.slider.Slider;

import java.util.Locale;

public class NoteConcentrationActivity extends AppCompatActivity {

    private static final float HUNDRED_PERCENT = 100f;

    @BindView(R.id.topNoteSlider)
    Slider topNoteSlider;
    @BindView(R.id.middleNoteSlider)
    Slider middleNoteSlider;
    @BindView(R.id.baseNoteSlider)
    Slider baseNoteSlider;
    @BindView(R.id.topNoteValueTV)
    TextView topNoteValueTV;
    @BindView(R.id.middleNoteValueTV)
    TextView middleNoteValueTV;
    @BindView(R.id.baseNoteValueTV)
    TextView baseNoteValueTV;
    @BindView(R.id.priceRateEditText)
    EditText priceRateEditText;

    private boolean topValueIsChanging;
    private boolean middleValueIsChanging;
    private boolean baseValueIsChanging;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_concentration);
        ButterKnife.bind(this);

        priceRateEditText.setText(String.format(Locale.US, "%.0f", getPreviousPriceRate()));

        topNoteSlider.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public synchronized void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                while (topNoteSlider.getValue() + middleNoteSlider.getValue() + baseNoteSlider.getValue() > HUNDRED_PERCENT
                                && !middleValueIsChanging && !baseValueIsChanging) {
                    if (middleNoteSlider.getValue() > 0 ) {
                        middleNoteSlider.setValue(middleNoteSlider.getValue() - 1);
                    }
                    if (baseNoteSlider.getValue() > 0) {
                        baseNoteSlider.setValue(baseNoteSlider.getValue() - 1);
                    }
                    topValueIsChanging = true;
                }
                topValueIsChanging = false;
                topNoteValueTV.setText(String.format("%s%%", value));
                setPriceRate();
            }
        });

        middleNoteSlider.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public synchronized void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                while (topNoteSlider.getValue() + middleNoteSlider.getValue() + baseNoteSlider.getValue() > HUNDRED_PERCENT
                        && !topValueIsChanging && !baseValueIsChanging) {
                    if (topNoteSlider.getValue() > 0 ) {
                        topNoteSlider.setValue(topNoteSlider.getValue() - 1);
                    }
                    if (baseNoteSlider.getValue() > 0) {
                        baseNoteSlider.setValue(baseNoteSlider.getValue() - 1);
                    }
                    middleValueIsChanging = true;
                }
                middleValueIsChanging = false;
                middleNoteValueTV.setText(String.format("%s%%", value));
                setPriceRate();
            }
        });

        baseNoteSlider.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public synchronized void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                while (topNoteSlider.getValue() + middleNoteSlider.getValue() + baseNoteSlider.getValue() > HUNDRED_PERCENT
                        && !topValueIsChanging && !middleValueIsChanging) {
                    if (topNoteSlider.getValue() > 0 ) {
                        topNoteSlider.setValue(topNoteSlider.getValue() - 1);
                    }
                    if (middleNoteSlider.getValue() > 0) {
                        middleNoteSlider.setValue(middleNoteSlider.getValue() - 1);
                    }
                    baseValueIsChanging = true;
                }
                baseValueIsChanging = false;
                baseNoteValueTV.setText(String.format("%s%%", value));
                setPriceRate();
            }
        });

    }

    private double getPreviousPriceRate() {
        return 5;
    }

    private double getPriceRate() {
        return (topNoteSlider.getValue()/100) * 1
                + (middleNoteSlider.getValue()/100) * 2
                + (baseNoteSlider.getValue()/100) * 3;
    }

    private void setPriceRate() {
        if (topNoteSlider.getValue() + middleNoteSlider.getValue() + baseNoteSlider.getValue() == 100) {
            priceRateEditText.setText(String.format(Locale.US, "%.2f", getPreviousPriceRate() + getPriceRate()));
        } else {
            priceRateEditText.setText(String.format(Locale.US, "%.2f", getPreviousPriceRate()));
        }
    }

    @OnClick(R.id.backBtn)
    public void onBackClicked() {
        onBackPressed();
    }

    @OnClick(R.id.nextBtn)
    public void onNextClicked() {
        startActivity(new Intent(this, FragranceFamilyActivity.class));
    }
}