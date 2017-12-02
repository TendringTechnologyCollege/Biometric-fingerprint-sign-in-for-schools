package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ErrorWindowControler {
    ErrorWindowControler() {
        error();
    }


    public void error(){

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Error Window.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Error");
            stage.setScene(new Scene(root1));
            stage.getIcons().add(new Image(Controller.class.getResourceAsStream("img/error.png")));
            stage.setMaximized(false);
            stage.show();



        } catch (Exception e) {
            System.out.println("Error loading window");

        }


    }







}





