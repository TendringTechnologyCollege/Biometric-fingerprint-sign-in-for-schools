package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;


public class Controller {

    private String Username = "Hello";
    private String Password = "World";

    @FXML private Text actiontarget;
    @FXML private TextField UserName;
    //@FXML private TextField passwordField;
    @FXML private TextField passwordField;


    @FXML
    public void onEnter(KeyEvent e){

        if(e.getCode().equals(KeyCode.ENTER)){
            Signin();
        }

    }

    @FXML protected void handleSubmitButtonAction(ActionEvent event) {

        Signin();


    }






    private void Signin() {



        String username = UserName.getCharacters().toString();
        String password = passwordField.getCharacters().toString();
        System.out.println(username + ", " + password);

        if (username.equals(Username)) {

            if (password.equals(Password)) {

                actiontarget.setText(username + ", " + password + " - Correct");
                System.out.println("Correct");

                try{
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SecondWindow.fxml"));
                    Parent root1 = fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Second Window");
                    stage.setScene(new Scene(root1));
                    stage.setFullScreen(true);
                    stage.show();
                } catch (Exception e){
                    System.out.println("Error loading window");
                }


            }

        } else {
            System.out.println("Incorrect");
            actiontarget.setText(username + ", " + password + " - Incorrect");



        }
    }


}