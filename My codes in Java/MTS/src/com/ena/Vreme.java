package com.ena;

public class Vreme {

    private int sat;
    private int minut;
    private int sekunda;

    public Vreme(int sat, int minut, int sekunda) {

        if (this.sat >= 24) {
            this.sat = sat;
        } else {
            System.out.println("Pogresan unos sati.");
        }

        if (this.minut <= 60) {
            this.minut = minut;
        } else {
            System.out.println("Pogresan unos minuta.");
        }

        if (this.sekunda <= 60) {
            this.sekunda = sekunda;
        } else {
            System.out.println("Pogresan unos sekundi");
        }
    }


    public Vreme(Vreme vreme) {
        this.sat = vreme.sat;
        this.minut = vreme.minut;
        this.sekunda = vreme.sekunda;
    }


    public int getSat() {
        return sat;
    }

    public void setSat(int sat) {
        this.sat = sat;
    }

    public int getMinut() {
        return minut;
    }

    public void setMinut(int minut) {
        this.minut = minut;
    }

    public int getSekunda() {
        return sekunda;
    }

    public void setSekunda(int sekunda) {
        this.sekunda = sekunda;
    }
}
