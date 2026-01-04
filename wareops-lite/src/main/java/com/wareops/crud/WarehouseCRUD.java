package com.wareops.crud;

import com.wareops.entity.Warehouse;
import com.wareops.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class WarehouseCRUD {

    // Register a new warehouse
    public static void registerWarehouse() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- Register Warehouse ---");

        // Input
        System.out.print("Enter Warehouse ID (integer): ");
        int warehouseId = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Warehouse Name: ");
        String name = sc.nextLine();

        System.out.print("Enter City: ");
        String city = sc.nextLine();

        System.out.print("Enter Status (ACTIVE/INACTIVE): ");
        String status = sc.nextLine().toUpperCase();

        // Validate status
        if (!status.equals("ACTIVE") && !status.equals("INACTIVE")) {
            System.out.println("Invalid status! Must be ACTIVE or INACTIVE.");
            return;
        }

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // Check if warehouseId already exists
            Warehouse existing = session.get(Warehouse.class, warehouseId);
            if (existing != null) {
                System.out.println("Warehouse ID already exists! Registration aborted.");
                return;
            }

            // Start transaction
            tx = session.beginTransaction();

            // Create Warehouse object
            Warehouse warehouse = new Warehouse();
            warehouse.setWarehouseId(warehouseId);
            warehouse.setName(name);
            warehouse.setCity(city);
            warehouse.setStatus(status);

            // Save
            session.save(warehouse);

            // Commit
            tx.commit();
            System.out.println("Warehouse registered successfully!");

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            System.out.println("Failed to register warehouse.");
        }
    }

    // List all warehouses
    public static void listWarehouses() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println("\n--- Warehouses ---");
            session.createQuery("FROM Warehouse", Warehouse.class)
                    .list()
                    .forEach(w -> System.out.println(
                            w.getWarehouseId() + " | " + w.getName() + " | " + w.getCity() + " | " + w.getStatus()
                    ));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete a warehouse
    public static void deleteWarehouse(int warehouseId) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Warehouse w = session.get(Warehouse.class, warehouseId);
            if (w == null) {
                System.out.println("Warehouse ID not found.");
                return;
            }

            tx = session.beginTransaction();
            session.delete(w);
            tx.commit();
            System.out.println("Warehouse deleted successfully.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
