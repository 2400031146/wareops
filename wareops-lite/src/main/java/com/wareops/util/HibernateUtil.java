package com.wareops.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create Configuration
            Configuration configuration = new Configuration();
            
            // Load hibernate.cfg.xml from classpath
            configuration.configure("hibernate.cfg.xml");

            // Build SessionFactory
            return configuration.buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Provide global access to SessionFactory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Optional: close the SessionFactory when app shuts down
    public static void shutdown() {
        getSessionFactory().close();
    }
}
