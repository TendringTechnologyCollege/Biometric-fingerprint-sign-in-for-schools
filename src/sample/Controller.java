package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Controller {

    //private String Username = "Hello";
    //private String Password = "World";

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
        //System.out.println(username + ", " + password);
        //System.out.println("Before database");
        memory.setTFusername(username);
        memory.setTFpassword(password);
        DatabaseLogin.login();
        //System.out.println("Before IF");

        //System.out.println(memory.getUsername() + "    " + memory.getPassword());
        //System.out.println(memory.getTFusername() + "    " + memory.getTFpassword());
        //System.out.println(username + "    " + password);


        if (username.equals(memory.getUsername())) {
            System.out.println("correct username");


            if (password.equals(memory.getPassword())) {
                System.out.println("correct password");
                actiontarget.setText("Correct password");


                try{
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SecondWindow.fxml"));
                    Parent root1 = fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Location");
                    stage.setScene(new Scene(root1));
                    stage.setFullScreen(true);
                    stage.show();
                } catch (Exception e){
                    System.out.println("Error loading window");
                }


            }else {
                System.out.println("Password Incorrect");
                actiontarget.setText("Password Incorrect");
            }

        } else {
            System.out.println("Username Incorrect");
            actiontarget.setText("Username Incorrect");



        }
    }


}