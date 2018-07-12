package com.ena;

public class Datum {


    private int dan;
    private int mesec;
    private int godina;


    public Datum(int dan, int mesec, int godina) {

       if (((((mesec%2)!=0)) || mesec == 7 )  && (dan>0 && dan <=31)){
           this.dan = dan;
       }else if (((((mesec%2)==0)) || mesec == 9)  && (dan>0 && dan <=30)){

           if (((mesec==2 && (((godina % 4 == 0) && (godina % 100 == 0))) || godina%400==0)) && (dan>0 && dan <=29)){
            this.dan = dan;
           }else if ((dan>0 && dan <=28)){
               this.dan = dan;
           }else {
               System.out.println("Februar ima ili 28 ili 29 dana ako je prestupna.");
           }
       }else {
           this.dan = dan;
       }


       if (mesec>0 && mesec<=12){
           this.mesec = mesec;
       }

       if (godina>0 && godina<=2018){

           this.godina = godina;
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







