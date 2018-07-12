package com.ena;

public class Razgovor {

    private String broj;
    private Vreme trajanjeRazgovora;


    public Razgovor(String broj, Vreme trajanjeRazgovora) {
        this.broj = broj;
        this.trajanjeRazgovora = trajanjeRazgovora;
    }

    public Razgovor(Razgovor razgovor) {
        this.broj = razgovor.broj;
        this.trajanjeRazgovora = razgovor.trajanjeRazgovora;
    }

    public String getBroj() {

        return broj;

    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public Vreme getTrajanjeRazgovora() {

        return trajanjeRazgovora;
    }

    public void setTrajanjeRazgovora(Vreme trajanjeRazgovora) {

        this.trajanjeRazgovora = trajanjeRazgovora;
    }


}
