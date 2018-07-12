package com.ena;

public class Osoba {

    private String ime;
    private String prezime;
    private String adresa;


    public Osoba(String ime, String prezime, String adresa) {
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
    }

    public Osoba(Osoba o) {
        this.ime = o.ime;
        this.prezime = o.prezime;
        this.adresa = o.adresa;
    }


    public OsobaD prebacivanje(OsobaJMBG osobaJMBG){
        Datum datum = osobaJMBG.vracanjeDatuma(osobaJMBG.getJmbg());
        OsobaD osobaJMBGtoD = new OsobaD(osobaJMBG.getIme(),osobaJMBG.getPrezime(),osobaJMBG.getAdresa(),datum);
        return osobaJMBGtoD;
    }


    //GETTERI I SETERI
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }



    @Override
    public String toString() {
        return ime  + ", " + prezime + ", " + adresa;
    }
}



