import  java.sql.*;

public class DriverDb extends ClientDb {

    int checkVehicleNo(String vehicleNo) throws SQLException {
        Connection con = DbConnection.getConnection();
        super.setQuery("SELECT vehicleNo FROM Drivers WHERE vehicleNo = ?");
        PreparedStatement ps = con.prepareStatement(super.getQuery());
        ps.setString(1, vehicleNo);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return 1;
        }
        return -1;
    }

    int checkVehicleNo(String vehicleNo, int id) throws SQLException {
        Connection con = DbConnection.getConnection();
        super.setQuery("SELECT vehicleNo FROM Drivers WHERE id = ?");
        PreparedStatement ps = con.prepareStatement(super.getQuery());
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next() && !vehicleNo.equals(rs.getString("vehicleNo"))) {
            return 1;
        }
        return -1;
    }

    void updateVehicleNo(int id, String vehicleNo) throws SQLException {
        Connection con = DbConnection.getConnection();
        super.setQuery("UPDATE Drivers SET vehicleNo = ? WHERE id = ?");
        PreparedStatement ps = con.prepareStatement(super.getQuery());
        ps.setString(1, vehicleNo);
        ps.setInt(2, id);
        ps.executeUpdate();
        System.out.println("vehicleNo updated successfully");
    }

    void updateCurrentLoc(int id, String currentLoc) throws SQLException {
        Connection con = DbConnection.getConnection();
        super.setQuery("UPDATE Drivers SET currentLoc = ? WHERE id = ?");
        PreparedStatement ps = con.prepareStatement(super.getQuery());
        ps.setString(1, currentLoc);
        ps.setInt(2, id);
        ps.executeUpdate();
        System.out.println("currentLoc updated successfully");
    }
    
    void insertData(int id, String name, String vehicleNo, String city, long contactNo, String currentLoc) throws SQLException {
        Connection con = DbConnection.getConnection();
        super.setQuery("INSERT INTO Drivers VALUES (?,?,?,?,?,?,?)");
        PreparedStatement ps = con.prepareStatement(super.getQuery());
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setString(3, vehicleNo);
        ps.setString(4, city);
        ps.setLong(5, contactNo);
        ps.setString(6,currentLoc);
        ps.setString(7, "unbooked");
        ps.executeUpdate();
        System.out.println("Data Inserted Successfully");
    }
}
