package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.util.ArrayList;



public class MainFrame extends VBox {

    private ArrayList<Student> listaStudenata;

    private Label labIme;
    private Label labIndex;
    private Label labSmer;
    private VBox vbLabele;

    private TextField tfIme;
    private TextField tfIndex;
    private ComboBox<Smer> cbSmer;
    private VBox vbTextFildovi;

    private HBox hbUnos;
    private Button btnDodaj;
    private Button btnObrisi;

    private VBox vbForma;
    private ListView<Student> lvStudenti;

    private HBox hbGore;

    private Button btnSviStud;
    private Button btnPoSmeru;
    private Button btnDeoImena;
    private HBox hbDole;

    public MainFrame(){
        super(20);
        setPadding(new Insets(10));
        setAlignment(Pos.CENTER);
        listaStudenata = new ArrayList<>();
        postaviElemente();
        postaviAkcije();

        getChildren().addAll(hbGore, hbDole);
    }


    private void postaviElemente() {

        labIme = new Label("Ime:");
        labIndex = new Label("Index:");
        labSmer = new Label("Smer:");
        vbLabele = new VBox(25);
        vbLabele.getChildren().addAll(labIme, labIndex, labSmer);

        tfIme = new TextField();
        tfIme.setPrefWidth(130);
        tfIndex = new TextField();
        tfIndex.setPrefWidth(130);
        cbSmer = new ComboBox<>();
        cbSmer.setPrefWidth(130);
        cbSmer.getItems().addAll(Smer.values());
        vbTextFildovi = new VBox(15);
        vbTextFildovi.getChildren().addAll(tfIme, tfIndex, cbSmer);

        hbUnos = new HBox(20);
        hbUnos.getChildren().addAll(vbLabele, vbTextFildovi);
        btnDodaj = new Button("Dodaj");
        btnObrisi = new Button("Obrisi");

        vbForma = new VBox(15);
        vbForma.setAlignment(Pos.BASELINE_CENTER);
        vbForma.getChildren().addAll(hbUnos, btnDodaj, btnObrisi);
        lvStudenti = new ListView<>();

       hbGore = new HBox(10);
       hbGore.getChildren().addAll(vbForma, lvStudenti);

        btnSviStud = new Button("Svi Studenti");
        btnPoSmeru = new Button("Po Smeru");
        btnDeoImena = new Button("Deo Imena");
        hbDole =new HBox(20);
        hbDole.setAlignment(Pos.CENTER);
        hbDole.getChildren().addAll(btnSviStud, btnPoSmeru, btnDeoImena);
    }


    private void postaviAkcije() {

        btnDodaj.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String ime = tfIme.getText().trim();
                if(ime.length() == 0) return;

                String index = tfIndex.getText().trim();
                if(index.length() == 0) return;

                Smer smer = cbSmer.getSelectionModel().getSelectedItem();
                if(smer == null) return;

                Student stud = new Student(ime, index, smer);
                lvStudenti.getItems().add(stud);
                listaStudenata.add(stud);

                tfIme.setText("");
                tfIndex.clear();
                cbSmer.getSelectionModel().select(-1);//deselektuj sve
            }
        });

        btnObrisi.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int index = lvStudenti.getSelectionModel().getSelectedIndex();
                if(index == -1) return;

                lvStudenti.getItems().remove(index);


            }
        });

        btnSviStud.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lvStudenti.getItems().clear();
                lvStudenti.getItems().addAll(listaStudenata);
            }
        });

        btnPoSmeru.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Smer smer = cbSmer.getSelectionModel().getSelectedItem();
                if(smer == null) return;

                lvStudenti.getItems().clear();
                for (Student st: listaStudenata){

                    if (st.getSmer().equals(smer)){
                        lvStudenti.getItems().add(st);
                    }


                }

            }
        });


        btnDeoImena.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String deoImena = tfIme.getText().trim();
                lvStudenti.getItems().clear();

                for (Student st: listaStudenata){
                    if (st.getIme().contains(deoImena)){
                        lvStudenti.getItems().add(st);
                    }




                }


            }
        });


    }


}
