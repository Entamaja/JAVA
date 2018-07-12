package com.ena;

public class FilmskiCd extends Cd {

    private String imeRezisera;
    private String imeGlavnogGlumca;


    public FilmskiCd(String naziv, Datum izajmljivanja, String imeRezisera, String imeGlavnogGlumca) {
        super(naziv, 60, izajmljivanja);
        this.imeRezisera = imeRezisera;
        this.imeGlavnogGlumca = imeGlavnogGlumca;
    }

    public FilmskiCd(String naziv, String imeRezisera, String imeGlavnogGlumca) {
        super(naziv, 60, new Datum(31,5,2018));
        this.imeRezisera = imeRezisera;
        this.imeGlavnogGlumca = imeGlavnogGlumca;
    }



    public Datum datumVracanja(Datum datumKadJeUzet){

        int maxDana = 5;
        Datum datumMaximalnogZadrzavanja = datumKadJeUzet;
        while (maxDana>0){
            datumMaximalnogZadrzavanja = datumMaximalnogZadrzavanja.sledeciDatum2();
            maxDana--;
            if (maxDana!=0){
                continue;
            }
            return datumMaximalnogZadrzavanja;
        }
        System.out.println("OPET - Datum vracanja "+datumMaximalnogZadrzavanja);
        return null;
    }

    @Override
    public String toString() {
        return "Ime Rezisera " + imeRezisera +", ime Glavnog Glumca " + imeGlavnogGlumca;
    }

    public String getImeRezisera() {
        return imeRezisera;
    }

    public void setImeRezisera(String imeRezisera) {
        this.imeRezisera = imeRezisera;
    }

    public String getImeGlavnogGlumca() {
        return imeGlavnogGlumca;
    }

    public void setImeGlavnogGlumca(String imeGlavnogGlumca) {
        this.imeGlavnogGlumca = imeGlavnogGlumca;
    }
}
