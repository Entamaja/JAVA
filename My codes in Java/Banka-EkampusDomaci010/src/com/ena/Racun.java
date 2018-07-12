package com.ena;

import java.util.ArrayList;

public abstract class Racun {

    protected String brojRacuna;
    protected Valuta valuta;
    protected double stanjeRacuna;
    protected Datum poslednjaUplata;
    protected Datum posladnjaIsplata;

    protected ArrayList<Uplata> poslednjih10Uplata;
    protected ArrayList<Isplata> poslednjih10Isplata;


    public Racun(String brojRacuna, Valuta valuta, double stanjeRacuna, Datum poslednjaUplata, Datum posladnjaIsplata) {
        this.brojRacuna = brojRacuna;
        this.valuta = valuta;
        this.stanjeRacuna = stanjeRacuna;
        this.poslednjaUplata = poslednjaUplata;
        this.posladnjaIsplata = posladnjaIsplata;
        this.poslednjih10Uplata = new ArrayList<>();
        this.poslednjih10Isplata = new ArrayList<>();
    }




    public Racun(Racun racun) {
        this.brojRacuna = racun.brojRacuna;
        this.valuta = racun.valuta;
        this.stanjeRacuna = racun.stanjeRacuna;
        this.poslednjaUplata = racun.poslednjaUplata;
        this.posladnjaIsplata = racun.posladnjaIsplata;
        this.poslednjih10Uplata = new ArrayList<>();
        this.poslednjih10Isplata = new ArrayList<>();
    }


    abstract void realizujUplatu(Uplata u);

    abstract boolean realizujIsplatu(Isplata i);


    //getteri i setteri


    public String getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(String brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public Valuta getValuta() {
        return valuta;
    }

    public void setValuta(Valuta valuta) {
        this.valuta = valuta;
    }

    public double getStanjeRacuna() {
        return stanjeRacuna;
    }

    public void setStanjeRacuna(double stanjeRacuna) {
        this.stanjeRacuna = stanjeRacuna;
    }

    public Datum getPoslednjaUplata() {
        return poslednjaUplata;
    }

    public void setPoslednjaUplata(Datum poslednjaUplata) {
        this.poslednjaUplata = poslednjaUplata;
    }

    public Datum getPosladnjaIsplata() {
        return posladnjaIsplata;
    }

    public void setPosladnjaIsplata(Datum posladnjaIsplata) {
        this.posladnjaIsplata = posladnjaIsplata;
    }

    public ArrayList<Uplata> getPoslednjih10Uplata() {
        return poslednjih10Uplata;
    }

    public void setPoslednjih10Uplata(ArrayList<Uplata> poslednjih10Uplata) {
        this.poslednjih10Uplata = poslednjih10Uplata;
    }

    public ArrayList<Isplata> getPoslednjih10Isplata() {
        return poslednjih10Isplata;
    }

    public void setPoslednjih10Isplata(ArrayList<Isplata> poslednjih10Isplata) {
        this.poslednjih10Isplata = poslednjih10Isplata;
    }


    @Override
    public String toString() {
        return "Racun{" +
                "brojRacuna='" + brojRacuna + '\'' +
                ", valuta=" + valuta +
                ", stanjeRacuna=" + stanjeRacuna +
                ", poslednjaUplata=" + poslednjaUplata +
                ", posladnjaIsplata=" + posladnjaIsplata +
                ", poslednjih10Uplata=" + poslednjih10Uplata +
                ", poslednjih10Isplata=" + poslednjih10Isplata +
                '}';
    }

    public void ispisUplata() {
        System.out.println("-------------------------------");
        for (int i = 0; i < this.poslednjih10Uplata.size(); i++) {
            System.out.println("Uplata " + (i + 1) + "." + this.getPoslednjih10Uplata().get(i));
            System.out.println("-------------------------------");
        }
    }


    public void ispisIsplata() {
        System.out.println("-------------------------------");
        for (int i = 0; i < this.poslednjih10Isplata.size(); i++) {
            System.out.println("Isplata " + (i + 1) + "." + this.getPoslednjih10Isplata().get(i));
            System.out.println("-------------------------------");
        }
    }



}
