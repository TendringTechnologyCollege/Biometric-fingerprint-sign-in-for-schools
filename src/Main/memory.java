package Main;

public class memory {
    private static String username;
    private static String password;
    private static String TFusername;
    private static String TFpassword;
    private static String locaion;
    private static String Time;
    public static String Date;
    private static String DBLocation;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        memory.username = username;
    }

    public static  String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        memory.password = password;
    }

    public static String getTFusername() {
        return TFusername;
    }

    public static void setTFusername(String TFusername) {
        memory.TFusername = TFusername;
    }

    public static String getTFpassword() {
        return TFpassword;
    }

    public static void setTFpassword(String TFpassword) {
        memory.TFpassword = TFpassword;
    }

    public static String getLocaion() {
        return locaion;
    }

    public static void setLocaion(String locaion) {
        memory.locaion = locaion;
    }

    public static String getTime() {
        return Time;
    }

    public static void setTime(String time) {
        Time = time;
    }

    public static String getDate() {
        return Date;
    }

    public static void setDate(String date) {
        Date = date;
    }

    public static String getDBLocation() {
        return DBLocation;
    }

    public static void setDBLocation(String DBLocation) {
        memory.DBLocation = DBLocation;
    }
}
