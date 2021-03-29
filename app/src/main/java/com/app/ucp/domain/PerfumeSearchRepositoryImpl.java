package com.app.ucp.domain;

import com.app.ucp.data.PerfumeSearchRepository;
import com.app.ucp.model.BottleShape;
import com.app.ucp.model.FragranceConcentration;
import com.app.ucp.model.FragranceFamily;
import com.app.ucp.model.NoteConcentration;
import com.app.ucp.model.Perfume;
import com.app.ucp.model.PerfumeRequest;

import java.util.ArrayList;
import java.util.List;
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

    @Override
    public void getReadyMadePerfumes(MutableLiveData<List<Perfume>> perfumeListLiveData) {
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

        Perfume perfume2 = new Perfume();
        perfume2.setBottleShape(bottleShape);
        FragranceFamily ff2 = new FragranceFamily("Category2", "Perfume2", "Desc", 3);
        perfume2.setFragranceFamily(ff2);
        perfume2.setNoteConcentration(nc);
        perfume2.setFragranceConcentration(fc);
        perfume2.setId(UUID.randomUUID().toString());
        perfume2.updatePrice(15);

        Perfume perfume3 = new Perfume();
        perfume3.setBottleShape(bottleShape);
        FragranceFamily ff3 = new FragranceFamily("Category3", "Perfume3", "Desc", 3);
        perfume3.setFragranceFamily(ff3);
        perfume3.setNoteConcentration(nc);
        perfume3.setFragranceConcentration(fc);
        perfume3.setId(UUID.randomUUID().toString());
        perfume3.updatePrice(6);

        Perfume perfume4 = new Perfume();
        perfume4.setBottleShape(bottleShape);
        FragranceFamily ff4 = new FragranceFamily("Category4", "Perfume4", "Desc", 3);
        perfume4.setFragranceFamily(ff4);
        perfume4.setNoteConcentration(nc);
        perfume4.setFragranceConcentration(fc);
        perfume4.setId(UUID.randomUUID().toString());
        perfume4.updatePrice(12);

        List<Perfume> perfumes = new ArrayList<>();
        perfumes.add(perfume);
        perfumes.add(perfume2);
        perfumes.add(perfume3);
        perfumes.add(perfume4);

        perfumeListLiveData.setValue(perfumes);
    }

    @Override
    public void getPerfumeRequests(MutableLiveData<List<PerfumeRequest>> perfumeRequestLiveData) {
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

        PerfumeRequest perfumeRequest1 = new PerfumeRequest();
        perfumeRequest1.setId(UUID.randomUUID().toString());
        perfumeRequest1.setPerfume(perfume);
        perfumeRequest1.setPhoneNumber("0101234567");

        PerfumeRequest perfumeRequest2 = new PerfumeRequest();
        perfumeRequest2.setId(UUID.randomUUID().toString());
        perfumeRequest2.setPerfume(perfume);
        perfumeRequest2.setPhoneNumber("01099424645");

        PerfumeRequest perfumeRequest3 = new PerfumeRequest();
        perfumeRequest3.setId(UUID.randomUUID().toString());
        perfumeRequest3.setPerfume(perfume);
        perfumeRequest3.setPhoneNumber("01021564876");

        List<PerfumeRequest> perfumeRequestList = new ArrayList<>();
        perfumeRequestList.add(perfumeRequest);
        perfumeRequestList.add(perfumeRequest1);
        perfumeRequestList.add(perfumeRequest2);
        perfumeRequestList.add(perfumeRequest3);

        perfumeRequestLiveData.setValue(perfumeRequestList);
    }
}
