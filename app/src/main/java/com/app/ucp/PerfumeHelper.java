package com.app.ucp;

import android.content.Context;
import android.content.SharedPreferences;

import com.app.ucp.model.Perfume;
import com.google.gson.Gson;

public class PerfumeHelper {

    private SharedPreferences sharedPreferences;

    public PerfumeHelper(Context context) {
//        sharedPreferences = context.getSharedPreferences(Constants.SHARED_PREF, Context.MODE_PRIVATE);
    }

    public void updatePerfume(Perfume perfume) {
        //check if there is data already stored with this id
        Perfume oldPerfumeValue = getPerfume(perfume.getId());
        if (oldPerfumeValue != null) {
            perfume.updatePrice(oldPerfumeValue.getPrice() + perfume.getPrice());
        }
        //save updated value of perfume
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(perfume);
        prefsEditor.putString(perfume.getId(), json);
        prefsEditor.apply();
    }

    public String convertObjToJson(Perfume perfume) {
        Gson gson = new Gson();
        return gson.toJson(perfume);
    }

    public Perfume convertJsonToObj(String json) {
        Gson gson = new Gson();
        return (Perfume) gson.fromJson(json, Perfume.class);
    }

    public Perfume getPerfume(String id) {
        Gson gson = new Gson();
        String json = sharedPreferences.getString(id, "");
        return (Perfume) gson.fromJson(json, Perfume.class);
    }

    public void removePerfumeFromSharedPrefs(String id) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.remove(id);
    }
}
