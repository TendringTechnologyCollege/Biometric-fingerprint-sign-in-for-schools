package Main;

import Main.Misc.Notifications;
import Main.Windows.Databases.InSchoolQuit;
import Main.Windows.Databases.UpdateDatabase;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
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
            Parent root = FXMLLoader.load(getClass().getResource("Windows/Splash.fxml"));
            //window.getIcons().add(new Image(MainWindow.class.getResourceAsStream("Icon.png")));
            window.getIcons().add(new Image(main.class.getResourceAsStream("Windows/Resources/img/Icon.png")));
            window.setTitle("Starting up...");
            window.setScene(new Scene(root, 600, 575, Color.TRANSPARENT));
            window.initStyle(StageStyle.TRANSPARENT);
            window.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
            window.setFullScreen(false);
            window.setAlwaysOnTop(true);
            window.show();
            Platform.setImplicitExit(false);

            Wait();

            File logsexcel = new File("Logs.xls");
            boolean logexist = logsexcel.exists();

            if (logexist == false){

                Workbook wb = new HSSFWorkbook();
                CreationHelper createHelper = wb.getCreationHelper();
                Sheet sheet = wb.createSheet(Date());
                Row row = sheet.createRow((short) 0);
                row.createCell(0).setCellValue(createHelper.createRichTextString("ID"));
                row.createCell(1).setCellValue(createHelper.createRichTextString("Name"));
                row.createCell(2).setCellValue(createHelper.createRichTextString("Location"));
                row.createCell(3).setCellValue(createHelper.createRichTextString("Time out"));
                FileOutputStream fileOut = new FileOutputStream("Logs.xls");
                wb.write(fileOut);
                fileOut.close();


            }

            timedate();



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
                    try {
                        new Main.Windows.LoginPageWindow();
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (AWTException e) {
                        e.printStackTrace();
                    }
                    window.close();
                });
            }
        }, 5000);
        //System.out.println(3);
        }


    public static String time(){
        String timeStamp = new SimpleDateFormat("HH.mm").format(new Date());
        memory.setTime(timeStamp);
        return timeStamp;
    }

    public static String Date(){
        String dateStamp = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        memory.setDate(dateStamp);
        return dateStamp;
    }

    public static void timedate(){
        String timeStamp = new SimpleDateFormat("HH:mm").format(new Date());
        memory.setTime(timeStamp);
        String dateStamp = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        memory.setDate(dateStamp);
    }






    public static void main(String[] args) throws MalformedURLException, AWTException {
        //Notifications.Loading();

        launch(args);

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                try {
                    Quit.Quit();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (AWTException e) {
                    e.printStackTrace();
                }
            }
        }, "Shutdown-thread"));









    }



}
