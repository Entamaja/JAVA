package com.ena;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Osoba> osobe = new ArrayList<>();


    public static void main(String[] args) {


        System.out.println("Koliko osoba kreiramo: \n");
        int brojOsoba = sc.nextInt();
        sc.nextLine();

        ArrayList<OsobaD> osobeD = new ArrayList<>();
        ArrayList<OsobaJMBG> osobaJMBGS = new ArrayList<>();


        for (int i = 0; i < brojOsoba; i++) {
            System.out.println("Ime " + (i + 1) + ". osobe: ");
            String ime = sc.nextLine();
            System.out.println("Prezime " + (i + 1) + ". osobe: ");
            String prezime = sc.nextLine();
            System.out.println("Adresa " + (i + 1) + ". osobe: ");
            String adresa = sc.nextLine();

            System.out.println("Izabrite opcije: \n1 - zna se datum rodjenja osobe\n2-Zna se JMBG osobe\n3-Ne zna se nista");
            int akcija = sc.nextInt();
            sc.nextLine();


            if (akcija == 1) {
                System.out.println("Unosenje Datuma: \n" +
                        "Unesite dan rodjenja: ");
                int dan = sc.nextInt();
                sc.nextLine();
                System.out.println("Unesite mesec rodjenja: ");
                int mesec = sc.nextInt();
                sc.nextLine();
                System.out.println("Unesite godinu rodjenja: ");
                int god = sc.nextInt();
                sc.nextLine();

                Datum datum = new Datum(dan, mesec, god);
                if (!prestupnaGodina(god) && validanUnosDatuma(datum)) {
                    OsobaD osoba = new OsobaD(ime, prezime, adresa, datum);
                    osobe.add(osoba);
                    osobeD.add(osoba);


                }

            } else if (akcija == 2) {

                System.out.println("Unesite JMBG: ");
                String jmbg = sc.nextLine();

                if (validacijaJmbg(jmbg)) {
                    OsobaJMBG osoba = new OsobaJMBG(ime, prezime, adresa, jmbg);
//                        OsobaD osobaNova = osoba.prebacivanje(osoba);
                    osobe.add(osoba);
                    osobaJMBGS.add(osoba);

                } else {
                    System.out.println("gresa");


                }

            } else {
                osobe.add(new Osoba(ime, prezime, adresa));
            }

        }

        System.out.println("\n\nDANASNJI DATUM: ");
        System.out.println("Unosenje DAN:");
        int danDanas = sc.nextInt();
        sc.nextLine();
        System.out.println("Unesite mesec: ");
        int mesecDanas = sc.nextInt();
        sc.nextLine();
        System.out.println("Unesite tekucu godinu: ");
        int godDanas = sc.nextInt();
        sc.nextLine();

        Datum danasnjiDatum = new Datum(danDanas, mesecDanas, godDanas);


        for (int i = 0; i < osobeD.size(); i++) {
            OsobaD test = osobeD.get(i);
            boolean nule = test.imaLiNule(danasnjiDatum);
            if ((test.numeroloskiBrojOsobe() != 7) && (nule == true)) {
                test.metabozilam(danasnjiDatum);
            } else {
                test.setMetabolizam("");
            }
        }


        for (int i = 0; i < osobaJMBGS.size(); i++) {
            OsobaJMBG test = osobaJMBGS.get(i);
            boolean nule = test.imaLiNule(danasnjiDatum);
            if ((test.numeroloskiBrojOsobe() != 7) && (nule == true)) {
                test.metabozilam(danasnjiDatum);
            } else {
                test.setMetabolizam("");
            }
        }


        for (int i = 0; i < osobe.size(); i++) {
            System.out.println((i + 1) + ". Osoba " + osobe.get(i) + "\n");
        }
    }

    public static boolean prestupnaGodina(int godina) {
        if ((godina % 100 != 0) && (godina % 400 == 0) || (godina % 4 == 0)) {
            System.out.println("PRESTUPNA GODINA!");
            return true;
        }
        return false;
    }

    public static boolean validanUnosDatuma(Datum datum) {
        if (datum.getDan() > 0 && datum.getDan() <= 31) {
            return true;
        }

        if (datum.getMesec() > 0 && datum.getMesec() <= 12) {
            return true;
        } else {
            System.out.println("NEPAVILAN UNOS DATUMA!!");
            return false;
        }
    }


    public static boolean validacijaJmbg(String jmbg) {

        String deo1 = "" + jmbg.charAt(0);
        String deo2 = "" + jmbg.charAt(1);
        int d1 = Integer.parseInt(deo1);
        int d2 = Integer.parseInt(deo2);
        int dan;
        if (d1 == 0) {
            dan = d2;
        } else {
            dan = d1 * 10 + d2;
        }

        String deo3 = "" + jmbg.charAt(2);
        String deo4 = "" + jmbg.charAt(3);
        int d3 = Integer.parseInt(deo3);
        int d4 = Integer.parseInt(deo4);
        int mesec;
        if (d3 == 0) {
            mesec = d4;
        } else {
            mesec = d3 * 10 + d4;
        }

        String deo5 = "" + jmbg.charAt(4);
        String deo6 = "" + jmbg.charAt(5);
        String deo7 = "" + jmbg.charAt(6);
        int d5 = Integer.parseInt(deo4);
        int d6 = Integer.parseInt(deo5);
        int d7 = Integer.parseInt(deo6);
        int godina;
        if (d5 == 0) {
            godina = 2000 + (d6 * 10) + d7;
        } else {
            godina = 1000 + (d5 * 100) + (d6 * 10) + d7;
        }
        // ...validacija
        if ((dan > 0 && dan <= 31) && (mesec > 0 && mesec <= 12) && (godina > 0)) {
            return true;
        } else {
            System.out.println("Pogresan format JMBG-a , unos nije VALIDAN!");
            return false;
        }
    }


}


