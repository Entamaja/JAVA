package com.ena;

public class Main {

    public static void main(String[] args) {

//        ObicnaKarta mojaKarta = new ObicnaKarta("MOJA KARTA",75,100,Polozaj.NAPAD,TipKarte.CUDOVISTE);
//
//        ObicnaKarta protivnickaKarta = new ObicnaKarta("PROTIVNICKA KARTA",500,222,Polozaj.ODBRANA,TipKarte.ZAMKA);
//
//        System.out.println(mojaKarta.napadni(protivnickaKarta));
//
//        System.out.println("Cudoviste ima: NAPAD: "+mojaKarta.getNapad()+" | ODBRANA: "+mojaKarta.getOdbrana()+" u polozaju je "+ mojaKarta.getPolozaj());
//        System.out.println("Zamka je napadnuta, ima: NAPAD: "+protivnickaKarta.getNapad()+" | ODBRANA: "+protivnickaKarta.getOdbrana()+" u polozaju je "+ protivnickaKarta.getPolozaj()+" " +
//                "\n ova karta je "+protivnickaKarta.isUnistena()+" unistena.");


        Racunar racunar = new Racunar();
        Covek ena = new Covek("ena",200,50);
        Covek darko = new Covek("darko",300,100);



        /* KAKO DA NAPRAVIM TALON>???????? Talon tl = new Talon ( Igrac 1, Igrac 2
         jer --> Covek i Racunar implement Igrac (interface)
        */

//        Talon talon1 = new Talon(racunar,darko);
//        darko.pobedi(racunar);
//        darko.pobedi(racunar);
//        darko.pobedi(racunar);
//        darko.pobedi(racunar);


        Talon talon = new Talon(ena,darko);
//        ena.pobedi(darko);
//        ena.pobedi(darko);
//        ena.pobedi(darko);
//        ena.pobedi(darko);


        Karta k1 = new ObicnaKarta("cudoviste Godzila",220,100,Polozaj.NAPAD,TipKarte.CUDOVISTE);
        Karta k2 = new ObicnaKarta("cudoviste Godzila junior",1000,3000,Polozaj.NAPAD,TipKarte.CUDOVISTE);
        Karta k3 = new ObicnaKarta("cudoviste Ana",500000,10,Polozaj.ODBRANA,TipKarte.CUDOVISTE);
        Karta k4 = new RetkaKarta("Retko glupa zamka",150,60,Polozaj.ODBRANA,TipKarte.ZAMKA,200.50);
        Karta k5 = new RetkaKarta("Retko glupo cudoviste",201,100,Polozaj.ODBRANA,TipKarte.CUDOVISTE,55.32);


//       talon.dodajKartu(k1,ena);
//       talon.dodajKartu(k1,ena);
//       talon.dodajKartu(k3,ena);
//       talon.dodajKartu(k1,ena);
//       talon.dodajKartu(k4,ena);
//       talon.dodajKartu(k5,ena);
//
//       talon.dodajKartu(k5,darko);
//       talon.dodajKartu(k5,darko);
//       talon.dodajKartu(k4,darko);
//       talon.dodajKartu(k2,darko);
//       talon.dodajKartu(k4,darko);
//       talon.dodajKartu(k4,darko);
//
//        System.out.println("Cudovista igraca Ena: \n"+ talon.vratiCudovistaIgraca(ena));
//        System.out.println("\n**************************\n" +
//                "Cudovista igraca Darko: \n"+ talon.vratiCudovistaIgraca(darko));
//
//
//      talon.odstampajTalon();
        Partija partija = new Partija(ena,darko);
        partija.dodajKartu(k2);
        partija.dodajKartu(k5);
        partija.dodajKartu(k1);
        partija.dodajKartu(k4);
        partija.dodajKartu(k2);
        partija.dodajKartu(k5);
        partija.dodajKartu(k1);
        partija.dodajKartu(k5);
        partija.dodajKartu(k1);
        partija.dodajKartu(k1);
        partija.dodajKartu(k3);
        partija.dodajKartu(k4);
        partija.dodajKartu(k4);
        partija.dodajKartu(k2);
        partija.dodajKartu(k5);
        partija.dodajKartu(k1);
        partija.dodajKartu(k5);




        System.out.println(partija.podeliKarte());

//        partija.odigrajPartiju();
        System.out.println(partija.odigrajPartiju());





    }
}
