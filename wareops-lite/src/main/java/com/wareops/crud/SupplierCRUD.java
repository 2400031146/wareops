package com.wareops.crud;

import com.wareops.entity.Supplier;
import com.wareops.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Scanner;

public class SupplierCRUD {

    public static void registerSupplier() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Supplier ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter GST Number: ");
        String gst = sc.nextLine();
        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter City: ");
        String city = sc.nextLine();
        System.out.print("Enter Status (ACTIVE/INACTIVE): ");
        String status = sc.nextLine();

        // Simple GST validation: length = 15
        if (gst.length() != 15) {
            System.out.println("Invalid GST Number! Registration aborted.");
            return;
        }

        Supplier supplier = new Supplier(id, name, gst, phone, city, status);

        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(supplier);
            tx.commit();
            System.out.println("Supplier registered successfully!");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
