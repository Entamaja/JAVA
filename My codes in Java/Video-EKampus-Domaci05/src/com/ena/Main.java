package com.ena;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Cd> cdovi = new ArrayList<>();


    public static void main(String[] args) {

        int maxUnos = 2;
        String unos = "";
        int trajanje = 0;


//        while (maxUnos != 0) {
//
//            System.out.println("Unositi NASLOV , pa TRAJANJE ...");
//            unos = sc.nextLine();
//            trajanje = sc.nextInt();
//            sc.nextLine();
//            System.out.println("ODABERI: \n" +
//                    "m - muzicki\n" +
//                    "f - filmski\n");
//
//            String mf = sc.nextLine();
//
//
//            if (mf.equals("m")) {
//                System.out.println("Kada si uzela taj cd?\n");
//                int dan = sc.nextInt();
//                sc.nextLine();
//                int mesec = sc.nextInt();
//                sc.nextLine();
//                int godina = sc.nextInt();
//                sc.nextLine();
//
//                Datum datum = new Datum(dan, mesec, godina);
//
//                MuzickiCd cd1 = new MuzickiCd(unos, trajanje, datum);
//                cdovi.add(cd1);
//                maxUnos--;
//
//            } else if (mf.equals("f")) {
//                System.out.println("Kako se zove reziser?");
//                String reziser = sc.nextLine();
//
//                System.out.println("Kako se zove glavni glumac?");
//                String glavniGlumac = sc.nextLine();
//
//
//                System.out.println("Kada si uzela taj cd?\n");
//                int dan = sc.nextInt();
//                sc.nextLine();
//                int mesec = sc.nextInt();
//                sc.nextLine();
//                int godina = sc.nextInt();
//                sc.nextLine();
//
//                Datum datum = new Datum(dan, mesec, godina);
//
//                FilmskiCd cd2 = new FilmskiCd(unos, datum, reziser, glavniGlumac);
//                cdovi.add(cd2);
//                maxUnos--;
//
//            }
//        }

        Datum datum = new Datum(23, 5, 2018);
        MuzickiCd m1 = new MuzickiCd("n1", 60, datum);
        Datum datum2 = new Datum(29, 5, 2018);
        MuzickiCd m2 = new MuzickiCd("n2", 45, datum2);
        Datum datum3 = new Datum(30, 5, 2018);
        FilmskiCd f1 = new FilmskiCd("f1", datum3, "Resiser mika0", "Leonar");

        Datum datum4 = new Datum(29, 12, 2018);
        MuzickiCd m4 = new MuzickiCd("n1", 60, datum4);
        Datum datum5 = new Datum(8, 5, 2018);
        FilmskiCd f2 = new FilmskiCd("f3551", datum5, "Resiser mika0", "Leonar");

        cdovi.add(m1);
        cdovi.add(m2);
        cdovi.add(f1);
        cdovi.add(m4);
        cdovi.add(f2);


        Datum danasnjiDatum = new Datum(31, 5, 2018);

        ArrayList<MuzickiCd> muzickiCds = new ArrayList<>();
        ArrayList<FilmskiCd> FilmsiCds = new ArrayList<>();
        for (int i = 0; i < cdovi.size(); i++) {
            if (cdovi.get(i).getClass() == MuzickiCd.class) {

                Cd temp = cdovi.get(i);
                muzickiCds.add((MuzickiCd) temp);
            } else {

                Cd temp = cdovi.get(i);
                FilmsiCds.add((FilmskiCd) temp);
            }
        }

        for (int i = 0; i < muzickiCds.size(); i++) {
            System.out.println("Datum izdavanja: " + muzickiCds.get(i).getIzajmljivanja() + "\n" +
                    "Datum vracanja:" + muzickiCds.get(i).datumVracanja(muzickiCds.get(i).getIzajmljivanja()));
            Datum datumVracanja = muzickiCds.get(i).datumVracanja(muzickiCds.get(i).getIzajmljivanja());
            if (datumVracanja.isti(danasnjiDatum)) {
                System.out.println("Danas treba vratiti: " + muzickiCds.get(i).getNaziv());
            }
            System.out.println("_____________________");
        }


        for (int i = 0; i < FilmsiCds.size(); i++) {

            System.out.println("Datum izdavanja: " + FilmsiCds.get(i).getIzajmljivanja() + "\n" +
                    "Datum vracanja:" + FilmsiCds.get(i).datumVracanja(FilmsiCds.get(i).getIzajmljivanja()));
            Datum datumVracanja2 = FilmsiCds.get(i).datumVracanja(FilmsiCds.get(i).getIzajmljivanja());
            if (datumVracanja2.isti(danasnjiDatum)) {
                System.out.println("Danas treba vratiti: " + FilmsiCds.get(i).getNaziv());
            }
        }


//??????????????????????????????????????? nou

//        for (int i = 0; i < cdovi.size(); i++) {
//            if (cdovi.get(i).getIzajmljivanja().isti(danasnjiDatum)) {
//                System.out.println("Danas treba vratiti: " + cdovi.get(i).getNaziv());
//            }else {
//                System.out.println("Nema filma koji se vraca danas ");
//            }
//        }


    }
}
