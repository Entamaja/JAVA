package com.ena;

public abstract class Korisnik {

    private String brojTelefona;


    public Korisnik(String brojTelefona) {
        String str = "";
        for (int i = 0; i < 3; i++) {
            str += brojTelefona.charAt(i);
        }

        if ((str.equals("064") || str.equals("065") || str.equals("066")) && (str.length() >= 9 || str.length() <= 10)) {
            this.brojTelefona = brojTelefona;
        } else {
            System.out.println("Broj mora pocinjati sa 064 | 065 | 066 i mora sadrzati 9-10 cifara");
        }
//        if(brojTelefona.indexOf("065")==0){
//
//        }
    }


    public abstract double racunanjeRazgovora(Vreme vreme, Korisnik korisnik);

    public double racunanjePDVa(double cena) {
        return cena * 0.18;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    @Override
    public String toString() {
        return "Broj Telefona korisnika : " + brojTelefona;
    }
}
