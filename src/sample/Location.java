package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

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
        //System.out.println(2);

        if(memory.getLocaion() == "InSchool"){
            //System.out.println(3);
            memory.setLocaion(Location);
            UpdateDatabase.update();

        }else{
            //System.out.println(4);
            memory.setLocaion("InSchool");
            UpdateDatabase.update();
        }
    }



}
