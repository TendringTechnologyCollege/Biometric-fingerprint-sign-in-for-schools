package sample;


import java.sql.*;


public class Database {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/signin";


    // Database credentials
    static final String USER = "SignIn";
    static final String PASS = "Root";

    //SQL login details



    public static void Databse() {
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);


            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT ID, UserName, Password, Name FROM students WHERE UserName = '"+ memory.getUsername() +"' ";
            ResultSet rs = stmt.executeQuery(sql);



            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int ID  = rs.getInt("ID");
                String UserName = rs.getString("UserName");
                String Password = rs.getString("Password");
                String Name = rs.getString("Name");

                //Display values
                System.out.print("ID: " + ID);
                System.out.print(", UserName: " + UserName);
                System.out.print(", Password: " + Password);
                System.out.println(", Name: " + Name);
                memory.setUsername(UserName);
                memory.setPassword(Password);

                String userName = UserName;


            }

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
        System.out.println("Goodbye!");

    }}