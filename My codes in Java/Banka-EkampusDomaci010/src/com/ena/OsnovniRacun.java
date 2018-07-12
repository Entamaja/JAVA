package com.ena;

public class OsnovniRacun extends Racun {


    public OsnovniRacun(String brojRacuna, Valuta valuta, Datum poslednjaUplata, Datum posladnjaIsplata) {
        super(brojRacuna, valuta, 0, poslednjaUplata, posladnjaIsplata);
    }

    public OsnovniRacun(String brojRacuna, Valuta valuta, double stanjeRacuna, Datum poslednjaUplata, Datum posladnjaIsplata) {
        super(brojRacuna, valuta, stanjeRacuna, poslednjaUplata, posladnjaIsplata);
    }


    @Override
    void realizujUplatu(Uplata u) {
        if (this.brojRacuna.equals(u.getRacunKorisnika())) {
            stanjeRacuna += u.getSuma();
            // da ovo bude poslednja uplata
            Datum datumUplate = u.getDatumUplate();
            super.poslednjaUplata = datumUplate;

            if (super.poslednjih10Uplata.size() < 10) {
                super.poslednjih10Uplata.add(u);
            } else {
                super.poslednjih10Uplata.remove(9);
                super.poslednjih10Uplata.add(9, u);
            }

        } else {
            System.out.println("Ovaj korisnik ne postoji...");
        }
    }


    @Override
    boolean realizujIsplatu(Isplata i) {
        if (this.brojRacuna.equals(i.getRacunKorisnika())) {

            if ((this.stanjeRacuna - i.getSuma()) > 0) {
                this.stanjeRacuna -= i.getSuma();
                // da ovo bude poslednja isplata
                Datum datumIsplate = i.getDatumUplate();
                super.posladnjaIsplata = datumIsplate;


                if (super.poslednjih10Isplata.size() < 10) {
                    super.poslednjih10Isplata.add(i);
                } else {
                    super.poslednjih10Isplata.remove(9);
                    super.poslednjih10Isplata.add(9, i);
                }

                System.out.println("Uspesno ste platili nesto " + i.getSuma());
                return true;
            }
            System.out.println("Nemate dovoljno sredstava.");
            return false;
        } else {
            System.out.println("Nije dobar broj racuna");
            return false;
        }
    }


    @Override
    public String toString() {

        if ((super.poslednjih10Uplata.size() == 0) && (super.poslednjih10Isplata.size() == 0)) {
            String datum = super.getPoslednjaUplata().toString();
            datum = "--";
            String datum2 = super.getPosladnjaIsplata().toString();
            datum2 = "--";

            return "Osnovni racun: \n" +
                    "\nStanje racuna = " + getStanjeRacuna() +
                    "\nPoslednja uplata: " + datum +
                    "\nPoslednja isplata: " + datum2;

        } else if (super.poslednjih10Uplata.size() == 0) {

            String datum = super.getPoslednjaUplata().toString();
            datum = "--";
            return "Osnovni racun: \n" +
                    "\nStanje racuna = " + getStanjeRacuna() +
                    "\nPoslednja uplata: " + datum +
                    "\nPoslednja isplata: " + super.getPosladnjaIsplata();

        } else if (super.poslednjih10Isplata.size() == 0) {

            String datum2 = super.getPosladnjaIsplata().toString();
            datum2 = "--";
            return "Osnovni racun: \n" +
                    "\nStanje racuna = " + getStanjeRacuna() +
                    "\nPoslednja uplata: " + super.poslednjaUplata +
                    "\nPoslednja isplata: " + datum2;

        } else {
            return "Osnovni racun: \n" +
                    "\nStanje racuna = " + getStanjeRacuna() +
                    "\nPoslednja uplata: " + super.poslednjaUplata +
                    "\nPoslednja isplata: " + super.getPosladnjaIsplata();
        }


    }


    public void ispisUplata() {
        System.out.println("-------------------------------");
        for (int i = 0; i < this.poslednjih10Uplata.size(); i++) {
            System.out.println("Uplata " + (i + 1) + "." + this.getPoslednjih10Uplata().get(i));
            System.out.println("-------------------------------");
        }
    }


    public void ispisIsplata() {
        System.out.println("-------------------------------");
        for (int i = 0; i < this.poslednjih10Isplata.size(); i++) {
            System.out.println("Isplata " + (i + 1) + "." + this.getPoslednjih10Isplata().get(i));
            System.out.println("-------------------------------");
        }
    }


}




