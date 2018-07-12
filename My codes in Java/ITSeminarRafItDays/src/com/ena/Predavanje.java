package com.ena;

import java.time.LocalDateTime;

public class Predavanje extends Dogadjaj implements Glasanje,Comparable{

       private int brojGlasova;
       private boolean potrebanProjektor;

    public Predavanje(String nazivDogadjaja, String imePredavaca, LocalDateTime vremePocetka, boolean potrebanProjektor) {
        super(nazivDogadjaja, imePredavaca, vremePocetka);
        this.brojGlasova = 0;
        this.potrebanProjektor = potrebanProjektor;
    }

    public int getBrojGlasova() {
        return brojGlasova;
    }

    @Override
    public void glasaj() {
        brojGlasova++;
    }

    @Override
    public int compareTo(Object obj) {
        Predavanje predavanjeZaPoredjenje= (Predavanje)obj;
        return predavanjeZaPoredjenje.brojGlasova - this.brojGlasova;
    }



}
