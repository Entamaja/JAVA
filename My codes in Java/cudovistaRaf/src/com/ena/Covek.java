package com.ena;


public class Covek implements Igrac {

    private String ime;
    private int brojPoena;
    private int bonus;

    public Covek(String ime, int brojPoena, int bonus) {
        this.ime = ime;
        this.brojPoena = brojPoena;
        this.bonus = bonus;
    }

    @Override
    public void pobedi(Igrac protivnik) {
        brojPoena +=10;
        if (protivnik instanceof Covek){
           this.brojPoena+= ((Covek) protivnik).bonus;

        }
        System.out.println("COVEK JE POBEDIO sa poenima: "+ this.brojPoena);
    }

    @Override
    public String toString() {
        return "Covek{" +
                "ime='" + ime + '\'' +
                ", brojPoena=" + brojPoena +
                ", bonus=" + bonus +
                '}';
    }
}
