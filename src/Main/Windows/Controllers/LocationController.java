package Main.Windows.Controllers;

import Main.Windows.Databases.UpdateDatabase;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import Main.memory;

import java.awt.*;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LocationController {

    private static String Location = "";

    public void Triangle(ActionEvent actionEvent) throws MalformedURLException, AWTException {
        //System.out.println(1);
        Location = "Triangle";
        Check();
        Node source = (Node)  actionEvent.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();


    }

    public void Returning(ActionEvent actionEvent) throws MalformedURLException, AWTException {
        Location = "Returning";
        Check();
        Node source = (Node)  actionEvent.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void GoingHome(ActionEvent actionEvent) throws MalformedURLException, AWTException {
        Location = "GoingHome";
        Check();
        Node source = (Node)  actionEvent.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }



    private static void Check() throws MalformedURLException, AWTException {
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
