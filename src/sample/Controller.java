package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.awt.*;

public class Controller {
    @FXML private Text actiontarget;
    @FXML private TextField UserName;


    public void handleSubmitButtonAction(ActionEvent actionEvent) {
        System.out.println(UserName.getText());

    }


    public void UserNameTF(ActionEvent actionEvent) {

    }
}