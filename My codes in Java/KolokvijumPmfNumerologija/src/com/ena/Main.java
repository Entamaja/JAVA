package com.ena;

public class Main {

    public static void main(String[] args) {
//        Datum mojDatum = new Datum(7, 5, 1987);
////    System.out.println("Datum mog rodjenja: " + mojDatum);
//
//        String jmbg = mojDatum.generisanjeJmbga(mojDatum);
////    System.out.println("Moj jmbg: "+jmbg);
//
//        OsobaD osobaDddd = new OsobaD("Ena", "Batur", "Radoja Domanovica", mojDatum);
//        int num = osobaDddd.numeroloskiBrojOsobe();
//        System.out.println("Numeroloski broj osobe "+osobaDddd.getIme()+" je ---> "+num);
//
//        String metabolizam = osobaDddd.metabozilam(new Datum(11,5,2020));
//        System.out.println("Metabolizam : "+metabolizam);

        OsobaJMBG persona = new OsobaJMBG("persona","prezime","adresa","0705987120146");

        Datum d = persona.vracanjeDatuma("0705987123456");
        System.out.println(d);



    }


}
