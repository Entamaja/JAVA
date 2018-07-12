package com.ena;

public class PostpaidKorisnik extends Korisnik {

    private double racun = 150.00;

    public PostpaidKorisnik(String brojTelefona, double racun) {
        super(brojTelefona);
        this.racun = racun;
    }

    public double getRacun() {
        return racun;
    }

    public void setRacun(double racun) {
        this.racun = racun;
    }


    public double racunanjeRazgovora(Vreme trajanjeRazgovora, Korisnik skimPrica) {

        double obracun;

        int h = trajanjeRazgovora.getSat();
        int m = trajanjeRazgovora.getMinut();
        int s = trajanjeRazgovora.getSekunda();
        double uspostavaVeze = 0.0;

        if (h > 0 || m > 0 || s > 0) {
            uspostavaVeze = 2.5;
        }

        if (skimPrica.getBrojTelefona().startsWith("064") || skimPrica.getBrojTelefona().startsWith("065") || skimPrica.getBrojTelefona().startsWith("066")) {
            if (h > 0) {
                m = h * 60;
            }
            obracun = m * 2.8 + uspostavaVeze;
        } else {
            if (h > 0) {
                m = h * 60;
            }
            obracun = m * 5.8 + uspostavaVeze;
        }

        return obracun;

    }


    public double racunanjeSmsPotrosnje(int brojSms) {
        return brojSms * 2.2;
    }


}
