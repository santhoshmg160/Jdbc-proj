import java.sql.*;
import  java.util.*;

public class ContactDb {

    static String query;
    static ContactModel contactModel;

    static int checkContactNo(long contactNo) throws SQLException {
        Connection con = DbConnection.getConnection();
        query = "SELECT contactNo FROM Contacts WHERE contactNo = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, contactNo);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return 1;
        }
        return -1;
    }

    static int checkContactNo(long contactNo, ContactModel contact) throws SQLException {
        Connection con = DbConnection.getConnection();
        query = "SELECT contactNo FROM Contacts WHERE contactNo = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, contactNo);
        ResultSet rs = ps.executeQuery();
        if (rs.next() && contactNo != contact.getContactNo()) {
            return 1;
        }
        return -1;
    }

    static int checkName(String name) throws SQLException {
        Connection con = DbConnection.getConnection();
        query = "SELECT Name FROM Contacts WHERE Name = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return 1;
        }
        return -1;
    }

    static void addContactInDb(String name, long contactNo) throws SQLException {
        Connection con = DbConnection.getConnection();
        query = "INSERT INTO Contacts VALUES (?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);
        ps.setLong(2, contactNo);
        ps.executeUpdate();
        System.out.println("Contact Inserted Successfully");
    }

    static void getContactByName(String name, ArrayList<ContactModel> cm) throws SQLException {
        Connection con = DbConnection.getConnection();
        query = "SELECT * FROM Contacts WHERE Name = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            contactModel = new ContactModel();
            contactModel.setName(rs.getString(1));
            contactModel.setContactNo(rs.getLong(2));
            cm.add(contactModel);
        }
    }

    static void getContactByNo(long contactNo, ArrayList<ContactModel> cm) throws SQLException {
        Connection con = DbConnection.getConnection();
        query = "SELECT * FROM Contacts WHERE contactNo = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, contactNo);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            contactModel = new ContactModel();
            contactModel.setName(rs.getString(1));
            contactModel.setContactNo(rs.getLong(2));
            cm.add(contactModel);
        }
    }

    static void getAllContact(ArrayList<ContactModel> cm) throws SQLException  {
        Connection con = DbConnection.getConnection();
        query = "SELECT * FROM Contacts";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            contactModel = new ContactModel();
            contactModel.setName(rs.getString(1));
            contactModel.setContactNo(rs.getLong(2));
            cm.add(contactModel);
        }
    }

    static void updateNameInDb(ContactModel contact, String name) throws SQLException {
        Connection con = DbConnection.getConnection();
        query = "UPDATE Contacts SET Name = ? WHERE contactNo = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);
        ps.setLong(2, contact.getContactNo());
        ps.executeUpdate();
        System.out.println("Name Updated Successfully");
    }

    static void updateNoInDb(ContactModel contact, long contactNo) throws SQLException {
        Connection con = DbConnection.getConnection();
        query = "UPDATE Contacts SET contactNo = ? WHERE contactNo = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, contactNo);
        ps.setLong(2, contact.getContactNo());
        ps.executeUpdate();
        System.out.println("Contact Number Updated Successfully");
    }

    static void deleteContactInDb(ContactModel contact) throws SQLException {
        Connection con = DbConnection.getConnection();
        query = "DELETE FROM Contacts WHERE contactNo = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, contact.getContactNo());
        ps.executeUpdate();
        System.out.println("Contact Deleted Successfully");
    }
}
