package com.app.ucp.presentation.createperfume;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.ucp.Constants;
import com.app.ucp.PerfumeHelper;
import com.app.ucp.R;
import com.app.ucp.model.NoteConcentration;
import com.app.ucp.model.Perfume;
import com.google.android.material.slider.Slider;

import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    private Perfume perfume;
    private PerfumeHelper perfumeHelper = new PerfumeHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_concentration);
        ButterKnife.bind(this);

        String perfumeJson = getIntent().getExtras().getString(Constants.PERFUME);
        perfume = perfumeHelper.convertJsonToObj(perfumeJson);
        Toast.makeText(this, "Current Price rate: " + perfume.getPrice(), Toast.LENGTH_SHORT).show();
        priceRateEditText.setText(String.format(Locale.US, "%.2f", getPreviousPriceRate()));

        topNoteSlider.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public synchronized void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                while (topNoteSlider.getValue() + middleNoteSlider.getValue() + baseNoteSlider.getValue() > HUNDRED_PERCENT
                        && !middleValueIsChanging && !baseValueIsChanging) {
                    if (middleNoteSlider.getValue() > 0) {
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
                    if (topNoteSlider.getValue() > 0) {
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
                    if (topNoteSlider.getValue() > 0) {
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
        return perfume.getPrice();
    }

    private double getPriceRate() {
        double priceRate = (topNoteSlider.getValue() / 100) * NoteConcentration.NotePriceRate.TOP.getRate()
                + (middleNoteSlider.getValue() / 100) * NoteConcentration.NotePriceRate.MIDDLE.getRate()
                + (baseNoteSlider.getValue() / 100) * NoteConcentration.NotePriceRate.BASE.getRate();
        Log.d("NOTE PRICE", priceRate + "");
        return priceRate;
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
        if (topNoteSlider.getValue() + middleNoteSlider.getValue() + baseNoteSlider.getValue() < HUNDRED_PERCENT) {
            Toast.makeText(this, "Total values of Top, Middle and Base notes must be equal 100", Toast.LENGTH_SHORT).show();
        } else {
            NoteConcentration noteConcentration = new NoteConcentration();
            noteConcentration.setTopNote((int) topNoteSlider.getValue());
            noteConcentration.setMiddleNote((int) middleNoteSlider.getValue());
            noteConcentration.setBaseNote((int) baseNoteSlider.getValue());
            perfume.setNoteConcentration(noteConcentration);

            perfume.updatePrice(Double.parseDouble(priceRateEditText.getText().toString()));
            Intent intent = new Intent(this, FragranceFamilyActivity.class);
            intent.putExtra(Constants.PERFUME, perfumeHelper.convertObjToJson(perfume));
            startActivity(intent);
        }
    }
}