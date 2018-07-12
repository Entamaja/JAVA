package com.ena;

import java.util.ArrayList;
import java.util.Random;

public class Partija implements Igrac {


    private ArrayList<Karta> karte;
    private boolean podeljeneKarte;
    private Talon talon;


    // kao interfejs List
    private Igrac igrac1;
    private Igrac igrac2;

    public Partija(Igrac igrac1, Igrac igrac2) {
        this.podeljeneKarte = false;
        this.karte = new ArrayList<>();
        this.talon = new Talon(igrac1, igrac2);
        this.igrac1 = igrac1;
        this.igrac2 = igrac2;
    }


    @Override
    public void pobedi(Igrac igrac) {
        System.out.println("OVO JE PARTIJA.pobedi()-- sta bre treba ovde??");

    }


    public void dodajKartu(Karta karta) {

        // za koju partiju ?????????????????????????????????????????????????????????????? - za jednu jedinu
        karte.add(karta);
    }

    public boolean podeliKarte() {
        int brojKarata = karte.size();
        if (brojKarata < 10) {
            return false;
        } else {
            Random random = new Random();
            for (int i = 0; i < 5; i++) {
                int broj = random.nextInt(karte.size());
//                System.out.println(i+" (i) Random broj : \n"+broj);
                talon.dodajKartu(karte.get(broj), igrac1);
//                System.out.println("Dodaje "+igrac1.getClass().getName()+" igracu kartu ---> "+karte.get(broj).getNaziv()+"\n");
                karte.remove(broj);
                broj = random.nextInt(karte.size());
//                System.out.println(i+" (i) Random broj : \n"+broj);
                talon.dodajKartu(karte.get(broj), igrac2);
//                System.out.println("Dodaje "+igrac2.getClass().getName()+" igracu kartu ---> "+karte.get(broj).getNaziv()+"\n");
                karte.remove(broj);
            }
            this.podeljeneKarte = true;
            return true;
        }
    }


    public Igrac odigrajPartiju() {
        if (!podeliKarte()) {
            return null;
        }

        Random rand = new Random();
        while (true) {
            //na potezu prvi igrac
            if (talon.isUnisten(igrac1)) { //ako je unisten
                igrac2.pobedi(igrac1);
                return igrac2;
            }
            ArrayList<Karta> listaCudovista = talon.vratiCudovistaIgraca(igrac1); //dohvatam listu cudovista igraca 1
            int br = rand.nextInt(listaCudovista.size()); //biram nasumicno cudoviste
            double vrv = rand.nextDouble(); //odredjujem vrv da li da napadnem ili da ga stavim u odbranu
            Karta kartaPrvog = listaCudovista.get(br);
            if (vrv < 0.5) {//ako ce u odbranu
                kartaPrvog.setPolozaj(Polozaj.ODBRANA);
            } else {//ako ce da napdada.
                kartaPrvog.setPolozaj(Polozaj.NAPAD);
                ArrayList<Karta> listaZivihDrugog = talon.vratiZiveKarte(igrac2);//dohvatam zive karte drugog igraca
                int index2 = rand.nextInt(listaZivihDrugog.size());//neku nasumicnu zivu kartu drugog igraca
                listaZivihDrugog.get(index2).primiNapad(kartaPrvog);//i ona prima napad od moje arte
            }
            //sve to isto za drugog igraca jer je on na potezu
            if (talon.isUnisten(igrac2)) {
                igrac1.pobedi(igrac2);
                return igrac1;
            }
            //drugi igra
            ArrayList<Karta> listaCudovista2 = talon.vratiCudovistaIgraca(igrac2);
            int br2 = rand.nextInt(listaCudovista2.size());
            double vrv2 = rand.nextDouble();
            Karta kartaDrugog = listaCudovista2.get(br);
            if (vrv < 0.5) {
                kartaDrugog.setPolozaj(Polozaj.ODBRANA);
            } else {
                kartaDrugog.setPolozaj(Polozaj.NAPAD);
                ArrayList<Karta> listaZivihPrvog = talon.vratiZiveKarte(igrac1);
                int index2 = rand.nextInt(listaZivihPrvog.size());
                listaZivihPrvog.get(index2).primiNapad(kartaDrugog);
            }
            if (talon.isUnisten(igrac1)) {
                igrac2.pobedi(igrac1);
                return igrac2;
            }
        }

    }


    public Talon getTalon() {
        return talon;
    }


    @Override
    public String toString() {
        return "Partija{" +
                "karte=" + karte +
                ", podeljeneKarte=" + podeljeneKarte +
                ", talon=" + talon +
                ", igrac1=" + igrac1 +
                ", igrac2=" + igrac2 +
                '}';
    }




}