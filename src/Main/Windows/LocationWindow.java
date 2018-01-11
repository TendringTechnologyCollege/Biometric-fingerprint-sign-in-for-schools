package Main.Windows;

import Main.Misc.Notifications;
import Main.Quit;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.awt.*;
import java.net.MalformedURLException;

@SuppressWarnings("Duplicates")
public class LocationWindow {

    public LocationWindow() throws MalformedURLException, AWTException {

        start();

    }

    public void start() throws MalformedURLException, AWTException {
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

            Platform.setImplicitExit(false);
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    event.consume();
                    try {
                        Quit.Quit();
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (AWTException e) {
                        e.printStackTrace();
                    }
                }
            });



        }catch (Exception e){
            //System.out.println(e);
            Notifications.Error(String.valueOf(e));
        }}


}
