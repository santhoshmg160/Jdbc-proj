import java.sql.*;

public class DbConnection {
    
    static private String url = "jdbc:mysql://localhost:3306/ola";
    static private String name ="root";
    static private String pw = "san123!@#SAN";

    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,name,pw);
    }
}
