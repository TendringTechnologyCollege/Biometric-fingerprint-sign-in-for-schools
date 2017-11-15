package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {




    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        window.getIcons().add(new Image(Controller.class.getResourceAsStream("img/Icon.png")));
        window.setTitle("Welcome | Sign in");
        window.setScene(new Scene(root, 600, 575));
        window.setFullScreen(true);
        window.show();

    }


    public static void main(String[] args) {
        launch(args);




    }



}
