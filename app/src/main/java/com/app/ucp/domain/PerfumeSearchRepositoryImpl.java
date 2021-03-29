package com.app.ucp.domain;

import com.app.ucp.data.PerfumeSearchRepository;
import com.app.ucp.model.BottleShape;
import com.app.ucp.model.FragranceConcentration;
import com.app.ucp.model.FragranceFamily;
import com.app.ucp.model.NoteConcentration;
import com.app.ucp.model.Perfume;
import com.app.ucp.model.PerfumeRequest;

import java.util.UUID;

import androidx.lifecycle.MutableLiveData;

public class PerfumeSearchRepositoryImpl implements PerfumeSearchRepository {
    @Override
    public void getPerfumeByPhone(String phone, MutableLiveData<PerfumeRequest> perfumeRequestLiveData) {
        if (phone.equals("01014736447")) {
            FragranceConcentration fc = new FragranceConcentration("Eau de toilet", "10-15%", 3, 4);
            NoteConcentration nc = new NoteConcentration();
            nc.setBaseNote(34);
            nc.setMiddleNote(33);
            nc.setTopNote(33);
            FragranceFamily ff = new FragranceFamily("Category1", "Perfume1", "Desc", 3);
            BottleShape bottleShape = new BottleShape("https://st.depositphotos.com/1408467/3650/v/950/depositphotos_36507573-stock-illustration-perfume-bottle.jpg", 3);

            Perfume perfume = new Perfume();
            perfume.setBottleShape(bottleShape);
            perfume.setFragranceFamily(ff);
            perfume.setNoteConcentration(nc);
            perfume.setFragranceConcentration(fc);
            perfume.setId(UUID.randomUUID().toString());
            perfume.updatePrice(13.2);

            PerfumeRequest perfumeRequest = new PerfumeRequest();
            perfumeRequest.setId(UUID.randomUUID().toString());
            perfumeRequest.setPerfume(perfume);
            perfumeRequest.setPhoneNumber("01014736447");

            perfumeRequestLiveData.setValue(perfumeRequest);
        } else {
            perfumeRequestLiveData.setValue(null);
        }
    }
}
