package sample;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;



public class controller {
    Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private Button send;

    @FXML
    public TextArea textArea;

    @FXML
    void sendMessage(ActionEvent event) {
        main.b=true;
    }

    @FXML
    public TableView tableView;

    @FXML
    private Button button;

    private boolean init = true;

    void initializeColumns() {
        TableColumn<Person, String> firstNameCol = new TableColumn<>("Client");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("firstName"));

        ///button column starts
        TableColumn<Person, String> actionCol = new TableColumn<>("Send");
        actionCol.setCellValueFactory(new PropertyValueFactory<>("Send"));

        Callback<TableColumn<Person, String>, TableCell<Person, String>> cellFactory =
                new Callback<TableColumn<Person, String>, TableCell<Person, String>>() {
                    @Override
                    public TableCell call( final TableColumn<Person, String> param ) {
                        final TableCell<Person, String> cell = new TableCell<Person, String>() {
                            final Button btn = new Button("Select");

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem( item, empty );
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                }
                                else {
                                    // action of 'Select' button click
                                    btn.setOnAction((ActionEvent event) -> {
                                                Person person = getTableView().getItems().get(getIndex());
                                                String name = person.getFirstName() + " " ;
                                                main.write(person);
                                                main.persons.remove(person);
                                                textArea.setText(null);
                                            }
                                    );
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };
        actionCol.setCellFactory(cellFactory);

        tableView.getColumns().addAll(firstNameCol, actionCol);
    }

    @FXML
    void buttonAction(ActionEvent event) {

        if (init) {
            initializeColumns();
            init = false;
        }

        tableView.setEditable(true);
        tableView.setItems(main.persons);
        button.setVisible(false);
    }

    void showTable() {

        if (init) {
            initializeColumns();
            init = false;
        }

        tableView.setEditable(true);
        tableView.setItems(main.persons);

    }
        //Person p = new Person("A", "B", "C@D.com");
        //tableView.getItems().add(p);
}


