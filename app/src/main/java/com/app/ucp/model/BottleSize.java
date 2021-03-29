package com.app.ucp.model;

public class BottleSize {

    private String size;
    private int priceRate;

    public BottleSize() {
    }

    public BottleSize(String size, int priceRate) {
        this.size = size;
        this.priceRate = priceRate;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPriceRate() {
        return priceRate;
    }

    public void setPriceRate(int priceRate) {
        this.priceRate = priceRate;
    }
}
