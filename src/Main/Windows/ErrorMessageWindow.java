package Main.Windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ErrorMessageWindow {
    public ErrorMessageWindow() {
        error();
    }


    public void error(){

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ErrorMessage.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Error");
            stage.getIcons().add(new Image(ErrorMessageWindow.class.getResourceAsStream("Resources/img/error.png")));
            stage.setScene(new Scene(root1));
            stage.setMaximized(false);
            stage.show();



        } catch (Exception e) {
           //System.out.println("Error loading window");

        }


    }


}





