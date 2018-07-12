package com.ena;

public class Datum {

    private int dan;
    private int mesec;
    private int godina;


    public Datum(int dan, int mesec, int godina) {

        if ((mesec == 1 || mesec == 3 || mesec == 5 || mesec == 7 || mesec == 8 || mesec == 10 || mesec == 12) && (dan > 0 && dan <= 31)) {
            this.dan = dan;
        } else if ((mesec == 4 || mesec == 6 || mesec == 9 || mesec == 11) && (dan > 0 && dan <= 30)) {
            this.dan = dan;
        }else {
            //za Februar ...
            if (((mesec == 2 && (((godina % 4 == 0) && (godina % 100 == 0))) || godina % 400 == 0)) && (dan > 0 && dan <= 29)) {
                this.dan = dan;
            } else if ((dan > 0 && dan <= 28)) {
                this.dan = dan;
            }
        }


        if (mesec > 0 && mesec <= 12) {
            this.mesec = mesec;
        }

        if (godina > 0) {
            this.godina = godina;
        }
    }


    public Datum(Datum d) {
        this.dan = d.dan;
        this.mesec = d.mesec;
        this.godina = d.godina;
    }

    public Datum sledeciDatum2() {
        int dan, mesec, godina;

        dan = this.dan+1;
        mesec= this.mesec;
        godina = this.godina;

        switch (this.mesec) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (dan > 31){
                    dan = 1;
                    mesec ++;
                    if(mesec>12){
                        mesec = 1;
                        godina++;
                    }
                }
                break;


            case 4:
            case 6:
            case 9:
            case 11:
                if (dan > 30) {
                    dan = 1;
                    mesec++;
                }
                break;
        }

        Datum sledeciDatum = new Datum(dan, mesec, godina);

        return sledeciDatum;


    }


    public Datum sledeciDatum() {
       // int dan, mesec, godina;

        switch (this.mesec){
            case 1:case 3:case 5:case 7:case 8:case 10:case 12:
            if (dan == 31 && godina!=12){
               mesec = this.mesec + 1;
               dan = 1;
            }else if (dan == 31 && mesec==12){
               mesec = 1;
               dan = 1;
               godina +=1;
            }else {
                dan = this.dan + 1;
            }
            break;


            case 4:case 6:case 9:case 11:
            if (dan == 30 && godina!=12) {
                mesec = this.mesec + 1;
                dan = 1;
            }else if (dan==30 && godina==12){
                mesec = this.mesec + 1;
                dan = 1;
                godina += 1;
            }else {
                dan = this.dan + 1;
            }
            break;
        }

        Datum sledeciDatum = new Datum(dan, mesec, godina);

        return sledeciDatum;





//        if (((((mesec % 2) != 0)) || mesec == 7) && (dan == 31)) {
//            sledeciMesec = this.mesec + 1;
//            sledeciDan = 1;
//        } else if (((((mesec % 2) == 0)) || mesec == 9) && (dan == 30)) {
//
//
//            sledeciMesec = this.mesec + 1;
//            sledeciDan = 1;
//        } else {
//            sledeciDan = this.dan + 1;
//        }
//
//        int sledecaGodina = this.godina;
//
//        if (dan == 31 && mesec == 12) {
//            sledecaGodina += 1;
//        }
//
//        Datum sledeciDatum = new Datum(sledeciDan, sledeciMesec, sledecaGodina);

//        return sledeciDatum;







    }


    public boolean isti(final Datum datum) {
        if ((this.getDan() == datum.getDan()) && (this.getMesec() == datum.getMesec()) && (this.getGodina() == datum.getGodina())) {
            return true;
        } else {
            return false;
        }
    }


    //getteri i setteri

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

    @Override
    public String toString() {
        return dan + "." + mesec + "." + godina + ".";
    }


}
