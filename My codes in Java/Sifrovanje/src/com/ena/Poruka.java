package com.ena;

public class Poruka {
    protected String tekstPoruke;



    public Poruka(String tekstPoruke) {

        this.tekstPoruke = tekstPoruke;
    }

    public Poruka(Poruka poruka) {

        this.tekstPoruke = poruka.tekstPoruke;
    }

    public String getTekstPoruke() {

        return tekstPoruke;
    }

    public void setTekstPoruke(String tekstPoruke) {

        this.tekstPoruke = tekstPoruke;
    }

    @Override
    public String toString() {
        return "Tajna poruka: " + tekstPoruke;
    }





}
