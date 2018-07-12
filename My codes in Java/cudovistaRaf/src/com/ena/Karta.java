package com.ena;

public abstract class Karta {

    protected String naziv;
    protected int napad;
    protected int odbrana;
    protected boolean unistena;
    protected Polozaj polozaj;
    protected TipKarte tipKarte;

    public Karta(String naziv, int napad, int odbrana, Polozaj polozaj, TipKarte tipKarte) {
        this.naziv = naziv;
        this.napad = napad;
        this.odbrana = odbrana;
        this.unistena = false;
        this.polozaj = polozaj;
        this.tipKarte = tipKarte;
    }

    public abstract boolean napadni(Karta karta);
    public abstract void primiNapad(Karta karta);

    public int umanjiNapad(int energija){
        napad -= energija;
        if (napad<0){
            napad=0;
        }
        return napad;
    }

    public int umanjiOdbranu(int energija){
       odbrana -= energija;
        if (odbrana<0){
            odbrana = 0;
        }
        return odbrana;
    }


    @Override
    public String toString() {
        return "\nNaziv = " + naziv  +
                "\nNapad = " + napad +
                "\nOdbrana = " + odbrana +
                "\nUnistena = " + unistena +
                "\nPolozaj = " + polozaj +
                "\nTip Karte = " + tipKarte+
                "\n___________________________";
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getNapad() {
        return napad;
    }

    public void setNapad(int napad) {
        this.napad = napad;
    }

    public int getOdbrana() {
        return odbrana;
    }

    public void setOdbrana(int odbrana) {
        this.odbrana = odbrana;
    }

    public boolean isUnistena() {
        return unistena;
    }

    public void setUnistena(boolean unistena) {
        this.unistena = unistena;
    }

    public Polozaj getPolozaj() {
        return polozaj;
    }

    public void setPolozaj(Polozaj polozaj) {
        this.polozaj = polozaj;
    }

    public TipKarte getTipKarte() {
        return tipKarte;
    }

    public void setTipKarte(TipKarte tipKarte) {
        this.tipKarte = tipKarte;
    }




}
