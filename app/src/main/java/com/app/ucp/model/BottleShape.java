package com.app.ucp.model;

public class BottleShape {

    private String imageUrl;
    private int price;

    public BottleShape() {
    }

    public BottleShape(String imageUrl, int price) {
        this.imageUrl = imageUrl;
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
