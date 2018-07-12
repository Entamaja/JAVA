package com.ena;

public class MuzickiCd extends Cd{



        private String autor;

    public MuzickiCd(String naziv, int trajanjeMinuta, Datum izajmljivanja, String autor) {
        super(naziv, trajanjeMinuta, izajmljivanja);
        this.autor = autor;
    }
    public MuzickiCd(String naziv, int trajanjeMinuta, Datum izajmljivanja) {
        super(naziv, trajanjeMinuta, izajmljivanja);
        this.autor = "nepoznat";
    }



    public Datum datumVracanja(Datum datumKadJeUzet){
        int maxDana = 3;
        Datum datumMaximalnogZadrzavanja = datumKadJeUzet;
        while (maxDana>0){
            datumMaximalnogZadrzavanja = datumMaximalnogZadrzavanja.sledeciDatum2();
            maxDana--;
            if (maxDana!=0){
                continue;
            }
            return datumMaximalnogZadrzavanja;
        }
        System.out.println("OPET - Datum vracanja "+datumMaximalnogZadrzavanja);
        return null;
    }


    @Override
    public String toString() {
        return "Autor je " + autor;
    }


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
