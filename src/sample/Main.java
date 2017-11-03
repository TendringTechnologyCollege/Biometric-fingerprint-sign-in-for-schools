package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));


        primaryStage.getIcons().add(new Image(Controller.class.getResourceAsStream("img/Icon.png")));
        primaryStage.setTitle("Welcome | Sign in");
        primaryStage.setScene(new Scene(root, 600, 575));
        primaryStage.setFullScreen(true);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }



}
