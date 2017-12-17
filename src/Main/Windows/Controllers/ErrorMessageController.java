package Main.Windows.Controllers;


import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class ErrorMessageController {


    public void close(ActionEvent event) {

        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();


    }
}
