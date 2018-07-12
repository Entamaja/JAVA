package com.ena;

import java.util.Random;

public class RetkaKarta extends Karta {

    private double kriticnaVerovatnoca;

    public RetkaKarta(String naziv, int napad, int odbrana, Polozaj polozaj, TipKarte tipKarte, double kriticnaVerovatnoca) {
        super(naziv, napad, odbrana, polozaj, tipKarte);
        this.kriticnaVerovatnoca = kriticnaVerovatnoca;
    }

    @Override
    public boolean napadni(Karta protivnickaKarta) {

        polozaj = Polozaj.NAPAD;
        Random random = new Random();
        double rnd = random.nextDouble();
        if (rnd < kriticnaVerovatnoca) {
            this.napad += 50000;
            protivnickaKarta.primiNapad(this);
            napad -= 50000;

        } else {
            protivnickaKarta.primiNapad(this);
        }

        return protivnickaKarta.unistena;
    }



    @Override
    public void primiNapad(Karta protivnickaKarta) {
        Random random = new Random();
        double rnd = random.nextDouble();
        ////////
        if (this.tipKarte ==TipKarte.ZAMKA){
            if( rnd < this.kriticnaVerovatnoca) napad +=50000;
            protivnickaKarta.primiNapad(this);   // ???????????????????????????????????????????????????????????????????????????????????????
            if( rnd < this.kriticnaVerovatnoca) napad -=50000;
            this.unistena = true;

        }else {
            if (this.polozaj == Polozaj.NAPAD){
                this.umanjiNapad(protivnickaKarta.napad);
                if(this.napad == 0) this.unistena = true;
            }else {
                if (rnd >= kriticnaVerovatnoca) this.umanjiOdbranu(protivnickaKarta.napad);
                if (this.odbrana == 0) this.unistena = true;
            }
        }
    }






}
