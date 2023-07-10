import java.sql.*;

public class ClientDb {

    private String query;

    int checkId(String Client, int id) throws  SQLException {
        Connection con = DbConnection.getConnection();
        if (Client.equals("Drivers")) {
            query = "SELECT id FROM Drivers WHERE id = ?";
        } else {
            query = "SELECT id FROM Customers WHERE id = ?";
        }
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            return rs.getInt("id");
        } else {
            return -1;
        }
    }

    int checkId(String Client, int id, int newId) throws  SQLException {
        Connection con = DbConnection.getConnection();
        if (Client.equals("Drivers")) {
            query = "SELECT id FROM Drivers WHERE id = ?";
        } else {
            query = "SELECT id FROM Customers WHERE id = ?";
        }
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next() && id != newId) {
            return rs.getInt("id");
        }
        return -1;
    }

    int checkContactNo(String Client, long contactNo) throws SQLException {
        Connection con = DbConnection.getConnection();
        if (Client.equals("Drivers")) {
            query = "SELECT contactNo FROM Drivers WHERE contactNo = ?";
        } else {
            query = "SELECT contactNo FROM Customers WHERE contactNo = ?";
        }
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, contactNo);
        ResultSet rs = ps.executeQuery();
        if(rs.next() && contactNo != rs.getLong("contactNo")) {
            return 1;
        }
        return -1;
    }

    int checkContactNo(String Client, long contactNo, int id) throws SQLException {
        Connection con = DbConnection.getConnection();
        if (Client.equals("Drivers")) {
            query = "SELECT contactNo FROM Drivers WHERE id = ?";
        } else {
            query = "SELECT contactNo FROM Customers WHERE id = ?";
        }
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next() && contactNo != rs.getLong("contactNo")) {
            return 1;
        }
        return -1;
    }


    void updateId(String Client, int id, int newId) throws SQLException {
        Connection con = DbConnection.getConnection();
        if (Client.equals("Drivers")) {
            query = "UPDATE Drivers SET id = ? WHERE id = ?";
        } else {
            query = "UPDATE Customers SET id = ? WHERE id = ?";
        }
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, newId);
        ps.setInt(2, id);
        ps.executeUpdate();
        System.out.println("id updated successfully");
    }

    void updateName(String Client, int id, String name) throws SQLException {
        Connection con = DbConnection.getConnection();
        if (Client.equals("Drivers")) {
            query = "UPDATE Drivers SET name = ? WHERE id = ?";
        } else {
            query = "UPDATE Customers SET name = ? WHERE id = ?";
        }
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);
        ps.setInt(2, id);
        ps.executeUpdate();
        System.out.println("name updated successfully");
    }

    void updateCity(String Client, int id, String city) throws SQLException {
        Connection con = DbConnection.getConnection();
        if (Client.equals("Drivers")) {
            query = "UPDATE Drivers SET city = ? WHERE id = ?";
        } else {
            query = "UPDATE Customers SET city = ? WHERE id = ?";
        }
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, city);
        ps.setInt(2, id);
        ps.executeUpdate();
        System.out.println("city updated successfully");
    }

    void updateContactNo(String Client, int id, long contactNo) throws SQLException {
        Connection con = DbConnection.getConnection();
        if (Client.equals("Drivers")) {
            query = "UPDATE Drivers SET contactNo = ? WHERE id = ?";
        } else {
            query = "UPDATE Customers SET contactNo = ? WHERE id = ?";
        }
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, contactNo);
        ps.setInt(2, id);
        ps.executeUpdate();
        System.out.println("contactNo updated successfully");
    }

    void getData(String Client, int id) throws SQLException {
        Connection con = DbConnection.getConnection();
        if (Client.equals("Drivers")) {
            query = "SELECT * FROM Drivers WHERE id = ?";
        } else {
            query = "SELECT * FROM Customers WHERE id = ?";
        }
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            if (Client.equals("Drivers")) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getLong(5) + " " + rs.getString(6) + " " + rs.getString(7));
            } else {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "  + " " + rs.getLong(4) + rs.getString(5) + " " + rs.getString(6) + rs.getString(7));
            }
        }
    }

    void deleteData(String Client, int id) throws SQLException {
        Connection con = DbConnection.getConnection();
        if (Client.equals("Drivers")) {
            query = "DELETE FROM Drivers WHERE id = ?";
        } else {
            query = "DELETE FROM Customers WHERE id = ?";
        }
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,id);
        ps.executeUpdate();
        System.out.println("Data Deleted Successfully");
    }

    void setQuery(String query) {
        this.query = query;
    }

    String getQuery() {
        return query;
    }
}
