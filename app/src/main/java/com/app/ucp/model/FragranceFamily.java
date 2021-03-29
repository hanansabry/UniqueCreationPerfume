package com.app.ucp.model;

public class FragranceFamily {

    private String category;
    private String perfume;
    private String description;
    private int priceRate;

    public FragranceFamily() {
    }

    public FragranceFamily(String category, String perfume, String description, int priceRate) {
        this.category = category;
        this.perfume = perfume;
        this.description = description;
        this.priceRate = priceRate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPerfume() {
        return perfume;
    }

    public void setPerfume(String perfume) {
        this.perfume = perfume;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriceRate() {
        return priceRate;
    }

    public void setPriceRate(int priceRate) {
        this.priceRate = priceRate;
    }
}
