import java.sql.*;

import java.util.Scanner;

class Main {

    static Scanner sc = new Scanner(System.in);

    static void getchoice() throws SQLException {
        System.out.println("1.CREATE");
        System.out.println("2.READ");
        System.out.println("3.UPDATE");
        System.out.println("4.DELETE");
        int select = sc.nextInt();
        sc.nextLine();
        switch(select) {
            case 1: 
                select = getClients();
                if (select == 1) {
                    Client.addClient("Drivers");
                } else {
                    Client.addClient("Customers");
                }
                getchoice();
                break;

            case 2:
                select = getClients();
                if (select == 1) {
                    Client.readClient("Drivers");
                } else {
                    Client.readClient("Customers");
                }
                getchoice();
                break;

            case 3:
                select = getClients();
                if (select == 1) {
                    Client.updateClient("Drivers");
                } else {
                    Client.updateClient("Customers");
                }
                getchoice();
                break;

            case 4:
                select = getClients();
                if (select == 1) {
                    Client.deleteClient("Drivers");
                } else {
                    Client.deleteClient("Customers");
                }
                getchoice();
                break;
                
            default:
                break;

        }
    }

    static int getClients() {
        System.out.println("1.Drivers");
        System.out.println("2.Customers");
        int select = sc.nextInt();
        sc.nextLine(); 
        return select;
    }

    public static void main(String[] args) throws SQLException {
        getchoice();
    }
}