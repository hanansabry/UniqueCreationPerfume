package com.app.ucp.model;

public class PerfumeRequest {

    private String id;
    private Perfume perfume;
    private String phoneNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Perfume getPerfume() {
        return perfume;
    }

    public void setPerfume(Perfume perfume) {
        this.perfume = perfume;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
