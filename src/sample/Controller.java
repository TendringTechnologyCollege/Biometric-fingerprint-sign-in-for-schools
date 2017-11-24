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

                CheckLocation.login();

                if(memory.getDBLocation().equals("InSchool")) {

                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SecondWindow.fxml"));
                        Parent root1 = fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setTitle("Location");
                        stage.setScene(new Scene(root1));
                        stage.setMaximized(true);
                        stage.show();



                    } catch (Exception e) {
                        System.out.println("Error loading window");
                    }
                }else{
                    System.out.println("opened");
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SignedBackIn.fxml"));
                        Parent root1 = fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setTitle("Signed Back In");
                        stage.setScene(new Scene(root1));
                        stage.setMaximized(true);
                        stage.show();

                        Thread.sleep(5000);

                        stage.close();



                    } catch (Exception e) {
                        System.out.println("Error loading window");
                    }

                    System.out.println("closed");
                    memory.setLocaion("InSchool");
                    UpdateDatabase.update();

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