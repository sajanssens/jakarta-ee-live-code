package com.infosupport.domain;

public class Aangifte {

    private String bsn;
    private double bedrag;

    public Aangifte() {
    }

    public Aangifte(String bsn, double bedrag) {
        this.bsn = bsn;
        this.bedrag = bedrag;
    }

    public String getBsn() {
        return bsn;
    }

    public void setBsn(String bsn) {
        this.bsn = bsn;
    }

    public double getBedrag() {
        return bedrag;
    }

    public void setBedrag(double bedrag) {
        this.bedrag = bedrag;
    }
}
