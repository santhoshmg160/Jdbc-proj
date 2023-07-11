import java.sql.SQLException;
import java.util.*;

public class ContactController {

    String name;
    long contactNo;
    int check, select, id;
    char type;
    Scanner sc = new Scanner(System.in);
    ArrayList<ContactModel> contactModel = new ArrayList<>();

    public void addContacts() throws SQLException {
        System.out.println("Enter The Name:");
        name = sc.nextLine();
        getContactNo("CREATE");
        ContactDb.addContactInDb(name, contactNo);
    }

    public void getContactNo(String method) throws SQLException {
        if (method.equals("CREATE")) {
            System.out.println("Enter The ContactNo:");
            contactNo = sc.nextLong();
            sc.nextLine();
            check = ContactDb.checkContactNo(contactNo);
            if (check != -1) {
                System.out.println("The ContactNo already exists");
                getContactNo(method);
            }
        } else {
            System.out.println("Enter New ContactNo:");
            contactNo = sc.nextLong();
            sc.nextLine();
            check = ContactDb.checkContactNo(contactNo, contactModel.get(id));
            if (check != -1) {
                System.out.println("The ContactNo already exists");
                getContactNo(method);
            }
        }
    }

    public void getContacts() throws SQLException {
        System.out.println("1.Get All Contacts");
        System.out.println("2.Enter Contacts By Name");
        System.out.println("3.Enter Contacts By ContactNo");
        select = sc.nextInt();
        sc.nextLine();
        switch (select) {
            case 1:
                contactModel.clear();
                ContactDb.getAllContact(contactModel);
                break;
            case 2:
                contactModel.clear();
                System.out.println("Enter The Name:");
                name = sc.nextLine();
                ContactDb.getContactByName(name, contactModel);
                break;
            case 3:
                contactModel.clear();
                System.out.println("Enter The ContactNo:");
                contactNo = sc.nextLong();
                sc.nextLine();
                ContactDb.getContactByNo(contactNo, contactModel);
                break;
        }
        printContacts(contactModel);
    }

    public void printContacts(ArrayList<ContactModel> cm) {
        if (cm.size() > 0) {
            int count = 0;
            for (ContactModel i : cm) {
                System.out.println(count + " " + i);
                count++;
            }
        } else {
            System.out.println("There Are No Contacts");
        }
    }

    public void updateContacts() throws SQLException {
        getContacts();
        if (contactModel.size() > 0) {
            System.out.println("Select The Id To Update The Contacts:");
            id = sc.nextInt();
            sc.nextLine();
            if (contactModel.size() > id) {
                System.out.println("Do You Want To Change Name Press Y/N:");
                char type = sc.next().charAt(0);
                sc.nextLine();
                if (type == 'Y') {
                    System.out.println("Enter The New Name:");
                    name = sc.nextLine();
                    ContactDb.updateNameInDb(contactModel.get(id), name);
                }

                System.out.println("Do You Want To Chnage ContactNo Press Y/N:");
                type = sc.next().charAt(0);
                sc.nextLine();
                if (type == 'Y') {
                    getContactNo("POST");
                    ContactDb.updateNoInDb(contactModel.get(id), contactNo);
                }
            } else {
                System.out.println("You Entered Id Is Wrong");
            }
        }
    }

    public void deleteContacts() throws SQLException {
        getContacts();
        if (contactModel.size() > 0) {
            System.out.println("Select The Id To Delete The Contacts:");
            id = sc.nextInt();
            sc.nextLine();
            if (contactModel.size() > id) {
                ContactDb.deleteContactInDb(contactModel.get(id));
                contactModel.clear();
            } else {
                System.out.println("You Entered Id Is Wrong");
            }
        }
    }
}