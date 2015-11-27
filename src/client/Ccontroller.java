package client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class Ccontroller {
    Main main;
    String name;
    void setName(String name){
        this.name=name;
        clientName.setText("Client : "+name);
    }
    void setMain(Main main){
        this.main=main;
    }

    @FXML
    private Text clientName;

    @FXML
    public TextArea output;

    @FXML
    public Text text;

}
