package com.ena;

public class Datum {

    private int dan;
    private int mesec;
    private int godina;

    public Datum(int dan, int mesec, int godina) {
        this.dan = dan;
        this.mesec = mesec;
        this.godina = godina;
    }

    //COPY KONSTRUKTOR - STA CE MI ??
    public Datum(Datum d) {
        this.dan = d.dan;
        this.mesec = d.mesec;
        this.godina = d.godina;
    }

    @Override
    public String toString() {
        if (dan < 10 && mesec > 10) {
            return "0" + dan + "." + mesec + "." + godina + ".";
        } else if (mesec < 10 && dan > 10) {
            return dan + "." + "0" + mesec + "." + godina + ".";
        } else if (dan < 10 && mesec < 10) {
            return "0" + dan + "." + "0" + mesec + "." + godina + ".";

        } else {
            return dan + "." + mesec + "." + godina + ".";
        }
    }


//    public String generisanjeJmbga(Datum datum) {
//        // dan
//        String str = "";
//        if (datum.getDan() > 0 && datum.getDan() < 10) {
//            str += "0" + datum.getDan();
//        } else if (datum.getDan() > 0 && datum.getDan() <= 31) {
//            str += datum.getDan();
//        }
//        //mesec
//        if (datum.getMesec() > 0 && datum.getMesec() < 10) {
//            str += "0" + datum.getMesec();
//        } else if (datum.getMesec() > 0 && datum.getMesec() <= 31) {
//            str += datum.getMesec();
//        }
//        //godina
//        str += this.godina % 1000;
//
//        //ostatak
//        for (int i = 0; i < 6; i++) {
//            str += (int) (Math.random() * 9);
//        }
//
//        return str;
//    }

//
//    public String datumRodjenja(Datum datumRodjenja) {
//        String strDatum = "";
//        if (datumRodjenja.getDan() > 0 && datumRodjenja.getDan() < 10) {
//            strDatum += "0" + datumRodjenja.getDan();
//        } else if (datumRodjenja.getDan() > 0 && datumRodjenja.getDan() <= 31) {
//            strDatum += datumRodjenja.getDan();
//        }
//        //mesec
//        if (datumRodjenja.getMesec() > 0 && datumRodjenja.getMesec() < 10) {
//            strDatum += "0" + datumRodjenja.getMesec();
//        } else if (datumRodjenja.getMesec() > 0 && datumRodjenja.getMesec() <= 31) {
//            strDatum += datumRodjenja.getMesec();
//        }
//        //godina
//        strDatum += this.godina % 1000;
//
//        return strDatum;
//    }


    private String datumRodjenjaA(Datum datumRodjenja) {
        String strDatum = "";
        if (datumRodjenja.getDan() > 0 && datumRodjenja.getDan() < 10) {
            strDatum += "0" + datumRodjenja.getDan();
        } else if (datumRodjenja.getDan() > 0 && datumRodjenja.getDan() <= 31) {
            strDatum += datumRodjenja.getDan();
        }
        //mesec
        if (datumRodjenja.getMesec() > 0 && datumRodjenja.getMesec() < 10) {
            strDatum += "0" + datumRodjenja.getMesec();
        } else if (datumRodjenja.getMesec() > 0 && datumRodjenja.getMesec() <= 31) {
            strDatum += datumRodjenja.getMesec();
        }
        //godina
        strDatum += this.godina;

        return strDatum;
    }

    public int datumRodj(Datum datumRodjenja) {
        String datum = datumRodjenjaA(datumRodjenja);
        int datumBroj = Integer.parseInt(datum);
        return datumBroj;
    }


    //GETTERI I SETTERI
    public int getDan() {
        return dan;
    }

    public void setDan(int dan) {
        this.dan = dan;
    }

    public int getMesec() {
        return mesec;
    }

    public void setMesec(int mesec) {
        this.mesec = mesec;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }
}
