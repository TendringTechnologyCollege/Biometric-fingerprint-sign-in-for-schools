package Main;

import Main.Windows.Databases.InSchoolQuit;

import java.awt.*;
import java.net.MalformedURLException;

public class Quit {
    @SuppressWarnings("MethodNameSameAsClassName")
    public static void Quit() throws MalformedURLException, AWTException {
        System.out.println("quitting");
        memory.setLocaion("InSchool");
        InSchoolQuit.quitdatabase();
        System.exit(0); // DON'T REMOVE, OR PROGRAM CAN BREAK

    }

    public static void quit() throws MalformedURLException, AWTException {
        System.out.println("quitting");
        memory.setLocaion("InSchool");
        InSchoolQuit.quitdatabase();
        System.exit(0); // DON'T REMOVE, OR PROGRAM CAN BREAK

    }
}
