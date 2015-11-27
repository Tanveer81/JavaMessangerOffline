package client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class Main extends Application {
    Ccontroller a;
    startController s;
    Stage stage;
    boolean c=false;
    @Override
    public void start(Stage primaryStage) throws Exception{
        stage=primaryStage;
        showStart();
    }
    public void showStart() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Cstart.fxml"));
        Parent root = loader.load();


        startController controller = loader.getController();
        controller.setMain(this);
        s=controller;

        stage.setTitle("Client");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public void showClient(String name) throws Exception {
        String cName;
        cName=name;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Csample.fxml"));
        Parent root = loader.load();

        Ccontroller controller = loader.getController();
        controller.setMain(this);
        controller.setName(cName);
        a=controller;

        stage.setTitle("Client");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();

        Thread t=new Thread(new client(this,cName));
        t.start();
    }


    public static void main(String[] args) {
        launch(args);
    }
}