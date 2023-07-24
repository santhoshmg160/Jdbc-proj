import java.sql.*;

public class DbConnection {

    //Provide your database url and username and password;
    private static String url = "";
    private static  String name ="";

    private static String password = "";

    static Connection getConnection() throws  SQLException {
        return DriverManager.getConnection(url, name, password);
    }
}
