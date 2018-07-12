package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainFrame extends VBox{

    private ArrayList<Paketi> listaPaketa;

    private Button btnPregledPaketa;
   // private ListView<Paketi> lvPaketa;
    private TextArea taPregled;
    private VBox vbPregledPaketa;

    private Label lbCenaFolije;
    private TextField tfCenaFolije;
    private HBox hbCenaFolije;

    //private ListView lvCena;
    private TextArea taCene;
    private Button btnIzracunajCenu;
    private VBox vbCenaFolije;



    public MainFrame(){
        super(20);
        setPadding(new Insets(10));
        setAlignment(Pos.CENTER);

        listaPaketa = new ArrayList<>();
        postaviElementre();
        postaviAkcije();

        getChildren().addAll(vbPregledPaketa,hbCenaFolije,vbCenaFolije);

    }

    private void postaviAkcije() {
        btnPregledPaketa.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                listaPaketa.clear();//da se ne gomila
                taPregled.clear();//da se ne gomila ako neko klikce puno puta
                try {
                    Scanner fajl = new Scanner(new File("paketi.txt"));
                    String linija;
                    while(fajl.hasNext()){
                        linija = fajl.nextLine();
                        String []podaci = linija.split(", ");

                        if(podaci[0].equals("K")){
                            listaPaketa.add(new Kutija(Double.parseDouble(podaci[1]),Double.parseDouble(podaci[2]),Double.parseDouble(podaci[3])));
                        }else{
                            listaPaketa.add(new Valjak(Double.parseDouble(podaci[1]),Double.parseDouble(podaci[2])));
                        }
                        taPregled.appendText(linija+"\n");
                    }
                    taPregled.appendText("--------------------------------------------------------");
                    fajl.close();

                    for(Paketi pak : listaPaketa){
                        taPregled.appendText(pak+"\n");
                    }


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }


            }
        });

        btnIzracunajCenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                taCene.clear();
                double suma = 0;
                for (Paketi pak: listaPaketa){
                    if (pak instanceof Kutija){
                        taCene.appendText(pak+", P = "+String.format("%.2f",pak.povrsina())+"\n");
                        suma += pak.povrsina();
                    }
                }
                taCene.appendText("..............................\n" +
                        "Ukupno povrsina je : "+ suma+"\n");

                try{
                    double cena = Double.parseDouble(tfCenaFolije.getText().trim());  // ovako ce da uzme ono sto je otkucano u text fildu

                    double ukupnoPara = cena * suma;
                    taCene.appendText("\nUkupna cena " + ukupnoPara);
                }catch(Exception ex){
                    ex.printStackTrace();   // da ispise da se desio neki bag ali program nastavlja da radi kako tako
                    taCene.appendText("Nije uneta cena");
                }
            }
        });



    }

    private void postaviElementre(){
        btnPregledPaketa = new Button("Pregled paketa");
        //lvPaketa = new ListView<>();
        taPregled = new TextArea();
        taPregled.setEditable(false);
        vbPregledPaketa = new VBox(10);
        vbPregledPaketa.getChildren().addAll(btnPregledPaketa,taPregled);

        lbCenaFolije = new Label("Cena zastitne folije ");
        tfCenaFolije = new TextField();
        tfCenaFolije.prefWidth(120);
        hbCenaFolije = new HBox(10);
        hbCenaFolije.getChildren().addAll(lbCenaFolije,tfCenaFolije);

        taCene = new TextArea();
        taCene.setEditable(false);
        //lvCena = new ListView();
        btnIzracunajCenu = new Button("Izracunaj cenu dodatnog pakovanja");
        vbCenaFolije = new VBox(10);
        vbCenaFolije.getChildren().addAll(taCene,btnIzracunajCenu);
    }





}
