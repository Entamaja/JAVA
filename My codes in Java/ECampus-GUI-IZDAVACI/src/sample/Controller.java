package sample;

import javafx.scene.Scene;
import javafx.stage.Stage;
import podaci.Izdavac;
import prozori.GlavniProzor;
import prozori.Ispis;

import java.util.ArrayList;

public class Controller {


    private static Controller instance = null;
    private ArrayList<Izdavac> listaIzdavaca;

    private Stage glavniStage; // staje je JEDAN , menjaju se scene, scena drzi frame
    private Ispis ispit;
    private Scene scenaIspit;

    private GlavniProzor glavniProzor;
    private Scene scenaGlavniProzor;

    private Controller(){
        this.listaIzdavaca = new ArrayList<>();

    }

    public ArrayList<Izdavac> getListaIzdavaca() {
        return listaIzdavaca;
    }

    public static Controller getInstance(){
        if(instance == null){
            instance = new Controller();//pravimo fizicki taj jedan jedini objekat.
        }
        return instance;
    }


    public static void setInstance(Controller instance) {
        Controller.instance = instance;
    }

    public void setListaIzdavaca(ArrayList<Izdavac> listaIzdavaca) {
        this.listaIzdavaca = listaIzdavaca;
    }

    public Stage getGlavniStage() {
        return glavniStage;
    }

    public void setGlavniStage(Stage glavniStage) {
        this.glavniStage = glavniStage;
    }

    public Ispis getIspit() {
        return ispit;
    }

    public void setIspit(Ispis ispit) {
        this.ispit = ispit;
    }

    public Scene getScenaIspit() {
        return scenaIspit;
    }

    public void setScenaIspit(Scene scenaIspit) {
        this.scenaIspit = scenaIspit;
    }

    public GlavniProzor getGlavniProzor() {
        return glavniProzor;
    }

    public void setGlavniProzor(GlavniProzor glavniProzor) {
        this.glavniProzor = glavniProzor;
    }

    public Scene getScenaGlavniProzor() {
        return scenaGlavniProzor;
    }

    public void setScenaGlavniProzor(Scene scenaGlavniProzor) {
        this.scenaGlavniProzor = scenaGlavniProzor;
    }
}
