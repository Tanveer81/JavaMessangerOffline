package client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class startController {
    Main main;
    void setMain(Main main){
        this.main=main;
    }
    @FXML
    public TextField textField;

    @FXML
    private Text text;

    @FXML
    private Button connect;

    @FXML
    void connectServer(ActionEvent event) {
        try {
            main.showClient(textField.getText());
            main.c=true;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
