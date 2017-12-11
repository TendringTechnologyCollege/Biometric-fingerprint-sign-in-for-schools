package sample;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class SignInBack {

    SignInBack(){
        SignIn();

    }

    public void SignIn(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SignedBackIn.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Signed Back In");
            stage.setScene(new Scene(root1));
            stage.setMaximized(true);
            stage.setAlwaysOnTop(true);
            stage.show();
            memory.setLocaion("InSchool");
            UpdateDatabase.update();


            close(stage);
            //System.out.println("closed");






        } catch (Exception e) {
            System.out.println("Error loading window");
            System.out.println(e);

        }
    }

    public void close(Stage stage){
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

