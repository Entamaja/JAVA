package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import prozori.GlavniProzor;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Controller.getInstance().setGlavniStage(primaryStage);
        GlavniProzor glavniProzor = new GlavniProzor();
        Controller.getInstance().setGlavniProzor(glavniProzor);
        Scene scene1 = new Scene(glavniProzor,500,600);
        Controller.getInstance().setScenaGlavniProzor(scene1);

        primaryStage.setTitle("Glavni");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
