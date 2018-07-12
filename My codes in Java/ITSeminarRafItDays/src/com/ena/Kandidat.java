package com.ena;


import java.util.ArrayList;
import java.util.Random;

public class Kandidat implements Test, Comparable<Kandidat> {

    protected String imePrezime;
    protected String grad;
    protected int brojPoena;

    ArrayList<Kandidat> polaganjeTestaListaKandidata;

    public Kandidat(String imePrezime, String grad) {
        this.imePrezime = imePrezime;
        this.grad = grad;
        this.brojPoena = 0;
    }


    @Override
    public int compareTo(Kandidat kandidatZaPoredjenje) {
        return kandidatZaPoredjenje.getBrojPoena() - brojPoena;
    }

    @Override
    public void polaganjeTesta() {
        this.polaganjeTestaListaKandidata = new ArrayList<>();
        Random random = new Random();
        int randomPoeni = random.nextInt(100); // 30 je kao maximum
        this.brojPoena = randomPoeni;
        polaganjeTestaListaKandidata.add(this);
        System.out.println(this.imePrezime + " kandidat " + randomPoeni);
    }


    //getteri i setteri, toString..

    public int getBrojPoena() {
        return brojPoena;
    }

    public String getGrad() {
        return grad;
    }

    public String getImePrezime() {
        return imePrezime;
    }


    @Override
    public String toString() {
        return "\nimePrezime = " + imePrezime + "\n grad " + grad + "\n, brojPoena = " + brojPoena + "\n";
    }
}
