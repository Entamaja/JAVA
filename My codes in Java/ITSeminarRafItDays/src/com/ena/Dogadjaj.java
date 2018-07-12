package com.ena;


import java.time.LocalDateTime;

public abstract class Dogadjaj {

    protected String nazivDogadjaja;
    protected String imePredavaca;
    protected LocalDateTime vremePocetka;


    public Dogadjaj(String nazivDogadjaja, String imePredavaca, LocalDateTime vremePocetka) {
        this.nazivDogadjaja = nazivDogadjaja;
        this.imePredavaca = imePredavaca;
        this.vremePocetka = vremePocetka;
    }





















    @Override
    public String toString() {
        return "Dogadjaj{" +
                "nazivDogadjaja='" + nazivDogadjaja + '\'' +
                ", imePredavaca='" + imePredavaca + '\'' +
                ", vremePocetka=" + vremePocetka +
                '}';
    }
}
