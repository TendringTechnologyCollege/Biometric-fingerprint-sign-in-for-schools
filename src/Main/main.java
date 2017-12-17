package Main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static com.sun.org.apache.bcel.internal.util.SecuritySupport.getResourceAsStream;

public class main extends Application {




    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {


        try {

            window = primaryStage;
            Parent root = FXMLLoader.load(getClass().getResource("../Windows/Splash.fxml"));
            //window.getIcons().add(new Image(MainWindow.class.getResourceAsStream("Icon.png")));
            window.getIcons().add(new Image(main.class.getResourceAsStream("../Resources/img/Icon.png")));
            window.setTitle("Starting up...");
            window.setScene(new Scene(root, 600, 575, Color.TRANSPARENT));
            window.initStyle(StageStyle.TRANSPARENT);
            window.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
            window.setFullScreen(false);
            window.setAlwaysOnTop(true);
            window.show();

            Wait();


        }catch (Exception e){
            System.out.println(e);
        }

    }



    public void Wait(){

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //System.out.println(1);
                Platform.runLater(() -> {
                    //System.out.println(2);
                    new Windows.LoginPageWindow();
                    window.close();
                });
            }
        }, 5000);
        //System.out.println(3);
        }


    public static void time(){
        String timeStamp = new SimpleDateFormat("HH.mm").format(new Date());
        Main.memory.setTime(timeStamp);
    }

    public static void Date(){
        String dateStamp = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        Main.memory.setDate(dateStamp);
    }






    public static void main(String[] args) {
        launch(args);






    }



}
