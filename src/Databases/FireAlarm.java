package Databases;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.sql.*;


public class FireAlarm {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/signin";


    // SignInUsers credentials
    static final String USER = "SignIn";
    static final String PASS = "Root";

    //SQL login details



    public static void Fire() {
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            //System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            //System.out.println("Connected database successfully...");


            //STEP 4: Execute a query
            //System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT `Name`, `Location`, `TimeOut`, `Date` FROM `students` WHERE `Location` != 'InSchool'";
            ResultSet rs = stmt.executeQuery(sql);



            //STEP 5: Extract data from result set
            Workbook wb = new HSSFWorkbook();
            //Workbook wb = new XSSFWorkbook();
            CreationHelper createHelper = wb.getCreationHelper();
            Sheet sheet = wb.createSheet("Students who are Out");

            // Create a row and put some cells in it. Rows are 0 based.

            Row row = sheet.createRow((short) 0);
            row.createCell(0).setCellValue(createHelper.createRichTextString("Name"));
            row.createCell(1).setCellValue(createHelper.createRichTextString("Location"));
            row.createCell(2).setCellValue(createHelper.createRichTextString("Time Out"));
            row.createCell(3).setCellValue(createHelper.createRichTextString("Date"));


            int count = 1;
            while(rs.next()) {

                String Name = rs.getString("Name");
                String Location = rs.getString("LocationController");
                String TimeOut = rs.getString("TimeOut");
                String Date = rs.getString("Date");

                row = sheet.createRow((short) count);
                row.createCell(0).setCellValue(createHelper.createRichTextString(Name));
                row.createCell(1).setCellValue(createHelper.createRichTextString(Location));
                row.createCell(2).setCellValue(createHelper.createRichTextString(TimeOut));
                row.createCell(3).setCellValue(createHelper.createRichTextString(Date));
                count++;

            }



            // Write the output to a file
            FileOutputStream fileOut = new FileOutputStream("Fire Alarm Registration.xls");
            wb.write(fileOut);
            fileOut.close();

            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        //System.out.println("Goodbye!");

    }}