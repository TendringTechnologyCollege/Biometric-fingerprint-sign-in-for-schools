package sample;


import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class ErrorWindow {


    public void close(ActionEvent event) {

        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
