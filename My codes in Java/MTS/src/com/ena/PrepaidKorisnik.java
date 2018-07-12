package com.ena;

public class PrepaidKorisnik extends Korisnik {

    private double kredit;

    private String friendAndFamily1;
    private String friendAndFamily2;
    private String friendAndFamily3;


    public PrepaidKorisnik(String brojTelefona, double kredit, String friendAndFamily1, String friendAndFamily2, String friendAndFamily3) {
        super(brojTelefona);
//        String s = super.getBrojTelefona();
        this.kredit = kredit;
        this.friendAndFamily1 = friendAndFamily1;
        this.friendAndFamily2 = friendAndFamily2;
        this.friendAndFamily3 = friendAndFamily3;
    }


    public double getKredit() {
        return kredit;
    }

    public void setKredit(double kredit) {
        this.kredit = kredit;
    }

    public Korisnik getFriendAndFamily1() {
        return friendAndFamily1;
    }

    public void setFriendAndFamily1(Korisnik friendAndFamily1) {
        this.friendAndFamily1 = friendAndFamily1;
    }

    public Korisnik getFriendAndFamily2() {
        return friendAndFamily2;
    }

    public void setFriendAndFamily2(Korisnik friendAndFamily2) {
        this.friendAndFamily2 = friendAndFamily2;
    }

    public Korisnik getFriendAndFamily3() {
        return friendAndFamily3;
    }

    public void setFriendAndFamily3(Korisnik friendAndFamily3) {
        this.friendAndFamily3 = friendAndFamily3;
    }


    public void dopuniKredit(int dopuna) {
        this.kredit += dopuna;
        System.out.println("Dopunili ste kredit sa " + dopuna + " dinara i sada na racunu imate: " + this.kredit + " dinara.");
    }

    //razgovori 7.5 din- MINUT , friend and familu 4.45-MIN
    //USPOSTAVA VEZE 2.8 din
    // 1SMS - 0.9 din

    // 1. minut se zaokruzuje.. .... 3.52-na 4

    public double racunanjeSmsPotrosnje(int brojSms) {
        return brojSms * 0.9;
    }

    public double racunanjeRazgovora(Vreme trajanjeRazgovora, Korisnik skimPrica) {

        double obracun;


        int h = trajanjeRazgovora.getSat();
        int m = trajanjeRazgovora.getMinut();
        int s = trajanjeRazgovora.getSekunda();
        double uspostavaVeze = 0.0;
        if (h > 0 || m > 0 || s > 0) {
            uspostavaVeze = 2.28;
        }

        if (skimPrica == friendAndFamily1 || skimPrica == friendAndFamily2 || skimPrica == friendAndFamily3) {
            if (h > 0) {
                m = h * 60;
            }
            if (s > 30) {
                m += 1;
            }
            obracun = m * 4.5 + uspostavaVeze;
        } else {
            if (h > 0) {
                m = h * 60;
            }
            if (s > 30) {
                m += 1;
            }
            obracun = m * 7.5 + uspostavaVeze;
        }
        // zaokruzivanje prvog minuta ??

        return obracun;

    }


    public void azuriraj_racun_razgovora(Razgovor razgovor, PrepaidKorisnik skimPrica) {
        double cenaRazgovora = racunanjeRazgovora(razgovor.getTrajanjeRazgovora(), skimPrica);

        if (skimPrica.getKredit() >= (skimPrica.getKredit() - cenaRazgovora)) {
            System.out.println("Razgovor je kostao " + cenaRazgovora);
            kredit -= cenaRazgovora;
        } else {
            System.out.println("Korisnik nema dovoljno kredita");
            kredit = 0;
        }
    }

    public void azuriraj_racun_sms(int sms) {
        double cenaPoruka = racunanjeSmsPotrosnje(sms);
        if (kredit > (kredit - cenaPoruka)) {
            kredit -= cenaPoruka;
            System.out.println("Poslato je " + sms + " poruka i potroseno je " + cenaPoruka + " , ostalo je jos " + kredit + " kredita");
        } else {
            System.out.println("Nema dovoljno kredita za slanje poruka");
            kredit = 0;
        }
    }


    @Override
    public String toString() {
        return " ima kredita" + kredit + ", friendAndFamily1=" + friendAndFamily1 + ", friendAndFamily2=" + friendAndFamily2 + ", friendAndFamily3=" + friendAndFamily3;
    }
}
