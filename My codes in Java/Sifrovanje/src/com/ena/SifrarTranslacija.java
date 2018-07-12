package com.ena;

public class SifrarTranslacija extends Sifrar {

    private int pomeraj;


    public SifrarTranslacija(Poruka poruka, int pomeraj) {
        super(poruka);
        this.pomeraj = pomeraj;
    }


    public int getPomeraj() {
        return pomeraj;
    }

    public void setPomeraj(int pomeraj) {
        this.pomeraj = pomeraj;
    }


    @Override
    Poruka sifruj(Poruka poruka) {

        String porukaZaSifrovanje = poruka.getTekstPoruke();
        char[] slova = new char[porukaZaSifrovanje.length()];
        Poruka poruka1;

        String sifrovani = "";
        for (int i = 0; i < porukaZaSifrovanje.length(); i++) {
            slova[i] = porukaZaSifrovanje.charAt(i);
            if (slova[i] != ' ') {
                int x = (int) slova[i];  // int vrednost chara
                x += pomeraj;  // menja za pomeraj vrednost
                sifrovani += (char) x;
//                 Poruka sifrovana = new Poruka(sifrovani);
//                 System.out.print(sifrovani);
            } else {
                sifrovani += '!';
            }

        }
        poruka1 = new Poruka(sifrovani);
        return poruka1;
    }

    public String sifrovanaPoruka(Poruka poruka) {
        String sifrovanaPoruka = sifruj(poruka).getTekstPoruke();
        return sifrovanaPoruka;
    }


    @Override
    public String toString() {
        return "Tajna poruka: " + sifrovanaPoruka(poruka);
    }
}
