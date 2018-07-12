package com.ena;

public class Cd {


    protected String naziv;
    protected int trajanjeMinuta;
    protected Datum izajmljivanja;


    public Cd(String naziv, int trajanjeMinuta, Datum izajmljivanja) {
        this.naziv = naziv;
        this.trajanjeMinuta = trajanjeMinuta;
        this.izajmljivanja = izajmljivanja;
    }

    public Cd(String naziv, Datum izajmljivanja) {
        this.naziv = naziv;
        this.trajanjeMinuta = 90;
        this.izajmljivanja = izajmljivanja;
    }

    public Cd() {
        this.naziv = "Defaultni film";
        this.trajanjeMinuta = 60;
        this.izajmljivanja = new Datum(1, 1, 2011);
    }

    @Override
    public String toString() {
        return "Naziv filma je " + naziv + " on traje" + trajanjeMinuta + " minuta.";
    }


    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getTrajanjeMinuta() {
        return trajanjeMinuta;
    }

    public void setTrajanjeMinuta(int trajanjeMinuta) {
        this.trajanjeMinuta = trajanjeMinuta;
    }

    public Datum getIzajmljivanja() {
        return izajmljivanja;
    }

    public void setIzajmljivanja(Datum izajmljivanja) {
        this.izajmljivanja = izajmljivanja;
    }
}
