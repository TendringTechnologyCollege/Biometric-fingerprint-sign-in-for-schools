package Main.Windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class LocationWindow {

    public LocationWindow() {

        start();

    }

    public void start() {
        try{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Location.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.getIcons().add(new Image(LocationWindow.class.getResourceAsStream("Resources/img/Icon.png")));
        stage.setTitle("Location");
        stage.setScene(new Scene(root1));
        stage.setMaximized(true);
        stage.setAlwaysOnTop(true);
        stage.show();
    }catch (Exception e){
            System.out.println(e);
        }}


}
