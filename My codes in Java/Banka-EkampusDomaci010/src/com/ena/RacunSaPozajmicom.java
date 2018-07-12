package com.ena;

public class RacunSaPozajmicom extends Racun {

    private double pozajmica;
    private double raspolozivoStanje;
    private double dugovanje = 0;
    private double dozvoljeniMinus;


    public RacunSaPozajmicom(String brojRacuna, Valuta valuta, double stanjeRacuna, Datum poslednjaUplata, Datum posladnjaIsplata, double dozvoljeniMinus) {
        super(brojRacuna, valuta, stanjeRacuna, poslednjaUplata, posladnjaIsplata);
        this.raspolozivoStanje = stanjeRacuna;
        this.dozvoljeniMinus = dozvoljeniMinus;
    }

    public RacunSaPozajmicom(String brojRacuna, Valuta valuta, Datum poslednjaUplata, Datum posladnjaIsplata, double dozvoljeniMinus) {
        super(brojRacuna, valuta, 0, poslednjaUplata, posladnjaIsplata);
        this.raspolozivoStanje = stanjeRacuna;
        this.dozvoljeniMinus = dozvoljeniMinus;
    }

    public RacunSaPozajmicom(RacunSaPozajmicom racunSaPozajmicom) {
        super(racunSaPozajmicom.brojRacuna, racunSaPozajmicom.valuta, racunSaPozajmicom.stanjeRacuna, racunSaPozajmicom.poslednjaUplata, racunSaPozajmicom.posladnjaIsplata);
        this.raspolozivoStanje = racunSaPozajmicom.stanjeRacuna;
        this.dozvoljeniMinus = racunSaPozajmicom.dozvoljeniMinus;
    }


    public boolean pozajmiPare(double svota) {
        double staraPozajmica = this.pozajmica;
        this.pozajmica = svota;
        if ((this.stanjeRacuna - pozajmica) > ((-1) * dozvoljeniMinus)) {
            super.stanjeRacuna -= this.pozajmica;
            this.raspolozivoStanje += this.pozajmica;
            this.dugovanje += this.pozajmica;
            System.out.println("Pozajmili ste: " + pozajmica +
                    "\n , sada na raspolaganju imate: " + raspolozivoStanje +
                    "\n , a realno stanje je " + stanjeRacuna +
                    "\n , dozvoljeni minus -" + dozvoljeniMinus +
                    "\n .. dugujete:  " + dugovanje +
                    "\n**************************************\n");
            return true;
        } else {
            System.out.println("Ne mozete da idete u nedozvoljeni minus");
            this.pozajmica = staraPozajmica;
            return false;
        }
    }


    @Override
    void realizujUplatu(Uplata u) {

        if (this.brojRacuna.equals(u.getRacunKorisnika())) {
            stanjeRacuna += u.getSuma();
            raspolozivoStanje += u.getSuma();
            // da ovo bude poslednja uplata
            Datum datumUplate = u.getDatumUplate();
            super.poslednjaUplata = datumUplate;


//            System.out.println("Uplaceno je "+ u.getSuma()+" na Vas racun \n"+
//                                "Raspolozivo stanje: "+ raspolozivoStanje+
//                                "\n Stanje: " + stanjeRacuna +
//                                "\n Korisnik: " + brojRacuna+
//                                "\n Datum: " + datumUplate);
            if (super.poslednjih10Uplata.size() < 10) {
                super.poslednjih10Uplata.add(u);
            } else {
                super.poslednjih10Uplata.remove(9);
                super.poslednjih10Uplata.add(9, u);
//                System.out.println("uneto je na poslednje mesto");
            }

        } else {
            System.out.println("Ovaj korisnik ne postoji...");
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


    @Override
    boolean realizujIsplatu(Isplata i) {

        if (this.brojRacuna.equals(i.getRacunKorisnika())) {

            if ((this.raspolozivoStanje - i.getSuma()) > 0) {
                this.raspolozivoStanje -= i.getSuma();
                this.stanjeRacuna -= i.getSuma();
                // da ovo bude poslednja isplata
                Datum datumIsplate = i.getDatumUplate();
                super.posladnjaIsplata = datumIsplate;


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


    //getteri i setteri


    public double getPozajmica() {
        return pozajmica;
    }

    public void setPozajmica(double pozajmica) {
        this.pozajmica = pozajmica;
    }

    public double getRaspolozivoStanje() {
        return raspolozivoStanje;
    }

    public void setRaspolozivoStanje(double raspolozivoStanje) {
        this.raspolozivoStanje = raspolozivoStanje;
    }

    public double getDugovanje() {
        return dugovanje;
    }

    public void setDugovanje(double dugovanje) {
        this.dugovanje = dugovanje;
    }


    @Override
    public String toString() {


        if ((super.poslednjih10Uplata.size() == 0) && (super.poslednjih10Isplata.size() == 0)) {
            String datum = super.getPoslednjaUplata().toString();
            datum = "--";
            String datum2 = super.getPosladnjaIsplata().toString();
            datum2 = "--";

            return "RacunSaPozajmicom: \n" +
                    "\nRealna situacija = " + getStanjeRacuna() +
                    "\nPoslednja uplata: " + datum +
                    "\nPoslednja isplata: " + datum2 +
                    "\npozajmica = " + pozajmica +
                    "\nRaspolozivoStanje = " + raspolozivoStanje +
                    "\nDugovanje = " + dugovanje +
                    "\nDozvoljeniMinus = - " + dozvoljeniMinus;


        } else if (super.poslednjih10Uplata.size() == 0) {

            String datum = super.getPoslednjaUplata().toString();
            datum = "--";
            return "RacunSaPozajmicom: \n" +
                    "\nRealna situacija = " + getStanjeRacuna() +
                    "\nPoslednja uplata: " + datum +
                    "\nPoslednja isplata: " + super.getPosladnjaIsplata() +
                    "\npozajmica = " + pozajmica +
                    "\nRaspolozivoStanje = " + raspolozivoStanje +
                    "\nDugovanje = " + dugovanje +
                    "\nDozvoljeniMinus = - " + dozvoljeniMinus;


        } else if (super.poslednjih10Isplata.size() == 0) {

            String datum = super.getPosladnjaIsplata().toString();
            datum = "--";
            return "RacunSaPozajmicom: \n" +
                    "\nRealna situacija = " + getStanjeRacuna() +
                    "\nPoslednja uplata: " + super.poslednjaUplata +
                    "\nPoslednja isplata: " + datum +
                    "\npozajmica = " + pozajmica +
                    "\nRaspolozivoStanje = " + raspolozivoStanje +
                    "\nDugovanje = " + dugovanje +
                    "\nDozvoljeniMinus = - " + dozvoljeniMinus;

        } else
            return "RacunSaPozajmicom: \n" +
                    "\nRealna situacija = " + getStanjeRacuna() +
                    "\nPoslednja uplata: " + super.poslednjaUplata +
                    "\nPoslednja isplata: " + super.getPosladnjaIsplata() +
                    "\npozajmica = " + pozajmica +
                    "\nRaspolozivoStanje = " + raspolozivoStanje +
                    "\nDugovanje = " + dugovanje +
                    "\nDozvoljeniMinus = - " + dozvoljeniMinus;


    }


}
