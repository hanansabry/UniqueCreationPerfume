package com.app.ucp.model;

public class Perfume {

    private String id;
    private FragranceConcentration fragranceConcentration;
    private NoteConcentration noteConcentration;
    private FragranceFamily fragranceFamily;
    private BottleShape bottleShape;
    private double price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FragranceConcentration getFragranceConcentration() {
        return fragranceConcentration;
    }

    public void setFragranceConcentration(FragranceConcentration fragranceConcentration) {
        this.fragranceConcentration = fragranceConcentration;
    }

    public NoteConcentration getNoteConcentration() {
        return noteConcentration;
    }

    public void setNoteConcentration(NoteConcentration noteConcentration) {
        this.noteConcentration = noteConcentration;
    }

    public FragranceFamily getFragranceFamily() {
        return fragranceFamily;
    }

    public void setFragranceFamily(FragranceFamily fragranceFamily) {
        this.fragranceFamily = fragranceFamily;
    }

    public BottleShape getBottleShape() {
        return bottleShape;
    }

    public void setBottleShape(BottleShape bottleShape) {
        this.bottleShape = bottleShape;
    }

    public double getPrice() {
        return price;
    }

    public void updatePrice(double price) {
        this.price = price;
    }
}
