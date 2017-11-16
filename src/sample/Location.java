package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Location {

    public static String Location = "";

    public void Triangle(ActionEvent actionEvent) {
        Location = "Triangle";
        System.out.println(Location);
    }

    public void Returning(ActionEvent actionEvent) {
        Location = "Returning";
        System.out.println(Location);
    }

    public void GoingHome(ActionEvent actionEvent) {
        Location = "GoingHome";
        System.out.println(Location);
    }



}
