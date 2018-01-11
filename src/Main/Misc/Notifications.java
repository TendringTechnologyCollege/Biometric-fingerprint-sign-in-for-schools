package Main.Misc;

import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.net.MalformedURLException;

public class Notifications {

    public static void Error(String e) throws MalformedURLException, AWTException {

        if (SystemTray.isSupported()) {
            Notifications td = new Notifications();
            td.error(e);
        } else {
            System.err.println("System tray not supported!");
        }
    }

    public void error(String e) throws AWTException, java.net.MalformedURLException {
        //Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        //Alternative (if the icon is on the classpath):
        //Image image = Toolkit.getToolkit().createImage(getClass().getResource("icon.png"));
        TrayIcon trayIcon = new TrayIcon(image, "Sign In/Out");
        //Let the system resizes the image if needed
        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("Error");
        tray.add(trayIcon);

        trayIcon.displayMessage("Error: ", e, MessageType.ERROR);
    }

    public static void Loading() throws MalformedURLException, AWTException {

        if (SystemTray.isSupported()) {
            Notifications td = new Notifications();
            td.loading();
        } else {
            System.err.println("System tray not supported!");
        }
    }

    public void loading() throws AWTException, java.net.MalformedURLException {
        //Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().createImage("Icon.png");
        //Alternative (if the icon is on the classpath):
        //Image image = Toolkit.getToolkit().createImage(getClass().getResource("icon.png"));
        TrayIcon trayIcon = new TrayIcon(image, "Sign In/Out");
        //Let the system resizes the image if needed
        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("Starting up");
        tray.add(trayIcon);
        trayIcon.displayMessage("", "Starting up...", MessageType.NONE);
    }




}