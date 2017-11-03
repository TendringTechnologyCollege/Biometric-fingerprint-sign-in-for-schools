package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

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

            }

        } else {
            System.out.println("Incorrect");
            actiontarget.setText(username + ", " + password + " - Incorrect");



        }
    }


}