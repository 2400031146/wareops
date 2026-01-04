package com.wareops.test;
import com.wareops.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestHibernate {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            System.out.println("Hibernate connected successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        sessionFactory.close();
    }
}
