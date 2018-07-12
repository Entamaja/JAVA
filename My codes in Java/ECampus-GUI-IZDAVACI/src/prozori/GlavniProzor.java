package prozori;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import podaci.Izdavac;
import podaci.Knjiga;
import sample.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GlavniProzor extends VBox {


    private Label lbNaslov;
    private Label lbAutor;
    private Label lbGodina;
    private Label lbIzdavac;
    private Button btnPretrazi;
    private VBox vbLabele;


    private TextField tfNaslov;

    private TextField tfAutor;
    private TextField tfGodina;
    private ComboBox<Izdavac> cbIzdavaci;
    private VBox vbUnosi;


    private CheckBox cbTacanNaslov;
    private CheckBox cbTacanAutor;
    private VBox vbTacni;

    private HBox hbForma;

    private ListView<Knjiga> lvKnjiga;

    private Button btnProdaja;
    private Button btnSacuvaj;
    private HBox hbDugmici;

    public GlavniProzor(){
        super(20);
        setPadding(new Insets(15));

        napraviElemente();


        getChildren().addAll(hbForma,lvKnjiga,hbDugmici);
    }

    private void napraviElemente() {

        lbNaslov = new Label("Naslov");
        lbAutor= new Label("Autor");
        lbGodina= new Label("Godina izdanja");
        lbIzdavac= new Label("Izdavac");
        btnPretrazi = new Button("Pretrazi");
        vbLabele = new VBox(25);
        vbLabele.getChildren().addAll(lbNaslov,lbAutor,lbGodina,lbIzdavac,btnPretrazi);


        tfNaslov = new TextField();

        tfAutor = new TextField();
        tfGodina = new TextField();
        cbIzdavaci = new ComboBox<>();
        ucitajIzdavace();
        cbIzdavaci.getItems().addAll(Controller.getInstance().getListaIzdavaca());

        vbUnosi = new VBox(15);
        vbUnosi.getChildren().addAll(tfNaslov,tfAutor,tfGodina,cbIzdavaci);


        cbTacanNaslov = new CheckBox("Tacan naslov");
        cbTacanAutor= new CheckBox("Tacan autor");
        vbTacni = new VBox(10);

        hbForma = new HBox(10);
        hbForma.getChildren().addAll(vbLabele,vbUnosi,vbTacni);

        lvKnjiga = new ListView<>();

        btnProdaja = new Button("Prodaja");
        btnSacuvaj = new Button("Sacuvaj novo stanje");
        hbDugmici = new HBox(15);




    }

    private void ucitajIzdavace() {

        try {
            Scanner scanner = new Scanner(new File("izdavaci.txt"));
            while (scanner.hasNext()){
                String izdavac = scanner.next();
                double popust = scanner.nextDouble();

                Controller.getInstance().getListaIzdavaca().add(new Izdavac(izdavac, popust));
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }


}
