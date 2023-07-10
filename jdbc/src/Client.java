import java.sql.SQLException;
import java.util.Scanner;

public class Client {
    
    static Scanner sc = new Scanner(System.in);
    static int id,check,newId;
    static char type;
    static String vehicleNo, name, city, currentLoc;
    static long contactNo;
    static ClientDb clientDb = new ClientDb();
    static DriverDb driverDb = new DriverDb();
    static CustomerDb customerDb = new CustomerDb();

    static void addClient(String Client) throws SQLException {
        getId(Client, "create");
        System.out.println("Enter your name:");
        name = sc.nextLine();
        if (Client.equals("Drivers")) {
            getVehicleNo("create");
        }
        System.out.println("Enter your city:"); 
        city = sc.nextLine();
        getContactNo(Client, "create");
        if (Client.equals("Drivers")) {
            System.out.println("Enter your currentLoc");
            currentLoc = sc.nextLine();
        }
        if (Client.equals("Drivers")) {
            driverDb.insertData(id,name,vehicleNo,city,contactNo,currentLoc);
        } else {
            customerDb.insertData(id, name, city, contactNo);
        }
    }

    static void getId(String Client, String method) throws SQLException {
        if (method.equals("create")) {
            System.out.println("Enter your id:");
            id = sc.nextInt();
            sc.nextLine();
            check = clientDb.checkId(Client, id);
            if (check != -1) {
                System.out.println("The " + Client + " id " + id + "already exists");
                getId(Client,method);
            }
        } else {
            System.out.println("Enter your new id:");
            newId = sc.nextInt();
            sc.nextLine();
            check = clientDb.checkId(Client, id, newId);
            if (check != -1) {
                System.out.println("The " + Client + " id " + newId + "already exists");
                getId(Client,method);
            }
        }
    }

    static void getVehicleNo(String method) throws SQLException{
        if (method.equals("create")) {
            System.out.println("Enter your vehicleNo");
            vehicleNo = sc.nextLine();
            check = driverDb.checkVehicleNo(vehicleNo);
            if (check != -1) {
                System.out.println("The Driver VehicleNo already exists");
                getVehicleNo(method);
            }
        } else {
            System.out.println("Enter your new vehicleNo");
            vehicleNo = sc.nextLine();
            check = driverDb.checkVehicleNo(vehicleNo,id);
            if (check != -1) {
                System.out.println("The Driver VehicleNo already exists");
                getVehicleNo(method);
            }
        }
    }

    static void getContactNo(String Client, String method) throws SQLException {
        if (method.equals("create")) {
            System.out.println("Enter your contactNo:");
            contactNo = sc.nextLong();
            sc.nextLine();
            check =  clientDb.checkContactNo(Client, contactNo);
            if (check != -1) {
                System.out.println("The "+ Client +" contactNo " + "already exists");
                getContactNo(Client, method);
            }
        } else {
            System.out.println("Enter your new contactNo:");
            contactNo = sc.nextLong();
            sc.nextLine();
            check =  clientDb.checkContactNo(Client, contactNo,id);
            if (check != -1) {
                System.out.println("The "+ Client +" contactNo " + "already exists");
                getContactNo(Client, method);
            }
        }
    }

    static void readClient(String Client) throws SQLException {
        System.out.println("Enter your id to get your details:");
        id = sc.nextInt();
        sc.nextLine();
        check = clientDb.checkId(Client,id);
        if ( check == -1) {
            System.out.println("The " + Client + " id " + id + " not exists");
            readClient(Client);
        } else {
            clientDb.getData(Client,id);
        }
    }

    static void updateClient(String Client) throws SQLException {
        System.out.println("Enter your id:"); 
        id = sc.nextInt();
        sc.nextLine();
        check = clientDb.checkId("Drivers",id);
        if (check == -1) {
            System.out.println("The " + Client + " id "+ id + " not exists");
            updateClient(Client);
        } else {
            System.out.println("Do you want to change your id press y/n");
            type = sc.next().charAt(0);
            sc.nextLine();
            if (type == 'y') {
                getId(Client, "post");
                clientDb.updateId(Client,id,newId);
            }
            id = newId;
            System.out.println("Do you want to change your name press y/n");
            type = sc.next().charAt(0);
            sc.nextLine();
            if (type == 'y') {
                System.out.println("Enter your new name");
                name = sc.nextLine();
                clientDb.updateName(Client, id, name);
            }
            if (Client.equals("Drivers")) {
                System.out.println("Do you want to change your vehicleNo press y/n");
                type = sc.next().charAt(0);
                sc.nextLine();
                if (type == 'y') {
                    getVehicleNo("post");
                    driverDb.updateVehicleNo(id, vehicleNo);
                }
            }
            System.out.println("Do you want to change your city press y/n");
            type = sc.next().charAt(0);
            sc.nextLine();
            if (type == 'y') {
                System.out.println("Enter your new city");
                city = sc.nextLine();
                clientDb.updateCity(Client, id, city);
            }
            System.out.println("Do you want to change your contactNo press y/n");
            type = sc.next().charAt(0);
            sc.nextLine();
            if (type == 'y') {
                getContactNo(Client, "post");
                clientDb.updateContactNo(Client, id, contactNo);
            }
            if (Client.equals("Drivers")) {
                System.out.println("Do you want to change your currentLoc press y/n");
                type = sc.next().charAt(0);
                sc.nextLine();
                if (type == 'y') {
                    System.out.println("Enter your new currentLoc");
                    currentLoc = sc.nextLine();
                    driverDb.updateCurrentLoc(id, currentLoc);
                }
            }
        }
    }

    static void deleteClient(String Client) throws SQLException {
        System.out.println("Enter your id:");
        id = sc.nextInt();
        sc.nextLine();
        check = clientDb.checkId(Client,id);
        if (check == -1) {
            System.out.println("The" + Client + "id "+ id + " not exists");
            deleteClient(Client);
        } else {
            clientDb.deleteData(Client,id);
        }
    }
}
