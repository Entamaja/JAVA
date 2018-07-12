package com.ena;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Talon {

    private Igrac prviIgrac;
    private Igrac drugiIgrac;
    private ArrayList<Karta> karte1;
    private ArrayList<Karta> karte2;


    public Talon(Igrac prviIgrac, Igrac drugiIgrac) {
        this.prviIgrac = prviIgrac;
        this.drugiIgrac = drugiIgrac;
        this.karte1 = new ArrayList<>();
        this.karte2 = new ArrayList<>();
    }


    public void dodajKartu(Karta karta, Igrac igrac){

        // KAKO DA ZNA KOM IGRACU DODAJEEE ???????????????????????????????????????????????????????A

        if (this.prviIgrac.equals(igrac)){
            karte1.add(karta);
        }else {
            karte2.add(karta);
        }

    }


    public void odstampajTalon(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("talon.txt")));

            bw.write("Prvi Igrac:\n");
            for(Karta kar : karte1){
                bw.write(kar.toString());
            }
            bw.write("Drugi igrac:\n");
            for(Karta kar : karte2){
                bw.write(kar.toString());
            }

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

// MOJ UZALUDNI POKUSAJI :)
//    public void odstampajTalon1(){
//
//        if (this == prviIgrac){
//            for (int i=0;i<karte1.size();i++){
//                System.out.println("Karta "+ (i+1)+". " +
//                                karte1.get(i));
//
//
//            }
//        }else if (this == drugiIgrac){
//            for (int i=0;i<karte2.size();i++){
//                System.out.println("Karta "+ (i+1)+". " +
//                        karte2.get(i));
//            }
//        }
//
//    }


    public ArrayList<Karta> vratiCudovistaIgraca(Igrac igrac) {
        ArrayList<Karta> listaKarataCudovista = new ArrayList<>();
        if (prviIgrac.equals(igrac)) {
            for (int i = 0; i < karte1.size(); i++) {
                Karta kar = karte1.get(i);
                if (kar.getTipKarte() == TipKarte.CUDOVISTE) {
                    listaKarataCudovista.add(kar);
                }
            }
            // preko kolekcijske for petlje
        } else {
            for (Karta k : karte2) {
                if (k.getTipKarte() == TipKarte.CUDOVISTE) {
                    listaKarataCudovista.add(k);
                }
            }
        }
        return listaKarataCudovista;
    }






    public ArrayList<Karta> vratiZiveKarte(Igrac igrac){
        ArrayList<Karta> ziveKarte = new ArrayList<>();

        if (prviIgrac.equals(igrac)) {
            for (int i = 0; i < karte1.size(); i++) {
                Karta kar = karte1.get(i);
                if (!(kar.isUnistena())) {
                    ziveKarte.add(kar);
                }
            }
            // preko kolekcijske for petlje
        } else {
            for (Karta k : karte2) {
                if (!(k.isUnistena())) {
                    ziveKarte.add(k);
                }
            }
        }
        return ziveKarte;
    }



    public boolean isUnisten(Igrac igrac){
        int brojCudovista = 0;
        if (prviIgrac.equals(igrac)) {    // ?????????????????????????????????????????????????????????????????? ko poziva ovo
            for (int i=0;i<karte1.size();i++){
                if (karte1.get(i).getTipKarte() == TipKarte.CUDOVISTE && karte1.get(i).isUnistena()==false){
                   return false;
                }
            }
        } else{
            brojCudovista = 0;
            for (int i=0;i<karte2.size();i++){
                if (karte2.get(i).getTipKarte() == TipKarte.CUDOVISTE && karte2.get(i).isUnistena()==false){
                    return false;
                }
            }
        }
        //System.out.println("Nesto ne valja....");
        return true;
    }









    }
