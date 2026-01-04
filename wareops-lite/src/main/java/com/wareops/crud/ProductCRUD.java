package com.wareops.crud;

import com.wareops.entity.Product;
import com.wareops.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Scanner;

public class ProductCRUD {

    public static void registerProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter SKU: ");
        String sku = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Category: ");
        String category = sc.nextLine();
        System.out.print("Enter Unit Price: ");
        double price = sc.nextDouble();
        System.out.print("Enter Reorder Level: ");
        int reorder = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Status (ACTIVE/INACTIVE): ");
        String status = sc.nextLine();

        Product product = new Product(id, sku, name, category, price, reorder, status);

        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Product existing = session.get(Product.class, id);
            if (existing != null) {
                System.out.println("Product ID already exists!");
                return;
            }

            // Optional: Check SKU uniqueness
            Long count = (Long) session.createQuery("SELECT COUNT(p) FROM Product p WHERE p.sku = :sku")
                                       .setParameter("sku", sku)
                                       .uniqueResult();
            if (count != null && count > 0) {
                System.out.println("SKU already exists! Registration aborted.");
                return;
            }

            tx = session.beginTransaction();
            session.save(product);
            tx.commit();
            System.out.println("Product registered successfully!");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
