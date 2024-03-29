package Main.Windows.Databases;


import Main.Misc.Notifications;
import Main.memory;

import java.awt.*;
import java.net.MalformedURLException;
import java.sql.*;


public class CheckLocation {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    private static final String DB_URL = "jdbc:mariadb://192.168.137.98:3306/signin";


    // SignInUsers credentials
    private static final String USER = "SignIn";
    private static final String PASS = "Root";

    //SQL login details



    @SuppressWarnings("Duplicates")
    public static void login() throws MalformedURLException, AWTException {
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.mariadb.jdbc.Driver");

            //STEP 3: Open a connection
            //System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            //System.out.println("Connected database successfully...");


            //STEP 4: Execute a query
            //System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT UserName, Location FROM students WHERE UserName = '"+ memory.getUsername() +"' ";
            ResultSet rs = stmt.executeQuery(sql);



            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                String UserName = rs.getString("UserName");
                String location = rs.getString("Location");

                //Display values
               //System.out.print(", UserName: " + UserName);
               //System.out.println(", LocationController: " + location);

                memory.setDBLocation(location);


            }

            //STEP 6: Clean-up environment
            rs.close();
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