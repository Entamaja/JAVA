package com.ena;

import java.util.List;
import java.util.Random;

public class Ucesnik {

    private String imePrezime;
    private KategorijaUcesnika kategorijaUcesnika;


    public Ucesnik(Kandidat kandidat) {
        this.imePrezime = kandidat.imePrezime;
        if (kandidat.grad.equals("Beograd")){
            this.kategorijaUcesnika = KategorijaUcesnika.DOMACI;
        }else {
            this.kategorijaUcesnika = KategorijaUcesnika.GOST;
        }
    }



    public void glasaj(List<Glasanje> listaGlasanja){
        Random random = new Random();
        int slucajniIzbor = random.nextInt(listaGlasanja.size());
        listaGlasanja.get(slucajniIzbor).glasaj();
        System.out.println("Slucajnim izborom glasa za "+ listaGlasanja.get(slucajniIzbor));
    }










    public String getImePrezime() {
        return imePrezime;
    }

    public KategorijaUcesnika getKategorijaUcesnika() {
        return kategorijaUcesnika;
    }

    @Override
    public String toString() {
        return "\n" + imePrezime + ", kategorije " + kategorijaUcesnika +"\n";
    }
}
