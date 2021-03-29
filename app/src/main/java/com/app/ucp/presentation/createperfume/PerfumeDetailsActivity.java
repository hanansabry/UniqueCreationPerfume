package com.app.ucp.presentation.createperfume;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.ucp.Constants;
import com.app.ucp.PerfumeHelper;
import com.app.ucp.R;
import com.app.ucp.model.Perfume;
import com.squareup.picasso.Picasso;

import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PerfumeDetailsActivity extends AppCompatActivity {

    private Perfume perfume;
    private PerfumeHelper perfumeHelper = new PerfumeHelper(this);
    @BindView(R.id.fragranceConcentrationValue)
    TextView fragranceConcentrationValue;
    @BindView(R.id.topNoteValueTv)
    TextView topNoteValueTv;
    @BindView(R.id.baseNoteValueTv)
    TextView baseNoteValueTv;
    @BindView(R.id.middleNoteValueTv)
    TextView middleNoteValueTv;
    @BindView(R.id.categoryTv)
    TextView categoryTv;
    @BindView(R.id.perfumeTv)
    TextView perfumeTv;
    @BindView(R.id.priceTv)
    TextView priceTv;
    @BindView(R.id.perfumeBottleImage)
    ImageView perfumeBottleImage;
    @BindView(R.id.payBtn)
    Button payBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfume_details);
        ButterKnife.bind(this);

        if (getIntent().getExtras().get(Constants.SHOW_PAY) != null) {
            payBtn.setVisibility(View.GONE);
        }
        String perfumeJson = getIntent().getExtras().getString(Constants.PERFUME);
        perfume = perfumeHelper.convertJsonToObj(perfumeJson);

        //set perfume details value
        fragranceConcentrationValue.setText(perfume.getFragranceConcentration().getFragrance());
        topNoteValueTv.setText(String.format(Locale.US, "Top: %d%%", perfume.getNoteConcentration().getTopNote()));
        middleNoteValueTv.setText(String.format(Locale.US, "Middle: %d%%", perfume.getNoteConcentration().getMiddleNote()));
        baseNoteValueTv.setText(String.format(Locale.US, "Base: %d%%", perfume.getNoteConcentration().getBaseNote()));
        categoryTv.setText(perfume.getFragranceFamily().getCategory());
        perfumeTv.setText(perfume.getFragranceFamily().getPerfume());
        priceTv.setText(String.format(Locale.US, "%.2f", perfume.getPrice()));

        Picasso.with(this)
                .load(perfume.getBottleShape().getImageUrl())
                .placeholder(R.drawable.launcher_logo_transparent)
                .into(perfumeBottleImage);
    }

    @OnClick(R.id.backBtn)
    public void onBackClicked() {
        onBackPressed();
    }

    @OnClick(R.id.payBtn)
    public void onPayClicked() {
        Intent intent = new Intent(this, PaymentActivity.class);
        intent.putExtra(Constants.PERFUME, perfumeHelper.convertObjToJson(perfume));
        startActivity(intent);
    }
}