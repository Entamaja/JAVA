package com.ena;

public class OsobaD extends Osoba {

    private Datum datumRodjenja;
    private String metabolizam ="";

    public OsobaD(String ime, String prezime, String adresa, Datum datumRodjenja) {
        super(ime, prezime, adresa);
        this.datumRodjenja = datumRodjenja;
    }

    public OsobaD(Osoba o, Datum datumRodjenja) {
        super(o);
        this.datumRodjenja = datumRodjenja;
    }

    @Override
    public String toString() {
        if (getMetabolizam() == "") {
            return super.toString() + "\ndatumRodjenja:" + datumRodjenja + " \nNumeroloski broj ove osobe je: " + numeroloskiBrojOsobe();
        } else {
            return super.toString() + "\ndatumRodjenja:" + datumRodjenja + " Numeroloski broj ove osobe je: " + numeroloskiBrojOsobe() + " ima metabolizam ==> " + this.getMetabolizam();
        }
    }

//    public OsobaD prebacivanje(OsobaJMBG osobaJMBG){
//        Datum datum = osobaJMBG.vracanjeDatuma(osobaJMBG.getJmbg());
//        OsobaD osobaJMBGtoD = new OsobaD(osobaJMBG.getIme(),osobaJMBG.getPrezime(),osobaJMBG.getAdresa(),datum);
//        return osobaJMBGtoD;
//    }



    public int numeroloskiBrojOsobe() {

        int suma = 0;

        if (this.datumRodjenja.getDan() / 10 != 0) {
            int broj1 = this.datumRodjenja.getDan() / 10;
            int broj2 = this.datumRodjenja.getDan() % 10;
            suma = suma + broj1 + broj2;
        } else {
            suma += this.datumRodjenja.getDan();
        }

        if (this.datumRodjenja.getMesec() / 10 != 0) {
            int broj1 = this.datumRodjenja.getMesec() / 10;
            int broj2 = this.datumRodjenja.getMesec() % 10;
            suma = suma + broj1 + broj2;
        } else {
            suma += this.datumRodjenja.getMesec();
        }

        //godina
        suma += this.datumRodjenja.getGodina() / 1000;
        int temp = this.datumRodjenja.getGodina() / 1000;
        suma = suma + ((this.datumRodjenja.getGodina() - (temp * 1000)) / 100);
        int temp2 = ((this.datumRodjenja.getGodina() - (temp * 1000)) / 100);
        suma = suma + ((this.datumRodjenja.getGodina() - (temp * 1000) - (temp2 * 100)) / 10);
        suma += this.datumRodjenja.getGodina() % 10;

        boolean kraj = false;

        if (suma / 10 != 0) {
            int numBroj;
            int a = suma / 10;
            int b = suma % 10;
            numBroj = a + b;
            if (suma / 10 == 0) {
                return numBroj;
            } else {
                int jos;
                a = numBroj / 10;
                b = numBroj % 10;
                jos = a + b;
                return jos;
            }
        }

        return suma;
    }





    private int metabolizamBrojka(Datum finalniDatum){
        int datum = this.datumRodjenja.datumRodj(this.datumRodjenja);
        int datumFinala = this.datumRodjenja.datumRodj(finalniDatum);
        int zbirDatuma = datum + datumFinala;
        return zbirDatuma;
    }

    public String metabozilam(Datum finalniDatum){
        int suma = metabolizamBrojka(finalniDatum);
        String rez = "" + suma;
        this.metabolizam = rez;
        return rez;
    }

    public boolean imaLiNule(Datum datumMetabolizma){
        String rez ="";
        rez += metabozilam(datumMetabolizma);
        for (int i=0;i<rez.length();i++){
            if (rez.charAt(i) == '0'){
                System.out.println("nema nule?");
               return false;
            }
            return true;
        }
        return true;
    }

    public void setMetabolizam(String metabolizam) {
        this.metabolizam = metabolizam;
    }

    public String getMetabolizam() {
        return this.metabolizam;
    }

    //GETTERI I SETERI
    public Datum getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Datum datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }
}
