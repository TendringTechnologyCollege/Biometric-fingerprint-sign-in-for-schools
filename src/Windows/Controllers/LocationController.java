package Windows.Controllers;

import Databases.UpdateDatabase;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import Main.memory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LocationController {

    public static String Location = "";

    public void Triangle(ActionEvent actionEvent) {
        //System.out.println(1);
        Location = "Triangle";
        Check();
        Node source = (Node)  actionEvent.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();


    }

    public void Returning(ActionEvent actionEvent) {
        Location = "Returning";
        Check();
        Node source = (Node)  actionEvent.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void GoingHome(ActionEvent actionEvent) {
        Location = "GoingHome";
        Check();
        Node source = (Node)  actionEvent.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }



    public static void Check(){
        String timeStamp = new SimpleDateFormat("HH:mm").format(new Date());
        memory.setTime(timeStamp);
        String dateStamp = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        memory.setDate(dateStamp);
        //CheckLocation.login();
        memory.setLocaion(Location);
       //System.out.println(memory.getDBLocation());
       //System.out.println(memory.getLocaion());
        //System.out.println(2);


        UpdateDatabase.update();

        Stage stage = new Stage();
        stage.close();



    }



}
