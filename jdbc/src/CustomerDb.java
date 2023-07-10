import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDb extends ClientDb {

    void insertData(int id, String name, String city, long contactNo) throws SQLException {
        Connection con = DbConnection.getConnection();
        super.setQuery("INSERT INTO Customers VALUES (?,?,?,?,?,?,?)");
        PreparedStatement ps = con.prepareStatement(super.getQuery());
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setString(3, city);
        ps.setLong(4, contactNo);
        ps.setString(5, "NIL");
        ps.setString(6, "NIL");
        ps.setString(7, "unbooked");
        ps.executeUpdate();
        System.out.println("Data Inserted Successfully");
    }
}
