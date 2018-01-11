package Main.Windows;

import Main.Quit;
import Main.Windows.Databases.UpdateDatabase;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import Main.memory;
import javafx.stage.WindowEvent;

import java.awt.*;
import java.net.MalformedURLException;
import java.util.Timer;
import java.util.TimerTask;

public class SignedBackInWindow {

    @FXML private ProgressBar progressbar;

    public SignedBackInWindow(){
        SignIn();

    }

    public void SignIn(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SignedBackIn.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Signed Back In");
            stage.getIcons().add(new Image(SignedBackInWindow.class.getResourceAsStream("Resources/img/Icon.png")));
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


            memory.setLocaion("InSchool");
            UpdateDatabase.update();
            //System.out.println(progressbar.getProgress());

            close(stage);
            //System.out.println("closed");






        } catch (Exception e) {
            System.out.println("Error loading window");
            System.out.println(e);

        }
    }

    public static void close(Stage stage){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //System.out.println(1);
                Platform.runLater(() -> {
                    stage.close();

                });

            }
        }, 2000);




    }
    }

