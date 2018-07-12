package com.ena;

import java.util.Scanner;

public class TestPoruka {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Unesite tekst poruke ");
        String tekst = sc.nextLine();

        Poruka tajnaPoruka = new Poruka(tekst);
        System.out.println(tajnaPoruka);

        System.out.println("Odaberi nacin sifrovanja:\n" +
                "t - translacija\n" +
                "r - rotacija");
        String vrstaSifte = sc.nextLine();
        System.out.println("Uneti pomeraj: ");
        int pomeraj = sc.nextInt();
        sc.nextLine();

        switch (vrstaSifte) {

            case "t":
                SifrarTranslacija st = new SifrarTranslacija(tajnaPoruka, pomeraj);
                System.out.println("Sifrovana poruka " + st.sifrovanaPoruka(tajnaPoruka));
                break;
            case "r":
                System.out.println("Unesite smer: ");
                String smer = sc.nextLine();

                if (smer.equals("levo")) {
                    SifrarRotacije sfRot = new SifrarRotacije(tajnaPoruka, pomeraj, "levo");
                    System.out.println(sfRot.sifruj(tajnaPoruka));
                    break;
                } else {
                    SifrarRotacije sfRot = new SifrarRotacije(tajnaPoruka, pomeraj, "desno");
                    System.out.println(sfRot.sifruj(tajnaPoruka));
                    break;
                }

        }


//        SifrarTranslacija sif = new SifrarTranslacija(tajnaPoruka,1);
////      sif.sifruj(tajnaPoruka);
////      System.out.println(sif);

//        SifrarRotacije roto = new SifrarRotacije(tajnaPoruka,2,"desno");
//        System.out.println(roto.sifruj(tajnaPoruka));

    }
}
