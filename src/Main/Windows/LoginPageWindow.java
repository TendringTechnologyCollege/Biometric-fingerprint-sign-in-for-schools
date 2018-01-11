package Main.Windows;


import Main.Misc.Notifications;
import Main.Quit;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.awt.*;
import java.net.MalformedURLException;

import static javafx.scene.input.KeyCombination.NO_MATCH;

public class LoginPageWindow {

    public LoginPageWindow() throws MalformedURLException, AWTException {
        signin();
    }


    public void signin() throws MalformedURLException, AWTException {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image(LoginPageWindow.class.getResourceAsStream("Resources/img/Icon.png")));
            stage.setTitle("Welcome | Sign in");
            stage.setScene(new Scene(root1));
            stage.setFullScreen(true);
            Platform.setImplicitExit(false);
            stage.setFullScreenExitKeyCombination(NO_MATCH);
            stage.show();

            Platform.setImplicitExit(false);
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    event.consume();
                    try {
                        Quit.quit();
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (AWTException e) {
                        e.printStackTrace();
                    }
                }
            });


        } catch (Exception e) {
            System.out.println("Error loading window");
            Notifications.Error(String.valueOf(e));

        }




    }

}
