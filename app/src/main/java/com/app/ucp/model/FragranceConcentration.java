package com.app.ucp.model;

public class FragranceConcentration {

    private String fragrance;
    private String purePerfume;
    private int remainUpTo;
    private int priceRate;

    public FragranceConcentration() {
    }

    public FragranceConcentration(String fragrance, String purePerfume, int remainUpTo, int priceRate) {
        this.fragrance = fragrance;
        this.purePerfume = purePerfume;
        this.remainUpTo = remainUpTo;
        this.priceRate = priceRate;
    }

    public String getFragrance() {
        return fragrance;
    }

    public void setFragrance(String fragrance) {
        this.fragrance = fragrance;
    }

    public String getPurePerfume() {
        return purePerfume;
    }

    public void setPurePerfume(String purePerfume) {
        this.purePerfume = purePerfume;
    }

    public int getRemainUpTo() {
        return remainUpTo;
    }

    public void setRemainUpTo(int remainUpTo) {
        this.remainUpTo = remainUpTo;
    }

    public int getPriceRate() {
        return priceRate;
    }

    public void setPriceRate(int priceRate) {
        this.priceRate = priceRate;
    }
}
