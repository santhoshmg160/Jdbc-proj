import java.util.*;
import java.sql.*;

class Main {

    static ContactController contacts = new ContactController();
    static Scanner  sc = new Scanner(System.in);

    static void getchoice() throws SQLException {
        System.out.println("1.CREATE");
        System.out.println("2.READ");
        System.out.println("3.UPDATE");
        System.out.println("4.DELETE");
        int select = sc.nextInt();
        sc.nextLine();
        switch(select) {
            case 1: 
                contacts.addContacts();
                getchoice();
                break;

            case 2:
                contacts.getContacts();
                getchoice();
                break;

            case 3:
                contacts.updateContacts();
                getchoice();
                break;

            case 4:
                contacts.deleteContacts();
                getchoice();
                break;
                
            default:
                break;

        }
    }

    public static void main(String[] args) throws SQLException {
        getchoice();
    }
}