package com.ena;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacunarskiFakultet {

    private String nazivKoferencije;
    private ArrayList<Ucionica> ucionice;
    private ArrayList<Kandidat> prijavljeniKandidati;
    private ArrayList<Dogadjaj> dogadjaji;
    private ArrayList<Ucesnik> ucesniciKoferencije;


    private ArrayList<Ucesnik> listaNajboljih;

    public RacunarskiFakultet(String nazivKoferencije, ArrayList<Ucionica> ucionice) {
        this.nazivKoferencije = nazivKoferencije;
        this.ucionice = ucionice;
        this.prijavljeniKandidati = new ArrayList<>();
        this.dogadjaji = new ArrayList<>();
        this.ucesniciKoferencije = new ArrayList<>();
    }


    public void prijavaKandidata(String imePrezime, String grad) {
//        this.prijavljeniKandidati.add(new Kandidat(imePrezime,grad));
        // POKUSAC 250:
        Kandidat kandidat = new Kandidat(imePrezime, grad);
        kandidat.polaganjeTesta();
        this.prijavljeniKandidati.add(kandidat);
    }


    public void dodavanjeDogadjajaRafu(Dogadjaj dogadjaj){
        this.dogadjaji.add(dogadjaj);
    }


    public void polaganjeTesta() {

        Collections.sort(prijavljeniKandidati);

        System.out.println("\nBodovna lista: \n");
        for (int i = 0; i < prijavljeniKandidati.size(); i++) {
            System.out.println((i + 1) + ". Kandidat: " + prijavljeniKandidati.get(i).getImePrezime() + " = " +
                    prijavljeniKandidati.get(i).getBrojPoena());
        }
        /////////////////////////////////
        int prijavljenihUkupno = prijavljeniKandidati.size();
        listaNajboljih = new ArrayList<>();
        int brMogMest = brojMogucihMesta();
        if (brMogMest<prijavljenihUkupno){
            for (int i=0;i<brMogMest;i++){
                listaNajboljih.add(new Ucesnik(prijavljeniKandidati.get(i)));
            }
        }else {
            for (int i=0;i<prijavljenihUkupno;i++){
                listaNajboljih.add(new Ucesnik(prijavljeniKandidati.get(i)));
            }
        }
    }



    public void spisakUspesnihUcesnika(){
        System.out.println("\nNAJUSPESNIJI: \n");
        for (int i=0;i<listaNajboljih.size();i++){
            System.out.println((i+1)+". "+listaNajboljih.get(i).getImePrezime());
        }
    }


    private int brojMogucihMesta() {
        int brojMogucihMesta = 0;
        for (int i = 0; i < ucionice.size(); i++) {  ///// ??? NE ZNAM STA HOCE OVDE.....
            brojMogucihMesta += ucionice.get(i).getBrojMesta();
        }
        return brojMogucihMesta;
    }

    private List<Glasanje> vratiDogadjajeGlasanja() {
        ArrayList<Glasanje> dogadjajiGlasanja = new ArrayList();
        for (int i = 0; i < this.dogadjaji.size(); i++) {
            if (dogadjaji.get(i) instanceof Glasanje) {

                dogadjajiGlasanja.add((Glasanje) dogadjaji.get(i));
            }
        }
        return dogadjajiGlasanja;
    }


    public void odaberiDogadjaje() {
        ArrayList<Glasanje> svaPredavanja = (ArrayList)vratiDogadjajeGlasanja();

        for (Ucesnik uc: ucesniciKoferencije){
            uc.glasaj(svaPredavanja);
        }
        //Collections.sort(svaPredavanja);
        System.out.println("Ukupno predavanja : "+svaPredavanja.size());



    }


    public void odstampajDogadjajeIUcesnike() {


                try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("ucesnici.txt")));

            bw.write("Ucesnici:");
            bw.newLine();
            bw.write("____________________");
            bw.newLine();

            for(Ucesnik uc : listaNajboljih){
                bw.write(uc.toString());
                bw.newLine();
            }

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    @Override
    public String toString() {
        return "RacunarskiFakultet{" +
                "\nnazivKoferencije='" + nazivKoferencije + '\'' +
                "\n, ucionice=" + ucionice +
                "\n, prijavljeniKandidati=" + prijavljeniKandidati +
                "\n, dogadjaji=" + dogadjaji +
                "\n, ucesniciKoferencije=" + ucesniciKoferencije;
    }
}
