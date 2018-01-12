package Main.Windows.Databases;

import Main.Misc.Notifications;
import Main.main;
import Main.memory;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;


@SuppressWarnings("ConstantConditions")
public class UpdateDatabase {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/signin";


    // SignInUsers credentials
    private static final String USER = "SignIn";
    private static final String PASS = "Root";

    //SQL login details



    @SuppressWarnings("Duplicates")
    public static void update() throws MalformedURLException, AWTException {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            //System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //System.out.println("Connected database successfully...");
            String dateStamp = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
            
            String logfilepath = "Logs.xls";


            
            


            

            //STEP 4: Execute a query
            //System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "UPDATE students SET Location = '" + memory.getLocaion() + "' WHERE UserName = '" + memory.getUsername() + "'";
            stmt.executeUpdate(sql);
            sql = "UPDATE students SET TimeOut = '" + memory.getTime() + "' WHERE UserName = '" + memory.getUsername() + "'";
            stmt.executeUpdate(sql);
            sql = "UPDATE students SET Date = '" + memory.getDate() + "' WHERE UserName = '" + memory.getUsername() + "'";
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

                Object[][] bookData = {
                        {Name, location, TimeOut},
                };



                try {
                    FileInputStream inputStream = new FileInputStream(new File(logfilepath));
                    Workbook workbook = WorkbookFactory.create(inputStream);

                    Sheet sheet = workbook.getSheet(dateStamp);

                    try {
                        int rowCount = sheet.getLastRowNum();
                        for (Object[] aBook : bookData) {
                            Row row = sheet.createRow(++rowCount);

                            int columnCount = 0;

                            Cell cell = row.createCell(columnCount);
                            cell.setCellValue(rowCount);

                            for (Object field : aBook) {
                                cell = row.createCell(++columnCount);
                                if (field instanceof String) {
                                    cell.setCellValue((String) field);
                                } else if (field instanceof Integer) {
                                    cell.setCellValue((Integer) field);
                                }
                            }

                        }

                    }catch (NullPointerException ex){
                        CreationHelper createHelper = workbook.getCreationHelper();
                        sheet = workbook.createSheet(main.Date());
                        Row row = sheet.createRow((short) 0);
                        row.createCell(0).setCellValue(createHelper.createRichTextString("ID"));
                        row.createCell(1).setCellValue(createHelper.createRichTextString("Name"));
                        row.createCell(2).setCellValue(createHelper.createRichTextString("Location"));
                        row.createCell(3).setCellValue(createHelper.createRichTextString("Time out"));
                        int rowCount = sheet.getLastRowNum();
                        for (Object[] aBook : bookData) {
                            row = sheet.createRow(++rowCount);

                            int columnCount = 0;

                            Cell cell = row.createCell(columnCount);
                            cell.setCellValue(rowCount);

                            for (Object field : aBook) {
                                cell = row.createCell(++columnCount);
                                if (field instanceof String) {
                                    cell.setCellValue((String) field);
                                } else if (field instanceof Integer) {
                                    cell.setCellValue((Integer) field);
                                }
                            }

                        }

                    }




                    inputStream.close();

                    FileOutputStream outputStream = new FileOutputStream(logfilepath);
                    workbook.write(outputStream);
                    workbook.close();
                    outputStream.close();

                } catch (IOException | EncryptedDocumentException
                        | InvalidFormatException ex) {
                    ex.printStackTrace();
                    Notifications.Error(String.valueOf(ex));
                }

                

                //Display values
                //System.out.print("ID: " + ID);
                //System.out.print(", UserName: " + UserName);
                //System.out.print(", Password: " + Password);
                //System.out.print(", Name: " + Name);
                //System.out.print(", LocationController: " + location);
                //System.out.print(", Time Out: " + TimeOut);
                //System.out.print(", Date: " + Date);


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