import java.sql.*;

public class DbConnection {

    private static String url = "jdbc:mysql://localhost:3306/Db";
    private static  String name ="root";
    // Enter Your password
    private static String password = "san123!@#SAN";

    static Connection getConnection() throws  SQLException {
        return DriverManager.getConnection(url, name, password);
    }
}
