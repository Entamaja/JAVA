package com.ena;

public class Isplata {

    private String racunKorisnika;
    private double suma;
    private Datum datumUplate;


    public Isplata(String racunKorisnika, double suma, Datum datumUplate) {
        this.racunKorisnika = racunKorisnika;
        this.suma = suma;
        this.datumUplate = datumUplate;
    }


    //getteri i setteri


    public String getRacunKorisnika() {
        return racunKorisnika;
    }

    public void setRacunKorisnika(String racunKorisnika) {
        this.racunKorisnika = racunKorisnika;
    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public Datum getDatumUplate() {
        return datumUplate;
    }

    public void setDatumUplate(Datum datumUplate) {
        this.datumUplate = datumUplate;
    }
}
