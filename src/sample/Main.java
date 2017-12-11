package sample;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {




    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("Slash.fxml"));
        window.getIcons().add(new Image(Controller.class.getResourceAsStream("img/Icon.png")));
        window.setTitle("Starting up...");
        window.setScene(new Scene(root, 600, 575, Color.TRANSPARENT));
        window.initStyle(StageStyle.TRANSPARENT);
        window.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        window.setFullScreen(false);
        window.setAlwaysOnTop(true);
        window.show();

        Wait();




    }



    public void Wait(){

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(1);
                Platform.runLater(() -> {
                    System.out.println(2);
                    new SignInWindow();
                    window.close();

                });

            }
        }, 5000);
        System.out.println(3);



        }









    public static void main(String[] args) {
        launch(args);






    }



}
