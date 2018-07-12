package com.ena;

public class SifrarRotacije extends Sifrar {

    private int pomeraj;
    private String smer;

    public SifrarRotacije(Poruka poruka, int pomeraj, String smer) {
        super(poruka);
        this.pomeraj = pomeraj;
        this.smer = smer;
    }


    @Override
    Poruka sifruj(Poruka poruka) {
        Poruka poruka1;

        String porukaZaSifrovanje = poruka.getTekstPoruke();
        if (smer == "levo") {
            String prviDeo = porukaZaSifrovanje.substring(0, pomeraj);
            porukaZaSifrovanje = porukaZaSifrovanje.substring(pomeraj);
            String novi = porukaZaSifrovanje + prviDeo;
            poruka1 = new Poruka(novi);
            return poruka1;
//            System.out.println(novi);
        } else if (smer == "desno") {

            int velicina = porukaZaSifrovanje.length();
            String drugiDeo = porukaZaSifrovanje.substring(velicina - pomeraj, velicina);
            porukaZaSifrovanje = porukaZaSifrovanje.substring(0, velicina - pomeraj);

            String novi = drugiDeo + porukaZaSifrovanje;
            poruka1 = new Poruka(novi);
            return poruka1;

//            System.out.println(novi);
        }


        return null;
    }


    public String sifrovanaPoruka(Poruka poruka) {
        String sifrovanaPoruka = sifruj(poruka).getTekstPoruke();
        return sifrovanaPoruka;
    }


    //GETTERI I SETTERI

    public int getPomeraj() {
        return pomeraj;
    }

    public void setPomeraj(int pomeraj) {
        this.pomeraj = pomeraj;
    }

    public String getSmer() {
        return smer;
    }

    public void setSmer(String smer) {
        this.smer = smer;
    }

    @Override
    public String toString() {
        return "Sifrovana poruka: " + sifrovanaPoruka(poruka);
    }
}
