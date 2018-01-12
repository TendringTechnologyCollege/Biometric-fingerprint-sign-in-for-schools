package Main.Windows.Databases;

import Main.Misc.Notifications;
import Main.memory;

import java.awt.*;
import java.net.MalformedURLException;
import java.sql.*;

public class InSchoolQuit {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/signin";


    // SignInUsers credentials
    private static final String USER = "SignIn";
    private static final String PASS = "Root";

    //SQL login details



    @SuppressWarnings("Duplicates")
    public static void quitdatabase() throws MalformedURLException, AWTException {
        Connection conn = null;
        Statement stmt = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            //System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();
            String sql = "UPDATE students SET Location = '" + memory.getLocaion() + "'";
            stmt.executeUpdate(sql);
            sql = "UPDATE students SET TimeOut = '" + memory.getTime() + "'";
            stmt.executeUpdate(sql);
            sql = "UPDATE students SET Date = '" + memory.getDate() + "'";
            stmt.executeUpdate(sql);

            sql = "SELECT ID, UserName, Password, Name, Location, TimeOut, Date FROM students WHERE UserName = '" + memory.getTFusername() + "' ";
            ResultSet rs = stmt.executeQuery(sql);


            //STEP 5: Extract data from result set
            int count = 1;
            while (rs.next()) {

                //Retrieve by column name
                int ID = rs.getInt("ID");
                String UserName = rs.getString("UserName");
                String Password = rs.getString("Password");
                String Name = rs.getString("Name");
                String location = rs.getString("Location");
                String TimeOut = rs.getString("TimeOut");
                String Date = rs.getString("Date");


                //Display values
                System.out.print("ID: " + ID);
                System.out.print(", UserName: " + UserName);
                System.out.print(", Password: " + Password);
                System.out.print(", Name: " + Name);
                System.out.print(", Location: " + location);
                System.out.print(", Time Out: " + TimeOut);
                System.out.print(", Date: " + Date);


            }
            rs.close();







            //STEP 6: Clean-up environment
            stmt.close();
            conn.close();

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            Notifications.Error(String.valueOf(se));
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            Notifications.Error(String.valueOf(e));
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
                Notifications.Error(String.valueOf(se2));
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
                Notifications.Error(String.valueOf(se));
            }//end finally try
        }//end try
        //System.out.println("Goodbye!");

    }}