package com.app.ucp.model;

public class NoteConcentration {

    private int topNote;
    private int middleNote;
    private int baseNote;
    private int priceRate;

    public int getTopNote() {
        return topNote;
    }

    public void setTopNote(int topNote) {
        this.topNote = topNote;
    }

    public int getMiddleNote() {
        return middleNote;
    }

    public void setMiddleNote(int middleNote) {
        this.middleNote = middleNote;
    }

    public int getBaseNote() {
        return baseNote;
    }

    public void setBaseNote(int baseNote) {
        this.baseNote = baseNote;
    }

    public int getPriceRate() {
        return priceRate;
    }

    public void setPriceRate(int priceRate) {
        this.priceRate = priceRate;
    }

    public enum NotePriceRate {
        TOP(1), MIDDLE(2), BASE(3);
        private int rate;
        NotePriceRate(int rate) {
            this.rate = rate;
        }

        public int getRate() {
            return rate;
        }
    }
}
