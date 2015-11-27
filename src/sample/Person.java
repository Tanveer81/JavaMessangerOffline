package sample;

import javafx.beans.property.SimpleStringProperty;
import sun.nio.ch.Net;
import util.NetworkUtil;

public class Person {
    private final SimpleStringProperty firstName;
    private NetworkUtil nc;
    Main main;

    public Person(SimpleStringProperty firstName,NetworkUtil nc,Main main) {
        this.main=main;
        this.firstName = firstName;
        this.nc = nc;
    }

    Person(String fName) {
        this.firstName = new SimpleStringProperty(fName);

    }

    public String getFirstName() {
        return firstName.get();
    }
    public void setFirstName(String fName) {
        firstName.set(fName);
    }




    public String toString() {
        return firstName + "" ;
    }

}
