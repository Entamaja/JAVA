package com.ena;

public class ObicnaKarta extends Karta {

    public ObicnaKarta(String naziv, int napad, int odbrana, Polozaj polozaj, TipKarte tipKarte) {
        super(naziv, napad, odbrana, polozaj, tipKarte);
    }

    @Override
    public boolean napadni(Karta protivnickaKarta) {
       polozaj=Polozaj.NAPAD;
       // this napada protivnicku kartu
       // ovo this je taj obj koji bude pozvao ovu metodu

       protivnickaKarta.primiNapad(this);
       return protivnickaKarta.unistena;

    }

    @Override
    public void primiNapad(Karta protivnickaKarta) {
        // this prima napd od protivnicke karte
        // this.primiNapad(protivnickaKarta);

        //ako je moja karta zamka - onda ce protivnik da primi napad od te zamke:
        if (this.tipKarte == TipKarte.ZAMKA){
            protivnickaKarta.primiNapad(this);   // ???????????????????????????????????????????????????????????????????????????????????????
            this.unistena = true;
        }else {
            if (this.polozaj == Polozaj.NAPAD){
                this.umanjiNapad(protivnickaKarta.napad);
                if(this.napad == 0) this.unistena = true;
            }else {
                this.umanjiOdbranu(protivnickaKarta.napad);
                if(this.odbrana == 0) this.unistena = true;
            }
        }
    }









}
