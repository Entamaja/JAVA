package com.ena;

public class Ucionica {

    private String nazivUcionice;
    private boolean saRacunarom;
    private boolean imaProjektor;
    private int brojMesta;

    public Ucionica(String nazivUcionice, boolean saRacunarom, boolean imaProjektor, int brojMesta) {
        this.nazivUcionice = nazivUcionice;
        this.saRacunarom = saRacunarom;
        this.imaProjektor = imaProjektor;
        this.brojMesta = brojMesta;
    }




    public boolean isSaRacunarom() {
        return saRacunarom;
    }

    public boolean isImaProjektor() {
        return imaProjektor;
    }

    public String getNazivUcionice() {
        return nazivUcionice;
    }

    public int getBrojMesta() {
        return brojMesta;
    }

    @Override
    public String toString() {
        return "Ucionica{" +
                "nazivUcionice='" + nazivUcionice + '\'' +
                ", saRacunarom=" + saRacunarom +
                ", imaProjektor=" + imaProjektor +
                ", brojMesta=" + brojMesta +
                '}';
    }
}
