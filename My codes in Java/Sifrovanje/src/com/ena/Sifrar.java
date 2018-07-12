package com.ena;

public abstract class Sifrar {

    protected Poruka poruka;


    public Sifrar(Poruka poruka) {
        this.poruka = poruka;
    }

    abstract Poruka sifruj(Poruka poruka);

}
