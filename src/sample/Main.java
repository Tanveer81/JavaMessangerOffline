package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    final ObservableList<Person> persons = FXCollections.observableArrayList();
    Person person;
    controller c;
    Stage stage;
    boolean b=false;
    String name;
    @Override
    public void start(Stage primaryStage) throws Exception{
        stage=primaryStage;

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("server.fxml"));
        Parent root = loader.load();

        controller Controller = loader.getController();
        Controller.setMain(this);
        c=Controller;
        c.showTable();

        stage.setTitle("Server");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();

        Thread t=new Thread(new server(this));
        t.start();
    }

    void write(Person person){
        this.person=person;
        b=true;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
