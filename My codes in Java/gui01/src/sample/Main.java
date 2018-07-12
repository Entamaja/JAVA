package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        MainFrame root = new MainFrame();
        Scene mainScena = new Scene(root, 475, 250);

        primaryStage.setTitle("Studentski Servis");
        primaryStage.setScene(mainScena);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
