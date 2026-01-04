package com.wareops.test;

import com.wareops.crud.WarehouseCRUD; // Make sure this path matches your package
import java.util.Scanner;               // Required for console input

public class MainMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- WareOps Lite Menu ---");
            System.out.println("1. Register Warehouse");
            System.out.println("2. List Warehouses");
            System.out.println("3. Delete Warehouse");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    WarehouseCRUD.registerWarehouse();
                    break;
                case 2:
                    WarehouseCRUD.listWarehouses();
                    break;
                case 3:
                    System.out.print("Enter Warehouse ID to delete: ");
                    int id = sc.nextInt();
                    WarehouseCRUD.deleteWarehouse(id);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        sc.close();
    }
}
