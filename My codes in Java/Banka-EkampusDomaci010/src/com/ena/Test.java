package com.ena;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Test {


    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Racun> racuni = new ArrayList<>();


    public static void main(String[] args) {

        System.out.println("Koliko racuna kreiramo: ");
        int kolikoRacuna = sc.nextInt();
        sc.nextLine();


        while (kolikoRacuna != 0) {


            System.out.println("Koji racun kreiramo: \n" +
                    "1. Osnovni \n" +
                    "2. Sa pozajmicom\n");
            int opcija = sc.nextInt();
            sc.nextLine();

            switch (opcija) {

                case 1:
                    System.out.println("OSNOVNI RACUN KREIRANJE \n" +
                            "Broj racuna: ");
                    String brojRacuna = sc.nextLine();
                    System.out.println("Valute: \n" +
                            "1. RSD \n" +
                            "2. EUR \n");
                    int valuta = sc.nextInt();
                    sc.nextLine();
                    if (valuta == 1) {
                        Valuta valuta1 = Valuta.RSD;
                    } else if (valuta == 2) {
                        Valuta valuta1 = Valuta.EUR;
                    }

                    System.out.println("Stanje racuna:\n" +
                            "1. 0.00 din\n" +
                            "2. unesi stanje");
                    int racun = sc.nextInt();
                    sc.nextLine();
                    if (racun == 1) {
                        racun = 0;
                    } else {
                        System.out.println("Unesite stanje racuna:");
                        double stanje = sc.nextDouble();
                        sc.nextLine();
                    }

                    System.out.println("Datum poslednje uplate: ");
                    int dan, mesec, godina;
                    dan = sc.nextInt();
                    mesec = sc.nextInt();
                    godina = sc.nextInt();
                    Datum datumUplate = new Datum(dan, mesec, godina);

                    System.out.println("Datum poslednje isplate: ");
                    int danI, mesecI, godinaI;
                    danI = sc.nextInt();
                    mesecI = sc.nextInt();
                    godinaI = sc.nextInt();

                    Datum datumIsplate = new Datum(danI, mesecI, godinaI);

                    OsnovniRacun osnovniRacun = new OsnovniRacun(brojRacuna, Valuta.RSD, racun, datumUplate, datumIsplate);
                    racuni.add(osnovniRacun);
                    kolikoRacuna--;
                    break;


                case 2:

                    System.out.println("RACUN SA POZAJMICOM KREIRANJE \n" +
                            "Broj racuna: ");
                    String brojRacunaSaPozajmicom = sc.nextLine();
                    System.out.println("Valute: \n" +
                            "1. RSD \n" +
                            "2. EUR \n");
                    int v = sc.nextInt();
                    sc.nextLine();
                    if (v == 1) {
                        Valuta va = Valuta.RSD;
                    } else if (v == 2) {
                        Valuta va = Valuta.EUR;
                    }

                    System.out.println("Stanje racuna:\n" +
                            "1. 0.00 din\n" +
                            "2. unesi stanje");
                    int racunSaPozajmicom = sc.nextInt();
                    sc.nextLine();
                    if (racunSaPozajmicom == 1) {
                        racunSaPozajmicom = 0;
                    } else {
                        System.out.println("Unesite stanje racuna:");
                        double stanje2 = sc.nextDouble();
                        sc.nextLine();
                    }

                    System.out.println("Datum poslednje uplate: ");
                    int dan2, mesec2, godina2;
                    dan2 = sc.nextInt();
                    sc.nextLine();
                    mesec2 = sc.nextInt();
                    sc.nextLine();
                    godina2 = sc.nextInt();
                    sc.nextLine();
                    Datum datumUplate2 = new Datum(dan2, mesec2, godina2);

                    System.out.println("Datum poslednje isplate: ");
                    int danI2, mesecI2, godinaI2;
                    danI2 = sc.nextInt();
                    sc.nextLine();
                    mesecI2 = sc.nextInt();
                    sc.nextLine();
                    godinaI2 = sc.nextInt();
                    sc.nextLine();

                    Datum datumIsplate2 = new Datum(danI2, mesecI2, godinaI2);

                    System.out.println("Dozvoljeni minus je :");
                    double minus = sc.nextDouble();
                    sc.nextLine();

                    RacunSaPozajmicom racunSaPoz = new RacunSaPozajmicom(brojRacunaSaPozajmicom, Valuta.RSD, datumUplate2, datumIsplate2, minus);
                    racuni.add(racunSaPoz);
                    kolikoRacuna--;
                    break;

            }
        }


        ////////////////////////////////////////////////////////////////////////
        for(Racun rac : racuni){
            if(rac instanceof OsnovniRacun){
                OsnovniRacun or = (OsnovniRacun)rac;
                // sada moze da koristi sve sto ima osnovni racun
            }
        }


        Random rand = new Random();
        int rng = rand.nextInt(kolikoRacuna);
        int slucajniBroj = (int) (Math.random() * kolikoRacuna);

        System.out.println("izabrani " + slucajniBroj);

        Racun izabrani = racuni.get(slucajniBroj);
        Uplata plata = new Uplata(izabrani.getBrojRacuna(), 200.55, new Datum(1, 1, 2018));
        izabrani.realizujUplatu(plata);
        izabrani.realizujUplatu(plata);
        izabrani.realizujUplatu(plata);
        izabrani.ispisUplata();
        izabrani.ispisIsplata();

        System.out.println("___________________________________________________________________________________");

        System.out.println(izabrani);


        if (izabrani.getClass().equals(RacunSaPozajmicom.class)) {
            System.out.println("Minus: ");
            double minus = sc.nextDouble();
            sc.nextLine();
            RacunSaPozajmicom rp = new RacunSaPozajmicom(izabrani.getBrojRacuna(), izabrani.getValuta(), izabrani.getStanjeRacuna(),
                    izabrani.getPoslednjaUplata(), izabrani.getPosladnjaIsplata(), minus);
            rp.pozajmiPare(2000);
            rp.pozajmiPare(2000);
            rp.getPoslednjih10Isplata();

        } else {
            System.out.println("cao ,cao, nema pozajmice");
        }


    }


}
