package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Location {

    public static String Location = "";

    public void Triangle(ActionEvent actionEvent) {
        //System.out.println(1);
        Location = "Triangle";
        Check();


    }

    public void Returning(ActionEvent actionEvent) {
        Location = "Returning";
        Check();
    }

    public void GoingHome(ActionEvent actionEvent) {
        Location = "GoingHome";
        Check();
    }



    public static void Check(){
        String timeStamp = new SimpleDateFormat("HH:mm").format(new Date());
        String dateStamp = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        memory.setTime(timeStamp);
        memory.setDate(dateStamp);
        //CheckLocation.login();
        System.out.println(memory.getDBLocation());
        System.out.println(memory.getLocaion());
        //System.out.println(2);

        memory.setLocaion(Location);
        UpdateDatabase.update();

        Stage stage = new Stage();
        stage.close();



    }



}
