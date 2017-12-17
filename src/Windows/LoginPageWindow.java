package Windows;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class LoginPageWindow {

    public LoginPageWindow(){
        signin();
    }


    public void signin() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image(LoginPageWindow.class.getResourceAsStream("../Resources/img/Icon.png")));
            stage.setTitle("Welcome | Sign in");
            stage.setScene(new Scene(root1));
            stage.setFullScreen(true);
            stage.setAlwaysOnTop(true);
            stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
            stage.show();


        } catch (Exception e) {
            System.out.println("Error loading window");
            System.out.println(e);

        }




    }

}
