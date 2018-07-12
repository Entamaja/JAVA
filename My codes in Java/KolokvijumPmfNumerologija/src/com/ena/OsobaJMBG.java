package com.ena;

public class OsobaJMBG extends Osoba {

    private String jmbg;
    private String metabolizam = "";


    public OsobaJMBG(String ime, String prezime, String adresa, String jmbg) {
        super(ime, prezime, adresa);
        this.jmbg = jmbg;
    }

    public OsobaJMBG(Osoba o, String jmbg) {
        super(o);
        this.jmbg = jmbg;
    }


    public Datum vracanjeDatuma(String jmbg) {
        jmbg = this.jmbg;
        String tempDan = "";
        int dan;
        int a;
        int b;
        if (jmbg.charAt(0) == '0') {
            tempDan += jmbg.charAt(1);
            dan = Integer.parseInt(tempDan);
        } else {
            tempDan += jmbg.charAt(0);
//            dan = (jmbg.charAt(0) * 10) + jmbg.charAt(1);
            String tempDan2 = "" + jmbg.charAt(1);
            a = Integer.parseInt(tempDan);
            b = Integer.parseInt(tempDan2);
            dan = a * 10 + b;
        }

        int mesec;
        int c, d;
        String tempMesec = "";
        if (jmbg.charAt(2) == '0') {
            tempMesec += jmbg.charAt(3);
            mesec = Integer.parseInt(tempMesec);
//            mesec = jmbg.charAt(3);
        } else {
            tempMesec += jmbg.charAt(2);
            String temp2Mesec = "" + jmbg.charAt(3);
//            mesec = (jmbg.charAt(2) * 10) + jmbg.charAt(3);
            c = Integer.parseInt(tempMesec);
            d = Integer.parseInt(temp2Mesec);
            mesec = c * 10 + d;
        }

        int godina;
        int g1, g2, g3, g4;
        if (jmbg.charAt(4) == '0') {
            String godina1 = "" + jmbg.charAt(5);
            String godina2 = "" + jmbg.charAt(6);
            g1 = Integer.parseInt(godina1);
            g2 = Integer.parseInt(godina2);
            godina = 2000 + (g1 * 10) + g2;
//            godina = 2000+ (jmbg.charAt(5)*10 + jmbg.charAt(6));
        } else {
            String godina1 = "" + jmbg.charAt(4);
            String godina2 = "" + jmbg.charAt(5);
            String godina3 = "" + jmbg.charAt(6);
            g1 = Integer.parseInt(godina1);
            g2 = Integer.parseInt(godina2);
            g3 = Integer.parseInt(godina3);
            godina = 1000 + (g1 * 100) + (g2 * 10) + g3;
//            godina = 1000+ (jmbg.charAt(4)*100 + jmbg.charAt(5)*10 + jmbg.charAt(6));
        }

        Datum datum = new Datum(dan, mesec, godina);
        return datum;
    }


    public int numeroloskiBrojOsobe() {

        int suma = 0;

        Datum datumRodjenja = vracanjeDatuma(this.jmbg);
        if (datumRodjenja.getDan() / 10 != 0) {
            int broj1 = datumRodjenja.getDan() / 10;
            int broj2 = datumRodjenja.getDan() % 10;
            suma = suma + broj1 + broj2;
        } else {
            suma += datumRodjenja.getDan();
        }


        if (datumRodjenja.getMesec() / 10 != 0) {
            int broj1 = datumRodjenja.getMesec() / 10;
            int broj2 = datumRodjenja.getMesec() % 10;
            suma = suma + broj1 + broj2;
        } else {
            suma += datumRodjenja.getMesec();
        }

        //godina
        suma += datumRodjenja.getGodina() / 1000;
        int temp = datumRodjenja.getGodina() / 1000;
        suma = suma + ((datumRodjenja.getGodina() - (temp * 1000)) / 100);
        int temp2 = ((datumRodjenja.getGodina() - (temp * 1000)) / 100);
        suma = suma + ((datumRodjenja.getGodina() - (temp * 1000) - (temp2 * 100)) / 10);
        suma += datumRodjenja.getGodina() % 10;

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


    private int metabolizamBrojka(Datum finalniDatum) {
        Datum datumRodjenja = vracanjeDatuma(this.jmbg);
        int datum = datumRodjenja.datumRodj(datumRodjenja);
        int datumFinala = datumRodjenja.datumRodj(finalniDatum);
        int zbirDatuma = datum + datumFinala;
        return zbirDatuma;
    }

    public String metabozilam(Datum finalniDatum) {
        int suma = metabolizamBrojka(finalniDatum);
        String rez = "" + suma;
        setMetabolizam(rez);
        return rez;
    }

    public boolean imaLiNule(Datum datumMetabolizma) {
        String rez = "";
        rez += metabozilam(datumMetabolizma);
        for (int i = 0; i < rez.length(); i++) {
            if (rez.charAt(i) == '0') {
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


    // GETERI I SETERI
    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    @Override
    public String toString() {
        return super.toString() + " rodjena: " + vracanjeDatuma(this.jmbg) + " , numeroloski broj je " + numeroloskiBrojOsobe() + " i jmbg = " + jmbg + " i metabolizam ==> " + getMetabolizam();
    }


}
