package Windows.Controllers;

import Databases.CheckLocation;
import Databases.FireAlarm;
import Databases.SignInUsers;
import Windows.ErrorMessageWindow;
import Windows.SignedBackInWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import Main.memory;


public class MainWindow {

    //private String Username = "Hello";
    //private String Password = "World";

    @FXML private Text actiontarget;
    @FXML private TextField UserName;
    @FXML private TextField passwordField;
    @FXML private  ProgressBar progressBar;


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
        SignInUsers.login();
        //System.out.println("Before IF");

        //System.out.println(memory.getUsername() + "    " + memory.getPassword());
        //System.out.println(memory.getTFusername() + "    " + memory.getTFpassword());
        //System.out.println(username + "    " + password);


        if (username.equals(memory.getUsername())) {
           //System.out.println("correct username");


            if (password.equals(memory.getPassword())) {
               //System.out.println("correct password");
                actiontarget.setText("Correct password");

                CheckLocation.login();

                if(memory.getDBLocation().equals("InSchool")) {

                    try {
                        new Windows.LocationWindow();
                        actiontarget.setText("");
                        UserName.setText("");
                        passwordField.setText("");
                        System.out.println("laoded");



                    } catch (Exception e) {
                       //System.out.println("Error loading window");

                    }
                }else{
                   //System.out.println("opened");
                    actiontarget.setText("");
                    UserName.setText("");
                    passwordField.setText("");
                    new SignedBackInWindow();
                   //System.out.println("closed");


                }

            }else {
               //System.out.println("Password Incorrect");
                actiontarget.setText("Password Incorrect");



            }

        } else if (username.equals("Fire")) {
            FireAlarm.Fire();
        } else {
            //System.out.println("Username Incorrect");
            actiontarget.setText("Username Incorrect");
            new ErrorMessageWindow();


        }
    }



}