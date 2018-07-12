package com.ena;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // KANDIDATI
        Kandidat kandidat1 = new Kandidat("EnaMaksimovic","Pancevo");
        Kandidat kandidat2 = new Kandidat("VesnaTrengoski","Pancevo");
        Kandidat kandidat3 = new Kandidat("MarijaGolubovic","Zajecar");
        Kandidat kandidat4 = new Kandidat("DamirTrhulj","Beograd");
        Kandidat kandidat5 = new Kandidat("JanaDakic","Beograd");
        Kandidat kandidat6 = new Kandidat("AnaStojnovic","Novi Sad");
        Kandidat kandidat7 = new Kandidat("IgorJovicic","Beograd");
        Kandidat kandidat8 = new Kandidat("DankaStupar","Beograd");
        Kandidat kandidat9 = new Kandidat("MajaLazovic","Pancevo");
        Kandidat kandidat10 = new Kandidat("AleksandarLalic","Beograd");

        // UCIONIA SVAKA KREIRANJE
        Ucionica ucionica1 = new Ucionica("Ucionica 1",true,true,1);
        Ucionica ucionica2 = new Ucionica("Ucionica 2",true,false,2);
        Ucionica ucionica3 = new Ucionica("Ucionica 3",false,true,2);
        Ucionica ucionica4 = new Ucionica("Ucionica 4",false,false,2);

        // DATUM
        LocalDate dan1 = LocalDate.of(2018, 10, 12);

        // DOGADJAJI
        Dogadjaj dogadjaj1 = new Predavanje("Kako je raditi u Facebooku","Slavko Fodor",dan1.atTime(5,30),false);
        Dogadjaj dogadjaj2 = new Predavanje("Zasto je Raf najgluplji fakultet na svetu","Ena Maksimovic",dan1.atTime(4,0),true);
        Dogadjaj dogadjaj3 = new Predavanje("Sve o Java programskom jeziku","Isidora Bekic",dan1.atTime(12,0),false);
        Dogadjaj dogadjaj4 = new Predavanje("Android Master class","Tim Burschalka",dan1.atTime(5,0),true);
        Dogadjaj dogadjaj5 = new Predavanje("Kolike su plate u IT-u","Dusan Tosic",dan1.atTime(1,45),false);
        Dogadjaj dogadjaj6 = new Radionica("Osnove DB deo 1","Ecampus Bojan", dan1.atTime(7,0));
        Dogadjaj dogadjaj7 = new Radionica("Osnove DB deo 2","Ecampus Bojan", dan1.atTime(7,30));
        Dogadjaj dogadjaj8 = new Radionica("Kreiranje igrica","Slavko Fodor", dan1.atTime(8,0));
        Dogadjaj dogadjaj9 = new Radionica("Robotika uvod","Milan Krstic", dan1.atTime(8,30));
        Dogadjaj dogadjaj10 = new Radionica("Robotika napredno","Milan Krstic", dan1.atTime(3,0));


//        kandidat1.polaganjeTesta();
//        kandidat2.polaganjeTesta();
//        kandidat3.polaganjeTesta();
//        kandidat4.polaganjeTesta();
//        kandidat5.polaganjeTesta();
//        kandidat6.polaganjeTesta();
//        kandidat7.polaganjeTesta();
//        kandidat8.polaganjeTesta();
//        kandidat9.polaganjeTesta();
//        kandidat10.polaganjeTesta();


//        ArrayList<Kandidat> svi = new ArrayList<>();
//        svi.add(kandidat1);
//        svi.add(kandidat2);
//        svi.add(kandidat3);
//        svi.add(kandidat4);
//        svi.add(kandidat5);
//        svi.add(kandidat6);
//        svi.add(kandidat7);
//        svi.add(kandidat8);
//        svi.add(kandidat9);
//        svi.add(kandidat10);
//         sort radi samo ovvako ??? pf ?????????????????????????????????????????????????????????????????????
//        Collections.sort(svi);
//
//        for (int i=0;i<svi.size();i++){
//            System.out.println(i+" --> "+svi.get(i).getBrojPoena());
//        }
//
//        try {
//            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("bodovanjeSortirano.txt")));
//
//            bw.write("Bodovanje:\n");
//            for(Kandidat kand : svi){
//                bw.write("\n"+kand.toString()+"\n");
//            }
//
//            bw.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // UCIONICE RAFA
        ArrayList<Ucionica> rafoveUcionice = new ArrayList<>();
        rafoveUcionice.add(ucionica1);
        rafoveUcionice.add(ucionica2);
        rafoveUcionice.add(ucionica3);
        rafoveUcionice.add(ucionica4);

        // KANDIDATI ZA RAF IT DAYS PRIJAVA
        RacunarskiFakultet raf = new RacunarskiFakultet("raf 2018",rafoveUcionice);
        raf.prijavaKandidata(kandidat1.getImePrezime(),kandidat1.getGrad());
        raf.prijavaKandidata(kandidat2.getImePrezime(),kandidat2.getGrad());
        raf.prijavaKandidata(kandidat3.getImePrezime(),kandidat3.getGrad());
        raf.prijavaKandidata(kandidat4.getImePrezime(),kandidat4.getGrad());
        raf.prijavaKandidata(kandidat5.getImePrezime(),kandidat5.getGrad());
        raf.prijavaKandidata(kandidat6.getImePrezime(),kandidat6.getGrad());
        raf.prijavaKandidata(kandidat7.getImePrezime(),kandidat7.getGrad());
        raf.prijavaKandidata(kandidat8.getImePrezime(),kandidat8.getGrad());
        raf.prijavaKandidata(kandidat9.getImePrezime(),kandidat9.getGrad());
        raf.prijavaKandidata(kandidat10.getImePrezime(),kandidat10.getGrad());

        raf.polaganjeTesta();

        raf.spisakUspesnihUcesnika();
        raf.odstampajDogadjajeIUcesnike();

        //DODAVANJE DOGADJAJA
        raf.dodavanjeDogadjajaRafu(dogadjaj1);
        raf.dodavanjeDogadjajaRafu(dogadjaj2);
        raf.dodavanjeDogadjajaRafu(dogadjaj3);
        raf.dodavanjeDogadjajaRafu(dogadjaj4);
        raf.dodavanjeDogadjajaRafu(dogadjaj5);
        raf.dodavanjeDogadjajaRafu(dogadjaj6);
        raf.dodavanjeDogadjajaRafu(dogadjaj7);
        raf.dodavanjeDogadjajaRafu(dogadjaj8);
        raf.dodavanjeDogadjajaRafu(dogadjaj9);
        raf.dodavanjeDogadjajaRafu(dogadjaj10);




        raf.odaberiDogadjaje();
    }


}
