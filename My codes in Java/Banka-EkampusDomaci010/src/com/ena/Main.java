package com.ena;

public class Main {

    public static void main(String[] args) {


        Datum d1 = new Datum(1, 5, 2018);
        Datum d2 = new Datum(2, 9, 2018);
        Datum d3 = new Datum(24, 12, 2019);
        RacunSaPozajmicom mojRacun = new RacunSaPozajmicom("123", Valuta.RSD, 100, d1, d2, 10000);


        mojRacun.pozajmiPare(22);
        mojRacun.pozajmiPare(122000);

        Uplata plata = new Uplata("123", 20000, d2);
        mojRacun.realizujUplatu(plata);
        System.out.println(mojRacun);
        Uplata plata2 = new Uplata("123", 120000, d3);
        mojRacun.realizujUplatu(plata2);

        mojRacun.realizujUplatu(plata);
        mojRacun.realizujUplatu(plata);
        mojRacun.realizujUplatu(plata);
        mojRacun.realizujUplatu(plata);
        mojRacun.realizujUplatu(plata2);
        mojRacun.realizujUplatu(plata);
        mojRacun.realizujUplatu(plata);
        mojRacun.realizujUplatu(plata);
        mojRacun.realizujUplatu(plata);
        Uplata plataExtra = new Uplata("123", 300, d3);

        mojRacun.realizujUplatu(plataExtra);


        mojRacun.ispisUplata();
        System.out.println(mojRacun);
        System.out.println(mojRacun);
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        Isplata racuni = new Isplata("123", 6000, d2);
        mojRacun.realizujIsplatu(racuni);


        System.out.println(mojRacun);


        OsnovniRacun obican = new OsnovniRacun("555", Valuta.RSD, 2300, d1, d2);
        System.out.println(obican);
        Uplata plata11 = new Uplata("555", 20000, d2);
        obican.realizujUplatu(plata11);

        System.out.println(obican);


    }
}
